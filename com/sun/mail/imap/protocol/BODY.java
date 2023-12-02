package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

/* loaded from: classes6.dex */
public class BODY implements Item {

    /* renamed from: f  reason: collision with root package name */
    static final char[] f37824f = {'B', 'O', 'D', 'Y'};

    /* renamed from: a  reason: collision with root package name */
    private final int f37825a;

    /* renamed from: b  reason: collision with root package name */
    private final ByteArray f37826b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37827c;

    /* renamed from: d  reason: collision with root package name */
    private final int f37828d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f37829e;

    public BODY(FetchResponse fetchResponse) throws ParsingException {
        this.f37825a = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() == 91) {
            String readString = fetchResponse.readString(']');
            this.f37827c = readString;
            if (fetchResponse.readByte() == 93) {
                this.f37829e = readString.regionMatches(true, 0, "HEADER", 0, 6);
                if (fetchResponse.readByte() == 60) {
                    this.f37828d = fetchResponse.readNumber();
                    fetchResponse.skip(1);
                } else {
                    this.f37828d = -1;
                }
                this.f37826b = fetchResponse.readByteArray();
                return;
            }
            throw new ParsingException("BODY parse error: missing ``]'' at section end");
        }
        throw new ParsingException("BODY parse error: missing ``['' at section start");
    }

    public ByteArray getByteArray() {
        return this.f37826b;
    }

    public ByteArrayInputStream getByteArrayInputStream() {
        ByteArray byteArray = this.f37826b;
        if (byteArray != null) {
            return byteArray.toByteArrayInputStream();
        }
        return null;
    }

    public int getOrigin() {
        return this.f37828d;
    }

    public String getSection() {
        return this.f37827c;
    }

    public boolean isHeader() {
        return this.f37829e;
    }
}
