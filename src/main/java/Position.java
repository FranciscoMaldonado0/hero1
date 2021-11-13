public class Position {
    private int x,y;
    public Position(){
        this.x = 10;
        this.y = 10;
    }
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
