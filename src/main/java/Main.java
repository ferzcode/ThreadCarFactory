import model.Factory;
import model.exceptions.FactoryCreationException;
import view.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Factory factory;
        try {
            factory = new Factory();
        } catch (FactoryCreationException e) {
            return;
        }

        SwingUtilities.invokeLater(() -> {
            View view = new View(factory);
            factory.addListener(view);
            factory.start();
        });
    }
}