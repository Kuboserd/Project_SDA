package gui.mediator;

public interface Mediator {
    void registerComponent(Component component);
    void offLogJpOnRegJp();
    void onVisibleLogPanel();
    void offRegJpOnLogJp();
    void onVisibleRegPanel();

}
