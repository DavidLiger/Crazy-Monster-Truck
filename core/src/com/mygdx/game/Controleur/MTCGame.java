package com.mygdx.game.Controleur;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.mygdx.game.Outils.GoogleServices;
import com.mygdx.game.Outils.Translator;
import com.mygdx.game.Outils.VideoEventListener;
import com.mygdx.game.Vue.SplashPreLoadingScreen;

public class MTCGame extends Game implements VideoEventListener {
	private final AssetManager assetManager = new AssetManager();
	private SpriteBatch batch;
	private Preferences prefs;
    private GoogleServices googleServices;
    private int maxVideoPerPeriod = 10;
    private long periodBeforeNewVideos = 7200000;
    private long periodCycleRefreshNbVideos = 7200000;
    private Translator trad = new Translator();

    public MTCGame (GoogleServices googleServices){
        if(googleServices != null){
            this.googleServices = googleServices;
            this.googleServices.setVideoEventListener(this);
        }
    }

    @Override
	public void create () {

		Box2D.init();
		batch = new SpriteBatch();
		prefs = Gdx.app.getPreferences("MyPrefs");
		assetManager.setLoader(TiledMap.class,new TmxMapLoader(new InternalFileHandleResolver()));
		setScreen(new SplashPreLoadingScreen(this, batch));

//		reinitializer();
	}

    public void showRewardedVideoAd(){
        if(this.googleServices.hasVideoLoaded()) {
            this.googleServices.showRewardedVideoAd();
        }
    }
    @Override
    public void onRewardedEvent(String type, int amount) {
        // player has just finished the video and was rewarded
        type = "coins;";amount = 10;
    }

    @Override
    public void onRewardedVideoAdLoadedEvent() {
        // video is ready and can be presented to the player

    }

    @Override
    public void onRewardedVideoAdClosedEvent() {
        // player has closed the video so no reward for him


    }


    private void reinitializer(){
		prefs.putBoolean("pilote3Paid",false).flush();
		prefs.putBoolean("pilote4Paid",false).flush();
        prefs.putBoolean("pilote5Paid",false).flush();
        prefs.putBoolean("pilote6Paid",false).flush();
        prefs.putBoolean("pilote7Paid",false).flush();
        prefs.putBoolean("pilote8Paid",false).flush();
        prefs.putBoolean("pilote9Paid",false).flush();
        prefs.putBoolean("pilote10Paid",false).flush();
        prefs.putBoolean("pilote11Paid",false).flush();
        prefs.putBoolean("pilote12Paid",false).flush();

		prefs.putBoolean("vehicule3Paid",false).flush();
		prefs.putBoolean("vehicule4Paid",false).flush();
		prefs.putBoolean("vehicule5Paid",false).flush();
		prefs.putBoolean("vehicule6Paid",false).flush();
		prefs.putBoolean("vehicule7Paid",false).flush();
		prefs.putBoolean("vehicule8Paid",false).flush();
		prefs.putBoolean("vehicule9Paid",false).flush();
		prefs.putBoolean("vehicule10Paid",false).flush();
		prefs.putBoolean("vehicule11Paid",false).flush();
		prefs.putBoolean("vehicule12Paid",false).flush();
        prefs.putBoolean("vehicule13Paid",false).flush();

		prefs.putBoolean("circuit3Paid",false).flush();
		prefs.putBoolean("circuit4Paid",false).flush();
		prefs.putBoolean("circuit5Paid",false).flush();
		prefs.putBoolean("circuit6Paid",false).flush();
		prefs.putBoolean("circuit7Paid",false).flush();
		prefs.putBoolean("circuit8Paid",false).flush();
		prefs.putBoolean("circuit9Paid",false).flush();
		prefs.putBoolean("circuit10Paid",false).flush();
		prefs.putBoolean("circuit11Paid",false).flush();
		prefs.putBoolean("circuit12Paid",false).flush();

		prefs.putInteger("money",0).flush();
		prefs.putInteger("argentMax",0).flush();

        prefs.putInteger("headChoice",0).flush();
        prefs.putInteger("vehiculeChoice",0).flush();
        prefs.putInteger("groundChoice",0).flush();

        prefs.putInteger("precedentHeadChoice",99).flush();
        prefs.putInteger("precedentVehiculeChoice",99).flush();
        prefs.putInteger("precedentGroundChoice",99).flush();

        prefs.putInteger("vehiculeRoueCustom",0).flush();
		prefs.putInteger("vehiculeMoteurCustom",0).flush();
		prefs.putInteger("vehiculeChassisCustom",0).flush();

        prefs.putInteger("vehiculeRoueCustomImage",0).flush();
        prefs.putInteger("vehiculeMoteurCustomImage",0).flush();
        prefs.putInteger("vehiculeChassisCustomImage",0).flush();

		prefs.putInteger("nbTropheeRoue",0).flush();
        prefs.putInteger("nbTropheeDollar",0).flush();
        prefs.putInteger("nbTropheeBonus",0).flush();

		prefs.putBoolean("customVehicule",false).flush();
		prefs.putInteger("nbVideoViewed", 0).flush();
        prefs.putBoolean("videoViewedLimit", false).flush();
        prefs.putLong("VVLimitTimeStart",0).flush();
        if(googleServices != null){
            googleServices.setIs_video_ad_closed(false);
        }
	}

    public AssetManager getAssetManager() {
        return assetManager;
    }

    public Preferences getPrefs() {
        return prefs;
    }

    public GoogleServices getGoogleServices() { return googleServices; }

    public Translator getTrad() { return trad; }

    public int getMaxVideoPerPeriod() {
        return maxVideoPerPeriod;
    }

    public long getPeriodBeforeNewVideos() {
        return periodBeforeNewVideos;
    }

    public long getPeriodCycleRefreshNbVideos() {
        return periodCycleRefreshNbVideos;
    }
}
