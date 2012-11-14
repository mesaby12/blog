/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.swau.blog.web;

import edu.swau.blog.Dao.ArticuloDao;
import edu.swau.blog.model.Articulo;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 * @author gijoe
 */

@Controller
@RequestMapping("/articulo")
public class ArticuloController {
    private static final Logger log = LoggerFactory.getLogger(ArticuloController.class);
    @Autowired
    private ArticuloDao articuloDao;
    
    @RequestMapping
    public String lista(Model modelo) {
        modelo.addAttribute("articulos", articuloDao.lista());
        return "articulo/lista";
    }
    
    @RequestMapping("/nuevo")
    public String nuevo(Model modelo) {
        modelo.addAttribute("articulo", new Articulo());
        return "articulo/nuevo";
    }
    
    @RequestMapping("/crea")
    public String crea(@Valid Articulo articulo, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            for(ObjectError error : bindingResult.getAllErrors()) {
                log.debug("Error: {}", error);
            }
            return "articulo/nuevo";
        }
        
        articulo = articuloDao.crea(articulo);
        
        redirectAttributes.addFlashAttribute("mensaje","El articulo "+articulo.getTitulo()+" ha sido creado");
        
        return "redirect:/articulo/ver/"+articulo.getId();
    }
    
    @RequestMapping("/ver/{id}")
    public String ver(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("articulo", articuloDao.obtiene(id));
        return "articulo/ver";
    }

    @RequestMapping("/elimina/{id}")
    public String elimina(@PathVariable Long id, Model modelo, RedirectAttributes redirectAttributes) {
        String titulo = articuloDao.elimina(id);
        redirectAttributes.addFlashAttribute("mensaje", "Se elimino el articulo "+titulo);
        return "redirect:/articulo";
    }
}