package com.varunest.sparkbutton.helpers;

import android.animation.ArgbEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* loaded from: classes6.dex */
public class DotsView extends View {
    public static final Property<DotsView, Float> DOTS_PROGRESS = new a(Float.class, "dotsProgress");

    /* renamed from: a  reason: collision with root package name */
    private int f38348a;

    /* renamed from: b  reason: collision with root package name */
    private int f38349b;

    /* renamed from: c  reason: collision with root package name */
    private int f38350c;

    /* renamed from: d  reason: collision with root package name */
    private int f38351d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint[] f38352e;

    /* renamed from: f  reason: collision with root package name */
    private int f38353f;

    /* renamed from: g  reason: collision with root package name */
    private int f38354g;

    /* renamed from: h  reason: collision with root package name */
    private float f38355h;

    /* renamed from: i  reason: collision with root package name */
    private float f38356i;

    /* renamed from: j  reason: collision with root package name */
    private float f38357j;

    /* renamed from: k  reason: collision with root package name */
    private float f38358k;

    /* renamed from: l  reason: collision with root package name */
    private float f38359l;

    /* renamed from: m  reason: collision with root package name */
    private float f38360m;

    /* renamed from: n  reason: collision with root package name */
    private float f38361n;

    /* renamed from: o  reason: collision with root package name */
    private float f38362o;

    /* renamed from: p  reason: collision with root package name */
    private ArgbEvaluator f38363p;

    /* loaded from: classes6.dex */
    static class a extends Property<DotsView, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(DotsView dotsView) {
            return Float.valueOf(dotsView.getCurrentProgress());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(DotsView dotsView, Float f4) {
            dotsView.setCurrentProgress(f4.floatValue());
        }
    }

    public DotsView(Context context) {
        super(context);
        this.f38348a = -16121;
        this.f38349b = -26624;
        this.f38350c = -43230;
        this.f38351d = -769226;
        this.f38352e = new Paint[4];
        this.f38358k = 0.0f;
        this.f38359l = 0.0f;
        this.f38360m = 0.0f;
        this.f38361n = 0.0f;
        this.f38362o = 0.0f;
        this.f38363p = new ArgbEvaluator();
        c();
    }

    private void a(Canvas canvas) {
        int i4 = 0;
        while (i4 < 10) {
            double d4 = (((i4 * 36) - 10) * 3.141592653589793d) / 180.0d;
            int cos = (int) (this.f38353f + (this.f38362o * Math.cos(d4)));
            float f4 = this.f38361n;
            Paint[] paintArr = this.f38352e;
            i4++;
            canvas.drawCircle(cos, (int) (this.f38354g + (this.f38362o * Math.sin(d4))), f4, paintArr[i4 % paintArr.length]);
        }
    }

    private void b(Canvas canvas) {
        for (int i4 = 0; i4 < 10; i4++) {
            double d4 = ((i4 * 36) * 3.141592653589793d) / 180.0d;
            float f4 = this.f38360m;
            Paint[] paintArr = this.f38352e;
            canvas.drawCircle((int) (this.f38353f + (this.f38359l * Math.cos(d4))), (int) (this.f38354g + (this.f38359l * Math.sin(d4))), f4, paintArr[i4 % paintArr.length]);
        }
    }

    private void c() {
        this.f38357j = Utils.dpToPx(getContext(), 4);
        int i4 = 0;
        while (true) {
            Paint[] paintArr = this.f38352e;
            if (i4 < paintArr.length) {
                paintArr[i4] = new Paint();
                this.f38352e[i4].setStyle(Paint.Style.FILL);
                i4++;
            } else {
                return;
            }
        }
    }

