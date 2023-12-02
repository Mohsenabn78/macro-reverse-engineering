package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzfy implements zzge {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    @Nullable
    private zzgj zzd;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzfy(boolean z3) {
        this.zza = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.ads.zzge
    public final void zzf(zzhg zzhgVar) {
        zzhgVar.getClass();
        if (!this.zzb.contains(zzhgVar)) {
            this.zzb.add(zzhgVar);
            this.zzc++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzg(int i4) {
        zzgj zzgjVar = this.zzd;
        int i5 = zzfj.zza;
        for (int i6 = 0; i6 < this.zzc; i6++) {
            ((zzhg) this.zzb.get(i6)).zza(this, zzgjVar, this.zza, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzh() {
        zzgj zzgjVar = this.zzd;
        int i4 = zzfj.zza;
        for (int i5 = 0; i5 < this.zzc; i5++) {
            ((zzhg) this.zzb.get(i5)).zzb(this, zzgjVar, this.zza);
        }
        this.zzd = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi(zzgj zzgjVar) {
        for (int i4 = 0; i4 < this.zzc; i4++) {
            ((zzhg) this.zzb.get(i4)).zzc(this, zzgjVar, this.zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzj(zzgj zzgjVar) {
        this.zzd = zzgjVar;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            ((zzhg) this.zzb.get(i4)).zzd(this, zzgjVar, this.zza);
        }
    }
}
