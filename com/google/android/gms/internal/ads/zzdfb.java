package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdfb implements zzcvg, zzdcd {
    private final zzbxe zza;
    private final Context zzb;
    private final zzbxw zzc;
    @Nullable
    private final View zzd;
    private String zze;
    private final zzaxj zzf;

    public zzdfb(zzbxe zzbxeVar, Context context, zzbxw zzbxwVar, @Nullable View view, zzaxj zzaxjVar) {
        this.zza = zzbxeVar;
        this.zzb = context;
        this.zzc = zzbxwVar;
        this.zzd = view;
        this.zzf = zzaxjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzg() {
        String str;
        if (this.zzf == zzaxj.APP_OPEN) {
            return;
        }
        String zzd = this.zzc.zzd(this.zzb);
        this.zze = zzd;
        zzaxj zzaxjVar = this.zzf;
        String valueOf = String.valueOf(zzd);
        if (zzaxjVar == zzaxj.REWARD_BASED_VIDEO_AD) {
            str = "/Rewarded";
        } else {
            str = "/Interstitial";
        }
        this.zze = valueOf.concat(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzj() {
        this.zza.zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzo() {
        View view = this.zzd;
        if (view != null && this.zze != null) {
            this.zzc.zzs(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    @ParametersAreNonnullByDefault
    public final void zzp(zzbuu zzbuuVar, String str, String str2) {
        if (this.zzc.zzu(this.zzb)) {
            try {
                zzbxw zzbxwVar = this.zzc;
                Context context = this.zzb;
                zzbxwVar.zzo(context, zzbxwVar.zza(context), this.zza.zza(), zzbuuVar.zzc(), zzbuuVar.zzb());
            } catch (RemoteException e4) {
                zzbzr.zzk("Remote Exception to get reward item.", e4);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzbr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdcd
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzm() {
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzq() {
    }
}
