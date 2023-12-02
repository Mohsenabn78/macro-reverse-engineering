package com.sun.mail.pop3;

import com.sun.mail.util.MailLogger;
import com.sun.mail.util.ReadableMime;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.util.Enumeration;
import java.util.logging.Level;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.Header;
import javax.mail.IllegalWriteException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.SharedInputStream;

/* loaded from: classes6.dex */
public class POP3Message extends MimeMessage implements ReadableMime {

    /* renamed from: a  reason: collision with root package name */
    private POP3Folder f37885a;

    /* renamed from: b  reason: collision with root package name */
    private int f37886b;

    /* renamed from: c  reason: collision with root package name */
    private int f37887c;

    /* renamed from: d  reason: collision with root package name */
    String f37888d;

    /* renamed from: e  reason: collision with root package name */
    private SoftReference<InputStream> f37889e;

    public POP3Message(Folder folder, int i4) throws MessagingException {
        super(folder, i4);
        this.f37886b = -1;
        this.f37887c = -1;
        this.f37888d = "UNKNOWN";
        this.f37889e = new SoftReference<>(null);
        this.f37885a = (POP3Folder) folder;
    }

    private InputStream a(boolean z3) throws MessagingException {
        InputStream inputStream;
        long j4;
        int i4;
        int i5;
        try {
            synchronized (this) {
                inputStream = this.f37889e.get();
                if (inputStream == null) {
                    e f4 = this.f37885a.f();
                    if (f4 != null) {
                        if (this.f37885a.f37884l.isLoggable(Level.FINE)) {
                            this.f37885a.f37884l.fine("caching message #" + this.msgnum + " in temp file");
                        }
                        a b4 = f4.b();
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(b4);
                        this.f37885a.g().Q(this.msgnum, bufferedOutputStream);
                        bufferedOutputStream.close();
                        inputStream = b4.b();
                    } else {
                        b g4 = this.f37885a.g();
                        int i6 = this.msgnum;
                        int i7 = this.f37887c;
                        if (i7 > 0) {
                            i4 = i7 + this.f37886b;
                        } else {
                            i4 = 0;
                        }
                        inputStream = g4.P(i6, i4);
                    }
                    if (inputStream != null) {
                        if (this.headers != null && !((POP3Store) this.f37885a.getStore()).f37907s) {
                            do {
                                i5 = 0;
                                while (true) {
                                    int read = inputStream.read();
                                    if (read < 0 || read == 10) {
                                        break;
                                    } else if (read == 13) {
                                        if (inputStream.available() > 0) {
                                            inputStream.mark(1);
                                            if (inputStream.read() != 10) {
                                                inputStream.reset();
                                            }
                                        }
                                    } else {
                                        i5++;
                                    }
                                }
                                if (inputStream.available() == 0) {
                                    break;
                                }
                            } while (i5 != 0);
                            this.f37886b = (int) ((SharedInputStream) inputStream).getPosition();
                            this.f37887c = inputStream.available();
                            this.f37889e = new SoftReference<>(inputStream);
                        }
                        this.headers = new InternetHeaders(inputStream);
                        this.f37886b = (int) ((SharedInputStream) inputStream).getPosition();
                        this.f37887c = inputStream.available();
                        this.f37889e = new SoftReference<>(inputStream);
                    } else {
                        this.expunged = true;
                        throw new MessageRemovedException("can't retrieve message #" + this.msgnum + " in POP3Message.getContentStream");
                    }
                }
            }
            SharedInputStream sharedInputStream = (SharedInputStream) inputStream;
            if (z3) {
                j4 = this.f37886b;
            } else {
                j4 = 0;
            }
            return sharedInputStream.newStream(j4, -1L);
        } catch (EOFException e4) {
            this.f37885a.close(false);
            throw new FolderClosedException(this.f37885a, e4.toString());
        } catch (IOException e5) {
            throw new MessagingException("error fetching POP3 content", e5);
        }
    }

