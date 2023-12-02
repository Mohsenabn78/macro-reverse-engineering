package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.ViewPropertyTransition;

/* loaded from: classes3.dex */
public class ViewPropertyAnimationFactory<R> implements TransitionFactory<R> {

    /* renamed from: a  reason: collision with root package name */
    private final ViewPropertyTransition.Animator f17550a;

    /* renamed from: b  reason: collision with root package name */
    private ViewPropertyTransition<R> f17551b;

    public ViewPropertyAnimationFactory(ViewPropertyTransition.Animator animator) {
        this.f17550a = animator;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<R> build(DataSource dataSource, boolean z3) {
        if (dataSource != DataSource.MEMORY_CACHE && z3) {
            if (this.f17551b == null) {
                this.f17551b = new ViewPropertyTransition<>(this.f17550a);
            }
            return this.f17551b;
        }
        return NoTransition.get();
    }
}
