package com.google.firebase.auth.internal;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzadt;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.Recaptcha;
import com.google.android.recaptcha.RecaptchaTasksClient;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzbp implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f29031a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzbr f29032b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbp(zzbr zzbrVar, String str) {
        this.f29032b = zzbrVar;
        this.f29031a = str;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        String str;
        if (!task.isSuccessful()) {
            return Tasks.forException(new zzbo((String) Preconditions.checkNotNull(((Exception) Preconditions.checkNotNull(task.getException())).getMessage())));
        }
        zzadt zzadtVar = (zzadt) task.getResult();
        String zzb = zzadtVar.zzb();
        if (com.google.android.gms.internal.p002firebaseauthapi.zzac.zzd(zzb)) {
            return Tasks.forException(new zzbo("No Recaptcha Enterprise siteKey configured for tenant/project ".concat(String.valueOf(this.f29031a))));
        }
        List zzd = com.google.android.gms.internal.p002firebaseauthapi.zzab.zzb(com.google.android.gms.internal.p002firebaseauthapi.zzj.zzb('/')).zzd(zzb);
        if (zzd.size() != 4) {
            str = null;
        } else {
            str = (String) zzd.get(3);
        }
        if (TextUtils.isEmpty(str)) {
            return Tasks.forException(new Exception("Invalid siteKey format ".concat(String.valueOf(zzb))));
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Successfully obtained site key for tenant ".concat(String.valueOf(this.f29031a)));
        }
        this.f29032b.f29035b = zzadtVar;
        Task<RecaptchaTasksClient> tasksClient = Recaptcha.getTasksClient((Application) this.f29032b.f29036c.getApplicationContext(), str);
        this.f29032b.f29034a.put(this.f29031a, tasksClient);
        return tasksClient;
    }
}
