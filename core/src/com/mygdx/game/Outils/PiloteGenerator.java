package com.mygdx.game.Outils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.Controleur.MTCGame;

public class PiloteGenerator {

    private Sprite headSprite;
    private Sprite crashedHeadSprite;
    private Sprite victoriousHeadSprite;
    private float[] headShapeFloatArray;
    private  float[][] piloteSkills = new float[12][2];
    private int randomHead;
    private Music animalSound;

    private TextureAtlas textureAtlas;
    private Texture frameSheet;
    private MTCGame mtcGame;

    private String animalSoundRef;
    private String animationFrameSheetRef;
    private int headChoice;

    public PiloteGenerator(MTCGame mtcGame, int headChoice){

        this.mtcGame = mtcGame;
        this.headChoice = headChoice;
        textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas",TextureAtlas.class);

        // [0] = poids ; [1] = nervosité
        piloteSkills[0][0] = -0.5f;piloteSkills[0][1] = 75;
        piloteSkills[1][0] = 4;piloteSkills[1][1] = 50;
        piloteSkills[2][0] = -1.4f;piloteSkills[2][1] = 75;
        piloteSkills[3][0] = -1;piloteSkills[3][1] = 5;
        piloteSkills[4][0] = -1.2f;piloteSkills[4][1] = 5;
        piloteSkills[5][0] = -1;piloteSkills[5][1] = 20;
        piloteSkills[6][0] = 1.5f;piloteSkills[6][1] = 10;
        piloteSkills[7][0] = 6;piloteSkills[7][1] = 35;
        piloteSkills[8][0] = 7;piloteSkills[8][1] = 40;
        piloteSkills[9][0] = 7;piloteSkills[9][1] = 80;
        piloteSkills[10][0] = -1;piloteSkills[10][1] = 75;
        piloteSkills[11][0] = -1.2f;piloteSkills[11][1] = 100;

        createAnimalSound();

    }

    private Sprite createHeadSprite(int headChoice) {
        if (headChoice != 99) {
            if (headChoice == 0) {
                headSprite = new Sprite(textureAtlas.findRegion("requinHead"));
            }
            if (headChoice == 1) {
                headSprite = new Sprite(textureAtlas.findRegion("wolfHead"));
            }
            if (headChoice == 2) {
                headSprite = new Sprite(textureAtlas.findRegion("T-RexHead"));
            }
            if (headChoice == 3) {
                headSprite = new Sprite(textureAtlas.findRegion("horseHead"));
            }
            if (headChoice == 4) {
                headSprite = new Sprite(textureAtlas.findRegion("rhinoHead"));
            }
            if (headChoice == 5) {
                headSprite = new Sprite(textureAtlas.findRegion("chimpanzeHead"));
            }
            if (headChoice == 6) {
                headSprite = new Sprite(textureAtlas.findRegion("tortueHead"));
            }
            if (headChoice == 7) {
                headSprite = new Sprite(textureAtlas.findRegion("aigleHead"));
            }
            if (headChoice == 8) {
                headSprite = new Sprite(textureAtlas.findRegion("perroquetHead"));
            }
            if (headChoice == 9) {
                headSprite = new Sprite(textureAtlas.findRegion("coqHead"));
            }
            if (headChoice == 10) {
                headSprite = new Sprite(textureAtlas.findRegion("crocoHead"));
            }
            if (headChoice == 11) {
                headSprite = new Sprite(textureAtlas.findRegion("oursHead"));
            }

        } else {
            randomHead = MathUtils.random(0, 59);
            headSprite = HeadSpriteRandomGenerator.generateRandomizeHead(mtcGame,randomHead);
        }
        headSprite.setScale(0.25f, 0.25f);
        headSprite.setOrigin(headSprite.getWidth() / 2, headSprite.getHeight() / 2);
        return headSprite;
    }

