package reiknirit.s1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by hjaltisteinar on 31.8.2016.
 */

public class Percolation {
    
    private int gridSize;
    private boolean[][] theGrid;
    private WeightedQuickUnionUF unionGrid;
    private int openCount;
    private int TOP_CELL;
    private int BOTTOM_CELL;
    
    public static void main(String[] args) {
        
        Percolation p  = new Percolation(5);
        p.open(0,1);
        p.open(1,1);
        p.open(2,1);
        p.open(3,1);
        p.open(4,1);
        
        System.out.println(p.isFull(1,1));
        System.out.println(p.isFull(3,1));
        System.out.println(p.isFull(4,1));
        
        System.out.println(p.percolates());
        
    }
    
    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        
        this.unionGrid = new WeightedQuickUnionUF((n * n) + 2);
        this.gridSize = n;
        this.theGrid = new boolean[n][n];
        this.TOP_CELL = (n * n);
        this.BOTTOM_CELL = (n * n) + 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                theGrid[i][j] = false;
            }
        }
        
        for (int i = 0; i < n; i++) {
            addUnion(numberFromCoordinates(0,i),TOP_CELL);
            addUnion(numberFromCoordinates(gridSize - 1,i),BOTTOM_CELL);
        }
    }
    
    public void open(int row, int col) {
        if (!isValid(row,col))
            throw new IndexOutOfBoundsException();
        
        if (isOpen(row, col))
            return;
        
        theGrid[row][col] = true;
        openCount+= 1;
        checkSurroundingsFrom(row,col);
    }
    
    public boolean isOpen(int row, int col) {
        if (!isValid(row,col))
            throw new IndexOutOfBoundsException();
        return theGrid[row][col];
    }
    
    public boolean isFull(int row, int col) {
        if (!isValid(row,col))
            throw new IndexOutOfBoundsException();
        return isConnected(numberFromCoordinates(row,col), TOP_CELL);
    }
    
    public int numberOfOpenSites() {
        return openCount;
    }
    
    public boolean percolates() {
        return isConnected(TOP_CELL, BOTTOM_CELL);
    }
    
    private boolean isValid(int row, int col){
        if (row < 0 || col < 0 || row >= gridSize || col >= gridSize)
            return false;
        return true;
    }
    
    private int numberFromCoordinates(int row, int col){
        return (row) * gridSize + col;
    }
    
    private void checkSurroundingsFrom(int row, int col){
        
        int factorX = 0;
        int factorY = 0;
        int loops = 4;
        for (int i = 0; i<= loops - 1; i++){
            
            switch (i){
                case 0: factorX = 1; factorY = 0;
                    break;
                case 1: factorX = -1; factorY = 0;
                    break;
                case 2: factorX = 0; factorY = -1;
                    break;
                case 3: factorX = 0; factorY = 1;
                    break;
                default: break;
            }
            
            if (row == 0 && factorY == -1 ){
                continue;
            }
            if (row == gridSize -1 && factorY == 1 ){
                continue;
            }
            
            if (isValid(row + factorY, col + factorX)){
                if (isOpen(row + factorY, col+ factorX)){
                    if (row == 0 || row == gridSize - 1)
                        continue;
                    else
                        addUnion(numberFromCoordinates(row, col), numberFromCoordinates(row + factorY, col + factorX));
                }
            }
        }
    }
    
    private void addUnion(int y, int x){
        if (!unionGrid.connected(y, x))
            unionGrid.union(y, x);
    }
    
    private boolean isConnected (int y, int x){
        return  unionGrid.connected(y, x);
    }
    
    private  void printDebug(String deb){
        System.out.println(deb);
    }
}
