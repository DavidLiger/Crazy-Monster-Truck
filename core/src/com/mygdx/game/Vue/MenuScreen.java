package com.mygdx.game.Vue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Controleur.MTCGame;

import java.util.Locale;

public class MenuScreen extends ScreenAdapter {

    private static final float WORLD_WIDTH = 960;
    private static final float WORLD_HEIGHT = 720;
    private static float UNITS_PER_METER = 32F;
    private static float UNIT_WIDTH = WORLD_WIDTH / UNITS_PER_METER;
    private static float UNIT_HEIGHT = WORLD_HEIGHT / UNITS_PER_METER;
    private Viewport viewport;
    private OrthographicCamera camera;

    private final MTCGame mtcGame;
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;

    // stage
    private Stage stage;

    private Group menuCircuitGroup = new Group();
    private Group menuCircuitReceptionBoutonsCircuitGroup = new Group();
    private Group menuPiloteGroup = new Group();
    private Group menuPiloteReceptionBoutonsPiloteGroup = new Group();
    private Group menuChoixReceptionBoutonsDirectionsGroup = new Group();
    private Group menuVehiculesGroup = new Group();
    private Group menuVehiculesReceptionBoutonsVehiculesGroup = new Group();
    private Group menuAtelierGroup = new Group();
    private Group menuBoutiqueGroup = new Group();
    private Group menuGeneralGroup = new Group();
    private Group boutonRetourScale = new Group();
    private Group boutonStartGroup = new Group();
    private Group boutonCompteScale = new Group();
    private Group menuBoutiqueBoutonsCircuitGroup = new Group();
    private Group menuBoutiqueBoutonsPiloteGroup = new Group();
    private Group menuBoutiqueBoutonsVehiculeGroup = new Group();
    private Group menuBoutiqueBoutonsDirectionsGroup = new Group();
    private Group menuBoutiqueReceptionBoutonsPiloteGroup = new Group();
    private Group menuBoutiqueReceptionBoutonsVehiculesGroup = new Group();
    private Group menuBoutiqueReceptionBoutonsCircuitGroup = new Group();


    private Group fichePilotesGroup = new Group();
    private Group ficheVehiculesGroup = new Group();
    private Group ficheCircuitGroup = new Group();
    private Group ficheCompteGroup = new Group();
    private Group cadenasGroup = new Group();

    private Image menuCircuitImageDeFond;
    private Image menuPiloteImageDeFond;
    private Image menuVehiculesImageDeFond;
    private Image menuAtelierImageDeFond;
    private Image menuBoutiqueImageDeFond;
    private Image bandeauAntiTouchBas;
    private Image bandeauAntiTouchHaut;

    private Image ficheCompte;

    private Image ficheFond;
    private Image ficheImage;
    private Image ficheDescr;
    private TextureRegion ficheFondTex;
    private TextureRegion ficheDescriptionTex;
    private TextureRegion ficheImageTex;
    private String ficheNomString;
    private String ficheTextString;
    private Label ficheNomLabel;
    private Label ficheTextLabel;
    private Group ficheGroup = new Group();

    private Image cadenasImage3;
    private Image cadenasImage4;
    private Image cadenasImage5;
    private Image cadenasImage6;
    private Image cadenasImage7;
    private Image cadenasImage8;
    private Image cadenasImage9;
    private Image cadenasImage10;
    private Image cadenasImage11;
    private Image cadenasImage12;

    private Array<Image> arrayCadenasImage = new Array<Image>();

    private Image checkImage;
    private Group checkImageScale = new Group();

    // menu ATELIER
    private ImageButton boutonRoueVehicule1;
    private ImageButton boutonRoueVehicule2;
    private ImageButton boutonRoueVehicule3;
    private ImageButton boutonRoueVehicule4;
    private ImageButton boutonRoueVehicule5;
    private ImageButton boutonRoueVehicule6;
    private ImageButton boutonRoueVehicule7;
    private ImageButton boutonRoueVehicule8;
    private ImageButton boutonRoueVehicule9;
    private ImageButton boutonRoueVehicule10;
    private ImageButton boutonRoueVehicule11;
    private ImageButton boutonRoueVehicule12;

    private ImageButton boutonChassisVehicule1;
    private ImageButton boutonChassisVehicule2;
    private ImageButton boutonChassisVehicule3;
    private ImageButton boutonChassisVehicule4;
    private ImageButton boutonChassisVehicule5;
    private ImageButton boutonChassisVehicule6;
    private ImageButton boutonChassisVehicule7;
    private ImageButton boutonChassisVehicule8;
    private ImageButton boutonChassisVehicule9;
    private ImageButton boutonChassisVehicule10;
    private ImageButton boutonChassisVehicule11;
    private ImageButton boutonChassisVehicule12;

    private ImageButton boutonMoteurVehicule1;
    private ImageButton boutonMoteurVehicule2;
    private ImageButton boutonMoteurVehicule3;
    private ImageButton boutonMoteurVehicule4;
    private ImageButton boutonMoteurVehicule5;
    private ImageButton boutonMoteurVehicule6;
    private ImageButton boutonMoteurVehicule7;
    private ImageButton boutonMoteurVehicule8;
    private ImageButton boutonMoteurVehicule9;
    private ImageButton boutonMoteurVehicule10;
    private ImageButton boutonMoteurVehicule11;
    private ImageButton boutonMoteurVehicule12;

    private Array<ImageButton> arrayBoutonRouesVehicules = new Array<ImageButton>();
    private Array<ImageButton> arrayBoutonChassisVehicules = new Array<ImageButton>();
    private Array<ImageButton> arrayBoutonMoteurVehicules = new Array<ImageButton>();

    private Group boutonsRouesVehiculesGroup = new Group();
    private Group boutonsChassisVehiculesGroup = new Group();
    private Group boutonsMoteurVehiculesGroup = new Group();

    private ImageButton boutonUpColonneRoues;
    private ImageButton boutonDownColonneRoues;
    private ImageButton boutonUpColonneChassis;
    private ImageButton boutonDownColonneChassis;
    private ImageButton boutonLeftRangeeMoteur;
    private ImageButton boutonRightRangeeMoteur;

    private Image coinAntiTouch1;
    private Image coinAntiTouch2;
    private Image coinAntiTouch3;
    private Image coinAntiTouch4;
    private Image coinAntiTouch5;
    private Image coinAntiTouch6;

    private Group antiTouchGroup = new Group();
    private Group boutonsDirectionsGroup = new Group();
    private Group saveButtonScale = new Group();

    private ImageButton saveButton;
    private Image sousBoutonSave;
    private Label boutonSaveLabel;

    private TextureRegion roueEditeurImageTexture;
    private TextureRegion moteurEditeurImageTexture;
    private TextureRegion chassisEditeurImageTexture;
    private Image roueLeftEditeurImage;
    private Image roueRightEditeurImage;
    private Image moteurEditeurImage;
    private Image chassisEditeurImage;
    private Group imagesEditeurGroup = new Group();

    // menu GENERAL
    private final ImageButton boutonMenuAtelier;
    private final ImageButton boutonMenuBoutique;
    private final ImageButton boutonMenuPilote;
    private final ImageButton boutonMenuVehicules;
    private final ImageButton boutonMenuCircuit;
    private final ImageButton boutonRetour;
    private final ImageButton boutonStart;

    private Image sousBoutonAtelier;
    private Image sousBoutonBoutique;

    private Image sousBoutonPilote;
    private Image sousBoutonVehicule;
    private Image sousBoutonCircuit;

    private Group boutonAtelierGroup = new Group();
    private Group boutonBoutiqueGroup = new Group();
    private Group boutonPiloteGroup = new Group();
    private Group boutonVehiculeGroup = new Group();
    private Group boutonCircuitGroup = new Group();

//    private Label boutonPiloteLabel;
//    private Label boutonVehiculeLabel;
//    private Label boutonCircuitLabel;

    private float buttonMover = 0;
    private boolean buttonMoveBool;

    // menu BOUTIQUE
    private final ImageButton boutonCircuit1;
    private final ImageButton boutonCircuit2;
    private final ImageButton boutonCircuit3;
    private final ImageButton boutonCircuit4;
    private final ImageButton boutonCircuit5;
    private final ImageButton boutonCircuit6;
    private final ImageButton boutonCircuit7;
    private final ImageButton boutonCircuit8;
    private final ImageButton boutonCircuit9;
    private final ImageButton boutonCircuit10;
    private final ImageButton boutonCircuit11;
    private final ImageButton boutonCircuit12;

    private Array<ImageButton> arrayBoutonsCircuit = new Array<ImageButton>();
    private Array<ImageButton> toSellCircuitList = new Array<ImageButton>();
    private Array<ImageButton> paidCircuitList = new Array<ImageButton>();

    private final ImageButton boutonPilote1;
    private final ImageButton boutonPilote2;
    private final ImageButton boutonPilote3;
    private final ImageButton boutonPilote4;
    private final ImageButton boutonPilote5;
    private final ImageButton boutonPilote6;
    private final ImageButton boutonPilote7;
    private final ImageButton boutonPilote8;
    private final ImageButton boutonPilote9;
    private final ImageButton boutonPilote10;
    private final ImageButton boutonPilote11;
    private final ImageButton boutonPilote12;

    private Array<Image> imagesCadenasPiloteList = new Array<Image>();

    private Array<ImageButton> arrayBoutonsPilote = new Array<ImageButton>();
    private Array<ImageButton> toSellPiloteList = new Array<ImageButton>();
    private Array<ImageButton> paidPiloteList = new Array<ImageButton>();

    private float[] positionsMenuBoutiqueBoutonsColonneListY = new float[12];
    private Array<Vector2> positionsMenuChoixBoutonsPositionsArray = new Array<Vector2>();

    private final ImageButton boutonVehicule1;
    private final ImageButton boutonVehicule2;
    private final ImageButton boutonVehicule3;
    private final ImageButton boutonVehicule4;
    private final ImageButton boutonVehicule5;
    private final ImageButton boutonVehicule6;
    private final ImageButton boutonVehicule7;
    private final ImageButton boutonVehicule8;
    private final ImageButton boutonVehicule9;
    private final ImageButton boutonVehicule10;
    private final ImageButton boutonVehicule11;
    private final ImageButton boutonVehicule12;
    private final ImageButton boutonVehicule13;

    private Array<ImageButton> arrayBoutonsVehicule = new Array<ImageButton>();
    private Array<ImageButton> toSellVehiculeList = new Array<ImageButton>();
    private Array<ImageButton> paidVehiculeList = new Array<ImageButton>();

    private final ImageButton boutonHautColonnePilote;
    private final ImageButton boutonHautColonneVehicule;
    private final ImageButton boutonHautColonneCircuit;
    private final ImageButton boutonBasColonnePilote;
    private final ImageButton boutonBasColonneVehicule;
    private final ImageButton boutonBasColonneCircuit;

    private final ImageButton boutonCompte;
    private Image fondBoutonCompteImage;

    // Menu Achat
    private Label.LabelStyle scoreFontLabelStyle = new Label.LabelStyle();
    private Label.LabelStyle compteLabelStyle = new Label.LabelStyle();
    private final ImageButton boutonAchat;
    private Image sousBoutonAchatTexture;
    private int montantAchat;
    private Label prixDAchatLabel;
    private Group boutonAchatGroup = new Group();
    private boolean paiement;
    private boolean achatBool;
    private int soldeToutCompte;

    // panneau Timer
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

    private Image fondPopUpManqueArgentImage;
    private final ImageButton boutonPubPopUpManqueArgent;
    private Label manqueArgentLabel;
    private Group popUpManqueArgentGroup = new Group();

    private int[] grilleDePrixPilote = new int[10];
    private int[] grilleDePrixVehicule = new int[10];
    private int[] grilleDePrixCircuit = new int[10];

    private ImageButton boutonToBuy;

    // stats et compte
    private Label compteLabel;
    private Label boutonCompteLabel;
    private Image iconesFicheCompte;

    private Label argentMaxLabel;
    private Label nbTropheeRoueLabel;
    private Label nbTropheeDollarLabel;
    private Label nbTropheeBonusLabel;

    // musics
    private Music menuMusic;
    private Music atelierMusic;
    private Music supermarketMusic;
    private Music achatSound;
    private Music coinSound;

    private float fichesPiloteMover = 0;
    private boolean fichesPiloteBool;
    private float fichesVehiculeMover = 0;
    private boolean fichesVehiculeBool;
    private float fichesCircuitMover = 0;
    private boolean fichesCircuitBool;
    private float fichesCompteMover = 0;
    private boolean fichesCompteBool;

    private boolean futureUpPositionColonneBool;
    private boolean futureDownPositionColonneBool;
    private boolean futureUpPositionColonneVehiculeBool;
    private boolean futureDownPositionColonneVehiculeBool;
    private boolean futureUpPositionColonneCircuitBool;
    private boolean futureDownPositionColonneCircuitBool;
    private boolean okUpdatePositionVehiculeColonne;
    private boolean okUpdatePositionCircuitColonne;
    private boolean okUpdatePositionColonne;

    private boolean scrollUpMenuChoixBoutonsGroupBool;
    private boolean scrollDownMenuChoixBoutonsGroupBool;

    private float futurePositionPiloteColonne;
    private float futurePositionVehiculeColonne;
    private float futurePositionCircuitColonne;

    // Atelier : mouvements colonnes et rangée
    private boolean futureUpPosColRouesBool;
    private boolean futureDownPosColRouesBool;
    private boolean okUpdatePosColRoues;

    private float futurePosColRoues;

    private boolean futureUpPosColChassisBool;
    private boolean futureDownPosColChassisBool;
    private boolean okUpdatePosColChassis;

    private float futurePosColChassis;

    private boolean futureRightPosColMoteurBool;
    private boolean futureLeftPosColMoteurBool;
    private boolean okUpdatePosColMoteur;

    private float futurePosColMoteur;
    private int choixRoue;
    private int choixMoteur;
    private int choixChassis;

    // pubs
    private float videoViewedTimer = 0;
    private int adReward;
    private long timeStarted;
    private long timeElapsing;
    private long cycleTimeElapsing;

    private long time;
    private double millis;
    private double seconds;
    private double minutes;
    private double hours;

    private String horloge;

    private Array<String> assetsToUnload;

