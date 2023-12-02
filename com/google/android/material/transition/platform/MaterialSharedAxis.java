package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
/* loaded from: classes5.dex */
public final class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {
    public static final int X = 0;
    public static final int Y = 1;
    public static final int Z = 2;
    @AttrRes

    /* renamed from: f  reason: collision with root package name */
    private static final int f25123f = R.attr.motionDurationLong1;
    @AttrRes

    /* renamed from: g  reason: collision with root package name */
    private static final int f25124g = R.attr.motionEasingStandard;

    /* renamed from: d  reason: collision with root package name */
    private final int f25125d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25126e;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface Axis {
    }

    public MaterialSharedAxis(int i4, boolean z3) {
        super(g(i4, z3), h());
        this.f25125d = i4;
        this.f25126e = z3;
    }

    private static VisibilityAnimatorProvider g(int i4, boolean z3) {
        int i5;
        int i6;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return new ScaleProvider(z3);
                }
                throw new IllegalArgumentException("Invalid axis: " + i4);
            }
            if (z3) {
                i6 = 80;
            } else {
                i6 = 48;
            }
            return new SlideDistanceProvider(i6);
        }
        if (z3) {
            i5 = GravityCompat.END;
        } else {
            i5 = GravityCompat.START;
        }
        return new SlideDistanceProvider(i5);
    }

    private static VisibilityAnimatorProvider h() {
        return new FadeThroughProvider();
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void addAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.addAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void clearAdditionalAnimatorProvider() {
        super.clearAdditionalAnimatorProvider();
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @AttrRes
    int d(boolean z3) {
        return f25123f;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @AttrRes
    int e(boolean z3) {
        return f25124g;
    }

    public int getAxis() {
        return this.f25125d;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getPrimaryAnimatorProvider() {
        return super.getPrimaryAnimatorProvider();
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return super.getSecondaryAnimatorProvider();
    }

    public boolean isForward() {
        return this.f25126e;
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ boolean removeAdditionalAnimatorProvider(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.removeAdditionalAnimatorProvider(visibilityAnimatorProvider);
    }

    @Override // com.google.android.material.transition.platform.MaterialVisibility
    public /* bridge */ /* synthetic */ void setSecondaryAnimatorProvider(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.setSecondaryAnimatorProvider(visibilityAnimatorProvider);
    }
}
