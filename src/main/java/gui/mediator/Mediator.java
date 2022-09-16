package gui.mediator;

public interface Mediator {
    void registerComponent(Component component);
    void addToFrame();
    void offVisibleLogPanel();
    void onVisibleLogPanel();
    void offVisibleRegPanel();
    void onVisibleRegPanel();

}
