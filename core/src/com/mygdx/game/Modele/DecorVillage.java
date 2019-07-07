package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorVillage implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorVillage/exitScreenBackground-Village.png";

    public DecorVillage(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("Village-Fanfare-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorVillage/mapVillage.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorVillage/Paysage-Village.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorVillage/AP-MTC-Village.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorVillage/exitScreenBackground-Village.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorVillage/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorVillage/SolDepart.png",Texture.class);

        assetsReferences.add("Village-Fanfare-Music.mp3");assetsReferences.add("textures DecorVillage/mapVillage.tmx");
        assetsReferences.add("textures DecorVillage/Paysage-Village.png");assetsReferences.add("textures DecorVillage/AP-MTC-Village.png");
        assetsReferences.add("textures DecorVillage/sky.png");
        assetsReferences.add("textures DecorVillage/SolDepart.png");

        solTexturesReferences.add("textures DecorVillage/Sol1.png");solTexturesReferences.add("textures DecorVillage/Sol2.png");
        solTexturesReferences.add("textures DecorVillage/Sol3.png");solTexturesReferences.add("textures DecorVillage/Sol4.png");
        solTexturesReferences.add("textures DecorVillage/Sol5.png");solTexturesReferences.add("textures DecorVillage/Sol6.png");
        solTexturesReferences.add("textures DecorVillage/Sol7.png");solTexturesReferences.add("textures DecorVillage/Sol8.png");
        solTexturesReferences.add("textures DecorVillage/Sol9.png");solTexturesReferences.add("textures DecorVillage/Sol10.png");
        solTexturesReferences.add("textures DecorVillage/Sol11.png");solTexturesReferences.add("textures DecorVillage/Sol12.png");
        solTexturesReferences.add("textures DecorVillage/Sol13.png");solTexturesReferences.add("textures DecorVillage/Sol14.png");
        solTexturesReferences.add("textures DecorVillage/Sol15.png");solTexturesReferences.add("textures DecorVillage/Sol16.png");
        solTexturesReferences.add("textures DecorVillage/Sol17.png");solTexturesReferences.add("textures DecorVillage/Sol18.png");
        solTexturesReferences.add("textures DecorVillage/Sol19.png");solTexturesReferences.add("textures DecorVillage/Sol20.png");
        solTexturesReferences.add("textures DecorVillage/Sol21.png");solTexturesReferences.add("textures DecorVillage/Sol22.png");
        solTexturesReferences.add("textures DecorVillage/Sol23.png");solTexturesReferences.add("textures DecorVillage/Sol24.png");
        solTexturesReferences.add("textures DecorVillage/Sol25.png");solTexturesReferences.add("textures DecorVillage/Sol26.png");
        solTexturesReferences.add("textures DecorVillage/Sol27.png");solTexturesReferences.add("textures DecorVillage/Sol28.png");
        solTexturesReferences.add("textures DecorVillage/Sol29.png");solTexturesReferences.add("textures DecorVillage/Sol30.png");
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
