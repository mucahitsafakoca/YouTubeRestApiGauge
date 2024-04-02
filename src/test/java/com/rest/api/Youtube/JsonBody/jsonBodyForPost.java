package com.rest.api.Youtube.JsonBody;

import com.rest.api.Youtube.helper.contentFinderHelper;
import com.rest.api.Youtube.helper.searchedVideoHelper;
import com.rest.api.Youtube.helper.videosChannelId;
import org.json.JSONObject;

public class jsonBodyForPost {
    public static JSONObject getJsonObjectForSubscribe(String channelId) {
        JSONObject requestBody = new JSONObject();
        JSONObject snippetObject = new JSONObject();
        JSONObject resourceIdObject = new JSONObject();

        resourceIdObject.put("channelId", channelId);
        snippetObject.put("resourceId", resourceIdObject);
        requestBody.put("snippet", snippetObject);

        System.out.println(requestBody.toString());

        return requestBody;
    }

    public static JSONObject getJsonObjectForSearchedSubscribe() {
        String channelId = contentFinderHelper.getChannelId();

        JSONObject requestBody = new JSONObject();
        JSONObject snippetObject = new JSONObject();
        JSONObject resourceIdObject = new JSONObject();

        resourceIdObject.put("channelId", channelId);
        snippetObject.put("resourceId", resourceIdObject);
        requestBody.put("snippet", snippetObject);

        System.out.println(requestBody.toString());

        return requestBody;
    }
    public static JSONObject getJsonObjectForComment() {
        String vId = searchedVideoHelper.getVideoId();
        String cId = videosChannelId.getChannelId();


        JSONObject requestBody = new JSONObject();
        JSONObject snippetObject = new JSONObject();
        JSONObject topLevelCommentObject = new JSONObject();
        JSONObject commentSnippetObject = new JSONObject();


        commentSnippetObject.put("videoId", vId);
        commentSnippetObject.put("textOriginal", "benbiryumurtayım");

        snippetObject.put("channelId", cId);
        topLevelCommentObject.put("snippet", commentSnippetObject);
        snippetObject.put("topLevelComment", topLevelCommentObject);

        requestBody.put("snippet", snippetObject);
        return requestBody;
    }

    public static JSONObject getJsonObjectForPlaylist() {
        JSONObject requestBody = new JSONObject();
        JSONObject snippetObject = new JSONObject();
        JSONObject statusObject = new JSONObject();

        snippetObject.put("title", "APITestPlaylist");
        snippetObject.put("description", "Bu listeyi deneme amacli olusturuyorum");

        statusObject.put("privacyStatus", "public");

        requestBody.put("snippet", snippetObject);
        requestBody.put("status", statusObject);

        return requestBody;
    }

    public static JSONObject getJsonObjectForPlaylistItem() {


        JSONObject requestBody = new JSONObject();

        JSONObject resourceIdObject = new JSONObject();
        resourceIdObject.put("videoId", "XP0KA3U3Kyc");
        resourceIdObject.put("kind", "youtube#video");

        JSONObject snippetObject = new JSONObject();
        snippetObject.put("playlistId", "PLor2Dqjhz6W8NDmt7UA8WoyZZlOLKny76");
        snippetObject.put("resourceId", resourceIdObject);

        requestBody.put("snippet", snippetObject);

        System.out.println(requestBody.toString());

        return requestBody;

    }
}
