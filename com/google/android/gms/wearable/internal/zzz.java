package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.CapabilityApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzz implements zzb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IntentFilter[] f22864a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(IntentFilter[] intentFilterArr) {
        this.f22864a = intentFilterArr;
    }

    @Override // com.google.android.gms.wearable.internal.zzb
    public final /* synthetic */ void a(zzim zzimVar, BaseImplementation.ResultHolder resultHolder, Object obj, ListenerHolder listenerHolder) throws RemoteException {
        zzimVar.zzp(resultHolder, (CapabilityApi.CapabilityListener) obj, listenerHolder, this.f22864a);
    }
}
