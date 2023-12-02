package com.google.android.gms.wearable;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzan;
import com.google.android.gms.wearable.internal.zzau;
import com.google.android.gms.wearable.internal.zzbd;
import com.google.android.gms.wearable.internal.zzce;
import com.google.android.gms.wearable.internal.zzct;
import com.google.android.gms.wearable.internal.zzdb;
import com.google.android.gms.wearable.internal.zzfl;
import com.google.android.gms.wearable.internal.zzfw;
import com.google.android.gms.wearable.internal.zzgd;
import com.google.android.gms.wearable.internal.zzgl;
import com.google.android.gms.wearable.internal.zzhk;
import com.google.android.gms.wearable.internal.zziw;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public class Wearable {
    @NonNull
    @Deprecated
    public static final Api<WearableOptions> API;

    /* renamed from: a  reason: collision with root package name */
    private static final Api.ClientKey f22644a;

    /* renamed from: b  reason: collision with root package name */
    private static final Api.AbstractClientBuilder f22645b;
    @NonNull
    @Deprecated
    public static final DataApi DataApi = new zzct();
    @NonNull
    @Deprecated
    public static final CapabilityApi CapabilityApi = new zzah();
    @NonNull
    @Deprecated
    public static final MessageApi MessageApi = new zzfl();
    @NonNull
    @Deprecated
    public static final NodeApi NodeApi = new zzgd();
    @NonNull
    @Deprecated
    public static final ChannelApi ChannelApi = new zzau();
    @ShowFirstParty
    @Deprecated
    public static final com.google.android.gms.wearable.internal.zzk zza = new com.google.android.gms.wearable.internal.zzk();
    @ShowFirstParty
    @Deprecated
    public static final com.google.android.gms.wearable.internal.zzh zzb = new com.google.android.gms.wearable.internal.zzh();
    @ShowFirstParty
    @Deprecated
    public static final zzce zzc = new zzce();
    @ShowFirstParty
    @Deprecated
    public static final zzhk zzd = new zzhk();
    @ShowFirstParty
    @Deprecated
    public static final zziw zze = new zziw();

    /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
    /* loaded from: classes4.dex */
    public static final class WearableOptions implements Api.ApiOptions.Optional {

        /* renamed from: b  reason: collision with root package name */
        static final WearableOptions f22646b = new WearableOptions(new Builder());

        /* renamed from: a  reason: collision with root package name */
        private final Looper f22647a;

        /* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
        /* loaded from: classes4.dex */
        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            private Looper f22648a;

            @NonNull
            public WearableOptions build() {
                return new WearableOptions(this);
            }

            @NonNull
            public Builder setLooper(@NonNull Looper looper) {
                this.f22648a = looper;
                return this;
            }
        }

        private WearableOptions(Builder builder) {
            this.f22647a = builder.f22648a;
        }

        static /* bridge */ /* synthetic */ GoogleApi.Settings a(WearableOptions wearableOptions) {
            if (wearableOptions.f22647a != null) {
                return new GoogleApi.Settings.Builder().setLooper(wearableOptions.f22647a).build();
            }
            return GoogleApi.Settings.DEFAULT_SETTINGS;
        }

        public boolean equals(@Nullable Object obj) {
            return obj instanceof WearableOptions;
        }

        public int hashCode() {
            return Objects.hashCode(WearableOptions.class);
        }
    }

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f22644a = clientKey;
        zzh zzhVar = new zzh();
        f22645b = zzhVar;
        API = new Api<>("Wearable.API", zzhVar, clientKey);
    }

    private Wearable() {
    }

    @NonNull
    public static CapabilityClient getCapabilityClient(@NonNull Activity activity) {
        return new zzan(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static ChannelClient getChannelClient(@NonNull Activity activity) {
        return new zzbd(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static DataClient getDataClient(@NonNull Activity activity) {
        return new zzdb(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static MessageClient getMessageClient(@NonNull Activity activity) {
        return new zzfw(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static NodeClient getNodeClient(@NonNull Activity activity) {
        return new zzgl(activity, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static CapabilityClient getCapabilityClient(@NonNull Activity activity, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzan(activity, WearableOptions.a(wearableOptions));
    }

    @NonNull
    public static ChannelClient getChannelClient(@NonNull Activity activity, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzbd(activity, WearableOptions.a(wearableOptions));
    }

    @NonNull
    public static DataClient getDataClient(@NonNull Activity activity, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzdb(activity, WearableOptions.a(wearableOptions));
    }

    @NonNull
    public static MessageClient getMessageClient(@NonNull Activity activity, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzfw(activity, WearableOptions.a(wearableOptions));
    }

    @NonNull
    public static NodeClient getNodeClient(@NonNull Activity activity, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzgl(activity, WearableOptions.a(wearableOptions));
    }

    @NonNull
    public static CapabilityClient getCapabilityClient(@NonNull Context context) {
        return new zzan(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static ChannelClient getChannelClient(@NonNull Context context) {
        return new zzbd(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static DataClient getDataClient(@NonNull Context context) {
        return new zzdb(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static MessageClient getMessageClient(@NonNull Context context) {
        return new zzfw(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static NodeClient getNodeClient(@NonNull Context context) {
        return new zzgl(context, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @NonNull
    public static CapabilityClient getCapabilityClient(@NonNull Context context, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzan(context, WearableOptions.a(wearableOptions));
    }

    @NonNull
    public static ChannelClient getChannelClient(@NonNull Context context, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzbd(context, WearableOptions.a(wearableOptions));
    }

    @NonNull
    public static DataClient getDataClient(@NonNull Context context, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzdb(context, WearableOptions.a(wearableOptions));
    }

    @NonNull
    public static MessageClient getMessageClient(@NonNull Context context, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzfw(context, WearableOptions.a(wearableOptions));
    }

    @NonNull
    public static NodeClient getNodeClient(@NonNull Context context, @NonNull WearableOptions wearableOptions) {
        Preconditions.checkNotNull(wearableOptions, "options must not be null");
        return new zzgl(context, WearableOptions.a(wearableOptions));
    }
}
