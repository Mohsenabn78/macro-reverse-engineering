package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdtf implements com.google.android.gms.ads.internal.overlay.zzo, zzcgk {
    private final Context zza;
    private final zzbzx zzb;
    private zzdsx zzc;
    private zzcez zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    @Nullable
    private com.google.android.gms.ads.internal.client.zzda zzh;
    private boolean zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdtf(Context context, zzbzx zzbzxVar) {
        this.zza = context;
        this.zzb = zzbzxVar;
    }

    private final synchronized boolean zzl(com.google.android.gms.ads.internal.client.zzda zzdaVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
            zzbzr.zzj("Ad inspector had an internal error.");
            try {
                zzdaVar.zze(zzfbi.zzd(16, null, null));
            } catch (RemoteException unused) {
            }
            return false;
        } else if (this.zzc == null) {
            zzbzr.zzj("Ad inspector had an internal error.");
            try {
                zzdaVar.zze(zzfbi.zzd(16, null, null));
            } catch (RemoteException unused2) {
            }
            return false;
        } else {
            if (!this.zze && !this.zzf) {
                if (com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() >= this.zzg + ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzix)).intValue()) {
                    return true;
                }
            }
            zzbzr.zzj("Ad inspector cannot be opened because it is already open.");
            try {
                zzdaVar.zze(zzfbi.zzd(19, null, null));
            } catch (RemoteException unused3) {
            }
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgk
    public final synchronized void zza(boolean z3) {
        if (z3) {
            com.google.android.gms.ads.internal.util.zze.zza("Ad inspector loaded.");
            this.zze = true;
            zzk("");
            return;
        }
        zzbzr.zzj("Ad inspector failed to load.");
        try {
            com.google.android.gms.ads.internal.client.zzda zzdaVar = this.zzh;
            if (zzdaVar != null) {
                zzdaVar.zze(zzfbi.zzd(17, null, null));
            }
        } catch (RemoteException unused) {
        }
        this.zzi = true;
        this.zzd.destroy();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzb() {
        this.zzf = true;
        zzk("");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzf(int i4) {
        this.zzd.destroy();
        if (!this.zzi) {
            com.google.android.gms.ads.internal.util.zze.zza("Inspector closed.");
            com.google.android.gms.ads.internal.client.zzda zzdaVar = this.zzh;
            if (zzdaVar != null) {
                try {
                    zzdaVar.zze(null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0L;
        this.zzi = false;
        this.zzh = null;
    }

    @Nullable
    public final Activity zzg() {
        zzcez zzcezVar = this.zzd;
        if (zzcezVar != null && !zzcezVar.zzaz()) {
            return this.zzd.zzi();
        }
        return null;
    }

    public final void zzh(zzdsx zzdsxVar) {
        this.zzc = zzdsxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str) {
        JSONObject zze = this.zzc.zze();
        if (!TextUtils.isEmpty(str)) {
            try {
                zze.put("redirectUrl", str);
            } catch (JSONException unused) {
            }
        }
        this.zzd.zzb("window.inspectorInfo", zze.toString());
    }

    public final synchronized void zzj(com.google.android.gms.ads.internal.client.zzda zzdaVar, zzbjb zzbjbVar, zzbiu zzbiuVar) {
        if (!zzl(zzdaVar)) {
            return;
        }
        try {
            com.google.android.gms.ads.internal.zzt.zzz();
            zzcez zza = zzcfl.zza(this.zza, zzcgo.zza(), "", false, false, null, null, this.zzb, null, null, null, zzawz.zza(), null, null, null);
            this.zzd = zza;
            zzcgm zzN = zza.zzN();
            if (zzN == null) {
                zzbzr.zzj("Failed to obtain a web view for the ad inspector");
                try {
                    zzdaVar.zze(zzfbi.zzd(17, "Failed to obtain a web view for the ad inspector", null));
                    return;
                } catch (RemoteException unused) {
                    return;
                }
            }
            this.zzh = zzdaVar;
            zzN.zzM(null, null, null, null, null, false, null, null, null, null, null, null, null, null, zzbjbVar, null, new zzbja(this.zza), zzbiuVar);
            zzN.zzA(this);
            this.zzd.loadUrl((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziv));
            com.google.android.gms.ads.internal.zzt.zzi();
            com.google.android.gms.ads.internal.overlay.zzm.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
            this.zzg = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        } catch (zzcfk e4) {
            zzbzr.zzk("Failed to obtain a web view for the ad inspector", e4);
            try {
                zzdaVar.zze(zzfbi.zzd(17, "Failed to obtain a web view for the ad inspector", null));
            } catch (RemoteException unused2) {
            }
        }
    }

    public final synchronized void zzk(final String str) {
        if (this.zze && this.zzf) {
            zzcae.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdte
                @Override // java.lang.Runnable
                public final void run() {
                    zzdtf.this.zzi(str);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbF() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbo() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzby() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zze() {
    }
}
