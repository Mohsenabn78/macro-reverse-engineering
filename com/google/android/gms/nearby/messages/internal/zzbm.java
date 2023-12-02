package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzbm extends zzbu {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ListenerHolder f22449b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzbw f22450c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ SubscribeOptions f22451d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbm(zzbx zzbxVar, GoogleApiClient googleApiClient, ListenerHolder listenerHolder, zzbw zzbwVar, SubscribeOptions subscribeOptions) {
        super(googleApiClient);
        this.f22449b = listenerHolder;
        this.f22450c = zzbwVar;
        this.f22451d = subscribeOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzai) anyClient).k(a(), this.f22449b, this.f22450c, this.f22451d, null);
    }
}
