package org.avalon.tracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.avalon.tracker.characterSelection.CharacterSelectionActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @OnClick(R.id.next_button)
    public void goToCharacterSelection(View view) {
        Intent characterSelection = new Intent(PlayerCountActivity.this, CharacterSelectionActivity.class);
        characterSelection.putExtra("playerCount", Integer.valueOf(playerCountField.getText().toString()));
        PlayerCountActivity.this.startActivity(characterSelection);
    }
}
