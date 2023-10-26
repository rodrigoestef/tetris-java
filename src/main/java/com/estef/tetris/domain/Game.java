package com.estef.tetris.domain;

import java.util.ArrayList;
import java.util.List;
import com.estef.tetris.domain.pieces.*;

public class Game {
  private Piece currentPiece;
  private Piece nextPiece;
  private List<Point> points;

  public Game() {
    this.currentPiece = new Cube();
    this.nextPiece = new Ele();
    this.points = new ArrayList<Point>();
  }

  public Piece getCurrentPiece() {
    return this.currentPiece;
  }

  public Piece getNextPiece() {
    return this.nextPiece;
  }

  public List<Point> getPoints(){
    return this.points;
  }

  // private Game(Piece currentPiece, Piece nextPiece, List<Point> points) {
  //   this.currentPiece = currentPiece;
  //   this.nextPiece = nextPiece;
  //   this.points = points;
  // }

}
