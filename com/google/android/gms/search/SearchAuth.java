package com.google.android.gms.search;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.icing.zzav;
import com.google.android.gms.internal.icing.zzbc;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public class SearchAuth {
    @NonNull
    public static final Api<Api.ApiOptions.NoOptions> API;
    @NonNull
    public static final SearchAuthApi SearchAuthApi;

    /* renamed from: a  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzav, Api.ApiOptions.NoOptions> f22563a;
    @NonNull
    public static final Api.ClientKey<zzav> zza;

    /* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
    /* loaded from: classes4.dex */
    public static class StatusCodes {
        public static final int AUTH_DISABLED = 10000;
        public static final int AUTH_THROTTLED = 10001;
        public static final int DEVELOPER_ERROR = 10;
        public static final int INTERNAL_ERROR = 8;
        public static final int SUCCESS = 0;
    }

    static {
        zzb zzbVar = new zzb();
        f22563a = zzbVar;
        Api.ClientKey<zzav> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        API = new Api<>("SearchAuth.API", zzbVar, clientKey);
        SearchAuthApi = new zzbc();
    }

    private SearchAuth() {
    }
}
