package com.varunest.sparkbutton.helpers;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class CircleView extends View {
    public static final Property<CircleView, Float> INNER_CIRCLE_RADIUS_PROGRESS = new a(Float.class, "innerCircleRadiusProgress");
    public static final Property<CircleView, Float> OUTER_CIRCLE_RADIUS_PROGRESS = new b(Float.class, "outerCircleRadiusProgress");

    /* renamed from: a  reason: collision with root package name */
    private int f38338a;

    /* renamed from: b  reason: collision with root package name */
    private int f38339b;

    /* renamed from: c  reason: collision with root package name */
    private ArgbEvaluator f38340c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f38341d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f38342e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f38343f;

    /* renamed from: g  reason: collision with root package name */
    private Canvas f38344g;

    /* renamed from: h  reason: collision with root package name */
    private float f38345h;

    /* renamed from: i  reason: collision with root package name */
    private float f38346i;

    /* renamed from: j  reason: collision with root package name */
    private int f38347j;

    /* loaded from: classes6.dex */
    static class a extends Property<CircleView, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(CircleView circleView) {
            return Float.valueOf(circleView.getInnerCircleRadiusProgress());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(CircleView circleView, Float f4) {
            circleView.setInnerCircleRadiusProgress(f4.floatValue());
        }
    }

    /* loaded from: classes6.dex */
    static class b extends Property<CircleView, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(CircleView circleView) {
            return Float.valueOf(circleView.getOuterCircleRadiusProgress());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(CircleView circleView, Float f4) {
            circleView.setOuterCircleRadiusProgress(f4.floatValue());
        }
    }

    public CircleView(Context context) {
        super(context);
        this.f38338a = -43230;
        this.f38339b = -16121;
        this.f38340c = new ArgbEvaluator();
        this.f38341d = new Paint();
        this.f38342e = new Paint();
        this.f38345h = 0.0f;
        this.f38346i = 0.0f;
        a();
    }

    private void a() {
        this.f38341d.setStyle(Paint.Style.FILL);
        this.f38342e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    private void b() {
        this.f38341d.setColor(((Integer) this.f38340c.evaluate((float) Utils.mapValueFromRangeToRange((float) Utils.clamp(this.f38345h, 0.5d, 1.0d), 0.5d, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d), Integer.valueOf(this.f38338a), Integer.valueOf(this.f38339b))).intValue());
    }

    public float getInnerCircleRadiusProgress() {
        return this.f38346i;
    }

    public float getOuterCircleRadiusProgress() {
        return this.f38345h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f38344g.drawColor(16777215, PorterDuff.Mode.CLEAR);
        this.f38344g.drawCircle(getWidth() / 2, getHeight() / 2, this.f38345h * this.f38347j, this.f38341d);
        this.f38344g.drawCircle(getWidth() / 2, getHeight() / 2, this.f38346i * this.f38347j, this.f38342e);
        canvas.drawBitmap(this.f38343f, 0.0f, 0.0f, (Paint) null);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f38347j = i4 / 2;
        this.f38343f = Bitmap.createBitmap(getWidth(), getWidth(), Bitmap.Config.ARGB_8888);
        this.f38344g = new Canvas(this.f38343f);
    }

    public void setColors(int i4, int i5) {
        this.f38338a = i4;
        this.f38339b = i5;
    }

    public void setInnerCircleRadiusProgress(float f4) {
        this.f38346i = f4;
        postInvalidate();
    }

    public void setOuterCircleRadiusProgress(float f4) {
        this.f38345h = f4;
        b();
        postInvalidate();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38338a = -43230;
        this.f38339b = -16121;
        this.f38340c = new ArgbEvaluator();
        this.f38341d = new Paint();
        this.f38342e = new Paint();
        this.f38345h = 0.0f;
        this.f38346i = 0.0f;
        a();
    }

    public CircleView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f38338a = -43230;
        this.f38339b = -16121;
        this.f38340c = new ArgbEvaluator();
        this.f38341d = new Paint();
        this.f38342e = new Paint();
        this.f38345h = 0.0f;
        this.f38346i = 0.0f;
        a();
    }

    public CircleView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f38338a = -43230;
        this.f38339b = -16121;
        this.f38340c = new ArgbEvaluator();
        this.f38341d = new Paint();
        this.f38342e = new Paint();
        this.f38345h = 0.0f;
        this.f38346i = 0.0f;
        a();
    }
}
