package com.android.dx.util;

import java.io.PrintWriter;
import java.io.Writer;

/* loaded from: classes2.dex */
public final class Writers {
    private Writers() {
    }

    public static PrintWriter printWriterFor(Writer writer) {
        if (writer instanceof PrintWriter) {
            return (PrintWriter) writer;
        }
        return new PrintWriter(writer);
    }
}
