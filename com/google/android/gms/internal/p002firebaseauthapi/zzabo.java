package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.PhoneAuthProvider;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabo  reason: invalid package */
/* loaded from: classes4.dex */
final class zzabo implements Runnable {
    final /* synthetic */ zzabq zza;
    final /* synthetic */ zzabp zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabo(zzabp zzabpVar, zzabq zzabqVar) {
        this.zzb = zzabpVar;
        this.zza = zzabqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zza.zzl) {
            if (!this.zzb.zza.zzl.isEmpty()) {
                this.zza.zza((PhoneAuthProvider.OnVerificationStateChangedCallbacks) this.zzb.zza.zzl.get(0), new Object[0]);
            }
        }
    }
}
