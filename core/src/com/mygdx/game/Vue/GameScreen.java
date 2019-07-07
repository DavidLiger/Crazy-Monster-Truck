package com.mygdx.game.Vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controleur.MTCGame;
import com.mygdx.game.Modele.BonusBillets;
import com.mygdx.game.Modele.BonusGasFree;
import com.mygdx.game.Modele.BonusMultiScore;
import com.mygdx.game.Modele.BonusNitro;
import com.mygdx.game.Modele.Coin;
import com.mygdx.game.Modele.Collectable;
import com.mygdx.game.Modele.DecorCampagne;
import com.mygdx.game.Modele.DecorDecharge;
import com.mygdx.game.Modele.DecorDef;
import com.mygdx.game.Modele.DecorDesert;
import com.mygdx.game.Modele.DecorForet;
import com.mygdx.game.Modele.DecorIles;
import com.mygdx.game.Modele.DecorJungle;
import com.mygdx.game.Modele.DecorLune;
import com.mygdx.game.Modele.DecorMontagne;
import com.mygdx.game.Modele.DecorPoleNord;
import com.mygdx.game.Modele.DecorSousMarin;
import com.mygdx.game.Modele.DecorVillage;
import com.mygdx.game.Modele.DecorVille;
import com.mygdx.game.Modele.Jerrycan;
import com.mygdx.game.Modele.Vehicule4X4;
import com.mygdx.game.Modele.VehiculeBerline;
import com.mygdx.game.Modele.VehiculeCamion;
import com.mygdx.game.Modele.VehiculeCamionette;
import com.mygdx.game.Modele.VehiculeChantier;
import com.mygdx.game.Modele.VehiculeCustom;
import com.mygdx.game.Modele.VehiculeDecapotable;
import com.mygdx.game.Modele.VehiculeDef;
import com.mygdx.game.Modele.VehiculeGT;
import com.mygdx.game.Modele.VehiculeLegende;
import com.mygdx.game.Modele.VehiculeLuxe;
import com.mygdx.game.Modele.VehiculePickUp;
import com.mygdx.game.Modele.VehiculePourri;
import com.mygdx.game.Modele.VehiculeSansPermis;
import com.mygdx.game.Outils.GroundGenerator;
import com.mygdx.game.Outils.PiloteGenerator;
import com.mygdx.game.Outils.SheetToFramer;
import com.mygdx.game.Outils.VehiculeGenerator;

import java.util.Locale;


public class GameScreen extends ScreenAdapter {

    private static final float WORLD_WIDTH = 960;
    private static final float WORLD_HEIGHT = 577;
    private static final float UNITS_PER_METER = 32f;
    private static float UNIT_WIDTH = WORLD_WIDTH / UNITS_PER_METER;
    private static float UNIT_HEIGHT = WORLD_HEIGHT / UNITS_PER_METER;

    public final MTCGame mtcGame;
    private World world;
    private Box2DDebugRenderer debugRenderer;
    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private Viewport stageViewport;
    private OrthographicCamera box2dCam;
    private OrthogonalTiledMapRenderer orthogonalTiledMapRenderer;
    private SpriteBatch batch;
    private Stage stage;

    private Array<Vector2> enemiesPositions = new Array<Vector2>();
    private Array<VehiculeGenerator> EnemiesVehicules = new Array<VehiculeGenerator>();
    private Array<VehiculeGenerator> vehiculesToCrash = new Array<VehiculeGenerator>();
    private Array<VehiculeGenerator> vehiculesToRemove = new Array<VehiculeGenerator>();
    private Array<Coin> coinToGrabList = new Array<Coin>();
    private Array<Jerrycan> jerrycanToGrabList = new Array<Jerrycan>();
    private Array<Collectable> bonusToGrabList = new Array<Collectable>();

    private Collectable collectable;

    private int groundChoice;
    private int vehiculeChoice;
    private int headChoice;

    private String exitChoice ;
    private String multiplierScore = "";

    private VehiculeGenerator vehicule;
    private VehiculeDef vehiculeDef;
    private PiloteGenerator pilote;
    private GroundGenerator ground;
    private DecorDef decorDef;

    private Polygon vehiculeCollisionRectangle;
    private Polygon headCollisionRectangle;
    private Array<Body> wheelsCollisonVehicule = new Array<Body>();
    private ObjectMap<Body, Polygon> wheelsPolygons = new ObjectMap<Body, Polygon>();

    private TextureRegion playTexture;
    private TextureRegion playPressedTexture;
    private TextureRegion jumpTexture;
    private TextureRegion jumpPressedTexture;
    private TextureRegion brakeTexture;
    private TextureRegion brakePressedTexture;
    private TextureRegion panneauTexture;

    private final ImageButton pauseButton;
    private final ImageButton nitroButton;
    private final ImageButton pubAndResumePanneButton;
    private final ImageButton quitMenuButton;

    private final ImageButton replayButton;
    private final ImageButton menuButton;
    private final ImageButton resumeButton;

    private Image sousReplayButton;
    private Image sousMenuButton;
    private Image sousResumeButton;

    private Group replayButtonGroup = new Group();
    private Group menuButtonGroup = new Group();
    private Group resumeButtonGroup = new Group();

    private Image sousBoutonJumpRed;
    private Image sousBoutonJumpGreen;
    private Image sousBoutonNitroGreen;
    private Image sousBoutonNitroRed;
    private Image menuPauseBackground;
    private Image noMoneyIcone;
    private Image voituresEcraseesIcone;
    private Image goldenCoin;

    private BitmapFont scoreVoituresEcraseesFont;
    private BitmapFont scoreFont;

    private Group boutonJumpGroup = new Group();
    private Group pauseBoutonGroup = new Group();
    private Group nitroBoutonGroup = new Group();
    private Group quitMenuButtonGroup = new Group();
    private Group menuButtonsGroup = new Group();
    private Group pauseMenuGroup = new Group();
    private Group HUDVisibleGroup = new Group();

    private Image fondPopUpTimerVideosImage;
    private Group popUpTimerGroup = new Group();
    private Label timerDecompteLabel;
    private Label expliTimerDecompteLabel;
    private float popUpTimerGroupTimer = 0;

    // panneau Wifi
    private Image fondWifiWarningImage;
    private Group popUpWifiGroup = new Group();
    private Label wifiWarningLabel;
    private float popUpWifiGroupTimer = 0;

    private Group panneMenuGroup = new Group();
    private Label panneTimerLabel;
    private Label expliPanneTimerLabel;

    // score des voitures écrasées
    private Label score;
    private Label.LabelStyle scoreStyle = new Label.LabelStyle();
    private Label scorePoints;
    private Label.LabelStyle scorePointsStyle = new Label.LabelStyle();
    private Label montantPrime;
    private Label.LabelStyle montantPrimeStyle = new Label.LabelStyle();
    private Label goLabel;
    private Label.LabelStyle goLabelStyle = new Label.LabelStyle();
    private String affichageTemporaire;
    private Group montantgroup = new Group();

    private Music goSound;
    private Music coinSound;
    private Music jumpSound;
    private Music brakeSound;
    private Music jaugeAlarmSound;
    private Music tachyAlarmSound;
    private Music reservoirFillingSound;
    private Music noMoneySound;
    private Music music;
    private Music nitroMusic;
    private Music deceptionMusic;

    private float decalageCam = 0;
    private boolean okDezoom;

    private boolean boostLeft;
    private boolean boostRight;
    private boolean boost;

    private boolean freePlace = true;
    private float freeTime = 0;
    private boolean jump = true;
    private float jumpTimer = 0;
    private float crashTimer = 0;
    private float crashTimerMax = 5;

    private boolean motor;
    private boolean okBrake;
    private float motorAccel = 0.2f;

    //************TEST******************
    private int scoreDead = 0;
    //************TEST******************
    private int scorePointsTotal = 0;
    private int scorePointsTemp = 0;

    private float montantTimer = 0;
    private boolean okMontant;

    private boolean moneyToWin;
    private float colorChangerTimer = 0;
    private boolean okScale;
    private float scaler = 1;
    private boolean okTilt;
    private float tilter = 0;

    //***************TEST********
    private float fuel = -120;
    private boolean fuelAlarm;
    private float fuelAlarmTimer = 0;
    private boolean fuelFillBool;
    private boolean noMoneyBool;
    private boolean noMoneyDetectBool;
    private float noMoneyTimer = 0;
    private float resetNoMoneyTimer = 0;

    private boolean isFuelEmpty;
    private boolean finishRaceBool;

    private float vitesse = 0;
    private boolean tachyAlarm;
    private float tachyAlarmTimer = 0;
    private boolean tachyDeadAlarm;
    private float tachyDeadTimer = 5.9f;

    private float crashSoundTimer = 1;

    private float payment;
    private boolean okPayment;
    private boolean okPause;
    private float deathTimer = 0;
    private float deceptionTimer = 6;
    private boolean okTachyDeath;

    private boolean billetsBool;
    private boolean gasFreeBool;
    private boolean multiScoreBool;
    private boolean nitroBool;
    private boolean okNitro;
    private float nitroTimer = 11;
    private int nitroCatched ;
    private int billetCatched;
    private int gasFreeCatched;
    private int nbEnemies;
    private float stateTime;

    private float videoViewedTimer;
    private boolean videoClosed;
    private boolean videoStarted = false;

    private long timeStarted;
    private long timeElapsing;
    private long cycleTimeElapsing;

    private long time;
    private double millis;
    private double seconds;
    private double minutes;
    private double hours;

    private String horloge;

    private float goLabelTimer = 0;

    private Animation<TextureRegion> bonusAnimation;
    private Array<String> assetsToUnload;
    private Array<String> vehiculeCustomAssetsToUnload;

