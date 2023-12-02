package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalk;
import com.google.android.gms.internal.ads.zzalq;
import com.google.android.gms.internal.ads.zzamh;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzcaj;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbn extends zzalk {

    /* renamed from: a  reason: collision with root package name */
    private final zzcaj f19301a;

    /* renamed from: b  reason: collision with root package name */
    private final zzbzq f19302b;

    public zzbn(String str, Map map, zzcaj zzcajVar) {
        super(0, str, new zzbm(zzcajVar));
        this.f19301a = zzcajVar;
        zzbzq zzbzqVar = new zzbzq(null);
        this.f19302b = zzbzqVar;
        zzbzqVar.zzd(str, "GET", null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzalk
    public final zzalq zzh(zzalg zzalgVar) {
        return zzalq.zzb(zzalgVar, zzamh.zzb(zzalgVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzalk
    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzalg zzalgVar = (zzalg) obj;
        this.f19302b.zzf(zzalgVar.zzc, zzalgVar.zza);
        zzbzq zzbzqVar = this.f19302b;
        byte[] bArr = zzalgVar.zzb;
        if (zzbzq.zzk() && bArr != null) {
            zzbzqVar.zzh(bArr);
        }
        this.f19301a.zzd(zzalgVar);
    }
}
