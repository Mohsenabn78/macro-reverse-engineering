package com.google.android.gms.measurement.internal;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhh implements zzen {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzgd f21765a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhh(zzhi zzhiVar, zzgd zzgdVar) {
        this.f21765a = zzgdVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzen
    public final boolean zza() {
        if (this.f21765a.zzL() && Log.isLoggable(this.f21765a.zzaA().zzr(), 3)) {
            return true;
        }
        return false;
    }
}
