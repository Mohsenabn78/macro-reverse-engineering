package com.google.android.gms.maps.model;

/* loaded from: classes4.dex */
public final class Dash extends PatternItem {
    public final float length;

    public Dash(float f4) {
        super(0, Float.valueOf(Math.max(f4, 0.0f)));
        this.length = Math.max(f4, 0.0f);
    }

    @Override // com.google.android.gms.maps.model.PatternItem
    public final String toString() {
        float f4 = this.length;
        StringBuilder sb = new StringBuilder(30);
        sb.append("[Dash: length=");
        sb.append(f4);
        sb.append("]");
        return sb.toString();
    }
}
