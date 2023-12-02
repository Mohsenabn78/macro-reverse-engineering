package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcbp {
    private final Context zza;
    private final zzcca zzb;
    private final ViewGroup zzc;
    private zzcbo zzd;

    public zzcbp(Context context, ViewGroup viewGroup, zzcez zzcezVar) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcezVar;
        this.zzd = null;
    }

    public final zzcbo zza() {
        return this.zzd;
    }

    @Nullable
    public final Integer zzb() {
        zzcbo zzcboVar = this.zzd;
        if (zzcboVar != null) {
            return zzcboVar.zzl();
        }
        return null;
    }

    public final void zzc(int i4, int i5, int i6, int i7) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzcbo zzcboVar = this.zzd;
        if (zzcboVar != null) {
            zzcboVar.zzF(i4, i5, i6, i7);
        }
    }

    public final void zzd(int i4, int i5, int i6, int i7, int i8, boolean z3, zzcbz zzcbzVar) {
        if (this.zzd != null) {
            return;
        }
        zzbbw.zza(this.zzb.zzm().zza(), this.zzb.zzk(), "vpr2");
        Context context = this.zza;
        zzcca zzccaVar = this.zzb;
        zzcbo zzcboVar = new zzcbo(context, zzccaVar, i8, z3, zzccaVar.zzm().zza(), zzcbzVar);
        this.zzd = zzcboVar;
        this.zzc.addView(zzcboVar, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzd.zzF(i4, i5, i6, i7);
        this.zzb.zzz(false);
    }

    public final void zze() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzcbo zzcboVar = this.zzd;
        if (zzcboVar != null) {
            zzcboVar.zzo();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zzf() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzcbo zzcboVar = this.zzd;
        if (zzcboVar != null) {
            zzcboVar.zzu();
        }
    }

    public final void zzg(int i4) {
        zzcbo zzcboVar = this.zzd;
        if (zzcboVar != null) {
            zzcboVar.zzC(i4);
        }
    }
}
