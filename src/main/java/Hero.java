import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    public Position position;
    public Hero(int x, int y){
        position= new Position(x,y);
    }
    public Hero(){this(10,10);}
    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public void setPosition(Position position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }
    public Position moveUp(){
        return new Position(getX(), getY()-1);
    }
    public Position moveDown(){
        return new Position(getX(), getY()+1);
    }
    public Position moveLeft(){
        return new Position(getX()-1, getY());
    }
    public Position moveRight(){
        return new Position(getX()+1, getY());
    }

    public void draw(TextGraphics graphics) {
        //graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter('Y')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");

    }
}
