package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class StateListAnimator {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Tuple> f23878a = new ArrayList<>();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Tuple f23879b = null;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f23880c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f23881d = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.StateListAnimator.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.f23880c == animator) {
                stateListAnimator.f23880c = null;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Tuple {

        /* renamed from: a  reason: collision with root package name */
        final int[] f23883a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f23884b;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.f23883a = iArr;
            this.f23884b = valueAnimator;
        }
    }

    private void a() {
        ValueAnimator valueAnimator = this.f23880c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f23880c = null;
        }
    }

    private void b(@NonNull Tuple tuple) {
        ValueAnimator valueAnimator = tuple.f23884b;
        this.f23880c = valueAnimator;
        valueAnimator.start();
    }

    public void addState(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.f23881d);
        this.f23878a.add(tuple);
    }

    public void jumpToCurrentState() {
        ValueAnimator valueAnimator = this.f23880c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f23880c = null;
        }
    }

    public void setState(int[] iArr) {
        Tuple tuple;
        int size = this.f23878a.size();
        int i4 = 0;
        while (true) {
            if (i4 < size) {
                tuple = this.f23878a.get(i4);
                if (StateSet.stateSetMatches(tuple.f23883a, iArr)) {
                    break;
                }
                i4++;
            } else {
                tuple = null;
                break;
            }
        }
        Tuple tuple2 = this.f23879b;
        if (tuple == tuple2) {
            return;
        }
        if (tuple2 != null) {
            a();
        }
        this.f23879b = tuple;
        if (tuple != null) {
            b(tuple);
        }
    }
}
