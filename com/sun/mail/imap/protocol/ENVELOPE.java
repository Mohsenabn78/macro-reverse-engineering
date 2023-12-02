package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import com.sun.mail.util.PropUtil;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MailDateFormat;

/* loaded from: classes6.dex */
public class ENVELOPE implements Item {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f37836a = {'E', 'N', 'V', 'E', 'L', 'O', 'P', 'E'};

    /* renamed from: b  reason: collision with root package name */
    private static final MailDateFormat f37837b = new MailDateFormat();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f37838c = PropUtil.getBooleanSystemProperty("mail.imap.parse.debug", false);
    public InternetAddress[] bcc;
    public InternetAddress[] cc;
    public Date date;
    public InternetAddress[] from;
    public String inReplyTo;
    public String messageId;
    public int msgno;
    public InternetAddress[] replyTo;
    public InternetAddress[] sender;
    public String subject;
    public InternetAddress[] to;

    public ENVELOPE(FetchResponse fetchResponse) throws ParsingException {
        this.date = null;
        if (f37838c) {
            System.out.println("parse ENVELOPE");
        }
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() == 40) {
            String readString = fetchResponse.readString();
            if (readString != null) {
                try {
                    MailDateFormat mailDateFormat = f37837b;
                    synchronized (mailDateFormat) {
                        this.date = mailDateFormat.parse(readString);
                    }
                } catch (ParseException unused) {
                }
            }
            boolean z3 = f37838c;
            if (z3) {
                PrintStream printStream = System.out;
                printStream.println("  Date: " + this.date);
            }
            this.subject = fetchResponse.readString();
            if (z3) {
                PrintStream printStream2 = System.out;
                printStream2.println("  Subject: " + this.subject);
            }
            if (z3) {
                System.out.println("  From addresses:");
            }
            this.from = a(fetchResponse);
            if (z3) {
                System.out.println("  Sender addresses:");
            }
            this.sender = a(fetchResponse);
            if (z3) {
                System.out.println("  Reply-To addresses:");
            }
            this.replyTo = a(fetchResponse);
            if (z3) {
                System.out.println("  To addresses:");
            }
            this.to = a(fetchResponse);
            if (z3) {
                System.out.println("  Cc addresses:");
            }
            this.cc = a(fetchResponse);
            if (z3) {
                System.out.println("  Bcc addresses:");
            }
            this.bcc = a(fetchResponse);
            this.inReplyTo = fetchResponse.readString();
            if (z3) {
                PrintStream printStream3 = System.out;
                printStream3.println("  In-Reply-To: " + this.inReplyTo);
            }
            this.messageId = fetchResponse.readString();
            if (z3) {
                PrintStream printStream4 = System.out;
                printStream4.println("  Message-ID: " + this.messageId);
            }
            if (fetchResponse.isNextNonSpace(')')) {
                return;
            }
            throw new ParsingException("ENVELOPE parse error");
        }
        throw new ParsingException("ENVELOPE parse error");
    }

    private InternetAddress[] a(Response response) throws ParsingException {
        response.skipSpaces();
        byte readByte = response.readByte();
        if (readByte == 40) {
            if (response.isNextNonSpace(')')) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            do {
                a aVar = new a(response);
                if (f37838c) {
                    PrintStream printStream = System.out;
                    printStream.println("    Address: " + aVar);
                }
                if (!aVar.a()) {
                    arrayList.add(aVar);
                }
            } while (!response.isNextNonSpace(')'));
            return (InternetAddress[]) arrayList.toArray(new InternetAddress[arrayList.size()]);
        } else if (readByte != 78 && readByte != 110) {
            throw new ParsingException("ADDRESS parse error");
        } else {
            response.skip(2);
            return null;
        }
    }
}
