package com.google.android.gms.common;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
abstract class zzl extends zzj {

    /* renamed from: c  reason: collision with root package name */
    private static final WeakReference f20774c = new WeakReference(null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference f20775b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzl(byte[] bArr) {
        super(bArr);
        this.f20775b = f20774c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.common.zzj
    public final byte[] b() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f20775b.get();
            if (bArr == null) {
                bArr = c();
                this.f20775b = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] c();
}
