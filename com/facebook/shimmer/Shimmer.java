package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class Shimmer {

    /* renamed from: a  reason: collision with root package name */
    final float[] f17605a = new float[4];

    /* renamed from: b  reason: collision with root package name */
    final int[] f17606b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    final RectF f17607c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    int f17608d = 0;
    @ColorInt

    /* renamed from: e  reason: collision with root package name */
    int f17609e = -1;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    int f17610f = 1291845631;

    /* renamed from: g  reason: collision with root package name */
    int f17611g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f17612h = 0;

    /* renamed from: i  reason: collision with root package name */
    int f17613i = 0;

    /* renamed from: j  reason: collision with root package name */
    float f17614j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    float f17615k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    float f17616l = 0.0f;

    /* renamed from: m  reason: collision with root package name */
    float f17617m = 0.5f;

    /* renamed from: n  reason: collision with root package name */
    float f17618n = 20.0f;

    /* renamed from: o  reason: collision with root package name */
    boolean f17619o = true;

    /* renamed from: p  reason: collision with root package name */
    boolean f17620p = true;

    /* renamed from: q  reason: collision with root package name */
    boolean f17621q = true;

    /* renamed from: r  reason: collision with root package name */
    int f17622r = -1;

    /* renamed from: s  reason: collision with root package name */
    int f17623s = 1;

    /* renamed from: t  reason: collision with root package name */
    long f17624t = 1000;

    /* renamed from: u  reason: collision with root package name */
    long f17625u;

    /* loaded from: classes3.dex */
    public static abstract class Builder<T extends Builder<T>> {

        /* renamed from: a  reason: collision with root package name */
        final Shimmer f17626a = new Shimmer();

        private static float a(float f4, float f5, float f6) {
            return Math.min(f5, Math.max(f4, f6));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public T b(TypedArray typedArray) {
            int i4 = R.styleable.ShimmerFrameLayout_shimmer_clip_to_children;
            if (typedArray.hasValue(i4)) {
                setClipToChildren(typedArray.getBoolean(i4, this.f17626a.f17619o));
            }
            int i5 = R.styleable.ShimmerFrameLayout_shimmer_auto_start;
            if (typedArray.hasValue(i5)) {
                setAutoStart(typedArray.getBoolean(i5, this.f17626a.f17620p));
            }
            int i6 = R.styleable.ShimmerFrameLayout_shimmer_base_alpha;
            if (typedArray.hasValue(i6)) {
                setBaseAlpha(typedArray.getFloat(i6, 0.3f));
            }
            int i7 = R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha;
            if (typedArray.hasValue(i7)) {
                setHighlightAlpha(typedArray.getFloat(i7, 1.0f));
            }
            int i8 = R.styleable.ShimmerFrameLayout_shimmer_duration;
            if (typedArray.hasValue(i8)) {
                setDuration(typedArray.getInt(i8, (int) this.f17626a.f17624t));
            }
            int i9 = R.styleable.ShimmerFrameLayout_shimmer_repeat_count;
            if (typedArray.hasValue(i9)) {
                setRepeatCount(typedArray.getInt(i9, this.f17626a.f17622r));
            }
            int i10 = R.styleable.ShimmerFrameLayout_shimmer_repeat_delay;
            if (typedArray.hasValue(i10)) {
                setRepeatDelay(typedArray.getInt(i10, (int) this.f17626a.f17625u));
            }
            int i11 = R.styleable.ShimmerFrameLayout_shimmer_repeat_mode;
            if (typedArray.hasValue(i11)) {
                setRepeatMode(typedArray.getInt(i11, this.f17626a.f17623s));
            }
            int i12 = R.styleable.ShimmerFrameLayout_shimmer_direction;
            if (typedArray.hasValue(i12)) {
                int i13 = typedArray.getInt(i12, this.f17626a.f17608d);
                if (i13 != 1) {
                    if (i13 != 2) {
                        if (i13 != 3) {
                            setDirection(0);
                        } else {
                            setDirection(3);
                        }
                    } else {
                        setDirection(2);
                    }
                } else {
                    setDirection(1);
                }
            }
            int i14 = R.styleable.ShimmerFrameLayout_shimmer_shape;
            if (typedArray.hasValue(i14)) {
                if (typedArray.getInt(i14, this.f17626a.f17611g) != 1) {
                    setShape(0);
                } else {
                    setShape(1);
                }
            }
            int i15 = R.styleable.ShimmerFrameLayout_shimmer_dropoff;
            if (typedArray.hasValue(i15)) {
                setDropoff(typedArray.getFloat(i15, this.f17626a.f17617m));
            }
            int i16 = R.styleable.ShimmerFrameLayout_shimmer_fixed_width;
            if (typedArray.hasValue(i16)) {
                setFixedWidth(typedArray.getDimensionPixelSize(i16, this.f17626a.f17612h));
            }
            int i17 = R.styleable.ShimmerFrameLayout_shimmer_fixed_height;
            if (typedArray.hasValue(i17)) {
                setFixedHeight(typedArray.getDimensionPixelSize(i17, this.f17626a.f17613i));
            }
            int i18 = R.styleable.ShimmerFrameLayout_shimmer_intensity;
            if (typedArray.hasValue(i18)) {
                setIntensity(typedArray.getFloat(i18, this.f17626a.f17616l));
            }
            int i19 = R.styleable.ShimmerFrameLayout_shimmer_width_ratio;
            if (typedArray.hasValue(i19)) {
                setWidthRatio(typedArray.getFloat(i19, this.f17626a.f17614j));
            }
            int i20 = R.styleable.ShimmerFrameLayout_shimmer_height_ratio;
            if (typedArray.hasValue(i20)) {
                setHeightRatio(typedArray.getFloat(i20, this.f17626a.f17615k));
            }
            int i21 = R.styleable.ShimmerFrameLayout_shimmer_tilt;
            if (typedArray.hasValue(i21)) {
                setTilt(typedArray.getFloat(i21, this.f17626a.f17618n));
            }
            return c();
        }

        public Shimmer build() {
            this.f17626a.b();
            this.f17626a.c();
            return this.f17626a;
        }

        protected abstract T c();

        public T consumeAttributes(Context context, AttributeSet attributeSet) {
            return b(context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0));
        }

        public T copyFrom(Shimmer shimmer) {
            setDirection(shimmer.f17608d);
            setShape(shimmer.f17611g);
            setFixedWidth(shimmer.f17612h);
            setFixedHeight(shimmer.f17613i);
            setWidthRatio(shimmer.f17614j);
            setHeightRatio(shimmer.f17615k);
            setIntensity(shimmer.f17616l);
            setDropoff(shimmer.f17617m);
            setTilt(shimmer.f17618n);
            setClipToChildren(shimmer.f17619o);
            setAutoStart(shimmer.f17620p);
            setRepeatCount(shimmer.f17622r);
            setRepeatMode(shimmer.f17623s);
            setRepeatDelay(shimmer.f17625u);
            setDuration(shimmer.f17624t);
            Shimmer shimmer2 = this.f17626a;
            shimmer2.f17610f = shimmer.f17610f;
            shimmer2.f17609e = shimmer.f17609e;
            return c();
        }

        public T setAutoStart(boolean z3) {
            this.f17626a.f17620p = z3;
            return c();
        }

        public T setBaseAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
            Shimmer shimmer = this.f17626a;
            shimmer.f17610f = (((int) (a(0.0f, 1.0f, f4) * 255.0f)) << 24) | (shimmer.f17610f & 16777215);
            return c();
        }

        public T setClipToChildren(boolean z3) {
            this.f17626a.f17619o = z3;
            return c();
        }

        public T setDirection(int i4) {
            this.f17626a.f17608d = i4;
            return c();
        }

        public T setDropoff(float f4) {
            if (f4 >= 0.0f) {
                this.f17626a.f17617m = f4;
                return c();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f4);
        }

        public T setDuration(long j4) {
            if (j4 >= 0) {
                this.f17626a.f17624t = j4;
                return c();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j4);
        }

        public T setFixedHeight(@Px int i4) {
            if (i4 >= 0) {
                this.f17626a.f17613i = i4;
                return c();
            }
            throw new IllegalArgumentException("Given invalid height: " + i4);
        }

        public T setFixedWidth(@Px int i4) {
            if (i4 >= 0) {
                this.f17626a.f17612h = i4;
                return c();
            }
            throw new IllegalArgumentException("Given invalid width: " + i4);
        }

        public T setHeightRatio(float f4) {
            if (f4 >= 0.0f) {
                this.f17626a.f17615k = f4;
                return c();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f4);
        }

        public T setHighlightAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
            Shimmer shimmer = this.f17626a;
            shimmer.f17609e = (((int) (a(0.0f, 1.0f, f4) * 255.0f)) << 24) | (shimmer.f17609e & 16777215);
            return c();
        }

        public T setIntensity(float f4) {
            if (f4 >= 0.0f) {
                this.f17626a.f17616l = f4;
                return c();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f4);
        }

        public T setRepeatCount(int i4) {
            this.f17626a.f17622r = i4;
            return c();
        }

        public T setRepeatDelay(long j4) {
            if (j4 >= 0) {
                this.f17626a.f17625u = j4;
                return c();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j4);
        }

        public T setRepeatMode(int i4) {
            this.f17626a.f17623s = i4;
            return c();
        }

        public T setShape(int i4) {
            this.f17626a.f17611g = i4;
            return c();
        }

        public T setTilt(float f4) {
            this.f17626a.f17618n = f4;
            return c();
        }

        public T setWidthRatio(float f4) {
            if (f4 >= 0.0f) {
                this.f17626a.f17614j = f4;
                return c();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f4);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    Shimmer() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i4) {
        int i5 = this.f17613i;
        if (i5 <= 0) {
            return Math.round(this.f17615k * i4);
        }
        return i5;
    }

    void b() {
        if (this.f17611g != 1) {
            int[] iArr = this.f17606b;
            int i4 = this.f17610f;
            iArr[0] = i4;
            int i5 = this.f17609e;
            iArr[1] = i5;
            iArr[2] = i5;
            iArr[3] = i4;
            return;
        }
        int[] iArr2 = this.f17606b;
        int i6 = this.f17609e;
        iArr2[0] = i6;
        iArr2[1] = i6;
        int i7 = this.f17610f;
        iArr2[2] = i7;
        iArr2[3] = i7;
    }

    void c() {
        if (this.f17611g != 1) {
            this.f17605a[0] = Math.max(((1.0f - this.f17616l) - this.f17617m) / 2.0f, 0.0f);
            this.f17605a[1] = Math.max(((1.0f - this.f17616l) - 0.001f) / 2.0f, 0.0f);
            this.f17605a[2] = Math.min(((this.f17616l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.f17605a[3] = Math.min(((this.f17616l + 1.0f) + this.f17617m) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.f17605a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.f17616l, 1.0f);
        this.f17605a[2] = Math.min(this.f17616l + this.f17617m, 1.0f);
        this.f17605a[3] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i4) {
        int i5 = this.f17612h;
        if (i5 <= 0) {
            return Math.round(this.f17614j * i4);
        }
        return i5;
    }

    /* loaded from: classes3.dex */
    public static class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        public AlphaHighlightBuilder() {
            this.f17626a.f17621q = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.shimmer.Shimmer.Builder
        /* renamed from: d */
        public AlphaHighlightBuilder c() {
            return this;
        }
    }

    /* loaded from: classes3.dex */
    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        public ColorHighlightBuilder() {
            this.f17626a.f17621q = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.facebook.shimmer.Shimmer.Builder
        /* renamed from: d */
        public ColorHighlightBuilder b(TypedArray typedArray) {
            super.b(typedArray);
            int i4 = R.styleable.ShimmerFrameLayout_shimmer_base_color;
            if (typedArray.hasValue(i4)) {
                setBaseColor(typedArray.getColor(i4, this.f17626a.f17610f));
            }
            int i5 = R.styleable.ShimmerFrameLayout_shimmer_highlight_color;
            if (typedArray.hasValue(i5)) {
                setHighlightColor(typedArray.getColor(i5, this.f17626a.f17609e));
            }
            return c();
        }

        public ColorHighlightBuilder setBaseColor(@ColorInt int i4) {
            Shimmer shimmer = this.f17626a;
            shimmer.f17610f = (i4 & 16777215) | (shimmer.f17610f & (-16777216));
            return c();
        }

        public ColorHighlightBuilder setHighlightColor(@ColorInt int i4) {
            this.f17626a.f17609e = i4;
            return c();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.facebook.shimmer.Shimmer.Builder
        /* renamed from: e */
        public ColorHighlightBuilder c() {
            return this;
        }
    }
}
