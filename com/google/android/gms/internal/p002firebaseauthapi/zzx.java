package com.google.android.gms.internal.p002firebaseauthapi;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzx  reason: invalid package */
/* loaded from: classes4.dex */
final class zzx extends zzz {
    final /* synthetic */ zzl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(zzy zzyVar, zzab zzabVar, CharSequence charSequence, zzl zzlVar) {
        super(zzabVar, charSequence);
        this.zza = zzlVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzz
    public final int zzc(int i4) {
        return ((zzo) this.zza).zza.end();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzz
    public final int zzd(int i4) {
        if (((zzo) this.zza).zza.find(i4)) {
            return ((zzo) this.zza).zza.start();
        }
        return -1;
    }
}
