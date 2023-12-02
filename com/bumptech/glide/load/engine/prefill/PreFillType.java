package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;

/* loaded from: classes3.dex */
public final class PreFillType {
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    static final Bitmap.Config f17084e = Bitmap.Config.RGB_565;

    /* renamed from: a  reason: collision with root package name */
    private final int f17085a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17086b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap.Config f17087c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17088d;

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final int f17089a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17090b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f17091c;

        /* renamed from: d  reason: collision with root package name */
        private int f17092d;

        public Builder(int i4) {
            this(i4, i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public PreFillType a() {
            return new PreFillType(this.f17089a, this.f17090b, this.f17091c, this.f17092d);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Bitmap.Config b() {
            return this.f17091c;
        }

        public Builder setConfig(@Nullable Bitmap.Config config) {
            this.f17091c = config;
            return this;
        }

        public Builder setWeight(int i4) {
            if (i4 > 0) {
                this.f17092d = i4;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i4, int i5) {
            this.f17092d = 1;
            if (i4 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            }
            if (i5 > 0) {
                this.f17089a = i4;
                this.f17090b = i5;
                return;
            }
            throw new IllegalArgumentException("Height must be > 0");
        }
    }

    PreFillType(int i4, int i5, Bitmap.Config config, int i6) {
        this.f17087c = (Bitmap.Config) Preconditions.checkNotNull(config, "Config must not be null");
        this.f17085a = i4;
        this.f17086b = i5;
        this.f17088d = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap.Config a() {
        return this.f17087c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f17086b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f17088d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f17085a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (this.f17086b != preFillType.f17086b || this.f17085a != preFillType.f17085a || this.f17088d != preFillType.f17088d || this.f17087c != preFillType.f17087c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((this.f17085a * 31) + this.f17086b) * 31) + this.f17087c.hashCode()) * 31) + this.f17088d;
    }

    public String toString() {
        return "PreFillSize{width=" + this.f17085a + ", height=" + this.f17086b + ", config=" + this.f17087c + ", weight=" + this.f17088d + '}';
    }
}
