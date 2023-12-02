package com.google.android.gms.identity.intents;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
/* loaded from: classes4.dex */
public final class Address {
    @NonNull
    public static final Api<AddressOptions> API;

    /* renamed from: a  reason: collision with root package name */
    static final Api.ClientKey<com.google.android.gms.internal.identity.zze> f20845a;

    /* renamed from: b  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.identity.zze, AddressOptions> f20846b;

    /* compiled from: com.google.android.gms:play-services-identity@@17.0.1 */
    /* loaded from: classes4.dex */
    public static final class AddressOptions implements Api.ApiOptions.HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int i4) {
            this.theme = i4;
        }
    }

    static {
        Api.ClientKey<com.google.android.gms.internal.identity.zze> clientKey = new Api.ClientKey<>();
        f20845a = clientKey;
        zza zzaVar = new zza();
        f20846b = zzaVar;
        API = new Api<>("Address.API", zzaVar, clientKey);
    }

    public static void requestUserAddress(@NonNull GoogleApiClient googleApiClient, @NonNull UserAddressRequest userAddressRequest, int i4) {
        googleApiClient.enqueue(new zzb(googleApiClient, userAddressRequest, i4));
    }
}
