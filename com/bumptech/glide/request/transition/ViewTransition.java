package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public class ViewTransition<R> implements Transition<R> {

    /* renamed from: a  reason: collision with root package name */
    private final a f17553a;

    /* loaded from: classes3.dex */
    interface a {
        Animation a(Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTransition(a aVar) {
        this.f17553a = aVar;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r4, Transition.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.f17553a.a(view.getContext()));
            return false;
        }
        return false;
    }
}
