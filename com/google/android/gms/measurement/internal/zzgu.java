package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
final class zzgu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21726a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f21727b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f21728c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ long f21729d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzgv f21730e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgu(zzgv zzgvVar, String str, String str2, String str3, long j4) {
        this.f21730e = zzgvVar;
        this.f21726a = str;
        this.f21727b = str2;
        this.f21728c = str3;
        this.f21729d = j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlh zzlhVar;
        zzlh zzlhVar2;
        String str = this.f21726a;
        if (str == null) {
            zzlhVar2 = this.f21730e.f21731a;
            zzlhVar2.zzR(this.f21727b, null);
            return;
        }
        zzir zzirVar = new zzir(this.f21728c, str, this.f21729d);
        zzlhVar = this.f21730e.f21731a;
        zzlhVar.zzR(this.f21727b, zzirVar);
    }
}
