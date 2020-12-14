
/**
* @author [Madhur Nirmal]
* @email [madhurnirmal01@mail.com]
*/
/**
* @author [Divyansh Mishra]
* @email [divyanshm471@gmail.com]
*/
/**
* @author [Akhilesh Ketkar]
* @email [ketkarakhilesh@gmail.com]
*/
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TextEditor extends JFrame {
  private JTextArea textArea;
  private boolean isSaved = false;

  public TextEditor() {
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem newFileMenuItem = new JMenuItem("New");
    JMenuItem openFileMenuItem = new JMenuItem("Open");
    JMenuItem saveFileMenuItem = new JMenuItem("Save");
    JMenuItem printFileMenuItem = new JMenuItem("Print");
    newFileMenuItem.addActionListener((e) -> {
      new TextEditor();
    });
    openFileMenuItem.addActionListener((e) -> {
      this.isSaved = true;
      openFile();
    });
    saveFileMenuItem.addActionListener((e) -> {
      saveFile();
    });
    printFileMenuItem.addActionListener((e) -> {
      try {
        textArea.print();
      } catch (Exception evt) {
        JOptionPane.showMessageDialog(this, evt.getMessage());
      }
    });
    fileMenu.add(newFileMenuItem);
    fileMenu.add(openFileMenuItem);
    fileMenu.add(saveFileMenuItem);
    fileMenu.add(printFileMenuItem);
    JMenu editMenu = new JMenu("Edit");
    JMenuItem cutEditMenuItem = new JMenuItem("Cut");
    JMenuItem copyEditMenuItem = new JMenuItem("Copy");
    JMenuItem pasteEditMenuItem = new JMenuItem("Paste");
    JMenuItem selectAllEditMenuItem = new JMenuItem("Select All");
    cutEditMenuItem.addActionListener((e) -> {
      textArea.cut();
    });
    copyEditMenuItem.addActionListener((e) -> {
      textArea.copy();
    });
    pasteEditMenuItem.addActionListener((e) -> {
      textArea.paste();
    });
    selectAllEditMenuItem.addActionListener((e) -> {
      textArea.selectAll();
    });
    editMenu.add(cutEditMenuItem);
    editMenu.add(copyEditMenuItem);
    editMenu.add(pasteEditMenuItem);
    editMenu.add(selectAllEditMenuItem);
    JMenuItem closeMenu = new JMenuItem("Close");
    closeMenu.addActionListener(e -> {
      if (isSaved || textArea.getText().equals(""))
        System.exit(0);
      else
        saveFile();
    });
    menuBar.add(fileMenu);
    menuBar.add(editMenu);
    menuBar.add(closeMenu);
    textArea = new JTextArea();
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    setJMenuBar(menuBar);
    setTitle("Text-Pad");
    add(textArea);
    setSize(500, 500);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void openFile() {
    JFileChooser jFileChooser = new JFileChooser("C:\\Users\\DELL\\Desktop");
    int r = jFileChooser.showOpenDialog(null);
    if (r == JFileChooser.APPROVE_OPTION) {
      File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
      try {
        String s1 = "", sl = "";
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        sl = br.readLine();
        s1 = br.readLine();
        while (s1 != null) {
          System.out.println(sl);
          sl = sl + "\n" + s1;
          s1 = br.readLine();
        }
        br.close();
        textArea.setText(sl);
      } catch (Exception evt) {
        JOptionPane.showMessageDialog(this, evt.getMessage());
      }
    }
  }

  private void saveFile() {
    JFileChooser jFileChooser = new JFileChooser("C:\\Users\\DELL\\Desktop");
    int r = jFileChooser.showOpenDialog(null);
    if (r == JFileChooser.APPROVE_OPTION) {
      File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());
      try {
        String s1 = "", sl = "";
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        sl = br.readLine();
        s1 = br.readLine();
        while (s1 != null) {
          System.out.println(sl);
          sl = sl + "\n" + s1;
          s1 = br.readLine();
        }
        br.close();
        textArea.setText(sl);
        this.isSaved = true;
      } catch (Exception evt) {
        JOptionPane.showMessageDialog(this, evt.getMessage());
      }
    }
  }

  public static void main(String args[]) {
    new TextEditor();
  }
}