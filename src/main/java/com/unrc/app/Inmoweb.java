package com.unrc.app;
import com.unrc.app.models.*;
import org.javalite.activejdbc.Base;
import spark.*;
import java.util.List;
public class Inmoweb {

   public static void main(String[] args) { 	
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
                "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+
                "<center> <h1>Imobiliarias Online Web</h1>" +
             //////////////////////////////////////////////  
                        /*login*/
      "<form name='formu' action='/login/' method='post'>"+
"<table bgcolor='#DADADA' border='0' cellpadding='1 cellspacing='1' align='center'>"+
	"<tr>"+
		"<td bgcolor='#CCCCCC' align='center' colspan='2'>"+
			"<b>LOGIN</b>"+
		"</td>"+
	"</tr>"+
	"<tr>"+
		"<td align='right'>"+
			"<b>First Name:</b>&nbsp;"+
		"</td>"+
		"<td align='left'>"+
		"<input type='text' maxlength='56' name='first'>&nbsp;"+
		"</td>"+
	"</tr>"+
        "<tr>"+
		"<td align='right'>"+
			"<b>Last Name:</b>&nbsp;"+
		"</td>"+
		"<td align='left'>"+
		"<input type='text' maxlength='56' name='last'>&nbsp;"+
		"</td>"+
	"</tr>"+
        
        "<tr>"+
		"<td align='right'>"+
			"<b>Email:</b>&nbsp;"+
		"</td>"+
		"<td align='left'>"+
		"<input type='text' maxlength='60' name='email'>&nbsp;"+
		"</td>"+
	"</tr>"+
                        
                        
	"<tr>"+
		"<td align='right'>"+
			"&nbsp;<b>Pasword:</b>&nbsp;"+
		"</td>"+
		"<td align='left'>"+
		"<input type='password' maxlength='30' name='pass_form'>&nbsp;"+
		"</td>"+
	"</tr>"+
	"<tr>"+
		"<td colspan='2' align='center'>"+
		"<input type='submit' value='L O G I N'>"+
		"</td>"+
	"</tr>"+
	"<tr>"+
		"<td align='center' colspan='2'>"+
			"&nbsp;No estas registrado? <a href='/addUser/'><font color='#000000'><b>REGISTRATE</b></font></a>&nbsp;"+
		"</td>"+
	"</tr>"+
"</form>"+
"</table> "+
                        
                        
                        
                            ////////////////////////////////////////////////////        
                " <a href='user/1'>Usuario</a><br>"+         
                " <a href='listUsers/'>Listar Usuarios</a><br>"+
                 ////////////////////////////////////////////////////        
                " <a href='userType/mainOwner/owner/1'>Duenio de Inmobiliaria</a><br>"+        
		" <a href='userType/mainOwner/listOwners/'>Lista de Duenios de Inmobiliarias</a><br>"+
                        
                /////////////////////////////////////////////////////        
                " <a href='userType/mainOwner/real_state/1'>Inmobiliaria</a><br>"+
                " <a href='userType/mainOwner/listRealState/'>Listar Inmobiliarias</a><br>"+
                        
                ////////////////////////////////////////////////////////////        
                " <a href='userType/mainOwnerBuilding/ownerBuildings/1'>Duenio de Inmueble</a><br>"+
                " <a href='userType/mainOwnerBuilding/listOwnerBuildings/'>Listar Duenios de Inmuebles</a><br>"+
                        
                ////////////////////////////////////////////////////////////////////        
                " <a href='userType/mainOwner/building/1'>Inmueble</a><br>"+  
                " <a href='userType/mainOwner/listBuildings/'>Lista de Inmuebles</a><br>"+ 
                        
                " <a href='userType/mainOwner/Ad/1'>Listar un Anuncio</a><br>"+
                " <a href='userType/mainOwner/listAds/'>Listar Anuncios</a><br>"+
                ///////////////////////////////////////////////////////////////////////        
               	"</center>"+
"</html>";			

     }
});
                                     /// Fin de Codigo HTML////
       Spark.post(new Route ("/login/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			User u=new User();
                        u=User.findFirst("email= '"+request.queryParams("email") + "' and " 
                                          +"first_name = '" + request.queryParams("first") + "' and "
                                          + "last_name= '" + request.queryParams("last") + "' and "
                                          +"password= '" + request.queryParams("pass_form")+"' ");
                        if(u!=null){
                            response.redirect("/userType/");
                        }
                        else{
                            return "Error: Algun dato no es valido"+"<br>"+
                                "<a href='/'>GoBack</a><br>";

                        }
                        Base.close();
                return " ";	
		}
   	});
                                 /// Fin de Codigo HTML////
       Spark.get(new Route ("/userType/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			return " "+
                   "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+
                                
                   "<a href='/userType/changeUser/'>Cambiar Usuario</a><br>"+
                                
                    "<a href='mainOwner/'>Duenio de Inmobiliaria</a><br>"+
                    
                    " <a href='mainOwnerBuilding/'>DuenioInmueble</a><br>";    
                    
		}
   	});
       
       
        
       Spark.get(new Route ("/userType/mainOwner/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			return " "+
                    
                ////////////////////////////////////////////////////////////        
                   "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+             
                   "<a href='/userType/mainOwner/owner/1'>Duenio de Inmobiliaria</a><br>"+        
                    " <a href='/userType/mainOwner/listOwners/'>Lista de Duenios de Inmobiliarias</a><br>"+    
                    " <a href='/userType/mainOwner/addOwner/'>Agregar un Duenio de Inmobiliaria</a><br>"+
                    " <a href='/userType/mainOwner/deleteOwner/'>Dar de Baja un Duenio de Inmobiliaria</a><br>"+        
                    " <a href='/userType/mainOwner/changeOwner/'>Modificar datos del Duenio de Inmobiliaria</a><br> <br> </br>"+
                                        
                    " <a href='/userType/mainOwner/real_state/1'>Inmobiliaria</a><br>"+
                    " <a href='/userType/mainOwner/listRealState/'>Listar Inmobiliarias</a><br>"+
                    " <a href='/userType/mainOwner/addRealState/'>Agregar una Inmobiliaria</a><br>"+
                    " <a href='/userType/mainOwner/deleteRealState/'>Dar de Baja una Inmobiliaria</a><br>"+
                    " <a href='/userType/mainOwner/ChangeRealState/'>Modificar Datos de una Inmobiliaria</a><br> <br> </br>"+
                     
                " <a href='/userType/mainOwner/building/1'>Inmueble</a><br>"+  
                " <a href='/userType/mainOwner/listBuildings/'>Lista de Inmuebles</a><br>"+ 
                " <a href='/userType/mainOwner/addBuilding/'>Agregar un Inmueble</a><br>"+
                " <a href='/userType/mainOwner/deleteBuilding/'>Dar de Baja un Inmueble</a><br>"+
                " <a href='/userType/mainOwner/changeBuilding/'>Modificar datos de Inmueble</a><br> <br> </br>"+        
                /////////////////////////////////////////////////////////////////////
                " <a href='/userType/mainOwner/Ad/1'>Listar un Anuncio</a><br>"+
                " <a href='/userType/mainOwner/listAds/'>Listar Anuncios</a><br>"+
                " <a href='/userType/mainOwner/addAd/'>Agregar un Anuncio</a><br>"+
                " <a href='/userType/mainOwner/deleteAd/'>Dar de Baja un Anuncio</a><br>"+
                " <a href='/userType/mainOwner/changeAds/'>Modificar Datos de Anuncio</a><br> <br> </br>";        
                                      
		}
   	});
        
        
       
       
       
       Spark.get(new Route ("/userType/mainOwnerBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			return " "+
                                
                                
                ////////////////////////////////////////////////////////////
                "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+                
                " <a href='/userType/mainOwnerBuilding/ownerBuildings/1'>Duenio de Inmueble</a><br>"+
                " <a href='/userType/mainOwnerBuilding/listOwnerBuildings/'>Listar Duenios de Inmuebles</a><br>"+
                " <a href='/userType/mainOwnerBuilding/addOwnerBuilding/'>Agregar un Duenio de Inmueble</a><br>"+
                " <a href='/userType/mainOwnerBuilding/deleteOwnerBuilding/'>Dar de Baja un Duenio de Inmueble</a><br>"+
                " <a href='/userType/mainOwnerBuilding/changeOwnerBuilding/'>Modificar Datos de Duenio de Inmueble</a><br> <br> </br>"+
                            
                     
                " <a href='/userType/mainOwnerBuilding/building/1'>Inmueble</a><br>"+  
                " <a href='/userType/mainOwnerBuilding/listBuildings/'>Lista de Inmuebles</a><br>"+ 
                " <a href='/userType/mainOwnerBuilding/addBuilding/'>Agregar un Inmueble</a><br>"+
                " <a href='/userType/mainOwnerBuilding/deleteBuilding/'>Dar de Baja un Inmueble</a><br>"+
                " <a href='/userType/mainOwnerBuilding/changeBuilding/'>Modificar datos de Inmueble</a><br> <br> </br>"+        
                /////////////////////////////////////////////////////////////////////
                " <a href='/userType/mainOwnerBuilding/Ad/1'>Listar un Anuncio</a><br>"+
                " <a href='/userType/mainOwnerBuilding/listAds/'>Listar Anuncios</a><br>"+
                " <a href='/userType/mainOwnerBuilding/addAd/'>Agregar un Anuncio</a><br>"+
                " <a href='/userType/mainOwnerBuilding/deleteAd/'>Dar de Baja un Anuncio</a><br>"+
                " <a href='/userType/mainOwnerBuilding/changeAds/'>Modificar Datos de Anuncio</a><br> <br> </br>";
                                      
		}
   	});
      
      
        //////////////////////////--------USER--------//////////////////////////////////////
                      //////---Listar un Usuario--------///////
      
	Spark.get(new Route("/user/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			User user = User.findFirst("id = ?", request.params(":id"));
                        Base.close();
                        if (user != null ){
  	   			 return "Name: "+" "+user.get("email")+"  "+"first name   "+user.get("first_name")+"  "+" last name "+user.get("last_name");
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
				result = result + "<ol> " +u.get("first_name")+" "+u.get("last_name")+"</ol>";
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
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
			"<form method = 'POST' action='/addUser/'  >"+
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+        
     			"First Name: <input name='first_name'><P>"+
     			"Last Name: <input name='last_name'><P>"+
                        "Password: <input type='password' name='password'><P>"+        
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});
        
        Spark.post(new Route ("/addUser/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Usuario.insertar(request.queryParams("email"), request.queryParams("first_name"),request.queryParams("last_name"),request.queryParams("password"));
                        Base.close();
                return "Nuevo Usuario agregado";	
		}
   	});
        
                        /////--- Eliminar un Usuario----//////
                Spark.get(new Route("/deleteUser/") {
                @Override
                public Object handle(Request request, Response response) {
                    response.type("text/html");	     					
                return "" + 
                    "<form method = 'POST' action='/deleteUser/'  >"+
                    "ID: <input name='id'><P>"+
                    "<input type='submit' value='Delete'>"+
                    "<input type='reset' value='Reset'></form>";			
            }
        });

        Spark.post(new Route ("/deleteUser/"){
        @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                User o=new User();
                o=User.findById(request.queryParams("id"));
                if(o==null){
                    response.status(500);
                }else{ 
                    Usuario.eliminar(request.queryParams("id"));
	        }
                Base.close();
                return "el Usuario fue dado de baja exitosamente";
            }
        });
        
                Spark.get(new Route("/userType/changeUser/") {
                @Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" +
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
			"<form method = 'POST' action='/changeUser/'  >"+
                         "Id: <input name='id'><P>"+
     			"Email: <input name='email'><P>"+
     			"First Name: <input name='first_name'><P>"+
     			"Last Name: <input name='last_name'><P>"+
                        "Password: <input type='password' name='password'><P>"+        
                        "<input type='submit' value='Change'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("/userType/changeUser/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
                        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			
                        User u=new User();                        
			u=User.findById(request.queryParams("id"));
			if(u==null){
                            response.status(500);
                            return("Usuario no encontrado");
			}
			else{
                            Usuario.modificar(request.queryParams("id"),request.queryParams("email"),request.queryParams("first_name"), request.queryParams("last_name"),request.queryParams("password"));
			}
                        Base.close();
                        return "El Usuario ha sido modificado exitosamente";
		}
                	
   	});

                     ////// ----End Delete User----///////

        
        ///////////////////// -----END USER------////////////////////////////////////////////////////
        ////////////////77-----------------mainOwner-------------/////////////////////////
        ////////////////////-------OWNER---------////////////////////////////////////////////////////
                    ////////////----Listar un Dueño-----////////////
        Spark.get(new Route("userType/mainOwner/owner/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			Owner owner = Owner.findFirst("id = ?", request.params(":id"));        	
    			if (owner != null ){
                            return "Name: "+owner.get("first_name")+" "+" last name: "+owner.get("last_name")+" "+" email: "+owner.get("email");
     			}else{
  	   			response.status(404);
  	   			return "Owner not found";
     			}     		
                }
	}); 
                //////-----Listar Todos los dueños----/////////////
	Spark.get(new Route("userType/mainOwner/listOwners/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Owner o=new Owner();	     		
			List <Owner>owners = Owner.findAll();
			String result ="";
			for (int i=0;i<owners.size();i++){
				o = owners.get(i);
				result = result + "<ol>"+"First Name: "+o.get("first_name")+"last name: "+ o.get("last_name")+"email: "+o.get("email")+"</ol>";
			}
			Base.close();
			return result;			
	    	}
	}); 
                 /////-----Agregar un Dueño----//////////
        Spark.get(new Route("userType/mainOwner/addOwner/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" +
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
			"<form method = 'POST' action='/addOwner/'  >"+
     			"First Name: <input name='first_name'><P>"+
     			"Last Name: <input name='last_name'><P>"+
                        "City : <input name='city'><P>"+  
                        "Phone_number: <input name='phone_number'><P>"+
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+
                        "ID Inmobiliaria: <input name='id_realstates'><P>"+        
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("userType/mainOwner/addOwner/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");	
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                        Dueño.insertar(request.queryParams("first_name"), request.queryParams("last_name"),request.queryParams("city"),request.queryParams("phone_number"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("email"),request.queryParams("id_realstates"));
                        Base.close();
                        return "El duenio ha sido agregado exitosamente";	
		}
   	});
        
                /////----Dar de Bajar un dueño de Inmobiliaria---/////// 
        Spark.get(new Route("userType/mainOwner/deleteOwner/") {
        @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
                return "" + 
                    "<form method = 'POST' action='/deleteOwner/'  >"+
                    "Id duenio: <input name='id'><P>"+                                
                    "<input type='submit' value='Delete'>"+
                    "<input type='reset' value='Reset'></form>";			
            }
        });

        Spark.post(new Route ("userType/mainOwner/deleteOwner/"){
        @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                Owner o=new Owner();
                o=Owner.findById(request.queryParams("id"));
                if(o==null){
                    response.status(500);
                }else{
                    Dueño.eliminar(request.queryParams("id"));
	        }
                Base.close();
                return "el Duenio de Inmobiliaria fue dado de baja exitosamente";
            }
        });
                     ////// ----End Delete Owner----///////

        
        ////////////////--------Modificar un Dueño de Inmobiliaria--------////////////
        Spark.get(new Route("userType/mainOwner/changeOwner/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" +
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
			"<form method = 'POST' action='/changeOwner/'  >"+
     			"id owner: <input name='id_owner'><P>"+
     			"First Name: <input name='first_name'><P>"+
     			"Last Name: <input name='last_name'><P>"+
                        "City : <input name='city'><P>"+  
                        "Phone_number: <input name='phone_number'><P>"+
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+
			"Id RealState: "+"<input name='id_realstates'><P>"+						
     			"<input type='submit' value='Change'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("userType/mainOwner/changeOwner/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
                        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Owner o=new Owner();
			o=Owner.findById(request.queryParams("id_owner"));
			if(o==null){
                            response.status(500);
                            return("Dueño no encontrado");
			}
			else{	
                            Dueño.modificar(request.queryParams("id_owner"),request.queryParams("first_name"), request.queryParams("last_name"),request.queryParams("city"),request.queryParams("phone_number"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("email"),request.queryParams("id_realstates"));                            
			}Base.close();
                         return "El duenio ha sido modificado exitosamente";
		}
   	});

        /////////////////////------------ END OWNER--------------///////////////////////////////////
        
        ////////////////////--------------REAL STATE-------------///////////////////////////////////
                    ////----Listar una Inmobiliaria----//////////////////////////////
        Spark.get(new Route("userType/mainOwner/real_state/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			RealState real_state = RealState.findFirst("id = ?", request.params(":id"));
     			Base.close();
        	
    			 if (real_state != null ){
  	   			 return "First_Name: "+ real_state.get("first_name") + " " + "City: "+ real_state.get("city");
     			}else{
  	   			response.status(404);
  	   			return "Real State not found";
     			}
     		}
	}); 
                    /////-----Listar Todas las inmobiliarias-----////////////
        Spark.get(new Route("userType/mainOwner/listRealState/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			RealState o=new RealState();	     		
			List <RealState>realState = RealState.findAll();
			String result ="";
			for (int i=0;i<realState.size();i++){
				o = realState.get(i);
				result = result +" <ol>"+"first name: "+o.get("first_name")+"</ol>";
			}
			Base.close();
			return result;			
	    	}
	});
                        //////-----Agregar una inmobiliaria-----/////////
        Spark.get(new Route("userType/mainOwner/addRealState/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" +
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
			"<form method = 'POST' action='/addRealState/'  >"+
     			"First Name: <input name='first_name'><P>"+
                        "City : <input name='city'><P>"+  
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Phone_number: <input name='phone_number'><P>"+        
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+
                        "WebSite: <input name='webSite'VALUE='www.example.com'><P>"+
                        "idDuenio: <input name='id_owners'><P>"+        
     			"<input type='submit' value='Add'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("userType/mainOwner/addRealState/"){
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
        Spark.get(new Route("userType/mainOwner/deleteRealState/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
                return "" + 
                    "<form method = 'POST' action='/deleteRealState/'  >"+
                    "Id RealState: <input name='id'><P>"+                                
                    "<input type='submit' value='Delete'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("userType/mainOwner/deleteRealState/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
		RealState r=new RealState();
		r=RealState.findById(request.queryParams("id"));
		if(r==null){
                    response.status(500);			
		}else{
                    Inmobiliaria.eliminar(request.queryParams("id"));
		}
             Base.close();  
             return "Inmobiliaria dada de baja exitosamente";   
            }
   	});
                    /////----- End Delete Inmobiliaria ----//////

                    /////----Modificar una Inmobiliaria----//////
        Spark.get(new Route("userType/mainOwner/changeRealState/") {
     	@Override
     		
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" +
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
			"<form method = 'POST' action='/changeRealState/'>"+
                        "Id: <input name='id'><P>"+
     			"First Name: <input name='first_name'><P>"+
                        "City : <input name='city'><P>"+  
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Phone_number: <input name='phone_number'><P>"+        
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+
                        "WebSite: <input name='webSite'VALUE='www.example.com'><P>"+     
     			"id owner: <input name='id_owners'><P>"+
                        "<input type='submit' value='Change'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});

	Spark.post(new Route ("/userType/mainOwner/changeRealState/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
                        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			RealState r=new RealState();
			r=RealState.findById(request.queryParams("id"));
			if(r==null){
                            response.status(500);
                            return("Inmobiliaria no encontrado");
			}else{	
                            Inmobiliaria.modificar(request.queryParams("id"),request.queryParams("first_name"),request.queryParams("city"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("phone_number"),request.queryParams("email"),request.queryParams("webSite"),request.queryParams("id_owners"));
                        }Base.close();
                         return "La inmobiliaria ha sido modificada exitosamente";
		}
   	});
                            //end-Modificacion Inmobiliaria
        /////////////////////////------END REAL STATE-------//////////////////////////////////////////
        
        
        ///////////////////////------------BUILDING------------------///////////////////////////////
                    //////////--------Listar un Inmueble----////////////
        Spark.get(new Route("userType/mainOwner/building/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			Building building = Building.findFirst("id = ?", request.params(":id"));
                        Base.close();

        	
    			 if (building != null ){
  	   			
                             return "City: "+building.get("city")+"Neigberhood: "+building.get("neighborhood")+"Street: "+building.get("street")+"Descriptive Text: "+building.get("descriptive_text");

                         }else{
  	   			response.status(404);
  	   			return "Inmueble not found";
     			}
     		}
	});
        
                    ///////------Listar todos los Inmuebles----/////////////
        Spark.get(new Route("userType/mainOwner/listBuildings/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Building ob=new Building();	     		
			List <Building>building = Building.findAll();
			String result ="";
			for (int i=0;i<building.size();i++){
				ob = building.get(i);
				result = result +"<ol>"+ "city "+ ob.get("city") + "neighborhood" + ob.get("neighborhood") + "street: "+ ob.get("street") + "descriptive_ text"+ ob.get("descriptive_text") + "</ol>";
                        }
			Base.close();
			return result;			
	    	}
	});
        
                    //////------Agregar un Inmueble////////////////
        Spark.get(new Route("userType/mainOwner/addBuilding/") {
     	@Override
            public Object handle(Request request, Response response) {
            response.type("text/html");	     					
            return "" + 
                "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                "<form method = 'POST' action='/addBuilding/'  >"+
                "City: "+"<input name='city'><P>"+        
                "neighborhood: <input name='neighborhood'><P>"+
     		"Street: <input name='street'><P>"+
                "Descriptive Text: <br><textarea name='descriptive_text'cols='100'raws='20'>Ingrese su texto!</textarea>"+"<br>"+"<br>"+
                "Price: <input name='price'><P>"+
                "id_situation: <input name='id_situation'><P>"+  
                "iD owner Building: <input name='id_ownersBuilding'><P>"+   
                "ID Type: <input name='id_isType'><P>"+
                "ID Real State: <input name='id_realstate'><P>"+       
     		"<input type='submit' value='Add'>"+
     		"<input type='reset' value='Reset'></form>";			
	    }
	});
        
        Spark.post(new Route ("userType/mainOwner/addBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Inmueble.insertar(request.queryParams("city"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("descriptive_text"),request.queryParams("price"),request.queryParams("id_situation"),request.queryParams("id_ownersBuilding"),request.queryParams("id_isType"),request.queryParams("id_realstate"));
                        Base.close();
                return "Nuevo inmueble agregado";	
		}
   	});
        
                ///////////////------Dar de baja un Inmueble--------/////////////////	
        Spark.get(new Route("userType/mainOwner/deleteBuilding/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
		return "" +
                    "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                    "<form method = 'POST' action='/deleteBuilding/'  >"+
                    "Id Building: <input name='id'><P>"+                                
                    "<input type='submit' value='Delete'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("userType/mainOwner/deleteBuilding/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                Building b=new Building();
                if(b==null){
                    response.status(500);			
		}else{
                    Inmueble.eliminar(request.queryParams("id"));
                }Base.close();
            return "El inmueble ha sido dado de baja exitosamente";    
            }
   	});
                    /////// ------End-Delete Building--------/////////
                    ///////-------Change Building----------/////////
        Spark.get(new Route("userType/mainOwner/changeBuilding/") {
        @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
                return "" +
                    "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                    "<form method = 'POST' action='/changeBuilding/'>"+	
                    "Id: <input name='id'><P>"+
                    "City: <input name='city'><P>"+
                    "Neighborhood: <input name='neighborhood'><P>"+
                    "Street: <input name='street'><P>"+
                    "Descriptive Text: <br><textarea name='descriptive_text'cols='100'raws='20'>Ingrese su texto!</textarea>"+"<br>"+"<br>"+				
                    "price: <input name='price'><P>"+
                    "id_situation: <input name='situation'><P>"+
                    "id_ownersBuilding: <input name='id_ownersBuilding'><P>"+
                    "id_isType: <input name='id_isType'><P>"+
                    "Id real state: <input name='id_realstate'><P>"+
                    "<input type='submit' value='Change'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("userType/mainOwner/changeBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
                        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Building b=new Building();
			b=Building.findById(request.queryParams("id"));
			if(b==null){
                            response.status(500);
                            return("Inmueble no encontrado");			
			}else{         
 Inmueble.modificar(request.queryParams("id"),request.queryParams("city"),request.queryParams("neighborhood"),request.queryParams("street"), request.queryParams("descriptive_text"),request.queryParams("price"),request.queryParams("id_isType"),request.queryParams("situation"),request.queryParams("id_ownersBuilding"),request.queryParams("id_realstate"));
                        }Base.close();
                return "El Inmueble ha sido modificado exitosamente";		
		}
   	});
        ////////////////////////---------END BUILDING---------------////////////////////////////////  
        
        ///////////////////////----------ANUNCIO (AD)--------------////////////////////////////////
                            /////----Listar un Anuncio por ID---/////////
        Spark.get(new Route("userType/mainOwner/ad/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			Ad ad = Ad.findFirst("id = ?", request.params(":id"));
     			Base.close();        	
    			 if (ad != null ){
                            return "id: " + ad.get("id") + ad.get("descriptive_text");
     			}else{
                            response.status(404);
                            return "Anuncio not found";
     			}
     		}
	});
        
                    ////////-----Listar todos los Anuncios------//////////////
        Spark.get(new Route("userType/mainOwner/listAds/") {
     	@Override
     		public Object handle(Request request, Response response) {
                    response.type("text/html");
                    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                    Ad ad=new Ad();	     		
                    List <Ad>ads = Ad.findAll();
                    String result ="";
                        for (int i=0;i<ads.size();i++){
                            ad = ads.get(i);
                            result = result + "<ol>"+"id: "+ad.get("id")+"descriptive text: "+ad.get("descriptive_text")+"</ol>";
                        }
                    Base.close();
                    return result;			
	    	}
	});
        
                    /////-----Agregar un Inmueble------//////////
        Spark.get(new Route("userType/mainOwner/addAd/") {
     	@Override
            public Object handle(Request request, Response response) {
            response.type("text/html");	     					
            return "" + 
                "<form method = 'POST' action='/addAd/'  >"+
                "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                "Descriptive Text: <br><textarea name='descriptive_text'cols='100'raws='20'>Ingrese su texto!</textarea>"+"<br>"+"<br>"+        
                "ID Building: <input name='id_Building'><P>"+
     		"ID Owner Building: <input name='id_ownersBuilding'><P>"+
                "ID Real State: <input name='id_realstate'><P>"+       
     		"<input type='submit' value='Add'>"+
     		"<input type='reset' value='Reset'></form>";			
	    }
	});
        
        Spark.post(new Route ("userType/mainOwner/addAd/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Anuncio.insertar(request.queryParams("descriptive_text"), request.queryParams("id_Building"),request.queryParams("id_ownersBuilding"),request.queryParams("id_realstate"));
                        Base.close();
                return "Nuevo Anuncio agregado";	
		}
   	});


                        ////----Modificar un Anuncio-----////////
        Spark.get(new Route("userType/mainOwner/changeAds/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" +
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
			"<form method = 'POST' action='/changeAds/'  >"+ 
     			"Id: <input name='id'><P>"+
                        "Descriptive Text: <br><textarea name='descriptive_text'cols='100'raws='20'>Ingrese su texto!</textarea>"+"<br>"+"<br>"+                                
    			"id Owner Building: <input name='id_ownersBuilding'><P>"+ 
     			"id Buildng: <input name='id_Building'><P>"+                                
     			"id RealState: <input name='id_realstate'><P>"+
     			"<input type='submit' value='Change'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});
        
        Spark.post(new Route ("userType/mainOwner/changeAds/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
                        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Anuncio a =new Anuncio();
			Ad ad=new Ad();
			ad=Ad.findById(request.queryParams("id"));
			if(ad==null){
                            response.status(500);
                            return("Anuncio no encontrado");
			}else{
                            Anuncio.modificar(request.queryParams("id"),request.queryParams("descriptive_text"),request.queryParams("id_Building"),request.queryParams("id_ownersBuilding"),request.queryParams("id_realstate"));
                        }Base.close();
                        return "el anuncio fue modificado exitosamente";
		}
   	});

        
                        ////-----Dar de baja un Anuncio------//////
        Spark.get(new Route("userType/mainOwner/deleteAd/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
		return "" + 
                    "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                    "<form method = 'POST' action='/deleteAd/'  >"+
                    "Id Anuncio: <input name='id'><P>"+                                
                    "<input type='submit' value='Delete'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("userType/mainOwner/deleteAd/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                Ad ad=new Ad();		
                ad=Ad.findById(request.queryParams("id"));
                if(ad==null){
                    response.status(500);
		}
		Anuncio.eliminar(request.queryParams("id"));
                Base.close();
            return "El Anuncio fue dado de baja Correctamente";
            }
   	});
                    /////------ End-Delete Ad------////////

	        ///////////////////////////// ----END ANUNCIO(AD)-----////////////////////////////////////////	
           
        //////////////////////////////////---------fin mainOwner----------------------////////////////////
          
        
        ////////////////////////-------OWNER BUILDING------//////////////////////////////////////////
                        ////---Listar un Dueño de Inmueble---///////
        Spark.get(new Route("userType/mainOwnerBuilding/ownerBuildings/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			OwnerBuilding ownerBuilding = OwnerBuilding.findFirst("id = ?", request.params(":id"));
     			Base.close();
        	
    			 if (ownerBuilding != null ){
  	   			 return "Name: "+ ownerBuilding.get("first_name") + ownerBuilding.get("last_name");
     			}else{
  	   			response.status(404);
  	   			return "Duenio inmueble not found";
     			}
     		}
	});
        
                    ////----listar Todos los dueños de inmueble-----//////
        Spark.get(new Route("userType/mainOwnerBuilding/listOwnerBuildings/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			OwnerBuilding ob=new OwnerBuilding();	     		
			List <OwnerBuilding>ownerBuilding = OwnerBuilding.findAll();
			String result ="";
			for (int i=0;i<ownerBuilding.size();i++){
				ob = ownerBuilding.get(i);
				result = result +"<ol>" +"First name: "+ob.get("first_name")+"last name"+ob.get("last_name")+"</ol>";
			}
			Base.close();
			return result;			
	    	}
	});
                    //////-----Agregar un dueño de inmueble-----///////
        Spark.get(new Route("userType/mainOwnerBuilding/addOwnerBuilding/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" +
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
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

	Spark.post(new Route ("userType/mainOwnerBuilding/addOwnerBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");	
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			DueñoInmueble.insertar(request.queryParams("first_name"),request.queryParams("last_name"),request.queryParams("city"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("email"),request.queryParams("phone_number"),request.queryParams("id_building"),request.queryParams("id_realState"));
                        Base.close();
                        return "El Duenio Inmueble ha sido agregado exitosamente";	
		}
   	});
        
                ///-----Modificar un Dueño de Inmueble-------//////
        Spark.get(new Route("userType/mainOwnerBuilding/changeOwnerBuilding/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" +
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
			"<form method = 'POST' action='/changeOwnerBuilding/'>"+
     			"Id: <input name='id'><P>"+
                        "First Name: <input name='first_name'><P>"+
                        "Last Name: <input name='last_name'><P>"+        
                        "City : <input name='city'><P>"+  
                        "Neighborhood: <input name='neighborhood'><P>"+       
                        "Street: <input name='street'><P>"+
                        "Email: "+"<input name='email'VALUE='example@example.com'><P>"+        
                        "Phone_number: <input name='phone_number'><P>"+
                        "id building: <input name='id_Building'><P>"+
                         "Id realstate: <input name='id_realstate'><P>"+
     			"<input type='submit' value='Change'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});
        
        	Spark.post(new Route ("userType/mainOwnerBuilding/changeOwnerBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
                        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			OwnerBuilding ob=new OwnerBuilding();
			ob=OwnerBuilding.findById(request.queryParams("id"));
			if(ob==null){
                            response.status(500);
                            return("Duenio Inmueble no encontrado");
			}
			else{
                            DueñoInmueble.modificar(request.queryParams("id"),request.queryParams("first_name"),request.queryParams("last_name"),request.queryParams("city"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("email"),request.queryParams("phone_number"),request.queryParams("id_realstate"),request.queryParams("id_Building"));	
			}Base.close();
                         return "El Duenio Inmueble ha sido modificado exitosamente";			
		}
   	});

                //////-----Dar de baja un dueño de Inmueble------/////////
        Spark.get(new Route("userType/mainOwnerBuilding/deleteOwnerBuilding/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
		return "" + 
                    "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                    "<form method = 'POST' action='/deleteOwnerBuilding/'  >"+
                    "Id OwnerBuilding: <input name='id'><P>"+                                
                    "<input type='submit' value='Delete'>"+
                    "<input type='reset' value='Delete'></form>";			
	    }
	});

	Spark.post(new Route ("userType/mainOwnerBuilding/deleteOwnerBuilding/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
		OwnerBuilding ob=new OwnerBuilding();
                
                if(ob==null){
                    response.status(500);
		}else{
                    DueñoInmueble.eliminar(request.queryParams("id"));
                }Base.close();
            return "el Duenio de inmueble fue dado de baja exitosamente";    
            }
   	});
                //////----- End-Delete OwnerBuilding------//////


        ///////////////////////------------END OWNER BUILDING--------///////////////////////////////
        
        ///////////////////////------------BUILDING------------------///////////////////////////////
                    //////////--------Listar un Inmueble----////////////
        Spark.get(new Route("userType/mainOwnerBuilding/building/:id") {
     		@Override
  		public Object handle(Request request, Response response) {
  			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
     			Building building = Building.findFirst("id = ?", request.params(":id"));
                        Base.close();

        	
    			 if (building != null ){
  	   			
                             return "City: "+building.get("city")+"Neigberhood: "+building.get("neighborhood")+"Street: "+building.get("street")+"Descriptive Text: "+building.get("descriptive_text");

                         }else{
  	   			response.status(404);
  	   			return "Inmueble not found";
     			}
     		}
	});
        
                    ///////------Listar todos los Inmuebles----/////////////
        Spark.get(new Route("userType/mainOwnerBuilding/listBuildings/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");
	     		Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Building ob=new Building();	     		
			List <Building>building = Building.findAll();
			String result ="";
			for (int i=0;i<building.size();i++){
				ob = building.get(i);
				result = result +"<ol>"+ "city: "+ob.get("city")+"neighborhood: "+ob.get("neighborhood")+"street"+ob.get("street")+"descriptive text"+ob.get("descriptive_text")+"</ol>";
                        }
			Base.close();
			return result;			
	    	}
	});
        
                    //////------Agregar un Inmueble////////////////
        Spark.get(new Route("userType/mainOwnerBuilding/addBuilding/") {
     	@Override
            public Object handle(Request request, Response response) {
            response.type("text/html");	     					
            return "" +
                "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                "<form method = 'POST' action='/addBuilding/'  >"+
                "City: "+"<input name='city'><P>"+        
                "neighborhood: <input name='neighborhood'><P>"+
     		"Street: <input name='street'><P>"+
                "Descriptive Text: <br><textarea name='descriptive_text'cols='100'raws='20'>Ingrese su texto!</textarea>"+"<br>"+"<br>"+
                "Price: <input name='price'><P>"+
                "id_situation: <input name='id_situation'><P>"+  
                "iD owner Building: <input name='id_ownersBuilding'><P>"+   
                "ID Type: <input name='id_isType'><P>"+
                "ID Real State: <input name='id_realstate'><P>"+       
     		"<input type='submit' value='Add'>"+
     		"<input type='reset' value='Reset'></form>";			
	    }
	});
        
        Spark.post(new Route ("userType/mainOwnerBuilding/addBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Inmueble.insertar(request.queryParams("city"), request.queryParams("neighborhood"),request.queryParams("street"),request.queryParams("descriptive_text"),request.queryParams("price"),request.queryParams("id_situation"),request.queryParams("id_ownersBuilding"),request.queryParams("id_isType"),request.queryParams("id_realstate"));
                        Base.close();
                return "Nuevo inmueble agregado";	
		}
   	});
        
                ///////////////------Dar de baja un Inmueble--------/////////////////	
        Spark.get(new Route("userType/mainOwnerBuilding/deleteBuilding/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
		return "" +
                    "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                    "<form method = 'POST' action='/deleteBuilding/'  >"+
                    "Id Building: <input name='id'><P>"+                                
                    "<input type='submit' value='Delete'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("userType/mainOwnerBuilding/deleteBuilding/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                Building b=new Building();
                if(b==null){
                    response.status(500);			
		}else{
                    Inmueble.eliminar(request.queryParams("id"));
                }Base.close();
            return "El inmueble ha sido dado de baja exitosamente";    
            }
   	});
                    /////// ------End-Delete Building--------/////////
                    ///////-------Change Building----------/////////
        Spark.get(new Route("userType/mainOwnerBuilding/changeBuilding/") {
        @Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
                return "" +
                    "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                    "<form method = 'POST' action='/changeBuilding/'>"+	
                    "Id: <input name='id'><P>"+
                    "City: <input name='city'><P>"+
                    "Neighborhood: <input name='neighborhood'><P>"+
                    "Street: <input name='street'><P>"+
                    "Descriptive Text: <br><textarea name='descriptive_text'cols='100'raws='20'>Ingrese su texto!</textarea>"+"<br>"+"<br>"+				
                    "price: <input name='price'><P>"+
                    "id_situation: <input name='situation'><P>"+
                    "id_ownersBuilding: <input name='id_ownersBuilding'><P>"+
                    "id_isType: <input name='id_isType'><P>"+
                    "Id real state: <input name='id_realstate'><P>"+
                    "<input type='submit' value='Change'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("userType/mainOwnerBuilding/changeBuilding/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
                        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Building b=new Building();
			b=Building.findById(request.queryParams("id"));
			if(b==null){
                            response.status(500);
                            return("Inmueble no encontrado");			
			}else{         
 Inmueble.modificar(request.queryParams("id"),request.queryParams("city"),request.queryParams("neighborhood"),request.queryParams("street"), request.queryParams("descriptive_text"),request.queryParams("price"),request.queryParams("id_isType"),request.queryParams("situation"),request.queryParams("id_ownersBuilding"),request.queryParams("id_realstate"));
                        }Base.close();
                return "El Inmueble ha sido modificado exitosamente";		
		}
   	});
        ////////////////////////---------END BUILDING---------------////////////////////////////////  
        
        ///////////////////////----------ANUNCIO (AD)--------------////////////////////////////////
                            /////----Listar un Anuncio por ID---/////////
        Spark.get(new Route("userType/mainOwnerBuilding/ad/:id") {
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
        Spark.get(new Route("userType/mainOwnerBuilding/listAds/") {
     	@Override
     		public Object handle(Request request, Response response) {
                    response.type("text/html");
                    Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                    Ad ad=new Ad();	     		
                    List <Ad>ads = Ad.findAll();
                    String result ="";
                        for (int i=0;i<ads.size();i++){
                            ad = ads.get(i);
                            result = result +"<ol>"+ "id: "+ad.get("id")+"descriptive_ text: "+ad.get("descriptive_text")+"</ol>";
                        }
                    Base.close();
                    return result;			
	    	}
	});
        
                    /////-----Agregar un Inmueble------//////////
        Spark.get(new Route("userType/mainOwnerBuilding/addAd/") {
     	@Override
            public Object handle(Request request, Response response) {
            response.type("text/html");	     					
            return "" +
                "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                "<form method = 'POST' action='/addAd/'  >"+
                "Descriptive Text: <br><textarea name='descriptive_text'cols='100'raws='20'>Ingrese su texto!</textarea>"+"<br>"+"<br>"+        
                "ID Building: <input name='id_Building'><P>"+
     		"ID Owner Building: <input name='id_ownersBuilding'><P>"+
                "ID Real State: <input name='id_realstate'><P>"+       
     		"<input type='submit' value='Add'>"+
     		"<input type='reset' value='Reset'></form>";			
	    }
	});
        
        Spark.post(new Route ("userType/mainOwnerBuilding/addAd/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");				
			Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Anuncio.insertar(request.queryParams("descriptive_text"), request.queryParams("id_Building"),request.queryParams("id_ownersBuilding"),request.queryParams("id_realstate"));
                        Base.close();
                return "Nuevo Anuncio agregado";	
		}
   	});


                        ////----Modificar un Anuncio-----////////
        Spark.get(new Route("userType/mainOwnerBuilding/changeAds/") {
     	@Override
     		public Object handle(Request request, Response response) {
			response.type("text/html");	     					
			return "" +
                        "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+        
			"<form method = 'POST' action='/changeAds/'  >"+ 
     			"Id: <input name='id'><P>"+
                        "Descriptive Text: <br><textarea name='descriptive_text'cols='100'raws='20'>Ingrese su texto!</textarea>"+"<br>"+"<br>"+                                
    			"id Owner Building: <input name='id_ownersBuilding'><P>"+ 
     			"id Buildng: <input name='id_Building'><P>"+                                
     			"id RealState: <input name='id_realstate'><P>"+
     			"<input type='submit' value='Change'>"+
     			"<input type='reset' value='Reset'></form>";			
	    	}
	});
        
        Spark.post(new Route ("userType/mainOwnerBuilding/changeAds/"){
	@Override
		public Object handle(Request request, Response response) {
			response.type("text/html");
                        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
			Anuncio a =new Anuncio();
			Ad ad=new Ad();
			ad=Ad.findById(request.queryParams("id"));
			if(ad==null){
                            response.status(500);
                            return("Anuncio no encontrado");
			}else{
                            Anuncio.modificar(request.queryParams("id"),request.queryParams("descriptive_text"),request.queryParams("id_Building"),request.queryParams("id_ownersBuilding"),request.queryParams("id_realstate"));
                        }Base.close();
                        return "el anuncio fue modificado exitosamente";
		}
   	});

        
                        ////-----Dar de baja un Anuncio------//////
        Spark.get(new Route("userType/mainOwnerBuilding/deleteAd/") {
     	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");	     					
		return "" + 
                    "<body background = 'http://us.123rf.com/400wm/400/400/evok20/evok200807/evok20080700026/3351610-el-centro-de-la-ciudad-de-edificios-modernos-y-arquitectura-corporativa.jpg'>"+    
                    "<form method = 'POST' action='/deleteAd/'  >"+
                    "Id Anuncio: <input name='id'><P>"+                                
                    "<input type='submit' value='Delete'>"+
                    "<input type='reset' value='Reset'></form>";			
	    }
	});

	Spark.post(new Route ("userType/mainOwnerBuilding/deleteAd/"){
	@Override
            public Object handle(Request request, Response response) {
                response.type("text/html");
                Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/inmoapp_development", "root", "root");
                Ad ad=new Ad();		
                ad=Ad.findById(request.queryParams("id"));
                if(ad==null){
                    response.status(500);
		}
		Anuncio.eliminar(request.queryParams("id"));
                Base.close();
            return "El Anuncio fue dado de baja Correctamente";
            }
   	});
                    /////------ End-Delete Ad------////////

	        ///////////////////////////// ----END ANUNCIO(AD)-----////////////////////////////////////////	
   }
   
   ////////////////////////////////////////////end maianOwnerBuilding/////////////////////////////////////
   
   
   
}
