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

  private boolean gameOver = false;

  private Random random = new Random();

  private Class<?>[] pieces = { Cube.class, Ele.class, Line.class, Paralel.class, Scade.class };

  public Game() {
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


    if(this.gameOver){
      return this;
    }

    var game = new Game(this.currentPiece.down(), this.nextPiece, this.points);

    var hasCollision = this.points.stream().filter(game.getCurrentPiece()::colision).toList().size() > 0 ? true : false;

    if (hasCollision || game.currentPiece.equals(this.currentPiece)) {
      this.points.addAll(this.currentPiece.getPoints().toList());
      return new Game(this.nextPiece, this.getRandonPiece(), this.points);
    }

    return game;

  }

  public Game rotate() {
    
    if(this.gameOver){
      return this;
    }

    var game = new Game(this.currentPiece.rotate(), this.nextPiece, this.points);

    if (game.hasCollision()){
      return this;
    }

      return game;
  }

  public Game right() {

    if(this.gameOver){
      return this;
    }

    var game = new Game(this.currentPiece.right(), this.nextPiece, this.points);

    var hasCollision = this.points.stream().filter(game.getCurrentPiece()::colision).toList().size() > 0 ? true : false;

    if (hasCollision) {
      this.points.addAll(this.currentPiece.getPoints().toList());
      return new Game(this.nextPiece, this.getRandonPiece(), this.points);
    }

    return game;
  }

  public Game left() {

    if(this.gameOver){
      return this;
    }

    var game = new Game(this.currentPiece.left(), this.nextPiece, this.points);

    var hasCollision = this.points.stream().filter(game.getCurrentPiece()::colision).toList().size() > 0 ? true : false;

    if (hasCollision) {
      this.points.addAll(this.currentPiece.getPoints().toList());
      return new Game(this.nextPiece, this.getRandonPiece(), this.points);
    }

    return game;
  }

  public boolean hasCollision() {
    return this.points.stream().filter(this.getCurrentPiece()::colision).toList().size() > 0 ? true : false;
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

  public boolean isGameOver(){
    return this.gameOver;
  }

  public Game(Piece currentPiece, Piece nextPiece, List<Point> points) {
    this.currentPiece = currentPiece;
    this.nextPiece = nextPiece;
    this.points = points;

    var handle = new RemoveLinesHandle();

    handle.setNext(new GravityPointsHandle());

    handle.run(new RemovePointsModel(points, new ArrayList<Integer>()));
  
    if(this.hasCollision()){
      this.gameOver = true;
    }

  }

}
