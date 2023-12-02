package com.sun.mail.imap;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.api.client.googleapis.notifications.ResourceStates;
import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.IMAPMessage;
import com.sun.mail.imap.protocol.FetchItem;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.IMAPResponse;
import com.sun.mail.imap.protocol.Item;
import com.sun.mail.imap.protocol.ListInfo;
import com.sun.mail.imap.protocol.MailboxInfo;
import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.Status;
import com.sun.mail.imap.protocol.UID;
import com.sun.mail.imap.protocol.UIDSet;
import com.sun.mail.util.MailLogger;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.FolderNotFoundException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Quota;
import javax.mail.ReadOnlyFolderException;
import javax.mail.StoreClosedException;
import javax.mail.UIDFolder;
import javax.mail.event.MailEvent;
import javax.mail.event.MessageChangedEvent;
import javax.mail.event.MessageCountListener;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes6.dex */
public class IMAPFolder extends Folder implements UIDFolder, ResponseHandler {
    private Status A;
    private long B;
    private boolean C;
    protected MailLogger D;
    private MailLogger E;

    /* renamed from: a  reason: collision with root package name */
    protected volatile String f37644a;

    /* renamed from: b  reason: collision with root package name */
    protected String f37645b;

    /* renamed from: c  reason: collision with root package name */
    protected int f37646c;

    /* renamed from: d  reason: collision with root package name */
    protected char f37647d;

    /* renamed from: e  reason: collision with root package name */
    protected Flags f37648e;

    /* renamed from: f  reason: collision with root package name */
    protected Flags f37649f;

    /* renamed from: g  reason: collision with root package name */
    protected volatile boolean f37650g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f37651h;

    /* renamed from: i  reason: collision with root package name */
    protected volatile String[] f37652i;

    /* renamed from: j  reason: collision with root package name */
    protected volatile IMAPProtocol f37653j;

    /* renamed from: k  reason: collision with root package name */
    protected MessageCache f37654k;

    /* renamed from: l  reason: collision with root package name */
    protected final Object f37655l;

    /* renamed from: m  reason: collision with root package name */
    protected Hashtable<Long, IMAPMessage> f37656m;

    /* renamed from: n  reason: collision with root package name */
    private volatile boolean f37657n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f37658o;

    /* renamed from: p  reason: collision with root package name */
    private int f37659p;

    /* renamed from: r  reason: collision with root package name */
    private IdleManager f37660r;

    /* renamed from: s  reason: collision with root package name */
    private volatile int f37661s;

    /* renamed from: t  reason: collision with root package name */
    private volatile int f37662t;

    /* renamed from: u  reason: collision with root package name */
    private int f37663u;

    /* renamed from: v  reason: collision with root package name */
    private long f37664v;

    /* renamed from: w  reason: collision with root package name */
    private long f37665w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f37666x;

    /* renamed from: y  reason: collision with root package name */
    private volatile long f37667y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f37668z;

    /* loaded from: classes6.dex */
    public static class FetchProfileItem extends FetchProfile.Item {
        public static final FetchProfileItem HEADERS = new FetchProfileItem("HEADERS");
        @Deprecated
        public static final FetchProfileItem SIZE = new FetchProfileItem("SIZE");
        public static final FetchProfileItem MESSAGE = new FetchProfileItem("MESSAGE");
        public static final FetchProfileItem INTERNALDATE = new FetchProfileItem("INTERNALDATE");

        protected FetchProfileItem(String str) {
            super(str);
        }
    }

    /* loaded from: classes6.dex */
    public interface ProtocolCommand {
        Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException;
    }

    /* loaded from: classes6.dex */
    class a implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Flags f37669a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Date f37670b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.sun.mail.imap.b f37671c;

        a(Flags flags, Date date, com.sun.mail.imap.b bVar) {
            this.f37669a = flags;
            this.f37670b = date;
            this.f37671c = bVar;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.append(IMAPFolder.this.f37644a, this.f37669a, this.f37670b, this.f37671c);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Flags f37673a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Date f37674b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.sun.mail.imap.b f37675c;

        b(Flags flags, Date date, com.sun.mail.imap.b bVar) {
            this.f37673a = flags;
            this.f37674b = date;
            this.f37675c = bVar;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.appenduid(IMAPFolder.this.f37644a, this.f37673a, this.f37674b, this.f37675c);
        }
    }

