package menu.common.controller;

import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

/**
 * Extension of {@link GenericControllerAbstr}.
 */
public abstract class SimpleMenuControllerAbstr extends GenericControllerAbstr {

    private GenericViewController menuViewController;

    /**
     * Builds a {@link SimpleMenuControllerAbstr}.
     * 
     * @param <S> the scenes of the stage
     * @param s   the {@link StageManager}
     */
    public <S> SimpleMenuControllerAbstr(final StageManager<S> s) {
        super(s);
    }

    @Override
    public final GenericViewController getViewController() {
        return this.menuViewController;
    }

    @Override
    public final void setViewController(final GenericViewController viewController) {
        if (viewController instanceof GenericViewController) {
            this.menuViewController = (GenericViewController) viewController;
        } else {
            throw new IllegalArgumentException("The parameter must be an instance of GenericViewController");
        }
    }

}
