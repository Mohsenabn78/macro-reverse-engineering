package com.twofortyfouram.spackle.bundle;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class BundleScrubber {
    private BundleScrubber() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @CheckResult
    public static boolean scrub(@Nullable Intent intent) {
        if (intent != null) {
            boolean scrub = scrub(intent.getExtras());
            if (scrub) {
                intent.replaceExtras(new Bundle());
                return scrub;
            }
            return scrub;
        }
        return false;
    }

    @CheckResult
    public static boolean scrub(@Nullable Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.containsKey(null);
            } catch (Exception unused) {
                bundle.clear();
                return true;
            }
        }
        return false;
    }
}
