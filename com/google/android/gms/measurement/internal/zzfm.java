package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfm {

    /* renamed from: a  reason: collision with root package name */
    private final zza f21619a;

    /* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
    /* loaded from: classes4.dex */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzfm(zza zzaVar) {
        Preconditions.checkNotNull(zzaVar);
        this.f21619a = zzaVar;
    }

    @MainThread
    public final void zza(Context context, Intent intent) {
        zzgd zzp = zzgd.zzp(context, null, null);
        zzet zzaA = zzp.zzaA();
        if (intent == null) {
            zzaA.zzk().zza("Receiver called with null intent");
            return;
        }
        zzp.zzay();
        String action = intent.getAction();
        zzaA.zzj().zzb("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzaA.zzj().zza("Starting wakeful intent.");
            this.f21619a.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzaA.zzk().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
