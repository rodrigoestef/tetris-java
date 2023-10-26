package com.estef.tetris.domain;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Piece implements Function<Point, Point> {

  private final List<Point> points;

  private final Color color;

  private int x = 0;

  private int y = 24;

  public Piece(Point p1, Point p2, Point p3, Point p4, Color color) {

    this.color = color;

    this.points = List.of(p1, p2, p3, p4);

  }

  private Piece(Point p1, Point p2, Point p3, Point p4, Color color, int x, int y) {

    this.color = color;

    this.points = List.of(p1, p2, p3, p4);
    this.x = x;
    this.y = y;
  }

  public void setX(int x) {
    this.x = this.x + x;
  }

  public Piece down() {
    var newPiece = new Piece(this.points.get(0), this.points.get(1), this.points.get(2), this.points.get(3), this.color,
        this.x,
        this.y - 2);

    if(newPiece.getY() < 0){
      return this;
    }

    return newPiece;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public Color getColor() {
    return this.color;
  }

  public Piece rotate() {

    var points = this.points.stream().map(Point::rotate).toList();

    return new Piece(points.get(0), points.get(1), points.get(2), points.get(3), this.color, this.x, this.y);
  }

  public Iterator<Point> getPoints() {
    return this.points.stream().map(this).iterator();
  }

  public Iterator<Point> getCentralyPoints() {
    return this.points.stream().iterator();
  }

  @Override
  public String toString() {
    return "" + this.x + " " + this.y;
  }

  @Override
  public boolean equals(Object obj) {

    Piece p = (Piece) obj;

    var x = p.getX();
    var y = p.getY();

    return this.x == x && this.y == y;
  }

  @Override
  public Point apply(Point p) {
    var x = p.x + this.x;

    if (x % 2 == 0)
      x++;

    var y = p.y + this.y;

    if (y % 2 == 0)
      y++;

    return new Point(x, y);
  }

}
