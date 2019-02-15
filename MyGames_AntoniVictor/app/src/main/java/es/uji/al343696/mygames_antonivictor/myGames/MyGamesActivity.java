package es.uji.al343696.mygames_antonivictor.myGames;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import es.uji.al343696.mygames_antonivictor.R;
import es.uji.al343696.mygames_antonivictor.myGames.addGame.AddGameActivity;

public class MyGamesActivity extends AppCompatActivity implements IMyGamesView, AskGameDialog.IGameNameListener{

    private MyGamesPresenter presenter;
    private TextView noNames;
    private ListView namesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Context context = this.getApplicationContext();

        noNames = findViewById(R.id.noNames);
        namesList = findViewById(R.id.namesList);

        presenter = new MyGamesPresenter(this,this.getApplicationContext());

        namesList.setEmptyView(noNames);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_games);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AskGameDialog askGameDialog = new AskGameDialog();
                askGameDialog.show(getFragmentManager(),"AskGameName");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_games, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onNameInput(String name) {
        presenter.onAddGameRequested(name);

    }

    @Override
    public void switchToAddGame(String name) {
        Intent intent = new Intent(this,AddGameActivity.class);

        intent.putExtra(AddGameActivity.GAME_NAME,name);

        startActivity(intent);
    }

    @Override
    public void showSearchInProgress() {

    }

    @Override       //aqui 2.5 pagina 9
    public void gamesFound() {

    }
}
