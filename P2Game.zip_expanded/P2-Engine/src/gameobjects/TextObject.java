package gameobjects;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.text.AttributedString;
import java.util.LinkedList;
import collider.*;
import controller.ObjectController;
import playground.Playground;
import rendering.*;

/**
 * Convenience Class subclassing {@link GameObject}, pre-creationg a subclass of {@link Artist} that
 * draws a text. The controller is left undefined, the collider as well. However, a single call to
 * the overwritten method {@link #generateColliders} will in fact generate a rect collider of just
 * the right size for the text.
 *
 */
public class TextObject extends GameObject {

  private String text = null;
  private int size = 1;
  private Color textColor = null;
  protected double rx, ry;

  public String getText() {
    return this.text;
  }

  /**
   * Constructor.
   * 
   * @param id object name
   * @param playground containing {@link Playground} instance
   * @param x positionx
   * @param y positiony
   * @param vx speedx
   * @param vy speedy
   * @param size font size in Pxiels
   * @param text String to be displayed
   * @param textColor text color, see java.awt.Color
   */
  public TextObject(String id, Playground playground, double x, double y, double vx, double vy,
      String text, int size, Color textColor) {
    super(id, playground, x, y, vx, vy);

    this.artist = new TextArtist(this, text, size, textColor);

    this.setColliders(new LinkedList<Collider>());

  }

  public TextObject generateColliders() {
    // damit man auf getTextWidth/Height zugreifen kann! this.artist ist vom Basistyp artist und hat
    // das nicht..
    TextArtist kruecke = (TextArtist) (this.artist);

    this.scol.clear();
    this.scol.add(new RectCollider("rect", this, kruecke.getTextWidth(), kruecke.getTextHeight()));
    return this;
  }


}
