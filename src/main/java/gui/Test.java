package gui;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        GuiFrame gui = new GuiFrame();
        gui.registerComponent(new LoginPanel());
        gui.registerComponent(new RegisterPanel());
        gui.createGui();
    }
}
