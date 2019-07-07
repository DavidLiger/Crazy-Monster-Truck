package com.mygdx.game.Modele;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controleur.MTCGame;
import com.mygdx.game.Vue.GameScreen;

public class VehiculeCamion implements VehiculeDef{

    private TextureAtlas textureAtlas;
    private String player;

    private TextureRegion chassisTexture;
    private TextureRegion wheelTexture;
    private TextureRegion crashedChassisTexture;
    private TextureRegion crashedWheelTexture;

    private Music vehiculeCrashSound;
    private Music vehiculeSoundAccel;
    private Music vehiculeSoundDecel;

    private float[] wheelShapeFloatArray;

    private Image jaugeCadran;
    private Image jaugeAiguille;
    private Image jaugeFondBlanc;
    private Image jaugeFondRouge;
    private Image tableauDeBordTexture;
    private Image tableauNITROTexture;
    private Image tachyCadran;
    private Image tachyAiguille;
    private Image tachyFondBlanc;
    private Image tachyFondRouge;

    private Label deadTimerLabel;
    private Label.LabelStyle deadTimerLabelStyle = new Label.LabelStyle();

    private Group jaugeGroup = new Group();
    private Group tableauDeBordGroup = new Group();

    //réglages
    private float boostPower = 100;
    private Vector2 jumpPower = new Vector2(25, 50);
    private float carWidth = GameScreen.getUnitsPerMeter() * 2;
    private float carHeight = GameScreen.getUnitsPerMeter() / 2;
    private float wheelRadius;
    private float[] chassisShapeFloatArray;
    private int chassisFixtureDefDensity = 10000;
    private int wheelFixtureDefFriction = 500;
    private float wheelFixtureDefRestitution = 0.001f;
    private float deadBoxShapeRadius = 10;
    private Vector2 neckLocalAnchorAPosition = new Vector2(24,8.5f);
    private Vector2 neckLocalAnchorBPosition = new Vector2(-2,-8.5f);
    private Vector2 wheelLocalAnchorAPosition;
    private float axisDefFrequencyHz = 3.8f;
    private float scaleSprite = 0.25f;
    private int prime = 130;
    private float tachyDeadTimer = 0;

    private int randomVehicule;
    private String accelSoundRef = "CamionSoundEffect-accel.mp3";
    private String decelSoundRef = "CamionSoundEffect-decel.mp3";
    private String atlasRef = "postLoading_VehiculeCamion.atlas";


    public VehiculeCamion(MTCGame mtcGame, String player) {
        this.player = player;
        this.vehiculeCrashSound = mtcGame.getAssetManager().get("F1Crash.mp3", Music.class);
        textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas",TextureAtlas.class);

        wheelTexture = textureAtlas.findRegion("camion_wheel");
        crashedWheelTexture = textureAtlas.findRegion("camion_crashedWheel");

        if(player.equals("ok")){
            this.vehiculeSoundAccel = mtcGame.getAssetManager().get("CamionSoundEffect-accel.mp3", Music.class);
            this.vehiculeSoundDecel = mtcGame.getAssetManager().get("CamionSoundEffect-decel.mp3", Music.class);

            TextureAtlas textureAtlasTabBord = mtcGame.getAssetManager().get("postLoading_VehiculeCamion.atlas",TextureAtlas.class);
            jaugeCadran = new Image(textureAtlasTabBord.findRegion("Camion_jauge_cadran"));
            jaugeAiguille = new Image(textureAtlasTabBord.findRegion("jauge_aiguille"));
            jaugeFondBlanc = new Image(textureAtlasTabBord.findRegion("jauge_fondBlanc"));
            jaugeFondRouge = new Image(textureAtlasTabBord.findRegion("jauge_fondRouge"));
            tableauDeBordTexture = new Image(textureAtlasTabBord.findRegion("tabBord-Camion"));
            tableauNITROTexture = new Image(textureAtlasTabBord.findRegion("tabBord-Camion-NITRO"));
            tachyCadran = new Image(textureAtlasTabBord.findRegion("Camion_tachy_cadran"));
            tachyAiguille = new Image(textureAtlasTabBord.findRegion("tachy_aiguille"));
            tachyFondBlanc = new Image(textureAtlasTabBord.findRegion("tachy_fondBlanc"));
            tachyFondRouge = new Image(textureAtlasTabBord.findRegion("tachy_fondRouge"));
        }

        wheelShapeFloatArray = new float[]{-wheelTexture.getRegionWidth() / 4, wheelTexture.getRegionHeight() / 2,
                -wheelTexture.getRegionWidth() / 2, wheelTexture.getRegionHeight() / 4,
                -wheelTexture.getRegionWidth() / 2, -wheelTexture.getRegionHeight() / 4,
                -wheelTexture.getRegionWidth() / 4, -wheelTexture.getRegionHeight() / 2,
                wheelTexture.getRegionWidth() / 4, -wheelTexture.getRegionHeight() / 2,
                wheelTexture.getRegionWidth() / 2, -wheelTexture.getRegionHeight() / 4,
                wheelTexture.getRegionWidth() / 2, wheelTexture.getRegionHeight() / 4,
                wheelTexture.getRegionWidth() / 4, wheelTexture.getRegionHeight() / 2};

        chassisShapeFloatArray = new float[]{-carWidth / 1.5f, -carHeight / 1.6f, carWidth / 1.55f,
                -carHeight / 1.6f, carWidth / 1.55f, carHeight *0.95f, -carWidth / 1.5f, carHeight *0.95f};



    }

