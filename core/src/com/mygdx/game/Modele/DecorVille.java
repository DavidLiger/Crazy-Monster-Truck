package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorVille implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorMontagne/exitScreenBackground-Ville.png";

    public DecorVille(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("City-Jazz-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorVille/mapVille.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorVille/Paysage-Ville.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorVille/AP-MTC-Ville.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorVille/exitScreenBackground-Ville.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorVille/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorVille/SolDepart.png",Texture.class);

        assetsReferences.add("City-Jazz-Music.mp3");assetsReferences.add("textures DecorVille/mapVille.tmx");
        assetsReferences.add("textures DecorVille/Paysage-Ville.png");assetsReferences.add("textures DecorVille/AP-MTC-Ville.png");
        assetsReferences.add("textures DecorVille/sky.png");
        assetsReferences.add("textures DecorVille/SolDepart.png");

        solTexturesReferences.add("textures DecorVille/Sol1.png");solTexturesReferences.add("textures DecorVille/Sol2.png");
        solTexturesReferences.add("textures DecorVille/Sol3.png");solTexturesReferences.add("textures DecorVille/Sol4.png");
        solTexturesReferences.add("textures DecorVille/Sol5.png");solTexturesReferences.add("textures DecorVille/Sol6.png");
        solTexturesReferences.add("textures DecorVille/Sol7.png");solTexturesReferences.add("textures DecorVille/Sol8.png");
        solTexturesReferences.add("textures DecorVille/Sol9.png");solTexturesReferences.add("textures DecorVille/Sol10.png");
        solTexturesReferences.add("textures DecorVille/Sol11.png");solTexturesReferences.add("textures DecorVille/Sol12.png");
        solTexturesReferences.add("textures DecorVille/Sol13.png");solTexturesReferences.add("textures DecorVille/Sol14.png");
        solTexturesReferences.add("textures DecorVille/Sol15.png");solTexturesReferences.add("textures DecorVille/Sol16.png");
        solTexturesReferences.add("textures DecorVille/Sol17.png");solTexturesReferences.add("textures DecorVille/Sol18.png");
        solTexturesReferences.add("textures DecorVille/Sol19.png");solTexturesReferences.add("textures DecorVille/Sol20.png");
        solTexturesReferences.add("textures DecorVille/Sol21.png");solTexturesReferences.add("textures DecorVille/Sol22.png");
        solTexturesReferences.add("textures DecorVille/Sol23.png");solTexturesReferences.add("textures DecorVille/Sol24.png");
        solTexturesReferences.add("textures DecorVille/Sol25.png");solTexturesReferences.add("textures DecorVille/Sol26.png");
        solTexturesReferences.add("textures DecorVille/Sol27.png");solTexturesReferences.add("textures DecorVille/Sol28.png");
        solTexturesReferences.add("textures DecorVille/Sol29.png");solTexturesReferences.add("textures DecorVille/Sol30.png");
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
