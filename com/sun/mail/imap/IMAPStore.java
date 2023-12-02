package com.sun.mail.imap;

import com.google.firebase.firestore.util.ExponentialBackoff;
import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.iap.ResponseHandler;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.IMAPReferralException;
import com.sun.mail.imap.protocol.ListInfo;
import com.sun.mail.imap.protocol.Namespaces;
import com.sun.mail.util.MailConnectException;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SocketConnectException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Quota;
import javax.mail.QuotaAwareStore;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.StoreClosedException;
import javax.mail.URLName;
import kotlin.jvm.internal.CharCompanionObject;
import org.altbeacon.beacon.service.scanner.CycledLeScanner;
import org.apache.http.client.params.AuthPolicy;

/* loaded from: classes6.dex */
public class IMAPStore extends Store implements QuotaAwareStore, ResponseHandler {
    public static final String ID_ADDRESS = "address";
    public static final String ID_ARGUMENTS = "arguments";
    public static final String ID_COMMAND = "command";
    public static final String ID_DATE = "date";
    public static final String ID_ENVIRONMENT = "environment";
    public static final String ID_NAME = "name";
    public static final String ID_OS = "os";
    public static final String ID_OS_VERSION = "os-version";
    public static final String ID_SUPPORT_URL = "support-url";
    public static final String ID_VENDOR = "vendor";
    public static final String ID_VERSION = "version";
    public static final int RESPONSE = 1000;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private volatile boolean F;
    private volatile boolean G;
    private final Object H;
    private boolean I;
    private boolean J;
    protected MailLogger K;
    private boolean L;
    private volatile Constructor<?> M;
    private volatile Constructor<?> N;
    private final b O;
    private ResponseHandler P;

    /* renamed from: a  reason: collision with root package name */
    protected final String f37750a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f37751b;

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f37752c;

    /* renamed from: d  reason: collision with root package name */
    private final int f37753d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f37754e;

    /* renamed from: f  reason: collision with root package name */
    private final int f37755f;

    /* renamed from: g  reason: collision with root package name */
    private final int f37756g;

    /* renamed from: h  reason: collision with root package name */
    private final int f37757h;

    /* renamed from: i  reason: collision with root package name */
    private volatile int f37758i;

    /* renamed from: j  reason: collision with root package name */
    protected String f37759j;

    /* renamed from: k  reason: collision with root package name */
    protected String f37760k;

    /* renamed from: l  reason: collision with root package name */
    protected String f37761l;

    /* renamed from: m  reason: collision with root package name */
    protected String f37762m;

    /* renamed from: n  reason: collision with root package name */
    protected String f37763n;

    /* renamed from: o  reason: collision with root package name */
    protected String f37764o;

    /* renamed from: p  reason: collision with root package name */
    private Namespaces f37765p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f37766r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f37767s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f37768t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f37769u;

    /* renamed from: v  reason: collision with root package name */
    private String[] f37770v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f37771w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f37772x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f37773y;

    /* renamed from: z  reason: collision with root package name */
    private String f37774z;

    /* loaded from: classes6.dex */
    class a implements ResponseHandler {
        a() {
        }

        @Override // com.sun.mail.iap.ResponseHandler
        public void handleResponse(Response response) {
            if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
                IMAPStore.this.r(response);
            }
            if (response.isBYE()) {
                IMAPStore.this.K.fine("IMAPStore non-store connection dead");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: b  reason: collision with root package name */
        private Vector<IMAPFolder> f37777b;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f37780e;

        /* renamed from: f  reason: collision with root package name */
        private final long f37781f;

        /* renamed from: g  reason: collision with root package name */
        private final long f37782g;

        /* renamed from: h  reason: collision with root package name */
        private final int f37783h;

        /* renamed from: i  reason: collision with root package name */
        private final long f37784i;

        /* renamed from: j  reason: collision with root package name */
        private final MailLogger f37785j;

        /* renamed from: l  reason: collision with root package name */
        private IMAPProtocol f37787l;

        /* renamed from: a  reason: collision with root package name */
        private Vector<IMAPProtocol> f37776a = new Vector<>();

        /* renamed from: c  reason: collision with root package name */
        private boolean f37778c = false;

        /* renamed from: k  reason: collision with root package name */
        private int f37786k = 0;

        /* renamed from: d  reason: collision with root package name */
        private long f37779d = System.currentTimeMillis();

        b(String str, MailLogger mailLogger, Session session) {
            Properties properties = session.getProperties();
            MailLogger subLogger = mailLogger.getSubLogger("connectionpool", "DEBUG IMAP CP", PropUtil.getBooleanProperty(properties, "mail." + str + ".connectionpool.debug", false));
            this.f37785j = subLogger;
            int intProperty = PropUtil.getIntProperty(properties, "mail." + str + ".connectionpoolsize", -1);
            if (intProperty > 0) {
                this.f37783h = intProperty;
                if (subLogger.isLoggable(Level.CONFIG)) {
                    subLogger.config("mail.imap.connectionpoolsize: " + intProperty);
                }
            } else {
                this.f37783h = 1;
            }
            int intProperty2 = PropUtil.getIntProperty(properties, "mail." + str + ".connectionpooltimeout", -1);
            if (intProperty2 > 0) {
                long j4 = intProperty2;
                this.f37781f = j4;
                if (subLogger.isLoggable(Level.CONFIG)) {
                    subLogger.config("mail.imap.connectionpooltimeout: " + j4);
                }
            } else {
                this.f37781f = 45000L;
            }
            int intProperty3 = PropUtil.getIntProperty(properties, "mail." + str + ".servertimeout", -1);
            if (intProperty3 > 0) {
                long j5 = intProperty3;
                this.f37782g = j5;
                if (subLogger.isLoggable(Level.CONFIG)) {
                    subLogger.config("mail.imap.servertimeout: " + j5);
                }
            } else {
                this.f37782g = CycledLeScanner.ANDROID_N_MAX_SCAN_DURATION_MILLIS;
            }
            int intProperty4 = PropUtil.getIntProperty(properties, "mail." + str + ".pruninginterval", -1);
            if (intProperty4 > 0) {
                long j6 = intProperty4;
                this.f37784i = j6;
                if (subLogger.isLoggable(Level.CONFIG)) {
                    subLogger.config("mail.imap.pruninginterval: " + j6);
                }
            } else {
                this.f37784i = ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
            }
            boolean booleanProperty = PropUtil.getBooleanProperty(properties, "mail." + str + ".separatestoreconnection", false);
            this.f37780e = booleanProperty;
            if (booleanProperty) {
                subLogger.config("dedicate a store connection");
            }
        }
    }

