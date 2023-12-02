package com.twofortyfouram.locale.sdk.client.ui.activity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes6.dex */
public interface IPluginActivity {
    @Nullable
    String getPreviousBlurb();

    @Nullable
    Bundle getPreviousBundle();

    @NonNull
    String getResultBlurb(@NonNull Bundle bundle);

    @Nullable
    Bundle getResultBundle();

    boolean isBundleValid(@NonNull Bundle bundle);

    void onPostCreateWithPreviousResult(@NonNull Bundle bundle, @NonNull String str);
}
