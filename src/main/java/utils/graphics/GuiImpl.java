package utils.graphics;

import java.util.List;

import utils.enums.ControllerType;

/**
 * Implementation of {@link Gui}.
 *
 * @param <S> the scenes of the stage
 */
public class GuiImpl<S> implements Gui<S> {

    public GuiImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void createGui() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <U> S loadScene(final String fxmlUrl, final ControllerType c, final List<U> players) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setScene(final S scene) {
        this.mainStage.setScene(scene);
    }

}
