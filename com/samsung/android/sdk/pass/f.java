package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* loaded from: classes6.dex */
final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ SpassFingerprint.c f37416a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ FingerprintEvent f37417b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SpassFingerprint.c cVar, FingerprintEvent fingerprintEvent) {
        this.f37416a = cVar;
        this.f37417b = fingerprintEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpassFingerprint.IdentifyListener identifyListener;
        SpassFingerprint.IdentifyListener identifyListener2;
        SpassFingerprint.IdentifyListener identifyListener3;
        identifyListener = this.f37416a.f37403a;
        if (identifyListener != null) {
            int i4 = this.f37417b.eventId;
            if (i4 == 11) {
                identifyListener2 = this.f37416a.f37403a;
                identifyListener2.onReady();
            } else if (i4 == 12) {
                identifyListener3 = this.f37416a.f37403a;
                identifyListener3.onStarted();
            }
        }
    }
}
