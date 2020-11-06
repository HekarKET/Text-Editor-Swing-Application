// Java Program to create a text editor using java 
import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*; 
import javax.swing.plaf.metal.*; 
import javax.swing.text.*; 

class texteditor extends JFrame implements ActionListener { 
	
	JTextArea textArea; 
	JFrame f; 
	
	texteditor() 
	{ 
		// Create a frame 
		f = new JFrame("Text editor"); 
        
		// Create a menubar 
		JMenuBar menuBar = new JMenuBar(); 


		// Create menu for File 
		JMenu fileMenu = new JMenu("File"); 
		// Create menu items of File
		JMenuItem newFileMenu = new JMenuItem("New"); 
		JMenuItem openFileMenu = new JMenuItem("Open"); 
		JMenuItem saveFileMenu = new JMenuItem("Save"); 
		JMenuItem printFileMenu = new JMenuItem("Print"); 
		newFileMenu.addActionListener(this); 
		openFileMenu.addActionListener(this); 
		saveFileMenu.addActionListener(this); 
		printFileMenu.addActionListener(this); 
		fileMenu.add(newFileMenu); 
		fileMenu.add(openFileMenu); 
		fileMenu.add(saveFileMenu); 
		fileMenu.add(printFileMenu); 


		// Create a menu for Edit 
		JMenu editMenu = new JMenu("Edit"); 
		// Create menu items for edit 
		JMenuItem cutEditMenu = new JMenuItem("cut"); 
		JMenuItem copyEditMenu = new JMenuItem("copy"); 
		JMenuItem pasteEditMenu = new JMenuItem("paste"); 		
		cutEditMenu.addActionListener(this); 
		copyEditMenu.addActionListener(this); 
		pasteEditMenu.addActionListener(this); 
		editMenu.add(cutEditMenu); 
		editMenu.add(copyEditMenu); 
		editMenu.add(pasteEditMenu); 

        // Create a menu for Close 
		JMenuItem closeMenu = new JMenuItem("close"); 
		closeMenu.addActionListener(this); 



        //Add menu to menubar
		menuBar.add(fileMenu); 
		menuBar.add(editMenu); 
		menuBar.add(closeMenu); 


        // Text area 
        textArea = new JTextArea(); 
        
		f.setJMenuBar(menuBar); 
		f.add(textArea); 
		f.setSize(500, 500); 
		f.setVisible(true);
	} 

	// If a button is pressed 
	public void actionPerformed(ActionEvent e) 
	{ 
        //Get action name
		String s = e.getActionCommand(); 

		if (s.equals("cut")) { 
			textArea.cut(); 
		} 
		else if (s.equals("copy")) { 
			textArea.copy(); 
		} 
		else if (s.equals("paste")) { 
			textArea.paste(); 
		} 
	
		else if (s.equals("Print")) { 
			try { 
				// print the file 
				textArea.print(); 
			} 
			catch (Exception evt) { 
				JOptionPane.showMessageDialog(f, evt.getMessage()); 
			} 
        } 

        else if (s.equals("New")) { 
			textArea.setText(""); 
        } 
        
		else if (s.equals("close")) { 
			f.setVisible(false); 
        } 

		else if (s.equals("Open")) { 
			
			JFileChooser j = new JFileChooser("f:"); 			
			int r = j.showOpenDialog(null); 	
			if (r == JFileChooser.APPROVE_OPTION) { 	
				File fi = new File(j.getSelectedFile().getAbsolutePath()); 
				try { 
					
					String s1 = "", sl = ""; 					
					FileReader fr = new FileReader(fi);					
					BufferedReader br = new BufferedReader(fr); 					
                    sl = br.readLine(); 
                    s1 = br.readLine();			
					while (s1 != null) { 
                        System.out.println(sl);
                        sl = sl + "\n" + s1; 
                        s1 = br.readLine();
					} 
					textArea.setText(sl); 
				} 
				catch (Exception evt) { 
					JOptionPane.showMessageDialog(f, evt.getMessage()); 
				} 
			} 	
        } 

        else if (s.equals("Save")) { 		
			JFileChooser j = new JFileChooser("f:"); 
			int option = j.showSaveDialog(null); 
			if (option == JFileChooser.APPROVE_OPTION) { 				
				File fi = new File(j.getSelectedFile().getAbsolutePath()); 
				try { 
					
                    FileWriter wr = new FileWriter(fi, false); 
                    BufferedWriter w = new BufferedWriter(wr); 	
					w.write(textArea.getText()); 
					w.flush(); 
					w.close(); 
				} 
				catch (Exception evt) { 
					JOptionPane.showMessageDialog(f, evt.getMessage()); 
				} 
			} 	
        } 
        
	
	} 

	// Main class 
	public static void main(String args[]) 
	{ 
		texteditor t = new texteditor(); 
	} 
} 
