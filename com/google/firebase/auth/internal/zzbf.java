package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzbf {

    /* renamed from: d  reason: collision with root package name */
    private static final com.google.android.gms.internal.p002firebaseauthapi.zzam f29022d = com.google.android.gms.internal.p002firebaseauthapi.zzam.zzj("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");

    /* renamed from: e  reason: collision with root package name */
    private static final zzbf f29023e = new zzbf();

    /* renamed from: a  reason: collision with root package name */
    private Task f29024a;

    /* renamed from: b  reason: collision with root package name */
    private Task f29025b;

    /* renamed from: c  reason: collision with root package name */
    private long f29026c = 0;

    private zzbf() {
    }

    private static final void a(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        com.google.android.gms.internal.p002firebaseauthapi.zzam zzamVar = f29022d;
        int size = zzamVar.size();
        for (int i4 = 0; i4 < size; i4++) {
            edit.remove((String) zzamVar.get(i4));
        }
        edit.commit();
    }

    public static zzbf zzc() {
        return f29023e;
    }

    @Nullable
    public final Task zza() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.f29026c < 3600000) {
            return this.f29024a;
        }
        return null;
    }

    @Nullable
    public final Task zzb() {
        if (DefaultClock.getInstance().currentTimeMillis() - this.f29026c < 3600000) {
            return this.f29025b;
        }
        return null;
    }

    public final void zzd(Context context) {
        Preconditions.checkNotNull(context);
        a(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.f29024a = null;
        this.f29026c = 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007f, code lost:
        if (r4.equals("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN") == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zze(com.google.firebase.auth.FirebaseAuth r13) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbf.zze(com.google.firebase.auth.FirebaseAuth):void");
    }
}