    private Sprite createCrashedHeadSprite(int headChoice) {
        if (headChoice != 99) {
            if (headChoice == 0) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("requinCrashedHead"));
            }
            if (headChoice == 1) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("wolfCrashedHead"));
            }
            if (headChoice == 2) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("T-RexCrashedHead"));
            }
            if (headChoice == 3) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("horseCrashedHead"));
            }
            if (headChoice == 4) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("rhinoHeadCrashed"));
            }
            if (headChoice == 5) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("chimpanzeCrashedHead"));
            }
            if (headChoice == 6) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("tortueCrashedHead"));
            }
            if (headChoice == 7) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("aigleCrashedHead"));
            }
            if (headChoice == 8) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("perroquetCrashedHead"));
            }
            if (headChoice == 9) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("coqCrashedHead"));
            }
            if (headChoice == 10) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("crocoCrashedHead"));
            }
            if (headChoice == 11) {
                crashedHeadSprite = new Sprite(textureAtlas.findRegion("oursCrashedHead"));
            }

        } else {
            crashedHeadSprite = HeadSpriteRandomGenerator.generateRandomizeCrashedHead(mtcGame,randomHead);
        }
        crashedHeadSprite.setScale(0.25f, 0.25f);
        crashedHeadSprite.setOrigin(crashedHeadSprite.getWidth() / 2, crashedHeadSprite.getHeight() / 2);
        return crashedHeadSprite;
    }

    private Sprite createVictoriousHeadSprite(int headChoice) {
        if (headChoice == 0) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousRequinHead"));
        }
        if (headChoice == 1) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousWolfHead"));
        }
        if (headChoice == 2) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousT-RexHead"));
        }
        if (headChoice == 3) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousHorseHead"));
        }
        if (headChoice == 4) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousRhinoHead"));
        }
        if (headChoice == 5) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousChimpanzeHead"));
        }
        if (headChoice == 6) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousTortueHead"));
        }
        if (headChoice == 7) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousAigleHead"));
        }
        if (headChoice == 8) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousPerroquetHead"));
        }
        if (headChoice == 9) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousCoqHead"));
        }
        if (headChoice == 10) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousCrocoHead"));
        }
        if (headChoice == 11) {
            victoriousHeadSprite = new Sprite(textureAtlas.findRegion("victoriousOursHead"));
        }
        victoriousHeadSprite.setScale(0.25f, 0.25f);
        victoriousHeadSprite.setOrigin(victoriousHeadSprite.getWidth() / 2, victoriousHeadSprite.getHeight() / 2);
        return victoriousHeadSprite;
    }

    private void createAnimalSound(){
        if (headChoice == 0) {
            animalSound = mtcGame.getAssetManager().get("sharkSound.mp3",Music.class);
            animalSoundRef = "sharkSound.mp3";
        }
        if (headChoice == 1) {
            animalSound = mtcGame.getAssetManager().get("WolfSound.mp3",Music.class);
            animalSoundRef = "WolfSound.mp3";
        }
        if (headChoice == 2) {
            animalSound = mtcGame.getAssetManager().get("TRexSound.mp3",Music.class);
            animalSoundRef = "TRexSound.mp3";
        }
        if (headChoice == 3) {
            animalSound = mtcGame.getAssetManager().get("horseSound.mp3",Music.class);
            animalSoundRef = "horseSound.mp3";
        }
        if (headChoice == 4) {
            animalSound = mtcGame.getAssetManager().get("rhinoSound.mp3",Music.class);
            animalSoundRef = "rhinoSound.mp3";
        }
        if (headChoice == 5) {
            animalSound = mtcGame.getAssetManager().get("chimpSound.mp3",Music.class);
            animalSoundRef = "chimpSound.mp3";
        }
        if (headChoice == 6) {
            animalSound = mtcGame.getAssetManager().get("turtleSound.mp3",Music.class);
            animalSoundRef = "turtleSound.mp3";
        }
        if (headChoice == 7) {
            animalSound = mtcGame.getAssetManager().get("eagleSound.mp3",Music.class);
            animalSoundRef = "eagleSound.mp3";
        }
        if (headChoice == 8) {
            animalSound = mtcGame.getAssetManager().get("parrotSound.mp3",Music.class);
            animalSoundRef = "parrotSound.mp3";
        }
        if (headChoice == 9) {
            animalSound = mtcGame.getAssetManager().get("cockSound.mp3",Music.class);
            animalSoundRef = "cockSound.mp3";
        }
        if (headChoice == 10) {
            animalSound = mtcGame.getAssetManager().get("crocoSound.mp3",Music.class);
            animalSoundRef = "crocoSound.mp3";
        }
        if (headChoice == 11) {
            animalSound = mtcGame.getAssetManager().get("bearSound.mp3",Music.class);
            animalSoundRef = "bearSound.mp3";
        }
    }

    private float[] createHeadShapeFloatArray() {
        if (headSprite != null) {
            headShapeFloatArray = new float[]{-headSprite.getWidth() / 25f, headSprite.getHeight() / 10.5f,
                    -headSprite.getWidth() / 10.5f, headSprite.getHeight() / 25f,
                    -headSprite.getWidth() / 10.5f, -headSprite.getHeight() / 25f,
                    -headSprite.getWidth() / 25f, -headSprite.getHeight() / 10.5f,
                    headSprite.getWidth() / 25f, -headSprite.getHeight() / 10.5f,
                    headSprite.getWidth() / 10.5f, -headSprite.getHeight() / 25f,
                    headSprite.getWidth() / 10.5f, headSprite.getHeight() / 25f,
                    headSprite.getWidth() / 25f, headSprite.getHeight() / 10.5f};
        }
        return headShapeFloatArray;
    }

    /**
     * ANIMATION
     */
    private void frameSheetChoicer(int headChoice, String exitChoice){
        if(headChoice == 0){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Requin_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Requin_victoire_frameSheet.png";
            }
        }
        if(headChoice == 1){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Loup_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Loup_victoire_frameSheet.png";
            }
        }
        if(headChoice == 2){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_victoire_frameSheet.png";
            }
        }
        if(headChoice == 3){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Cheval_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Cheval_victoire_frameSheet.png";
            }
        }
        if(headChoice == 4){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Rhino_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Rhino_victoire_frameSheet.png";
            }
        }
        if(headChoice == 5){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Chimpanze_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Chimpanze_victoire_frameSheet.png";
            }
        }
        if(headChoice == 6){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Tortue_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Tortue_victoire_frameSheet.png";
            }
        }
        if(headChoice == 7){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Aigle_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Aigle_victoire_frameSheet.png";
            }
        }
        if(headChoice == 8){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Perroquet_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Perroquet_victoire_frameSheet.png";
            }
        }
        if(headChoice == 9){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Coq_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Coq_victoire_frameSheet.png";
            }
        }
        if(headChoice == 10){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Croco_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Croco_victoire_frameSheet.png";
            }
        }
        if(headChoice == 11){
            if(exitChoice.equals("panne")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_panne_frameSheet.png";
            }
            if(exitChoice.equals("accident")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/T-Rex_accident_frameSheet.png";
            }
            if(exitChoice.equals("victoire")){
                frameSheet = mtcGame.getAssetManager().get("frameSheets/Ours_victoire_frameSheet.png",Texture.class);
                animationFrameSheetRef = "frameSheets/Ours_victoire_frameSheet.png";
            }
        }
    }

    public Sprite getHeadSprite(int headChoice) {
        return createHeadSprite(headChoice);
    }

    public Sprite getCrashedHeadSprite(int headChoice) {
        return createCrashedHeadSprite(headChoice);
    }

    public float[] getHeadShapeFloatArray() {
        return createHeadShapeFloatArray();
    }

    public Music getAnimalSound() {
        return animalSound;
    }

    public Sprite getVictoriousHeadSprite(int headChoice) {
        return createVictoriousHeadSprite(headChoice);
    }

    public Texture getFrameSheet(int headChoice, String exitChoice) {
        frameSheetChoicer(headChoice,exitChoice);
        return frameSheet;
    }

    public float[][] getPiloteSkills() {
        return piloteSkills;
    }

    public String getAnimalSoundRef() {
        return animalSoundRef;
    }

    public String getAnimationFrameSheetRef() {
        return animationFrameSheetRef;
    }

    public void debuglog(){
        Gdx.app.log("animalSoundRef",animalSoundRef);
    }
}