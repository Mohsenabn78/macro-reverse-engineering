package com.samsung.android.sdk.pass;

import com.samsung.android.sdk.pass.SpassFingerprint;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ SpassFingerprint f37409a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ SpassFingerprint.IdentifyListener f37410b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SpassFingerprint spassFingerprint, SpassFingerprint.IdentifyListener identifyListener) {
        this.f37409a = spassFingerprint;
        this.f37410b = identifyListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpassFingerprint.a(this.f37409a, this.f37410b, null, 7);
        this.f37410b.onCompleted();
    }
}
