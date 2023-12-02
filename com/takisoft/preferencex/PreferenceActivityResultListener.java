package com.takisoft.preferencex;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;

/* loaded from: classes6.dex */
public interface PreferenceActivityResultListener {
    void onActivityResult(int i4, int i5, @Nullable Intent intent);

    void onPreferenceClick(@NonNull PreferenceFragmentCompat preferenceFragmentCompat, @NonNull Preference preference);
}
