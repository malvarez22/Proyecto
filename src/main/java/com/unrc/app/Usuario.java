/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;

import com.unrc.app.models.User;/**
 *
 * @author matias
 */
public class Usuario{
//metodos insertar,modificar,eliminar dueño inmobiliaria    
	
	public static void insertar(String email,String first_name,String last_name, String password){
		User user=new User();
                user.set("email",email);                
		user.set("first_name",first_name);
		user.set("last_name",last_name);
                user.set("password",password);
		user.saveIt();			
	}

	
	
	public static void modificar(String id,String email,String first_name, String last_name, String password){
		User user=new User();
		user=User.findById(id);
		if (user!=null){
			user.set("email",email);
                        user.set("first_name",first_name);
                        user.set("last_name",last_name);
                        user.set("password",password);
			user.saveIt();
                }		
	}
	
	public static void eliminar(String id){
		User user=new User();
		user=User.findById(id);
		if (user!=null){
		user.deleteCascade();
		}

	}
}	
	