    private void d() {
        int mapValueFromRangeToRange = (int) Utils.mapValueFromRangeToRange((float) Utils.clamp(this.f38358k, 0.6000000238418579d, 1.0d), 0.6000000238418579d, 1.0d, 255.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.f38352e[0].setAlpha(mapValueFromRangeToRange);
        this.f38352e[1].setAlpha(mapValueFromRangeToRange);
        this.f38352e[2].setAlpha(mapValueFromRangeToRange);
        this.f38352e[3].setAlpha(mapValueFromRangeToRange);
    }

    private void e() {
        float f4 = this.f38358k;
        if (f4 < 0.5f) {
            float mapValueFromRangeToRange = (float) Utils.mapValueFromRangeToRange(f4, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0.5d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d);
            this.f38352e[0].setColor(((Integer) this.f38363p.evaluate(mapValueFromRangeToRange, Integer.valueOf(this.f38348a), Integer.valueOf(this.f38349b))).intValue());
            this.f38352e[1].setColor(((Integer) this.f38363p.evaluate(mapValueFromRangeToRange, Integer.valueOf(this.f38349b), Integer.valueOf(this.f38350c))).intValue());
            this.f38352e[2].setColor(((Integer) this.f38363p.evaluate(mapValueFromRangeToRange, Integer.valueOf(this.f38350c), Integer.valueOf(this.f38351d))).intValue());
            this.f38352e[3].setColor(((Integer) this.f38363p.evaluate(mapValueFromRangeToRange, Integer.valueOf(this.f38351d), Integer.valueOf(this.f38348a))).intValue());
            return;
        }
        float mapValueFromRangeToRange2 = (float) Utils.mapValueFromRangeToRange(f4, 0.5d, 1.0d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 1.0d);
        this.f38352e[0].setColor(((Integer) this.f38363p.evaluate(mapValueFromRangeToRange2, Integer.valueOf(this.f38349b), Integer.valueOf(this.f38350c))).intValue());
        this.f38352e[1].setColor(((Integer) this.f38363p.evaluate(mapValueFromRangeToRange2, Integer.valueOf(this.f38350c), Integer.valueOf(this.f38351d))).intValue());
        this.f38352e[2].setColor(((Integer) this.f38363p.evaluate(mapValueFromRangeToRange2, Integer.valueOf(this.f38351d), Integer.valueOf(this.f38348a))).intValue());
        this.f38352e[3].setColor(((Integer) this.f38363p.evaluate(mapValueFromRangeToRange2, Integer.valueOf(this.f38348a), Integer.valueOf(this.f38349b))).intValue());
    }

    private void f() {
        float f4 = this.f38358k;
        if (f4 < 0.3f) {
            this.f38362o = (float) Utils.mapValueFromRangeToRange(f4, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0.30000001192092896d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, this.f38356i);
        } else {
            this.f38362o = this.f38356i;
        }
        float f5 = this.f38358k;
        if (f5 < 0.2d) {
            this.f38361n = this.f38357j;
        } else if (f5 < 0.5d) {
            double d4 = f5;
            float f6 = this.f38357j;
            this.f38361n = (float) Utils.mapValueFromRangeToRange(d4, 0.20000000298023224d, 0.5d, f6, f6 * 0.3d);
        } else {
            this.f38361n = (float) Utils.mapValueFromRangeToRange(f5, 0.5d, 1.0d, this.f38357j * 0.3f, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
    }

    private void g() {
        float f4 = this.f38358k;
        if (f4 < 0.3f) {
            this.f38359l = (float) Utils.mapValueFromRangeToRange(f4, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0.30000001192092896d, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, this.f38355h * 0.8f);
        } else {
            float f5 = this.f38355h;
            this.f38359l = (float) Utils.mapValueFromRangeToRange(f4, 0.30000001192092896d, 1.0d, 0.8f * f5, f5);
        }
        float f6 = this.f38358k;
        if (f6 < 0.7d) {
            this.f38360m = this.f38357j;
        } else {
            this.f38360m = (float) Utils.mapValueFromRangeToRange(f6, 0.699999988079071d, 1.0d, this.f38357j, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
    }

    public float getCurrentProgress() {
        return this.f38358k;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        int i8 = i4 / 2;
        this.f38353f = i8;
        this.f38354g = i5 / 2;
        float f4 = i8 - (this.f38357j * 2.0f);
        this.f38355h = f4;
        this.f38356i = f4 * 0.8f;
    }

    public void setColors(int i4, int i5) {
        this.f38348a = i4;
        this.f38349b = Utils.darkenColor(i4, 1.1f);
        this.f38351d = i5;
        this.f38350c = Utils.darkenColor(i5, 1.1f);
    }

    public void setCurrentProgress(float f4) {
        this.f38358k = f4;
        f();
        g();
        e();
        d();
        postInvalidate();
    }

    public void setMaxDotSize(int i4) {
        this.f38357j = i4;
    }

    public DotsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38348a = -16121;
        this.f38349b = -26624;
        this.f38350c = -43230;
        this.f38351d = -769226;
        this.f38352e = new Paint[4];
        this.f38358k = 0.0f;
        this.f38359l = 0.0f;
        this.f38360m = 0.0f;
        this.f38361n = 0.0f;
        this.f38362o = 0.0f;
        this.f38363p = new ArgbEvaluator();
        c();
    }

    public DotsView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f38348a = -16121;
        this.f38349b = -26624;
        this.f38350c = -43230;
        this.f38351d = -769226;
        this.f38352e = new Paint[4];
        this.f38358k = 0.0f;
        this.f38359l = 0.0f;
        this.f38360m = 0.0f;
        this.f38361n = 0.0f;
        this.f38362o = 0.0f;
        this.f38363p = new ArgbEvaluator();
        c();
    }

    @TargetApi(21)
    public DotsView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f38348a = -16121;
        this.f38349b = -26624;
        this.f38350c = -43230;
        this.f38351d = -769226;
        this.f38352e = new Paint[4];
        this.f38358k = 0.0f;
        this.f38359l = 0.0f;
        this.f38360m = 0.0f;
        this.f38361n = 0.0f;
        this.f38362o = 0.0f;
        this.f38363p = new ArgbEvaluator();
        c();
    }
}
