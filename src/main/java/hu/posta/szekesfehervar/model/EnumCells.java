package hu.posta.szekesfehervar.model;

public enum EnumCells {
    WorkSheet(new int[][] {
        {1, 3},
        {2, 3},
        {3, 3},
        {4, 3},
        {5, 3},
        {6, 3},
        {7, 3},
        {8, 3},
        {9, 3},
        {10, 3},
        {11, 3},
        {12, 3},
        {1, 4},
        {2, 4},
        {13, 4},
        {14, 4}
    }),
    TYPE2(new int[][] {{7, 8}, {10, 11}});

    private final int[][] array;

    EnumCells(int[][] array) {
        this.array = array;
    }

    public int[][] getTwoDimensionalArray() {
        return array;
    }
}
