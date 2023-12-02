package com.google.android.gms.wearable;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageClient;
import com.google.android.gms.wearable.internal.zzbc;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class WearableListenerService extends Service implements DataApi.DataListener, MessageApi.MessageListener, CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, MessageClient.RpcService {
    @NonNull
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";

    /* renamed from: a  reason: collision with root package name */
    private ComponentName f22649a;

    /* renamed from: b  reason: collision with root package name */
    private zzn f22650b;

    /* renamed from: c  reason: collision with root package name */
    private IBinder f22651c;

    /* renamed from: d  reason: collision with root package name */
    private Intent f22652d;

    /* renamed from: e  reason: collision with root package name */
    private Looper f22653e;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22655g;

    /* renamed from: f  reason: collision with root package name */
    private final Object f22654f = new Object();

    /* renamed from: h  reason: collision with root package name */
    private zzbc f22656h = new zzbc(new zzk(this, null));

    @NonNull
    public Looper getLooper() {
        if (this.f22653e == null) {
            HandlerThread handlerThread = new HandlerThread("WearableListenerService");
            handlerThread.start();
            this.f22653e = handlerThread.getLooper();
        }
        return this.f22653e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(@NonNull Intent intent) {
        String action;
        char c4;
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        switch (action.hashCode()) {
            case -1487371046:
                if (action.equals("com.google.android.gms.wearable.CAPABILITY_CHANGED")) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case -1140095138:
                if (action.equals(MessageClient.ACTION_REQUEST_RECEIVED)) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case -786751258:
                if (action.equals("com.google.android.gms.wearable.MESSAGE_RECEIVED")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 915816236:
                if (action.equals("com.google.android.gms.wearable.DATA_CHANGED")) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case 1003809169:
                if (action.equals("com.google.android.gms.wearable.CHANNEL_EVENT")) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case 1460975593:
                if (action.equals(BIND_LISTENER_INTENT_ACTION)) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        if (c4 != 0 && c4 != 1 && c4 != 2 && c4 != 3 && c4 != 4 && c4 != 5) {
            if (Log.isLoggable("WearableLS", 3)) {
                String obj = intent.toString();
                StringBuilder sb = new StringBuilder();
                sb.append("onBind: Provided bind intent (");
                sb.append(obj);
                sb.append(") is not allowed");
            }
            return null;
        }
        return this.f22651c;
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelClosed(@NonNull Channel channel, int i4, int i5) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelOpened(@NonNull Channel channel) {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f22649a = new ComponentName(this, getClass().getName());
        if (Log.isLoggable("WearableLS", 3)) {
            "onCreate: ".concat(String.valueOf(this.f22649a));
        }
        this.f22650b = new zzn(this, getLooper());
        Intent intent = new Intent(BIND_LISTENER_INTENT_ACTION);
        this.f22652d = intent;
        intent.setComponent(this.f22649a);
        this.f22651c = new zzaa(this, null);
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            "onDestroy: ".concat(String.valueOf(this.f22649a));
        }
        synchronized (this.f22654f) {
            this.f22655g = true;
            zzn zznVar = this.f22650b;
            if (zznVar != null) {
                zznVar.a();
            } else {
                String valueOf = String.valueOf(this.f22649a);
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=" + valueOf);
            }
        }
        super.onDestroy();
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onInputClosed(@NonNull Channel channel, int i4, int i5) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onOutputClosed(@NonNull Channel channel, int i4, int i5) {
    }

    @Override // com.google.android.gms.wearable.MessageClient.RpcService
    @Nullable
    @ShowFirstParty
    public Task<byte[]> onRequest(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        return null;
    }

    public void onChannelClosed(@NonNull ChannelClient.Channel channel, int i4, int i5) {
    }

    public void onChannelOpened(@NonNull ChannelClient.Channel channel) {
    }

    public void onInputClosed(@NonNull ChannelClient.Channel channel, int i4, int i5) {
    }

    public void onOutputClosed(@NonNull ChannelClient.Channel channel, int i4, int i5) {
    }

    public void onCapabilityChanged(@NonNull CapabilityInfo capabilityInfo) {
    }

    public void onConnectedNodes(@NonNull List<Node> list) {
    }

    @Override // com.google.android.gms.wearable.DataApi.DataListener
    public void onDataChanged(@NonNull DataEventBuffer dataEventBuffer) {
    }

    @ShowFirstParty
    public void onEntityUpdate(zza zzaVar) {
    }

    public void onMessageReceived(@NonNull MessageEvent messageEvent) {
    }

    @ShowFirstParty
    public void onNotificationReceived(zzb zzbVar) {
    }

    public void onPeerConnected(@NonNull Node node) {
    }

    public void onPeerDisconnected(@NonNull Node node) {
    }
}
