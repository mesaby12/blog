/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.swau.blog.web;

import edu.swau.blog.Dao.ArticuloDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author gijoe
 */
@Controller
@RequestMapping("/")
public class InicioController {
    private static final Logger log = LoggerFactory.getLogger(InicioController.class);
    @Autowired
    private ArticuloDao articuloDao;
    
    @RequestMapping({"","/inicio"})
    public String inicio(Model model) {
        log.info("Mostrando pagina Inicio");
        model.addAttribute("mesaje", "Hi from InicioController");
        model.addAttribute("articulos", articuloDao.lista());
        return "inicio/index";
        
    
    
    }
    
}
