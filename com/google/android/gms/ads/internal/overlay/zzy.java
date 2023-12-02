package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzdcu;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzy extends zzbrs {

    /* renamed from: a  reason: collision with root package name */
    private final AdOverlayInfoParcel f19252a;

    /* renamed from: b  reason: collision with root package name */
    private final Activity f19253b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19254c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19255d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19256e = false;

    public zzy(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f19252a = adOverlayInfoParcel;
        this.f19253b = activity;
    }

    private final synchronized void zzb() {
        if (!this.f19255d) {
            zzo zzoVar = this.f19252a.zzc;
            if (zzoVar != null) {
                zzoVar.zzf(4);
            }
            this.f19255d = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final boolean zzG() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzl(@Nullable Bundle bundle) {
        zzo zzoVar;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzis)).booleanValue() && !this.f19256e) {
            this.f19253b.requestWindowFeature(1);
        }
        boolean z3 = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z3 = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.f19252a;
        if (adOverlayInfoParcel == null) {
            this.f19253b.finish();
        } else if (z3) {
            this.f19253b.finish();
        } else {
            if (bundle == null) {
                com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel.zzb;
                if (zzaVar != null) {
                    zzaVar.onAdClicked();
                }
                zzdcu zzdcuVar = this.f19252a.zzv;
                if (zzdcuVar != null) {
                    zzdcuVar.zzr();
                }
                if (this.f19253b.getIntent() != null && this.f19253b.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zzoVar = this.f19252a.zzc) != null) {
                    zzoVar.zzb();
                }
            }
            com.google.android.gms.ads.internal.zzt.zzh();
            Activity activity = this.f19253b;
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.f19252a;
            zzc zzcVar = adOverlayInfoParcel2.zza;
            if (!zza.zzb(activity, zzcVar, adOverlayInfoParcel2.zzi, zzcVar.zzi)) {
                this.f19253b.finish();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzm() throws RemoteException {
        if (this.f19253b.isFinishing()) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzo() throws RemoteException {
        zzo zzoVar = this.f19252a.zzc;
        if (zzoVar != null) {
            zzoVar.zzbo();
        }
        if (this.f19253b.isFinishing()) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzr() throws RemoteException {
        if (this.f19254c) {
            this.f19253b.finish();
            return;
        }
        this.f19254c = true;
        zzo zzoVar = this.f19252a.zzc;
        if (zzoVar != null) {
            zzoVar.zzbF();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzs(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.f19254c);
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzu() throws RemoteException {
        if (this.f19253b.isFinishing()) {
            zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzv() throws RemoteException {
        zzo zzoVar = this.f19252a.zzc;
        if (zzoVar != null) {
            zzoVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzx() throws RemoteException {
        this.f19256e = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzi() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzq() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzt() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzh(int i4, int i5, Intent intent) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbrt
    public final void zzp(int i4, String[] strArr, int[] iArr) {
    }
}
