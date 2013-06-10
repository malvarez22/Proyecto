package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Owner extends Model {
  static{
      validatePresenceOf("first_name", "last_name","city","phone_number","neighborhood","street","email","id_realstates");
  }
  //check email format
  static{
      validateEmailOf("email");
  }
  static{
	  validateNumericalityOf("phone_number");
	    }
}