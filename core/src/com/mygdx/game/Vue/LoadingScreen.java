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
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controleur.MTCGame;
import com.mygdx.game.Outils.SheetToFramer;

public class LoadingScreen extends ScreenAdapter {

    private static final float WORLD_WIDTH = 960;
    private static final float WORLD_HEIGHT = 577;
    private static float UNITS_PER_METER = 32F;
    private static float UNIT_WIDTH = WORLD_WIDTH / UNITS_PER_METER;
    private static float UNIT_HEIGHT = WORLD_HEIGHT / UNITS_PER_METER;
    private static final float PROGRESS_BAR_HEIGHT = 25;
    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private OrthographicCamera camera;
    private float progress = 0;

    private Texture miniMonsterFrameSheet;
    private float stateTime;

    private final MTCGame mtcGame;
    private SpriteBatch batch;
    private Stage stage;
    private Label.LabelStyle readyLabelStyle = new Label.LabelStyle();
    private BitmapFont readyFont;

    private Music readySound;

    private int groundChoice;
    private int vehiculeChoice;
    private int headChoice;

    private Array<String> customVehiculeAssetToUnload = new Array<String>();


    public LoadingScreen(MTCGame mtcGame, SpriteBatch batch){
        this.mtcGame = mtcGame;
        this.batch = batch;
        groundChoice = mtcGame.getPrefs().getInteger("groundChoice");
        vehiculeChoice = mtcGame.getPrefs().getInteger("vehiculeChoice");
        headChoice = mtcGame.getPrefs().getInteger("headChoice");

        camera = new OrthographicCamera(UNIT_WIDTH, UNIT_HEIGHT);
        viewport = new FitViewport(WORLD_WIDTH/2, WORLD_HEIGHT/2.5f,camera);
        shapeRenderer = new ShapeRenderer();

        readyFont = mtcGame.getAssetManager().get("score.fnt", BitmapFont.class);
        stage = new Stage(viewport);

        readySound = mtcGame.getAssetManager().get("readySound.mp3",Music.class);
        readySound.setVolume(0.7f);
        readySound.play();
    }

    @Override
    public void show() {
        viewport.apply(true);

        stageHUD();
    }

