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
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controleur.MTCGame;
import com.mygdx.game.Outils.SheetToFramer;

public class SplashPreLoadingScreen extends ScreenAdapter {

    private static final float WORLD_WIDTH = 960;
    private static final float WORLD_HEIGHT = 577;
    private static float UNITS_PER_METER = 32F;
    private static float UNIT_WIDTH = WORLD_WIDTH / UNITS_PER_METER;
    private static float UNIT_HEIGHT = WORLD_HEIGHT / UNITS_PER_METER;
    private static final float PROGRESS_BAR_WIDTH = 100;
    private static final float PROGRESS_BAR_HEIGHT = 25;
    private ShapeRenderer shapeRenderer;
    private Viewport viewport;
    private OrthographicCamera camera;
    private float progress = 0;

    private Texture miniMonsterFrameSheet;
    private float stateTime;
    private Music splashMusic;

    private final MTCGame mtcGame;
    private SpriteBatch batch;

    public SplashPreLoadingScreen(MTCGame mtcGame, SpriteBatch batch){
        this.mtcGame = mtcGame;
        this.batch = batch;
        camera = new OrthographicCamera(UNIT_WIDTH, UNIT_HEIGHT);
        viewport = new FitViewport(WORLD_WIDTH/2, WORLD_HEIGHT/2f,camera);
        shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void show() {
        viewport.apply(true);
    }

    @Override
    public void render(float delta) {
        update();
        clearScreen();
        draw();
        if(mtcGame.getAssetManager().update()){
            splashMusic.stop();
            mtcGame.setScreen(new MenuScreen(mtcGame,batch,null));
        }else{
            progress += mtcGame.getAssetManager().getProgress();
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height );
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        batch.flush();
        splashMusic.dispose();
    }

    private void update(){
        // musique
        mtcGame.getAssetManager().load("splashMusic.mp3", Music.class);
        if(mtcGame.getAssetManager().isLoaded("splashMusic.mp3", Music.class)){
            splashMusic = mtcGame.getAssetManager().get("splashMusic.mp3", Music.class);
            splashMusic.setVolume(0.5f);
            splashMusic.play();
        }
        // update
        loadTexture();
        loadMusicAndSound();
        debugLog();
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
        if(mtcGame.getAssetManager().isLoaded("cover-splashScreen.png",Texture.class)){
            Texture backGround = mtcGame.getAssetManager().get("cover-splashScreen.png");
            batch.draw(backGround,-viewport.getWorldWidth() + backGround.getWidth() / 2, -viewport.getWorldHeight() + backGround.getHeight() / 2,backGround.getWidth()/2,backGround.getHeight()/2);
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


    private void loadMusicAndSound(){
        // pré-loading
        mtcGame.getAssetManager().load("supermarketMusic.mp3", Music.class);
        mtcGame.getAssetManager().load("menuMusic.mp3", Music.class);
        mtcGame.getAssetManager().load("atelierMusic.mp3", Music.class);
        mtcGame.getAssetManager().load("nitroTime.mp3", Music.class);

        mtcGame.getAssetManager().load("Coin-Sound-Effect.mp3", Music.class);
        mtcGame.getAssetManager().load("Coin Sound Effect.wav", Sound.class);
        mtcGame.getAssetManager().load("jumpSound.mp3",Music.class);
        mtcGame.getAssetManager().load("brakeSound.mp3",Music.class);
        mtcGame.getAssetManager().load("vitesseAlarm.mp3",Music.class);
        mtcGame.getAssetManager().load("emptyFuelBip.mp3",Music.class);
        mtcGame.getAssetManager().load("reservoirFillingSound.mp3",Music.class);
        mtcGame.getAssetManager().load("noMoneySound.mp3",Music.class);
        mtcGame.getAssetManager().load("F1Crash.mp3",Music.class);
        mtcGame.getAssetManager().load("monsterCrash.mp3",Music.class);
        mtcGame.getAssetManager().load("tracteurCrash.mp3",Music.class);
        mtcGame.getAssetManager().load("deceptionSound.mp3",Music.class);
        mtcGame.getAssetManager().load("deceptionExplosionSound.mp3",Music.class);
        mtcGame.getAssetManager().load("deceptionPanneSound.mp3",Music.class);
        mtcGame.getAssetManager().load("victorySound.mp3",Music.class);
        mtcGame.getAssetManager().load("tableauStompSound.wav",Sound.class);
        mtcGame.getAssetManager().load("readySound.mp3",Music.class);
        mtcGame.getAssetManager().load("goSound.mp3",Music.class);

    }

    private void loadTexture(){
        // TEXTURES DES LOADINGSCREENs
        mtcGame.getAssetManager().load("cover-splashScreen.png",Texture.class);
        mtcGame.getAssetManager().load("cover-loadingScreen.png",Texture.class);

        // TEXTURES DU GAMEOVERSCREEN
        mtcGame.getAssetManager().load("frameSheets/miniMonster_frameSheet.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/panneauBONUS_frameSheet.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/panneauBONUSPanne_frameSheet.png",Texture.class);
        mtcGame.getAssetManager().load("score.fnt", BitmapFont.class);

        // PRE-LOADING
        mtcGame.getAssetManager().load("preLoading_Total.atlas",TextureAtlas.class);

        mtcGame.getAssetManager().load("frameSheets/bonusBillet_frameSheet.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/bonusGasFree_frameSheet.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/bonusMultiScoreX2_frameSheet.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/bonusMultiScoreX3_frameSheet.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/flame_chassis_frameSheet.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/flame_wheel_frameSheet.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/explosion_chassis_animation.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/bonusNitro2.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/bonusNitro.png",Texture.class);
        mtcGame.getAssetManager().load("frameSheets/panneauBONUSPanne_frameSheet.png",Texture.class);

        mtcGame.getAssetManager().load("rock.fnt", BitmapFont.class);
        mtcGame.getAssetManager().load("minnie.fnt", BitmapFont.class);

    }

    private void debugLog(){
        Gdx.app.log("progressBar",Float.toString(progress));
    }
}
