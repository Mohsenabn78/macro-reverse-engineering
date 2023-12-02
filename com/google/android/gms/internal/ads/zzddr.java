package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzddr {
    private final zzdew zza;
    @Nullable
    private final zzcez zzb;

    public zzddr(zzdew zzdewVar, @Nullable zzcez zzcezVar) {
        this.zza = zzdewVar;
        this.zzb = zzcezVar;
    }

    public static final zzdcm zzh(zzffk zzffkVar) {
        return new zzdcm(zzffkVar, zzcae.zzf);
    }

    public static final zzdcm zzi(zzdfb zzdfbVar) {
        return new zzdcm(zzdfbVar, zzcae.zzf);
    }

    @Nullable
    public final View zza() {
        zzcez zzcezVar = this.zzb;
        if (zzcezVar == null) {
            return null;
        }
        return zzcezVar.zzG();
    }

    @Nullable
    public final View zzb() {
        zzcez zzcezVar = this.zzb;
        if (zzcezVar != null) {
            return zzcezVar.zzG();
        }
        return null;
    }

    @Nullable
    public final zzcez zzc() {
        return this.zzb;
    }

    public final zzdcm zzd(Executor executor) {
        final zzcez zzcezVar = this.zzb;
        return new zzdcm(new zzczt() { // from class: com.google.android.gms.internal.ads.zzddp
            @Override // com.google.android.gms.internal.ads.zzczt
            public final void zza() {
                com.google.android.gms.ads.internal.overlay.zzl zzL;
                zzcez zzcezVar2 = zzcez.this;
                if (zzcezVar2 != null && (zzL = zzcezVar2.zzL()) != null) {
                    zzL.zzb();
                }
            }
        }, executor);
    }

    public final zzdew zze() {
        return this.zza;
    }

    public Set zzf(zzcud zzcudVar) {
        return Collections.singleton(new zzdcm(zzcudVar, zzcae.zzf));
    }

    public Set zzg(zzcud zzcudVar) {
        return Collections.singleton(new zzdcm(zzcudVar, zzcae.zzf));
    }
}
