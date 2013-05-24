package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Building extends Model {
  static{
      validatePresenceOf("city","neighborhood","street","descriptive_text","price","id_situation","id_ownersBuilding","id_isType");
  }
  static{
	  int min = 1, max =5;
      validateRange("id_isType", min, max).message("Type cannot be less than " + min + " or more than " + max);
	    }
  static{
	  int min = 1, max = 2;
	  validateRange("id_situation", min, max).message("Situation cannot be less than " + min + " or more than " + max);
  }
} 
