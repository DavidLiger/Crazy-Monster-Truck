package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorSousMarin implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorSousMarin/exitScreenBackground-SousMarin.png";

    public DecorSousMarin(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("SousMarin-Dub-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorSousMarin/mapSousMarin.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorSousMarin/Paysage-SousMarin.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorSousMarin/AP-MTC-SousMarin.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorSousMarin/exitScreenBackground-SousMarin.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorSousMarin/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorSousMarin/SolDepart.png",Texture.class);

        assetsReferences.add("SousMarin-Dub-Music.mp3");assetsReferences.add("textures DecorSousMarin/mapSousMarin.tmx");
        assetsReferences.add("textures DecorSousMarin/Paysage-SousMarin.png");assetsReferences.add("textures DecorSousMarin/AP-MTC-SousMarin.png");
        assetsReferences.add("textures DecorSousMarin/sky.png");
        assetsReferences.add("textures DecorSousMarin/SolDepart.png");

        solTexturesReferences.add("textures DecorSousMarin/Sol1.png");solTexturesReferences.add("textures DecorSousMarin/Sol2.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol3.png");solTexturesReferences.add("textures DecorSousMarin/Sol4.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol5.png");solTexturesReferences.add("textures DecorSousMarin/Sol6.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol7.png");solTexturesReferences.add("textures DecorSousMarin/Sol8.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol9.png");solTexturesReferences.add("textures DecorSousMarin/Sol10.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol11.png");solTexturesReferences.add("textures DecorSousMarin/Sol12.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol13.png");solTexturesReferences.add("textures DecorSousMarin/Sol14.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol15.png");solTexturesReferences.add("textures DecorSousMarin/Sol16.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol17.png");solTexturesReferences.add("textures DecorSousMarin/Sol18.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol19.png");solTexturesReferences.add("textures DecorSousMarin/Sol20.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol21.png");solTexturesReferences.add("textures DecorSousMarin/Sol22.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol23.png");solTexturesReferences.add("textures DecorSousMarin/Sol24.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol25.png");solTexturesReferences.add("textures DecorSousMarin/Sol26.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol27.png");solTexturesReferences.add("textures DecorSousMarin/Sol28.png");
        solTexturesReferences.add("textures DecorSousMarin/Sol29.png");solTexturesReferences.add("textures DecorSousMarin/Sol30.png");
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
