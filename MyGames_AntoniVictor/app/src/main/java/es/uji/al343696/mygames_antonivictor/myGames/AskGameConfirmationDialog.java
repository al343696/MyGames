package es.uji.al343696.mygames_antonivictor.myGames;

/**
 * Created by User on 16/03/2018.
 */

public class AskGameConfirmationDialog implements IConfirmedListener {

    MyGamesPresenter presenter;

    @Override
    public void onActionConfirmed() {
        presenter.onAddGameConfirmed();


    }
}
