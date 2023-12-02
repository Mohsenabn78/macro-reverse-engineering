package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelApi;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzat extends zzu {

    /* renamed from: a  reason: collision with root package name */
    private final String f22681a;

    /* renamed from: b  reason: collision with root package name */
    private ChannelApi.ChannelListener f22682b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzat(GoogleApiClient googleApiClient, ChannelApi.ChannelListener channelListener, @Nullable String str) {
        super(googleApiClient);
        this.f22682b = (ChannelApi.ChannelListener) Preconditions.checkNotNull(channelListener);
        this.f22681a = str;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result createFailedResult(Status status) {
        this.f22682b = null;
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzim) anyClient).zzy(this, this.f22682b, this.f22681a);
        this.f22682b = null;
    }
}
