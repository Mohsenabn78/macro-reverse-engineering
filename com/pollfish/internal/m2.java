package com.pollfish.internal;

import java.lang.Thread;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class m2 implements Thread.UncaughtExceptionHandler {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f37081a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final u3 f37082b;

    public m2(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @NotNull u3 u3Var) {
        this.f37081a = uncaughtExceptionHandler;
        this.f37082b = u3Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
        if (r0 == true) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
        if (r0 != false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void uncaughtException(@org.jetbrains.annotations.NotNull java.lang.Thread r7, @org.jetbrains.annotations.NotNull java.lang.Throwable r8) {
        /*
            r6 = this;
            java.lang.StackTraceElement[] r0 = r8.getStackTrace()
            java.lang.Object r0 = kotlin.collections.ArraysKt.first(r0)
            java.lang.StackTraceElement r0 = (java.lang.StackTraceElement) r0
            r1 = 0
            r2 = 2
            java.lang.String r3 = "com.pollfish"
            r4 = 1
            r5 = 0
            if (r0 == 0) goto L20
            java.lang.String r0 = r0.getClassName()
            if (r0 == 0) goto L20
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r3, r5, r2, r1)
            if (r0 != r4) goto L20
            r0 = 1
            goto L21
        L20:
            r0 = 0
        L21:
            if (r0 != 0) goto L51
            java.lang.Throwable r0 = r8.getCause()
            if (r0 == 0) goto L44
            java.lang.StackTraceElement[] r0 = r0.getStackTrace()
            if (r0 == 0) goto L44
            java.lang.Object r0 = kotlin.collections.ArraysKt.first(r0)
            java.lang.StackTraceElement r0 = (java.lang.StackTraceElement) r0
            if (r0 == 0) goto L44
            java.lang.String r0 = r0.getClassName()
            if (r0 == 0) goto L44
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r3, r5, r2, r1)
            if (r0 != r4) goto L44
            goto L45
        L44:
            r4 = 0
        L45:
            if (r4 != 0) goto L51
            java.lang.String r0 = kotlin.ExceptionsKt.stackTraceToString(r8)
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r3, r5, r2, r1)
            if (r0 == 0) goto L5d
        L51:
            com.pollfish.internal.u3 r0 = r6.f37082b
            com.pollfish.internal.f4$a r1 = com.pollfish.internal.f4.a.FATAL
            com.pollfish.internal.l4$a$d0 r2 = new com.pollfish.internal.l4$a$d0
            r2.<init>(r8)
            r0.a(r1, r2)
        L5d:
            java.lang.Thread$UncaughtExceptionHandler r0 = r6.f37081a
            if (r0 == 0) goto L64
            r0.uncaughtException(r7, r8)
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.internal.m2.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