    public MenuScreen(MTCGame mtcGame, SpriteBatch batch, Array<String> refsToUnload) {
        this.mtcGame = mtcGame;
        this.batch = batch;
        camera = new OrthographicCamera(UNIT_WIDTH, UNIT_HEIGHT);
        viewport = new FitViewport(WORLD_WIDTH / 2, WORLD_HEIGHT / 2.5f, camera);
        stage = new Stage(viewport);
        assetsToUnload = refsToUnload;

        menuMusic = mtcGame.getAssetManager().get("menuMusic.mp3", Music.class);
        menuMusic.setVolume(0.5f);
        menuMusic.play();
        atelierMusic = mtcGame.getAssetManager().get("atelierMusic.mp3", Music.class);
        atelierMusic.setVolume(0.25f);
        supermarketMusic = mtcGame.getAssetManager().get("supermarketMusic.mp3", Music.class);
        supermarketMusic.setVolume(0.25f);
        achatSound = mtcGame.getAssetManager().get("victorySound.mp3", Music.class);
        coinSound = mtcGame.getAssetManager().get("Coin-Sound-Effect.mp3", Music.class);
        textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas", TextureAtlas.class);

        TextureRegion cadenasTexture = textureAtlas.findRegion("cadenas");

        menuCircuitImageDeFond = new Image(new TextureRegion(textureAtlas.findRegion("fondMenuCircuit")));
        menuPiloteImageDeFond = new Image(new TextureRegion(textureAtlas.findRegion("fondMenuPilote")));
        menuVehiculesImageDeFond = new Image(new TextureRegion(textureAtlas.findRegion("fondMenuVehicule")));
        menuAtelierImageDeFond = new Image(new TextureRegion(textureAtlas.findRegion("atelier-image de fond")));
        menuBoutiqueImageDeFond = new Image(new TextureRegion(textureAtlas.findRegion("boutique-image de fond")));
        bandeauAntiTouchBas = new Image(new TextureRegion(textureAtlas.findRegion("bandeau-AntiTouch")));
        bandeauAntiTouchHaut = new Image(new TextureRegion(textureAtlas.findRegion("bandeau-AntiTouch")));

        // menu BOUTIQUE images
        ficheFond = new Image(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-fiche-pilote-fond")));
        ficheImage = new Image(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-fiche-pilote-1")));
        ficheDescr = new Image(new TextureRegion(textureAtlas.findRegion("fiche-image-description-pilote-1")));

        ficheCompte = new Image(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-fiche-compte")));

        // images cadenas
        cadenasImage3 = new Image(new TextureRegion(cadenasTexture));
        cadenasImage4 = new Image(new TextureRegion(cadenasTexture));
        cadenasImage5 = new Image(new TextureRegion(cadenasTexture));
        cadenasImage6 = new Image(new TextureRegion(cadenasTexture));
        cadenasImage7 = new Image(new TextureRegion(cadenasTexture));
        cadenasImage8 = new Image(new TextureRegion(cadenasTexture));
        cadenasImage9 = new Image(new TextureRegion(cadenasTexture));
        cadenasImage10 = new Image(new TextureRegion(cadenasTexture));
        cadenasImage11 = new Image(new TextureRegion(cadenasTexture));
        cadenasImage12 = new Image(new TextureRegion(cadenasTexture));

        arrayCadenasImage.add(cadenasImage3);
        arrayCadenasImage.add(cadenasImage4);
        arrayCadenasImage.add(cadenasImage5);
        arrayCadenasImage.add(cadenasImage6);
        arrayCadenasImage.add(cadenasImage7);
        arrayCadenasImage.add(cadenasImage8);
        arrayCadenasImage.add(cadenasImage9);
        arrayCadenasImage.add(cadenasImage10);
        arrayCadenasImage.add(cadenasImage11);
        arrayCadenasImage.add(cadenasImage12);

        // check
        checkImage = new Image(new TextureRegion(textureAtlas.findRegion("check")));

        // menu GENERAL boutons
        boutonMenuAtelier = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-atelier-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-atelier-pressed"))));
        boutonMenuBoutique = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-boutique-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-boutique-pressed"))));
        boutonMenuPilote = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-pilote-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-pilote-pressed"))));
        boutonMenuVehicules = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-vehicules-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-vehicules-pressed"))));
        boutonMenuCircuit = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-circuit-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-circuit-pressed"))));
        boutonRetour = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-retour-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-retour-pressed"))));
        boutonStart = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-start-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-General-bouton-start-pressed"))));

        sousBoutonAtelier = new Image(textureAtlas.findRegion("Menu-General-sous-bouton-atelier"));
        sousBoutonBoutique = new Image(textureAtlas.findRegion("Menu-General-sous-bouton-boutique"));

        // menu BOUTIQUE boutons
        boutonCircuit1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-1-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-1-pressed"))));
        boutonCircuit2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-2-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-2-pressed"))));
        boutonCircuit3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-3-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-3-pressed"))));
        boutonCircuit4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-4-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-4-pressed"))));
        boutonCircuit5 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-5-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-5-pressed"))));
        boutonCircuit6 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-6-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-6-pressed"))));
        boutonCircuit7 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-7-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-7-pressed"))));
        boutonCircuit8 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-8-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-8-pressed"))));
        boutonCircuit9 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-9-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-9-pressed"))));
        boutonCircuit10 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-10-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-10-pressed"))));
        boutonCircuit11 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-11-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-11-pressed"))));
        boutonCircuit12 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-12-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-circuit-12-pressed"))));

        arrayBoutonsCircuit.add(boutonCircuit1);
        arrayBoutonsCircuit.add(boutonCircuit2);
        arrayBoutonsCircuit.add(boutonCircuit3);
        arrayBoutonsCircuit.add(boutonCircuit4);
        arrayBoutonsCircuit.add(boutonCircuit5);
        arrayBoutonsCircuit.add(boutonCircuit6);
        arrayBoutonsCircuit.add(boutonCircuit7);
        arrayBoutonsCircuit.add(boutonCircuit8);
        arrayBoutonsCircuit.add(boutonCircuit9);
        arrayBoutonsCircuit.add(boutonCircuit10);
        arrayBoutonsCircuit.add(boutonCircuit11);
        arrayBoutonsCircuit.add(boutonCircuit12);

        paidCircuitList.add(boutonCircuit1);
        paidCircuitList.add(boutonCircuit2);
        if (mtcGame.getPrefs().getBoolean("circuit3Paid")) {
            paidCircuitList.add(boutonCircuit3);
        } else {
            toSellCircuitList.add(boutonCircuit3);
        }
        if (mtcGame.getPrefs().getBoolean("circuit4Paid")) {
            paidCircuitList.add(boutonCircuit4);
        } else {
            toSellCircuitList.add(boutonCircuit4);
        }
        if (mtcGame.getPrefs().getBoolean("circuit5Paid")) {
            paidCircuitList.add(boutonCircuit5);
        } else {
            toSellCircuitList.add(boutonCircuit5);
        }
        if (mtcGame.getPrefs().getBoolean("circuit6Paid")) {
            paidCircuitList.add(boutonCircuit6);
        } else {
            toSellCircuitList.add(boutonCircuit6);
        }
        if (mtcGame.getPrefs().getBoolean("circuit7Paid")) {
            paidCircuitList.add(boutonCircuit7);
        } else {
            toSellCircuitList.add(boutonCircuit7);
        }
        if (mtcGame.getPrefs().getBoolean("circuit8Paid")) {
            paidCircuitList.add(boutonCircuit8);
        } else {
            toSellCircuitList.add(boutonCircuit8);
        }
        if (mtcGame.getPrefs().getBoolean("circuit9Paid")) {
            paidCircuitList.add(boutonCircuit9);
        } else {
            toSellCircuitList.add(boutonCircuit9);
        }
        if (mtcGame.getPrefs().getBoolean("circuit10Paid")) {
            paidCircuitList.add(boutonCircuit10);
        } else {
            toSellCircuitList.add(boutonCircuit10);
        }
        if (mtcGame.getPrefs().getBoolean("circuit11Paid")) {
            paidCircuitList.add(boutonCircuit11);
        } else {
            toSellCircuitList.add(boutonCircuit11);
        }
        if (mtcGame.getPrefs().getBoolean("circuit12Paid")) {
            paidCircuitList.add(boutonCircuit12);
        } else {
            toSellCircuitList.add(boutonCircuit12);
        }

        boutonPilote1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-1-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-1-pressed"))));
        boutonPilote2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-2-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-2-pressed"))));
        boutonPilote3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-3-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-3-pressed"))));
        boutonPilote4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-4-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-4-pressed"))));
        boutonPilote5 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-5-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-5-pressed"))));
        boutonPilote6 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-6-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-6-pressed"))));
        boutonPilote7 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-7-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-7-pressed"))));
        boutonPilote8 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-8-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-8-pressed"))));
        boutonPilote9 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-9-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-9-pressed"))));
        boutonPilote10 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-10-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-10-pressed"))));
        boutonPilote11 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-11-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-11-pressed"))));
        boutonPilote12 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-12-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-pilote-12-pressed"))));

        arrayBoutonsPilote.add(boutonPilote1);
        arrayBoutonsPilote.add(boutonPilote2);
        arrayBoutonsPilote.add(boutonPilote3);
        arrayBoutonsPilote.add(boutonPilote4);
        arrayBoutonsPilote.add(boutonPilote5);
        arrayBoutonsPilote.add(boutonPilote6);
        arrayBoutonsPilote.add(boutonPilote7);
        arrayBoutonsPilote.add(boutonPilote8);
        arrayBoutonsPilote.add(boutonPilote9);
        arrayBoutonsPilote.add(boutonPilote10);
        arrayBoutonsPilote.add(boutonPilote11);
        arrayBoutonsPilote.add(boutonPilote12);

        paidPiloteList.add(boutonPilote1);
        paidPiloteList.add(boutonPilote2);
        if (mtcGame.getPrefs().getBoolean("pilote3Paid")) {
            paidPiloteList.add(boutonPilote3);
        } else {
            toSellPiloteList.add(boutonPilote3);
        }
        if (mtcGame.getPrefs().getBoolean("pilote4Paid")) {
            paidPiloteList.add(boutonPilote4);
        } else {
            toSellPiloteList.add(boutonPilote4);
        }
        if (mtcGame.getPrefs().getBoolean("pilote5Paid")) {
            paidPiloteList.add(boutonPilote5);
        } else {
            toSellPiloteList.add(boutonPilote5);
        }
        if (mtcGame.getPrefs().getBoolean("pilote6Paid")) {
            paidPiloteList.add(boutonPilote6);
        } else {
            toSellPiloteList.add(boutonPilote6);
        }
        if (mtcGame.getPrefs().getBoolean("pilote7Paid")) {
            paidPiloteList.add(boutonPilote7);
        } else {
            toSellPiloteList.add(boutonPilote7);
        }
        if (mtcGame.getPrefs().getBoolean("pilote8Paid")) {
            paidPiloteList.add(boutonPilote8);
        } else {
            toSellPiloteList.add(boutonPilote8);
        }
        if (mtcGame.getPrefs().getBoolean("pilote9Paid")) {
            paidPiloteList.add(boutonPilote9);
        } else {
            toSellPiloteList.add(boutonPilote9);
        }
        if (mtcGame.getPrefs().getBoolean("pilote10Paid")) {
            paidPiloteList.add(boutonPilote10);
        } else {
            toSellPiloteList.add(boutonPilote10);
        }
        if (mtcGame.getPrefs().getBoolean("pilote11Paid")) {
            paidPiloteList.add(boutonPilote11);
        } else {
            toSellPiloteList.add(boutonPilote11);
        }
        if (mtcGame.getPrefs().getBoolean("pilote12Paid")) {
            paidPiloteList.add(boutonPilote12);
        } else {
            toSellPiloteList.add(boutonPilote12);
        }

        // liste de positions
        positionsMenuBoutiqueBoutonsColonneListY[0] = viewport.getWorldHeight() / 4 - boutonPilote1.getHeight() / 6;
        positionsMenuBoutiqueBoutonsColonneListY[1] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight();
        positionsMenuBoutiqueBoutonsColonneListY[2] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 2.08f;
        positionsMenuBoutiqueBoutonsColonneListY[3] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 3.17f;
        positionsMenuBoutiqueBoutonsColonneListY[4] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 4.26f;
        positionsMenuBoutiqueBoutonsColonneListY[5] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 5.34f;
        positionsMenuBoutiqueBoutonsColonneListY[6] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 6.43f;
        positionsMenuBoutiqueBoutonsColonneListY[7] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 7.51f;
        positionsMenuBoutiqueBoutonsColonneListY[8] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 8.6f;
        positionsMenuBoutiqueBoutonsColonneListY[9] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 9.68f;
        positionsMenuBoutiqueBoutonsColonneListY[10] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 10.77f;
        positionsMenuBoutiqueBoutonsColonneListY[11] = viewport.getWorldHeight() / 8 - boutonPilote2.getHeight() * 11.85f;

        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 4 - boutonPilote1.getWidth() / 1.2f, viewport.getWorldHeight() / 1.14f - boutonPilote1.getHeight() / 4));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 3 - boutonPilote2.getWidth() / 20, viewport.getWorldHeight() / 1.14f - boutonPilote1.getHeight() / 4));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 3 + boutonPilote2.getWidth() * 1.03f, viewport.getWorldHeight() / 1.14f - boutonPilote1.getHeight() / 4));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 3 + boutonPilote2.getWidth() * 2.12f, viewport.getWorldHeight() / 1.14f - boutonPilote1.getHeight() / 4));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 4 - boutonPilote1.getWidth() / 1.2f, viewport.getWorldHeight() / 2.5f - boutonPilote2.getHeight() / 3));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 3 - boutonPilote2.getWidth() / 20, viewport.getWorldHeight() / 2.5f - boutonPilote2.getHeight() / 3));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 3 + boutonPilote2.getWidth() * 1.03f, viewport.getWorldHeight() / 2.5f - boutonPilote2.getHeight() / 3));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 3 + boutonPilote2.getWidth() * 2.12f, viewport.getWorldHeight() / 2.5f - boutonPilote2.getHeight() / 3));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 4 - boutonPilote1.getWidth() / 1.2f, viewport.getWorldHeight() / 4 - boutonPilote2.getHeight() * 1.09f));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 3 - boutonPilote2.getWidth() / 20, viewport.getWorldHeight() / 4 - boutonPilote2.getHeight() * 1.09f));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 3 + boutonPilote2.getWidth() * 1.03f, viewport.getWorldHeight() / 4 - boutonPilote2.getHeight() * 1.09f));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 3 + boutonPilote2.getWidth() * 2.12f, viewport.getWorldHeight() / 4 - boutonPilote2.getHeight() * 1.09f));
        positionsMenuChoixBoutonsPositionsArray.add(new Vector2(viewport.getWorldWidth() / 4 - boutonPilote1.getWidth() / 1.2f, viewport.getWorldHeight() + boutonPilote1.getHeight() / 1.75f));

        boutonVehicule1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-1-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-1-pressed"))));
        boutonVehicule2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-2-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-2-pressed"))));
        boutonVehicule3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-3-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-3-pressed"))));
        boutonVehicule4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-4-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-4-pressed"))));
        boutonVehicule5 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-5-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-5-pressed"))));
        boutonVehicule6 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-6-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-6-pressed"))));
        boutonVehicule7 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-7-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-7-pressed"))));
        boutonVehicule8 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-8-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-8-pressed"))));
        boutonVehicule9 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-9-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-9-pressed"))));
        boutonVehicule10 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-10-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-10-pressed"))));
        boutonVehicule11 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-11-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-11-pressed"))));
        boutonVehicule12 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-12-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-vehicule-12-pressed"))));
        boutonVehicule13 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-vehicule-perso-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-vehicule-perso-pressed"))));

        arrayBoutonsVehicule.add(boutonVehicule1);
        arrayBoutonsVehicule.add(boutonVehicule2);
        arrayBoutonsVehicule.add(boutonVehicule3);
        arrayBoutonsVehicule.add(boutonVehicule4);
        arrayBoutonsVehicule.add(boutonVehicule5);
        arrayBoutonsVehicule.add(boutonVehicule6);
        arrayBoutonsVehicule.add(boutonVehicule7);
        arrayBoutonsVehicule.add(boutonVehicule8);
        arrayBoutonsVehicule.add(boutonVehicule9);
        arrayBoutonsVehicule.add(boutonVehicule10);
        arrayBoutonsVehicule.add(boutonVehicule11);
        arrayBoutonsVehicule.add(boutonVehicule12);

        boutonHautColonnePilote = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-pressed"))));
        boutonHautColonneVehicule = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-pressed"))));
        boutonHautColonneCircuit = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-pressed"))));
        boutonBasColonnePilote = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-pressed"))));
        boutonBasColonneVehicule = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-pressed"))));
        boutonBasColonneCircuit = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-pressed"))));

        boutonCompte = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-compte-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-compte-pressed"))));

        fondBoutonCompteImage = new Image(new TextureRegion(textureAtlas.findRegion("Menu-Boutique-bouton-compte-fond")));

        boutonAchat = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-achat-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-achat-pressed"))));

        sousBoutonAchatTexture = new Image(new TextureRegion(textureAtlas.findRegion("sousBouton-achat")));

        grilleDePrixVehicule[0] = 20000;
        grilleDePrixPilote[0] = 3000;
        grilleDePrixCircuit[0] = 12000;

        fondPopUpManqueArgentImage = new Image(new TextureRegion(textureAtlas.findRegion("popup-Manque-Argent")));
        fondPopUpTimerVideosImage = new Image(new TextureRegion(textureAtlas.findRegion("popup-Manque-Temps")));
        fondWifiWarningImage = new Image(new TextureRegion(textureAtlas.findRegion("popup-Manque-Wifi")));
        boutonPubPopUpManqueArgent = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-pub-manque-argent-normal"))),
                new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("bouton-pub-manque-argent-pressed"))));

        iconesFicheCompte = new Image(textureAtlas.findRegion("iconesFicheCompte"));

        sousBoutonPilote = new Image(createSousBoutonPiloteTexture());
        sousBoutonVehicule = new Image(createSousBoutonVehiculeTexture());
        sousBoutonCircuit = new Image(createSousBoutonCircuitTexture());

        // menu Atelier
        boutonRoueVehicule1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-1-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-1-pressed"))));
        boutonRoueVehicule2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-2-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-2-pressed"))));
        boutonRoueVehicule3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-3-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-3-pressed"))));
        boutonRoueVehicule4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-4-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-4-pressed"))));
        boutonRoueVehicule5 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-5-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-5-pressed"))));
        boutonRoueVehicule6 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-6-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-6-pressed"))));
        boutonRoueVehicule7 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-7-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-7-pressed"))));
        boutonRoueVehicule8 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-8-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-8-pressed"))));
        boutonRoueVehicule9 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-9-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-9-pressed"))));
        boutonRoueVehicule10 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-10-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-10-pressed"))));
        boutonRoueVehicule11 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-11-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-11-pressed"))));
        boutonRoueVehicule12 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-12-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-roue-12-pressed"))));

        arrayBoutonRouesVehicules.add(boutonRoueVehicule1);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule2);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule3);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule4);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule5);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule6);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule7);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule8);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule9);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule10);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule11);
        arrayBoutonRouesVehicules.add(boutonRoueVehicule12);

        boutonChassisVehicule1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-1-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-1-pressed"))));
        boutonChassisVehicule2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-2-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-2-pressed"))));
        boutonChassisVehicule3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-3-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-3-pressed"))));
        boutonChassisVehicule4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-4-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-4-pressed"))));
        boutonChassisVehicule5 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-5-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-5-pressed"))));
        boutonChassisVehicule6 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-6-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-6-pressed"))));
        boutonChassisVehicule7 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-7-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-7-pressed"))));
        boutonChassisVehicule8 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-8-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-8-pressed"))));
        boutonChassisVehicule9 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-9-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-9-pressed"))));
        boutonChassisVehicule10 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-10-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-10-pressed"))));
        boutonChassisVehicule11 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-11-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-11-pressed"))));
        boutonChassisVehicule12 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-12-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-chassis-12-pressed"))));

        arrayBoutonChassisVehicules.add(boutonChassisVehicule1);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule2);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule3);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule4);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule5);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule6);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule7);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule8);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule9);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule10);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule11);
        arrayBoutonChassisVehicules.add(boutonChassisVehicule12);

        boutonMoteurVehicule1 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-1-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-1-pressed"))));
        boutonMoteurVehicule2 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-2-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-2-pressed"))));
        boutonMoteurVehicule3 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-3-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-3-pressed"))));
        boutonMoteurVehicule4 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-4-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-4-pressed"))));
        boutonMoteurVehicule5 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-5-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-5-pressed"))));
        boutonMoteurVehicule6 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-6-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-6-pressed"))));
        boutonMoteurVehicule7 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-7-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-7-pressed"))));
        boutonMoteurVehicule8 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-8-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-8-pressed"))));
        boutonMoteurVehicule9 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-9-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-9-pressed"))));
        boutonMoteurVehicule10 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-10-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-10-pressed"))));
        boutonMoteurVehicule11 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-11-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-11-pressed"))));
        boutonMoteurVehicule12 = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-12-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-moteur-12-pressed"))));

        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule1);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule2);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule3);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule4);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule5);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule6);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule7);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule8);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule9);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule10);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule11);
        arrayBoutonMoteurVehicules.add(boutonMoteurVehicule12);

        paidVehiculeList.add(boutonVehicule1);
        paidVehiculeList.add(boutonVehicule2);
        paidVehiculeList.add(boutonRoueVehicule1);
        paidVehiculeList.add(boutonRoueVehicule2);
        paidVehiculeList.add(boutonChassisVehicule1);
        paidVehiculeList.add(boutonChassisVehicule2);
        paidVehiculeList.add(boutonMoteurVehicule1);
        paidVehiculeList.add(boutonMoteurVehicule2);
        if (mtcGame.getPrefs().getBoolean("vehicule3Paid")) {
            paidVehiculeList.add(boutonVehicule3);
            paidVehiculeList.add(boutonRoueVehicule3);
            paidVehiculeList.add(boutonChassisVehicule3);
            paidVehiculeList.add(boutonMoteurVehicule3);
        } else {
            toSellVehiculeList.add(boutonVehicule3);
            toSellVehiculeList.add(boutonRoueVehicule3);
            toSellVehiculeList.add(boutonChassisVehicule3);
            toSellVehiculeList.add(boutonMoteurVehicule3);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule4Paid")) {
            paidVehiculeList.add(boutonVehicule4);
            paidVehiculeList.add(boutonRoueVehicule4);
            paidVehiculeList.add(boutonChassisVehicule4);
            paidVehiculeList.add(boutonMoteurVehicule4);
        } else {
            toSellVehiculeList.add(boutonVehicule4);
            toSellVehiculeList.add(boutonRoueVehicule4);
            toSellVehiculeList.add(boutonChassisVehicule4);
            toSellVehiculeList.add(boutonMoteurVehicule4);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule5Paid")) {
            paidVehiculeList.add(boutonVehicule5);
            paidVehiculeList.add(boutonRoueVehicule5);
            paidVehiculeList.add(boutonChassisVehicule5);
            paidVehiculeList.add(boutonMoteurVehicule5);
        } else {
            toSellVehiculeList.add(boutonVehicule5);
            toSellVehiculeList.add(boutonRoueVehicule5);
            toSellVehiculeList.add(boutonChassisVehicule5);
            toSellVehiculeList.add(boutonMoteurVehicule5);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule6Paid")) {
            paidVehiculeList.add(boutonVehicule6);
            paidVehiculeList.add(boutonRoueVehicule6);
            paidVehiculeList.add(boutonChassisVehicule6);
            paidVehiculeList.add(boutonMoteurVehicule6);
        } else {
            toSellVehiculeList.add(boutonVehicule6);
            toSellVehiculeList.add(boutonRoueVehicule6);
            toSellVehiculeList.add(boutonChassisVehicule6);
            toSellVehiculeList.add(boutonMoteurVehicule6);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule7Paid")) {
            paidVehiculeList.add(boutonVehicule7);
            paidVehiculeList.add(boutonRoueVehicule7);
            paidVehiculeList.add(boutonChassisVehicule7);
            paidVehiculeList.add(boutonMoteurVehicule7);
        } else {
            toSellVehiculeList.add(boutonVehicule7);
            toSellVehiculeList.add(boutonRoueVehicule7);
            toSellVehiculeList.add(boutonChassisVehicule7);
            toSellVehiculeList.add(boutonMoteurVehicule7);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule8Paid")) {
            paidVehiculeList.add(boutonVehicule8);
            paidVehiculeList.add(boutonRoueVehicule8);
            paidVehiculeList.add(boutonChassisVehicule8);
            paidVehiculeList.add(boutonMoteurVehicule8);
        } else {
            toSellVehiculeList.add(boutonVehicule8);
            toSellVehiculeList.add(boutonRoueVehicule8);
            toSellVehiculeList.add(boutonChassisVehicule8);
            toSellVehiculeList.add(boutonMoteurVehicule8);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule9Paid")) {
            paidVehiculeList.add(boutonVehicule9);
            paidVehiculeList.add(boutonRoueVehicule9);
            paidVehiculeList.add(boutonChassisVehicule9);
            paidVehiculeList.add(boutonMoteurVehicule9);
        } else {
            toSellVehiculeList.add(boutonVehicule9);
            toSellVehiculeList.add(boutonRoueVehicule9);
            toSellVehiculeList.add(boutonChassisVehicule9);
            toSellVehiculeList.add(boutonMoteurVehicule9);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule10Paid")) {
            paidVehiculeList.add(boutonVehicule10);
            paidVehiculeList.add(boutonRoueVehicule10);
            paidVehiculeList.add(boutonChassisVehicule10);
            paidVehiculeList.add(boutonMoteurVehicule10);
        } else {
            toSellVehiculeList.add(boutonVehicule10);
            toSellVehiculeList.add(boutonRoueVehicule10);
            toSellVehiculeList.add(boutonChassisVehicule10);
            toSellVehiculeList.add(boutonMoteurVehicule10);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule11Paid")) {
            paidVehiculeList.add(boutonVehicule11);
            paidVehiculeList.add(boutonRoueVehicule11);
            paidVehiculeList.add(boutonChassisVehicule11);
            paidVehiculeList.add(boutonMoteurVehicule11);
        } else {
            toSellVehiculeList.add(boutonVehicule11);
            toSellVehiculeList.add(boutonRoueVehicule11);
            toSellVehiculeList.add(boutonChassisVehicule11);
            toSellVehiculeList.add(boutonMoteurVehicule11);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule12Paid")) {
            paidVehiculeList.add(boutonVehicule12);
            paidVehiculeList.add(boutonRoueVehicule12);
            paidVehiculeList.add(boutonChassisVehicule12);
            paidVehiculeList.add(boutonMoteurVehicule12);
        } else {
            toSellVehiculeList.add(boutonVehicule12);
            toSellVehiculeList.add(boutonRoueVehicule12);
            toSellVehiculeList.add(boutonChassisVehicule12);
            toSellVehiculeList.add(boutonMoteurVehicule12);
        }
        if (mtcGame.getPrefs().getBoolean("vehicule13Paid")) {
            paidVehiculeList.add(boutonVehicule13);
        } else {
            toSellVehiculeList.add(boutonVehicule13);
        }
        boutonUpColonneRoues = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-pressed"))));
        boutonDownColonneRoues = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-pressed"))));
        boutonUpColonneChassis = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-up-pressed"))));
        boutonDownColonneChassis = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-down-pressed"))));
        boutonRightRangeeMoteur = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-right-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-right-pressed"))));
        boutonLeftRangeeMoteur = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-left-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("boutons-directions-left-pressed"))));

        saveButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-save-normal"))), new TextureRegionDrawable(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-bouton-save-pressed"))));
        sousBoutonSave = new Image(new TextureRegion(textureAtlas.findRegion("Menu-Atelier-sous-bouton-save")));

        coinAntiTouch1 = new Image(new TextureRegion(textureAtlas.findRegion("bandeau-AntiTouch-Atelier")));
        coinAntiTouch2 = new Image(new TextureRegion(textureAtlas.findRegion("bandeau-AntiTouch-Atelier")));
        coinAntiTouch3 = new Image(new TextureRegion(textureAtlas.findRegion("bandeau-AntiTouch-Atelier")));
        coinAntiTouch4 = new Image(new TextureRegion(textureAtlas.findRegion("bandeau-AntiTouch-Atelier")));
        coinAntiTouch5 = new Image(new TextureRegion(textureAtlas.findRegion("bandeau-AntiTouch-Atelier")));
        coinAntiTouch6 = new Image(new TextureRegion(textureAtlas.findRegion("bandeau-AntiTouch-Atelier")));

        createImagesEditeurTexture();
        roueLeftEditeurImage = new Image(roueEditeurImageTexture);
        roueRightEditeurImage = new Image(roueEditeurImageTexture);
        moteurEditeurImage = new Image(moteurEditeurImageTexture);
        chassisEditeurImage = new Image(chassisEditeurImageTexture);
    }

    @Override
    public void show() {
        viewport.apply(true);
        remplissageGrillesDePrix(grilleDePrixVehicule);
        remplissageGrillesDePrix(grilleDePrixCircuit);
        remplissageGrillesDePrix(grilleDePrixPilote);
        stageHUD();
        changeTextureForEditeurImages();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        update();
        draw();
        debugLog();
        stage.act();
        suiteMenuGeneralButtonsMouvements();
        fichePilotesGroup.setPosition(viewport.getWorldWidth() / 4 - ficheFond.getWidth() / 1.5f + fichesPiloteMover * 100,
                viewport.getWorldHeight() / 2 - ficheFond.getHeight() / 4);
        ficheVehiculesGroup.setPosition(viewport.getWorldWidth() / 2 - ficheFond.getWidth() / 4,
                viewport.getWorldHeight() / 4 - ficheFond.getHeight() / 1.5f + fichesVehiculeMover * 60);
        ficheCircuitGroup.setPosition(viewport.getWorldWidth() / 4 + ficheFond.getWidth() / 2.5f - fichesCircuitMover * 96.9f,
                viewport.getWorldHeight() / 2 - ficheFond.getHeight() / 4);
        ficheCompteGroup.setPosition(viewport.getWorldWidth() / 2 - ficheCompte.getWidth() / 4,
                viewport.getWorldHeight() / 2 + ficheCompte.getHeight() / 4 - fichesCompteMover * 55.5f);
        if (mtcGame.getPrefs().getInteger("money") != 0) {
            compteLabel.setText("\n " + mtcGame.getTrad().getFicheComptePart1() + mtcGame.getPrefs().getInteger("money") + " $");
        } else {
            compteLabel.setText("\n " + mtcGame.getTrad().getFicheComptePart1() + "0" + " $");
        }
        prixDAchatLabel.setText("     = " + montantAchat + " $");
        manqueArgentLabel.setText(mtcGame.getTrad().getManqueArgent() + "\n" + "       " + (soldeToutCompte - (soldeToutCompte * 2)) + " $");
        boutonCompteLabel.setText(mtcGame.getPrefs().getInteger("money") + " $");
        argentMaxLabel.setText(" " + mtcGame.getTrad().getFicheComptePart11() + mtcGame.getPrefs().getInteger("argentMax") + " $");
        nbTropheeRoueLabel.setText(" " + mtcGame.getTrad().getFicheComptePart3() + mtcGame.getPrefs().getInteger("nbTropheeRoue"));
        nbTropheeDollarLabel.setText(" " + mtcGame.getTrad().getFicheComptePart5() + mtcGame.getPrefs().getInteger("nbTropheeDollar"));
        nbTropheeBonusLabel.setText(" " + mtcGame.getTrad().getFicheComptePart8() + mtcGame.getPrefs().getInteger("nbTropheeBonus"));
        timerDecompteLabel.setText(timeToStringConvert(
                (mtcGame.getPrefs().getLong("VVLimitTimeStart") + mtcGame.getPeriodBeforeNewVideos()) - timeElapsing));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
    }

    public void update() {
        unloader();

        moveMenuGeneralButtons();
        moveMenuBoutiqueColonnePilote();
        moveMenuBoutiqueColonneVehicule();
        moveMenuBoutiqueColonneCircuit();
        movefichesPiloteGroup();
        movefichesVehiculeGroup();
        movefichesCircuitGroup();
        movefichesCompteGroup();
        changeParentBoutonsGroup(menuPiloteGroup, menuBoutiqueBoutonsPiloteGroup,
                menuPiloteReceptionBoutonsPiloteGroup, menuBoutiqueReceptionBoutonsPiloteGroup);
        changeParentBoutonsGroup(menuVehiculesGroup, menuBoutiqueBoutonsVehiculeGroup,
                menuVehiculesReceptionBoutonsVehiculesGroup, menuBoutiqueReceptionBoutonsVehiculesGroup);
        changeParentBoutonsGroup(menuCircuitGroup, menuBoutiqueBoutonsCircuitGroup,
                menuCircuitReceptionBoutonsCircuitGroup, menuBoutiqueReceptionBoutonsCircuitGroup);
        changeParentCadenasGroup();
        cadenasPositionnerViewer();
        checkImagePositionUpdater();
        changeParentBoutonsDirectionsGroup();
        boutonsDirectionsPositionner();
        positionner(menuPiloteGroup, arrayBoutonsPilote);
        positionner(menuVehiculesGroup, arrayBoutonsVehicule);
        positionner(menuCircuitGroup, arrayBoutonsCircuit);
        scrollMenuChoixBoutonGroup(menuVehiculesGroup, menuVehiculesReceptionBoutonsVehiculesGroup);
        scrollMenuChoixBoutonGroup(menuPiloteGroup, menuPiloteReceptionBoutonsPiloteGroup);
        scrollMenuChoixBoutonGroup(menuCircuitGroup, menuCircuitReceptionBoutonsCircuitGroup);
        savePaidPreferences();
        soldeDuCompte();
        moveColonneRoues();
        moveColonneChassis();
        moveRangeeMoteurs();
        customVehiculeBouton();
        if (mtcGame.getGoogleServices() != null) {
            videoViewedToggleBool();
            viewedVideosPerDayLimiter();
        }
        popUpTimerVisibiliteTimer();
        popUpWifiVisibiliteTimer();
    }

    public void clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void draw() {
        batch.setProjectionMatrix(camera.projection);
        batch.setTransformMatrix(camera.view);
        batch.begin();
        batch.end();
    }

    private void unloader() {
        if (assetsToUnload != null) {
            for (String string : assetsToUnload) {
                if (mtcGame.getAssetManager().isLoaded(string)) {
                    mtcGame.getAssetManager().unload(string);
                    assetsToUnload.removeValue(string, true);
                }
            }
            mtcGame.getAssetManager().update();
        }
    }

    /**
     * création TEXTURE dans MENU ATELIER
     */
    private void createImagesEditeurTexture() {
        // roue
        choixRoue = mtcGame.getPrefs().getInteger("vehiculeRoueCustomImage");
        if (choixRoue == 0) {
            roueEditeurImageTexture = textureAtlas.findRegion("empty");
        }
        if (choixRoue == 100) {
            roueEditeurImageTexture = textureAtlas.findRegion("sansPermis_wheel");
        }
        if (choixRoue == 200) {
            roueEditeurImageTexture = textureAtlas.findRegion("pourrie_wheel");
        }
        if (choixRoue == 300) {
            roueEditeurImageTexture = textureAtlas.findRegion("berline_wheel");
        }
        if (choixRoue == 400) {
            roueEditeurImageTexture = textureAtlas.findRegion("GT_wheel");
        }
        if (choixRoue == 500) {
            roueEditeurImageTexture = textureAtlas.findRegion("luxe_wheel");
        }
        if (choixRoue == 600) {
            roueEditeurImageTexture = textureAtlas.findRegion("decapotable_wheel");
        }
        if (choixRoue == 700) {
            roueEditeurImageTexture = textureAtlas.findRegion("legende_wheel");
        }
        if (choixRoue == 800) {
            roueEditeurImageTexture = textureAtlas.findRegion("pickup_wheel");
        }
        if (choixRoue == 900) {
            roueEditeurImageTexture = textureAtlas.findRegion("camionette_wheel");
        }
        if (choixRoue == 1000) {
            roueEditeurImageTexture = textureAtlas.findRegion("4X4_wheel");
        }
        if (choixRoue == 1100) {
            roueEditeurImageTexture = textureAtlas.findRegion("camion_wheel");
        }
        if (choixRoue == 1200) {
            roueEditeurImageTexture = textureAtlas.findRegion("chantier_wheel");
        }

        // moteur
        choixMoteur = mtcGame.getPrefs().getInteger("vehiculeMoteurCustomImage");
        if (choixMoteur == 0) {
            moteurEditeurImageTexture = textureAtlas.findRegion("empty");
        }
        if (choixMoteur == 101) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-1-normal");
        }
        if (choixMoteur == 201) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-2-normal");
        }
        if (choixMoteur == 301) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-3-normal");
        }
        if (choixMoteur == 401) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-4-normal");
        }
        if (choixMoteur == 501) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-5-normal");
        }
        if (choixMoteur == 601) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-6-normal");
        }
        if (choixMoteur == 701) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-7-normal");
        }
        if (choixMoteur == 801) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-8-normal");
        }
        if (choixMoteur == 901) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-9-normal");
        }
        if (choixMoteur == 1001) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-10-normal");
        }
        if (choixMoteur == 1101) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-11-normal");
        }
        if (choixMoteur == 1201) {
            moteurEditeurImageTexture = textureAtlas.findRegion("Menu-Atelier-bouton-moteur-12-normal");
        }


        // chassis
        choixChassis = mtcGame.getPrefs().getInteger("vehiculeChassisCustomImage");
        if (choixChassis == 0) {
            chassisEditeurImageTexture = textureAtlas.findRegion("empty");
        }
        if (choixChassis == 102) {
            chassisEditeurImageTexture = textureAtlas.findRegion("sansPermis_chassis");
        }
        if (choixChassis == 202) {
            chassisEditeurImageTexture = textureAtlas.findRegion("pourrie_chassis");
        }
        if (choixChassis == 302) {
            chassisEditeurImageTexture = textureAtlas.findRegion("berline_chassis");
        }
        if (choixChassis == 402) {
            chassisEditeurImageTexture = textureAtlas.findRegion("GT_chassis");
        }
        if (choixChassis == 502) {
            chassisEditeurImageTexture = textureAtlas.findRegion("luxe_chassis");
        }
        if (choixChassis == 602) {
            chassisEditeurImageTexture = textureAtlas.findRegion("decapotable_chassis");
        }
        if (choixChassis == 702) {
            chassisEditeurImageTexture = textureAtlas.findRegion("legende_chassis");
        }
        if (choixChassis == 802) {
            chassisEditeurImageTexture = textureAtlas.findRegion("pickup_chassis");
        }
        if (choixChassis == 902) {
            chassisEditeurImageTexture = textureAtlas.findRegion("camionette_chassis");
        }
        if (choixChassis == 1002) {
            chassisEditeurImageTexture = textureAtlas.findRegion("4X4_chassis");
        }
        if (choixChassis == 1102) {
            chassisEditeurImageTexture = textureAtlas.findRegion("camion_chassis");
        }
        if (choixChassis == 1202) {
            chassisEditeurImageTexture = textureAtlas.findRegion("chantier_chassis");
        }
    }

    /**
     * changement TEXTURE dans MENU ATELIER
     */
    private void changeTextureForEditeurImages() {
        createImagesEditeurTexture();
        imagesEditeurGroup.removeActor(roueLeftEditeurImage);
        imagesEditeurGroup.removeActor(roueRightEditeurImage);
        imagesEditeurGroup.removeActor(chassisEditeurImage);
        imagesEditeurGroup.removeActor(moteurEditeurImage);

        roueLeftEditeurImage.remove();
        roueRightEditeurImage.remove();
        chassisEditeurImage.remove();
        moteurEditeurImage.remove();

        roueLeftEditeurImage = new Image(roueEditeurImageTexture);
        roueRightEditeurImage = new Image(roueEditeurImageTexture);
        chassisEditeurImage = new Image(chassisEditeurImageTexture);
        moteurEditeurImage = new Image(moteurEditeurImageTexture);

        if (chassisEditeurImage != null) {
            if (choixChassis == 402) {
                chassisEditeurImage.setPosition(viewport.getWorldWidth() / 1.75f - chassisEditeurImage.getWidth() / 2,
                        viewport.getWorldHeight() / 1.95f - chassisEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 202 || choixChassis == 102 || choixChassis == 602) {
                chassisEditeurImage.setPosition(viewport.getWorldWidth() / 1.75f - chassisEditeurImage.getWidth() / 2,
                        viewport.getWorldHeight() / 1.95f - chassisEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 502) {
                chassisEditeurImage.setPosition(viewport.getWorldWidth() / 1.75f - chassisEditeurImage.getWidth() / 2.65f,
                        viewport.getWorldHeight() / 1.7f - chassisEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 1202) {
                chassisEditeurImage.setPosition(viewport.getWorldWidth() / 1.75f - chassisEditeurImage.getWidth() / 2.3f,
                        viewport.getWorldHeight() / 1.6f - chassisEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 1002) {
                chassisEditeurImage.setPosition(viewport.getWorldWidth() / 1.75f - chassisEditeurImage.getWidth() / 2.1f,
                        viewport.getWorldHeight() / 1.8f - chassisEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 1102) {
                chassisEditeurImage.setPosition(viewport.getWorldWidth() / 1.75f - chassisEditeurImage.getWidth() / 2.35f,
                        viewport.getWorldHeight() / 1.8f - chassisEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 802 || choixChassis == 902 || choixChassis == 302 || choixChassis == 702 || choixChassis == 0) {
                chassisEditeurImage.setPosition(viewport.getWorldWidth() / 1.75f - chassisEditeurImage.getWidth() / 2,
                        viewport.getWorldHeight() / 1.8f - chassisEditeurImage.getHeight() / 2);
            }
            chassisEditeurImage.setScale(0.65f);
            stage.addActor(chassisEditeurImage);
            imagesEditeurGroup.addActor(chassisEditeurImage);
        }

        if (roueLeftEditeurImage != null) {
            if (choixChassis == 202) {
                roueLeftEditeurImage.setPosition(viewport.getWorldWidth() / 2.55f - roueLeftEditeurImage.getWidth() / 3.1f,
                        viewport.getWorldHeight() / 2.6f - roueLeftEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 502) {
                roueLeftEditeurImage.setPosition(viewport.getWorldWidth() / 2.55f - roueLeftEditeurImage.getWidth() / 1.8f,
                        viewport.getWorldHeight() / 2.6f - roueLeftEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 1202) {
                roueLeftEditeurImage.setPosition(viewport.getWorldWidth() / 2.55f - roueLeftEditeurImage.getWidth() / 2.4f,
                        viewport.getWorldHeight() / 2.6f - roueLeftEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 1002) {
                roueLeftEditeurImage.setPosition(viewport.getWorldWidth() / 2.55f - roueLeftEditeurImage.getWidth() / 3.1f,
                        viewport.getWorldHeight() / 2.6f - roueLeftEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 1102) {
                roueLeftEditeurImage.setPosition(viewport.getWorldWidth() / 2.55f - roueLeftEditeurImage.getWidth() / 3f,
                        viewport.getWorldHeight() / 2.6f - roueLeftEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 102) {
                roueLeftEditeurImage.setPosition(viewport.getWorldWidth() / 2.55f - roueLeftEditeurImage.getWidth() / 3.8f,
                        viewport.getWorldHeight() / 2.6f - roueLeftEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 802 || choixChassis == 402 || choixChassis == 902 || choixChassis == 302 || choixChassis == 702 || choixChassis == 602 || choixChassis == 0) {
                roueLeftEditeurImage.setPosition(viewport.getWorldWidth() / 2.55f - roueLeftEditeurImage.getWidth() / 2.6f,
                        viewport.getWorldHeight() / 2.6f - roueLeftEditeurImage.getHeight() / 2);
            }
            roueLeftEditeurImage.setScale(0.65f);
            stage.addActor(roueLeftEditeurImage);
            imagesEditeurGroup.addActor(roueLeftEditeurImage);
        }
        if (roueRightEditeurImage != null) {
            if (choixChassis == 202 || choixChassis == 102) {
                roueRightEditeurImage.setPosition(viewport.getWorldWidth() / 1.5f - roueRightEditeurImage.getWidth() / 1.7f,
                        viewport.getWorldHeight() / 2.6f - roueRightEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 502) {
                roueRightEditeurImage.setPosition(viewport.getWorldWidth() / 1.5f - roueRightEditeurImage.getWidth() / 5f,
                        viewport.getWorldHeight() / 2.6f - roueRightEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 1202) {
                roueRightEditeurImage.setPosition(viewport.getWorldWidth() / 1.5f - roueRightEditeurImage.getWidth() / 2.4f,
                        viewport.getWorldHeight() / 2.6f - roueRightEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 1002) {
                roueRightEditeurImage.setPosition(viewport.getWorldWidth() / 1.5f - roueRightEditeurImage.getWidth() / 1.7f,
                        viewport.getWorldHeight() / 2.6f - roueRightEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 1102) {
                roueRightEditeurImage.setPosition(viewport.getWorldWidth() / 1.5f - roueRightEditeurImage.getWidth() / 2f,
                        viewport.getWorldHeight() / 2.6f - roueRightEditeurImage.getHeight() / 2);
            }
            if (choixChassis == 802 || choixChassis == 402 || choixChassis == 902 || choixChassis == 302 || choixChassis == 702 || choixChassis == 602 || choixChassis == 0) {
                roueRightEditeurImage.setPosition(viewport.getWorldWidth() / 1.5f - roueRightEditeurImage.getWidth() / 1.6f,
                        viewport.getWorldHeight() / 2.6f - roueRightEditeurImage.getHeight() / 2);
            }
            roueRightEditeurImage.setScale(0.65f);
            stage.addActor(roueRightEditeurImage);
            imagesEditeurGroup.addActor(roueRightEditeurImage);
        }

        if (moteurEditeurImage != null) {
            moteurEditeurImage.setPosition(viewport.getWorldWidth() / 1.2f - moteurEditeurImage.getWidth() / 2,
                    viewport.getWorldHeight() / 1.2f - moteurEditeurImage.getHeight() / 2);
            moteurEditeurImage.setScale(0.35f);
            stage.addActor(moteurEditeurImage);
            imagesEditeurGroup.addActor(moteurEditeurImage);
        }
    }

    /**
     * création TEXTURE des sous boutons dans MENU GENERAL
     */
    private TextureRegion createSousBoutonPiloteTexture() {
        TextureRegion sousBoutonPiloteTex = new TextureRegion();
        // roue
        int choixSBPilote = mtcGame.getPrefs().getInteger("headChoice");
        if (choixSBPilote == 0) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-1");
        }
        if (choixSBPilote == 1) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-2");
        }
        if (choixSBPilote == 2) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-3");
        }
        if (choixSBPilote == 3) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-4");
        }
        if (choixSBPilote == 4) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-5");
        }
        if (choixSBPilote == 5) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-6");
        }
        if (choixSBPilote == 6) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-7");
        }
        if (choixSBPilote == 7) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-8");
        }
        if (choixSBPilote == 8) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-9");
        }
        if (choixSBPilote == 9) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-10");
        }
        if (choixSBPilote == 10) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-11");
        }
        if (choixSBPilote == 11) {
            sousBoutonPiloteTex = textureAtlas.findRegion("Menu-General-sous-Bouton-pilote-12");
        }
        return sousBoutonPiloteTex;
    }

    private TextureRegion createSousBoutonVehiculeTexture() {
        TextureRegion sousBoutonVehiculeTex = new TextureRegion();
        // roue
        int choixSBPilote = mtcGame.getPrefs().getInteger("vehiculeChoice");
        if (choixSBPilote == 0) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-1");
        }
        if (choixSBPilote == 1) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-2");
        }
        if (choixSBPilote == 2) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-3");
        }
        if (choixSBPilote == 3) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-4");
        }
        if (choixSBPilote == 4) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-5");
        }
        if (choixSBPilote == 5) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-6");
        }
        if (choixSBPilote == 6) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-7");
        }
        if (choixSBPilote == 7) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-8");
        }
        if (choixSBPilote == 8) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-9");
        }
        if (choixSBPilote == 9) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-10");
        }
        if (choixSBPilote == 10) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-11");
        }
        if (choixSBPilote == 11) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-12");
        }
        if (choixSBPilote == 12) {
            sousBoutonVehiculeTex = textureAtlas.findRegion("Menu-General-sous-Bouton-vehicule-13");
        }
        return sousBoutonVehiculeTex;
    }

    private TextureRegion createSousBoutonCircuitTexture() {
        TextureRegion sousBoutonCircuitTex = new TextureRegion();
        // roue
        int choixSBPilote = mtcGame.getPrefs().getInteger("groundChoice");
        if (choixSBPilote == 0) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-1");
        }
        if (choixSBPilote == 1) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-2");
        }
        if (choixSBPilote == 2) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-3");
        }
        if (choixSBPilote == 3) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-4");
        }
        if (choixSBPilote == 4) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-5");
        }
        if (choixSBPilote == 5) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-6");
        }
        if (choixSBPilote == 6) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-7");
        }
        if (choixSBPilote == 7) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-8");
        }
        if (choixSBPilote == 8) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-9");
        }
        if (choixSBPilote == 9) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-10");
        }
        if (choixSBPilote == 10) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-11");
        }
        if (choixSBPilote == 11) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-12");
        }
        if (choixSBPilote == 12) {
            sousBoutonCircuitTex = textureAtlas.findRegion("Menu-General-sous-Bouton-circuit-13");
        }
        return sousBoutonCircuitTex;
    }

    /**
     * changement TEXTURE des sous boutons dans MENU GENERAL
     * @param imageButton
     */
    private void changeSousBoutonTexture(ImageButton imageButton) {
        if (arrayBoutonsPilote.contains(imageButton, true)) {
            if (sousBoutonPilote != null) {
                boutonPiloteGroup.removeActor(boutonMenuPilote);
//                boutonPiloteGroup.removeActor(boutonPiloteLabel);
                boutonPiloteGroup.removeActor(sousBoutonPilote);
                sousBoutonPilote.remove();
            }

            sousBoutonPilote = new Image(createSousBoutonPiloteTexture());
            stage.addActor(sousBoutonPilote);
            boutonPiloteGroup.addActor(sousBoutonPilote);
//            boutonPiloteGroup.addActor(boutonPiloteLabel);
            boutonPiloteGroup.addActor(boutonMenuPilote);
        }
        if (arrayBoutonsVehicule.contains(imageButton, true)) {
            if (sousBoutonVehicule != null) {
                boutonVehiculeGroup.removeActor(boutonMenuVehicules);
//                boutonVehiculeGroup.removeActor(boutonVehiculeLabel);
                boutonVehiculeGroup.removeActor(sousBoutonVehicule);
                sousBoutonVehicule.remove();
            }

            sousBoutonVehicule = new Image(createSousBoutonVehiculeTexture());
            stage.addActor(sousBoutonVehicule);
            boutonVehiculeGroup.addActor(sousBoutonVehicule);
//            boutonVehiculeGroup.addActor(boutonVehiculeLabel);
            boutonVehiculeGroup.addActor(boutonMenuVehicules);
        }
        if (arrayBoutonsCircuit.contains(imageButton, true)) {
            if (sousBoutonCircuit != null) {
                boutonCircuitGroup.removeActor(boutonMenuCircuit);
//                boutonCircuitGroup.removeActor(boutonCircuitLabel);
                boutonCircuitGroup.removeActor(sousBoutonCircuit);
                sousBoutonCircuit.remove();
            }

            sousBoutonCircuit = new Image(createSousBoutonCircuitTexture());
            stage.addActor(sousBoutonCircuit);
            boutonCircuitGroup.addActor(sousBoutonCircuit);
//            boutonCircuitGroup.addActor(boutonCircuitLabel);
            boutonCircuitGroup.addActor(boutonMenuCircuit);
        }
    }

    /**
     * création et changement TEXTURES et TEXTES des FICHES
     *
     * @return
     */
    private void createFicheElements(ImageButton imageButton) {
        // ficheFond Pilote
        if (arrayBoutonsPilote.contains(imageButton, true)) {
            ficheFondTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-fond");
            ficheNomLabel.setColor(Color.SALMON);
            int choixFichePilote = Integer.parseInt(imageButton.getUserObject().toString());
            if (choixFichePilote == 0) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-1");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-1");
                ficheNomString = "SurfHunter";
                ficheTextString = mtcGame.getTrad().getFichePilote1();
            }
            if (choixFichePilote == 1) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-2");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-2");
                ficheNomString = "SheepEater";
                ficheTextString = mtcGame.getTrad().getFichePilote2();
            }
            if (choixFichePilote == 2) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-3");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-3");
                ficheNomString = "LizardKing";
                ficheTextString = mtcGame.getTrad().getFichePilote3();
            }
            if (choixFichePilote == 3) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-4");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-4");
                ficheNomString = "MedievalV8";
                ficheTextString = mtcGame.getTrad().getFichePilote4();
            }
            if (choixFichePilote == 4) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-5");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-5");
                ficheNomString = "MegaNose";
                ficheTextString = mtcGame.getTrad().getFichePilote5();
            }
            if (choixFichePilote == 5) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-6");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-6");
                ficheNomString = "HumanBros";
                ficheTextString = mtcGame.getTrad().getFichePilote6();
            }
            if (choixFichePilote == 6) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-7");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-7");
                ficheNomString = "SlowTank";
                ficheTextString = mtcGame.getTrad().getFichePilote7();
            }
            if (choixFichePilote == 7) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-8");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-8");
                ficheNomString = "BikerTattoo";
                ficheTextString = mtcGame.getTrad().getFichePilote8();
            }
            if (choixFichePilote == 8) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-9");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-9");
                ficheNomString = "JungleCrooner";
                ficheTextString = mtcGame.getTrad().getFichePilote9();
            }
            if (choixFichePilote == 9) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-10");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-10");
                ficheNomString = "ChickenChief";
                ficheTextString = mtcGame.getTrad().getFichePilote10();
            }
            if (choixFichePilote == 10) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-11");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-11");
                ficheNomString = "HandBag";
                ficheTextString = mtcGame.getTrad().getFichePilote11();
            }
            if (choixFichePilote == 11) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-pilote-12");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-pilote-12");
                ficheNomString = "GrizGriz'";
                ficheTextString = mtcGame.getTrad().getFichePilote12();
            }
        }
        if (arrayBoutonsVehicule.contains(imageButton, true) || arrayBoutonRouesVehicules.contains(imageButton, true) ||
                arrayBoutonChassisVehicules.contains(imageButton, true) || arrayBoutonMoteurVehicules.contains(imageButton, true)) {
            ficheFondTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-fond");
            ficheNomLabel.setColor(Color.CYAN);
            int choixFicheVehicule = Integer.parseInt(imageButton.getUserObject().toString());
            if (choixFicheVehicule == 0) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-1");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-1");
                ficheNomString = "YoghurtPot";
                ficheTextString = mtcGame.getTrad().getFicheVehicule1();
            }
            if (choixFicheVehicule == 1) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-2");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-2");
                ficheNomString = "RollingTrashCan";
                ficheTextString = mtcGame.getTrad().getFicheVehicule2();
            }
            if (choixFicheVehicule == 2) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-3");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-3");
                ficheNomString = "MonsterRookie";
                ficheTextString = mtcGame.getTrad().getFicheVehicule3();
            }
            if (choixFicheVehicule == 3) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-4");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-4");
                ficheNomString = "GubattiSmasher";
                ficheTextString = mtcGame.getTrad().getFicheVehicule4();
            }
            if (choixFicheVehicule == 4) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-5");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-5");
                ficheNomString = "ThunderLimo";
                ficheTextString = mtcGame.getTrad().getFicheVehicule5();
            }
            if (choixFicheVehicule == 5) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-6");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-6");
                ficheNomString = "ElegantDestroyer";
                ficheTextString = mtcGame.getTrad().getFicheVehicule6();
            }
            if (choixFicheVehicule == 6) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-7");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-7");
                ficheNomString = "OldTimerDanger";
                ficheTextString = mtcGame.getTrad().getFicheVehicule7();
            }
            if (choixFicheVehicule == 7) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-8");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-8");
                ficheNomString = "CountryBoss";
                ficheTextString = mtcGame.getTrad().getFicheVehicule8();
            }
            if (choixFicheVehicule == 8) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-9");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-9");
                ficheNomString = "BeachDevourer";
                ficheTextString = mtcGame.getTrad().getFicheVehicule9();
            }
            if (choixFicheVehicule == 9) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-10");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-10");
                ficheNomString = "HillRuler";
                ficheTextString = mtcGame.getTrad().getFicheVehicule10();
            }
            if (choixFicheVehicule == 10) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-11");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-11");
                ficheNomString = "RoadMaster";
                ficheTextString = mtcGame.getTrad().getFicheVehicule11();
            }
            if (choixFicheVehicule == 11) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-vehicule-12");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-vehicule-12");
                ficheNomString = "EarthQuaker";
                ficheTextString = mtcGame.getTrad().getFicheVehicule12();
            }
        }
        if (arrayBoutonsCircuit.contains(imageButton, true)) {
            ficheFondTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-fond");
            ficheNomLabel.setColor(Color.ORANGE);
            int choixFicheCircuit = Integer.parseInt(imageButton.getUserObject().toString());
            if (choixFicheCircuit == 0) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-1");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-1");
                ficheNomString = "RockMountain";
                ficheTextString = mtcGame.getTrad().getFicheCircuit1();
            }
            if (choixFicheCircuit == 1) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-2");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-2");
                ficheNomString = "Desert";
                ficheTextString = mtcGame.getTrad().getFicheCircuit2();
            }
            if (choixFicheCircuit == 2) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-3");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-3");
                ficheNomString = "Moon";
                ficheTextString = mtcGame.getTrad().getFicheCircuit3();
            }
            if (choixFicheCircuit == 3) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-4");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-4");
                ficheNomString = "Woods";
                ficheTextString = mtcGame.getTrad().getFicheCircuit4();
            }
            if (choixFicheCircuit == 4) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-5");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-5");
                ficheNomString = "Amazon";
                ficheTextString = mtcGame.getTrad().getFicheCircuit5();
            }
            if (choixFicheCircuit == 5) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-6");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-6");
                ficheNomString = "Archipelago";
                ficheTextString = mtcGame.getTrad().getFicheCircuit6();
            }
            if (choixFicheCircuit == 6) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-7");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-7");
                ficheNomString = "Metropolis";
                ficheTextString = mtcGame.getTrad().getFicheCircuit7();
            }
            if (choixFicheCircuit == 7) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-8");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-8");
                ficheNomString = "CountrySide";
                ficheTextString = mtcGame.getTrad().getFicheCircuit8();
            }
            if (choixFicheCircuit == 8) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-9");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-9");
                ficheNomString = "Abyss";
                ficheTextString = mtcGame.getTrad().getFicheCircuit9();
            }
            if (choixFicheCircuit == 9) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-10");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-10");
                ficheNomString = "LittleTown";
                ficheTextString = mtcGame.getTrad().getFicheCircuit10();
            }
            if (choixFicheCircuit == 10) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-11");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-11");
                ficheNomString = "IceLand";
                ficheTextString = mtcGame.getTrad().getFicheCircuit11();
            }
            if (choixFicheCircuit == 11) {
                ficheImageTex = textureAtlas.findRegion("Menu-Boutique-fiche-circuit-12");
                ficheDescriptionTex = textureAtlas.findRegion("fiche-image-description-circuit-12");
                ficheNomString = "TrashPlace";
                ficheTextString = mtcGame.getTrad().getFicheCircuit12();
            }
        }
    }

    /**
     * Création de fiche décrivant un perso, un véhicule, un circuit
     * @param imageButton
     */
    private void createFiche(ImageButton imageButton) {
        ficheGroup.removeActor(ficheNomLabel);
        ficheGroup.removeActor(ficheTextLabel);
        ficheGroup.removeActor(ficheImage);
        ficheGroup.removeActor(ficheDescr);
        ficheGroup.removeActor(ficheFond);
        ficheFond.remove();

        createFicheElements(imageButton);
        ficheFond = new Image(ficheFondTex);
        stage.addActor(ficheFond);
        ficheImage = new Image(ficheImageTex);
        if (arrayBoutonsPilote.contains(imageButton, true)) {
            ficheImage.setPosition(ficheFond.getWidth() / 4.5f - ficheImage.getWidth() / 2, ficheFond.getHeight() / 2.3f - ficheImage.getHeight() / 2);
        } else {
            ficheImage.setPosition(ficheFond.getWidth() / 4.3f - ficheImage.getWidth() / 2, ficheFond.getHeight() / 2.2f - ficheImage.getHeight() / 2);
        }
        stage.addActor(ficheImage);
        ficheDescr = new Image(ficheDescriptionTex);
        stage.addActor(ficheDescr);
        ficheNomLabel.setText(ficheNomString);
        ficheTextLabel.setText(ficheTextString);
        if (toSellPiloteList.contains(imageButton, true) || toSellVehiculeList.contains(imageButton, true)
                || toSellCircuitList.contains(imageButton, true)) {
            ficheDescr.setPosition(ficheFond.getWidth() / 1.5f - ficheDescr.getWidth() / 2, ficheFond.getHeight() / 3f - ficheDescr.getHeight() / 2);
            ficheTextLabel.setPosition(ficheFond.getWidth() / 2.25f - ficheTextLabel.getWidth(), ficheFond.getHeight() / 1.5f - ficheNomLabel.getHeight() / 2);
        } else {
            ficheDescr.setPosition(ficheFond.getWidth() / 1.5f - ficheDescr.getWidth() / 2, ficheFond.getHeight() / 6f - ficheDescr.getHeight() / 2);
            ficheTextLabel.setPosition(ficheFond.getWidth() / 2.25f - ficheTextLabel.getWidth(), ficheFond.getHeight() / 1.8f - ficheNomLabel.getHeight() / 2);
        }
        ficheGroup.addActor(ficheFond);
        ficheGroup.addActor(ficheImage);
        ficheGroup.addActor(ficheDescr);
        ficheGroup.addActor(ficheNomLabel);
        ficheGroup.addActor(ficheTextLabel);
    }

    private void changeFicheTexture(ImageButton imageButton) {
        if (arrayBoutonsPilote.contains(imageButton, true)) {
            fichePilotesGroup.removeActor(boutonAchatGroup);
            fichePilotesGroup.removeActor(ficheGroup);
            createFiche(imageButton);
            fichePilotesGroup.addActor(ficheGroup);
            fichePilotesGroup.addActor(boutonAchatGroup);
        }
        if (arrayBoutonsVehicule.contains(imageButton, true) || arrayBoutonRouesVehicules.contains(imageButton, true) ||
                arrayBoutonChassisVehicules.contains(imageButton, true) || arrayBoutonMoteurVehicules.contains(imageButton, true)) {
            ficheVehiculesGroup.removeActor(boutonAchatGroup);
            ficheVehiculesGroup.removeActor(ficheGroup);
            createFiche(imageButton);
            ficheVehiculesGroup.addActor(ficheGroup);
            ficheVehiculesGroup.addActor(boutonAchatGroup);
        }
        if (arrayBoutonsCircuit.contains(imageButton, true)) {
            ficheCircuitGroup.removeActor(boutonAchatGroup);
            ficheCircuitGroup.removeActor(ficheGroup);
            createFiche(imageButton);
            ficheCircuitGroup.addActor(ficheGroup);
            ficheCircuitGroup.addActor(boutonAchatGroup);
        }
    }

    private void customVehiculeBouton() {
        if (mtcGame.getPrefs().getBoolean("customVehicule")) {
            arrayBoutonsVehicule.add(boutonVehicule13);
            menuVehiculesReceptionBoutonsVehiculesGroup.addActor(boutonVehicule13);
        } else {
            arrayBoutonsVehicule.removeValue(boutonVehicule13, true);
            menuVehiculesReceptionBoutonsVehiculesGroup.removeActor(boutonVehicule13);
        }
    }

    private void remplissageGrillesDePrix(int[] ints) {
        if (ints == grilleDePrixVehicule) {
            for (int k = 0; k < ints.length; k++) {
                if (k > 0) {
                    ints[k] = ints[k - 1] + 7500;
                }
            }
        }
        if (ints == grilleDePrixCircuit) {
            for (int k = 0; k < ints.length; k++) {
                if (k > 0) {
                    ints[k] = ints[k - 1] + 5000;
                }
            }
        }
        if (ints == grilleDePrixPilote) {
            for (int k = 0; k < ints.length; k++) {
                if (k > 0) {
                    ints[k] = ints[k - 1] + 2500;
                }
            }
        }
    }

    private void movefichesPiloteGroup() {
        if (fichesPiloteBool) {
            if (fichesPiloteMover < 5) {
                fichesPiloteMover += 0.4f;
            }
        } else {
            if (fichesPiloteMover > 0) {
                fichesPiloteMover -= 0.4f;
            }
        }
    }

    private void movefichesVehiculeGroup() {
        if (fichesVehiculeBool) {
            if (fichesVehiculeMover < 5) {
                fichesVehiculeMover += 0.4f;
            }
        } else {
            if (fichesVehiculeMover > 0) {
                fichesVehiculeMover -= 0.4f;
            }
        }
    }

    private void movefichesCircuitGroup() {
        if (fichesCircuitBool) {
            if (fichesCircuitMover < 5) {
                fichesCircuitMover += 0.4f;
            }
        } else {
            if (fichesCircuitMover > 0) {
                fichesCircuitMover -= 0.4f;
            }
        }
    }

    private void movefichesCompteGroup() {
        if (fichesCompteBool) {
            if (fichesCompteMover < 5) {
                fichesCompteMover += 0.4f;
            }
        } else {
            if (fichesCompteMover > 0) {
                fichesCompteMover -= 0.4f;
            }
        }
    }

    private void moveMenuGeneralButtons() {
        if (buttonMoveBool) {
            if (buttonMover < 8.5f) {
                buttonMover += 0.35f;
            }
        }
        if (buttonMover > 8.5f) {
            buttonMoveBool = false;
            buttonMover = 0;
        }
    }


    private void suiteMenuGeneralButtonsMouvements() {
        if (buttonMover > 0) {
            boutonAtelierGroup.setPosition(viewport.getWorldWidth() / 1.25f - boutonMenuAtelier.getWidth() / 2.5f + buttonMover * 200,
                    viewport.getWorldHeight() + boutonMenuAtelier.getHeight());
        }
        if (buttonMover > 1.5f) {
            boutonBoutiqueGroup.setPosition(viewport.getWorldWidth() / 4 - boutonMenuBoutique.getWidth() / 2.67f,
                    viewport.getWorldHeight() / 4 - boutonMenuBoutique.getHeight() / 6f + (buttonMover * 200 - 300));
        }
        if (buttonMover > 2.2f) {
            boutonCircuitGroup.setPosition(viewport.getWorldWidth() - boutonMenuCircuit.getWidth() / 4f - (buttonMover * 200 - 440),
                    viewport.getWorldHeight() - boutonMenuCircuit.getHeight() * 2);
        }
        if (buttonMover > 3.3f) {
            boutonPiloteGroup.setPosition(viewport.getWorldWidth() / 2 + boutonMenuPilote.getWidth() * 2.38f,
                    viewport.getWorldHeight() / 2 - (buttonMover * 200 - 660));
        }
        if (buttonMover > 4.8f) {
            boutonVehiculeGroup.setPosition(viewport.getWorldWidth() / 4 + boutonMenuVehicules.getWidth() / 2.135f + (buttonMover * 200 - 960),
                    viewport.getWorldHeight() / 4 + boutonMenuVehicules.getHeight() / 4f);
        }
    }

    /**
     * MENUS CHOIX : Déplacement des boutons
     */
    private void scrollMenuChoixBoutonGroup(Group menuChoixGroup, Group menuChoixReceptionDuGroupeDeBoutonsGroup) {
        int maxOffset = 84;
        int minOffset = 0;
        if (menuChoixGroup.equals(menuVehiculesGroup) && mtcGame.getPrefs().getBoolean("customVehicule")) {
            maxOffset = 156;
            minOffset = -84;
        }
        if (menuChoixGroup.isVisible()) {
            if (scrollUpMenuChoixBoutonsGroupBool) {
                if (menuChoixReceptionDuGroupeDeBoutonsGroup.getY() < maxOffset) {
                    float futureScrollPos = menuChoixReceptionDuGroupeDeBoutonsGroup.getY() + 12;
                    menuChoixReceptionDuGroupeDeBoutonsGroup.setPosition(
                            menuChoixReceptionDuGroupeDeBoutonsGroup.getX(), futureScrollPos);
                    cadenasGroup.setPosition(menuChoixReceptionDuGroupeDeBoutonsGroup.getX(),
                            menuChoixReceptionDuGroupeDeBoutonsGroup.getY());
                }
            }
            if (menuChoixReceptionDuGroupeDeBoutonsGroup.getY() >= maxOffset) {
                scrollUpMenuChoixBoutonsGroupBool = false;
                boutonHautColonneVehicule.setVisible(false);
                boutonBasColonneVehicule.setVisible(true);
            }
            if (scrollDownMenuChoixBoutonsGroupBool) {
                if (menuChoixReceptionDuGroupeDeBoutonsGroup.getY() > minOffset) {
                    float futureScrollPos = menuChoixReceptionDuGroupeDeBoutonsGroup.getY() - 12;
                    menuChoixReceptionDuGroupeDeBoutonsGroup.setPosition(
                            menuChoixReceptionDuGroupeDeBoutonsGroup.getX(), futureScrollPos);
                    cadenasGroup.setPosition(menuChoixReceptionDuGroupeDeBoutonsGroup.getX(),
                            menuChoixReceptionDuGroupeDeBoutonsGroup.getY());
                }
            }
            if (menuChoixReceptionDuGroupeDeBoutonsGroup.getY() <= minOffset) {
                scrollDownMenuChoixBoutonsGroupBool = false;
                boutonBasColonneVehicule.setVisible(false);
                boutonHautColonneVehicule.setVisible(true);
            }
        }
    }

    /**
     * MENU ATELIER : Déplacement des colonnes et rangée
     */
    private void moveColonneRoues() {
        // creation de la future position
        if (futureUpPosColRouesBool && okUpdatePosColRoues || futureDownPosColRouesBool && okUpdatePosColRoues) {
            if (boutonsRouesVehiculesGroup.getY() < 754 && futureUpPosColRouesBool) {
                futurePosColRoues += 151;
                futureUpPosColRouesBool = false;
            }
            if (boutonsRouesVehiculesGroup.getY() > 150 && futureDownPosColRouesBool) {
                futurePosColRoues -= 151;
                futureDownPosColRouesBool = false;
            }
        }

        // déplacement de la colonne si différence entre position actuelle et future position
        if (boutonsRouesVehiculesGroup.getY() != futurePosColRoues) {
            okUpdatePosColRoues = false;
            // monte
            if (boutonsRouesVehiculesGroup.getY() < futurePosColRoues - 1) {
                boutonsRouesVehiculesGroup.setPosition(boutonsRouesVehiculesGroup.getX(),
                        boutonsRouesVehiculesGroup.getY() + 15.1f);
            }
            // descend
            if (boutonsRouesVehiculesGroup.getY() > futurePosColRoues + 1) {
                boutonsRouesVehiculesGroup.setPosition(boutonsRouesVehiculesGroup.getX(),
                        boutonsRouesVehiculesGroup.getY() - 15.1f);
            }
        }

        // réautorise nouvelle future position
        if (boutonsRouesVehiculesGroup.getY() <= futurePosColRoues &&
                boutonsRouesVehiculesGroup.getY() > futurePosColRoues - 0.05f) {
            okUpdatePosColRoues = true;
        }
        if (boutonsRouesVehiculesGroup.getY() >= futurePosColRoues &&
                boutonsRouesVehiculesGroup.getY() < futurePosColRoues + 0.05f) {
            okUpdatePosColRoues = true;
        }

        // visibilité bouton haut
        if (boutonsRouesVehiculesGroup.getY() < 754) {
            boutonUpColonneRoues.setVisible(true);
        } else {
            boutonUpColonneRoues.setVisible(false);
        }
        // visibilité boutons bas
        if (boutonsRouesVehiculesGroup.getY() > 150) {
            boutonDownColonneRoues.setVisible(true);
        } else {
            boutonDownColonneRoues.setVisible(false);
        }
    }

    private void moveColonneChassis() {
        // creation de la future position
        if (futureUpPosColChassisBool && okUpdatePosColChassis || futureDownPosColChassisBool && okUpdatePosColChassis) {
            if (boutonsChassisVehiculesGroup.getY() < 754 && futureUpPosColChassisBool) {
                futurePosColChassis += 151;
                futureUpPosColChassisBool = false;
            }
            if (boutonsChassisVehiculesGroup.getY() > 150 && futureDownPosColChassisBool) {
                futurePosColChassis -= 151;
                futureDownPosColChassisBool = false;
            }
        }

        // déplacement de la colonne si différence entre position actuelle et future position
        if (boutonsChassisVehiculesGroup.getY() != futurePosColChassis) {
            okUpdatePosColChassis = false;
            // monte
            if (boutonsChassisVehiculesGroup.getY() < futurePosColChassis - 1) {
                boutonsChassisVehiculesGroup.setPosition(boutonsChassisVehiculesGroup.getX(),
                        boutonsChassisVehiculesGroup.getY() + 15.1f);
            }
            // descend
            if (boutonsChassisVehiculesGroup.getY() > futurePosColChassis + 1) {
                boutonsChassisVehiculesGroup.setPosition(boutonsChassisVehiculesGroup.getX(),
                        boutonsChassisVehiculesGroup.getY() - 15.1f);
            }
        }

        // réautorise nouvelle future position
        if (boutonsChassisVehiculesGroup.getY() <= futurePosColChassis &&
                boutonsChassisVehiculesGroup.getY() > futurePosColChassis - 0.05f) {
            okUpdatePosColChassis = true;
        }
        if (boutonsChassisVehiculesGroup.getY() >= futurePosColChassis &&
                boutonsChassisVehiculesGroup.getY() < futurePosColChassis + 0.05f) {
            okUpdatePosColChassis = true;
        }

        // visibilité bouton haut
        if (boutonsChassisVehiculesGroup.getY() < 754) {
            boutonUpColonneChassis.setVisible(true);
        } else {
            boutonUpColonneChassis.setVisible(false);
        }
        // visibilité boutons bas
        if (boutonsChassisVehiculesGroup.getY() > 150) {
            boutonDownColonneChassis.setVisible(true);
        } else {
            boutonDownColonneChassis.setVisible(false);
        }
    }

    private void moveRangeeMoteurs() {
        // creation de la future position
        if (futureRightPosColMoteurBool && okUpdatePosColMoteur || futureLeftPosColMoteurBool && okUpdatePosColMoteur) {
            if (boutonsMoteurVehiculesGroup.getX() < 0 && futureRightPosColMoteurBool) {
                futurePosColMoteur += 240;
                futureRightPosColMoteurBool = false;
            }
            if (boutonsMoteurVehiculesGroup.getX() > -720 && futureLeftPosColMoteurBool) {
                futurePosColMoteur -= 240;
                futureLeftPosColMoteurBool = false;
            }
        }

        // déplacement de la colonne si différence entre position actuelle et future position
        if (boutonsMoteurVehiculesGroup.getX() != futurePosColMoteur) {
            okUpdatePosColMoteur = false;
            // vers la gauche
            if (boutonsMoteurVehiculesGroup.getX() < futurePosColMoteur - 1) {
                boutonsMoteurVehiculesGroup.setPosition(boutonsMoteurVehiculesGroup.getX() + 24,
                        boutonsMoteurVehiculesGroup.getY());
            }
            // vers la droite
            if (boutonsMoteurVehiculesGroup.getX() > futurePosColMoteur + 1) {
                boutonsMoteurVehiculesGroup.setPosition(boutonsMoteurVehiculesGroup.getX() - 24,
                        boutonsMoteurVehiculesGroup.getY());
            }
        }

        // réautorise nouvelle future position
        if (boutonsMoteurVehiculesGroup.getX() <= futurePosColMoteur &&
                boutonsMoteurVehiculesGroup.getX() > futurePosColMoteur - 0.5f) {
            okUpdatePosColMoteur = true;
        }
        if (boutonsMoteurVehiculesGroup.getX() >= futurePosColMoteur &&
                boutonsMoteurVehiculesGroup.getX() < futurePosColMoteur + 0.5f) {
            okUpdatePosColMoteur = true;
        }

        // visibilité bouton haut
        if (boutonsMoteurVehiculesGroup.getX() < 0) {
            boutonRightRangeeMoteur.setVisible(true);
        } else {
            boutonRightRangeeMoteur.setVisible(false);
        }
        // visibilité boutons bas
        if (boutonsMoteurVehiculesGroup.getX() > -720) {
            boutonLeftRangeeMoteur.setVisible(true);
        } else {
            boutonLeftRangeeMoteur.setVisible(false);
        }
    }

    /**
     * MENU BOUTIQUE : Déplacement des colonnes
     */
    private void moveMenuBoutiqueColonnePilote() {
        // création de la future position
        if (futureUpPositionColonneBool && okUpdatePositionColonne || futureDownPositionColonneBool && okUpdatePositionColonne) {
            if (menuBoutiqueReceptionBoutonsPiloteGroup.getY() < 1520 && futureUpPositionColonneBool) {
                futurePositionPiloteColonne += 152f;
                futureUpPositionColonneBool = false;
            }
            if (menuBoutiqueReceptionBoutonsPiloteGroup.getY() > 0 && futureDownPositionColonneBool) {
                futurePositionPiloteColonne -= 152f;
                futureDownPositionColonneBool = false;
            }
        }

        // déplacement de la colonne si différence entre position actuelle et future position
        if (menuBoutiqueReceptionBoutonsPiloteGroup.getY() != futurePositionPiloteColonne) {
            okUpdatePositionColonne = false;
            // monte
            if (menuBoutiqueReceptionBoutonsPiloteGroup.getY() < futurePositionPiloteColonne - 1) {
                menuBoutiqueReceptionBoutonsPiloteGroup.setPosition(menuBoutiqueReceptionBoutonsPiloteGroup.getX(),
                        menuBoutiqueReceptionBoutonsPiloteGroup.getY() + 15.2f);
            }
            // descend
            if (menuBoutiqueReceptionBoutonsPiloteGroup.getY() > futurePositionPiloteColonne + 1) {
                menuBoutiqueReceptionBoutonsPiloteGroup.setPosition(menuBoutiqueReceptionBoutonsPiloteGroup.getX(),
                        menuBoutiqueReceptionBoutonsPiloteGroup.getY() - 15.2f);
            }
        }

        // réautorise nouvelle future position
        if (menuBoutiqueReceptionBoutonsPiloteGroup.getY() <= futurePositionPiloteColonne &&
                menuBoutiqueReceptionBoutonsPiloteGroup.getY() > futurePositionPiloteColonne - 0.5f) {
            okUpdatePositionColonne = true;
        }
        if (menuBoutiqueReceptionBoutonsPiloteGroup.getY() >= futurePositionPiloteColonne &&
                menuBoutiqueReceptionBoutonsPiloteGroup.getY() < futurePositionPiloteColonne + 0.5f) {
            okUpdatePositionColonne = true;
        }

        // visibilité bouton haut
        if (menuBoutiqueReceptionBoutonsPiloteGroup.getY() < 1520) {
            boutonHautColonnePilote.setVisible(true);
        } else {
            boutonHautColonnePilote.setVisible(false);
        }
        // visibilité boutons bas
        if (menuBoutiqueReceptionBoutonsPiloteGroup.getY() > 0) {
            boutonBasColonnePilote.setVisible(true);
        } else {
            boutonBasColonnePilote.setVisible(false);
        }
    }

    private void moveMenuBoutiqueColonneVehicule() {
        // création de la future position
        if (futureUpPositionColonneVehiculeBool && okUpdatePositionVehiculeColonne || futureDownPositionColonneVehiculeBool && okUpdatePositionVehiculeColonne) {
            if (menuBoutiqueReceptionBoutonsVehiculesGroup.getY() < 1520 && futureUpPositionColonneVehiculeBool) {
                futurePositionVehiculeColonne += 152f;
                futureUpPositionColonneVehiculeBool = false;
            }
            if (menuBoutiqueReceptionBoutonsVehiculesGroup.getY() > 0 && futureDownPositionColonneVehiculeBool) {
                futurePositionVehiculeColonne -= 152f;
                futureDownPositionColonneVehiculeBool = false;
            }
        }

        // déplacement de la colonne si différence entre position actuelle et future position
        if (menuBoutiqueReceptionBoutonsVehiculesGroup.getY() != futurePositionVehiculeColonne) {
            okUpdatePositionVehiculeColonne = false;
            // monte
            if (menuBoutiqueReceptionBoutonsVehiculesGroup.getY() < futurePositionVehiculeColonne - 1) {
                menuBoutiqueReceptionBoutonsVehiculesGroup.setPosition(menuBoutiqueReceptionBoutonsVehiculesGroup.getX(),
                        menuBoutiqueReceptionBoutonsVehiculesGroup.getY() + 15.2f);
            }
            // descend
            if (menuBoutiqueReceptionBoutonsVehiculesGroup.getY() > futurePositionVehiculeColonne + 1) {
                menuBoutiqueReceptionBoutonsVehiculesGroup.setPosition(menuBoutiqueReceptionBoutonsVehiculesGroup.getX(),
                        menuBoutiqueReceptionBoutonsVehiculesGroup.getY() - 15.2f);
            }
        }

        // réautorise nouvelle future position
        if (menuBoutiqueReceptionBoutonsVehiculesGroup.getY() <= futurePositionVehiculeColonne &&
                menuBoutiqueReceptionBoutonsVehiculesGroup.getY() > futurePositionVehiculeColonne - 0.5f) {
            okUpdatePositionVehiculeColonne = true;
        }
        if (menuBoutiqueReceptionBoutonsVehiculesGroup.getY() >= futurePositionVehiculeColonne &&
                menuBoutiqueReceptionBoutonsVehiculesGroup.getY() < futurePositionVehiculeColonne + 0.5f) {
            okUpdatePositionVehiculeColonne = true;
        }

        // visibilité bouton
        if (menuBoutiqueGroup.isVisible()) {
            if (menuBoutiqueReceptionBoutonsVehiculesGroup.getY() < 1520) {
                boutonHautColonneVehicule.setVisible(true);
            } else {
                boutonHautColonneVehicule.setVisible(false);
            }
            // visibilité boutons haut bas
            if (menuBoutiqueReceptionBoutonsVehiculesGroup.getY() > 0) {
                boutonBasColonneVehicule.setVisible(true);
            } else {
                boutonBasColonneVehicule.setVisible(false);
            }
        }
    }

    private void moveMenuBoutiqueColonneCircuit() {
        // création de la future position
        if (futureUpPositionColonneCircuitBool && okUpdatePositionCircuitColonne || futureDownPositionColonneCircuitBool && okUpdatePositionCircuitColonne) {
            if (menuBoutiqueReceptionBoutonsCircuitGroup.getY() < 1520 && futureUpPositionColonneCircuitBool) {
                futurePositionCircuitColonne += 152f;
                futureUpPositionColonneCircuitBool = false;
            }
            if (menuBoutiqueReceptionBoutonsCircuitGroup.getY() > 0 && futureDownPositionColonneCircuitBool) {
                futurePositionCircuitColonne -= 152f;
                futureDownPositionColonneCircuitBool = false;
            }
        }

        // déplacement de la colonne si différence entre position actuelle et future position
        if (menuBoutiqueReceptionBoutonsCircuitGroup.getY() != futurePositionCircuitColonne) {
            okUpdatePositionCircuitColonne = false;
            // monte
            if (menuBoutiqueReceptionBoutonsCircuitGroup.getY() < futurePositionCircuitColonne - 1) {
                menuBoutiqueReceptionBoutonsCircuitGroup.setPosition(menuBoutiqueReceptionBoutonsCircuitGroup.getX(),
                        menuBoutiqueReceptionBoutonsCircuitGroup.getY() + 15.2f);
            }
            // descend
            if (menuBoutiqueReceptionBoutonsCircuitGroup.getY() > futurePositionCircuitColonne + 1) {
                menuBoutiqueReceptionBoutonsCircuitGroup.setPosition(menuBoutiqueReceptionBoutonsCircuitGroup.getX(),
                        menuBoutiqueReceptionBoutonsCircuitGroup.getY() - 15.2f);
            }
        }

        // réautorise nouvelle future position
        if (menuBoutiqueReceptionBoutonsCircuitGroup.getY() <= futurePositionCircuitColonne &&
                menuBoutiqueReceptionBoutonsCircuitGroup.getY() > futurePositionCircuitColonne - 0.5f) {
            okUpdatePositionCircuitColonne = true;
        }
        if (menuBoutiqueReceptionBoutonsCircuitGroup.getY() >= futurePositionCircuitColonne &&
                menuBoutiqueReceptionBoutonsCircuitGroup.getY() < futurePositionCircuitColonne + 0.5f) {
            okUpdatePositionCircuitColonne = true;
        }

        // visibilité bouton
        if (menuBoutiqueReceptionBoutonsCircuitGroup.getY() < 1520) {
            boutonHautColonneCircuit.setVisible(true);
        } else {
            boutonHautColonneCircuit.setVisible(false);
        }
        // visibilité boutons haut bas
        if (menuBoutiqueReceptionBoutonsCircuitGroup.getY() > 0) {
            boutonBasColonneCircuit.setVisible(true);
        } else {
            boutonBasColonneCircuit.setVisible(false);
        }
    }

    private void stageHUD() {
        Gdx.input.setInputProcessor(stage);

        // Groupe de réception des boutons de directions pour les menus de choix
        menuChoixReceptionBoutonsDirectionsGroup.setName("menuChoixReceptionBoutonsDirectionsGroup");
        menuChoixReceptionBoutonsDirectionsGroup.setScale(0.8f, 0.5f);
        stage.addActor(menuChoixReceptionBoutonsDirectionsGroup);

        // ETAGE MENU CIRCUIT
        menuCircuitImageDeFond.setOrigin(menuCircuitImageDeFond.getImageWidth() / 2, menuCircuitImageDeFond.getImageHeight() / 2);
        menuCircuitImageDeFond.setPosition(viewport.getWorldWidth() / 2 - menuCircuitImageDeFond.getWidth() / 4,
                viewport.getWorldHeight() / 2 - menuCircuitImageDeFond.getHeight() / 4);
        menuCircuitImageDeFond.setScale(0.65f);
        stage.addActor(menuCircuitImageDeFond);

        stage.addActor(menuCircuitReceptionBoutonsCircuitGroup);

        menuCircuitGroup.addActor(menuCircuitImageDeFond);
        menuCircuitGroup.addActor(menuCircuitReceptionBoutonsCircuitGroup);
        menuCircuitGroup.setScale(0.8f);
        menuCircuitGroup.setVisible(false);
        stage.addActor(menuCircuitGroup);

        // ETAGE MENU PILOTE
        menuPiloteImageDeFond.setOrigin(menuPiloteImageDeFond.getImageWidth() / 2, menuPiloteImageDeFond.getImageHeight() / 2);
        menuPiloteImageDeFond.setPosition(viewport.getWorldWidth() / 2 - menuPiloteImageDeFond.getWidth() / 4,
                viewport.getWorldHeight() / 2 - menuPiloteImageDeFond.getHeight() / 4);
        menuPiloteImageDeFond.setScale(0.65f);
        stage.addActor(menuPiloteImageDeFond);

        stage.addActor(menuPiloteReceptionBoutonsPiloteGroup);

        menuPiloteGroup.addActor(menuPiloteImageDeFond);
        menuPiloteGroup.addActor(menuPiloteReceptionBoutonsPiloteGroup);
        for (Image image : imagesCadenasPiloteList) {
            stage.addActor(image);
            menuPiloteGroup.addActor(image);
        }
        menuPiloteGroup.setScale(0.8f);
        menuPiloteGroup.setVisible(false);
        stage.addActor(menuPiloteGroup);

        // ETAGE MENU VEHICULE
        menuVehiculesImageDeFond.setOrigin(menuVehiculesImageDeFond.getImageWidth() / 2, menuVehiculesImageDeFond.getImageHeight() / 2);
        menuVehiculesImageDeFond.setPosition(viewport.getWorldWidth() / 2 - menuVehiculesImageDeFond.getWidth() / 4,
                viewport.getWorldHeight() / 2 - menuVehiculesImageDeFond.getHeight() / 4);
        menuVehiculesImageDeFond.setScale(0.65f);
        stage.addActor(menuVehiculesImageDeFond);
        for (Image image : imagesCadenasPiloteList) {
            stage.addActor(image);
            menuVehiculesGroup.addActor(image);
        }
        stage.addActor(menuVehiculesReceptionBoutonsVehiculesGroup);

        menuVehiculesGroup.addActor(menuVehiculesImageDeFond);
        menuVehiculesGroup.addActor(menuVehiculesReceptionBoutonsVehiculesGroup);
        menuVehiculesGroup.setScale(0.8f);
        menuVehiculesGroup.setVisible(false);
        stage.addActor(menuVehiculesGroup);

        // ETAGE MENU ATELIER
        menuAtelierImageDeFond.setOrigin(menuAtelierImageDeFond.getImageWidth() / 2, menuAtelierImageDeFond.getImageHeight() / 2);
        menuAtelierImageDeFond.setPosition(viewport.getWorldWidth() / 2 - menuAtelierImageDeFond.getWidth() / 4,
                viewport.getWorldHeight() / 2 - menuAtelierImageDeFond.getHeight() / 3.7f);
        menuAtelierImageDeFond.setScale(0.5f, 0.55f);
        stage.addActor(menuAtelierImageDeFond);

        // images dans l'editeur
        chassisEditeurImage.setPosition(viewport.getWorldWidth() / 1.75f - chassisEditeurImage.getWidth() / 2,
                viewport.getWorldHeight() / 1.6f - chassisEditeurImage.getHeight() / 2);
        chassisEditeurImage.setScale(0.65f);
        stage.addActor(chassisEditeurImage);

        roueLeftEditeurImage.setPosition(viewport.getWorldWidth() / 2.55f - roueLeftEditeurImage.getWidth() / 2,
                viewport.getWorldHeight() / 2.6f - roueLeftEditeurImage.getHeight() / 2);
        roueLeftEditeurImage.setScale(0.65f);
        stage.addActor(roueLeftEditeurImage);

        roueRightEditeurImage.setPosition(viewport.getWorldWidth() / 1.5f - roueRightEditeurImage.getWidth() / 2,
                viewport.getWorldHeight() / 2.6f - roueRightEditeurImage.getHeight() / 2);
        roueRightEditeurImage.setScale(0.65f);
        stage.addActor(roueRightEditeurImage);

        moteurEditeurImage.setPosition(viewport.getWorldWidth() / 1.2f - moteurEditeurImage.getWidth() / 2,
                viewport.getWorldHeight() / 1.2f - moteurEditeurImage.getHeight() / 2);
        moteurEditeurImage.setScale(0.35f);
        stage.addActor(moteurEditeurImage);

        imagesEditeurGroup.addActor(chassisEditeurImage);
        imagesEditeurGroup.addActor(roueLeftEditeurImage);
        imagesEditeurGroup.addActor(roueRightEditeurImage);
        imagesEditeurGroup.addActor(moteurEditeurImage);
        stage.addActor(imagesEditeurGroup);

        // colonne roues
        int f = 0;
        for (final ImageButton imageButton : arrayBoutonRouesVehicules) {
            imageButton.setUserObject(Integer.toString(f));
            f++;
            imageButton.addListener(new ActorGestureListener() {
                @Override
                public void tap(InputEvent event, float x, float y, int count, int button) {
                    savePreferences(imageButton);
                }
            });
            stage.addActor(imageButton);
            boutonsRouesVehiculesGroup.addActor(imageButton);
            imageButton.setPosition(10,
                    positionsMenuBoutiqueBoutonsColonneListY[Integer.parseInt(imageButton.getUserObject().toString())] * 0.8f + 145);
        }
        boutonsRouesVehiculesGroup.setScale(0.62f);
        boutonsRouesVehiculesGroup.setPosition(boutonsRouesVehiculesGroup.getX(), 0);

        //colonne chassis
        int g = 0;
        for (final ImageButton imageButton : arrayBoutonChassisVehicules) {
            imageButton.setUserObject(Integer.toString(g));
            g++;
            imageButton.addListener(new ActorGestureListener() {
                @Override
                public void tap(InputEvent event, float x, float y, int count, int button) {
                    savePreferences(imageButton);
                }
            });
            stage.addActor(imageButton);
            boutonsChassisVehiculesGroup.addActor(imageButton);
            imageButton.setPosition(655,
                    positionsMenuBoutiqueBoutonsColonneListY[Integer.parseInt(imageButton.getUserObject().toString())] * 0.8f + 145);
        }
        boutonsChassisVehiculesGroup.setScale(0.62f);
        boutonsChassisVehiculesGroup.setPosition(boutonsChassisVehiculesGroup.getX(), 0);

        // rangée moteur
        int h = 0;
        for (final ImageButton imageButton : arrayBoutonMoteurVehicules) {
            imageButton.setUserObject(Integer.toString(h));
            h++;
            imageButton.addListener(new ActorGestureListener() {
                @Override
                public void tap(InputEvent event, float x, float y, int count, int button) {
                    savePreferences(imageButton);
                }
            });
            stage.addActor(imageButton);
            boutonsMoteurVehiculesGroup.addActor(imageButton);
            imageButton.setPosition(-positionsMenuBoutiqueBoutonsColonneListY[Integer.parseInt(imageButton.getUserObject().toString())] * 1.5f + viewport.getWorldWidth(),
                    viewport.getWorldHeight() * 2.1875f);
        }
        boutonsMoteurVehiculesGroup.setScale(0.35f);
        boutonsMoteurVehiculesGroup.setPosition(0, boutonsMoteurVehiculesGroup.getY());

        // antiTouch
        coinAntiTouch1.setPosition(viewport.getWorldWidth() / 6f - coinAntiTouch1.getWidth() / 1.7f,
                viewport.getWorldHeight() - coinAntiTouch1.getHeight() / 2.7f);
        stage.addActor(coinAntiTouch1);
        coinAntiTouch2.setPosition(viewport.getWorldWidth() + coinAntiTouch2.getWidth() * 1.587f,
                viewport.getWorldHeight() - coinAntiTouch2.getHeight() / 2.7f);
        stage.addActor(coinAntiTouch2);

        coinAntiTouch3.setPosition(viewport.getWorldWidth() / 6f - coinAntiTouch3.getWidth() / 1.7f,
                viewport.getWorldHeight() - coinAntiTouch3.getHeight() * 2.75f);
        stage.addActor(coinAntiTouch3);
        coinAntiTouch4.setPosition(viewport.getWorldWidth() + coinAntiTouch4.getWidth() * 1.587f,
                viewport.getWorldHeight() - coinAntiTouch4.getHeight() * 2.75f);
        stage.addActor(coinAntiTouch4);
        coinAntiTouch5.setPosition(viewport.getWorldWidth() / 2.5f - coinAntiTouch5.getWidth() / 1.2f,
                viewport.getWorldHeight() - coinAntiTouch5.getHeight() / 8.7f);
        stage.addActor(coinAntiTouch5);
        coinAntiTouch6.setPosition(viewport.getWorldWidth() + coinAntiTouch6.getWidth() * 1.25f,
                viewport.getWorldHeight() - coinAntiTouch5.getHeight() / 8.7f);
        stage.addActor(coinAntiTouch6);

        antiTouchGroup.addActor(coinAntiTouch1);
        antiTouchGroup.addActor(coinAntiTouch2);
        antiTouchGroup.addActor(coinAntiTouch3);
        antiTouchGroup.addActor(coinAntiTouch4);
        antiTouchGroup.addActor(coinAntiTouch5);
        antiTouchGroup.addActor(coinAntiTouch6);
        antiTouchGroup.setScale(0.5f, 0.8f);
        stage.addActor(antiTouchGroup);

        // boutons directions
        boutonUpColonneRoues.setPosition(2, viewport.getWorldHeight() / 0.53f);
        boutonUpColonneRoues.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                futureUpPosColRouesBool = true;
            }
        });
        stage.addActor(boutonUpColonneRoues);

        boutonDownColonneRoues.setPosition(2, viewport.getWorldHeight() / 6.3f - boutonDownColonneRoues.getHeight() / 2);
        boutonDownColonneRoues.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                futureDownPosColRouesBool = true;
            }
        });
        stage.addActor(boutonDownColonneRoues);

        boutonUpColonneChassis.setPosition(viewport.getWorldWidth() * 2 + boutonUpColonneChassis.getWidth() / 12, viewport.getWorldHeight() / 0.53f);
        boutonUpColonneChassis.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                futureUpPosColChassisBool = true;
            }
        });
        stage.addActor(boutonUpColonneChassis);

        boutonDownColonneChassis.setPosition(viewport.getWorldWidth() * 2 + boutonUpColonneChassis.getWidth() / 12, viewport.getWorldHeight() / 6.3f - boutonDownColonneChassis.getHeight() / 2);
        boutonDownColonneChassis.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                futureDownPosColChassisBool = true;
            }
        });
        stage.addActor(boutonDownColonneChassis);

        boutonLeftRangeeMoteur.setPosition(182, 625);
        boutonLeftRangeeMoteur.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                futureLeftPosColMoteurBool = true;
            }
        });
        stage.addActor(boutonLeftRangeeMoteur);

        boutonRightRangeeMoteur.setPosition(viewport.getWorldWidth() * 1.8f + boutonRightRangeeMoteur.getWidth() / 3.2f, 625);
        boutonRightRangeeMoteur.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                futureRightPosColMoteurBool = true;
            }
        });
        stage.addActor(boutonRightRangeeMoteur);

        // bouton sauvegarde
        stage.addActor(sousBoutonSave);

        saveButton.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                if (mtcGame.getPrefs().getInteger("vehiculeRoueCustomImage") != 0 && mtcGame.getPrefs().getInteger("vehiculeMoteurCustomImage") != 0 && mtcGame.getPrefs().getInteger("vehiculeChassisCustomImage") != 0) {
                    // sauve choix
                    mtcGame.getPrefs().putInteger("vehiculeRoueCustom", mtcGame.getPrefs().getInteger("vehiculeRoueCustomImage")).flush();
                    mtcGame.getPrefs().putInteger("vehiculeMoteurCustom", mtcGame.getPrefs().getInteger("vehiculeMoteurCustomImage")).flush();
                    mtcGame.getPrefs().putInteger("vehiculeChassisCustom", mtcGame.getPrefs().getInteger("vehiculeChassisCustomImage")).flush();
                    musicManager(saveButton);
                    mtcGame.getPrefs().putBoolean("customVehicule", true).flush();
                    mtcGame.getPrefs().putBoolean("vehicule13Paid", true).flush();
                    arrayBoutonsVehicule.add(boutonVehicule13);
                    menuVehiculesReceptionBoutonsVehiculesGroup.addActor(boutonVehicule13);
                    toSellVehiculeList.removeValue(boutonVehicule13, true);
                    paidVehiculeList.add(boutonVehicule13);
                    savePreferences(boutonVehicule13);
                    // repositionne
                    menuAtelierGroup.setVisible(false);
                    boutonAtelierGroup.setPosition(viewport.getWorldWidth() / 1.25f - boutonMenuAtelier.getWidth() / 2.5f,
                            viewport.getWorldHeight() + boutonMenuAtelier.getHeight());
                    boutonBoutiqueGroup.setPosition(viewport.getWorldWidth() / 4 - boutonMenuBoutique.getWidth() / 2.67f,
                            viewport.getWorldHeight() / 4 - boutonMenuBoutique.getHeight() / 6f);
                    boutonCircuitGroup.setPosition(viewport.getWorldWidth() - boutonMenuCircuit.getWidth() / 4f,
                            viewport.getWorldHeight() - boutonMenuCircuit.getHeight() * 2);
                    boutonPiloteGroup.setPosition(viewport.getWorldWidth() / 2 + boutonMenuPilote.getWidth() * 2.38f,
                            viewport.getWorldHeight() / 2);
                    boutonVehiculeGroup.setPosition(viewport.getWorldWidth() / 4 + boutonMenuVehicules.getWidth() / 2.135f,
                            viewport.getWorldHeight() / 4 + boutonMenuVehicules.getHeight() / 4f);
                    // bouton start
                    boutonStartGroup.setVisible(true);
                }
            }
        });
        stage.addActor(saveButton);

        compteLabelStyle.font = mtcGame.getAssetManager().get("minnie.fnt");
        boutonSaveLabel = new Label(mtcGame.getTrad().getSauvegarder(), compteLabelStyle);
        // adapte taille et position selon langue
        if (Locale.getDefault().getLanguage().equals("pl") || Locale.getDefault().getLanguage().equals("fr")
                || Locale.getDefault().getLanguage().equals("nl")) {
            boutonSaveLabel.setPosition(sousBoutonVehicule.getWidth() / 2.05f - boutonSaveLabel.getWidth() / 2,
                    sousBoutonVehicule.getHeight() / 7 - boutonSaveLabel.getHeight() / 2);
            boutonSaveLabel.setFontScale(0.5f, 1.4f);
        } else {
            if (Locale.getDefault().getLanguage().equals("en")) {
                boutonSaveLabel.setPosition(sousBoutonVehicule.getWidth() / 3.5f - boutonSaveLabel.getWidth() / 2,
                        sousBoutonVehicule.getHeight() / 7 - boutonSaveLabel.getHeight() / 2);
                boutonSaveLabel.setFontScale(1.4f, 1.4f);
            } else {
                boutonSaveLabel.setPosition(sousBoutonVehicule.getWidth() / 2.5f - boutonSaveLabel.getWidth() / 2,
                        sousBoutonVehicule.getHeight() / 7 - boutonSaveLabel.getHeight() / 2);
                boutonSaveLabel.setFontScale(0.75f, 1.4f);
            }
        }
        boutonSaveLabel.setColor(Color.NAVY);
        stage.addActor(boutonSaveLabel);

        saveButtonScale.addActor(sousBoutonSave);
        saveButtonScale.addActor(boutonSaveLabel);
        saveButtonScale.addActor(saveButton);
        saveButtonScale.setScale(0.6f);
        saveButtonScale.setPosition(viewport.getWorldWidth() / 3,
                viewport.getWorldHeight() / 4 - saveButton.getHeight() * 0.95f);
        stage.addActor(saveButtonScale);

        boutonsDirectionsGroup.setScale(0.41f, 0.35f);
        boutonsDirectionsGroup.addActor(boutonUpColonneRoues);
        boutonsDirectionsGroup.addActor(boutonDownColonneRoues);
        boutonsDirectionsGroup.addActor(boutonUpColonneChassis);
        boutonsDirectionsGroup.addActor(boutonDownColonneChassis);
        boutonsDirectionsGroup.addActor(boutonRightRangeeMoteur);
        boutonsDirectionsGroup.addActor(boutonLeftRangeeMoteur);

        menuAtelierGroup.addActor(menuAtelierImageDeFond);
        menuAtelierGroup.addActor(imagesEditeurGroup);
        menuAtelierGroup.addActor(boutonsRouesVehiculesGroup);
        menuAtelierGroup.addActor(boutonsChassisVehiculesGroup);
        menuAtelierGroup.addActor(boutonsMoteurVehiculesGroup);
        menuAtelierGroup.addActor(antiTouchGroup);
        menuAtelierGroup.addActor(boutonsDirectionsGroup);
        menuAtelierGroup.addActor(saveButtonScale);
        menuAtelierGroup.setVisible(false);
        stage.addActor(menuAtelierGroup);

        // ETAGE MENU BOUTIQUE
        menuBoutiqueImageDeFond.setOrigin(menuBoutiqueImageDeFond.getImageWidth() / 2, menuBoutiqueImageDeFond.getImageHeight() / 2);
        menuBoutiqueImageDeFond.setPosition(viewport.getWorldWidth() / 2 - menuBoutiqueImageDeFond.getWidth() / 4,
                viewport.getWorldHeight() / 2 - menuBoutiqueImageDeFond.getHeight() / 3.7f);
        menuBoutiqueImageDeFond.setScale(0.5f, 0.55f);
        stage.addActor(menuBoutiqueImageDeFond);

        // colonne Circuit
        int j = 0;
        for (final ImageButton imageButton : arrayBoutonsCircuit) {
            imageButton.setUserObject(Integer.toString(j));
            j++;
            imageButton.addListener(new ActorGestureListener() {
                @Override
                public void tap(InputEvent event, float x, float y, int count, int button) {
                    savePreferences(imageButton);
                }
            });
            // groupe pour deplacement colonne
            stage.addActor(imageButton);
            menuBoutiqueBoutonsCircuitGroup.addActor(imageButton);
        }

        // colonne Pilote
        int k = 0;
        for (final ImageButton imageButton : arrayBoutonsPilote) {
            imageButton.setUserObject(Integer.toString(k));
            k++;
            imageButton.addListener(new ActorGestureListener() {
                @Override
                public void tap(InputEvent event, float x, float y, int count, int button) {
                    savePreferences(imageButton);
                }
            });
            // groupe pour deplacement colonne
            stage.addActor(imageButton);
            menuBoutiqueBoutonsPiloteGroup.addActor(imageButton);
        }

        // colonne Vehicule
        int l = 0;
        for (final ImageButton imageButton : arrayBoutonsVehicule) {
            if (l < 12) {
                imageButton.setUserObject(Integer.toString(l));
                l++;
                imageButton.addListener(new ActorGestureListener() {
                    @Override
                    public void tap(InputEvent event, float x, float y, int count, int button) {
                        savePreferences(imageButton);
                    }
                });
                stage.addActor(imageButton);
                menuBoutiqueBoutonsVehiculeGroup.addActor(imageButton);
            }
        }
        boutonVehicule13.setUserObject("12");
        boutonVehicule13.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                paidVehiculeList.add(boutonVehicule13);
                savePreferences(boutonVehicule13);
            }
        });

        // groupes pour déplacement colonne
        for (ImageButton imageButton : arrayBoutonsCircuit) {
            stage.addActor(imageButton);
            menuBoutiqueBoutonsCircuitGroup.addActor(imageButton);
        }
        stage.addActor(menuBoutiqueBoutonsCircuitGroup);

        for (ImageButton imageButton : arrayBoutonsPilote) {
            stage.addActor(imageButton);
            menuBoutiqueBoutonsPiloteGroup.addActor(imageButton);
        }
        stage.addActor(menuBoutiqueBoutonsPiloteGroup);

        for (ImageButton imageButton : arrayBoutonsVehicule) {
            stage.addActor(imageButton);
            menuBoutiqueBoutonsVehiculeGroup.addActor(imageButton);
        }
        stage.addActor(menuBoutiqueBoutonsVehiculeGroup);

        // CADENAS (menus choix)
        cadenasImage3.setUserObject("2");
        cadenasImage4.setUserObject("3");
        cadenasImage5.setUserObject("4");
        cadenasImage6.setUserObject("5");
        cadenasImage7.setUserObject("6");
        cadenasImage8.setUserObject("7");
        cadenasImage9.setUserObject("8");
        cadenasImage10.setUserObject("9");
        cadenasImage11.setUserObject("10");
        cadenasImage12.setUserObject("11");
        cadenasGroup.setScale(0.25f);
        for (Image image : arrayCadenasImage) {
            stage.addActor(image);
            cadenasGroup.addActor(image);
        }

        // CHECK
        checkImage.setPosition(positionsMenuChoixBoutonsPositionsArray.get(0).x + checkImage.getWidth() / 4,
                positionsMenuChoixBoutonsPositionsArray.get(0).y + checkImage.getHeight() / 3);
        stage.addActor(checkImage);
        checkImageScale.addActor(checkImage);
        checkImageScale.setScale(4);
        cadenasGroup.addActor(checkImageScale);

        // BANDEAUX ANTITOUCH
        bandeauAntiTouchHaut.setPosition(viewport.getWorldWidth() / 4 - bandeauAntiTouchHaut.getWidth() / 2, viewport.getWorldHeight() / 4 + bandeauAntiTouchHaut.getHeight() * 0.89f);
        bandeauAntiTouchBas.setPosition(viewport.getWorldWidth() / 4 - bandeauAntiTouchBas.getWidth() / 2, viewport.getWorldHeight() / 4 - bandeauAntiTouchBas.getHeight() * 1.25f);
        stage.addActor(bandeauAntiTouchBas);
        stage.addActor(bandeauAntiTouchHaut);

        // boutons déplacement colonnes
        boutonHautColonnePilote.setPosition(viewport.getWorldWidth() / 4 - boutonHautColonnePilote.getWidth() / 1.7f, viewport.getWorldHeight() / 4 + boutonHautColonnePilote.getHeight() * 3.5f);
        stage.addActor(boutonHautColonnePilote);
        boutonHautColonnePilote.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int pointer, int button) {
                futureUpPositionColonneBool = true;
            }
        });

        boutonBasColonnePilote.setPosition(viewport.getWorldWidth() / 4 - boutonBasColonnePilote.getWidth() / 1.7f, viewport.getWorldHeight() / 4 - boutonBasColonnePilote.getHeight() / 1.25f);
        boutonBasColonnePilote.setVisible(false);
        stage.addActor(boutonBasColonnePilote);
        boutonBasColonnePilote.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int pointer, int button) {
                futureDownPositionColonneBool = true;
            }
        });

        stage.addActor(boutonHautColonneVehicule);
        boutonHautColonneVehicule.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int pointer, int button) {
                if (menuBoutiqueGroup.isVisible()) {
                    futureUpPositionColonneVehiculeBool = true;
                }
                if (menuCircuitGroup.isVisible() || menuVehiculesGroup.isVisible() || menuPiloteGroup.isVisible()) {
                    scrollUpMenuChoixBoutonsGroupBool = true;
                }
            }
        });

        boutonBasColonneVehicule.setVisible(false);
        stage.addActor(boutonBasColonneVehicule);
        boutonBasColonneVehicule.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int pointer, int button) {
                if (menuBoutiqueGroup.isVisible()) {
                    futureDownPositionColonneVehiculeBool = true;
                }
                if (menuCircuitGroup.isVisible() || menuVehiculesGroup.isVisible() || menuPiloteGroup.isVisible()) {
                    scrollDownMenuChoixBoutonsGroupBool = true;
                }
            }
        });

        boutonHautColonneCircuit.setPosition(viewport.getWorldWidth() / 3 + boutonHautColonneCircuit.getWidth() * 1.23f, viewport.getWorldHeight() / 4 + boutonHautColonneCircuit.getHeight() * 3.5f);
        stage.addActor(boutonHautColonneCircuit);
        boutonHautColonneCircuit.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int pointer, int button) {
                futureUpPositionColonneCircuitBool = true;
            }
        });

        boutonBasColonneCircuit.setPosition(viewport.getWorldWidth() / 3 + boutonBasColonneCircuit.getWidth() * 1.23f, viewport.getWorldHeight() / 4 - boutonBasColonnePilote.getHeight() / 1.25f);
        boutonBasColonneCircuit.setVisible(true);
        stage.addActor(boutonBasColonneCircuit);
        boutonBasColonneCircuit.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int pointer, int button) {
                futureDownPositionColonneCircuitBool = true;
            }
        });

        // BOUTON COMPTE
        boutonCompte.setPosition(viewport.getWorldWidth() / 1.25f - boutonCompte.getWidth() / 2.5f, viewport.getWorldHeight() + boutonCompte.getHeight() * 2.72f);
        stage.addActor(boutonCompte);
        boutonCompte.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                fichesCompteBool = true;
            }
        });

        // label bouton compte
        fondBoutonCompteImage.setPosition(boutonCompte.getX(), boutonCompte.getY());
        stage.addActor(fondBoutonCompteImage);

        scoreFontLabelStyle.font = mtcGame.getAssetManager().get("score.fnt", BitmapFont.class);
        String boutonCompteString = mtcGame.getPrefs().getInteger("money") + " $";
        boutonCompteLabel = new Label(boutonCompteString, compteLabelStyle);
        boutonCompteLabel.setColor(Color.BLACK);
        boutonCompteLabel.setFontScale(2, 3.5f);
        boutonCompteLabel.setPosition(boutonCompte.getX() + boutonCompte.getWidth() / 16, boutonCompte.getY() + boutonCompte.getHeight() / 2.7f);
        stage.addActor(boutonCompteLabel);

        boutonCompteScale.addActor(fondBoutonCompteImage);
        boutonCompteScale.addActor(boutonCompteLabel);
        boutonCompteScale.addActor(boutonCompte);
        boutonCompteScale.setScale(0.5f, 0.35f);
        stage.addActor(boutonCompteScale);

        // groupe pour visibilité des boutons
        menuBoutiqueBoutonsDirectionsGroup.setName("menuBoutiqueBoutonsDirectionsGroup");
        menuBoutiqueBoutonsDirectionsGroup.addActor(boutonHautColonnePilote);
        menuBoutiqueBoutonsDirectionsGroup.addActor(boutonHautColonneCircuit);
        menuBoutiqueBoutonsDirectionsGroup.addActor(boutonBasColonnePilote);
        menuBoutiqueBoutonsDirectionsGroup.addActor(boutonBasColonneVehicule);
        menuBoutiqueBoutonsDirectionsGroup.addActor(boutonBasColonneCircuit);
        menuBoutiqueBoutonsDirectionsGroup.setScale(0.8f, 0.5f);
        stage.addActor(menuBoutiqueBoutonsDirectionsGroup);

        // groupe pour affichage
        stage.addActor(menuBoutiqueReceptionBoutonsPiloteGroup);
        stage.addActor(menuBoutiqueReceptionBoutonsVehiculesGroup);
        stage.addActor(menuBoutiqueReceptionBoutonsCircuitGroup);

        menuBoutiqueReceptionBoutonsPiloteGroup.setName("menuBoutiqueReceptionBoutonsPiloteGroup");
        menuBoutiqueGroup.setName("menuBoutiqueGroup");
        menuBoutiqueGroup.addActor(menuBoutiqueImageDeFond);
        menuBoutiqueGroup.addActor(menuBoutiqueBoutonsCircuitGroup);
        menuBoutiqueGroup.addActor(menuBoutiqueBoutonsVehiculeGroup);
        //sert a positionner les boutons de la colonne sous les boutons de direction
        menuBoutiqueGroup.addActor(menuBoutiqueReceptionBoutonsPiloteGroup);
        menuBoutiqueGroup.addActor(menuBoutiqueReceptionBoutonsVehiculesGroup);
        menuBoutiqueGroup.addActor(menuBoutiqueReceptionBoutonsCircuitGroup);
        menuBoutiqueGroup.addActor(bandeauAntiTouchHaut);
        menuBoutiqueGroup.addActor(bandeauAntiTouchBas);
        menuBoutiqueGroup.addActor(menuBoutiqueBoutonsDirectionsGroup);
        menuBoutiqueGroup.addActor(boutonCompteScale);
        menuBoutiqueGroup.setVisible(false);
        stage.addActor(menuBoutiqueGroup);

        // FICHES PILOTES
        ficheNomLabel = new Label(ficheNomString, compteLabelStyle);
        ficheNomLabel.setPosition(ficheFond.getWidth() / 16, ficheFond.getHeight() / 1.1f - ficheNomLabel.getHeight() / 2);
        ficheNomLabel.setFontScale(2.3f, 2.6f);
        stage.addActor(ficheNomLabel);

        ficheTextLabel = new Label(ficheTextString, compteLabelStyle);
        ficheTextLabel.setPosition(ficheFond.getWidth() / 2.7f, ficheFond.getHeight() / 1.5f - ficheNomLabel.getHeight() / 2);
        ficheTextLabel.setFontScale(1.15f, 1.8f);
        stage.addActor(ficheTextLabel);

        stage.addActor(ficheFond);
        stage.addActor(ficheImage);
        stage.addActor(ficheDescr);
        ficheGroup.addActor(ficheFond);
        ficheGroup.addActor(ficheImage);
        ficheGroup.addActor(ficheDescr);
        stage.addActor(ficheGroup);

        fichePilotesGroup.setPosition(viewport.getWorldWidth() / 4 - ficheFond.getWidth() / 1.5f,
                viewport.getWorldHeight() / 2 - ficheFond.getHeight() / 4);
        fichePilotesGroup.setScale(0.5f);
        fichePilotesGroup.addActor(ficheGroup);
        stage.addActor(fichePilotesGroup);

        // FICHES VEHICULES

        ficheVehiculesGroup.setPosition(viewport.getWorldWidth() / 2 - ficheFond.getWidth() / 4,
                viewport.getWorldHeight() / 4 - ficheFond.getHeight() / 1.5f);
        ficheVehiculesGroup.setScale(0.5f);
        stage.addActor(ficheVehiculesGroup);

        // FICHES CIRCUIT

        ficheCircuitGroup.setPosition(viewport.getWorldWidth() / 4 + ficheFond.getWidth() / 2.5f,
                viewport.getWorldHeight() / 2 - ficheFond.getHeight() / 4);
        ficheCircuitGroup.setScale(0.5f);
        stage.addActor(ficheCircuitGroup);

        // BOUTON ACHAT
        sousBoutonAchatTexture.setPosition(ficheFond.getWidth() / 2 - sousBoutonAchatTexture.getWidth() / 3,
                ficheFond.getHeight() / 2 - sousBoutonAchatTexture.getHeight() * 2);
        stage.addActor(sousBoutonAchatTexture);

        scoreFontLabelStyle.font = mtcGame.getAssetManager().get("score.fnt", BitmapFont.class);
        String achatString = " = " + montantAchat + " $";
        prixDAchatLabel = new Label(achatString, scoreFontLabelStyle);
        prixDAchatLabel.setColor(Color.BLACK);
        prixDAchatLabel.setPosition(sousBoutonAchatTexture.getX() + prixDAchatLabel.getWidth() * 1.35f,
                sousBoutonAchatTexture.getY() + prixDAchatLabel.getHeight() * 1.4f);
        prixDAchatLabel.setFontScale(2);
        stage.addActor(prixDAchatLabel);

        boutonAchat.setPosition(sousBoutonAchatTexture.getX(), sousBoutonAchatTexture.getY());
        stage.addActor(boutonAchat);
        boutonAchat.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                achatBool = true;
            }
        });

        boutonAchatGroup.addActor(sousBoutonAchatTexture);
        boutonAchatGroup.addActor(boutonAchat);
        boutonAchatGroup.addActor(prixDAchatLabel);
        boutonAchatGroup.setScale(0.8f);
        stage.addActor(boutonAchatGroup);

        fichePilotesGroup.addActor(boutonAchatGroup);
        // FICHE COMPTE
        stage.addActor(ficheCompte);

        // ligne compte
        String compteString = mtcGame.getTrad().getFicheComptePart1() + mtcGame.getPrefs().getInteger("money") + "$";
        compteLabel = new Label(compteString, compteLabelStyle);
        compteLabel.setColor(Color.BLACK);
        compteLabel.setFontScale(1.1f, 1.65f);
        stage.addActor(compteLabel);

        // ligne argent max
        String argentMaxString = mtcGame.getTrad().getFicheComptePart11() + mtcGame.getPrefs().getInteger("argentMax") + " $";
        argentMaxLabel = new Label(argentMaxString, compteLabelStyle);
        argentMaxLabel.setColor(Color.BLACK);
        argentMaxLabel.setFontScale(1.1f, 1.65f);
        stage.addActor(argentMaxLabel);
        String argentMaxExplicationsString = "     " + mtcGame.getTrad().getFicheComptePart2();
        Label argentMaxExplications = new Label(argentMaxExplicationsString, compteLabelStyle);
        argentMaxExplications.setColor(Color.DARK_GRAY);
        argentMaxExplications.setFontScale(0.55f, 0.85f);
        stage.addActor(argentMaxExplications);

        // ligne trophée roue
        String nbTropheeRoueString = mtcGame.getTrad().getFicheComptePart3() + mtcGame.getPrefs().getInteger("nbTropheeRoue");
        nbTropheeRoueLabel = new Label(nbTropheeRoueString, compteLabelStyle);
        nbTropheeRoueLabel.setColor(Color.BLACK);
        nbTropheeRoueLabel.setFontScale(1.1f, 1.65f);
        stage.addActor(nbTropheeRoueLabel);
        String nbTropheeRoueExplicationsString = "     " + mtcGame.getTrad().getFicheComptePart4();
        Label nbTropheeRoueExplications = new Label(nbTropheeRoueExplicationsString, compteLabelStyle);
        nbTropheeRoueExplications.setColor(Color.DARK_GRAY);
        nbTropheeRoueExplications.setFontScale(0.55f, 0.85f);
        stage.addActor(nbTropheeRoueExplications);

        // ligne trophée dollar
        String nbTropheeDollarString = mtcGame.getTrad().getFicheComptePart5() + mtcGame.getPrefs().getInteger("nbTropheeDollar");
        nbTropheeDollarLabel = new Label(nbTropheeDollarString, compteLabelStyle);
        nbTropheeDollarLabel.setColor(Color.BLACK);
        nbTropheeDollarLabel.setFontScale(1.1f, 1.65f);
        stage.addActor(nbTropheeDollarLabel);
        String nbTropheeDollarExplicationsString = "     " + mtcGame.getTrad().getFicheComptePart6();
        Label nbTropheeDollarExplications = new Label(nbTropheeDollarExplicationsString, compteLabelStyle);
        nbTropheeDollarExplications.setColor(Color.DARK_GRAY);
        nbTropheeDollarExplications.setFontScale(0.55f, 0.85f);
        stage.addActor(nbTropheeDollarExplications);
        String nbTropheeDollarExplicationsSuiteString = "     " + mtcGame.getTrad().getFicheComptePart7();
        Label nbTropheeDollarExplicationsSuite = new Label(nbTropheeDollarExplicationsSuiteString, compteLabelStyle);
        nbTropheeDollarExplicationsSuite.setColor(Color.DARK_GRAY);
        nbTropheeDollarExplicationsSuite.setFontScale(0.55f, 0.85f);
        stage.addActor(nbTropheeDollarExplicationsSuite);

        // ligne trophée bonus
        String nbTropheeBonusString = mtcGame.getTrad().getFicheComptePart8() + mtcGame.getPrefs().getInteger("nbTropheeBonus");
        nbTropheeBonusLabel = new Label(nbTropheeBonusString, compteLabelStyle);
        nbTropheeBonusLabel.setColor(Color.BLACK);
        nbTropheeBonusLabel.setFontScale(1.1f, 1.65f);
        stage.addActor(nbTropheeBonusLabel);
        String nbTropheeBonusExplicationsString = "     " + mtcGame.getTrad().getFicheComptePart9();
        Label nbTropheeBonusExplications = new Label(nbTropheeBonusExplicationsString, compteLabelStyle);
        nbTropheeBonusExplications.setColor(Color.DARK_GRAY);
        nbTropheeBonusExplications.setFontScale(0.55f, 0.85f);
        stage.addActor(nbTropheeBonusExplications);
        String nbTropheeBonusExplicationsSuiteString = "     " + mtcGame.getTrad().getFicheComptePart10();
        Label nbTropheeBonusExplicationsSuite = new Label(nbTropheeBonusExplicationsSuiteString, compteLabelStyle);
        nbTropheeBonusExplicationsSuite.setColor(Color.DARK_GRAY);
        nbTropheeBonusExplicationsSuite.setFontScale(0.55f, 0.85f);
        stage.addActor(nbTropheeBonusExplicationsSuite);

        Table argentMaxTable = new Table();
        argentMaxTable.row().spaceBottom(1);
        argentMaxTable.row().height(175);
        argentMaxTable.add(compteLabel).width(10);
        argentMaxTable.row().spaceBottom(1);
        argentMaxTable.add(argentMaxLabel).width(10);
        argentMaxTable.row().spaceBottom(1);
        argentMaxTable.add(argentMaxExplications).width(10);
        argentMaxTable.row();
        argentMaxTable.add(nbTropheeRoueLabel).width(10);
        argentMaxTable.row().spaceBottom(1);
        argentMaxTable.add(nbTropheeRoueExplications).width(10);
        argentMaxTable.row();
        argentMaxTable.add(nbTropheeDollarLabel).width(10);
        argentMaxTable.row();
        argentMaxTable.add(nbTropheeDollarExplications).width(10);
        argentMaxTable.row().spaceBottom(1);
        argentMaxTable.add(nbTropheeDollarExplicationsSuite).width(10);
        argentMaxTable.row();
        argentMaxTable.add(nbTropheeBonusLabel).width(10);
        argentMaxTable.row();
        argentMaxTable.add(nbTropheeBonusExplications).width(10);
        argentMaxTable.row().spaceBottom(1);
        argentMaxTable.add(nbTropheeBonusExplicationsSuite).width(10);
        argentMaxTable.setPosition(ficheCompte.getWidth() / 8, ficheCompte.getHeight() / 1.8f);
        stage.addActor(argentMaxTable);

        // icones
        iconesFicheCompte.setPosition(ficheCompte.getWidth() / 12 - iconesFicheCompte.getWidth() / 1.7f,
                ficheCompte.getHeight() / 2.2f - iconesFicheCompte.getHeight() / 2.5f);
        iconesFicheCompte.setWidth(iconesFicheCompte.getWidth() / 1.2f);
        iconesFicheCompte.setHeight(iconesFicheCompte.getHeight() / 1.2f);
        stage.addActor(iconesFicheCompte);

        ficheCompteGroup.addActor(ficheCompte);
        ficheCompteGroup.addActor(argentMaxTable);
        ficheCompteGroup.addActor(iconesFicheCompte);
        ficheCompteGroup.setPosition(viewport.getWorldWidth() / 2 - ficheCompte.getWidth() / 4,
                viewport.getWorldHeight() / 2 + ficheCompte.getHeight() / 4);
        ficheCompteGroup.setScale(0.5f);
        stage.addActor(ficheCompteGroup);

        // POPUP VIDEOS LIMITE
        stage.addActor(fondPopUpTimerVideosImage);

        // labels : "vous avez regardé 10 vidéos en 2h, vous devez attendre

        String expliDecompte = mtcGame.getTrad().getTimerDecompte();
        expliTimerDecompteLabel = new Label(expliDecompte, scoreFontLabelStyle);
        expliTimerDecompteLabel.setColor(Color.BLACK);
        expliTimerDecompteLabel.setFontScale(1.5f);
        expliTimerDecompteLabel.setPosition(fondPopUpTimerVideosImage.getWidth() / 2 - expliTimerDecompteLabel.getWidth() / 1.3f,
                fondPopUpTimerVideosImage.getHeight() / 2 - expliTimerDecompteLabel.getHeight() / 5f);
        stage.addActor(expliTimerDecompteLabel);

        String decompteHoraire = timeToStringConvert(mtcGame.getPeriodBeforeNewVideos() - timeElapsing);
        timerDecompteLabel = new Label(decompteHoraire, scoreFontLabelStyle);
        timerDecompteLabel.setColor(Color.BLACK);
        timerDecompteLabel.setFontScale(1.8f);
        timerDecompteLabel.setPosition(fondPopUpTimerVideosImage.getWidth() / 2 - timerDecompteLabel.getWidth() / 1.1f,
                fondPopUpTimerVideosImage.getHeight() / 3 - timerDecompteLabel.getHeight() * 1.8f);
        stage.addActor(timerDecompteLabel);

        popUpTimerGroup.addActor(fondPopUpTimerVideosImage);
        popUpTimerGroup.addActor(expliTimerDecompteLabel);
        popUpTimerGroup.addActor(timerDecompteLabel);
        popUpTimerGroup.setScale(0.65f);
        popUpTimerGroup.setPosition(viewport.getWorldWidth() / 16 - popUpTimerGroup.getWidth() / 2,
                viewport.getWorldHeight() / 16 - popUpTimerGroup.getWidth() / 6);
        popUpTimerGroup.setVisible(false);

        // POPUP WIFI NON-CONNECTE
        stage.addActor(fondWifiWarningImage);

        String wifiWarning = mtcGame.getTrad().getPopUpWifiLabelPart1() + "\n" + mtcGame.getTrad().getPopUpWifiLabelPart2() + "\n"
                + mtcGame.getTrad().getPopUpWifiLabelPart3() + "\n" + mtcGame.getTrad().getPopUpWifiLabelPart4();
        wifiWarningLabel = new Label(wifiWarning, scoreFontLabelStyle);
        wifiWarningLabel.setColor(Color.BLACK);
        wifiWarningLabel.setFontScale(1.5f);
        wifiWarningLabel.setPosition(fondWifiWarningImage.getWidth() / 2 - wifiWarningLabel.getWidth() / 1.3f,
                fondWifiWarningImage.getHeight() / 2 - wifiWarningLabel.getHeight() / 2f);
        stage.addActor(wifiWarningLabel);

        popUpWifiGroup.addActor(fondWifiWarningImage);
        popUpWifiGroup.addActor(wifiWarningLabel);
        popUpWifiGroup.setScale(0.65f);
        popUpWifiGroup.setPosition(viewport.getWorldWidth() / 16 - popUpWifiGroup.getWidth() / 2,
                viewport.getWorldHeight() / 16 - popUpWifiGroup.getWidth() / 6);
        popUpWifiGroup.setVisible(false);

        // POPUP MANQUE ARGENT
        stage.addActor(fondPopUpManqueArgentImage);

        boutonPubPopUpManqueArgent.setPosition(fondPopUpManqueArgentImage.getWidth() / 2 - boutonPubPopUpManqueArgent.getWidth() / 2,
                fondPopUpManqueArgentImage.getHeight() / 2 - boutonPubPopUpManqueArgent.getHeight() * 1.4f);
        stage.addActor(boutonPubPopUpManqueArgent);
        //****************CODE PUB******************
        boutonPubPopUpManqueArgent.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                if (mtcGame.getGoogleServices().isWifiConnected()) {
                    // décompte cycle 2 heures
                    if (mtcGame.getPrefs().getInteger("nbVideoViewed") == 0) {
                        mtcGame.getPrefs().putLong("VVFirstTimeCycleStart", TimeUtils.millis()).flush();
                    }
                    if (!mtcGame.getPrefs().getBoolean("videoViewedLimit")) {
                        // recup time de la derniere video
                        if (mtcGame.getPrefs().getInteger("nbVideoViewed") == mtcGame.getMaxVideoPerPeriod()) {
                            timeStarted = TimeUtils.millis();
                        }
                        mtcGame.getPrefs().putLong("VVLimitTimeStart", timeStarted).flush();
                        mtcGame.getPrefs().putInteger("nbVideoViewed", mtcGame.getPrefs().getInteger("nbVideoViewed") + 1).flush();
                        adReward = mtcGame.getPrefs().getInteger("money") + 150;
                        boutonPubPopUpManqueArgent.setVisible(false);
                        musicManager(boutonPubPopUpManqueArgent);
                        mtcGame.showRewardedVideoAd();
                    } else {
                        // panneau + décompte
                        popUpTimerGroup.setVisible(true);
                    }
                } else {
                    popUpWifiGroup.setVisible(true);
                }
            }
        });
        //*****************************************

        String manqueString = mtcGame.getTrad().getManqueArgent() + "\n" + "     " + soldeToutCompte + " $";
        manqueArgentLabel = new Label(manqueString, scoreFontLabelStyle);
        manqueArgentLabel.setColor(Color.FIREBRICK);
        manqueArgentLabel.setFontScale(1.8f);
        manqueArgentLabel.setPosition(fondPopUpManqueArgentImage.getWidth() / 3 - manqueArgentLabel.getWidth() / 2f,
                fondPopUpManqueArgentImage.getHeight() / 1.6f - manqueArgentLabel.getHeight() / 2);
        stage.addActor(manqueArgentLabel);

        popUpManqueArgentGroup.addActor(fondPopUpManqueArgentImage);
        popUpManqueArgentGroup.addActor(boutonPubPopUpManqueArgent);
        popUpManqueArgentGroup.addActor(manqueArgentLabel);
        popUpManqueArgentGroup.setScale(0.65f);
        popUpManqueArgentGroup.setPosition(viewport.getWorldWidth() / 16 - popUpManqueArgentGroup.getWidth() / 8,
                viewport.getWorldHeight() / 16 - popUpManqueArgentGroup.getWidth() / 6);
        popUpManqueArgentGroup.setVisible(false);

        stage.addActor(popUpManqueArgentGroup);
        stage.addActor(popUpTimerGroup);
        stage.addActor(popUpWifiGroup);

        // BOUTON RETOUR

        boutonRetour.setOrigin(boutonRetour.getWidth(), boutonRetour.getHeight());
        boutonRetour.setPosition(viewport.getWorldWidth() * 2.185f, viewport.getWorldHeight() * 1.985f);
        stage.addActor(boutonRetour);
        boutonRetour.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                musicManager(boutonRetour);
                // cache popup manque argent
                if (popUpManqueArgentGroup.isVisible()) {
                    achatBool = false;
                    popUpManqueArgentGroup.setVisible(false);
                }
                if (popUpTimerGroup.isVisible()) {
                    popUpTimerGroup.setVisible(false);
                }
                if (popUpWifiGroup.isVisible()) {
                    popUpWifiGroup.setVisible(false);
                }
                // repositionne les groupes de fiches
                if (fichesPiloteBool || fichesVehiculeBool || fichesCircuitBool || fichesCompteBool) {
                    if (fichesPiloteBool) {
                        fichesPiloteBool = false;
                    }
                    if (fichesVehiculeBool) {
                        fichesVehiculeBool = false;
                    }
                    if (fichesCircuitBool) {
                        fichesCircuitBool = false;
                    }
                    if (fichesCompteBool) {
                        fichesCompteBool = false;
                    }
                } else {
                    // cache les menus
                    menuCircuitGroup.setVisible(false);
                    menuVehiculesGroup.setVisible(false);
                    menuPiloteGroup.setVisible(false);
                    menuAtelierGroup.setVisible(false);
                    menuBoutiqueGroup.setVisible(false);
                    // repositionne le menu general
                    boutonAtelierGroup.setPosition(viewport.getWorldWidth() / 1.25f - boutonMenuAtelier.getWidth() / 2.5f,
                            viewport.getWorldHeight() + boutonMenuAtelier.getHeight());
                    boutonBoutiqueGroup.setPosition(viewport.getWorldWidth() / 4 - boutonMenuBoutique.getWidth() / 2.67f,
                            viewport.getWorldHeight() / 4 - boutonMenuBoutique.getHeight() / 6f);
                    boutonCircuitGroup.setPosition(viewport.getWorldWidth() - boutonMenuCircuit.getWidth() / 4f,
                            viewport.getWorldHeight() - boutonMenuCircuit.getHeight() * 2);
                    boutonPiloteGroup.setPosition(viewport.getWorldWidth() / 2 + boutonMenuPilote.getWidth() * 2.38f,
                            viewport.getWorldHeight() / 2);
                    boutonVehiculeGroup.setPosition(viewport.getWorldWidth() / 4 + boutonMenuVehicules.getWidth() / 2.135f,
                            viewport.getWorldHeight() / 4 + boutonMenuVehicules.getHeight() / 4f);

                    // repositionne le menu boutique
                    futurePositionPiloteColonne = 0;
                    futurePositionVehiculeColonne = 0;
                    futurePositionCircuitColonne = 0;
                    menuBoutiqueReceptionBoutonsPiloteGroup.setPosition(0, 0);
                    menuBoutiqueReceptionBoutonsVehiculesGroup.setPosition(0, 0);
                    menuBoutiqueReceptionBoutonsCircuitGroup.setPosition(0, 0);
                    menuBoutiqueBoutonsVehiculeGroup.setPosition(0, 0);
                    menuBoutiqueBoutonsCircuitGroup.setPosition(0, 0);
                    // repositionne les groupes de boutons des menus choix
                    menuPiloteReceptionBoutonsPiloteGroup.setPosition(menuPiloteReceptionBoutonsPiloteGroup.getX(), 0);
                    menuVehiculesReceptionBoutonsVehiculesGroup.setPosition(menuVehiculesReceptionBoutonsVehiculesGroup.getX(), 0);
                    menuCircuitReceptionBoutonsCircuitGroup.setPosition(menuCircuitReceptionBoutonsCircuitGroup.getX(), 0);
                    cadenasGroup.setPosition(cadenasGroup.getX(), 0);
                    // remet visibilité des cadenas
                    for (Image image : arrayCadenasImage) {
                        image.setVisible(true);
                    }
                    // montre le bouton start
                    boutonStartGroup.setVisible(true);

                    // repositionne les colonnes du menu atelier
                    futurePosColRoues = 0;
                    futurePosColChassis = 0;
                    futurePosColMoteur = 0;
                    boutonsRouesVehiculesGroup.setPosition(boutonsRouesVehiculesGroup.getX(), 0);
                    boutonsChassisVehiculesGroup.setPosition(boutonsChassisVehiculesGroup.getX(), 0);
                    boutonsMoteurVehiculesGroup.setPosition(0, boutonsMoteurVehiculesGroup.getY());
                }
            }
        });
        boutonRetourScale.addActor(boutonRetour);
        boutonRetourScale.setScale(0.4f);
        stage.addActor(boutonRetourScale);


        // ETAGE MENU GENERAL
        // bouton atelier
        stage.addActor(sousBoutonAtelier);

        stage.addActor(boutonMenuAtelier);
        boutonMenuAtelier.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                musicManager(boutonMenuAtelier);
                menuAtelierGroup.setVisible(true);
                buttonMoveBool = true;
                boutonStartGroup.setVisible(false);
            }
        });

        Label boutonAtelierLabel = new Label(mtcGame.getTrad().getBoutonMenuGeneralAtelier(), compteLabelStyle);
        boutonAtelierLabel.setPosition(sousBoutonAtelier.getWidth() / 3 - boutonAtelierLabel.getWidth() / 2,
                sousBoutonAtelier.getHeight() / 2 - boutonAtelierLabel.getHeight() / 2);
        boutonAtelierLabel.setFontScale(2.5f, 3.3f);
        boutonAtelierLabel.setColor(Color.YELLOW);
        stage.addActor(boutonAtelierLabel);

        boutonAtelierGroup.addActor(sousBoutonAtelier);
        boutonAtelierGroup.addActor(boutonAtelierLabel);
        boutonAtelierGroup.addActor(boutonMenuAtelier);
        boutonAtelierGroup.setPosition(viewport.getWorldWidth() / 1.25f - boutonMenuAtelier.getWidth() / 2.5f, viewport.getWorldHeight() + boutonMenuAtelier.getHeight());

        stage.addActor(boutonAtelierGroup);

        // bouton boutique
        stage.addActor(sousBoutonBoutique);

        stage.addActor(boutonMenuBoutique);
        boutonMenuBoutique.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                musicManager(boutonMenuBoutique);
                menuBoutiqueGroup.setVisible(true);
                buttonMoveBool = true;
                boutonStartGroup.setVisible(false);
            }
        });

        Label boutonBoutiqueLabel = new Label(mtcGame.getTrad().getBoutonMenuGeneralBoutique(), compteLabelStyle);
        boutonBoutiqueLabel.setPosition(sousBoutonBoutique.getWidth() / 2.5f - boutonBoutiqueLabel.getWidth() / 2,
                sousBoutonBoutique.getHeight() / 1.15f - boutonBoutiqueLabel.getHeight() / 2);
        boutonBoutiqueLabel.setFontScale(1.2f, 1.8f);
        boutonBoutiqueLabel.setColor(Color.FIREBRICK);
        stage.addActor(boutonBoutiqueLabel);

        boutonBoutiqueGroup.addActor(sousBoutonBoutique);
        boutonBoutiqueGroup.addActor(boutonBoutiqueLabel);
        boutonBoutiqueGroup.addActor(boutonMenuBoutique);
        boutonBoutiqueGroup.setPosition(viewport.getWorldWidth() / 4 - boutonMenuBoutique.getWidth() / 2.67f, viewport.getWorldHeight() / 4 - boutonMenuBoutique.getHeight() / 6f);

        stage.addActor(boutonBoutiqueGroup);
        // bouton Pilote
        stage.addActor(sousBoutonPilote);

        boutonMenuPilote.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                musicManager(boutonMenuPilote);
                menuPiloteGroup.setVisible(true);
                buttonMoveBool = true;
                boutonStartGroup.setVisible(false);
            }
        });
        stage.addActor(boutonMenuPilote);

