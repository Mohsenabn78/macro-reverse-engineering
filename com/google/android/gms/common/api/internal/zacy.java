package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zacy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Result f20292a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zada f20293b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zacy(zada zadaVar, Result result) {
        this.f20293b = zadaVar;
        this.f20292a = result;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        WeakReference weakReference;
        zacz zaczVar;
        zacz zaczVar2;
        WeakReference weakReference2;
        GoogleApiClient googleApiClient;
        ResultTransform resultTransform;
        zacz zaczVar3;
        zacz zaczVar4;
        WeakReference weakReference3;
        try {
            try {
                ThreadLocal threadLocal = BasePendingResult.zaa;
                threadLocal.set(Boolean.TRUE);
                resultTransform = this.f20293b.f20296a;
                PendingResult onSuccess = ((ResultTransform) Preconditions.checkNotNull(resultTransform)).onSuccess(this.f20292a);
                zada zadaVar = this.f20293b;
                zaczVar3 = zadaVar.f20303h;
                zaczVar4 = zadaVar.f20303h;
                zaczVar3.sendMessage(zaczVar4.obtainMessage(0, onSuccess));
                threadLocal.set(Boolean.FALSE);
                zada zadaVar2 = this.f20293b;
                zada.m(this.f20292a);
                weakReference3 = this.f20293b.f20302g;
                googleApiClient = (GoogleApiClient) weakReference3.get();
                if (googleApiClient == null) {
                    return;
                }
            } catch (RuntimeException e4) {
                zada zadaVar3 = this.f20293b;
                zaczVar = zadaVar3.f20303h;
                zaczVar2 = zadaVar3.f20303h;
                zaczVar.sendMessage(zaczVar2.obtainMessage(1, e4));
                BasePendingResult.zaa.set(Boolean.FALSE);
                zada zadaVar4 = this.f20293b;
                zada.m(this.f20292a);
                weakReference2 = this.f20293b.f20302g;
                googleApiClient = (GoogleApiClient) weakReference2.get();
                if (googleApiClient == null) {
                    return;
                }
            }
            googleApiClient.zap(this.f20293b);
        } catch (Throwable th) {
            BasePendingResult.zaa.set(Boolean.FALSE);
            zada zadaVar5 = this.f20293b;
            zada.m(this.f20292a);
            weakReference = this.f20293b.f20302g;
            GoogleApiClient googleApiClient2 = (GoogleApiClient) weakReference.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zap(this.f20293b);
            }
            throw th;
        }
    }
}
