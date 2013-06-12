package com.unrc.app.models;

import org.javalite.activejdbc.Model;
//validan datos tabla user
public class User extends Model {
  static{
      validatePresenceOf("email","first_name", "last_name","password");
  }  
  static{
      validateEmailOf("email");
  }
}