package com.mygdx.game.Outils;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SheetToFramer {
    /**
     * Stocke dans tableau à une dimension le frameSheet
     * après l'avoir splitté dans tableau temporaire à 2 dimensions
     */
    public static TextureRegion[] sheetToFrame(Texture frameSheet, int nbRangeesArrayTemp, int nbColonnesArrayTemp){
        TextureRegion[] textureRegionArray = new TextureRegion[nbColonnesArrayTemp*nbRangeesArrayTemp];
        TextureRegion[][] textureRegions = TextureRegion.split(frameSheet,frameSheet.getWidth()/nbColonnesArrayTemp,frameSheet.getHeight()/nbRangeesArrayTemp);
        int index = 0;
        for (int i = 0; i < nbRangeesArrayTemp; i++){
            for (int j = 0; j < nbColonnesArrayTemp; j++){
                textureRegionArray[index++] = textureRegions[i][j];
            }
        }
        return textureRegionArray;
    }
}
