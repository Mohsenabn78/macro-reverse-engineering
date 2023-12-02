package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzla implements Callable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzq f22027a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzlh f22028b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzla(zzlh zzlhVar, zzq zzqVar) {
        this.f22028b = zzlhVar;
        this.f22027a = zzqVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzhb P = this.f22028b.P((String) Preconditions.checkNotNull(this.f22027a.zza));
        zzha zzhaVar = zzha.ANALYTICS_STORAGE;
        if (P.zzj(zzhaVar) && zzhb.zzc(this.f22027a.zzv, 100).zzj(zzhaVar)) {
            return this.f22028b.M(this.f22027a).m0();
        }
        this.f22028b.zzaA().zzj().zza("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
