package com.estef.tetris.domain.checkout;

import com.estef.tetris.domain.Point;
import com.estef.tetris.utils.Handle;

public class ReturnFalseHandle extends Handle<Point, Boolean> {
  @Override
  public Boolean run(Point value) {
    return false;
  }
}
