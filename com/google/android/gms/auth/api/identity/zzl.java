package com.google.android.gms.auth.api.identity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public final class zzl implements Api.ApiOptions.Optional {

    /* renamed from: a  reason: collision with root package name */
    private final String f19788a;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class zzc {

        /* renamed from: a  reason: collision with root package name */
        private String f19789a;

        private zzc() {
        }

        public static zzc zzc(zzl zzlVar) {
            zzc zzcVar = new zzc();
            String zzh = zzlVar.zzh();
            if (zzh != null) {
                zzcVar.zzh(zzh);
            }
            return zzcVar;
        }

        public final zzc zzh(@NonNull String str) {
            this.f19789a = Preconditions.checkNotEmpty(str);
            return this;
        }

        public final zzl zzk() {
            return new zzl(this.f19789a);
        }
    }

    public zzl(String str) {
        this.f19788a = str;
    }

    public static zzc zzj() {
        return new zzc();
    }

    public final boolean equals(@Nullable Object obj) {
        return obj instanceof zzl;
    }

    public final int hashCode() {
        return Objects.hashCode(zzl.class);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("session_id", this.f19788a);
        return bundle;
    }

    public final String zzh() {
        return this.f19788a;
    }
}
