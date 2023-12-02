package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
/* loaded from: classes5.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {

    /* renamed from: a  reason: collision with root package name */
    private final P f25127a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private VisibilityAnimatorProvider f25128b;

    /* renamed from: c  reason: collision with root package name */
    private final List<VisibilityAnimatorProvider> f25129c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    public MaterialVisibility(P p4, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.f25127a = p4;
        this.f25128b = visibilityAnimatorProvider;
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
        a(arrayList, this.f25127a, viewGroup, view, z3);
        a(arrayList, this.f25128b, viewGroup, view, z3);
        for (VisibilityAnimatorProvider visibilityAnimatorProvider : this.f25129c) {
            a(arrayList, visibilityAnimatorProvider, viewGroup, view, z3);
        }
        f(viewGroup.getContext(), z3);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private void f(@NonNull Context context, boolean z3) {
        TransitionUtils.p(this, context, d(z3));
        TransitionUtils.q(this, context, e(z3), c(z3));
    }

    public void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.f25129c.add(visibilityAnimatorProvider);
    }

    @NonNull
    TimeInterpolator c(boolean z3) {
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public void clearAdditionalAnimatorProvider() {
        this.f25129c.clear();
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
        return this.f25127a;
    }

    @Nullable
    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.f25128b;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return b(viewGroup, view, false);
    }

    public boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.f25129c.remove(visibilityAnimatorProvider);
    }

    public void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.f25128b = visibilityAnimatorProvider;
    }
}
