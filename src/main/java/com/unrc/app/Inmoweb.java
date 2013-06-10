package com.unrc.app;
import com.unrc.app.models.*;
import org.javalite.activejdbc.Base;
import spark.*;
import java.util.List;
public class Inmoweb {

   public static void main(String[] args) {
      Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");   	
      User e = new User();
        e.set("email", "user@email.com");
        e.set("first_name", "John");
        e.set("last_name", "Doe");
        e.saveIt(); 	
      Spark.get(new Route("/") {
         @Override
         public Object handle(Request request, Response response) {
            response.type("text/html");
	     // return html
                return "" +
                "<DOCTYPE html>" +
                "<html>" +
                " <head>" +
                "<title>Inmo Web</title>"+
                " </head>" +
                "<body background = 'http://inmueblesconrentabilidad.net/wp-content/uploads/2012/03/edificios.jpg'>"+
                "<center> <h1>Imobiliarias Online Web</h1>" +
                ////////////////////////////////////////////////////        
                " <a href='user/2'>Usuario</a><br>"+         
                " <a href='listUsers/'>Listar Usuarios</a><br>"+     
                " <a href='addUser/'>Agregar un Usuario</a><br>"+
                " <a href='deleteUser/'>Dar de Baja un Usuario</a><br>"+
                " <a href='changeUser/'>Modificar un Usuario</a><br>"+        
                ////////////////////////////////////////////////////        
                " <a href='owner/2'>Dueño de Inmobiliaria</a><br>"+        
		" <a href='listOwners/'>Lista de Dueños de Inmobiliarias</a><br>"+    
                " <a href='addOwner/'>Agregar un Dueño de Inmobiliaria</a><br>"+
                " <a href='deleteOwner/'>Dar de Baja un Dueño de Inmobiliaria</a><br>"+        
                " <a href='changeOwner/'>Modificar datos del Dueño de Inmobiliaria</a><br>"+
                /////////////////////////////////////////////////////        
                " <a href='real_state/2'>Inmobiliaria</a><br>"+
                " <a href='listRealState/'>Listar Inmobiliarias</a><br>"+
                " <a href='addRealState/'>Agregar una Inmobiliaria</a><br>"+
                " <a href='deleteRealState/'>Dar de Baja una Inmobiliaria</a><br>"+
                " <a href='ChangeRealState/'>Modificar Datos de una Inmobiliaria</a><br>"+        
                ////////////////////////////////////////////////////////////        
                " <a href='ownerBuildings/2'>Dueño de Inmueble</a><br>"+
                " <a href='listOwnerBuildings/'>Listar Dueños de Inmuebles</a><br>"+
                " <a href='addOwnerBuilding/'>Agregar un Dueño de Inmueble</a><br>"+
                " <a href='deleteOwnerBuilding/'>Dar de Baja un Dueño de Inmueble</a><br>"+
                " <a href='changeOwnerBuilding/'>Modificar Datos de dueño de Inmueble</a><br>"+        
                ////////////////////////////////////////////////////////////////////        
                " <a href='building/2'>Inmueble</a><br>"+  
                " <a href='listBuildings/'>Lista de Inmuebles</a><br>"+ 
                " <a href='addBuilding/'>Agregar un Inmueble</a><br>"+
                " <a href='deleteBuilding/'>Dar de Baja un Inmueble</a><br>"+
                " <a href='changeBuilding/'>Modificar datos de Inmueble</a><br>"+        
                /////////////////////////////////////////////////////////////////////
                " <a href='Ad/'>Listar un Anuncio</a><br>"+
                " <a href='listAds/'>Listar Anuncios</a><br>"+
                " <a href='addAd/'>Agregar un Anuncio</a><br>"+
                " <a href='deleteAd/'>Dar de Baja un Anuncio</a><br>"+
                " <a href='changeAd/'>Modificar Datos de Anuncio</a><br>"+        
                ///////////////////////////////////////////////////////////////////////        
                "</body>" +
                "</html>";
         }
      });
      /// Fin de Codigo HTML
        //////////////////////////--------USER--------//////////////////////////////////////
                      //////---Listar un Usuario--------///////
      
	Spark.get(new Route("/user/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			User user = User.findFirst("id = ?", request.params(":id"));
     			Base.close();
        	
    			 if (user != null ){
  	   			 return "Name: "+user.get("email")+user.get("first_name")+user.get("last_name");
     			}else{
  	   			response.status(404);
  	   			return "User not found";
     			}
     		}
	}); 
                    ///////------Listar Todos los Usuarios------//////////
        Spark.get(new Route("/listUsers/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			User u=new User();	     		
			List <User>users = User.findAll();
			String result ="";
			for (int i=0;i<users.size();i++){
				u = users.get(i);
				result = result + "FN: "+u.get("email")+u.get("first_name")+"<br>"+u.get("last_name");
			}
			Base.close();
			return result;			
	    	}
	});
        
                    /////----Agregar un Usuario----/////
        Spark.get(new Route("/addUser/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" + 
			"<form method = 'POST' action='/addUser/'  >"+
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+        
     			"First Name: <input name='first_name'><P>"+
     			"Last Name: <input name='last_name'><P>"+
                        "Contraseña: <input name='contraseña'VALUE='********'><P>"+        
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});
        
        Spark.post(new Route ("/addUser/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Usuario.insertar(request.queryParams("first_name"), request.queryParams("last_name"),request.queryParams("email"),request.queryParams("contraseña"));
		return "Nuevo Usuario agregado";	
		}
   	});
        
        ///////////////////// -----END USER------////////////////////////////////////////////////////
        
        ////////////////////-------OWNER---------////////////////////////////////////////////////////
                    ////////////----Listar un Dueño-----////////////
        Spark.get(new Route("/owner/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			Owner owner = Owner.findFirst("id = ?", request.params(":id"));
     			Base.close();
        	
    			 if (owner != null ){
  	   			 return "Name: "+owner.get("first_name")+owner.get("last_name")+owner.get("email");
     			}else{
  	   			response.status(404);
  	   			return "Owner not found";
     			}
     		}
	}); 
                //////-----Listar Todos los dueños----/////////////
	Spark.get(new Route("/listOwners/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Owner o=new Owner();	     		
			List <Owner>owners = Owner.findAll();
			String result ="";
			for (int i=0;i<owners.size();i++){
				o = owners.get(i);
				result = result + "FN: "+o.get("first_name")+"<br>"+o.get("last_name")+o.get("email");
			}
			Base.close();
			return result;			
	    	}
	}); 
                 /////-----Agregar un Dueño----//////////
        Spark.get(new Route("/addOwner/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" + 
			"<form method = 'POST' action='/addowner/'  >"+
     			"First Name: <input name='first_name'><P>"+
     			"Last Name: <input name='last_name'><P>"+
                        "City : <input name='city'><P>"+  
                        "Phone_number: <input name='phone_number'><P>"+
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+                                
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("/addOwner/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");	
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                        Dueño.insertar(request.queryParams("first_name"), request.queryParams("last_name"),request.queryParams("city"),request.queryParams("phone_number"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("email"),request.queryParams("id_realstate"));
                        Base.close();
                        return "El dueño ha sido agregado exitosamente";	
		}
   	});
        
                /////----Dar de Bajar un dueño de Inmobiliaria---/////// 
        Spark.get(new Route("/deleteOwner/") {
        @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
                return "" + 
                    "<form method = 'POST' action='/deleteOwner/'  >"+
                    "Id dueño: <input name='id'><P>"+                                
                    "<input type='submit' value='Add'>"+
                    "<input type='reset' value='Reset'></form>";			
            }
        });

        Spark.post(new Route ("/deleteOwner/"){
        @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Owner o=new Owner();
                o=Owner.findById("id");
                if(o==null){
                    response.status(500);
                }else{
                    Dueño d = new Dueño();	
                    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                    Dueño.eliminar(request.queryParams("id"));
                    Base.close();
	        }
                return "el Dueño de Inmobiliaria fue dado de baja exitosamente";
            }
        });
                     ////// ----End Delete Owner----///////

        
        ////////////////--------Modificar un Dueño de Inmobiliaria--------////////////
        Spark.get(new Route("/changeOwner/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" + 
			"<form method = 'POST' action='/changeOwner/'  >"+
     			"id owner: <input name='id_owner'><P>"+
     			"First Name: <input name='first_name'><P>"+
     			"Last Name: <input name='last_name'><P>"+
                        "City : <input name='city'><P>"+  
                        "Phone_number: <input name='phone_number'><P>"+
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+
			"Id RealState: "+"<input name='id_realstate'><P>"+						
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("/changeOwner/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
			Owner o=new Owner();
			o=Owner.findById("id_owner");
			if(o==null){
                            response.status(500);
                            return("Dueño no encontrado");
			}
			else{
                            Dueño dueño = new Dueño();	
                            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                            Dueño.modificar(request.queryParams("id_owner"),request.queryParams("first_name"), request.queryParams("last_name"),request.queryParams("city"),request.queryParams("phone_number"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("email"),request.queryParams("id_realstate"));
                            Base.close();
                            return "El dueño ha sido modificado exitosamente";	
			}
		}
   	});

        /////////////////////------------ END OWNER--------------///////////////////////////////////
        
        ////////////////////--------------REAL STATE-------------///////////////////////////////////
                    ////----Listar una Inmobiliaria----//////////////////////////////
        Spark.get(new Route("/real_state/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			RealState real_state = RealState.findFirst("id = ?", request.params(":id"));
     			Base.close();
        	
    			 if (real_state != null ){
  	   			 return "First_Name: "+real_state.get("first_name")+"City: "+real_state.get("city");
     			}else{
  	   			response.status(404);
  	   			return "Real State not found";
     			}
     		}
	}); 
                    /////-----Listar Todas las inmobiliarias-----////////////
        Spark.get(new Route("/listRealState/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			RealState o=new RealState();	     		
			List <RealState>realState = RealState.findAll();
			String result ="";
			for (int i=0;i<realState.size();i++){
				o = realState.get(i);
				result = result + "FN: "+o.get("first_name")+"<br>";
			}
			Base.close();
			return result;			
	    	}
	});
                        //////-----Agregar una inmobiliaria-----/////////
        Spark.get(new Route("/addRealState/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" + 
			"<form method = 'POST' action='/addRealState/'  >"+
     			"First Name: <input name='first_name'><P>"+
                        "City : <input name='city'><P>"+  
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Phone_number: <input name='phone_number'><P>"+        
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+
                        "WebSite: <input name='webSite'><P>"+
                        "idDueño: <input name='id_owners'><P>"+        
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("/addRealState/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");	
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Inmobiliaria.insertar(request.queryParams("first_name"),request.queryParams("city"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("phone_number"),request.queryParams("email"),request.queryParams("webSite"),request.queryParams("id_owners"));
			Base.close();
                        return "La inmobiliaria ha sido agregado exitosamente";
			}
   	});
        
                        ///////----Dar de baja una inmobiliaria-----////////	
        Spark.get(new Route("/deleteRealState/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
                return "" + 
                    "<form method = 'POST' action='/deleteRealState/'  >"+
                    "Id RealState: <input name='id'><P>"+                                
                    "<input type='submit' value='Add'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("/deleteRealState/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
		RealState r=new RealState();
		r=RealState.findById("id");
		if(r==null){
                    response.status(500);			
		}else{
                    Inmobiliaria i= new Inmobiliaria();	
                    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                    Inmobiliaria.eliminar(request.queryParams("id"));
                    Base.close();
		}
             return "Inmobiliaria dada de baja exitosamente";   
            }
   	});
                    /////----- End Delete Inmobiliaria ----//////

                    /////----Modificar una Inmobiliaria----//////
        Spark.get(new Route("/changeRealState/") {
     	@Override
     		
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" + 
			"<form method = 'POST' action='/changeRealState/'>"+		
     			"First Name: <input name='first_name'><P>"+
                        "City : <input name='city'><P>"+  
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Phone_number: <input name='phone_number'><P>"+        
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+
                        "WebSite: <input name='webSite'><P>"+     
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("/changeRealState/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
			RealState r=new RealState();
			r=RealState.findById("id_realState");
			if(r==null){
                            response.status(500);
                            return("Inmobiliaria no encontrado");
			}else{			
                            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                            Inmobiliaria.modificar(request.queryParams("id_realState"),request.queryParams("first_name"),request.queryParams("city"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("phone_number"),request.queryParams("email"),request.queryParams("webSite"),request.queryParams("id_owners"));
                            Base.close();
                            return "La inmobiliaria ha sido modificada exitosamente";
			}
		}
   	});
                            //end-Modificacion Inmobiliaria
        /////////////////////////------END REAL STATE-------//////////////////////////////////////////
        
        ////////////////////////-------OWNER BUILDING------//////////////////////////////////////////
                        ////---Listar un Dueño de Inmueble---///////
        Spark.get(new Route("/ownerBuildings/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			OwnerBuilding ownerBuilding = OwnerBuilding.findFirst("id = ?", request.params(":id"));
     			Base.close();
        	
    			 if (ownerBuilding != null ){
  	   			 return "Name: "+ownerBuilding.get("first_name")+ownerBuilding.get("last_name");
     			}else{
  	   			response.status(404);
  	   			return "Dueño inmueble not found";
     			}
     		}
	});
        
                    ////----listar Todos los dueños de inmueble-----//////
        Spark.get(new Route("/listOwnerBuildings/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			OwnerBuilding ob=new OwnerBuilding();	     		
			List <OwnerBuilding>ownerBuilding = OwnerBuilding.findAll();
			String result ="";
			for (int i=0;i<ownerBuilding.size();i++){
				ob = ownerBuilding.get(i);
				result = result + "FN: "+ob.get("first_name")+"<br>"+ob.get("last_name");
			}
			Base.close();
			return result;			
	    	}
	});
                    //////-----Agregar un dueño de inmueble-----///////
        Spark.get(new Route("/addOwnerBuilding/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" + 
			"<form method = 'POST' action='/addOwnerBuilding/'  >"+
     			"First Name: <input name='first_name'><P>"+
                        "Last Name: <input name='last_name'><P>"+        
                        "City : <input name='city'><P>"+  
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+        
                        "Phone_number: <input name='phone_number'><P>"+
                        "idDueno_Inmueble: <input name='id_building'><P>"+        
                        "idDueno_Inmobiliaria: <input name='id_realState'><P>"+        
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("/addOwnerBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");	
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			DueñoInmueble.insertar(request.queryParams("first_name"),request.queryParams("last_name"),request.queryParams("city"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("email"),request.queryParams("phone_number"),request.queryParams("id_building"),request.queryParams("id_realState"));
                        Base.close();
                        return "El Dueño Inmueble ha sido agregado exitosamente";	
		}
   	});
        
                ///-----Modificar un Dueño de Inmueble-------//////
        Spark.get(new Route("/changeOwnerBuilding/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" + 
			"<form method = 'POST' action='/changeOwnerBuilding/'>"+
     			"First Name: <input name='first_name'><P>"+
                        "Last Name: <input name='last_name'><P>"+        
                        "City : <input name='city'><P>"+  
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+        
                        "Phone_number: <input name='phone_number'><P>"+                      						
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});
        
                //////-----Dar de baja un dueño de Inmueble------/////////
        Spark.get(new Route("/deleteOwnerBuilding/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
		return "" + 
                    "<form method = 'POST' action='/deleteOwnerBuilding/'  >"+
                    "Id OwnerBuilding: <input name='id'><P>"+                                
                    "<input type='submit' value='Add'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("/deleteOwnerBuilding/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
		OwnerBuilding ob=new OwnerBuilding();
                if(ob==null){
                    response.status(500);
		}else{
                    DueñoInmueble di = new DueñoInmueble();	
                    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                    DueñoInmueble.eliminar(request.queryParams("id"));
                    Base.close();
                }
            return "el Dueño de inmueble fue dado de baja exitosamente";    
            }
   	});
                //////----- End-Delete OwnerBuilding------//////


	Spark.post(new Route ("/changeOwnerBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
			OwnerBuilding ob=new OwnerBuilding();
			ob=OwnerBuilding.findById("id");
			if(ob==null){
                            response.status(500);
                            return("Dueño Inmueble no encontrado");
			}
			else{	
                            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                            DueñoInmueble.modificar(request.queryParams("id_ownersBuilding"),request.queryParams("first_name"),request.queryParams("last_name"),request.queryParams("city"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("email"),request.queryParams("phone_number"),request.queryParams("id_realState"),request.queryParams("id_Building"));
                            Base.close();
                            return "El Dueño Inmueble ha sido modificado exitosamente";	
			}			
		}
   	});
        ///////////////////////------------END OWNER BUILDING--------///////////////////////////////
        
        ///////////////////////------------BUILDING------------------///////////////////////////////
                    //////////--------Listar un Inmueble----////////////
        Spark.get(new Route("/building/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			Building building = Building.findFirst("id = ?", request.params(":id"));
     			Base.close();
        	
    			 if (building != null ){
  	   			 return "City: "+building.get("city")+"Neigberhood: "+building.get("Neigberhood")+"Street: "+building.get("street")+"Descriptive Text: "+building.get("descriptive_text");
     			}else{
  	   			response.status(404);
  	   			return "Inmueble not found";
     			}
     		}
	});
        
                    ///////------Listar todos los Inmuebles----/////////////
        Spark.get(new Route("/listBuildings/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Building ob=new Building();	     		
			List <Building>building = Building.findAll();
			String result ="";
			for (int i=0;i<building.size();i++){
				ob = building.get(i);
				result = result + "FN: "+ob.get("first_name")+"<br>"+ob.get("neigberhood")+"<br>"+ob.get("street")+"<br>"+ob.get("descriptive_text")+"<br>";
                        }
			Base.close();
			return result;			
	    	}
	});
        
                    //////------Agregar un Inmueble////////////////
        Spark.get(new Route("/addBuilding/") {
     	@Override
            public Object handle(Request request, Response response) {
            response.type("text/html");	     					
            return "" + 
                "<form method = 'POST' action='/addBuilding/'  >"+
                "City: "+"<input name='city'><P>"+        
                "neighborhood: <input name='neighborhood'><P>"+
     		"Street: <input name='street'><P>"+
                "Descriptive Text: <input name='descriptive_text'><P>"+
                "Price: <input name='price'><P>"+
                "id_situation: <input name='id_situation'><P>"+  
                "iD owner Building: <input name='id_ownersBuilding'><P>"+   
                "ID Type: <input name='id_isType'><P>"+
                "ID Real State: <input name='id_realstate'><P>"+       
     		"<input type='submit' value='Add'>"+
     		"<input type='reset' value='Reset'></form>";			
	    }
	});
        
        Spark.post(new Route ("/addBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Inmueble.insertar(request.queryParams("city"), request.queryParams("neigberhood"),request.queryParams("street"),request.queryParams("descriptive_text"),request.queryParams("price"),request.queryParams("id_situation"),request.queryParams("id_ownersBuilding"),request.queryParams("id_isType"),request.queryParams("id_realstate"));
		return "Nuevo inmueble agregado";	
		}
   	});
        
                ///////////////------Dar de baja un Inmueble--------/////////////////	
        Spark.get(new Route("/deleteBuilding/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
		return "" + 
                    "<form method = 'POST' action='/deleteBuilding/'  >"+
                    "Id Building: <input name='id'><P>"+                                
                    "<input type='submit' value='Add'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("/deleteBuilding/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Building b=new Building();
                if(b==null){
                    response.status(500);			
		}else{	
                    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                    Inmueble.eliminar(request.queryParams("id"));
                    Base.close();
                }
            return "El inmueble ha sido dado de baja exitosamente";    
            }
   	});
                    /////// ------End-Delete Building--------/////////
        
        Spark.get(new Route("/changeBuilding/") {
        @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
                return "" + 
                    "<form method = 'POST' action='/changeBuilding/'  >"+			    
                    "City: <input name='city'><P>"+
                    "Neighborhood: <input name='neighborhood'><P>"+
                    "Street: <input name='street'><P>"+
                    "Descriptive text: <input name='descriptive_text'><P>"+				
                    "price: <input name='price'><P>"+
                    "id_situation: <input name='situation'><P>"+
                    "id_ownersBuilding: <input name='id_ownersBuilding'><P>"+
                    "id_isType: <input name='id_isType'><P>"+
                    "Id real state: <input name='id_realstate'><P>"+
                    "<input type='submit' value='Add'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("/changeBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
			Building b=new Building();
			b=Building.findById("id_building");
			if(b==null){
                            response.status(500);
                            return("Inmueble no encontrado");			
			}else{
                            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                            Inmueble.modificar(request.queryParams("id"),request.queryParams("city"),request.queryParams("neighborhood"),request.queryParams("street"), request.queryParams("descriptive_text"),request.queryParams("price"),request.queryParams("id_situation"),request.queryParams("id_ownersBuilding"),request.queryParams("id_isType"),request.queryParams("id_realstate"));
                            Base.close();
                            return "El Inmueble ha sido modificado exitosamente";			
			}		
		}
   	});
        ////////////////////////---------END BUILDING---------------////////////////////////////////  
        
        ///////////////////////----------ANUNCIO (AD)--------------////////////////////////////////
                            /////----Listar un Anuncio por ID---/////////
        Spark.get(new Route("/ad/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			Ad ad = Ad.findFirst("id = ?", request.params(":id"));
     			Base.close();        	
    			 if (ad != null ){
                            return "id: "+ad.get("id")+ad.get("descriptive_text");
     			}else{
                            response.status(404);
                            return "Anuncio not found";
     			}
     		}
	});
        
                    ////////-----Listar todos los Anuncios------//////////////
        Spark.get(new Route("/listAds/") {
     	@Override
     		public Object handle(Request request, Response response) {
                    response.type("text/html");
                    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                    Ad ad=new Ad();	     		
                    List <Ad>ads = Ad.findAll();
                    String result ="";
                        for (int i=0;i<ads.size();i++){
                            ad = ads.get(i);
                            result = result + "FN: "+ad.get("id")+"<br>"+ad.get("descriptive_text")+"<br>";
                        }
                    Base.close();
                    return result;			
	    	}
	});
        
                    /////-----Agregar un Inmueble------//////////
        Spark.get(new Route("/addAd/") {
     	@Override
            public Object handle(Request request, Response response) {
            response.type("text/html");	     					
            return "" + 
                "<form method = 'POST' action='/addAd/'  >"+
                "Descriptive Text: "+"<input name='descriptive_text'><P>"+        
                "ID Building: <input name='id_buildings'><P>"+
     		"ID Owner Building: <input name='id_ownersBuildings'><P>"+
                "ID Real State: <input name='id_realstate'><P>"+       
     		"<input type='submit' value='Add'>"+
     		"<input type='reset' value='Reset'></form>";			
	    }
	});
        
        Spark.post(new Route ("/addAd/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Anuncio.insertar(request.queryParams("descriptive_text"), request.queryParams("id_buildings"),request.queryParams("id_ownersBuildings"),request.queryParams("id_realstate"));
		return "Nuevo Anuncio agregado";	
		}
   	});


                        ////----Modificar un Anuncio-----////////
        Spark.get(new Route("/changeAds/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" + 
			"<form method = 'POST' action='/changeAds/'  >"+
     			"id Anuncio: <input name='id'><P>"+ 
     			"descriptive Text: <input name='descriptive_text'><P>"+                                
    			"id Owner Building: <input name='id_ownersBuilding'><P>"+ 
     			"id Buildng: <input name='id_Building'><P>"+                                
     			"id RealState: <input name='id_realstate'><P>"+
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});
        
                        ////-----Dar de baja un Anuncio------//////
        Spark.get(new Route("/deleteAds/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
		return "" + 
                    "<form method = 'POST' action='/deleteAds/'  >"+
                    "Id dueño: <input name='id'><P>"+                                
                    "<input type='submit' value='Add'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("/deleteAds/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Ad ad=new Ad();
		if(ad==null){
                    response.status(500);
		}
		Anuncio a = new Anuncio();	
		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
		Anuncio.eliminar(request.queryParams("id"));
                Base.close();
            return "El Anuncio fue dado de baja Correctamente";    
            }
   	});
                    /////------ End-Delete Ad------////////

	Spark.post(new Route ("/changeAds/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
			Anuncio a =new Anuncio();
			Ad ad=new Ad();
			ad=Ad.findById("id");
			if(ad==null){
                            response.status(500);
                            return("Anuncio no encontrado");
			}else{
                            Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                            Anuncio.modificar(request.queryParams("id"),request.queryParams("descriptive_text"),request.queryParams("id_building"),request.queryParams("id_ownersBuilding"),request.queryParams("id_realstate"));
                            return "el anuncio fue modificado exitosamente";
                        }
		}
   	});
        ///////////////////////////// ----END ANUNCIO(AD)-----////////////////////////////////////////	
   }
}
