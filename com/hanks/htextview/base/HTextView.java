package com.hanks.htextview.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/* loaded from: classes6.dex */
public abstract class HTextView extends TextView {
    public HTextView(Context context) {
        this(context, null);
    }

    public abstract void animateText(CharSequence charSequence);

    public abstract void setAnimationListener(AnimationListener animationListener);

    public abstract void setProgress(float f4);

    public HTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }
}
