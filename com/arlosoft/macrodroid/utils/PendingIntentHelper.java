package com.arlosoft.macrodroid.utils;

import android.os.Build;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: PendingIntentHelper.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PendingIntentHelper {
    public static final int $stable = 0;
    @JvmField
    public static final int FLAG_IMMUTABLE;
    @JvmField
    public static final int FLAG_MUTABLE;
    @NotNull
    public static final PendingIntentHelper INSTANCE = new PendingIntentHelper();

    static {
        int i4;
        int i5 = Build.VERSION.SDK_INT;
        int i6 = 0;
        if (i5 >= 23) {
            i4 = 67108864;
        } else {
            i4 = 0;
        }
        FLAG_IMMUTABLE = i4;
        if (i5 >= 31) {
            i6 = 33554432;
        }
        FLAG_MUTABLE = i6;
    }

    private PendingIntentHelper() {
    }
}
