package org.avalon.tracker.characterSelection;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import org.avalon.tracker.BuildConfig;
import org.avalon.tracker.PlayerCountActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static java.lang.Integer.valueOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.robolectric.Robolectric.buildActivity;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class CharacterSelectionActivityTest {

    CharacterSelectionActivity activity;

    @Before
    public void setUp() throws Exception {
        Intent characterSelection = new Intent();
        characterSelection.putExtra("playerCount", 3);
        activity = buildActivity(CharacterSelectionActivity.class).withIntent(characterSelection).create().get();
    }

    @Test
    public void onCreate_shouldGetPlayerCountFromIntent() {
        assertThat(activity.getPlayerCount()).isEqualTo(valueOf(3));
    }

//    @Test
//    public void selectCharacter_shouldAddCharacterToSelection() {
//        assertThat(activity.getSelection()).isEqualTo(Arrays.asList("Assassin", "Morgana", "Merlin", "Perceval"));
//    }
}
