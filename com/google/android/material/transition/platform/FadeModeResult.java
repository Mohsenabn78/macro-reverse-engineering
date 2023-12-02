package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes5.dex */
class FadeModeResult {

    /* renamed from: a  reason: collision with root package name */
    final int f25006a;

    /* renamed from: b  reason: collision with root package name */
    final int f25007b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f25008c;

    private FadeModeResult(int i4, int i5, boolean z3) {
        this.f25006a = i4;
        this.f25007b = i5;
        this.f25008c = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FadeModeResult a(int i4, int i5) {
        return new FadeModeResult(i4, i5, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FadeModeResult b(int i4, int i5) {
        return new FadeModeResult(i4, i5, false);
    }
}
