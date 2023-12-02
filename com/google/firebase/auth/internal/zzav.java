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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzav extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f29004a;

    /* renamed from: b  reason: collision with root package name */
    private final TaskCompletionSource f29005b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseAuth f29006c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseUser f29007d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzax f29008e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzav(zzax zzaxVar, Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.f29008e = zzaxVar;
        this.f29004a = new WeakReference(activity);
        this.f29005b = taskCompletionSource;
        this.f29006c = firebaseAuth;
        this.f29007d = firebaseUser;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (((Activity) this.f29004a.get()) == null) {
            Log.e("FederatedAuthReceiver", "Failed to unregister BroadcastReceiver because the Activity that launched this flow has been garbage collected; please do not finish() your Activity while performing a FederatedAuthProvider operation.");
            this.f29005b.setException(zzaas.zza(new Status((int) FirebaseError.ERROR_INTERNAL_ERROR, "Activity that started the web operation is no longer alive; see logcat for details")));
            zzax.d(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.OPERATION")) {
            String stringExtra = intent.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(stringExtra)) {
                this.f29006c.signInWithCredential(zzax.f(intent)).addOnSuccessListener(new zzaq(r0, r1, context)).addOnFailureListener(new zzap(this.f29008e, this.f29005b, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(stringExtra)) {
                this.f29007d.linkWithCredential(zzax.f(intent)).addOnSuccessListener(new zzas(r0, r1, context)).addOnFailureListener(new zzar(this.f29008e, this.f29005b, context));
            } else if ("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(stringExtra)) {
                this.f29007d.reauthenticateAndRetrieveData(zzax.f(intent)).addOnSuccessListener(new zzau(r0, r1, context)).addOnFailureListener(new zzat(this.f29008e, this.f29005b, context));
            } else {
                TaskCompletionSource taskCompletionSource = this.f29005b;
                taskCompletionSource.setException(zzaas.zza(zzai.zza("WEB_CONTEXT_CANCELED:Unknown operation received (" + stringExtra + ")")));
            }
        } else if (zzby.zzc(intent)) {
            this.f29005b.setException(zzaas.zza(zzby.zza(intent)));
            zzax.d(context);
        } else if (intent.hasExtra("com.google.firebase.auth.internal.EXTRA_CANCELED")) {
            this.f29005b.setException(zzaas.zza(zzai.zza("WEB_CONTEXT_CANCELED")));
            zzax.d(context);
        }
    }
}
