package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfc {

    /* renamed from: a  reason: collision with root package name */
    private final String f21567a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f21568b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21569c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21570d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzfi f21571e;

    public zzfc(zzfi zzfiVar, String str, boolean z3) {
        this.f21571e = zzfiVar;
        Preconditions.checkNotEmpty(str);
        this.f21567a = str;
        this.f21568b = z3;
    }

    @WorkerThread
    public final void zza(boolean z3) {
        SharedPreferences.Editor edit = this.f21571e.d().edit();
        edit.putBoolean(this.f21567a, z3);
        edit.apply();
        this.f21570d = z3;
    }

    @WorkerThread
    public final boolean zzb() {
        if (!this.f21569c) {
            this.f21569c = true;
            this.f21570d = this.f21571e.d().getBoolean(this.f21567a, this.f21568b);
        }
        return this.f21570d;
    }
}
