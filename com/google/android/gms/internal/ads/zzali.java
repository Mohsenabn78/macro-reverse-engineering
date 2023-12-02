package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzali implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzalk zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzali(zzalk zzalkVar, String str, long j4) {
        this.zzc = zzalkVar;
        this.zza = str;
        this.zzb = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalv zzalvVar;
        zzalv zzalvVar2;
        zzalvVar = this.zzc.zza;
        zzalvVar.zza(this.zza, this.zzb);
        zzalk zzalkVar = this.zzc;
        zzalvVar2 = zzalkVar.zza;
        zzalvVar2.zzb(zzalkVar.toString());
    }
}
