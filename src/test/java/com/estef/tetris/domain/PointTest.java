package com.estef.tetris.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PointTest {

  @Test
  public void testEqual() {

    assertEquals("test equals", new Point(0, 0), new Point(0, 0));

    Set<Point> s = new HashSet<Point>();

    s.add(new Point(0, 0));
    s.add(new Point(0, 0));

    assertEquals("hashCode", 1, s.size());

  }

  @Test
  public void rotate() {

    Point p = new Point(1, 0);

    Point p1 = p.rotate();

    Point p2 = p1.rotate();

    Point p3 = p2.rotate();

    assertEquals("rotate", new Point(0, 1), p1);

    assertEquals("rotate", new Point(-1, 0), p2);

    assertEquals("rotate", new Point(0, -1), p3);

    assertEquals("rotate", p, p3.rotate());
  }

  @Test
  public void getOut() {
    var in = new Point(1, 1).outGrid();
    var out = new Point(1, -1).outGrid();

    assertEquals(false, in);
    assertEquals(true, out);

  }

}
