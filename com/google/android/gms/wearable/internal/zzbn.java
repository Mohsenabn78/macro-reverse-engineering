package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.ChannelApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzbn implements zzb {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f22703a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ IntentFilter[] f22704b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbn(String str, IntentFilter[] intentFilterArr) {
        this.f22703a = str;
        this.f22704b = intentFilterArr;
    }

    @Override // com.google.android.gms.wearable.internal.zzb
    public final /* bridge */ /* synthetic */ void a(zzim zzimVar, BaseImplementation.ResultHolder resultHolder, Object obj, ListenerHolder listenerHolder) throws RemoteException {
        zzimVar.zzq(resultHolder, (ChannelApi.ChannelListener) obj, listenerHolder, this.f22703a, this.f22704b);
    }
}
