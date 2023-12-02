package com.google.android.gms.internal.p002firebaseauthapi;

import javax.annotation.CheckForNull;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzz  reason: invalid package */
/* loaded from: classes4.dex */
abstract class zzz extends zzd {
    final CharSequence zzb;
    final zzj zzc;
    int zzd = 0;
    int zze;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzz(zzab zzabVar, CharSequence charSequence) {
        zzj zzjVar;
        zzjVar = zzabVar.zza;
        this.zzc = zzjVar;
        this.zze = Integer.MAX_VALUE;
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzd
    @CheckForNull
    protected final /* bridge */ /* synthetic */ Object zza() {
        int zzc;
        int i4 = this.zzd;
        while (true) {
            int i5 = this.zzd;
            if (i5 != -1) {
                int zzd = zzd(i5);
                if (zzd == -1) {
                    zzd = this.zzb.length();
                    this.zzd = -1;
                    zzc = -1;
                } else {
                    zzc = zzc(zzd);
                    this.zzd = zzc;
                }
                if (zzc == i4) {
                    int i6 = zzc + 1;
                    this.zzd = i6;
                    if (i6 > this.zzb.length()) {
                        this.zzd = -1;
                    }
                } else {
                    if (i4 < zzd) {
                        this.zzb.charAt(i4);
                    }
                    if (i4 < zzd) {
                        this.zzb.charAt(zzd - 1);
                    }
                    int i7 = this.zze;
                    if (i7 == 1) {
                        zzd = this.zzb.length();
                        this.zzd = -1;
                        if (zzd > i4) {
                            this.zzb.charAt(zzd - 1);
                        }
                    } else {
                        this.zze = i7 - 1;
                    }
                    return this.zzb.subSequence(i4, zzd).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    abstract int zzc(int i4);

    abstract int zzd(int i4);
}
