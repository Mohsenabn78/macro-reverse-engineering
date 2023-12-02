package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zag<R extends Result> extends BasePendingResult<R> {

    /* renamed from: a  reason: collision with root package name */
    private final Result f20354a;

    public zag(GoogleApiClient googleApiClient, Result result) {
        super(googleApiClient);
        this.f20354a = result;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R createFailedResult(Status status) {
        return (R) this.f20354a;
    }
}
