package com.google.android.gms.auth.account;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.tasks.Task;

/* loaded from: classes4.dex */
public class WorkAccountClient extends GoogleApi<Api.ApiOptions.NoOptions> {

    /* renamed from: a  reason: collision with root package name */
    private final WorkAccountApi f19623a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkAccountClient(@NonNull Context context) {
        super(context, WorkAccount.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.f19623a = new zzh();
    }

    public Task<Account> addWorkAccount(String str) {
        return PendingResultUtil.toTask(this.f19623a.addWorkAccount(asGoogleApiClient(), str), new zzg(this));
    }

    public Task<Void> removeWorkAccount(Account account) {
        return PendingResultUtil.toVoidTask(this.f19623a.removeWorkAccount(asGoogleApiClient(), account));
    }

    public Task<Void> setWorkAuthenticatorEnabled(boolean z3) {
        return PendingResultUtil.toVoidTask(this.f19623a.setWorkAuthenticatorEnabledWithResult(asGoogleApiClient(), z3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkAccountClient(@NonNull Activity activity) {
        super(activity, (Api<Api.ApiOptions>) WorkAccount.API, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.f19623a = new zzh();
    }
}
