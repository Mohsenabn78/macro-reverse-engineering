package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {

    /* renamed from: a  reason: collision with root package name */
    private int f24989a;
    @Px

    /* renamed from: b  reason: collision with root package name */
    private int f24990b = -1;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes5.dex */
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i4) {
        this.f24989a = i4;
    }

    private static Animator a(View view, View view2, int i4, @Px int i5) {
        float f4;
        float f5;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 48) {
                    if (i4 != 80) {
                        if (i4 != 8388611) {
                            if (i4 == 8388613) {
                                if (f(view)) {
                                    f5 = translationX - i5;
                                } else {
                                    f5 = i5 + translationX;
                                }
                                return c(view2, f5, translationX, translationX);
                            }
                            throw new IllegalArgumentException("Invalid slide direction: " + i4);
                        }
                        if (f(view)) {
                            f4 = i5 + translationX;
                        } else {
                            f4 = translationX - i5;
                        }
                        return c(view2, f4, translationX, translationX);
                    }
                    return d(view2, i5 + translationY, translationY, translationY);
                }
                return d(view2, translationY - i5, translationY, translationY);
            }
            return c(view2, translationX - i5, translationX, translationX);
        }
        return c(view2, i5 + translationX, translationX, translationX);
    }

    private static Animator b(View view, View view2, int i4, @Px int i5) {
        float f4;
        float f5;
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i4 != 3) {
            if (i4 != 5) {
                if (i4 != 48) {
                    if (i4 != 80) {
                        if (i4 != 8388611) {
                            if (i4 == 8388613) {
                                if (f(view)) {
                                    f5 = i5 + translationX;
                                } else {
                                    f5 = translationX - i5;
                                }
                                return c(view2, translationX, f5, translationX);
                            }
                            throw new IllegalArgumentException("Invalid slide direction: " + i4);
                        }
                        if (f(view)) {
                            f4 = translationX - i5;
                        } else {
                            f4 = i5 + translationX;
                        }
                        return c(view2, translationX, f4, translationX);
                    }
                    return d(view2, translationY, translationY - i5, translationY);
                }
                return d(view2, translationY, i5 + translationY, translationY);
            }
            return c(view2, translationX, i5 + translationX, translationX);
        }
        return c(view2, translationX, translationX - i5, translationX);
    }

    private static Animator c(final View view, float f4, float f5, final float f6) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f4, f5));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationX(f6);
            }
        });
        return ofPropertyValuesHolder;
    }

    private static Animator d(final View view, float f4, float f5, final float f6) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f4, f5));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transition.SlideDistanceProvider.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setTranslationY(f6);
            }
        });
        return ofPropertyValuesHolder;
    }

    private int e(Context context) {
        int i4 = this.f24990b;
        if (i4 != -1) {
            return i4;
        }
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean f(View view) {
        if (ViewCompat.getLayoutDirection(view) == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createAppear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return a(viewGroup, view, this.f24989a, e(view.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    @Nullable
    public Animator createDisappear(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return b(viewGroup, view, this.f24989a, e(view.getContext()));
    }

    @Px
    public int getSlideDistance() {
        return this.f24990b;
    }

    public int getSlideEdge() {
        return this.f24989a;
    }

    public void setSlideDistance(@Px int i4) {
        if (i4 >= 0) {
            this.f24990b = i4;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void setSlideEdge(int i4) {
        this.f24989a = i4;
    }
}
