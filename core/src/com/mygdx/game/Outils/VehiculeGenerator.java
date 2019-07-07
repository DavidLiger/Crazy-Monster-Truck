package com.mygdx.game.Outils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.badlogic.gdx.physics.box2d.joints.WheelJoint;
import com.badlogic.gdx.physics.box2d.joints.WheelJointDef;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controleur.MTCGame;
import com.mygdx.game.Modele.VehiculeDef;

public class VehiculeGenerator {

    private Body chassis, leftWheel, rightWheel, deadBox;
    private WheelJoint leftAxis;
    private WheelJoint rightAxis;

    // fixture
    private Fixture chassisFixture;
    private Fixture leftWheelFixture;
    private Fixture rightWheelFixture;
    private Fixture deadBoxFixture;

    private boolean isDead;
    private boolean isCrashed;

    private VehiculeDef vehiculeDef;
    private World world;
    private PiloteGenerator pilote;

    private Array<Body> bodies = new Array<Body>();
    private Array<Joint> joints = new Array<Joint>();
    private ObjectMap<Body, Sprite> sprites = new ObjectMap<Body, Sprite>();
    private ObjectMap<Body, Sprite> crashSprites = new ObjectMap<Body, Sprite>();
    private ObjectMap<Body, Sprite> victoriousSprites = new ObjectMap<Body, Sprite>();
    private ObjectMap<Body, Sprite> bodySprites = new ObjectMap<Body, Sprite>();
    private ObjectMap<Body, TextureRegion> animNitro = new ObjectMap<Body, TextureRegion>();
    private ObjectMap<Body, TextureRegion> animWheelNitro = new ObjectMap<Body, TextureRegion>();

    private Sprite chassisSprite = new Sprite();
    private int headChoice;
    private Vector2 carPosition;

    // animation
    private Animation<TextureRegion> nitroChassisAnimAnimation;
    private Animation<TextureRegion> explosionChassisAnimAnimation;
    private Animation<TextureRegion> nitroWheelAnimAnimation;
    private float stateTime;
    private float explosionStateTime;

    private String accelSoundRef;
    private String decelSoundRef;
    private String atlasRef;

    public VehiculeGenerator(VehiculeDef vehiculeDef,MTCGame mtcGame, World world, PiloteGenerator pilote, Vector2 carPosition, int headChoice) {
        this.world = world;
        this.pilote = pilote;
        this.headChoice = headChoice;
        this.carPosition = carPosition;
        this.vehiculeDef = vehiculeDef;

        accelSoundRef = vehiculeDef.getAccelSoundRef();
        decelSoundRef = vehiculeDef.getDecelSoundRef();
        atlasRef = vehiculeDef.getAtlasRef();

        Texture wheelFlameFrameSheet = mtcGame.getAssetManager().get("frameSheets/flame_wheel_frameSheet.png",Texture.class);
        Texture chassisFlameFrameSheet = mtcGame.getAssetManager().get("frameSheets/flame_chassis_frameSheet.png",Texture.class);
        Texture chassisExplosionFrameSheet = mtcGame.getAssetManager().get("frameSheets/explosion_chassis_animation.png",Texture.class);

        nitroChassisAnimAnimation = new Animation<TextureRegion>(0.075f,SheetToFramer.sheetToFrame(chassisFlameFrameSheet,2,4));
        nitroChassisAnimAnimation.setPlayMode(Animation.PlayMode.LOOP);

        nitroWheelAnimAnimation  = new Animation<TextureRegion>(0.075f,SheetToFramer.sheetToFrame(wheelFlameFrameSheet,2,4));
        nitroWheelAnimAnimation.setPlayMode(Animation.PlayMode.LOOP);

        explosionChassisAnimAnimation = new Animation<TextureRegion>(0.075f,SheetToFramer.sheetToFrame(chassisExplosionFrameSheet,3,3));
        explosionChassisAnimAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        createBodiesAndJoints();
    }

