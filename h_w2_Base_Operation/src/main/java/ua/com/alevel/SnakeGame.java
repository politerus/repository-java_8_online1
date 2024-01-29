package ua.com.alevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeGame extends JPanel implements ActionListener {
    private final int WIDTH = 800; // Увеличенная ширина экрана
    private final int HEIGHT = 600; // Увеличенная высота экрана
    private final int CELL_SIZE = 20; // Увеличенный размер ячейки
    private final int TOTAL_CELLS = WIDTH * HEIGHT / (CELL_SIZE * CELL_SIZE);
    private final int SPEED = 100;

    private final int[] x = new int[TOTAL_CELLS];
    private final int[] y = new int[TOTAL_CELLS];

    private int snakeLength;
    private int appleX;
    private int appleY;
    private boolean gameOver = false;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    public SnakeGame() {
        Timer timer = new Timer(SPEED, this);
        timer.start();
        setFocusable(true);
        addKeyListener(new KeyPress());
        startGame();
    }

    public void startGame() {
        snakeLength = 3;
        for (int i = 0; i < snakeLength; i++) {
            x[i] = 100 - i * CELL_SIZE;
            y[i] = 100;
        }
        generateApple();
        gameOver = false;
        left = false;
        right = true;
        up = false;
        down = false;
    }

    public void generateApple() {
        appleX = (int) (Math.random() * (WIDTH / CELL_SIZE)) * CELL_SIZE;
        appleY = (int) (Math.random() * (HEIGHT / CELL_SIZE)) * CELL_SIZE;
    }

    public void paint(Graphics g) {
        if (!gameOver) {
            // Отрисовка фона
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            // Отрисовка яблока
            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, CELL_SIZE, CELL_SIZE);

            // Отрисовка змейки
            for (int i = 0; i < snakeLength; i++) {
                g.setColor(Color.GREEN);
                g.fillRect(x[i], y[i], CELL_SIZE, CELL_SIZE);
            }
        } else {
            // Сообщение о завершении игры
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            g.drawString("Game Over", WIDTH / 2 - 150, HEIGHT / 2);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            move();
            checkApple();
            checkCollision();
        }
        repaint();
    }

    public void move() {
        for (int i = snakeLength; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (left) {
            x[0] -= CELL_SIZE;
        }
        if (right) {
            x[0] += CELL_SIZE;
        }
        if (up) {
            y[0] -= CELL_SIZE;
        }
        if (down) {
            y[0] += CELL_SIZE;
        }
    }

    public void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            snakeLength++;
            generateApple();
        }
    }

    public void checkCollision() {
        if (x[0] >= WIDTH || x[0] < 0 || y[0] >= HEIGHT || y[0] < 0) {
            gameOver = true;
        }

        for (int i = 1; i < snakeLength; i++) {
            if (x[0] == x[i] && y[0] == y[i]) {
                gameOver = true;
                break;
            }
        }

        if (gameOver) {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private class KeyPress extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!right)) {
                left = true;
                up = false;
                down = false;
            }
            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
                right = true;
                up = false;
                down = false;
            }
            if ((key == KeyEvent.VK_UP) && (!down)) {
                up = true;
                right = false;
                left = false;
            }
            if ((key == KeyEvent.VK_DOWN) && (!up)) {
                down = true;
                right = false;
                left = false;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        SnakeGame snakeGame = new SnakeGame();

        frame.add(snakeGame);
        frame.setSize(snakeGame.WIDTH, snakeGame.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while (true) {
            if (snakeGame.gameOver) {
                int choice = JOptionPane.showConfirmDialog(null, "Game Over! Play again?",
                        "Game Over", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    snakeGame.startGame();
                    snakeGame.gameOver = false;
                } else {
                    System.exit(0);
                }
            }
        }
    }
}
