package com.mygdx.game.Modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.Controleur.MTCGame;

public class BonusGasFree implements Collectable {

    private TextureRegion[] bonusGasFreeFrames;
    private TextureRegion currentFrame;
    private Animation<TextureRegion> bonusGasFreeAnimation;
    private float stateTime;

    private float positionX;
    private float positionY;
    private float upNDownPosition;
    private boolean okUp;
    private Polygon collisionRectangle;

    public BonusGasFree(MTCGame mtcGame,float x, float y){
        this.positionX = x;
        this.positionY = y;
        upNDownPosition = positionY;

        Texture texture = mtcGame.getAssetManager().get("frameSheets/bonusGasFree_frameSheet.png",Texture.class);

        bonusGasFreeAnimation = new Animation<TextureRegion>(0.1f,bonusGasFreeFrames = sheetToFrame(texture));
        bonusGasFreeAnimation.setPlayMode(Animation.PlayMode.LOOP);
        float[] bonusGasFreeShapeFloatArray = new float[]{-bonusGasFreeFrames[0].getRegionWidth()/2,-bonusGasFreeFrames[0].getRegionHeight()/2,bonusGasFreeFrames[0].getRegionWidth()/2,-bonusGasFreeFrames[0].getRegionHeight()/2,bonusGasFreeFrames[0].getRegionWidth()/2,bonusGasFreeFrames[0].getRegionHeight()/2,-bonusGasFreeFrames[0].getRegionWidth()/2,bonusGasFreeFrames[0].getRegionHeight()/2};

        // rectangle de collision
        collisionRectangle = new Polygon(bonusGasFreeShapeFloatArray);
        collisionRectangle.setScale(0.3325f,0.315f);
    }

    /**
     * Stocke dans tableau à une dimension le frameSheet
     * après l'avoir splitté dans tableau temporaire à 2 dimensions
     */
    private TextureRegion[] sheetToFrame(Texture frameSheet){
        TextureRegion[] textureRegionArray = new TextureRegion[4 * 2];
        TextureRegion[][] textureRegions = TextureRegion.split(frameSheet,frameSheet.getWidth()/4,frameSheet.getHeight()/2);
        int index = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 4; j++){
                textureRegionArray[index++] = textureRegions[i][j];
            }
        }
        return textureRegionArray;
    }

    public void draw(SpriteBatch batch){
        currentFrame =  bonusGasFreeAnimation.getKeyFrame(stateTime,true);
        batch.draw(currentFrame,positionX,updatePositionY(),currentFrame.getRegionWidth()/2.9f,currentFrame.getRegionHeight()/2.9f);
    }

    private float updatePositionY(){
        if(!okUp){
            if(upNDownPosition <= positionY+currentFrame.getRegionHeight()/4){
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
        collisionRectangle.setPosition(positionX+bonusGasFreeFrames[0].getRegionWidth()/6,upNDownPosition+bonusGasFreeFrames[0].getRegionHeight()/6);
        return collisionRectangle;
    }

    @Override
    public String getCollectableIdentifier() {
        return "bonusGasFree";
    }

    @Override
    public void updateFrame() {
        stateTime += Gdx.graphics.getDeltaTime();
    }
}
