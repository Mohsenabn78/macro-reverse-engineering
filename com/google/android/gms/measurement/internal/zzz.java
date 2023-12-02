package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzoy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzz extends zzy {

    /* renamed from: g  reason: collision with root package name */
    private final com.google.android.gms.internal.measurement.zzet f22110g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ zzaa f22111h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzz(zzaa zzaaVar, String str, int i4, com.google.android.gms.internal.measurement.zzet zzetVar) {
        super(str, i4);
        this.f22111h = zzaaVar;
        this.f22110g = zzetVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzy
    public final int a() {
        return this.f22110g.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean b() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.zzy
    public final boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k(Long l4, Long l5, com.google.android.gms.internal.measurement.zzgm zzgmVar, boolean z3) {
        boolean z4;
        Object obj;
        zzoy.zzc();
        boolean zzs = this.f22111h.f21734a.zzf().zzs(this.f22104a, zzeg.zzW);
        boolean zzg = this.f22110g.zzg();
        boolean zzh = this.f22110g.zzh();
        boolean zzi = this.f22110g.zzi();
        if (!zzg && !zzh && !zzi) {
            z4 = false;
        } else {
            z4 = true;
        }
        Boolean bool = null;
        Integer num = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z3 && !z4) {
            zzer zzj = this.f22111h.f21734a.zzaA().zzj();
            Integer valueOf = Integer.valueOf(this.f22105b);
            if (this.f22110g.zzj()) {
                num = Integer.valueOf(this.f22110g.zza());
            }
            zzj.zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf, num);
            return true;
        }
        com.google.android.gms.internal.measurement.zzem zzb = this.f22110g.zzb();
        boolean zzg2 = zzb.zzg();
        if (zzgmVar.zzr()) {
            if (!zzb.zzi()) {
                this.f22111h.f21734a.zzaA().zzk().zzb("No number filter for long property. property", this.f22111h.f21734a.zzj().f(zzgmVar.zzf()));
            } else {
                bool = zzy.j(zzy.h(zzgmVar.zzb(), zzb.zzc()), zzg2);
            }
        } else if (zzgmVar.zzq()) {
            if (!zzb.zzi()) {
                this.f22111h.f21734a.zzaA().zzk().zzb("No number filter for double property. property", this.f22111h.f21734a.zzj().f(zzgmVar.zzf()));
            } else {
                bool = zzy.j(zzy.g(zzgmVar.zza(), zzb.zzc()), zzg2);
            }
        } else if (zzgmVar.zzt()) {
            if (!zzb.zzk()) {
                if (!zzb.zzi()) {
                    this.f22111h.f21734a.zzaA().zzk().zzb("No string or number filter defined. property", this.f22111h.f21734a.zzj().f(zzgmVar.zzf()));
                } else if (zzlj.G(zzgmVar.zzg())) {
                    bool = zzy.j(zzy.i(zzgmVar.zzg(), zzb.zzc()), zzg2);
                } else {
                    this.f22111h.f21734a.zzaA().zzk().zzc("Invalid user property value for Numeric number filter. property, value", this.f22111h.f21734a.zzj().f(zzgmVar.zzf()), zzgmVar.zzg());
                }
            } else {
                bool = zzy.j(zzy.f(zzgmVar.zzg(), zzb.zzd(), this.f22111h.f21734a.zzaA()), zzg2);
            }
        } else {
            this.f22111h.f21734a.zzaA().zzk().zzb("User property has no value, property", this.f22111h.f21734a.zzj().f(zzgmVar.zzf()));
        }
        zzer zzj2 = this.f22111h.f21734a.zzaA().zzj();
        if (bool == null) {
            obj = "null";
        } else {
            obj = bool;
        }
        zzj2.zzb("Property filter result", obj);
        if (bool == null) {
            return false;
        }
        this.f22106c = Boolean.TRUE;
        if (zzi && !bool.booleanValue()) {
            return true;
        }
        if (!z3 || this.f22110g.zzg()) {
            this.f22107d = bool;
        }
        if (bool.booleanValue() && z4 && zzgmVar.zzs()) {
            long zzc = zzgmVar.zzc();
            if (l4 != null) {
                zzc = l4.longValue();
            }
            if (zzs && this.f22110g.zzg() && !this.f22110g.zzh() && l5 != null) {
                zzc = l5.longValue();
            }
            if (this.f22110g.zzh()) {
                this.f22109f = Long.valueOf(zzc);
            } else {
                this.f22108e = Long.valueOf(zzc);
            }
        }
        return true;
    }
}
