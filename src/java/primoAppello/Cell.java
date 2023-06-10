package primoAppello;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acer
 */
public class Cell {
    public int x,y,counter;
    public char content;
    
    Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.counter = 0;
    }
    
    Cell(int x, int y, char c) {
        this(x,y);
        this.content = c;
    }

}