    @Override
    public void render(float delta) {
        update();
        debugLog();
        stage.act(delta);
        clearScreen();
        draw();
        if(mtcGame.getAssetManager().update()){
            readySound.stop();
            createVehiculeCustomAssetsToUnloadList();
            mtcGame.setScreen(new GameScreen(mtcGame,batch,customVehiculeAssetToUnload));
        }else{
            progress += mtcGame.getAssetManager().getProgress();
        }
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height );
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }

    private void update(){
        loadMusicAndSound();
        loadTexture();
        updateFrame();
    }

    private void clearScreen(){
        Gdx.gl.glClearColor(Color.BLACK.r,Color.BLACK.g ,Color.BLACK.b ,Color.BLACK.a );
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void draw(){
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        batch.begin();
        if(mtcGame.getAssetManager().isLoaded("cover-loadingScreen.png",Texture.class)){
            Texture backGround = mtcGame.getAssetManager().get("cover-loadingScreen.png");
            batch.draw(backGround,-viewport.getWorldWidth() + backGround.getWidth() / 2, -viewport.getWorldHeight() + backGround.getHeight() / 2.55f,backGround.getWidth()/2,backGround.getHeight()/2);
        }
        if(mtcGame.getAssetManager().isLoaded("frameSheets/miniMonster_frameSheet.png",Texture.class)){
            miniMonsterFrameSheet = mtcGame.getAssetManager().get("frameSheets/miniMonster_frameSheet.png",Texture.class);
            drawAnimBonus();
        }
        batch.end();
    }

    private void drawAnimBonus() {
        Animation<TextureRegion> bonusAnimation = new Animation<TextureRegion>(0.2f, SheetToFramer.sheetToFrame(miniMonsterFrameSheet, 2, 3));
        bonusAnimation.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion bonusCurrentFrame = bonusAnimation.getKeyFrame(stateTime, true);
        batch.draw(bonusCurrentFrame, viewport.getWorldWidth()/3 - bonusCurrentFrame.getRegionWidth()/2 + progress*250,
                viewport.getWorldHeight()/14f,
                bonusCurrentFrame.getRegionWidth() / 2.15f, bonusCurrentFrame.getRegionHeight() / 2.15f);
    }

    private void updateFrame() {
        stateTime += Gdx.graphics.getDeltaTime();
    }

    private void stageHUD(){
        readyLabelStyle.font = readyFont;
        Label readyLabel = new Label(mtcGame.getTrad().getReady(),readyLabelStyle);
        readyLabel.setColor(Color.WHITE);
        readyLabel.setFontScale(2);
        readyLabel.setPosition(viewport.getWorldWidth()/3-readyLabel.getWidth()/2,viewport.getWorldHeight()/2);
        stage.addActor(readyLabel);
    }

    private void loadMusicAndSound() {
        // pre-loading
        mtcGame.getAssetManager().load("deceptionPanneSound.mp3", Music.class);
        // post-loading
        if (groundChoice == 0) {
            mtcGame.getAssetManager().load("Montagne-Rock-Music.mp3", Music.class);
        }
        if (groundChoice == 1) {
            mtcGame.getAssetManager().load("Desert-Oriental-Music.mp3", Music.class);
        }
        if (groundChoice == 2) {
            mtcGame.getAssetManager().load("Lune-Psychedelic-Music.mp3", Music.class);
        }
        if (groundChoice == 3) {
            mtcGame.getAssetManager().load("Foret-BlueGrass-Music.mp3", Music.class);
        }
        if (groundChoice == 4) {
            mtcGame.getAssetManager().load("Jungle-Samba-Music.mp3", Music.class);
        }
        if (groundChoice == 5) {
            mtcGame.getAssetManager().load("Island-Hawaii-Music.mp3", Music.class);
        }
        if (groundChoice == 6) {
            mtcGame.getAssetManager().load("City-Jazz-Music.mp3", Music.class);
        }
        if (groundChoice == 7) {
            mtcGame.getAssetManager().load("Campagne-Country-Music.mp3", Music.class);
        }
        if (groundChoice == 8) {
            mtcGame.getAssetManager().load("SousMarin-Dub-Music.mp3", Music.class);
        }
        if (groundChoice == 9) {
            mtcGame.getAssetManager().load("Village-Fanfare-Music.mp3", Music.class);
        }
        if (groundChoice == 10) {
            mtcGame.getAssetManager().load("PoleNord-Fanfare-Music.mp3", Music.class);
        }
        if (groundChoice == 11) {
            mtcGame.getAssetManager().load("Decharge-Flute-Music.mp3", Music.class);
        }

        // charge cri du pilote
        if (headChoice == 0) {
            mtcGame.getAssetManager().load("sharkSound.mp3", Music.class);
        }
        if (headChoice == 1) {
            mtcGame.getAssetManager().load("WolfSound.mp3", Music.class);
        }
        if (headChoice == 2) {
            mtcGame.getAssetManager().load("TRexSound.mp3", Music.class);
        }
        if (headChoice == 3) {
            mtcGame.getAssetManager().load("horseSound.mp3", Music.class);
        }
        if (headChoice == 4) {
            mtcGame.getAssetManager().load("rhinoSound.mp3", Music.class);
        }
        if (headChoice == 5) {
            mtcGame.getAssetManager().load("chimpSound.mp3", Music.class);
        }
        if (headChoice == 6) {
            mtcGame.getAssetManager().load("turtleSound.mp3", Music.class);
        }
        if (headChoice == 7) {
            mtcGame.getAssetManager().load("eagleSound.mp3", Music.class);
        }
        if (headChoice == 8) {
            mtcGame.getAssetManager().load("parrotSound.mp3", Music.class);
        }
        if (headChoice == 9) {
            mtcGame.getAssetManager().load("cockSound.mp3", Music.class);
        }
        if (headChoice == 10) {
            mtcGame.getAssetManager().load("crocoSound.mp3", Music.class);
        }
        if (headChoice == 11) {
            mtcGame.getAssetManager().load("bearSound.mp3", Music.class);
        }

        // bruit vehicule
        if (vehiculeChoice == 0) {
            mtcGame.getAssetManager().load("SansPermisSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("SansPermisSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 1) {
            mtcGame.getAssetManager().load("PourrieSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("PourrieSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 2) {
            mtcGame.getAssetManager().load("BerlineSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("BerlineSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 3) {
            mtcGame.getAssetManager().load("F1SoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("F1SoundEffect-ralenti.mp3", Music.class);
        }
        if (vehiculeChoice == 4) {
            mtcGame.getAssetManager().load("LuxeSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("LuxeSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 5) {
            mtcGame.getAssetManager().load("DecapotableSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("DecapotableSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 6) {
            mtcGame.getAssetManager().load("LegendeSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("LegendeSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 7) {
            mtcGame.getAssetManager().load("PickUpSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("PickUpSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 8) {
            mtcGame.getAssetManager().load("CamionetteSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("CamionetteSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 9) {
            mtcGame.getAssetManager().load("4X4SoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("4X4SoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 10) {
            mtcGame.getAssetManager().load("CamionSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("CamionSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 11) {
            mtcGame.getAssetManager().load("ChantierSoundEffect-accel.mp3", Music.class);
            mtcGame.getAssetManager().load("ChantierSoundEffect-decel.mp3", Music.class);
        }
        if (vehiculeChoice == 12) {
            // SANSPERMIS
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 100
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 101
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 102) {
                mtcGame.getAssetManager().load("SansPermisSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("SansPermisSoundEffect-decel.mp3", Music.class);
            }
            // POURRI
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 200
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 201
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 202) {
                mtcGame.getAssetManager().load("PourrieSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("PourrieSoundEffect-decel.mp3", Music.class);
            }
            // BERLINE
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 300
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 301
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 302) {
                mtcGame.getAssetManager().load("BerlineSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("BerlineSoundEffect-decel.mp3", Music.class);
                customVehiculeAssetToUnload.add("BerlineSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("BerlineSoundEffect-decel.mp3");
            }
            // GT
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 400
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 401
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 402) {
                mtcGame.getAssetManager().load("F1SoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("F1SoundEffect-ralenti.mp3", Music.class);
            }
            // LUXE
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 500
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 501
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 502) {
                mtcGame.getAssetManager().load("LuxeSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("LuxeSoundEffect-decel.mp3", Music.class);
            }
            // DECAPOTABLE
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 600
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 601
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 602) {
                mtcGame.getAssetManager().load("DecapotableSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("DecapotableSoundEffect-decel.mp3", Music.class);
            }
            // LEGENDE
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 700
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 701
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 702) {
                mtcGame.getAssetManager().load("LegendeSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("LegendeSoundEffect-decel.mp3", Music.class);
            }
            // PICKUP
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 800
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 801
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 802) {
                mtcGame.getAssetManager().load("PickUpSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("PickUpSoundEffect-decel.mp3", Music.class);
            }
            // CAMIONETTE
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 900
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 901
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 902) {
                mtcGame.getAssetManager().load("CamionetteSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("CamionetteSoundEffect-decel.mp3", Music.class);
            }
            // 4X4
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1000
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1001
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1002) {
                mtcGame.getAssetManager().load("4X4SoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("4X4SoundEffect-decel.mp3", Music.class);
            }
            // CAMION
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1100
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1101
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1102) {
                mtcGame.getAssetManager().load("CamionSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("CamionSoundEffect-decel.mp3", Music.class);
            }
            // CHANTIER
            if (mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1200
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1201
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1202) {
                mtcGame.getAssetManager().load("ChantierSoundEffect-accel.mp3", Music.class);
                mtcGame.getAssetManager().load("ChantierSoundEffect-decel.mp3", Music.class);
            }
        }
    }

    private void createVehiculeCustomAssetsToUnloadList(){
        if (vehiculeChoice == 12) {
            // SANSPERMIS
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 100
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 101
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 102){
                customVehiculeAssetToUnload.add("SansPermisSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("SansPermisSoundEffect-decel.mp3");
            }
            // POURRI
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 200
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 201
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 202){
                customVehiculeAssetToUnload.add("PourrieSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("PourrieSoundEffect-decel.mp3");
            }
            // BERLINE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 300
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 301
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 302){
                customVehiculeAssetToUnload.add("BerlineSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("BerlineSoundEffect-decel.mp3");
            }
            // GT
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 400
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 401
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 402){
                customVehiculeAssetToUnload.add("F1SoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("F1SoundEffect-ralenti.mp3");
            }
            // LUXE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 500
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 501
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 502){
                customVehiculeAssetToUnload.add("LuxeSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("LuxeSoundEffect-decel.mp3");
            }
            // DECAPOTABLE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 600
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 601
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 602){
                customVehiculeAssetToUnload.add("SansPermisSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("SansPermisSoundEffect-decel.mp3");
            }
            // LEGENDE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 700
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 701
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 702){
                customVehiculeAssetToUnload.add("LegendeSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("LegendeSoundEffect-decel.mp3");
            }
            // PICKUP
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 800
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 801
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 802){
                customVehiculeAssetToUnload.add("PickUpSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("PickUpSoundEffect-decel.mp3");
            }
            // CAMIONETTE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 900
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 901
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 902){
                customVehiculeAssetToUnload.add("CamionetteSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("CamionetteSoundEffect-decel.mp3");
            }
            // 4X4
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1000
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1001
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1002){
                customVehiculeAssetToUnload.add("4X4SoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("4X4SoundEffect-decel.mp3");
            }
            // CAMION
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1100
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1101
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1102){
                customVehiculeAssetToUnload.add("CamionSoundEffect-accel.mp3");
                customVehiculeAssetToUnload.add("CamionSoundEffect-decel.mp3");
            }
            // CHANTIER
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1200
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1201
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1202){
                customVehiculeAssetToUnload.add("ChantierSoundEffect-accel.mp3  ");
                customVehiculeAssetToUnload.add("ChantierSoundEffect-decel.mp3");
            }
        }
    }

    private void loadTexture(){
        // POST-LOADING

        // TEXTURES DE VEHICULEMONSTER
        if(vehiculeChoice == 0){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculeSansPermis.atlas",TextureAtlas.class);
        }

        // TEXTURES DE VEHICULEFORMULEUN
        if(vehiculeChoice == 1){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculePourrie.atlas",TextureAtlas.class);
        }

        // TEXTURES DE TRACTEUR
        if(vehiculeChoice == 2){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculeBerline.atlas",TextureAtlas.class);
        }

        // TEXTURES DE LUXE
        if(vehiculeChoice == 3){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculeGT.atlas",TextureAtlas.class);
            mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);
        }

        // TEXTURES DE CHANTIER
        if(vehiculeChoice == 4){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculeLuxe.atlas",TextureAtlas.class);
        }

        // TEXTURES DE CAMIONETTE
        if(vehiculeChoice == 5){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculeDecapotable.atlas",TextureAtlas.class);
        }

        // TEXTURES DE 4X4
        if(vehiculeChoice == 6){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculeLegende.atlas",TextureAtlas.class);
        }
        // TEXTURES DE CAMION
        if(vehiculeChoice == 7){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculePickUp.atlas",TextureAtlas.class);
            mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);
        }
        // TEXTURES DE BERLINE
        if(vehiculeChoice == 8){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculeCamionette.atlas",TextureAtlas.class);
        }
        // TEXTURES DE SANSPERMIS
        if(vehiculeChoice == 9){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_Vehicule4X4.atlas",TextureAtlas.class);
        }
        // TEXTURES DE LEGENDE
        if(vehiculeChoice == 10){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculeCamion.atlas",TextureAtlas.class);
        }
        // TEXTURES DE DECAPOTABLE
        if(vehiculeChoice == 11){
            // tableau de bord
            mtcGame.getAssetManager().load("postLoading_VehiculeChantier.atlas",TextureAtlas.class);
        }
        if(vehiculeChoice == 12){
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 100
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 101
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 102){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 100){
                    mtcGame.getAssetManager().load("postLoading_VehiculeSansPermis.atlas",TextureAtlas.class);
                    mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);}
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 101){
                    mtcGame.getAssetManager().load("postLoading_VehiculeSansPermis.atlas",TextureAtlas.class);
                    mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);}
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 102){
                    mtcGame.getAssetManager().load("postLoading_VehiculeSansPermis.atlas",TextureAtlas.class);
                    mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);}
            }
            // GT
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 200
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 201
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 202){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 200){
                    mtcGame.getAssetManager().load("postLoading_VehiculePourrie.atlas",TextureAtlas.class);
                    mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);}
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 201){
                    mtcGame.getAssetManager().load("postLoading_VehiculePourrie.atlas",TextureAtlas.class);
                    mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);}
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 202){
                    mtcGame.getAssetManager().load("postLoading_VehiculePourrie.atlas",TextureAtlas.class);
                    mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);}
            }
            // POURRIE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 300
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 301
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 302){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 300){
                    mtcGame.getAssetManager().load("postLoading_VehiculeBerline.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 301){
                    mtcGame.getAssetManager().load("postLoading_VehiculeBerline.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 302){
                    mtcGame.getAssetManager().load("postLoading_VehiculeBerline.atlas",TextureAtlas.class); }
            }
            // LUXE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 400
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 401
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 402){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 400){
                    mtcGame.getAssetManager().load("postLoading_VehiculeGT.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 401){
                    mtcGame.getAssetManager().load("postLoading_VehiculeGT.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 402){
                    mtcGame.getAssetManager().load("postLoading_VehiculeGT.atlas",TextureAtlas.class); }
            }
            // CHANTIER
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 500
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 501
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 502){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 500){
                    mtcGame.getAssetManager().load("postLoading_VehiculeLuxe.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 501){
                    mtcGame.getAssetManager().load("postLoading_VehiculeLuxe.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 502){
                    mtcGame.getAssetManager().load("postLoading_VehiculeLuxe.atlas",TextureAtlas.class); }
            }
            // CAMIONETTE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 600
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 601
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 602){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 600){
                    mtcGame.getAssetManager().load("postLoading_VehiculeDecapotable.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 601){
                    mtcGame.getAssetManager().load("postLoading_VehiculeDecapotable.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 602){
                    mtcGame.getAssetManager().load("postLoading_VehiculeDecapotable.atlas",TextureAtlas.class); }
            }
            // 4X4
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 700
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 701
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 702){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 700){
                    mtcGame.getAssetManager().load("postLoading_VehiculeLegende.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 701){
                    mtcGame.getAssetManager().load("postLoading_VehiculeLegende.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 702){
                    mtcGame.getAssetManager().load("postLoading_VehiculeLegende.atlas",TextureAtlas.class); }
            }
            // CAMION
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 800
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 801
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 802){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 800){
                    mtcGame.getAssetManager().load("postLoading_VehiculePickUp.atlas",TextureAtlas.class);
                    mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);}
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 801){
                    mtcGame.getAssetManager().load("postLoading_VehiculePickUp.atlas",TextureAtlas.class);
                    mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);}
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 802){
                    mtcGame.getAssetManager().load("postLoading_VehiculePickUp.atlas",TextureAtlas.class);
                    mtcGame.getAssetManager().load("digitalTachy.fnt", BitmapFont.class);}
            }
            // BERLINE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 900
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 901
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 902){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 900){
                    mtcGame.getAssetManager().load("postLoading_VehiculeCamionette.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 901){
                    mtcGame.getAssetManager().load("postLoading_VehiculeCamionette.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 902){
                    mtcGame.getAssetManager().load("postLoading_VehiculeCamionette.atlas",TextureAtlas.class); }
            }
            // SANS PERMIS
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1000
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1001
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1002){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1000){
                    mtcGame.getAssetManager().load("postLoading_Vehicule4X4.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1001){
                    mtcGame.getAssetManager().load("postLoading_Vehicule4X4.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1002){
                    mtcGame.getAssetManager().load("postLoading_Vehicule4X4.atlas",TextureAtlas.class); }
            }
            // LEGENDE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1100
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1101
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1102){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1100){
                    mtcGame.getAssetManager().load("postLoading_VehiculeCamion.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1101){
                    mtcGame.getAssetManager().load("postLoading_VehiculeCamion.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1102){
                    mtcGame.getAssetManager().load("postLoading_VehiculeCamion.atlas",TextureAtlas.class); }
            }
            // DECAPOTABLE
            if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1200
                    || mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1201
                    || mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1202){
                if(mtcGame.getPrefs().getInteger("vehiculeRoueCustom") == 1200){
                    mtcGame.getAssetManager().load("postLoading_VehiculeChantier.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeMoteurCustom") == 1201){
                    mtcGame.getAssetManager().load("postLoading_VehiculeChantier.atlas",TextureAtlas.class); }
                if(mtcGame.getPrefs().getInteger("vehiculeChassisCustom") == 1202){
                    mtcGame.getAssetManager().load("postLoading_VehiculeChantier.atlas",TextureAtlas.class); }
            }
        }

        // TEXTURES DES DECORS
        if(groundChoice == 0){
            mtcGame.getAssetManager().load("textures DecorMontagne/Paysage-Montagne.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorMontagne/AP-MTC-Montagne.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorMontagne/exitScreenBackground-Montagne.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorMontagne/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorMontagne/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorMontagne/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorMontagne/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorMontagne/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorMontagne/mapMontagne.tmx",TiledMap.class);
        }

        if (groundChoice == 1) {
            mtcGame.getAssetManager().load("textures DecorDesert/Paysage-Desert.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDesert/AP-MTC-Desert.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDesert/exitScreenBackground-Desert.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDesert/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDesert/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDesert/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDesert/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDesert/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDesert/mapDesert.tmx",TiledMap.class);
        }

        if (groundChoice == 2) {
            mtcGame.getAssetManager().load("textures DecorLune/Paysage-Lune.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorLune/AP-MTC-Lune.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorLune/exitScreenBackground-Lune.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorLune/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorLune/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorLune/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorLune/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorLune/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorLune/mapLune.tmx",TiledMap.class);
        }

        if (groundChoice == 3) {
            mtcGame.getAssetManager().load("textures DecorForet/Paysage-Foret.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorForet/AP-MTC-Foret.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorForet/exitScreenBackground-Foret.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorForet/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorForet/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorForet/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorForet/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorForet/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorForet/mapForet.tmx",TiledMap.class);
        }

        if (groundChoice == 4) {
            mtcGame.getAssetManager().load("textures DecorJungle/Paysage-Jungle.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorJungle/AP-MTC-Jungle.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorJungle/exitScreenBackground-Jungle.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorJungle/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorJungle/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorJungle/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorJungle/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorJungle/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorJungle/mapJungle.tmx",TiledMap.class);
        }

        if (groundChoice == 5) {
            mtcGame.getAssetManager().load("textures DecorIles/Paysage-Iles.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorIles/AP-MTC-Iles.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorIles/exitScreenBackground-Iles.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorIles/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorIles/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorIles/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorIles/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorIles/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorIles/mapIles.tmx",TiledMap.class);
        }

        if (groundChoice == 6) {
            mtcGame.getAssetManager().load("textures DecorVille/Paysage-Ville.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVille/AP-MTC-Ville.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVille/exitScreenBackground-Ville.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVille/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVille/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVille/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVille/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVille/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVille/mapVille.tmx",TiledMap.class);
        }

        if (groundChoice == 7) {
            mtcGame.getAssetManager().load("textures DecorCampagne/Paysage-Campagne.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorCampagne/AP-MTC-Campagne.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorCampagne/exitScreenBackground-Campagne.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorCampagne/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorCampagne/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorCampagne/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorCampagne/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorCampagne/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorCampagne/Sol4.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorCampagne/mapCampagne.tmx",TiledMap.class);
        }

        if (groundChoice == 8) {
            mtcGame.getAssetManager().load("textures DecorSousMarin/Paysage-SousMarin.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorSousMarin/AP-MTC-SousMarin.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorSousMarin/exitScreenBackground-SousMarin.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorSousMarin/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorSousMarin/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorSousMarin/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorSousMarin/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorSousMarin/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorSousMarin/mapSousMarin.tmx",TiledMap.class);
        }

        if (groundChoice == 9) {
            mtcGame.getAssetManager().load("textures DecorVillage/Paysage-Village.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVillage/AP-MTC-Village.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVillage/exitScreenBackground-Village.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVillage/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVillage/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVillage/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVillage/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVillage/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorVillage/mapVillage.tmx",TiledMap.class);
        }

        if (groundChoice == 10) {
            mtcGame.getAssetManager().load("textures DecorPoleNord/Paysage-PoleNord.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorPoleNord/AP-MTC-PoleNord.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorPoleNord/exitScreenBackground-PoleNord.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorPoleNord/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorPoleNord/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorPoleNord/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorPoleNord/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorPoleNord/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorPoleNord/mapPoleNord.tmx",TiledMap.class);
        }

        if (groundChoice == 11) {
            mtcGame.getAssetManager().load("textures DecorDecharge/Paysage-Decharge.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDecharge/AP-MTC-Decharge.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDecharge/exitScreenBackground-Decharge.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDecharge/sky.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDecharge/SolDepart.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDecharge/Sol1.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDecharge/Sol2.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDecharge/Sol3.png",Texture.class);
            mtcGame.getAssetManager().load("textures DecorDecharge/mapDecharge.tmx",TiledMap.class);
        }

        // FRAMESHEETS du GAMEOVERSCREEN
        // charge cri du pilote
        if(headChoice == 0){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Requin_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 1){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Loup_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 2){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 3){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Cheval_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 4){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Rhino_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 5){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Chimpanze_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 6){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Tortue_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 7){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Aigle_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 8){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Perroquet_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 9){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Coq_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 10){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Croco_victoire_frameSheet.png",Texture.class);
        }
        if(headChoice == 11){
            mtcGame.getAssetManager().load("frameSheets/T-Rex_accident_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_explosion_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/T-Rex_panne_frameSheet.png",Texture.class);
            mtcGame.getAssetManager().load("frameSheets/Ours_victoire_frameSheet.png",Texture.class);
        }
        mtcGame.getAssetManager().update();
    }


    private void debugLog(){
        Gdx.app.log("update.progress",Float.toString(progress));
    }
}