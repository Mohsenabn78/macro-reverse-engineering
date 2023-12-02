package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzv  reason: invalid package */
/* loaded from: classes4.dex */
final class zzv extends zzz {
    final /* synthetic */ zzw zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzv(zzw zzwVar, zzab zzabVar, CharSequence charSequence) {
        super(zzabVar, charSequence);
        this.zza = zzwVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzz
    final int zzc(int i4) {
        return i4 + 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzz
    final int zzd(int i4) {
        zzj zzjVar = this.zza.zza;
        CharSequence charSequence = ((zzz) this).zzb;
        int length = charSequence.length();
        zzu.zzb(i4, length, FirebaseAnalytics.Param.INDEX);
        while (i4 < length) {
            if (!zzjVar.zza(charSequence.charAt(i4))) {
                i4++;
            } else {
                return i4;
            }
        }
        return -1;
    }
}
