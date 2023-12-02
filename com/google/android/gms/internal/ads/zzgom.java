package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgom {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzgon zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgom(zzgol zzgolVar) {
    }

    public static int zzF(int i4) {
        return (i4 >>> 1) ^ (-(i4 & 1));
    }

    public static long zzG(long j4) {
        return (j4 >>> 1) ^ (-(1 & j4));
    }

    public static zzgom zzH(InputStream inputStream, int i4) {
        return new zzgok(inputStream, 4096, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgom zzI(byte[] bArr, int i4, int i5, boolean z3) {
        zzgog zzgogVar = new zzgog(bArr, i4, i5, z3, null);
        try {
            zzgogVar.zze(i5);
            return zzgogVar;
        } catch (zzgpy e4) {
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

    public abstract int zze(int i4) throws zzgpy;

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

    public abstract zzgoe zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract String zzy() throws IOException;

    public abstract void zzz(int i4) throws zzgpy;
}
