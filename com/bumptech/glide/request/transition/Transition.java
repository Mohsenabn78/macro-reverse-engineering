package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public interface Transition<R> {

    /* loaded from: classes3.dex */
    public interface ViewAdapter {
        @Nullable
        Drawable getCurrentDrawable();

        View getView();

        void setDrawable(Drawable drawable);
    }

    boolean transition(R r4, ViewAdapter viewAdapter);
}
