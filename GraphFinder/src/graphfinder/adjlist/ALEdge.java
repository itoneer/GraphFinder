/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphfinder.adjlist;

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
    
    ALEdge (ALVertex source, ALVertex dest, boolean twoway, int length,
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
    
    public boolean isTwoWay() {
        return twoway;
    }
    
    public int getLength() {
        return length;
    }
    
    public int getSpeed() {
        return speed1;
    }
    
    public int getRTSpeed() {
        return speed2;
    }
    
    public boolean end (ALVertex v) {
        return source.equals(v) || dest.equals(v);
    }
    
    @Override
    public boolean equals (Object o) {
        if (!(o instanceof ALEdge)) return false;
        else return source.equals(((ALEdge) o).getSource()) || dest.equals(((ALEdge) o).getDest());
    }
    
    public int getTime(ALVertex v) {
        if (source.equals(v)) return length/speed1;
        else if (dest.equals(v) && twoway) return length/speed2;
        else return -1;
    }
    
    public ALVertex getOtherEnd (ALVertex v) {
        if (!end(v)) return null;
        if (dest.equals(v)) return source;
        else return dest;
    }
    
}
