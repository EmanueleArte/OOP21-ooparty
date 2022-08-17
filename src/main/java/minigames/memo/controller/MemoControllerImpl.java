package minigames.memo.controller;

import java.util.List;

import utils.controller.GenericControllerAbstr;
import utils.graphics.controller.StageManager;
import utils.view.GenericViewController;

public class MemoControllerImpl<S> extends GenericControllerAbstr implements MemoController {

    public MemoControllerImpl(final StageManager<S> s) {
        super(s);
    }

    @Override
    public List<?> getGameResults() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void startGame() {

    }

    @Override
    public boolean nextTurn() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public GenericViewController getViewController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <C> void setViewController(final C viewController) {
        // TODO Auto-generated method stub

    }

}
