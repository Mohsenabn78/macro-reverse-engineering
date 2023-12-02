package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzdtx extends Exception {
    private final int zza;

    public zzdtx(int i4) {
        this.zza = i4;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdtx(int i4, String str) {
        super(str);
        this.zza = i4;
    }

    public zzdtx(int i4, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
