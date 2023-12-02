package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zacd implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    private final GoogleApiManager f20267a;

    /* renamed from: b  reason: collision with root package name */
    private final int f20268b;

    /* renamed from: c  reason: collision with root package name */
    private final ApiKey f20269c;

    /* renamed from: d  reason: collision with root package name */
    private final long f20270d;

    /* renamed from: e  reason: collision with root package name */
    private final long f20271e;

    @VisibleForTesting
    zacd(GoogleApiManager googleApiManager, int i4, ApiKey apiKey, long j4, long j5, @Nullable String str, @Nullable String str2) {
        this.f20267a = googleApiManager;
        this.f20268b = i4;
        this.f20269c = apiKey;
        this.f20270d = j4;
        this.f20271e = j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static zacd a(GoogleApiManager googleApiManager, int i4, ApiKey apiKey) {
        boolean z3;
        long j4;
        long j5;
        if (!googleApiManager.c()) {
            return null;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config != null) {
            if (!config.getMethodInvocationTelemetryEnabled()) {
                return null;
            }
            z3 = config.getMethodTimingTelemetryEnabled();
            zabq q4 = googleApiManager.q(apiKey);
            if (q4 != null) {
                if (!(q4.zaf() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) q4.zaf();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration b4 = b(q4, baseGmsClient, i4);
                    if (b4 == null) {
                        return null;
                    }
                    q4.v();
                    z3 = b4.getMethodTimingTelemetryEnabled();
                }
            }
        } else {
            z3 = true;
        }
        if (z3) {
            j4 = System.currentTimeMillis();
        } else {
            j4 = 0;
        }
        if (z3) {
            j5 = SystemClock.elapsedRealtime();
        } else {
            j5 = 0;
        }
        return new zacd(googleApiManager, i4, apiKey, j4, j5, null, null);
    }

    @Nullable
    private static ConnectionTelemetryConfiguration b(zabq zabqVar, BaseGmsClient baseGmsClient, int i4) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i4) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i4))) || zabqVar.n() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    @WorkerThread
    public final void onComplete(@NonNull Task task) {
        zabq q4;
        boolean z3;
        int i4;
        int i5;
        int i6;
        int i7;
        int errorCode;
        long j4;
        long j5;
        int i8;
        if (!this.f20267a.c()) {
            return;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (q4 = this.f20267a.q(this.f20269c)) != null && (q4.zaf() instanceof BaseGmsClient)) {
            BaseGmsClient baseGmsClient = (BaseGmsClient) q4.zaf();
            boolean z4 = true;
            if (this.f20270d > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            int gCoreServiceId = baseGmsClient.getGCoreServiceId();
            if (config != null) {
                z3 &= config.getMethodTimingTelemetryEnabled();
                int batchPeriodMillis = config.getBatchPeriodMillis();
                int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                i4 = config.getVersion();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration b4 = b(q4, baseGmsClient, this.f20268b);
                    if (b4 == null) {
                        return;
                    }
                    z4 = (!b4.getMethodTimingTelemetryEnabled() || this.f20270d <= 0) ? false : false;
                    maxMethodInvocationsInBatch = b4.getMaxMethodInvocationsLogged();
                    z3 = z4;
                }
                i5 = batchPeriodMillis;
                i6 = maxMethodInvocationsInBatch;
            } else {
                i4 = 0;
                i5 = 5000;
                i6 = 100;
            }
            GoogleApiManager googleApiManager = this.f20267a;
            if (task.isSuccessful()) {
                i7 = 0;
                errorCode = 0;
            } else {
                if (task.isCanceled()) {
                    i7 = 100;
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        Status status = ((ApiException) exception).getStatus();
                        int statusCode = status.getStatusCode();
                        ConnectionResult connectionResult = status.getConnectionResult();
                        if (connectionResult == null) {
                            i7 = statusCode;
                        } else {
                            errorCode = connectionResult.getErrorCode();
                            i7 = statusCode;
                        }
                    } else {
                        i7 = 101;
                    }
                }
                errorCode = -1;
            }
            if (z3) {
                long j6 = this.f20270d;
                j5 = System.currentTimeMillis();
                j4 = j6;
                i8 = (int) (SystemClock.elapsedRealtime() - this.f20271e);
            } else {
                j4 = 0;
                j5 = 0;
                i8 = -1;
            }
            googleApiManager.w(new MethodInvocation(this.f20268b, i7, errorCode, j4, j5, null, null, gCoreServiceId, i8), i4, i5, i6);
        }
    }
}
