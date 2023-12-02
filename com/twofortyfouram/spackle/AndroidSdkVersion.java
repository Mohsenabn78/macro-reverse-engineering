package com.twofortyfouram.spackle;

import android.os.Build;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class AndroidSdkVersion {
    private AndroidSdkVersion() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    public static boolean isAtLeastSdk(int i4) {
        if (Build.VERSION.SDK_INT >= i4) {
            return true;
        }
        return false;
    }
}
