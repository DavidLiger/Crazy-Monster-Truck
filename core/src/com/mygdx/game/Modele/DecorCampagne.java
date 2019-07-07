package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorCampagne implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorCampagne/exitScreenBackground-Campagne.png";

    public DecorCampagne(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("Campagne-Country-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorCampagne/mapCampagne.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorCampagne/Paysage-Campagne.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorCampagne/AP-MTC-Campagne.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorCampagne/exitScreenBackground-Campagne.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorCampagne/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorCampagne/SolDepart.png",Texture.class);

        assetsReferences.add("Campagne-Country-Music.mp3");assetsReferences.add("textures DecorCampagne/mapCampagne.tmx");
        assetsReferences.add("textures DecorCampagne/Paysage-Campagne.png");assetsReferences.add("textures DecorCampagne/AP-MTC-Campagne.png");
        assetsReferences.add("textures DecorCampagne/sky.png");
        assetsReferences.add("textures DecorCampagne/SolDepart.png");

        solTexturesReferences.add("textures DecorCampagne/Sol1.png");solTexturesReferences.add("textures DecorCampagne/Sol2.png");
        solTexturesReferences.add("textures DecorCampagne/Sol3.png");solTexturesReferences.add("textures DecorCampagne/Sol4.png");
        solTexturesReferences.add("textures DecorCampagne/Sol5.png");solTexturesReferences.add("textures DecorCampagne/Sol6.png");
        solTexturesReferences.add("textures DecorCampagne/Sol7.png");solTexturesReferences.add("textures DecorCampagne/Sol8.png");
        solTexturesReferences.add("textures DecorCampagne/Sol9.png");solTexturesReferences.add("textures DecorCampagne/Sol10.png");
        solTexturesReferences.add("textures DecorCampagne/Sol11.png");solTexturesReferences.add("textures DecorCampagne/Sol12.png");
        solTexturesReferences.add("textures DecorCampagne/Sol13.png");solTexturesReferences.add("textures DecorCampagne/Sol14.png");
        solTexturesReferences.add("textures DecorCampagne/Sol15.png");solTexturesReferences.add("textures DecorCampagne/Sol16.png");
        solTexturesReferences.add("textures DecorCampagne/Sol17.png");solTexturesReferences.add("textures DecorCampagne/Sol18.png");
        solTexturesReferences.add("textures DecorCampagne/Sol19.png");solTexturesReferences.add("textures DecorCampagne/Sol20.png");
        solTexturesReferences.add("textures DecorCampagne/Sol21.png");solTexturesReferences.add("textures DecorCampagne/Sol22.png");
        solTexturesReferences.add("textures DecorCampagne/Sol23.png");solTexturesReferences.add("textures DecorCampagne/Sol24.png");
        solTexturesReferences.add("textures DecorCampagne/Sol25.png");solTexturesReferences.add("textures DecorCampagne/Sol26.png");
        solTexturesReferences.add("textures DecorCampagne/Sol27.png");solTexturesReferences.add("textures DecorCampagne/Sol28.png");
        solTexturesReferences.add("textures DecorCampagne/Sol29.png");solTexturesReferences.add("textures DecorCampagne/Sol30.png");
    }

    public Array<String> getSolTexturesReferences() { return solTexturesReferences; }

    public Array<String> getAssetsReferences() { return assetsReferences; }

    public Texture getSky() {
        return sky;
    }

    public Texture getBackground() {
        return background;
    }

    public Texture getMidBackground() { return midBackground; }

    @Override
    public Texture getExitScreenTexture() {
        return exitScreenTexture;
    }

    public float getLevelWidth() {
        return 28800;
    }

    public Texture getSolDepart() {
        return solDepart;
    }

    public Music getMusic() {
        return music;
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }
    public String getExitBackGroundRef() { return exitBackGroundRef; }

}
