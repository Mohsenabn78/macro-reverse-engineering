package com.sun.mail.pop3;

import com.sun.mail.util.MailLogger;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.MethodNotSupportedException;
import javax.mail.UIDFolder;

/* loaded from: classes6.dex */
public class POP3Folder extends Folder {

    /* renamed from: a  reason: collision with root package name */
    private String f37873a;

    /* renamed from: b  reason: collision with root package name */
    private POP3Store f37874b;

    /* renamed from: c  reason: collision with root package name */
    private volatile b f37875c;

    /* renamed from: d  reason: collision with root package name */
    private int f37876d;

    /* renamed from: e  reason: collision with root package name */
    private int f37877e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f37878f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f37879g;

    /* renamed from: h  reason: collision with root package name */
    private POP3Message[] f37880h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f37881i;

    /* renamed from: j  reason: collision with root package name */
    private volatile e f37882j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f37883k;

    /* renamed from: l  reason: collision with root package name */
    MailLogger f37884l;

    /* JADX INFO: Access modifiers changed from: protected */
    public POP3Folder(POP3Store pOP3Store, String str) {
        super(pOP3Store);
        this.f37878f = false;
        this.f37879g = false;
        this.f37881i = false;
        this.f37882j = null;
        this.f37873a = str;
        this.f37874b = pOP3Store;
        if (str.equalsIgnoreCase("INBOX")) {
            this.f37878f = true;
        }
        this.f37884l = new MailLogger(getClass(), "DEBUG POP3", pOP3Store.getSession().getDebug(), pOP3Store.getSession().getDebugOut());
    }

    private void b() throws IllegalStateException {
        if (!this.f37879g) {
            return;
        }
        throw new IllegalStateException("Folder is Open");
    }

    private void c() throws IllegalStateException {
        if (this.f37879g) {
            return;
        }
        throw new IllegalStateException("Folder is not Open");
    }

    private void d() throws IllegalStateException {
        int i4;
        if (this.f37879g && ((i4 = this.mode) == 1 || i4 == 2)) {
            return;
        }
        throw new IllegalStateException("Folder is not Readable");
    }

    @Override // javax.mail.Folder
    public void appendMessages(Message[] messageArr) throws MessagingException {
        throw new MethodNotSupportedException("Append not supported");
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z3) throws MessagingException {
        c();
        try {
            if (this.f37874b.f37905p && !this.f37883k) {
                this.f37875c.R();
            }
            if (z3 && this.mode == 2 && !this.f37883k) {
                int i4 = 0;
                while (true) {
                    POP3Message[] pOP3MessageArr = this.f37880h;
                    if (i4 >= pOP3MessageArr.length) {
                        break;
                    }
                    POP3Message pOP3Message = pOP3MessageArr[i4];
                    if (pOP3Message != null && pOP3Message.isSet(Flags.Flag.DELETED)) {
                        try {
                            this.f37875c.r(i4 + 1);
                        } catch (IOException e4) {
                            throw new MessagingException("Exception deleting messages during close", e4);
                        }
                    }
                    i4++;
                }
            }
            int i5 = 0;
            while (true) {
                POP3Message[] pOP3MessageArr2 = this.f37880h;
                if (i5 >= pOP3MessageArr2.length) {
                    break;
                }
                POP3Message pOP3Message2 = pOP3MessageArr2[i5];
                if (pOP3Message2 != null) {
                    pOP3Message2.invalidate(true);
                }
                i5++;
            }
            if (this.f37883k) {
                this.f37875c.q();
            } else {
                this.f37875c.L();
            }
            this.f37875c = null;
            this.f37874b.e(this);
            this.f37880h = null;
            this.f37879g = false;
            notifyConnectionListeners(3);
        } catch (IOException unused) {
            this.f37875c = null;
            this.f37874b.e(this);
            this.f37880h = null;
            this.f37879g = false;
            notifyConnectionListeners(3);
            if (this.f37882j != null) {
                this.f37882j.a();
            }
        }
        if (this.f37882j != null) {
            this.f37882j.a();
            this.f37882j = null;
        }
    }

