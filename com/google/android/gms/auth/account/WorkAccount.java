package com.google.android.gms.auth.account;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzr;

/* loaded from: classes4.dex */
public class WorkAccount {
    public static final Api<Api.ApiOptions.NoOptions> API;
    @Deprecated
    public static final WorkAccountApi WorkAccountApi;

    /* renamed from: a  reason: collision with root package name */
    private static final Api.ClientKey<zzr> f19621a;

    /* renamed from: b  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzr, Api.ApiOptions.NoOptions> f19622b;

    static {
        Api.ClientKey<zzr> clientKey = new Api.ClientKey<>();
        f19621a = clientKey;
        zzf zzfVar = new zzf();
        f19622b = zzfVar;
        API = new Api<>("WorkAccount.API", zzfVar, clientKey);
        WorkAccountApi = new zzh();
    }

    private WorkAccount() {
    }

    public static WorkAccountClient getClient(@NonNull Activity activity) {
        return new WorkAccountClient(activity);
    }

    public static WorkAccountClient getClient(@NonNull Context context) {
        return new WorkAccountClient(context);
    }
}
