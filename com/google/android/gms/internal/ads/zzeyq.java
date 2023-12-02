package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeyq implements OnAdMetadataChangedListener, zzcwu, zzcvj, zzcvg, zzcvw, zzcxr, zzexb, zzdcu {
    private final zzfbq zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();

    public zzeyq(zzfbq zzfbqVar) {
        this.zza = zzfbqVar;
    }

    @Override // com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
    public final void onAdMetadataChanged() {
        zzews.zza(this.zzb, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyk
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((OnAdMetadataChangedListener) obj).onAdMetadataChanged();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvj
    public final void zza(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        final int i4 = zzeVar.zza;
        zzews.zza(this.zzc, new zzewr() { // from class: com.google.android.gms.internal.ads.zzexw
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbvu) obj).zzf(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
        zzews.zza(this.zzc, new zzewr() { // from class: com.google.android.gms.internal.ads.zzexx
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbvu) obj).zze(i4);
            }
        });
        zzews.zza(this.zze, new zzewr() { // from class: com.google.android.gms.internal.ads.zzexy
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbva) obj).zzg(i4);
            }
        });
    }

    public final void zzb(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzb.set(onAdMetadataChangedListener);
    }

    @Override // com.google.android.gms.internal.ads.zzexb
    public final void zzbG(zzexb zzexbVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzbr() {
        zzews.zza(this.zze, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyf
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbva) obj).zzl();
            }
        });
    }

    public final void zzc(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        this.zzh.set(zzdgVar);
    }

    public final void zzd(zzbvq zzbvqVar) {
        this.zzd.set(zzbvqVar);
    }

    public final void zze(zzbvu zzbvuVar) {
        this.zzc.set(zzbvuVar);
    }

    @Deprecated
    public final void zzf(zzbva zzbvaVar) {
        this.zze.set(zzbvaVar);
    }

    @Deprecated
    public final void zzg(zzbuv zzbuvVar) {
        this.zzg.set(zzbuvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcxr
    public final void zzh(@NonNull final com.google.android.gms.ads.internal.client.zzs zzsVar) {
        zzews.zza(this.zzh, new zzewr() { // from class: com.google.android.gms.internal.ads.zzexv
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.client.zzdg) obj).zze(com.google.android.gms.ads.internal.client.zzs.this);
            }
        });
    }

    public final void zzi(zzbvv zzbvvVar) {
        this.zzf.set(zzbvvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzj() {
        this.zza.zza();
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyc
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbvq) obj).zzg();
            }
        });
        zzews.zza(this.zze, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyd
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbva) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzk(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzexz
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbvq) obj).zzi(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeya
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbvq) obj).zzh(com.google.android.gms.ads.internal.client.zze.this.zza);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzm() {
        zzews.zza(this.zze, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyl
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbva) obj).zzh();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzn() {
        zzews.zza(this.zzc, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyi
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbvu) obj).zzg();
            }
        });
        zzews.zza(this.zze, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyj
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbva) obj).zzi();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzo() {
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeye
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbvq) obj).zzj();
            }
        });
        zzews.zza(this.zze, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyg
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbva) obj).zzj();
            }
        });
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyh
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbvq) obj).zzf();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzp(final zzbuu zzbuuVar, final String str, final String str2) {
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeym
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                zzbuu zzbuuVar2 = zzbuu.this;
                ((zzbvq) obj).zzk(new zzbwe(zzbuuVar2.zzc(), zzbuuVar2.zzb()));
            }
        });
        zzews.zza(this.zzf, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyn
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                zzbuu zzbuuVar2 = zzbuu.this;
                ((zzbvv) obj).zze(new zzbwe(zzbuuVar2.zzc(), zzbuuVar2.zzb()), str, str2);
            }
        });
        zzews.zza(this.zze, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyo
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbva) obj).zze(zzbuu.this);
            }
        });
        zzews.zza(this.zzg, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyp
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbuv) obj).zze(zzbuu.this, str, str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzq() {
        zzews.zza(this.zze, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeyb
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbva) obj).zzk();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzr() {
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzexu
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzbvq) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzs() {
    }
}
