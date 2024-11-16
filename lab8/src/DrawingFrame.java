import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawingFrame extends JFrame {
    private JMenuBar menuBar;
    private Color currentColor = Color.RED;
    private JButton redButton;
    private JButton greenButton;
    private JButton blueButton;

    private class DrawingPanel extends JPanel {
        public BufferedImage image;
        public DrawingPanel() {
            setBackground(Color.WHITE);

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent mouseEvent) {
                    Graphics2D g2d = image.createGraphics();
                    g2d.setColor(currentColor);
                    g2d.fillOval(mouseEvent.getX() - 5, mouseEvent.getY() - 5, 10, 10);
                    g2d.dispose();
                    repaint();
                }
            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent mouseEvent) {
                    Graphics2D g2d = image.createGraphics();
                    g2d.setColor(currentColor);
                    g2d.fillOval(mouseEvent.getX() - 5, mouseEvent.getY() - 5, 10, 10);
                    g2d.dispose();
                    repaint();
                }
            });

            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent componentEvent) {
                    int newWidth = drawingPanel1.getWidth();
                    int newHeight = drawingPanel1.getHeight();

                    if (newWidth > image.getWidth() || newHeight > image.getHeight()) {
                        BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
                        Graphics2D g2d = newImage.createGraphics();

                        g2d.setColor(Color.WHITE);
                        g2d.fillRect(0, 0, newWidth, newHeight);

                        g2d.drawImage(image, 0, 0, null);
                        g2d.dispose();

                        image = newImage;

                        drawingPanel1.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (image == null) {
                image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = image.createGraphics();
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.dispose();
            }
            g.drawImage(image, 0, 0, null);
        }
    }

    DrawingPanel drawingPanel1;

    public DrawingFrame() {
        setTitle("Drawing Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 960);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(actionEvent -> loadImage());
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(actionEvent -> saveImage());

        JMenu fileMenu = new JMenu("File");
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);

        menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.setPreferredSize(new Dimension(100, 30));
        redButton.addActionListener(actionEvent -> currentColor = Color.RED);
        greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.setPreferredSize(new Dimension(100, 30));
        greenButton.addActionListener(actionEvent -> currentColor = Color.GREEN);
        blueButton = new JButton();
        blueButton.setBackground(Color.BLUE);
        blueButton.setPreferredSize(new Dimension(100, 30));
        blueButton.addActionListener(actionEvent -> currentColor = Color.BLUE);

        JPanel colorPanel = new JPanel();
        colorPanel.add(redButton);
        colorPanel.add(greenButton);
        colorPanel.add(blueButton);

        add(colorPanel, BorderLayout.NORTH);

        drawingPanel1 = new DrawingPanel();
        drawingPanel1.setPreferredSize(new Dimension(700, 1100));
        DrawingPanel drawingPanel2 = new DrawingPanel();
        drawingPanel2.setPreferredSize(new Dimension(700, 1100));
        JPanel panel = new JPanel(new GridLayout());
        panel.add(drawingPanel1);
        panel.add(drawingPanel2);
        add(new JScrollPane(panel), BorderLayout.CENTER);

        setVisible(true);
    }

    private void saveImage() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                ImageIO.write(drawingPanel1.image, "png", file);
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
    }

    private void loadImage() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = chooser.getSelectedFile();
                drawingPanel1.image = ImageIO.read(file);
                drawingPanel1.repaint();
            } catch (IOException exception) {
                JOptionPane.showMessageDialog(null, exception);
            }
        }
    }
}