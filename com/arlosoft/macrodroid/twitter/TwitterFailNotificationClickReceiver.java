package com.arlosoft.macrodroid.twitter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.outputservices.TwitterOutput;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: TwitterFailNotificationClickReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TwitterFailNotificationClickReceiver extends BroadcastReceiver {
    public static final int $stable = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        TwitterOutput.setupTwitter(context, null);
    }
}