    public IMAPStore(Session session, URLName uRLName) {
        this(session, uRLName, "imap", false);
    }

    private void C() {
        InetAddress inetAddress;
        if (this.K.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.K;
            mailLogger.fine("refresh password, user: " + traceUser(this.f37760k));
        }
        try {
            inetAddress = InetAddress.getByName(this.f37759j);
        } catch (UnknownHostException unused) {
            inetAddress = null;
        }
        PasswordAuthentication requestPasswordAuthentication = this.session.requestPasswordAuthentication(inetAddress, this.f37758i, this.f37750a, null, this.f37760k);
        if (requestPasswordAuthentication != null) {
            this.f37760k = requestPasswordAuthentication.getUserName();
            this.f37761l = requestPasswordAuthentication.getPassword();
        }
    }

    private void F(IMAPProtocol iMAPProtocol) {
        boolean z3;
        if (iMAPProtocol == null) {
            d();
            return;
        }
        synchronized (this.H) {
            z3 = this.F;
            this.F = false;
        }
        synchronized (this.O) {
            this.O.f37778c = false;
            this.O.notifyAll();
            this.O.f37785j.fine("releaseStoreProtocol()");
            H();
        }
        if (z3) {
            d();
        }
    }

    private void H() {
        synchronized (this.O) {
            if (System.currentTimeMillis() - this.O.f37779d > this.O.f37784i && this.O.f37776a.size() > 1) {
                if (this.O.f37785j.isLoggable(Level.FINE)) {
                    this.O.f37785j.fine("checking for connections to prune: " + (System.currentTimeMillis() - this.O.f37779d));
                    this.O.f37785j.fine("clientTimeoutInterval: " + this.O.f37781f);
                }
                for (int size = this.O.f37776a.size() - 1; size > 0; size--) {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.O.f37776a.elementAt(size);
                    if (this.O.f37785j.isLoggable(Level.FINE)) {
                        this.O.f37785j.fine("protocol last used: " + (System.currentTimeMillis() - iMAPProtocol.getTimestamp()));
                    }
                    if (System.currentTimeMillis() - iMAPProtocol.getTimestamp() > this.O.f37781f) {
                        this.O.f37785j.fine("authenticated connection timed out, logging out the connection");
                        iMAPProtocol.removeResponseHandler(this);
                        this.O.f37776a.removeElementAt(size);
                        try {
                            iMAPProtocol.logout();
                        } catch (ProtocolException unused) {
                        }
                    }
                }
                this.O.f37779d = System.currentTimeMillis();
            }
        }
    }

    private void I() throws ProtocolException {
        while (this.O.f37786k != 0) {
            if (this.O.f37786k == 1) {
                this.O.f37787l.idleAbort();
                this.O.f37786k = 2;
            }
            try {
                this.O.wait();
            } catch (InterruptedException e4) {
                throw new ProtocolException("Interrupted waitIfIdle", e4);
            }
        }
    }

    private void c(IMAPProtocol iMAPProtocol, String str, String str2, String str3) throws ProtocolException {
        Locale locale;
        String property = this.session.getProperty("mail." + this.f37750a + ".auth.mechanisms");
        if (property == null) {
            property = "PLAIN LOGIN NTLM XOAUTH2";
        }
        StringTokenizer stringTokenizer = new StringTokenizer(property);
        while (stringTokenizer.hasMoreTokens()) {
            String upperCase = stringTokenizer.nextToken().toUpperCase(Locale.ENGLISH);
            if (property == "PLAIN LOGIN NTLM XOAUTH2") {
                String str4 = "mail." + this.f37750a + ".auth." + upperCase.toLowerCase(locale) + ".disable";
                if (PropUtil.getBooleanProperty(this.session.getProperties(), str4, upperCase.equals("XOAUTH2"))) {
                    if (this.K.isLoggable(Level.FINE)) {
                        this.K.fine("mechanism " + upperCase + " disabled by property: " + str4);
                    }
                }
            }
            if (!iMAPProtocol.hasCapability("AUTH=" + upperCase) && (!upperCase.equals("LOGIN") || !iMAPProtocol.hasCapability("AUTH-LOGIN"))) {
                this.K.log(Level.FINE, "mechanism {0} not supported by server", upperCase);
            } else if (upperCase.equals("PLAIN")) {
                iMAPProtocol.authplain(str, str2, str3);
                return;
            } else if (upperCase.equals("LOGIN")) {
                iMAPProtocol.authlogin(str2, str3);
                return;
            } else if (upperCase.equals(AuthPolicy.NTLM)) {
                iMAPProtocol.authntlm(str, str2, str3);
                return;
            } else if (upperCase.equals("XOAUTH2")) {
                iMAPProtocol.authoauth2(str2, str3);
                return;
            } else {
                this.K.log(Level.FINE, "no authenticator for mechanism {0}", upperCase);
            }
        }
        if (!iMAPProtocol.hasCapability("LOGINDISABLED")) {
            iMAPProtocol.login(str2, str3);
            return;
        }
        throw new ProtocolException("No login methods supported!");
    }

