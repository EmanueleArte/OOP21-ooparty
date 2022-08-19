package menu.afterminigamemenu.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import menu.MenuController;
import utils.controller.GenericController;

public class AfterMinigameMenuViewControllerImpl implements AfterMinigameMenuViewController {

    private MenuController menuController;
    @FXML
    private VBox vBox1;
    @FXML
    private VBox vBox2;
    @FXML
    private VBox vBox3;
    @FXML
    private VBox vBox4;

    public AfterMinigameMenuViewControllerImpl() {
        this.initialize();
    }

    @Override
    public final void setController(final GenericController controller) throws IllegalArgumentException {
        if (controller instanceof MenuController) {
            this.menuController = (MenuController) controller;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of MenuController");
        }
    }

    private void initialize() {
        System.out.println(this.vBox1);
        System.out.println(this.vBox2);
        System.out.println(this.vBox3);
        System.out.println(this.vBox4);
        /*Label l = (Label) this.vBox1.getChildren().get(0);
        l.setText("sdgfhJGDHKHGIGIAFGAIFIAFG");*/
    }

    @FXML
    private void exitMenu() {
        this.menuController.exit();
    }

}
