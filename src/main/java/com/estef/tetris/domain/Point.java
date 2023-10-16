package com.estef.tetris.domain;

public class Point {

  public final int x;

  public final int y;

  public Point(int x, int y) {

    this.x = x;
    this.y = y;

  }

  public Point rotate() {
    return new Point(-y, x);
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

  @Override
  public String toString() {
    return "( " + x + " , " + y + " )";
  }

}
