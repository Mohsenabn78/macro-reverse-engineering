package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes5.dex */
public class ResponseParser {
    public static final int ResponseActionDiscard = 0;
    public static final int ResponseActionRetry = 1;

    public static int parse(int i4) {
        if (i4 >= 200 && i4 <= 299) {
            return 0;
        }
        if ((i4 < 300 || i4 > 399) && i4 >= 400 && i4 <= 499) {
            return 0;
        }
        return 1;
    }
}
