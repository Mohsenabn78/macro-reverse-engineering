package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class AdjustedCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final CornerSize f24181a;

    /* renamed from: b  reason: collision with root package name */
    private final float f24182b;

    public AdjustedCornerSize(float f4, @NonNull CornerSize cornerSize) {
        while (cornerSize instanceof AdjustedCornerSize) {
            cornerSize = ((AdjustedCornerSize) cornerSize).f24181a;
            f4 += ((AdjustedCornerSize) cornerSize).f24182b;
        }
        this.f24181a = cornerSize;
        this.f24182b = f4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjustedCornerSize)) {
            return false;
        }
        AdjustedCornerSize adjustedCornerSize = (AdjustedCornerSize) obj;
        if (this.f24181a.equals(adjustedCornerSize.f24181a) && this.f24182b == adjustedCornerSize.f24182b) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF rectF) {
        return Math.max(0.0f, this.f24181a.getCornerSize(rectF) + this.f24182b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f24181a, Float.valueOf(this.f24182b)});
    }
}
