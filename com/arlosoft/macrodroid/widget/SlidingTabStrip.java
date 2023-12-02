package com.arlosoft.macrodroid.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.arlosoft.macrodroid.widget.SlidingTabLayout;

/* loaded from: classes3.dex */
public class SlidingTabStrip extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final int f16480a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f16481b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16482c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f16483d;

    /* renamed from: e  reason: collision with root package name */
    private final int f16484e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f16485f;

    /* renamed from: g  reason: collision with root package name */
    private final float f16486g;

    /* renamed from: h  reason: collision with root package name */
    private int f16487h;

    /* renamed from: i  reason: collision with root package name */
    private float f16488i;

    /* renamed from: j  reason: collision with root package name */
    private SlidingTabLayout.TabColorizer f16489j;

    /* renamed from: k  reason: collision with root package name */
    private final b f16490k;

    /* loaded from: classes3.dex */
    private static class b implements SlidingTabLayout.TabColorizer {

        /* renamed from: a  reason: collision with root package name */
        private int[] f16491a;

        /* renamed from: b  reason: collision with root package name */
        private int[] f16492b;

        private b() {
        }

        void a(int... iArr) {
            this.f16492b = iArr;
        }

        void b(int... iArr) {
            this.f16491a = iArr;
        }

        @Override // com.arlosoft.macrodroid.widget.SlidingTabLayout.TabColorizer
        public final int getDividerColor(int i4) {
            int[] iArr = this.f16492b;
            return iArr[i4 % iArr.length];
        }

        @Override // com.arlosoft.macrodroid.widget.SlidingTabLayout.TabColorizer
        public final int getIndicatorColor(int i4) {
            int[] iArr = this.f16491a;
            return iArr[i4 % iArr.length];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SlidingTabStrip(Context context) {
        this(context, null);
    }

    private static int a(int i4, int i5, float f4) {
        float f5 = 1.0f - f4;
        return Color.rgb((int) ((Color.red(i4) * f4) + (Color.red(i5) * f5)), (int) ((Color.green(i4) * f4) + (Color.green(i5) * f5)), (int) ((Color.blue(i4) * f4) + (Color.blue(i5) * f5)));
    }

    private static int c(int i4, byte b4) {
        return Color.argb((int) b4, Color.red(i4), Color.green(i4), Color.blue(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i4, float f4) {
        this.f16487h = i4;
        this.f16488i = f4;
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        int height = getHeight();
        int childCount = getChildCount();
        float f4 = height;
        int min = (int) (Math.min(Math.max(0.0f, this.f16486g), 1.0f) * f4);
        SlidingTabLayout.TabColorizer tabColorizer = this.f16489j;
        if (tabColorizer == null) {
            tabColorizer = this.f16490k;
        }
        SlidingTabLayout.TabColorizer tabColorizer2 = tabColorizer;
        if (childCount > 0) {
            View childAt = getChildAt(this.f16487h);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int indicatorColor = tabColorizer2.getIndicatorColor(this.f16487h);
            if (this.f16488i > 0.0f && this.f16487h < getChildCount() - 1) {
                int indicatorColor2 = tabColorizer2.getIndicatorColor(this.f16487h + 1);
                if (indicatorColor != indicatorColor2) {
                    indicatorColor = a(indicatorColor2, indicatorColor, this.f16488i);
                }
                View childAt2 = getChildAt(this.f16487h + 1);
                float left2 = this.f16488i * childAt2.getLeft();
                float f5 = this.f16488i;
                left = (int) (left2 + ((1.0f - f5) * left));
                right = (int) ((f5 * childAt2.getRight()) + ((1.0f - this.f16488i) * right));
            }
            this.f16483d.setColor(indicatorColor);
            canvas.drawRect(left, height - this.f16482c, right, f4, this.f16483d);
        }
        canvas.drawRect(0.0f, height - this.f16480a, getWidth(), f4, this.f16481b);
        canvas.drawRect(0.0f, 0.0f, getWidth(), this.f16480a, this.f16481b);
        int i4 = (height - min) / 2;
        for (int i5 = 0; i5 < childCount - 1; i5++) {
            View childAt3 = getChildAt(i5);
            this.f16485f.setColor(tabColorizer2.getDividerColor(i5));
            canvas.drawLine(childAt3.getRight(), i4, childAt3.getRight(), i4 + min, this.f16485f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomTabColorizer(SlidingTabLayout.TabColorizer tabColorizer) {
        this.f16489j = tabColorizer;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDividerColors(int... iArr) {
        this.f16489j = null;
        this.f16490k.a(iArr);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSelectedIndicatorColors(int... iArr) {
        this.f16489j = null;
        this.f16490k.b(iArr);
        invalidate();
    }

    private SlidingTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
        float f4 = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i4 = typedValue.data;
        int c4 = c(i4, (byte) 38);
        this.f16484e = c4;
        b bVar = new b();
        this.f16490k = bVar;
        bVar.b(-13388315);
        bVar.a(c(i4, (byte) 32));
        this.f16480a = (int) (2.0f * f4);
        Paint paint = new Paint();
        this.f16481b = paint;
        paint.setColor(c4);
        this.f16482c = (int) (8.0f * f4);
        this.f16483d = new Paint();
        this.f16486g = 0.5f;
        Paint paint2 = new Paint();
        this.f16485f = paint2;
        paint2.setStrokeWidth((int) (f4 * 1.0f));
    }
}
