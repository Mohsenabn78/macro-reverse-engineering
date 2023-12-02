package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f4, float f5, @NonNull ShapePath shapePath) {
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f4, float f5, float f6) {
        getCornerPath(f4, f5, shapePath);
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f4, float f5, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f4, f5, cornerSize.getCornerSize(rectF));
    }
}
