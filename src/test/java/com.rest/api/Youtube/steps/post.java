package com.rest.api.Youtube.steps;

import com.rest.api.Youtube.helper.contentFinderHelper;
import com.rest.api.Youtube.helper.searchedVideoHelper;
import com.rest.api.Youtube.helper.subscriptionHelper;
import com.rest.api.Youtube.utils.parametres;
import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import static com.rest.api.Youtube.JsonBody.jsonBodyForPost.*;
import static io.restassured.RestAssured.given;


public class post {

    @Step("Subscribe to channel that has Id as : <query>")
    public void subscribeToChannel(String query) {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;
        JSONObject requestBody = getJsonObjectForSubscribe(query);

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("part", "snippet")
                .body(requestBody.toString())
                .when()
                .post("/subscriptions");

        String id = response.jsonPath().getString("id");
        subscriptionHelper.setSubscriptionId(id);
        String channelIdResponse = response.jsonPath().getString("snippet.resourceId.channelId");
        contentFinderHelper.setChannelId(channelIdResponse);

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }
    @Step("Subscribe to channel that has Id as")
    public void subscribeToChannel() {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;
        JSONObject requestBody = getJsonObjectForSearchedSubscribe();

        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("part", "snippet")
                .body(requestBody.toString())
                .when()
                .post("/subscriptions");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }

    @Step("Like a video that has Id as : <query>")
    public void likeVideo(String videoId) {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("rating", "like")
                .queryParam("id", videoId)
                .when()
                .post("/videos/rate");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }
    @Step("Like searched video")
    public void likeListedVideo() {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;
        String vId = searchedVideoHelper.getVideoId();

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("rating", "like")
                .queryParam("id", vId)
                .when()
                .post("/videos/rate");
        Assert.assertEquals(response.getStatusCode(), 204, "Status code should be 204 but it's not");


        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);


        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }


    @Step("Dislike a video that has Id as : <query>")
    public void dislikeVideo(String videoId) {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("rating", "dislike")
                .queryParam("id", videoId)
                .when()
                .post("/videos/rate");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }

    @Step("Remove rate for a video that has Id as : <query>")
    public void removeVideoRate(String videoId) {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .queryParam("rating", "none")
                .queryParam("id", videoId)
                .when()
                .post("/videos/rate");


        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);


    }

    @Step("Comment")
    public void comment() {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;

        JSONObject requestBody = getJsonObjectForComment();

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .queryParam("part", "snippet")
                .body(requestBody.toString())
                .post("/commentThreads");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }


    @Step("Create Playlist")
    public void createPlaylist() {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;
        JSONObject requestBody = getJsonObjectForPlaylist();
        System.out.println(requestBody.toString(4));

        Response response = given().
                when()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .queryParam("part", "snippet", "status") // Parametre olarak ekleniyor
                .body(requestBody.toString(4))
                .post("/playlists");

        String id = response.jsonPath().getString("id");
        subscriptionHelper.setSubscriptionId(id);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);


    }


    @Step("CreatePlaylistItem")
    public void createPlaylistItem() {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;
        JSONObject requestBody = getJsonObjectForPlaylistItem();
        System.out.println(requestBody.toString(4));


        Response response = given().
                when()
                .header("Authorization", "Bearer " + accessToken)
                .header("Content-Type", "application/json")
                .queryParam("part", "snippet,Id")
                .body(requestBody.toString(4))
                .post("/playlistItems");


        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);


    }

}