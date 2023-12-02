package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public abstract class IndeterminateAnimatorDelegate<T extends Animator> {

    /* renamed from: a  reason: collision with root package name */
    protected IndeterminateDrawable f24089a;

    /* renamed from: b  reason: collision with root package name */
    protected final float[] f24090b;

    /* renamed from: c  reason: collision with root package name */
    protected final int[] f24091c;

    /* JADX INFO: Access modifiers changed from: protected */
    public IndeterminateAnimatorDelegate(int i4) {
        this.f24090b = new float[i4 * 2];
        this.f24091c = new int[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: protected */
    public float b(int i4, int i5, int i6) {
        return (i4 - i5) / i6;
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@NonNull IndeterminateDrawable indeterminateDrawable) {
        this.f24089a = indeterminateDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void f();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g();

    public abstract void h();
}
