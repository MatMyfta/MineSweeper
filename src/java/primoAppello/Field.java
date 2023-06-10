package primoAppello;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class Field {
    public int maxDim;
    public final int MAXBOMB = 10;
    public Cell[][] field;
    List<Cell> dumpList = new ArrayList<>();
    List<Bomb> bombList = new ArrayList<>();
    
    public Field(int maxDim) {
        this.maxDim = maxDim;
        this.field = new Cell[maxDim][maxDim];
        
        fillWithBombs();
        countNeighbours();
    }
    
    private void fillWithBombs() {
        for (int i = 0; i < maxDim; i++) {
            for (int j = 0; j < maxDim; j++) {
                Cell c = new Cell(i,j);
                field[i][j] = c;
                dumpList.add(c);
            }
        }
        Collections.shuffle(dumpList);
        for (int i = 0; i < MAXBOMB; i++) {
            Cell temp = dumpList.remove(0);
            field[temp.x][temp.y] = new Bomb(temp.x, temp.y);
            bombList.add((Bomb) field[temp.x][temp.y]);
        }
    }
    
    private void countNeighbours() {
        for (Bomb b : bombList) {
            if (b.x+1 < maxDim && b.y+1 < maxDim)   incrementNeigh(b.x+1,b.y+1);
            if (b.x+1 < maxDim)                     incrementNeigh(b.x+1,b.y);
            if (b.x+1 < maxDim && b.y-1 >= 0)       incrementNeigh(b.x+1,b.y-1);
            if (b.y+1 < maxDim)                     incrementNeigh(b.x,b.y+1);
            if (b.y-1 >= 0)                         incrementNeigh(b.x,b.y-1);
            if (b.x-1 >= 0 && b.y+1 < maxDim)       incrementNeigh(b.x-1,b.y+1);
            if (b.x-1 >= 0)                         incrementNeigh(b.x-1,b.y);
            if (b.x-1 >= 0 && b.y-1 >= 0)           incrementNeigh(b.x-1,b.y-1);
        }
    }
    
    private void incrementNeigh(int x, int y) {
        if (!(field[x][y] instanceof Bomb)) {
            field[x][y].counter++;
        }
    }
    
    public Integer getCell(int x, int y) {
        return this.field[x][y].counter;
    }
    
    public String getValue(int x, int y) {
        int c = getCell(x,y);
        
        if (c < 0) return "B";
        else return Integer.toString(c);
    }
    
}