    /* loaded from: classes6.dex */
    class c implements ProtocolCommand {
        c() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.getQuotaRoot(IMAPFolder.this.f37644a);
        }
    }

    /* loaded from: classes6.dex */
    class d implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Quota f37678a;

        d(Quota quota) {
            this.f37678a = quota;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.setQuota(this.f37678a);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class e implements ProtocolCommand {
        e() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.getACL(IMAPFolder.this.f37644a);
        }
    }

    /* loaded from: classes6.dex */
    class f implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f37681a;

        f(String str) {
            this.f37681a = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.deleteACL(IMAPFolder.this.f37644a, this.f37681a);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class g implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f37683a;

        g(String str) {
            this.f37683a = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.listRights(IMAPFolder.this.f37644a, this.f37683a);
        }
    }

    /* loaded from: classes6.dex */
    class h implements ProtocolCommand {
        h() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.myRights(IMAPFolder.this.f37644a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class i implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ char f37686a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ACL f37687b;

        i(char c4, ACL acl) {
            this.f37686a = c4;
            this.f37687b = acl;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.setACL(IMAPFolder.this.f37644a, this.f37686a, this.f37687b);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class j implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ IdleManager f37689a;

        j(IdleManager idleManager) {
            this.f37689a = idleManager;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            IdleManager idleManager;
            if (IMAPFolder.this.f37659p == 1 && (idleManager = this.f37689a) != null && idleManager == IMAPFolder.this.f37660r) {
                return Boolean.TRUE;
            }
            if (IMAPFolder.this.f37659p == 0) {
                iMAPProtocol.idleStart();
                IMAPFolder.this.D.finest("startIdle: set to IDLE");
                IMAPFolder.this.f37659p = 1;
                IMAPFolder.this.f37660r = this.f37689a;
                return Boolean.TRUE;
            }
            try {
                IMAPFolder.this.f37655l.wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class k implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f37691a;

        k(String str) {
            this.f37691a = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.list("", this.f37691a);
        }
    }

    /* loaded from: classes6.dex */
    class l implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f37693a;

        l(Map map) {
            this.f37693a = map;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.id(this.f37693a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class m implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f37695a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ char f37696b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f37697c;

        m(boolean z3, char c4, String str) {
            this.f37695a = z3;
            this.f37696b = c4;
            this.f37697c = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            if (this.f37695a) {
                return iMAPProtocol.lsub("", IMAPFolder.this.f37644a + this.f37696b + this.f37697c);
            }
            return iMAPProtocol.list("", IMAPFolder.this.f37644a + this.f37696b + this.f37697c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class n implements ProtocolCommand {
        n() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            if (iMAPProtocol.isREV1()) {
                return iMAPProtocol.list(IMAPFolder.this.f37644a, "");
            }
            return iMAPProtocol.list("", IMAPFolder.this.f37644a);
        }
    }

    /* loaded from: classes6.dex */
    class o implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f37700a;

        o(String str) {
            this.f37700a = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.lsub("", this.f37700a);
        }
    }

    /* loaded from: classes6.dex */
    class p implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f37702a;

        p(boolean z3) {
            this.f37702a = z3;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            if (this.f37702a) {
                iMAPProtocol.subscribe(IMAPFolder.this.f37644a);
                return null;
            }
            iMAPProtocol.unsubscribe(IMAPFolder.this.f37644a);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class q implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f37704a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ char f37705b;

        q(int i4, char c4) {
            this.f37704a = i4;
            this.f37705b = c4;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            ListInfo[] list;
            if ((this.f37704a & 1) == 0) {
                iMAPProtocol.create(IMAPFolder.this.f37644a + this.f37705b);
            } else {
                iMAPProtocol.create(IMAPFolder.this.f37644a);
                if ((this.f37704a & 2) != 0 && (list = iMAPProtocol.list("", IMAPFolder.this.f37644a)) != null && !list[0].hasInferiors) {
                    iMAPProtocol.delete(IMAPFolder.this.f37644a);
                    throw new ProtocolException("Unsupported type");
                }
            }
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes6.dex */
    class r implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f37707a;

        r(String str) {
            this.f37707a = str;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            return iMAPProtocol.list("", this.f37707a);
        }
    }

    /* loaded from: classes6.dex */
    class s implements ProtocolCommand {
        s() {
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.delete(IMAPFolder.this.f37644a);
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes6.dex */
    class t implements ProtocolCommand {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Folder f37710a;

        t(Folder folder) {
            this.f37710a = folder;
        }

        @Override // com.sun.mail.imap.IMAPFolder.ProtocolCommand
        public Object doCommand(IMAPProtocol iMAPProtocol) throws ProtocolException {
            iMAPProtocol.rename(IMAPFolder.this.f37644a, this.f37710a.getFullName());
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPFolder(String str, char c4, IMAPStore iMAPStore, Boolean bool) {
        super(iMAPStore);
        int indexOf;
        this.f37651h = false;
        this.f37655l = new Object();
        this.f37657n = false;
        this.f37658o = true;
        this.f37659p = 0;
        this.f37661s = -1;
        this.f37662t = -1;
        this.f37663u = -1;
        this.f37664v = -1L;
        this.f37665w = -1L;
        this.f37666x = false;
        this.f37667y = -1L;
        this.f37668z = true;
        this.A = null;
        this.B = 0L;
        this.C = false;
        if (str != null) {
            this.f37644a = str;
            this.f37647d = c4;
            this.D = new MailLogger(getClass(), "DEBUG IMAP", iMAPStore.getSession().getDebug(), iMAPStore.getSession().getDebugOut());
            this.E = iMAPStore.h();
            this.f37651h = false;
            if (c4 != 65535 && c4 != 0 && (indexOf = this.f37644a.indexOf(c4)) > 0 && indexOf == this.f37644a.length() - 1) {
                this.f37644a = this.f37644a.substring(0, indexOf);
                this.f37651h = true;
            }
            if (bool != null) {
                this.f37651h = bool.booleanValue();
                return;
            }
            return;
        }
        throw new NullPointerException("Folder name is null");
    }

    private Status A() throws ProtocolException {
        IMAPProtocol B;
        int p4 = ((IMAPStore) this.store).p();
        if (p4 > 0 && this.A != null && System.currentTimeMillis() - this.B < p4) {
            return this.A;
        }
        IMAPProtocol iMAPProtocol = null;
        try {
            B = B();
        } catch (Throwable th) {
            th = th;
        }
        try {
            Status status = B.status(this.f37644a, null);
            if (p4 > 0) {
                this.A = status;
                this.B = System.currentTimeMillis();
            }
            N(B);
            return status;
        } catch (Throwable th2) {
            th = th2;
            iMAPProtocol = B;
            N(iMAPProtocol);
            throw th;
        }
    }

    private boolean G() {
        if ((this.f37646c & 2) != 0) {
            return true;
        }
        return false;
    }

    private boolean H(Throwable th) {
        if (!(th instanceof Exception) && !(th instanceof LinkageError)) {
            return false;
        }
        return true;
    }

    private MessagingException J(String str, ProtocolException protocolException) {
        MessagingException messagingException = new MessagingException(str, protocolException);
        try {
            this.f37653j.logout();
        } catch (Throwable th) {
            f(messagingException, th);
        }
        return messagingException;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private javax.mail.Message L(com.sun.mail.imap.protocol.FetchResponse r9) {
        /*
            r8 = this;
            int r0 = r9.getNumber()
            com.sun.mail.imap.IMAPMessage r0 = r8.x(r0)
            if (r0 == 0) goto L6c
            java.lang.Class<com.sun.mail.imap.protocol.UID> r1 = com.sun.mail.imap.protocol.UID.class
            com.sun.mail.imap.protocol.Item r1 = r9.getItem(r1)
            com.sun.mail.imap.protocol.UID r1 = (com.sun.mail.imap.protocol.UID) r1
            r2 = 1
            if (r1 == 0) goto L3a
            long r3 = r0.x()
            long r5 = r1.uid
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L3a
            r0.K(r5)
            java.util.Hashtable<java.lang.Long, com.sun.mail.imap.IMAPMessage> r3 = r8.f37656m
            if (r3 != 0) goto L2d
            java.util.Hashtable r3 = new java.util.Hashtable
            r3.<init>()
            r8.f37656m = r3
        L2d:
            java.util.Hashtable<java.lang.Long, com.sun.mail.imap.IMAPMessage> r3 = r8.f37656m
            long r4 = r1.uid
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r3.put(r1, r0)
            r1 = 1
            goto L3b
        L3a:
            r1 = 0
        L3b:
            java.lang.Class<com.sun.mail.imap.protocol.MODSEQ> r3 = com.sun.mail.imap.protocol.MODSEQ.class
            com.sun.mail.imap.protocol.Item r3 = r9.getItem(r3)
            com.sun.mail.imap.protocol.MODSEQ r3 = (com.sun.mail.imap.protocol.MODSEQ) r3
            if (r3 == 0) goto L53
            long r4 = r0.d()
            long r6 = r3.modseq
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 == 0) goto L53
            r0.J(r6)
            r1 = 1
        L53:
            java.lang.Class<com.sun.mail.imap.protocol.FLAGS> r3 = com.sun.mail.imap.protocol.FLAGS.class
            com.sun.mail.imap.protocol.Item r3 = r9.getItem(r3)
            com.sun.mail.imap.protocol.FLAGS r3 = (com.sun.mail.imap.protocol.FLAGS) r3
            if (r3 == 0) goto L61
            r0.f(r3)
            goto L62
        L61:
            r2 = r1
        L62:
            java.util.Map r9 = r9.getExtensionItems()
            r0.y(r9)
            if (r2 != 0) goto L6c
            r0 = 0
        L6c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.L(com.sun.mail.imap.protocol.FetchResponse):javax.mail.Message");
    }

    private void O(ACL acl, char c4) throws MessagingException {
        doOptionalCommand("ACL not supported", new i(c4, acl));
    }

    private void f(Throwable th, Throwable th2) {
        if (H(th2)) {
            th.addSuppressed(th2);
            return;
        }
        th2.addSuppressed(th);
        if (!(th2 instanceof Error)) {
            if (th2 instanceof RuntimeException) {
                throw ((RuntimeException) th2);
            }
            throw new RuntimeException("unexpected exception", th2);
        }
        throw ((Error) th2);
    }

    private void i(Flags flags) throws MessagingException {
        if (this.mode == 2) {
            return;
        }
        throw new IllegalStateException("Cannot change flags on READ_ONLY folder: " + this.f37644a);
    }

    private void l(boolean z3) {
        M(z3);
        this.f37654k = null;
        this.f37656m = null;
        this.f37650g = false;
        this.f37652i = null;
        this.f37657n = false;
        this.f37659p = 0;
        this.f37655l.notifyAll();
        notifyConnectionListeners(3);
    }

    private MessagingException m(MessagingException messagingException) {
        try {
            try {
                this.f37653j.close();
                M(true);
            } catch (Throwable th) {
                f(messagingException, th);
            }
        } catch (ProtocolException e4) {
            f(messagingException, J(e4.getMessage(), e4));
            M(false);
        }
        return messagingException;
    }

    private void n(boolean z3, boolean z4) throws MessagingException {
        boolean z5;
        synchronized (this.f37655l) {
            if (!this.f37657n && this.f37658o) {
                throw new IllegalStateException("This operation is not allowed on a closed folder");
            }
            boolean z6 = true;
            this.f37658o = true;
            if (!this.f37657n) {
                return;
            }
            try {
                R();
                if (z4) {
                    this.D.log(Level.FINE, "forcing folder {0} to close", this.f37644a);
                    if (this.f37653j != null) {
                        this.f37653j.disconnect();
                    }
                } else if (((IMAPStore) this.store).u()) {
                    this.D.fine("pool is full, not adding an Authenticated connection");
                    if (z3 && this.f37653j != null) {
                        this.f37653j.close();
                    }
                    if (this.f37653j != null) {
                        this.f37653j.logout();
                    }
                } else if (!z3 && this.mode == 2) {
                    try {
                        if (this.f37653j != null && this.f37653j.hasCapability("UNSELECT")) {
                            this.f37653j.unselect();
                        } else if (this.f37653j != null) {
                            try {
                                this.f37653j.examine(this.f37644a);
                                z5 = true;
                            } catch (CommandFailedException unused) {
                                z5 = false;
                            }
                            if (z5 && this.f37653j != null) {
                                this.f37653j.close();
                            }
                        }
                    } catch (ProtocolException unused2) {
                        z6 = false;
                    }
                } else if (this.f37653j != null) {
                    this.f37653j.close();
                }
                if (this.f37657n) {
                    l(z6);
                }
            } catch (ProtocolException e4) {
                throw new MessagingException(e4.getMessage(), e4);
            }
        }
    }

    private synchronized void o(Message[] messageArr, Folder folder, boolean z3) throws MessagingException {
        j();
        if (messageArr.length == 0) {
            return;
        }
        if (folder.getStore() == this.store) {
            synchronized (this.f37655l) {
                try {
                    IMAPProtocol z4 = z();
                    MessageSet[] messageSet = Utility.toMessageSet(messageArr, null);
                    if (messageSet != null) {
                        if (z3) {
                            z4.move(messageSet, folder.getFullName());
                        } else {
                            z4.copy(messageSet, folder.getFullName());
                        }
                    } else {
                        throw new MessageRemovedException("Messages have been removed");
                    }
                } catch (CommandFailedException e4) {
                    if (e4.getMessage().indexOf("TRYCREATE") != -1) {
                        throw new FolderNotFoundException(folder, folder.getFullName() + " does not exist");
                    }
                    throw new MessagingException(e4.getMessage(), e4);
                } catch (ConnectionException e5) {
                    throw new FolderClosedException(this, e5.getMessage());
                } catch (ProtocolException e6) {
                    throw new MessagingException(e6.getMessage(), e6);
                }
            }
        } else if (!z3) {
            super.copyMessages(messageArr, folder);
        } else {
            throw new MessagingException("Move between stores not supported");
        }
    }

    private synchronized AppendUID[] p(Message[] messageArr, Folder folder, boolean z3) throws MessagingException {
        CopyUID copyuid;
        AppendUID[] appendUIDArr;
        String str;
        j();
        if (messageArr.length == 0) {
            return null;
        }
        if (folder.getStore() != this.store) {
            if (z3) {
                str = "can't moveUIDMessages to a different store";
            } else {
                str = "can't copyUIDMessages to a different store";
            }
            throw new MessagingException(str);
        }
        FetchProfile fetchProfile = new FetchProfile();
        fetchProfile.add(UIDFolder.FetchProfileItem.UID);
        fetch(messageArr, fetchProfile);
        synchronized (this.f37655l) {
            try {
                IMAPProtocol z4 = z();
                MessageSet[] messageSet = Utility.toMessageSet(messageArr, null);
                if (messageSet != null) {
                    if (z3) {
                        copyuid = z4.moveuid(messageSet, folder.getFullName());
                    } else {
                        copyuid = z4.copyuid(messageSet, folder.getFullName());
                    }
                    long[] array = UIDSet.toArray(copyuid.src);
                    long[] array2 = UIDSet.toArray(copyuid.dst);
                    Message[] messagesByUID = getMessagesByUID(array);
                    appendUIDArr = new AppendUID[messageArr.length];
                    for (int i4 = 0; i4 < messageArr.length; i4++) {
                        int i5 = i4;
                        while (true) {
                            if (messageArr[i4] == messagesByUID[i5]) {
                                appendUIDArr[i4] = new AppendUID(copyuid.uidvalidity, array2[i5]);
                                break;
                            }
                            i5++;
                            if (i5 >= messagesByUID.length) {
                                i5 = 0;
                                continue;
                            }
                            if (i5 == i4) {
                                break;
                            }
                        }
                    }
                } else {
                    throw new MessageRemovedException("Messages have been removed");
                }
            } catch (CommandFailedException e4) {
                if (e4.getMessage().indexOf("TRYCREATE") != -1) {
                    throw new FolderNotFoundException(folder, folder.getFullName() + " does not exist");
                }
                throw new MessagingException(e4.getMessage(), e4);
            } catch (ConnectionException e5) {
                throw new FolderClosedException(this, e5.getMessage());
            } catch (ProtocolException e6) {
                throw new MessagingException(e6.getMessage(), e6);
            }
        }
        return appendUIDArr;
    }

    private String q(String[] strArr, boolean z3) {
        StringBuilder sb;
        if (z3) {
            sb = new StringBuilder("BODY.PEEK[HEADER.FIELDS (");
        } else {
            sb = new StringBuilder("RFC822.HEADER.LINES (");
        }
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (i4 > 0) {
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
            sb.append(strArr[i4]);
        }
        if (z3) {
            sb.append(")]");
        } else {
            sb.append(")");
        }
        return sb.toString();
    }

    private Message[] r(long[] jArr) {
        IMAPMessage iMAPMessage;
        IMAPMessage[] iMAPMessageArr = new IMAPMessage[jArr.length];
        for (int i4 = 0; i4 < jArr.length; i4 = i4 + 1 + 1) {
            Hashtable<Long, IMAPMessage> hashtable = this.f37656m;
            if (hashtable != null) {
                iMAPMessage = hashtable.get(Long.valueOf(jArr[i4]));
            } else {
                iMAPMessage = null;
            }
            if (iMAPMessage == null) {
                iMAPMessage = K(-1);
                iMAPMessage.K(jArr[i4]);
                iMAPMessage.setExpunged(true);
            }
            iMAPMessageArr[i4] = iMAPMessage;
        }
        return iMAPMessageArr;
    }

    private synchronized Folder[] s(String str, boolean z3) throws MessagingException {
        h();
        int i4 = 0;
        if (this.f37652i != null && !G()) {
            return new Folder[0];
        }
        char separator = getSeparator();
        ListInfo[] listInfoArr = (ListInfo[]) doCommandIgnoreFailure(new m(z3, separator, str));
        if (listInfoArr == null) {
            return new Folder[0];
        }
        if (listInfoArr.length > 0) {
            String str2 = listInfoArr[0].name;
            if (str2.equals(this.f37644a + separator)) {
                i4 = 1;
            }
        }
        IMAPFolder[] iMAPFolderArr = new IMAPFolder[listInfoArr.length - i4];
        IMAPStore iMAPStore = (IMAPStore) this.store;
        for (int i5 = i4; i5 < listInfoArr.length; i5++) {
            iMAPFolderArr[i5 - i4] = iMAPStore.x(listInfoArr[i5]);
        }
        return iMAPFolderArr;
    }

    private int u(ListInfo[] listInfoArr, String str) {
        int i4 = 0;
        while (i4 < listInfoArr.length && !listInfoArr[i4].name.equals(str)) {
            i4++;
        }
        if (i4 >= listInfoArr.length) {
            return 0;
        }
        return i4;
    }

    protected synchronized IMAPProtocol B() throws ProtocolException {
        this.E.fine("getStoreProtocol() borrowing a connection");
        return ((IMAPStore) this.store).j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean C(boolean z3) throws MessagingException {
        while (true) {
            Response readIdleResponse = this.f37653j.readIdleResponse();
            try {
                synchronized (this.f37655l) {
                    if (readIdleResponse.isBYE() && readIdleResponse.isSynthetic() && this.f37659p == 1) {
                        Exception exception = readIdleResponse.getException();
                        if ((exception instanceof InterruptedIOException) && ((InterruptedIOException) exception).bytesTransferred == 0) {
                            if (exception instanceof SocketTimeoutException) {
                                this.D.finest("handleIdle: ignoring socket timeout");
                                readIdleResponse = null;
                            } else {
                                this.D.finest("handleIdle: interrupting IDLE");
                                IdleManager idleManager = this.f37660r;
                                if (idleManager != null) {
                                    this.D.finest("handleIdle: request IdleManager to abort");
                                    idleManager.f(this);
                                } else {
                                    this.D.finest("handleIdle: abort IDLE");
                                    this.f37653j.idleAbort();
                                    this.f37659p = 2;
                                }
                            }
                            if (readIdleResponse == null && !this.f37653j.hasResponse()) {
                                return true;
                            }
                        }
                    }
                    if (this.f37653j == null || !this.f37653j.processIdleResponse(readIdleResponse)) {
                        break;
                    }
                    if (z3 && this.f37659p == 1) {
                        try {
                            this.f37653j.idleAbort();
                        } catch (Exception unused) {
                        }
                        this.f37659p = 2;
                    }
                    if (readIdleResponse == null) {
                    }
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        this.D.finest("handleIdle: set to RUNNING");
        this.f37659p = 0;
        this.f37660r = null;
        this.f37655l.notifyAll();
        return false;
    }

    void D(Response[] responseArr) {
        for (Response response : responseArr) {
            if (response != null) {
                handleResponse(response);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        synchronized (this.f37655l) {
            if (this.f37659p == 1 && this.f37653j != null) {
                this.f37653j.idleAbort();
                this.f37659p = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        synchronized (this.f37655l) {
            if (this.f37659p == 1 && this.f37653j != null) {
                this.f37653j.idleAbort();
                this.f37659p = 2;
                do {
                    try {
                    } catch (Exception e4) {
                        this.D.log(Level.FINEST, "Exception in idleAbortWait", (Throwable) e4);
                    }
                } while (C(false));
                this.D.finest("IDLE aborted");
            }
        }
    }

    protected void I(boolean z3) throws ProtocolException {
        if (this.f37653j == null) {
            return;
        }
        if (System.currentTimeMillis() - this.f37653j.getTimestamp() > 1000) {
            R();
            if (this.f37653j != null) {
                this.f37653j.noop();
            }
        }
        if (z3 && ((IMAPStore) this.store).s()) {
            IMAPProtocol iMAPProtocol = null;
            try {
                iMAPProtocol = ((IMAPStore) this.store).j();
                if (System.currentTimeMillis() - iMAPProtocol.getTimestamp() > 1000) {
                    iMAPProtocol.noop();
                }
            } finally {
                ((IMAPStore) this.store).D(iMAPProtocol);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMessage K(int i4) {
        return new IMAPMessage(this, i4);
    }

    protected void M(boolean z3) {
        if (this.f37653j != null) {
            this.f37653j.removeResponseHandler(this);
            if (z3) {
                ((IMAPStore) this.store).E(this, this.f37653j);
            } else {
                this.f37653j.disconnect();
                ((IMAPStore) this.store).E(this, null);
            }
            this.f37653j = null;
        }
    }

    protected synchronized void N(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol != this.f37653j) {
            ((IMAPStore) this.store).D(iMAPProtocol);
        } else {
            this.D.fine("releasing our protocol as store protocol?");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean P(IdleManager idleManager) throws MessagingException {
        boolean booleanValue;
        IdleManager idleManager2;
        synchronized (this) {
            j();
            if (idleManager != null && (idleManager2 = this.f37660r) != null && idleManager != idleManager2) {
                throw new MessagingException("Folder already being watched by another IdleManager");
            }
            Boolean bool = (Boolean) doOptionalCommand("IDLE not supported", new j(idleManager));
            this.D.log(Level.FINEST, "startIdle: return {0}", bool);
            booleanValue = bool.booleanValue();
        }
        return booleanValue;
    }

    protected synchronized void Q(ConnectionException connectionException) throws FolderClosedException, StoreClosedException {
        if ((this.f37653j != null && connectionException.getProtocol() == this.f37653j) || (this.f37653j == null && !this.f37658o)) {
            throw new FolderClosedException(this, connectionException.getMessage());
        }
        throw new StoreClosedException(this.store, connectionException.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() throws ProtocolException {
        while (true) {
            int i4 = this.f37659p;
            if (i4 != 0) {
                if (i4 == 1) {
                    IdleManager idleManager = this.f37660r;
                    if (idleManager != null) {
                        this.D.finest("waitIfIdle: request IdleManager to abort");
                        idleManager.f(this);
                    } else {
                        this.D.finest("waitIfIdle: abort IDLE");
                        this.f37653j.idleAbort();
                        this.f37659p = 2;
                    }
                } else {
                    this.D.log(Level.FINEST, "waitIfIdle: idleState {0}", Integer.valueOf(i4));
                }
                try {
                    MailLogger mailLogger = this.D;
                    Level level = Level.FINEST;
                    if (mailLogger.isLoggable(level)) {
                        MailLogger mailLogger2 = this.D;
                        mailLogger2.finest("waitIfIdle: wait to be not idle: " + Thread.currentThread());
                    }
                    this.f37655l.wait();
                    if (this.D.isLoggable(level)) {
                        MailLogger mailLogger3 = this.D;
                        mailLogger3.finest("waitIfIdle: wait done, idleState " + this.f37659p + ": " + Thread.currentThread());
                    }
                } catch (InterruptedException e4) {
                    Thread.currentThread().interrupt();
                    throw new ProtocolException("Interrupted waitIfIdle", e4);
                }
            } else {
                return;
            }
        }
    }

    public void addACL(ACL acl) throws MessagingException {
        O(acl, (char) 0);
    }

    @Override // javax.mail.Folder
    public synchronized void addMessageCountListener(MessageCountListener messageCountListener) {
        super.addMessageCountListener(messageCountListener);
        this.C = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Message[] addMessages(Message[] messageArr) throws MessagingException {
        MimeMessage[] mimeMessageArr;
        j();
        mimeMessageArr = new MimeMessage[messageArr.length];
        AppendUID[] appendUIDMessages = appendUIDMessages(messageArr);
        for (int i4 = 0; i4 < appendUIDMessages.length; i4++) {
            AppendUID appendUID = appendUIDMessages[i4];
            if (appendUID != null && appendUID.uidvalidity == this.f37664v) {
                try {
                    mimeMessageArr[i4] = getMessageByUID(appendUID.uid);
                } catch (MessagingException unused) {
                }
            }
        }
        return mimeMessageArr;
    }

    public void addRights(ACL acl) throws MessagingException {
        O(acl, SignatureVisitor.EXTENDS);
    }

    @Override // javax.mail.Folder
    public synchronized void appendMessages(Message[] messageArr) throws MessagingException {
        int i4;
        h();
        int g4 = ((IMAPStore) this.store).g();
        for (Message message : messageArr) {
            Date receivedDate = message.getReceivedDate();
            if (receivedDate == null) {
                receivedDate = message.getSentDate();
            }
            Flags flags = message.getFlags();
            try {
                if (message.getSize() > g4) {
                    i4 = 0;
                } else {
                    i4 = g4;
                }
                doCommand(new a(flags, receivedDate, new com.sun.mail.imap.b(message, i4)));
            } catch (IOException e4) {
                throw new MessagingException("IOException while appending messages", e4);
            } catch (MessageRemovedException unused) {
            }
        }
    }

    public synchronized AppendUID[] appendUIDMessages(Message[] messageArr) throws MessagingException {
        AppendUID[] appendUIDArr;
        int i4;
        h();
        int g4 = ((IMAPStore) this.store).g();
        appendUIDArr = new AppendUID[messageArr.length];
        for (int i5 = 0; i5 < messageArr.length; i5++) {
            Message message = messageArr[i5];
            try {
                if (message.getSize() > g4) {
                    i4 = 0;
                } else {
                    i4 = g4;
                }
                com.sun.mail.imap.b bVar = new com.sun.mail.imap.b(message, i4);
                Date receivedDate = message.getReceivedDate();
                if (receivedDate == null) {
                    receivedDate = message.getSentDate();
                }
                appendUIDArr[i5] = (AppendUID) doCommand(new b(message.getFlags(), receivedDate, bVar));
            } catch (IOException e4) {
                throw new MessagingException("IOException while appending messages", e4);
            } catch (MessageRemovedException unused) {
            }
        }
        return appendUIDArr;
    }

    @Override // javax.mail.Folder
    public synchronized void close(boolean z3) throws MessagingException {
        n(z3, false);
    }

    @Override // javax.mail.Folder
    public synchronized void copyMessages(Message[] messageArr, Folder folder) throws MessagingException {
        o(messageArr, folder, false);
    }

    public synchronized AppendUID[] copyUIDMessages(Message[] messageArr, Folder folder) throws MessagingException {
        return p(messageArr, folder, false);
    }

    @Override // javax.mail.Folder
    public synchronized boolean create(int i4) throws MessagingException {
        char separator;
        if ((i4 & 1) == 0) {
            separator = getSeparator();
        } else {
            separator = 0;
        }
        if (doCommandIgnoreFailure(new q(i4, separator)) == null) {
            return false;
        }
        boolean exists = exists();
        if (exists) {
            notifyFolderListeners(1);
        }
        return exists;
    }

    @Override // javax.mail.Folder
    public synchronized boolean delete(boolean z3) throws MessagingException {
        g();
        if (z3) {
            for (Folder folder : list()) {
                folder.delete(z3);
            }
        }
        if (doCommandIgnoreFailure(new s()) == null) {
            return false;
        }
        this.f37650g = false;
        this.f37652i = null;
        notifyFolderListeners(2);
        return true;
    }

    public Object doCommand(ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return t(protocolCommand);
        } catch (ConnectionException e4) {
            Q(e4);
            return null;
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
    }

    public Object doCommandIgnoreFailure(ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return t(protocolCommand);
        } catch (CommandFailedException unused) {
            return null;
        } catch (ConnectionException e4) {
            Q(e4);
            return null;
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
    }

    public Object doOptionalCommand(String str, ProtocolCommand protocolCommand) throws MessagingException {
        try {
            return t(protocolCommand);
        } catch (BadCommandException e4) {
            throw new MessagingException(str, e4);
        } catch (ConnectionException e5) {
            Q(e5);
            return null;
        } catch (ProtocolException e6) {
            throw new MessagingException(e6.getMessage(), e6);
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean exists() throws MessagingException {
        String str;
        if (this.f37651h && this.f37647d != 0) {
            str = this.f37644a + this.f37647d;
        } else {
            str = this.f37644a;
        }
        ListInfo[] listInfoArr = (ListInfo[]) doCommand(new k(str));
        if (listInfoArr != null) {
            int u3 = u(listInfoArr, str);
            this.f37644a = listInfoArr[u3].name;
            this.f37647d = listInfoArr[u3].separator;
            int length = this.f37644a.length();
            if (this.f37647d != 0 && length > 0) {
                int i4 = length - 1;
                if (this.f37644a.charAt(i4) == this.f37647d) {
                    this.f37644a = this.f37644a.substring(0, i4);
                }
            }
            this.f37646c = 0;
            ListInfo listInfo = listInfoArr[u3];
            if (listInfo.hasInferiors) {
                this.f37646c = 0 | 2;
            }
            if (listInfo.canOpen) {
                this.f37646c |= 1;
            }
            this.f37650g = true;
            this.f37652i = listInfoArr[u3].attrs;
        } else {
            this.f37650g = this.f37657n;
            this.f37652i = null;
        }
        return this.f37650g;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] expunge() throws MessagingException {
        return expunge(null);
    }

    @Override // javax.mail.Folder
    public synchronized void fetch(Message[] messageArr, FetchProfile fetchProfile) throws MessagingException {
        boolean isREV1;
        FetchItem[] fetchItems;
        boolean z3;
        boolean z4;
        String str;
        String[] strArr;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        synchronized (this.f37655l) {
            j();
            isREV1 = this.f37653j.isREV1();
            fetchItems = this.f37653j.getFetchItems();
        }
        StringBuilder sb = new StringBuilder();
        if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
            sb.append(w());
            z3 = false;
        } else {
            z3 = true;
        }
        if (fetchProfile.contains(FetchProfile.Item.FLAGS)) {
            if (z3) {
                str9 = "FLAGS";
            } else {
                str9 = " FLAGS";
            }
            sb.append(str9);
            z3 = false;
        }
        if (fetchProfile.contains(FetchProfile.Item.CONTENT_INFO)) {
            if (z3) {
                str8 = "BODYSTRUCTURE";
            } else {
                str8 = " BODYSTRUCTURE";
            }
            sb.append(str8);
            z3 = false;
        }
        if (fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
            if (z3) {
                str7 = "UID";
            } else {
                str7 = " UID";
            }
            sb.append(str7);
            z3 = false;
        }
        if (fetchProfile.contains(FetchProfileItem.HEADERS)) {
            if (isREV1) {
                if (z3) {
                    str6 = "BODY.PEEK[HEADER]";
                } else {
                    str6 = " BODY.PEEK[HEADER]";
                }
                sb.append(str6);
            } else {
                if (z3) {
                    str5 = "RFC822.HEADER";
                } else {
                    str5 = " RFC822.HEADER";
                }
                sb.append(str5);
            }
            z3 = false;
            z4 = true;
        } else {
            z4 = false;
        }
        if (fetchProfile.contains(FetchProfileItem.MESSAGE)) {
            if (isREV1) {
                if (z3) {
                    str4 = "BODY.PEEK[]";
                } else {
                    str4 = " BODY.PEEK[]";
                }
                sb.append(str4);
            } else {
                if (z3) {
                    str3 = "RFC822";
                } else {
                    str3 = " RFC822";
                }
                sb.append(str3);
            }
            z3 = false;
            z4 = true;
        }
        if (fetchProfile.contains(FetchProfile.Item.SIZE) || fetchProfile.contains(FetchProfileItem.SIZE)) {
            if (z3) {
                str = "RFC822.SIZE";
            } else {
                str = " RFC822.SIZE";
            }
            sb.append(str);
            z3 = false;
        }
        if (fetchProfile.contains(FetchProfileItem.INTERNALDATE)) {
            if (z3) {
                str2 = "INTERNALDATE";
            } else {
                str2 = " INTERNALDATE";
            }
            sb.append(str2);
            z3 = false;
        }
        Response[] responseArr = null;
        if (!z4) {
            strArr = fetchProfile.getHeaderNames();
            if (strArr.length > 0) {
                if (!z3) {
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                sb.append(q(strArr, isREV1));
            }
        } else {
            strArr = null;
        }
        for (int i4 = 0; i4 < fetchItems.length; i4++) {
            if (fetchProfile.contains(fetchItems[i4].getFetchProfileItem())) {
                if (sb.length() != 0) {
                    sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                }
                sb.append(fetchItems[i4].getName());
            }
        }
        IMAPMessage.FetchProfileCondition fetchProfileCondition = new IMAPMessage.FetchProfileCondition(fetchProfile, fetchItems);
        synchronized (this.f37655l) {
            j();
            MessageSet[] messageSetSorted = Utility.toMessageSetSorted(messageArr, fetchProfileCondition);
            if (messageSetSorted == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            try {
                responseArr = z().fetch(messageSetSorted, sb.toString());
            } catch (CommandFailedException unused) {
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
            if (responseArr == null) {
                return;
            }
            for (Response response : responseArr) {
                if (response != null) {
                    if (!(response instanceof FetchResponse)) {
                        arrayList.add(response);
                    } else {
                        FetchResponse fetchResponse = (FetchResponse) response;
                        IMAPMessage x3 = x(fetchResponse.getNumber());
                        int itemCount = fetchResponse.getItemCount();
                        boolean z5 = false;
                        for (int i5 = 0; i5 < itemCount; i5++) {
                            Item item = fetchResponse.getItem(i5);
                            if ((item instanceof Flags) && (!fetchProfile.contains(FetchProfile.Item.FLAGS) || x3 == null)) {
                                z5 = true;
                            } else if (x3 != null) {
                                x3.z(item, strArr, z4);
                            }
                        }
                        if (x3 != null) {
                            x3.y(fetchResponse.getExtensionItems());
                        }
                        if (z5) {
                            arrayList.add(fetchResponse);
                        }
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                Response[] responseArr2 = new Response[arrayList.size()];
                arrayList.toArray(responseArr2);
                D(responseArr2);
            }
        }
    }

    public synchronized void forceClose() throws MessagingException {
        n(false, true);
    }

    protected void g() {
        if (!this.f37657n) {
            return;
        }
        throw new IllegalStateException("This operation is not allowed on an open folder");
    }

    public ACL[] getACL() throws MessagingException {
        return (ACL[]) doOptionalCommand("ACL not supported", new e());
    }

    public synchronized String[] getAttributes() throws MessagingException {
        String[] strArr;
        h();
        if (this.f37652i == null) {
            exists();
        }
        if (this.f37652i == null) {
            strArr = new String[0];
        } else {
            strArr = (String[]) this.f37652i.clone();
        }
        return strArr;
    }

    @Override // javax.mail.Folder
    public synchronized int getDeletedMessageCount() throws MessagingException {
        int length;
        if (!this.f37657n) {
            h();
            return -1;
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.DELETED);
        try {
            synchronized (this.f37655l) {
                length = z().search(new FlagTerm(flags, true)).length;
            }
            return length;
        } catch (ConnectionException e4) {
            throw new FolderClosedException(this, e4.getMessage());
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
    }

    @Override // javax.mail.Folder
    public synchronized Folder getFolder(String str) throws MessagingException {
        char separator;
        if (this.f37652i != null && !G()) {
            throw new MessagingException("Cannot contain subfolders");
        }
        separator = getSeparator();
        return ((IMAPStore) this.store).y(this.f37644a + separator + str, separator);
    }

    @Override // javax.mail.Folder
    public String getFullName() {
        return this.f37644a;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0051 A[Catch: all -> 0x006d, TRY_ENTER, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x0005, B:13:0x0022, B:36:0x0051, B:39:0x0055, B:40:0x005c, B:45:0x0069, B:46:0x006c), top: B:50:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0055 A[Catch: all -> 0x006d, TRY_ENTER, TryCatch #5 {, blocks: (B:3:0x0001, B:5:0x0005, B:13:0x0022, B:36:0x0051, B:39:0x0055, B:40:0x005c, B:45:0x0069, B:46:0x006c), top: B:50:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized long getHighestModSeq() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f37657n     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L9
            long r0 = r5.f37667y     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r5)
            return r0
        L9:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.B()     // Catch: java.lang.Throwable -> L36 com.sun.mail.iap.ProtocolException -> L3b com.sun.mail.iap.ConnectionException -> L49 com.sun.mail.iap.BadCommandException -> L5d
            java.lang.String r2 = "CONDSTORE"
            boolean r2 = r1.hasCapability(r2)     // Catch: java.lang.Throwable -> L2e com.sun.mail.iap.ProtocolException -> L30 com.sun.mail.iap.ConnectionException -> L32 com.sun.mail.iap.BadCommandException -> L34
            if (r2 == 0) goto L26
            java.lang.String r2 = "HIGHESTMODSEQ"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L2e com.sun.mail.iap.ProtocolException -> L30 com.sun.mail.iap.ConnectionException -> L32 com.sun.mail.iap.BadCommandException -> L34
            java.lang.String r3 = r5.f37644a     // Catch: java.lang.Throwable -> L2e com.sun.mail.iap.ProtocolException -> L30 com.sun.mail.iap.ConnectionException -> L32 com.sun.mail.iap.BadCommandException -> L34
            com.sun.mail.imap.protocol.Status r0 = r1.status(r3, r2)     // Catch: java.lang.Throwable -> L2e com.sun.mail.iap.ProtocolException -> L30 com.sun.mail.iap.ConnectionException -> L32 com.sun.mail.iap.BadCommandException -> L34
        L22:
            r5.N(r1)     // Catch: java.lang.Throwable -> L6d
            goto L4f
        L26:
            com.sun.mail.iap.BadCommandException r2 = new com.sun.mail.iap.BadCommandException     // Catch: java.lang.Throwable -> L2e com.sun.mail.iap.ProtocolException -> L30 com.sun.mail.iap.ConnectionException -> L32 com.sun.mail.iap.BadCommandException -> L34
            java.lang.String r3 = "CONDSTORE not supported"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2e com.sun.mail.iap.ProtocolException -> L30 com.sun.mail.iap.ConnectionException -> L32 com.sun.mail.iap.BadCommandException -> L34
            throw r2     // Catch: java.lang.Throwable -> L2e com.sun.mail.iap.ProtocolException -> L30 com.sun.mail.iap.ConnectionException -> L32 com.sun.mail.iap.BadCommandException -> L34
        L2e:
            r0 = move-exception
            goto L69
        L30:
            r0 = move-exception
            goto L3f
        L32:
            r2 = move-exception
            goto L4b
        L34:
            r0 = move-exception
            goto L61
        L36:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L69
        L3b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L3f:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = r0.getMessage()     // Catch: java.lang.Throwable -> L2e
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L49:
            r2 = move-exception
            r1 = r0
        L4b:
            r5.Q(r2)     // Catch: java.lang.Throwable -> L2e
            goto L22
        L4f:
            if (r0 == 0) goto L55
            long r0 = r0.highestmodseq     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r5)
            return r0
        L55:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch: java.lang.Throwable -> L6d
            java.lang.String r1 = "Cannot obtain HIGHESTMODSEQ"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L6d
            throw r0     // Catch: java.lang.Throwable -> L6d
        L5d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L61:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch: java.lang.Throwable -> L2e
            java.lang.String r3 = "Cannot obtain HIGHESTMODSEQ"
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L2e
            throw r2     // Catch: java.lang.Throwable -> L2e
        L69:
            r5.N(r1)     // Catch: java.lang.Throwable -> L6d
            throw r0     // Catch: java.lang.Throwable -> L6d
        L6d:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getHighestModSeq():long");
    }

    @Override // javax.mail.Folder
    public synchronized Message getMessage(int i4) throws MessagingException {
        j();
        k(i4);
        return this.f37654k.getMessage(i4);
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message getMessageByUID(long j4) throws MessagingException {
        IMAPMessage iMAPMessage;
        j();
        try {
            try {
                synchronized (this.f37655l) {
                    Long valueOf = Long.valueOf(j4);
                    Hashtable<Long, IMAPMessage> hashtable = this.f37656m;
                    if (hashtable != null) {
                        iMAPMessage = hashtable.get(valueOf);
                        if (iMAPMessage != null) {
                            return iMAPMessage;
                        }
                    } else {
                        this.f37656m = new Hashtable<>();
                        iMAPMessage = null;
                    }
                    z().fetchSequenceNumber(j4);
                    Hashtable<Long, IMAPMessage> hashtable2 = this.f37656m;
                    if (hashtable2 != null && (iMAPMessage = hashtable2.get(valueOf)) != null) {
                        return iMAPMessage;
                    }
                    return iMAPMessage;
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this, e4.getMessage());
            }
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getMessageCount() throws MessagingException {
        synchronized (this.f37655l) {
            if (this.f37657n) {
                try {
                    try {
                        I(true);
                        return this.f37661s;
                    } catch (ConnectionException e4) {
                        throw new FolderClosedException(this, e4.getMessage());
                    }
                } catch (ProtocolException e5) {
                    throw new MessagingException(e5.getMessage(), e5);
                }
            }
            h();
            try {
                try {
                    try {
                        return A().total;
                    } catch (ProtocolException e6) {
                        throw new MessagingException(e6.getMessage(), e6);
                    }
                } catch (ConnectionException e7) {
                    throw new StoreClosedException(this.store, e7.getMessage());
                }
            } catch (BadCommandException unused) {
                try {
                    IMAPProtocol B = B();
                    MailboxInfo examine = B.examine(this.f37644a);
                    B.close();
                    int i4 = examine.total;
                    N(B);
                    return i4;
                } catch (ProtocolException e8) {
                    throw new MessagingException(e8.getMessage(), e8);
                }
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized Message[] getMessages() throws MessagingException {
        Message[] messageArr;
        j();
        int messageCount = getMessageCount();
        messageArr = new Message[messageCount];
        for (int i4 = 1; i4 <= messageCount; i4++) {
            messageArr[i4 - 1] = this.f37654k.getMessage(i4);
        }
        return messageArr;
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long j4, long j5) throws MessagingException {
        Message[] messageArr;
        j();
        try {
            try {
                synchronized (this.f37655l) {
                    if (this.f37656m == null) {
                        this.f37656m = new Hashtable<>();
                    }
                    long[] fetchSequenceNumbers = z().fetchSequenceNumbers(j4, j5);
                    ArrayList arrayList = new ArrayList();
                    for (long j6 : fetchSequenceNumbers) {
                        IMAPMessage iMAPMessage = this.f37656m.get(Long.valueOf(j6));
                        if (iMAPMessage != null) {
                            arrayList.add(iMAPMessage);
                        }
                    }
                    messageArr = (Message[]) arrayList.toArray(new Message[arrayList.size()]);
                }
            } catch (ProtocolException e4) {
                throw new MessagingException(e4.getMessage(), e4);
            }
        } catch (ConnectionException e5) {
            throw new FolderClosedException(this, e5.getMessage());
        }
        return messageArr;
    }

    public synchronized Message[] getMessagesByUIDChangedSince(long j4, long j5, long j6) throws MessagingException {
        IMAPMessage[] y3;
        j();
        try {
            synchronized (this.f37655l) {
                IMAPProtocol z3 = z();
                if (z3.hasCapability("CONDSTORE")) {
                    y3 = y(z3.uidfetchChangedSince(j4, j5, j6));
                } else {
                    throw new BadCommandException("CONDSTORE not supported");
                }
            }
        } catch (ConnectionException e4) {
            throw new FolderClosedException(this, e4.getMessage());
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
        return y3;
    }

    @Override // javax.mail.Folder
    public synchronized String getName() {
        if (this.f37645b == null) {
            try {
                this.f37645b = this.f37644a.substring(this.f37644a.lastIndexOf(getSeparator()) + 1);
            } catch (MessagingException unused) {
            }
        }
        return this.f37645b;
    }

    @Override // javax.mail.Folder
    public synchronized int getNewMessageCount() throws MessagingException {
        synchronized (this.f37655l) {
            if (this.f37657n) {
                try {
                    try {
                        I(true);
                        return this.f37662t;
                    } catch (ConnectionException e4) {
                        throw new FolderClosedException(this, e4.getMessage());
                    }
                } catch (ProtocolException e5) {
                    throw new MessagingException(e5.getMessage(), e5);
                }
            }
            h();
            try {
                try {
                    try {
                        return A().recent;
                    } catch (ProtocolException e6) {
                        throw new MessagingException(e6.getMessage(), e6);
                    }
                } catch (ConnectionException e7) {
                    throw new StoreClosedException(this.store, e7.getMessage());
                }
            } catch (BadCommandException unused) {
                try {
                    IMAPProtocol B = B();
                    MailboxInfo examine = B.examine(this.f37644a);
                    B.close();
                    int i4 = examine.recent;
                    N(B);
                    return i4;
                } catch (ProtocolException e8) {
                    throw new MessagingException(e8.getMessage(), e8);
                }
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized Folder getParent() throws MessagingException {
        char separator = getSeparator();
        int lastIndexOf = this.f37644a.lastIndexOf(separator);
        if (lastIndexOf != -1) {
            return ((IMAPStore) this.store).y(this.f37644a.substring(0, lastIndexOf), separator);
        }
        return new DefaultFolder((IMAPStore) this.store);
    }

    @Override // javax.mail.Folder
    public synchronized Flags getPermanentFlags() {
        Flags flags = this.f37649f;
        if (flags == null) {
            return null;
        }
        return (Flags) flags.clone();
    }

    public Quota[] getQuota() throws MessagingException {
        return (Quota[]) doOptionalCommand("QUOTA not supported", new c());
    }

    @Override // javax.mail.Folder
    public synchronized char getSeparator() throws MessagingException {
        if (this.f37647d == 65535) {
            ListInfo[] listInfoArr = (ListInfo[]) doCommand(new n());
            if (listInfoArr != null) {
                this.f37647d = listInfoArr[0].separator;
            } else {
                this.f37647d = '/';
            }
        }
        return this.f37647d;
    }

    public synchronized Message[] getSortedMessages(SortTerm[] sortTermArr) throws MessagingException {
        return getSortedMessages(sortTermArr, null);
    }

    public synchronized long getStatusItem(String str) throws MessagingException {
        long j4 = -1;
        if (this.f37657n) {
            return -1L;
        }
        h();
        IMAPProtocol iMAPProtocol = null;
        try {
            try {
                iMAPProtocol = B();
                Status status = iMAPProtocol.status(this.f37644a, new String[]{str});
                if (status != null) {
                    j4 = status.getItem(str);
                }
                N(iMAPProtocol);
                return j4;
            } catch (ConnectionException e4) {
                throw new StoreClosedException(this.store, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        } catch (BadCommandException unused) {
            N(iMAPProtocol);
            return -1L;
        }
    }

    @Override // javax.mail.Folder
    public synchronized int getType() throws MessagingException {
        if (this.f37657n) {
            if (this.f37652i == null) {
                exists();
            }
        } else {
            h();
        }
        return this.f37646c;
    }

    @Override // javax.mail.UIDFolder
    public synchronized long getUID(Message message) throws MessagingException {
        if (message.getFolder() == this) {
            j();
            if (message instanceof IMAPMessage) {
                IMAPMessage iMAPMessage = (IMAPMessage) message;
                long x3 = iMAPMessage.x();
                if (x3 != -1) {
                    return x3;
                }
                synchronized (this.f37655l) {
                    try {
                        IMAPProtocol z3 = z();
                        iMAPMessage.q();
                        UID fetchUID = z3.fetchUID(iMAPMessage.w());
                        if (fetchUID != null) {
                            x3 = fetchUID.uid;
                            iMAPMessage.K(x3);
                            if (this.f37656m == null) {
                                this.f37656m = new Hashtable<>();
                            }
                            this.f37656m.put(Long.valueOf(x3), iMAPMessage);
                        }
                    } catch (ConnectionException e4) {
                        throw new FolderClosedException(this, e4.getMessage());
                    } catch (ProtocolException e5) {
                        throw new MessagingException(e5.getMessage(), e5);
                    }
                }
                return x3;
            }
            throw new MessagingException("message is not an IMAPMessage");
        }
        throw new NoSuchElementException("Message does not belong to this folder");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x003f A[Catch: all -> 0x005c, TRY_ENTER, TRY_LEAVE, TryCatch #7 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x001a, B:30:0x003f, B:33:0x0043, B:34:0x004a, B:40:0x0058, B:41:0x005b), top: B:46:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0043 A[Catch: all -> 0x005c, TRY_ENTER, TryCatch #7 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x001a, B:30:0x003f, B:33:0x0043, B:34:0x004a, B:40:0x0058, B:41:0x005b), top: B:46:0x0001 }] */
    @Override // javax.mail.UIDFolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized long getUIDNext() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f37657n     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L9
            long r0 = r5.f37665w     // Catch: java.lang.Throwable -> L5c
            monitor-exit(r5)
            return r0
        L9:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.B()     // Catch: java.lang.Throwable -> L24 com.sun.mail.iap.ProtocolException -> L29 com.sun.mail.iap.ConnectionException -> L37 com.sun.mail.iap.BadCommandException -> L4b
            java.lang.String r2 = "UIDNEXT"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: com.sun.mail.iap.ProtocolException -> L1e com.sun.mail.iap.ConnectionException -> L20 com.sun.mail.iap.BadCommandException -> L22 java.lang.Throwable -> L57
            java.lang.String r3 = r5.f37644a     // Catch: com.sun.mail.iap.ProtocolException -> L1e com.sun.mail.iap.ConnectionException -> L20 com.sun.mail.iap.BadCommandException -> L22 java.lang.Throwable -> L57
            com.sun.mail.imap.protocol.Status r0 = r1.status(r3, r2)     // Catch: com.sun.mail.iap.ProtocolException -> L1e com.sun.mail.iap.ConnectionException -> L20 com.sun.mail.iap.BadCommandException -> L22 java.lang.Throwable -> L57
        L1a:
            r5.N(r1)     // Catch: java.lang.Throwable -> L5c
            goto L3d
        L1e:
            r0 = move-exception
            goto L2d
        L20:
            r2 = move-exception
            goto L39
        L22:
            r0 = move-exception
            goto L4f
        L24:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L58
        L29:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L2d:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = r0.getMessage()     // Catch: java.lang.Throwable -> L57
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L57
            throw r2     // Catch: java.lang.Throwable -> L57
        L37:
            r2 = move-exception
            r1 = r0
        L39:
            r5.Q(r2)     // Catch: java.lang.Throwable -> L57
            goto L1a
        L3d:
            if (r0 == 0) goto L43
            long r0 = r0.uidnext     // Catch: java.lang.Throwable -> L5c
            monitor-exit(r5)
            return r0
        L43:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch: java.lang.Throwable -> L5c
            java.lang.String r1 = "Cannot obtain UIDNext"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L5c
            throw r0     // Catch: java.lang.Throwable -> L5c
        L4b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L4f:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = "Cannot obtain UIDNext"
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L57
            throw r2     // Catch: java.lang.Throwable -> L57
        L57:
            r0 = move-exception
        L58:
            r5.N(r1)     // Catch: java.lang.Throwable -> L5c
            throw r0     // Catch: java.lang.Throwable -> L5c
        L5c:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getUIDNext():long");
    }

    public synchronized boolean getUIDNotSticky() throws MessagingException {
        j();
        return this.f37666x;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x003f A[Catch: all -> 0x005c, TRY_ENTER, TRY_LEAVE, TryCatch #7 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x001a, B:30:0x003f, B:33:0x0043, B:34:0x004a, B:40:0x0058, B:41:0x005b), top: B:46:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0043 A[Catch: all -> 0x005c, TRY_ENTER, TryCatch #7 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x001a, B:30:0x003f, B:33:0x0043, B:34:0x004a, B:40:0x0058, B:41:0x005b), top: B:46:0x0001 }] */
    @Override // javax.mail.UIDFolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized long getUIDValidity() throws javax.mail.MessagingException {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f37657n     // Catch: java.lang.Throwable -> L5c
            if (r0 == 0) goto L9
            long r0 = r5.f37664v     // Catch: java.lang.Throwable -> L5c
            monitor-exit(r5)
            return r0
        L9:
            r0 = 0
            com.sun.mail.imap.protocol.IMAPProtocol r1 = r5.B()     // Catch: java.lang.Throwable -> L24 com.sun.mail.iap.ProtocolException -> L29 com.sun.mail.iap.ConnectionException -> L37 com.sun.mail.iap.BadCommandException -> L4b
            java.lang.String r2 = "UIDVALIDITY"
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: com.sun.mail.iap.ProtocolException -> L1e com.sun.mail.iap.ConnectionException -> L20 com.sun.mail.iap.BadCommandException -> L22 java.lang.Throwable -> L57
            java.lang.String r3 = r5.f37644a     // Catch: com.sun.mail.iap.ProtocolException -> L1e com.sun.mail.iap.ConnectionException -> L20 com.sun.mail.iap.BadCommandException -> L22 java.lang.Throwable -> L57
            com.sun.mail.imap.protocol.Status r0 = r1.status(r3, r2)     // Catch: com.sun.mail.iap.ProtocolException -> L1e com.sun.mail.iap.ConnectionException -> L20 com.sun.mail.iap.BadCommandException -> L22 java.lang.Throwable -> L57
        L1a:
            r5.N(r1)     // Catch: java.lang.Throwable -> L5c
            goto L3d
        L1e:
            r0 = move-exception
            goto L2d
        L20:
            r2 = move-exception
            goto L39
        L22:
            r0 = move-exception
            goto L4f
        L24:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L58
        L29:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L2d:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = r0.getMessage()     // Catch: java.lang.Throwable -> L57
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L57
            throw r2     // Catch: java.lang.Throwable -> L57
        L37:
            r2 = move-exception
            r1 = r0
        L39:
            r5.Q(r2)     // Catch: java.lang.Throwable -> L57
            goto L1a
        L3d:
            if (r0 == 0) goto L43
            long r0 = r0.uidvalidity     // Catch: java.lang.Throwable -> L5c
            monitor-exit(r5)
            return r0
        L43:
            javax.mail.MessagingException r0 = new javax.mail.MessagingException     // Catch: java.lang.Throwable -> L5c
            java.lang.String r1 = "Cannot obtain UIDValidity"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L5c
            throw r0     // Catch: java.lang.Throwable -> L5c
        L4b:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L4f:
            javax.mail.MessagingException r2 = new javax.mail.MessagingException     // Catch: java.lang.Throwable -> L57
            java.lang.String r3 = "Cannot obtain UIDValidity"
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L57
            throw r2     // Catch: java.lang.Throwable -> L57
        L57:
            r0 = move-exception
        L58:
            r5.N(r1)     // Catch: java.lang.Throwable -> L5c
            throw r0     // Catch: java.lang.Throwable -> L5c
        L5c:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPFolder.getUIDValidity():long");
    }

    @Override // javax.mail.Folder
    public synchronized int getUnreadMessageCount() throws MessagingException {
        int length;
        if (!this.f37657n) {
            h();
            try {
                try {
                    return A().unseen;
                } catch (BadCommandException unused) {
                    return -1;
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            } catch (ConnectionException e5) {
                throw new StoreClosedException(this.store, e5.getMessage());
            }
        }
        Flags flags = new Flags();
        flags.add(Flags.Flag.SEEN);
        try {
            synchronized (this.f37655l) {
                length = z().search(new FlagTerm(flags, false)).length;
            }
            return length;
        } catch (ConnectionException e6) {
            throw new FolderClosedException(this, e6.getMessage());
        } catch (ProtocolException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        }
    }

    protected void h() throws MessagingException {
        if (!this.f37650g && !exists()) {
            throw new FolderNotFoundException(this, this.f37644a + " not found");
        }
    }

    @Override // com.sun.mail.iap.ResponseHandler
    public void handleResponse(Response response) {
        if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
            ((IMAPStore) this.store).r(response);
        }
        int i4 = 0;
        if (response.isBYE()) {
            if (this.f37657n) {
                l(false);
            }
        } else if (response.isOK()) {
            response.skipSpaces();
            if (response.readByte() == 91 && response.readAtom().equalsIgnoreCase("HIGHESTMODSEQ")) {
                this.f37667y = response.readLong();
            }
            response.reset();
        } else if (!response.isUnTagged()) {
        } else {
            if (!(response instanceof IMAPResponse)) {
                this.D.fine("UNEXPECTED RESPONSE : " + response.toString());
                return;
            }
            IMAPResponse iMAPResponse = (IMAPResponse) response;
            if (iMAPResponse.keyEquals(ResourceStates.EXISTS)) {
                int number = iMAPResponse.getNumber();
                int i5 = this.f37663u;
                if (number <= i5) {
                    return;
                }
                int i6 = number - i5;
                Message[] messageArr = new Message[i6];
                this.f37654k.addMessages(i6, i5 + 1);
                int i7 = this.f37661s;
                this.f37663u += i6;
                this.f37661s += i6;
                if (this.C) {
                    while (i4 < i6) {
                        i7++;
                        messageArr[i4] = this.f37654k.getMessage(i7);
                        i4++;
                    }
                    notifyMessageAddedListeners(messageArr);
                }
            } else if (iMAPResponse.keyEquals("EXPUNGE")) {
                int number2 = iMAPResponse.getNumber();
                if (number2 > this.f37663u) {
                    return;
                }
                Message[] messageArr2 = null;
                if (this.f37668z && this.C) {
                    IMAPMessage x3 = x(number2);
                    Message[] messageArr3 = {x3};
                    if (x3 != null) {
                        messageArr2 = messageArr3;
                    }
                }
                this.f37654k.expungeMessage(number2);
                this.f37663u--;
                if (messageArr2 != null) {
                    notifyMessageRemovedListeners(false, messageArr2);
                }
            } else if (iMAPResponse.keyEquals("VANISHED")) {
                if (iMAPResponse.readAtomStringList() == null) {
                    UIDSet[] parseUIDSets = UIDSet.parseUIDSets(iMAPResponse.readAtom());
                    this.f37663u = (int) (this.f37663u - UIDSet.size(parseUIDSets));
                    Message[] r4 = r(UIDSet.toArray(parseUIDSets));
                    int length = r4.length;
                    while (i4 < length) {
                        Message message = r4[i4];
                        if (message.getMessageNumber() > 0) {
                            this.f37654k.expungeMessage(message.getMessageNumber());
                        }
                        i4++;
                    }
                    if (this.f37668z && this.C) {
                        notifyMessageRemovedListeners(true, r4);
                    }
                }
            } else if (iMAPResponse.keyEquals("FETCH")) {
                Message L = L((FetchResponse) iMAPResponse);
                if (L != null) {
                    notifyMessageChangedListeners(1, L);
                }
            } else if (iMAPResponse.keyEquals("RECENT")) {
                this.f37662t = iMAPResponse.getNumber();
            }
        }
    }

    @Override // javax.mail.Folder
    public synchronized boolean hasNewMessages() throws MessagingException {
        String str;
        synchronized (this.f37655l) {
            boolean z3 = false;
            if (this.f37657n) {
                try {
                    try {
                        I(true);
                        if (this.f37662t > 0) {
                            z3 = true;
                        }
                        return z3;
                    } catch (ProtocolException e4) {
                        throw new MessagingException(e4.getMessage(), e4);
                    }
                } catch (ConnectionException e5) {
                    throw new FolderClosedException(this, e5.getMessage());
                }
            }
            if (this.f37651h && this.f37647d != 0) {
                str = this.f37644a + this.f37647d;
            } else {
                str = this.f37644a;
            }
            ListInfo[] listInfoArr = (ListInfo[]) doCommandIgnoreFailure(new r(str));
            if (listInfoArr != null) {
                int i4 = listInfoArr[u(listInfoArr, str)].changeState;
                if (i4 == 1) {
                    return true;
                }
                if (i4 == 2) {
                    return false;
                }
                try {
                    try {
                        if (A().recent <= 0) {
                            return false;
                        }
                        return true;
                    } catch (BadCommandException unused) {
                        return false;
                    } catch (ConnectionException e6) {
                        throw new StoreClosedException(this.store, e6.getMessage());
                    }
                } catch (ProtocolException e7) {
                    throw new MessagingException(e7.getMessage(), e7);
                }
            }
            throw new FolderNotFoundException(this, this.f37644a + " not found");
        }
    }

    public Map<String, String> id(Map<String, String> map) throws MessagingException {
        j();
        return (Map) doOptionalCommand("ID not supported", new l(map));
    }

    public void idle() throws MessagingException {
        idle(false);
    }

    @Override // javax.mail.Folder
    public synchronized boolean isOpen() {
        synchronized (this.f37655l) {
            if (this.f37657n) {
                try {
                    I(false);
                } catch (ProtocolException unused) {
                }
            }
        }
        return this.f37657n;
    }

    @Override // javax.mail.Folder
    public synchronized boolean isSubscribed() {
        String str;
        ListInfo[] listInfoArr;
        if (this.f37651h && this.f37647d != 0) {
            str = this.f37644a + this.f37647d;
        } else {
            str = this.f37644a;
        }
        try {
            listInfoArr = (ListInfo[]) t(new o(str));
        } catch (ProtocolException unused) {
            listInfoArr = null;
        }
        if (listInfoArr != null) {
            return listInfoArr[u(listInfoArr, str)].canOpen;
        }
        return false;
    }

    protected void j() throws FolderClosedException {
        if (!this.f37657n) {
            if (this.f37658o) {
                throw new IllegalStateException("This operation is not allowed on a closed folder");
            }
            throw new FolderClosedException(this, "Lost folder connection to server");
        }
    }

    protected void k(int i4) throws MessagingException {
        if (i4 >= 1) {
            if (i4 <= this.f37661s) {
                return;
            }
            synchronized (this.f37655l) {
                try {
                    try {
                        I(false);
                    } catch (ProtocolException e4) {
                        throw new MessagingException(e4.getMessage(), e4);
                    }
                } catch (ConnectionException e5) {
                    throw new FolderClosedException(this, e5.getMessage());
                }
            }
            if (i4 <= this.f37661s) {
                return;
            }
            throw new IndexOutOfBoundsException(i4 + " > " + this.f37661s);
        }
        throw new IndexOutOfBoundsException("message number < 1");
    }

    @Override // javax.mail.Folder
    public Folder[] list(String str) throws MessagingException {
        return s(str, false);
    }

    public Rights[] listRights(String str) throws MessagingException {
        return (Rights[]) doOptionalCommand("ACL not supported", new g(str));
    }

    @Override // javax.mail.Folder
    public Folder[] listSubscribed(String str) throws MessagingException {
        return s(str, true);
    }

    public synchronized void moveMessages(Message[] messageArr, Folder folder) throws MessagingException {
        o(messageArr, folder, true);
    }

    public synchronized AppendUID[] moveUIDMessages(Message[] messageArr, Folder folder) throws MessagingException {
        return p(messageArr, folder, true);
    }

    public Rights myRights() throws MessagingException {
        return (Rights) doOptionalCommand("ACL not supported", new h());
    }

    @Override // javax.mail.Folder
    public synchronized void open(int i4) throws MessagingException {
        open(i4, null);
    }

    public void removeACL(String str) throws MessagingException {
        doOptionalCommand("ACL not supported", new f(str));
    }

    public void removeRights(ACL acl) throws MessagingException {
        O(acl, SignatureVisitor.SUPER);
    }

    @Override // javax.mail.Folder
    public synchronized boolean renameTo(Folder folder) throws MessagingException {
        g();
        h();
        if (folder.getStore() == this.store) {
            if (doCommandIgnoreFailure(new t(folder)) == null) {
                return false;
            }
            this.f37650g = false;
            this.f37652i = null;
            notifyFolderRenamedListeners(folder);
            return true;
        }
        throw new MessagingException("Can't rename across Stores");
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm) throws MessagingException {
        IMAPMessage[] y3;
        j();
        try {
            try {
                synchronized (this.f37655l) {
                    int[] search = z().search(searchTerm);
                    y3 = search != null ? y(search) : null;
                }
            } catch (ProtocolException e4) {
                throw new MessagingException(e4.getMessage(), e4);
            } catch (SearchException e5) {
                if (!((IMAPStore) this.store).G()) {
                    return super.search(searchTerm);
                }
                throw e5;
            }
        } catch (CommandFailedException unused) {
            return super.search(searchTerm);
        } catch (ConnectionException e6) {
            throw new FolderClosedException(this, e6.getMessage());
        }
        return y3;
    }

    @Override // javax.mail.Folder
    public synchronized void setFlags(Message[] messageArr, Flags flags, boolean z3) throws MessagingException {
        j();
        i(flags);
        if (messageArr.length == 0) {
            return;
        }
        synchronized (this.f37655l) {
            try {
                IMAPProtocol z4 = z();
                MessageSet[] messageSetSorted = Utility.toMessageSetSorted(messageArr, null);
                if (messageSetSorted != null) {
                    z4.storeFlags(messageSetSorted, flags, z3);
                } else {
                    throw new MessageRemovedException("Messages have been removed");
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    public void setQuota(Quota quota) throws MessagingException {
        doOptionalCommand("QUOTA not supported", new d(quota));
    }

    @Override // javax.mail.Folder
    public synchronized void setSubscribed(boolean z3) throws MessagingException {
        doCommandIgnoreFailure(new p(z3));
    }

    protected synchronized Object t(ProtocolCommand protocolCommand) throws ProtocolException {
        IMAPProtocol iMAPProtocol;
        Object doCommand;
        if (this.f37653j != null) {
            synchronized (this.f37655l) {
                doCommand = protocolCommand.doCommand(z());
            }
            return doCommand;
        }
        try {
            iMAPProtocol = B();
        } catch (Throwable th) {
            th = th;
            iMAPProtocol = null;
        }
        try {
            Object doCommand2 = protocolCommand.doCommand(iMAPProtocol);
            N(iMAPProtocol);
            return doCommand2;
        } catch (Throwable th2) {
            th = th2;
            N(iMAPProtocol);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SocketChannel v() {
        if (this.f37653j != null) {
            return this.f37653j.getChannel();
        }
        return null;
    }

    protected String w() {
        return "ENVELOPE INTERNALDATE RFC822.SIZE";
    }

    protected IMAPMessage x(int i4) {
        if (i4 > this.f37654k.size()) {
            if (this.D.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.D;
                mailLogger.fine("ignoring message number " + i4 + " outside range " + this.f37654k.size());
                return null;
            }
            return null;
        }
        return this.f37654k.getMessageBySeqnum(i4);
    }

    protected IMAPMessage[] y(int[] iArr) {
        int length = iArr.length;
        IMAPMessage[] iMAPMessageArr = new IMAPMessage[length];
        int i4 = 0;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            IMAPMessage x3 = x(iArr[i5]);
            iMAPMessageArr[i5] = x3;
            if (x3 == null) {
                i4++;
            }
        }
        if (i4 > 0) {
            IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[iArr.length - i4];
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                IMAPMessage iMAPMessage = iMAPMessageArr[i7];
                if (iMAPMessage != null) {
                    iMAPMessageArr2[i6] = iMAPMessage;
                    i6++;
                }
            }
            return iMAPMessageArr2;
        }
        return iMAPMessageArr;
    }

    protected IMAPProtocol z() throws ProtocolException {
        R();
        if (this.f37653j != null) {
            return this.f37653j;
        }
        throw new ConnectionException("Connection closed");
    }

    public synchronized Message[] expunge(Message[] messageArr) throws MessagingException {
        Message[] removeExpungedMessages;
        j();
        if (messageArr != null) {
            FetchProfile fetchProfile = new FetchProfile();
            fetchProfile.add(UIDFolder.FetchProfileItem.UID);
            fetch(messageArr, fetchProfile);
        }
        synchronized (this.f37655l) {
            this.f37668z = false;
            try {
                IMAPProtocol z3 = z();
                if (messageArr != null) {
                    z3.uidexpunge(Utility.toUIDSet(messageArr));
                } else {
                    z3.expunge();
                }
                this.f37668z = true;
                if (messageArr != null) {
                    removeExpungedMessages = this.f37654k.removeExpungedMessages(messageArr);
                } else {
                    removeExpungedMessages = this.f37654k.removeExpungedMessages();
                }
                if (this.f37656m != null) {
                    for (IMAPMessage iMAPMessage : removeExpungedMessages) {
                        long x3 = iMAPMessage.x();
                        if (x3 != -1) {
                            this.f37656m.remove(Long.valueOf(x3));
                        }
                    }
                }
                this.f37661s = this.f37654k.size();
            } catch (CommandFailedException e4) {
                if (this.mode != 2) {
                    throw new IllegalStateException("Cannot expunge READ_ONLY folder: " + this.f37644a);
                }
                throw new MessagingException(e4.getMessage(), e4);
            } catch (ConnectionException e5) {
                throw new FolderClosedException(this, e5.getMessage());
            } catch (ProtocolException e6) {
                throw new MessagingException(e6.getMessage(), e6);
            }
        }
        if (removeExpungedMessages.length > 0) {
            notifyMessageRemovedListeners(true, removeExpungedMessages);
        }
        return removeExpungedMessages;
    }

    public synchronized Message[] getSortedMessages(SortTerm[] sortTermArr, SearchTerm searchTerm) throws MessagingException {
        IMAPMessage[] y3;
        j();
        try {
            try {
                try {
                    synchronized (this.f37655l) {
                        int[] sort = z().sort(sortTermArr, searchTerm);
                        y3 = sort != null ? y(sort) : null;
                    }
                } catch (ConnectionException e4) {
                    throw new FolderClosedException(this, e4.getMessage());
                } catch (ProtocolException e5) {
                    throw new MessagingException(e5.getMessage(), e5);
                }
            } catch (SearchException e6) {
                throw new MessagingException(e6.getMessage(), e6);
            }
        } catch (CommandFailedException e7) {
            throw new MessagingException(e7.getMessage(), e7);
        }
        return y3;
    }

    public void idle(boolean z3) throws MessagingException {
        synchronized (this) {
            if (this.f37653j != null && this.f37653j.getChannel() != null) {
                throw new MessagingException("idle method not supported with SocketChannels");
            }
        }
        if (P(null)) {
            do {
            } while (C(z3));
            int l4 = ((IMAPStore) this.store).l();
            if (l4 > 0) {
                try {
                    Thread.sleep(l4);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public synchronized List<MailEvent> open(int i4, ResyncData resyncData) throws MessagingException {
        MailboxInfo select;
        ArrayList arrayList;
        long[] array;
        Message L;
        g();
        this.f37653j = ((IMAPStore) this.store).o(this);
        synchronized (this.f37655l) {
            this.f37653j.addResponseHandler(this);
            if (resyncData != null) {
                try {
                    if (resyncData == ResyncData.CONDSTORE) {
                        if (!this.f37653j.isEnabled("CONDSTORE") && !this.f37653j.isEnabled("QRESYNC")) {
                            if (this.f37653j.hasCapability("CONDSTORE")) {
                                this.f37653j.enable("CONDSTORE");
                            } else {
                                this.f37653j.enable("QRESYNC");
                            }
                        }
                    } else if (!this.f37653j.isEnabled("QRESYNC")) {
                        this.f37653j.enable("QRESYNC");
                    }
                } catch (CommandFailedException e4) {
                    h();
                    if ((this.f37646c & 1) == 0) {
                        throw new MessagingException("folder cannot contain messages");
                    }
                    throw new MessagingException(e4.getMessage(), e4);
                } catch (ProtocolException e5) {
                    throw J(e5.getMessage(), e5);
                }
            }
            if (i4 == 1) {
                select = this.f37653j.examine(this.f37644a, resyncData);
            } else {
                select = this.f37653j.select(this.f37644a, resyncData);
            }
            int i5 = select.mode;
            if (i5 != i4 && (i4 != 2 || i5 != 1 || !((IMAPStore) this.store).b())) {
                throw m(new ReadOnlyFolderException(this, "Cannot open in desired mode"));
            }
            this.f37657n = true;
            this.f37658o = false;
            this.mode = select.mode;
            this.f37648e = select.availableFlags;
            this.f37649f = select.permanentFlags;
            int i6 = select.total;
            this.f37663u = i6;
            this.f37661s = i6;
            this.f37662t = select.recent;
            this.f37664v = select.uidvalidity;
            this.f37665w = select.uidnext;
            this.f37666x = select.uidNotSticky;
            this.f37667y = select.highestmodseq;
            this.f37654k = new MessageCache(this, (IMAPStore) this.store, this.f37661s);
            if (select.responses != null) {
                arrayList = new ArrayList();
                for (IMAPResponse iMAPResponse : select.responses) {
                    if (iMAPResponse.keyEquals("VANISHED")) {
                        String[] readAtomStringList = iMAPResponse.readAtomStringList();
                        if (readAtomStringList != null && readAtomStringList.length == 1 && readAtomStringList[0].equalsIgnoreCase("EARLIER") && (array = UIDSet.toArray(UIDSet.parseUIDSets(iMAPResponse.readAtom()), this.f37665w)) != null && array.length > 0) {
                            arrayList.add(new MessageVanishedEvent(this, array));
                        }
                    } else if (iMAPResponse.keyEquals("FETCH") && (L = L((FetchResponse) iMAPResponse)) != null) {
                        arrayList.add(new MessageChangedEvent(this, 1, L));
                    }
                }
            } else {
                arrayList = null;
            }
        }
        this.f37650g = true;
        this.f37652i = null;
        this.f37646c = 1;
        notifyConnectionListeners(1);
        return arrayList;
    }

    @Override // javax.mail.Folder
    public synchronized Message[] search(SearchTerm searchTerm, Message[] messageArr) throws MessagingException {
        IMAPMessage[] y3;
        j();
        if (messageArr.length == 0) {
            return messageArr;
        }
        try {
            try {
                try {
                    try {
                        synchronized (this.f37655l) {
                            IMAPProtocol z3 = z();
                            MessageSet[] messageSetSorted = Utility.toMessageSetSorted(messageArr, null);
                            if (messageSetSorted != null) {
                                int[] search = z3.search(messageSetSorted, searchTerm);
                                y3 = search != null ? y(search) : null;
                            } else {
                                throw new MessageRemovedException("Messages have been removed");
                            }
                        }
                        return y3;
                    } catch (ConnectionException e4) {
                        throw new FolderClosedException(this, e4.getMessage());
                    }
                } catch (SearchException unused) {
                    return super.search(searchTerm, messageArr);
                }
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        } catch (CommandFailedException unused2) {
            return super.search(searchTerm, messageArr);
        }
    }

    @Override // javax.mail.Folder
    public synchronized void setFlags(int i4, int i5, Flags flags, boolean z3) throws MessagingException {
        j();
        Message[] messageArr = new Message[(i5 - i4) + 1];
        int i6 = 0;
        while (i4 <= i5) {
            messageArr[i6] = getMessage(i4);
            i4++;
            i6++;
        }
        setFlags(messageArr, flags, z3);
    }

    @Override // javax.mail.UIDFolder
    public synchronized Message[] getMessagesByUID(long[] jArr) throws MessagingException {
        long[] jArr2;
        Message[] messageArr;
        j();
        try {
            synchronized (this.f37655l) {
                if (this.f37656m != null) {
                    ArrayList arrayList = new ArrayList();
                    for (long j4 : jArr) {
                        if (!this.f37656m.containsKey(Long.valueOf(j4))) {
                            arrayList.add(Long.valueOf(j4));
                        }
                    }
                    int size = arrayList.size();
                    jArr2 = new long[size];
                    for (int i4 = 0; i4 < size; i4++) {
                        jArr2[i4] = ((Long) arrayList.get(i4)).longValue();
                    }
                } else {
                    this.f37656m = new Hashtable<>();
                    jArr2 = jArr;
                }
                if (jArr2.length > 0) {
                    z().fetchSequenceNumbers(jArr2);
                }
                messageArr = new Message[jArr.length];
                for (int i5 = 0; i5 < jArr.length; i5++) {
                    messageArr[i5] = this.f37656m.get(Long.valueOf(jArr[i5]));
                }
            }
        } catch (ConnectionException e4) {
            throw new FolderClosedException(this, e4.getMessage());
        } catch (ProtocolException e5) {
            throw new MessagingException(e5.getMessage(), e5);
        }
        return messageArr;
    }

    @Override // javax.mail.Folder
    public synchronized void setFlags(int[] iArr, Flags flags, boolean z3) throws MessagingException {
        j();
        Message[] messageArr = new Message[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            messageArr[i4] = getMessage(iArr[i4]);
        }
        setFlags(messageArr, flags, z3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPFolder(ListInfo listInfo, IMAPStore iMAPStore) {
        this(listInfo.name, listInfo.separator, iMAPStore, null);
        if (listInfo.hasInferiors) {
            this.f37646c |= 2;
        }
        if (listInfo.canOpen) {
            this.f37646c |= 1;
        }
        this.f37650g = true;
        this.f37652i = listInfo.attrs;
    }
}
