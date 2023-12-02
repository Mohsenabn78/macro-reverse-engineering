package com.google.android.material.transition;

/* loaded from: classes5.dex */
class FadeModeEvaluators {

    /* renamed from: a  reason: collision with root package name */
    private static final FadeModeEvaluator f24864a = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult a(float f4, float f5, float f6, float f7) {
            return FadeModeResult.a(255, TransitionUtils.m(0, 255, f5, f6, f4));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final FadeModeEvaluator f24865b = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult a(float f4, float f5, float f6, float f7) {
            return FadeModeResult.b(TransitionUtils.m(255, 0, f5, f6, f4), 255);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final FadeModeEvaluator f24866c = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult a(float f4, float f5, float f6, float f7) {
            return FadeModeResult.b(TransitionUtils.m(255, 0, f5, f6, f4), TransitionUtils.m(0, 255, f5, f6, f4));
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final FadeModeEvaluator f24867d = new FadeModeEvaluator() { // from class: com.google.android.material.transition.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.FadeModeEvaluator
        public FadeModeResult a(float f4, float f5, float f6, float f7) {
            float f8 = ((f6 - f5) * f7) + f5;
            return FadeModeResult.b(TransitionUtils.m(255, 0, f5, f8, f4), TransitionUtils.m(0, 255, f8, f6, f4));
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
                        return f24867d;
                    }
                    throw new IllegalArgumentException("Invalid fade mode: " + i4);
                }
                return f24866c;
            } else if (z3) {
                return f24865b;
            } else {
                return f24864a;
            }
        } else if (z3) {
            return f24864a;
        } else {
            return f24865b;
        }
    }
}
