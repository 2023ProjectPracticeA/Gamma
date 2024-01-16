package step9_G6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
* 課題番号 ： 第 14 回 演習問題 G9-1
* ファイル名 ： ProgG61Image1.java
* 作成年月日 ： 2024 年 1 月 16 日
* 学生番号・氏名： 
* グループ ： Γ
*/

public class ProgG61Image1 extends JPanel {
    private static String fileName = "kittens.jpg";
    private int x = -10;
    private int y = -10;
    private BufferedImage image;
    private boolean isClicked = false;

    public ProgG61Image1() {
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isClicked = true;
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isClicked) {
            return;
        }

        g.setColor(Color.RED);
        g.drawLine(x - 10, y, x + 10, y);
        g.drawLine(x, y - 10, x, y + 10);
        if (image != null) {
            g.drawImage(image, x, y, this);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame(fileName + "： グループΓ" );
        frame.add(new ProgG61Image1());
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
