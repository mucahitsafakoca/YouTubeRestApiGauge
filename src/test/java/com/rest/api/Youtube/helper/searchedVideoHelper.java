package com.rest.api.Youtube.helper;

public class searchedVideoHelper {
    private static String videoId;

    public static void setVideoId(String vId) {
        videoId = vId;
    }

    public static String getVideoId() {
        return videoId;
    }
}

