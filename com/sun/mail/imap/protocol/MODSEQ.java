package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;

/* loaded from: classes6.dex */
public class MODSEQ implements Item {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f37862a = {'M', 'O', 'D', 'S', 'E', 'Q'};
    public long modseq;
    public int seqnum;

    public MODSEQ(FetchResponse fetchResponse) throws ParsingException {
        this.seqnum = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() == 40) {
            this.modseq = fetchResponse.readLong();
            if (fetchResponse.isNextNonSpace(')')) {
                return;
            }
            throw new ParsingException("MODSEQ parse error");
        }
        throw new ParsingException("MODSEQ parse error");
    }
}
