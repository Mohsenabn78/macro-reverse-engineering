package com.google.android.gms.common.moduleinstall.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zau extends zaa {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtomicReference f20628a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f20629b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ InstallStatusListener f20630c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zay f20631d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zau(zay zayVar, AtomicReference atomicReference, TaskCompletionSource taskCompletionSource, InstallStatusListener installStatusListener) {
        this.f20631d = zayVar;
        this.f20628a = atomicReference;
        this.f20629b = taskCompletionSource;
        this.f20630c = installStatusListener;
    }

    @Override // com.google.android.gms.common.moduleinstall.internal.zaa, com.google.android.gms.common.moduleinstall.internal.zae
    public final void zad(Status status, @Nullable ModuleInstallResponse moduleInstallResponse) {
        if (moduleInstallResponse != null) {
            this.f20628a.set(moduleInstallResponse);
        }
        TaskUtil.trySetResultOrApiException(status, null, this.f20629b);
        if (status.isSuccess() && (moduleInstallResponse == null || !moduleInstallResponse.zaa())) {
            return;
        }
        this.f20631d.doUnregisterEventListener(ListenerHolders.createListenerKey(this.f20630c, InstallStatusListener.class.getSimpleName()), 27306);
    }
}
