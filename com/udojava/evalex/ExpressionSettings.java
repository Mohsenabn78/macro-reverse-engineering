package com.udojava.evalex;

import java.math.MathContext;

/* loaded from: classes6.dex */
public class ExpressionSettings {

    /* renamed from: a  reason: collision with root package name */
    private MathContext f38287a;

    /* renamed from: b  reason: collision with root package name */
    private int f38288b;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private MathContext f38289a = MathContext.DECIMAL32;

        /* renamed from: b  reason: collision with root package name */
        private int f38290b = 40;

        public ExpressionSettings build() {
            return new ExpressionSettings(this.f38289a, this.f38290b);
        }

        public Builder mathContext(MathContext mathContext) {
            this.f38289a = mathContext;
            return this;
        }

        public Builder powerOperatorPrecedence(int i4) {
            this.f38290b = i4;
            return this;
        }

        public Builder powerOperatorPrecedenceHigher() {
            this.f38290b = 80;
            return this;
        }
    }

    private ExpressionSettings() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public MathContext getMathContext() {
        return this.f38287a;
    }

    public int getPowerOperatorPrecedence() {
        return this.f38288b;
    }

    public ExpressionSettings(MathContext mathContext, int i4) {
        this.f38287a = mathContext;
        this.f38288b = i4;
    }
}
