package com.samsung.android.sdk.pass;

import com.samsung.android.sdk.pass.SpassFingerprint;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ SpassFingerprint f37407a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ SpassFingerprint.IdentifyListener f37408b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SpassFingerprint spassFingerprint, SpassFingerprint.IdentifyListener identifyListener) {
        this.f37407a = spassFingerprint;
        this.f37408b = identifyListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SpassFingerprint.a(this.f37407a, this.f37408b, null, 8);
        this.f37408b.onCompleted();
    }
}
