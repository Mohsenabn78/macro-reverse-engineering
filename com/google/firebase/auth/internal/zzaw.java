package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzaas;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
final class zzaw extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f29009a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f29010b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzax f29011c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaw(zzax zzaxVar, Activity activity, TaskCompletionSource taskCompletionSource) {
        this.f29011c = zzaxVar;
        this.f29009a = new WeakReference(activity);
        this.f29010b = taskCompletionSource;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (((Activity) this.f29009a.get()) == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.f29010b.setException(zzaas.zza(new Status((int) FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.d(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(stringExtra)) {
                this.f29010b.setResult(intent.getStringExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN"));
                zzax.d(context);
                return;
            }
            TaskCompletionSource taskCompletionSource = this.f29010b;
            taskCompletionSource.setException(zzaas.zza(zzai.zza("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
        } else if (zzby.zzc(intent)) {
            this.f29010b.setException(zzaas.zza(zzby.zza(intent)));
            zzax.d(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.f29010b.setException(zzaas.zza(zzai.zza("WEB_CONTEXT_CANCELED")));
            zzax.d(context);
        }
    }
}
