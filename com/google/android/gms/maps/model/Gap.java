package com.google.android.gms.maps.model;

/* loaded from: classes4.dex */
public final class Gap extends PatternItem {
    public final float length;

    public Gap(float f4) {
        super(2, Float.valueOf(Math.max(f4, 0.0f)));
        this.length = Math.max(f4, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        float f4 = this.length;
        StringBuilder sb = new StringBuilder(29);
        sb.append("[Gap: length=");
        sb.append(f4);
        sb.append("]");
        return sb.toString();
    }
}
