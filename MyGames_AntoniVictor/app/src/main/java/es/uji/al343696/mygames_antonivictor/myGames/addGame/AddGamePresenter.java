package es.uji.al343696.mygames_antonivictor.myGames.addGame;


import android.support.v7.app.ActionBar;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import es.uji.al343696.mygames_antonivictor.myGames.model.AllGameData;
import es.uji.al343696.mygames_antonivictor.myGames.model.GameData;
import es.uji.al343696.mygames_antonivictor.myGames.model.MyGamesModel;
import es.uji.al343696.mygames_antonivictor.myGames.model.inetserver.ResponseReceiver;

/**
 * Created by al343696 on 2/03/18.
 */

public class AddGamePresenter  {

    IAddGameView view;
    MyGamesModel model;
    private List<AllGameData> games;

    public AddGamePresenter(MyGamesModel model) {
        this.model = model;
    }

    public void setSearchGameName(String gameName) {
        view.showTitle(gameName);
        view.showSearchInProgress();
        model.findGames(gameName, new ResponseReceiver<List<AllGameData>>() {
            @Override
            public void onResponseReceived(List<AllGameData> response) {
                view.hideSearchInProgress();
                gamesFound(response);
            }

            @Override
            public void onErrorReceived(String message) {
                view.hideSearchInProgress();
                view.showError(message);
            }

            @Override
            public List<AllGameData> findGames(String name) {
                return null;
            }


        });
    }

    private void gamesFound(List<AllGameData> response) {
        games = response;

        List<String> names = new ArrayList<>();
        for (AllGameData allGameData : response)
            names.add(allGameData.getGame().getName());

        view.displayNames(names);
    }

    public void onAddGameRequested(int requestedIndex) {

        view.askGameInsertionConfirmation("");
    }
}
