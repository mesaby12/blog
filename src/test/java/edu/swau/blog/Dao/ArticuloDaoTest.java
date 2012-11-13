/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.swau.blog.Dao;

import edu.swau.blog.model.Articulo;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
//import org.slf4j.Logger;

/**
 *
 * @author gijoe
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:blog.xml"})
@Transactional

public class ArticuloDaoTest {
    private static final Logger log = LoggerFactory.getLogger(ArticuloDaoTest.class);
    @Autowired
    private ArticuloDao instance;
    
    public ArticuloDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of crea method, of class ArticuloDao.
     */
    @Test
    public void testCrea() {
     log.debug("Crear Articulo");
     Articulo articulo = new Articulo(
             "TITULO 1", 
             "Esta es la descripcion", 
             "Este es el contenido",
             "Miguel Espinosa");
     
     articulo = instance.crea(articulo);
     assertNotNull(articulo);
     assertNotNull(articulo.getId());
     
       
    }

    /**
     * Test of actualiza method, of class ArticuloDao.
     */
    @Test
    public void testActualiza() {
        log.debug("Actualiza articulo");
        Articulo articulo = new Articulo(
              "TITULO 1", 
             "Esta es la descripcion", 
             "Este es el contenido",
             "Miguel Espinosa");
     
     articulo = instance.crea(articulo);
     assertNotNull(articulo);
     assertNotNull(articulo.getId());
     
     Long id = articulo.getId();
     Articulo prueba = instance.obtiene(id);
     prueba.setAutor("Abigail Tenorio");
     instance.actualiza(prueba);
     
     Articulo demo = instance.obtiene(id);
     assertNotNull(demo);
     assertEquals("Abigail Tenorio", demo.getAutor());
     
    
     
    }

    /**
     * Test of elimina method, of class ArticuloDao.
     */
    @Test
    public void testElimina() {
        log.debug("Elimina articulo");
        Articulo articulo = new Articulo(
             "TITULO 1", 
             "Esta es la descripcion", 
             "Este es el contenido",
             "Miguel Espinosa");
     
     articulo = instance.crea(articulo);
     assertNotNull(articulo);
     assertNotNull(articulo.getId());
     
     Long id = articulo.getId();
     String titulo = instance.elimina(id);
     assertNotNull(titulo);
     assertEquals("TITULO 1", titulo);
     Articulo prueba = instance.obtiene(id);
     assertNull(prueba);
    
    }
    /**
     * Test of lista method, of class ArticuloDao.
     */
    @Test
    public void testLista() {
        System.out.println("Lista");
        Articulo articulo = new Articulo(
             "TITULO 1", 
             "Esta es la descripcion", 
             "Este es el contenido",
             "Miguel Espinosa");     
        instance.crea(articulo);
     
                articulo = new Articulo(
            "TITULO 2", 
            "Esta es la descripcion", 
            "Este es el contenido",
            "Abigail Tenorio");     
        instance.crea(articulo);
     
     List<Articulo> articulos = instance.lista();
     assertNotNull(articulos);
     assertTrue(articulos.size() >= 2);
   }
}
