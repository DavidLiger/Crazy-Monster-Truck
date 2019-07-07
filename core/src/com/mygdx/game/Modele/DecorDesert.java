package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorDesert implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorDesert/exitScreenBackground-Desert.png";

    public DecorDesert(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("Desert-Oriental-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorDesert/mapDesert.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorDesert/Paysage-Desert.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorDesert/AP-MTC-Desert.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorDesert/exitScreenBackground-Desert.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorDesert/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorDesert/SolDepart.png",Texture.class);

        assetsReferences.add("Desert-Oriental-Music.mp3");assetsReferences.add("textures DecorDesert/mapDesert.tmx");
        assetsReferences.add("textures DecorDesert/Paysage-Desert.png");assetsReferences.add("textures DecorDesert/AP-MTC-Desert.png");
        assetsReferences.add("textures DecorDesert/sky.png");
        assetsReferences.add("textures DecorDesert/SolDepart.png");

        solTexturesReferences.add("textures DecorDesert/Sol1.png");solTexturesReferences.add("textures DecorDesert/Sol2.png");
        solTexturesReferences.add("textures DecorDesert/Sol3.png");solTexturesReferences.add("textures DecorDesert/Sol4.png");
        solTexturesReferences.add("textures DecorDesert/Sol5.png");solTexturesReferences.add("textures DecorDesert/Sol6.png");
        solTexturesReferences.add("textures DecorDesert/Sol7.png");solTexturesReferences.add("textures DecorDesert/Sol8.png");
        solTexturesReferences.add("textures DecorDesert/Sol9.png");solTexturesReferences.add("textures DecorDesert/Sol10.png");
        solTexturesReferences.add("textures DecorDesert/Sol11.png");solTexturesReferences.add("textures DecorDesert/Sol12.png");
        solTexturesReferences.add("textures DecorDesert/Sol13.png");solTexturesReferences.add("textures DecorDesert/Sol14.png");
        solTexturesReferences.add("textures DecorDesert/Sol15.png");solTexturesReferences.add("textures DecorDesert/Sol16.png");
        solTexturesReferences.add("textures DecorDesert/Sol17.png");solTexturesReferences.add("textures DecorDesert/Sol18.png");
        solTexturesReferences.add("textures DecorDesert/Sol19.png");solTexturesReferences.add("textures DecorDesert/Sol20.png");
        solTexturesReferences.add("textures DecorDesert/Sol21.png");solTexturesReferences.add("textures DecorDesert/Sol22.png");
        solTexturesReferences.add("textures DecorDesert/Sol23.png");solTexturesReferences.add("textures DecorDesert/Sol24.png");
        solTexturesReferences.add("textures DecorDesert/Sol25.png");solTexturesReferences.add("textures DecorDesert/Sol26.png");
        solTexturesReferences.add("textures DecorDesert/Sol27.png");solTexturesReferences.add("textures DecorDesert/Sol28.png");
        solTexturesReferences.add("textures DecorDesert/Sol29.png");solTexturesReferences.add("textures DecorDesert/Sol30.png");
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
