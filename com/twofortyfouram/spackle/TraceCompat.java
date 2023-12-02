package com.twofortyfouram.spackle;

import android.annotation.TargetApi;
import android.os.Trace;
import androidx.annotation.NonNull;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class TraceCompat {
    private TraceCompat() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    @TargetApi(18)
    private static void a(@NonNull String str) {
        Trace.beginSection(str);
    }

    @TargetApi(18)
    private static void b() {
        Trace.endSection();
    }

    public static void beginSection(@NonNull String str) {
        if (AndroidSdkVersion.isAtLeastSdk(18)) {
            a(str);
        }
    }

    public static void endSection() {
        if (AndroidSdkVersion.isAtLeastSdk(18)) {
            b();
        }
    }
}
