package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataItem;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzcq implements DataApi.DataItemResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22734a;

    /* renamed from: b  reason: collision with root package name */
    private final DataItem f22735b;

    public zzcq(Status status, DataItem dataItem) {
        this.f22734a = status;
        this.f22735b = dataItem;
    }

    @Override // com.google.android.gms.wearable.DataApi.DataItemResult
    public final DataItem getDataItem() {
        return this.f22735b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22734a;
    }
}
