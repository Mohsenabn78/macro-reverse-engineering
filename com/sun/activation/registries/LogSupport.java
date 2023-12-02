package com.sun.activation.registries;

import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
public class LogSupport {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f37551a = false;

    /* renamed from: b  reason: collision with root package name */
    private static Logger f37552b;

    /* renamed from: c  reason: collision with root package name */
    private static final Level f37553c = Level.FINE;

    static {
        try {
            f37551a = Boolean.getBoolean("javax.activation.debug");
        } catch (Throwable unused) {
        }
        f37552b = Logger.getLogger("javax.activation");
    }

    private LogSupport() {
    }

    public static boolean isLoggable() {
        if (!f37551a && !f37552b.isLoggable(f37553c)) {
            return false;
        }
        return true;
    }

    public static void log(String str) {
        if (f37551a) {
            System.out.println(str);
        }
        f37552b.log(f37553c, str);
    }

    public static void log(String str, Throwable th) {
        if (f37551a) {
            PrintStream printStream = System.out;
            printStream.println(str + "; Exception: " + th);
        }
        f37552b.log(f37553c, str, th);
    }
}
