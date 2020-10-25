# Game of life
From Narawish's game of life code: [repo](https://github.com/NarawishS/pa4-NarawishS)

### remove redundant code
This is code is use before in development process
in Grid.java remove them.
```
/**
* Set cell to Alive
*/
public void setAlive(int x, int y) {
    setState(x, y, ALIVE);
}
```
```
/**
 * Set cell to Dead
 */
public void setDead(int x, int y) {
    setState(x, y, DEAD);
}
```
```
/**
 * Print view of board in console.
 */
public void printGrid() {
    StringBuilder line = new StringBuilder();
    System.out.println("---");
    for (int y = 0; y < height; y++) {
        line.delete(0, line.length());
        line.append("|");
        for (int x = 0; x < width; x++) {
            if (this.grid[x][y] == DEAD) {
                line.append("*");
            } else {
                line.append(".");
            }
        }
        line.append("|");
        System.out.println(line.toString());
    }
    System.out.println("---\n");
}
```
### Separate file to match their use
In `StartView.java` there are two enum separate them into `Size.java` and `CellSize.java`
```
/**
 * Size enum of canvas
 */
public enum Size {
    Small_800x400(800, 400),
    Medium_1000x600(1000, 600),
    Large_1200x800(1200, 800),
    FullScreen((int) (Mainview.SCREEN_X - (Mainview.SCREEN_X % 20)), (int) (Mainview.SCREEN_Y - (Mainview.SCREEN_Y % 20) - 20));

    final int width;
    final int height;

    Size(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
```
```
/**
 * resolution enum for cell size
 */
public enum CellSize {
    Small(5),
    Medium(10),
    Large(20);

    private final int size;

    CellSize(int size) {
        this.size = size;
    }
}
```

### Change location of attribute
In `Mainview.java` screen resolution should be in enum Size in `Size.java`
```
/**
 * resolution of screen width
 */
static final double SCREEN_X = Screen.getPrimary().getVisualBounds().getMaxX();
/**
 * resolution of screen height
 */
static final double SCREEN_Y = Screen.getPrimary().getVisualBounds().getMaxY();
```

### In enum Size.java FULLSCREEN value
extract width and height of FULLSCREEN to separate method.
```
FullScreen((int) (Mainview.SCREENX - (Mainview.SCREENX % 20)), (int) (Mainview.SCREENY - (Mainview.SCREENY % 20) - 20));
```
to
```
FullScreen(getComputeScreenX(), getComputeScreenY());
...
private static int getComputeScreenX() {
    double screenX = Screen.getPrimary().getVisualBounds().getMaxX();
    return (int) (screenX - (screenX % 20));
}

private static int getComputeScreenY() {
    double screenY = Screen.getPrimary().getVisualBounds().getMaxY();
    return (int) (screenY - (screenY % 20) - 20);
}
```