    private void b() throws MessagingException {
        boolean z3;
        InputStream c02;
        try {
            synchronized (this) {
                if (this.headers != null) {
                    return;
                }
                if (!((POP3Store) this.f37885a.getStore()).f37906r && (c02 = this.f37885a.g().c0(this.msgnum, 0)) != null) {
                    this.f37886b = c02.available();
                    this.headers = new InternetHeaders(c02);
                    c02.close();
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    InputStream contentStream = getContentStream();
                    if (contentStream != null) {
                        contentStream.close();
                    }
                }
            }
        } catch (EOFException e4) {
            this.f37885a.close(false);
            throw new FolderClosedException(this.f37885a, e4.toString());
        } catch (IOException e5) {
            throw new MessagingException("error loading POP3 headers", e5);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration<String> getAllHeaderLines() throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration<Header> getAllHeaders() throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getAllHeaders();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeMessage
    public synchronized InputStream getContentStream() throws MessagingException {
        InputStream inputStream = this.contentStream;
        if (inputStream != null) {
            return ((SharedInputStream) inputStream).newStream(0L, -1L);
        }
        InputStream a4 = a(true);
        if (this.f37885a.f() != null || ((POP3Store) this.f37885a.getStore()).f37912x) {
            this.contentStream = ((SharedInputStream) a4).newStream(0L, -1L);
        }
        return a4;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getHeader(str);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration<String> getMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration<Header> getMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getMatchingHeaders(strArr);
    }

    @Override // com.sun.mail.util.ReadableMime
    public InputStream getMimeStream() throws MessagingException {
        return a(false);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration<String> getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration<Header> getNonMatchingHeaders(String[] strArr) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getNonMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        int i4;
        try {
            synchronized (this) {
                int i5 = this.f37887c;
                if (i5 > 0) {
                    return i5;
                }
                if (this.headers == null) {
                    b();
                }
                synchronized (this) {
                    if (this.f37887c < 0) {
                        this.f37887c = this.f37885a.g().E(this.msgnum) - this.f37886b;
                    }
                    i4 = this.f37887c;
                }
                return i4;
            }
        } catch (EOFException e4) {
            this.f37885a.close(false);
            throw new FolderClosedException(this.f37885a, e4.toString());
        } catch (IOException e5) {
            throw new MessagingException("error getting size", e5);
        }
    }

    public synchronized void invalidate(boolean z3) {
        this.content = null;
        InputStream inputStream = this.f37889e.get();
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            this.f37889e = new SoftReference<>(null);
        }
        InputStream inputStream2 = this.contentStream;
        if (inputStream2 != null) {
            try {
                inputStream2.close();
            } catch (IOException unused2) {
            }
            this.contentStream = null;
        }
        this.f37887c = -1;
        if (z3) {
            this.headers = null;
            this.f37886b = -1;
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void saveChanges() throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z3) throws MessagingException {
        super.setFlags(flags, z3);
        if (!this.flags.equals((Flags) this.flags.clone())) {
            this.f37885a.notifyMessageChangedListeners(1, this);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("POP3 messages are read-only");
    }

    public InputStream top(int i4) throws MessagingException {
        InputStream c02;
        try {
            synchronized (this) {
                c02 = this.f37885a.g().c0(this.msgnum, i4);
            }
            return c02;
        } catch (EOFException e4) {
            this.f37885a.close(false);
            throw new FolderClosedException(this.f37885a, e4.toString());
        } catch (IOException e5) {
            throw new MessagingException("error getting size", e5);
        }
    }

    @Override // javax.mail.internet.MimeMessage
    public synchronized void writeTo(OutputStream outputStream, String[] strArr) throws IOException, MessagingException {
        InputStream inputStream = this.f37889e.get();
        if (inputStream == null && strArr == null && !((POP3Store) this.f37885a.getStore()).f37909u) {
            if (this.f37885a.f37884l.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.f37885a.f37884l;
                mailLogger.fine("streaming msg " + this.msgnum);
            }
            if (!this.f37885a.g().Q(this.msgnum, outputStream)) {
                this.expunged = true;
                throw new MessageRemovedException("can't retrieve message #" + this.msgnum + " in POP3Message.writeTo");
            }
        } else if (inputStream != null && strArr == null) {
            InputStream newStream = ((SharedInputStream) inputStream).newStream(0L, -1L);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = newStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            newStream.close();
        } else {
            super.writeTo(outputStream, strArr);
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        if (this.headers == null) {
            b();
        }
        return this.headers.getHeader(str, str2);
    }
}
