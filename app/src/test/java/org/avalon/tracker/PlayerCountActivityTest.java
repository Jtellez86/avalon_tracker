package org.avalon.tracker;


import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowView;
import org.robolectric.util.ActivityController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Shadows.shadowOf;


@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class PlayerCountActivityTest {
    private ActivityController<PlayerCountActivity> controller;

    PlayerCountActivity playerCountActivity;
    Button nextButton;
    EditText playerCountField;

    @Before
    public void setup() {
        controller = Robolectric.buildActivity(PlayerCountActivity.class);
        playerCountActivity = controller.create().resume().get();
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
        assertThat(intentForNextActivity.getStringExtra("playerCount")).isEqualTo(playerCountField.getText().toString());
    }

}
