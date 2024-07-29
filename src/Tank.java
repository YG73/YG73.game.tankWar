
public class Tank {
    private int x; //坦克的横坐标
    private int y; //坦克的纵坐标
    private int direct = 2;//direct表示坦克方向（0—向上 1-向右 2-向下 3-向左）
    private int speed = 3;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
    public void move_UP(){
        y -= speed;
    }
    public void move_DOWN(){
        y += speed;
    }
    public void move_LEFT(){
        x -= speed;
    }public void move_RIGHT(){
        x += speed;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
