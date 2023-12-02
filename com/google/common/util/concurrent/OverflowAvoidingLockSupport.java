package com.google.common.util.concurrent;

import com.google.common.annotations.J2ktIncompatible;
import java.util.concurrent.locks.LockSupport;
import javax.annotation.CheckForNull;

@J2ktIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class OverflowAvoidingLockSupport {
    private OverflowAvoidingLockSupport() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@CheckForNull Object obj, long j4) {
        LockSupport.parkNanos(obj, Math.min(j4, 2147483647999999999L));
    }
}
