package com.twofortyfouram.spackle;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import androidx.annotation.NonNull;
import com.twofortyfouram.assertion.Assertions;
import net.jcip.annotations.ThreadSafe;

@SuppressLint({"NewApi"})
@ThreadSafe
/* loaded from: classes6.dex */
public final class StrictModeCompat {
    private StrictModeCompat() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    public static void noteSlowCall(@NonNull String str) {
        Assertions.assertNotEmpty(str, "name");
        if (AndroidSdkVersion.isAtLeastSdk(11)) {
            StrictMode.noteSlowCall(str);
        }
    }

    public static void setStrictMode(boolean z3) {
        if (AndroidSdkVersion.isAtLeastSdk(9)) {
            if (z3) {
                StrictMode.enableDefaults();
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
                StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
                return;
            }
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        }
    }
}
