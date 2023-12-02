package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzgb implements NodeApi.GetConnectedNodesResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22779a;

    /* renamed from: b  reason: collision with root package name */
    private final List f22780b;

    public zzgb(Status status, List list) {
        this.f22779a = status;
        this.f22780b = list;
    }

    @Override // com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult
    public final List<Node> getNodes() {
        return this.f22780b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22779a;
    }
}