    private void checkConnected() {
        if (super.isConnected()) {
            return;
        }
        throw new IllegalStateException("Not connected");
    }

    private synchronized void d() {
        boolean z3;
        if (!super.isConnected()) {
            this.K.fine("IMAPStore cleanup, not connected");
            return;
        }
        synchronized (this.H) {
            z3 = this.G;
            this.G = false;
            this.F = false;
        }
        if (this.K.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.K;
            mailLogger.fine("IMAPStore cleanup, force " + z3);
        }
        if (!z3 || this.C) {
            e(z3);
        }
        f(z3);
        try {
            super.close();
        } catch (MessagingException unused) {
        }
        this.K.fine("IMAPStore cleanup done");
    }

    private void e(boolean z3) {
        boolean z4;
        Vector vector = null;
        while (true) {
            synchronized (this.O) {
                if (this.O.f37777b != null) {
                    vector = this.O.f37777b;
                    this.O.f37777b = null;
                    z4 = false;
                } else {
                    z4 = true;
                }
            }
            if (z4) {
                return;
            }
            int size = vector.size();
            for (int i4 = 0; i4 < size; i4++) {
                IMAPFolder iMAPFolder = (IMAPFolder) vector.get(i4);
                if (z3) {
                    try {
                        this.K.fine("force folder to close");
                        iMAPFolder.forceClose();
                    } catch (IllegalStateException | MessagingException unused) {
                    }
                } else {
                    this.K.fine("close folder");
                    iMAPFolder.close(false);
                }
            }
        }
    }

    private void f(boolean z3) {
        synchronized (this.O) {
            for (int size = this.O.f37776a.size() - 1; size >= 0; size--) {
                try {
                    IMAPProtocol iMAPProtocol = (IMAPProtocol) this.O.f37776a.elementAt(size);
                    iMAPProtocol.removeResponseHandler(this);
                    if (z3) {
                        iMAPProtocol.disconnect();
                    } else {
                        iMAPProtocol.logout();
                    }
                } catch (ProtocolException unused) {
                }
            }
            this.O.f37776a.removeAllElements();
        }
        this.O.f37785j.fine("removed all authenticated connections from pool");
    }

