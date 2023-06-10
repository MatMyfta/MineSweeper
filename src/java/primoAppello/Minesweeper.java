/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primoAppello;

/**
 *
 * @author acer
 */
public class Minesweeper {
    public final int MAXDIM = 9;
    public Cell[][] emptyField;
    
    public Field field;

    public Minesweeper() {
        this.emptyField = new Cell[MAXDIM][MAXDIM];
        
        for (int i = 0; i < MAXDIM; i++) {
            for (int j = 0; j < MAXDIM; j++) {
                emptyField[i][j] = new Cell(i,j,' ');
            }
        }
        this.field = new Field(MAXDIM);
    }
}
