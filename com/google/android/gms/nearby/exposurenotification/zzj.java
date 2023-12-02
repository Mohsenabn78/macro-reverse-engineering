package com.google.android.gms.nearby.exposurenotification;

import com.google.android.gms.internal.nearby.zztr;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public enum zzj {
    INFECTIOUSNESS_NONE(0),
    INFECTIOUSNESS_STANDARD(1),
    INFECTIOUSNESS_HIGH(2);
    

    /* renamed from: a  reason: collision with root package name */
    private static final zztr f22368a = new zztr() { // from class: com.google.android.gms.nearby.exposurenotification.zzi
    };
    private final int zzf;

    zzj(int i4) {
        this.zzf = i4;
    }

    public static zzj zza(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return null;
                }
                return INFECTIOUSNESS_HIGH;
            }
            return INFECTIOUSNESS_STANDARD;
        }
        return INFECTIOUSNESS_NONE;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }
}