    public GameScreen(MTCGame mtcGame, SpriteBatch batch, Array<String> vehiculeCustomAssetsToUnload) {
        this.mtcGame = mtcGame;
        this.batch = batch;
        this.vehiculeCustomAssetsToUnload = vehiculeCustomAssetsToUnload;
        groundChoice = mtcGame.getPrefs().getInteger("groundChoice");
        headChoice = mtcGame.getPrefs().getInteger("headChoice");
        vehiculeChoice = mtcGame.getPrefs().getInteger("vehiculeChoice");

        TextureAtlas textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas",TextureAtlas.class);

        // récupération des sons
        coinSound = mtcGame.getAssetManager().get("Coin-Sound-Effect.mp3", Music.class);
        jumpSound = mtcGame.getAssetManager().get("jumpSound.mp3", Music.class);
        brakeSound = mtcGame.getAssetManager().get("brakeSound.mp3", Music.class);
        jaugeAlarmSound = mtcGame.getAssetManager().get("emptyFuelBip.mp3", Music.class);
        tachyAlarmSound = mtcGame.getAssetManager().get("vitesseAlarm.mp3", Music.class);
        reservoirFillingSound = mtcGame.getAssetManager().get("reservoirFillingSound.mp3", Music.class);
        noMoneySound = mtcGame.getAssetManager().get("noMoneySound.mp3", Music.class);
        deceptionMusic = mtcGame.getAssetManager().get("deceptionPanneSound.mp3",Music.class);
        nitroMusic = mtcGame.getAssetManager().get("nitroTime.mp3", Music.class);
        nitroMusic.setVolume(0.45f);
        reservoirFillingSound.setVolume(0.8f);
        coinSound.setVolume(0.85f);

        // récupération des textures
        playTexture = textureAtlas.findRegion("bouton-play-normal");
        playPressedTexture = textureAtlas.findRegion("bouton-play-pressed");
        jumpTexture = textureAtlas.findRegion("bouton-jump-normal");
        jumpPressedTexture = textureAtlas.findRegion("bouton-jump-pressed");
        brakeTexture = textureAtlas.findRegion("bouton-brake-normal");
        brakePressedTexture = textureAtlas.findRegion("bouton-brake-pressed");
        panneauTexture = textureAtlas.findRegion("background-menuPanne");

        scoreVoituresEcraseesFont = mtcGame.getAssetManager().get("rock.fnt", BitmapFont.class);
        scoreFont = mtcGame.getAssetManager().get("score.fnt", BitmapFont.class);

        // HUD boutons
        pauseButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-pause"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-pause-pressed"))));
        nitroButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-jump-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-jump-pressed"))));
        // pause
        replayButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-pressed"))));
        menuButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-pressed"))));
        resumeButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-pressed"))));
        quitMenuButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-quit-menuPause"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-quit-menuPause-pressed"))));

        sousReplayButton = new Image(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-sousBouton-1")));
        sousMenuButton = new Image(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-sousBouton-2")));
        sousResumeButton = new Image(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-sousBouton-3")));

        // panne
        pubAndResumePanneButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-txt-bonusPanne"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-txt-bonusPanne-pressed"))));

        // HUD images
        sousBoutonJumpRed = new Image(new TextureRegion(textureAtlas.findRegion("bouton-jump-red")));
        sousBoutonJumpGreen = new Image(new TextureRegion(textureAtlas.findRegion("bouton-jump-green")));
        sousBoutonNitroGreen = new Image(new TextureRegion(textureAtlas.findRegion("nitro-sousBouton-Green")));
        sousBoutonNitroRed = new Image(new TextureRegion(textureAtlas.findRegion("bouton-jump-red")));
        menuPauseBackground = new Image(new TextureRegion(textureAtlas.findRegion("background-menuPause")));
        noMoneyIcone = new Image(new TextureRegion(textureAtlas.findRegion("100Dollars")));
        voituresEcraseesIcone = new Image(new TextureRegion(textureAtlas.findRegion("accident")));
        goldenCoin = new Image(new TextureRegion(textureAtlas.findRegion("goldenCoin")));

        fondPopUpTimerVideosImage = new Image(new TextureRegion(textureAtlas.findRegion("popup-Manque-Temps")));
        fondWifiWarningImage = new Image(new TextureRegion(textureAtlas.findRegion("popup-Manque-Wifi")));

        // Objets du jeu
        world = new World(new Vector2(0, -22.5f), true);
        debugRenderer = new Box2DDebugRenderer();
        box2dCam = new OrthographicCamera(UNIT_WIDTH, UNIT_HEIGHT);
        viewport = new FitViewport(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, box2dCam);
        shapeRenderer = new ShapeRenderer();
        stageViewport = new FitViewport(WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
        stage = new Stage(stageViewport);
        ground = new GroundGenerator(createDecorDef(),mtcGame, world, batch, box2dCam);
        pilote = new PiloteGenerator(mtcGame,headChoice);
        vehicule = new VehiculeGenerator(createVehiculeDef(vehiculeChoice,"ok"),mtcGame, world, pilote,
                ground.getPlayerPosition(),mtcGame.getPrefs().getInteger("headChoice"));
        vehiculeCollisionRectangle = new Polygon(vehicule.getChassisShapeFloatArray());
        headCollisionRectangle = new Polygon(pilote.getHeadShapeFloatArray());
        orthogonalTiledMapRenderer = new OrthogonalTiledMapRenderer(ground.getTiledMap(), batch);

        bonusAnimation = new Animation<TextureRegion>
                (0.2f, SheetToFramer.sheetToFrame(mtcGame.getAssetManager().get("frameSheets/panneauBONUSPanne_frameSheet.png",Texture.class),
                        2, 3));

        goSound = mtcGame.getAssetManager().get("goSound.mp3",Music.class);
        goSound.setVolume(0.25f);
        goSound.play();


    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void show() {
        box2dCam.zoom = 0.5f;
        orthogonalTiledMapRenderer.setView(box2dCam);

        // association des polygones de collision aux roues
        wheelsCollisonVehicule.add(vehicule.getLeftWheel());
        wheelsCollisonVehicule.add(vehicule.getRightWheel());
        for (Body body : wheelsCollisonVehicule) {
            Polygon vehiculeWheelCollisionRectangle = new Polygon(vehicule.getWheelShapeFloatArray());
            wheelsPolygons.put(body, vehiculeWheelCollisionRectangle);
        }
        contactWheelToGround();
        stageHUD();

        //******TEST*********
//        vehicule.setDead(true);
        if(mtcGame.getGoogleServices() != null){
            if (mtcGame.getGoogleServices().hasVideoClosed()) {
                mtcGame.getGoogleServices().setIs_video_ad_closed(false);
            }
        }
    }

    @Override
    public void render(float delta) {
        playMusic();
        criDeVictoire();
        // PAUSE
        if (!okPause) {
            update();
            //config de Box2D
            world.step(delta * 2f, 10, 6);
        }
        gameOver();
        panne();
        clearScreen();
        draw();
//        drawDebug();
        debugLog();
        stage.act(delta);
        score.setText(Integer.toString(scoreDead));
        scorePoints.setText(Integer.toString(scorePointsTotal));
        voituresEcraseesIcone.setScale(scaler);
        goldenCoin.setPosition(stageViewport.getWorldWidth() / 2.4f, stageViewport.getWorldHeight() / 1.17f + (tilter * 3.5f));
        montantPrime.setText(affichageTemporaire);
        panneTimerLabel.setText(Integer.toString((int)deceptionTimer)+mtcGame.getTrad().getSecondes());
        timerDecompteLabel.setText(timeToStringConvert(
                (mtcGame.getPrefs().getLong("VVLimitTimeStart") + mtcGame.getPeriodBeforeNewVideos()) - timeElapsing));
        montantgroup.act(delta);
        fuelBurning();
        compteurVitesse();
        scorePointsColorChangerGreen();
        noMoneyIcone.setVisible(noMoneyDetectBool);
        stage.draw();
        for(Collectable collectable : bonusToGrabList){
            collectable.updateFrame();
        }
        if(mtcGame.getGoogleServices() != null){
            videoViewedToggleBool();
            videoClosedToggleBool();
            viewedVideosPerDayLimiter();
        }
        popUpTimerVisibiliteTimer();
        popUpWifiVisibiliteTimer();
    }

    @Override
    public void pause() {
        okPause = true;
        pauseMenuGroup.setVisible(true);
    }

    @Override
    public void resume() {
        okPause = false;
        pauseMenuGroup.setVisible(false);
    }

    @Override
    public void dispose() {
        world.dispose();
        stage.dispose();
        shapeRenderer.dispose();
    }


    /**
     * UPDATE
     *
     */
    private void update() {
        updateCameraPositionZ();
        updateCameraPositionX();
        zoomDezoom();

        // update des méthodes du stageHUD
        goLabelVisibiliteTimer();
        elementHUDVisible();
        jaugeFondRougeVisible();
        tachyAvantExplosionFondRougeVisible();

        jaugeAlarmSound();
        tachyAlarmSound();
        tachyDeadTimerDecompte();
        timeToJump();
        scaleTimer();
        tiltTimer();
        montantPrimeTimer();
        scorePointsColorChangerGreen();

        // update des méthodes de collectables
        createCoinToGrab();
        createJerrycanToGrab();
        createCollectableToGrab();
        overlapCoinAndVehiculesPolygons();
        overlapJerrycanAndVehiculePolygons();
        overlapBonusAndVehiculesPolygons();
        eraseCoinsNotGrabbed();
        eraseJerrycanNotGrabbed();
        eraseBonusNotGrabbed();

        // update des méthodes de paiement
        updatePayment();
        payFuel();
        updateScoreTemp();
        noMoneyBuzzer();
        resetNoMoneyDetectBoolAndNoMoneyTimer();
        fillingFuelReservoir();

        // update des méthodes de vehicules ennemis
        createEnemiesVehicules();
        freePlaceTimer();
        updateCrashedVehicules();
        collectCrashedEnemiesVehicules();
        updateVehiculeEnemies();
        collectDeadEnemiesVehicules();

        // update des méthodes du vehicule player
        accelMotor();
        isBoostOnTwoWheels();
        vehiculeMotor();
        vehiculeBrake();
        updateVehiculeCollisionPolygons();
        deadPlayer();
        finishRace();
        nitroTimer();

        // HUD vehicule Player
        vehicule.update();
        vehicule.setJaugeAiguilleRotation(fuel);
        vehicule.setTachyAiguille(vitesse);
        vehicule.setDigitalTachymetre(Integer.toString((int) (vitesse * 2)));
        vehicule.setDeadTimerLabel(tachyDeadTimer);
        vehicule.setJaugeFondRouge(fuelAlarm);

        // si vehiculeChoice != monster(pickup)
        if(vehiculeChoice != 7){
            vehicule.deadTimerVisible(tachyDeadAlarm);
            vehicule.deadTimerLabelColorChanger(tachyAlarm);
            vehicule.setTachyFondRouge(tachyAlarm);
        }

        // méthode du ground
        ground.loadingUnloadingSelonPosition();
//        unloader();

    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void draw() {
        batch.setProjectionMatrix(box2dCam.projection);
        batch.setTransformMatrix(box2dCam.view);
        orthogonalTiledMapRenderer.render();
        batch.begin();
        ground.draw();
        ground.drawSolSelonPosition();
        drawDeadOrVictoriousPlayerSprites();
        if(okNitro){
            vehicule.drawNitroAnim(batch);
        }
        if (okTachyDeath || vehicule.isDead()) {
            vehicule.drawExplosionAnim(batch);
        }
        for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
            vehiculeGenerator.draw(batch);
        }
        for (VehiculeGenerator vehiculeGenerator : vehiculesToCrash) {
            vehiculeGenerator.drawCrash(batch);
            vehiculeGenerator.drawExplosionAnim(batch);
        }
        for (Coin coin : coinToGrabList) {
            coin.draw(batch);
        }
        for (Jerrycan jerrycan : jerrycanToGrabList) {
            jerrycan.drawJerrycan(batch);
        }
        for (Collectable collectable : bonusToGrabList){
            collectable.draw(batch);
        }
        if(isFuelEmpty){
            drawPanneauPanne();
            drawBonusPanneAnim(batch);
        }
        batch.end();
    }

    private void drawPanneauPanne(){
        batch.draw(panneauTexture, box2dCam.position.x - panneauTexture.getRegionWidth()/2.58f, box2dCam.position.y - panneauTexture.getRegionHeight()/2.85f,
                panneauTexture.getRegionWidth() *0.775f, panneauTexture.getRegionHeight()*0.7f);
    }

    private void drawBonusPanneAnim(SpriteBatch batch){
        stateTime += Gdx.graphics.getDeltaTime();
        bonusAnimation.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion bonusCurrentFrame = bonusAnimation.getKeyFrame(stateTime, true);
        batch.draw(bonusCurrentFrame, box2dCam.position.x - bonusCurrentFrame.getRegionWidth()/2f, box2dCam.position.y - bonusCurrentFrame.getRegionHeight()/1.5f,
                bonusCurrentFrame.getRegionWidth() , bonusCurrentFrame.getRegionHeight() / 1.5f);
    }

    private void drawDebug() {
        debugRenderer.render(world, box2dCam.combined);
        shapeRenderer.setProjectionMatrix(box2dCam.projection);
        shapeRenderer.setTransformMatrix(box2dCam.view);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.BLUE);
        // Polygones de détection
        // Vehicule :
        shapeRenderer.polygon(vehiculeCollisionRectangle.getTransformedVertices());
        shapeRenderer.polygon(headCollisionRectangle.getTransformedVertices());
        for (Polygon polygon : wheelsPolygons.values()) {
            shapeRenderer.polygon(polygon.getTransformedVertices());
        }
        // Collectables :
        for (Coin coin : coinToGrabList) {
            shapeRenderer.polygon(coin.getCollisionRectangle().getTransformedVertices());
        }
        for (Jerrycan jerrycan : jerrycanToGrabList) {
            shapeRenderer.polygon(jerrycan.getCollisionPolygon().getTransformedVertices());
        }
        for (Collectable collectable : bonusToGrabList){
            shapeRenderer.polygon(collectable.getCollisionRectangle().getTransformedVertices());
        }
        shapeRenderer.end();
    }

    private VehiculeDef createVehiculeDef(int vehiculeChoice, String player){
        if(vehiculeChoice != 99){
            if(vehiculeChoice == 0){
                vehiculeDef = new VehiculeSansPermis(mtcGame,player);
            }
            if(vehiculeChoice == 1){
                vehiculeDef = new VehiculePourri(mtcGame,player);
            }
            if(vehiculeChoice == 2){
                vehiculeDef = new VehiculeBerline(mtcGame,player);
            }
            if(vehiculeChoice == 3){
                vehiculeDef = new VehiculeGT(mtcGame,player);
            }
            if(vehiculeChoice == 4){
                vehiculeDef = new VehiculeLuxe(mtcGame,player);
            }
            if(vehiculeChoice == 5){
                vehiculeDef = new VehiculeDecapotable(mtcGame,player);
            }
            if(vehiculeChoice == 6){
                vehiculeDef = new VehiculeLegende(mtcGame,player);
            }
            if(vehiculeChoice == 7){
                vehiculeDef = new VehiculePickUp(mtcGame,player);
            }
            if(vehiculeChoice == 8){
                vehiculeDef = new VehiculeCamionette(mtcGame,player);
            }
            if(vehiculeChoice == 9){
                vehiculeDef = new Vehicule4X4(mtcGame,player);
            }
            if(vehiculeChoice == 10){
                vehiculeDef = new VehiculeCamion(mtcGame,player);
            }
            if(vehiculeChoice == 11){
                vehiculeDef = new VehiculeChantier(mtcGame,player);
            }
            if(vehiculeChoice == 12){
                vehiculeDef = new VehiculeCustom(mtcGame,player);
            }
        }else{
            vehiculeChoice = MathUtils.random(0,11);
            createVehiculeDef(vehiculeChoice,player);
        }
        return vehiculeDef;
    }

    private DecorDef createDecorDef(){
        if(groundChoice == 0){
            decorDef = new DecorMontagne(mtcGame);
        }
        if(groundChoice == 1){
            decorDef = new DecorDesert(mtcGame);
        }
        if(groundChoice == 2){
            decorDef = new DecorLune(mtcGame);
        }
        if(groundChoice == 3){
            decorDef = new DecorForet(mtcGame);
        }
        if(groundChoice == 4){
            decorDef = new DecorJungle(mtcGame);
        }
        if(groundChoice == 5){
            decorDef = new DecorIles(mtcGame);
        }
        if(groundChoice == 6){
            decorDef = new DecorVille(mtcGame);
        }
        if(groundChoice == 7){
            decorDef = new DecorCampagne(mtcGame);
        }
        if(groundChoice == 8){
            decorDef = new DecorSousMarin(mtcGame);
        }
        if(groundChoice == 9){
            decorDef = new DecorVillage(mtcGame);
        }
        if(groundChoice == 10){
            decorDef = new DecorPoleNord(mtcGame);
        }
        if(groundChoice == 11){
            decorDef = new DecorDecharge(mtcGame);
        }
        return decorDef;
    }


    private void playMusic() {
        music = ground.getMusic();
        music.setVolume(0.35f);
        music.setLooping(true);
        if (okPause) {
            music.pause();
            nitroMusic.pause();
            vehicule.getVehiculeSoundDecel().pause();
        } else {
            if(!nitroMusic.isPlaying()){
                music.play();
            }else{
                music.pause();
            }
        }
    }

    private void criDeVictoire(){
        if(finishRaceBool){
            if(deathTimer > 0 && deathTimer < 0.1f){
                pilote.getAnimalSound().setVolume(0.85f);
                pilote.getAnimalSound().play();
            }
        }
    }

    private void addAssetsToUnloadToList(){
        assetsToUnload = ground.getAssetsListeTemp();
        assetsToUnload.add(vehicule.getAccelSoundRef());
        assetsToUnload.add(vehicule.getDecelSoundRef());
        assetsToUnload.add(vehicule.getAtlasRef());
        assetsToUnload.add(pilote.getAnimalSoundRef());
        if(vehiculeCustomAssetsToUnload!=null){
            for(String string : vehiculeCustomAssetsToUnload){
                assetsToUnload.add(string);
            }
        }
    }

    private void gameOver(){
        if(vehicule.isDead() || finishRaceBool){
            pauseBoutonGroup.setVisible(false);
            if(deathTimer < 5){
                deathTimer += 0.025f;
            }
        }if(deathTimer >= 5){
            okNitro =false;
            okPause =true;
            music.stop();
            nitroMusic.stop();
            dispose();
            addAssetsToUnloadToList();
            mtcGame.setScreen(new GameOverScreen(mtcGame,batch,pilote,ground,
                    exitChoice,multiplierScore,
                    scoreDead,scorePointsTotal,gasFreeCatched,billetCatched,nitroCatched, nbEnemies,assetsToUnload));
        }
    }

    private void panne() {
        if (!finishRaceBool || !vehicule.isDead()) {
            if (isFuelEmpty) {
                if (mtcGame.getGoogleServices() != null ) {
                    if (deceptionTimer > 0) {
                        deceptionTimer -= 0.015f;
                    }
                    if (deceptionTimer < 6 && deceptionTimer > 5.9f) {
                        deceptionMusic.play();
                    }
                    okPause = true;
                    HUDVisibleGroup.setVisible(false);
                    pauseButton.setVisible(false);
                    panneMenuGroup.setVisible(true);

                    // si refus de la pub ---> R.I.P
                    if (deceptionTimer <= 1 && !videoStarted || videoClosed) {
                        deceptionTimer = 6;
                        exitChoice = "panne";
                        okNitro = false;
                        okPause = true;
                        music.stop();
                        nitroMusic.stop();
                        deceptionMusic.stop();
                        jaugeAlarmSound.stop();
                        dispose();
                        addAssetsToUnloadToList();
                        mtcGame.setScreen(new GameOverScreen(mtcGame, batch, pilote, ground,
                                exitChoice, multiplierScore,
                                scoreDead, scorePointsTotal, gasFreeCatched, billetCatched, nitroCatched, nbEnemies, assetsToUnload));
                    }
                }
            } else {
                deceptionMusic.stop();
                deceptionTimer = 6;
                HUDVisibleGroup.setVisible(true);
                panneMenuGroup.setVisible(false);
            }
        }
    }


    private void stageHUD() {
        Gdx.input.setInputProcessor(stage);

        // label GO !
        goLabelStyle.font = scoreFont;
        goLabel = new Label("GO !!!",goLabelStyle);
        goLabel.setColor(Color.WHITE);
        goLabel.setFontScale(2,2.5f);
        goLabel.setPosition(viewport.getWorldWidth()/3,viewport.getWorldHeight()/2);
        stage.addActor(goLabel);

        // HUD tableau de bord
        Group tableauDeBordGroup = vehicule.getTableauDeBordGroup(stage,stageViewport,vitesse,scoreFont);
        stage.addActor(tableauDeBordGroup);

        // bouton pause
        pauseButton.setPosition(stageViewport.getWorldWidth() * 1.185f, stageViewport.getWorldHeight() * 1.09f);
        stage.addActor(pauseButton);
        pauseButton.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                okPause = true;
                pauseButton.setVisible(false);
                pauseMenuGroup.setVisible(true);

            }
        });
        pauseBoutonGroup.addActor(pauseButton);
        pauseBoutonGroup.setScale(0.75f);
        pauseBoutonGroup.setWidth(pauseButton.getWidth());
        pauseBoutonGroup.setHeight(pauseButton.getHeight());
        stage.addActor(pauseBoutonGroup);


        // bouton play
        final ImageButton play = new ImageButton(new TextureRegionDrawable(new TextureRegion(playTexture)), new TextureRegionDrawable(new TextureRegion(playPressedTexture)));
        play.setPosition(WORLD_WIDTH / 2.15f, WORLD_HEIGHT / 6.5f, Align.top);
        play.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(!okPause){
                    if (!vehicule.isDead()) {
                        if (!isFuelEmpty) {
                            motor = true;
                            // son du moteur
                            vehicule.getVehiculeSoundAccel().setVolume(0.85f);
                            vehicule.getVehiculeSoundAccel().play();
                            vehicule.getVehiculeSoundDecel().stop();

                        }
                    } else {
                        motor = false;
                        if (!okPause) {
                            vehicule.getVehiculeSoundAccel().stop();
                            vehicule.getVehiculeSoundDecel().stop();
                        }
                    }
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                motor = false;
                if(!okPause){
                    if (!vehicule.isDead()) {
                        if (!isFuelEmpty) {
                            // son du moteur

                            vehicule.getVehiculeSoundAccel().stop();
                            vehicule.getVehiculeSoundDecel().setVolume(0.2f);
                            vehicule.getVehiculeSoundDecel().play();

                        } else {
                            vehicule.getVehiculeSoundAccel().stop();
                        }
                    } else {
                        vehicule.getVehiculeSoundAccel().stop();
                    }
                }
            }
        });
        stage.addActor(play);

        // bouton brake
        final ImageButton brake = new ImageButton(new TextureRegionDrawable(new TextureRegion(brakeTexture)), new TextureRegionDrawable(new TextureRegion(brakePressedTexture)));
        brake.setPosition(play.getX() / 64, play.getY());
        brake.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if(!okPause){
                    if (!vehicule.isDead()) {
                        if (!isFuelEmpty) {
                            okBrake = true;
                            if (boost) {
                                brakeSound.setVolume(0.7f);
                                brakeSound.play();
                            }
                        }
                    }
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                if(!okPause){
                    if (!vehicule.isDead()) {
                        if (!isFuelEmpty) {
                            okBrake = false;
                        }
                    }
                }
            }
        });
        stage.addActor(brake);

        // sous_bouton jump
        sousBoutonJumpRed.setPosition(stageViewport.getWorldWidth() / 1.5f, stageViewport.getWorldHeight() / 7 + sousBoutonJumpRed.getHeight() / 2, Align.top);
        sousBoutonJumpGreen.setPosition(sousBoutonJumpRed.getX() + sousBoutonJumpGreen.getWidth() / 2, sousBoutonJumpRed.getY() + sousBoutonJumpGreen.getHeight(), Align.top);
        sousBoutonJumpRed.setScale(0.9f);
        sousBoutonJumpGreen.setScale(0.9f);
        stage.addActor(sousBoutonJumpRed);
        stage.addActor(sousBoutonJumpGreen);

        // bouton jump
        ImageButton jumpButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(jumpTexture)), new TextureRegionDrawable(new TextureRegion(jumpPressedTexture)));
        jumpButton.setPosition(sousBoutonJumpRed.getX() + jumpButton.getWidth() / 2, sousBoutonJumpRed.getY() + jumpButton.getHeight(), Align.top);
        stage.addActor(jumpButton);
        jumpButton.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                if(!okPause){
                    if (!vehicule.isDead()) {
                        if (!isFuelEmpty) {
                            // fait sauter
                            if(jump && boost) {
                                vehicule.getRightWheel().setLinearVelocity(vehicule.getRightWheel().getLinearVelocity().x * 8, vehicule.getJumpPower().y * (2.4f + pilote.getPiloteSkills()[mtcGame.getPrefs().getInteger("headChoice")][0]));
                                vehicule.getChassis().setLinearVelocity(vehicule.getChassis().getLinearVelocity().x * 8, vehicule.getJumpPower().y * (2.4f + pilote.getPiloteSkills()[mtcGame.getPrefs().getInteger("headChoice")][0]));
                                jumpSound.setVolume(0.4f);
                                jumpSound.play();
                                jump = false;
                            }
                        }
                    }
                }
            }
        });
        boutonJumpGroup.addActor(jumpButton);
        boutonJumpGroup.setScale(0.81f);
        boutonJumpGroup.setWidth(jumpButton.getWidth());
        boutonJumpGroup.setHeight(jumpButton.getHeight());
        boutonJumpGroup.setPosition(sousBoutonJumpRed.getX() - boutonJumpGroup.getWidth() * 3.15f, sousBoutonJumpRed.getY() - boutonJumpGroup.getHeight() / 60);
        stage.addActor(boutonJumpGroup);

        // bouton NITRO
        sousBoutonNitroRed.setPosition(stageViewport.getWorldWidth() /2, stageViewport.getWorldHeight() /2);
        stage.addActor(sousBoutonNitroRed);

        sousBoutonNitroGreen.setPosition(stageViewport.getWorldWidth() /2, stageViewport.getWorldHeight() /2);
        stage.addActor(sousBoutonNitroGreen);

        nitroButton.setPosition(stageViewport.getWorldWidth() /2, stageViewport.getWorldHeight() /2);
        stage.addActor(nitroButton);
        nitroButton.addListener(new ActorGestureListener(){

            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                okNitro = true;
            }
        });

        nitroBoutonGroup.addActor(sousBoutonNitroRed);
        nitroBoutonGroup.addActor(sousBoutonNitroGreen);
        nitroBoutonGroup.addActor(nitroButton);
        nitroBoutonGroup.setScale(0.6f);
        nitroBoutonGroup.setOrigin(nitroBoutonGroup.getWidth()/2,nitroBoutonGroup.getHeight()/2);
        nitroBoutonGroup.setPosition(stageViewport.getWorldWidth() /2.23f, -stageViewport.getWorldHeight()/6.5f );
        nitroBoutonGroup.setVisible(false);
        stage.addActor(nitroBoutonGroup);

        // icone voitures écrasées
        voituresEcraseesIcone.setPosition(stageViewport.getWorldWidth() / 4 - voituresEcraseesIcone.getWidth()*1.25f, stageViewport.getWorldHeight() / 1.24f - voituresEcraseesIcone.getHeight()/3.8f);
        voituresEcraseesIcone.setOrigin(voituresEcraseesIcone.getWidth() / 2, voituresEcraseesIcone.getHeight() / 2);
        voituresEcraseesIcone.setRotation(10);
        stage.addActor(voituresEcraseesIcone);

        // score voiture accidentées
        scoreStyle.font = scoreVoituresEcraseesFont;
        String scoreAsString = Integer.toString(scoreDead);
        score = new Label(scoreAsString, scoreStyle);
        if(groundChoice != 2 && groundChoice != 6){
            score.setColor(Color.BLACK);
        }else{
            score.setColor(Color.WHITE);
        }
        score.setFontScale(score.getScaleX() * 1.3f, score.getScaleY() * 1.3f);
        score.setPosition(voituresEcraseesIcone.getX() + voituresEcraseesIcone.getWidth() * 0.96f - score.getWidth() / 2, voituresEcraseesIcone.getY() + score.getHeight());
        stage.addActor(score);

        // icone score total (piece or)
        goldenCoin.setScale(0.7f);
        stage.addActor(goldenCoin);

        // score points
        scorePointsStyle.font = scoreFont;
        String scorePointsAsString = Integer.toString(scorePointsTotal);
        scorePoints = new Label(scorePointsAsString, scorePointsStyle);
        if(groundChoice != 2 && groundChoice != 6){
            scorePoints.setColor(Color.BLACK);
        }else{
            scorePoints.setColor(Color.WHITE);
        }
        scorePoints.setFontScale(0.85f);
        scorePoints.setPosition(stageViewport.getWorldWidth() / 2f, stageViewport.getWorldHeight() / 1.18f);
        stage.addActor(scorePoints);

        // affichage montant de la prime
        montantPrimeStyle.font = scoreFont;
        String montantPrimeAsString = "+ "+ affichageTemporaire;
        montantPrime = new Label(montantPrimeAsString, montantPrimeStyle);
        montantPrime.setFontScale(montantPrime.getScaleX() * 1.3f, montantPrime.getScaleY() * 1.3f);
        montantPrime.setColor(Color.RED);
        montantPrime.setPosition((stageViewport.getWorldWidth() - montantPrime.getScaleX()) / 2.75f, (stageViewport.getWorldHeight() - montantPrime.getScaleY()) / 2.6f);
        stage.addActor(montantPrime);

        // parent du label permettant rotation
        montantgroup.addActor(montantPrime);
        montantgroup.setWidth(montantPrime.getWidth());
        montantgroup.setHeight(montantPrime.getHeight());
        montantgroup.setPosition(stageViewport.getWorldWidth() / 7.8f, stageViewport.getWorldHeight() / 1.4f);
        montantgroup.setRotation(-25);
        stage.addActor(montantgroup);

        // icone noMoney
        noMoneyIcone.setPosition((stageViewport.getWorldWidth()/4.5f - noMoneyIcone.getImageWidth()) , (stageViewport.getWorldHeight() - noMoneyIcone.getImageHeight()) / 1.7f);
        stage.addActor(noMoneyIcone);

        HUDVisibleGroup.addActor(tableauDeBordGroup);
        HUDVisibleGroup.addActor(play);
        HUDVisibleGroup.addActor(brake);
        HUDVisibleGroup.addActor(sousBoutonJumpRed);
        HUDVisibleGroup.addActor(sousBoutonJumpGreen);
        HUDVisibleGroup.addActor(boutonJumpGroup);
        HUDVisibleGroup.addActor(nitroBoutonGroup);
        HUDVisibleGroup.addActor(voituresEcraseesIcone);
        HUDVisibleGroup.addActor(goldenCoin);
        HUDVisibleGroup.addActor(score);
        HUDVisibleGroup.addActor(scorePoints);
        HUDVisibleGroup.addActor(montantgroup);
        HUDVisibleGroup.addActor(noMoneyIcone);
        stage.addActor(HUDVisibleGroup);

        // PAUSE ********************

        // menu PAUSE : image de fond
        menuPauseBackground.setPosition(stageViewport.getWorldWidth()/2 - menuPauseBackground.getWidth()/2, stageViewport.getWorldHeight()/2  -menuPauseBackground.getHeight()/2);
        menuPauseBackground.setOrigin(menuPauseBackground.getWidth()/2,menuPauseBackground.getHeight()/2);
        menuPauseBackground.setScale(0.775f,0.7f);
        stage.addActor(menuPauseBackground);

        // menu PAUSE : bouton quitter menu pause
        quitMenuButton.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                okPause = false;
                pauseMenuGroup.setVisible(false);
                pauseButton.setVisible(true);
            }
        });
        stage.addActor(quitMenuButton);

        quitMenuButtonGroup.setWidth(quitMenuButton.getWidth());
        quitMenuButtonGroup.setHeight(quitMenuButton.getHeight());
        quitMenuButtonGroup.addActor(quitMenuButton);
        quitMenuButtonGroup.setPosition(stageViewport.getWorldWidth()/1.118f,stageViewport.getWorldHeight()/1.2f);
        quitMenuButtonGroup.setScale(0.5f);
        stage.addActor(quitMenuButtonGroup);

        // menu PAUSE : bouton menu
