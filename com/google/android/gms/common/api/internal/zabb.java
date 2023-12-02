package com.google.android.gms.common.api.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabb implements ResultCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f20186a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f20187b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ GoogleApiClient f20188c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zabe f20189d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabb(zabe zabeVar, StatusPendingResult statusPendingResult, boolean z3, GoogleApiClient googleApiClient) {
        this.f20189d = zabeVar;
        this.f20186a = statusPendingResult;
        this.f20187b = z3;
        this.f20188c = googleApiClient;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void onResult(@NonNull Result result) {
        Context context;
        Status status = (Status) result;
        context = this.f20189d.f20196f;
        Storage.getInstance(context).zac();
        if (status.isSuccess() && this.f20189d.isConnected()) {
            zabe zabeVar = this.f20189d;
            zabeVar.disconnect();
            zabeVar.connect();
        }
        this.f20186a.setResult(status);
        if (this.f20187b) {
            this.f20188c.disconnect();
        }
    }
}
