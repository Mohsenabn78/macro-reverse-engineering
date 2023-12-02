package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.auth.zze;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxf  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxf implements zzabx {
    final /* synthetic */ zzabw zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Boolean zzd;
    final /* synthetic */ zze zze;
    final /* synthetic */ zzaaq zzf;
    final /* synthetic */ zzadu zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxf(zzys zzysVar, zzabw zzabwVar, String str, String str2, Boolean bool, zze zzeVar, zzaaq zzaaqVar, zzadu zzaduVar) {
        this.zza = zzabwVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzeVar;
        this.zzf = zzaaqVar;
        this.zzg = zzaduVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List list;
        List zzb = ((zzadk) obj).zzb();
        if (zzb != null && !zzb.isEmpty()) {
            int i4 = 0;
            zzadl zzadlVar = (zzadl) zzb.get(0);
            zzaea zzl = zzadlVar.zzl();
            if (zzl != null) {
                list = zzl.zzc();
            } else {
                list = null;
            }
            if (list != null && !list.isEmpty()) {
                if (TextUtils.isEmpty(this.zzb)) {
                    ((zzadz) list.get(0)).zzh(this.zzc);
                } else {
                    while (true) {
                        if (i4 >= list.size()) {
                            break;
                        } else if (((zzadz) list.get(i4)).zzf().equals(this.zzb)) {
                            ((zzadz) list.get(i4)).zzh(this.zzc);
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            }
            zzadlVar.zzh(this.zzd.booleanValue());
            zzadlVar.zze(this.zze);
            this.zzf.zzk(this.zzg, zzadlVar);
            return;
        }
        this.zza.zza("No users.");
    }
}
