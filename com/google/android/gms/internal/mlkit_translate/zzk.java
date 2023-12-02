package com.google.android.gms.internal.mlkit_translate;

import javax.annotation.CheckForNull;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzk extends zzf {
    private final Object zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzk) {
            return this.zza.equals(((zzk) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.zza + ")";
    }

    @Override // com.google.android.gms.internal.mlkit_translate.zzf
    public final boolean zza() {
        return true;
    }
}
