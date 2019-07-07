package com.mygdx.game.Outils;


public interface GoogleServices {
    boolean hasVideoLoaded();
    void loadRewardedVideoAd();
    void showRewardedVideoAd();
    void setVideoEventListener(VideoEventListener listener);
    boolean hasVideoViewed();
    boolean hasVideoClosed();
    void setIs_video_ad_viewed(boolean is_video_ad_viewed);
    void setIs_video_ad_closed(boolean is_video_ad_closed);
    boolean isWifiConnected();
}
