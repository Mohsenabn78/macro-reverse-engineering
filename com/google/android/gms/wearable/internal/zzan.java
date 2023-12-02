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
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityClient;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzan extends CapabilityClient {
    public static final /* synthetic */ int zza = 0;

    /* renamed from: a  reason: collision with root package name */
    private final CapabilityApi f22671a;

    public zzan(@NonNull Activity activity, @NonNull GoogleApi.Settings settings) {
        super(activity, settings);
        this.f22671a = new zzah();
    }

    private final Task a(final ListenerHolder listenerHolder, final CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, final IntentFilter[] intentFilterArr) {
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(listenerHolder).register(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzak
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzim) obj).zzp(new zzhj((TaskCompletionSource) obj2), CapabilityClient.OnCapabilityChangedListener.this, listenerHolder, intentFilterArr);
            }
        }).unregister(new RemoteCall() { // from class: com.google.android.gms.wearable.internal.zzal
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                ((zzim) obj).zzx(new zzhi((TaskCompletionSource) obj2), CapabilityClient.OnCapabilityChangedListener.this);
            }
        }).setMethodKey(24013).build());
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> addListener(@NonNull CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, @NonNull Uri uri, int i4) {
        boolean z3;
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(uri, "uri must not be null");
        if (i4 != 0) {
            if (i4 != 1) {
                z3 = false;
                Preconditions.checkArgument(z3, "invalid filter type");
                return a(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener"), onCapabilityChangedListener, new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.CAPABILITY_CHANGED", uri, i4)});
            }
            i4 = 1;
        }
        z3 = true;
        Preconditions.checkArgument(z3, "invalid filter type");
        return a(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener"), onCapabilityChangedListener, new IntentFilter[]{zzhl.zzb("com.google.android.gms.wearable.CAPABILITY_CHANGED", uri, i4)});
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> addLocalCapability(@NonNull String str) {
        Asserts.checkNotNull(str, "capability must not be null");
        CapabilityApi capabilityApi = this.f22671a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toVoidTask(asGoogleApiClient.enqueue(new zzx((zzah) capabilityApi, asGoogleApiClient, str)));
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Map<String, CapabilityInfo>> getAllCapabilities(int i4) {
        CapabilityApi capabilityApi = this.f22671a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        boolean z3 = true;
        if (i4 != 0) {
            if (i4 == 1) {
                i4 = 1;
            } else {
                z3 = false;
            }
        }
        Preconditions.checkArgument(z3);
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzw((zzah) capabilityApi, asGoogleApiClient, i4)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzaj
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((CapabilityApi.GetAllCapabilitiesResult) result).getAllCapabilities();
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<CapabilityInfo> getCapability(@NonNull String str, int i4) {
        Asserts.checkNotNull(str, "capability must not be null");
        CapabilityApi capabilityApi = this.f22671a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        boolean z3 = true;
        if (i4 != 0) {
            if (i4 == 1) {
                i4 = 1;
            } else {
                z3 = false;
            }
        }
        Preconditions.checkArgument(z3);
        return PendingResultUtil.toTask(asGoogleApiClient.enqueue(new zzv((zzah) capabilityApi, asGoogleApiClient, str, i4)), new PendingResultUtil.ResultConverter() { // from class: com.google.android.gms.wearable.internal.zzai
            @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
            public final Object convert(Result result) {
                return ((CapabilityApi.GetCapabilityResult) result).getCapability();
            }
        });
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Boolean> removeListener(@NonNull CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener) {
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener").getListenerKey(), "Key must not be null"), 24003);
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> removeLocalCapability(@NonNull String str) {
        Asserts.checkNotNull(str, "capability must not be null");
        CapabilityApi capabilityApi = this.f22671a;
        GoogleApiClient asGoogleApiClient = asGoogleApiClient();
        return PendingResultUtil.toVoidTask(asGoogleApiClient.enqueue(new zzy((zzah) capabilityApi, asGoogleApiClient, str)));
    }

    public zzan(@NonNull Context context, @NonNull GoogleApi.Settings settings) {
        super(context, settings);
        this.f22671a = new zzah();
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Boolean> removeListener(@NonNull CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, String str) {
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(str, "capability must not be null");
        if (!str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str = RemoteSettings.FORWARD_SLASH_STRING.concat(str);
        }
        return doUnregisterEventListener((ListenerHolder.ListenerKey) Preconditions.checkNotNull(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener:".concat(String.valueOf(str))).getListenerKey(), "Key must not be null"), 24003);
    }

    @Override // com.google.android.gms.wearable.CapabilityClient
    public final Task<Void> addListener(@NonNull CapabilityClient.OnCapabilityChangedListener onCapabilityChangedListener, @NonNull String str) {
        Asserts.checkNotNull(onCapabilityChangedListener, "listener must not be null");
        Asserts.checkNotNull(str, "capability must not be null");
        IntentFilter zza2 = zzhl.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED");
        if (!str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str = RemoteSettings.FORWARD_SLASH_STRING.concat(str);
        }
        zza2.addDataPath(str, 0);
        return a(ListenerHolders.createListenerHolder(onCapabilityChangedListener, getLooper(), "CapabilityListener:".concat(String.valueOf(str))), new zzam(onCapabilityChangedListener, str), new IntentFilter[]{zza2});
    }
}
