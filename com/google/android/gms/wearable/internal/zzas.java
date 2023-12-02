package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzas implements ChannelApi.OpenChannelResult {

    /* renamed from: a  reason: collision with root package name */
    private final Status f22679a;

    /* renamed from: b  reason: collision with root package name */
    private final Channel f22680b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzas(Status status, @Nullable Channel channel) {
        this.f22679a = (Status) Preconditions.checkNotNull(status);
        this.f22680b = channel;
    }

    @Override // com.google.android.gms.wearable.ChannelApi.OpenChannelResult
    @Nullable
    public final Channel getChannel() {
        return this.f22680b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f22679a;
    }
}
