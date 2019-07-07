package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;

public class DecorJungle implements DecorDef {

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenTexture;
    private Texture solDepart;
    private TiledMap tiledMap;
    private Music music;

    private Array<String> solTexturesReferences = new Array<String>();
    private Array<String> assetsReferences = new Array<String>();
    private String exitBackGroundRef = "textures DecorJungle/exitScreenBackground-Jungle.png";

    public DecorJungle(MTCGame mtcGame) {
        music = mtcGame.getAssetManager().get("Jungle-Samba-Music.mp3",Music.class);
        tiledMap = mtcGame.getAssetManager().get("textures DecorJungle/mapJungle.tmx",TiledMap.class);
        background = mtcGame.getAssetManager().get("textures DecorJungle/Paysage-Jungle.png",Texture.class);
        midBackground = mtcGame.getAssetManager().get("textures DecorJungle/AP-MTC-Jungle.png",Texture.class);

        exitScreenTexture = mtcGame.getAssetManager().get("textures DecorJungle/exitScreenBackground-Jungle.png",Texture.class);
        sky = mtcGame.getAssetManager().get("textures DecorJungle/sky.png",Texture.class);

        solDepart = mtcGame.getAssetManager().get("textures DecorJungle/SolDepart.png",Texture.class);

        assetsReferences.add("Jungle-Samba-Music.mp3");assetsReferences.add("textures DecorJungle/mapJungle.tmx");
        assetsReferences.add("textures DecorJungle/Paysage-Jungle.png");assetsReferences.add("textures DecorJungle/AP-MTC-Jungle.png");
        assetsReferences.add("textures DecorJungle/sky.png");
        assetsReferences.add("textures DecorJungle/SolDepart.png");

        solTexturesReferences.add("textures DecorJungle/Sol1.png");solTexturesReferences.add("textures DecorJungle/Sol2.png");
        solTexturesReferences.add("textures DecorJungle/Sol3.png");solTexturesReferences.add("textures DecorJungle/Sol4.png");
        solTexturesReferences.add("textures DecorJungle/Sol5.png");solTexturesReferences.add("textures DecorJungle/Sol6.png");
        solTexturesReferences.add("textures DecorJungle/Sol7.png");solTexturesReferences.add("textures DecorJungle/Sol8.png");
        solTexturesReferences.add("textures DecorJungle/Sol9.png");solTexturesReferences.add("textures DecorJungle/Sol10.png");
        solTexturesReferences.add("textures DecorJungle/Sol11.png");solTexturesReferences.add("textures DecorJungle/Sol12.png");
        solTexturesReferences.add("textures DecorJungle/Sol13.png");solTexturesReferences.add("textures DecorJungle/Sol14.png");
        solTexturesReferences.add("textures DecorJungle/Sol15.png");solTexturesReferences.add("textures DecorJungle/Sol16.png");
        solTexturesReferences.add("textures DecorJungle/Sol17.png");solTexturesReferences.add("textures DecorJungle/Sol18.png");
        solTexturesReferences.add("textures DecorJungle/Sol19.png");solTexturesReferences.add("textures DecorJungle/Sol20.png");
        solTexturesReferences.add("textures DecorJungle/Sol21.png");solTexturesReferences.add("textures DecorJungle/Sol22.png");
        solTexturesReferences.add("textures DecorJungle/Sol23.png");solTexturesReferences.add("textures DecorJungle/Sol24.png");
        solTexturesReferences.add("textures DecorJungle/Sol25.png");solTexturesReferences.add("textures DecorJungle/Sol26.png");
        solTexturesReferences.add("textures DecorJungle/Sol27.png");solTexturesReferences.add("textures DecorJungle/Sol28.png");
        solTexturesReferences.add("textures DecorJungle/Sol29.png");solTexturesReferences.add("textures DecorJungle/Sol30.png");
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
