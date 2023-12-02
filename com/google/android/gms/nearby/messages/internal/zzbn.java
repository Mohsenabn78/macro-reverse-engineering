package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzbn extends zzbu {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PendingIntent f22452b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzbw f22453c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ SubscribeOptions f22454d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbn(zzbx zzbxVar, GoogleApiClient googleApiClient, PendingIntent pendingIntent, zzbw zzbwVar, SubscribeOptions subscribeOptions) {
        super(googleApiClient);
        this.f22452b = pendingIntent;
        this.f22453c = zzbwVar;
        this.f22454d = subscribeOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzai) anyClient).i(a(), this.f22452b, this.f22453c, this.f22454d);
    }
}
