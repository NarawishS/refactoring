package gameOfLife;

import javafx.stage.Screen;


/**
 * Size enum of canvas
 */
public enum Size {
    Small_800x400(800, 400),
    Medium_1000x600(1000, 600),
    Large_1200x800(1200, 800),
    FullScreen(getComputeScreenX(), getComputeScreenY());

    final int width;
    final int height;

    Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private static int getComputeScreenX() {
        double screenX = Screen.getPrimary().getVisualBounds().getMaxX();
        return (int) (screenX - (screenX % 20));
    }

    private static int getComputeScreenY() {
        double screenY = Screen.getPrimary().getVisualBounds().getMaxY();
        return (int) (screenY - (screenY % 20) - 20);
    }

}