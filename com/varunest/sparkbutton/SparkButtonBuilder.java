package com.varunest.sparkbutton;

import android.content.Context;
import com.varunest.sparkbutton.helpers.Utils;

/* loaded from: classes6.dex */
public class SparkButtonBuilder {

    /* renamed from: a  reason: collision with root package name */
    private SparkButton f38336a;

    /* renamed from: b  reason: collision with root package name */
    private Context f38337b;

    public SparkButtonBuilder(Context context) {
        this.f38337b = context;
        this.f38336a = new SparkButton(context);
    }

    public SparkButton build() {
        this.f38336a.d();
        return this.f38336a;
    }

    public SparkButtonBuilder setActiveImage(int i4) {
        this.f38336a.f38295a = i4;
        return this;
    }

    public SparkButtonBuilder setAnimationSpeed(float f4) {
        this.f38336a.f38308n = f4;
        return this;
    }

    public SparkButtonBuilder setImageSizeDp(int i4) {
        this.f38336a.f38297c = Utils.dpToPx(this.f38337b, i4);
        return this;
    }

    public SparkButtonBuilder setImageSizePx(int i4) {
        this.f38336a.f38297c = i4;
        return this;
    }

    public SparkButtonBuilder setInactiveImage(int i4) {
        this.f38336a.f38296b = i4;
        return this;
    }

    public SparkButtonBuilder setPrimaryColor(int i4) {
        this.f38336a.f38301g = i4;
        return this;
    }

    public SparkButtonBuilder setSecondaryColor(int i4) {
        this.f38336a.f38300f = i4;
        return this;
    }
}
