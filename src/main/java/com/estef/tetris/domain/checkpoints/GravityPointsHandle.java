package com.estef.tetris.domain.checkpoints;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.estef.tetris.domain.Point;
import com.estef.tetris.utils.Handle;

public class GravityPointsHandle extends Handle<RemovePointsModel, Void>
    implements Consumer<Integer>, Comparator<Integer> {

  public GravityPointsHandle() {
    this.setNext(new DoNottingHandle());
  }

  private List<Point> points;

  @Override
  public Void run(RemovePointsModel value) {

    if (value.linesRemoved.size() == 0) {
      return super.run(value);
    }

    this.points = value.points;
    Collections.sort(value.linesRemoved, this);
    value.linesRemoved.forEach(this);

    return super.run(value);
  }

  @Override
  public void accept(Integer line) {

    var upers = this.points.stream().filter(p -> p.getY() > line).toList();

    this.points.removeAll(upers);

    this.points.addAll(upers.stream().map(p -> new Point(p.getX(), p.getY() - 2)).toList());

  }

  @Override
  public int compare(Integer o1, Integer o2) {

    return o2 - o1;

  }

}
