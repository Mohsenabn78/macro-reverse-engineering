package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.zzbl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzp extends zzbl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f29154a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ActionCodeSettings f29155b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29156c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(FirebaseAuth firebaseAuth, String str, ActionCodeSettings actionCodeSettings) {
        this.f29156c = firebaseAuth;
        this.f29154a = str;
        this.f29155b = actionCodeSettings;
    }

    @Override // com.google.firebase.auth.internal.zzbl
    public final Task zza(@Nullable String str) {
        zzaao zzaaoVar;
        FirebaseApp firebaseApp;
        String str2;
        if (TextUtils.isEmpty(str)) {
            String str3 = this.f29154a;
            Log.i("FirebaseAuth", "Email link sign in for " + str3 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for email link sign in for ".concat(String.valueOf(this.f29154a)));
        }
        FirebaseAuth firebaseAuth = this.f29156c;
        zzaaoVar = firebaseAuth.f28875e;
        firebaseApp = firebaseAuth.f28871a;
        String str4 = this.f29154a;
        ActionCodeSettings actionCodeSettings = this.f29155b;
        str2 = firebaseAuth.f28881k;
        return zzaaoVar.zzz(firebaseApp, str4, actionCodeSettings, str2, str);
    }
}
