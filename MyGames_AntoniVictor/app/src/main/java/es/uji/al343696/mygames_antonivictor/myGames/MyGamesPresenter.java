package es.uji.al343696.mygames_antonivictor.myGames;


import android.content.Context;

/**
 * Created by al343696 on 2/03/18.
 */

public class MyGamesPresenter
{
    IMyGamesView view;
    Context context;


    public MyGamesPresenter(IMyGamesView view, Context context)
    {
        this.context = context.getApplicationContext();
        this.view = view;
    }

    public void onAddGameRequested(String name)
    {
        view.switchToAddGame(name);

    }

    public void onAddGameConfirmed() {
    }
}
