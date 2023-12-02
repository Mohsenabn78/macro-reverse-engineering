package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.dx.rop.code.RegisterSpec;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzarn implements zzfla {
    private final zzfjd zza;
    private final zzfju zzb;
    private final zzasa zzc;
    private final zzarm zzd;
    private final zzaqw zze;
    private final zzasc zzf;
    private final zzaru zzg;
    private final zzarl zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzarn(@NonNull zzfjd zzfjdVar, @NonNull zzfju zzfjuVar, @NonNull zzasa zzasaVar, @NonNull zzarm zzarmVar, @Nullable zzaqw zzaqwVar, @Nullable zzasc zzascVar, @Nullable zzaru zzaruVar, @Nullable zzarl zzarlVar) {
        this.zza = zzfjdVar;
        this.zzb = zzfjuVar;
        this.zzc = zzasaVar;
        this.zzd = zzarmVar;
        this.zze = zzaqwVar;
        this.zzf = zzascVar;
        this.zzg = zzaruVar;
        this.zzh = zzarlVar;
    }

    private final Map zze() {
        HashMap hashMap = new HashMap();
        zzaon zzb = this.zzb.zzb();
        hashMap.put(RegisterSpec.PREFIX, this.zza.zzb());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put(HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT, zzb.zzh());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        zzaru zzaruVar = this.zzg;
        if (zzaruVar != null) {
            hashMap.put("tcq", Long.valueOf(zzaruVar.zzc()));
            hashMap.put("tpq", Long.valueOf(this.zzg.zzg()));
            hashMap.put("tcv", Long.valueOf(this.zzg.zzd()));
            hashMap.put("tpv", Long.valueOf(this.zzg.zzh()));
            hashMap.put("tchv", Long.valueOf(this.zzg.zzb()));
            hashMap.put("tphv", Long.valueOf(this.zzg.zzf()));
            hashMap.put("tcc", Long.valueOf(this.zzg.zza()));
            hashMap.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzfla
    public final Map zza() {
        Map zze = zze();
        zze.put("lts", Long.valueOf(this.zzc.zza()));
        return zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfla
    public final Map zzb() {
        Map zze = zze();
        zzaon zza = this.zzb.zza();
        zze.put("gai", Boolean.valueOf(this.zza.zzd()));
        zze.put("did", zza.zzg());
        zze.put("dst", Integer.valueOf(zza.zzal() - 1));
        zze.put("doo", Boolean.valueOf(zza.zzai()));
        zzaqw zzaqwVar = this.zze;
        if (zzaqwVar != null) {
            zze.put("nt", Long.valueOf(zzaqwVar.zza()));
        }
        zzasc zzascVar = this.zzf;
        if (zzascVar != null) {
            zze.put("vs", Long.valueOf(zzascVar.zzc()));
            zze.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfla
    public final Map zzc() {
        Map zze = zze();
        zzarl zzarlVar = this.zzh;
        if (zzarlVar != null) {
            zze.put("vst", zzarlVar.zza());
        }
        return zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
