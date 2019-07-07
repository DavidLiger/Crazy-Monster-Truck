package com.mygdx.game.Modele;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.joints.WheelJoint;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controleur.MTCGame;

public interface VehiculeDef {

    float getBoostPower();

    Vector2 getJumpPower();

    Music getVehiculeSoundAccel();

    Music getVehiculeSoundDecel();

    Music getVehiculeCrashSound();

    float[] getChassisShapeFloatArray();

    void setJaugeAiguilleRotation(float fuel);

    void setJaugeFondRouge(boolean fuelAlarm);

    void setTachyAiguille(float vitesse);

    void setTachyFondRouge(boolean tachyAlarm);

    void setDigitalTachymetre(String vitesse);

    void deadTimerVisible(boolean tachyDeadAlarm);

    void deadTimerLabelColorChanger(boolean tachyAlarm);

    void setDeadTimerLabel(float deadTimer);

    Group getTableauDeBordGroup(Stage stage, Viewport stageViewport, float vitesse, BitmapFont scoreFont);

    Image getTableauNITROTexture();


    TextureRegion getChassisTexture();

    TextureRegion getWheelTexture();

    TextureRegion getCrashedChassisTexture();

    TextureRegion getCrashedWheelTexture();

    int getChassisFixtureDefDensity();

    int getWheelFixtureDefFriction();

    float getWheelFixtureDefRestitution();

    float getDeadBoxShapeRadius();

    Vector2 getNeckLocalAnchorAPosition();

    Vector2 getNeckLocalAnchorBPosition();

    Vector2 getWheelLocalAnchorAPosition();

    float getAxisDefFrequencyHz();

    float getWheelRadius();

    float[] getWheelShapeFloatArray();

    float getScaleSprite(TextureRegion textureRegion);

    int getPrime();

    String getAccelSoundRef();

    String getDecelSoundRef();

    String getAtlasRef();

    void debugLog();

    void update();

}
