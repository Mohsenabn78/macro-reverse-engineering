package com.sun.mail.imap;

import com.google.common.net.HttpHeaders;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.util.LineOutputStream;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.ReadableMime;
import com.sun.mail.util.SharedByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import javax.activation.DataHandler;
import javax.mail.FolderClosedException;
import javax.mail.Header;
import javax.mail.IllegalWriteException;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParameterList;

/* loaded from: classes6.dex */
public class IMAPBodyPart extends MimeBodyPart implements ReadableMime {

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f37637g = PropUtil.getBooleanSystemProperty("mail.mime.decodefilename", false);

    /* renamed from: a  reason: collision with root package name */
    private IMAPMessage f37638a;

    /* renamed from: b  reason: collision with root package name */
    private BODYSTRUCTURE f37639b;

    /* renamed from: c  reason: collision with root package name */
    private String f37640c;

    /* renamed from: d  reason: collision with root package name */
    private String f37641d;

    /* renamed from: e  reason: collision with root package name */
    private String f37642e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37643f = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPBodyPart(BODYSTRUCTURE bodystructure, String str, IMAPMessage iMAPMessage) {
        this.f37639b = bodystructure;
        this.f37640c = str;
        this.f37638a = iMAPMessage;
        this.f37641d = new ContentType(bodystructure.type, bodystructure.subtype, bodystructure.cParams).toString();
    }

