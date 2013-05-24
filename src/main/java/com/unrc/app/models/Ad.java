package com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Ad extends Model {
  static{
      validatePresenceOf("descriptive_text","id_Building","id_ownerBuilding");
  }
} 
