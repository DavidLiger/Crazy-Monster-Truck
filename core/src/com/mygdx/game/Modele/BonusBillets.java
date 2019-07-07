package com.mygdx.game.Modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.Controleur.MTCGame;

public class BonusBillets implements Collectable {

    private TextureRegion[] bonusBilletFrames;
    private TextureRegion currentFrame;
    private Animation<TextureRegion> bonusBilletAnimation;
    private float stateTime;

    private float positionX;
    private float positionY;
    private float upNDownPosition;
    private boolean okUp;
    private Polygon collisionRectangle;

    public BonusBillets(MTCGame mtcGame,float x, float y){
        this.positionX = x;
        this.positionY = y;
        upNDownPosition = positionY;

        Texture texture = mtcGame.getAssetManager().get("frameSheets/bonusBillet_frameSheet.png",Texture.class);

        bonusBilletAnimation = new Animation<TextureRegion>(0.1f,bonusBilletFrames = sheetToFrame(texture));
        bonusBilletAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        float[] bonusBilletsShapeFloatArray = new float[]{-bonusBilletFrames[0].getRegionWidth()/2,-bonusBilletFrames[0].getRegionHeight()/4,
                bonusBilletFrames[0].getRegionWidth()/2,-bonusBilletFrames[0].getRegionHeight()/2,
                bonusBilletFrames[0].getRegionWidth()/2,bonusBilletFrames[0].getRegionHeight()/2,
                -bonusBilletFrames[0].getRegionWidth()/2,bonusBilletFrames[0].getRegionHeight()/2};

        // rectangle de collision
        collisionRectangle = new Polygon(bonusBilletsShapeFloatArray);
        collisionRectangle.setScale(0.27f,0.27f);
    }

    /**
     * Stocke dans tableau à une dimension le frameSheet
     * après l'avoir splitté dans tableau temporaire à 2 dimensions
     */
    private TextureRegion[] sheetToFrame(Texture frameSheet){
        TextureRegion[] textureRegionArray = new TextureRegion[2 * 5];
        TextureRegion[][] textureRegions = TextureRegion.split(frameSheet,frameSheet.getWidth()/5,
                frameSheet.getHeight()/2);
        int index = 0;
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 5; j++){
                textureRegionArray[index++] = textureRegions[i][j];
            }
        }
        return textureRegionArray;
    }

    public void draw(SpriteBatch batch){
        currentFrame =  bonusBilletAnimation.getKeyFrame(stateTime,true);
        batch.draw(currentFrame,positionX,updatePositionY(),currentFrame.getRegionWidth()/2.5f,
                currentFrame.getRegionHeight()/2.5f);
    }

    private float updatePositionY(){
        if(!okUp){
            if(upNDownPosition <= positionY + currentFrame.getRegionHeight()/8){
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
        collisionRectangle.setPosition(positionX+bonusBilletFrames[0].getRegionWidth()/5.5f,
                upNDownPosition+bonusBilletFrames[0].getRegionHeight()/4.8f);
        return collisionRectangle;
    }

    public String getCollectableIdentifier() {
        return "bonusBillets";
    }

    @Override
    public void updateFrame() {
        stateTime += Gdx.graphics.getDeltaTime();
    }
}
