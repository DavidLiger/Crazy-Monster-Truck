package com.mygdx.game.Outils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Controleur.MTCGame;
import com.mygdx.game.Modele.DecorDef;


public class GroundGenerator {

    private MTCGame mtcGame;
    private TiledMap tiledMap ;
    private Polyline polyline;
    private DecorDef decorDef;

    private Vector2 playerPosition;
    private Array<Vector2> enemiesPositions = new Array<Vector2>();
    private Array<Vector2> coinsPositions = new Array<Vector2>();
    private Array<Vector2> jerrycanPositions = new Array<Vector2>();
    private Array<Vector2> finishPosition = new Array<Vector2>();
    private Array<Vector2> bonusPositions = new Array<Vector2>();

    private Music music;
    private SpriteBatch batch;
    private Camera camera;

    private Texture sky;
    private Texture background;
    private Texture midBackground;
    private Texture exitScreenBackground;
    private Texture solDepart;
    private Texture[] solTextureTab = new Texture[30];
    private Array<String> assetsListeTemp;


    private float levelWidth;
    private Sprite finishFlagSprite;
    private Vector2 finishFlagPosition = new Vector2();

    private int k = 0;
    private int position = 0;

    private String refToLoad;
    private String refToUnload;
    private String refExitBackground;



    public GroundGenerator(DecorDef decorDef, MTCGame mtcGame, World world, SpriteBatch batch, Camera camera){
        this.mtcGame = mtcGame;
        this.batch = batch;
        this.camera = camera;
        this.decorDef = decorDef;

        refExitBackground = decorDef.getExitBackGroundRef();

        tiledMap = decorDef.getTiledMap();
        music = decorDef.getMusic();
        sky = decorDef.getSky();
        background = decorDef.getBackground();
        midBackground = decorDef.getMidBackground();
        exitScreenBackground = decorDef.getExitScreenTexture();
        solDepart = decorDef.getSolDepart();
        levelWidth = decorDef.getLevelWidth();

        solTextureTab[0] = mtcGame.getAssetManager().get(decorDef.getSolTexturesReferences().get(0));
        solTextureTab[1] = mtcGame.getAssetManager().get(decorDef.getSolTexturesReferences().get(1));

        assetsListeTemp = decorDef.getAssetsReferences();
        assetsListeTemp.add(decorDef.getSolTexturesReferences().get(0));
        assetsListeTemp.add(decorDef.getSolTexturesReferences().get(1));
        assetsListeTemp.add(decorDef.getSolTexturesReferences().get(2));

        // ground : récupération de la forme
        MapObjects groundMapObjects = tiledMap.getLayers().get("groundMapObject").getObjects();
        for (MapObject object : groundMapObjects) {
            PolylineMapObject polygonMapObject = (PolylineMapObject) object;
            polyline = polygonMapObject.getPolyline();
        }

        // vehicule : recuperation de la position
        MapObjects groundMapObjectsPlayer = tiledMap.getLayers().get("positionPlayer").getObjects();
        for (MapObject object : groundMapObjectsPlayer) {
            RectangleMapObject rectangleMapObject = (RectangleMapObject) object;
            playerPosition = rectangleMapObject.getRectangle().getPosition(new Vector2());
        }

        // ennemis véhicules : récupération des postions
        MapObjects groundMapObjectsEnemies = tiledMap.getLayers().get("positionsEnemies").getObjects();
        for (MapObject object : groundMapObjectsEnemies) {
            RectangleMapObject rectangleMapObject = (RectangleMapObject) object;
            enemiesPositions.add(rectangleMapObject.getRectangle().getPosition(new Vector2()));
        }

        // coins : récupération des positions
        MapObjects groundMapObjectCoins = tiledMap.getLayers().get("positionsCoins").getObjects();
        for (MapObject object : groundMapObjectCoins) {
            RectangleMapObject rectangleMapObject = (RectangleMapObject) object;
            coinsPositions.add(rectangleMapObject.getRectangle().getPosition(new Vector2()));
        }

        // jerycans : récupération des positions
        MapObjects groundMapObjectJerrycan = tiledMap.getLayers().get("positionsGazole").getObjects();
        for (MapObject object : groundMapObjectJerrycan) {
            RectangleMapObject rectangleMapObject = (RectangleMapObject) object;
            jerrycanPositions.add(rectangleMapObject.getRectangle().getPosition(new Vector2()));
        }

        // finish : récupération de la position
        MapObjects groundMapObjectFinish = tiledMap.getLayers().get("positionFinish").getObjects();
        for (MapObject object : groundMapObjectFinish) {
            RectangleMapObject rectangleMapObject = (RectangleMapObject) object;
            finishPosition.add(rectangleMapObject.getRectangle().getPosition(new Vector2()));
        }

        // bonus : récupération des positions
        MapObjects groundMapObjectBonus = tiledMap.getLayers().get("positionsBonus").getObjects();
        for (MapObject object : groundMapObjectBonus) {
            RectangleMapObject rectangleMapObject = (RectangleMapObject) object;
            bonusPositions.add(rectangleMapObject.getRectangle().getPosition(new Vector2()));
        }


        ChainShape chainShape = new ChainShape();
        chainShape.createChain(polyline.getVertices());

        FixtureDef groundFixtureDef = new FixtureDef();
        groundFixtureDef.shape = chainShape;
        groundFixtureDef.friction = 30;

        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
        def.position.set(polyline.getX(),polyline.getY());

        Body groundBody = world.createBody(def);
        groundBody.setTransform(polyline.getX(),polyline.getY(),0);
        groundBody.createFixture(groundFixtureDef);

        finishFlagPositioner();


    }


