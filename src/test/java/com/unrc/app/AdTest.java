package com.unrc.app;


import com.unrc.app.models.Ad;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class AdTest {
    
    @Before
    public void beforeTest() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
        Base.openTransaction();
    }

    @After
    public void afterTest() {
        Base.rollbackTransaction();
        Base.close();
    }
    @Test
    public void testInsertarAd() {
        System.out.println("insertar");
	String descriptive_text="Vendo inmueble urgente";
	String id_buildings="1";
	String id_ownersBuildings="1";
        String id_realstate="2";
	Anuncio.insertar(descriptive_text,id_buildings,id_ownersBuildings,id_realstate);

        //busca TODOS los OWNER que coincidan
        LazyList<Ad> encontrados =Ad.where(
               	"descriptive_text= '" + descriptive_text + "' and "
                + "id_Building= '" + id_buildings + "' and "
		+ "id_ownersBuilding= '" +id_ownersBuildings+"' ");

        assertTrue(encontrados.size() == 1);
    }
    
      @Test
    public void testEliminar() throws Exception {
        System.out.println("eliminar ");
	String descriptive_text="Vendo inmueble urgente";
	String id_buildings="1";
	String id_ownersBuildings="1";
        String id_realstate="2";
	Ad ad=new Ad();
	Anuncio a=new Anuncio();
	Anuncio.insertar(descriptive_text,id_buildings,id_ownersBuildings,id_realstate);

        Ad encontrado = Ad.findFirst("descriptive_text= ?",descriptive_text);
	 if (encontrado == null) {
            fail("Error: No se encontro Anuncio para borrar");
        } else {		
                String id =(String)encontrado.getId();	
		Anuncio.eliminar(id);
		Ad ads=Ad.findById(id);
		assertTrue(ads==null);
	}
     
    }
  

    public void testModificar() {
	System.out.println("modificar");
	
	String descriptive_text="Vendo inmueble urgente";
	String id_buildings="1";
	String id_ownersBuildings="1";
        String id_realstate="2";
	Ad ad=new Ad();
	Anuncio a=new Anuncio();
	Anuncio.insertar(descriptive_text,id_buildings,id_ownersBuildings,id_realstate);

        Ad encontrado = Ad.findFirst("descriptive_text=?",descriptive_text);

       	String id =(String)ad.getId();
	String new_text="Vendo edificio";
    	Anuncio. modificar(id,new_text,id_buildings,id_ownersBuildings,id_realstate);
		
	Ad ads=Ad.findFirst("descriptive_text= ?",new_text);

	assertFalse(ads==null);	
   }



     
}

