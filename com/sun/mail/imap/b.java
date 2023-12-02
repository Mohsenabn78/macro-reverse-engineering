package com.sun.mail.imap;

import com.sun.mail.iap.Literal;
import com.sun.mail.util.CRLFOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.mail.Message;
import javax.mail.MessagingException;

/* compiled from: IMAPFolder.java */
/* loaded from: classes6.dex */
class b implements Literal {

    /* renamed from: a  reason: collision with root package name */
    private Message f37814a;

    /* renamed from: b  reason: collision with root package name */
    private int f37815b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f37816c;

    public b(Message message, int i4) throws MessagingException, IOException {
        this.f37815b = -1;
        this.f37814a = message;
        a aVar = new a(i4);
        CRLFOutputStream cRLFOutputStream = new CRLFOutputStream(aVar);
        message.writeTo(cRLFOutputStream);
        cRLFOutputStream.flush();
        this.f37815b = aVar.c();
        this.f37816c = aVar.b();
    }

    @Override // com.sun.mail.iap.Literal
    public int size() {
        return this.f37815b;
    }

    @Override // com.sun.mail.iap.Literal
    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = this.f37816c;
            if (bArr != null) {
                outputStream.write(bArr, 0, this.f37815b);
                return;
            }
            this.f37814a.writeTo(new CRLFOutputStream(outputStream));
        } catch (MessagingException e4) {
            throw new IOException("MessagingException while appending message: " + e4);
        }
    }
}
