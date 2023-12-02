package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(21)
/* loaded from: classes5.dex */
public interface FitModeEvaluator {
    FitModeResult a(float f4, float f5, float f6, float f7, float f8, float f9, float f10);

    boolean b(FitModeResult fitModeResult);

    void c(RectF rectF, float f4, FitModeResult fitModeResult);
}
