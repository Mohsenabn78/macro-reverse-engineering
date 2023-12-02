package com.google.android.gms.nearby.exposurenotification;

import com.google.android.gms.internal.nearby.zztr;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public enum zzh {
    LOWEST_CONFIDENCE(0),
    LOW_CONFIDENCE(1),
    MEDIUM_CONFIDENCE(2),
    HIGH_CONFIDENCE(3);
    

    /* renamed from: a  reason: collision with root package name */
    private static final zztr f22366a = new zztr() { // from class: com.google.android.gms.nearby.exposurenotification.zzg
    };
    private final int zzg;

    zzh(int i4) {
        this.zzg = i4;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzg);
    }
}
