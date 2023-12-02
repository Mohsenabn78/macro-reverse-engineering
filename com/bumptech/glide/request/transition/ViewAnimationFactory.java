package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewTransition;

/* loaded from: classes3.dex */
public class ViewAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewTransition.a f17546a;

    /* renamed from: b  reason: collision with root package name */
    private Transition<R> f17547b;

    /* loaded from: classes3.dex */
    private static class a implements ViewTransition.a {

        /* renamed from: a  reason: collision with root package name */
        private final Animation f17548a;

        a(Animation animation) {
            this.f17548a = animation;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.a
        public Animation a(Context context) {
            return this.f17548a;
        }
    }

    /* loaded from: classes3.dex */
    private static class b implements ViewTransition.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f17549a;

        b(int i4) {
            this.f17549a = i4;
        }

        @Override // com.bumptech.glide.request.transition.ViewTransition.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.f17549a);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this(new a(animation));
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z3) {
        if (dataSource != DataSource.MEMORY_CACHE && z3) {
            if (this.f17547b == null) {
                this.f17547b = new ViewTransition(this.f17546a);
            }
            return this.f17547b;
        }
        return NoTransition.get();
    }

    public ViewAnimationFactory(int i4) {
        this(new b(i4));
    }

    ViewAnimationFactory(ViewTransition.a aVar) {
        this.f17546a = aVar;
    }
}
