package com.mygdx.game.Modele;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;

public interface Collectable {

    float getPositionX();

    Polygon getCollisionRectangle();

    void draw(SpriteBatch batch);

    void updateFrame();

    String getCollectableIdentifier();


}