    public void update(){
        deadTimerLabel.setText(Integer.toString((int) tachyDeadTimer));
    }

    private TextureRegion createChassisTexture(){
        if(player.equals("ok")){
            chassisTexture = textureAtlas.findRegion("camion_chassis");
        }else{
            randomVehicule = MathUtils.random(0,3);
            if(randomVehicule == 0){
                chassisTexture = textureAtlas.findRegion("camion_chassis-2");
            }
            if(randomVehicule == 1){
                chassisTexture = textureAtlas.findRegion("camion_chassis-3");
            }
            if(randomVehicule == 2){
                chassisTexture = textureAtlas.findRegion("camion_chassis-4");
            }
            if(randomVehicule == 3){
                chassisTexture = textureAtlas.findRegion("camion_chassis-5");
            }
        }
        return chassisTexture;
    }

    private TextureRegion createCrashedChassisTexture(){
        if(player.equals("ok")){
            crashedChassisTexture = textureAtlas.findRegion("camion_crashedChassis");
        }else{
            if(randomVehicule == 0){
                crashedChassisTexture = textureAtlas.findRegion("camion_crashedChassis-2");
            }
            if(randomVehicule == 1){
                crashedChassisTexture = textureAtlas.findRegion("camion_crashedChassis-3");
            }
            if(randomVehicule == 2){
                crashedChassisTexture = textureAtlas.findRegion("camion_crashedChassis-4");
            }
            if(randomVehicule == 3){
                crashedChassisTexture = textureAtlas.findRegion("camion_crashedChassis-5");
            }
        }
        return crashedChassisTexture;
    }

    private float createWheelRadius(){
        if(player.equals("ok")){
            wheelRadius = 19;
        }else{
            wheelRadius = 13;
        }
        return wheelRadius;
    }

    private Vector2 createWheelLocalAnchorAPosition(){
        if(player.equals("ok")){
            wheelLocalAnchorAPosition  = new Vector2(-26.33f,-14.8f);
        }else{
            wheelLocalAnchorAPosition  = new Vector2(-26.33f,-12.8f);
        }
        return wheelLocalAnchorAPosition;
    }

