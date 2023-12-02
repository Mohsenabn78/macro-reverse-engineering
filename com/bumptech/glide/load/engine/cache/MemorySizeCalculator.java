package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public final class MemorySizeCalculator {

    /* renamed from: a  reason: collision with root package name */
    private final int f16903a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16904b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f16905c;

    /* renamed from: d  reason: collision with root package name */
    private final int f16906d;

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: i  reason: collision with root package name */
        static final int f16907i;

        /* renamed from: a  reason: collision with root package name */
        final Context f16908a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f16909b;

        /* renamed from: c  reason: collision with root package name */
        b f16910c;

        /* renamed from: e  reason: collision with root package name */
        float f16912e;

        /* renamed from: d  reason: collision with root package name */
        float f16911d = 2.0f;

        /* renamed from: f  reason: collision with root package name */
        float f16913f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        float f16914g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        int f16915h = 4194304;

        static {
            int i4;
            if (Build.VERSION.SDK_INT < 26) {
                i4 = 4;
            } else {
                i4 = 1;
            }
            f16907i = i4;
        }

        public Builder(Context context) {
            this.f16912e = f16907i;
            this.f16908a = context;
            this.f16909b = (ActivityManager) context.getSystemService("activity");
            this.f16910c = new a(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && MemorySizeCalculator.b(this.f16909b)) {
                this.f16912e = 0.0f;
            }
        }

        public MemorySizeCalculator build() {
            return new MemorySizeCalculator(this);
        }

        public Builder setArrayPoolSize(int i4) {
            this.f16915h = i4;
            return this;
        }

        public Builder setBitmapPoolScreens(float f4) {
            boolean z3;
            if (f4 >= 0.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Bitmap pool screens must be greater than or equal to 0");
            this.f16912e = f4;
            return this;
        }

        public Builder setLowMemoryMaxSizeMultiplier(float f4) {
            boolean z3;
            if (f4 >= 0.0f && f4 <= 1.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Low memory max size multiplier must be between 0 and 1");
            this.f16914g = f4;
            return this;
        }

        public Builder setMaxSizeMultiplier(float f4) {
            boolean z3;
            if (f4 >= 0.0f && f4 <= 1.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Size multiplier must be between 0 and 1");
            this.f16913f = f4;
            return this;
        }

        public Builder setMemoryCacheScreens(float f4) {
            boolean z3;
            if (f4 >= 0.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Memory cache screens must be greater than or equal to 0");
            this.f16911d = f4;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    private static final class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f16916a;

        a(DisplayMetrics displayMetrics) {
            this.f16916a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.b
        public int a() {
            return this.f16916a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.cache.MemorySizeCalculator.b
        public int b() {
            return this.f16916a.widthPixels;
        }
    }

    /* loaded from: classes3.dex */
    interface b {
        int a();

        int b();
    }

    MemorySizeCalculator(Builder builder) {
        int i4;
        boolean z3;
        this.f16905c = builder.f16908a;
        if (b(builder.f16909b)) {
            i4 = builder.f16915h / 2;
        } else {
            i4 = builder.f16915h;
        }
        this.f16906d = i4;
        int a4 = a(builder.f16909b, builder.f16913f, builder.f16914g);
        float b4 = builder.f16910c.b() * builder.f16910c.a() * 4;
        int round = Math.round(builder.f16912e * b4);
        int round2 = Math.round(b4 * builder.f16911d);
        int i5 = a4 - i4;
        int i6 = round2 + round;
        if (i6 <= i5) {
            this.f16904b = round2;
            this.f16903a = round;
        } else {
            float f4 = i5;
            float f5 = builder.f16912e;
            float f6 = builder.f16911d;
            float f7 = f4 / (f5 + f6);
            this.f16904b = Math.round(f6 * f7);
            this.f16903a = Math.round(f7 * builder.f16912e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(c(this.f16904b));
            sb.append(", pool size: ");
            sb.append(c(this.f16903a));
            sb.append(", byte array size: ");
            sb.append(c(i4));
            sb.append(", memory class limited? ");
            if (i6 > a4) {
                z3 = true;
            } else {
                z3 = false;
            }
            sb.append(z3);
            sb.append(", max size: ");
            sb.append(c(a4));
            sb.append(", memoryClass: ");
            sb.append(builder.f16909b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(b(builder.f16909b));
        }
    }

    private static int a(ActivityManager activityManager, float f4, float f5) {
        boolean b4 = b(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (b4) {
            f4 = f5;
        }
        return Math.round(memoryClass * f4);
    }

    @TargetApi(19)
    static boolean b(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String c(int i4) {
        return Formatter.formatFileSize(this.f16905c, i4);
    }

    public int getArrayPoolSizeInBytes() {
        return this.f16906d;
    }

    public int getBitmapPoolSize() {
        return this.f16903a;
    }

    public int getMemoryCacheSize() {
        return this.f16904b;
    }
}
