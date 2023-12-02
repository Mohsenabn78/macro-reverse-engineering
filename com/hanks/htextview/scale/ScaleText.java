package com.hanks.htextview.scale;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.hanks.htextview.base.CharacterDiffResult;
import com.hanks.htextview.base.CharacterUtils;
import com.hanks.htextview.base.DefaultAnimatorListener;
import com.hanks.htextview.base.HText;
import com.hanks.htextview.base.HTextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class ScaleText extends HText {

    /* renamed from: n  reason: collision with root package name */
    float f34032n = 20.0f;

    /* renamed from: o  reason: collision with root package name */
    float f34033o = 400.0f;

    /* renamed from: p  reason: collision with root package name */
    private List<CharacterDiffResult> f34034p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private long f34035q;

    /* renamed from: r  reason: collision with root package name */
    private ValueAnimator f34036r;

    /* loaded from: classes6.dex */
    class a extends DefaultAnimatorListener {
        a() {
        }

        @Override // com.hanks.htextview.base.DefaultAnimatorListener, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (((HText) ScaleText.this).f34030m != null) {
                ((HText) ScaleText.this).f34030m.onAnimationEnd(((HText) ScaleText.this).f34024g);
            }
        }
    }

    /* loaded from: classes6.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((HText) ScaleText.this).f34027j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ((HText) ScaleText.this).f34024g.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CharSequence f34039a;

        c(CharSequence charSequence) {
            this.f34039a = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((HText) ScaleText.this).f34024g != null && ((HText) ScaleText.this).f34024g.getLayout() != null) {
                ScaleText scaleText = ScaleText.this;
                ((HText) scaleText).f34029l = ((HText) scaleText).f34024g.getLayout().getLineLeft(0);
                ScaleText.super.animateText(this.f34039a);
            }
        }
    }

    @Override // com.hanks.htextview.base.HText
    protected void a(CharSequence charSequence) {
        this.f34034p.clear();
        this.f34034p.addAll(CharacterUtils.diff(this.f34021d, this.f34020c));
    }

    @Override // com.hanks.htextview.base.HText, com.hanks.htextview.base.IHText
    public void animateText(CharSequence charSequence) {
        HTextView hTextView = this.f34024g;
        if (hTextView != null && hTextView.getLayout() != null) {
            this.f34024g.post(new c(charSequence));
        }
    }

    @Override // com.hanks.htextview.base.HText
    protected void b(CharSequence charSequence) {
        int length = this.f34020c.length();
        if (length <= 0) {
            length = 1;
        }
        float f4 = this.f34033o;
        this.f34035q = f4 + ((f4 / this.f34032n) * (length - 1));
        this.f34036r.cancel();
        this.f34036r.setFloatValues(0.0f, 1.0f);
        this.f34036r.setDuration(this.f34035q);
        this.f34036r.start();
    }

    @Override // com.hanks.htextview.base.HText
    public void drawFrame(Canvas canvas) {
        float f4;
        String str;
        int i4;
        float f5;
        float lineLeft = this.f34024g.getLayout().getLineLeft(0);
        float baseline = this.f34024g.getBaseline();
        float f6 = this.f34029l;
        int max = Math.max(this.f34020c.length(), this.f34021d.length());
        float f7 = lineLeft;
        float f8 = f6;
        int i5 = 0;
        while (i5 < max) {
            if (i5 < this.f34021d.length()) {
                int needMove = CharacterUtils.needMove(i5, this.f34034p);
                if (needMove != -1) {
                    this.f34023f.setTextSize(this.f34028k);
                    this.f34023f.setAlpha(255);
                    float f9 = this.f34027j * 2.0f;
                    if (f9 > 1.0f) {
                        f5 = 1.0f;
                    } else {
                        f5 = f9;
                    }
                    str = "";
                    float offset = CharacterUtils.getOffset(i5, needMove, f5, lineLeft, this.f34029l, this.f34025h, this.f34026i);
                    f4 = lineLeft;
                    i4 = 255;
                    canvas.drawText(this.f34021d.charAt(i5) + str, 0, 1, offset, baseline, (Paint) this.f34023f);
                } else {
                    f4 = lineLeft;
                    str = "";
                    i4 = 255;
                    this.f34023f.setAlpha((int) ((1.0f - this.f34027j) * 255.0f));
                    this.f34023f.setTextSize(this.f34028k * (1.0f - this.f34027j));
                    canvas.drawText(this.f34021d.charAt(i5) + str, 0, 1, f8 + ((this.f34026i.get(i5).floatValue() - this.f34023f.measureText(this.f34021d.charAt(i5) + str)) / 2.0f), baseline, (Paint) this.f34023f);
                }
                f8 += this.f34026i.get(i5).floatValue();
            } else {
                f4 = lineLeft;
                str = "";
                i4 = 255;
            }
            if (i5 < this.f34020c.length()) {
                if (!CharacterUtils.stayHere(i5, this.f34034p)) {
                    float f10 = this.f34033o;
                    float f11 = this.f34027j;
                    long j4 = this.f34035q;
                    float f12 = i5;
                    float f13 = this.f34032n;
                    int i6 = (int) (((((float) j4) * f11) - ((f10 * f12) / f13)) * (255.0f / f10));
                    if (i6 <= i4) {
                        i4 = i6;
                    }
                    if (i4 < 0) {
                        i4 = 0;
                    }
                    float f14 = this.f34028k;
                    float f15 = ((1.0f * f14) / f10) * ((f11 * ((float) j4)) - ((f10 * f12) / f13));
                    if (f15 <= f14) {
                        f14 = f15;
                    }
                    if (f14 < 0.0f) {
                        f14 = 0.0f;
                    }
                    this.f34022e.setAlpha(i4);
                    this.f34022e.setTextSize(f14);
                    canvas.drawText(this.f34020c.charAt(i5) + str, 0, 1, f7 + ((this.f34025h.get(i5).floatValue() - this.f34022e.measureText(this.f34020c.charAt(i5) + str)) / 2.0f), baseline, (Paint) this.f34022e);
                }
                f7 += this.f34025h.get(i5).floatValue();
            }
            i5++;
            lineLeft = f4;
        }
    }

    @Override // com.hanks.htextview.base.HText, com.hanks.htextview.base.IHText
    public void init(HTextView hTextView, AttributeSet attributeSet, int i4) {
        super.init(hTextView, attributeSet, i4);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f34036r = valueAnimator;
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f34036r.addListener(new a());
        this.f34036r.addUpdateListener(new b());
        int length = this.f34020c.length();
        if (length <= 0) {
            length = 1;
        }
        float f4 = this.f34033o;
        this.f34035q = f4 + ((f4 / this.f34032n) * (length - 1));
    }

    @Override // com.hanks.htextview.base.HText
    protected void c() {
    }
}
