package es.uji.al343696.mygames_antonivictor.myGames.model.inetserver;

import es.uji.al343696.mygames_antonivictor.myGames.model.AllGameData;

import java.util.List;

/**
 * Created by jcamen on 17/02/18.
 */

public interface IGamesServer {

    void findGames(String gameName, ResponseReceiver<List<AllGameData>> receiver);

    void requestCover(String cover, String filename, ResponseReceiver<String> receiver);
}
