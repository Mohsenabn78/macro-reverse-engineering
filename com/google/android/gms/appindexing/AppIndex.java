package com.google.android.gms.appindexing;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.icing.zzal;
import com.google.android.gms.internal.icing.zze;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@VisibleForTesting
@Deprecated
/* loaded from: classes4.dex */
public final class AppIndex {
    @NonNull
    public static final Api<Api.ApiOptions.NoOptions> API;
    @NonNull
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> APP_INDEX_API;
    @NonNull
    public static final AppIndexApi AppIndexApi;

    static {
        Api<Api.ApiOptions.NoOptions> api = zze.zzb;
        API = api;
        APP_INDEX_API = api;
        AppIndexApi = new zzal();
    }

    private AppIndex() {
    }
}
