package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ParsingException;
import java.io.ByteArrayInputStream;

/* loaded from: classes6.dex */
public class RFC822DATA implements Item {

    /* renamed from: d  reason: collision with root package name */
    static final char[] f37863d = {'R', 'F', 'C', '8', '2', '2'};

    /* renamed from: a  reason: collision with root package name */
    private final int f37864a;

    /* renamed from: b  reason: collision with root package name */
    private final ByteArray f37865b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37866c;

    public RFC822DATA(FetchResponse fetchResponse) throws ParsingException {
        this(fetchResponse, false);
    }

    public ByteArray getByteArray() {
        return this.f37865b;
    }

    public ByteArrayInputStream getByteArrayInputStream() {
        ByteArray byteArray = this.f37865b;
        if (byteArray != null) {
            return byteArray.toByteArrayInputStream();
        }
        return null;
    }

    public boolean isHeader() {
        return this.f37866c;
    }

    public RFC822DATA(FetchResponse fetchResponse, boolean z3) throws ParsingException {
        this.f37866c = z3;
        this.f37864a = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        this.f37865b = fetchResponse.readByteArray();
    }
}
