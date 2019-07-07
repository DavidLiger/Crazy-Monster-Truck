package com.mygdx.game.Modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.Controleur.MTCGame;


public class Coin implements Collectable {


    private Sprite goldenCoin;
    private float positionX;
    private Polygon collisionRectangle;

    public Coin(MTCGame mtcGame, float x, float y){
        this.positionX = x;

        TextureAtlas textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas");

        goldenCoin = new Sprite(new TextureRegion(textureAtlas.findRegion("goldenCoin")));

        float[] coinShapeFloatArray = new float[]{-goldenCoin.getWidth()/2,-goldenCoin.getHeight()/2,goldenCoin.getWidth()/2,-goldenCoin.getHeight()/2,goldenCoin.getWidth()/2,goldenCoin.getHeight()/2,-goldenCoin.getWidth()/2,goldenCoin.getHeight()/2};
        goldenCoin.setScale(0.5f);
        goldenCoin.setPosition(positionX,y);

        // rectangle de collision
        collisionRectangle = new Polygon(coinShapeFloatArray);
        collisionRectangle.setScale(0.35f,0.35f);
        collisionRectangle.setPosition(positionX+goldenCoin.getWidth()/1.95f,y+goldenCoin.getHeight()/1.95f);
    }

    public void draw(SpriteBatch batch){
        goldenCoin.draw(batch);
    }

    public float getPositionX() {
        return positionX;
    }

    public Polygon getCollisionRectangle() {
        return collisionRectangle;
    }

    @Override
    public String getCollectableIdentifier() {
        return "";
    }

    @Override
    public void updateFrame() {

    }
}
