package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzgc implements NodeApi.GetLocalNodeResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22781a;

    /* renamed from: b  reason: collision with root package name */
    private final Node f22782b;

    public zzgc(Status status, Node node) {
        this.f22781a = status;
        this.f22782b = node;
    }

    @Override // com.google.android.gms.wearable.NodeApi.GetLocalNodeResult
    public final Node getNode() {
        return this.f22782b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22781a;
    }
}
