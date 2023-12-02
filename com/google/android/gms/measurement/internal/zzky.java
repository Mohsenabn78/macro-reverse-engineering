package com.google.android.gms.measurement.internal;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzky implements zzev {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f22022a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzlh f22023b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzky(zzlh zzlhVar, String str) {
        this.f22023b = zzlhVar;
        this.f22022a = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzev
    public final void a(String str, int i4, Throwable th, byte[] bArr, Map map) {
        this.f22023b.k(i4, th, bArr, this.f22022a);
    }
}
