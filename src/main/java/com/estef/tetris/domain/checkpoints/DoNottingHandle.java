package com.estef.tetris.domain.checkpoints;

import java.util.List;

import com.estef.tetris.domain.Point;
import com.estef.tetris.utils.Handle;

public class DoNottingHandle extends Handle<List<Point>, Void>{
 @Override
 public Void run(List<Point> value) {
  return null;
 } 
}
