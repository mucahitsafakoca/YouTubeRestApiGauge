package com.rest.api.Youtube.steps;

import com.rest.api.Youtube.helper.subscriptionHelper;
import com.rest.api.Youtube.utils.parametres;
import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class delete {

    @Step("Unsubscribe")
    public void unsubscribe() {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .queryParam("id", "R1bDLO5dAKxb_1U6piaNxp8oZUlj0oi1bAEYjnRL0AU")
                .delete("/subscriptions");

        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 204, "Status code should be 204 but it's not");

    }
    @Step("Unsubscribe from channel")
    public void unsubscribeChannel() {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;

        String subscriptionId = subscriptionHelper.getSubscriptionId(); // Abonelik kimliğini alın

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .queryParam("id", subscriptionId)
                .delete("/subscriptions");

        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 204, "Status code should be 204 but it's not");


    }
    @Step("DeletePlaylist")
    public void delPlaylist() {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;
        String subId = subscriptionHelper.getSubscriptionId();

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .queryParam("id",subId)
                .delete("/playlists");

        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 204, "Status code should be 204 but it's not");

    }
}




