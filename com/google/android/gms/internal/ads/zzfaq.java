package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfaq implements zzfvy {
    final /* synthetic */ zzcez zza;
    final /* synthetic */ zzfgr zzb;
    final /* synthetic */ zzeba zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfaq(zzcez zzcezVar, zzfgr zzfgrVar, zzeba zzebaVar) {
        this.zza = zzcezVar;
        this.zzb = zzfgrVar;
        this.zzc = zzebaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzD().zzaj) {
            this.zzb.zzc(str, null);
            return;
        }
        long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        String str2 = this.zza.zzP().zzb;
        int i4 = 2;
        if (!com.google.android.gms.ads.internal.zzt.zzo().zzx(this.zza.getContext())) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgb)).booleanValue() || !this.zza.zzD().zzT) {
                i4 = 1;
            }
        }
        this.zzc.zzd(new zzebc(currentTimeMillis, str2, str, i4));
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
    }
}
