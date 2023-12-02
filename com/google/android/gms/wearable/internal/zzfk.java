package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzfk implements MessageApi.SendMessageResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22768a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22769b;

    public zzfk(Status status, int i4) {
        this.f22768a = status;
        this.f22769b = i4;
    }

    @Override // com.google.android.gms.wearable.MessageApi.SendMessageResult
    public final int getRequestId() {
        return this.f22769b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22768a;
    }
}
