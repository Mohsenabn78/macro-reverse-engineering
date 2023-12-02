package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zacr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.signin.internal.zak f20281a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zact f20282b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zacr(zact zactVar, com.google.android.gms.signin.internal.zak zakVar) {
        this.f20282b = zactVar;
        this.f20281a = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zact.b(this.f20282b, this.f20281a);
    }
}
