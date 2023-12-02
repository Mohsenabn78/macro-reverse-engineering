package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.ENVELOPE;
import com.sun.mail.imap.protocol.IMAPProtocol;
import javax.mail.Flags;
import javax.mail.FolderClosedException;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;

/* loaded from: classes6.dex */
public class IMAPNestedMessage extends IMAPMessage {

    /* renamed from: p  reason: collision with root package name */
    private IMAPMessage f37749p;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMAPNestedMessage(IMAPMessage iMAPMessage, BODYSTRUCTURE bodystructure, ENVELOPE envelope, String str) {
        super(iMAPMessage.e());
        this.f37749p = iMAPMessage;
        this.f37723a = bodystructure;
        this.f37724b = envelope;
        this.f37731i = str;
        setPeek(iMAPMessage.getPeek());
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected boolean A() {
        return this.f37749p.A();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected boolean C() throws FolderClosedException {
        return this.f37749p.C();
    }

    @Override // com.sun.mail.imap.IMAPMessage, javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        return this.f37723a.size;
    }

    @Override // javax.mail.Message
    public boolean isExpunged() {
        return this.f37749p.isExpunged();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected void q() throws MessageRemovedException {
        this.f37749p.q();
    }

    @Override // com.sun.mail.imap.IMAPMessage, javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z3) throws MessagingException {
        throw new MethodNotSupportedException("Cannot set flags on this nested message");
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected int t() {
        return this.f37749p.t();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected Object u() {
        return this.f37749p.u();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected IMAPProtocol v() throws ProtocolException, FolderClosedException {
        return this.f37749p.v();
    }

    @Override // com.sun.mail.imap.IMAPMessage
    protected int w() {
        return this.f37749p.w();
    }
}
