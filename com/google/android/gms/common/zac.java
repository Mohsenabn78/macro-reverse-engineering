package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
final class zac implements DialogInterface.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f20761a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f20762b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ActivityResultLauncher f20763c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ GoogleApiAvailability f20764d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zac(GoogleApiAvailability googleApiAvailability, Activity activity, int i4, ActivityResultLauncher activityResultLauncher) {
        this.f20764d = googleApiAvailability;
        this.f20761a = activity;
        this.f20762b = i4;
        this.f20763c = activityResultLauncher;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        PendingIntent errorResolutionPendingIntent = this.f20764d.getErrorResolutionPendingIntent(this.f20761a, this.f20762b, 0);
        if (errorResolutionPendingIntent == null) {
            return;
        }
        this.f20763c.launch(new IntentSenderRequest.Builder(errorResolutionPendingIntent.getIntentSender()).build());
    }
}
