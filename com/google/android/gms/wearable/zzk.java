package com.google.android.gms.wearable;

import androidx.annotation.NonNull;
import com.google.android.gms.wearable.ChannelClient;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzk extends ChannelClient.ChannelCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WearableListenerService f22867a;

    @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
    public final void onChannelClosed(@NonNull ChannelClient.Channel channel, int i4, int i5) {
        this.f22867a.onChannelClosed(channel, i4, i5);
    }

    @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
    public final void onChannelOpened(@NonNull ChannelClient.Channel channel) {
        this.f22867a.onChannelOpened(channel);
    }

    @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
    public final void onInputClosed(@NonNull ChannelClient.Channel channel, int i4, int i5) {
        this.f22867a.onInputClosed(channel, i4, i5);
    }

    @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
    public final void onOutputClosed(@NonNull ChannelClient.Channel channel, int i4, int i5) {
        this.f22867a.onOutputClosed(channel, i4, i5);
    }
}
