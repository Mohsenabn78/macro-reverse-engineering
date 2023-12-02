package com.google.android.gms.common.internal.service;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class Common {
    @NonNull
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> API;
    @NonNull
    @KeepForSdk
    public static final Api.ClientKey<zah> CLIENT_KEY;

    /* renamed from: a  reason: collision with root package name */
    private static final Api.AbstractClientBuilder f20499a;
    public static final zae zaa;

    static {
        Api.ClientKey<zah> clientKey = new Api.ClientKey<>();
        CLIENT_KEY = clientKey;
        zab zabVar = new zab();
        f20499a = zabVar;
        API = new Api<>("Common.API", zabVar, clientKey);
        zaa = new zae();
    }
}
