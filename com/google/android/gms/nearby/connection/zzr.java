package com.google.android.gms.nearby.connection;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzr {
    public static String zza(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    return "OTHER";
                }
                return "Secondary";
            }
            return "Main";
        }
        return "UNKNOWN";
    }
}
