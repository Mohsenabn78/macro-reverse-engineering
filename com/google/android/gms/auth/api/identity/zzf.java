package com.google.android.gms.auth.api.identity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public class zzf implements Api.ApiOptions.Optional {

    /* renamed from: a  reason: collision with root package name */
    private final String f19786a;

    /* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
    /* loaded from: classes4.dex */
    public static class zzc {

        /* renamed from: a  reason: collision with root package name */
        private String f19787a;

        private zzc() {
        }

        public static zzc zzc(zzf zzfVar) {
            zzc zzcVar = new zzc();
            String zzh = zzfVar.zzh();
            if (zzh != null) {
                zzcVar.zze(zzh);
            }
            return zzcVar;
        }

        public final zzc zze(@NonNull String str) {
            this.f19787a = Preconditions.checkNotEmpty(str);
            return this;
        }

        public final zzf zzi() {
            return new zzf(this.f19787a);
        }
    }

    public zzf(String str) {
        this.f19786a = str;
    }

    public static zzc zzg() {
        return new zzc();
    }

    public boolean equals(@Nullable Object obj) {
        return obj instanceof zzf;
    }

    public int hashCode() {
        return Objects.hashCode(zzf.class);
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("session_id", this.f19786a);
        return bundle;
    }

    public final String zzh() {
        return this.f19786a;
    }
}
