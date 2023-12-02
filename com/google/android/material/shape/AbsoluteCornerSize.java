package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class AbsoluteCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final float f24180a;

    public AbsoluteCornerSize(float f4) {
        this.f24180a = f4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof AbsoluteCornerSize) && this.f24180a == ((AbsoluteCornerSize) obj).f24180a) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(@NonNull RectF rectF) {
        return this.f24180a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f24180a)});
    }

    public float getCornerSize() {
        return this.f24180a;
    }
}
