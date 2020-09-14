package com.asopaps.asopaps.persistence;

import java.util.ArrayList;

import com.duseni.duseni.entities.Member;
import com.duseni.duseni.entities.Request;
import com.duseni.duseni.entitiesPruebas.MemberSerializer;
import com.duseni.duseni.entitiesPruebas.RequestSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import antlr.collections.List;

/**
 * clase que se encarga del manejo que se necesite de JSONs
 * @author Cesar
 *
 */
public class JsonManager {

	/**
	 * metodo que combierte cualquier objeto a un string json
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd-HH:mm:ss").create(); //formato especial para la fecha en la que se retorna el objeto en forma de json
		return gson.toJson(obj);
	}
	
	
	
	/*Register custom serializer of Product object*/
	public static String simpleJsonWithCustomSerialization(Member member){
	  GsonBuilder gsonBuilder = new GsonBuilder();
	  gsonBuilder.registerTypeAdapter(Member.class, new MemberSerializer()).setPrettyPrinting();
	  Gson gson = gsonBuilder.create();
	  String json = gson.toJson(member);
	  System.out.println(json);
	  return json;
	}
	
	
	
	
	/*Register custom serializer of Product object*/
	public static String getPedios(Iterable<Request> request){
	  GsonBuilder gsonBuilder = new GsonBuilder();
	  gsonBuilder.registerTypeAdapter(Request.class, new RequestSerializer()).setPrettyPrinting();
	  Gson gson = gsonBuilder.create();
	  String json = gson.toJson(request);
	  System.out.println(json);
	  return json;
	}
	
	
	public static String toJson2(Object obj) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd-HH:mm:ss").create(); //formato especial para la fecha en la que se retorna el objeto en forma de json
		
		
		
		return gson.toJson(obj);
	}
	
}
