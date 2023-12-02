package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzhe implements ChannelApi.ChannelListener {

    /* renamed from: a  reason: collision with root package name */
    private final String f22793a;

    /* renamed from: b  reason: collision with root package name */
    private final ChannelApi.ChannelListener f22794b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhe(String str, ChannelApi.ChannelListener channelListener) {
        this.f22793a = (String) Preconditions.checkNotNull(str);
        this.f22794b = (ChannelApi.ChannelListener) Preconditions.checkNotNull(channelListener);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhe)) {
            return false;
        }
        zzhe zzheVar = (zzhe) obj;
        if (this.f22794b.equals(zzheVar.f22794b) && this.f22793a.equals(zzheVar.f22793a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.f22793a.hashCode() * 31) + this.f22794b.hashCode();
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelClosed(Channel channel, int i4, int i5) {
        this.f22794b.onChannelClosed(channel, i4, i5);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onChannelOpened(Channel channel) {
        this.f22794b.onChannelOpened(channel);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onInputClosed(Channel channel, int i4, int i5) {
        this.f22794b.onInputClosed(channel, i4, i5);
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public final void onOutputClosed(Channel channel, int i4, int i5) {
        this.f22794b.onOutputClosed(channel, i4, i5);
    }
}
