package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzage  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzage {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzagf zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzage(zzagd zzagdVar) {
    }

    public static int zzF(int i4) {
        return (i4 >>> 1) ^ (-(i4 & 1));
    }

    public static long zzG(long j4) {
        return (j4 >>> 1) ^ (-(1 & j4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzage zzH(byte[] bArr, int i4, int i5, boolean z3) {
        zzaga zzagaVar = new zzaga(bArr, 0, i5, z3, null);
        try {
            zzagaVar.zze(i5);
            return zzagaVar;
        } catch (zzahl e4) {
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

    public abstract int zze(int i4) throws zzahl;

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

    public abstract zzafy zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract String zzy() throws IOException;

    public abstract void zzz(int i4) throws zzahl;
}
