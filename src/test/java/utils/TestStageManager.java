package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import utils.graphics.controller.StageManager;
import utils.graphics.controller.StageManagerImpl;

/**
 * Test class for StageManager used without gui.
 */
class TestStageManager {

    @Test
    void testAddScene() {
        final StageManager<String> s = new StageManagerImpl<>();
        s.addScene(null);
        assertTrue(s.getScenes().isEmpty());
        s.addScene("1");
        s.addScene("2");
        assertFalse(s.getScenes().isEmpty());
        s.addScene("3");
        assertEquals(3, s.getScenes().size());
    }

    @Test
    void testPopScene() {
        final StageManager<String> s = new StageManagerImpl<>();
        s.addScene("1");
        s.addScene("2");
        s.addScene("3");
        assertEquals("3", s.popScene());
        assertEquals("2", s.popScene());
        assertEquals("1", s.popScene());
        assertTrue(s.getScenes().isEmpty());
    }

}
