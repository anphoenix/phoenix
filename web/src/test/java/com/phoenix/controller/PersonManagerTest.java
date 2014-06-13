package com.phoenix.controller;

import com.google.gson.JsonObject;
import junit.framework.TestCase;
import org.junit.Test;

public class PersonManagerTest extends TestCase {

    @Test
    public void testGetPersonInfobyID() throws Exception {

        JsonObject person ;
        person = PersonManager.getPersonInfobyID("10457");
        System.out.println(person.toString());
    }
}