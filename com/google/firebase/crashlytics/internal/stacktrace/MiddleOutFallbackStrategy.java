package com.google.firebase.crashlytics.internal.stacktrace;

/* loaded from: classes5.dex */
public class MiddleOutFallbackStrategy implements StackTraceTrimmingStrategy {

    /* renamed from: a  reason: collision with root package name */
    private final int f30033a;

    /* renamed from: b  reason: collision with root package name */
    private final StackTraceTrimmingStrategy[] f30034b;

    /* renamed from: c  reason: collision with root package name */
    private final MiddleOutStrategy f30035c;

    public MiddleOutFallbackStrategy(int i4, StackTraceTrimmingStrategy... stackTraceTrimmingStrategyArr) {
        this.f30033a = i4;
        this.f30034b = stackTraceTrimmingStrategyArr;
        this.f30035c = new MiddleOutStrategy(i4);
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceTrimmingStrategy[] stackTraceTrimmingStrategyArr;
        if (stackTraceElementArr.length <= this.f30033a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (StackTraceTrimmingStrategy stackTraceTrimmingStrategy : this.f30034b) {
            if (stackTraceElementArr2.length <= this.f30033a) {
                break;
            }
            stackTraceElementArr2 = stackTraceTrimmingStrategy.getTrimmedStackTrace(stackTraceElementArr);
        }
        if (stackTraceElementArr2.length > this.f30033a) {
            return this.f30035c.getTrimmedStackTrace(stackTraceElementArr2);
        }
        return stackTraceElementArr2;
    }
}
