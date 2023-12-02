package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeaj implements zzfem {
    private final zzdzx zza;
    private final zzeab zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeaj(zzdzx zzdzxVar, zzeab zzeabVar) {
        this.zza = zzdzxVar;
        this.zzb = zzeabVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbC(zzfef zzfefVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfW)).booleanValue() && zzfef.RENDERER == zzfefVar && this.zza.zzc() != 0) {
            this.zza.zzf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzc(zzfef zzfefVar, String str) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfW)).booleanValue()) {
            return;
        }
        if (zzfef.RENDERER == zzfefVar) {
            this.zza.zzg(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime());
        } else if (zzfef.PRELOADED_LOADER != zzfefVar && zzfef.SERVER_TRANSACTION != zzfefVar) {
        } else {
            this.zza.zzh(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime());
            final zzeab zzeabVar = this.zzb;
            final long zzd = this.zza.zzd();
            zzeabVar.zza.zza(new zzfdo() { // from class: com.google.android.gms.internal.ads.zzeaa
                @Override // com.google.android.gms.internal.ads.zzfdo
                public final Object zza(Object obj) {
                    zzeab zzeabVar2 = zzeab.this;
                    long j4 = zzd;
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                    if (!zzeabVar2.zzf()) {
                        zzazh zzg = zzazi.zzg();
                        zzg.zzh(j4);
                        byte[] zzax = ((zzazi) zzg.zzal()).zzax();
                        zzeai.zzg(sQLiteDatabase, false, false);
                        zzeai.zzd(sQLiteDatabase, j4, zzax);
                        return null;
                    }
                    return null;
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzd(zzfef zzfefVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfW)).booleanValue() && zzfef.RENDERER == zzfefVar && this.zza.zzc() != 0) {
            this.zza.zzf(com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbB(zzfef zzfefVar, String str) {
    }
}
