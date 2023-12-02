package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zabo implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zabp f20238a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabo(zabp zabpVar) {
        this.f20238a = zabpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client;
        Api.Client client2;
        zabq zabqVar = this.f20238a.f20239a;
        client = zabqVar.f20241b;
        client2 = zabqVar.f20241b;
        client.disconnect(client2.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
