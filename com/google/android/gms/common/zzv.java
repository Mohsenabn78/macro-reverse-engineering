package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
final class zzv extends zzx {

    /* renamed from: f  reason: collision with root package name */
    private final Callable f20797f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzv(Callable callable, zzu zzuVar) {
        super();
        this.f20797f = callable;
    }

    @Override // com.google.android.gms.common.zzx
    final String a() {
        try {
            return (String) this.f20797f.call();
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }
}
