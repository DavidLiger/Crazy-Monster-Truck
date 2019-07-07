package com.mygdx.game.Modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.game.Controleur.MTCGame;

public class BonusMultiScore implements Collectable {

    private TextureRegion[] bonusScoreFrames = new TextureRegion[10];
    private Animation<TextureRegion> bonusScoreAnimation;
    private TextureRegion currentFrame;
    private float stateTime;

    private float positionX;
    private float positionY;
    private float upNDownPosition;
    private boolean okUp;
    private Polygon collisionRectangle;
    private String collectableIdentifier;

    public BonusMultiScore(MTCGame mtcGame,float x, float y){
        this.positionX = x;
        this.positionY = y;
        upNDownPosition = positionY;

        Texture texture = mtcGame.getAssetManager().get("frameSheets/bonusMultiScoreX3_frameSheet.png",Texture.class);
        Texture texture1 = mtcGame.getAssetManager().get("frameSheets/bonusMultiScoreX2_frameSheet.png",Texture.class);


        int X2X3Random = MathUtils.random(0,1);
        if(X2X3Random == 0){
            bonusScoreAnimation = new Animation<TextureRegion>(0.15f,bonusScoreFrames = sheetToFrame(texture));
            collectableIdentifier = "multiScoreX3";
        }
        if(X2X3Random == 1){
            bonusScoreAnimation = new Animation<TextureRegion>(0.15f,bonusScoreFrames = sheetToFrame(texture1));
            collectableIdentifier = "multiScoreX2";
        }
        bonusScoreAnimation.setPlayMode(Animation.PlayMode.LOOP);
        float[] bonusMultiScoreFloatArray = new float[]{-bonusScoreFrames[0].getRegionWidth()/2,-bonusScoreFrames[0].getRegionHeight()/2,bonusScoreFrames[0].getRegionWidth()/2,-bonusScoreFrames[0].getRegionHeight()/2,bonusScoreFrames[0].getRegionWidth()/2,bonusScoreFrames[0].getRegionHeight()/2,-bonusScoreFrames[0].getRegionWidth()/2,bonusScoreFrames[0].getRegionHeight()/2};

        // rectangle de collision
        collisionRectangle = new Polygon(bonusMultiScoreFloatArray);
        collisionRectangle.setScale(0.1035f,0.1035f);
    }

    /**
     * Stocke dans tableau à une dimension le frameSheet
     * après l'avoir splitté dans tableau temporaire à 2 dimensions
     */
    private TextureRegion[] sheetToFrame(Texture frameSheet){
        TextureRegion[] textureRegionArray = new TextureRegion[3 * 3];
        TextureRegion[][] textureRegions = TextureRegion.split(frameSheet,frameSheet.getWidth()/3,frameSheet.getHeight()/3);
        int index = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                textureRegionArray[index++] = textureRegions[i][j];
            }
        }
        return textureRegionArray;
    }

    public void draw(SpriteBatch batch){
        currentFrame =  bonusScoreAnimation.getKeyFrame(stateTime,true);
        batch.draw(currentFrame,positionX,updatePositionY(),currentFrame.getRegionWidth()/8,currentFrame.getRegionHeight()/8);
    }

    public void updateFrame(){
        stateTime += Gdx.graphics.getDeltaTime();
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
        collisionRectangle.setPosition(positionX+bonusScoreFrames[0].getRegionWidth()/15,upNDownPosition+bonusScoreFrames[0].getRegionHeight()/18);

        return collisionRectangle;
    }

    public String getCollectableIdentifier() {
        return collectableIdentifier;
    }
}
