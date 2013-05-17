package main.com.unrc.app.models;

import org.javalite.activejdbc.Model;

public class Building extends Model {
  static{
      validatePresenceOf("city","street","neighborhood","descriptive_text","price","isType","situation","id_realState","id_ownerBuilding");
  }
} 
