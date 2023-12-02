package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
public final class zzq {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static zzq f19874d;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    private Storage f19875a;
    @Nullable
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInAccount f19876b;
    @Nullable
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    private GoogleSignInOptions f19877c;

    private zzq(Context context) {
        Storage storage = Storage.getInstance(context);
        this.f19875a = storage;
        this.f19876b = storage.getSavedDefaultGoogleSignInAccount();
        this.f19877c = this.f19875a.getSavedDefaultGoogleSignInOptions();
    }

    private static synchronized zzq a(Context context) {
        synchronized (zzq.class) {
            zzq zzqVar = f19874d;
            if (zzqVar != null) {
                return zzqVar;
            }
            zzq zzqVar2 = new zzq(context);
            f19874d = zzqVar2;
            return zzqVar2;
        }
    }

    public static synchronized zzq zzd(@NonNull Context context) {
        zzq a4;
        synchronized (zzq.class) {
            a4 = a(context.getApplicationContext());
        }
        return a4;
    }

    public final synchronized void clear() {
        this.f19875a.clear();
        this.f19876b = null;
        this.f19877c = null;
    }

    public final synchronized void zzc(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f19875a.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.f19876b = googleSignInAccount;
        this.f19877c = googleSignInOptions;
    }

    @Nullable
    public final synchronized GoogleSignInAccount zzr() {
        return this.f19876b;
    }

    @Nullable
    public final synchronized GoogleSignInOptions zzs() {
        return this.f19877c;
    }
}
