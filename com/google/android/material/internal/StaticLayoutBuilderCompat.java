package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
final class StaticLayoutBuilderCompat {

    /* renamed from: n  reason: collision with root package name */
    static final int f23885n;

    /* renamed from: o  reason: collision with root package name */
    private static boolean f23886o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private static Constructor<StaticLayout> f23887p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private static Object f23888q;

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f23889a;

    /* renamed from: b  reason: collision with root package name */
    private final TextPaint f23890b;

    /* renamed from: c  reason: collision with root package name */
    private final int f23891c;

    /* renamed from: e  reason: collision with root package name */
    private int f23893e;

    /* renamed from: l  reason: collision with root package name */
    private boolean f23900l;

    /* renamed from: d  reason: collision with root package name */
    private int f23892d = 0;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f23894f = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: g  reason: collision with root package name */
    private int f23895g = Integer.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    private float f23896h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private float f23897i = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    private int f23898j = f23885n;

    /* renamed from: k  reason: collision with root package name */
    private boolean f23899k = true;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private TextUtils.TruncateAt f23901m = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    static {
        int i4;
        if (Build.VERSION.SDK_INT >= 23) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        f23885n = i4;
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i4) {
        this.f23889a = charSequence;
        this.f23890b = textPaint;
        this.f23891c = i4;
        this.f23893e = charSequence.length();
    }

    private void b() throws StaticLayoutBuilderCompatException {
        boolean z3;
        TextDirectionHeuristic textDirectionHeuristic;
        if (f23886o) {
            return;
        }
        try {
            if (this.f23900l && Build.VERSION.SDK_INT >= 23) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            f23888q = textDirectionHeuristic;
            Class cls = Integer.TYPE;
            Class cls2 = Float.TYPE;
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            f23887p = declaredConstructor;
            declaredConstructor.setAccessible(true);
            f23886o = true;
        } catch (Exception e4) {
            throw new StaticLayoutBuilderCompatException(e4);
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat c(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i4) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i4);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        StaticLayout.Builder obtain;
        TextDirectionHeuristic textDirectionHeuristic;
        StaticLayout build;
        if (this.f23889a == null) {
            this.f23889a = "";
        }
        int max = Math.max(0, this.f23891c);
        CharSequence charSequence = this.f23889a;
        if (this.f23895g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f23890b, max, this.f23901m);
        }
        int min = Math.min(charSequence.length(), this.f23893e);
        this.f23893e = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f23900l && this.f23895g == 1) {
                this.f23894f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            obtain = StaticLayout.Builder.obtain(charSequence, this.f23892d, min, this.f23890b, max);
            obtain.setAlignment(this.f23894f);
            obtain.setIncludePad(this.f23899k);
            if (this.f23900l) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
            obtain.setTextDirection(textDirectionHeuristic);
            TextUtils.TruncateAt truncateAt = this.f23901m;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f23895g);
            float f4 = this.f23896h;
            if (f4 != 0.0f || this.f23897i != 1.0f) {
                obtain.setLineSpacing(f4, this.f23897i);
            }
            if (this.f23895g > 1) {
                obtain.setHyphenationFrequency(this.f23898j);
            }
            build = obtain.build();
            return build;
        }
        b();
        try {
            return (StaticLayout) ((Constructor) Preconditions.checkNotNull(f23887p)).newInstance(charSequence, Integer.valueOf(this.f23892d), Integer.valueOf(this.f23893e), this.f23890b, Integer.valueOf(max), this.f23894f, Preconditions.checkNotNull(f23888q), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f23899k), null, Integer.valueOf(max), Integer.valueOf(this.f23895g));
        } catch (Exception e4) {
            throw new StaticLayoutBuilderCompatException(e4);
        }
    }

    @NonNull
    public StaticLayoutBuilderCompat d(@NonNull Layout.Alignment alignment) {
        this.f23894f = alignment;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat e(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f23901m = truncateAt;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat f(int i4) {
        this.f23898j = i4;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat g(boolean z3) {
        this.f23899k = z3;
        return this;
    }

    public StaticLayoutBuilderCompat h(boolean z3) {
        this.f23900l = z3;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat i(float f4, float f5) {
        this.f23896h = f4;
        this.f23897i = f5;
        return this;
    }

    @NonNull
    public StaticLayoutBuilderCompat j(@IntRange(from = 0) int i4) {
        this.f23895g = i4;
        return this;
    }
}
