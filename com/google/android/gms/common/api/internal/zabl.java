package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zabl implements BackgroundDetector.BackgroundStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GoogleApiManager f20234a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zabl(GoogleApiManager googleApiManager) {
        this.f20234a = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z3) {
        Handler handler;
        Handler handler2;
        GoogleApiManager googleApiManager = this.f20234a;
        handler = googleApiManager.f20065n;
        handler2 = googleApiManager.f20065n;
        handler.sendMessage(handler2.obtainMessage(1, Boolean.valueOf(z3)));
    }
}