//        boutonPiloteLabel = new Label(mtcGame.getTrad().getBoutonMenuGeneralPilote(),compteLabelStyle);
//        boutonPiloteLabel.setPosition(sousBoutonPilote.getWidth()/2-boutonPiloteLabel.getWidth()/2,
//                sousBoutonPilote.getHeight()/8-boutonPiloteLabel.getHeight()/2);
//        boutonPiloteLabel.setFontScale(1.1f,1.4f);
//        boutonPiloteLabel.setColor(Color.FOREST);
//        stage.addActor(boutonPiloteLabel);

        boutonPiloteGroup.setPosition(viewport.getWorldWidth() / 2 + boutonMenuPilote.getWidth() * 2.38f,
                viewport.getWorldHeight() / 2);
        boutonPiloteGroup.addActor(sousBoutonPilote);
//        boutonPiloteGroup.addActor(boutonPiloteLabel);
        boutonPiloteGroup.addActor(boutonMenuPilote);
        stage.addActor(boutonPiloteGroup);

        // bouton Vehicule
        stage.addActor(sousBoutonVehicule);

        boutonMenuVehicules.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                musicManager(boutonMenuVehicules);
                menuVehiculesGroup.setVisible(true);
                if (mtcGame.getPrefs().getBoolean("customVehicule")) {
                    scrollDownMenuChoixBoutonsGroupBool = true;
                }
                buttonMoveBool = true;
                boutonStartGroup.setVisible(false);
            }
        });
        stage.addActor(boutonMenuVehicules);

