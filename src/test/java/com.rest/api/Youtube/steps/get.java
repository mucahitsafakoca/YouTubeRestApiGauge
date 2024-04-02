package com.rest.api.Youtube.steps;

import com.rest.api.Youtube.helper.searchedVideoHelper;
import com.rest.api.Youtube.helper.videosChannelId;
import com.rest.api.Youtube.utils.parametres;
import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;


public class get {
    @Step("Search <query> with Token")
    public void searchWithToken(String query) {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .param("part", "snippet")
                .param("type", "video")
                .param("videoCaption", "closedCaption")
                .param("q", query)
                .param("maxResults", 1)
                .when()
                .get("/search");

        String videoId = response.jsonPath().getString("items[0].id.videoId");
        searchedVideoHelper.setVideoId(videoId);

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");


        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }
    @Step("Search <query> for channelId with Token")
    public void searchWithTokentogetchannelId(String query) {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;

        Response response = RestAssured.given()
                .header("Authorization", "Bearer " + accessToken)
                .param("part", "snippet")
                .param("type", "video")
                .param("videoCaption", "closedCaption")
                .param("q", query)
                .param("maxResults",1)
                .when()
                .get("/search");

        String videoId = response.jsonPath().getString("items[0].id.videoId");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body:" + responseBody);

        videosChannelId.setChannelId(videoId);
    }


    @Step("Search <query> with API Key")
    public void searchWithKey(String query) {
        RestAssured.baseURI = parametres.baseURI ;
        String  apiKey= parametres.apiKey;

        Response response = RestAssured.given()
                .param("key", apiKey)
                .param("q", query)
                .param("type", "video")
                .param("videoCaption", "closedCaption")
                .param("part", "snippet")
                .when()
                .get("/search");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }

    @Step("Get channel with channelId : <query>")
    public void getChannel(String query) {
        RestAssured.baseURI = parametres.baseURI ;
        String apiKey= parametres.apiKey;
        String channelId = parametres.channelId;


        Response response = RestAssured.given()
                .param("key", apiKey)
                .param("part", "snippet,id,statistics")
                .param("id", channelId)
                .when()
                .get("/channels");
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");


        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }
    @Step("Get channel with searched contents response channelId")
    public void getChannel(){
        RestAssured.baseURI = parametres.baseURI ;
        String apiKey= parametres.apiKey;
        String cId = videosChannelId.getChannelId();

        Response response = RestAssured.given()
                .param("key", apiKey)
                .param("part", "snippet,id,statistics")
                .param("id", cId)
                .when()
                .get("/channels");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");


        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }

    @Step("Kullanıcının oluşturulmuş playlistlerini görüntüle")
    public void listPlaylist() {
        RestAssured.baseURI = parametres.baseURI ;
        String accessToken = parametres.accessToken;

        Response response = RestAssured.given()
                .param("part", "id,snippet")
                .param("mine", true)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/playlists");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

    }
    @Step("List Playlists of a channel")
    public void listChannelsPlaylist() {
        RestAssured.baseURI = parametres.baseURI;
        String accessToken = parametres.accessToken;
        String cId = videosChannelId.getChannelId();

        Response response = RestAssured.given()
                .param("part", "id,snippet")
                .param("channelId", cId)
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("/playlists");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }
    @Step("API key kullanarak playlistId'si : <query> olan listedeki videoları listede")
    public void listPlaylistItems(String query) {
        RestAssured.baseURI = parametres.baseURI ;
        String playlistId = parametres.playlistId;
        String  apiKey= parametres.apiKey;

        Response response = RestAssured.given()
                .param("part", "id,snippet")
                .param("playlistId", playlistId)
                .param("key", apiKey)
                .when()
                .get("/playlistItems");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200 but it's not");

        int statusCode = response.getStatusCode();
        System.out.println("Response Status Code: " + statusCode);

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }


}
