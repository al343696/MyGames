package es.uji.al343696.mygames_antonivictor.myGames.model;

import android.content.Context;

import es.uji.al343696.mygames_antonivictor.myGames.model.database.IGamesDatabase;
import es.uji.al343696.mygames_antonivictor.myGames.model.database.MockGamesDatabase;
import es.uji.al343696.mygames_antonivictor.myGames.model.inetserver.IGamesServer;
import es.uji.al343696.mygames_antonivictor.myGames.model.inetserver.MockGamesServer;
import es.uji.al343696.mygames_antonivictor.myGames.model.inetserver.ResponseReceiver;

/**
 * Created by al343696 on 2/03/18.
 */

public class MyGamesModel implements IMyGamesModel
{
    private IGamesDatabase db;
    private IGamesServer gamesServer;

    private static MyGamesModel instance = null;

    public static MyGamesModel getInstance(){
        return instance;
    }

    public static MyGamesModel getInstance(Context context){
        if (instance == null){
            instance = new MyGamesModel(new MockGamesDatabase(), new MockGamesServer());
        }
        return instance;
    }

    private MyGamesModel(IGamesDatabase db, IGamesServer gamesServer) //constructor
    {
        this.db = db;
        this.gamesServer = gamesServer;

    }

    @Override
    public void findGames(String gameName, ResponseReceiver receiver) {
        gamesServer.findGames(gameName, receiver);

    }
}