//        menuButton.setPosition(menuButtonsGroup.getX(),menuButtonsGroup.getY() + menuButton.getHeight()*1.15f);
        stage.addActor(menuButton);
        menuButton.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                music.stop();
                nitroMusic.stop();
                jaugeAlarmSound.stop();
                tachyAlarmSound.stop();
                vehicule.getVehiculeSoundDecel().stop();
                vehicule.getVehiculeSoundAccel().stop();
                dispose();
                addAssetsToUnloadToList();
                assetsToUnload.add(ground.getRefExitBackground());
                mtcGame.setScreen(new MenuScreen(mtcGame, batch,assetsToUnload));
            }
        });

        stage.addActor(sousMenuButton);

        Label boutonMenuLabel = new Label(mtcGame.getTrad().getBoutonMenu(),scorePointsStyle);
        boutonMenuLabel.setPosition(sousMenuButton.getWidth()/2 - boutonMenuLabel.getWidth()/1.2f,
                sousMenuButton.getHeight()/2 - boutonMenuLabel.getHeight()/2f);
        boutonMenuLabel.setFontScale(1.8f);
        boutonMenuLabel.setColor(Color.BLACK);
        stage.addActor(boutonMenuLabel);

        menuButtonGroup.addActor(sousMenuButton);
        menuButtonGroup.addActor(boutonMenuLabel);
        menuButtonGroup.addActor(menuButton);
        menuButtonGroup.setPosition(menuButtonsGroup.getX(),menuButtonsGroup.getY() + menuButton.getHeight()*1.15f);

        // menu PAUSE : bouton replay
