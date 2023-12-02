package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdvr extends zzdvl {
    private String zzg;
    private int zzh = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdvr(Context context) {
        this.zzf = new zzbte(context, com.google.android.gms.ads.internal.zzt.zzt().zzb(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i4 = this.zzh;
                    if (i4 == 2) {
                        this.zzf.zzp().zze(this.zze, new zzdvk(this));
                    } else if (i4 == 3) {
                        this.zzf.zzp().zzh(this.zzg, new zzdvk(this));
                    } else {
                        this.zza.zze(new zzdwa(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zze(new zzdwa(1));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzbzr.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zze(new zzdwa(1));
    }

    public final zzfwm zzb(zzbue zzbueVar) {
        synchronized (this.zzb) {
            int i4 = this.zzh;
            if (i4 != 1 && i4 != 2) {
                return zzfwc.zzg(new zzdwa(2));
            } else if (this.zzc) {
                return this.zza;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbueVar;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdvq
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdvr.this.zza();
                    }
                }, zzcae.zzf);
                return this.zza;
            }
        }
    }

    public final zzfwm zzc(String str) {
        synchronized (this.zzb) {
            int i4 = this.zzh;
            if (i4 != 1 && i4 != 3) {
                return zzfwc.zzg(new zzdwa(2));
            } else if (this.zzc) {
                return this.zza;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdvp
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzdvr.this.zza();
                    }
                }, zzcae.zzf);
                return this.zza;
            }
        }
    }
}
