package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class CollapsingTextHelper {

    /* renamed from: l0  reason: collision with root package name */
    private static final boolean f23771l0 = false;
    @NonNull

    /* renamed from: m0  reason: collision with root package name */
    private static final Paint f23772m0 = null;
    private CancelableFontCallback A;
    private CancelableFontCallback B;
    @Nullable
    private CharSequence C;
    @Nullable
    private CharSequence D;
    private boolean E;
    private boolean G;
    @Nullable
    private Bitmap H;
    private Paint I;
    private float J;
    private float K;
    private int[] L;
    private boolean M;
    @NonNull
    private final TextPaint N;
    @NonNull
    private final TextPaint O;
    private TimeInterpolator P;
    private TimeInterpolator Q;
    private float R;
    private float S;
    private float T;
    private ColorStateList U;
    private float V;
    private float W;
    private float X;
    private ColorStateList Y;
    private float Z;

    /* renamed from: a  reason: collision with root package name */
    private final View f23773a;

    /* renamed from: a0  reason: collision with root package name */
    private float f23774a0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f23775b;

    /* renamed from: b0  reason: collision with root package name */
    private StaticLayout f23776b0;

    /* renamed from: c  reason: collision with root package name */
    private float f23777c;

    /* renamed from: c0  reason: collision with root package name */
    private float f23778c0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23779d;

    /* renamed from: d0  reason: collision with root package name */
    private float f23780d0;

    /* renamed from: e  reason: collision with root package name */
    private float f23781e;

    /* renamed from: e0  reason: collision with root package name */
    private float f23782e0;

    /* renamed from: f  reason: collision with root package name */
    private float f23783f;

    /* renamed from: f0  reason: collision with root package name */
    private float f23784f0;

    /* renamed from: g  reason: collision with root package name */
    private int f23785g;

    /* renamed from: g0  reason: collision with root package name */
    private CharSequence f23786g0;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final Rect f23787h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final Rect f23789i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final RectF f23791j;

    /* renamed from: o  reason: collision with root package name */
    private ColorStateList f23798o;

    /* renamed from: p  reason: collision with root package name */
    private ColorStateList f23799p;

    /* renamed from: q  reason: collision with root package name */
    private int f23800q;

    /* renamed from: r  reason: collision with root package name */
    private float f23801r;

    /* renamed from: s  reason: collision with root package name */
    private float f23802s;

    /* renamed from: t  reason: collision with root package name */
    private float f23803t;

    /* renamed from: u  reason: collision with root package name */
    private float f23804u;

    /* renamed from: v  reason: collision with root package name */
    private float f23805v;

    /* renamed from: w  reason: collision with root package name */
    private float f23806w;

    /* renamed from: x  reason: collision with root package name */
    private Typeface f23807x;

    /* renamed from: y  reason: collision with root package name */
    private Typeface f23808y;

    /* renamed from: z  reason: collision with root package name */
    private Typeface f23809z;

    /* renamed from: k  reason: collision with root package name */
    private int f23793k = 16;

    /* renamed from: l  reason: collision with root package name */
    private int f23795l = 16;

    /* renamed from: m  reason: collision with root package name */
    private float f23796m = 15.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f23797n = 15.0f;
    private boolean F = true;

    /* renamed from: h0  reason: collision with root package name */
    private int f23788h0 = 1;

    /* renamed from: i0  reason: collision with root package name */
    private float f23790i0 = 0.0f;

    /* renamed from: j0  reason: collision with root package name */
    private float f23792j0 = 1.0f;

    /* renamed from: k0  reason: collision with root package name */
    private int f23794k0 = StaticLayoutBuilderCompat.f23885n;

    public CollapsingTextHelper(View view) {
        this.f23773a = view;
        TextPaint textPaint = new TextPaint(129);
        this.N = textPaint;
        this.O = new TextPaint(textPaint);
        this.f23789i = new Rect();
        this.f23787h = new Rect();
        this.f23791j = new RectF();
        this.f23783f = e();
    }

    private void A(float f4) {
        this.f23780d0 = f4;
        ViewCompat.postInvalidateOnAnimation(this.f23773a);
    }

    private boolean B(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.B;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.f23807x != typeface) {
            this.f23807x = typeface;
            return true;
        }
        return false;
    }

    private void C(float f4) {
        this.f23782e0 = f4;
        ViewCompat.postInvalidateOnAnimation(this.f23773a);
    }

    private boolean D(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.A;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.f23808y != typeface) {
            this.f23808y = typeface;
            return true;
        }
        return false;
    }

    private void E(float f4) {
        boolean z3;
        h(f4);
        if (f23771l0 && this.J != 1.0f) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.G = z3;
        if (z3) {
            m();
        }
        ViewCompat.postInvalidateOnAnimation(this.f23773a);
    }

    private boolean F() {
        if (this.f23788h0 > 1 && ((!this.E || this.f23779d) && !this.G)) {
            return true;
        }
        return false;
    }

    private static int a(int i4, int i5, float f4) {
        float f5 = 1.0f - f4;
        return Color.argb((int) ((Color.alpha(i4) * f5) + (Color.alpha(i5) * f4)), (int) ((Color.red(i4) * f5) + (Color.red(i5) * f4)), (int) ((Color.green(i4) * f5) + (Color.green(i5) * f4)), (int) ((Color.blue(i4) * f5) + (Color.blue(i5) * f4)));
    }

    private void b(boolean z3) {
        float f4;
        int i4;
        float f5;
        StaticLayout staticLayout;
        float f6 = this.K;
        i(this.f23797n, z3);
        CharSequence charSequence = this.D;
        if (charSequence != null && (staticLayout = this.f23776b0) != null) {
            this.f23786g0 = TextUtils.ellipsize(charSequence, this.N, staticLayout.getWidth(), TextUtils.TruncateAt.END);
        }
        float f7 = 0.0f;
        if (this.f23786g0 != null) {
            TextPaint textPaint = new TextPaint(this.N);
            textPaint.setLetterSpacing(this.Z);
            CharSequence charSequence2 = this.f23786g0;
            this.f23778c0 = textPaint.measureText(charSequence2, 0, charSequence2.length());
        } else {
            this.f23778c0 = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f23795l, this.E ? 1 : 0);
        int i5 = absoluteGravity & 112;
        if (i5 != 48) {
            if (i5 != 80) {
                this.f23802s = this.f23789i.centerY() - ((this.N.descent() - this.N.ascent()) / 2.0f);
            } else {
                this.f23802s = this.f23789i.bottom + this.N.ascent();
            }
        } else {
            this.f23802s = this.f23789i.top;
        }
        int i6 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i6 != 1) {
            if (i6 != 5) {
                this.f23804u = this.f23789i.left;
            } else {
                this.f23804u = this.f23789i.right - this.f23778c0;
            }
        } else {
            this.f23804u = this.f23789i.centerX() - (this.f23778c0 / 2.0f);
        }
        i(this.f23796m, z3);
        StaticLayout staticLayout2 = this.f23776b0;
        if (staticLayout2 != null) {
            f4 = staticLayout2.getHeight();
        } else {
            f4 = 0.0f;
        }
        StaticLayout staticLayout3 = this.f23776b0;
        if (staticLayout3 != null) {
            i4 = staticLayout3.getLineCount();
        } else {
            i4 = 0;
        }
        this.f23800q = i4;
        CharSequence charSequence3 = this.D;
        if (charSequence3 != null) {
            f5 = this.N.measureText(charSequence3, 0, charSequence3.length());
        } else {
            f5 = 0.0f;
        }
        StaticLayout staticLayout4 = this.f23776b0;
        if (staticLayout4 != null && this.f23788h0 > 1) {
            f5 = staticLayout4.getWidth();
        }
        StaticLayout staticLayout5 = this.f23776b0;
        if (staticLayout5 != null) {
            if (this.f23788h0 > 1) {
                f7 = staticLayout5.getLineStart(0);
            } else {
                f7 = staticLayout5.getLineLeft(0);
            }
        }
        this.f23784f0 = f7;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f23793k, this.E ? 1 : 0);
        int i7 = absoluteGravity2 & 112;
        if (i7 != 48) {
            if (i7 != 80) {
                this.f23801r = this.f23787h.centerY() - (f4 / 2.0f);
            } else {
                this.f23801r = (this.f23787h.bottom - f4) + this.N.descent();
            }
        } else {
            this.f23801r = this.f23787h.top;
        }
        int i8 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i8 != 1) {
            if (i8 != 5) {
                this.f23803t = this.f23787h.left;
            } else {
                this.f23803t = this.f23787h.right - f5;
            }
        } else {
            this.f23803t = this.f23787h.centerX() - (f5 / 2.0f);
        }
        j();
        E(f6);
    }

    private void c() {
        g(this.f23777c);
    }

    private float d(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        float f5 = this.f23783f;
        if (f4 <= f5) {
            return AnimationUtils.lerp(1.0f, 0.0f, this.f23781e, f5, f4);
        }
        return AnimationUtils.lerp(0.0f, 1.0f, f5, 1.0f, f4);
    }

    private float e() {
        float f4 = this.f23781e;
        return f4 + ((1.0f - f4) * 0.5f);
    }

    private boolean f(@NonNull CharSequence charSequence) {
        boolean v3 = v();
        if (this.F) {
            return w(charSequence, v3);
        }
        return v3;
    }

    private void g(float f4) {
        float f5;
        t(f4);
        if (this.f23779d) {
            if (f4 < this.f23783f) {
                this.f23805v = this.f23803t;
                this.f23806w = this.f23801r;
                E(this.f23796m);
                f5 = 0.0f;
            } else {
                this.f23805v = this.f23804u;
                this.f23806w = this.f23802s - Math.max(0, this.f23785g);
                E(this.f23797n);
                f5 = 1.0f;
            }
        } else {
            this.f23805v = x(this.f23803t, this.f23804u, f4, this.P);
            this.f23806w = x(this.f23801r, this.f23802s, f4, this.P);
            E(x(this.f23796m, this.f23797n, f4, this.Q));
            f5 = f4;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        A(1.0f - x(0.0f, 1.0f, 1.0f - f4, timeInterpolator));
        C(x(1.0f, 0.0f, f4, timeInterpolator));
        if (this.f23799p != this.f23798o) {
            this.N.setColor(a(q(), getCurrentCollapsedTextColor(), f5));
        } else {
            this.N.setColor(getCurrentCollapsedTextColor());
        }
        float f6 = this.Z;
        float f7 = this.f23774a0;
        if (f6 != f7) {
            this.N.setLetterSpacing(x(f7, f6, f4, timeInterpolator));
        } else {
            this.N.setLetterSpacing(f6);
        }
        this.N.setShadowLayer(x(this.V, this.R, f4, null), x(this.W, this.S, f4, null), x(this.X, this.T, f4, null), a(p(this.Y), p(this.U), f4));
        if (this.f23779d) {
            int alpha = this.N.getAlpha();
            this.N.setAlpha((int) (d(f4) * alpha));
        }
        ViewCompat.postInvalidateOnAnimation(this.f23773a);
    }

    private void h(float f4) {
        i(f4, false);
    }

    private void i(float f4, boolean z3) {
        boolean z4;
        float f5;
        boolean z5;
        if (this.C == null) {
            return;
        }
        float width = this.f23789i.width();
        float width2 = this.f23787h.width();
        boolean z6 = false;
        int i4 = 1;
        if (u(f4, this.f23797n)) {
            f5 = this.f23797n;
            this.J = 1.0f;
            Typeface typeface = this.f23809z;
            Typeface typeface2 = this.f23807x;
            if (typeface != typeface2) {
                this.f23809z = typeface2;
                z5 = true;
            } else {
                z5 = false;
            }
        } else {
            float f6 = this.f23796m;
            Typeface typeface3 = this.f23809z;
            Typeface typeface4 = this.f23808y;
            if (typeface3 != typeface4) {
                this.f23809z = typeface4;
                z4 = true;
            } else {
                z4 = false;
            }
            if (u(f4, f6)) {
                this.J = 1.0f;
            } else {
                this.J = f4 / this.f23796m;
            }
            float f7 = this.f23797n / this.f23796m;
            float f8 = width2 * f7;
            if (z3 || f8 <= width) {
                width = width2;
            } else {
                width = Math.min(width / f7, width2);
            }
            f5 = f6;
            z5 = z4;
        }
        if (width > 0.0f) {
            if (this.K == f5 && !this.M && !z5) {
                z5 = false;
            } else {
                z5 = true;
            }
            this.K = f5;
            this.M = false;
        }
        if (this.D == null || z5) {
            this.N.setTextSize(this.K);
            this.N.setTypeface(this.f23809z);
            TextPaint textPaint = this.N;
            if (this.J != 1.0f) {
                z6 = true;
            }
            textPaint.setLinearText(z6);
            this.E = f(this.C);
            if (F()) {
                i4 = this.f23788h0;
            }
            StaticLayout k4 = k(i4, width, this.E);
            this.f23776b0 = k4;
            this.D = k4.getText();
        }
    }

    private void j() {
        Bitmap bitmap = this.H;
        if (bitmap != null) {
            bitmap.recycle();
            this.H = null;
        }
    }

    private StaticLayout k(int i4, float f4, boolean z3) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.c(this.C, this.N, (int) f4).e(TextUtils.TruncateAt.END).h(z3).d(Layout.Alignment.ALIGN_NORMAL).g(false).j(i4).i(this.f23790i0, this.f23792j0).f(this.f23794k0).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e4) {
            Log.e("CollapsingTextHelper", e4.getCause().getMessage(), e4);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private void l(@NonNull Canvas canvas, float f4, float f5) {
        int alpha = this.N.getAlpha();
        canvas.translate(f4, f5);
        float f6 = alpha;
        this.N.setAlpha((int) (this.f23782e0 * f6));
        this.f23776b0.draw(canvas);
        this.N.setAlpha((int) (this.f23780d0 * f6));
        int lineBaseline = this.f23776b0.getLineBaseline(0);
        CharSequence charSequence = this.f23786g0;
        float f7 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f7, this.N);
        if (!this.f23779d) {
            String trim = this.f23786g0.toString().trim();
            if (trim.endsWith("…")) {
                trim = trim.substring(0, trim.length() - 1);
            }
            String str = trim;
            this.N.setAlpha(alpha);
            canvas.drawText(str, 0, Math.min(this.f23776b0.getLineEnd(0), str.length()), 0.0f, f7, (Paint) this.N);
        }
    }

    private void m() {
        if (this.H == null && !this.f23787h.isEmpty() && !TextUtils.isEmpty(this.D)) {
            g(0.0f);
            int width = this.f23776b0.getWidth();
            int height = this.f23776b0.getHeight();
            if (width > 0 && height > 0) {
                this.H = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f23776b0.draw(new Canvas(this.H));
                if (this.I == null) {
                    this.I = new Paint(3);
                }
            }
        }
    }

    private float n(int i4, int i5) {
        if (i5 != 17 && (i5 & 7) != 1) {
            if ((i5 & GravityCompat.END) != 8388613 && (i5 & 5) != 5) {
                if (this.E) {
                    return this.f23789i.right - this.f23778c0;
                }
                return this.f23789i.left;
            } else if (this.E) {
                return this.f23789i.left;
            } else {
                return this.f23789i.right - this.f23778c0;
            }
        }
        return (i4 / 2.0f) - (this.f23778c0 / 2.0f);
    }

    private float o(@NonNull RectF rectF, int i4, int i5) {
        if (i5 != 17 && (i5 & 7) != 1) {
            if ((i5 & GravityCompat.END) != 8388613 && (i5 & 5) != 5) {
                if (this.E) {
                    return this.f23789i.right;
                }
                return rectF.left + this.f23778c0;
            } else if (this.E) {
                return rectF.left + this.f23778c0;
            } else {
                return this.f23789i.right;
            }
        }
        return (i4 / 2.0f) + (this.f23778c0 / 2.0f);
    }

    @ColorInt
    private int p(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.L;
        if (iArr != null) {
            return colorStateList.getColorForState(iArr, 0);
        }
        return colorStateList.getDefaultColor();
    }

    @ColorInt
    private int q() {
        return p(this.f23798o);
    }

    private void r(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f23797n);
        textPaint.setTypeface(this.f23807x);
        textPaint.setLetterSpacing(this.Z);
    }

    private void s(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.f23796m);
        textPaint.setTypeface(this.f23808y);
        textPaint.setLetterSpacing(this.f23774a0);
    }

    private void t(float f4) {
        Rect rect;
        if (this.f23779d) {
            RectF rectF = this.f23791j;
            if (f4 < this.f23783f) {
                rect = this.f23787h;
            } else {
                rect = this.f23789i;
            }
            rectF.set(rect);
            return;
        }
        this.f23791j.left = x(this.f23787h.left, this.f23789i.left, f4, this.P);
        this.f23791j.top = x(this.f23801r, this.f23802s, f4, this.P);
        this.f23791j.right = x(this.f23787h.right, this.f23789i.right, f4, this.P);
        this.f23791j.bottom = x(this.f23787h.bottom, this.f23789i.bottom, f4, this.P);
    }

    private static boolean u(float f4, float f5) {
        if (Math.abs(f4 - f5) < 0.001f) {
            return true;
        }
        return false;
    }

    private boolean v() {
        if (ViewCompat.getLayoutDirection(this.f23773a) == 1) {
            return true;
        }
        return false;
    }

    private boolean w(@NonNull CharSequence charSequence, boolean z3) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        if (z3) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    private static float x(float f4, float f5, float f6, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f6 = timeInterpolator.getInterpolation(f6);
        }
        return AnimationUtils.lerp(f4, f5, f6);
    }

    private static boolean z(@NonNull Rect rect, int i4, int i5, int i6, int i7) {
        if (rect.left == i4 && rect.top == i5 && rect.right == i6 && rect.bottom == i7) {
            return true;
        }
        return false;
    }

    public void draw(@NonNull Canvas canvas) {
        float lineLeft;
        int save = canvas.save();
        if (this.D != null && this.f23775b) {
            boolean z3 = true;
            if (this.f23788h0 > 1) {
                lineLeft = this.f23776b0.getLineStart(0);
            } else {
                lineLeft = this.f23776b0.getLineLeft(0);
            }
            float f4 = (this.f23805v + lineLeft) - (this.f23784f0 * 2.0f);
            this.N.setTextSize(this.K);
            float f5 = this.f23805v;
            float f6 = this.f23806w;
            z3 = (!this.G || this.H == null) ? false : false;
            float f7 = this.J;
            if (f7 != 1.0f && !this.f23779d) {
                canvas.scale(f7, f7, f5, f6);
            }
            if (z3) {
                canvas.drawBitmap(this.H, f5, f6, this.I);
                canvas.restoreToCount(save);
                return;
            }
            if (F() && (!this.f23779d || this.f23777c > this.f23783f)) {
                l(canvas, f4, f6);
            } else {
                canvas.translate(f5, f6);
                this.f23776b0.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
    }

    public void getCollapsedTextActualBounds(@NonNull RectF rectF, int i4, int i5) {
        this.E = f(this.C);
        rectF.left = n(i4, i5);
        rectF.top = this.f23789i.top;
        rectF.right = o(rectF, i4, i5);
        rectF.bottom = this.f23789i.top + getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.f23799p;
    }

    public int getCollapsedTextGravity() {
        return this.f23795l;
    }

    public float getCollapsedTextHeight() {
        r(this.O);
        return -this.O.ascent();
    }

    public float getCollapsedTextSize() {
        return this.f23797n;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.f23807x;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return p(this.f23799p);
    }

    public int getExpandedLineCount() {
        return this.f23800q;
    }

    public ColorStateList getExpandedTextColor() {
        return this.f23798o;
    }

    public float getExpandedTextFullHeight() {
        s(this.O);
        return (-this.O.ascent()) + this.O.descent();
    }

    public int getExpandedTextGravity() {
        return this.f23793k;
    }

    public float getExpandedTextHeight() {
        s(this.O);
        return -this.O.ascent();
    }

    public float getExpandedTextSize() {
        return this.f23796m;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.f23808y;
        if (typeface == null) {
            return Typeface.DEFAULT;
        }
        return typeface;
    }

    public float getExpansionFraction() {
        return this.f23777c;
    }

    public float getFadeModeThresholdFraction() {
        return this.f23783f;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.f23794k0;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.f23776b0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.f23776b0.getSpacingAdd();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.f23776b0.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.f23788h0;
    }

    @Nullable
    public TimeInterpolator getPositionInterpolator() {
        return this.P;
    }

    @Nullable
    public CharSequence getText() {
        return this.C;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.F;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f23799p;
        if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f23798o) != null && colorStateList.isStateful())) {
            return true;
        }
        return false;
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setCollapsedBounds(int i4, int i5, int i6, int i7) {
        if (z(this.f23789i, i4, i5, i6, i7)) {
            return;
        }
        this.f23789i.set(i4, i5, i6, i7);
        this.M = true;
        y();
    }

    public void setCollapsedTextAppearance(int i4) {
        TextAppearance textAppearance = new TextAppearance(this.f23773a.getContext(), i4);
        if (textAppearance.getTextColor() != null) {
            this.f23799p = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.f23797n = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.U = colorStateList;
        }
        this.S = textAppearance.shadowDx;
        this.T = textAppearance.shadowDy;
        this.R = textAppearance.shadowRadius;
        this.Z = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.B;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.B = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.f23773a.getContext(), this.B);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.f23799p != colorStateList) {
            this.f23799p = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i4) {
        if (this.f23795l != i4) {
            this.f23795l = i4;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f4) {
        if (this.f23797n != f4) {
            this.f23797n = f4;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (B(typeface)) {
            recalculate();
        }
    }

    public void setCurrentOffsetY(int i4) {
        this.f23785g = i4;
    }

    public void setExpandedBounds(int i4, int i5, int i6, int i7) {
        if (z(this.f23787h, i4, i5, i6, i7)) {
            return;
        }
        this.f23787h.set(i4, i5, i6, i7);
        this.M = true;
        y();
    }

    public void setExpandedTextAppearance(int i4) {
        TextAppearance textAppearance = new TextAppearance(this.f23773a.getContext(), i4);
        if (textAppearance.getTextColor() != null) {
            this.f23798o = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.f23796m = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.Y = colorStateList;
        }
        this.W = textAppearance.shadowDx;
        this.X = textAppearance.shadowDy;
        this.V = textAppearance.shadowRadius;
        this.f23774a0 = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.A;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.A = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.f23773a.getContext(), this.A);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.f23798o != colorStateList) {
            this.f23798o = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i4) {
        if (this.f23793k != i4) {
            this.f23793k = i4;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f4) {
        if (this.f23796m != f4) {
            this.f23796m = f4;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (D(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f4) {
        float clamp = MathUtils.clamp(f4, 0.0f, 1.0f);
        if (clamp != this.f23777c) {
            this.f23777c = clamp;
            c();
        }
    }

    public void setFadeModeEnabled(boolean z3) {
        this.f23779d = z3;
    }

    public void setFadeModeStartFraction(float f4) {
        this.f23781e = f4;
        this.f23783f = e();
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int i4) {
        this.f23794k0 = i4;
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float f4) {
        this.f23790i0 = f4;
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f4) {
        this.f23792j0 = f4;
    }

    public void setMaxLines(int i4) {
        if (i4 != this.f23788h0) {
            this.f23788h0 = i4;
            j();
            recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.P = timeInterpolator;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z3) {
        this.F = z3;
    }

    public final boolean setState(int[] iArr) {
        this.L = iArr;
        if (isStateful()) {
            recalculate();
            return true;
        }
        return false;
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.C, charSequence)) {
            this.C = charSequence;
            this.D = null;
            j();
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.Q = timeInterpolator;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        boolean B = B(typeface);
        boolean D = D(typeface);
        if (B || D) {
            recalculate();
        }
    }

    void y() {
        boolean z3;
        if (this.f23789i.width() > 0 && this.f23789i.height() > 0 && this.f23787h.width() > 0 && this.f23787h.height() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.f23775b = z3;
    }

    public void recalculate(boolean z3) {
        if ((this.f23773a.getHeight() <= 0 || this.f23773a.getWidth() <= 0) && !z3) {
            return;
        }
        b(z3);
        c();
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }
}
