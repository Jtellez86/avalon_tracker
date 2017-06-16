package org.avalon.tracker.characterSelection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.avalon.tracker.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class CharacterSelectionActivity extends Activity {
    private Integer playerCount;
    private List<String> selection;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_selection);
        ButterKnife.bind(this);

        GridView gridview = (GridView) findViewById(R.id.characterGrid);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

            }
        });

        playerCount = getIntent().getIntExtra("playerCount", 0);
        selection = new ArrayList<>();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    public Integer getPlayerCount() {
        return playerCount;
    }

    public List<String> getSelection() {
        return selection;
    }
}
