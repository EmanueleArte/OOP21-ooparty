package utils.graphics.view;

import utils.graphics.controller.StageManager;
import utils.view.ViewLoader;

/**
 * An empty implementation of {@link Gui}.
 */
public class EmptyGui implements Gui {

    /**
     * Builds a new {@link EmptyGui}.
     * 
     * @param <S>   the scenes of the stage
     * @param title the title of the frame
     * @param s     the {@link StageManager}
     */
    public <S> EmptyGui(final String title, final StageManager<S> s) {
    }

    @Override
    public final void createGui() {
    }

    @Override
    public final boolean mainStagePresence() {
        return false;
    }

    @Override
    public final ViewLoader<?> getViewFactory() {
        return null;
    }

    @Override
    public final <S> void setScene(final S scene) throws RuntimeException {
    }

}
