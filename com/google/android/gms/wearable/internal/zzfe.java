package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzfe extends zzhn {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference f22758b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference f22759c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfe(Map map, Object obj, BaseImplementation.ResultHolder resultHolder) {
        super(resultHolder);
        this.f22758b = new WeakReference(map);
        this.f22759c = new WeakReference(obj);
    }

    @Override // com.google.android.gms.wearable.internal.zza, com.google.android.gms.wearable.internal.zzex
    public final void zzG(Status status) {
        Map map = (Map) this.f22758b.get();
        Object obj = this.f22759c.get();
        if (status.getStatus().getStatusCode() == 4002 && map != null && obj != null) {
            synchronized (map) {
                zzit zzitVar = (zzit) map.remove(obj);
                if (zzitVar != null) {
                    zzitVar.zzs();
                }
            }
        }
        a(status);
    }
}
