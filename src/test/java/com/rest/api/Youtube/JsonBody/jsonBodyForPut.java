package com.rest.api.Youtube.JsonBody;

import org.json.JSONObject;

public class jsonBodyForPut {

    public static JSONObject getJsonObjectForUpdatePlaylist() {
        JSONObject requestBody = new JSONObject();

        JSONObject snippetObject = new JSONObject();
        snippetObject.put("title", "APITestPlaylist");
        snippetObject.put("description", "PostmanUzerindenDegistirildi");

        requestBody.put("snippet", snippetObject);
        requestBody.put("id", "PLor2Dqjhz6W8NDmt7UA8WoyZZlOLKny76");
        System.out.println(requestBody.toString());

        return requestBody;
    }

}
