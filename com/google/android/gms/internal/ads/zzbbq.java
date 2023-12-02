package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbbq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zza() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbcr.zzc("gad:dynamite_module:experiment_id", ""));
        zzc(arrayList, zzbdc.zza);
        zzc(arrayList, zzbdc.zzb);
        zzc(arrayList, zzbdc.zzc);
        zzc(arrayList, zzbdc.zzd);
        zzc(arrayList, zzbdc.zze);
        zzc(arrayList, zzbdc.zzu);
        zzc(arrayList, zzbdc.zzf);
        zzc(arrayList, zzbdc.zzm);
        zzc(arrayList, zzbdc.zzn);
        zzc(arrayList, zzbdc.zzo);
        zzc(arrayList, zzbdc.zzp);
        zzc(arrayList, zzbdc.zzq);
        zzc(arrayList, zzbdc.zzr);
        zzc(arrayList, zzbdc.zzs);
        zzc(arrayList, zzbdc.zzt);
        zzc(arrayList, zzbdc.zzg);
        zzc(arrayList, zzbdc.zzh);
        zzc(arrayList, zzbdc.zzi);
        zzc(arrayList, zzbdc.zzj);
        zzc(arrayList, zzbdc.zzk);
        zzc(arrayList, zzbdc.zzl);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List zzb() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbdp.zza);
        return arrayList;
    }

    private static void zzc(List list, zzbcr zzbcrVar) {
        String str = (String) zzbcrVar.zze();
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }
}
