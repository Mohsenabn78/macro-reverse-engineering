package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import com.google.android.play.core.common.IntentSenderForResultStarter;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
final class zzf implements IntentSenderForResultStarter {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f25229a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(zzg zzgVar, Activity activity) {
        this.f25229a = activity;
    }

    @Override // com.google.android.play.core.common.IntentSenderForResultStarter
    public final void startIntentSenderForResult(IntentSender intentSender, int i4, Intent intent, int i5, int i6, int i7, Bundle bundle) throws IntentSender.SendIntentException {
        this.f25229a.startIntentSenderForResult(intentSender, i4, intent, i5, i6, i7, bundle);
    }
}
