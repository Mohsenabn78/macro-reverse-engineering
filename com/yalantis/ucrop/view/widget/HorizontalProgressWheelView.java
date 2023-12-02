package com.yalantis.ucrop.view.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R;

/* loaded from: classes6.dex */
public class HorizontalProgressWheelView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f38579a;

    /* renamed from: b  reason: collision with root package name */
    private ScrollingListener f38580b;

    /* renamed from: c  reason: collision with root package name */
    private float f38581c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f38582d;

    /* renamed from: e  reason: collision with root package name */
    private int f38583e;

    /* renamed from: f  reason: collision with root package name */
    private int f38584f;

    /* renamed from: g  reason: collision with root package name */
    private int f38585g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f38586h;

    /* renamed from: i  reason: collision with root package name */
    private float f38587i;

    /* renamed from: j  reason: collision with root package name */
    private int f38588j;

    /* loaded from: classes6.dex */
    public interface ScrollingListener {
        void onScroll(float f4, float f5);

        void onScrollEnd();

        void onScrollStart();
    }

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f38588j = ContextCompat.getColor(getContext(), R.color.ucrop_color_progress_wheel_line);
        this.f38583e = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.f38584f = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.f38585g = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_margin_horizontal_wheel_progress_line);
        Paint paint = new Paint(1);
        this.f38582d = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f38582d.setStrokeWidth(this.f38583e);
    }

    private void b(MotionEvent motionEvent, float f4) {
        this.f38587i -= f4;
        postInvalidate();
        this.f38581c = motionEvent.getX();
        ScrollingListener scrollingListener = this.f38580b;
        if (scrollingListener != null) {
            scrollingListener.onScroll(-f4, this.f38587i);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.getClipBounds(this.f38579a);
        int width = this.f38579a.width();
        int i4 = this.f38583e;
        int i5 = this.f38585g;
        int i6 = width / (i4 + i5);
        float f4 = this.f38587i % (i5 + i4);
        this.f38582d.setColor(getResources().getColor(R.color.ucrop_color_progress_wheel_line));
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = i6 / 4;
            if (i7 < i8) {
                this.f38582d.setAlpha((int) ((i7 / i8) * 255.0f));
            } else if (i7 > (i6 * 3) / 4) {
                this.f38582d.setAlpha((int) (((i6 - i7) / i8) * 255.0f));
            } else {
                this.f38582d.setAlpha(255);
            }
            float f5 = -f4;
            Rect rect = this.f38579a;
            float f6 = rect.left + f5 + ((this.f38583e + this.f38585g) * i7);
            float centerY = rect.centerY() - (this.f38584f / 4.0f);
            Rect rect2 = this.f38579a;
            canvas.drawLine(f6, centerY, f5 + rect2.left + ((this.f38583e + this.f38585g) * i7), rect2.centerY() + (this.f38584f / 4.0f), this.f38582d);
        }
        this.f38582d.setColor(this.f38588j);
        canvas.drawLine(this.f38579a.centerX(), this.f38579a.centerY() - (this.f38584f / 2.0f), this.f38579a.centerX(), (this.f38584f / 2.0f) + this.f38579a.centerY(), this.f38582d);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float x3 = motionEvent.getX() - this.f38581c;
                    if (x3 != 0.0f) {
                        if (!this.f38586h) {
                            this.f38586h = true;
                            ScrollingListener scrollingListener = this.f38580b;
                            if (scrollingListener != null) {
                                scrollingListener.onScrollStart();
                            }
                        }
                        b(motionEvent, x3);
                    }
                }
            } else {
                ScrollingListener scrollingListener2 = this.f38580b;
                if (scrollingListener2 != null) {
                    this.f38586h = false;
                    scrollingListener2.onScrollEnd();
                }
            }
        } else {
            this.f38581c = motionEvent.getX();
        }
        return true;
    }

    public void setMiddleLineColor(@ColorInt int i4) {
        this.f38588j = i4;
        invalidate();
    }

    public void setScrollingListener(ScrollingListener scrollingListener) {
        this.f38580b = scrollingListener;
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f38579a = new Rect();
        a();
    }

    @TargetApi(21)
    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f38579a = new Rect();
    }
}
