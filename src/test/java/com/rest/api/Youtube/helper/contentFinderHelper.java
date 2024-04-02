package com.rest.api.Youtube.helper;

public class contentFinderHelper {
    public static String channelIdResponse;
    public static void setChannelId(String cId){
        channelIdResponse = cId;
    }
    public static String getChannelId(){
        return channelIdResponse;
    }
}
