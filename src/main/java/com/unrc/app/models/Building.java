package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Building extends Model {
  static{
      validatePresenceOf("city","street","neighborhood","descriptive_text","price","id_isType","id_situations","id_ownersBuilding");
  }
  static{
	  int min = 1, max =5;
      validateRange("id_isType", min, max).message("Type cannot be less than " + min + " or more than " + max);
	    }
  static{
	  int min = 1, max = 2;
	  validateRange("id_situations", min, max).message("Situation cannot be less than " + min + " or more than " + max);
  }
} 
