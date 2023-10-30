package com.estef.tetris.domain.checkpoints;

import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;

import com.estef.tetris.domain.Point;
import com.estef.tetris.utils.Handle;

public class RemoveLinesHandle extends Handle<List<Point>, Void> implements Consumer<Point> {

  public RemoveLinesHandle() {
    this.setNext(new DoNottingHandle());
  }

  private HashSet<Integer> knowLines = new HashSet<Integer>();

  @Override
  public Void run(List<Point> points) {

    points.forEach(this);

    this.knowLines.forEach(line -> {
      var linePoints = points.stream().filter(p -> p.filterLine(line)).toList();
      if (linePoints.size() == 8) {
        points.removeAll(linePoints);
      }
    });

    return super.run(points);
  }

  @Override
  public void accept(Point p) {
    this.knowLines.add(p.getY());
  }
}
