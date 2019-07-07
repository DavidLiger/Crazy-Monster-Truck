package com.mygdx.game.Modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.Controleur.MTCGame;


public class Jerrycan {

    private Sprite jerrycanSprite;
    private float positionX;
    private Polygon collisionPolygon;

    public Jerrycan(MTCGame mtcGame,float x, float y){
        this.positionX = x;

        TextureAtlas textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas");
        TextureRegion texture = textureAtlas.findRegion("jerrycan");

        jerrycanSprite = new Sprite(texture);
        float[] jerrycanShapeFloatArray = new float[]{-jerrycanSprite.getWidth()/2,-jerrycanSprite.getHeight()/2,jerrycanSprite.getWidth()/2,-jerrycanSprite.getHeight()/2,jerrycanSprite.getWidth()/2,jerrycanSprite.getHeight()/2,-jerrycanSprite.getWidth()/2,jerrycanSprite.getHeight()/2};
        jerrycanSprite.setScale(0.35f);
        jerrycanSprite.setPosition(positionX ,y-(jerrycanSprite.getHeight()/4.5f) );

        // polygone de collision
        collisionPolygon = new Polygon(jerrycanShapeFloatArray);
        collisionPolygon.setScale(0.315f,0.28f);
        collisionPolygon.setPosition(positionX + jerrycanSprite.getWidth()/1.95f,y + jerrycanSprite.getHeight()/4f);
    }

    public void drawJerrycan(SpriteBatch batch){
        jerrycanSprite.draw(batch);
    }

    public float getPositionX() {
        return positionX;
    }

    public Polygon getCollisionPolygon() {
        return collisionPolygon;
    }
}
