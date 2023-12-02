package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgm implements zzgd {
    @Nullable
    private zzhg zzb;
    @Nullable
    private String zzc;
    private boolean zzf;
    private final zzha zza = new zzha();
    private int zzd = ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED;
    private int zze = ConnectionsStatusCodes.STATUS_NETWORK_NOT_CONNECTED;

    public final zzgm zzb(boolean z3) {
        this.zzf = true;
        return this;
    }

    public final zzgm zzc(int i4) {
        this.zzd = i4;
        return this;
    }

    public final zzgm zzd(int i4) {
        this.zze = i4;
        return this;
    }

    public final zzgm zze(@Nullable zzhg zzhgVar) {
        this.zzb = zzhgVar;
        return this;
    }

    public final zzgm zzf(@Nullable String str) {
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgd
    /* renamed from: zzg */
    public final zzgr zza() {
        zzgr zzgrVar = new zzgr(this.zzc, this.zzd, this.zze, this.zzf, this.zza);
        zzhg zzhgVar = this.zzb;
        if (zzhgVar != null) {
            zzgrVar.zzf(zzhgVar);
        }
        return zzgrVar;
    }
}
