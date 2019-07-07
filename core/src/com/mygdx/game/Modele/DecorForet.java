package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorForet implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorForet/exitScreenBackground-Foret.png";

    public DecorForet(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("Foret-BlueGrass-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorForet/mapForet.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorForet/Paysage-Foret.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorForet/AP-MTC-Foret.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorForet/exitScreenBackground-Foret.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorForet/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorForet/SolDepart.png",Texture.class);

        assetsReferences.add("Foret-BlueGrass-Music.mp3");assetsReferences.add("textures DecorForet/mapForet.tmx");
        assetsReferences.add("textures DecorForet/Paysage-Foret.png");assetsReferences.add("textures DecorForet/AP-MTC-Foret.png");
        assetsReferences.add("textures DecorForet/sky.png");
        assetsReferences.add("textures DecorForet/SolDepart.png");

        solTexturesReferences.add("textures DecorForet/Sol1.png");solTexturesReferences.add("textures DecorForet/Sol2.png");
        solTexturesReferences.add("textures DecorForet/Sol3.png");solTexturesReferences.add("textures DecorForet/Sol4.png");
        solTexturesReferences.add("textures DecorForet/Sol5.png");solTexturesReferences.add("textures DecorForet/Sol6.png");
        solTexturesReferences.add("textures DecorForet/Sol7.png");solTexturesReferences.add("textures DecorForet/Sol8.png");
        solTexturesReferences.add("textures DecorForet/Sol9.png");solTexturesReferences.add("textures DecorForet/Sol10.png");
        solTexturesReferences.add("textures DecorForet/Sol11.png");solTexturesReferences.add("textures DecorForet/Sol12.png");
        solTexturesReferences.add("textures DecorForet/Sol13.png");solTexturesReferences.add("textures DecorForet/Sol14.png");
        solTexturesReferences.add("textures DecorForet/Sol15.png");solTexturesReferences.add("textures DecorForet/Sol16.png");
        solTexturesReferences.add("textures DecorForet/Sol17.png");solTexturesReferences.add("textures DecorForet/Sol18.png");
        solTexturesReferences.add("textures DecorForet/Sol19.png");solTexturesReferences.add("textures DecorForet/Sol20.png");
        solTexturesReferences.add("textures DecorForet/Sol21.png");solTexturesReferences.add("textures DecorForet/Sol22.png");
        solTexturesReferences.add("textures DecorForet/Sol23.png");solTexturesReferences.add("textures DecorForet/Sol24.png");
        solTexturesReferences.add("textures DecorForet/Sol25.png");solTexturesReferences.add("textures DecorForet/Sol26.png");
        solTexturesReferences.add("textures DecorForet/Sol27.png");solTexturesReferences.add("textures DecorForet/Sol28.png");
        solTexturesReferences.add("textures DecorForet/Sol29.png");solTexturesReferences.add("textures DecorForet/Sol30.png");
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
