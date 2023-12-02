package com.bumptech.glide.request.transition;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes3.dex */
public class DrawableCrossFadeTransition implements Transition<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f17542a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f17543b;

    public DrawableCrossFadeTransition(int i4, boolean z3) {
        this.f17542a = i4;
        this.f17543b = z3;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(Drawable drawable, Transition.ViewAdapter viewAdapter) {
        Drawable currentDrawable = viewAdapter.getCurrentDrawable();
        if (currentDrawable == null) {
            currentDrawable = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f17543b);
        transitionDrawable.startTransition(this.f17542a);
        viewAdapter.setDrawable(transitionDrawable);
        return true;
    }
}
