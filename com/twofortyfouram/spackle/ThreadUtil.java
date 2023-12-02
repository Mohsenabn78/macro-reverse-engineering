package com.twofortyfouram.spackle;

import android.os.HandlerThread;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.twofortyfouram.annotation.VisibleForTesting;
import com.twofortyfouram.assertion.Assertions;
import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
/* loaded from: classes6.dex */
public final class ThreadUtil {

    @Immutable
    /* loaded from: classes6.dex */
    public enum ThreadPriority {
        AUDIO(-16),
        BACKGROUND(10),
        DEFAULT(0),
        DISPLAY(-4),
        FOREGROUND(-2),
        LESS_FAVORABLE(1),
        LOWEST(19),
        MORE_FAVORABLE(-1),
        URGENT_AUDIO(-19),
        URGENT_DISPLAY(-8);
        
        private final int mPriority;

        ThreadPriority(int i4) {
            this.mPriority = i4;
        }

        @VisibleForTesting(VisibleForTesting.Visibility.PRIVATE)
        int a() {
            return this.mPriority;
        }
    }

    private ThreadUtil() {
        throw new UnsupportedOperationException("This class is non-instantiable");
    }

    public static boolean isMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    @NonNull
    public static HandlerThread newHandlerThread(@NonNull String str, @NonNull ThreadPriority threadPriority) {
        Assertions.assertNotEmpty(str, "threadName");
        Assertions.assertNotNull(threadPriority, "threadPriority");
        HandlerThread handlerThread = new HandlerThread(str, threadPriority.a());
        handlerThread.start();
        return handlerThread;
    }
}
