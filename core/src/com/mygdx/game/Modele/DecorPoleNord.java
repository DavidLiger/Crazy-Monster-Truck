package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorPoleNord implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorPoleNord/exitScreenBackground-PoleNord.png";

    public DecorPoleNord(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("PoleNord-Fanfare-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorPoleNord/mapPoleNord.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorPoleNord/Paysage-PoleNord.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorPoleNord/AP-MTC-PoleNord.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorPoleNord/exitScreenBackground-PoleNord.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorPoleNord/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorPoleNord/SolDepart.png",Texture.class);

        assetsReferences.add("PoleNord-Fanfare-Music.mp3");assetsReferences.add("textures DecorPoleNord/mapPoleNord.tmx");
        assetsReferences.add("textures DecorPoleNord/Paysage-PoleNord.png");assetsReferences.add("textures DecorPoleNord/AP-MTC-PoleNord.png");
        assetsReferences.add("textures DecorPoleNord/sky.png");
        assetsReferences.add("textures DecorPoleNord/SolDepart.png");

        solTexturesReferences.add("textures DecorPoleNord/Sol1.png");solTexturesReferences.add("textures DecorPoleNord/Sol2.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol3.png");solTexturesReferences.add("textures DecorPoleNord/Sol4.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol5.png");solTexturesReferences.add("textures DecorPoleNord/Sol6.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol7.png");solTexturesReferences.add("textures DecorPoleNord/Sol8.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol9.png");solTexturesReferences.add("textures DecorPoleNord/Sol10.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol11.png");solTexturesReferences.add("textures DecorPoleNord/Sol12.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol13.png");solTexturesReferences.add("textures DecorPoleNord/Sol14.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol15.png");solTexturesReferences.add("textures DecorPoleNord/Sol16.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol17.png");solTexturesReferences.add("textures DecorPoleNord/Sol18.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol19.png");solTexturesReferences.add("textures DecorPoleNord/Sol20.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol21.png");solTexturesReferences.add("textures DecorPoleNord/Sol22.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol23.png");solTexturesReferences.add("textures DecorPoleNord/Sol24.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol25.png");solTexturesReferences.add("textures DecorPoleNord/Sol26.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol27.png");solTexturesReferences.add("textures DecorPoleNord/Sol28.png");
        solTexturesReferences.add("textures DecorPoleNord/Sol29.png");solTexturesReferences.add("textures DecorPoleNord/Sol30.png");
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