//        replayButton.setPosition(menuButtonsGroup.getX(),menuButtonsGroup.getY());
        stage.addActor(replayButton);
        replayButton.addListener(new ActorGestureListener(){
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                music.stop();
                nitroMusic.stop();
                jaugeAlarmSound.stop();
                tachyAlarmSound.stop();
                vehicule.getVehiculeSoundDecel().stop();
                vehicule.getVehiculeSoundAccel().stop();
                mtcGame.setScreen(new LoadingScreen(mtcGame,batch));
                dispose();
            }
        });

        stage.addActor(sousReplayButton);

        Label boutonReplayLabel = new Label(mtcGame.getTrad().getBoutonReplay(),scorePointsStyle);
        // adapte taille et position selon langue
        if( Locale.getDefault().getLanguage().equals("de") || Locale.getDefault().getLanguage().equals("nl")){
            boutonReplayLabel.setPosition(sousReplayButton.getWidth()/2.25f - boutonReplayLabel.getWidth()/2.2f,
                    sousReplayButton.getHeight()/2 - boutonReplayLabel.getHeight()/2f);
            boutonReplayLabel.setFontScale(1.05f,2);
        }else{
            boutonReplayLabel.setPosition(sousReplayButton.getWidth()/2 - boutonReplayLabel.getWidth()/1.5f,
                    sousReplayButton.getHeight()/2 - boutonReplayLabel.getHeight()/2f);
            boutonReplayLabel.setFontScale(1.4f,2);
        }
        boutonReplayLabel.setColor(Color.BLACK);
        stage.addActor(boutonReplayLabel);

        replayButtonGroup.addActor(sousReplayButton);
        replayButtonGroup.addActor(boutonReplayLabel);
        replayButtonGroup.addActor(replayButton);
        replayButtonGroup.setPosition(menuButtonsGroup.getX(),menuButtonsGroup.getY());

        // menu PAUSE : bouton resume
