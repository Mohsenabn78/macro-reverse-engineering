package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzbu implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzbv f29043a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbu(zzbv zzbvVar) {
        this.f29043a = zzbvVar;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z3) {
        boolean d4;
        zzam zzamVar;
        if (z3) {
            this.f29043a.f29046c = true;
            this.f29043a.zzc();
            return;
        }
        this.f29043a.f29046c = false;
        d4 = this.f29043a.d();
        if (d4) {
            zzamVar = this.f29043a.f29045b;
            zzamVar.zzc();
        }
    }
}
