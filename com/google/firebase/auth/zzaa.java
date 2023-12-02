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
public final class zzaa extends zzbl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ boolean f29114a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ FirebaseUser f29115b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ EmailAuthCredential f29116c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29117d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaa(FirebaseAuth firebaseAuth, boolean z3, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.f29117d = firebaseAuth;
        this.f29114a = z3;
        this.f29115b = firebaseUser;
        this.f29116c = emailAuthCredential;
    }

    @Override // com.google.firebase.auth.internal.zzbl
    public final Task zza(@Nullable String str) {
        zzaao zzaaoVar;
        FirebaseApp firebaseApp;
        zzaao zzaaoVar2;
        FirebaseApp firebaseApp2;
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Email link login/reauth with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login/reauth with email link");
        }
        if (this.f29114a) {
            FirebaseAuth firebaseAuth = this.f29117d;
            zzaaoVar2 = firebaseAuth.f28875e;
            firebaseApp2 = firebaseAuth.f28871a;
            return zzaaoVar2.zzr(firebaseApp2, (FirebaseUser) Preconditions.checkNotNull(this.f29115b), this.f29116c, str, new zzad(this.f29117d));
        }
        FirebaseAuth firebaseAuth2 = this.f29117d;
        zzaaoVar = firebaseAuth2.f28875e;
        firebaseApp = firebaseAuth2.f28871a;
        return zzaaoVar.zzF(firebaseApp, this.f29116c, str, new zzac(firebaseAuth2));
    }
}
