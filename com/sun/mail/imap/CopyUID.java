package com.sun.mail.imap;

import com.sun.mail.imap.protocol.UIDSet;

/* loaded from: classes6.dex */
public class CopyUID {
    public UIDSet[] dst;
    public UIDSet[] src;
    public long uidvalidity;

    public CopyUID(long j4, UIDSet[] uIDSetArr, UIDSet[] uIDSetArr2) {
        this.uidvalidity = j4;
        this.src = uIDSetArr;
        this.dst = uIDSetArr2;
    }
}
