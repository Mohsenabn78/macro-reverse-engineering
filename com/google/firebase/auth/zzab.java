package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.zzbl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzab extends zzbl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f29118a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FirebaseUser f29119b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EmailAuthCredential f29120c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29121d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(FirebaseAuth firebaseAuth, boolean z3, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.f29121d = firebaseAuth;
        this.f29118a = z3;
        this.f29119b = firebaseUser;
        this.f29120c = emailAuthCredential;
    }

    @Override // com.google.firebase.auth.internal.zzbl
    public final Task zza(@Nullable String str) {
        zzaao zzaaoVar;
        FirebaseApp firebaseApp;
        zzaao zzaaoVar2;
        FirebaseApp firebaseApp2;
        if (this.f29118a) {
            if (TextUtils.isEmpty(str)) {
                Log.i("FirebaseAuth", " Email link reauth with empty reCAPTCHA token");
            } else {
                Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with email link");
            }
            FirebaseAuth firebaseAuth = this.f29121d;
            zzaaoVar2 = firebaseAuth.f28875e;
            firebaseApp2 = firebaseAuth.f28871a;
            return zzaaoVar2.zzq(firebaseApp2, this.f29119b, this.f29120c, str, new zzad(firebaseAuth));
        }
        EmailAuthCredential emailAuthCredential = this.f29120c;
        String zzd = emailAuthCredential.zzd();
        String zze = emailAuthCredential.zze();
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Reauthenticating " + zzd + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with ".concat(String.valueOf(zzd)));
        }
        FirebaseAuth firebaseAuth2 = this.f29121d;
        zzaaoVar = firebaseAuth2.f28875e;
        firebaseApp = firebaseAuth2.f28871a;
        return zzaaoVar.zzs(firebaseApp, this.f29119b, zzd, Preconditions.checkNotEmpty(zze), this.f29119b.getTenantId(), str, new zzad(this.f29121d));
    }
}
