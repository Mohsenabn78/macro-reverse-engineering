package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.internal.BaseImplementation;
import java.util.List;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzid extends zzhn {

    /* renamed from: b  reason: collision with root package name */
    private final List f22803b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzid(BaseImplementation.ResultHolder resultHolder, List list) {
        super(resultHolder);
        this.f22803b = list;
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzex
    public final void zzC(zzgu zzguVar) {
        a(new zzcq(zzhf.zza(zzguVar.zza), zzguVar.zzb));
        if (zzguVar.zza != 0) {
            for (FutureTask futureTask : this.f22803b) {
                futureTask.cancel(true);
            }
        }
    }
}
