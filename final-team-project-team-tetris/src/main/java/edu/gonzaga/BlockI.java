package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockI extends Block {

    public BlockI(GridBlock[][] gridBlocks, Point spawnPoint) {
        super(gridBlocks, spawnPoint, new Color(0, 255, 255));
        shape = new ArrayList<Point>();
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(bias.x, 1 + bias.y));
        shape.add(new Point(bias.x, 2  + bias.y));
        shape.add(new Point(bias.x, 3 + bias.y));

    }

    @Override
    public void rotate(int direction) {
        direction = Math.abs(direction) - 2;
        super.rotate(direction, shape.get(2));
    }

    @Override
    public Point getCenter() {
        return shape.get(2);
    }

    @Override
    public int getType() {
        return 2;
    }


}
