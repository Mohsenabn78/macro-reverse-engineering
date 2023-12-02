package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbmn implements zzble, zzbmm {
    private final zzbmm zza;
    private final HashSet zzb = new HashSet();

    public zzbmn(zzbmm zzbmmVar) {
        this.zza = zzbmmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzble, com.google.android.gms.internal.ads.zzblp
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.ads.zzble, com.google.android.gms.internal.ads.zzblp
    public final /* synthetic */ void zzb(String str, String str2) {
        zzbld.zzc(this, str, str2);
    }

    public final void zzc() {
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry simpleEntry = (AbstractMap.SimpleEntry) it.next();
            com.google.android.gms.ads.internal.util.zze.zza("Unregistering eventhandler: ".concat(String.valueOf(((zzbij) simpleEntry.getValue()).toString())));
            this.zza.zzr((String) simpleEntry.getKey(), (zzbij) simpleEntry.getValue());
        }
        this.zzb.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzblc
    public final /* synthetic */ void zzd(String str, Map map) {
        zzbld.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzble, com.google.android.gms.internal.ads.zzblc
    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbld.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbld.zzd(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbmm
    public final void zzq(String str, zzbij zzbijVar) {
        this.zza.zzq(str, zzbijVar);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzbijVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbmm
    public final void zzr(String str, zzbij zzbijVar) {
        this.zza.zzr(str, zzbijVar);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzbijVar));
    }
}
