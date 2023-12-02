package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfe {

    /* renamed from: a  reason: collision with root package name */
    private final String f21576a;

    /* renamed from: b  reason: collision with root package name */
    private final long f21577b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f21578c;

    /* renamed from: d  reason: collision with root package name */
    private long f21579d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzfi f21580e;

    public zzfe(zzfi zzfiVar, String str, long j4) {
        this.f21580e = zzfiVar;
        Preconditions.checkNotEmpty(str);
        this.f21576a = str;
        this.f21577b = j4;
    }

    @WorkerThread
    public final long zza() {
        if (!this.f21578c) {
            this.f21578c = true;
            this.f21579d = this.f21580e.d().getLong(this.f21576a, this.f21577b);
        }
        return this.f21579d;
    }

    @WorkerThread
    public final void zzb(long j4) {
        SharedPreferences.Editor edit = this.f21580e.d().edit();
        edit.putLong(this.f21576a, j4);
        edit.apply();
        this.f21579d = j4;
    }
}
