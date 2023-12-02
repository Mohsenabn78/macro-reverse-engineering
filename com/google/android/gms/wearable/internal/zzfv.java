package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzfv implements Result {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22772a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f22773b;

    public zzfv(Status status, int i4, byte[] bArr) {
        this.f22772a = status;
        this.f22773b = bArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22772a;
    }

    public final byte[] zza() {
        return this.f22773b;
    }
}
