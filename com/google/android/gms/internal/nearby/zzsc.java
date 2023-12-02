package com.google.android.gms.internal.nearby;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzsc extends zzsf {
    static final zzsc zza = new zzsc();

    private zzsc() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // com.google.android.gms.internal.nearby.zzsf
    public final Object zza() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.android.gms.internal.nearby.zzsf
    public final boolean zzb() {
        return false;
    }
}
