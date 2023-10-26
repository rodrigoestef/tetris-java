package com.estef.tetris.domain.checkout;

import com.estef.tetris.domain.Point;
import com.estef.tetris.utils.Handle;

public class LeftHandle extends Handle<Point, Boolean> {
  @Override
  public Boolean run(Point value) {
    
    if (value.getX() > 8 * 2) {
      return true;
    }

    return super.run(value);
  }
}
