package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzai;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxb  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzxb implements zzabx {
    final /* synthetic */ EmailAuthCredential zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzaaq zzc;
    final /* synthetic */ zzys zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxb(zzys zzysVar, EmailAuthCredential emailAuthCredential, String str, zzaaq zzaaqVar) {
        this.zzd = zzysVar;
        this.zza = emailAuthCredential;
        this.zzb = str;
        this.zzc = zzaaqVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabw
    public final void zza(@Nullable String str) {
        this.zzc.zzh(zzai.zza(str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabx
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzd.zzP(new zzacx(this.zza, ((zzadu) obj).zze(), this.zzb), this.zzc);
    }
}
