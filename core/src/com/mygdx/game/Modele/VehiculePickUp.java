package com.mygdx.game.Modele;

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

public class VehiculePickUp implements VehiculeDef {

    private TextureAtlas textureAtlas;
    private String player;

    private TextureRegion chassisTexture;
    private TextureRegion wheelTexture;
    private TextureRegion crashedChassisTexture;
    private TextureRegion crashedWheelTexture;

    private Music vehiculeSoundAccel;
    private Music vehiculeSoundDecel;
    private Music vehiculeCrashSound;

    private float[] wheelShapeFloatArray;

    private Image jaugeCadran;
    private Image jaugeAiguille;
    private Image jaugeFondBlanc;
    private Image jaugeFondRouge;
    private Image tableauDeBordTexture;
    private Image tableauNITROTexture;
    private Image tachyCadran;
    private Image tachyDiodeVerte;
    private Image tachyDiodeJaune;
    private Image tachyDiodeOrange;
    private Image tachyDiodeRouge;
    private Image tachyDiodeVerteAllumee;
    private Image tachyDiodeJauneAllumee;
    private Image tachyDiodeOrangeAllumee;
    private Image tachyDiodeRougeAllumee;
    private Group tachyDiodeEteintesGroup = new Group();
    private Group tachyDiodesAllumeesGroup = new Group();
    private Group tachyDiodesVisibleGroup = new Group();
    private Image tachyAiguille;
    private Image tachyFondBlanc;

    private BitmapFont digitalFont;
    private Label digitalTachymetre;
    private Label.LabelStyle digitalTachymetreStyle = new Label.LabelStyle();

    private Group tableauDeBordGroup = new Group();

    // réglages
    private float boostPower = 200;
    private Vector2 jumpPower = new Vector2(150, 150);
    private float carWidth = 64;
    private float carHeight = 16;
    private float wheelRadius;
    private float[] chassisShapeFloatArray;
    private int chassisFixtureDefDensity = 2000;
    private int wheelFixtureDefFriction = 80;
    private float wheelFixtureDefRestitution = 0.001f;
    private float deadBoxShapeRadius = 10;
    private Vector2 neckLocalAnchorAPosition = new Vector2(6.3f,12.5f);
    private Vector2 neckLocalAnchorBPosition = new Vector2(0,-7.5f);
    private Vector2 wheelLocalAnchorAPosition;
    private float axisDefFrequencyHz = 8;
    private float scaleSprite = 0.25f;
    private int prime = 95;

    private int randomVehicule;
    private String accelSoundRef = "PickUpSoundEffect-accel.mp3";
    private String decelSoundRef = "PickUpSoundEffect-decel.mp3";
    private String atlasRef = "postLoading_VehiculePickUp.atlas";