    private Group HUDTableauDeBordGroup(Stage stage, Viewport stageViewport, BitmapFont scoreFont) {
        // tableau de bord : partie NIRO
        tableauNITROTexture.setPosition(stageViewport.getWorldWidth() / 2 - tableauNITROTexture.getWidth() / 2, stageViewport.getWorldHeight() / 2 - tableauNITROTexture.getHeight());
        tableauNITROTexture.setOrigin(tableauNITROTexture.getWidth() / 2, tableauNITROTexture.getHeight() / 2);
        tableauNITROTexture.setScale(0.6f);
        tableauNITROTexture.setVisible(false);
        stage.addActor(tableauNITROTexture);

        tableauDeBordTexture.setPosition(stageViewport.getWorldWidth() / 2 - tableauDeBordTexture.getWidth() / 2, stageViewport.getWorldHeight() / 2 - tableauDeBordTexture.getHeight()*1.01f);
        tableauDeBordTexture.setOrigin(tableauDeBordTexture.getWidth() / 2, tableauDeBordTexture.getHeight() / 2);
        tableauDeBordTexture.setScale(0.6f);
        stage.addActor(tableauDeBordTexture);

        // icone jauge fond blanc
        jaugeFondBlanc.setPosition(stageViewport.getWorldWidth() / 4.2f, stageViewport.getWorldHeight() / 6.5f - jaugeFondBlanc.getHeight() / 1.8f);
        jaugeFondBlanc.setOrigin(jaugeFondBlanc.getWidth() / 2, jaugeFondBlanc.getHeight() / 2);
        jaugeFondBlanc.setScale(0.85f);
        stage.addActor(jaugeFondBlanc);

        // icone jauge fond rouge
        jaugeFondRouge.setPosition(jaugeFondBlanc.getX(), jaugeFondBlanc.getY());
        jaugeFondRouge.setOrigin(jaugeFondRouge.getWidth() / 2, jaugeFondRouge.getHeight() / 2);
        jaugeFondRouge.setScale(0.85f);
        jaugeFondRouge.setVisible(false);
        stage.addActor(jaugeFondRouge);

        // icone jauge cadran
        jaugeCadran.setPosition(jaugeFondBlanc.getX(), jaugeFondBlanc.getY());
        jaugeCadran.setOrigin(jaugeCadran.getWidth() / 2, jaugeCadran.getHeight() / 2);
        jaugeCadran.setScale(0.9f);
        stage.addActor(jaugeCadran);

        // icone jauge aiguille
        jaugeAiguille.setPosition(jaugeFondBlanc.getX(), jaugeFondBlanc.getY());
        jaugeAiguille.setOrigin(jaugeAiguille.getWidth() / 2, jaugeAiguille.getHeight() / 2);
        jaugeAiguille.setScale(0.9f);
        stage.addActor(jaugeAiguille);

        // TACHYMETRE
        // icone tachymètre fond blanc
        tachyFondBlanc.setPosition(stageViewport.getWorldWidth() / 2 - tachyFondBlanc.getWidth() / 2, stageViewport.getWorldHeight() / 6.5f - tachyFondBlanc.getHeight() / 2);
        stage.addActor(tachyFondBlanc);

        // icone tachymètre cadran
        tachyCadran.setPosition(tachyFondBlanc.getX(), tachyFondBlanc.getY());
        stage.addActor(tachyCadran);

        // icone tachymètre aiguille
        tachyAiguille.setPosition(tachyFondBlanc.getX(), tachyFondBlanc.getY());
        tachyAiguille.setOrigin(tachyAiguille.getWidth() / 2, tachyAiguille.getHeight() / 2);
        stage.addActor(tachyAiguille);

        // icone tachymètre fond rouge
        tachyFondRouge.setPosition(tachyFondBlanc.getX(), tachyFondBlanc.getY());
        tachyFondRouge.setVisible(false);
        stage.addActor(tachyFondRouge);


        // compte à rebours tachyDead
        deadTimerLabelStyle.font = scoreFont;
        String compteAReboursAsString = Integer.toString((int) tachyDeadTimer);
        deadTimerLabel = new Label(compteAReboursAsString, deadTimerLabelStyle);
        deadTimerLabel.setColor(Color.RED);
        deadTimerLabel.setFontScale(2.15f);
        deadTimerLabel.setVisible(false);
        deadTimerLabel.setPosition(tachyFondBlanc.getX() + tachyFondBlanc.getWidth() / 2 - deadTimerLabel.getWidth(), tachyFondBlanc.getY() + tachyFondBlanc.getWidth() / 2 - deadTimerLabel.getHeight() / 2);
        stage.addActor(deadTimerLabel);

        tableauDeBordGroup.addActor(tableauNITROTexture);
        tableauDeBordGroup.addActor(tableauDeBordTexture);
        tableauDeBordGroup.addActor(jaugeFondBlanc);
        tableauDeBordGroup.addActor(jaugeFondRouge);
        tableauDeBordGroup.addActor(jaugeCadran);
        tableauDeBordGroup.addActor(jaugeAiguille);
        tableauDeBordGroup.addActor(tachyFondBlanc);
        tableauDeBordGroup.addActor(tachyCadran);
        tableauDeBordGroup.addActor(tachyAiguille);
        tableauDeBordGroup.addActor(tachyFondRouge);
        tableauDeBordGroup.addActor(deadTimerLabel);
        stage.addActor(tableauDeBordGroup);

        return tableauDeBordGroup;
    }

