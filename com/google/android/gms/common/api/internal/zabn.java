package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zabn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f20236a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zabq f20237b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabn(zabq zabqVar, int i4) {
        this.f20237b = zabqVar;
        this.f20236a = i4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f20237b.g(this.f20236a);
    }
}
