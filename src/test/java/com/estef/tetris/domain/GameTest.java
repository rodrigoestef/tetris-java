package com.estef.tetris.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.estef.tetris.domain.pieces.Ele;

public class GameTest {

  @Test
  public void reOrderTest() {
    var a = new ArrayList<Point>();
    a.add(new Point(1, 3));
    a.add(new Point(3, 3));
    a.add(new Point(5, 3));
    a.add(new Point(9, 3));
    a.add(new Point(11, 3));
    a.add(new Point(13, 3));
    a.add(new Point(15, 3));
    a.add(new Point(1, 1));
    a.add(new Point(3, 1));
    a.add(new Point(5, 1));
    a.add(new Point(7, 1));
    a.add(new Point(9, 1));
    a.add(new Point(11, 1));
    a.add(new Point(13, 1));
    a.add(new Point(15, 1));
    var game = new Game(new Ele(), new Ele(), a);

    assertEquals(7, game.getPoints().size());

    game.getPoints().forEach(p -> {
      assertEquals(1, p.getY());
    });

  }

  @Test
  public void sortErrorTest() {

    var a = new ArrayList<Point>();
    a.add(new Point(1, 3));
    a.add(new Point(3, 3));
    a.add(new Point(5, 3));
    a.add(new Point(7, 3));
    a.add(new Point(9, 3));
    a.add(new Point(11, 3));
    a.add(new Point(13, 3));
    a.add(new Point(13, 5));
    a.add(new Point(15, 3));
    a.add(new Point(1, 1));
    a.add(new Point(3, 1));
    a.add(new Point(5, 1));
    a.add(new Point(7, 1));
    a.add(new Point(9, 1));
    a.add(new Point(11, 1));
    a.add(new Point(13, 1));
    a.add(new Point(15, 1));
    var y = new Game(new Ele(), new Ele(), a).getPoints().get(0).getY();

    assertEquals(1, y);

  }

}
