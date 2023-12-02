package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.internal.zzad;
import com.google.android.play.core.appupdate.internal.zzaf;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
final class zzz implements zza {

    /* renamed from: a  reason: collision with root package name */
    private final zzz f25266a = this;

    /* renamed from: b  reason: collision with root package name */
    private final zzaf f25267b;

    /* renamed from: c  reason: collision with root package name */
    private final zzaf f25268c;

    /* renamed from: d  reason: collision with root package name */
    private final zzaf f25269d;

    /* renamed from: e  reason: collision with root package name */
    private final zzaf f25270e;

    /* renamed from: f  reason: collision with root package name */
    private final zzaf f25271f;

    /* renamed from: g  reason: collision with root package name */
    private final zzaf f25272g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzz(zzi zziVar, zzy zzyVar) {
        zzk zzkVar = new zzk(zziVar);
        this.f25267b = zzkVar;
        zzaf zzb = zzad.zzb(new zzu(zzkVar));
        this.f25268c = zzb;
        zzaf zzb2 = zzad.zzb(new zzs(zzkVar, zzb));
        this.f25269d = zzb2;
        zzaf zzb3 = zzad.zzb(new zzd(zzkVar));
        this.f25270e = zzb3;
        zzaf zzb4 = zzad.zzb(new zzh(zzb2, zzb3, zzkVar));
        this.f25271f = zzb4;
        this.f25272g = zzad.zzb(new zzj(zzb4));
    }

    @Override // com.google.android.play.core.appupdate.zza
    public final AppUpdateManager zza() {
        return (AppUpdateManager) this.f25272g.zza();
    }
}
