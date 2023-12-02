package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class BatchResult implements Result {

    /* renamed from: a  reason: collision with root package name */
    private final Status f20000a;

    /* renamed from: b  reason: collision with root package name */
    private final PendingResult[] f20001b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchResult(Status status, PendingResult[] pendingResultArr) {
        this.f20000a = status;
        this.f20001b = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.f20000a;
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public <R extends Result> R take(@NonNull BatchResultToken<R> batchResultToken) {
        boolean z3;
        if (batchResultToken.f20002a < this.f20001b.length) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "The result token does not belong to this batch");
        return (R) this.f20001b[batchResultToken.f20002a].await(0L, TimeUnit.MILLISECONDS);
    }
}
