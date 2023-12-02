package com.twofortyfouram.locale.sdk.host.internal;

import androidx.annotation.NonNull;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public enum PackageResult {
    NOTHING_CHANGED,
    CONDITIONS_CHANGED,
    SETTINGS_CHANGED,
    CONDITIONS_AND_SETTINGS_CHANGED,
    EVENTS_CHANGED,
    EVENTS_AND_CONDITIONS_CHANGED,
    EVENT_AND_SETTINGS_CHANGED,
    EVENT_AND_SETTINGS_AND_CONDITIONS_CHANGED;

    @NonNull
    public static PackageResult get(boolean z3, boolean z4, boolean z5) {
        if (z3 && z4 && z5) {
            return EVENT_AND_SETTINGS_AND_CONDITIONS_CHANGED;
        }
        if (z3 && z4) {
            return CONDITIONS_AND_SETTINGS_CHANGED;
        }
        if (z3 && z5) {
            return EVENTS_AND_CONDITIONS_CHANGED;
        }
        if (z5 && z4) {
            return EVENT_AND_SETTINGS_CHANGED;
        }
        if (z5) {
            return EVENTS_CHANGED;
        }
        if (z4) {
            return SETTINGS_CHANGED;
        }
        if (z3) {
            return CONDITIONS_CHANGED;
        }
        return NOTHING_CHANGED;
    }
}
