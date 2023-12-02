package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzc extends zzu {

    /* renamed from: a  reason: collision with root package name */
    private Object f22718a;

    /* renamed from: b  reason: collision with root package name */
    private ListenerHolder f22719b;

    /* renamed from: c  reason: collision with root package name */
    private final zzb f22720c;

    private zzc(GoogleApiClient googleApiClient, Object obj, ListenerHolder listenerHolder, zzb zzbVar) {
        super(googleApiClient);
        this.f22718a = Preconditions.checkNotNull(obj);
        this.f22719b = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.f22720c = (zzb) Preconditions.checkNotNull(zzbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PendingResult a(GoogleApiClient googleApiClient, zzb zzbVar, Object obj) {
        return googleApiClient.enqueue(new zzc(googleApiClient, obj, googleApiClient.registerListener(obj), zzbVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        this.f22718a = null;
        this.f22719b = null;
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        this.f22720c.a((zzim) anyClient, this, this.f22718a, this.f22719b);
        this.f22718a = null;
        this.f22719b = null;
    }
}
