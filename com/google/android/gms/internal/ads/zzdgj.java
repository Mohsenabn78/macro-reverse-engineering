package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdgj extends zzben {
    private final zzdha zza;
    private IObjectWrapper zzb;

    public zzdgj(zzdha zzdhaVar) {
        this.zza = zzdhaVar;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbeo
    public final float zze() throws RemoteException {
        float f4;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfZ)).booleanValue()) {
            return 0.0f;
        }
        if (this.zza.zzb() != 0.0f) {
            return this.zza.zzb();
        }
        if (this.zza.zzj() != null) {
            try {
                return this.zza.zzj().zze();
            } catch (RemoteException e4) {
                zzbzr.zzh("Remote exception getting video controller aspect ratio.", e4);
                return 0.0f;
            }
        }
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return zzb(iObjectWrapper);
        }
        zzber zzm = this.zza.zzm();
        if (zzm == null) {
            return 0.0f;
        }
        if (zzm.zzd() != -1 && zzm.zzc() != -1) {
            f4 = zzm.zzd() / zzm.zzc();
        } else {
            f4 = 0.0f;
        }
        if (f4 == 0.0f) {
            return zzb(zzm.zzf());
        }
        return f4;
    }

    @Override // com.google.android.gms.internal.ads.zzbeo
    public final float zzf() throws RemoteException {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzga)).booleanValue() || this.zza.zzj() == null) {
            return 0.0f;
        }
        return this.zza.zzj().zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbeo
    public final float zzg() throws RemoteException {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzga)).booleanValue() || this.zza.zzj() == null) {
            return 0.0f;
        }
        return this.zza.zzj().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbeo
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzga)).booleanValue()) {
            return null;
        }
        return this.zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbeo
    @Nullable
    public final IObjectWrapper zzi() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzber zzm = this.zza.zzm();
        if (zzm == null) {
            return null;
        }
        return zzm.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbeo
    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbeo
    public final boolean zzk() throws RemoteException {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzga)).booleanValue()) {
            return false;
        }
        return this.zza.zzad();
    }

    @Override // com.google.android.gms.internal.ads.zzbeo
    public final boolean zzl() throws RemoteException {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzga)).booleanValue() || this.zza.zzj() == null) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbeo
    public final void zzm(zzbfz zzbfzVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzga)).booleanValue() && (this.zza.zzj() instanceof zzcfv)) {
            ((zzcfv) this.zza.zzj()).zzv(zzbfzVar);
        }
    }
}
