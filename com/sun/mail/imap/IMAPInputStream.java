package com.sun.mail.imap;

import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.util.FolderClosedIOException;
import com.sun.mail.util.MessageRemovedIOException;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.MessagingException;

/* loaded from: classes6.dex */
public class IMAPInputStream extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private IMAPMessage f37712a;

    /* renamed from: b  reason: collision with root package name */
    private String f37713b;

    /* renamed from: c  reason: collision with root package name */
    private int f37714c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f37715d;

    /* renamed from: e  reason: collision with root package name */
    private int f37716e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f37717f;

    /* renamed from: g  reason: collision with root package name */
    private int f37718g;

    /* renamed from: h  reason: collision with root package name */
    private int f37719h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f37720i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f37721j;

    /* renamed from: k  reason: collision with root package name */
    private ByteArray f37722k;

    public IMAPInputStream(IMAPMessage iMAPMessage, String str, int i4, boolean z3) {
        this.f37712a = iMAPMessage;
        this.f37713b = str;
        this.f37716e = i4;
        this.f37721j = z3;
        this.f37715d = iMAPMessage.t();
    }

    private void b() {
        if (this.f37721j) {
            return;
        }
        try {
            Folder folder = this.f37712a.getFolder();
            if (folder != null && folder.getMode() != 1) {
                IMAPMessage iMAPMessage = this.f37712a;
                Flags.Flag flag = Flags.Flag.SEEN;
                if (!iMAPMessage.isSet(flag)) {
                    this.f37712a.setFlag(flag, true);
                }
            }
        } catch (MessagingException unused) {
        }
    }

    private void c() throws IOException {
        int i4;
        int i5;
        BODY fetchBody;
        int i6;
        ByteArray byteArray;
        int i7;
        boolean z3;
        boolean z4;
        if (!this.f37720i && ((i4 = this.f37716e) == -1 || this.f37714c < i4)) {
            if (this.f37722k == null) {
                this.f37722k = new ByteArray(this.f37715d + 64);
            }
            synchronized (this.f37712a.u()) {
                try {
                    try {
                        IMAPProtocol v3 = this.f37712a.v();
                        if (!this.f37712a.isExpunged()) {
                            int w3 = this.f37712a.w();
                            i5 = this.f37715d;
                            int i8 = this.f37716e;
                            if (i8 != -1) {
                                int i9 = this.f37714c;
                                if (i9 + i5 > i8) {
                                    i5 = i8 - i9;
                                }
                            }
                            if (this.f37721j) {
                                fetchBody = v3.peekBody(w3, this.f37713b, this.f37714c, i5, this.f37722k);
                            } else {
                                fetchBody = v3.fetchBody(w3, this.f37713b, this.f37714c, i5, this.f37722k);
                            }
                            i6 = 0;
                            z4 = false;
                            i6 = 0;
                            z3 = false;
                            if (fetchBody == null || (byteArray = fetchBody.getByteArray()) == null) {
                                d();
                                byteArray = new ByteArray(0);
                            }
                        } else {
                            throw new MessageRemovedIOException("No content for expunged message");
                        }
                    } catch (FolderClosedException e4) {
                        throw new FolderClosedIOException(e4.getFolder(), e4.getMessage());
                    }
                } catch (ProtocolException e5) {
                    d();
                    throw new IOException(e5.getMessage());
                }
            }
            if (this.f37714c == 0) {
                b();
            }
            this.f37717f = byteArray.getBytes();
            this.f37719h = byteArray.getStart();
            int count = byteArray.getCount();
            if (fetchBody != null) {
                i7 = fetchBody.getOrigin();
            } else {
                i7 = this.f37714c;
            }
            if (i7 < 0) {
                if (this.f37714c == 0) {
                    if (count != i5) {
                        z4 = true;
                    }
                    this.f37720i = z4;
                    i6 = count;
                    this.f37718g = this.f37719h + i6;
                    this.f37714c += i6;
                    return;
                }
                this.f37720i = true;
                this.f37718g = this.f37719h + i6;
                this.f37714c += i6;
                return;
            } else if (i7 == this.f37714c) {
                if (count < i5) {
                    z3 = true;
                }
                this.f37720i = z3;
                i6 = count;
                this.f37718g = this.f37719h + i6;
                this.f37714c += i6;
                return;
            } else {
                this.f37720i = true;
                this.f37718g = this.f37719h + i6;
                this.f37714c += i6;
                return;
            }
        }
        if (this.f37714c == 0) {
            b();
        }
        this.f37722k = null;
    }

    private void d() throws MessageRemovedIOException, FolderClosedIOException {
        synchronized (this.f37712a.u()) {
            try {
                try {
                    this.f37712a.v().noop();
                } catch (ProtocolException unused) {
                } catch (FolderClosedException e4) {
                    throw new FolderClosedIOException(e4.getFolder(), e4.getMessage());
                }
            } catch (ConnectionException e5) {
                throw new FolderClosedIOException(this.f37712a.getFolder(), e5.getMessage());
            }
        }
        if (!this.f37712a.isExpunged()) {
            return;
        }
        throw new MessageRemovedIOException();
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        return this.f37718g - this.f37719h;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        if (this.f37719h >= this.f37718g) {
            c();
            if (this.f37719h >= this.f37718g) {
                return -1;
            }
        }
        byte[] bArr = this.f37717f;
        int i4 = this.f37719h;
        this.f37719h = i4 + 1;
        return bArr[i4] & 255;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = this.f37718g - this.f37719h;
        if (i6 <= 0) {
            c();
            i6 = this.f37718g - this.f37719h;
            if (i6 <= 0) {
                return -1;
            }
        }
        if (i6 < i5) {
            i5 = i6;
        }
        System.arraycopy(this.f37717f, this.f37719h, bArr, i4, i5);
        this.f37719h += i5;
        return i5;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
