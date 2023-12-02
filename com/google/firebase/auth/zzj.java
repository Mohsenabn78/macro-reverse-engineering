package com.google.firebase.auth;

import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzj implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PhoneAuthOptions f29137a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f29138b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29139c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.f29139c = firebaseAuth;
        this.f29137a = phoneAuthOptions;
        this.f29138b = str;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        String zza;
        String str;
        String str2;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception instanceof FirebaseAuthMissingActivityForRecaptchaException) {
                FirebaseAuth.zzX((FirebaseAuthMissingActivityForRecaptchaException) exception, this.f29137a, this.f29138b);
                return;
            }
            if (task.getException() != null) {
                str2 = task.getException().getMessage();
            } else {
                str2 = "";
            }
            Log.e("FirebaseAuth", "Error while validating application identity: ".concat(String.valueOf(str2)));
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            str = null;
            zza = null;
        } else {
            String zzb = ((com.google.firebase.auth.internal.zze) task.getResult()).zzb();
            zza = ((com.google.firebase.auth.internal.zze) task.getResult()).zza();
            str = zzb;
        }
        this.f29139c.zzV(this.f29137a, str, zza);
    }
}
