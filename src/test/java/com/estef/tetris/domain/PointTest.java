package com.estef.tetris.domain;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PointTest {

  @Test
  public void testEqual() {

    assertEquals("test equals", new Point(0, 0, Color.BLACK), new Point(0, 0, Color.BLACK));

    Set<Point> s = new HashSet<Point>();

    s.add(new Point(0, 0, Color.BLACK));
    s.add(new Point(0, 0, Color.BLACK));

    assertEquals("hashCode", 1, s.size());

  }

  @Test
  public void rotate() {

    Point p = new Point(1, 0, Color.BLACK);

    Point p1 = p.rotate();

    Point p2 = p1.rotate();

    Point p3 = p2.rotate();

    assertEquals("rotate", new Point(0, 1, Color.BLACK), p1);

    assertEquals("rotate", new Point(-1, 0, Color.BLACK), p2);

    assertEquals("rotate", new Point(0, -1, Color.BLACK), p3);

    assertEquals("rotate", p, p3.rotate());
  }

  @Test
  public void getOut() {
    var in = new Point(1, 1, Color.BLACK).outGrid();
    var out = new Point(1, -1, Color.BLACK).outGrid();

    var right = new Point(-1, 1, Color.BLACK).outGrid();
    var left = new Point(18, 1, Color.BLACK).outGrid();
    assertEquals(false, in);
    assertEquals("down", true, out);
    assertEquals("right", true, right);
    assertEquals("left", true, left);

  }

}
