package com.rest.api.Youtube.steps;

import com.rest.api.Youtube.utils.parametres;
import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import static com.rest.api.Youtube.JsonBody.jsonBodyForPut.getJsonObjectForUpdatePlaylist;
import static io.restassured.RestAssured.given;

public class put {

    @Step("PlaylistUpdate")
    public void updatePlaylist() {
        JSONObject requestBody = getJsonObjectForUpdatePlaylist();
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;
        System.out.println(requestBody.toString(4));

        Response response = given().
                when().
                header("Authorization", "Bearer " + accessToken).
                header("Content-Type", "application/json").
                queryParam("part", "id", "snippet").
                body(requestBody.toString(4)).
                put("/playlists");
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);


    }
}
