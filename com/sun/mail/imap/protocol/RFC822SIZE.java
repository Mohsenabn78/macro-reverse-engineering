package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;

/* loaded from: classes6.dex */
public class RFC822SIZE implements Item {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f37867a = {'R', 'F', 'C', '8', '2', '2', '.', 'S', 'I', 'Z', 'E'};
    public int msgno;
    public long size;

    public RFC822SIZE(FetchResponse fetchResponse) throws ParsingException {
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        this.size = fetchResponse.readLong();
    }
}
