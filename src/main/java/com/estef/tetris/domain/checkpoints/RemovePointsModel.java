package com.estef.tetris.domain.checkpoints;

import java.util.List;

import com.estef.tetris.domain.Point;

public class RemovePointsModel {

  public RemovePointsModel(List<Point> points, List<Integer> linesRemoved) {
    this.points = points;
    this.linesRemoved = linesRemoved;
  }

  public final List<Point> points;
  public final List<Integer> linesRemoved;
}
