package es.uji.al343696.mygames_antonivictor.myGames.model.inetserver;

import java.util.List;

import es.uji.al343696.mygames_antonivictor.myGames.model.AllGameData;

/**
 * Created by jvilar on 4/11/16.
 */

public interface ResponseReceiver<T> {
    void onResponseReceived(T response);
    void onErrorReceived(String message);
    List<AllGameData> findGames(String name);
}
