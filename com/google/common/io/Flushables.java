package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class Flushables {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f28020a = Logger.getLogger(Flushables.class.getName());

    private Flushables() {
    }

    public static void flush(Flushable flushable, boolean z3) throws IOException {
        try {
            flushable.flush();
        } catch (IOException e4) {
            if (z3) {
                f28020a.log(Level.WARNING, "IOException thrown while flushing Flushable.", (Throwable) e4);
                return;
            }
            throw e4;
        }
    }

    @Beta
    public static void flushQuietly(Flushable flushable) {
        try {
            flush(flushable, true);
        } catch (IOException e4) {
            f28020a.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e4);
        }
    }
}
