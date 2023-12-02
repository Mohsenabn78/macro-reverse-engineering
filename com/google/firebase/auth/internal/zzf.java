package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaas;
import com.google.android.gms.internal.p002firebaseauthapi.zzabe;
import com.google.android.gms.internal.p002firebaseauthapi.zzacq;
import com.google.android.gms.internal.p002firebaseauthapi.zzadq;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMissingActivityForRecaptchaException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzf {

    /* renamed from: b  reason: collision with root package name */
    private static final String f29062b = "zzf";

    /* renamed from: c  reason: collision with root package name */
    private static final zzf f29063c = new zzf();

    /* renamed from: a  reason: collision with root package name */
    private String f29064a;

    private zzf() {
    }

    private final void d(FirebaseAuth firebaseAuth, zzbz zzbzVar, Activity activity, TaskCompletionSource taskCompletionSource) {
        Task task;
        if (activity == null) {
            taskCompletionSource.setException(new FirebaseAuthMissingActivityForRecaptchaException());
            return;
        }
        zzbzVar.zzg(firebaseAuth.getApp().getApplicationContext(), firebaseAuth);
        Preconditions.checkNotNull(activity);
        TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        if (!zzax.zza().zzg(activity, taskCompletionSource2)) {
            task = Tasks.forException(zzaas.zza(new Status(17057, "reCAPTCHA flow already in progress")));
        } else {
            Intent intent = new Intent("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            intent.setClass(activity, RecaptchaActivity.class);
            intent.setPackage(activity.getPackageName());
            intent.putExtra("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.getApp().getOptions().getApiKey());
            if (!TextUtils.isEmpty(firebaseAuth.getTenantId())) {
                intent.putExtra("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            }
            intent.putExtra("com.google.firebase.auth.internal.CLIENT_VERSION", zzabe.zza().zzb());
            intent.putExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME", firebaseAuth.getApp().getName());
            activity.startActivity(intent);
            task = taskCompletionSource2.getTask();
        }
        task.addOnSuccessListener(new zzd(this, taskCompletionSource)).addOnFailureListener(new zzc(this, taskCompletionSource));
    }

    public static zzf zzb() {
        return f29063c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, zzbz zzbzVar, Activity activity, Task task) {
        String message;
        if (task.isSuccessful() && task.getResult() != null && !TextUtils.isEmpty(((IntegrityTokenResponse) task.getResult()).token())) {
            taskCompletionSource.setResult(new zze(null, ((IntegrityTokenResponse) task.getResult()).token()));
            return;
        }
        if (task.getException() == null) {
            message = "";
        } else {
            message = task.getException().getMessage();
        }
        Log.e(f29062b, "Play Integrity Token fetch failed, falling back to Recaptcha".concat(String.valueOf(message)));
        d(firebaseAuth, zzbzVar, activity, taskCompletionSource);
    }

    public final Task zza(final FirebaseAuth firebaseAuth, @Nullable String str, @Nullable final Activity activity, boolean z3, boolean z4) {
        Task zzd;
        zzw zzwVar = (zzw) firebaseAuth.getFirebaseAuthSettings();
        final zzbz zzc = zzbz.zzc();
        if (!zzacq.zzg(firebaseAuth.getApp()) && !zzwVar.zze()) {
            String str2 = f29062b;
            boolean zzc2 = zzwVar.zzc();
            Log.i(str2, "ForceRecaptchaFlow from phoneAuthOptions = " + z4 + ", ForceRecaptchaFlow from firebaseSettings = " + zzc2);
            boolean zzc3 = z4 | zzwVar.zzc();
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            Task zzb = zzc.zzb();
            if (zzb != null) {
                if (zzb.isSuccessful()) {
                    return Tasks.forResult(new zze((String) zzb.getResult(), null));
                }
                Log.e(str2, "Error in previous reCAPTCHA flow: ".concat(String.valueOf(zzb.getException().getMessage())));
                Log.e(str2, "Continuing with application verification as normal");
            }
            if (z3 && !zzc3) {
                IntegrityManager create = IntegrityManagerFactory.create(firebaseAuth.getApp().getApplicationContext());
                if (!TextUtils.isEmpty(this.f29064a)) {
                    zzd = Tasks.forResult(new zzadq(this.f29064a));
                } else {
                    zzd = firebaseAuth.zzd();
                }
                zzd.continueWithTask(firebaseAuth.zzM(), new zzb(this, str, create)).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.auth.internal.zza
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        zzf.this.c(taskCompletionSource, firebaseAuth, zzc, activity, task);
                    }
                });
            } else {
                d(firebaseAuth, zzc, activity, taskCompletionSource);
            }
            return taskCompletionSource.getTask();
        }
        return Tasks.forResult(new zze(null, null));
    }
}
