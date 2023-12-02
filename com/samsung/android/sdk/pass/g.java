package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ SpassFingerprint.c f37418a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ FingerprintEvent f37419b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ SpassFingerprint.IdentifyListener f37420c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SpassFingerprint.c cVar, FingerprintEvent fingerprintEvent, SpassFingerprint.IdentifyListener identifyListener) {
        this.f37418a = cVar;
        this.f37419b = fingerprintEvent;
        this.f37420c = identifyListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpassFingerprint spassFingerprint;
        if (this.f37419b.eventId == 13) {
            spassFingerprint = SpassFingerprint.this;
            SpassFingerprint.a(spassFingerprint, this.f37420c, this.f37419b, -1);
            this.f37420c.onCompleted();
        }
    }
}
