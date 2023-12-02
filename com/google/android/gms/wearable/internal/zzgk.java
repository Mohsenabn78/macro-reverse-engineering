package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzgk implements Result {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22785a;

    /* renamed from: b  reason: collision with root package name */
    private final String f22786b;

    public zzgk(Status status, String str) {
        this.f22785a = status;
        this.f22786b = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22785a;
    }

    public final String zza() {
        return this.f22786b;
    }
}
