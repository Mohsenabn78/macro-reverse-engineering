package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzfh {

    /* renamed from: a  reason: collision with root package name */
    private final String f21586a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21587b;

    /* renamed from: c  reason: collision with root package name */
    private String f21588c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zzfi f21589d;

    public zzfh(zzfi zzfiVar, String str, String str2) {
        this.f21589d = zzfiVar;
        Preconditions.checkNotEmpty(str);
        this.f21586a = str;
    }

    @WorkerThread
    public final String zza() {
        if (!this.f21587b) {
            this.f21587b = true;
            this.f21588c = this.f21589d.d().getString(this.f21586a, null);
        }
        return this.f21588c;
    }

    @WorkerThread
    public final void zzb(String str) {
        SharedPreferences.Editor edit = this.f21589d.d().edit();
        edit.putString(this.f21586a, str);
        edit.apply();
        this.f21588c = str;
    }
}
