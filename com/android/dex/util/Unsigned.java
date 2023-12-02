package com.android.dex.util;

import javax.mail.UIDFolder;
import kotlin.UShort;

/* loaded from: classes2.dex */
public final class Unsigned {
    private Unsigned() {
    }

    public static int compare(int i4, int i5) {
        if (i4 == i5) {
            return 0;
        }
        return (((long) i4) & UIDFolder.MAXUID) < (((long) i5) & UIDFolder.MAXUID) ? -1 : 1;
    }

    public static int compare(short s3, short s4) {
        if (s3 == s4) {
            return 0;
        }
        return (s3 & UShort.MAX_VALUE) < (s4 & UShort.MAX_VALUE) ? -1 : 1;
    }
}
