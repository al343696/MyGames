package es.uji.al343696.mygames_antonivictor.myGames;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import es.uji.al343696.mygames_antonivictor.R;

/**
 * Created by al343696 on 2/03/18.
 */

public class AskGameDialog extends DialogFragment
{
    EditText gameNameEdit;
    IGameNameListener gameNameListener;

    public interface IGameNameListener
    {

        void onNameInput(String name);


    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        Activity context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        View view = context.getLayoutInflater().inflate(R.layout.lookfor_name_layout,null);
        gameNameEdit = view.findViewById(R.id.gameNameEdit);

        builder.setView(view);
        builder.setPositiveButton("SEARCH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(gameNameListener!=null)
                {
                    gameNameListener.onNameInput(gameNameEdit.getText().toString());
                }
            }
        });

        builder.setNegativeButton("CANCEL", null);


        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        gameNameListener = (IGameNameListener)context;
    }
}
