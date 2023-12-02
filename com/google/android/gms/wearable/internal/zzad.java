package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityInfo;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzad implements CapabilityApi.GetAllCapabilitiesResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22664a;

    /* renamed from: b  reason: collision with root package name */
    private final Map f22665b;

    public zzad(Status status, Map map) {
        this.f22664a = status;
        this.f22665b = map;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult
    public final Map<String, CapabilityInfo> getAllCapabilities() {
        return this.f22665b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22664a;
    }
}