    private void createBodiesAndJoints(){
        // shapes
        PolygonShape chassisShape = new PolygonShape();
        chassisShape.set(vehiculeDef.getChassisShapeFloatArray());

        CircleShape leftWheelShape = new CircleShape();
        leftWheelShape.setRadius(vehiculeDef.getWheelRadius());

        CircleShape rightWheelShape = new CircleShape();
        rightWheelShape.setRadius(vehiculeDef.getWheelRadius());

        // réglages fixture
        FixtureDef chassisFixtureDef = new FixtureDef();
        chassisFixtureDef.density = vehiculeDef.getChassisFixtureDefDensity();
        chassisFixtureDef.shape = chassisShape;

        // réglages fixture roue gauche
        FixtureDef leftWheelFixtureDef = new FixtureDef();
        leftWheelFixtureDef.density = vehiculeDef.getChassisFixtureDefDensity() * 2;
        leftWheelFixtureDef.friction = vehiculeDef.getWheelFixtureDefFriction();
        leftWheelFixtureDef.restitution = vehiculeDef.getWheelFixtureDefRestitution();
        leftWheelFixtureDef.shape = leftWheelShape;

        // réglages fixture roue droite
        FixtureDef rightWheelFixtureDef = new FixtureDef();
        rightWheelFixtureDef.density = vehiculeDef.getChassisFixtureDefDensity() * 8;
        rightWheelFixtureDef.friction = vehiculeDef.getWheelFixtureDefFriction();
        rightWheelFixtureDef.restitution = vehiculeDef.getWheelFixtureDefRestitution();
        rightWheelFixtureDef.shape = rightWheelShape;

        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;

        // chassis

        chassis = world.createBody(def);
        chassisFixture = chassis.createFixture(chassisFixtureDef);
        chassis.setTransform(new Vector2(carPosition.x, carPosition.y), 0);
        chassis.setUserData("chassis");

        // left wheel
        leftWheel = world.createBody(def);
        leftWheelFixture = leftWheel.createFixture(leftWheelFixtureDef);
        leftWheel.setUserData("leftWheel");

        // right wheel
        rightWheel = world.createBody(def);
        rightWheelFixture = rightWheel.createFixture(rightWheelFixtureDef);
        rightWheel.setUserData("rightWheel");

        bodies.add(chassis);
        bodies.add(rightWheel);
        bodies.add(leftWheel);

        // dead box
        CircleShape deadBoxShape = new CircleShape();
        deadBoxShape.setRadius(vehiculeDef.getDeadBoxShapeRadius());

        FixtureDef deadBoxdef = new FixtureDef();
        deadBoxdef.density = vehiculeDef.getChassisFixtureDefDensity() / 10;
        deadBoxdef.shape = deadBoxShape;

        deadBox = world.createBody(def);
        deadBoxFixture = deadBox.createFixture(deadBoxdef);
        deadBox.setUserData("deadBox");
        bodies.add(deadBox);

        RevoluteJointDef axisJointDef = new RevoluteJointDef();
        axisJointDef.bodyA = chassis;
        axisJointDef.bodyB = deadBox;
        // réglage position du cou
        axisJointDef.localAnchorA.set(vehiculeDef.getNeckLocalAnchorAPosition().x,vehiculeDef.getNeckLocalAnchorAPosition().y);
        axisJointDef.localAnchorB.set(vehiculeDef.getNeckLocalAnchorBPosition().x,vehiculeDef.getNeckLocalAnchorBPosition().y);
        axisJointDef.enableLimit = true;
        axisJointDef.upperAngle = 10 * MathUtils.degreesToRadians;
        axisJointDef.lowerAngle = -10 * MathUtils.degreesToRadians;
        axisJointDef.referenceAngle = 0;
//        axisJointDef.frequencyHz = wheelJointDefFrequencyHz / 2;
        RevoluteJoint deadBoxAxis = (RevoluteJoint) world.createJoint(axisJointDef);
        deadBoxAxis.setUserData("deadBoxAxis");
        joints.add(deadBoxAxis);


        // left axis
        WheelJointDef axisDef = new WheelJointDef();
        axisDef.bodyA = chassis;
        axisDef.bodyB = leftWheel;
        axisDef.localAnchorA.set(vehiculeDef.getWheelLocalAnchorAPosition().x, vehiculeDef.getWheelLocalAnchorAPosition().y - leftWheelShape.getRadius()/3);
        axisDef.localAxisA.set(Vector2.Y);
        axisDef.frequencyHz = vehiculeDef.getAxisDefFrequencyHz();

        leftAxis = (WheelJoint) world.createJoint(axisDef);

        // positions relatives des bodies
        leftWheel.setTransform(new Vector2(carPosition.x + axisDef.localAnchorA.x,
                carPosition.y + axisDef.localAnchorA.y), 0);
        rightWheel.setTransform(new Vector2(carPosition.x - axisDef.localAnchorA.x,
                carPosition.y + axisDef.localAnchorA.y), 0);
        deadBox.setTransform(new Vector2(carPosition.x, carPosition.y + 20), 0);

        // right axis
        axisDef.bodyB = rightWheel;
        axisDef.localAnchorA.x *= -1;
        rightAxis = (WheelJoint) world.createJoint(axisDef);

        leftWheelShape.dispose();
        rightWheelShape.dispose();
        chassisShape.dispose();

        // sprites associées aux bodies
        for (Body body : bodies) {
            Sprite sprite = createSpritesForBodies(body);
            if (sprite != null) sprites.put(body, sprite);
        }

        // sprites "crashées" associées aux bodies
        for (Body body : bodies) {
            Sprite sprite = createCrashedSpritesForBodies(body);
            if (sprite != null) crashSprites.put(body, sprite);
        }

        // sprites "victorieux" associées aux bodies
        for (Body body : bodies) {
            Sprite sprite = createVictoriouspritesForBodies(body);
            if (sprite != null) victoriousSprites.put(body, sprite);
        }

    }

