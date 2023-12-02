package com.google.mlkit.common.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.mlkit_common.zzw;
import com.google.android.gms.internal.mlkit_common.zzx;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes5.dex */
public abstract class RemoteModelSource {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f32951a;

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            return Objects.equal(this.f32951a, ((RemoteModelSource) obj).f32951a);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f32951a);
    }

    @NonNull
    public String toString() {
        zzw zzb = zzx.zzb("RemoteModelSource");
        zzb.zza("firebaseModelName", this.f32951a);
        return zzb.toString();
    }

    @Nullable
    public final String zza() {
        return this.f32951a;
    }
}
