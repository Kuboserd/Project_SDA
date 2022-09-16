
import gui.GuiFrame;
import gui.LoginPanel;
import gui.RegisterPanel;

public class Main {
    public static void main(String[] args) {
        GuiFrame gui = new GuiFrame();
        gui.registerComponent(new LoginPanel());
        gui.registerComponent(new RegisterPanel());
        gui.createGui();
    }
}
