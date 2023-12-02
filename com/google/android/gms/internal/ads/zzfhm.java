package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfhm implements Application.ActivityLifecycleCallbacks {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzfhm zza = new zzfhm();
    private boolean zzb;
    private boolean zzc;
    private zzfhr zzd;

    private zzfhm() {
    }

    public static zzfhm zza() {
        return zza;
    }

    private final void zze() {
        String str;
        boolean z3 = this.zzc;
        for (zzfha zzfhaVar : zzfhl.zza().zzc()) {
            zzfhx zzg = zzfhaVar.zzg();
            if (zzg.zzk()) {
                if (true != z3) {
                    str = "foregrounded";
                } else {
                    str = "backgrounded";
                }
                zzfhq.zza().zzb(zzg.zza(), "setState", str);
            }
        }
    }

    private final void zzf(boolean z3) {
        if (this.zzc != z3) {
            this.zzc = z3;
            if (this.zzb) {
                zze();
                if (this.zzd != null) {
                    if (!z3) {
                        zzfin.zzd().zzi();
                    } else {
                        zzfin.zzd().zzh();
                    }
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zzf(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        View zzf;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i4 = runningAppProcessInfo.importance;
        boolean z3 = true;
        boolean z4 = true;
        for (zzfha zzfhaVar : zzfhl.zza().zzb()) {
            if (zzfhaVar.zzj() && (zzf = zzfhaVar.zzf()) != null && zzf.hasWindowFocus()) {
                z4 = false;
            }
        }
        zzf((i4 == 100 || !z4) ? false : false);
    }

    public final void zzb() {
        this.zzb = true;
        this.zzc = false;
        zze();
    }

    public final void zzc() {
        this.zzb = false;
        this.zzc = false;
        this.zzd = null;
    }

    public final void zzd(zzfhr zzfhrVar) {
        this.zzd = zzfhrVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
