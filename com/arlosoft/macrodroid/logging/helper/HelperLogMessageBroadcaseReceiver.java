package com.arlosoft.macrodroid.logging.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.database.room.LogLevel;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;

/* compiled from: HelperLogMessageBroadcaseReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class HelperLogMessageBroadcaseReceiver extends BroadcastReceiver {
    public static final int $stable = 0;

    private final void a(Intent intent, String str) {
        String stringExtra = intent.getStringExtra(HelperCommandsKt.HELPER_LOG_MESSAGE);
        LogLevel logLevel = HelperLogLevel.values()[intent.getIntExtra(HelperCommandsKt.HELPER_LOG_LEVEL, 0)].getLogLevel();
        SystemLog.log(logLevel, str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + stringExtra);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        boolean equals$default;
        boolean equals$default2;
        boolean equals$default3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        equals$default = m.equals$default(intent.getAction(), HelperCommandsKt.V21_SYSTEM_HELPER_LOG_MESSAGE, false, 2, null);
        if (!equals$default) {
            equals$default2 = m.equals$default(intent.getAction(), HelperCommandsKt.HELPER_SYSTEM_LOG_MESSAGE, false, 2, null);
            if (!equals$default2) {
                equals$default3 = m.equals$default(intent.getAction(), HelperCommandsKt.XIAOMI_HELPER_LOG_MESSAGE, false, 2, null);
                if (equals$default3) {
                    a(intent, "[XiaomiHelper]");
                    return;
                }
                return;
            }
            a(intent, "[Helper]");
            return;
        }
        a(intent, "[V21 System Setting Helper]");
    }
}