    private Sprite createSpritesForBodies(Body body) {
        if ("deadBox".equals(body.getUserData())) {
            return pilote.getHeadSprite(headChoice);
        }
        if ("chassis".equals(body.getUserData())) {
            chassisSprite = createSprite(vehiculeDef.getChassisTexture());
            return chassisSprite;
        }
        if ("leftWheel".equals(body.getUserData())) {
            return createSprite(vehiculeDef.getWheelTexture());
        }
        if ("rightWheel".equals(body.getUserData())) {
            return createSprite(vehiculeDef.getWheelTexture());
        }
        return null;
    }

    private Sprite createCrashedSpritesForBodies(Body body) {
        if ("deadBox".equals(body.getUserData())) {
            return pilote.getCrashedHeadSprite(headChoice);
        }
        if ("chassis".equals(body.getUserData())) {
            return createSprite(vehiculeDef.getCrashedChassisTexture());
        }
        if ("leftWheel".equals(body.getUserData())) {
            return createSprite(vehiculeDef.getCrashedWheelTexture());
        }
        if ("rightWheel".equals(body.getUserData())) {
            return createSprite(vehiculeDef.getCrashedWheelTexture());
        }
        return null;
    }

    private Sprite createVictoriouspritesForBodies(Body body) {
        if ("deadBox".equals(body.getUserData())) {
            return pilote.getVictoriousHeadSprite(headChoice);
        }
        if ("chassis".equals(body.getUserData())) {
            return createSprite(vehiculeDef.getChassisTexture());

        }
        if ("leftWheel".equals(body.getUserData())) {
            return createSprite(vehiculeDef.getWheelTexture());
        }
        if ("rightWheel".equals(body.getUserData())) {
            return createSprite(vehiculeDef.getWheelTexture());
        }
        return null;
    }

    private Sprite createSprite(TextureRegion textureRegion) {
        Sprite sprite = new Sprite(textureRegion);
        sprite.setScale(vehiculeDef.getScaleSprite(textureRegion));
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        return sprite;
    }

    private void drawHead(SpriteBatch batch) {
        // dessins sur bodies
        for (Body body : sprites.keys()) {
            if(body.getUserData().equals("deadBox")){
                Sprite sprite = sprites.get(body);
                sprite.draw(batch);
            }
        }
    }

    private void drawChassis(SpriteBatch batch){
        for (Body body : sprites.keys()) {
            if(body.getUserData().equals("chassis")){
                Sprite sprite = sprites.get(body);
                sprite.draw(batch);
            }
        }
    }