    @Override // javax.mail.Folder
    public boolean create(int i4) throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public boolean delete(boolean z3) throws MessagingException {
        throw new MethodNotSupportedException("delete");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.sun.mail.pop3.POP3Message e(javax.mail.Folder r4, int r5) throws javax.mail.MessagingException {
        /*
            r3 = this;
            com.sun.mail.pop3.POP3Store r4 = r3.f37874b
            java.lang.reflect.Constructor<?> r4 = r4.f37904o
            if (r4 == 0) goto L1a
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L1a
            r1 = 0
            r0[r1] = r3     // Catch: java.lang.Exception -> L1a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> L1a
            r2 = 1
            r0[r2] = r1     // Catch: java.lang.Exception -> L1a
            java.lang.Object r4 = r4.newInstance(r0)     // Catch: java.lang.Exception -> L1a
            com.sun.mail.pop3.POP3Message r4 = (com.sun.mail.pop3.POP3Message) r4     // Catch: java.lang.Exception -> L1a
            goto L1b
        L1a:
            r4 = 0
        L1b:
            if (r4 != 0) goto L22
            com.sun.mail.pop3.POP3Message r4 = new com.sun.mail.pop3.POP3Message
            r4.<init>(r3, r5)
        L22:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Folder.e(javax.mail.Folder, int):com.sun.mail.pop3.POP3Message");
    }

    @Override // javax.mail.Folder
    public boolean exists() {
        return this.f37878f;
    }

    @Override // javax.mail.Folder
    public Message[] expunge() throws MessagingException {
        throw new MethodNotSupportedException("Expunge not supported");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e f() {
        return this.f37882j;
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        d();
        if (!this.f37881i && this.f37874b.f37908t && fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
            int length = this.f37880h.length;
            String[] strArr = new String[length];
            try {
                try {
                    if (!this.f37875c.f0(strArr)) {
                        return;
                    }
                    for (int i4 = 0; i4 < length; i4++) {
                        if (strArr[i4] != null) {
                            ((POP3Message) getMessage(i4 + 1)).f37888d = strArr[i4];
                        }
                    }
                    this.f37881i = true;
                } catch (EOFException e4) {
                    close(false);
                    throw new FolderClosedException(this, e4.toString());
                }
            } catch (IOException e5) {
                throw new MessagingException("error getting UIDL", e5);
            }
        }
        if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
            for (Message message : messageArr) {
                try {
                    POP3Message pOP3Message = (POP3Message) message;
                    pOP3Message.getHeader("");
                    pOP3Message.getSize();
                } catch (MessageRemovedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Folder
    public void finalize() throws Throwable {
        this.f37883k = !this.f37874b.f37913y;
        try {
            if (this.f37879g) {
                close(false);
            }
        } finally {
            super.finalize();
            this.f37883k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b g() throws MessagingException {
        b bVar = this.f37875c;
        c();
        return bVar;
    }

    @Override // javax.mail.Folder
    public Folder getFolder(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return this.f37873a;
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i4) throws MessagingException {
        POP3Message pOP3Message;
        c();
        int i5 = i4 - 1;
        pOP3Message = this.f37880h[i5];
        if (pOP3Message == null) {
            pOP3Message = e(this, i4);
            this.f37880h[i5] = pOP3Message;
        }
        return pOP3Message;
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        if (!this.f37879g) {
            return -1;
        }
        d();
        return this.f37876d;
    }

    @Override // javax.mail.Folder
    public String getName() {
        return this.f37873a;
    }

    @Override // javax.mail.Folder
    public Folder getParent() {
        return new DefaultFolder(this.f37874b);
    }

    @Override // javax.mail.Folder
    public Flags getPermanentFlags() {
        return new Flags();
    }

    @Override // javax.mail.Folder
    public char getSeparator() {
        return (char) 0;
    }

    public synchronized int getSize() throws MessagingException {
        c();
        return this.f37877e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0063, code lost:
        if (r2 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int[] getSizes() throws javax.mail.MessagingException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.c()     // Catch: java.lang.Throwable -> L68
            int r0 = r6.f37876d     // Catch: java.lang.Throwable -> L68
            int[] r0 = new int[r0]     // Catch: java.lang.Throwable -> L68
            r1 = 0
            com.sun.mail.pop3.b r2 = r6.f37875c     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L5b
            java.io.InputStream r2 = r2.F()     // Catch: java.lang.Throwable -> L4c java.io.IOException -> L5b
            com.sun.mail.util.LineInputStream r3 = new com.sun.mail.util.LineInputStream     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L5c
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L5c
        L14:
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L45 java.io.IOException -> L48
            if (r1 == 0) goto L3a
            java.util.StringTokenizer r4 = new java.util.StringTokenizer     // Catch: java.lang.RuntimeException -> L14 java.lang.Throwable -> L45 java.io.IOException -> L48
            r4.<init>(r1)     // Catch: java.lang.RuntimeException -> L14 java.lang.Throwable -> L45 java.io.IOException -> L48
            java.lang.String r1 = r4.nextToken()     // Catch: java.lang.RuntimeException -> L14 java.lang.Throwable -> L45 java.io.IOException -> L48
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.RuntimeException -> L14 java.lang.Throwable -> L45 java.io.IOException -> L48
            java.lang.String r4 = r4.nextToken()     // Catch: java.lang.RuntimeException -> L14 java.lang.Throwable -> L45 java.io.IOException -> L48
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.RuntimeException -> L14 java.lang.Throwable -> L45 java.io.IOException -> L48
            if (r1 <= 0) goto L14
            int r5 = r6.f37876d     // Catch: java.lang.RuntimeException -> L14 java.lang.Throwable -> L45 java.io.IOException -> L48
            if (r1 > r5) goto L14
            int r1 = r1 + (-1)
            r0[r1] = r4     // Catch: java.lang.RuntimeException -> L14 java.lang.Throwable -> L45 java.io.IOException -> L48
            goto L14
        L3a:
            r3.close()     // Catch: java.io.IOException -> L3e java.lang.Throwable -> L68
            goto L3f
        L3e:
        L3f:
            if (r2 == 0) goto L66
        L41:
            r2.close()     // Catch: java.io.IOException -> L66 java.lang.Throwable -> L68
            goto L66
        L45:
            r0 = move-exception
            r1 = r3
            goto L4e
        L48:
            r1 = r3
            goto L5c
        L4a:
            r0 = move-exception
            goto L4e
        L4c:
            r0 = move-exception
            r2 = r1
        L4e:
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.io.IOException -> L54 java.lang.Throwable -> L68
            goto L55
        L54:
        L55:
            if (r2 == 0) goto L5a
            r2.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L68
        L5a:
            throw r0     // Catch: java.lang.Throwable -> L68
        L5b:
            r2 = r1
        L5c:
            if (r1 == 0) goto L63
            r1.close()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L68
            goto L63
        L62:
        L63:
            if (r2 == 0) goto L66
            goto L41
        L66:
            monitor-exit(r6)
            return r0
        L68:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.POP3Folder.getSizes():int[]");
    }

    @Override // javax.mail.Folder
    public int getType() {
        return 1;
    }

    public synchronized String getUID(Message message) throws MessagingException {
        c();
        if (message instanceof POP3Message) {
            POP3Message pOP3Message = (POP3Message) message;
            try {
                if (!this.f37874b.f37908t) {
                    return null;
                }
                if (pOP3Message.f37888d == "UNKNOWN") {
                    pOP3Message.f37888d = this.f37875c.e0(pOP3Message.getMessageNumber());
                }
                return pOP3Message.f37888d;
            } catch (EOFException e4) {
                close(false);
                throw new FolderClosedException(this, e4.toString());
            } catch (IOException e5) {
                throw new MessagingException("error getting UIDL", e5);
            }
        }
        throw new MessagingException("message is not a POP3Message");
    }

    @Override // javax.mail.Folder
    public boolean hasNewMessages() throws MessagingException {
        return false;
    }

    @Override // javax.mail.Folder
    public synchronized boolean isOpen() {
        if (!this.f37879g) {
            return false;
        }
        try {
            try {
                if (this.f37875c.K()) {
                    return true;
                }
                throw new IOException("NOOP failed");
            } catch (IOException unused) {
                close(false);
                return false;
            }
        } catch (MessagingException unused2) {
            return false;
        }
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        throw new MessagingException("not a directory");
    }

    public synchronized InputStream listCommand() throws MessagingException, IOException {
        c();
        return this.f37875c.F();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Folder
    public void notifyMessageChangedListeners(int i4, Message message) {
        super.notifyMessageChangedListeners(i4, message);
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i4) throws MessagingException {
        POP3Store pOP3Store;
        b();
        if (this.f37878f) {
            try {
                this.f37875c = this.f37874b.g(this);
                d W = this.f37875c.W();
                this.f37876d = W.f37949a;
                this.f37877e = W.f37950b;
                this.mode = i4;
                if (this.f37874b.f37910v) {
                    try {
                        this.f37882j = new e(this.f37874b.f37911w);
                    } catch (IOException e4) {
                        this.f37884l.log(Level.FINE, "failed to create file cache", (Throwable) e4);
                        throw e4;
                    }
                }
                this.f37879g = true;
                this.f37880h = new POP3Message[this.f37876d];
                this.f37881i = false;
                notifyConnectionListeners(1);
            } catch (IOException e5) {
                try {
                    if (this.f37875c != null) {
                        this.f37875c.L();
                    }
                    this.f37875c = null;
                    pOP3Store = this.f37874b;
                } catch (IOException unused) {
                    this.f37875c = null;
                    pOP3Store = this.f37874b;
                } catch (Throwable th) {
                    this.f37875c = null;
                    this.f37874b.e(this);
                    throw th;
                }
                pOP3Store.e(this);
                throw new MessagingException("Open failed", e5);
            }
        } else {
            throw new FolderNotFoundException(this, "folder is not INBOX");
        }
    }

    @Override // javax.mail.Folder
    public boolean renameTo(Folder folder) throws MessagingException {
        throw new MethodNotSupportedException("renameTo");
    }
}
