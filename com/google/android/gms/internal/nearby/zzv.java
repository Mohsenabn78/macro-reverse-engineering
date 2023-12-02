package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzv implements Continuation {
    public final /* synthetic */ zzax zza;
    public final /* synthetic */ List zzb;
    public final /* synthetic */ ExposureConfiguration zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzv(zzax zzaxVar, List list, ExposureConfiguration exposureConfiguration, String str) {
        this.zza = zzaxVar;
        this.zzb = list;
        this.zzc = exposureConfiguration;
        this.zzd = str;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final Object then(Task task) {
        return this.zza.zza(this.zzb, this.zzc, this.zzd, task);
    }
}
