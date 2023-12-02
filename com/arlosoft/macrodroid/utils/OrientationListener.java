package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.view.OrientationEventListener;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PortraitOrientationListener.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class OrientationListener extends OrientationEventListener {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final OrientationChangedListener f16070a;

    /* renamed from: b  reason: collision with root package name */
    private int f16071b;

    /* compiled from: PortraitOrientationListener.kt */
    /* loaded from: classes3.dex */
    public interface OrientationChangedListener {
        void orientationUpdated(boolean z3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrientationListener(@Nullable Context context, int i4, @NotNull OrientationChangedListener orientationChangedListener) {
        super(context, i4);
        Intrinsics.checkNotNullParameter(orientationChangedListener, "orientationChangedListener");
        this.f16070a = orientationChangedListener;
        this.f16071b = -1;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i4) {
        boolean z3;
        int i5;
        boolean z4;
        boolean z5;
        if (i4 == -1) {
            return;
        }
        boolean z6 = true;
        if (330 <= i4 && i4 < 361) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            if (i4 >= 0 && i4 < 31) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                if (150 <= i4 && i4 < 211) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    i5 = 1;
                } else {
                    i5 = -1;
                }
                if (i5 == -1 && this.f16071b != i5) {
                    this.f16071b = i5;
                    OrientationChangedListener orientationChangedListener = this.f16070a;
                    if (i5 != 0) {
                        z6 = false;
                    }
                    orientationChangedListener.orientationUpdated(z6);
                    return;
                }
            }
        }
        i5 = 0;
        if (i5 == -1) {
        }
    }
}
