package es.uji.al343696.mygames_antonivictor.myGames.addGame;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import es.uji.al343696.mygames_antonivictor.R;
import es.uji.al343696.mygames_antonivictor.myGames.model.AllGameData;
import es.uji.al343696.mygames_antonivictor.myGames.model.MyGamesModel;
import es.uji.al343696.mygames_antonivictor.myGames.model.inetserver.ResponseReceiver;

public class AddGameActivity extends AppCompatActivity implements IAddGameView{


    public static final String GAME_NAME = "gameName";

    ListView games_list;
    TextView not_found_text;
    ProgressBar progress_bar;
    AddGamePresenter presenter;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        games_list = findViewById(R.id.games_list);
        not_found_text = findViewById(R.id.no_found_text);
        progress_bar = findViewById(R.id.progress_bar);

        games_list.setEmptyView(not_found_text);

        presenter = new AddGamePresenter(MyGamesModel.getInstance());

        Intent intent = getIntent();
        String gameName = intent.getStringExtra(GAME_NAME);

        presenter.setSearchGameName(gameName);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);

    }


    @Override
    public void showTitle(String gameName) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(gameName);

    }

    @Override
    public void showSearchInProgress() {
        games_list.setVisibility(View.GONE);
        not_found_text.setVisibility(View.GONE);

        progress_bar.setVisibility(View.VISIBLE);

    }

    @Override
    public void findGames(String gameName, ResponseReceiver<List<AllGameData>> receiver) {


    }

    @Override
    public void displayNames(List names) {
        ListAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
        games_list.setAdapter(adapter);
        games_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.onAddGameRequested(position);
            }
        });
    }

    @Override
    public void askGameInsertionConfirmation(String name) {

    }

    @Override
    public void hideSearchInProgress() {
        games_list.setVisibility(View.VISIBLE);
        not_found_text.setVisibility(View.VISIBLE);

        progress_bar.setVisibility(View.GONE);

    }

    @Override
    public void showError(String message) {

    }


}
