package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzbc implements ChannelApi.ChannelListener {

    /* renamed from: a  reason: collision with root package name */
    private final ChannelClient.ChannelCallback f22683a;

    public zzbc(ChannelClient.ChannelCallback channelCallback) {
        this.f22683a = channelCallback;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbc.class == obj.getClass()) {
            return this.f22683a.equals(((zzbc) obj).f22683a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f22683a.hashCode();
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelClosed(Channel channel, int i4, int i5) {
        this.f22683a.onChannelClosed(zzbd.b(channel), i4, i5);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelOpened(Channel channel) {
        this.f22683a.onChannelOpened(zzbd.b(channel));
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onInputClosed(Channel channel, int i4, int i5) {
        this.f22683a.onInputClosed(zzbd.b(channel), i4, i5);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onOutputClosed(Channel channel, int i4, int i5) {
        this.f22683a.onOutputClosed(zzbd.b(channel), i4, i5);
    }
}
