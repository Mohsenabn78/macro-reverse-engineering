package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzfj extends zzu {

    /* renamed from: a  reason: collision with root package name */
    private MessageApi.MessageListener f22765a;

    /* renamed from: b  reason: collision with root package name */
    private ListenerHolder f22766b;

    /* renamed from: c  reason: collision with root package name */
    private IntentFilter[] f22767c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfj(GoogleApiClient googleApiClient, MessageApi.MessageListener messageListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr, zzfi zzfiVar) {
        super(googleApiClient);
        this.f22765a = (MessageApi.MessageListener) Preconditions.checkNotNull(messageListener);
        this.f22766b = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.f22767c = (IntentFilter[]) Preconditions.checkNotNull(intentFilterArr);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        this.f22765a = null;
        this.f22766b = null;
        this.f22767c = null;
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzim) anyClient).zzs(this, this.f22765a, this.f22766b, this.f22767c);
        this.f22765a = null;
        this.f22766b = null;
        this.f22767c = null;
    }
}
