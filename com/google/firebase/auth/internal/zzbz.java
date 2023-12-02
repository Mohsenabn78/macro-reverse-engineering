package com.google.firebase.auth.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzbz {

    /* renamed from: c  reason: collision with root package name */
    private static final zzbz f29055c = new zzbz();

    /* renamed from: a  reason: collision with root package name */
    private final zzbf f29056a;

    /* renamed from: b  reason: collision with root package name */
    private final zzax f29057b;

    private zzbz() {
        zzbf zzc = zzbf.zzc();
        zzax zza = zzax.zza();
        this.f29056a = zzc;
        this.f29057b = zza;
    }

    public static zzbz zzc() {
        return f29055c;
    }

    public final Task zza() {
        return this.f29056a.zza();
    }

    public final Task zzb() {
        return this.f29056a.zzb();
    }

    public final void zzd(Context context) {
        this.f29056a.zzd(context);
    }

    public final void zze(FirebaseAuth firebaseAuth) {
        this.f29056a.zze(firebaseAuth);
    }

    public final void zzf(Context context, Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.getStatusCode());
        edit.putString("statusMessage", status.getStatusMessage());
        edit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    public final void zzg(Context context, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        edit.commit();
    }

    public final void zzh(Context context, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(firebaseAuth);
        Preconditions.checkNotNull(firebaseUser);
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("firebaseAppName", firebaseAuth.getApp().getName());
        edit.putString("firebaseUserUid", firebaseUser.getUid());
        edit.commit();
    }

    public final boolean zzi(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth) {
        return this.f29057b.zzf(activity, taskCompletionSource, firebaseAuth, null);
    }

    public final boolean zzj(Activity activity, TaskCompletionSource taskCompletionSource, FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        return this.f29057b.zzf(activity, taskCompletionSource, firebaseAuth, firebaseUser);
    }
}
