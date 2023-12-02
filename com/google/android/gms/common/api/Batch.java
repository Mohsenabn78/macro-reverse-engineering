package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class Batch extends BasePendingResult<BatchResult> {

    /* renamed from: a  reason: collision with root package name */
    private int f19993a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19994b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19995c;

    /* renamed from: d  reason: collision with root package name */
    private final PendingResult[] f19996d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f19997e;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final List f19998a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final GoogleApiClient f19999b;

        public Builder(@NonNull GoogleApiClient googleApiClient) {
            this.f19999b = googleApiClient;
        }

        @NonNull
        @ResultIgnorabilityUnspecified
        public <R extends Result> BatchResultToken<R> add(@NonNull PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.f19998a.size());
            this.f19998a.add(pendingResult);
            return batchResultToken;
        }

        @NonNull
        public Batch build() {
            return new Batch(this.f19998a, this.f19999b, null);
        }
    }

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zac zacVar) {
        super(googleApiClient);
        this.f19997e = new Object();
        int size = list.size();
        this.f19993a = size;
        PendingResult[] pendingResultArr = new PendingResult[size];
        this.f19996d = pendingResultArr;
        if (!list.isEmpty()) {
            for (int i4 = 0; i4 < list.size(); i4++) {
                PendingResult pendingResult = (PendingResult) list.get(i4);
                this.f19996d[i4] = pendingResult;
                pendingResult.addStatusListener(new zab(this));
            }
            return;
        }
        setResult(new BatchResult(Status.RESULT_SUCCESS, pendingResultArr));
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        for (PendingResult pendingResult : this.f19996d) {
            pendingResult.cancel();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    @NonNull
    public BatchResult createFailedResult(@NonNull Status status) {
        return new BatchResult(status, this.f19996d);
    }
}
