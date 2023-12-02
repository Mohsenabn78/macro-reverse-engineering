package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes5.dex */
class FadeModeEvaluators {

    /* renamed from: a  reason: collision with root package name */
    private static final FadeModeEvaluator f25002a = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult a(float f4, float f5, float f6, float f7) {
            return FadeModeResult.a(255, TransitionUtils.n(0, 255, f5, f6, f4));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final FadeModeEvaluator f25003b = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult a(float f4, float f5, float f6, float f7) {
            return FadeModeResult.b(TransitionUtils.n(255, 0, f5, f6, f4), 255);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final FadeModeEvaluator f25004c = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult a(float f4, float f5, float f6, float f7) {
            return FadeModeResult.b(TransitionUtils.n(255, 0, f5, f6, f4), TransitionUtils.n(0, 255, f5, f6, f4));
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final FadeModeEvaluator f25005d = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult a(float f4, float f5, float f6, float f7) {
            float f8 = ((f6 - f5) * f7) + f5;
            return FadeModeResult.b(TransitionUtils.n(255, 0, f5, f8, f4), TransitionUtils.n(0, 255, f8, f6, f4));
        }
    };

    private FadeModeEvaluators() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FadeModeEvaluator a(int i4, boolean z3) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        return f25005d;
                    }
                    throw new IllegalArgumentException("Invalid fade mode: " + i4);
                }
                return f25004c;
            } else if (z3) {
                return f25003b;
            } else {
                return f25002a;
            }
        } else if (z3) {
            return f25002a;
        } else {
            return f25003b;
        }
    }
}
