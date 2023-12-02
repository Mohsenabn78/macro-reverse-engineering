package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzac implements CapabilityInfo {

    /* renamed from: a  reason: collision with root package name */
    private final String f22662a;

    /* renamed from: b  reason: collision with root package name */
    private final Set f22663b;

    public zzac(CapabilityInfo capabilityInfo) {
        String name = capabilityInfo.getName();
        Set<Node> nodes = capabilityInfo.getNodes();
        this.f22662a = name;
        this.f22663b = nodes;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final String getName() {
        return this.f22662a;
    }

    @Override // com.google.android.gms.wearable.CapabilityInfo
    public final Set<Node> getNodes() {
        return this.f22663b;
    }
}
