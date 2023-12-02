package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import timber.log.Timber;

/* compiled from: MediaButtonV2Receiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MediaButtonV2Receiver extends BroadcastReceiver {
    public static final int $stable = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        KeyEvent keyEvent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Timber.e("************** MediaButtonV2Receiver", new Object[0]);
        if (Intrinsics.areEqual("android.intent.action.MEDIA_BUTTON", intent.getAction()) && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0) {
            keyEvent.getKeyCode();
        }
    }
}
