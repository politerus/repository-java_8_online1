package ua.com.alevel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class TankGame extends JPanel implements KeyListener, ActionListener {
    private int tankX = 100;
    private int tankY = 100;
    private int tankSpeed = 5;
    private int bulletX = -1;
    private int bulletY = -1;
    private boolean shooting = false;
    private Image tankImage;
    private Image bulletImage;

    public TankGame() {
        Timer timer = new Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        loadTankImage();
        loadBulletImage();
    }

    private void loadTankImage() {
        try {
            File tankImageFile = new File("/home/roman/IdeaProjects/repository-java_8_online1/h_w2_Base_Operation/src/main/java/ua/com/alevel/resources/tank.png");
            if (tankImageFile.exists()) {
                tankImage = ImageIO.read(tankImageFile);
            } else {
                System.out.println("Файл изображения не найден.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadBulletImage() {
            try {
                File tankImageFile = new File("/home/roman/IdeaProjects/repository-java_8_online1/h_w2_Base_Operation/src/main/java/ua/com/alevel/resources/free-icon-bullet-3553208 (1).png");
                if (tankImageFile.exists()) {
                    bulletImage = ImageIO.read(tankImageFile);
                } else {
                    System.out.println("Файл изображения не найден.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Рисуем танк
        g.drawImage(tankImage, tankX, tankY, this);

        // Рисуем пулю, если она активна
        if (shooting) {
            g.drawImage(bulletImage, bulletX, bulletY, this);
        }
    }

    public void actionPerformed(ActionEvent e) {
        moveBullet();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            tankY -= tankSpeed;
        } else if (key == KeyEvent.VK_DOWN) {
            tankY += tankSpeed;
        } else if (key == KeyEvent.VK_LEFT) {
            tankX -= tankSpeed;
        } else if (key == KeyEvent.VK_RIGHT) {
            tankX += tankSpeed;
        } else if (key == KeyEvent.VK_SPACE && !shooting) {
            shooting = true;
            bulletX = tankX + tankImage.getWidth(this) / 2 - bulletImage.getWidth(this) / 2;
            bulletY = tankY - bulletImage.getHeight(this);
        }
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    private void moveBullet() {
        if (shooting) {
            bulletY -= 5;
            if (bulletY < 0) {
                shooting = false;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tank Game");
        TankGame tankGame = new TankGame();

        frame.add(tankGame);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

/*private void loadTankImage() {
        try {
            File tankImageFile = new File("/home/roman/IdeaProjects/repository-java_8_online1/h_w2_Base_Operation/src/main/java/ua/com/alevel/resources/tank.png");
            if (tankImageFile.exists()) {
                tankImage = ImageIO.read(tankImageFile);
            } else {
                System.out.println("Файл изображения не найден.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


 */