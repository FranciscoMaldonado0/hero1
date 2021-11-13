import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    private Hero hero;
    Position position = new Position();
    private int height, width;
    public List<Wall> walls;
    public Arena(int height, int width){
        hero = new Hero();
        this.height = height;
        this.width = width;
        this.walls = createWalls();

    }
    public List<Wall> getPosition(){
        return walls;
    }
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0099"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width , height), ' ');
        //graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2 + 1), "/\\");
        for (Wall wall : walls)
            wall.draw(graphics);
        hero.draw(graphics);
    }
    private void moveHero(Position position){
        if(canHeroMove(position)){
            hero.setPosition(position);
        }
    }
    private boolean canHeroMove(Position position){
        if(position.getX() > 0 && position.getX() < width - 1 && position.getY() > 0 && position.getY() < height - 1)
            return true;
        return false;
    }
    public void processKey(KeyStroke key) throws IOException {
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowUp)
            moveHero(hero.moveUp());
        else if (key.getKeyType() == KeyType.ArrowDown)
            moveHero(hero.moveDown());
        else if (key.getKeyType() == KeyType.ArrowLeft)
            moveHero(hero.moveLeft());
        else if (key.getKeyType() == KeyType.ArrowRight)
            moveHero(hero.moveRight());
        }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;}


}