//        boutonVehiculeLabel = new Label(mtcGame.getTrad().getBoutonMenuGeneralVehicule(),compteLabelStyle);
//        boutonVehiculeLabel.setPosition(sousBoutonVehicule.getWidth()/2.5f-boutonVehiculeLabel.getWidth()/2,
//                sousBoutonVehicule.getHeight()/8-boutonVehiculeLabel.getHeight()/2);
//        boutonVehiculeLabel.setFontScale(1.4f);
//        boutonVehiculeLabel.setColor(Color.GOLD);
//        stage.addActor(boutonVehiculeLabel);

        boutonVehiculeGroup.setPosition(viewport.getWorldWidth() / 4 + boutonMenuVehicules.getWidth() / 2.135f,
                viewport.getWorldHeight() / 4 + boutonMenuVehicules.getHeight() / 4f);
        boutonVehiculeGroup.addActor(sousBoutonVehicule);
//        boutonVehiculeGroup.addActor(boutonVehiculeLabel);
        boutonVehiculeGroup.addActor(boutonMenuVehicules);
        stage.addActor(boutonVehiculeGroup);

        // bouton Circuit
        stage.addActor(sousBoutonCircuit);

        boutonMenuCircuit.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                musicManager(boutonMenuCircuit);
                menuCircuitGroup.setVisible(true);
                buttonMoveBool = true;
                boutonStartGroup.setVisible(false);
            }
        });
        stage.addActor(boutonMenuCircuit);

