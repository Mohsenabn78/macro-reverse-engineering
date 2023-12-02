package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxe  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxe implements zzabx {
    final /* synthetic */ zzaeg zza;
    final /* synthetic */ zzadl zzb;
    final /* synthetic */ zzaaq zzc;
    final /* synthetic */ zzadu zzd;
    final /* synthetic */ zzabw zze;
    final /* synthetic */ zzys zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxe(zzys zzysVar, zzaeg zzaegVar, zzadl zzadlVar, zzaaq zzaaqVar, zzadu zzaduVar, zzabw zzabwVar) {
        this.zzf = zzysVar;
        this.zza = zzaegVar;
        this.zzb = zzadlVar;
        this.zzc = zzaaqVar;
        this.zzd = zzaduVar;
        this.zze = zzabwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zze.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaeh zzaehVar = (zzaeh) obj;
        if (this.zza.zzn("EMAIL")) {
            this.zzb.zzg(null);
        } else {
            zzaeg zzaegVar = this.zza;
            if (zzaegVar.zzk() != null) {
                this.zzb.zzg(zzaegVar.zzk());
            }
        }
        if (this.zza.zzn("DISPLAY_NAME")) {
            this.zzb.zzf(null);
        } else {
            zzaeg zzaegVar2 = this.zza;
            if (zzaegVar2.zzj() != null) {
                this.zzb.zzf(zzaegVar2.zzj());
            }
        }
        if (this.zza.zzn("PHOTO_URL")) {
            this.zzb.zzj(null);
        } else {
            zzaeg zzaegVar3 = this.zza;
            if (zzaegVar3.zzm() != null) {
                this.zzb.zzj(zzaegVar3.zzm());
            }
        }
        if (!TextUtils.isEmpty(this.zza.zzl())) {
            this.zzb.zzi(Base64Utils.encode("redacted".getBytes()));
        }
        List zzf = zzaehVar.zzf();
        if (zzf == null) {
            zzf = new ArrayList();
        }
        this.zzb.zzk(zzf);
        zzaaq zzaaqVar = this.zzc;
        zzadu zzaduVar = this.zzd;
        Preconditions.checkNotNull(zzaduVar);
        Preconditions.checkNotNull(zzaehVar);
        String zzd = zzaehVar.zzd();
        String zze = zzaehVar.zze();
        if (!TextUtils.isEmpty(zzd) && !TextUtils.isEmpty(zze)) {
            zzaduVar = new zzadu(zze, zzd, Long.valueOf(zzaehVar.zzb()), zzaduVar.zzg());
        }
        zzaaqVar.zzk(zzaduVar, this.zzb);
    }
}