    /**
     * Extraction de la position unique de la liste
     */
    private void finishFlagPositioner(){
        for(Vector2 position : finishPosition){
            finishFlagPosition.x = position.x;
            finishFlagPosition.y = position.y;
        }
    }

    /**
     * Traveling sky sur position.x camera
     */
    private void drawSky() {
        batch.draw(sky, camera.position.x - (sky.getWidth() / 2), camera.position.y - (sky.getHeight() / 2),sky.getWidth()/1.2f,sky.getHeight()/1.2f);
    }


    private void drawBackground() {
        batch.draw(background, (camera.position.x - camera.viewportWidth / 2) - ((background.getWidth() * (camera.position.x / levelWidth))*0.7f), camera.position.y - (background.getHeight() / 2));
    }

    private void drawMidBackground() {
        batch.draw(midBackground, (camera.position.x - camera.viewportWidth / 2) - ((midBackground.getWidth() * (camera.position.x / levelWidth))*0.7f), camera.position.y - (midBackground.getHeight() / 2));
    }


    /**
     * Défilement du sol
     */
    public void loadingUnloadingSelonPosition(){
        refToUnload = "";
        if(k < solTextureTab.length - 3){
            refToLoad = decorDef.getSolTexturesReferences().get(k+3);
            if(!mtcGame.getAssetManager().isLoaded(refToLoad)) {
                mtcGame.getAssetManager().load(refToLoad,Texture.class);
                mtcGame.getAssetManager().update();
                assetsListeTemp.add(refToLoad);
            }
        }
        if(k < solTextureTab.length - 2){
            solTextureTab[k+2] = mtcGame.getAssetManager().get(decorDef.getSolTexturesReferences().get(k+2));
        }
        if(k > 3){
            refToUnload = decorDef.getSolTexturesReferences().get(k-4);
            if(mtcGame.getAssetManager().isLoaded(refToUnload)){
                mtcGame.getAssetManager().unload(refToUnload);
                assetsListeTemp.removeValue(refToUnload,true);
            }
        }

    }

    public void drawSolSelonPosition() {
        batch.draw(solDepart, -960, 0);
        batch.draw(solTextureTab[0], 0, -solTextureTab[0].getHeight()/5);
        batch.draw(solTextureTab[1], 960, -solTextureTab[1].getHeight()/5);
        if (camera.position.x - (camera.viewportWidth / 1.5f) > position + solTextureTab[k].getWidth() && k < solTextureTab.length) {
            position += solTextureTab[k].getWidth();
            if (k < solTextureTab.length - 1) {
                k += 1;
            }
        }
        if (k < solTextureTab.length - 1) {
            batch.draw(solTextureTab[k], position, -solTextureTab[k].getHeight()/5);
            batch.draw(solTextureTab[k + 1], position + solTextureTab[k].getWidth(), -solTextureTab[k].getHeight()/5);
            if(k > 2){
                batch.draw(solTextureTab[k - 1], position - solTextureTab[k].getWidth(), -solTextureTab[k].getHeight()/5);
                batch.draw(solTextureTab[k - 2], position - (solTextureTab[k].getWidth() * 2), -solTextureTab[k].getHeight()/5);
            }
        } else {
            batch.draw(solTextureTab[solTextureTab.length - 1], position, -solTextureTab[k].getHeight()/5);
        }

    }

    private void drawFlag(){
        TextureAtlas textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas");
        finishFlagSprite = new Sprite(textureAtlas.findRegion("finishFlag"));
        finishFlagSprite.setScale(0.5f);
        finishFlagSprite.setOrigin(finishFlagSprite.getWidth()/2, finishFlagSprite.getHeight()/2);
        finishFlagSprite.setPosition(finishFlagPosition.x,finishFlagPosition.y-finishFlagSprite.getHeight()/3);
        finishFlagSprite.draw(batch);
    }

    public void draw() {
        drawSky();
        drawBackground();
        drawMidBackground();
        drawFlag();
    }

    public TiledMap getTiledMap() {
        return tiledMap;
    }

    public Vector2 getPlayerPosition() {
        return playerPosition;
    }

    public Array<Vector2> getEnemiesPositions() {
        return enemiesPositions;
    }

    public Array<Vector2> getCoinsPositions() {
        return coinsPositions;
    }

    public Array<Vector2> getJerrycanPositions() {
        return jerrycanPositions;
    }

    public Array<Vector2> getBonusPositions() {
        return bonusPositions;
    }

    public Music getMusic() {
        return music;
    }

    public Texture getExitScreenBackground(){
        return exitScreenBackground;
    }

    public Vector2 getFinishFlagPosition() {
        return finishFlagPosition;
    }

    public Array<String> getAssetsListeTemp() {
        return assetsListeTemp;
    }

    public String getRefToLoad() {
        return refToLoad;
    }

    public String getRefExitBackground() {
        return refExitBackground;
    }

    public void debugLog(){
//        Gdx.app.log("k",Integer.toString(k));
//        Gdx.app.log("position",Integer.toString(position));
//        Gdx.app.log("refToLoad",refToLoad);
        Gdx.app.log("assetsTemp.size",Integer.toString(assetsListeTemp.size));
    }
}
