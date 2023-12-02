package com.google.firebase.appindexing.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.firebase.FirebaseExceptionMapper;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
final class zzr extends GoogleApi<Api.ApiOptions.NoOptions> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(Context context) {
        super(context, com.google.android.gms.internal.icing.zze.zzb, Api.ApiOptions.NO_OPTIONS, new FirebaseExceptionMapper());
    }
}