//        resumeButton.setPosition(menuButtonsGroup.getX(),menuButtonsGroup.getY() - resumeButton.getHeight()*1.15f);
        stage.addActor(resumeButton);
        resumeButton.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                okPause = false;
                pauseMenuGroup.setVisible(false);
                pauseButton.setVisible(true);
            }
        });

        stage.addActor(sousResumeButton);

        Label boutonResumeLabel = new Label(mtcGame.getTrad().getBoutonResume(),scorePointsStyle);
        // adapte taille et position selon langue
        if(Locale.getDefault().getLanguage().equals("it") || Locale.getDefault().getLanguage().equals("de")
                || Locale.getDefault().getLanguage().equals("pl")){
            boutonResumeLabel.setPosition(sousResumeButton.getWidth()/2.25f- boutonResumeLabel.getWidth()/2.2f,
                    sousResumeButton.getHeight()/2f - boutonResumeLabel.getHeight()/2f);
            boutonResumeLabel.setFontScale(1.05f,2);
        }else{
            boutonResumeLabel.setPosition(sousResumeButton.getWidth()/2- boutonResumeLabel.getWidth()/1.45f,
                    sousResumeButton.getHeight()/2f - boutonResumeLabel.getHeight()/2f);
            boutonResumeLabel.setFontScale(1.4f,2);
        }
        boutonResumeLabel.setColor(Color.BLACK);
        stage.addActor(boutonResumeLabel);

        resumeButtonGroup.addActor(sousResumeButton);
        resumeButtonGroup.addActor(boutonResumeLabel);
        resumeButtonGroup.addActor(resumeButton);
        resumeButtonGroup.setPosition(menuButtonsGroup.getX(),menuButtonsGroup.getY() - resumeButton.getHeight()*1.15f);

        menuButtonsGroup.addActor(menuButtonGroup);
        menuButtonsGroup.addActor(replayButtonGroup);
        menuButtonsGroup.addActor(resumeButtonGroup);
        menuButtonsGroup.setPosition(stageViewport.getWorldWidth()/1.5f,stageViewport.getWorldHeight()/2.5f);
        menuButtonsGroup.setScale(0.35f);
        stage.addActor(menuButtonsGroup);

        pauseMenuGroup.addActor(menuPauseBackground);
        pauseMenuGroup.addActor(menuButtonsGroup);
        pauseMenuGroup.addActor(quitMenuButtonGroup);
        pauseMenuGroup.setVisible(false);
        stage.addActor(pauseMenuGroup);

        // PANNE ********************
        stage.addActor(fondPopUpTimerVideosImage);

        // labels : "vous avez regardé 10 vidéos en 2h, vous devez attendre

        String expliDecompte = mtcGame.getTrad().getTimerDecompte();
        expliTimerDecompteLabel = new Label(expliDecompte,scorePointsStyle);
        expliTimerDecompteLabel.setColor(Color.BLACK);
        expliTimerDecompteLabel.setFontScale(1.5f);
        expliTimerDecompteLabel.setPosition(fondPopUpTimerVideosImage.getWidth()/2-expliTimerDecompteLabel.getWidth()/1.3f,
                fondPopUpTimerVideosImage.getHeight()/2 - expliTimerDecompteLabel.getHeight()/5f);
        stage.addActor(expliTimerDecompteLabel);

        String decompteHoraire = timeToStringConvert(mtcGame.getPeriodBeforeNewVideos() - timeElapsing);
        timerDecompteLabel = new Label(decompteHoraire,scorePointsStyle);
        timerDecompteLabel.setColor(Color.BLACK);
        timerDecompteLabel.setFontScale(1.8f);
        timerDecompteLabel.setPosition(fondPopUpTimerVideosImage.getWidth()/2-timerDecompteLabel.getWidth()/1.1f,
                fondPopUpTimerVideosImage.getHeight()/3 - timerDecompteLabel.getHeight() *1.8f);
        stage.addActor(timerDecompteLabel);

        popUpTimerGroup.addActor(fondPopUpTimerVideosImage);
        popUpTimerGroup.addActor(expliTimerDecompteLabel);
        popUpTimerGroup.addActor(timerDecompteLabel);
        popUpTimerGroup.setScale(0.65f);
        popUpTimerGroup.setPosition(viewport.getWorldWidth()/16 - popUpTimerGroup.getWidth()/2,
                viewport.getWorldHeight()/16 - popUpTimerGroup.getWidth()/6);
        popUpTimerGroup.setVisible(false);

        // POPUP WIFI NON-CONNECTE
        stage.addActor(fondWifiWarningImage);

        String wifiWarning = mtcGame.getTrad().getPopUpWifiLabelPart1() + "\n" + mtcGame.getTrad().getPopUpWifiLabelPart2() +"\n"
                + mtcGame.getTrad().getPopUpWifiLabelPart3()+ "\n" + mtcGame.getTrad().getPopUpWifiLabelPart4();
        wifiWarningLabel = new Label(wifiWarning,scorePointsStyle);
        wifiWarningLabel.setColor(Color.BLACK);
        wifiWarningLabel.setFontScale(1.5f);
        wifiWarningLabel.setPosition(fondWifiWarningImage.getWidth()/2-wifiWarningLabel.getWidth()/1.3f,
                fondWifiWarningImage.getHeight()/2 - wifiWarningLabel.getHeight()/2);
        stage.addActor(wifiWarningLabel);

        popUpWifiGroup.addActor(fondWifiWarningImage);
        popUpWifiGroup.addActor(wifiWarningLabel);
        popUpWifiGroup.setScale(0.65f);
        popUpWifiGroup.setPosition(viewport.getWorldWidth()/16 - popUpWifiGroup.getWidth()/2,
                viewport.getWorldHeight()/16 - popUpWifiGroup.getWidth()/6);
        popUpWifiGroup.setVisible(false);

        // menu PANNE : bouton pub et resume
        pubAndResumePanneButton.setPosition(panneMenuGroup.getX(), panneMenuGroup.getY() - pubAndResumePanneButton.getHeight()*1.15f);
        stage.addActor(pubAndResumePanneButton);
        pubAndResumePanneButton.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                if(mtcGame.getGoogleServices().isWifiConnected()){
                    // décompte cycle 2 heures
                    if(mtcGame.getPrefs().getInteger("nbVideoViewed") == 0){
                        mtcGame.getPrefs().putLong("VVFirstTimeCycleStart",TimeUtils.millis()).flush();
                    }
                    if(!mtcGame.getPrefs().getBoolean("videoViewedLimit")){
                        // recup time de la derniere video
                        if(mtcGame.getPrefs().getInteger("nbVideoViewed") == mtcGame.getMaxVideoPerPeriod()){
                            timeStarted = TimeUtils.millis();
                        }
                        mtcGame.getPrefs().putLong("VVLimitTimeStart",timeStarted).flush();
                        mtcGame.getPrefs().putInteger("nbVideoViewed",mtcGame.getPrefs().getInteger("nbVideoViewed") + 1).flush();
                        mtcGame.showRewardedVideoAd();
                        videoStarted = true;
                    }
                    else{
                        // panneau "limite atteinte" + décompte du temps
                        popUpTimerGroup.setVisible(true);
                    }
                }else{
                    popUpWifiGroup.setVisible(true);
                }
            }
        });

        expliPanneTimerLabel = new Label(mtcGame.getTrad().getPanneTimerLabel(),scorePointsStyle);
        expliPanneTimerLabel.setColor(Color.BLACK);
        expliPanneTimerLabel.setFontScale(3);
        expliPanneTimerLabel.setPosition(pubAndResumePanneButton.getX() - expliPanneTimerLabel.getWidth()*2.8f,
                pubAndResumePanneButton.getY() + expliPanneTimerLabel.getHeight()*11);
        stage.addActor(expliPanneTimerLabel);

        String panneTimerLabelString = Integer.toString((int)deceptionTimer) + mtcGame.getTrad().getSecondes();
        panneTimerLabel = new Label(panneTimerLabelString,scorePointsStyle);
        panneTimerLabel.setColor(Color.BLACK);
        panneTimerLabel.setFontScale(3);
        panneTimerLabel.setPosition(pubAndResumePanneButton.getX() - panneTimerLabel.getWidth()*3.2f,
                pubAndResumePanneButton.getY() + panneTimerLabel.getHeight()*8);
        stage.addActor(panneTimerLabel);

        panneMenuGroup.addActor(pubAndResumePanneButton);
        panneMenuGroup.addActor(panneTimerLabel);
        panneMenuGroup.addActor(expliPanneTimerLabel);
        panneMenuGroup.setPosition(stageViewport.getWorldWidth()/1.35f,stageViewport.getWorldHeight()/2.5f);
        panneMenuGroup.setScale(0.35f);
        panneMenuGroup.setVisible(false);

        stage.addActor(panneMenuGroup);
        stage.addActor(popUpTimerGroup);
        stage.addActor(popUpWifiGroup);

    }

    private void elementHUDVisible() {
        if (jump) {
            sousBoutonJumpGreen.setVisible(true);
        } else {
            sousBoutonJumpGreen.setVisible(false);
        }
        if (okNitro) {
            sousBoutonNitroGreen.setVisible(false);
        } else {
            sousBoutonNitroGreen.setVisible(true);
        }
        if (okMontant) {
            montantPrime.setVisible(true);
        } else {
            montantPrime.setVisible(false);
        }
    }


    /**
     * CONSO CARBURANT selon déplacement véhicule et mise a jour rotation aiguille de la jauge
     */
    private void fuelBurning() {
        if(!okPause){
            if (!fuelFillBool) {
                fuel += vehicule.getChassis().getLinearVelocity().x / 1250;
            }
        }
    }

    /**
     * Incrémentation/décrémentation de la VITESSE
     */
    private void compteurVitesse() {
        if (vehicule.getChassis().getLinearVelocity().x > vitesse) {
            // jusqu'à 90 km/h (pour vitesse * 2)
            if (vitesse < 45) {
                vitesse += 0.125f;
                // au-dela de 90 on incrémente moins vite
            }else{
                vitesse += 0.0625f;
            }
        } else {
            vitesse -= 0.35f;
        }

    }


    /**
     * Mort par explosion du moteur
     */
    private void tachyAvantExplosionFondRougeVisible() {
        // Limite vitesse avant explosion du moteur
        if (vitesse > 53.5f) {
            tachyDeadAlarm = true;
            if (!tachyAlarm) {
                if (tachyAlarmTimer <= 5) {
                    tachyAlarmTimer += 0.1f;
                    if (tachyAlarmTimer >= 5) {
                        tachyAlarm = true;
                    }
                }
            } else {
                tachyAlarmTimer -= 0.1f;
                if (tachyAlarmTimer <= 0) {
                    tachyAlarm = false;
                }
            }
        } else {
            tachyDeadAlarm = false;
            tachyAlarm = false;
        }

    }


    private void tachyAlarmSound() {
        if (tachyAlarm) {
            tachyAlarmSound.setVolume(0.25f);
            tachyAlarmSound.play();
            // évite la répétition du signal sonore
            if (tachyAlarmTimer < 2f) {
                tachyAlarmSound.stop();
            }
        }
    }

    private void tachyDeadTimerDecompte() {
        if (tachyDeadAlarm) {
            if (tachyDeadTimer >= 0) {
                tachyDeadTimer -= 0.015f;
                tachyDeath();
            }
        } else {
            tachyDeadTimer = 5.9f;
        }
    }

    private void tachyDeath() {
        if (tachyDeadTimer <= 0.05f) {
            vehicule.setDead(true);
            exitChoice = "accident";
            okTachyDeath = true;
            playerCrashSound();
        }
        if (tachyDeadTimer <= 0) {
            tachyDeadAlarm = false;
        }
    }

    private void jaugeFondRougeVisible() {
        if (fuel > -40 && fuel < -10) {
            if (!fuelAlarm) {
                if (fuelAlarmTimer <= 2.5f) {
                    fuelAlarmTimer += 0.1f;
                    if (fuelAlarmTimer >= 2.5) {
                        fuelAlarm = true;
                    }
                }
            } else {
                fuelAlarmTimer -= 0.1f;
                if (fuelAlarmTimer <= 0) {
                    fuelAlarm = false;
                }
            }
        } else {
            fuelAlarm = false;
        }
        if (fuel > -10) {
            isFuelEmpty = true;
            vehicule.getVehiculeSoundDecel().stop();
            vehicule.getVehiculeSoundAccel().stop();
        }
    }

    private void jaugeAlarmSound() {
        if (fuelAlarmTimer <= 0.2f) {
            jaugeAlarmSound.setVolume(0.5f);
            jaugeAlarmSound.play();
        }
        // évite la répétition du signal sonore
        if (fuelAlarmTimer <= 0.1f) {
            jaugeAlarmSound.stop();
        }
    }

    /**
     * Lecture unique du son de crash
     */
    private void playerCrashSound() {
        if (vehicule.isDead()) {
            if (crashSoundTimer > 0) {
                crashSoundTimer -= 0.05f;
            }
            // permet de faire une seule lecture du son
            if (crashSoundTimer < 1 && crashSoundTimer > 0.9) {
                vehicule.getVehiculeCrashSound().play();
            }
        }
    }

    /**
     * Méthode de traveling et zoom de la caméra
     */
    private void decalageCameraPositionX() {
        if (decalageCam <= 128)
            decalageCam += 1.81f;
    }

    private void reverseDecalageCameraPositionX() {
        if (decalageCam >= 14)
            decalageCam -= 1f;
    }

    private void updateCameraPositionX() {
        box2dCam.position.set(vehicule.getChassis().getPosition().x + decalageCam * 1.25f, vehicule.getChassis().getPosition().y *0.975f, box2dCam.position.z);
        box2dCam.update();
    }

    private void updateCameraPositionZ() {
        if (vehicule.getChassis().getLinearVelocity().x > 5) {
            okDezoom = true;
        }
        if (vehicule.isDead() || finishRaceBool) {
            okDezoom = false;
        }
    }

    private void zoomDezoom() {
        boolean boolDecalageCamX;
        if (okDezoom) {
            boolDecalageCamX = true;
            if (box2dCam.zoom <= 0.95f) {
                // réglage de la souplesse du zoom
                box2dCam.zoom += 0.0063f;
                box2dCam.update();
            }
        } else {
            boolDecalageCamX = false;
            if (box2dCam.zoom >= 0.55f) {
                // réglage de la souplesse du dézoom
                box2dCam.zoom -= 0.0035f;
                box2dCam.update();
            }
        }
        if (boolDecalageCamX) {
            decalageCameraPositionX();
        } else {
            reverseDecalageCameraPositionX();
        }
    }


    /**
     * CONTACTLISTENER
     * Permet l'exécution d'instructions en fonction de contacts choisis
     */
    private void contactWheelToGround() {
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                // contact pour le boost
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();
                if (fixtureA.equals(vehicule.getLeftWheelFixture())) {
                    boostLeft = true;
                } else if (fixtureB.equals(vehicule.getLeftWheelFixture())) {
                    boostLeft = true;
                }
                if (fixtureA.equals(vehicule.getRightWheelFixture())) {
                    boostRight = true;
                } else if (fixtureB.equals(vehicule.getRightWheelFixture())) {
                    boostRight = true;
                }

                // contact pour mort du player
                if (fixtureA.equals(vehicule.getDeadBoxFixture())) {
                    playerCrashSound();
                    vehicule.setDead(true);
                }
                if (fixtureB.equals(vehicule.getDeadBoxFixture())) {
                    playerCrashSound();
                    vehicule.setDead(true);
                }

                // boucle sur contacts des ennemis pour mort des ennemis
                for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
                    if (fixtureA.equals(vehiculeGenerator.getDeadBoxFixture()) && fixtureB.equals(vehicule.getChassisFixture())) {
                        increaseScoreDead(vehiculeGenerator);
                    }
                    if (fixtureB.equals(vehiculeGenerator.getDeadBoxFixture()) && fixtureA.equals(vehicule.getChassisFixture())) {
                        increaseScoreDead(vehiculeGenerator);
                    }
                    if (fixtureA.equals(vehiculeGenerator.getDeadBoxFixture()) && fixtureB.equals(vehicule.getLeftWheelFixture())) {
                        increaseScoreDead(vehiculeGenerator);
                    }
                    if (fixtureB.equals(vehiculeGenerator.getDeadBoxFixture()) && fixtureA.equals(vehicule.getLeftWheelFixture())) {
                        increaseScoreDead(vehiculeGenerator);
                    }
                    if (fixtureA.equals(vehiculeGenerator.getDeadBoxFixture()) && fixtureB.equals(vehicule.getRightWheelFixture())) {
                        increaseScoreDead(vehiculeGenerator);
                    }
                    if (fixtureB.equals(vehiculeGenerator.getDeadBoxFixture()) && fixtureA.equals(vehicule.getRightWheelFixture())) {
                        increaseScoreDead(vehiculeGenerator);
                    }
                }

                // boucle sur contact des ennemis qui meurt seul
                for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
                    // boucle sur les vehicules
                    if (fixtureA.equals(vehiculeGenerator.getDeadBoxFixture()) && !fixtureB.equals(vehicule.getLeftWheelFixture())) {
                        vehiculeGenerator.setDead(true);
                    }
                    if (fixtureB.equals(vehiculeGenerator.getDeadBoxFixture()) && !fixtureA.equals(vehicule.getLeftWheelFixture())) {
                        vehiculeGenerator.setDead(true);
                    }
                    if (fixtureA.equals(vehiculeGenerator.getDeadBoxFixture()) && !fixtureB.equals(vehicule.getRightWheelFixture())) {
                        vehiculeGenerator.setDead(true);
                    }
                    if (fixtureB.equals(vehiculeGenerator.getDeadBoxFixture()) && !fixtureA.equals(vehicule.getRightWheelFixture())) {
                        vehiculeGenerator.setDead(true);
                    }
                }

                // boucle sur contact du vehicule mode NITRO
                if(okNitro){
                    for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
                        // boucle sur les vehicules
                        if (fixtureA.equals(vehiculeGenerator.getChassisFixture()) && fixtureB.equals(vehicule.getLeftWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureB.equals(vehiculeGenerator.getChassisFixture()) && fixtureA.equals(vehicule.getLeftWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureA.equals(vehiculeGenerator.getChassisFixture()) && fixtureB.equals(vehicule.getRightWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureB.equals(vehiculeGenerator.getChassisFixture()) && fixtureA.equals(vehicule.getRightWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureA.equals(vehiculeGenerator.getChassisFixture()) && fixtureB.equals(vehicule.getChassisFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureB.equals(vehiculeGenerator.getChassisFixture()) && fixtureA.equals(vehicule.getChassisFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                    }
                    for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
                        // boucle sur les vehicules
                        if (fixtureA.equals(vehiculeGenerator.getLeftWheelFixture()) && fixtureB.equals(vehicule.getLeftWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureB.equals(vehiculeGenerator.getLeftWheelFixture()) && fixtureA.equals(vehicule.getLeftWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureA.equals(vehiculeGenerator.getLeftWheelFixture()) && fixtureB.equals(vehicule.getRightWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureB.equals(vehiculeGenerator.getLeftWheelFixture()) && fixtureA.equals(vehicule.getRightWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureA.equals(vehiculeGenerator.getLeftWheelFixture()) && fixtureB.equals(vehicule.getChassisFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureB.equals(vehiculeGenerator.getLeftWheelFixture()) && fixtureA.equals(vehicule.getChassisFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                    }

                    for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
                        // boucle sur les vehicules
                        if (fixtureA.equals(vehiculeGenerator.getRightWheelFixture()) && fixtureB.equals(vehicule.getLeftWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureB.equals(vehiculeGenerator.getRightWheelFixture()) && fixtureA.equals(vehicule.getLeftWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureA.equals(vehiculeGenerator.getRightWheelFixture()) && fixtureB.equals(vehicule.getRightWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureB.equals(vehiculeGenerator.getRightWheelFixture()) && fixtureA.equals(vehicule.getRightWheelFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureA.equals(vehiculeGenerator.getRightWheelFixture()) && fixtureB.equals(vehicule.getChassisFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                        if (fixtureB.equals(vehiculeGenerator.getRightWheelFixture()) && fixtureA.equals(vehicule.getChassisFixture())) {
                            increaseScoreDead(vehiculeGenerator);
                        }
                    }
                }
            }

            @Override
            public void endContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();
                if (fixtureA.equals(vehicule.getLeftWheelFixture())) {
                    boostLeft = false;
                } else if (fixtureB.equals(vehicule.getLeftWheelFixture())) {
                    boostLeft = false;
                }
                if (fixtureA.equals(vehicule.getRightWheelFixture())) {
                    boostRight = false;
                } else if (fixtureB.equals(vehicule.getRightWheelFixture())) {
                    boostRight = false;
                }
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }
        });
    }

    private void increaseScoreDead(VehiculeGenerator vehiculeGenerator) {
        vehiculeGenerator.setCrashed(true);
        if(!okNitro) {
            crashTimerMax = 5;
        } else {
            crashTimerMax = 0.65f;
        }
        vehiculeGenerator.getVehiculeCrashSound().setVolume(0.85f);
        vehiculeGenerator.getVehiculeCrashSound().play();
        scoreDead += 1;
        coinSound.play();
        affichageTemporaire = "+"+Integer.toString(vehiculeGenerator.getPrime());
        okScale = true;
        okTilt = true;
        if (!fuelFillBool) {
            scorePointsTotal += vehiculeGenerator.getPrime();
            moneyToWin = true;
        } else {
            scorePointsTemp += vehiculeGenerator.getPrime();
        }
    }

    private void scorePointsColorChangerGreen() {
        if (moneyToWin) {
            scorePoints.setColor(Color.GREEN);
            if (colorChangerTimer < 5) {
                colorChangerTimer += 0.08f;
            }
            if (colorChangerTimer >= 5) {
                if(groundChoice != 2 && groundChoice != 6){
                    scorePoints.setColor(Color.BLACK);
                }else{
                    scorePoints.setColor(Color.WHITE);
                }
                colorChangerTimer = 0;
                moneyToWin = false;
            }
        }
    }

    /**
     * autorise le boost
     *
     * @return
     */
    private void isBoostOnTwoWheels() {
        if (boostLeft || boostRight) {
            boost = true;
        } else {
            boost = false;
        }
    }


    /**
     * COLLECTABLE
     */
    private void createCollectableToGrab(){
        Array<Vector2> bonusPositions = ground.getBonusPositions();
        for (Vector2 position : bonusPositions){
            Collectable collectableToAdd = collectableChoicer(position.x,position.y);
            bonusPositions.removeIndex(0);
            bonusToGrabList.add(collectableToAdd);
        }
    }

    private Collectable collectableChoicer(float x, float y){
        int collectableChoice = MathUtils.random(0, 4);
        if (collectableChoice == 0){
            collectable = new Coin(mtcGame,x, y);
        }
        if (collectableChoice == 1){
            if(!billetsBool){
                collectable = new BonusBillets(mtcGame,x, y);
                billetsBool = true;
            }else{
                collectableChoice = MathUtils.random(0,4);
            }
        }
        if (collectableChoice == 2){
            if(!gasFreeBool){
                collectable = new BonusGasFree(mtcGame,x, y);
                gasFreeBool = true;
            }else{
                collectableChoice = MathUtils.random(0,4);
            }
        }
        if (collectableChoice == 3){
            if(!multiScoreBool){
                collectable = new BonusMultiScore(mtcGame,x, y);
                multiScoreBool = true;
            }else{
                collectableChoice = MathUtils.random(0,4);
            }
        }
        if (collectableChoice == 4){
            if(!nitroBool) {
                collectable = new BonusNitro(mtcGame,x, y);
                nitroBool = true;
            }
        }
        return collectable;
    }

    private void eraseBonusNotGrabbed() {
        for (Collectable collectable : bonusToGrabList) {
            if (collectable.getPositionX() < vehicule.getChassis().getPosition().x - viewport.getWorldWidth() / 4) {
                bonusToGrabList.removeValue(collectable, true);
            }
        }
    }

    private void overlapBonusAndVehiculesPolygons() {
        for (Collectable collectable : bonusToGrabList) {
            if (Intersector.overlapConvexPolygons(collectable.getCollisionRectangle(), vehiculeCollisionRectangle)) {
                addBonusToPlayer(collectable);
            }
            if (Intersector.overlapConvexPolygons(collectable.getCollisionRectangle(), headCollisionRectangle)) {
                addBonusToPlayer(collectable);
            }
            for (Polygon polygon : wheelsPolygons.values()) {
                if (Intersector.overlapConvexPolygons(collectable.getCollisionRectangle(), polygon)) {
                    addBonusToPlayer(collectable);
                }
            }
        }
    }

    private void addBonusToPlayer(Collectable collectable) {
        if(!collectable.getCollectableIdentifier().equals("")){
            if (collectable.getCollectableIdentifier().equals("bonusBillets")) {
                bonusToGrabList.removeValue(collectable, true);
                coinSound.play();
                okTilt = true;
                if (!fuelFillBool) {
                    scorePointsTotal += 100;
                } else {
                    scorePointsTemp += 100;
                }
                okMontant = true;
                affichageTemporaire = "+100$ !!";
                billetCatched = 1;
            }
            if (collectable.getCollectableIdentifier().equals("bonusGasFree")) {
                bonusToGrabList.removeValue(collectable, true);
                fuelFillBool = true;
                payment = scorePointsTotal;
                coinSound.play();
                okTilt = true;
                okMontant = true;
                reservoirFillingSound.play();
                montantPrime.setFontScale(0.85f);
                affichageTemporaire = "Free Gas!!";
                gasFreeCatched = 1;
            }
            if (collectable.getCollectableIdentifier().equals("multiScoreX3")) {
                bonusToGrabList.removeValue(collectable, true);
                coinSound.play();
                okTilt = true;
                okMontant = true;
                montantPrime.setFontScale(0.85f);
                affichageTemporaire = "Score X3 !!";
                multiplierScore = "X3";
            }
            if (collectable.getCollectableIdentifier().equals("multiScoreX2")) {
                bonusToGrabList.removeValue(collectable, true);
                coinSound.play();
                okTilt = true;
                okMontant = true;
                montantPrime.setFontScale(0.85f);
                affichageTemporaire = "Score X2 !!";
                multiplierScore = "X2";
            }
            if (collectable.getCollectableIdentifier().equals("bonusNitro")) {
                bonusToGrabList.removeValue(collectable, true);
                coinSound.play();
                okTilt = true;
                okMontant = true;
                affichageTemporaire = "NITRO !!";
                nitroCatched = 1;
                // boostPower * 2, explosion ennemi, clignote pendant 10 secondes
                vehicule.getTableauNITROTexture().setVisible(true);
                nitroBoutonGroup.setVisible(true);
            }
        }else{
            bonusToGrabList.removeValue(collectable, true);
            coinSound.play();
            okTilt = true;
            if (!fuelFillBool) {
                scorePointsTotal += 10;
            } else {
                scorePointsTemp += 10;
            }
        }
    }

    private void nitroTimer(){
        if(okNitro){
            if(nitroTimer > 0){
                nitroTimer -= 0.015f;
                affichageTemporaire = "Nitro : "+Integer.toString((int)nitroTimer);
                montantPrime.setFontScale(0.8f);
                okMontant = true;
                motorAccel = vehicule.getBoostPower();
                motor = true;
                nitroMusic.play();
            }else{
                okNitro = false;
                nitroTimer = 10;
                motor = false;
                vehicule.getTableauNITROTexture().setVisible(false);
                nitroBoutonGroup.setVisible(false);
                nitroMusic.stop();
            }
        }
    }

    /**
     * COINS
     * instanciation des coins
     *
     * @return
     */
    private void createCoinToGrab() {
        Array<Vector2> coinsPositions = ground.getCoinsPositions();
        for (Vector2 position : coinsPositions) {
            if (position.x < vehicule.getChassis().getPosition().x + viewport.getWorldWidth()) {
                Coin coin = new Coin(mtcGame,position.x, position.y);
                coinsPositions.removeIndex(0);
                coinToGrabList.add(coin);
            }
        }
    }

    private void eraseCoinsNotGrabbed() {
        for (Coin coin : coinToGrabList) {
            if (coin.getPositionX() < vehicule.getChassis().getPosition().x - viewport.getWorldWidth() / 4) {
                coinToGrabList.removeValue(coin, true);
            }
        }
    }

    private void overlapCoinAndVehiculesPolygons() {
        for (Coin coin : coinToGrabList) {
            if (Intersector.overlapConvexPolygons(coin.getCollisionRectangle(), vehiculeCollisionRectangle)) {
                addCoinsToScoreTotal(coin);
            }
            if (Intersector.overlapConvexPolygons(coin.getCollisionRectangle(), headCollisionRectangle)) {
                addCoinsToScoreTotal(coin);
            }
            for (Polygon polygon : wheelsPolygons.values()) {
                if (Intersector.overlapConvexPolygons(coin.getCollisionRectangle(), polygon)) {
                    addCoinsToScoreTotal(coin);
                }
            }
        }
    }

    private void addCoinsToScoreTotal(Coin coin) {
        coinToGrabList.removeValue(coin, true);
        coinSound.play();
        okTilt = true;
        if (!fuelFillBool) {
            scorePointsTotal += 10;
        } else {
            scorePointsTemp += 10;
        }
    }

    /**
     * JERRYCANS
     *
     * @return
     */
    private void createJerrycanToGrab() {
        Array<Vector2> jerrycansPositions = ground.getJerrycanPositions();
        for (Vector2 position : jerrycansPositions) {
            if (position.x < vehicule.getChassis().getPosition().x + viewport.getWorldWidth()) {
                Jerrycan jerrycan = new Jerrycan(mtcGame,position.x, position.y);
                jerrycansPositions.removeIndex(0);
                jerrycanToGrabList.add(jerrycan);
            }
        }
    }

    private void eraseJerrycanNotGrabbed() {
        for (Jerrycan jerrycan : jerrycanToGrabList) {
            if (jerrycan.getPositionX() < vehicule.getChassis().getPosition().x - viewport.getWorldWidth() / 4) {
                jerrycanToGrabList.removeValue(jerrycan, true);
            }
        }
    }

    private void overlapJerrycanAndVehiculePolygons() {
        for (Jerrycan jerrycan : jerrycanToGrabList) {
            if (Intersector.overlapConvexPolygons(jerrycan.getCollisionPolygon(), vehiculeCollisionRectangle)) {
                jerrycanFillReservoir(jerrycan);
            }
            if (Intersector.overlapConvexPolygons(jerrycan.getCollisionPolygon(), headCollisionRectangle)) {
                jerrycanFillReservoir(jerrycan);
            }
            for (Polygon polygon : wheelsPolygons.values()) {
                if (Intersector.overlapConvexPolygons(jerrycan.getCollisionPolygon(), polygon)) {
                    jerrycanFillReservoir(jerrycan);
                }
            }
        }
    }

    private void jerrycanFillReservoir(Jerrycan jerrycan) {
        if (scorePointsTotal >= 100) {
            jerrycanToGrabList.removeValue(jerrycan, true);
            fuelFillBool = true;
            okTilt = true;
            coinSound.play();
            reservoirFillingSound.play();
        } else {
            noMoneyDetectBool = true;
            if (noMoneyTimer == 0) {
                noMoneyBool = true;
                noMoneyTimer += 0.1f;
            }
        }
    }

    private void resetNoMoneyDetectBoolAndNoMoneyTimer() {
        if (noMoneyDetectBool) {
            if (resetNoMoneyTimer < 5) {
                resetNoMoneyTimer += 0.03f;
            }
        }
        if (resetNoMoneyTimer >= 5) {
            noMoneyDetectBool = false;
            noMoneyTimer = 0;
            resetNoMoneyTimer = 0;
        }
    }

    private void fillingFuelReservoir() {
        if (fuelFillBool) {
            if (fuel > -120) {
                fuel -= 0.35f;
            }
        }
        if (fuel <= -120 && okPayment) {
            fuelFillBool = false;
            fuelAlarmTimer = 0;
        }
    }

    private void payFuel() {
        if (fuelFillBool) {
            if (scorePointsTotal > payment) {
                scorePointsTotal -= 0.5f;
                scorePoints.setColor(Color.FIREBRICK);
            }
            if (scorePointsTotal == payment) {
                okPayment = true;
                if(groundChoice != 2 && groundChoice != 6){
                    scorePoints.setColor(Color.BLACK);
                }else{
                    scorePoints.setColor(Color.WHITE);
                }
            }
        } else {
            okPayment = false;
            if(groundChoice != 2 && groundChoice != 6){
                scorePoints.setColor(Color.BLACK);
            }else{
                scorePoints.setColor(Color.WHITE);
            }
        }

    }

    private void updatePayment() {
        if (!fuelFillBool) {
            if (scorePointsTotal >= 100) {
                payment = scorePointsTotal - 100;
            }
        }
    }

    private void noMoneyBuzzer() {
        if (noMoneyBool) {
            noMoneySound.setVolume(0.6f);
            noMoneySound.play();
            noMoneyBool = false;
        }
    }

    /**
     * Stocke les points acquis durant le remplissage du réservoir
     * et les ajoutent au compte une fois le paiement du plein terminé
     */
    private void updateScoreTemp() {
        if (!fuelFillBool) {
            if (scorePointsTemp > 0) {
                scorePointsTotal += scorePointsTemp;
                scorePointsTemp = 0;
                moneyToWin = true;
            }
        }
    }

    /**
     * Vehicule : Rectangles de COLLISION
     */
    private void updateVehiculeCollisionPolygons() {
        vehiculeCollisionRectangle.setPosition(vehicule.getChassis().getPosition().x, vehicule.getChassis().getPosition().y);
        vehiculeCollisionRectangle.setRotation(vehicule.getChassisSprite().getRotation());
        headCollisionRectangle.setPosition(vehicule.getDeadBox().getPosition().x, vehicule.getDeadBox().getPosition().y);
        for (Body body : wheelsPolygons.keys()) {
            Polygon polygon = wheelsPolygons.get(body);
            polygon.setPosition(body.getPosition().x, body.getPosition().y);
            polygon.setScale(0.25f, 0.25f);
        }
    }


    /**
     * VEHICULES ENNEMIS
     * création des véhicules ennemis en fonction de la distance entre le position
     * d'apparition et la distance du player (min et max) et un drapeau permettant
     * de savoir si un autre vehicule ennemi se trouve en-dessous
     */
    private void createEnemiesVehicules() {
        enemiesPositions = ground.getEnemiesPositions();
        if (EnemiesVehicules.size < 4) {
            for (Vector2 position : enemiesPositions) {
                if (position.x < vehicule.getChassis().getPosition().x + viewport.getWorldWidth()) {
                    if (isPlaceFree()) {
                        VehiculeGenerator EnemyVehicule = new VehiculeGenerator(createVehiculeDef(99,""),
                                mtcGame,world,pilote,position,99);
                        enemiesPositions.removeIndex(0);
                        EnemiesVehicules.add(EnemyVehicule);
                        nbEnemies += 1;
                    }
                }
            }
        }
    }

    /**
     * Interdit la création d'ennemi lorsque un vehicule est présent sous le point d'apparition
     *
     * @return
     */
    private boolean isPlaceFree() {
        if (EnemiesVehicules.size > 0) {
            for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
                if (enemiesPositions.size > 1) {
                    if (enemiesPositions.get(0).x - vehiculeGenerator.getChassis().getPosition().x < 50) {
                        freePlace = false;
                        freeTime = 0;
                        if (enemiesPositions.size > 0) {
                            enemiesPositions.removeIndex(0);
                        }
                    }
                }
            }
        }
        return freePlace;
    }

    /**
     * Chronomètre redonnant la permission de créer des ennemis
     */
    private void freePlaceTimer() {
        if (!freePlace) {
            if (freeTime < 5) {
                freeTime += 0.1f;
            }
        }
        if (freeTime >= 5) {
            freePlace = true;
            freeTime = 0;
        }
    }

    /**
     * Chrono rapide aller-retour pour scale du panneau
     */
    private void scaleTimer() {
        if (okScale) {
            if (scaler < 2.5f) {
                scaler += 0.25f;
                if (scaler >= 2.5f) {
                    okScale = false;
                }
            }
        } else {
            if (scaler >= 1.25f) {
                scaler -= 0.25f;
            }
        }
    }

    /**
     * Chrono rapide aller-retour pour tilt du dollar
     */
    private void tiltTimer() {
        if (okTilt) {
            if (tilter < 2.5f) {
                tilter += 0.25f;
                if (tilter >= 2.f) {
                    okTilt = false;
                    tilter = 0;
                }
            }
        } else {
            if (tilter >= 0.25f) {
                tilter -= 0.25f;
            }
        }
    }

    private void timeToJump() {
        if (!jump) {
            if (jumpTimer <= 10) {
                jumpTimer += 0.1f;
            }
        }
        if (jumpTimer >= 10) {
            jump = true;
            jumpTimer = 0;
        }
    }

    /**
     * Chrono pour temps d'affichage de la prime reçue par voiture écrasée
     */
    private void montantPrimeTimer() {
        if (okScale && affichageTemporaire != "") {
            okMontant = true;
        }
        if (okMontant) {
            if (montantTimer < 7f) {
                montantTimer += 0.1f;
            }
        }
        if (montantTimer >= 7) {
            okMontant = false;
            montantTimer = 0;
        }
    }

    /**
     * incrémente motorAccel
     */
    private void accelMotor() {
        if (motor) {
            if (motorAccel <= vehicule.getBoostPower()) {
                motorAccel += 5 + (pilote.getPiloteSkills()[mtcGame.getPrefs().getInteger("headChoice")][1]);
            }
        }
        if (!motor) {
            if (motorAccel >= 0.2) {
                motorAccel -= 1f;
            }
        }
    }

    private void vehiculeMotor() {
        if (motor && boost) {
            vehicule.getLeftWheel().setLinearVelocity(motorAccel, vehicule.getLeftWheel().getLinearVelocity().y);
            vehicule.getRightWheel().setLinearVelocity(motorAccel, vehicule.getLeftWheel().getLinearVelocity().y);
            vehicule.getChassis().setLinearVelocity(motorAccel, vehicule.getChassis().getLinearVelocity().y);
        }
        if(motor){
            vehicule.getLeftWheel().setAngularVelocity(-motorAccel/10);
            vehicule.getRightWheel().setAngularVelocity(-motorAccel/20);
        }
    }

    private void vehiculeBrake() {
        if (okBrake) {
            vehicule.getLeftWheel().setAngularVelocity(vehicule.getLeftWheel().getAngularVelocity() / 2);
            vehicule.getRightWheel().setAngularVelocity(vehicule.getLeftWheel().getAngularVelocity() / 2);
            vehicule.getChassis().setAngularVelocity(vehicule.getChassisAngularVelocity());
        }
    }

    private void updateVehiculeEnemies() {
        for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
            if (!vehiculeGenerator.isDead()) {
                vehiculeGenerator.updateSpritePositions(vehiculeGenerator.getSprites());
                vehiculeGenerator.updateBodySpritePositions(vehiculeGenerator.getBodySprites());
                autoDrive(vehiculeGenerator.getChassis(),vehiculeGenerator.getLeftWheel(),
                        vehiculeGenerator.getRightWheel(),vehiculeGenerator.getBoostPower());

            } else {
                vehiculesToRemove.add(vehiculeGenerator);
                EnemiesVehicules.removeValue(vehiculeGenerator, true);
            }
        }
    }

    private void autoDrive(Body chassis,Body leftWheel,Body rightWheel,float boostPower) {
        // moteur du vehicule
        if(chassis != null){
            if (chassisAngle(chassis) < 35 && chassisAngle(chassis) > -35 && chassis.getLinearVelocity().x < 20) {
                leftWheel.setLinearVelocity(boostPower/2, leftWheel.getLinearVelocity().y);
                rightWheel.setLinearVelocity(boostPower/2, rightWheel.getLinearVelocity().y);
                chassis.setLinearVelocity(boostPower/2, chassis.getLinearVelocity().y);
            }
            // anti-frontFlip
            if (chassisAngle(chassis) < 90 && chassisAngle(chassis) > 45) {
                chassis.setAngularVelocity(-4f);
            }
            // anti-backFlip
            if (chassisAngle(chassis) < -90 && chassisAngle(chassis) > -45) {
                chassis.setAngularVelocity(4f);
            }
        }
    }

    private float chassisAngle(Body chassis) {
        return (MathUtils.sin(chassis.getAngle()) * 60);
    }

    private void updateCrashedVehicules() {
        for (VehiculeGenerator vehiculeGenerator : EnemiesVehicules) {
            if (vehiculeGenerator.isCrashed()) {
                vehiculesToCrash.add(vehiculeGenerator);
                EnemiesVehicules.removeValue(vehiculeGenerator, true);
            }
        }
    }

    private void collectDeadEnemiesVehicules() {
        if (vehiculesToRemove.size > 0) {
            for (VehiculeGenerator vehiculeGenerator : vehiculesToRemove) {
                vehiculeGenerator.destroyBodiesAndSprites();
                vehiculesToRemove.removeValue(vehiculeGenerator, true);
            }
        }
    }

    private void collectCrashedEnemiesVehicules() {
        if (vehiculesToCrash.size > 0) {
            for (VehiculeGenerator vehiculeGenerator : vehiculesToCrash) {
                vehiculeGenerator.updateSpritePositions(vehiculeGenerator.getCrashSprites());
                vehiculeGenerator.crashJoints();
                if (crashTimer < crashTimerMax) {
                    crashTimer += 0.05f;
                }
                if (crashTimer >= crashTimerMax) {
                    vehiculeGenerator.setDead(true);
                    vehiculesToRemove.add(vehiculeGenerator);
                    vehiculesToCrash.removeValue(vehiculeGenerator, true);
                    crashTimer = 0;
                }
            }
        }
    }


    private void drawDeadOrVictoriousPlayerSprites() {
        if(!finishRaceBool){
            if (!vehicule.isDead()) {
                vehicule.updateBodySpritePositions(vehicule.getBodySprites());
                vehicule.updateSpritePositions(vehicule.getSprites());
                vehicule.draw(batch);
            } else {
                vehicule.drawCrash(batch);
                vehicule.updateSpritePositions(vehicule.getCrashSprites());
            }
        }else{
            vehicule.drawVictorious(batch);
            vehicule.updateBodySpritePositions(vehicule.getBodySprites());
            vehicule.updateSpritePositions(vehicule.getVictoriousSprites());
        }
    }

    private void deadPlayer() {
        if (vehicule.isDead()) {
            vehicule.crashJoints();
            if(!okTachyDeath){
                exitChoice = "accident";
            }
        }
    }

    private void finishRace() {
        if (vehicule.getChassis().getPosition().x > ground.getFinishFlagPosition().x + (vehicule.getChassisSprite().getWidth() / 2)) {
            finishRaceBool = true;
            // cri victoire
            exitChoice = "victoire";
        }

    }

    /**
     * Validation du visionnage de la pub et
     * Versement de la récompense
     */
    private void videoViewedToggleBool(){
        if(mtcGame.getGoogleServices().hasVideoViewed()){
            fuel = -20;
            deceptionTimer = 6;
            isFuelEmpty = false;
            pauseButton.setVisible(true);
            fuelFillBool = true;
            payment = scorePointsTotal;
            coinSound.play();
            okTilt = true;
            reservoirFillingSound.play();
            okPause = false;
            if(videoViewedTimer < 2){
                videoViewedTimer += 0.1f;
            }
        }
        if(videoViewedTimer >= 2){
            mtcGame.getGoogleServices().setIs_video_ad_viewed(false);
            mtcGame.getGoogleServices().setIs_video_ad_closed(false);
            videoViewedTimer = 0;
        }
    }

    private void videoClosedToggleBool() {
        if (mtcGame.getGoogleServices().hasVideoClosed()) {
            videoClosed = true;
        }else{
            videoClosed = false;
        }
    }

    private void viewedVideosPerDayLimiter() {
        if (mtcGame.getPrefs().getInteger("nbVideoViewed") > mtcGame.getMaxVideoPerPeriod()) {
            mtcGame.getPrefs().putBoolean("videoViewedLimit", true).flush();
        }
        if (mtcGame.getPrefs().getBoolean("videoViewedLimit")) {
            // récup de la date
            timeElapsing = TimeUtils.millis();
        }
        // si date + 4h --> boolean false et viedVideosPerDay = 0;
        if (timeElapsing > mtcGame.getPrefs().getLong("VVLimitTimeStart") + mtcGame.getPeriodBeforeNewVideos()) {
            mtcGame.getPrefs().putBoolean("videoViewedLimit", false).flush();
            mtcGame.getPrefs().putInteger("nbVideoViewed", 0).flush();
            mtcGame.getPrefs().putLong("VVLimitTimeStart", 0).flush();
        }
        cycleTimeElapsing = TimeUtils.millis();
        // fin de cycle de 2 heures
        if(cycleTimeElapsing > mtcGame.getPrefs().getLong("VVFirstTimeCycleStart") + mtcGame.getPeriodCycleRefreshNbVideos() ){
            mtcGame.getPrefs().putInteger("nbVideoViewed", 0).flush();
        }

    }

    private String timeToStringConvert(Long time){
        millis = time % 1000;
        seconds = (time / 1000) % 60;
        minutes = (time / (1000 * 60)) % 60;
        hours = (time / (1000 * 60 * 60)) % 24;
        horloge = Integer.toString((int)hours) + " h " + Integer.toString((int)minutes) + " mn " + Integer.toString((int)seconds) + " s";
        return horloge;
    }

    private void popUpTimerVisibiliteTimer(){
        if(popUpTimerGroup.isVisible()){
            if(popUpTimerGroupTimer < 3){
                popUpTimerGroupTimer += 0.0125f;
            }
        }
        if(popUpTimerGroupTimer >= 3){
            popUpTimerGroup.setVisible(false);
            popUpTimerGroupTimer = 0;
        }
    }

    private void popUpWifiVisibiliteTimer(){
        if(popUpWifiGroup.isVisible()){
            if(popUpWifiGroupTimer < 3){
                popUpWifiGroupTimer += 0.015f;
            }
        }
        if(popUpWifiGroupTimer >= 3){
            popUpWifiGroup.setVisible(false);
            popUpWifiGroupTimer = 0;
        }
    }

    private void goLabelVisibiliteTimer(){
        if(goLabelTimer < 1.5f){
            goLabelTimer += 0.05f;
        }
        if(goLabelTimer >= 1.5f){
            goLabelTimer = 1.5f;
            goLabel.setVisible(false);
        }
    }

    public static float getUnitsPerMeter() {
        return UNITS_PER_METER;
    }

    private void debugLog() {
//        Gdx.app.log("Vitesse chassis",Float.toString(vehicule.getChassis().getLinearVelocity().x) );
//        Gdx.app.log("Vitesse roue",Float.toString(vehicule.getLeftWheel().getAngularVelocity()) );
//        Gdx.app.log("Boost ", Boolean.toString(boost));
//        Gdx.app.log("Chassis Angle", Float.toString(MathUtils.sin(vehicule.getChassis().getAngle())*100));
//        Gdx.app.log("User Data ",vehicule.getLeftWheel().getUserData().toString() );
//        Gdx.app.log("Zoom Camera", Float.toString(camera.zoom));
//        Gdx.app.log("decalageCam",Float.toString(decalageCam) );
//        Gdx.app.log("EnemiesVehicules.size", Float.toString(EnemiesVehicules.size));
//        Gdx.app.log("isPlaceFree", Boolean.toString(freePlace));
//        Gdx.app.log("k", Float.toString(freeTime));
//        Gdx.app.log("jumpTimer", Float.toString(jumpTimer));
//        Gdx.app.log("jump ", Boolean.toString(jump));
//        Gdx.app.log("isDead", Boolean.toString(dead));
//        Gdx.app.log("vehiculeToRemove size",Integer.toString(vehiculesToRemove.size));
//        Gdx.app.log("scoreDead",Integer.toString(scoreDead ) );
//        Gdx.app.log("k",Float.toString(scaler) );
//        Gdx.app.log("okMontant", Boolean.toString(okMontant));
//        Gdx.app.log("okScale", Boolean.toString(okScale));
//        Gdx.app.log("montantTimer",Float.toString(montantTimer) );
//        Gdx.app.log("motorAccel",Float.toString(motorAccel));
//        Gdx.app.log("coinToGrabList.size",Float.toString(coinToGrabList.size));
//        Gdx.app.log("floatArrayVehiculeShape",Float.toString(vehiculeCollisionRectangle.getVertices().length));
//        Gdx.app.log("crashTimer",Float.toString(crashTimer));
//        Gdx.app.log("wheelscollisionRectangle",Float.toString(wheelsCollisonVehicule.size));
//        Gdx.app.log("fuel float", Float.toString(fuel));
//        Gdx.app.log("fuelAlarmTimer",Float.toString(fuelAlarmTimer));
//        Gdx.app.log("gazolePositions.size",Float.toString(jerrycansPositions.size));
//        Gdx.app.log("coinsPositions.size",Float.toString(coinsPositions.size));
//        Gdx.app.log("payment",Float.toString(payment))Gdx.app.log("noMoneyBool",Boolean.toString(noMoneyDetectBool));
//        Gdx.app.log("resetnoMoneyTimer",Float.toString(resetNoMoneyTimer));
//        Gdx.app.log("deadBoxPlayer",Boolean.toString(vehicule.isDead()));
//        Gdx.app.log("vitesse",Float.toString(vitesse));
//        Gdx.app.log("vehiculeVelocity",Float.toString(vehicule.getChassis().getLinearVelocity().x));
//        Gdx.app.log("fuelEmpty", Boolean.toString(isFuelEmpty));
//        Gdx.app.log("moneyToWin",Boolean.toString(moneyToWin));
//        Gdx.app.log("crashSoundTimer",Float.toString(crashSoundTimer));
//        Gdx.app.log("finishRace", Boolean.toString(finishRaceBool));
//        Gdx.app.log("okPause", Boolean.toString(okPause));
//        Gdx.app.log("collectabaleChoice", Integer.toString(collectableChoice));
//        Gdx.app.log("scoreTotal",Integer.toString(scorePointsTotal));
//        Gdx.app.log("scoreTemp",Integer.toString(scorePointsTemp));
//        Gdx.app.log("okNitro",Boolean.toString(okNitro));
//        Gdx.app.log("okPause",Boolean.toString(okPause));
//        Gdx.app.log("deathTimer",Float.toString(deathTimer));
//        Gdx.app.log("tachyDeadTimer",Float.toString(tachyDeadTimer));
//        Gdx.app.log("tachyAlarm",Boolean.toString(tachyAlarm));
//        Gdx.app.log("tachyDeadAlarm",Boolean.toString(tachyDeadAlarm));
//        Gdx.app.log("nbEnemies",Integer.toString(nbEnemies));
//        Gdx.app.log("chassisSprite-Rotation",Float.toString(vehicule.getChassisSprite().getRotation()));
//        for(VehiculeGenerator vehiculeGenerator : EnemiesVehicules){
//            vehiculeGenerator.debugLog();
//        }
//        Gdx.app.log("fuelEmpty",Boolean.toString(isFuelEmpty));
//        Gdx.app.log("deceptionTimer",Float.toString(deceptionTimer));
//        Gdx.app.log("nitroExplosionEnemies bool", Boolean.toString(nitroEnemyExplosionBool));
//        vehicule.debugLog();
//        Gdx.app.log("dead",Boolean.toString(vehicule.isDead()));
//        Gdx.app.log("animExplosionTimer",Float.toString(animExplosionLectureUniqueTimer));
//        Gdx.app.log("animExplosionBool",Boolean.toString(animExplosionBool));
//        Gdx.app.log("prefs.money",Integer.toString(Gdx.app.getPreferences("MyPrefs").getInteger("money")));
//        Gdx.app.log("hasVideoViewed",Boolean.toString(mtcGame.googleServices.hasVideoViewed()));
//        Gdx.app.log("videoClosed",Boolean.toString(videoClosed))Gdx.app.log("videoViewed",Integer.toString(mtcGame.getViewedVideosPerDay()))
//        Gdx.app.log("deceptionTimer",Float.toString(deceptionTimer));
//        Gdx.app.log("videoStarted",Boolean.toString(videoStarted));
//        Gdx.app.log("video PerDay",Boolean.toString(mtcGame.getPrefs().getBoolean("videoViewedLimit")));
//        Gdx.app.log("videoViewed time start",timeToStringConvert(mtcGame.getPrefs().getLong("VVLimitTimeStart")));

//        Gdx.app.log("Time started",timeToStringConvert(mtcGame.getPrefs().getLong("VVLimitTimeStart")));
//        Gdx.app.log("time Elapsed",timeToStringConvert(timeElapsing));
//        Gdx.app.log("precedentGroundChoice",Integer.toString(mtcGame.getPrefs().getInteger("precedentGroundChoice")));
//        Gdx.app.log("loadDechargeTMX",Boolean.toString(mtcGame.getAssetManager().isLoaded("textures DecorDecharge/exitScreenBackground-Decharge.png")));
//        Gdx.app.log("loadPoleNordTMX",Boolean.toString(mtcGame.getAssetManager().isLoaded("textures DecorPoleNord/exitScreenBackground-PoleNord.png")));
//        ground.debugLog();
//        Gdx.app.log("solToload",Boolean.toString(mtcGame.getAssetManager().isLoaded("textures DecorMontagne/Sol4.png")))Gdx.app.log("accelSoundRef",vehicule.getAccelSoundRef())
//        Gdx.app.log("SansPermisSoundEffectLoad",Boolean.toString(mtcGame.getAssetManager().isLoaded("SansPermisSoundEffect-accel.wav")));
//        if(assetsToUnload!=null){
//            Gdx.app.log("assetsToUnload",Integer.toString(assetsToUnload.size));

//        }
//        Gdx.app.log("animalSoundRef",pilote.getAnimalSoundRef());
//        pilote.debuglog();
//        Gdx.app.log("videoClosed",Boolean.toString(videoClosed));
    }

}