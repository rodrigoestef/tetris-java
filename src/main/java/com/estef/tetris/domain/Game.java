package com.estef.tetris.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.estef.tetris.domain.pieces.Cube;
import com.estef.tetris.domain.pieces.Ele;
import com.estef.tetris.domain.pieces.Line;
import com.estef.tetris.domain.pieces.Paralel;
import com.estef.tetris.domain.pieces.Scade;

public class Game {
  private Piece currentPiece;
  private Piece nextPiece;
  private List<Point> points;

  private Random random = new Random();

  private Class<?>[] pieces = { Cube.class, Ele.class, Line.class, Paralel.class, Scade.class };

  public Game() {
    this.currentPiece = new Ele();
    this.nextPiece = new Ele();
    this.points = new ArrayList<Point>();
    this.currentPiece = this.getRandonPiece();
    this.nextPiece = this.getRandonPiece();

  }

  private Piece getRandonPiece() {
    int i = this.random.nextInt();
    int index = Math.abs(i) % this.pieces.length;

    try {
      return (Piece) this.pieces[index].getConstructor().newInstance();
    } catch (Exception e) {
      System.err.println(e);
      System.exit(0);
      return new Cube();
    }
  }

  public Game down() {
    var game = new Game(this.currentPiece.down(), this.nextPiece, this.points);

    if (game.currentPiece.equals(this.currentPiece)) {
      this.points.addAll(this.currentPiece.getPoints().toList());
      return new Game(this.nextPiece, this.getRandonPiece(), this.points);
    }

    return game;

  }

  public Game rotate() {
    return new Game(this.currentPiece.rotate(), this.nextPiece, this.points);
  }

  public Game right() {
    return new Game(this.currentPiece.right(), this.nextPiece, this.points);
  }

  public Game left() {
    return new Game(this.currentPiece.left(), this.nextPiece, this.points);
  }

  public Piece getCurrentPiece() {
    return this.currentPiece;
  }

  public Piece getNextPiece() {
    return this.nextPiece;
  }

  public List<Point> getPoints() {
    return this.points;
  }

  private Game(Piece currentPiece, Piece nextPiece, List<Point> points) {
    this.currentPiece = currentPiece;
    this.nextPiece = nextPiece;
    this.points = points;
  }

}
