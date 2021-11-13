import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
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
    Arena arena;
    public Game() throws IOException {
        try {
            hero = new Hero(10, 10);
            arena = new Arena(20, 40);
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();
            screen.doResizeIfNecessary();
            TerminalSize terminalSize = new TerminalSize(40, 20);
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
            terminal = terminalFactory.createTerminal();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void draw() throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }
    public void run() throws IOException{
        while(true){
            draw();
            KeyStroke key = screen.readInput();
            arena.processKey(key);
            if (key.getKeyType() == KeyType.EOF)
                break;
        }

    }


}
