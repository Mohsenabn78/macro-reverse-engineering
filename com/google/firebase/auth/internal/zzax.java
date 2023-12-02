package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.VisibleForTesting;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.p002firebaseauthapi.zzaev;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzax {

    /* renamed from: c  reason: collision with root package name */
    private static zzax f29012c;

    /* renamed from: a  reason: collision with root package name */
    private boolean f29013a = false;

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f29014b;

    private zzax() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static void d(Context context) {
        zzax zzaxVar = f29012c;
        zzaxVar.f29013a = false;
        if (zzaxVar.f29014b != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(f29012c.f29014b);
        }
        f29012c.f29014b = null;
    }

    private final void e(Activity activity, BroadcastReceiver broadcastReceiver) {
        this.f29014b = broadcastReceiver;
        LocalBroadcastManager.getInstance(activity).registerReceiver(broadcastReceiver, new IntentFilter("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"));
    }

    private static final AuthCredential f(Intent intent) {
        Preconditions.checkNotNull(intent);
        zzaev zzaevVar = (zzaev) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzaev.CREATOR);
        zzaevVar.zze(true);
        return com.google.firebase.auth.zze.zzb(zzaevVar);
    }

    public static zzax zza() {
        if (f29012c == null) {
            f29012c = new zzax();
        }
        return f29012c;
    }

    public final boolean zzf(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (!this.f29013a) {
            e(activity, new zzav(this, activity, taskCompletionSource, firebaseAuth, firebaseUser));
            this.f29013a = true;
            return true;
        }
        return false;
    }

    public final boolean zzg(Activity activity, TaskCompletionSource taskCompletionSource) {
        if (!this.f29013a) {
            e(activity, new zzaw(this, activity, taskCompletionSource));
            this.f29013a = true;
            return true;
        }
        return false;
    }
}
