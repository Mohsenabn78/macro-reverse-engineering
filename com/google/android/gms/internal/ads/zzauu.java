package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzauu {
    private final Object zza = new Object();
    private zzaus zzb = null;
    private boolean zzc = false;

    @Nullable
    public final Activity zza() {
        synchronized (this.zza) {
            zzaus zzausVar = this.zzb;
            if (zzausVar != null) {
                return zzausVar.zza();
            }
            return null;
        }
    }

    @Nullable
    public final Context zzb() {
        synchronized (this.zza) {
            zzaus zzausVar = this.zzb;
            if (zzausVar != null) {
                return zzausVar.zzb();
            }
            return null;
        }
    }

    public final void zzc(zzaut zzautVar) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new zzaus();
            }
            this.zzb.zzf(zzautVar);
        }
    }

    public final void zzd(Context context) {
        Application application;
        synchronized (this.zza) {
            if (!this.zzc) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                } else {
                    application = null;
                }
                if (application == null) {
                    zzbzr.zzj("Can not cast Context to Application");
                    return;
                }
                if (this.zzb == null) {
                    this.zzb = new zzaus();
                }
                this.zzb.zzg(application, context);
                this.zzc = true;
            }
        }
    }

    public final void zze(zzaut zzautVar) {
        synchronized (this.zza) {
            zzaus zzausVar = this.zzb;
            if (zzausVar == null) {
                return;
            }
            zzausVar.zzh(zzautVar);
        }
    }
}
