package com.hanks.htextview.base;

import android.graphics.Canvas;
import android.util.AttributeSet;

/* loaded from: classes6.dex */
public interface IHText {
    void animateText(CharSequence charSequence);

    void init(HTextView hTextView, AttributeSet attributeSet, int i4);

    void onDraw(Canvas canvas);

    void setAnimationListener(AnimationListener animationListener);
}
