package com.google.android.gms.internal.places;

/* loaded from: classes4.dex */
public abstract class zzai {
    private int zzeo;
    private int zzep;
    private boolean zzeq;

    private zzai() {
        this.zzeo = 100;
        this.zzep = Integer.MAX_VALUE;
        this.zzeq = false;
    }

    public static long zzb(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    public static int zzm(int i4) {
        return (-(i4 & 1)) ^ (i4 >>> 1);
    }

    public abstract int zzaj();

    public abstract int zzl(int i4) throws zzbk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzai zzb(byte[] bArr, int i4, int i5, boolean z3) {
        zzak zzakVar = new zzak(bArr, 0, i5, false);
        try {
            zzakVar.zzl(i5);
            return zzakVar;
        } catch (zzbk e4) {
            throw new IllegalArgumentException(e4);
        }
    }
}
