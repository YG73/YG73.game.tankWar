import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    HeroTank heroTank = null ;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemySize = 3;
    public MyPanel(){//用构造器完成坦克的初始化
        heroTank = new HeroTank(100,100,0);//创建初始坦克
        for(int i = 0 ; i < enemySize ; i ++){
            enemyTanks.add(new EnemyTank( (100*(i+1) ) , 0 ) );
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1000,750);//圈出坦克的活动范围
        drawTank(heroTank.getX() , heroTank.getY() , g , 0,heroTank.getDirect());
        Iterator<EnemyTank> iterator = enemyTanks.iterator();
        while (iterator.hasNext()) {//用it遍历将集合里面的坦克取出
            EnemyTank enemyTank =  iterator.next();
            drawTank(enemyTank.getX(),enemyTank.getY(),g,1,enemyTank.getDirect());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W){
            heroTank.setDirect(0);
            heroTank.move_UP();
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S){
            heroTank.setDirect(2);
            heroTank.move_DOWN();
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A){
            heroTank.setDirect(3);
            heroTank.move_LEFT();
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D){
            heroTank.setDirect(1);
            heroTank.move_RIGHT();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    //x-坦克左上角的x坐标
    //y-坦克左上角的y坐标
    //g-画笔
    //type-坦克类型
    // direct-坦克行进的方向
    public void drawTank(int x , int y , Graphics g , int type ,int direct){
        switch (type) {
            case 0:
                //heroTank
                g.setColor(Color.cyan);
                break;
            case 1:
                //敌方坦克
                g.setColor(Color.yellow);
                break;
            default:
        }

        //根据方向，绘制坦克
        //direct表示坦克方向（0—向上 1-向右 2-向下 3-向左）
        switch (direct){
            case 0:
                g.fill3DRect(x , y ,10 ,60 ,false);//坦克左轮
                g.fill3DRect(x+30 ,y,10 ,60 ,false);//坦克右轮
                g.fill3DRect(x+10 ,y + 10,20 ,40 ,false);//坦克主体
                g.fillOval(x+10,y+20,20,20);//坦克盖子
                g.drawLine(x+20,y+30,x+20,y);//坦克炮塔
                break;
            case 1:
                g.fill3DRect(x , y ,60 ,10 ,false);//坦克左轮
                g.fill3DRect(x ,y+30,60 ,10 ,false);//坦克右轮
                g.fill3DRect(x+10 ,y + 10,40 ,20 ,false);//坦克主体
                g.fillOval(x+20,y+10,20,20);//坦克盖子
                g.drawLine(x+30,y+20,x+60,y+20);//坦克炮塔
                break;
            case 2:
                g.fill3DRect(x , y ,10 ,60 ,false);//坦克左轮
                g.fill3DRect(x+30 ,y,10 ,60 ,false);//坦克右轮
                g.fill3DRect(x+10 ,y + 10,20 ,40 ,false);//坦克主体
                g.fillOval(x+10,y+20,20,20);//坦克盖子
                g.drawLine(x+20,y+30,x+20,y+60);//坦克炮塔
                break;
            case 3 :
                g.fill3DRect(x , y ,60 ,10 ,false);//坦克左轮
                g.fill3DRect(x ,y+30,60 ,10 ,false);//坦克右轮
                g.fill3DRect(x+10 ,y + 10,40 ,20 ,false);//坦克主体
                g.fillOval(x+20,y+10,20,20);//坦克盖子
                g.drawLine(x+30,y+20,x,y+20);//坦克炮塔
                break;
            default:
        }
    }

}
