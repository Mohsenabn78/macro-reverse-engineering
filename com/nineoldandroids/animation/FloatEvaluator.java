package com.nineoldandroids.animation;

/* loaded from: classes6.dex */
public class FloatEvaluator implements TypeEvaluator<Number> {
    @Override // com.nineoldandroids.animation.TypeEvaluator
    public Float evaluate(float f4, Number number, Number number2) {
        float floatValue = number.floatValue();
        return Float.valueOf(floatValue + (f4 * (number2.floatValue() - floatValue)));
    }
}
