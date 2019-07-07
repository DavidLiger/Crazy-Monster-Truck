package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorIles implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorIles/exitScreenBackground-Iles.png";

    public DecorIles(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("Island-Hawaii-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorIles/mapIles.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorIles/Paysage-Iles.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorIles/AP-MTC-Iles.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorIles/exitScreenBackground-Iles.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorIles/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorIles/SolDepart.png",Texture.class);

        assetsReferences.add("Island-Hawaii-Music.mp3");assetsReferences.add("textures DecorIles/mapIles.tmx");
        assetsReferences.add("textures DecorIles/Paysage-Iles.png");assetsReferences.add("textures DecorIles/AP-MTC-Iles.png");
        assetsReferences.add("textures Iles/sky.png");
        assetsReferences.add("textures DecorIles/SolDepart.png");

        solTexturesReferences.add("textures DecorIles/Sol1.png");solTexturesReferences.add("textures DecorIles/Sol2.png");
        solTexturesReferences.add("textures DecorIles/Sol3.png");solTexturesReferences.add("textures DecorIles/Sol4.png");
        solTexturesReferences.add("textures DecorIles/Sol5.png");solTexturesReferences.add("textures DecorIles/Sol6.png");
        solTexturesReferences.add("textures DecorIles/Sol7.png");solTexturesReferences.add("textures DecorIles/Sol8.png");
        solTexturesReferences.add("textures DecorIles/Sol9.png");solTexturesReferences.add("textures DecorIles/Sol10.png");
        solTexturesReferences.add("textures DecorIles/Sol11.png");solTexturesReferences.add("textures DecorIles/Sol12.png");
        solTexturesReferences.add("textures DecorIles/Sol13.png");solTexturesReferences.add("textures DecorIles/Sol14.png");
        solTexturesReferences.add("textures DecorIles/Sol15.png");solTexturesReferences.add("textures DecorIles/Sol16.png");
        solTexturesReferences.add("textures DecorIles/Sol17.png");solTexturesReferences.add("textures DecorIles/Sol18.png");
        solTexturesReferences.add("textures DecorIles/Sol19.png");solTexturesReferences.add("textures DecorIles/Sol20.png");
        solTexturesReferences.add("textures DecorIles/Sol21.png");solTexturesReferences.add("textures DecorIles/Sol22.png");
        solTexturesReferences.add("textures DecorIles/Sol23.png");solTexturesReferences.add("textures DecorIles/Sol24.png");
        solTexturesReferences.add("textures DecorIles/Sol25.png");solTexturesReferences.add("textures DecorIles/Sol26.png");
        solTexturesReferences.add("textures DecorIles/Sol27.png");solTexturesReferences.add("textures DecorIles/Sol28.png");
        solTexturesReferences.add("textures DecorIles/Sol29.png");solTexturesReferences.add("textures DecorIles/Sol30.png");
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
