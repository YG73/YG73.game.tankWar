
import javax.swing.*;

public class TankGame01 extends JFrame {
    MyPanel mp = null;
    JFrame jf = null;
    public static void main(String[] args) {
        //启动坦克大战！
        TankGame01 tankGame01 = new TankGame01();
    }
    public TankGame01(){
        mp = new MyPanel();
        jf = new JFrame();
        jf.add(mp);
        jf.addKeyListener(mp);
        jf.setSize(1000,750);
        mp.setSize(1000,750);//坦克的游戏区域
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        mp.setVisible(true);
    }
}
