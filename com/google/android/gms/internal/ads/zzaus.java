package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaus implements Application.ActivityLifecycleCallbacks {
    @Nullable
    private Activity zza;
    private Context zzb;
    private Runnable zzh;
    private long zzj;
    private final Object zzc = new Object();
    private boolean zzd = true;
    private boolean zze = false;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private boolean zzi = false;

    private final void zzk(Activity activity) {
        synchronized (this.zzc) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zza = activity;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.zzc) {
            Activity activity2 = this.zza;
            if (activity2 != null) {
                if (activity2.equals(activity)) {
                    this.zza = null;
                }
                Iterator it = this.zzg.iterator();
                while (it.hasNext()) {
                    try {
                        if (((zzavh) it.next()).zza()) {
                            it.remove();
                        }
                    } catch (Exception e4) {
                        com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzbzr.zzh("", e4);
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzk(activity);
        synchronized (this.zzc) {
            for (zzavh zzavhVar : this.zzg) {
                try {
                    zzavhVar.zzb();
                } catch (Exception e4) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbzr.zzh("", e4);
                }
            }
        }
        this.zze = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzs.zza.removeCallbacks(runnable);
        }
        zzfmd zzfmdVar = com.google.android.gms.ads.internal.util.zzs.zza;
        zzaur zzaurVar = new zzaur(this);
        this.zzh = zzaurVar;
        zzfmdVar.postDelayed(zzaurVar, this.zzj);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzk(activity);
        this.zze = false;
        boolean z3 = !this.zzd;
        this.zzd = true;
        Runnable runnable = this.zzh;
        if (runnable != null) {
            com.google.android.gms.ads.internal.util.zzs.zza.removeCallbacks(runnable);
        }
        synchronized (this.zzc) {
            for (zzavh zzavhVar : this.zzg) {
                try {
                    zzavhVar.zzc();
                } catch (Exception e4) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbzr.zzh("", e4);
                }
            }
            if (z3) {
                for (zzaut zzautVar : this.zzf) {
                    try {
                        zzautVar.zza(true);
                    } catch (Exception e5) {
                        zzbzr.zzh("", e5);
                    }
                }
            } else {
                zzbzr.zze("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zzk(activity);
    }

    @Nullable
    public final Activity zza() {
        return this.zza;
    }

    @Nullable
    public final Context zzb() {
        return this.zzb;
    }

    public final void zzf(zzaut zzautVar) {
        synchronized (this.zzc) {
            this.zzf.add(zzautVar);
        }
    }

    public final void zzg(Application application, Context context) {
        if (!this.zzi) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                zzk((Activity) context);
            }
            this.zzb = application;
            this.zzj = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaP)).longValue();
            this.zzi = true;
        }
    }

    public final void zzh(zzaut zzautVar) {
        synchronized (this.zzc) {
            this.zzf.remove(zzautVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
