/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclientjplatform;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 *
 * @author Bedirhan.Sisman
 */
public class RestClientJPlatform {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        
        Thread.sleep(2500);
        
        ArayuzOfLogin frame = new ArayuzOfLogin();
        frame.setTitle("J-Platform Rest Login Client");
        frame.setResizable(false);
        frame.setVisible(true);
        
    }
    
    
}


