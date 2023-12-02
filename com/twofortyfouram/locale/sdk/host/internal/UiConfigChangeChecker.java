package com.twofortyfouram.locale.sdk.host.internal;

import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;

/* loaded from: classes6.dex */
public final class UiConfigChangeChecker {
    @NonNull
    private final Configuration mLastConfiguration = new Configuration();
    private int mLastDensity = 0;

    @CheckResult
    public boolean checkNewConfig(@NonNull Resources resources) {
        boolean z3;
        Assertions.assertNotNull(resources, "res");
        int updateFrom = this.mLastConfiguration.updateFrom(resources.getConfiguration());
        if (this.mLastDensity != resources.getDisplayMetrics().densityDpi) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.mLastDensity = resources.getDisplayMetrics().densityDpi;
        if (z3 || (updateFrom & 772) != 0) {
            return true;
        }
        return false;
    }
}
