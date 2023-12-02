package com.google.android.gms.internal.nearby;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzff {
    private final Class zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzff(GoogleApi googleApi, @Nullable Api.ApiOptions apiOptions) {
        this.zza = googleApi.getClass();
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof zzff) || !Objects.equal(this.zza, ((zzff) obj).zza) || !Objects.equal(null, null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null);
    }
}
