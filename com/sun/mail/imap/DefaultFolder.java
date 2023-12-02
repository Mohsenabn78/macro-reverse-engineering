package com.sun.mail.imap;

import com.sun.mail.iap.ProtocolException;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.ListInfo;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import kotlin.jvm.internal.CharCompanionObject;

/* loaded from: classes6.dex */
public class DefaultFolder extends IMAPFolder {

    /* loaded from: classes6.dex */
    class a implements IMAPFolder.ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f37633a;

        a(String str) {
            this.f37633a = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.list("", this.f37633a);
        }
    }

    /* loaded from: classes6.dex */
    class b implements IMAPFolder.ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f37635a;

        b(String str) {
            this.f37635a = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.lsub("", this.f37635a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DefaultFolder(IMAPStore iMAPStore) {
        super("", CharCompanionObject.MAX_VALUE, iMAPStore, null);
        this.f37650g = true;
        this.f37646c = 2;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Cannot append to Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean delete(boolean z3) throws MessagingException {
        throw new MethodNotSupportedException("Cannot delete Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Cannot expunge Default Folder");
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        return ((IMAPStore) this.store).y(str, CharCompanionObject.MAX_VALUE);
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public synchronized String getName() {
        return this.f37644a;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public Folder getParent() {
        return null;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public synchronized Folder[] list(String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new a(str));
        if (listInfoArr == null) {
            return new Folder[0];
        }
        int length = listInfoArr.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i4 = 0; i4 < length; i4++) {
            iMAPFolderArr[i4] = ((IMAPStore) this.store).x(listInfoArr[i4]);
        }
        return iMAPFolderArr;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public synchronized Folder[] listSubscribed(String str) throws MessagingException {
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new b(str));
        if (listInfoArr == null) {
            return new Folder[0];
        }
        int length = listInfoArr.length;
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[length];
        for (int i4 = 0; i4 < length; i4++) {
            iMAPFolderArr[i4] = ((IMAPStore) this.store).x(listInfoArr[i4]);
        }
        return iMAPFolderArr;
    }

    @Override // com.sun.mail.imap.IMAPFolder, javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("Cannot rename Default Folder");
    }
}
