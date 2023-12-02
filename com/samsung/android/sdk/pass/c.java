package com.samsung.android.sdk.pass;

import android.content.DialogInterface;
import com.samsung.android.sdk.pass.SpassFingerprint;

/* loaded from: classes6.dex */
final class c implements DialogInterface.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ SpassFingerprint.c f37411a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SpassFingerprint.c cVar) {
        this.f37411a = cVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f37411a.a();
    }
}
