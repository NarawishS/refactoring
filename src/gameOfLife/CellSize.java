package gameOfLife;

/**
 * resolution enum for cell size
 */
public enum CellSize {
    Small(5),
    Medium(10),
    Large(20);

    final int size;

    CellSize(int size) {
        this.size = size;
    }
}

