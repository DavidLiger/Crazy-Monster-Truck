package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controleur.MTCGame;

public class VehiculeCustom implements VehiculeDef{

    private VehiculeDef vehiculeDefRouesPart;
    private VehiculeDef vehiculeDefMoteurPart;
    private VehiculeDef vehiculeDefChassisPart;
    private MTCGame mtcGame;
    private String player;

    private TextureRegion chassisTexture;
    private TextureRegion wheelTexture;
    private TextureRegion crashedChassisTexture;
    private TextureRegion crashedWheelTexture;

    private Music vehiculeCrashSound;
    private Music vehiculeSoundAccel;
    private Music vehiculeSoundDecel;

    private float[] wheelShapeFloatArray;
    private float[] chassisShapeFloatArray;

    private String accelSoundRef;
    private String decelSoundRef;
    private String atlasRef;

    //réglages
    private float boostPower;
    private Vector2 jumpPower;
    private float wheelRadius;
    private int chassisFixtureDefDensity;
    private int wheelFixtureDefFriction;
    private float wheelFixtureDefRestitution;
    private float deadBoxShapeRadius;
    private Vector2 neckLocalAnchorAPosition;
    private Vector2 neckLocalAnchorBPosition;
    private Vector2 wheelLocalAnchorAPosition;
    private float axisDefFrequencyHz;
    private float scaleSprite;
    private int prime;

    public VehiculeCustom(MTCGame mtcGame, String player) {
        this.mtcGame = mtcGame;
        this.player = player;
        createVehiculeDefParts();
        if(vehiculeDefRouesPart != null && vehiculeDefMoteurPart != null && vehiculeDefChassisPart != null){
            chassisTexture = vehiculeDefChassisPart.getChassisTexture();
            crashedChassisTexture = vehiculeDefChassisPart.getCrashedChassisTexture();
            wheelTexture = vehiculeDefRouesPart.getWheelTexture();
            crashedWheelTexture = vehiculeDefRouesPart.getCrashedWheelTexture();

            vehiculeCrashSound = vehiculeDefChassisPart.getVehiculeCrashSound();
            vehiculeSoundAccel = vehiculeDefMoteurPart.getVehiculeSoundAccel();
            vehiculeSoundDecel = vehiculeDefMoteurPart.getVehiculeSoundDecel();
            accelSoundRef = vehiculeDefMoteurPart.getAccelSoundRef();
            decelSoundRef = vehiculeDefMoteurPart.getDecelSoundRef();
            atlasRef = vehiculeDefChassisPart.getAtlasRef();

            wheelShapeFloatArray = vehiculeDefRouesPart.getWheelShapeFloatArray();
            chassisShapeFloatArray = vehiculeDefChassisPart.getChassisShapeFloatArray();

            // réglages
            boostPower = vehiculeDefMoteurPart.getBoostPower();
            jumpPower = vehiculeDefChassisPart.getJumpPower();
            wheelRadius = vehiculeDefRouesPart.getWheelRadius();
            chassisFixtureDefDensity = vehiculeDefChassisPart.getChassisFixtureDefDensity();
            wheelFixtureDefFriction = vehiculeDefRouesPart.getWheelFixtureDefFriction();
            wheelFixtureDefRestitution = vehiculeDefRouesPart.getWheelFixtureDefRestitution();
            deadBoxShapeRadius = vehiculeDefChassisPart.getDeadBoxShapeRadius();
            neckLocalAnchorAPosition = vehiculeDefChassisPart.getNeckLocalAnchorAPosition();
            neckLocalAnchorBPosition = vehiculeDefChassisPart.getNeckLocalAnchorBPosition();
            wheelLocalAnchorAPosition = vehiculeDefChassisPart.getWheelLocalAnchorAPosition();
            axisDefFrequencyHz = vehiculeDefChassisPart.getAxisDefFrequencyHz();
            scaleSprite = vehiculeDefChassisPart.getScaleSprite(wheelTexture);
            prime = vehiculeDefChassisPart.getPrime();
        }
    }

