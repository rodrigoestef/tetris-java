package com.estef.tetris.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.estef.tetris.domain.checkpoints.GravityPointsHandle;
import com.estef.tetris.domain.checkpoints.RemoveLinesHandle;
import com.estef.tetris.domain.checkpoints.RemovePointsModel;
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

    var hasCollision = this.points.stream().filter(game.getCurrentPiece()::colision).toList().size() > 0 ? true : false;

    if (hasCollision || game.currentPiece.equals(this.currentPiece)) {
      this.points.addAll(this.currentPiece.getPoints().toList());
      return new Game(this.nextPiece, this.getRandonPiece(), this.points);
    }

    return game;

  }

  public Game rotate() {
    return new Game(this.currentPiece.rotate(), this.nextPiece, this.points);
  }

  public Game right() {

    var game = new Game(this.currentPiece.right(), this.nextPiece, this.points);

    var hasCollision = this.points.stream().filter(game.getCurrentPiece()::colision).toList().size() > 0 ? true : false;
    
    if (hasCollision) {
      this.points.addAll(this.currentPiece.getPoints().toList());
      return new Game(this.nextPiece, this.getRandonPiece(), this.points);
    }

    return game;
  }

  public Game left() {
    var game = new Game(this.currentPiece.left(), this.nextPiece, this.points);

    var hasCollision = this.points.stream().filter(game.getCurrentPiece()::colision).toList().size() > 0 ? true : false;
    
    if (hasCollision) {
      this.points.addAll(this.currentPiece.getPoints().toList());
      return new Game(this.nextPiece, this.getRandonPiece(), this.points);
    }

    return game;
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

  public Game(Piece currentPiece, Piece nextPiece, List<Point> points) {
    this.currentPiece = currentPiece;
    this.nextPiece = nextPiece;
    this.points = points;

    var handle = new RemoveLinesHandle();

    handle.setNext(new GravityPointsHandle());

    handle.run(new RemovePointsModel(points, new ArrayList<Integer>()));
  }

}
