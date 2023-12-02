package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzevl implements zzcvj, zzcxf, zzexb, com.google.android.gms.ads.internal.overlay.zzo, zzcxr, zzcvw, zzdcu {
    private final zzfbq zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private zzevl zzh = null;

    public zzevl(zzfbq zzfbqVar) {
        this.zza = zzfbqVar;
    }

    public static zzevl zzi(zzevl zzevlVar) {
        zzevl zzevlVar2 = new zzevl(zzevlVar.zza);
        zzevlVar2.zzh = zzevlVar;
        return zzevlVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzcvj
    public final void zza(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zza(zzeVar);
            return;
        }
        zzews.zza(this.zzb, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeuw
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzavw) obj).zzc(com.google.android.gms.ads.internal.client.zze.this);
            }
        });
        zzews.zza(this.zzb, new zzewr() { // from class: com.google.android.gms.internal.ads.zzevc
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzavw) obj).zzb(com.google.android.gms.ads.internal.client.zze.this.zza);
            }
        });
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzb() {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zzb();
            return;
        }
        zzews.zza(this.zzf, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeve
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((com.google.android.gms.ads.internal.overlay.zzo) obj).zzb();
            }
        });
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzevf
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzawa) obj).zzf();
            }
        });
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzevg
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzawa) obj).zze();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzexb
    public final void zzbG(zzexb zzexbVar) {
        this.zzh = (zzevl) zzexbVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzby() {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zzby();
        } else {
            zzews.zza(this.zzf, new zzewr() { // from class: com.google.android.gms.internal.ads.zzevb
                @Override // com.google.android.gms.internal.ads.zzewr
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzo) obj).zzby();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zze() {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zze();
        } else {
            zzews.zza(this.zzf, new zzewr() { // from class: com.google.android.gms.internal.ads.zzevi
                @Override // com.google.android.gms.internal.ads.zzewr
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzo) obj).zze();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzf(final int i4) {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zzf(i4);
        } else {
            zzews.zza(this.zzf, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeva
                @Override // com.google.android.gms.internal.ads.zzewr
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.overlay.zzo) obj).zzf(i4);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxf
    public final void zzg() {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zzg();
        } else {
            zzews.zza(this.zze, new zzewr() { // from class: com.google.android.gms.internal.ads.zzevk
                @Override // com.google.android.gms.internal.ads.zzewr
                public final void zza(Object obj) {
                    ((zzcxf) obj).zzg();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxr
    public final void zzh(@NonNull final com.google.android.gms.ads.internal.client.zzs zzsVar) {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zzh(zzsVar);
        } else {
            zzews.zza(this.zzg, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeuz
                @Override // com.google.android.gms.internal.ads.zzewr
                public final void zza(Object obj) {
                    ((com.google.android.gms.ads.internal.client.zzdg) obj).zze(com.google.android.gms.ads.internal.client.zzs.this);
                }
            });
        }
    }

    public final void zzj() {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zzj();
            return;
        }
        this.zza.zza();
        zzews.zza(this.zzc, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeux
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzavx) obj).zza();
            }
        });
        zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzeuy
            @Override // com.google.android.gms.internal.ads.zzewr
            public final void zza(Object obj) {
                ((zzawa) obj).zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcvw
    public final void zzk(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zzk(zzeVar);
        } else {
            zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzevh
                @Override // com.google.android.gms.internal.ads.zzewr
                public final void zza(Object obj) {
                    ((zzawa) obj).zzd(com.google.android.gms.ads.internal.client.zze.this);
                }
            });
        }
    }

    public final void zzl(final zzavt zzavtVar) {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zzl(zzavtVar);
        } else {
            zzews.zza(this.zzb, new zzewr() { // from class: com.google.android.gms.internal.ads.zzevd
                @Override // com.google.android.gms.internal.ads.zzewr
                public final void zza(Object obj) {
                    ((zzavw) obj).zzd(zzavt.this);
                }
            });
        }
    }

    public final void zzn(com.google.android.gms.ads.internal.overlay.zzo zzoVar) {
        this.zzf.set(zzoVar);
    }

    public final void zzo(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        this.zzg.set(zzdgVar);
    }

    public final void zzp(zzavw zzavwVar) {
        this.zzb.set(zzavwVar);
    }

    public final void zzq(zzawa zzawaVar) {
        this.zzd.set(zzawaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzr() {
        zzevl zzevlVar = this.zzh;
        if (zzevlVar != null) {
            zzevlVar.zzr();
        } else {
            zzews.zza(this.zzd, new zzewr() { // from class: com.google.android.gms.internal.ads.zzevj
                @Override // com.google.android.gms.internal.ads.zzewr
                public final void zza(Object obj) {
                    ((zzawa) obj).zzb();
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

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzs() {
    }
}
