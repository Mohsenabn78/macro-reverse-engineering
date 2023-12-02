package com.google.firebase.appindexing.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.icing.zzbi;
import com.google.firebase.FirebaseExceptionMapper;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
final class zzj extends GoogleApi<Api.ApiOptions.NoOptions> {
    public zzj(Context context) {
        super(context, zzf.f28822c, Api.ApiOptions.NO_OPTIONS, Looper.getMainLooper(), new FirebaseExceptionMapper());
        zzbi.zza(context);
    }
}
