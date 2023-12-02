package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzczn implements AppEventListener, OnAdMetadataChangedListener, zzcvg, com.google.android.gms.ads.internal.client.zza, zzcxr, zzcwa, zzcxf, com.google.android.gms.ads.internal.overlay.zzo, zzcvw, zzdcu {
    private final zzczl zza = new zzczl(this, null);
    @Nullable
    private zzejm zzb;
    @Nullable
    private zzejq zzc;
    @Nullable
    private zzevl zzd;
    @Nullable
    private zzeyq zze;

    public static /* bridge */ /* synthetic */ void zzn(zzczn zzcznVar, zzejm zzejmVar) {
        zzcznVar.zzb = zzejmVar;
    }

    public static /* bridge */ /* synthetic */ void zzt(zzczn zzcznVar, zzevl zzevlVar) {
        zzcznVar.zzd = zzevlVar;
    }

    public static /* bridge */ /* synthetic */ void zzu(zzczn zzcznVar, zzejq zzejqVar) {
        zzcznVar.zzc = zzejqVar;
    }

    public static /* bridge */ /* synthetic */ void zzv(zzczn zzcznVar, zzeyq zzeyqVar) {
        zzcznVar.zze = zzeyqVar;
    }

    private static void zzw(Object obj, zzczm zzczmVar) {
        if (obj != null) {
            zzczmVar.zza(obj);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzczb
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).onAdClicked();
            }
        });
        zzw(this.zzc, new zzczm() { // from class: com.google.android.gms.internal.ads.zzczc
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejq) obj).onAdClicked();
            }
        });
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyu
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).onAdMetadataChanged();
            }
        });
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(final String str, final String str2) {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyd
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).onAppEvent(str, str2);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzb() {
        zzw(this.zzd, new zzczm() { // from class: com.google.android.gms.internal.ads.zzczh
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzevl) obj).zzb();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbF() {
        zzw(this.zzd, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyz
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                zzevl zzevlVar = (zzevl) obj;
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzbo() {
        zzw(this.zzd, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyg
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                zzevl zzevlVar = (zzevl) obj;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzbr() {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyh
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                zzejm zzejmVar = (zzejm) obj;
            }
        });
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyi
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).zzbr();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzby() {
        zzw(this.zzd, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyj
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzevl) obj).zzby();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zze() {
        zzw(this.zzd, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyc
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzevl) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzf(final int i4) {
        zzw(this.zzd, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyx
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzevl) obj).zzf(i4);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxf
    public final void zzg() {
        zzw(this.zzd, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyp
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzevl) obj).zzg();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcxr
    public final void zzh(final com.google.android.gms.ads.internal.client.zzs zzsVar) {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcze
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).zzh(com.google.android.gms.ads.internal.client.zzs.this);
            }
        });
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzczf
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).zzh(com.google.android.gms.ads.internal.client.zzs.this);
            }
        });
        zzw(this.zzd, new zzczm() { // from class: com.google.android.gms.internal.ads.zzczg
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzevl) obj).zzh(com.google.android.gms.ads.internal.client.zzs.this);
            }
        });
    }

    public final zzczl zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzj() {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyv
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).zzj();
            }
        });
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyw
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).zzj();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzk(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyk
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).zzk(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyl
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).zzk(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwa
    public final void zzl() {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyn
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).zzl();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzm() {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyy
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).zzm();
            }
        });
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzczd
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).zzm();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzo() {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzczi
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).zzo();
            }
        });
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzczj
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).zzo();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzp(final zzbuu zzbuuVar, final String str, final String str2) {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcym
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                zzejm zzejmVar = (zzejm) obj;
            }
        });
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyo
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).zzp(zzbuu.this, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzq() {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcye
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                zzejm zzejmVar = (zzejm) obj;
            }
        });
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyf
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).zzq();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzr() {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyq
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).zzr();
            }
        });
        zzw(this.zzc, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyr
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejq) obj).zzr();
            }
        });
        zzw(this.zze, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcys
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzeyq) obj).zzr();
            }
        });
        zzw(this.zzd, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcyt
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzevl) obj).zzr();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzs() {
        zzw(this.zzb, new zzczm() { // from class: com.google.android.gms.internal.ads.zzcza
            @Override // com.google.android.gms.internal.ads.zzczm
            public final void zza(Object obj) {
                ((zzejm) obj).zzs();
            }
        });
    }
}
