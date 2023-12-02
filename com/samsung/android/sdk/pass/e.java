package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* loaded from: classes6.dex */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ SpassFingerprint.b f37413a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ FingerprintEvent f37414b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ SpassFingerprint.IdentifyListener f37415c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SpassFingerprint.b bVar, FingerprintEvent fingerprintEvent, SpassFingerprint.IdentifyListener identifyListener) {
        this.f37413a = bVar;
        this.f37414b = fingerprintEvent;
        this.f37415c = identifyListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpassFingerprint spassFingerprint;
        int i4 = this.f37414b.eventId;
        if (i4 != 16) {
            if (i4 != 100000) {
                switch (i4) {
                    case 11:
                        this.f37415c.onReady();
                        return;
                    case 12:
                        this.f37415c.onStarted();
                        return;
                    case 13:
                        spassFingerprint = SpassFingerprint.this;
                        SpassFingerprint.a(spassFingerprint, this.f37415c, this.f37414b, -1);
                        if (!SpassFingerprint.f37377o) {
                            this.f37415c.onCompleted();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            this.f37415c.onFinished(7);
            this.f37415c.onCompleted();
        } else if (SpassFingerprint.f37377o) {
            this.f37415c.onCompleted();
        }
    }
}
