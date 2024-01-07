import java.awt.*;

public class Function_Color {
    GUI gui;
    public Function_Color(GUI gui)
    {
        this.gui=gui;
    }
    public void changeColor(String color){
        switch(color)
        {
            case "White":
                gui.window.getContentPane().setBackground(Color.WHITE);
                gui.textArea.setBackground(Color.WHITE);
                gui.textArea.setForeground(Color.black);
                break;
            case "Black":
                gui.window.getContentPane().setBackground(Color.BLACK);
                gui.textArea.setBackground(Color.BLACK);
                gui.textArea.setForeground(Color.white);
                break;
            case "Blue":
                gui.window.getContentPane().setBackground(Color.BLUE);//can also add in (new Color(120,168,157)); for RGB colors
                gui.textArea.setBackground(Color.BLUE);
                gui.textArea.setForeground(Color.white);
                break;
        }
    }
}
