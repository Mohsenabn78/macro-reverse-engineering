package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgsz implements zzgpq {
    static final zzgpq zza = new zzgsz();

    private zzgsz() {
    }

    @Override // com.google.android.gms.internal.ads.zzgpq
    public final boolean zza(int i4) {
        if (i4 != 0 && i4 != 1 && i4 != 2 && i4 != 1999) {
            switch (i4) {
                case 1000:
                case 1001:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                case 1006:
                case 1007:
                case 1008:
                case 1009:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
