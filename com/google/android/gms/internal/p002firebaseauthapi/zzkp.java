package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkp  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzkp extends zzcf {
    private final zzlv zza;

    public zzkp(zzlv zzlvVar) {
        this.zza = zzlvVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzkp)) {
            return false;
        }
        zzlv zzlvVar = ((zzkp) obj).zza;
        if (!this.zza.zzc().zze().equals(zzlvVar.zzc().zze()) || !this.zza.zzc().zzg().equals(zzlvVar.zzc().zzg()) || !this.zza.zzc().zzf().equals(zzlvVar.zzc().zzf())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        zzlv zzlvVar = this.zza;
        return Arrays.hashCode(new Object[]{zzlvVar.zzc(), zzlvVar.zzd()});
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zzc().zzg();
        zzui zze = this.zza.zzc().zze();
        zzui zzuiVar = zzui.UNKNOWN_PREFIX;
        int ordinal = zze.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        str = "UNKNOWN";
                    } else {
                        str = "CRUNCHY";
                    }
                } else {
                    str = "RAW";
                }
            } else {
                str = "LEGACY";
            }
        } else {
            str = "TINK";
        }
        objArr[1] = str;
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public final zzlv zza() {
        return this.zza;
    }
}
