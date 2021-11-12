import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.security.Key;

public class Game {
    public Screen screen;
    Hero hero;
    public Game() throws IOException {
        try {
            hero = new Hero(10, 10);
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();

            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            terminal = terminalFactory.createTerminal();

            screen.clear();
            screen.setCharacter(10, 10, TextCharacter.fromCharacter('X')[0]);screen.refresh();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }
    public void run() throws IOException{
        while(true){
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
            if(key.getKeyType() == KeyType.Character)
                break;
        }

    }
    private void processKey(KeyStroke key) throws IOException{
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowUp)
            hero.moveUp();
        else if (key.getKeyType() == KeyType.ArrowDown)
            hero.moveDown();
        else if (key.getKeyType() == KeyType.ArrowLeft)
            hero.moveLeft();
        else if (key.getKeyType() == KeyType.ArrowRight)
            hero.moveRight();
    }
}
