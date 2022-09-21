
import gui.GuiFrame;
import gui.panels.*;

public class Main {
    public static void main(String[] args) {
        GuiFrame gui = new GuiFrame();
        gui.registerComponent(new LoginPanel());
        gui.registerComponent(new RegisterPanel());
        gui.registerComponent(new UserMenuPanel());
        gui.registerComponent(new AssistantPanel());
        gui.registerComponent(new AdminPanel());
        gui.registerComponent(new ChangeDataPanel());
        gui.registerComponent(new FlightMenuPanel());
        gui.createGui();
    }
}
