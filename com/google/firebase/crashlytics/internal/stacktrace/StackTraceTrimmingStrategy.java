package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes5.dex */
public interface StackTraceTrimmingStrategy {
    StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr);
}
