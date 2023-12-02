package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcnk implements zzfvy {
    final /* synthetic */ zzcnm zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcnk(zzcnm zzcnmVar) {
        this.zza = zzcnmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfar zzfarVar;
        zzfgn zzfgnVar;
        zzezz zzezzVar;
        zzezn zzeznVar;
        zzezn zzeznVar2;
        Context context;
        String str = (String) obj;
        zzcnm zzcnmVar = this.zza;
        zzfarVar = zzcnmVar.zzh;
        zzfgnVar = zzcnmVar.zzg;
        zzezzVar = zzcnmVar.zze;
        zzeznVar = zzcnmVar.zzf;
        zzeznVar2 = zzcnmVar.zzf;
        List zzd = zzfgnVar.zzd(zzezzVar, zzeznVar, false, "", str, zzeznVar2.zzc);
        zzbza zzo = com.google.android.gms.ads.internal.zzt.zzo();
        context = this.zza.zza;
        boolean zzx = zzo.zzx(context);
        int i4 = 1;
        if (true == zzx) {
            i4 = 2;
        }
        zzfarVar.zzc(zzd, i4);
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
    }
}
