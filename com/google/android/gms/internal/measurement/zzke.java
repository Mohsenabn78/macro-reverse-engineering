package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public class zzke {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzke(zzkd zzkdVar) {
    }

    public static int zzb(int i4) {
        return (i4 >>> 1) ^ (-(i4 & 1));
    }

    public static long zzc(long j4) {
        return (j4 >>> 1) ^ (-(1 & j4));
    }
}
