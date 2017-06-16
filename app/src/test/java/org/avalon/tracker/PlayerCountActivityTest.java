package org.avalon.tracker;


import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

import org.avalon.tracker.characterSelection.CharacterSelectionActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class PlayerCountActivityTest {

    PlayerCountActivity playerCountActivity;
    Button nextButton;
    EditText playerCountField;

    @Before
    public void setup() {
        playerCountActivity = Robolectric.buildActivity(PlayerCountActivity.class).create().resume().get();
        nextButton = (Button) playerCountActivity.findViewById(R.id.next_button);
        playerCountField = (EditText) playerCountActivity.findViewById(R.id.playerCountField);
    }

    @Test
    public void onCreate_shouldContainCorrectView() {
        assertThat(nextButton).isNotNull();
        assertThat(playerCountField).isNotNull();
    }

    @Test
    public void onCreate_shouldGoToCharacterSelectionScreenWithCorrectNumberOfPlayersFromField() {
        playerCountField.setText("10");

        ShadowActivity shadowActivity = shadowOf(playerCountActivity);

        nextButton.performClick();

        Intent intentForNextActivity = shadowActivity.peekNextStartedActivity();

        assertThat(intentForNextActivity.getComponent().getClassName()).isEqualTo(CharacterSelectionActivity.class.getCanonicalName());
        assertThat(intentForNextActivity.getIntExtra("playerCount", 0)).isEqualTo(Integer.valueOf(playerCountField.getText().toString()));
    }

}
