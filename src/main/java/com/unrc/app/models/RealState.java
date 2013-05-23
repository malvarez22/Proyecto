package com.unrc.app.models;


import org.javalite.activejdbc.Model;
public class RealState extends Model {
  static{
      validatePresenceOf("first_name", "city","neighborhood","street","phone_number","email","WebSite");
  }
  
  static{
	  validateNumericalityOf("phone_number")
	 .allowNull(true).greaterThan(0)
     .lessThan(25).onlyInteger()
     .message("incorrect 'Phone_number'");
	    }	 	    
}
