
import gui.GuiFrame;
import gui.panels.*;

public class Main {
    public static void main(String[] args) {
        GuiFrame gui = new GuiFrame();
        gui.registerComponent(new LoginPanel());
        gui.registerComponent(new RegisterPanel());
        gui.registerComponent(new AssistantPanel());
        gui.registerComponent(new AdminPanel());
        gui.registerComponent(new ChangeDataPanel());
        gui.registerComponent(new UserMenuTabbed());
        gui.registerComponent(new FundWalletPanel());
        gui.registerComponent(new FlightMenuPanel());
        gui.registerComponent(new ViewFlightPanel());
        gui.createGui();
    }
}
