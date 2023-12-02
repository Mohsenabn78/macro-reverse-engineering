package com.google.android.material.resources;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class CancelableFontCallback extends TextAppearanceFontCallback {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f24123a;

    /* renamed from: b  reason: collision with root package name */
    private final ApplyFont f24124b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24125c;

    /* loaded from: classes5.dex */
    public interface ApplyFont {
        void apply(Typeface typeface);
    }

    public CancelableFontCallback(ApplyFont applyFont, Typeface typeface) {
        this.f24123a = typeface;
        this.f24124b = applyFont;
    }

    private void a(Typeface typeface) {
        if (!this.f24125c) {
            this.f24124b.apply(typeface);
        }
    }

    public void cancel() {
        this.f24125c = true;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i4) {
        a(this.f24123a);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(Typeface typeface, boolean z3) {
        a(typeface);
    }
}
