package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public final class ApiKey<O extends Api.ApiOptions> {

    /* renamed from: a  reason: collision with root package name */
    private final int f20037a;

    /* renamed from: b  reason: collision with root package name */
    private final Api f20038b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Api.ApiOptions f20039c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f20040d;

    private ApiKey(Api api, @Nullable Api.ApiOptions apiOptions, @Nullable String str) {
        this.f20038b = api;
        this.f20039c = apiOptions;
        this.f20040d = str;
        this.f20037a = Objects.hashCode(api, apiOptions, str);
    }

    @NonNull
    @KeepForSdk
    public static <O extends Api.ApiOptions> ApiKey<O> getSharedApiKey(@NonNull Api<O> api, @Nullable O o4, @Nullable String str) {
        return new ApiKey<>(api, o4, str);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        if (!Objects.equal(this.f20038b, apiKey.f20038b) || !Objects.equal(this.f20039c, apiKey.f20039c) || !Objects.equal(this.f20040d, apiKey.f20040d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f20037a;
    }

    @NonNull
    public final String zaa() {
        return this.f20038b.zad();
    }
}
