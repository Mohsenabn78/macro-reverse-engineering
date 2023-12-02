package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class GetAuthTokenListener implements StateListener {

    /* renamed from: a  reason: collision with root package name */
    private final Utils f31535a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource<InstallationTokenResult> f31536b;

    public GetAuthTokenListener(Utils utils, TaskCompletionSource<InstallationTokenResult> taskCompletionSource) {
        this.f31535a = utils;
        this.f31536b = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean a(PersistedInstallationEntry persistedInstallationEntry) {
        if (persistedInstallationEntry.isRegistered() && !this.f31535a.isAuthTokenExpired(persistedInstallationEntry)) {
            this.f31536b.setResult(InstallationTokenResult.builder().setToken(persistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs()).build());
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onException(Exception exc) {
        this.f31536b.trySetException(exc);
        return true;
    }
}
