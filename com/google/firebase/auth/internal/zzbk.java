package com.google.firebase.auth.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaas;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuthException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
final class zzbk implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f29027a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzbr f29028b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ RecaptchaAction f29029c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Continuation f29030d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbk(String str, zzbr zzbrVar, RecaptchaAction recaptchaAction, Continuation continuation) {
        this.f29027a = str;
        this.f29028b = zzbrVar;
        this.f29029c = recaptchaAction;
        this.f29030d = continuation;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        if (!task.isSuccessful()) {
            Exception exc = (Exception) Preconditions.checkNotNull(task.getException());
            int i4 = zzaas.zzb;
            if ((exc instanceof FirebaseAuthException) && ((FirebaseAuthException) exc).getErrorCode().endsWith("INVALID_RECAPTCHA_TOKEN")) {
                if (Log.isLoggable("RecaptchaCallWrapper", 4)) {
                    Log.i("RecaptchaCallWrapper", "Invalid token - Refreshing Recaptcha Enterprise config and fetching new token for tenant ".concat(String.valueOf(this.f29027a)));
                }
                return this.f29028b.zza(this.f29027a, Boolean.TRUE, this.f29029c).continueWithTask(this.f29030d);
            }
            return task;
        }
        return task;
    }
}
