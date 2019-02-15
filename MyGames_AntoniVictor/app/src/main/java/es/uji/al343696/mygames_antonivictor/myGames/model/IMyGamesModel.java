package es.uji.al343696.mygames_antonivictor.myGames.model;

import es.uji.al343696.mygames_antonivictor.myGames.model.inetserver.ResponseReceiver;

/**
 * Created by al343696 on 2/03/18.
 */

public interface IMyGamesModel
{
        void findGames(String gameName, ResponseReceiver receiver);
}
