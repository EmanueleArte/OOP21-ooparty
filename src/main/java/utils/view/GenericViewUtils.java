package utils.view;

import minigames.common.viewcontroller.MinigameGuideViewControllerImpl;
import utils.controller.GenericController;
import utils.graphics.stagemanager.StageManager;

public final class GenericViewUtils {

    private GenericViewUtils() {
    }

    public static void createScene(final StageManager stageManager, final GenericController controller, final Class<?> viewControllerClass, final String fxmlUrl) {
        stageManager.addFXMLScene(fxmlUrl, viewControllerClass, controller);
    }

}
