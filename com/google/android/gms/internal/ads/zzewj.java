package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzewj implements zzfcp {
    public final zzexd zza;
    public final zzexf zzb;
    public final com.google.android.gms.ads.internal.client.zzl zzc;
    public final String zzd;
    public final Executor zze;
    public final com.google.android.gms.ads.internal.client.zzw zzf;
    public final zzfce zzg;

    public zzewj(zzexd zzexdVar, zzexf zzexfVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, Executor executor, com.google.android.gms.ads.internal.client.zzw zzwVar, zzfce zzfceVar) {
        this.zza = zzexdVar;
        this.zzb = zzexfVar;
        this.zzc = zzlVar;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzwVar;
        this.zzg = zzfceVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfcp
    public final zzfce zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzfcp
    public final Executor zzb() {
        return this.zze;
    }
}
