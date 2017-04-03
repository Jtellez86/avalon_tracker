package org.avalon.tracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerCountActivity extends Activity
{
    @BindView(R2.id.next_button)
    Button nextButton;

    @BindView((R2.id.playerCountField))
    EditText playerCountField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ButterKnife.bind(this);
    }

    public void goToCharacterSelection(View view) {
        Intent characterSelection = new Intent(this, CharacterSelectionActivity.class);
        characterSelection.putExtra("playerCount", playerCountField.getText().toString());
        PlayerCountActivity.this.startActivity(characterSelection);
    }
}