    public VehiculePickUp(MTCGame mtcGame, String player) {
        this.player = player;
        this.vehiculeCrashSound = mtcGame.getAssetManager().get("monsterCrash.mp3", Music.class);
        textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas",TextureAtlas.class);

        wheelTexture = textureAtlas.findRegion("pickup_wheel");
        crashedWheelTexture = textureAtlas.findRegion("pickup_crashedWheel");


        if(player.equals("ok")){
            this.vehiculeSoundAccel = mtcGame.getAssetManager().get("PickUpSoundEffect-accel.mp3", Music.class);
            this.vehiculeSoundDecel = mtcGame.getAssetManager().get("PickUpSoundEffect-decel.mp3", Music.class);

            TextureAtlas textureAtlasTabBord = mtcGame.getAssetManager().get("postLoading_VehiculePickUp.atlas",TextureAtlas.class);
            jaugeCadran = new Image(textureAtlasTabBord.findRegion("monster_jauge_cadran"));
            jaugeAiguille = new Image(textureAtlasTabBord.findRegion("jauge_aiguille"));
            jaugeFondBlanc = new Image(textureAtlasTabBord.findRegion("jauge_fondGris"));
            jaugeFondRouge = new Image(textureAtlasTabBord.findRegion("jauge_fondRouge"));
            tableauDeBordTexture = new Image(textureAtlasTabBord.findRegion("tabBord-Monster"));
            tableauNITROTexture = new Image(textureAtlasTabBord.findRegion("tabBord-Monster-NITRO"));
            tachyCadran = new Image(textureAtlasTabBord.findRegion("monster_tachy_cadran"));
            tachyDiodeVerte = new Image(textureAtlasTabBord.findRegion("diode_verte"));
            tachyDiodeJaune = new Image(textureAtlasTabBord.findRegion("diode_jaune"));
            tachyDiodeOrange = new Image(textureAtlasTabBord.findRegion("diode_orange"));
            tachyDiodeRouge = new Image(textureAtlasTabBord.findRegion("diode_rouge"));
            tachyDiodeVerteAllumee = new Image(textureAtlasTabBord.findRegion("diode_verte_allumée"));
            tachyDiodeJauneAllumee = new Image(textureAtlasTabBord.findRegion("diode_jaune_allumée"));
            tachyDiodeOrangeAllumee = new Image(textureAtlasTabBord.findRegion("diode_orange_allumée"));
            tachyDiodeRougeAllumee = new Image(textureAtlasTabBord.findRegion("diode_rouge_allumée"));
            tachyAiguille = new Image(textureAtlasTabBord.findRegion("tachy_aiguille"));
            tachyFondBlanc = new Image(textureAtlasTabBord.findRegion("tachy_fondBlanc"));

            digitalFont = mtcGame.getAssetManager().get("digitalTachy.fnt", BitmapFont.class);
        }

        wheelShapeFloatArray = new float[]{-wheelTexture.getRegionWidth() / 4, wheelTexture.getRegionHeight() / 2,
                -wheelTexture.getRegionWidth() / 2, wheelTexture.getRegionHeight() / 4,
                -wheelTexture.getRegionWidth() / 2, -wheelTexture.getRegionHeight() / 4,
                -wheelTexture.getRegionWidth() / 4, -wheelTexture.getRegionHeight() / 2,
                wheelTexture.getRegionWidth() / 4, -wheelTexture.getRegionHeight() / 2,
                wheelTexture.getRegionWidth() / 2, -wheelTexture.getRegionHeight() / 4,
                wheelTexture.getRegionWidth() / 2, wheelTexture.getRegionHeight() / 4,
                wheelTexture.getRegionWidth() / 4, wheelTexture.getRegionHeight() / 2};

        chassisShapeFloatArray = new float[]{-carWidth / 2, -carHeight / 2, carWidth / 2, -carHeight / 2,
                carWidth / 2 * 0.4f, carHeight * 0.8f, -carWidth / 2 * 0.8f, carHeight / 1.25f};


    }

    private TextureRegion createChassisTexture(){
        if(player.equals("ok")){
            chassisTexture = textureAtlas.findRegion("pickup_chassis");
        }else{
            randomVehicule = MathUtils.random(0,3);
            if(randomVehicule == 0){
                chassisTexture = textureAtlas.findRegion("pickup_chassis-2");
            }
            if(randomVehicule == 1){
                chassisTexture = textureAtlas.findRegion("pickup_chassis-3");
            }
            if(randomVehicule == 2){
                chassisTexture = textureAtlas.findRegion("pickup_chassis-4");
            }
            if(randomVehicule == 3){
                chassisTexture = textureAtlas.findRegion("pickup_chassis-5");
            }
        }
        return chassisTexture;
    }

    private TextureRegion createCrashedChassisTexture(){
        if(player.equals("ok")){
            crashedChassisTexture = textureAtlas.findRegion("pickup_crashedChassis");
        }else{
            if(randomVehicule == 0){
                crashedChassisTexture = textureAtlas.findRegion("pickup_crashedChassis-2");
            }
            if(randomVehicule == 1){
                crashedChassisTexture = textureAtlas.findRegion("pickup_crashedChassis-3");
            }
            if(randomVehicule == 2){
                crashedChassisTexture = textureAtlas.findRegion("pickup_crashedChassis-4");
            }
            if(randomVehicule == 3){
                crashedChassisTexture = textureAtlas.findRegion("pickup_crashedChassis-5");
            }
        }
        return crashedChassisTexture;
    }

    private float createWheelRadius(){
        if(player.equals("ok")){
            wheelRadius = 16;
        }else{
            wheelRadius = 12;
        }
        return wheelRadius;
    }

