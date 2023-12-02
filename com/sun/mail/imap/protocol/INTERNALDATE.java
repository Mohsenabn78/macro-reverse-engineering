package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.mail.internet.MailDateFormat;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes6.dex */
public class INTERNALDATE implements Item {

    /* renamed from: b  reason: collision with root package name */
    static final char[] f37858b = {'I', 'N', 'T', 'E', 'R', 'N', 'A', 'L', 'D', 'A', 'T', 'E'};

    /* renamed from: c  reason: collision with root package name */
    private static final MailDateFormat f37859c = new MailDateFormat();

    /* renamed from: d  reason: collision with root package name */
    private static SimpleDateFormat f37860d = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss ", Locale.US);

    /* renamed from: a  reason: collision with root package name */
    protected Date f37861a;
    public int msgno;

    public INTERNALDATE(FetchResponse fetchResponse) throws ParsingException {
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        String readString = fetchResponse.readString();
        if (readString != null) {
            try {
                MailDateFormat mailDateFormat = f37859c;
                synchronized (mailDateFormat) {
                    this.f37861a = mailDateFormat.parse(readString);
                }
                return;
            } catch (ParseException unused) {
                throw new ParsingException("INTERNALDATE parse error");
            }
        }
        throw new ParsingException("INTERNALDATE is NIL");
    }

    public static String format(Date date) {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (f37860d) {
            f37860d.format(date, stringBuffer, new FieldPosition(0));
        }
        int offset = (TimeZone.getDefault().getOffset(date.getTime()) / 60) / 1000;
        if (offset < 0) {
            stringBuffer.append(SignatureVisitor.SUPER);
            offset = -offset;
        } else {
            stringBuffer.append(SignatureVisitor.EXTENDS);
        }
        int i4 = offset / 60;
        int i5 = offset % 60;
        stringBuffer.append(Character.forDigit(i4 / 10, 10));
        stringBuffer.append(Character.forDigit(i4 % 10, 10));
        stringBuffer.append(Character.forDigit(i5 / 10, 10));
        stringBuffer.append(Character.forDigit(i5 % 10, 10));
        return stringBuffer.toString();
    }

    public Date getDate() {
        return this.f37861a;
    }
}
