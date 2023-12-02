package com.tencent.soter.core.model;

/* loaded from: classes6.dex */
public interface ISoterLogger {
    void d(String str, String str2, Object... objArr);

    void e(String str, String str2, Object... objArr);

    void i(String str, String str2, Object... objArr);

    void printErrStackTrace(String str, Throwable th, String str2);

    void v(String str, String str2, Object... objArr);

    void w(String str, String str2, Object... objArr);
}
