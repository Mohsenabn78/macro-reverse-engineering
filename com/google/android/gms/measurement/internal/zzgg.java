package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzac f21686a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzgv f21687b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgg(zzgv zzgvVar, zzac zzacVar) {
        this.f21687b = zzgvVar;
        this.f21686a = zzacVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        zzlh zzlhVar3;
        zzlhVar = this.f21687b.f21731a;
        zzlhVar.a();
        if (this.f21686a.zzc.zza() == null) {
            zzlhVar3 = this.f21687b.f21731a;
            zzlhVar3.n(this.f21686a);
            return;
        }
        zzlhVar2 = this.f21687b.f21731a;
        zzlhVar2.s(this.f21686a);
    }
}
