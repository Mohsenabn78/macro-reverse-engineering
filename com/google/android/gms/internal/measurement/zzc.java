package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzc {
    final zzf zza;
    zzg zzb;
    final zzab zzc;
    private final zzz zzd;

    public zzc() {
        zzf zzfVar = new zzf();
        this.zza = zzfVar;
        this.zzb = zzfVar.zzb.zza();
        this.zzc = new zzab();
        this.zzd = new zzz();
        zzfVar.zzd.zza("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzc.this.zzb();
            }
        });
        zzfVar.zzd.zza("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zzb
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzk(zzc.this.zzc);
            }
        });
    }

    public final zzab zza() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzai zzb() throws Exception {
        return new zzv(this.zzd);
    }

    public final void zzc(zzgt zzgtVar) throws zzd {
        zzai zzaiVar;
        try {
            this.zzb = this.zza.zzb.zza();
            if (!(this.zza.zza(this.zzb, (zzgy[]) zzgtVar.zzc().toArray(new zzgy[0])) instanceof zzag)) {
                for (zzgr zzgrVar : zzgtVar.zza().zzd()) {
                    List zzc = zzgrVar.zzc();
                    String zzb = zzgrVar.zzb();
                    Iterator it = zzc.iterator();
                    while (it.hasNext()) {
                        zzap zza = this.zza.zza(this.zzb, (zzgy) it.next());
                        if (zza instanceof zzam) {
                            zzg zzgVar = this.zzb;
                            if (!zzgVar.zzh(zzb)) {
                                zzaiVar = null;
                            } else {
                                zzap zzd = zzgVar.zzd(zzb);
                                if (zzd instanceof zzai) {
                                    zzaiVar = (zzai) zzd;
                                } else {
                                    throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(zzb)));
                                }
                            }
                            if (zzaiVar != null) {
                                zzaiVar.zza(this.zzb, Collections.singletonList(zza));
                            } else {
                                throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(zzb)));
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid rule definition");
                        }
                    }
                }
                return;
            }
            throw new IllegalStateException("Program loading failed");
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final void zzd(String str, Callable callable) {
        this.zza.zzd.zza(str, callable);
    }

    public final boolean zze(zzaa zzaaVar) throws zzd {
        try {
            this.zzc.zzd(zzaaVar);
            this.zza.zzc.zzg("runtime.counter", new zzah(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
            this.zzd.zzb(this.zzb.zza(), this.zzc);
            if (!zzg()) {
                if (!zzf()) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean zzf() {
        if (!this.zzc.zzc().isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean zzg() {
        zzab zzabVar = this.zzc;
        if (!zzabVar.zzb().equals(zzabVar.zza())) {
            return true;
        }
        return false;
    }
}
