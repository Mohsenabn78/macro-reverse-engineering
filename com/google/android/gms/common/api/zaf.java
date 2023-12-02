package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zaf<R extends Result> extends BasePendingResult<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Result f20353a;

    public zaf(Result result) {
        super(Looper.getMainLooper());
        this.f20353a = result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R createFailedResult(Status status) {
        if (status.getStatusCode() == this.f20353a.getStatus().getStatusCode()) {
            return (R) this.f20353a;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
