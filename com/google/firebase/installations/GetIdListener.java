package com.google.firebase.installations;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.installations.local.PersistedInstallationEntry;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class GetIdListener implements StateListener {

    /* renamed from: a  reason: collision with root package name */
    final TaskCompletionSource<String> f31537a;

    public GetIdListener(TaskCompletionSource<String> taskCompletionSource) {
        this.f31537a = taskCompletionSource;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean a(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && !persistedInstallationEntry.isErrored()) {
            return false;
        }
        this.f31537a.trySetResult(persistedInstallationEntry.getFirebaseInstallationId());
        return true;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onException(Exception exc) {
        return false;
    }
}
