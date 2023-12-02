package com.google.android.gms.internal.nearby;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzsk extends zzsf {
    private final Object zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzsk(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzsk) {
            return this.zza.equals(((zzsk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "Optional.of(" + obj + ")";
    }

    @Override // com.google.android.gms.internal.nearby.zzsf
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.nearby.zzsf
    public final boolean zzb() {
        return true;
    }
}
