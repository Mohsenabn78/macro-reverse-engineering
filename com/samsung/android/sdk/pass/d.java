package com.samsung.android.sdk.pass;

import com.samsung.android.fingerprint.FingerprintManager;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* loaded from: classes6.dex */
final class d implements FingerprintManager.EnrollFinishListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SpassFingerprint.RegisterListener f37412a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SpassFingerprint.RegisterListener registerListener) {
        this.f37412a = registerListener;
    }

    public final void onEnrollFinish() {
        this.f37412a.onFinished();
    }
}
