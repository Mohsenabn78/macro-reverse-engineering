package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeaz implements zzfvy {
    final /* synthetic */ zzfdo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeaz(zzeba zzebaVar, zzfdo zzfdoVar) {
        this.zza = zzfdoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzbzr.zzg("Failed to get offline buffered ping database: ".concat(String.valueOf(th.getMessage())));
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zza((SQLiteDatabase) obj);
        } catch (Exception e4) {
            zzbzr.zzg("Error executing function on offline buffered ping database: ".concat(String.valueOf(e4.getMessage())));
        }
    }
}
