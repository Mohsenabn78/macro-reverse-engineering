package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public class NoTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    static final NoTransition<?> f17544a = new NoTransition<>();

    /* renamed from: b  reason: collision with root package name */
    private static final TransitionFactory<?> f17545b = new NoAnimationFactory();

    /* loaded from: classes3.dex */
    public static class NoAnimationFactory<R> implements TransitionFactory<R> {
        @Override // com.bumptech.glide.request.transition.TransitionFactory
        public Transition<R> build(DataSource dataSource, boolean z3) {
            return NoTransition.f17544a;
        }
    }

    public static <R> Transition<R> get() {
        return f17544a;
    }

    public static <R> TransitionFactory<R> getFactory() {
        return (TransitionFactory<R>) f17545b;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
