
public class Shot implements Runnable{
    int x;
    int y;
    int direction = 0;
    int speed = 1 ;
    boolean isaLive = true ;

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        while (isaLive){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direction){
                case 0:
                    y -= speed;
                case 1:
                    x += speed;
                case 2:
                    y += speed;
                case 3:
                    x -= speed;
            }

            System.out.println("x=" + x + "y=" + y);
            if(!(x >= 0 &&x <= 1000 && y >=0 &&y <= 750 && isaLive) ){
                System.out.println("子弹线程退出！");
                isaLive = false;
                break;
            }
        }
    }
}
