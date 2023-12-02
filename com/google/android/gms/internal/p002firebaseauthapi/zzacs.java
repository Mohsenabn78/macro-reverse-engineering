package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacs  reason: invalid package */
/* loaded from: classes4.dex */
final class zzacs extends zzaeb {
    private final String zza;
    private final String zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzacs(@Nullable String str, @Nullable String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzaeb) {
            zzaeb zzaebVar = (zzaeb) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzaebVar.zzb()) : zzaebVar.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzaebVar.zza()) : zzaebVar.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        String str = this.zza;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        String str2 = this.zzb;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return ((hashCode ^ 1000003) * 1000003) ^ i4;
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "RecaptchaEnforcementState{provider=" + str + ", enforcementState=" + str2 + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeb
    @Nullable
    public final String zza() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaeb
    @Nullable
    public final String zzb() {
        return this.zza;
    }
}
