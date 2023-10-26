package com.estef.tetris.domain.checkout;

import com.estef.tetris.domain.Point;
import com.estef.tetris.utils.Handle;

public class DownHandle extends Handle<Point,Boolean>{
 @Override
 public Boolean run(Point value) {
  

    if (value.getY() < 0) {
      return true;
    }

    return super.run(value);
 } 
}
