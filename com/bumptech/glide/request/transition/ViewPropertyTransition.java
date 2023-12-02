package com.bumptech.glide.request.transition;

import android.view.View;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public class ViewPropertyTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Animator f17552a;

    /* loaded from: classes3.dex */
    public interface Animator {
        void animate(View view);
    }

    public ViewPropertyTransition(Animator animator) {
        this.f17552a = animator;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r4, Transition.ViewAdapter viewAdapter) {
        if (viewAdapter.getView() != null) {
            this.f17552a.animate(viewAdapter.getView());
            return false;
        }
        return false;
    }
}
