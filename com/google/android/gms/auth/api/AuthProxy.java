package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzar;

@KeepForSdk
/* loaded from: classes4.dex */
public final class AuthProxy {
    @KeepForSdk
    public static final Api<AuthProxyOptions> API;
    @KeepForSdk
    public static final ProxyApi ProxyApi;

    /* renamed from: a  reason: collision with root package name */
    private static final Api.ClientKey<zzak> f19632a;

    /* renamed from: b  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzak, AuthProxyOptions> f19633b;

    static {
        Api.ClientKey<zzak> clientKey = new Api.ClientKey<>();
        f19632a = clientKey;
        zza zzaVar = new zza();
        f19633b = zzaVar;
        API = new Api<>("Auth.PROXY_API", zzaVar, clientKey);
        ProxyApi = new zzar();
    }
}
