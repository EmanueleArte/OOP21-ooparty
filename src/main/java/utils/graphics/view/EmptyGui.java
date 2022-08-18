package utils.graphics.view;

import utils.factories.ViewFactory;

/**
 * An empty implementation of {@link Gui}.
 */
public class EmptyGui implements Gui {

    @Override
    public final void createGui() {
    }

    @Override
    public final boolean mainStagePresence() {
        return false;
    }

    @Override
    public final ViewFactory<?> getViewFactory() {
        return null;
    }

    @Override
    public final <S> void setScene(final S scene) throws RuntimeException {
    }

}