    private Vector2 createWheelLocalAnchorAPosition(){
        if(player.equals("ok")){
            wheelLocalAnchorAPosition  = new Vector2(-24,-20);
        }else{
            wheelLocalAnchorAPosition  = new Vector2(-24,-10.8f);
        }
        return wheelLocalAnchorAPosition;
    }


    private Group HUDTableauDeBordGroup(Stage stage, Viewport stageViewport, float vitesse, BitmapFont scoreFont) {
        // tableau de bord : partie NITRO
        tableauNITROTexture.setPosition(stageViewport.getWorldWidth() / 2 - tableauNITROTexture.getWidth() / 2, stageViewport.getWorldHeight() / 2 - tableauNITROTexture.getHeight());
        tableauNITROTexture.setOrigin(tableauNITROTexture.getWidth() / 2, tableauNITROTexture.getHeight() / 2);
        tableauNITROTexture.setScale(0.6f);
        tableauNITROTexture.setVisible(false);
        stage.addActor(tableauNITROTexture);

        // tableau de bord complet
        tableauDeBordTexture.setPosition(stageViewport.getWorldWidth() / 2 - tableauDeBordTexture.getWidth() / 2, stageViewport.getWorldHeight() / 2 - tableauDeBordTexture.getHeight()*1.01f);
        tableauDeBordTexture.setOrigin(tableauDeBordTexture.getWidth() / 2, tableauDeBordTexture.getHeight() / 2);
        tableauDeBordTexture.setScale(0.6f);
        stage.addActor(tableauDeBordTexture);

        // JAUGE
        // icone jauge fond blanc
        jaugeFondBlanc.setPosition(stageViewport.getWorldWidth() / 4.2f, stageViewport.getWorldHeight() / 6.5f - jaugeFondBlanc.getHeight() / 1.8f);
        jaugeFondBlanc.setOrigin(jaugeFondBlanc.getWidth() / 2, jaugeFondBlanc.getHeight() / 2);
        jaugeFondBlanc.setScale(0.85f);
        stage.addActor(jaugeFondBlanc);

        // icone jauge fond rouge
        jaugeFondRouge.setPosition(jaugeFondBlanc.getX(), jaugeFondBlanc.getY());
        jaugeFondRouge.setOrigin(jaugeFondRouge.getWidth() / 2, jaugeFondRouge.getHeight() / 2);
        jaugeFondRouge.setScale(0.85f);
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
        tachyFondBlanc.setVisible(false);
        stage.addActor(tachyFondBlanc);

        // icone tachymètre cadre
        tachyCadran.setPosition(tachyFondBlanc.getX(), tachyFondBlanc.getY());
        stage.addActor(tachyCadran);

        // icone tachymètre aiguille
        tachyAiguille.setPosition(tachyFondBlanc.getX(), tachyFondBlanc.getY());
        tachyAiguille.setOrigin(tachyAiguille.getWidth() / 2, tachyAiguille.getHeight() / 2);
        tachyAiguille.setVisible(false);
        stage.addActor(tachyAiguille);


        // DIODES


        // diode verte
        tachyDiodeVerte.setPosition(tachyDiodeEteintesGroup.getX(), tachyDiodeEteintesGroup.getY() - tachyDiodeVerte.getHeight());
        tachyDiodeVerte.setOrigin(tachyDiodeVerte.getWidth() / 2, tachyDiodeVerte.getHeight() / 2);
        stage.addActor(tachyDiodeVerte);

        // diode jaune
        tachyDiodeJaune.setPosition(tachyDiodeEteintesGroup.getX(), tachyDiodeEteintesGroup.getY());
        tachyDiodeJaune.setOrigin(tachyDiodeJaune.getWidth() / 2, tachyDiodeJaune.getHeight() / 2);
        stage.addActor(tachyDiodeJaune);

        // diode orange
        tachyDiodeOrange.setPosition(tachyDiodeEteintesGroup.getX(), tachyDiodeEteintesGroup.getY() + tachyDiodeVerte.getHeight());
        tachyDiodeOrange.setOrigin(tachyDiodeOrange.getWidth() / 2, tachyDiodeOrange.getHeight() / 2);
        stage.addActor(tachyDiodeOrange);

        // diode rouge
        tachyDiodeRouge.setPosition(tachyDiodeEteintesGroup.getX(), tachyDiodeEteintesGroup.getY() + tachyDiodeVerte.getHeight() * 2);
        tachyDiodeRouge.setOrigin(tachyDiodeRouge.getWidth() / 2, tachyDiodeRouge.getHeight() / 2);
        stage.addActor(tachyDiodeRouge);

        tachyDiodeEteintesGroup.addActor(tachyDiodeVerte);
        tachyDiodeEteintesGroup.addActor(tachyDiodeJaune);
        tachyDiodeEteintesGroup.addActor(tachyDiodeOrange);
        tachyDiodeEteintesGroup.addActor(tachyDiodeRouge);
        tachyDiodeEteintesGroup.setOrigin(tachyDiodeEteintesGroup.getWidth() / 2, tachyDiodeEteintesGroup.getHeight() / 2);
        tachyDiodeEteintesGroup.setScale(0.25f);
        tachyDiodeEteintesGroup.setPosition(stageViewport.getWorldWidth() / 2.25f, stageViewport.getWorldHeight() / 7);
        stage.addActor(tachyDiodeEteintesGroup);

        // diode verte allumée
        tachyDiodeVerteAllumee.setPosition(tachyDiodesAllumeesGroup.getX(), tachyDiodesAllumeesGroup.getY() - tachyDiodeVerteAllumee.getHeight());
        tachyDiodeVerteAllumee.setOrigin(tachyDiodeVerteAllumee.getWidth() / 2, tachyDiodeVerteAllumee.getHeight() / 2);

        stage.addActor(tachyDiodeVerteAllumee);

        tachyDiodeJauneAllumee.setPosition(tachyDiodesAllumeesGroup.getX(), tachyDiodesAllumeesGroup.getY());
        tachyDiodeJauneAllumee.setOrigin(tachyDiodeJauneAllumee.getWidth() / 2, tachyDiodeJauneAllumee.getHeight() / 2);
        tachyDiodeJauneAllumee.setVisible(false);
        stage.addActor(tachyDiodeJauneAllumee);

        tachyDiodeOrangeAllumee.setPosition(tachyDiodesAllumeesGroup.getX(), tachyDiodesAllumeesGroup.getY() + tachyDiodeVerteAllumee.getHeight());
        tachyDiodeOrangeAllumee.setOrigin(tachyDiodeOrangeAllumee.getWidth() / 2, tachyDiodeOrangeAllumee.getHeight() / 2);
        tachyDiodeOrangeAllumee.setVisible(false);
        stage.addActor(tachyDiodeOrangeAllumee);

        tachyDiodeRougeAllumee.setPosition(tachyDiodesAllumeesGroup.getX(), tachyDiodesAllumeesGroup.getY() + tachyDiodeVerteAllumee.getHeight() * 2);
        tachyDiodeRougeAllumee.setOrigin(tachyDiodeRougeAllumee.getWidth() / 2, tachyDiodeRougeAllumee.getHeight() / 2);
        tachyDiodeRougeAllumee.setVisible(false);
        stage.addActor(tachyDiodeRougeAllumee);

        tachyDiodesAllumeesGroup.addActor(tachyDiodeVerteAllumee);
        tachyDiodesAllumeesGroup.addActor(tachyDiodeJauneAllumee);
        tachyDiodesAllumeesGroup.addActor(tachyDiodeOrangeAllumee);
        tachyDiodesAllumeesGroup.addActor(tachyDiodeRougeAllumee);
        tachyDiodesAllumeesGroup.setOrigin(tachyDiodesAllumeesGroup.getWidth() / 2, tachyDiodesAllumeesGroup.getHeight() / 2);
        tachyDiodesAllumeesGroup.setScale(0.25f);
        tachyDiodesAllumeesGroup.setPosition(stageViewport.getWorldWidth() / 2.25f, stageViewport.getWorldHeight() / 7);
        stage.addActor(tachyDiodesAllumeesGroup);

        tachyDiodesVisibleGroup.addActor(tachyDiodeEteintesGroup);
        tachyDiodesVisibleGroup.addActor(tachyDiodesAllumeesGroup);
        stage.addActor(tachyDiodesVisibleGroup);

        // TACHY DIGITAL
        // affichage vitesse digital
        digitalTachymetreStyle.font = digitalFont;
        String vitesseDigitale = Integer.toString((int) vitesse);
        digitalTachymetre = new Label(vitesseDigitale, digitalTachymetreStyle);
        digitalTachymetre.setColor(Color.RED);
        digitalTachymetre.setFontScale(0.5f, 0.8f);
        digitalTachymetre.setPosition(tachyFondBlanc.getX() + tachyFondBlanc.getWidth() / 2 + digitalTachymetre.getWidth() / 2, tachyFondBlanc.getY() + tachyFondBlanc.getHeight() / 2 - digitalTachymetre.getHeight() / 1.7f);

        digitalTachymetre.setVisible(true);

        stage.addActor(digitalTachymetre);

        // ajout dans le groupe
        tableauDeBordGroup.addActor(tableauNITROTexture);
        tableauDeBordGroup.addActor(tableauDeBordTexture);
        tableauDeBordGroup.addActor(jaugeFondBlanc);
        tableauDeBordGroup.addActor(jaugeFondRouge);
        tableauDeBordGroup.addActor(jaugeCadran);
        tableauDeBordGroup.addActor(jaugeAiguille);
        tableauDeBordGroup.addActor(tachyFondBlanc);
        tableauDeBordGroup.addActor(tachyCadran);
        tableauDeBordGroup.addActor(tachyAiguille);
        tableauDeBordGroup.addActor(digitalTachymetre);
        tableauDeBordGroup.addActor(tachyDiodesVisibleGroup);
        stage.addActor(tableauDeBordGroup);
        return tableauDeBordGroup;
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


    public void setJaugeAiguilleRotation(float fuel) {
        this.jaugeAiguille.setRotation(fuel);
    }

    public void setJaugeFondRouge(boolean fuelAlarm) {
        this.jaugeFondRouge.setVisible(fuelAlarm);
    }


    /**
     * Vitesse est utilisée pour allumer des dides et non tourner l'aiguille
     * @param vitesse
     */
    public void setTachyAiguille(float vitesse) {
        if(vitesse > 2.5f){
            tachyDiodeVerteAllumee.setVisible(true);
        }else{
            tachyDiodeVerteAllumee.setVisible(false);
        }
        if(vitesse > 32.5f){
            tachyDiodeJauneAllumee.setVisible(true);
        }else{
            tachyDiodeJauneAllumee.setVisible(false);
        }
        if(vitesse > 42.5f){
            tachyDiodeOrangeAllumee.setVisible(true);
        }else{
            tachyDiodeOrangeAllumee.setVisible(false);
        }
        if(vitesse > 50){
            tachyDiodeRougeAllumee.setVisible(true);
        }else{
            tachyDiodeRougeAllumee.setVisible(false);
        }
    }

    public void setTachyFondRouge(boolean tachyAlarm) {
        this.tachyDiodesAllumeesGroup.setVisible(tachyAlarm);
    }

    public void setDigitalTachymetre(String vitesse) {
        this.digitalTachymetre.setText(vitesse);
    }

    public Group getTableauDeBordGroup(Stage stage, Viewport stageViewport, float vitesse, BitmapFont scoreFont) {
        return HUDTableauDeBordGroup(stage,stageViewport,vitesse,scoreFont);
    }


    public Image getTableauNITROTexture() {
        return tableauNITROTexture;
    }

    public TextureRegion getChassisTexture() {

        return createChassisTexture(); }

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

    @Override
    public void deadTimerVisible(boolean tachyDeadAlarm) {

    }

    @Override
    public void deadTimerLabelColorChanger(boolean tachyAlarm) {

    }

    public float getScaleSprite(TextureRegion textureRegion) {
        if(textureRegion.equals(wheelTexture) && !player.equals("ok") || textureRegion.equals(crashedWheelTexture) && !player.equals("ok")) {
            scaleSprite = 0.1875f;
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

    @Override
    public void setDeadTimerLabel(float deadTimer) {

    }

    @Override
    public void debugLog() {

    }

    @Override
    public void update() {

    }
}
