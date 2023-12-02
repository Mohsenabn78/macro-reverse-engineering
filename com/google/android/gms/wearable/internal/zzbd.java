package com.google.android.gms.wearable.internal;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzbd extends ChannelClient {
    public static final /* synthetic */ int zza = 0;

    /* renamed from: a */
    private final zzau f22684a;

    public zzbd(@NonNull Activity activity, @NonNull GoogleApi.Settings settings) {
        super(activity, settings);
        this.f22684a = new zzau();
    }

    public static /* bridge */ /* synthetic */ zzbq b(Channel channel) {
        return d(channel);
    }

    private static zzbq c(@NonNull ChannelClient.Channel channel) {
        Preconditions.checkNotNull(channel, "channel must not be null");
        return (zzbq) channel;
    }

    public static zzbq d(@NonNull Channel channel) {
        Preconditions.checkNotNull(channel, "channel must not be null");
        return (zzbq) channel;
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> close(@NonNull ChannelClient.Channel channel) {
        zzbq c4 = c(channel);
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toVoidTask(asGoogleApiClient.enqueue(new zzbh(c4, asGoogleApiClient)));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<InputStream> getInputStream(@NonNull ChannelClient.Channel channel) {
        zzbq c4 = c(channel);
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzbj(c4, asGoogleApiClient)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzaw
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((Channel.GetInputStreamResult) result).getInputStream();
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<OutputStream> getOutputStream(@NonNull ChannelClient.Channel channel) {
        zzbq c4 = c(channel);
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzbk(c4, asGoogleApiClient)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzbb
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((Channel.GetOutputStreamResult) result).getOutputStream();
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<ChannelClient.Channel> openChannel(@NonNull String str, @NonNull String str2) {
        zzau zzauVar = this.f22684a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Preconditions.checkNotNull(asGoogleApiClient, "client is null");
        Preconditions.checkNotNull(str, "nodeId is null");
        Preconditions.checkNotNull(str2, "path is null");
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzaq(zzauVar, asGoogleApiClient, str, str2)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzav
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                ChannelClient.Channel d4;
                d4 = zzbd.d(((ChannelApi.OpenChannelResult) result).getChannel());
                return d4;
            }
        });
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> receiveFile(@NonNull ChannelClient.Channel channel, @NonNull Uri uri, boolean z3) {
        zzbq c4 = c(channel);
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        Preconditions.checkNotNull(asGoogleApiClient, "client is null");
        Preconditions.checkNotNull(uri, "uri is null");
        return PendingResultUtil.toVoidTask(asGoogleApiClient.enqueue(new zzbl(c4, asGoogleApiClient, uri, z3)));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> registerChannelCallback(@NonNull ChannelClient.Channel channel, @NonNull ChannelClient.ChannelCallback channelCallback) {
        final String zzb = ((zzbq) channel).zzb();
        Preconditions.checkNotNull(channelCallback, "listener is null");
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener:".concat(String.valueOf(zzb)));
        final IntentFilter[] intentFilterArr = {zzhl.zza("com.google.android.gms.wearable.CHANNEL_EVENT")};
        final zzbc zzbcVar = new zzbc(channelCallback);
        final ListenerHolder createListenerHolder2 = ListenerHolders.createListenerHolder(zzbcVar, getLooper(), "ChannelListener");
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(createListenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzaz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzim) obj).zzq(new zzhj((TaskCompletionSource) obj2), zzbc.this, createListenerHolder2, zzb, intentFilterArr);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzba
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzim) obj).zzy(new zzhi((TaskCompletionSource) obj2), zzbc.this, zzb);
            }
        }).setMethodKey(24014).build());
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> sendFile(@NonNull ChannelClient.Channel channel, @NonNull Uri uri) {
        return PendingResultUtil.toVoidTask(c(channel).sendFile(asGoogleApiClient(), uri, 0L, -1L));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Boolean> unregisterChannelCallback(@NonNull ChannelClient.Channel channel, @NonNull ChannelClient.ChannelCallback channelCallback) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener:".concat(String.valueOf(c(channel).zzb()))).getListenerKey(), "Key must not be null"), 24004);
    }

    public zzbd(@NonNull Context context, @NonNull GoogleApi.Settings settings) {
        super(context, settings);
        this.f22684a = new zzau();
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> sendFile(@NonNull ChannelClient.Channel channel, @NonNull Uri uri, long j4, long j5) {
        return PendingResultUtil.toVoidTask(c(channel).sendFile(asGoogleApiClient(), uri, j4, j5));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> close(@NonNull ChannelClient.Channel channel, int i4) {
        zzbq c4 = c(channel);
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toVoidTask(asGoogleApiClient.enqueue(new zzbi(c4, asGoogleApiClient, i4)));
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Boolean> unregisterChannelCallback(@NonNull ChannelClient.ChannelCallback channelCallback) {
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener").getListenerKey(), "Key must not be null"), 24004);
    }

    @Override // com.google.android.gms.wearable.ChannelClient
    public final Task<Void> registerChannelCallback(@NonNull ChannelClient.ChannelCallback channelCallback) {
        Preconditions.checkNotNull(channelCallback, "listener is null");
        ListenerHolder createListenerHolder = ListenerHolders.createListenerHolder(channelCallback, getLooper(), "ChannelListener");
        final IntentFilter[] intentFilterArr = {zzhl.zza("com.google.android.gms.wearable.CHANNEL_EVENT")};
        final zzbc zzbcVar = new zzbc(channelCallback);
        final ListenerHolder createListenerHolder2 = ListenerHolders.createListenerHolder(zzbcVar, getLooper(), "ChannelListener");
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(createListenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzax
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzim) obj).zzq(new zzhj((TaskCompletionSource) obj2), zzbc.this, createListenerHolder2, null, intentFilterArr);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzay
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzim) obj).zzy(new zzhi((TaskCompletionSource) obj2), zzbc.this, null);
            }
        }).setMethodKey(24014).build());
    }
}