    private void createVehiculeDefParts(){
        // SANSPERMIS
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 100
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 101
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 102){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 100){
                vehiculeDefRouesPart = new VehiculeSansPermis(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 101){
                vehiculeDefMoteurPart = new VehiculeSansPermis(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 102){
                vehiculeDefChassisPart = new VehiculeSansPermis(mtcGame,player); }
        }
        // POURRI
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 200
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 201
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 202){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 200){
                vehiculeDefRouesPart = new VehiculePourri(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 201){
                vehiculeDefMoteurPart = new VehiculePourri(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 202){
                vehiculeDefChassisPart = new VehiculePourri(mtcGame,player); }
        }
        // BERLINE
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 300
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 301
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 302){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 300){
                vehiculeDefRouesPart = new VehiculeBerline(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 301){
                vehiculeDefMoteurPart = new VehiculeBerline(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 302){
                vehiculeDefChassisPart = new VehiculeBerline(mtcGame,player); }
        }
        // GT
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 400
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 401
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 402){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 400){
                vehiculeDefRouesPart = new VehiculeGT(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 401){
                vehiculeDefMoteurPart = new VehiculeGT(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 402){
                vehiculeDefChassisPart = new VehiculeGT(mtcGame,player); }
        }
        // LUXE
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 500
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 501
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 502){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 500){
                vehiculeDefRouesPart = new VehiculeLuxe(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 501){
                vehiculeDefMoteurPart = new VehiculeLuxe(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 502){
                vehiculeDefChassisPart = new VehiculeLuxe(mtcGame,player); }
        }
        // DECAPOTABLE
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 600
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 601
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 602){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 600){
                vehiculeDefRouesPart = new VehiculeDecapotable(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 601){
                vehiculeDefMoteurPart = new VehiculeDecapotable(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 602){
                vehiculeDefChassisPart = new VehiculeDecapotable(mtcGame,player); }
        }
        // LEGENDE
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 700
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 701
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 702){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 700){
                vehiculeDefRouesPart = new VehiculeLegende(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 701){
                vehiculeDefMoteurPart = new VehiculeLegende(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 702){
                vehiculeDefChassisPart = new VehiculeLegende(mtcGame,player); }
        }
        // PICKUP
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 800
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 801
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 802){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 800){
                vehiculeDefRouesPart = new VehiculePickUp(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 801){
                vehiculeDefMoteurPart = new VehiculePickUp(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 802){
                vehiculeDefChassisPart = new VehiculePickUp(mtcGame,player); }
        }
        // CAMIONETTE
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 900
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 901
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 902){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 900){
                vehiculeDefRouesPart = new VehiculeCamionette(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 901){
                vehiculeDefMoteurPart = new VehiculeCamionette(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 902){
                vehiculeDefChassisPart = new VehiculeCamionette(mtcGame,player); }
        }
        // 4X4
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1000
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1001
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1002){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1000){
                vehiculeDefRouesPart = new Vehicule4X4(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1001){
                vehiculeDefMoteurPart = new Vehicule4X4(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1002){
                vehiculeDefChassisPart = new Vehicule4X4(mtcGame,player); }
        }
        // CAMION
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1100
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1101
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1102){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1100){
                vehiculeDefRouesPart = new VehiculeCamion(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1101){
                vehiculeDefMoteurPart = new VehiculeCamion(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1102){
                vehiculeDefChassisPart = new VehiculeCamion(mtcGame,player); }
        }
        // CHANTIER
        if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1200
                || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1201
                || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1202){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1200){
                vehiculeDefRouesPart = new VehiculeChantier(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1201){
                vehiculeDefMoteurPart = new VehiculeChantier(mtcGame,player); }
            if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1202){
                vehiculeDefChassisPart = new VehiculeChantier(mtcGame,player); }
        }
    }

    @Override
    public float getBoostPower() { return boostPower; }
    @Override
    public Vector2 getJumpPower() { return jumpPower; }
    @Override
    public Music getVehiculeSoundAccel() { return vehiculeSoundAccel; }
    @Override
    public Music getVehiculeSoundDecel() { return vehiculeSoundDecel; }
    @Override
    public Music getVehiculeCrashSound() { return vehiculeCrashSound; }
    @Override
    public float[] getChassisShapeFloatArray() { return chassisShapeFloatArray; }
    @Override
    public void setJaugeAiguilleRotation(float fuel) { vehiculeDefChassisPart.setJaugeAiguilleRotation(fuel); }
    @Override
    public void setJaugeFondRouge(boolean fuelAlarm) { vehiculeDefChassisPart.setJaugeFondRouge(fuelAlarm); }
    @Override
    public void setTachyAiguille(float vitesse) { vehiculeDefChassisPart.setTachyAiguille(vitesse); }
    @Override
    public void setTachyFondRouge(boolean tachyAlarm) { vehiculeDefChassisPart.setTachyFondRouge(tachyAlarm); }
    @Override
    public void setDigitalTachymetre(String vitesse) { vehiculeDefChassisPart.setDigitalTachymetre(vitesse); }
    @Override
    public void deadTimerVisible(boolean tachyDeadAlarm) { vehiculeDefChassisPart.deadTimerVisible(tachyDeadAlarm); }
    @Override
    public void deadTimerLabelColorChanger(boolean tachyAlarm) { vehiculeDefChassisPart.deadTimerLabelColorChanger(tachyAlarm); }
    @Override
    public void setDeadTimerLabel(float deadTimer) { vehiculeDefChassisPart.setDeadTimerLabel(deadTimer); }
    @Override
    public Group getTableauDeBordGroup(Stage stage, Viewport stageViewport, float vitesse, BitmapFont scoreFont) {
        if(vehiculeDefChassisPart != null){
            return vehiculeDefChassisPart.getTableauDeBordGroup(stage,stageViewport,vitesse,scoreFont);
        }
        return null;
    }
    @Override
    public Image getTableauNITROTexture() { return vehiculeDefChassisPart.getTableauNITROTexture(); }
    @Override
    public TextureRegion getChassisTexture() { return chassisTexture; }
    @Override
    public TextureRegion getWheelTexture() { return wheelTexture; }
    @Override
    public TextureRegion getCrashedChassisTexture() { return crashedChassisTexture; }
    @Override
    public TextureRegion getCrashedWheelTexture() { return crashedWheelTexture; }
    @Override
    public int getChassisFixtureDefDensity() { return chassisFixtureDefDensity; }
    @Override
    public int getWheelFixtureDefFriction() { return wheelFixtureDefFriction; }
    @Override
    public float getWheelFixtureDefRestitution() { return wheelFixtureDefRestitution; }
    @Override
    public float getDeadBoxShapeRadius() { return deadBoxShapeRadius; }
    @Override
    public Vector2 getNeckLocalAnchorAPosition() { return neckLocalAnchorAPosition; }
    @Override
    public Vector2 getNeckLocalAnchorBPosition() { return neckLocalAnchorBPosition; }
    @Override
    public Vector2 getWheelLocalAnchorAPosition() { return wheelLocalAnchorAPosition; }
    @Override
    public float getAxisDefFrequencyHz() { return axisDefFrequencyHz; }
    @Override
    public float getWheelRadius() { return wheelRadius; }
    @Override
    public float[] getWheelShapeFloatArray() { return wheelShapeFloatArray; }
    @Override
    public float getScaleSprite(TextureRegion textureRegion) {

        return scaleSprite; }
    @Override
    public int getPrime() { return prime; }

    public String getAccelSoundRef() { return accelSoundRef; }

    public String getDecelSoundRef() { return decelSoundRef; }

    @Override
    public String getAtlasRef() {
        return atlasRef;
    }

    @Override
    public void debugLog() { }
    @Override
    public void update() { vehiculeDefChassisPart.update(); }
}
