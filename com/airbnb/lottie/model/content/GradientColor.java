package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes2.dex */
public class GradientColor {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f1627a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f1628b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.f1627a = fArr;
        this.f1628b = iArr;
    }

    public int[] getColors() {
        return this.f1628b;
    }

    public float[] getPositions() {
        return this.f1627a;
    }

    public int getSize() {
        return this.f1628b.length;
    }

    public void lerp(GradientColor gradientColor, GradientColor gradientColor2, float f4) {
        if (gradientColor.f1628b.length == gradientColor2.f1628b.length) {
            for (int i4 = 0; i4 < gradientColor.f1628b.length; i4++) {
                this.f1627a[i4] = MiscUtils.lerp(gradientColor.f1627a[i4], gradientColor2.f1627a[i4], f4);
                this.f1628b[i4] = GammaEvaluator.evaluate(f4, gradientColor.f1628b[i4], gradientColor2.f1628b[i4]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.f1628b.length + " vs " + gradientColor2.f1628b.length + ")");
    }
}
