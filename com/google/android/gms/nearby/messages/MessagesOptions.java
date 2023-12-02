package com.google.android.gms.nearby.messages;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class MessagesOptions implements Api.ApiOptions.Optional {
    public final int zzc;
    @Nullable
    public final String zza = null;
    public final boolean zzb = false;
    @NonNull
    public final String zzd = null;
    @NonNull
    public final String zze = null;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int f22390a = -1;

        @NonNull
        public MessagesOptions build() {
            return new MessagesOptions(this, null);
        }

        @NonNull
        public Builder setPermissions(int i4) {
            this.f22390a = i4;
            return this;
        }
    }

    /* synthetic */ MessagesOptions(Builder builder, zzd zzdVar) {
        this.zzc = builder.f22390a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessagesOptions)) {
            return false;
        }
        MessagesOptions messagesOptions = (MessagesOptions) obj;
        String str = messagesOptions.zza;
        if (Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && this.zzc == messagesOptions.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(null, Boolean.FALSE, null, null, Integer.valueOf(this.zzc));
    }
}
