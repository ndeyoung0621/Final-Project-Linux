package edu.gonzaga;

import java.awt.*;
import java.util.ArrayList;

public class BlockL extends Block {
    public BlockL(GridBlock[][] gridBlocks, Point spawnPoint) {
        super(gridBlocks, spawnPoint, new Color(255, 127, 0));
        shape = new ArrayList<Point>();
        shape.add(new Point(bias.x, bias.y));
        shape.add(new Point(bias.x, 1 + bias.y));
        shape.add(new Point(bias.x, 2 + bias.y));
        shape.add(new Point(1 + bias.x, 2 + bias.y));

    }

    @Override
    public void rotate(int direction) {
        super.rotate(direction, shape.get(1));
    }

    @Override
    public Point getCenter() {
        return shape.get(1);
    }

    @Override
    public int getType() {
        return 1;
    }


}
