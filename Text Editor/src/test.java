import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


class PopupActionListener implements ActionListener {
    public void actionPerformed(ActionEvent actionEvent) {
        File file = new File("C:\\Users\\Akhilesh\\Desktop\\Programs\\Projects");
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
            System.out.println("hey");
        }
        
    }
  }


public class test extends JFrame {// inheriting JFrame
    JFrame f;

    test(){  
    // JButton b=new JButton("Text editor");//create button  
    // b.setBounds(150,150,200,20);  
            
    //add(b);//adding button on frame  

    

    JMenuBar mb = new JMenuBar(); 
    
    JMenu fileMenu = new JMenu("File");

    JMenuItem openMenu = new JMenuItem("Open"); 
    JMenuItem newMenu = new JMenuItem("New"); 
    JMenuItem saveMenu = new JMenuItem("Save"); 


    openMenu.addActionListener(new PopupActionListener() );

    
    fileMenu.add(openMenu);
    fileMenu.add(newMenu);
    fileMenu.add(saveMenu);

    mb.add(fileMenu);
    setJMenuBar(mb);
    

    
    setSize(1120,620);  
    setLayout(null);  
    setVisible(true);  

        
}

    public static void main(final String[] args) {
        new test();
    }
}