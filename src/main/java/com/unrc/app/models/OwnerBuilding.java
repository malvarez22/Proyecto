package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class OwnerBuilding extends Model {
  static{
      validatePresenceOf("id","first_name", "last_name","city","neighborhood","street","email","phone_number","id_building","id_realstate");
  }
  static{
      validateEmailOf("email");
  }
  static{
	  validateNumericalityOf("phone_number");
	    }
}

