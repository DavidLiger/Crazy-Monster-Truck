package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorMontagne implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorMontagne/exitScreenBackground-Montagne.png";

    public DecorMontagne(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("Montagne-Rock-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorMontagne/mapMontagne.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorMontagne/Paysage-Montagne.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorMontagne/AP-MTC-Montagne.png",Texture.class);
        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorMontagne/exitScreenBackground-Montagne.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorMontagne/sky.png",Texture.class);
        solDepart = mtcGame.getAssetManager().get("textures DecorMontagne/SolDepart.png",Texture.class);

        assetsReferences.add("Montagne-Rock-Music.mp3");
        assetsReferences.add("textures DecorMontagne/mapMontagne.tmx");
        assetsReferences.add("textures DecorMontagne/Paysage-Montagne.png");
        assetsReferences.add("textures DecorMontagne/AP-MTC-Montagne.png");
        assetsReferences.add("textures DecorMontagne/sky.png");
        assetsReferences.add("textures DecorMontagne/SolDepart.png");

        solTexturesReferences.add("textures DecorMontagne/Sol1.png");solTexturesReferences.add("textures DecorMontagne/Sol2.png");
        solTexturesReferences.add("textures DecorMontagne/Sol3.png");solTexturesReferences.add("textures DecorMontagne/Sol4.png");
        solTexturesReferences.add("textures DecorMontagne/Sol5.png");solTexturesReferences.add("textures DecorMontagne/Sol6.png");
        solTexturesReferences.add("textures DecorMontagne/Sol7.png");solTexturesReferences.add("textures DecorMontagne/Sol8.png");
        solTexturesReferences.add("textures DecorMontagne/Sol9.png");solTexturesReferences.add("textures DecorMontagne/Sol10.png");
        solTexturesReferences.add("textures DecorMontagne/Sol11.png");solTexturesReferences.add("textures DecorMontagne/Sol12.png");
        solTexturesReferences.add("textures DecorMontagne/Sol13.png");solTexturesReferences.add("textures DecorMontagne/Sol14.png");
        solTexturesReferences.add("textures DecorMontagne/Sol15.png");solTexturesReferences.add("textures DecorMontagne/Sol16.png");
        solTexturesReferences.add("textures DecorMontagne/Sol17.png");solTexturesReferences.add("textures DecorMontagne/Sol18.png");
        solTexturesReferences.add("textures DecorMontagne/Sol19.png");solTexturesReferences.add("textures DecorMontagne/Sol20.png");
        solTexturesReferences.add("textures DecorMontagne/Sol21.png");solTexturesReferences.add("textures DecorMontagne/Sol22.png");
        solTexturesReferences.add("textures DecorMontagne/Sol23.png");solTexturesReferences.add("textures DecorMontagne/Sol24.png");
        solTexturesReferences.add("textures DecorMontagne/Sol25.png");solTexturesReferences.add("textures DecorMontagne/Sol26.png");
        solTexturesReferences.add("textures DecorMontagne/Sol27.png");solTexturesReferences.add("textures DecorMontagne/Sol28.png");
        solTexturesReferences.add("textures DecorMontagne/Sol29.png");solTexturesReferences.add("textures DecorMontagne/Sol30.png");



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
