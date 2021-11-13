import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    int x,y;
    Position position = new Position();
    public Wall(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void draw(TextGraphics graphics){
        graphics.putString(new TerminalPosition(x, y), "|");
    }
}
