package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.PublishOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzbk extends zzbu {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Message f22445b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzbt f22446c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ PublishOptions f22447d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbk(zzbx zzbxVar, GoogleApiClient googleApiClient, Message message, zzbt zzbtVar, PublishOptions publishOptions) {
        super(googleApiClient);
        this.f22445b = message;
        this.f22446c = zzbtVar;
        this.f22447d = publishOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzai) anyClient).f(a(), zzae.zza(this.f22445b), this.f22446c, this.f22447d);
    }
}
