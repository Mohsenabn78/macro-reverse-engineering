package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes5.dex */
public final class MaterialArcMotion extends PathMotion {
    private static PointF a(float f4, float f5, float f6, float f7) {
        if (f5 > f7) {
            return new PointF(f6, f5);
        }
        return new PointF(f4, f7);
    }

    @Override // android.transition.PathMotion
    @NonNull
    public Path getPath(float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(f4, f5);
        PointF a4 = a(f4, f5, f6, f7);
        path.quadTo(a4.x, a4.y, f6, f7);
        return path;
    }
}
