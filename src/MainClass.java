import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainClass {
    private JPanel panel1;
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel colorPanel;
    private JPanel PanelRGBImage;
    private JSlider slider4;
    private JSlider slider5;
    private JSlider slider6;
    private JButton button1;
    private JLabel lenaLabel;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;


    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("MainClass");
        frame.setContentPane(new MainClass().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,600));
        frame.pack();
        frame.setVisible(true);



    }

    public MainClass() throws IOException {



        slider1.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int x = slider1.getValue();
                String value1 = String.valueOf(x);
                label3.setText(value1);
               cambiarColor();

            }});


        slider2.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int sleepSense = slider2.getValue();
                String value1 = String.valueOf(sleepSense);
                label2.setText(value1);
               cambiarColor();

            }});

        slider3.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int sleepSense = slider3.getValue();
                String value1 = String.valueOf(sleepSense);
                label1.setText(value1);
               cambiarColor();

            }
        });

        slider4.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int sleepSense = slider4.getValue();
                String value1 = String.valueOf(sleepSense);
                label4.setText(value1);
                getLena();
            }
        });

        slider5.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int sleepSense = slider5.getValue();
                String value1 = String.valueOf(sleepSense);
                label5.setText(value1);
                getLena();


            }
        });

        slider6.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e) {
                int sleepSense = slider6.getValue();
                String value1 = String.valueOf(sleepSense);
                label6.setText(value1);
                getLena();


            }
        });



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                getLena();



            }
        });





    }
    public void cambiarColor() {
        int R, G, B;
        R = slider1.getValue();
        G = slider2.getValue();
        B = slider3.getValue();

        colorPanel.setBackground(new Color (R, G, B) );

    }

    public void getLena(){
        File file = new File("C://Users//Szymon//Desktop");
        BufferedImage img = null;
        try {
        img = ImageIO.read(file);
    } catch (IOException ioException) {
        ioException.printStackTrace();
    }
                for (int y = 0; y < img.getHeight(); y++) {
        for (int x = 0; x < img.getWidth(); x++) {
            int pixel = img.getRGB(x, y);
            Color color = new Color(pixel, true);
            //Retrieving the R G B values
            int rede = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();

            green = slider4.getValue();
            blue = slider5.getValue();
            Image image = img;
            color = new Color(rede, green, blue);
            img.setRGB(x, y, color.getRGB());
            PanelRGBImage.revalidate();
            PanelRGBImage.repaint();
            lenaLabel.revalidate();
            lenaLabel.repaint();

        }
    }

    file = new File("C://Users//Szymon//Desktop//lena.png");
                try {
        ImageIO.write(img, "jpg", file);
    } catch (IOException ioException) {
        ioException.printStackTrace();
    }
                System.out.println("Done...");
    ImageIcon img2 = new ImageIcon("C://Users//Szymon//Desktop//przyklad.jpg");
    lenaLabel.setIcon(img2);
    SwingUtilities.updateComponentTreeUI(lenaLabel);
        PanelRGBImage.revalidate();
                PanelRGBImage.repaint();
                lenaLabel.revalidate();
                lenaLabel.repaint();



}}

