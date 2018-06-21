package corbinnash_galleryapplication;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
public class MainClass {
 public MainClass(String filePath){
 SwingUtilities.invokeLater(new Runnable() {
     @Override
     public void run() {
        JFrame frame = new JFrame(filePath);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       BufferedImage img = null;
       // trying to pen image
       try {
         img = ImageIO.read(new File(filePath));
         
       } catch(IOException e){
       }
       //add image to image icon and our JLabel
       JLabel label = new JLabel();
       label.setIcon(new ImageIcon(img));
       frame.getContentPane().add(label, BorderLayout.CENTER);
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
     }
     
 });
 }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
     //file chooser
     final JFileChooser fc = new JFileChooser();
     int returnVal = fc.showOpenDialog(fc);
     String filePath = null;
     if (returnVal == JFileChooser.APPROVE_OPTION){
     filePath = fc.getSelectedFile().getAbsolutePath();
     
     } else { 
         System.out.println("CANCELED");
         System.exit(1);
 }   
new MainClass(filePath);
    }
}
 

