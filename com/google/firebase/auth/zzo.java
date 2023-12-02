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
public final class zzo extends zzbl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f29151a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ActionCodeSettings f29152b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29153c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(FirebaseAuth firebaseAuth, String str, ActionCodeSettings actionCodeSettings) {
        this.f29153c = firebaseAuth;
        this.f29151a = str;
        this.f29152b = actionCodeSettings;
    }

    @Override // com.google.firebase.auth.internal.zzbl
    public final Task zza(@Nullable String str) {
        zzaao zzaaoVar;
        FirebaseApp firebaseApp;
        String str2;
        if (TextUtils.isEmpty(str)) {
            String str3 = this.f29151a;
            Log.i("FirebaseAuth", "Password reset request " + str3 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for password reset of email ".concat(String.valueOf(this.f29151a)));
        }
        FirebaseAuth firebaseAuth = this.f29153c;
        zzaaoVar = firebaseAuth.f28875e;
        firebaseApp = firebaseAuth.f28871a;
        String str4 = this.f29151a;
        ActionCodeSettings actionCodeSettings = this.f29152b;
        str2 = firebaseAuth.f28881k;
        return zzaaoVar.zzy(firebaseApp, str4, actionCodeSettings, str2, str);
    }
}
