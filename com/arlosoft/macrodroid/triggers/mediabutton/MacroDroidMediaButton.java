package com.arlosoft.macrodroid.triggers.mediabutton;

import androidx.annotation.StringRes;
import com.arlosoft.macrodroid.R;

/* compiled from: MacroDroidMediaButton.kt */
/* loaded from: classes3.dex */
public enum MacroDroidMediaButton {
    PLAY(0, R.string.media_button_play),
    PLAY_PAUSE(1, R.string.action_control_media_play_pause),
    PAUSE(2, R.string.media_button_pause),
    STOP(3, R.string.action_control_media_stop),
    PREVIOUS(4, R.string.media_button_previous),
    NEXT(5, R.string.media_button_next),
    HEADSET_HOOK(6, R.string.media_button_headset_hook);
    
    private final int id;
    private final int stringRes;

    MacroDroidMediaButton(int i4, @StringRes int i5) {
        this.id = i4;
        this.stringRes = i5;
    }

    public final int getId() {
        return this.id;
    }

    public final int getStringRes() {
        return this.stringRes;
    }
}
