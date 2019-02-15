package es.uji.al343696.mygames_antonivictor.myGames.addGame;

import android.app.ActionBar;

import java.lang.reflect.Array;
import java.util.List;

import es.uji.al343696.mygames_antonivictor.myGames.model.AllGameData;
import es.uji.al343696.mygames_antonivictor.myGames.model.inetserver.ResponseReceiver;


/**
 * Created by al343696 on 2/03/18.
 */

public interface IAddGameView
{
    void showTitle(String gameName);

    void showSearchInProgress();

    void findGames(String gameName, ResponseReceiver<List<AllGameData>> receiver);

    void displayNames(List names);

    void askGameInsertionConfirmation(String name);

    void hideSearchInProgress();

    void showError(String message);
}
