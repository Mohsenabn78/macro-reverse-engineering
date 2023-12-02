package com.hanks.htextview.scale;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;

/* loaded from: classes6.dex */
public class ScaleTextView extends HTextView {

    /* renamed from: a  reason: collision with root package name */
    private ScaleText f34041a;

    public ScaleTextView(Context context) {
        this(context, null);
    }

    @Override // com.hanks.htextview.base.HTextView
    public void animateText(CharSequence charSequence) {
        this.f34041a.animateText(charSequence);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f34041a.onDraw(canvas);
    }

    @Override // com.hanks.htextview.base.HTextView
    public void setAnimationListener(AnimationListener animationListener) {
        this.f34041a.setAnimationListener(animationListener);
    }

    @Override // com.hanks.htextview.base.HTextView
    public void setProgress(float f4) {
        this.f34041a.setProgress(f4);
    }

    public ScaleTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        ScaleText scaleText = new ScaleText();
        this.f34041a = scaleText;
        scaleText.init(this, attributeSet, i4);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
    }
}
