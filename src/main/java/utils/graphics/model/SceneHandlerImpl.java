package utils.graphics.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link SceneHandler}.
 * 
 * @param <S> the scenes of the stage
 */
public class SceneHandlerImpl<S> implements SceneHandler<S> {

    private final List<S> scenes;

    /**
     * Builds a new {@link SceneHandlerImpl}.
     */
    public SceneHandlerImpl() {
        this.scenes = new ArrayList<>();
    }

    @Override
    public final void addScene(final S scene) {
        Optional<S> s = Optional.ofNullable(scene);
        if (s.isPresent()) {
            scenes.add(scene);
        }
    }

    @Override
    public final S popScene() {
        if (this.scenes.isEmpty()) {
            return null;
        }
        return this.scenes.remove(this.lastSceneIndex());
    }

    @Override
    public final int lastSceneIndex() throws RuntimeException {
        final int nScenes = this.scenes.size();
        if (nScenes == 0) {
            throw new RuntimeException("Scenes list is empty.");
        }
        return nScenes - 1;
    }

    @Override
    public final List<S> getScenes() {
        return this.scenes;
    }

}
