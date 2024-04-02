package com.rest.api.Youtube.helper;

public class videosChannelId {
    public static String channelIdForSearchedVide;

    public static void setChannelId(String cId){
        channelIdForSearchedVide = cId;
    }

    public static String getChannelId(){
        return channelIdForSearchedVide;
    }
}
