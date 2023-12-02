package com.bumptech.glide.request.transition;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public abstract class BitmapContainerTransitionFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    private final TransitionFactory<Drawable> f17534a;

    /* loaded from: classes3.dex */
    private final class a implements Transition<R> {

        /* renamed from: a  reason: collision with root package name */
        private final Transition<Drawable> f17535a;

        a(Transition<Drawable> transition) {
            this.f17535a = transition;
        }

        @Override // com.bumptech.glide.request.transition.Transition
        public boolean transition(R r4, Transition.ViewAdapter viewAdapter) {
            return this.f17535a.transition(new BitmapDrawable(viewAdapter.getView().getResources(), BitmapContainerTransitionFactory.this.a(r4)), viewAdapter);
        }
    }

    public BitmapContainerTransitionFactory(TransitionFactory<Drawable> transitionFactory) {
        this.f17534a = transitionFactory;
    }

    protected abstract Bitmap a(R r4);

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z3) {
        return new a(this.f17534a.build(dataSource, z3));
    }
}
