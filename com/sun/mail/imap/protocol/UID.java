package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;

/* loaded from: classes6.dex */
public class UID implements Item {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f37872a = {'U', 'I', 'D'};
    public int seqnum;
    public long uid;

    public UID(FetchResponse fetchResponse) throws ParsingException {
        this.seqnum = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        this.uid = fetchResponse.readLong();
    }
}
