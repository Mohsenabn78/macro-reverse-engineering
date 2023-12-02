package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzahh implements zzabv {
    final /* synthetic */ zzahi zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzahh(zzahi zzahiVar, zzahg zzahgVar) {
        this.zza = zzahiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        zzahu zzahuVar;
        long j4;
        zzahi zzahiVar = this.zza;
        zzahuVar = zzahiVar.zzd;
        j4 = zzahiVar.zzf;
        return zzahuVar.zzf(j4);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        zzahu zzahuVar;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        zzahi zzahiVar = this.zza;
        zzahuVar = zzahiVar.zzd;
        long zzg = zzahuVar.zzg(j4);
        j5 = zzahiVar.zzb;
        BigInteger valueOf = BigInteger.valueOf(zzg);
        zzahi zzahiVar2 = this.zza;
        j6 = zzahiVar2.zzc;
        j7 = zzahiVar2.zzb;
        BigInteger multiply = valueOf.multiply(BigInteger.valueOf(j6 - j7));
        j8 = this.zza.zzf;
        long longValue = j5 + multiply.divide(BigInteger.valueOf(j8)).longValue();
        zzahi zzahiVar3 = this.zza;
        j9 = zzahiVar3.zzb;
        j10 = zzahiVar3.zzc;
        zzabw zzabwVar = new zzabw(j4, Math.max(j9, Math.min(longValue - 30000, j10 - 1)));
        return new zzabt(zzabwVar, zzabwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return true;
    }
}