    public void draw(SpriteBatch batch) {
        // méthodes séparées pour superposition ordonnée des sprites
        drawHead(batch);
        drawChassis(batch);
        // dessins sur bodies
        for (Body body : sprites.keys()) {
            if(!body.getUserData().equals("deadBox") && !body.getUserData().equals("chassis") ){
                Sprite sprite = sprites.get(body);
                sprite.draw(batch);
            }
        }
    }

    public void drawCrash(SpriteBatch batch) {
        for (Sprite sprite : crashSprites.values()) {
            sprite.draw(batch);
        }
    }

    public void drawVictorious(SpriteBatch batch){
        for (Sprite sprite : victoriousSprites.values()) {
            sprite.draw(batch);
        }
    }

    public void drawNitroAnim(SpriteBatch batch){
        stateTime += Gdx.graphics.getDeltaTime();
        // boucle pour mettre à jour image
        // "nitro" associées aux bodies
        for (Body body : bodies) {
            if(body.getUserData().equals("chassis")){
                TextureRegion currentFrame = nitroChassisAnimAnimation.getKeyFrame(stateTime, true);
                if (currentFrame != null) animNitro.put(body, currentFrame);
            }
            if(body.getUserData().equals("leftWheel") || body.getUserData().equals("rightWheel")){
                TextureRegion currentFrame = nitroWheelAnimAnimation.getKeyFrame(stateTime,true);
                if(currentFrame != null) animWheelNitro.put(body, currentFrame);
            }
        }
        // boucle pour l'extraire et la dessiner
        for (Body body : animNitro.keys()){
            TextureRegion textureRegion = animNitro.get(body);
            batch.draw(textureRegion,body.getPosition().x-textureRegion.getRegionWidth()/2.7f,body.getPosition().y-textureRegion.getRegionHeight()/3.6f,textureRegion.getRegionWidth()/2,textureRegion.getRegionHeight()/2);
        }
        for (Body body : animWheelNitro.keys()){
            TextureRegion textureRegion = animWheelNitro.get(body);
            batch.draw(textureRegion,body.getPosition().x-textureRegion.getRegionWidth()/2.8f,body.getPosition().y-textureRegion.getRegionHeight()/2.15f,textureRegion.getRegionWidth()/2,textureRegion.getRegionHeight());
        }

    }

    public void drawExplosionAnim(SpriteBatch batch) {
        Vector2 position = new Vector2();
        if(chassis != null){
            position = chassis.getPosition();
        }
        explosionStateTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = explosionChassisAnimAnimation.getKeyFrame(explosionStateTime,true);
        // lecture Unique
        if(explosionStateTime < 0.65f){
            batch.draw(currentFrame,position.x - currentFrame.getRegionWidth()/2,
                    position.y-currentFrame.getRegionHeight()/2,
                    currentFrame.getRegionWidth()*0.8f,currentFrame.getRegionHeight()*0.8f);
        }
    }



