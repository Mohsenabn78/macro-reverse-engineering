package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdky extends zzbkt implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbec {
    private View zza;
    private com.google.android.gms.ads.internal.client.zzdq zzb;
    private zzdgv zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdky(zzdgv zzdgvVar, zzdha zzdhaVar) {
        this.zza = zzdhaVar.zzf();
        this.zzb = zzdhaVar.zzj();
        this.zzc = zzdgvVar;
        if (zzdhaVar.zzr() != null) {
            zzdhaVar.zzr().zzam(this);
        }
    }

    private final void zzg() {
        View view;
        zzdgv zzdgvVar = this.zzc;
        if (zzdgvVar != null && (view = this.zza) != null) {
            zzdgvVar.zzA(view, Collections.emptyMap(), Collections.emptyMap(), zzdgv.zzW(this.zza));
        }
    }

    private final void zzh() {
        View view = this.zza;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.zza);
        }
    }

    private static final void zzi(zzbkx zzbkxVar, int i4) {
        try {
            zzbkxVar.zze(i4);
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzg();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbku
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdq zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzbzr.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbku
    @Nullable
    public final zzbeo zzc() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzbzr.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdgv zzdgvVar = this.zzc;
        if (zzdgvVar == null || zzdgvVar.zzc() == null) {
            return null;
        }
        return zzdgvVar.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbku
    public final void zzd() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzh();
        zzdgv zzdgvVar = this.zzc;
        if (zzdgvVar != null) {
            zzdgvVar.zzb();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbku
    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdkx(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbku
    public final void zzf(IObjectWrapper iObjectWrapper, zzbkx zzbkxVar) throws RemoteException {
        String str;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzbzr.zzg("Instream ad can not be shown after destroy().");
            zzi(zzbkxVar, 2);
            return;
        }
        View view = this.zza;
        if (view != null && this.zzb != null) {
            if (this.zze) {
                zzbzr.zzg("Instream ad should not be used again.");
                zzi(zzbkxVar, 1);
                return;
            }
            this.zze = true;
            zzh();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            com.google.android.gms.ads.internal.zzt.zzx();
            zzcar.zza(this.zza, this);
            com.google.android.gms.ads.internal.zzt.zzx();
            zzcar.zzb(this.zza, this);
            zzg();
            try {
                zzbkxVar.zzf();
                return;
            } catch (RemoteException e4) {
                zzbzr.zzl("#007 Could not call remote method.", e4);
                return;
            }
        }
        if (view == null) {
            str = "can not get video view.";
        } else {
            str = "can not get video controller.";
        }
        zzbzr.zzg("Instream internal error: ".concat(str));
        zzi(zzbkxVar, 0);
    }
}
