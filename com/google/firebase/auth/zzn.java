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
public final class zzn extends zzbl {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f29148a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f29149b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29150c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(FirebaseAuth firebaseAuth, String str, String str2) {
        this.f29150c = firebaseAuth;
        this.f29148a = str;
        this.f29149b = str2;
    }

    @Override // com.google.firebase.auth.internal.zzbl
    public final Task zza(@Nullable String str) {
        zzaao zzaaoVar;
        FirebaseApp firebaseApp;
        String str2;
        if (TextUtils.isEmpty(str)) {
            String str3 = this.f29148a;
            Log.i("FirebaseAuth", "Creating user with " + str3 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for sign up with email ".concat(String.valueOf(this.f29148a)));
        }
        FirebaseAuth firebaseAuth = this.f29150c;
        zzaaoVar = firebaseAuth.f28875e;
        firebaseApp = firebaseAuth.f28871a;
        String str4 = this.f29148a;
        String str5 = this.f29149b;
        str2 = firebaseAuth.f28881k;
        return zzaaoVar.zzd(firebaseApp, str4, str5, str2, str, new zzac(firebaseAuth));
    }
}
