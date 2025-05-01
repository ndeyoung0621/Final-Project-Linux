package edu.gonzaga;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.awt.Point;

/** No Swing, no KeyEvent, pure logic. */
public class BlockMovementTest {

    private final GridPad pad = new GridPad(10, 40);

    @Test
    void leftMoveChangesCenter() {
        BlockL b = new BlockL(pad.getGridBlocks(), new Point(4, 0));
        pad.addABlock(b);
        b.moveLeft();
        Assertions.assertEquals(new Point(3, 1), b.getCenter());
    }

    @Test
    void rightMoveChangesCenter() {
        BlockL b = new BlockL(pad.getGridBlocks(), new Point(4, 0));
        pad.addABlock(b);
        b.moveRight();
        Assertions.assertEquals(new Point(5, 1), b.getCenter());
    }

    @Test
    void clockwiseRotationUpdatesCenter() {
        BlockL b = new BlockL(pad.getGridBlocks(), new Point(4, 0));
        pad.addABlock(b);
        b.rotate(1);
        Assertions.assertEquals(new Point(4, 1), b.getCenter());
    }

    @Test
    void counterRotationRestoresCenter() {
        BlockL b = new BlockL(pad.getGridBlocks(), new Point(4, 0));
        pad.addABlock(b);
        b.rotate(1);
        b.rotate(2);
        Assertions.assertEquals(new Point(4, 1), b.getCenter());
    }
}