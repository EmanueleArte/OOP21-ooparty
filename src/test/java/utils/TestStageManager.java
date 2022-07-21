package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import javafx.scene.Scene;
import utils.enums.ControllerType;
import utils.graphics.StageManager;
import utils.graphics.StageManagerImpl;

/**
 * Test class for StageManager.
 */
class TestStageManager {

    private final String fxmlUrl = "menu/main_menu.fxml";

    @Test
    void testAddScene() {
        final StageManager<Scene> s = new StageManagerImpl<Scene>("");
        s.addScene(fxmlUrl, ControllerType.MAIN_MENU, null);
        s.addScene(fxmlUrl, ControllerType.MAIN_MENU, null);
        assertFalse(s.getScenes().isEmpty());
        s.addScene(fxmlUrl, ControllerType.MAIN_MENU, null);
        assertEquals(3, s.getScenes().size());
    }

}
