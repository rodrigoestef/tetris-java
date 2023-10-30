package com.estef.tetris.domain.checkpoints;

import java.util.HashSet;
import java.util.function.Consumer;

import com.estef.tetris.domain.Point;
import com.estef.tetris.utils.Handle;

public class RemoveLinesHandle extends Handle<RemovePointsModel, Void> implements Consumer<Point> {

  public RemoveLinesHandle() {
    this.setNext(new DoNottingHandle());
  }

  private HashSet<Integer> knowLines = new HashSet<Integer>();

  @Override
  public Void run(RemovePointsModel value) {

    var points = value.points;

    points.forEach(this);

    this.knowLines.forEach(line -> {
      var linePoints = points.stream().filter(p -> p.filterLine(line)).toList();
      if (linePoints.size() == 8) {
        points.removeAll(linePoints);
        value.linesRemoved.add(line);
      }
    });

    return super.run(value);
  }

  @Override
  public void accept(Point p) {
    this.knowLines.add(p.getY());
  }
}
