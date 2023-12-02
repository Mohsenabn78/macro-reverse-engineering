package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzcr implements DataApi.DeleteDataItemsResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22736a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22737b;

    public zzcr(Status status, int i4) {
        this.f22736a = status;
        this.f22737b = i4;
    }

    @Override // com.google.android.gms.wearable.DataApi.DeleteDataItemsResult
    public final int getNumDeleted() {
        return this.f22737b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22736a;
    }
}
