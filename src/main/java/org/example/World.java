package org.example;

public class World {
    private final int n, m;
    private char[][] board;
    //private Organism[] organisms;
    //private int organismCount;
    //private Report report;
    public World() {
        this.n = Defines.WORLD_N;
        this.m = Defines.WORLD_M;
        this.board = new char[Defines.WORLD_N][Defines.WORLD_M];
        //this.organisms = new Organism[Defines.MAX_AMOUNT_OF_ORGANISMS];
        //this.organismCount = 0;
        //this.report = new Report();
    }
    public void clearWorldBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = Defines.EMPTY_SPACE_CHAR;
            }
        }
    }
}
