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
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controleur.MTCGame;
import com.mygdx.game.Outils.GroundGenerator;
import com.mygdx.game.Outils.PiloteGenerator;
import com.mygdx.game.Outils.SheetToFramer;

import java.util.Locale;

public class GameOverScreen extends ScreenAdapter {

    private static final float WORLD_WIDTH = 960;
    private static final float WORLD_HEIGHT = 577;

    private MTCGame mtcGame;
    private PiloteGenerator pilote;
    private GroundGenerator ground;
    private String exitScreenChoice;
    private int groundChoice;
    private int vehiculeChoice;
    private int headChoice;
    private String multiplierScore;

    private Stage stage;

    private Viewport viewport;
    private Viewport stageViewport;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private TextureRegion panneauTexture;
    private TextureRegion tropheeMultiScoreTexture;
    private Texture menuAnimFrameSheet;
    private TextureRegion iconneMultiScoreTexture;
    private TextureAtlas textureAtlas;

    private final ImageButton replayButton;
    private final ImageButton menuButton;
    private final ImageButton bonusButton;

    private Image sousMenuButton;
    private Image sousReplayButton;

    private Group menuButtonGroup = new Group();
    private Group replayButtonGroup = new Group();
    private Group menuButtonsGroup = new Group();

    private Image tropheeRoueGris;
    private Image tropheeRoueOr;
    private Image tropheeBonusGris;
    private Image tropheeBonusOr;
    private Image tropheeDollarGris;
    private Image tropheeDollarOr;
    private Image iconeVoituresEcrasees;
    private Image iconeDollar;
    private Image iconeMultiScoreGRIS;
    private Image iconeMultiScoreOR;
    private Image iconeGasFree;
    private Image iconeBillet;
    private Image iconeNitro;

    private BitmapFont rockFont;
    private Label scoreVoitures;
    private Label.LabelStyle scoreVoituresStyle = new Label.LabelStyle();
    private float scoreDead;
    private int scoreTotal;
    private int bonusVoituresEcrasees;
    private int scoreMultiplied = 0;
    private int primeVoituresEcrasees = 0;

    private Label scorePieces;
    private Label.LabelStyle scorePiecesStyle = new Label.LabelStyle();
    private Label bonusCollectees;
    private Label.LabelStyle bonusCollecteesStyle = new Label.LabelStyle();
    private Label primeTotal;
    private Label.LabelStyle primeTotalStyle = new Label.LabelStyle();
    private Label primeTrophee;
    private Group primeTropheeGroup = new Group();
    private Label.LabelStyle primeTropheeStyle = new Label.LabelStyle();
    private Label afterPub;
    private Label.LabelStyle afterPubStyle = new Label.LabelStyle();
    private float afficheTime = 0.05f;
    private int gasFreeCatched;
    private int billetCatched;
    private int nitroCatched;
    private int bonusCatched;
    private int resultat;
    private int total;
    private int tropheeRoueScore;
    private int tropheeDollarScore;
    private int tropheeBonusScore;
    private int bonusTrophee;
    private float nbEnemies;
    private boolean okBonusPub;
    private float produit;

    private float videoViewedTimer;

    private Music deceptionMusic;
    private Sound soundEffect;

    private long timeStarted;
    private long timeElapsing;
    private long cycleTimeElapsing;

    private long time;
    private double millis;
    private double seconds;
    private double minutes;
    private double hours;

    private String horloge;

    // résultats
    private float stateTime;

    private boolean videoClosed;

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

    private Array<String> assetsToUnload;

