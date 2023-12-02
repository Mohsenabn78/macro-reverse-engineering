package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzbc;
import com.google.android.gms.wearable.internal.zzbf;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzbf f22887a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaa f22888b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(zzaa zzaaVar, zzbf zzbfVar) {
        this.f22888b = zzaaVar;
        this.f22887a = zzbfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbc zzbcVar;
        this.f22887a.zza(this.f22888b.f22866b);
        zzbf zzbfVar = this.f22887a;
        zzbcVar = this.f22888b.f22866b.f22656h;
        zzbfVar.zza(zzbcVar);
    }
}
