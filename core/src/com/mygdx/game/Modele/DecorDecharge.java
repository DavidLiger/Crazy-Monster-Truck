package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorDecharge implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorDecharge/exitScreenBackground-Decharge.png";

    public DecorDecharge(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("Decharge-Flute-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorDecharge/mapDecharge.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorDecharge/Paysage-Decharge.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorDecharge/AP-MTC-Decharge.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorDecharge/exitScreenBackground-Decharge.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorDecharge/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorDecharge/SolDepart.png",Texture.class);

        assetsReferences.add("Decharge-Flute-Music.mp3");assetsReferences.add("textures DecorDecharge/mapDecharge.tmx");
        assetsReferences.add("textures DecorDecharge/Paysage-Decharge.png");assetsReferences.add("textures DecorDecharge/AP-MTC-Decharge.png");
        assetsReferences.add("textures DecorDecharge/sky.png");
        assetsReferences.add("textures DecorDecharge/SolDepart.png");

        solTexturesReferences.add("textures DecorDecharge/Sol1.png");solTexturesReferences.add("textures DecorDecharge/Sol2.png");
        solTexturesReferences.add("textures DecorDecharge/Sol3.png");solTexturesReferences.add("textures DecorDecharge/Sol4.png");
        solTexturesReferences.add("textures DecorDecharge/Sol5.png");solTexturesReferences.add("textures DecorDecharge/Sol6.png");
        solTexturesReferences.add("textures DecorDecharge/Sol7.png");solTexturesReferences.add("textures DecorDecharge/Sol8.png");
        solTexturesReferences.add("textures DecorDecharge/Sol9.png");solTexturesReferences.add("textures DecorDecharge/Sol10.png");
        solTexturesReferences.add("textures DecorDecharge/Sol11.png");solTexturesReferences.add("textures DecorDecharge/Sol12.png");
        solTexturesReferences.add("textures DecorDecharge/Sol13.png");solTexturesReferences.add("textures DecorDecharge/Sol14.png");
        solTexturesReferences.add("textures DecorDecharge/Sol15.png");solTexturesReferences.add("textures DecorDecharge/Sol16.png");
        solTexturesReferences.add("textures DecorDecharge/Sol17.png");solTexturesReferences.add("textures DecorDecharge/Sol18.png");
        solTexturesReferences.add("textures DecorDecharge/Sol19.png");solTexturesReferences.add("textures DecorDecharge/Sol20.png");
        solTexturesReferences.add("textures DecorDecharge/Sol21.png");solTexturesReferences.add("textures DecorDecharge/Sol22.png");
        solTexturesReferences.add("textures DecorDecharge/Sol23.png");solTexturesReferences.add("textures DecorDecharge/Sol24.png");
        solTexturesReferences.add("textures DecorDecharge/Sol25.png");solTexturesReferences.add("textures DecorDecharge/Sol26.png");
        solTexturesReferences.add("textures DecorDecharge/Sol27.png");solTexturesReferences.add("textures DecorDecharge/Sol28.png");
        solTexturesReferences.add("textures DecorDecharge/Sol29.png");solTexturesReferences.add("textures DecorDecharge/Sol30.png");
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
