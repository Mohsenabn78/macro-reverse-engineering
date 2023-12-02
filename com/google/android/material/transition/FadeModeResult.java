package com.google.android.material.transition;

/* loaded from: classes5.dex */
class FadeModeResult {

    /* renamed from: a  reason: collision with root package name */
    final int f24868a;

    /* renamed from: b  reason: collision with root package name */
    final int f24869b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f24870c;

    private FadeModeResult(int i4, int i5, boolean z3) {
        this.f24868a = i4;
        this.f24869b = i5;
        this.f24870c = z3;
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