    public GameOverScreen(MTCGame mtcGame, SpriteBatch batch, PiloteGenerator pilote, GroundGenerator ground, String exitScreenChoice,
                          String multiplierScore, int scoreDead, int scoreTotal, int gasFreeCatched, int billetCatched, int nitroCatched, int nbEnemies, Array<String> assetsToUnload) {
        this.mtcGame = mtcGame;
        this.pilote = pilote;
        this.ground = ground;
        this.exitScreenChoice = exitScreenChoice;
        groundChoice = mtcGame.getPrefs().getInteger("groundChoice");
        vehiculeChoice = mtcGame.getPrefs().getInteger("vehiculeChoice");
        headChoice = mtcGame.getPrefs().getInteger("headChoice");
        this.multiplierScore = multiplierScore;
        this.batch = batch;
        this.scoreDead = scoreDead;
        this.scoreTotal = scoreTotal;
        this.gasFreeCatched = gasFreeCatched;
        this.billetCatched = billetCatched;
        this.nitroCatched = nitroCatched;
        this.nbEnemies = nbEnemies;
        textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas",TextureAtlas.class);
        bonusCatched += nitroCatched;
        bonusCatched += gasFreeCatched;
        bonusCatched += billetCatched;
        this.assetsToUnload = assetsToUnload;
        mtcGame.getPrefs().putBoolean("videoViewed",false);

        panneauTexture = textureAtlas.findRegion("panneau_Game_Over0012");
        menuAnimFrameSheet = mtcGame.getAssetManager().get("frameSheets/panneauBONUS_frameSheet.png",Texture.class);

        rockFont = mtcGame.getAssetManager().get("score.fnt", BitmapFont.class);

        replayButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-pressed"))));
        menuButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-Menu-pause-pressed"))));
        bonusButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-pub-manque-argent-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-pub-manque-argent-pressed"))));

        tropheeRoueGris = new Image(textureAtlas.findRegion("trophées_roue_gris"));
        tropheeRoueOr = new Image(textureAtlas.findRegion("trophées_roue_or"));
        tropheeBonusGris = new Image(textureAtlas.findRegion("trophées_Bonus_gris"));
        tropheeBonusOr = new Image(textureAtlas.findRegion("trophées_Bonus_or"));
        tropheeDollarGris = new Image(textureAtlas.findRegion("trophées_dollar_gris"));
        tropheeDollarOr = new Image(textureAtlas.findRegion("trophées_dollar_or"));
        iconeVoituresEcrasees = new Image(textureAtlas.findRegion("accident"));

        iconeDollar = new Image(textureAtlas.findRegion("goldenCoin"));
        iconeGasFree = new Image(textureAtlas.findRegion("bonusGasFree"));
        iconeBillet = new Image(textureAtlas.findRegion("bonusBillet"));
        iconeNitro = new Image(textureAtlas.findRegion("bonusNitro"));

        sousMenuButton = new Image(new TextureRegion(textureAtlas.findRegion("bouton-Menu-sousBouton")));
        sousReplayButton = new Image(new TextureRegion(textureAtlas.findRegion("bouton-Menu-sousBouton")));

        fondPopUpTimerVideosImage = new Image(new TextureRegion(textureAtlas.findRegion("popup-Manque-Temps")));
        fondWifiWarningImage = new Image(new TextureRegion(textureAtlas.findRegion("popup-Manque-Wifi")));
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void show() {
        camera = new OrthographicCamera(WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
        viewport = new FitViewport(WORLD_WIDTH / 2, WORLD_HEIGHT / 2, camera);
        stageViewport = new FitViewport(WORLD_WIDTH / 2, WORLD_HEIGHT / 2);
        stage = new Stage(stageViewport);
        stageHUD();
        if(mtcGame.getGoogleServices() != null){
            if (mtcGame.getGoogleServices().hasVideoClosed()) {
                mtcGame.getGoogleServices().setIs_video_ad_closed(false);
            }
        }
    }

    @Override
    public void render(float delta) {
        clearScreen();
        update();
        draw();
        stage.act();
        scoreVoitures.setText(Integer.toString((int) scoreDead) + "/" + ((int) nbEnemies) + "        " + primeVoituresEcrasees + " $");
        if(scoreTotal != 0){
            scorePieces.setText(Integer.toString(scoreTotal) + "          " + scoreMultiplied + " $");
        }else{
            scorePieces.setText(Integer.toString(scoreTotal) + "                " + scoreMultiplied + " $");
        }
        bonusCollectees.setText("   " + bonusScore() + " $");
        primeTrophee.setText(primeSelonTrophee() / 100 + mtcGame.getTrad().getTrophee()+" = " + primeSelonTrophee() + " $");
        primeTotal.setText("TOTAL =  " + totalScore() + " $");
        afterPub.setText(  totalScore() + 150  + " $ ");
        timerDecompteLabel.setText(timeToStringConvert(
                (mtcGame.getPrefs().getLong("VVLimitTimeStart") + mtcGame.getPeriodBeforeNewVideos()) - timeElapsing));

        stage.draw();

    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    private void update() {
        unloader();
        debugLog();
        updateFrame();
        bonusVoituresEcrasees();
        multiplyScoreTotal();
        primeSelonTrophee();
        if(mtcGame.getGoogleServices() != null){
            videoViewedToggleBool();
            videoClosedToggleBool();
            viewedVideosPerDayLimiter();
        }
        popUpTimerVisibiliteTimer();
        popUpWifiVisibiliteTimer();
    }

    private void unloader(){
        if(assetsToUnload != null){
            for(String string : assetsToUnload){
                if(mtcGame.getAssetManager().isLoaded(string)){
                    mtcGame.getAssetManager().unload(string);
                    assetsToUnload.removeValue(string,true);
                }
            }
            mtcGame.getAssetManager().update();
        }
    }

    private void draw() {
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        batch.begin();
        createDecordefBackground().draw(batch);
//        createExitCauseSprite().draw(batch);
        drawAnimPilote(batch);
        suiteAffichageDraw();
        batch.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    private void stageHUD() {
        Gdx.input.setInputProcessor(stage);

        // TABLEAU

        // TROPHEES
        // trophée roue gris
        tropheeRoueGris.setPosition(viewport.getWorldWidth()/2 - tropheeRoueGris.getWidth() * 1.7f, viewport.getWorldHeight() / 1.42f);
        tropheeRoueGris.setWidth(tropheeRoueGris.getWidth() / 2.2f);
        tropheeRoueGris.setHeight(tropheeRoueGris.getHeight() / 2.2f);
        tropheeRoueGris.setVisible(false);
        stage.addActor(tropheeRoueGris);

        tropheeRoueOr.setPosition(viewport.getWorldWidth()/2 - tropheeRoueOr.getWidth() * 1.7f, viewport.getWorldHeight() / 1.42f);
        tropheeRoueOr.setWidth(tropheeRoueOr.getWidth() / 2.2f);
        tropheeRoueOr.setHeight(tropheeRoueOr.getHeight() / 2.2f);
        tropheeRoueOr.setVisible(false);
        stage.addActor(tropheeRoueOr);

        // trophée dollar gris
        tropheeDollarGris.setPosition(viewport.getWorldWidth()/2 - tropheeDollarGris.getWidth() * 1.02f, viewport.getWorldHeight() / 1.37f);
        tropheeDollarGris.setWidth(tropheeDollarGris.getWidth() / 2.2f);
        tropheeDollarGris.setHeight(tropheeDollarGris.getHeight() / 2.2f);
        tropheeDollarGris.setVisible(false);
        stage.addActor(tropheeDollarGris);

        // trophée dollar or
        tropheeDollarOr.setPosition(viewport.getWorldWidth()/2 - tropheeDollarOr.getWidth() * 1.02f, viewport.getWorldHeight() / 1.37f);
        tropheeDollarOr.setWidth(tropheeDollarOr.getWidth() / 2.2f);
        tropheeDollarOr.setHeight(tropheeDollarOr.getHeight() / 2.2f);
        tropheeDollarOr.setVisible(false);
        stage.addActor(tropheeDollarOr);

        // trophée bonus gris
        tropheeBonusGris.setPosition(viewport.getWorldWidth()/2 - tropheeBonusGris.getWidth() * 0.5f, viewport.getWorldHeight() / 1.41f);
        tropheeBonusGris.setWidth(tropheeBonusGris.getWidth() / 2.2f);
        tropheeBonusGris.setHeight(tropheeBonusGris.getHeight() / 2.2f);
        tropheeBonusGris.setVisible(false);
        stage.addActor(tropheeBonusGris);

        // trophée bonus or
        tropheeBonusOr.setPosition(viewport.getWorldWidth()/2 - tropheeBonusOr.getWidth() * 0.5f, viewport.getWorldHeight() / 1.41f);
        tropheeBonusOr.setWidth(tropheeBonusOr.getWidth() / 2.2f);
        tropheeBonusOr.setHeight(tropheeBonusOr.getHeight() / 2.2f);
        tropheeBonusOr.setVisible(false);
        stage.addActor(tropheeBonusOr);

        // ICONES
        // icone voitures écrasées
        iconeVoituresEcrasees.setPosition(viewport.getWorldWidth() / 2 - iconeVoituresEcrasees.getWidth() *1.7f, viewport.getWorldHeight() / 1.75f);
        iconeVoituresEcrasees.setWidth(iconeVoituresEcrasees.getWidth() / 2.2f);
        iconeVoituresEcrasees.setHeight(iconeVoituresEcrasees.getHeight() / 2.2f);
        iconeVoituresEcrasees.setScale(0.75f);
        iconeVoituresEcrasees.setVisible(false);
        stage.addActor(iconeVoituresEcrasees);

        // icone dollar
        iconeDollar.setPosition(viewport.getWorldWidth() / 2 - iconeDollar.getWidth() * 3.95f, viewport.getWorldHeight() / 2.1f);
        iconeDollar.setWidth(iconeDollar.getWidth() / 2.2f);
        iconeDollar.setHeight(iconeDollar.getHeight() / 2.2f);
        iconeDollar.setVisible(false);
        stage.addActor(iconeDollar);

        // LABEL voitures écrasées
        scoreVoituresStyle.font = rockFont;
        String scoreAsString = Integer.toString((int) scoreDead) + "/" + ((int) nbEnemies) + "           " + primeVoituresEcrasees + "$";
        scoreVoitures = new Label(scoreAsString, scoreVoituresStyle);
        scoreVoitures.setColor(Color.BLACK);
        scoreVoitures.setFontScale(0.55f, 0.7f);
        scoreVoitures.setPosition(iconeVoituresEcrasees.getX() + iconeVoituresEcrasees.getWidth() * 0.8f, iconeVoituresEcrasees.getY() - iconeVoituresEcrasees.getHeight()/6 );
        scoreVoitures.setVisible(false);
        stage.addActor(scoreVoitures);

        // LABEL score Dollar
        scorePiecesStyle.font = rockFont;
        String scorePiecesAsString = Integer.toString(scoreTotal) + " = " + (scoreTotal + scoreMultiplied) + "$";
        scorePieces = new Label(scorePiecesAsString, scorePiecesStyle);
        scorePieces.setColor(Color.BLACK);
        scorePieces.setFontScale(0.55f, 0.7f);
        scorePieces.setPosition(iconeDollar.getX() + iconeDollar.getWidth() * 1.25f, iconeDollar.getY() - iconeDollar.getHeight() / 2 + scorePieces.getHeight() / 12);
        scorePieces.setVisible(false);
        stage.addActor(scorePieces);

        // icone multiScoreGRIS
        iconeMultiScoreGRIS = new Image(multiScoreTexture("gris"));
        iconeMultiScoreGRIS.setPosition(scorePieces.getX() + iconeMultiScoreGRIS.getWidth() / 2.8f, scorePieces.getY() + iconeMultiScoreGRIS.getHeight() / 16);
        iconeMultiScoreGRIS.setWidth(iconeMultiScoreGRIS.getWidth() / 3.2f);
        iconeMultiScoreGRIS.setHeight(iconeMultiScoreGRIS.getHeight() / 3.2f);
        iconeMultiScoreGRIS.setVisible(false);
        stage.addActor(iconeMultiScoreGRIS);

        // icone multiScoreOR
        iconeMultiScoreOR = new Image(multiScoreTexture("icone"));
        iconeMultiScoreOR.setPosition(scorePieces.getX() + iconeMultiScoreOR.getWidth() / 2.8f, scorePieces.getY() + iconeMultiScoreOR.getHeight() / 16);
        iconeMultiScoreOR.setWidth(iconeMultiScoreOR.getWidth() / 3.2f);
        iconeMultiScoreOR.setHeight(iconeMultiScoreOR.getHeight() / 3.2f);
        iconeMultiScoreOR.setVisible(false);
        stage.addActor(iconeMultiScoreOR);

        // icone Collectable gasFree
        iconeGasFree.setPosition(viewport.getWorldWidth() / 2 - iconeGasFree.getWidth() * 1.55f, viewport.getWorldHeight() / 2.7f);
        iconeGasFree.setWidth(iconeGasFree.getWidth() / 3.6f);
        iconeGasFree.setHeight(iconeGasFree.getHeight() / 3.6f);
        iconeGasFree.setVisible(false);
        stage.addActor(iconeGasFree);

        // icone collectable nitro
        iconeNitro.setPosition(viewport.getWorldWidth() / 2 - iconeNitro.getWidth() * 1.3f, viewport.getWorldHeight() / 2.7f);
        iconeNitro.setWidth(iconeNitro.getWidth() / 3.6f);
        iconeNitro.setHeight(iconeNitro.getHeight() / 3.6f);
        iconeNitro.setVisible(false);
        stage.addActor(iconeNitro);

        // icone collectable billet
        iconeBillet.setPosition(viewport.getWorldWidth() / 2 - iconeBillet.getWidth() * 0.47f, viewport.getWorldHeight() / 2.7f);
        iconeBillet.setWidth(iconeBillet.getWidth() / 7.3f);
        iconeBillet.setHeight(iconeBillet.getHeight() / 7.3f);
        iconeBillet.setVisible(false);
        stage.addActor(iconeBillet);

        // LABEL score Bonus
        bonusCollecteesStyle.font = rockFont;
        String scoreBonusAsString = "     " + bonusScore() + " $";
        bonusCollectees = new Label(scoreBonusAsString, bonusCollecteesStyle);
        bonusCollectees.setColor(Color.BLACK);
        bonusCollectees.setFontScale(0.55f, 0.7f);
        bonusCollectees.setPosition(iconeBillet.getX() + iconeBillet.getWidth() * 1.2f, iconeBillet.getY() - iconeBillet.getHeight() / 1.5f + bonusCollectees.getHeight() / 16);
        bonusCollectees.setVisible(false);
        stage.addActor(bonusCollectees);

        // LABEL score Trophee
        primeTropheeStyle.font = rockFont;
        String scoreTropheeAsString = primeSelonTrophee() / 100 + mtcGame.getTrad().getTrophee() + " = " + primeSelonTrophee() + " $";
        primeTrophee = new Label(scoreTropheeAsString, primeTropheeStyle);
        primeTrophee.setColor(Color.RED);
        primeTrophee.setFontScale(0.55f, 0.7f);
        primeTrophee.setPosition(viewport.getWorldWidth() / 24, viewport.getWorldHeight() / 2.3f);
        primeTrophee.setVisible(false);
        stage.addActor(primeTrophee);

        // Groupe pour rotation du label de la prime des trophées
        primeTropheeGroup.setOrigin(primeTropheeGroup.getWidth() / 2, primeTropheeGroup.getHeight() / 2);
        primeTropheeGroup.setPosition(viewport.getWorldWidth() / 33, primeTrophee.getY());
        primeTropheeGroup.addActor(primeTrophee);
        primeTropheeGroup.setRotation(-17.5f);
        stage.addActor(primeTropheeGroup);

        // LIGNE TOTAL
        primeTotalStyle.font = rockFont;
        String scoreTotalAsString = "TOTAL = " + totalScore() + " $";
        primeTotal = new Label(scoreTotalAsString, primeTotalStyle);
        primeTotal.setColor(Color.BLACK);
        primeTotal.setFontScale(0.55f, 0.7f);
        primeTotal.setPosition(viewport.getWorldWidth() / 6, viewport.getWorldHeight() / 4.5f);
        primeTotal.setVisible(false);
        stage.addActor(primeTotal);

        // LIGNE PUB
        afterPubStyle.font = rockFont;
        String scoreAfterPubAsString = "(" + totalScore() + 150 + "$)";
        afterPub = new Label(scoreAfterPubAsString, afterPubStyle);
        afterPub.setColor(Color.DARK_GRAY);
        afterPub.setFontScale(0.38f, 0.7f);
        afterPub.setPosition(viewport.getWorldWidth() / 2.6f, viewport.getWorldHeight() / 9.5f);
        afterPub.setVisible(false);
        stage.addActor(afterPub);


        // BOUTONS
        // menu GameOver : bouton menu
//        menuButton.setPosition(menuButtonsGroup.getX() + menuButton.getHeight() / 2, menuButtonsGroup.getY() + menuButton.getHeight() * 2.5f);
        stage.addActor(menuButton);
        menuButton.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                savePrefs();
                playMusicChosen().stop();
                dispose();
                assetsToUnload.add(ground.getRefExitBackground());
                assetsToUnload.add(pilote.getAnimationFrameSheetRef());
                mtcGame.setScreen(new MenuScreen(mtcGame, batch,assetsToUnload));
            }
        });
        stage.addActor(sousMenuButton);

        Label boutonMenuLabel = new Label(mtcGame.getTrad().getBoutonMenu(),primeTropheeStyle);
        boutonMenuLabel.setPosition(sousMenuButton.getWidth()/2 - boutonMenuLabel.getWidth()/1.2f,
                sousMenuButton.getHeight()/2 - boutonMenuLabel.getHeight()/2f);
        boutonMenuLabel.setFontScale(1.8f);
        boutonMenuLabel.setColor(Color.BLACK);
        stage.addActor(boutonMenuLabel);

        menuButtonGroup.addActor(sousMenuButton);
        menuButtonGroup.addActor(boutonMenuLabel);
        menuButtonGroup.addActor(menuButton);
        menuButtonGroup.setPosition(menuButtonsGroup.getX() - menuButton.getWidth() / 2.8f, menuButtonsGroup.getY() + menuButton.getHeight() * 2.7f);

        // menu GameOver : bouton replay
//        replayButton.setPosition(menuButtonsGroup.getX() - replayButton.getWidth() / 1.15f, menuButtonsGroup.getY() + replayButton.getHeight() * 2.5f);
        stage.addActor(replayButton);
        replayButton.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                savePrefs();
                playMusicChosen().stop();
                mtcGame.setScreen(new LoadingScreen(mtcGame, batch));
            }
        });
        stage.addActor(sousReplayButton);

        Label boutonReplayLabel = new Label(mtcGame.getTrad().getBoutonReplay(),primeTropheeStyle);
        // adapte taille et position selon langue
        if(Locale.getDefault().getLanguage().equals("de") || Locale.getDefault().getLanguage().equals("nl")){
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
        replayButtonGroup.setPosition(menuButtonsGroup.getX() - menuButton.getWidth() / 2.8f,menuButtonsGroup.getY() + menuButton.getHeight()*1.6f);

        stage.addActor(fondPopUpTimerVideosImage);

        // labels : "vous avez regardé 10 vidéos en 2h, vous devez attendre

        String expliDecompte = mtcGame.getTrad().getTimerDecompte();
        expliTimerDecompteLabel = new Label(expliDecompte,primeTotalStyle);
        expliTimerDecompteLabel.setColor(Color.BLACK);
        expliTimerDecompteLabel.setFontScale(1.5f);
        expliTimerDecompteLabel.setPosition(fondPopUpTimerVideosImage.getWidth()/2-expliTimerDecompteLabel.getWidth()/1.3f,
                fondPopUpTimerVideosImage.getHeight()/2 - expliTimerDecompteLabel.getHeight()/5f);
        stage.addActor(expliTimerDecompteLabel);

        String decompteHoraire = timeToStringConvert(mtcGame.getPeriodBeforeNewVideos() - timeElapsing);
        timerDecompteLabel = new Label(decompteHoraire,primeTotalStyle);
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
        wifiWarningLabel = new Label(wifiWarning,primeTotalStyle);
        wifiWarningLabel.setColor(Color.BLACK);
        wifiWarningLabel.setFontScale(1.5f);
        wifiWarningLabel.setPosition(fondWifiWarningImage.getWidth()/2-wifiWarningLabel.getWidth()/1.3f,
                fondWifiWarningImage.getHeight()/2 - wifiWarningLabel.getHeight()/2f);
        stage.addActor(wifiWarningLabel);

        popUpWifiGroup.addActor(fondWifiWarningImage);
        popUpWifiGroup.addActor(wifiWarningLabel);
        popUpWifiGroup.setScale(0.65f);
        popUpWifiGroup.setPosition(viewport.getWorldWidth()/16 - popUpWifiGroup.getWidth()/2,
                viewport.getWorldHeight()/16 - popUpWifiGroup.getWidth()/6);
        popUpWifiGroup.setVisible(false);

        // menu GameOver : bouton bonus
        bonusButton.setPosition(menuButtonsGroup.getX() - bonusButton.getWidth() * 2.95f, menuButtonsGroup.getY() - bonusButton.getHeight() * 2);
        bonusButton.setVisible(false);
        stage.addActor(bonusButton);
        bonusButton.addListener(new ActorGestureListener() {
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
                        deceptionMusic.stop();
                        mtcGame.showRewardedVideoAd();
                    }else{
                        // panneau + décompte
                        popUpTimerGroup.setVisible(true);
                    }
                }else{
                    popUpWifiGroup.setVisible(true);
                }
            }
        });

        menuButtonsGroup.addActor(menuButtonGroup);
        menuButtonsGroup.addActor(replayButtonGroup);
        menuButtonsGroup.addActor(bonusButton);
        menuButtonsGroup.setPosition(stageViewport.getWorldWidth() / 1.35f, stageViewport.getWorldHeight() / 2.5f);
        menuButtonsGroup.setScale(0.35f);

        stage.addActor(menuButtonsGroup);
        stage.addActor(popUpTimerGroup);
        stage.addActor(popUpWifiGroup);

    }

    private Sprite createDecordefBackground() {
        Sprite decordefBackground = new Sprite(ground.getExitScreenBackground());
        decordefBackground.setOrigin(decordefBackground.getWidth() / 2, decordefBackground.getHeight() / 2);
        decordefBackground.setPosition(-viewport.getWorldWidth() + decordefBackground.getWidth() / 4, -viewport.getWorldHeight() + decordefBackground.getHeight() / 3.75f);
        decordefBackground.setScale(0.55f);
        return decordefBackground;
    }

    private TextureRegion multiScoreTexture(String grisOuOr) {
        if (grisOuOr.equals("gris")) {
            if (!multiplierScore.equals("")) {
                if (multiplierScore.equals("X3")) {
                    tropheeMultiScoreTexture = textureAtlas.findRegion("bonusMultiScoreX3_gris");
                } else {
                    tropheeMultiScoreTexture = textureAtlas.findRegion("bonusMultiScoreX2_gris");
                }
            } else {
                tropheeMultiScoreTexture = textureAtlas.findRegion("bonusMultiScoreX3_gris");
            }
        } else {
            if (!multiplierScore.equals("")) {
                if (multiplierScore.equals("X3")) {
                    iconneMultiScoreTexture = textureAtlas.findRegion("bonusMultiScoreX3");
                } else {
                    iconneMultiScoreTexture = textureAtlas.findRegion("bonusMultiScoreX2");
                }
            } else {
                iconneMultiScoreTexture = textureAtlas.findRegion("bonusMultiScoreX3");
            }
        }
        if (grisOuOr.equals("gris")) {
            return tropheeMultiScoreTexture;
        } else {
            return iconneMultiScoreTexture;
        }
    }

    private void suiteAffichageDraw() {
        afficheTime += 0.1f;
        if (afficheTime > 0) {
            // animation tableau
            if (afficheTime > 1) {
                batch.draw(panneauTexture, -viewport.getWorldWidth() + panneauTexture.getRegionWidth() / 1.1625f,
                        viewport.getWorldHeight() / 2 - panneauTexture.getRegionHeight() / 1.75f, panneauTexture.getRegionWidth() / 1.2f,
                        panneauTexture.getRegionHeight() * 1.18f);
                if (afficheTime > 1 && afficheTime < 1.1f)
                    soundEffectManager("tableau").play(0.5f);
            }
            // LIGNE des trophées
            if (afficheTime > 1.5f) {
                tropheeRoueGris.setVisible(true);
                if (afficheTime > 1.5f && afficheTime < 1.6f)
                    soundEffectManager("tableau").play();
            }
            if (afficheTime > 2f) {
                tropheeDollarGris.setVisible(true);
                if (afficheTime > 2f && afficheTime < 2.1f)
                    soundEffectManager("tableau").play(0.35f);
            }
            if (afficheTime > 2.5f) {
                tropheeBonusGris.setVisible(true);
                if (afficheTime > 2.5f && afficheTime < 2.59f)
                    soundEffectManager("tableau").play(0.35f);
            }
            // LIGNE des voitures écrasées
            if (afficheTime > 3) {
                iconeVoituresEcrasees.setVisible(true);
                scoreVoitures.setVisible(true);
                primeTotal.setVisible(true);
                if (afficheTime > 3f && afficheTime < 3.1f)
                    soundEffectManager("coinSound").play(0.35f);
                // trophée ROUE or
                if (produit >= 0.67f) {
                    tropheeRoueOr.setVisible(true);
                }
            }
            // LIGNE des Dollars
            if (afficheTime > 4) {
                iconeDollar.setVisible(true);
                scorePieces.setVisible(true);
                if (afficheTime > 4f && afficheTime < 4.1f) {
                    soundEffectManager("coinSound").play(0.35f);
                }
                // trophee DOLLAR or
                if (scoreMultiplied > 3500) tropheeDollarOr.setVisible(true);

            }
            if (afficheTime > 4.3f) {
                scorePieces.setVisible(true);
                iconeMultiScoreGRIS.setVisible(true);
            }
            if (afficheTime > 4.5f) {
                if (!multiplierScore.equals("")) {
                    iconeMultiScoreOR.setVisible(true);
                }

            }
            // LIGNE des bonus
            if (afficheTime > 5) {
                if (gasFreeCatched == 1) iconeGasFree.setVisible(true);
                if (afficheTime > 5f && afficheTime < 5.1f) {
                    soundEffectManager("tableau").play(0.2f);
                }
            }
            if (afficheTime > 5.2f) {
                if (nitroCatched == 1) {
                    iconeNitro.setVisible(true);
                    if (afficheTime > 5.2f && afficheTime < 5.3f) {
                        soundEffectManager("tableau").play(0.2f);
                    }
                }
            }
            if (afficheTime > 5.5f) {
                if (billetCatched == 1) {
                    iconeBillet.setVisible(true);
                    if (afficheTime > 5.5f && afficheTime < 5.6f) {
                        soundEffectManager("tableau").play(0.2f);
                    }
                }
            }
            if (afficheTime > 5.7f) {
                bonusCollectees.setVisible(true);
                if (afficheTime > 5.7f && afficheTime < 5.8f) {
                    soundEffectManager("coinSound").play(0.35f);
                }
                // trophée BONUS or
                if (bonusCatched == 3) {
                    tropheeBonusOr.setVisible(true);
                }
            }
            // Prime des trophées
            if (afficheTime > 6) {
                primeTrophee.setVisible(true);
                if (afficheTime > 6f && afficheTime < 6.1f) {
                    soundEffectManager("tableau").play(0.35f);
                }
            }
            // LIGNE PUBS
            if (afficheTime > 7f) {
                if (okBonusPub || videoClosed) {
                    afterPub.setVisible(false);
                    bonusButton.setVisible(false);
                } else {
                    drawAnimBonus(batch);
                    bonusButton.setVisible(true);
                    afterPub.setVisible(true);
                }


            }
            if (afficheTime > 7f && afficheTime < 7.1f) {
                soundEffectManager("tableau").play(0.35f);
                playMusicChosen().setVolume(0.9f);
                playMusicChosen().play();
            }
        }
    }

    private void drawAnimBonus(SpriteBatch batch) {
        Animation<TextureRegion> bonusAnimation = new Animation<TextureRegion>(0.2f, SheetToFramer.sheetToFrame(menuAnimFrameSheet, 2, 3));
        bonusAnimation.setPlayMode(Animation.PlayMode.LOOP);
        TextureRegion bonusCurrentFrame = bonusAnimation.getKeyFrame(stateTime, true);
        batch.draw(bonusCurrentFrame, viewport.getWorldWidth() / 28, viewport.getWorldHeight() / 8,
                bonusCurrentFrame.getRegionWidth() / 2.15f, bonusCurrentFrame.getRegionHeight() / 2.15f);
    }

    private void drawAnimPilote(SpriteBatch batch) {
        Animation<TextureRegion> piloteAnimation = new Animation<TextureRegion>(0.2f, SheetToFramer.sheetToFrame(pilote.getFrameSheet(mtcGame.getPrefs().getInteger("headChoice"), exitScreenChoice), 2, 4));
        if(exitScreenChoice.equals("accident")){
            piloteAnimation.setPlayMode(Animation.PlayMode.LOOP);
            TextureRegion piloteCurrentFrame = piloteAnimation.getKeyFrame(stateTime, true);
            batch.draw(piloteCurrentFrame, viewport.getWorldWidth() / 1.5f - piloteCurrentFrame.getRegionWidth()/6, viewport.getWorldHeight() / 8 - piloteCurrentFrame.getRegionHeight()/6,
                    piloteCurrentFrame.getRegionWidth()*0.5f , piloteCurrentFrame.getRegionHeight()*0.5f);
        }
        if(exitScreenChoice.equals("panne")){
            piloteAnimation.setPlayMode(Animation.PlayMode.LOOP);
            TextureRegion piloteCurrentFrame = piloteAnimation.getKeyFrame(stateTime, true);
            batch.draw(piloteCurrentFrame, viewport.getWorldWidth() / 1.5f - piloteCurrentFrame.getRegionWidth()/8, viewport.getWorldHeight() / 8 - piloteCurrentFrame.getRegionHeight()/8,
                    piloteCurrentFrame.getRegionWidth()*0.75f , piloteCurrentFrame.getRegionHeight()*0.75f);
        }
        if(exitScreenChoice.equals("victoire")){
            piloteAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
            TextureRegion piloteCurrentFrame = piloteAnimation.getKeyFrame(stateTime, true);
            batch.draw(piloteCurrentFrame, viewport.getWorldWidth() / 1.5f - piloteCurrentFrame.getRegionWidth()/3.5f, viewport.getWorldHeight() / 8 - piloteCurrentFrame.getRegionHeight()/5,
                    piloteCurrentFrame.getRegionWidth(), piloteCurrentFrame.getRegionHeight());
        }
    }

    private Sound soundEffectManager(String choice) {
        if (choice.equals("tableau")) {
            soundEffect = mtcGame.getAssetManager().get("tableauStompSound.wav");
        }
        if (choice.equals("coinSound")) {
            soundEffect = mtcGame.getAssetManager().get("Coin Sound Effect.wav");
        }
        return soundEffect;
    }

    private Music playMusicChosen() {
        if (exitScreenChoice.equals("accident")) {
            deceptionMusic = mtcGame.getAssetManager().get("deceptionSound.mp3",Music.class);

        }
        if (exitScreenChoice.equals("panne")) {
            deceptionMusic = mtcGame.getAssetManager().get("deceptionExplosionSound.mp3",Music.class);

        }
        if (exitScreenChoice.equals("victoire")) {
            deceptionMusic = mtcGame.getAssetManager().get("victorySound.mp3",Music.class);

        }
        return deceptionMusic;
    }

    private void updateFrame() {
        stateTime += Gdx.graphics.getDeltaTime();
    }

    /**
     * BONUS LIGNE PAR LIGNE
     */
    private void bonusVoituresEcrasees() {
        produit = (scoreDead / nbEnemies);
        if (produit != 0) {
            if (bonusVoituresEcrasees < scoreDead) {
                bonusVoituresEcrasees += 2f;
            }
            if (bonusVoituresEcrasees >= scoreDead && scoreDead != 0) {
                if (scoreDead == nbEnemies) {
                    primeVoituresEcrasees = 1000;
                }
                if (produit >= 0.75f) {
                    primeVoituresEcrasees = 300;
                }
                if (produit >= 0.67f && produit < 0.75f) {
                    primeVoituresEcrasees = 200;
                }
                if (produit >= 0.33f && produit < 0.67f) {
                    primeVoituresEcrasees = 100;
                }
            }
        }
    }

    private void multiplyScoreTotal() {
        int tempScoreToMultiply;
        if (!multiplierScore.equals("")) {
            if (multiplierScore.equals("X3")) {
                tempScoreToMultiply = scoreTotal * 3;
            } else {
                tempScoreToMultiply = scoreTotal * 2;
            }
            if (iconeMultiScoreOR.isVisible()) {
                scoreMultiplied = tempScoreToMultiply;
            }
        } else {
            scoreMultiplied = scoreTotal;
        }
        if (scoreMultiplied > 3500) {
            tropheeDollarOr.setVisible(true);
        }
    }

    private int bonusScore() {
        resultat = bonusCatched * 100;
        return resultat;
    }

    private int totalScore() {
        if (scorePieces.isVisible()) {
            total = primeVoituresEcrasees;
        }
        if (iconeMultiScoreOR.isVisible()) {
            total = primeVoituresEcrasees + scoreMultiplied;
        }
        if (bonusCollectees.isVisible()) {
            total = primeVoituresEcrasees + scoreMultiplied + resultat;
        }
        if (primeTrophee.isVisible()) {
            total = primeVoituresEcrasees + scoreMultiplied + resultat + bonusTrophee;
        }
        if (okBonusPub){
            total = (primeVoituresEcrasees + scoreMultiplied + resultat + bonusTrophee) + 150;
        }
        return total;
    }

    private int primeSelonTrophee() {
        if (tropheeRoueOr.isVisible()) tropheeRoueScore = 1;
        if (tropheeDollarOr.isVisible()) tropheeDollarScore = 1;
        if (tropheeBonusOr.isVisible()) tropheeBonusScore = 1;
        if (primeTropheeGroup.isVisible()) {
            bonusTrophee = (tropheeBonusScore + tropheeRoueScore + tropheeDollarScore) * 100;
        }
        return bonusTrophee;
    }

    private void savePrefs(){
        mtcGame.getPrefs().putInteger("money",
                mtcGame.getPrefs().getInteger("money") + total).flush();
        // trophées
        if(tropheeBonusOr.isVisible()){
            mtcGame.getPrefs().putInteger("nbTropheeBonus",mtcGame.getPrefs().getInteger("nbTropheeBonus") + 1).flush();
        }
        if(tropheeDollarOr.isVisible()){
            mtcGame.getPrefs().putInteger("nbTropheeDollar",mtcGame.getPrefs().getInteger("nbTropheeDollar") + 1).flush();
        }
        if(tropheeRoueOr.isVisible()){
            mtcGame.getPrefs().putInteger("nbTropheeRoue",mtcGame.getPrefs().getInteger("nbTropheeRoue") + 1).flush();
        }
        if(total > mtcGame.getPrefs().getInteger("argentMax")){
            mtcGame.getPrefs().putInteger("argentMax",total).flush();
        }
    }

    private void videoViewedToggleBool(){
        if(mtcGame.getGoogleServices().hasVideoViewed()){
            // récompense
            okBonusPub = true;
            // timer pour booleen viewed
            if(videoViewedTimer < 2){
                videoViewedTimer += 0.1f;
            }
        }
        if(videoViewedTimer >= 2){
            mtcGame.getGoogleServices().setIs_video_ad_viewed(false);
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

    private void debugLog() {
//        Gdx.app.log("batch.dispose", ": ok");
//        Gdx.app.log("scoreDead", Integer.toString((int) scoreDead));
//        Gdx.app.log("bonusVoitureEcasees", Integer.toString((int) bonusVoituresEcrasees));
//        Gdx.app.log("enemiesPositionsList.size", Integer.toString(ground.getEnemiesPositions().size));
//        Gdx.app.log("ratio", Float.toString(ratio));
//        Gdx.app.log("afficheTime",Float.toString(afficheTime));
//        Gdx.app.log("nbEnemiesRecus", Integer.toString((int) nbEnemies));
//        Gdx.app.log("scoreDead", Integer.toString((int) scoreDead));
//        Gdx.app.log("produit", Float.toString(produit));
//        Gdx.app.log("prefs.money",Integer.toString(Gdx.app.getPreferences("MyPrefs").getInteger("money")));
//        Gdx.app.log("exitTimer",Float.toString(exitTimer));
//        Gdx.app.log("nbTropheeBonus",Integer.toString(mtcGame.getPrefs().getInteger("nbTropheeBonus")));
//        Gdx.app.log("nbTropheeDollar",Integer.toString(mtcGame.getPrefs().getInteger("nbTropheeDollar")));
//        Gdx.app.log("nbTropheeRoue",Integer.toString(mtcGame.getPrefs().getInteger("nbTropheeRoue")));
//        Gdx.app.log("video PerDay",Boolean.toString(mtcGame.getPrefs().getBoolean("videoViewedLimit")));
//        Gdx.app.log("videoViewed time start",timeToStringConvert(mtcGame.getPrefs().getLong("VVLimitTimeStart")));

//        Gdx.app.log("Time started",timeToStringConvert(mtcGame.getPrefs().getLong("VVLimitTimeStart")));
//        Gdx.app.log("time Elapsed",timeToStringConvert(timeElapsing));
//        Gdx.app.log("poputImerGroupVisib",Boolean.toString(popUpTimerGroup.isVisible()));
//        Gdx.app.log("loadMontagneTMX",Boolean.toString(mtcGame.getAssetManager().isLoaded("textures DecorMontagne/mapMontagne.tmx")));
//        Gdx.app.log("loadDesertTMX",Boolean.toString(mtcGame.getAssetManager().isLoaded("textures DecorDesert/mapDesert.tmx")))
//        Gdx.app.log("SansPermisSoundEffectLoad",Boolean.toString(mtcGame.getAssetManager().isLoaded("SansPermisSoundEffect-accel.wav")));
        if(assetsToUnload!=null){
            Gdx.app.log("assetsToUnload",Integer.toString(assetsToUnload.size));

        }
    }

}
