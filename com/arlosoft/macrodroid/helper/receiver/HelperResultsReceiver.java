package com.arlosoft.macrodroid.helper.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.helper.HelperResultHandler;
import com.arlosoft.macrodroid.helper.data.ShellScriptResult;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: HelperResultsReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class HelperResultsReceiver extends BroadcastReceiver {
    public static final int $stable = 8;
    @Inject
    public HelperResultHandler helperResultHandler;

    public HelperResultsReceiver() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @NotNull
    public final HelperResultHandler getHelperResultHandler() {
        HelperResultHandler helperResultHandler = this.helperResultHandler;
        if (helperResultHandler != null) {
            return helperResultHandler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("helperResultHandler");
        return null;
    }

    public final void handleShellCommandResult(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(HelperCommandsKt.HELPER_RESULT_SHELL_RESULT);
        if (stringExtra == null) {
            stringExtra = "";
        }
        int intExtra = intent.getIntExtra(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, -1);
        boolean booleanExtra = intent.getBooleanExtra(HelperCommandsKt.HELPER_RESULT_SHELL_DID_TIMEOUT, false);
        SystemLog.logVerbose("Received return id=" + intExtra + " from helper file for shell command: " + stringExtra);
        getHelperResultHandler().newResultAvailable(new ShellScriptResult(intExtra, stringExtra, booleanExtra));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getStringExtra(HelperCommandsKt.HELPER_COMMAND_RESULT_TYPE), HelperCommandsKt.HELPER_RESULT_TYPE_SHELL)) {
            handleShellCommandResult(intent);
            return;
        }
        String action = intent.getAction();
        SystemLog.logError("==== RECEIVED return: " + action);
    }

    public final void setHelperResultHandler(@NotNull HelperResultHandler helperResultHandler) {
        Intrinsics.checkNotNullParameter(helperResultHandler, "<set-?>");
        this.helperResultHandler = helperResultHandler;
    }
}
