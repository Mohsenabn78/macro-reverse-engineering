package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabu implements BaseGmsClient.ConnectionProgressReportCallbacks, zacs {

    /* renamed from: a  reason: collision with root package name */
    private final Api.Client f20257a;

    /* renamed from: b  reason: collision with root package name */
    private final ApiKey f20258b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private IAccountAccessor f20259c = null;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Set f20260d = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f20261e = false;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ GoogleApiManager f20262f;

    public zabu(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.f20262f = googleApiManager;
        this.f20257a = client;
        this.f20258b = apiKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public final void e() {
        IAccountAccessor iAccountAccessor;
        if (this.f20261e && (iAccountAccessor = this.f20259c) != null) {
            this.f20257a.getRemoteService(iAccountAccessor, this.f20260d);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
        Handler handler;
        handler = this.f20262f.f20065n;
        handler.post(new zabt(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    @WorkerThread
    public final void zae(ConnectionResult connectionResult) {
        Map map;
        map = this.f20262f.f20061j;
        zabq zabqVar = (zabq) map.get(this.f20258b);
        if (zabqVar != null) {
            zabqVar.zas(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacs
    @WorkerThread
    public final void zaf(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set set) {
        if (iAccountAccessor != null && set != null) {
            this.f20259c = iAccountAccessor;
            this.f20260d = set;
            e();
            return;
        }
        Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
        zae(new ConnectionResult(4));
    }
}
