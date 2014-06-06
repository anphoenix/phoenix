package com.ibm.bluemix.phoenix.controller;



import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class PersonManager {

	public static JsonArray getAllPersons(){
		final JsonArray array = new JsonArray();
		
		// query all persons info from hbase
		
		return array;
	}
	public static JsonObject getPersoninfobyID(String id){
		
		final JsonObject person = new JsonObject();
		
		// query the info from Hbase
		
		// demo data
		person.addProperty("id", "12345");
		person.addProperty("gender", "女");
		person.addProperty("age", "26");
		person.addProperty("region", "北京");
		person.addProperty("constellation", "摩羯");
		person.addProperty("education", "硕士");
		person.addProperty("institutions", "东北大学");
		person.addProperty("company", "IBM");
		person.addProperty("position", "工程师");
		person.addProperty("income", "中等");
		
		return person;
	}
}
