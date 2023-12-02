package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
class zzage {
    public final int zzd;

    public zzage(int i4) {
        this.zzd = i4;
    }

    public static int zze(int i4) {
        return (i4 >> 24) & 255;
    }

    public static String zzf(int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ((i4 >> 24) & 255));
        sb.append((char) ((i4 >> 16) & 255));
        sb.append((char) ((i4 >> 8) & 255));
        sb.append((char) (i4 & 255));
        return sb.toString();
    }

    public String toString() {
        return zzf(this.zzd);
    }
}
