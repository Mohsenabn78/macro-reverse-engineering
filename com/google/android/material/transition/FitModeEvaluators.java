package com.google.android.material.transition;

import android.graphics.RectF;

/* loaded from: classes5.dex */
class FitModeEvaluators {

    /* renamed from: a  reason: collision with root package name */
    private static final FitModeEvaluator f24887a = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.1
        @Override // com.google.android.material.transition.FitModeEvaluator
        public FitModeResult a(float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            float l4 = TransitionUtils.l(f7, f9, f5, f6, f4, true);
            float f11 = l4 / f7;
            float f12 = l4 / f9;
            return new FitModeResult(f11, f12, l4, f8 * f11, l4, f10 * f12);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean b(FitModeResult fitModeResult) {
            if (fitModeResult.f24892d > fitModeResult.f24894f) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public void c(RectF rectF, float f4, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.f24894f - fitModeResult.f24892d) * f4;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final FitModeEvaluator f24888b = new FitModeEvaluator() { // from class: com.google.android.material.transition.FitModeEvaluators.2
        @Override // com.google.android.material.transition.FitModeEvaluator
        public FitModeResult a(float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            float l4 = TransitionUtils.l(f8, f10, f5, f6, f4, true);
            float f11 = l4 / f8;
            float f12 = l4 / f10;
            return new FitModeResult(f11, f12, f7 * f11, l4, f9 * f12, l4);
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public boolean b(FitModeResult fitModeResult) {
            if (fitModeResult.f24891c > fitModeResult.f24893e) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.material.transition.FitModeEvaluator
        public void c(RectF rectF, float f4, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.f24893e - fitModeResult.f24891c) / 2.0f) * f4;
            rectF.left += abs;
            rectF.right -= abs;
        }
    };

    private FitModeEvaluators() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FitModeEvaluator a(int i4, boolean z3, RectF rectF, RectF rectF2) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return f24888b;
                }
                throw new IllegalArgumentException("Invalid fit mode: " + i4);
            }
            return f24887a;
        } else if (b(z3, rectF, rectF2)) {
            return f24887a;
        } else {
            return f24888b;
        }
    }

    private static boolean b(boolean z3, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f4 = (height2 * width) / width2;
        float f5 = (width2 * height) / width;
        if (z3) {
            if (f4 >= height) {
                return true;
            }
        } else if (f5 >= height2) {
            return true;
        }
        return false;
    }
}
