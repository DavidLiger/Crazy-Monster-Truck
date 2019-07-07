package com.mygdx.game.Outils;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.Controleur.MTCGame;

public class HeadSpriteRandomGenerator {

    private static Sprite headSprite;
    private static Sprite headCrashedSprite;

    public static Sprite generateRandomizeHead(MTCGame mtcGame,int choix){
        TextureAtlas textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas",TextureAtlas.class);

        if(choix == 0){ headSprite = new Sprite(textureAtlas.findRegion("requinHead")); }
        if(choix == 1){ headSprite = new Sprite(textureAtlas.findRegion("wolfHead")); }
        if(choix == 2){ headSprite = new Sprite(textureAtlas.findRegion("T-RexHead")); }
        if(choix == 3){ headSprite = new Sprite(textureAtlas.findRegion("horseHead")); }
        if(choix == 4){ headSprite = new Sprite(textureAtlas.findRegion("rhinoHead")); }
        if(choix == 5){ headSprite = new Sprite(textureAtlas.findRegion("chimpanzeHead")); }
        if(choix == 6){ headSprite = new Sprite(textureAtlas.findRegion("tortueHead")); }
        if(choix == 7){ headSprite = new Sprite(textureAtlas.findRegion("aigleHead")); }
        if(choix == 8){ headSprite = new Sprite(textureAtlas.findRegion("perroquetHead")); }
        if(choix == 9){ headSprite = new Sprite(textureAtlas.findRegion("coqHead")); }
        if(choix == 10){ headSprite = new Sprite(textureAtlas.findRegion("crocoHead")); }
        if(choix == 11){ headSprite = new Sprite(textureAtlas.findRegion("oursHead")); }
        if(choix == 12){ headSprite = new Sprite(textureAtlas.findRegion("autrucheHead")); }
        if(choix == 13){ headSprite = new Sprite(textureAtlas.findRegion("babouinHead")); }
        if(choix == 14){ headSprite = new Sprite(textureAtlas.findRegion("baleineHead")); }
        if(choix == 15){ headSprite = new Sprite(textureAtlas.findRegion("bisonHead")); }
        if(choix == 16){ headSprite = new Sprite(textureAtlas.findRegion("caimanHead")); }
        if(choix == 17){ headSprite = new Sprite(textureAtlas.findRegion("calaoHead")); }
        if(choix == 18){ headSprite = new Sprite(textureAtlas.findRegion("chameauHead")); }
        if(choix == 19){ headSprite = new Sprite(textureAtlas.findRegion("chevreHead")); }
        if(choix == 20){ headSprite = new Sprite(textureAtlas.findRegion("cochonHead")); }
        if(choix == 21){ headSprite = new Sprite(textureAtlas.findRegion("colibriHead")); }
        if(choix == 22){ headSprite = new Sprite(textureAtlas.findRegion("corbeauHead")); }
        if(choix == 23){ headSprite = new Sprite(textureAtlas.findRegion("crapaudHead")); }
        if(choix == 24){ headSprite = new Sprite(textureAtlas.findRegion("dauphinHead")); }
        if(choix == 25){ headSprite = new Sprite(textureAtlas.findRegion("diplodocusHead")); }
        if(choix == 26){ headSprite = new Sprite(textureAtlas.findRegion("elanHead")); }
        if(choix == 27){ headSprite = new Sprite(textureAtlas.findRegion("elephantHead")); }
        if(choix == 28){ headSprite = new Sprite(textureAtlas.findRegion("espadonHead")); }
        if(choix == 29){ headSprite = new Sprite(textureAtlas.findRegion("fauconHead")); }
        if(choix == 30){ headSprite = new Sprite(textureAtlas.findRegion("gavialHead")); }
        if(choix == 31){ headSprite = new Sprite(textureAtlas.findRegion("gazelleHead")); }
        if(choix == 32){ headSprite = new Sprite(textureAtlas.findRegion("geckoHead")); }
        if(choix == 33){ headSprite = new Sprite(textureAtlas.findRegion("girafeHead")); }
        if(choix == 34){ headSprite = new Sprite(textureAtlas.findRegion("gnouHead")); }
        if(choix == 35){ headSprite = new Sprite(textureAtlas.findRegion("gorilleHead")); }
        if(choix == 36){ headSprite = new Sprite(textureAtlas.findRegion("hippopotameHead")); }
        if(choix == 37){ headSprite = new Sprite(textureAtlas.findRegion("hyeneHead")); }
        if(choix == 38){ headSprite = new Sprite(textureAtlas.findRegion("iguaneHead")); }
        if(choix == 39){ headSprite = new Sprite(textureAtlas.findRegion("kangourouHead")); }
        if(choix == 40){ headSprite = new Sprite(textureAtlas.findRegion("koalaHead")); }
        if(choix == 41){ headSprite = new Sprite(textureAtlas.findRegion("lapinHead")); }
        if(choix == 42){ headSprite = new Sprite(textureAtlas.findRegion("lionHead")); }
        if(choix == 43){ headSprite = new Sprite(textureAtlas.findRegion("mouetteHead")); }
        if(choix == 44){ headSprite = new Sprite(textureAtlas.findRegion("mureneHead")); }
        if(choix == 45){ headSprite = new Sprite(textureAtlas.findRegion("orangOutanHead")); }
        if(choix == 46){ headSprite = new Sprite(textureAtlas.findRegion("pandaHead")); }
        if(choix == 47){ headSprite = new Sprite(textureAtlas.findRegion("perroquetHead")); }
        if(choix == 48){ headSprite = new Sprite(textureAtlas.findRegion("pivertHead")); }
        if(choix == 49){ headSprite = new Sprite(textureAtlas.findRegion("pouleHead")); }
        if(choix == 50){ headSprite = new Sprite(textureAtlas.findRegion("raptorHead")); }
        if(choix == 51){ headSprite = new Sprite(textureAtlas.findRegion("renardHead")); }
        if(choix == 52){ headSprite = new Sprite(textureAtlas.findRegion("requinHead")); }
        if(choix == 53){ headSprite = new Sprite(textureAtlas.findRegion("sourisHead")); }
        if(choix == 54){ headSprite = new Sprite(textureAtlas.findRegion("stegosaureHead")); }
        if(choix == 55){ headSprite = new Sprite(textureAtlas.findRegion("tigreHead")); }
        if(choix == 56){ headSprite = new Sprite(textureAtlas.findRegion("toucanHead")); }
        if(choix == 57){ headSprite = new Sprite(textureAtlas.findRegion("triceratopsHead")); }
        if(choix == 58){ headSprite = new Sprite(textureAtlas.findRegion("vacheHead")); }
        if(choix == 59){ headSprite = new Sprite(textureAtlas.findRegion("varanHead")); }
        return headSprite;
    }


