package com.nineoldandroids.animation;

/* loaded from: classes6.dex */
public class ArgbEvaluator implements TypeEvaluator {
    @Override // com.nineoldandroids.animation.TypeEvaluator
    public Object evaluate(float f4, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        int i4 = intValue >> 24;
        int i5 = (intValue >> 16) & 255;
        int i6 = (intValue >> 8) & 255;
        int i7 = intValue & 255;
        int intValue2 = ((Integer) obj2).intValue();
        return Integer.valueOf(((i4 + ((int) (((intValue2 >> 24) - i4) * f4))) << 24) | ((i5 + ((int) ((((intValue2 >> 16) & 255) - i5) * f4))) << 16) | ((i6 + ((int) ((((intValue2 >> 8) & 255) - i6) * f4))) << 8) | (i7 + ((int) (f4 * ((intValue2 & 255) - i7)))));
    }
}
