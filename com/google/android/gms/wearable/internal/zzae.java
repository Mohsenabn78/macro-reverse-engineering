package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzae implements CapabilityApi.GetCapabilityResult {

    /* renamed from: a  reason: collision with root package name */
    private final CapabilityInfo f22666a;

    /* renamed from: b  reason: collision with root package name */
    private final Status f22667b;

    public zzae(Status status, CapabilityInfo capabilityInfo) {
        this.f22667b = status;
        this.f22666a = capabilityInfo;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult
    public final CapabilityInfo getCapability() {
        return this.f22666a;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22667b;
    }
}
