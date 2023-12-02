package com.google.android.material.textfield;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class EndIconDelegate {

    /* renamed from: a  reason: collision with root package name */
    TextInputLayout f24595a;

    /* renamed from: b  reason: collision with root package name */
    Context f24596b;

    /* renamed from: c  reason: collision with root package name */
    CheckableImageButton f24597c;
    @DrawableRes

    /* renamed from: d  reason: collision with root package name */
    final int f24598d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EndIconDelegate(@NonNull TextInputLayout textInputLayout, @DrawableRes int i4) {
        this.f24595a = textInputLayout;
        this.f24596b = textInputLayout.getContext();
        this.f24597c = textInputLayout.getEndIconView();
        this.f24598d = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i4) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z3) {
    }
}