//        boutonCircuitLabel = new Label(mtcGame.getTrad().getBoutonMenuGeneralCircuit(),compteLabelStyle);
//        boutonCircuitLabel.setPosition(sousBoutonCircuit.getWidth()/2.5f-boutonCircuitLabel.getWidth()/2,
//                sousBoutonCircuit.getHeight()/1.35f-boutonCircuitLabel.getHeight()/2);
//        boutonCircuitLabel.setFontScale(1.4f);
//        boutonCircuitLabel.setColor(Color.NAVY);
//        stage.addActor(boutonCircuitLabel);

        boutonCircuitGroup.setPosition(viewport.getWorldWidth() - boutonMenuCircuit.getWidth() / 4f,
                viewport.getWorldHeight() - boutonMenuCircuit.getHeight() * 2);
        boutonCircuitGroup.addActor(sousBoutonCircuit);
//        boutonCircuitGroup.addActor(boutonCircuitLabel);
        boutonCircuitGroup.addActor(boutonMenuCircuit);
        stage.addActor(boutonCircuitGroup);

        menuGeneralGroup.addActor(boutonAtelierGroup);
        menuGeneralGroup.addActor(boutonBoutiqueGroup);
        menuGeneralGroup.addActor(boutonPiloteGroup);
        menuGeneralGroup.addActor(boutonVehiculeGroup);
        menuGeneralGroup.addActor(boutonCircuitGroup);
        menuGeneralGroup.setScale(0.5f);
        stage.addActor(menuGeneralGroup);

        // BOUTON START
        boutonStart.setOrigin(boutonStart.getWidth(), boutonStart.getHeight());
        boutonStart.setPosition(boutonRetour.getX(), boutonRetour.getY());
        stage.addActor(boutonStart);
        boutonStart.addListener(new ActorGestureListener() {
            @Override
            public void tap(InputEvent event, float x, float y, int count, int button) {
                musicManager(boutonStart);
                // cache les menus
                mtcGame.setScreen(new LoadingScreen(mtcGame, batch));
                dispose();
            }
        });
        boutonStartGroup.addActor(boutonStart);
        boutonStartGroup.setScale(0.4f);
        stage.addActor(boutonStartGroup);


    }

    private void changeParentBoutonsDirectionsGroup() {
        if (menuBoutiqueGroup.isVisible()) {
            // bouton haut
            menuChoixReceptionBoutonsDirectionsGroup.removeActor(boutonHautColonneVehicule);
            menuBoutiqueBoutonsDirectionsGroup.addActor(boutonHautColonneVehicule);
            // bouton bas
            menuChoixReceptionBoutonsDirectionsGroup.removeActor(boutonBasColonneVehicule);
            menuBoutiqueBoutonsDirectionsGroup.addActor(boutonBasColonneVehicule);
        }
        if (menuPiloteGroup.isVisible() || menuVehiculesGroup.isVisible() || menuCircuitGroup.isVisible()) {
            boutonHautColonneVehicule.setVisible(true);
            boutonBasColonneVehicule.setVisible(true);
            // bouton haut
            menuBoutiqueBoutonsDirectionsGroup.removeActor(boutonHautColonneVehicule);
            menuChoixReceptionBoutonsDirectionsGroup.addActor(boutonHautColonneVehicule);
            // bouton bas
            menuBoutiqueBoutonsDirectionsGroup.removeActor(boutonBasColonneVehicule);
            menuChoixReceptionBoutonsDirectionsGroup.addActor(boutonBasColonneVehicule);
            if (menuCircuitGroup.isVisible()) {
                menuVehiculesGroup.removeActor(menuChoixReceptionBoutonsDirectionsGroup);
                menuPiloteGroup.removeActor(menuChoixReceptionBoutonsDirectionsGroup);
                menuCircuitGroup.addActor(menuChoixReceptionBoutonsDirectionsGroup);
            }
            if (menuPiloteGroup.isVisible()) {
                menuCircuitGroup.removeActor(menuChoixReceptionBoutonsDirectionsGroup);
                menuVehiculesGroup.removeActor(menuChoixReceptionBoutonsDirectionsGroup);
                menuPiloteGroup.addActor(menuChoixReceptionBoutonsDirectionsGroup);
            }
            if (menuVehiculesGroup.isVisible()) {
                menuPiloteGroup.removeActor(menuChoixReceptionBoutonsDirectionsGroup);
                menuCircuitGroup.removeActor(menuChoixReceptionBoutonsDirectionsGroup);
                menuVehiculesGroup.addActor(menuChoixReceptionBoutonsDirectionsGroup);
            }
        }
        if (menuAtelierGroup.isVisible()) {
            boutonHautColonneVehicule.setVisible(false);
            boutonBasColonneVehicule.setVisible(false);
        }
    }

    private void boutonsDirectionsPositionner() {
        if (menuBoutiqueGroup.isVisible()) {
            boutonHautColonneVehicule.setPosition(viewport.getWorldWidth() / 4 + boutonHautColonneVehicule.getWidth() / 2.35f,
                    viewport.getWorldHeight() / 4 + boutonHautColonneVehicule.getHeight() * 3.5f);
            boutonBasColonneVehicule.setPosition(viewport.getWorldWidth() / 4 + boutonBasColonneVehicule.getWidth() / 2.35f,
                    viewport.getWorldHeight() / 4 - boutonBasColonnePilote.getHeight() / 1.25f);
        }
        if (menuPiloteGroup.isVisible() || menuVehiculesGroup.isVisible() || menuCircuitGroup.isVisible()) {
            boutonHautColonneVehicule.setPosition(viewport.getWorldWidth() / 4 + boutonHautColonneVehicule.getWidth() / 1.25f,
                    viewport.getWorldHeight() + boutonHautColonneVehicule.getHeight() * 3.75f);
            boutonBasColonneVehicule.setPosition(viewport.getWorldWidth() / 4 + boutonBasColonneVehicule.getWidth() / 1.25f,
                    viewport.getWorldHeight() / 4 - boutonBasColonnePilote.getHeight() / 1.25f);
        }
    }


    private void changeParentBoutonsGroup(Group menuChoix, Group groupeDeBoutons,
                                          Group receptionDugroupeDeBoutonsMenuChoix,
                                          Group receptionDuGroupeDeBoutonsMenuBoutique) {
        if (menuBoutiqueGroup.isVisible()) {
            groupeDeBoutons.setVisible(true);
            receptionDugroupeDeBoutonsMenuChoix.removeActor(groupeDeBoutons);
            receptionDuGroupeDeBoutonsMenuBoutique.addActor(groupeDeBoutons);
        } else if (menuChoix.isVisible()) {
            groupeDeBoutons.setVisible(true);
            receptionDuGroupeDeBoutonsMenuBoutique.removeActor(groupeDeBoutons);
            receptionDugroupeDeBoutonsMenuChoix.addActor(groupeDeBoutons);
        } else {
            groupeDeBoutons.setVisible(false);
        }
    }

    private void positionner(Group menuChoix, Array<ImageButton> imageButtonArray) {
        float positionX = 0;
        if (imageButtonArray.contains(boutonPilote1, true)) {
            positionX = viewport.getWorldWidth() / 4 - boutonPilote1.getWidth() / 1.3f;
        }
        if (imageButtonArray.contains(boutonVehicule1, true)) {
            positionX = viewport.getWorldWidth() / 4 + boutonVehicule2.getWidth() / 2.8f;
        }
        if (imageButtonArray.contains(boutonCircuit1, true)) {
            positionX = viewport.getWorldWidth() / 3 + boutonCircuit2.getWidth() * 1.2f;
        }
        if (menuBoutiqueGroup.isVisible()) {
            for (ImageButton imageButton : imageButtonArray) {
                if (imageButton.getUserObject().equals("0")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[0]);
                }
                if (imageButton.getUserObject().equals("1")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[1]);
                }
                if (imageButton.getUserObject().equals("2")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[2]);
                }
                if (imageButton.getUserObject().equals("3")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[3]);
                }
                if (imageButton.getUserObject().equals("4")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[4]);
                }
                if (imageButton.getUserObject().equals("5")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[5]);
                }
                if (imageButton.getUserObject().equals("6")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[6]);
                }
                if (imageButton.getUserObject().equals("7")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[7]);
                }
                if (imageButton.getUserObject().equals("8")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[8]);
                }
                if (imageButton.getUserObject().equals("9")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[9]);
                }
                if (imageButton.getUserObject().equals("10")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[10]);
                }
                if (imageButton.getUserObject().equals("11")) {
                    imageButton.setPosition(positionX, positionsMenuBoutiqueBoutonsColonneListY[11]);
                }
            }
        }
        if (menuChoix.isVisible()) {
            for (ImageButton imageButton : imageButtonArray) {
                if (imageButton.getUserObject().equals("0")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(0).x, positionsMenuChoixBoutonsPositionsArray.get(0).y);
                }
                if (imageButton.getUserObject().equals("1")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(1).x, positionsMenuChoixBoutonsPositionsArray.get(1).y);
                }
                if (imageButton.getUserObject().equals("2")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(2).x, positionsMenuChoixBoutonsPositionsArray.get(2).y);
                }
                if (imageButton.getUserObject().equals("3")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(3).x, positionsMenuChoixBoutonsPositionsArray.get(3).y);
                }
                if (imageButton.getUserObject().equals("4")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(4).x, positionsMenuChoixBoutonsPositionsArray.get(4).y);
                }
                if (imageButton.getUserObject().equals("5")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(5).x, positionsMenuChoixBoutonsPositionsArray.get(5).y);
                }
                if (imageButton.getUserObject().equals("6")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(6).x, positionsMenuChoixBoutonsPositionsArray.get(6).y);
                }
                if (imageButton.getUserObject().equals("7")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(7).x, positionsMenuChoixBoutonsPositionsArray.get(7).y);
                }
                if (imageButton.getUserObject().equals("8")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(8).x, positionsMenuChoixBoutonsPositionsArray.get(8).y);
                }
                if (imageButton.getUserObject().equals("9")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(9).x, positionsMenuChoixBoutonsPositionsArray.get(9).y);
                }
                if (imageButton.getUserObject().equals("10")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(10).x, positionsMenuChoixBoutonsPositionsArray.get(10).y);
                }
                if (imageButton.getUserObject().equals("11")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(11).x, positionsMenuChoixBoutonsPositionsArray.get(11).y);
                }
            }
        }
        if (mtcGame.getPrefs().getBoolean("customVehicule") && menuVehiculesGroup.isVisible()) {
            // positions avec boutonCustom
            for (ImageButton imageButton : imageButtonArray) {
                if (imageButton.getUserObject().equals("0")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(0).x, positionsMenuChoixBoutonsPositionsArray.get(0).y - 70);
                }
                if (imageButton.getUserObject().equals("1")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(1).x, positionsMenuChoixBoutonsPositionsArray.get(1).y - 70);
                }
                if (imageButton.getUserObject().equals("2")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(2).x, positionsMenuChoixBoutonsPositionsArray.get(2).y - 70);
                }
                if (imageButton.getUserObject().equals("3")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(3).x, positionsMenuChoixBoutonsPositionsArray.get(3).y - 70);
                }
                if (imageButton.getUserObject().equals("4")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(4).x, positionsMenuChoixBoutonsPositionsArray.get(4).y - 70);
                }
                if (imageButton.getUserObject().equals("5")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(5).x, positionsMenuChoixBoutonsPositionsArray.get(5).y - 70);
                }
                if (imageButton.getUserObject().equals("6")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(6).x, positionsMenuChoixBoutonsPositionsArray.get(6).y - 70);
                }
                if (imageButton.getUserObject().equals("7")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(7).x, positionsMenuChoixBoutonsPositionsArray.get(7).y - 70);
                }
                if (imageButton.getUserObject().equals("8")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(8).x, positionsMenuChoixBoutonsPositionsArray.get(8).y - 70);
                }
                if (imageButton.getUserObject().equals("9")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(9).x, positionsMenuChoixBoutonsPositionsArray.get(9).y - 70);
                }
                if (imageButton.getUserObject().equals("10")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(10).x, positionsMenuChoixBoutonsPositionsArray.get(10).y - 70);
                }
                if (imageButton.getUserObject().equals("11")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(11).x, positionsMenuChoixBoutonsPositionsArray.get(11).y - 70);
                }
                if (imageButton.getUserObject().equals("12")) {
                    imageButton.setPosition(positionsMenuChoixBoutonsPositionsArray.get(12).x, positionsMenuChoixBoutonsPositionsArray.get(12).y - 70);
                }
            }
        }
    }

    private void cadenasPositionnerViewer() {
        // positions des cadenas
        cadenasImage3.setPosition(positionsMenuChoixBoutonsPositionsArray.get(2).x * 5.32f,
                positionsMenuChoixBoutonsPositionsArray.get(2).y * 4);
        cadenasImage4.setPosition(positionsMenuChoixBoutonsPositionsArray.get(3).x * 4.88f,
                positionsMenuChoixBoutonsPositionsArray.get(3).y * 4);
        cadenasImage5.setPosition(positionsMenuChoixBoutonsPositionsArray.get(4).x * 124.5f,
                positionsMenuChoixBoutonsPositionsArray.get(4).y * 4);
        cadenasImage6.setPosition(positionsMenuChoixBoutonsPositionsArray.get(5).x * 6.63f,
                positionsMenuChoixBoutonsPositionsArray.get(5).y * 4);
        cadenasImage7.setPosition(positionsMenuChoixBoutonsPositionsArray.get(6).x * 5.32f,
                positionsMenuChoixBoutonsPositionsArray.get(6).y * 4);
        cadenasImage8.setPosition(positionsMenuChoixBoutonsPositionsArray.get(7).x * 4.88f,
                positionsMenuChoixBoutonsPositionsArray.get(7).y * 4);
        cadenasImage9.setPosition(positionsMenuChoixBoutonsPositionsArray.get(8).x * 124.5f,
                positionsMenuChoixBoutonsPositionsArray.get(8).y * 4);
        cadenasImage10.setPosition(positionsMenuChoixBoutonsPositionsArray.get(9).x * 6.63f,
                positionsMenuChoixBoutonsPositionsArray.get(9).y * 4);
        cadenasImage11.setPosition(positionsMenuChoixBoutonsPositionsArray.get(10).x * 5.32f,
                positionsMenuChoixBoutonsPositionsArray.get(10).y * 4);
        cadenasImage12.setPosition(positionsMenuChoixBoutonsPositionsArray.get(11).x * 4.88f,
                positionsMenuChoixBoutonsPositionsArray.get(11).y * 4);

        if (mtcGame.getPrefs().getBoolean("customVehicule") && menuVehiculesGroup.isVisible()) {
            cadenasImage3.setPosition(positionsMenuChoixBoutonsPositionsArray.get(2).x * 5.32f,
                    positionsMenuChoixBoutonsPositionsArray.get(2).y * 4 - 280);
            cadenasImage4.setPosition(positionsMenuChoixBoutonsPositionsArray.get(3).x * 4.88f,
                    positionsMenuChoixBoutonsPositionsArray.get(3).y * 4 - 280);
            cadenasImage5.setPosition(positionsMenuChoixBoutonsPositionsArray.get(4).x * 124.5f,
                    positionsMenuChoixBoutonsPositionsArray.get(4).y * 4 - 280);
            cadenasImage6.setPosition(positionsMenuChoixBoutonsPositionsArray.get(5).x * 6.63f,
                    positionsMenuChoixBoutonsPositionsArray.get(5).y * 4 - 280);
            cadenasImage7.setPosition(positionsMenuChoixBoutonsPositionsArray.get(6).x * 5.32f,
                    positionsMenuChoixBoutonsPositionsArray.get(6).y * 4 - 280);
            cadenasImage8.setPosition(positionsMenuChoixBoutonsPositionsArray.get(7).x * 4.88f,
                    positionsMenuChoixBoutonsPositionsArray.get(7).y * 4 - 280);
            cadenasImage9.setPosition(positionsMenuChoixBoutonsPositionsArray.get(8).x * 124.5f,
                    positionsMenuChoixBoutonsPositionsArray.get(8).y * 4 - 280);
            cadenasImage10.setPosition(positionsMenuChoixBoutonsPositionsArray.get(9).x * 6.63f,
                    positionsMenuChoixBoutonsPositionsArray.get(9).y * 4 - 280);
            cadenasImage11.setPosition(positionsMenuChoixBoutonsPositionsArray.get(10).x * 5.32f,
                    positionsMenuChoixBoutonsPositionsArray.get(10).y * 4 - 280);
            cadenasImage12.setPosition(positionsMenuChoixBoutonsPositionsArray.get(11).x * 4.88f,
                    positionsMenuChoixBoutonsPositionsArray.get(11).y * 4 - 280);
        }
    }

    private void changeParentCadenasGroup() {
        if (menuPiloteGroup.isVisible()) {
            //change de groupe
            menuPiloteGroup.addActor(cadenasGroup);
            menuVehiculesGroup.removeActor(cadenasGroup);
            menuCircuitGroup.removeActor(cadenasGroup);
            for (Image image : arrayCadenasImage) {
                for (ImageButton imageButton : paidPiloteList) {
                    if (image.getUserObject().equals(imageButton.getUserObject())) {
                        image.setVisible(false);
                    }
                }
            }
        }
        if (menuVehiculesGroup.isVisible()) {
            //change de groupe
            menuVehiculesGroup.addActor(cadenasGroup);
            menuPiloteGroup.removeActor(cadenasGroup);
            menuCircuitGroup.removeActor(cadenasGroup);
            for (Image image : arrayCadenasImage) {
                for (ImageButton imageButton : paidVehiculeList) {
                    if (image.getUserObject().equals(imageButton.getUserObject())) {
                        image.setVisible(false);
                    }
                }
            }
        }
        if (menuCircuitGroup.isVisible()) {
            //change de groupe
            menuCircuitGroup.addActor(cadenasGroup);
            menuVehiculesGroup.removeActor(cadenasGroup);
            menuPiloteGroup.removeActor(cadenasGroup);
            for (Image image : arrayCadenasImage) {
                for (ImageButton imageButton : paidCircuitList) {
                    if (image.getUserObject().equals(imageButton.getUserObject())) {
                        image.setVisible(false);
                    }
                }
            }
        }
    }

    private void checkImagePositionUpdater() {
        int checkPositionPilote = mtcGame.getPrefs().getInteger("headChoice");
        int checkPositionVehicule = mtcGame.getPrefs().getInteger("vehiculeChoice");
        int checkPositionCircuit = mtcGame.getPrefs().getInteger("groundChoice");
        // position du check selon le contexte
        if (menuPiloteGroup.isVisible()) {
            checkImage.setPosition(positionsMenuChoixBoutonsPositionsArray.get(checkPositionPilote).x + checkImage.getWidth() / 4,
                    positionsMenuChoixBoutonsPositionsArray.get(checkPositionPilote).y + checkImage.getHeight() / 3);
        }
        if (menuVehiculesGroup.isVisible() && mtcGame.getPrefs().getBoolean("customVehicule")) {
            checkImage.setPosition(positionsMenuChoixBoutonsPositionsArray.get(checkPositionVehicule).x + checkImage.getWidth() / 4,
                    positionsMenuChoixBoutonsPositionsArray.get(checkPositionVehicule).y + checkImage.getHeight() / 3 - 70);
        } else if (menuVehiculesGroup.isVisible()) {
            checkImage.setPosition(positionsMenuChoixBoutonsPositionsArray.get(checkPositionVehicule).x + checkImage.getWidth() / 4,
                    positionsMenuChoixBoutonsPositionsArray.get(checkPositionVehicule).y + checkImage.getHeight() / 3);
        }
        if (menuCircuitGroup.isVisible()) {
            checkImage.setPosition(positionsMenuChoixBoutonsPositionsArray.get(checkPositionCircuit).x + checkImage.getWidth() / 4,
                    positionsMenuChoixBoutonsPositionsArray.get(checkPositionCircuit).y + checkImage.getHeight() / 3);
        }
    }


    private void savePreferences(ImageButton imageButton) {
        boutonToBuy = imageButton;
        // menu CHOIX
        if (arrayBoutonsPilote.contains(imageButton, true)) {
            if (menuBoutiqueGroup.isVisible()) {
                fichesPiloteBool = true;
                changeFicheTexture(imageButton);
                boutonAchatUpdater(imageButton);
            } else {
                if (toSellPiloteList.contains(imageButton, true)) {
                    fichesPiloteBool = true;
                    changeFicheTexture(imageButton);
                    boutonAchatUpdater(imageButton);
                }
                if (paidPiloteList.contains(imageButton, true)) {
                    mtcGame.getPrefs().putInteger("headChoice", Integer.parseInt(imageButton.getUserObject().toString())).flush();
                    changeSousBoutonTexture(imageButton);
                }
            }
        }
        if (arrayBoutonsCircuit.contains(imageButton, true)) {
            if (menuBoutiqueGroup.isVisible()) {
                fichesCircuitBool = true;
                changeFicheTexture(imageButton);
                boutonAchatUpdater(imageButton);
            } else {
                if (toSellCircuitList.contains(imageButton, true)) {
                    fichesCircuitBool = true;
                    changeFicheTexture(imageButton);
                    boutonAchatUpdater(imageButton);
                }
                if (paidCircuitList.contains(imageButton, true)) {
                    mtcGame.getPrefs().putInteger("groundChoice", Integer.parseInt(imageButton.getUserObject().toString())).flush();
                    changeSousBoutonTexture(imageButton);
                }
            }
        }
        if (arrayBoutonsVehicule.contains(imageButton, true)) {
            if (menuBoutiqueGroup.isVisible()) {
                fichesVehiculeBool = true;
                changeFicheTexture(imageButton);
                boutonAchatUpdater(imageButton);
            } else {
                if (toSellVehiculeList.contains(imageButton, true)) {
                    fichesVehiculeBool = true;
                    changeFicheTexture(imageButton);
                    boutonAchatUpdater(imageButton);
                }
                if (paidVehiculeList.contains(imageButton, true)) {
                    mtcGame.getPrefs().putInteger("vehiculeChoice", Integer.parseInt(imageButton.getUserObject().toString())).flush();
                    changeSousBoutonTexture(imageButton);
                }
            }
        }
        // menu ATELIER
        if (arrayBoutonRouesVehicules.contains(imageButton, true)) {
            if (toSellVehiculeList.contains(imageButton, true)) {
                fichesVehiculeBool = true;
                changeFicheTexture(imageButton);
                boutonAchatUpdater(imageButton);
            } else {
                mtcGame.getPrefs().putInteger("vehiculeRoueCustomImage", Integer.parseInt(imageButton.getUserObject().toString()) * 100 + 100).flush();
                changeTextureForEditeurImages();
            }
        }
        if (arrayBoutonMoteurVehicules.contains(imageButton, true)) {
            if (toSellVehiculeList.contains(imageButton, true)) {
                fichesVehiculeBool = true;
                changeFicheTexture(imageButton);
                boutonAchatUpdater(imageButton);
            } else {
                mtcGame.getPrefs().putInteger("vehiculeMoteurCustomImage", Integer.parseInt(imageButton.getUserObject().toString()) * 100 + 101).flush();
                changeTextureForEditeurImages();
            }
        }
        if (arrayBoutonChassisVehicules.contains(imageButton, true)) {
            if (toSellVehiculeList.contains(imageButton, true)) {
                fichesVehiculeBool = true;
                changeFicheTexture(imageButton);
                boutonAchatUpdater(imageButton);
            } else {
                mtcGame.getPrefs().putInteger("vehiculeChassisCustomImage", Integer.parseInt(imageButton.getUserObject().toString()) * 100 + 102).flush();
                changeTextureForEditeurImages();
            }
        }
    }

    private void savePaidPreferences() {
        if (paiement) {
            if (toSellPiloteList.contains(boutonToBuy, true)) {
                if (boutonToBuy.equals(boutonPilote3)) {
                    mtcGame.getPrefs().putBoolean("pilote3Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonPilote4)) {
                    mtcGame.getPrefs().putBoolean("pilote4Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonPilote5)) {
                    mtcGame.getPrefs().putBoolean("pilote5Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonPilote6)) {
                    mtcGame.getPrefs().putBoolean("pilote6Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonPilote7)) {
                    mtcGame.getPrefs().putBoolean("pilote7Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonPilote8)) {
                    mtcGame.getPrefs().putBoolean("pilote8Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonPilote9)) {
                    mtcGame.getPrefs().putBoolean("pilote9Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonPilote10)) {
                    mtcGame.getPrefs().putBoolean("pilote10Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonPilote11)) {
                    mtcGame.getPrefs().putBoolean("pilote11Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonPilote12)) {
                    mtcGame.getPrefs().putBoolean("pilote12Paid", true).flush();
                }
                // bascule de liste
                toSellPiloteList.removeValue(boutonToBuy, true);
                paidPiloteList.add(boutonToBuy);
                paiement = false;
            }
            if (toSellVehiculeList.contains(boutonToBuy, true)) {
                if (boutonToBuy.equals(boutonVehicule3) || boutonToBuy.equals(boutonRoueVehicule3) || boutonToBuy.equals(boutonMoteurVehicule3) || boutonToBuy.equals(boutonChassisVehicule3)) {
                    mtcGame.getPrefs().putBoolean("vehicule3Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonVehicule4) || boutonToBuy.equals(boutonRoueVehicule4) || boutonToBuy.equals(boutonMoteurVehicule4) || boutonToBuy.equals(boutonChassisVehicule4)) {
                    mtcGame.getPrefs().putBoolean("vehicule4Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonVehicule5) || boutonToBuy.equals(boutonRoueVehicule5) || boutonToBuy.equals(boutonMoteurVehicule5) || boutonToBuy.equals(boutonChassisVehicule5)) {
                    mtcGame.getPrefs().putBoolean("vehicule5Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonVehicule6) || boutonToBuy.equals(boutonRoueVehicule6) || boutonToBuy.equals(boutonMoteurVehicule6) || boutonToBuy.equals(boutonChassisVehicule6)) {
                    mtcGame.getPrefs().putBoolean("vehicule6Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonVehicule7) || boutonToBuy.equals(boutonRoueVehicule7) || boutonToBuy.equals(boutonMoteurVehicule7) || boutonToBuy.equals(boutonChassisVehicule7)) {
                    mtcGame.getPrefs().putBoolean("vehicule7Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonVehicule8) || boutonToBuy.equals(boutonRoueVehicule8) || boutonToBuy.equals(boutonMoteurVehicule8) || boutonToBuy.equals(boutonChassisVehicule8)) {
                    mtcGame.getPrefs().putBoolean("vehicule8Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonVehicule9) || boutonToBuy.equals(boutonRoueVehicule9) || boutonToBuy.equals(boutonMoteurVehicule9) || boutonToBuy.equals(boutonChassisVehicule9)) {
                    mtcGame.getPrefs().putBoolean("vehicule9Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonVehicule10) || boutonToBuy.equals(boutonRoueVehicule10) || boutonToBuy.equals(boutonMoteurVehicule10) || boutonToBuy.equals(boutonChassisVehicule10)) {
                    mtcGame.getPrefs().putBoolean("vehicule10Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonVehicule11) || boutonToBuy.equals(boutonRoueVehicule11) || boutonToBuy.equals(boutonMoteurVehicule11) || boutonToBuy.equals(boutonChassisVehicule11)) {
                    mtcGame.getPrefs().putBoolean("vehicule11Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonVehicule12) || boutonToBuy.equals(boutonRoueVehicule12) || boutonToBuy.equals(boutonMoteurVehicule12) || boutonToBuy.equals(boutonChassisVehicule12)) {
                    mtcGame.getPrefs().putBoolean("vehicule12Paid", true).flush();
                }
                // bascule de liste
                toSellVehiculeList.removeValue(boutonToBuy, true);
                paidVehiculeList.add(boutonToBuy);
                paiement = false;
            }
            if (toSellCircuitList.contains(boutonToBuy, true)) {
                if (boutonToBuy.equals(boutonCircuit3)) {
                    mtcGame.getPrefs().putBoolean("circuit3Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonCircuit4)) {
                    mtcGame.getPrefs().putBoolean("circuit4Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonCircuit5)) {
                    mtcGame.getPrefs().putBoolean("circuit5Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonCircuit6)) {
                    mtcGame.getPrefs().putBoolean("circuit6Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonCircuit7)) {
                    mtcGame.getPrefs().putBoolean("circuit7Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonCircuit8)) {
                    mtcGame.getPrefs().putBoolean("circuit8Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonCircuit9)) {
                    mtcGame.getPrefs().putBoolean("circuit9Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonCircuit10)) {
                    mtcGame.getPrefs().putBoolean("circuit10Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonCircuit11)) {
                    mtcGame.getPrefs().putBoolean("circuit11Paid", true).flush();
                }
                if (boutonToBuy.equals(boutonCircuit12)) {
                    mtcGame.getPrefs().putBoolean("circuit12Paid", true).flush();
                }
                // bascule de liste
                toSellCircuitList.removeValue(boutonToBuy, true);
                paidCircuitList.add(boutonToBuy);
                paiement = false;
            }
        }
    }

    private void boutonAchatUpdater(ImageButton imageButton) {
        if (toSellPiloteList.contains(imageButton, true)) {
            fichePilotesGroup.addActor(boutonAchatGroup);
            ficheVehiculesGroup.removeActor(boutonAchatGroup);
            ficheCircuitGroup.removeActor(boutonAchatGroup);
            montantAchat = grilleDePrixPilote[Integer.parseInt(imageButton.getUserObject().toString()) - 2];
            boutonAchatGroup.setVisible(true);
        }
        if (toSellVehiculeList.contains(imageButton, true)) {
            fichePilotesGroup.removeActor(boutonAchatGroup);
            ficheVehiculesGroup.addActor(boutonAchatGroup);
            ficheCircuitGroup.removeActor(boutonAchatGroup);
            montantAchat = grilleDePrixVehicule[Integer.parseInt(imageButton.getUserObject().toString()) - 2];
            boutonAchatGroup.setVisible(true);
        }
        if (toSellCircuitList.contains(imageButton, true)) {
            fichePilotesGroup.removeActor(boutonAchatGroup);
            ficheVehiculesGroup.removeActor(boutonAchatGroup);
            ficheCircuitGroup.addActor(boutonAchatGroup);
            montantAchat = grilleDePrixCircuit[Integer.parseInt(imageButton.getUserObject().toString()) - 2];
            boutonAchatGroup.setVisible(true);
        }
        if (paidPiloteList.contains(imageButton, true)) {
            boutonAchatGroup.setVisible(false);
        }
        if (paidVehiculeList.contains(imageButton, true)) {
            boutonAchatGroup.setVisible(false);
        }
        if (paidCircuitList.contains(imageButton, true)) {
            boutonAchatGroup.setVisible(false);
        }
    }

    private void soldeDuCompte() {
        if (achatBool) {
            soldeToutCompte = mtcGame.getPrefs().getInteger("money") - montantAchat;
            if (soldeToutCompte >= 0) {
                paiement = true;
                mtcGame.getPrefs().putInteger("money", soldeToutCompte).flush();
                boutonAchatGroup.setVisible(false);
                achatSound.setVolume(0.8f);
                coinSound.setVolume(0.8f);
                achatSound.play();
                coinSound.play();
                if (supermarketMusic.isPlaying()) {
                    supermarketMusic.pause();
                }
                if (menuMusic.isPlaying()) {
                    menuMusic.pause();
                }
            }
            if (soldeToutCompte < 0) {
                paiement = false;
                popUpManqueArgentGroup.setVisible(true);
            }
            achatBool = false;
        }
    }

    private void videoViewedToggleBool() {
        if (mtcGame.getGoogleServices().hasVideoViewed()) {
            // récompense
            if (mtcGame.getPrefs().getInteger("money") < adReward) {
                mtcGame.getPrefs().putInteger("money", mtcGame.getPrefs().getInteger("money") + 150).flush();
            }
            soldeToutCompte = mtcGame.getPrefs().getInteger("money") - montantAchat;
            // timer pour booleen viewed
            if (videoViewedTimer < 2) {
                videoViewedTimer += 0.1f;
            }
        }
        if (videoViewedTimer >= 2) {
            mtcGame.getGoogleServices().setIs_video_ad_viewed(false);
            videoViewedTimer = 0;
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
        // si date + 2h --> boolean false et viedVideosPerDay = 0;
        if (timeElapsing > mtcGame.getPrefs().getLong("VVLimitTimeStart") + mtcGame.getPeriodBeforeNewVideos()) {
            mtcGame.getPrefs().putBoolean("videoViewedLimit", false).flush();
            mtcGame.getPrefs().putInteger("nbVideoViewed", 0).flush();
            mtcGame.getPrefs().putLong("VVLimitTimeStart", 0).flush();
        }
        cycleTimeElapsing = TimeUtils.millis();
        // fin de cycle de 2 heures
        if (cycleTimeElapsing > mtcGame.getPrefs().getLong("VVFirstTimeCycleStart") + mtcGame.getPeriodCycleRefreshNbVideos()) {
            mtcGame.getPrefs().putInteger("nbVideoViewed", 0).flush();
        }

    }

    private String timeToStringConvert(Long time) {
        millis = time % 1000;
        seconds = (time / 1000) % 60;
        minutes = (time / (1000 * 60)) % 60;
        hours = (time / (1000 * 60 * 60)) % 24;
        horloge = Integer.toString((int) hours) + " h " + Integer.toString((int) minutes) + " mn " + Integer.toString((int) seconds) + " s";
        return horloge;
    }

    private void popUpTimerVisibiliteTimer() {
        if (popUpTimerGroup.isVisible()) {
            if (popUpTimerGroupTimer < 3) {
                popUpTimerGroupTimer += 0.0125f;
            }
        }
        if (popUpTimerGroupTimer >= 3) {
            popUpTimerGroup.setVisible(false);
            popUpTimerGroupTimer = 0;
        }
    }

    private void popUpWifiVisibiliteTimer() {
        if (popUpWifiGroup.isVisible()) {
            if (popUpWifiGroupTimer < 3) {
                popUpWifiGroupTimer += 0.015f;
            }
        }
        if (popUpWifiGroupTimer >= 3) {
            popUpWifiGroup.setVisible(false);
            popUpWifiGroupTimer = 0;
        }
    }

    private void musicManager(ImageButton imageButton) {
        if (imageButton.equals(boutonMenuAtelier)) {
            atelierMusic.play();
            menuMusic.pause();
            supermarketMusic.stop();
        }
        if (imageButton.equals(boutonMenuBoutique)) {
            atelierMusic.stop();
            menuMusic.pause();
            supermarketMusic.play();
        }
        if (imageButton.equals(boutonMenuPilote)
                || imageButton.equals(boutonMenuVehicules) || imageButton.equals(boutonMenuCircuit)
                || imageButton.equals(saveButton)) {
            atelierMusic.stop();
            menuMusic.play();
            supermarketMusic.stop();
        }
        if (imageButton.equals(boutonRetour)) {
            if(popUpManqueArgentGroup.isVisible()){
                menuMusic.play();
            }
            if (fichesPiloteBool || fichesVehiculeBool || fichesCircuitBool || fichesCompteBool) {
                if (menuBoutiqueGroup.isVisible()) {
                    atelierMusic.stop();
                    menuMusic.pause();
                    supermarketMusic.play();
                }
                if (menuAtelierGroup.isVisible()) {
                    atelierMusic.play();
                    menuMusic.pause();
                    supermarketMusic.stop();
                }
            }else{
                atelierMusic.stop();
                menuMusic.play();
                supermarketMusic.stop();
            }
        }
        if (imageButton.equals(boutonStart)) {
            atelierMusic.stop();
            menuMusic.stop();
            supermarketMusic.stop();
        }
        if (imageButton.equals(boutonPubPopUpManqueArgent)) {
            atelierMusic.stop();
            menuMusic.pause();
            supermarketMusic.stop();
        }
    }


        private void debugLog(){
//        Gdx.app.log("buttonMover",Float.toString(buttonMover));
//        Gdx.app.log("butoonMoveBool",Boolean.toString(buttonMoveBool));
//        Gdx.app.log("okUpdatePositionPiloteColonne", Boolean.toString(okUpdatePositionPiloteColonne));
//        Gdx.app.log("futureUpPositionPiloteColonne", Boolean.toString(futureUpPositionColonnePiloteBool));
//        Gdx.app.log("futureDownPositionPiloteColonne", Boolean.toString(futureDownPositionColonnePiloteBool));
//        Gdx.app.log("colonnePiloteMover",Float.toString(colonnePiloteMover));
//        Gdx.app.log("colonnePiloteBoutons position",Float.toString(menuBoutiqueBoutonsPiloteGroup.getY()));
//        Gdx.app.log("future position",Float.toString(futurePositionPiloteColonne));
//        Gdx.app.log("actualPosition",Float.toString(actualPosition));
//        Gdx.app.log("colonneMover position",Float.toString(colonnePiloteMover));
//        Gdx.app.log("prefs.money",Integer.toString(Gdx.app.getPreferences("MyPrefs").getInteger("money")));
//        Gdx.app.log("menuBoutiqueBoutonPiloteGroup.parent",menuBoutiqueBoutonsPiloteGroup.getParent().getName());
//        Gdx.app.log("boutonUpColonneVehicule.parent",boutonHautColonneVehicule.getParent().getName());
//        Gdx.app.log("groupeBoutons vehicules pos",Float.toString(menuVehiculesReceptionBoutonsVehiculesGroup.getY()));
//        Gdx.app.log("positionX cadenas", Float.toString(cadenasImage3.getImageX()));
//        Gdx.app.log("positionY cadenas", Float.toString(cadenasTexture.getRegionY()));
//        Gdx.app.log("imageCadenasPiloteListe.size",Integer.toString(imagesCadenasPiloteList.size));
//        Gdx.app.log("toSellPioteList.size",Integer.toString(toSellPiloteList.size));
//        Gdx.app.log("testTableauPrixVehicule",Integer.toString(grilleDePrixCircuit[4]));
//        Gdx.app.log("paiement",Boolean.toString(paiement));
//        Gdx.app.log("vehiculePaidListe",Float.toString(paidPiloteList.size));
//        Gdx.app.log("soldeToutCompte",Integer.toString(soldeToutCompte));
//        Gdx.app.log("futurePosRangeeMoteur",Float.toString(futurePosColMoteur));
//        Gdx.app.log("position groupe de boutons", Float.toString(boutonsMoteurVehiculesGroup.getX()));
//        Gdx.app.log("colonne dimension",Float.toString(boutonsRouesVehiculesGroup.getHeight()));
//        Gdx.app.log("futureRightPosColRouesBool",Boolean.toString(futureRightPosColMoteurBool));
//        Gdx.app.log("futureLeftPosColRouesBool",Boolean.toString(futureLeftPosColMoteurBool));
//        Gdx.app.log("okUpdateColRouesBool",Boolean.toString(okUpdatePosColMoteur));
//        Gdx.app.log("fichesVehiculeBool",Boolean.toString(fichesVehiculeBool));
//        Gdx.app.log("toSellVehiculeListe contient boutonVehiculeRoue3",Boolean.toString(toSellVehiculeList.contains(boutonRoueVehicule3,true)));
//        Gdx.app.log("height/2 imageButton", Float.toString(boutonVehicule1.getHeight()/2));
//        Gdx.app.log("hasVideoViewed",Boolean.toString(mtcGame.googleServices.hasVideoViewed()));
//        Gdx.app.log("videoViewed",Boolean.toString(mtcGame.getPrefs().getBoolean("videoViewed")));
//        Gdx.app.log("nbTropheeBonus",Integer.toString(mtcGame.getPrefs().getInteger("nbTropheeBonus")));
//        Gdx.app.log("nbTropheeDollar",Integer.toString(mtcGame.getPrefs().getInteger("nbTropheeDollar")));
//        Gdx.app.log("nbTropheeRoue",Integer.toString(mtcGame.getPrefs().getInteger("nbTropheeRoue")));

//        Gdx.app.log("nbVideoViewed",Integer.toString(mtcGame.getPrefs().getInteger("nbVideoViewed")));
//        Gdx.app.log("video PerDay",Boolean.toString(mtcGame.getPrefs().getBoolean("videoViewedLimit")));
//        Gdx.app.log("videoViewed time start",timeToStringConvert(mtcGame.getPrefs().getLong("VVLimitTimeStart")));

//        Gdx.app.log("Time started",timeToStringConvert(mtcGame.getPrefs().getLong("VVLimitTimeStart")));
//        Gdx.app.log("time Elapsed",timeToStringConvert(timeElapsing));
//        Gdx.app.log("time Cycled",timeToStringConvert(mtcGame.getPrefs().getLong("VVFirstTimeCycleStart")));
//        Gdx.app.log("time Cyclin",timeToStringConvert(cycleTimeElapsing));
//        Gdx.app.log("groundChoice",Integer.toString(mtcGame.getPrefs().getInteger("groundChoice")));
//        Gdx.app.log("loadDechargeTMX",Boolean.toString(mtcGame.getAssetManager().isLoaded("textures DecorDecharge/exitScreenBackground-Decharge.png")));
//        Gdx.app.log("loadPoleNordTMX",Boolean.toString(mtcGame.getAssetManager().isLoaded("textures DecorPoleNord/exitScreenBackground-PoleNord.png")));

//        Gdx.app.log("SansPermisSoundEffectLoad",Boolean.toString(mtcGame.getAssetManager().isLoaded("SansPermisSoundEffect-accel.wav")));
//        if(assetsToUnload!=null){
//            Gdx.app.log("assetsToUnload",Integer.toString(assetsToUnload.size));
//        Gdx.app.log("videoLoaded",Boolean.toString(mtcGame.getGoogleServices().hasVideoLoaded()));

        }

}


