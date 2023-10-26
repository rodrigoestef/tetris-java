package com.estef.tetris.domain.checkout;

import com.estef.tetris.domain.Point;
import com.estef.tetris.utils.Handle;

public class FactoryCheckout {
  public static Handle<Point, Boolean> create() {
    var handle = new DownHandle();

    handle
        .setNext(new RightHandle())
        .setNext(new LeftHandle())
        .setNext(new ReturnFalseHandle());

    return handle;
  }
}
