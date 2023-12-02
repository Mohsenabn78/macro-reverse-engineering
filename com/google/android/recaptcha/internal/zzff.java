package com.google.android.recaptcha.internal;

import java.io.IOException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public abstract class zzff {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzfg zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzff(zzfe zzfeVar) {
    }

    public static int zzF(int i4) {
        return (i4 >>> 1) ^ (-(i4 & 1));
    }

    public static long zzG(long j4) {
        return (j4 >>> 1) ^ (-(1 & j4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzff zzH(byte[] bArr, int i4, int i5, boolean z3) {
        zzfb zzfbVar = new zzfb(bArr, 0, 0, false, null);
        try {
            zzfbVar.zze(0);
            return zzfbVar;
        } catch (zzgy e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public abstract void zzA(int i4);

    public abstract boolean zzC() throws IOException;

    public abstract boolean zzD() throws IOException;

    public abstract boolean zzE(int i4) throws IOException;

    public abstract double zzb() throws IOException;

    public abstract float zzc() throws IOException;

    public abstract int zzd();

    public abstract int zze(int i4) throws zzgy;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzk() throws IOException;

    public abstract int zzl() throws IOException;

    public abstract int zzm() throws IOException;

    public abstract int zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract long zzv() throws IOException;

    public abstract zzez zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract String zzy() throws IOException;

    public abstract void zzz(int i4) throws zzgy;
}
