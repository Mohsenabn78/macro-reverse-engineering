package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes5.dex */
class FitModeEvaluators {

    /* renamed from: a  reason: collision with root package name */
    private static final FitModeEvaluator f25025a = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult a(float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            float m4 = TransitionUtils.m(f7, f9, f5, f6, f4, true);
            float f11 = m4 / f7;
            float f12 = m4 / f9;
            return new FitModeResult(f11, f12, m4, f8 * f11, m4, f10 * f12);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean b(FitModeResult fitModeResult) {
            if (fitModeResult.f25030d > fitModeResult.f25032f) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void c(RectF rectF, float f4, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.f25032f - fitModeResult.f25030d) * f4;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final FitModeEvaluator f25026b = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult a(float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
            float m4 = TransitionUtils.m(f8, f10, f5, f6, f4, true);
            float f11 = m4 / f8;
            float f12 = m4 / f10;
            return new FitModeResult(f11, f12, f7 * f11, m4, f9 * f12, m4);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean b(FitModeResult fitModeResult) {
            if (fitModeResult.f25029c > fitModeResult.f25031e) {
                return true;
            }
            return false;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void c(RectF rectF, float f4, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.f25031e - fitModeResult.f25029c) / 2.0f) * f4;
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
                    return f25026b;
                }
                throw new IllegalArgumentException("Invalid fit mode: " + i4);
            }
            return f25025a;
        } else if (b(z3, rectF, rectF2)) {
            return f25025a;
        } else {
            return f25026b;
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
