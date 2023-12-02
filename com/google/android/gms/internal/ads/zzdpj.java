package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.MobileAds;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdpj implements zzczy, com.google.android.gms.ads.internal.client.zza, zzcwa, zzcvk {
    private final Context zza;
    private final zzfax zzb;
    private final zzdqa zzc;
    private final zzezz zzd;
    private final zzezn zze;
    private final zzeba zzf;
    @Nullable
    private Boolean zzg;
    private final boolean zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgE)).booleanValue();

    public zzdpj(Context context, zzfax zzfaxVar, zzdqa zzdqaVar, zzezz zzezzVar, zzezn zzeznVar, zzeba zzebaVar) {
        this.zza = context;
        this.zzb = zzfaxVar;
        this.zzc = zzdqaVar;
        this.zzd = zzezzVar;
        this.zze = zzeznVar;
        this.zzf = zzebaVar;
    }

    private final zzdpz zzf(String str) {
        String str2;
        zzdpz zza = this.zzc.zza();
        zza.zze(this.zzd.zzb.zzb);
        zza.zzd(this.zze);
        zza.zzb("action", str);
        boolean z3 = false;
        if (!this.zze.zzu.isEmpty()) {
            zza.zzb("ancn", (String) this.zze.zzu.get(0));
        }
        if (this.zze.zzaj) {
            if (true != com.google.android.gms.ads.internal.zzt.zzo().zzx(this.zza)) {
                str2 = "offline";
            } else {
                str2 = CustomTabsCallback.ONLINE_EXTRAS_KEY;
            }
            zza.zzb("device_connectivity", str2);
            zza.zzb("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()));
            zza.zzb("offline_ad", "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzgN)).booleanValue()) {
            if (com.google.android.gms.ads.nonagon.signalgeneration.zzf.zze(this.zzd.zza.zza) != 1) {
                z3 = true;
            }
            zza.zzb("scar", String.valueOf(z3));
            if (z3) {
                com.google.android.gms.ads.internal.client.zzl zzlVar = this.zzd.zza.zza.zzd;
                zza.zzc("ragent", zzlVar.zzp);
                zza.zzc("rtype", com.google.android.gms.ads.nonagon.signalgeneration.zzf.zza(com.google.android.gms.ads.nonagon.signalgeneration.zzf.zzb(zzlVar)));
            }
        }
        return zza;
    }

    private final void zzg(zzdpz zzdpzVar) {
        if (this.zze.zzaj) {
            this.zzf.zzd(new zzebc(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), this.zzd.zzb.zzb.zzb, zzdpzVar.zzf(), 2));
            return;
        }
        zzdpzVar.zzg();
    }

    private final boolean zzh() {
        if (this.zzg == null) {
            synchronized (this) {
                if (this.zzg == null) {
                    String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbp);
                    com.google.android.gms.ads.internal.zzt.zzp();
                    String zzn = com.google.android.gms.ads.internal.util.zzs.zzn(this.zza);
                    boolean z3 = false;
                    if (str != null && zzn != null) {
                        try {
                            z3 = Pattern.matches(str, zzn);
                        } catch (RuntimeException e4) {
                            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzg = Boolean.valueOf(z3);
                }
            }
        }
        return this.zzg.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (!this.zze.zzaj) {
            return;
        }
        zzg(zzf("click"));
    }

    @Override // com.google.android.gms.internal.ads.zzcvk
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (!this.zzh) {
            return;
        }
        zzdpz zzf = zzf("ifts");
        zzf.zzb("reason", "adapter");
        int i4 = zzeVar.zza;
        String str = zzeVar.zzb;
        if (zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN) && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals(MobileAds.ERROR_DOMAIN)) {
            com.google.android.gms.ads.internal.client.zze zzeVar3 = zzeVar.zzd;
            i4 = zzeVar3.zza;
            str = zzeVar3.zzb;
        }
        if (i4 >= 0) {
            zzf.zzb("arec", String.valueOf(i4));
        }
        String zza = this.zzb.zza(str);
        if (zza != null) {
            zzf.zzb("areec", zza);
        }
        zzf.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcvk
    public final void zzb() {
        if (!this.zzh) {
            return;
        }
        zzdpz zzf = zzf("ifts");
        zzf.zzb("reason", "blocked");
        zzf.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcvk
    public final void zzc(zzdev zzdevVar) {
        if (!this.zzh) {
            return;
        }
        zzdpz zzf = zzf("ifts");
        zzf.zzb("reason", "exception");
        if (!TextUtils.isEmpty(zzdevVar.getMessage())) {
            zzf.zzb(NotificationCompat.CATEGORY_MESSAGE, zzdevVar.getMessage());
        }
        zzf.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzczy
    public final void zzd() {
        if (!zzh()) {
            return;
        }
        zzf("adapter_shown").zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzczy
    public final void zze() {
        if (!zzh()) {
            return;
        }
        zzf("adapter_impression").zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcwa
    public final void zzl() {
        if (!zzh() && !this.zze.zzaj) {
            return;
        }
        zzg(zzf("impression"));
    }
}
