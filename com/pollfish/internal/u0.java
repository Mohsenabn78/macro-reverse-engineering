package com.pollfish.internal;

/* loaded from: classes6.dex */
public final /* synthetic */ class u0 {
    public static final String a(int i4) {
        return b(i4);
    }

    public static /* synthetic */ String b(int i4) {
        if (i4 == 1) {
            return "development";
        }
        if (i4 == 2) {
            return "production";
        }
        if (i4 == 3) {
            return "mock";
        }
        throw null;
    }

    public static /* synthetic */ String c(int i4) {
        if (i4 == 1) {
            return "DEVELOPMENT";
        }
        if (i4 == 2) {
            return "PRODUCTION";
        }
        if (i4 == 3) {
            return "MOCK";
        }
        return "null";
    }
}
