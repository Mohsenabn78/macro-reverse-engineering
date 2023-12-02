package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcoh implements zzaua {
    private zzcez zza;
    private final Executor zzb;
    private final zzcnt zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcnw zzg = new zzcnw();

    public zzcoh(Executor executor, zzcnt zzcntVar, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcntVar;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            final JSONObject zzb = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcog
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzcoh.this.zzd(zzb);
                    }
                });
            }
        } catch (JSONException e4) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed to call video active view js", e4);
        }
    }

    public final void zza() {
        this.zze = false;
    }

    public final void zzb() {
        this.zze = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzaua
    public final void zzc(zzatz zzatzVar) {
        boolean z3;
        zzcnw zzcnwVar = this.zzg;
        if (this.zzf) {
            z3 = false;
        } else {
            z3 = zzatzVar.zzj;
        }
        zzcnwVar.zza = z3;
        zzcnwVar.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzatzVar;
        if (this.zze) {
            zzg();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(JSONObject jSONObject) {
        this.zza.zzl("AFMA_updateActiveView", jSONObject);
    }

    public final void zze(boolean z3) {
        this.zzf = z3;
    }

    public final void zzf(zzcez zzcezVar) {
        this.zza = zzcezVar;
    }
}