    public void deadTimerVisible(boolean tachyDeadAlarm) {
        if (tachyDeadAlarm) {
            deadTimerLabel.setVisible(true);
        } else deadTimerLabel.setVisible(false);

    }

    public void deadTimerLabelColorChanger(boolean tachyAlarm) {
        if (tachyAlarm) {
            deadTimerLabel.setColor(Color.WHITE);
        } else {
            deadTimerLabel.setColor(Color.RED);
        }
    }

    public void setDeadTimerLabel(float deadTimer) {
        tachyDeadTimer = deadTimer;
    }

    @Override
    public float getBoostPower() {
        return boostPower;
    }

    @Override
    public Vector2 getJumpPower() {
        return jumpPower;
    }

    @Override
    public Music getVehiculeSoundAccel() {
        return vehiculeSoundAccel;
    }

    @Override
    public Music getVehiculeSoundDecel() {
        return vehiculeSoundDecel;
    }

    @Override
    public Music getVehiculeCrashSound() {
        return vehiculeCrashSound;
    }

    @Override
    public float[] getChassisShapeFloatArray() {
        return chassisShapeFloatArray;
    }

    @Override
    public void setJaugeAiguilleRotation(float fuel) {
        this.jaugeAiguille.setRotation(fuel);
    }

    @Override
    public void setJaugeFondRouge(boolean fuelAlarm) {
        this.jaugeFondRouge.setVisible(fuelAlarm);
    }


    @Override
    public void setTachyAiguille(float vitesse) {
        tachyAiguille.setRotation(-vitesse * 1.95f);
    }

    @Override
    public void setTachyFondRouge(boolean tachyAlarm) {
        tachyFondRouge.setVisible(tachyAlarm);
    }

    @Override
    public void setDigitalTachymetre(String vitesse) {
    }

    public Group getTableauDeBordGroup(Stage stage, Viewport stageViewport, float vitesse, BitmapFont scoreFont) {
        return HUDTableauDeBordGroup(stage, stageViewport, scoreFont);
    }

    @Override
    public Image getTableauNITROTexture() {
        return tableauNITROTexture;
    }

    public TextureRegion getChassisTexture() {
        return createChassisTexture();
    }

    public TextureRegion getWheelTexture() {
        return wheelTexture;
    }

    public TextureRegion getCrashedChassisTexture() {
        return createCrashedChassisTexture();
    }

    public TextureRegion getCrashedWheelTexture() {
        return crashedWheelTexture;
    }

    public int getChassisFixtureDefDensity() {
        return chassisFixtureDefDensity;
    }

    public int getWheelFixtureDefFriction() {
        return wheelFixtureDefFriction;
    }

    public float getWheelFixtureDefRestitution() {
        return wheelFixtureDefRestitution;
    }

    public float getDeadBoxShapeRadius() {
        return deadBoxShapeRadius;
    }

    public Vector2 getNeckLocalAnchorAPosition() {
        return neckLocalAnchorAPosition;
    }

    public Vector2 getNeckLocalAnchorBPosition() {
        return neckLocalAnchorBPosition;
    }

    public Vector2 getWheelLocalAnchorAPosition() {
        return createWheelLocalAnchorAPosition();
    }

    public float getAxisDefFrequencyHz() {
        return axisDefFrequencyHz;
    }

    public float[] getWheelShapeFloatArray() {
        return wheelShapeFloatArray;
    }

    public float getWheelRadius() {
        return createWheelRadius();
    }

    public float getScaleSprite(TextureRegion textureRegion) {
        if(textureRegion.equals(wheelTexture) && !player.equals("ok") ||
                textureRegion.equals(crashedWheelTexture) && !player.equals("ok")) {
            scaleSprite = 0.166f;
        }else{
            scaleSprite = 0.25f;
        }
        return scaleSprite;
    }

    public int getPrime() {
        return prime;
    }

    public String getAccelSoundRef() { return accelSoundRef; }

    public String getDecelSoundRef() { return decelSoundRef; }

    public String getAtlasRef() { return atlasRef; }

    public void debugLog(){

        Gdx.app.log("tachyDeadTimerRecu",Float.toString(tachyDeadTimer));
    }
}

