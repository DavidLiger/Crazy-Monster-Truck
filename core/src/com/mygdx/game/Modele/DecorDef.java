package com.mygdx.game.Modele;


import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public interface DecorDef {

    Texture getSky();

    Music getMusic();

    Texture getBackground();

    Texture getMidBackground();

    float getLevelWidth();

    Texture getExitScreenTexture();

    Texture getSolDepart();

    Array<String> getSolTexturesReferences();

    Array<String> getAssetsReferences();

    TiledMap getTiledMap();

    String getExitBackGroundRef();

}
