package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {

    /* renamed from: a  reason: collision with root package name */
    private final P f24977a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private VisibilityAnimatorProvider f24978b;

    /* renamed from: c  reason: collision with root package name */
    private final List<VisibilityAnimatorProvider> f24979c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public MaterialVisibility(P p4, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.f24977a = p4;
        this.f24978b = visibilityAnimatorProvider;
    }

    private static void a(List<Animator> list, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z3) {
        Animator createDisappear;
        if (visibilityAnimatorProvider == null) {
            return;
        }
        if (z3) {
            createDisappear = visibilityAnimatorProvider.createAppear(viewGroup, view);
        } else {
            createDisappear = visibilityAnimatorProvider.createDisappear(viewGroup, view);
        }
        if (createDisappear != null) {
            list.add(createDisappear);
        }
    }

    private Animator b(@NonNull ViewGroup viewGroup, @NonNull View view, boolean z3) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        a(arrayList, this.f24977a, viewGroup, view, z3);
        a(arrayList, this.f24978b, viewGroup, view, z3);
        for (VisibilityAnimatorProvider visibilityAnimatorProvider : this.f24979c) {
            a(arrayList, visibilityAnimatorProvider, viewGroup, view, z3);
        }
        f(viewGroup.getContext(), z3);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private void f(@NonNull Context context, boolean z3) {
        TransitionUtils.o(this, context, d(z3));
        TransitionUtils.p(this, context, e(z3), c(z3));
    }

    public void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.f24979c.add(visibilityAnimatorProvider);
    }

    @NonNull
    TimeInterpolator c(boolean z3) {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public void clearAdditionalAnimatorProvider() {
        this.f24979c.clear();
    }

    @AttrRes
    int d(boolean z3) {
        return 0;
    }

    @AttrRes
    int e(boolean z3) {
        return 0;
    }

    @NonNull
    public P getPrimaryAnimatorProvider() {
        return this.f24977a;
    }

    @Nullable
    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.f24978b;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, false);
    }

    public boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.f24979c.remove(visibilityAnimatorProvider);
    }

    public void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.f24978b = visibilityAnimatorProvider;
    }
}
