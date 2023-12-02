package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdie implements View.OnClickListener {
    @Nullable
    @VisibleForTesting
    String zza;
    @Nullable
    @VisibleForTesting
    Long zzb;
    @Nullable
    @VisibleForTesting
    WeakReference zzc;
    private final zzdlx zzd;
    private final Clock zze;
    @Nullable
    private zzbgl zzf;
    @Nullable
    private zzbij zzg;

    public zzdie(zzdlx zzdlxVar, Clock clock) {
        this.zzd = zzdlxVar;
        this.zze = clock;
    }

    private final void zzd() {
        View view;
        this.zza = null;
        this.zzb = null;
        WeakReference weakReference = this.zzc;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        view.setClickable(false);
        view.setOnClickListener(null);
        this.zzc = null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WeakReference weakReference = this.zzc;
        if (weakReference != null && weakReference.get() == view) {
            if (this.zza != null && this.zzb != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", this.zza);
                hashMap.put("time_interval", String.valueOf(this.zze.currentTimeMillis() - this.zzb.longValue()));
                hashMap.put("messageType", "onePointFiveClick");
                this.zzd.zzg("sendMessageToNativeJs", hashMap);
            }
            zzd();
        }
    }

    @Nullable
    public final zzbgl zza() {
        return this.zzf;
    }

    public final void zzb() {
        if (this.zzf == null || this.zzb == null) {
            return;
        }
        zzd();
        try {
            this.zzf.zze();
        } catch (RemoteException e4) {
            zzbzr.zzl("#007 Could not call remote method.", e4);
        }
    }

    public final void zzc(final zzbgl zzbglVar) {
        this.zzf = zzbglVar;
        zzbij zzbijVar = this.zzg;
        if (zzbijVar != null) {
            this.zzd.zzk("/unconfirmedClick", zzbijVar);
        }
        zzbij zzbijVar2 = new zzbij() { // from class: com.google.android.gms.internal.ads.zzdid
            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zza(Object obj, Map map) {
                zzdie zzdieVar = zzdie.this;
                zzbgl zzbglVar2 = zzbglVar;
                try {
                    zzdieVar.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
                } catch (NumberFormatException unused) {
                    zzbzr.zzg("Failed to call parse unconfirmedClickTimestamp.");
                }
                zzdieVar.zza = (String) map.get("id");
                String str = (String) map.get("asset_id");
                if (zzbglVar2 == null) {
                    zzbzr.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
                    return;
                }
                try {
                    zzbglVar2.zzf(str);
                } catch (RemoteException e4) {
                    zzbzr.zzl("#007 Could not call remote method.", e4);
                }
            }
        };
        this.zzg = zzbijVar2;
        this.zzd.zzi("/unconfirmedClick", zzbijVar2);
    }
}
