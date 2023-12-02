package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaao;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.PhoneAuthProvider;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzk implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PhoneAuthOptions f29140a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f29141b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ FirebaseAuth f29142c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(FirebaseAuth firebaseAuth, PhoneAuthOptions phoneAuthOptions, String str) {
        this.f29142c = firebaseAuth;
        this.f29140a = phoneAuthOptions;
        this.f29141b = str;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        String zzb;
        String zza;
        PhoneAuthProvider.OnVerificationStateChangedCallbacks l4;
        zzaao zzaaoVar;
        String str;
        boolean z3;
        zzaao zzaaoVar2;
        String str2;
        boolean z4;
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            String str3 = "Error while validating application identity: ";
            if (exception != null) {
                str3 = "Error while validating application identity: ".concat(String.valueOf(exception.getMessage()));
            }
            Log.e("FirebaseAuth", str3);
            if (exception instanceof FirebaseAuthMissingActivityForRecaptchaException) {
                FirebaseAuth.zzX((FirebaseAuthMissingActivityForRecaptchaException) exception, this.f29140a, this.f29141b);
                return;
            }
            Log.e("FirebaseAuth", "Proceeding without any application identifier.");
            zzb = null;
            zza = null;
        } else {
            zzb = ((com.google.firebase.auth.internal.zze) task.getResult()).zzb();
            zza = ((com.google.firebase.auth.internal.zze) task.getResult()).zza();
        }
        long longValue = this.f29140a.zzg().longValue();
        l4 = this.f29142c.l(this.f29140a.zzh(), this.f29140a.zze());
        if (TextUtils.isEmpty(zzb)) {
            l4 = this.f29142c.q(this.f29140a, l4);
        }
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks = l4;
        com.google.firebase.auth.internal.zzag zzagVar = (com.google.firebase.auth.internal.zzag) Preconditions.checkNotNull(this.f29140a.zzc());
        if (zzagVar.zzf()) {
            zzaaoVar2 = this.f29142c.f28875e;
            String str4 = (String) Preconditions.checkNotNull(this.f29140a.zzh());
            str2 = this.f29142c.f28879i;
            if (this.f29140a.zzd() != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            zzaaoVar2.zzH(zzagVar, str4, str2, longValue, z4, this.f29140a.zzl(), zzb, zza, this.f29142c.h(), onVerificationStateChangedCallbacks, this.f29140a.zzi(), this.f29140a.zza());
            return;
        }
        zzaaoVar = this.f29142c.f28875e;
        PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.checkNotNull(this.f29140a.zzf());
        str = this.f29142c.f28879i;
        if (this.f29140a.zzd() != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzaaoVar.zzJ(zzagVar, phoneMultiFactorInfo, str, longValue, z3, this.f29140a.zzl(), zzb, zza, this.f29142c.h(), onVerificationStateChangedCallbacks, this.f29140a.zzi(), this.f29140a.zza());
    }
}
