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
public final class zzz extends zzbl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f29168a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f29169b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FirebaseUser f29170c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f29171d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f29172e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29173f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzz(FirebaseAuth firebaseAuth, String str, boolean z3, FirebaseUser firebaseUser, String str2, String str3) {
        this.f29173f = firebaseAuth;
        this.f29168a = str;
        this.f29169b = z3;
        this.f29170c = firebaseUser;
        this.f29171d = str2;
        this.f29172e = str3;
    }

    @Override // com.google.firebase.auth.internal.zzbl
    public final Task zza(@Nullable String str) {
        zzaao zzaaoVar;
        FirebaseApp firebaseApp;
        zzaao zzaaoVar2;
        FirebaseApp firebaseApp2;
        if (TextUtils.isEmpty(str)) {
            String str2 = this.f29168a;
            Log.i("FirebaseAuth", "Logging in as " + str2 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login with email ".concat(String.valueOf(this.f29168a)));
        }
        if (this.f29169b) {
            FirebaseAuth firebaseAuth = this.f29173f;
            zzaaoVar2 = firebaseAuth.f28875e;
            firebaseApp2 = firebaseAuth.f28871a;
            return zzaaoVar2.zzt(firebaseApp2, (FirebaseUser) Preconditions.checkNotNull(this.f29170c), this.f29168a, this.f29171d, this.f29172e, str, new zzad(this.f29173f));
        }
        FirebaseAuth firebaseAuth2 = this.f29173f;
        zzaaoVar = firebaseAuth2.f28875e;
        firebaseApp = firebaseAuth2.f28871a;
        return zzaaoVar.zzE(firebaseApp, this.f29168a, this.f29171d, this.f29172e, str, new zzac(firebaseAuth2));
    }
}
