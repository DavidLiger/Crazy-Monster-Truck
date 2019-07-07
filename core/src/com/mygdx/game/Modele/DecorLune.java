package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorLune implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorLune/exitScreenBackground-Lune.png";

    public DecorLune(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("Lune-Psychedelic-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorLune/mapLune.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorLune/Paysage-Lune.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorLune/AP-MTC-Lune.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorLune/exitScreenBackground-Lune.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorLune/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorLune/SolDepart.png",Texture.class);

        assetsReferences.add("Lune-Psychedelic-Music.mp3");assetsReferences.add("textures DecorLune/mapLune.tmx");
        assetsReferences.add("textures DecorLune/Paysage-Lune.png");assetsReferences.add("textures DecorLune/AP-MTC-Lune.png");
        assetsReferences.add("textures DecorLune/sky.png");
        assetsReferences.add("textures DecorLune/SolDepart.png");

        solTexturesReferences.add("textures DecorLune/Sol1.png");solTexturesReferences.add("textures DecorLune/Sol2.png");
        solTexturesReferences.add("textures DecorLune/Sol3.png");solTexturesReferences.add("textures DecorLune/Sol4.png");
        solTexturesReferences.add("textures DecorLune/Sol5.png");solTexturesReferences.add("textures DecorLune/Sol6.png");
        solTexturesReferences.add("textures DecorLune/Sol7.png");solTexturesReferences.add("textures DecorLune/Sol8.png");
        solTexturesReferences.add("textures DecorLune/Sol9.png");solTexturesReferences.add("textures DecorLune/Sol10.png");
        solTexturesReferences.add("textures DecorLune/Sol11.png");solTexturesReferences.add("textures DecorLune/Sol12.png");
        solTexturesReferences.add("textures DecorLune/Sol13.png");solTexturesReferences.add("textures DecorLune/Sol14.png");
        solTexturesReferences.add("textures DecorLune/Sol15.png");solTexturesReferences.add("textures DecorLune/Sol16.png");
        solTexturesReferences.add("textures DecorLune/Sol17.png");solTexturesReferences.add("textures DecorLune/Sol18.png");
        solTexturesReferences.add("textures DecorLune/Sol19.png");solTexturesReferences.add("textures DecorLune/Sol20.png");
        solTexturesReferences.add("textures DecorLune/Sol21.png");solTexturesReferences.add("textures DecorLune/Sol22.png");
        solTexturesReferences.add("textures DecorLune/Sol23.png");solTexturesReferences.add("textures DecorLune/Sol24.png");
        solTexturesReferences.add("textures DecorLune/Sol25.png");solTexturesReferences.add("textures DecorLune/Sol26.png");
        solTexturesReferences.add("textures DecorLune/Sol27.png");solTexturesReferences.add("textures DecorLune/Sol28.png");
        solTexturesReferences.add("textures DecorLune/Sol29.png");solTexturesReferences.add("textures DecorLune/Sol30.png");
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
