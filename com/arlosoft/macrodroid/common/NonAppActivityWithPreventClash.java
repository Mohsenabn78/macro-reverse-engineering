package com.arlosoft.macrodroid.common;

import android.annotation.SuppressLint;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: NonAppActivityWithPreventClash.kt */
@StabilityInferred(parameters = 0)
@SuppressLint({"Registered"})
/* loaded from: classes3.dex */
public class NonAppActivityWithPreventClash extends NonAppActivity {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final long MIN_DELAY_BETWEEN_SHOWS = 500;

    /* renamed from: d  reason: collision with root package name */
    private static long f9991d;

    /* compiled from: NonAppActivityWithPreventClash.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final long getDelayUntilNextDisplay() {
            long max = Math.max(500 - (System.currentTimeMillis() - NonAppActivityWithPreventClash.f9991d), 0L);
            NonAppActivityWithPreventClash.f9991d = System.currentTimeMillis() + max;
            return max;
        }
    }

    @JvmStatic
    public static final long getDelayUntilNextDisplay() {
        return Companion.getDelayUntilNextDisplay();
    }
}