    private synchronized Namespaces m() throws MessagingException {
        checkConnected();
        if (this.f37765p == null) {
            IMAPProtocol iMAPProtocol = null;
            try {
                iMAPProtocol = q();
                this.f37765p = iMAPProtocol.namespace();
            } catch (BadCommandException unused) {
            } catch (ConnectionException e4) {
                throw new StoreClosedException(this, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
            F(iMAPProtocol);
        }
        return this.f37765p;
    }

    private IMAPProtocol q() throws ProtocolException {
        IMAPProtocol iMAPProtocol = null;
        while (iMAPProtocol == null) {
            synchronized (this.O) {
                I();
                if (this.O.f37776a.isEmpty()) {
                    this.O.f37785j.fine("getStoreProtocol() - no connections in the pool, creating a new one");
                    try {
                        if (this.f37771w) {
                            C();
                        }
                        iMAPProtocol = A(this.f37759j, this.f37758i);
                        v(iMAPProtocol, this.f37760k, this.f37761l);
                    } catch (Exception unused) {
                        if (iMAPProtocol != null) {
                            try {
                                iMAPProtocol.logout();
                            } catch (Exception unused2) {
                            }
                        }
                        iMAPProtocol = null;
                    }
                    if (iMAPProtocol != null) {
                        iMAPProtocol.addResponseHandler(this);
                        this.O.f37776a.addElement(iMAPProtocol);
                    } else {
                        throw new ConnectionException("failed to create new store connection");
                    }
                } else {
                    if (this.O.f37785j.isLoggable(Level.FINE)) {
                        this.O.f37785j.fine("getStoreProtocol() - connection available -- size: " + this.O.f37776a.size());
                    }
                    iMAPProtocol = (IMAPProtocol) this.O.f37776a.firstElement();
                    String str = this.f37762m;
                    if (str != null && !str.equals(iMAPProtocol.getProxyAuthUser()) && iMAPProtocol.hasCapability("X-UNAUTHENTICATE")) {
                        iMAPProtocol.unauthenticate();
                        v(iMAPProtocol, this.f37760k, this.f37761l);
                    }
                }
                if (!this.O.f37778c) {
                    this.O.f37778c = true;
                    this.O.f37785j.fine("getStoreProtocol() -- storeConnectionInUse");
                } else {
                    try {
                        this.O.wait();
                        iMAPProtocol = null;
                    } catch (InterruptedException e4) {
                        Thread.currentThread().interrupt();
                        throw new ProtocolException("Interrupted getStoreProtocol", e4);
                    }
                }
                H();
            }
        }
        return iMAPProtocol;
    }

    private String tracePassword(String str) {
        if (!this.J) {
            if (str == null) {
                return "<null>";
            }
            return "<non-null>";
        }
        return str;
    }

    private String traceUser(String str) {
        if (!this.I) {
            return "<user name suppressed>";
        }
        return str;
    }

    private void v(IMAPProtocol iMAPProtocol, String str, String str2) throws ProtocolException {
        if ((this.f37766r || this.f37767s) && !iMAPProtocol.isSSL()) {
            if (iMAPProtocol.hasCapability("STARTTLS")) {
                iMAPProtocol.startTLS();
                iMAPProtocol.capability();
            } else if (this.f37767s) {
                this.K.fine("STARTTLS required but not supported by server");
                throw new ProtocolException("STARTTLS required but not supported by server");
            }
        }
        if (iMAPProtocol.isAuthenticated()) {
            return;
        }
        B(iMAPProtocol);
        if (this.f37774z != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("GUID", this.f37774z);
            iMAPProtocol.id(hashMap);
        }
        iMAPProtocol.getCapabilities().put("__PRELOGIN__", "");
        String str3 = this.f37763n;
        if (str3 == null && (str3 = this.f37762m) == null) {
            str3 = null;
        }
        if (this.f37769u) {
            try {
                iMAPProtocol.sasllogin(this.f37770v, this.f37764o, str3, str, str2);
                if (!iMAPProtocol.isAuthenticated()) {
                    throw new CommandFailedException("SASL authentication failed");
                }
            } catch (UnsupportedOperationException unused) {
            }
        }
        if (!iMAPProtocol.isAuthenticated()) {
            c(iMAPProtocol, str3, str, str2);
        }
        String str4 = this.f37762m;
        if (str4 != null) {
            iMAPProtocol.proxyauth(str4);
        }
        if (iMAPProtocol.hasCapability("__PRELOGIN__")) {
            try {
                iMAPProtocol.capability();
            } catch (ConnectionException e4) {
                throw e4;
            } catch (ProtocolException unused2) {
            }
        }
        if (this.D && iMAPProtocol.hasCapability("COMPRESS=DEFLATE")) {
            iMAPProtocol.compress();
        }
        if (iMAPProtocol.hasCapability("UTF8=ACCEPT") || iMAPProtocol.hasCapability("UTF8=ONLY")) {
            iMAPProtocol.enable("UTF8=ACCEPT");
        }
    }

    private Folder[] w(Namespaces.Namespace[] namespaceArr, String str) {
        boolean z3;
        int length = namespaceArr.length;
        Folder[] folderArr = new Folder[length];
        for (int i4 = 0; i4 < length; i4++) {
            String str2 = namespaceArr[i4].prefix;
            if (str == null) {
                int length2 = str2.length();
                if (length2 > 0) {
                    int i5 = length2 - 1;
                    if (str2.charAt(i5) == namespaceArr[i4].delimiter) {
                        str2 = str2.substring(0, i5);
                    }
                }
            } else {
                str2 = str2 + str;
            }
            char c4 = namespaceArr[i4].delimiter;
            if (str == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            folderArr[i4] = z(str2, c4, Boolean.valueOf(z3));
        }
        return folderArr;
    }

    protected IMAPProtocol A(String str, int i4) throws IOException, ProtocolException {
        return new IMAPProtocol(this.f37750a, str, i4, this.session.getProperties(), this.f37752c, this.K);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(IMAPProtocol iMAPProtocol) {
        if (iMAPProtocol == null) {
            return;
        }
        iMAPProtocol.removeResponseHandler(this.P);
        iMAPProtocol.addResponseHandler(this);
        synchronized (this.O) {
            this.O.f37778c = false;
            this.O.notifyAll();
            this.O.f37785j.fine("releaseFolderStoreProtocol()");
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(IMAPFolder iMAPFolder, IMAPProtocol iMAPProtocol) {
        synchronized (this.O) {
            if (iMAPProtocol != null) {
                if (!u()) {
                    iMAPProtocol.addResponseHandler(this);
                    this.O.f37776a.addElement(iMAPProtocol);
                    if (this.K.isLoggable(Level.FINE)) {
                        MailLogger mailLogger = this.K;
                        mailLogger.fine("added an Authenticated connection -- size: " + this.O.f37776a.size());
                    }
                } else {
                    this.K.fine("pool is full, not adding an Authenticated connection");
                    try {
                        iMAPProtocol.logout();
                    } catch (ProtocolException unused) {
                    }
                }
            }
            if (this.O.f37777b != null) {
                this.O.f37777b.removeElement(iMAPFolder);
            }
            H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        Properties properties = this.session.getProperties();
        return PropUtil.getBooleanProperty(properties, "mail." + this.f37750a + ".allowreadonlyselect", false);
    }

    @Override // javax.mail.Service, java.lang.AutoCloseable
    public synchronized void close() throws MessagingException {
        d();
        e(true);
        f(true);
    }

    @Override // javax.mail.Service
    protected void finalize() throws Throwable {
        if (!this.E) {
            synchronized (this.H) {
                this.F = true;
                this.G = true;
            }
            this.C = true;
        }
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f37756g;
    }

    @Override // javax.mail.Store
    public synchronized Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new DefaultFolder(this);
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return y(str, CharCompanionObject.MAX_VALUE);
    }

    @Override // javax.mail.Store
    public Folder[] getPersonalNamespaces() throws MessagingException {
        Namespaces.Namespace[] namespaceArr;
        Namespaces m4 = m();
        if (m4 != null && (namespaceArr = m4.personal) != null) {
            return w(namespaceArr, null);
        }
        return super.getPersonalNamespaces();
    }

    public String getProxyAuthUser() {
        return this.f37762m;
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized Quota[] getQuota(String str) throws MessagingException {
        Quota[] quotaRoot;
        checkConnected();
        try {
            try {
                try {
                    IMAPProtocol q4 = q();
                    quotaRoot = q4.getQuotaRoot(str);
                    F(q4);
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            } catch (ConnectionException e5) {
                throw new StoreClosedException(this, e5.getMessage());
            }
        } catch (BadCommandException e6) {
            throw new MessagingException("QUOTA not supported", e6);
        }
        return quotaRoot;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session getSession() {
        return this.session;
    }

    @Override // javax.mail.Store
    public Folder[] getSharedNamespaces() throws MessagingException {
        Namespaces.Namespace[] namespaceArr;
        Namespaces m4 = m();
        if (m4 != null && (namespaceArr = m4.shared) != null) {
            return w(namespaceArr, null);
        }
        return super.getSharedNamespaces();
    }

    @Override // javax.mail.Store
    public Folder[] getUserNamespaces(String str) throws MessagingException {
        Namespaces.Namespace[] namespaceArr;
        Namespaces m4 = m();
        if (m4 != null && (namespaceArr = m4.otherUsers) != null) {
            return w(namespaceArr, str);
        }
        return super.getUserNamespaces(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MailLogger h() {
        return this.O.f37785j;
    }

    @Override // com.sun.mail.iap.ResponseHandler
    public void handleResponse(Response response) {
        if (response.isOK() || response.isNO() || response.isBAD() || response.isBYE()) {
            r(response);
        }
        if (response.isBYE()) {
            this.K.fine("IMAPStore connection dead");
            synchronized (this.H) {
                this.F = true;
                if (response.isSynthetic()) {
                    this.G = true;
                }
            }
        }
    }

    public synchronized boolean hasCapability(String str) throws MessagingException {
        boolean hasCapability;
        try {
            IMAPProtocol q4 = q();
            hasCapability = q4.hasCapability(str);
            F(q4);
        } catch (ProtocolException e4) {
            throw new MessagingException(e4.getMessage(), e4);
        }
        return hasCapability;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f37753d;
    }

    public synchronized Map<String, String> id(Map<String, String> map) throws MessagingException {
        Map<String, String> id;
        checkConnected();
        try {
            try {
                try {
                    IMAPProtocol q4 = q();
                    id = q4.id(map);
                    F(q4);
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            } catch (ConnectionException e5) {
                throw new StoreClosedException(this, e5.getMessage());
            }
        } catch (BadCommandException e6) {
            throw new MessagingException("ID not supported", e6);
        }
        return id;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0052, code lost:
        if (r7.f37773y == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
        if (r2.isUnTagged() == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005a, code lost:
        notifyStoreListeners(1000, r2.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00e3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0095 -> B:56:0x0096). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void idle() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.idle():void");
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (!super.isConnected()) {
            return false;
        }
        IMAPProtocol iMAPProtocol = null;
        try {
            iMAPProtocol = q();
            iMAPProtocol.noop();
        } catch (ProtocolException unused) {
        }
        F(iMAPProtocol);
        return super.isConnected();
    }

    public synchronized boolean isSSL() {
        return this.f37768t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMAPProtocol j() throws ProtocolException {
        IMAPProtocol q4 = q();
        q4.removeResponseHandler(this);
        q4.addResponseHandler(this.P);
        return q4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f37757h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:6|7|(10:16|(1:18)|19|20|(2:47|48)|22|(2:28|29)|38|39|(3:41|(1:43)|44))|56|57|58|(1:60)|61|(1:63)|39|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x010c, code lost:
        if (r1 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010e, code lost:
        r1.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0113, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0140, code lost:
        throw new javax.mail.MessagingException("connection failure");
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011b A[Catch: all -> 0x0141, TryCatch #1 {, blocks: (B:7:0x0007, B:9:0x0013, B:11:0x0020, B:13:0x0028, B:16:0x0032, B:18:0x003c, B:19:0x005c, B:22:0x0084, B:27:0x00a3, B:29:0x00a7, B:31:0x00b1, B:33:0x00b9, B:35:0x00d4, B:36:0x00dc, B:38:0x00df, B:52:0x0116, B:54:0x011b, B:56:0x0123, B:57:0x012d, B:58:0x0136, B:24:0x0098, B:25:0x00a0, B:39:0x00e3, B:40:0x00ea, B:42:0x00ee, B:43:0x00f1, B:60:0x0139, B:61:0x0140, B:47:0x010e), top: B:70:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sun.mail.imap.protocol.IMAPProtocol o(com.sun.mail.imap.IMAPFolder r9) throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.o(com.sun.mail.imap.IMAPFolder):com.sun.mail.imap.protocol.IMAPProtocol");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f37755f;
    }

    @Override // javax.mail.Service
    protected synchronized boolean protocolConnect(String str, int i4, String str2, String str3) throws MessagingException {
        String message;
        boolean isEmpty;
        if (str != null && str3 != null && str2 != null) {
            if (i4 != -1) {
                this.f37758i = i4;
            } else {
                Properties properties = this.session.getProperties();
                this.f37758i = PropUtil.getIntProperty(properties, "mail." + this.f37750a + ".port", this.f37758i);
            }
            if (this.f37758i == -1) {
                this.f37758i = this.f37751b;
            }
            Protocol protocol = null;
            try {
                try {
                    try {
                        synchronized (this.O) {
                            isEmpty = this.O.f37776a.isEmpty();
                        }
                        if (isEmpty) {
                            MailLogger mailLogger = this.K;
                            Level level = Level.FINE;
                            if (mailLogger.isLoggable(level)) {
                                MailLogger mailLogger2 = this.K;
                                mailLogger2.fine("trying to connect to host \"" + str + "\", port " + this.f37758i + ", isSSL " + this.f37752c);
                            }
                            IMAPProtocol A = A(str, this.f37758i);
                            if (this.K.isLoggable(level)) {
                                MailLogger mailLogger3 = this.K;
                                mailLogger3.fine("protocolConnect login, host=" + str + ", user=" + traceUser(str2) + ", password=" + tracePassword(str3));
                            }
                            A.addResponseHandler(this.P);
                            v(A, str2, str3);
                            A.removeResponseHandler(this.P);
                            A.addResponseHandler(this);
                            this.f37768t = A.isSSL();
                            this.f37759j = str;
                            this.f37760k = str2;
                            this.f37761l = str3;
                            synchronized (this.O) {
                                this.O.f37776a.addElement(A);
                            }
                        }
                        return true;
                    } catch (ProtocolException e4) {
                        if (0 != 0) {
                            protocol.disconnect();
                        }
                        throw new MessagingException(e4.getMessage(), e4);
                    } catch (IOException e5) {
                        throw new MessagingException(e5.getMessage(), e5);
                    }
                } catch (CommandFailedException e6) {
                    if (0 != 0) {
                        protocol.disconnect();
                    }
                    Response response = e6.getResponse();
                    if (response != null) {
                        message = response.getRest();
                    } else {
                        message = e6.getMessage();
                    }
                    throw new AuthenticationFailedException(message);
                } catch (SocketConnectException e7) {
                    throw new MailConnectException(e7);
                }
            } catch (IMAPReferralException e8) {
                if (0 != 0) {
                    protocol.disconnect();
                }
                throw new ReferralException(e8.getUrl(), e8.getMessage());
            }
        }
        if (this.K.isLoggable(Level.FINE)) {
            MailLogger mailLogger4 = this.K;
            mailLogger4.fine("protocolConnect returning false, host=" + str + ", user=" + traceUser(str2) + ", password=" + tracePassword(str3));
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Response response) {
        if (this.f37772x) {
            notifyStoreListeners(1000, response.toString());
        }
        String rest = response.getRest();
        boolean z3 = false;
        if (rest.startsWith("[")) {
            int indexOf = rest.indexOf(93);
            if (indexOf > 0 && rest.substring(0, indexOf + 1).equalsIgnoreCase("[ALERT]")) {
                z3 = true;
            }
            rest = rest.substring(indexOf + 1).trim();
        }
        if (z3) {
            notifyStoreListeners(1, rest);
        } else if (response.isUnTagged() && rest.length() > 0) {
            notifyStoreListeners(2, rest);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.O.f37780e;
    }

    public synchronized void setPassword(String str) {
        this.f37761l = str;
    }

    public void setProxyAuthUser(String str) {
        this.f37762m = str;
    }

    @Override // javax.mail.QuotaAwareStore
    public synchronized void setQuota(Quota quota) throws MessagingException {
        checkConnected();
        try {
            try {
                try {
                    IMAPProtocol q4 = q();
                    q4.setQuota(quota);
                    F(q4);
                } catch (ProtocolException e4) {
                    throw new MessagingException(e4.getMessage(), e4);
                }
            } catch (ConnectionException e5) {
                throw new StoreClosedException(this, e5.getMessage());
            }
        } catch (BadCommandException e6) {
            throw new MessagingException("QUOTA not supported", e6);
        }
    }

    public synchronized void setUsername(String str) {
        this.f37760k = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return this.f37754e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        boolean z3;
        synchronized (this.O) {
            if (this.O.f37785j.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.O.f37785j;
                mailLogger.fine("connection pool current size: " + this.O.f37776a.size() + "   pool size: " + this.O.f37783h);
            }
            if (this.O.f37776a.size() >= this.O.f37783h) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sun.mail.imap.IMAPFolder x(com.sun.mail.imap.protocol.ListInfo r5) {
        /*
            r4 = this;
            java.lang.reflect.Constructor<?> r0 = r4.N
            if (r0 == 0) goto L20
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L16
            r1 = 0
            r0[r1] = r5     // Catch: java.lang.Exception -> L16
            r1 = 1
            r0[r1] = r4     // Catch: java.lang.Exception -> L16
            java.lang.reflect.Constructor<?> r1 = r4.N     // Catch: java.lang.Exception -> L16
            java.lang.Object r0 = r1.newInstance(r0)     // Catch: java.lang.Exception -> L16
            com.sun.mail.imap.IMAPFolder r0 = (com.sun.mail.imap.IMAPFolder) r0     // Catch: java.lang.Exception -> L16
            goto L21
        L16:
            r0 = move-exception
            com.sun.mail.util.MailLogger r1 = r4.K
            java.util.logging.Level r2 = java.util.logging.Level.FINE
            java.lang.String r3 = "exception creating IMAPFolder class LI"
            r1.log(r2, r3, r0)
        L20:
            r0 = 0
        L21:
            if (r0 != 0) goto L28
            com.sun.mail.imap.IMAPFolder r0 = new com.sun.mail.imap.IMAPFolder
            r0.<init>(r5, r4)
        L28:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.x(com.sun.mail.imap.protocol.ListInfo):com.sun.mail.imap.IMAPFolder");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPFolder y(String str, char c4) {
        return z(str, c4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.sun.mail.imap.IMAPFolder z(java.lang.String r5, char r6, java.lang.Boolean r7) {
        /*
            r4 = this;
            java.lang.reflect.Constructor<?> r0 = r4.M
            if (r0 == 0) goto L2a
            r0 = 4
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L20
            r1 = 0
            r0[r1] = r5     // Catch: java.lang.Exception -> L20
            java.lang.Character r1 = java.lang.Character.valueOf(r6)     // Catch: java.lang.Exception -> L20
            r2 = 1
            r0[r2] = r1     // Catch: java.lang.Exception -> L20
            r1 = 2
            r0[r1] = r4     // Catch: java.lang.Exception -> L20
            r1 = 3
            r0[r1] = r7     // Catch: java.lang.Exception -> L20
            java.lang.reflect.Constructor<?> r1 = r4.M     // Catch: java.lang.Exception -> L20
            java.lang.Object r0 = r1.newInstance(r0)     // Catch: java.lang.Exception -> L20
            com.sun.mail.imap.IMAPFolder r0 = (com.sun.mail.imap.IMAPFolder) r0     // Catch: java.lang.Exception -> L20
            goto L2b
        L20:
            r0 = move-exception
            com.sun.mail.util.MailLogger r1 = r4.K
            java.util.logging.Level r2 = java.util.logging.Level.FINE
            java.lang.String r3 = "exception creating IMAPFolder class"
            r1.log(r2, r3, r0)
        L2a:
            r0 = 0
        L2b:
            if (r0 != 0) goto L32
            com.sun.mail.imap.IMAPFolder r0 = new com.sun.mail.imap.IMAPFolder
            r0.<init>(r5, r6, r4, r7)
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPStore.z(java.lang.String, char, java.lang.Boolean):com.sun.mail.imap.IMAPFolder");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPStore(Session session, URLName uRLName, String str, boolean z3) {
        super(session, uRLName);
        Class<?> cls;
        this.f37758i = -1;
        this.f37766r = false;
        this.f37767s = false;
        this.f37768t = false;
        this.f37769u = false;
        this.f37771w = false;
        this.f37772x = false;
        this.f37773y = false;
        this.A = false;
        this.B = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = new Object();
        this.M = null;
        this.N = null;
        this.P = new a();
        Properties properties = session.getProperties();
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.f37750a = str;
        if (!z3) {
            z3 = PropUtil.getBooleanProperty(properties, "mail." + str + ".ssl.enable", false);
        }
        if (z3) {
            this.f37751b = 993;
        } else {
            this.f37751b = 143;
        }
        this.f37752c = z3;
        this.debug = session.getDebug();
        this.I = PropUtil.getBooleanProperty(properties, "mail.debug.auth.username", true);
        this.J = PropUtil.getBooleanProperty(properties, "mail.debug.auth.password", false);
        Class<?> cls2 = getClass();
        this.K = new MailLogger(cls2, "DEBUG " + str.toUpperCase(Locale.ENGLISH), session.getDebug(), session.getDebugOut());
        if (!PropUtil.getBooleanProperty(properties, "mail." + str + ".partialfetch", true)) {
            this.f37753d = -1;
            this.K.config("mail.imap.partialfetch: false");
        } else {
            int intProperty = PropUtil.getIntProperty(properties, "mail." + str + ".fetchsize", 16384);
            this.f37753d = intProperty;
            if (this.K.isLoggable(Level.CONFIG)) {
                MailLogger mailLogger = this.K;
                mailLogger.config("mail.imap.fetchsize: " + intProperty);
            }
        }
        this.f37754e = PropUtil.getBooleanProperty(properties, "mail." + str + ".ignorebodystructuresize", false);
        MailLogger mailLogger2 = this.K;
        Level level = Level.CONFIG;
        if (mailLogger2.isLoggable(level)) {
            MailLogger mailLogger3 = this.K;
            mailLogger3.config("mail.imap.ignorebodystructuresize: " + this.f37754e);
        }
        int intProperty2 = PropUtil.getIntProperty(properties, "mail." + str + ".statuscachetimeout", 1000);
        this.f37755f = intProperty2;
        if (this.K.isLoggable(level)) {
            MailLogger mailLogger4 = this.K;
            mailLogger4.config("mail.imap.statuscachetimeout: " + intProperty2);
        }
        int intProperty3 = PropUtil.getIntProperty(properties, "mail." + str + ".appendbuffersize", -1);
        this.f37756g = intProperty3;
        if (this.K.isLoggable(level)) {
            MailLogger mailLogger5 = this.K;
            mailLogger5.config("mail.imap.appendbuffersize: " + intProperty3);
        }
        int intProperty4 = PropUtil.getIntProperty(properties, "mail." + str + ".minidletime", 10);
        this.f37757h = intProperty4;
        if (this.K.isLoggable(level)) {
            MailLogger mailLogger6 = this.K;
            mailLogger6.config("mail.imap.minidletime: " + intProperty4);
        }
        String property = session.getProperty("mail." + str + ".proxyauth.user");
        if (property != null) {
            this.f37762m = property;
            if (this.K.isLoggable(level)) {
                MailLogger mailLogger7 = this.K;
                mailLogger7.config("mail.imap.proxyauth.user: " + this.f37762m);
            }
        }
        boolean booleanProperty = PropUtil.getBooleanProperty(properties, "mail." + str + ".starttls.enable", false);
        this.f37766r = booleanProperty;
        if (booleanProperty) {
            this.K.config("enable STARTTLS");
        }
        boolean booleanProperty2 = PropUtil.getBooleanProperty(properties, "mail." + str + ".starttls.required", false);
        this.f37767s = booleanProperty2;
        if (booleanProperty2) {
            this.K.config("require STARTTLS");
        }
        boolean booleanProperty3 = PropUtil.getBooleanProperty(properties, "mail." + str + ".sasl.enable", false);
        this.f37769u = booleanProperty3;
        if (booleanProperty3) {
            this.K.config("enable SASL");
        }
        if (this.f37769u) {
            String property2 = session.getProperty("mail." + str + ".sasl.mechanisms");
            if (property2 != null && property2.length() > 0) {
                if (this.K.isLoggable(level)) {
                    MailLogger mailLogger8 = this.K;
                    mailLogger8.config("SASL mechanisms allowed: " + property2);
                }
                ArrayList arrayList = new ArrayList(5);
                StringTokenizer stringTokenizer = new StringTokenizer(property2, " ,");
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.length() > 0) {
                        arrayList.add(nextToken);
                    }
                }
                String[] strArr = new String[arrayList.size()];
                this.f37770v = strArr;
                arrayList.toArray(strArr);
            }
        }
        String property3 = session.getProperty("mail." + str + ".sasl.authorizationid");
        if (property3 != null) {
            this.f37763n = property3;
            this.K.log(Level.CONFIG, "mail.imap.sasl.authorizationid: {0}", property3);
        }
        String property4 = session.getProperty("mail." + str + ".sasl.realm");
        if (property4 != null) {
            this.f37764o = property4;
            this.K.log(Level.CONFIG, "mail.imap.sasl.realm: {0}", property4);
        }
        boolean booleanProperty4 = PropUtil.getBooleanProperty(properties, "mail." + str + ".forcepasswordrefresh", false);
        this.f37771w = booleanProperty4;
        if (booleanProperty4) {
            this.K.config("enable forcePasswordRefresh");
        }
        boolean booleanProperty5 = PropUtil.getBooleanProperty(properties, "mail." + str + ".enableresponseevents", false);
        this.f37772x = booleanProperty5;
        if (booleanProperty5) {
            this.K.config("enable IMAP response events");
        }
        boolean booleanProperty6 = PropUtil.getBooleanProperty(properties, "mail." + str + ".enableimapevents", false);
        this.f37773y = booleanProperty6;
        if (booleanProperty6) {
            this.K.config("enable IMAP IDLE events");
        }
        this.L = PropUtil.getBooleanProperty(properties, "mail." + str + ".messagecache.debug", false);
        String property5 = session.getProperty("mail." + str + ".yahoo.guid");
        this.f37774z = property5;
        if (property5 != null) {
            this.K.log(Level.CONFIG, "mail.imap.yahoo.guid: {0}", property5);
        }
        boolean booleanProperty7 = PropUtil.getBooleanProperty(properties, "mail." + str + ".throwsearchexception", false);
        this.A = booleanProperty7;
        if (booleanProperty7) {
            this.K.config("throw SearchException");
        }
        boolean booleanProperty8 = PropUtil.getBooleanProperty(properties, "mail." + str + ".peek", false);
        this.B = booleanProperty8;
        if (booleanProperty8) {
            this.K.config("peek");
        }
        boolean booleanProperty9 = PropUtil.getBooleanProperty(properties, "mail." + str + ".closefoldersonstorefailure", true);
        this.C = booleanProperty9;
        if (booleanProperty9) {
            this.K.config("closeFoldersOnStoreFailure");
        }
        boolean booleanProperty10 = PropUtil.getBooleanProperty(properties, "mail." + str + ".compress.enable", false);
        this.D = booleanProperty10;
        if (booleanProperty10) {
            this.K.config("enable COMPRESS");
        }
        boolean booleanProperty11 = PropUtil.getBooleanProperty(properties, "mail." + str + ".finalizecleanclose", false);
        this.E = booleanProperty11;
        if (booleanProperty11) {
            this.K.config("close connection cleanly in finalize");
        }
        String property6 = session.getProperty("mail." + str + ".folder.class");
        if (property6 != null) {
            this.K.log(Level.CONFIG, "IMAP: folder class: {0}", property6);
            try {
                try {
                    cls = Class.forName(property6, false, getClass().getClassLoader());
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName(property6);
                }
                this.M = cls.getConstructor(String.class, Character.TYPE, IMAPStore.class, Boolean.class);
                this.N = cls.getConstructor(ListInfo.class, IMAPStore.class);
            } catch (Exception e4) {
                this.K.log(Level.CONFIG, "IMAP: failed to load folder class", (Throwable) e4);
            }
        }
        this.O = new b(str, this.K, session);
    }

    @Override // javax.mail.Store
    public synchronized Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return y(uRLName.getFile(), CharCompanionObject.MAX_VALUE);
    }

    protected void B(IMAPProtocol iMAPProtocol) throws ProtocolException {
    }
}