    public void updateSpritePositions(ObjectMap<Body, Sprite> objectMap) {
        for (Body body : objectMap.keys()) {
            Sprite sprite = objectMap.get(body);
            sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2f, body.getPosition().y - sprite.getHeight() / 2f);
            sprite.setRotation(MathUtils.radiansToDegrees * body.getAngle());
        }
    }

    public void updateBodySpritePositions(ObjectMap<Body, Sprite> objectMap) {
        for (Body body : objectMap.keys()) {
            Sprite sprite = objectMap.get(body);
            sprite.setPosition(body.getPosition().x - sprite.getWidth() /2,
                    body.getPosition().y - sprite.getHeight() / 2);
            sprite.setRotation(MathUtils.radiansToDegrees * body.getAngle());
        }
    }

    public void destroyBodiesAndSprites() {
        for (Body body : sprites.keys()) {
            sprites.remove(body);
        }
        world.destroyBody(chassis);
        world.destroyBody(leftWheel);
        world.destroyBody(rightWheel);
        world.destroyBody(deadBox);
    }


    public void crashJoints() {
        if (leftAxis != null) {
            world.destroyJoint(leftAxis);
            leftAxis = null;
        }
        if (rightAxis != null) {
            world.destroyJoint(rightAxis);
            rightAxis = null;
        }
    }

    public Group getTableauDeBordGroup(Stage stage, Viewport stageViewport, float vitesse, BitmapFont scoreFont) {
        return vehiculeDef.getTableauDeBordGroup(stage,stageViewport,vitesse,scoreFont);
    }


    public Fixture getLeftWheelFixture() {
        return leftWheelFixture;
    }

    public Fixture getRightWheelFixture() {
        return rightWheelFixture;
    }

    public Body getLeftWheel() {
        return leftWheel;
    }

    public Body getRightWheel() {
        return rightWheel;
    }

    public Body getChassis() {
        return chassis;
    }

    public Body getDeadBox() {
        return deadBox;
    }

    public float getBoostPower() {
        return vehiculeDef.getBoostPower();
    }
    public float getChassisAngularVelocity() {
        return -0.5f;
    }

    public Vector2 getJumpPower() {
        return vehiculeDef.getJumpPower();
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public Fixture getDeadBoxFixture() {
        return deadBoxFixture;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setCrashed(boolean crashed) {
        isCrashed = crashed;
    }

    public boolean isCrashed() {
        return isCrashed;
    }

    public int getPrime() {
        return vehiculeDef.getPrime();
    }

    public Music getVehiculeSoundAccel() {
        return vehiculeDef.getVehiculeSoundAccel();
    }

    public Music getVehiculeSoundDecel() {
        return vehiculeDef.getVehiculeSoundDecel();
    }

    public Sprite getChassisSprite() {
        return chassisSprite;
    }

    public Music getVehiculeCrashSound() {
        return vehiculeDef.getVehiculeCrashSound();
    }

    public ObjectMap<Body, Sprite> getSprites() {
        return sprites;
    }

    public ObjectMap<Body, Sprite> getVictoriousSprites() {
        return victoriousSprites;
    }

    public ObjectMap<Body, Sprite> getBodySprites() {
        return bodySprites;
    }

    public float[] getChassisShapeFloatArray() {
        return vehiculeDef.getChassisShapeFloatArray();
    }

    public float[] getWheelShapeFloatArray() {
        return vehiculeDef.getWheelShapeFloatArray();
    }

    public void setJaugeAiguilleRotation(float fuel) {
        vehiculeDef.setJaugeAiguilleRotation(fuel);
    }

    public void setJaugeFondRouge(boolean fuelAlarm) {
        vehiculeDef.setJaugeFondRouge(fuelAlarm);
    }

    public void setTachyAiguille(float vitesse) {
        vehiculeDef.setTachyAiguille(vitesse);
    }

    public void setDeadTimerLabel(float deadTimer) {
        vehiculeDef.setDeadTimerLabel(deadTimer);
    }

    public void setDigitalTachymetre(String vitesse) {
        vehiculeDef.setDigitalTachymetre(vitesse);
    }

    public void deadTimerLabelColorChanger(boolean tachyAlarm) {
        vehiculeDef.deadTimerLabelColorChanger(tachyAlarm);
    }

    public void deadTimerVisible(boolean tachyDeadAlarm) {
        vehiculeDef.deadTimerVisible(tachyDeadAlarm);
    }

    public void setTachyFondRouge(boolean tachyAlarm) {
        vehiculeDef.setTachyFondRouge(tachyAlarm);
    }


    public Fixture getChassisFixture() {
        return chassisFixture;
    }

    public Image getTableauNITROTexture() {
        return vehiculeDef.getTableauNITROTexture();
    }

    public ObjectMap<Body, Sprite> getCrashSprites() {
        return crashSprites;
    }

    public String getAccelSoundRef() {
        return accelSoundRef;
    }

    public String getDecelSoundRef() {
        return decelSoundRef;
    }

    public String getAtlasRef() {
        return atlasRef;
    }

    public void update() {
        vehiculeDef.update();
    }

    public void debugLog(){
//        Gdx.app.log("deathPositionX",Float.toString(deathPosition.x));
//        Gdx.app.log("nitroEnemyMessage",nitroEnemyExplosionText);
//        Gdx.app.log("stateTime",Float.toString(stateTime));
        vehiculeDef.debugLog();

    }

}