    private InputStream a() throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        if (!this.f37638a.C()) {
            b();
        }
        synchronized (this.f37638a.u()) {
            try {
                try {
                    IMAPProtocol v3 = this.f37638a.v();
                    this.f37638a.q();
                    if (v3.isREV1()) {
                        int w3 = this.f37638a.w();
                        BODY peekBody = v3.peekBody(w3, this.f37640c + ".MIME");
                        if (peekBody != null) {
                            byteArrayInputStream = peekBody.getByteArrayInputStream();
                            if (byteArrayInputStream == null) {
                                throw new MessagingException("Failed to fetch headers");
                            }
                        } else {
                            throw new MessagingException("Failed to fetch headers");
                        }
                    } else {
                        SharedByteArrayOutputStream sharedByteArrayOutputStream = new SharedByteArrayOutputStream(0);
                        LineOutputStream lineOutputStream = new LineOutputStream(sharedByteArrayOutputStream);
                        try {
                            Enumeration<String> allHeaderLines = super.getAllHeaderLines();
                            while (allHeaderLines.hasMoreElements()) {
                                lineOutputStream.writeln(allHeaderLines.nextElement());
                            }
                            lineOutputStream.writeln();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            try {
                                lineOutputStream.close();
                            } catch (IOException unused2) {
                            }
                            throw th;
                        }
                        try {
                            lineOutputStream.close();
                        } catch (IOException unused3) {
                            return sharedByteArrayOutputStream.toStream();
                        }
                    }
                } catch (ConnectionException e4) {
                    throw new FolderClosedException(this.f37638a.getFolder(), e4.getMessage());
                } catch (ProtocolException e5) {
                    throw new MessagingException(e5.getMessage(), e5);
                }
            } finally {
            }
        }
        return byteArrayInputStream;
    }

    private synchronized void b() throws MessagingException {
        if (this.f37643f) {
            return;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        synchronized (this.f37638a.u()) {
            try {
                IMAPProtocol v3 = this.f37638a.v();
                this.f37638a.q();
                if (v3.isREV1()) {
                    int w3 = this.f37638a.w();
                    BODY peekBody = v3.peekBody(w3, this.f37640c + ".MIME");
                    if (peekBody != null) {
                        ByteArrayInputStream byteArrayInputStream = peekBody.getByteArrayInputStream();
                        if (byteArrayInputStream != null) {
                            this.headers.load(byteArrayInputStream);
                        } else {
                            throw new MessagingException("Failed to fetch headers");
                        }
                    } else {
                        throw new MessagingException("Failed to fetch headers");
                    }
                } else {
                    this.headers.addHeader("Content-Type", this.f37641d);
                    this.headers.addHeader("Content-Transfer-Encoding", this.f37639b.encoding);
                    String str = this.f37639b.description;
                    if (str != null) {
                        this.headers.addHeader("Content-Description", str);
                    }
                    String str2 = this.f37639b.id;
                    if (str2 != null) {
                        this.headers.addHeader("Content-ID", str2);
                    }
                    String str3 = this.f37639b.md5;
                    if (str3 != null) {
                        this.headers.addHeader(HttpHeaders.CONTENT_MD5, str3);
                    }
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.f37638a.getFolder(), e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        this.f37643f = true;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration<String> getAllHeaderLines() throws MessagingException {
        b();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration<Header> getAllHeaders() throws MessagingException {
        b();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        return this.f37639b.id;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        return this.f37639b.md5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeBodyPart
    public InputStream getContentStream() throws MessagingException {
        BODY fetchBody;
        ByteArrayInputStream byteArrayInputStream;
        boolean peek = this.f37638a.getPeek();
        synchronized (this.f37638a.u()) {
            try {
                IMAPProtocol v3 = this.f37638a.v();
                this.f37638a.q();
                if (v3.isREV1()) {
                    int i4 = -1;
                    if (this.f37638a.t() != -1) {
                        IMAPMessage iMAPMessage = this.f37638a;
                        String str = this.f37640c;
                        if (!iMAPMessage.A()) {
                            i4 = this.f37639b.size;
                        }
                        return new IMAPInputStream(iMAPMessage, str, i4, peek);
                    }
                }
                int w3 = this.f37638a.w();
                if (peek) {
                    fetchBody = v3.peekBody(w3, this.f37640c);
                } else {
                    fetchBody = v3.fetchBody(w3, this.f37640c);
                }
                if (fetchBody != null) {
                    byteArrayInputStream = fetchBody.getByteArrayInputStream();
                } else {
                    byteArrayInputStream = null;
                }
                if (byteArrayInputStream == null) {
                    this.f37638a.s();
                    return new ByteArrayInputStream(new byte[0]);
                }
                return byteArrayInputStream;
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.f37638a.getFolder(), e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getContentType() throws MessagingException {
        return this.f37641d;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        if (this.dh == null) {
            if (this.f37639b.isMulti()) {
                this.dh = new DataHandler(new IMAPMultipartDataSource(this, this.f37639b.bodies, this.f37640c, this.f37638a));
            } else if (this.f37639b.isNested() && this.f37638a.C() && this.f37639b.envelope != null) {
                IMAPMessage iMAPMessage = this.f37638a;
                BODYSTRUCTURE bodystructure = this.f37639b;
                this.dh = new DataHandler(new IMAPNestedMessage(iMAPMessage, bodystructure.bodies[0], bodystructure.envelope, this.f37640c), this.f37641d);
            }
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDescription() throws MessagingException {
        String str = this.f37642e;
        if (str != null) {
            return str;
        }
        String str2 = this.f37639b.description;
        if (str2 == null) {
            return null;
        }
        try {
            this.f37642e = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f37642e = this.f37639b.description;
        }
        return this.f37642e;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getDisposition() throws MessagingException {
        return this.f37639b.disposition;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        return this.f37639b.encoding;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String getFileName() throws MessagingException {
        String str;
        ParameterList parameterList;
        ParameterList parameterList2 = this.f37639b.dParams;
        if (parameterList2 != null) {
            str = parameterList2.get("filename");
        } else {
            str = null;
        }
        if ((str == null || str.isEmpty()) && (parameterList = this.f37639b.cParams) != null) {
            str = parameterList.get("name");
        }
        if (f37637g && str != null) {
            try {
                return MimeUtility.decodeText(str);
            } catch (UnsupportedEncodingException e4) {
                throw new MessagingException("Can't decode filename", e4);
            }
        }
        return str;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        b();
        return super.getHeader(str);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getLineCount() throws MessagingException {
        return this.f37639b.lines;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration<String> getMatchingHeaderLines(String[] strArr) throws MessagingException {
        b();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration<Header> getMatchingHeaders(String[] strArr) throws MessagingException {
        b();
        return super.getMatchingHeaders(strArr);
    }

    @Override // com.sun.mail.util.ReadableMime
    public InputStream getMimeStream() throws MessagingException {
        return new SequenceInputStream(a(), getContentStream());
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public Enumeration<String> getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        b();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public Enumeration<Header> getNonMatchingHeaders(String[] strArr) throws MessagingException {
        b();
        return super.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.f37639b.size;
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setContent(Object obj, String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.internet.MimePart
    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart
    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    @Override // javax.mail.internet.MimeBodyPart, javax.mail.Part
    public void setContent(Multipart multipart) throws MessagingException {
        throw new IllegalWriteException("IMAPBodyPart is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeBodyPart
    public void updateHeaders() {
    }
}
