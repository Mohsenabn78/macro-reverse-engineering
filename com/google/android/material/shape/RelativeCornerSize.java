package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class RelativeCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final float f24244a;

    public RelativeCornerSize(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.f24244a = f4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof RelativeCornerSize) && this.f24244a == ((RelativeCornerSize) obj).f24244a) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF rectF) {
        return this.f24244a * rectF.height();
    }

    @FloatRange(from = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, to = 1.0d)
    public float getRelativePercent() {
        return this.f24244a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f24244a)});
    }
}
