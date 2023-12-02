package com.h6ah4i.android.widget.advrecyclerview.expandable;

import javax.mail.UIDFolder;

/* compiled from: ExpandableAdapterHelper.java */
/* loaded from: classes6.dex */
class a {
    public static int a(long j4) {
        return (int) (j4 >>> 32);
    }

    public static long b(int i4, int i5) {
        return (i4 & UIDFolder.MAXUID) | (i5 << 32);
    }

    public static long c(int i4) {
        return (i4 & UIDFolder.MAXUID) | (-4294967296L);
    }

    public static int d(long j4) {
        return (int) (j4 & UIDFolder.MAXUID);
    }
}
