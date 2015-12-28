/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder;

/**
 *
 * @author HP
 */
public class ALEdge {
    private final ALVertex source;
    private final ALVertex dest;
    private final boolean twoway;
    private final int length;
    private final int speed1;
    private final int speed2;
    
    public ALEdge (ALVertex source, ALVertex dest, boolean twoway, int length,
            int speed1, int speed2) {
        this.source = source;
        this.dest = dest;
        this.twoway = twoway;
        this.length = length;
        this.speed1 = speed1;
        if (twoway) this.speed2 = speed2;
        else this.speed2 = 0;
    }
    
    public ALVertex getSource() {
        return source;
    } 
    
    public ALVertex getDest() {
        return dest;
    }
    
    
}
