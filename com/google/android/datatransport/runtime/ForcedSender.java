package com.google.android.datatransport.runtime;

import android.annotation.SuppressLint;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.runtime.logging.Logging;

/* loaded from: classes.dex */
public final class ForcedSender {
    private ForcedSender() {
    }

    @SuppressLint({"DiscouragedApi"})
    @WorkerThread
    public static void sendBlocking(Transport<?> transport, Priority priority) {
        if (transport instanceof TransportImpl) {
            TransportRuntime.getInstance().getUploader().logAndUpdateState(((TransportImpl) transport).b().withPriority(priority), 1);
            return;
        }
        Logging.w("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", transport);
    }
}