    public static Sprite generateRandomizeCrashedHead(MTCGame mtcGame,int choix){
        TextureAtlas textureAtlas = mtcGame.getAssetManager().get("preLoading_Total.atlas",TextureAtlas.class);

        if(choix == 0){ headCrashedSprite = new Sprite(textureAtlas.findRegion("requinCrashedHead")); }
        if(choix == 1){ headCrashedSprite = new Sprite(textureAtlas.findRegion("wolfCrashedHead")); }
        if(choix == 2){ headCrashedSprite = new Sprite(textureAtlas.findRegion("T-RexCrashedHead")); }
        if(choix == 3){ headCrashedSprite = new Sprite(textureAtlas.findRegion("horseCrashedHead")); }
        if(choix == 4){ headCrashedSprite = new Sprite(textureAtlas.findRegion("rhinoHeadCrashed")); }
        if(choix == 5){ headCrashedSprite = new Sprite(textureAtlas.findRegion("chimpanzeCrashedHead")); }
        if(choix == 6){ headCrashedSprite = new Sprite(textureAtlas.findRegion("tortueCrashedHead")); }
        if(choix == 7){ headCrashedSprite = new Sprite(textureAtlas.findRegion("aigleCrashedHead")); }
        if(choix == 8){ headCrashedSprite = new Sprite(textureAtlas.findRegion("perroquetCrashedHead")); }
        if(choix == 9){ headCrashedSprite = new Sprite(textureAtlas.findRegion("coqCrashedHead")); }
        if(choix == 10){ headCrashedSprite = new Sprite(textureAtlas.findRegion("crocoCrashedHead")); }
        if(choix == 11){ headCrashedSprite = new Sprite(textureAtlas.findRegion("oursCrashedHead")); }
        if(choix == 12){ headCrashedSprite = new Sprite(textureAtlas.findRegion("autrucheCrashedHead")); }
        if(choix == 13){ headCrashedSprite = new Sprite(textureAtlas.findRegion("babouinCrashedHead")); }
        if(choix == 14){ headCrashedSprite = new Sprite(textureAtlas.findRegion("baleineCrashedHead")); }
        if(choix == 15){ headCrashedSprite = new Sprite(textureAtlas.findRegion("bisonCrashedHead")); }
        if(choix == 16){ headCrashedSprite = new Sprite(textureAtlas.findRegion("caimanCrashedHead")); }
        if(choix == 17){ headCrashedSprite = new Sprite(textureAtlas.findRegion("calaoCrashedHead")); }
        if(choix == 18){ headCrashedSprite = new Sprite(textureAtlas.findRegion("chameauCrashedHead")); }
        if(choix == 19){ headCrashedSprite = new Sprite(textureAtlas.findRegion("chevreCrashedHead")); }
        if(choix == 20){ headCrashedSprite = new Sprite(textureAtlas.findRegion("cochonCrashedHead")); }
        if(choix == 21){ headCrashedSprite = new Sprite(textureAtlas.findRegion("colibriCrashedHead")); }
        if(choix == 22){ headCrashedSprite = new Sprite(textureAtlas.findRegion("corbeauCrashedHead")); }
        if(choix == 23){ headCrashedSprite = new Sprite(textureAtlas.findRegion("crapaudCrashedHead")); }
        if(choix == 24){ headCrashedSprite = new Sprite(textureAtlas.findRegion("dauphinCrashedHead")); }
        if(choix == 25){ headCrashedSprite = new Sprite(textureAtlas.findRegion("diplodocusCrashedHead")); }
        if(choix == 26){ headCrashedSprite = new Sprite(textureAtlas.findRegion("elanCrashedHead")); }
        if(choix == 27){ headCrashedSprite = new Sprite(textureAtlas.findRegion("elephantCrashedHead")); }
        if(choix == 28){ headCrashedSprite = new Sprite(textureAtlas.findRegion("espadonCrashedHead")); }
        if(choix == 29){ headCrashedSprite = new Sprite(textureAtlas.findRegion("fauconCrashedHead")); }
        if(choix == 30){ headCrashedSprite = new Sprite(textureAtlas.findRegion("gavialCrashedHead")); }
        if(choix == 31){ headCrashedSprite = new Sprite(textureAtlas.findRegion("gazelleCrashedHead")); }
        if(choix == 32){ headCrashedSprite = new Sprite(textureAtlas.findRegion("geckoCrashedHead")); }
        if(choix == 33){ headCrashedSprite = new Sprite(textureAtlas.findRegion("girafeCrashedHead")); }
        if(choix == 34){ headCrashedSprite = new Sprite(textureAtlas.findRegion("gnouCrashedHead")); }
        if(choix == 35){ headCrashedSprite = new Sprite(textureAtlas.findRegion("gorilleCrashedHead")); }
        if(choix == 36){ headCrashedSprite = new Sprite(textureAtlas.findRegion("hippopotameCrashedHead")); }
        if(choix == 37){ headCrashedSprite = new Sprite(textureAtlas.findRegion("hyeneCrashedHead")); }
        if(choix == 38){ headCrashedSprite = new Sprite(textureAtlas.findRegion("iguaneCrashedHead")); }
        if(choix == 39){ headCrashedSprite = new Sprite(textureAtlas.findRegion("kangourouCrashedHead")); }
        if(choix == 40){ headCrashedSprite = new Sprite(textureAtlas.findRegion("koalaCrashedHead")); }
        if(choix == 41){ headCrashedSprite = new Sprite(textureAtlas.findRegion("lapinCrashedHead")); }
        if(choix == 42){ headCrashedSprite = new Sprite(textureAtlas.findRegion("lionCrashedHead")); }
        if(choix == 43){ headCrashedSprite = new Sprite(textureAtlas.findRegion("mouetteCrashedHead")); }
        if(choix == 44){ headCrashedSprite = new Sprite(textureAtlas.findRegion("mureneCrashedHead")); }
        if(choix == 45){ headCrashedSprite = new Sprite(textureAtlas.findRegion("orangOutanCrashedHead")); }
        if(choix == 46){ headCrashedSprite = new Sprite(textureAtlas.findRegion("pandaCrashedHead")); }
        if(choix == 47){ headCrashedSprite = new Sprite(textureAtlas.findRegion("perroquetCrashedHead")); }
        if(choix == 48){ headCrashedSprite = new Sprite(textureAtlas.findRegion("pivertCrashedHead")); }
        if(choix == 49){ headCrashedSprite = new Sprite(textureAtlas.findRegion("pouleCrashedHead")); }
        if(choix == 50){ headCrashedSprite = new Sprite(textureAtlas.findRegion("raptorCrashedHead")); }
        if(choix == 51){ headCrashedSprite = new Sprite(textureAtlas.findRegion("renardCrashedHead")); }
        if(choix == 52){ headCrashedSprite = new Sprite(textureAtlas.findRegion("requinCrashedHead")); }
        if(choix == 53){ headCrashedSprite = new Sprite(textureAtlas.findRegion("sourisCrashedHead")); }
        if(choix == 54){ headCrashedSprite = new Sprite(textureAtlas.findRegion("stegosaureCrashedHead")); }
        if(choix == 55){ headCrashedSprite = new Sprite(textureAtlas.findRegion("tigreCrashedHead")); }
        if(choix == 56){ headCrashedSprite = new Sprite(textureAtlas.findRegion("toucanCrashedHead")); }
        if(choix == 57){ headCrashedSprite = new Sprite(textureAtlas.findRegion("triceratopsCrashedHead")); }
        if(choix == 58){ headCrashedSprite = new Sprite(textureAtlas.findRegion("vacheCrashedHead")); }
        if(choix == 59){ headCrashedSprite = new Sprite(textureAtlas.findRegion("varanCrashedHead")); }
        return headCrashedSprite;
    }
}