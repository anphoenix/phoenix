package com.phoenix.controller;

import com.anphoenix.data.persistent.hbase.HBaseUtil;
import com.anphoenix.data.persistent.hbase.ResultHandler;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;


public class PersonManager {

	public static JsonArray getAllPersons(){
		final JsonArray array = new JsonArray();

		// query all persons info from hbase

		return array;
	}
	public static JsonObject getPersonInfobyID(String id){
		
		final JsonObject person = new JsonObject();
		
		// query the info from Hbase
        ResultHandler handler = new ResultHandler(){
            @Override
            public void process(Result rs) {
                if(rs.isEmpty()) {
                    System.out.println("No query result found");
                    return;
                }
                for (Cell cell : rs.listCells()) {
                    person.addProperty(Bytes.toString(CellUtil.cloneQualifier(cell)),
                            Bytes.toString(CellUtil.cloneValue(cell)));
                }
            }
        };
        try {
            HBaseUtil.getResult("Person", id, handler);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return person;
	}
}
