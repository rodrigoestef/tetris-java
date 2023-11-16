package com.estef.tetris.domain;

import java.awt.Color;

import com.estef.tetris.domain.checkout.FactoryCheckout;
import com.estef.tetris.utils.Handle;

public class Point {

  private Handle<Point, Boolean> checkoutHandle = FactoryCheckout.create();

  public static final int R = 20;
  public static final int D = Point.R * 2;
  public static final int W = Point.D * 8;
  public static final int H = Point.D * 12;

  public final int x;

  public final int y;

  public final Color color;

  public Point(int x, int y, Color color) {

    this.x = x;
    this.y = y;

    this.color = color;
  }

  public Point rotate() {
    return new Point(-y, x, this.color);
  }

  @Override
  public int hashCode() {
    return this.x * 3 + this.y * 7;
  }

  @Override
  public boolean equals(Object obj) {

    Point o = (Point) obj;

    return o.x == this.x && o.y == this.y;
  }

  public Point down() {
    return new Point(x, y - 2, color);
  }

  public boolean outGrid() {

    return this.checkoutHandle.run(this);

  }

  public boolean filterLine(int i) {
    return this.getY() == i;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  @Override
  public String toString() {
    return "( " + x + " , " + y + " )";
  }

}
