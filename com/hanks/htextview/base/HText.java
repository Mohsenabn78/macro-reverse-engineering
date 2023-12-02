package com.hanks.htextview.base;

import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class HText implements IHText {

    /* renamed from: a  reason: collision with root package name */
    protected int f34018a;

    /* renamed from: b  reason: collision with root package name */
    protected int f34019b;

    /* renamed from: c  reason: collision with root package name */
    protected CharSequence f34020c;

    /* renamed from: d  reason: collision with root package name */
    protected CharSequence f34021d;

    /* renamed from: e  reason: collision with root package name */
    protected TextPaint f34022e;

    /* renamed from: f  reason: collision with root package name */
    protected TextPaint f34023f;

    /* renamed from: g  reason: collision with root package name */
    protected HTextView f34024g;

    /* renamed from: j  reason: collision with root package name */
    protected float f34027j;

    /* renamed from: k  reason: collision with root package name */
    protected float f34028k;

    /* renamed from: m  reason: collision with root package name */
    protected AnimationListener f34030m;

    /* renamed from: h  reason: collision with root package name */
    protected List<Float> f34025h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    protected List<Float> f34026i = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    protected float f34029l = 0.0f;

    /* loaded from: classes6.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            float lineRight;
            HText.this.f34024g.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            HText hText = HText.this;
            hText.f34028k = hText.f34024g.getTextSize();
            HText hText2 = HText.this;
            hText2.f34019b = hText2.f34024g.getWidth();
            HText hText3 = HText.this;
            hText3.f34018a = hText3.f34024g.getHeight();
            HText hText4 = HText.this;
            hText4.f34029l = 0.0f;
            try {
                int layoutDirection = ViewCompat.getLayoutDirection(hText4.f34024g);
                HText hText5 = HText.this;
                if (layoutDirection == 0) {
                    lineRight = hText5.f34024g.getLayout().getLineLeft(0);
                } else {
                    lineRight = hText5.f34024g.getLayout().getLineRight(0);
                }
                hText5.f34029l = lineRight;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            HText.this.c();
        }
    }

    private void d() {
        float textSize = this.f34024g.getTextSize();
        this.f34028k = textSize;
        this.f34022e.setTextSize(textSize);
        this.f34022e.setColor(this.f34024g.getCurrentTextColor());
        this.f34022e.setTypeface(this.f34024g.getTypeface());
        this.f34025h.clear();
        for (int i4 = 0; i4 < this.f34020c.length(); i4++) {
            this.f34025h.add(Float.valueOf(this.f34022e.measureText(String.valueOf(this.f34020c.charAt(i4)))));
        }
        this.f34023f.setTextSize(this.f34028k);
        this.f34023f.setColor(this.f34024g.getCurrentTextColor());
        this.f34023f.setTypeface(this.f34024g.getTypeface());
        this.f34026i.clear();
        for (int i5 = 0; i5 < this.f34021d.length(); i5++) {
            this.f34026i.add(Float.valueOf(this.f34023f.measureText(String.valueOf(this.f34021d.charAt(i5)))));
        }
    }

    protected abstract void a(CharSequence charSequence);

    @Override // com.hanks.htextview.base.IHText
    public void animateText(CharSequence charSequence) {
        this.f34024g.setText(charSequence);
        this.f34021d = this.f34020c;
        this.f34020c = charSequence;
        d();
        a(charSequence);
        b(charSequence);
    }

    protected abstract void b(CharSequence charSequence);

    protected abstract void c();

    protected abstract void drawFrame(Canvas canvas);

    @Override // com.hanks.htextview.base.IHText
    public void init(HTextView hTextView, AttributeSet attributeSet, int i4) {
        this.f34024g = hTextView;
        this.f34021d = "";
        this.f34020c = hTextView.getText();
        this.f34027j = 1.0f;
        this.f34022e = new TextPaint(1);
        this.f34023f = new TextPaint(this.f34022e);
        this.f34024g.getViewTreeObserver().addOnGlobalLayoutListener(new a());
        d();
    }

    @Override // com.hanks.htextview.base.IHText
    public void onDraw(Canvas canvas) {
        drawFrame(canvas);
    }

    @Override // com.hanks.htextview.base.IHText
    public void setAnimationListener(AnimationListener animationListener) {
        this.f34030m = animationListener;
    }

    public void setProgress(float f4) {
        this.f34027j = f4;
        this.f34024g.invalidate();
    }
}
