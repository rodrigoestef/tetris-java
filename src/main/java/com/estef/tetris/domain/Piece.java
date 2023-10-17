package com.estef.tetris.domain;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;

public class Piece {

  private final List<Point> points;

  private final Color color;

  public Piece(Point p1, Point p2, Point p3, Point p4, Color color) {

    this.color = color;

    this.points = List.of(p1, p2, p3, p4);

  }

  public Color getColor(){
    return this.color;
  }

  public Piece rotate() {

    var points =  this.points.stream().map(Point::rotate).toList();


    return new Piece(points.get(0), points.get(1), points.get(2), points.get(3),this.color);
  }

  public Iterator<Point> getPoints() {
    return this.points.iterator();
  }

}
