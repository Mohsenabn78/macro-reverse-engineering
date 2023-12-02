package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zaaf {

    /* renamed from: a  reason: collision with root package name */
    private final ApiKey f20135a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f20136b = new TaskCompletionSource();

    public zaaf(ApiKey apiKey) {
        this.f20135a = apiKey;
    }

    public final ApiKey a() {
        return this.f20135a;
    }

    public final TaskCompletionSource b() {
        return this.f20136b;
    }
}
