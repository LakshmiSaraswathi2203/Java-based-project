import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.*;

public class GUI implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    Boolean wordWrapOn=false;
    JMenuBar menuBar;
    JMenu menufile, menuEdit, menuFormat,menuColor;
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
   // edit options
    JMenuItem iUndo, iRedo;
    JMenuItem iWrap,iFontArial, iFontCSMS, iFontTNR, iFontSize8,  iFontSize12, iFontSize18,  iFontSize24,  iFontSize48,  iFontSize72;
    JMenu menuFont, menuFontSize;
    //colour
    JMenuItem iColor1, iColor2, iColor3;

    Function_File file = new Function_File(this);
    Function_Format format= new Function_Format(this);
    Function_Color color=new Function_Color(this);
    Function_Edit edit= new Function_Edit(this);
    KeyHandler kHandler = new KeyHandler(this);

    UndoManager um= new UndoManager();

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();

        format.selectedFont= "Arial";
        format.createFont(24);
        format.wordWrap();
        color.changeColor("White");
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("NotePad");
        window.setSize(1000, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
        textArea.setFont(format.arial);

        textArea.addKeyListener(kHandler);

        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        um.addEdit(e.getEdit());
                    }
                }
        );

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar(){
        menuBar=new JMenuBar();
        window.setJMenuBar(menuBar);
        menufile = new JMenu("File");
        menuBar.add(menufile);
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        menuColor=new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menufile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menufile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menufile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SaveAs");
        menufile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menufile.add(iExit);
    }
    public void createEditMenu()
    {
        iUndo= new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo= new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }
    public void createFormatMenu(){
        iWrap= new JMenuItem("Word Wrap:Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial=new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comics");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comics");
        menuFont.add(iFontCSMS);

        iFontTNR= new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8=new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("8");
        menuFontSize.add(iFontSize8);

        iFontSize12=new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("12");
        menuFontSize.add(iFontSize12);


        iFontSize18=new JMenuItem("18");
        iFontSize18.addActionListener(this);
        iFontSize18.setActionCommand("18");
        menuFontSize.add(iFontSize18);


        iFontSize24=new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("24");
        menuFontSize.add(iFontSize24);


        iFontSize48=new JMenuItem("48");
        iFontSize48.addActionListener(this);
        iFontSize48.setActionCommand("48");
        menuFontSize.add(iFontSize48);


        iFontSize72=new JMenuItem("72");
        iFontSize72.addActionListener(this);
        iFontSize72.setActionCommand("72");
        menuFontSize.add(iFontSize72);
    }
    public void createColorMenu()
    {
        iColor1=new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2=new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3=new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newfile(); // Correct method name
                break;
            case "Open":
                file.open(); // Correct method name
                break;
            case "Save":
                file.save(); // Correct method name
                break;
            case "SaveAs":
                file.saveAs(); // Correct method name
                break;
            case "Exit":
                file.exit(); // Correct method name
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "Arial":
                format.setFont("Arial");
                break;
            case "Comics":
                format.setFont("Comics");
                break;
            case "Times New Roman":
                format.setFont("Times New Roman");
                break;
            case "8": format.createFont(8);break;
            case "12": format.createFont(12);break;
            case "18": format.createFont(18);break;
            case "24": format.createFont(24);break;
            case "48": format.createFont(48);break;
            case "72": format.createFont(72);break;
            case "White":
                color.changeColor("White");
                break;
            case "Black":
                color.changeColor("Black");
                break;
            case "Blue":
                color.changeColor("Blue");
                break;
        }
    }
}
