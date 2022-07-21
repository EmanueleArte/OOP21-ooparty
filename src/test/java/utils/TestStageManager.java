package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import utils.graphics.StageManager;
import utils.graphics.StageManagerImpl;

/**
 * Test class for StageManager.
 */
class TestStageManager {

    @Test
    void testAddScene() {
        final StageManager<String> s = new StageManagerImpl<String>("");
        s.addScene("1");
        s.addScene("2");
        assertFalse(s.getScenes().isEmpty());
        s.addScene("3");
        assertEquals(3, s.getScenes().size());
    }

}
