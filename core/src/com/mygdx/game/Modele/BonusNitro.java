package com.mygdx.game.Modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.Controleur.MTCGame;

public class BonusNitro implements Collectable {

    private Texture bonusNitrotexture;
    private Animation<Texture> bonusNitroAnimation;
    private Texture currentFrame;
    private float stateTime;

    private float positionX;
    private float positionY;
    private float upNDownPosition;
    private boolean okUp;
    private Polygon collisionRectangle;

    public BonusNitro(MTCGame mtcGame,float x, float y){
        this.positionX = x;
        this.positionY = y;
        upNDownPosition = positionY;


        bonusNitrotexture = mtcGame.getAssetManager().get("frameSheets/bonusNitro.png",Texture.class);
        Texture texture1 = mtcGame.getAssetManager().get("frameSheets/bonusNitro2.png",Texture.class);

        bonusNitroAnimation = new Animation<Texture>(0.5f,bonusNitrotexture,texture1);
        bonusNitroAnimation.setPlayMode(Animation.PlayMode.LOOP);
        float[] bonusNitroShapeFloatArray = new float[]{-bonusNitrotexture.getWidth()/2,-bonusNitrotexture.getHeight()/2, bonusNitrotexture.getWidth()/2,-bonusNitrotexture.getHeight()/2, bonusNitrotexture.getWidth()/2, bonusNitrotexture.getHeight()/2,-bonusNitrotexture.getWidth()/2, bonusNitrotexture.getHeight()/2};

        // rectangle de collision
        collisionRectangle = new Polygon(bonusNitroShapeFloatArray);
        collisionRectangle.setScale(0.1575f,0.35f);

    }

    public void draw(SpriteBatch batch){
        currentFrame =  bonusNitroAnimation.getKeyFrame(stateTime,true);
        batch.draw(currentFrame,positionX,updatePositionY(),currentFrame.getWidth()/2.9f,currentFrame.getHeight()/2.9f);
    }

    private float updatePositionY(){
        if(!okUp){
            if(upNDownPosition <= positionY+currentFrame.getHeight()/4){
                upNDownPosition += 0.25f;
            }else{
                okUp = true;
            }
        }else{
            if(upNDownPosition > positionY){
                upNDownPosition -=0.25f;
            }
            if(upNDownPosition <= positionY+0.2f){
                okUp = false;
            }
        }
        return upNDownPosition;
    }

    public float getPositionX() {
        return positionX;
    }

    public Polygon getCollisionRectangle() {
        collisionRectangle.setPosition(positionX+ bonusNitrotexture.getWidth()/5.9f,upNDownPosition+ bonusNitrotexture.getHeight()/5.9f);
        return collisionRectangle;
    }

    public String getCollectableIdentifier() {
        return "bonusNitro";
    }

    @Override
    public void updateFrame() {
        stateTime += Gdx.graphics.getDeltaTime();
    }
}
