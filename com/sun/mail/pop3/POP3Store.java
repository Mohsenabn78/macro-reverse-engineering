package com.sun.mail.pop3;

import com.sun.mail.util.MailConnectException;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SocketConnectException;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.mail.AuthenticationFailedException;
import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.URLName;

/* loaded from: classes6.dex */
public class POP3Store extends Store {

    /* renamed from: a  reason: collision with root package name */
    private String f37890a;

    /* renamed from: b  reason: collision with root package name */
    private int f37891b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37892c;

    /* renamed from: d  reason: collision with root package name */
    private b f37893d;

    /* renamed from: e  reason: collision with root package name */
    private POP3Folder f37894e;

    /* renamed from: f  reason: collision with root package name */
    private String f37895f;

    /* renamed from: g  reason: collision with root package name */
    private int f37896g;

    /* renamed from: h  reason: collision with root package name */
    private String f37897h;

    /* renamed from: i  reason: collision with root package name */
    private String f37898i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f37899j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f37900k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f37901l;

    /* renamed from: m  reason: collision with root package name */
    private Map<String, String> f37902m;

    /* renamed from: n  reason: collision with root package name */
    private MailLogger f37903n;

    /* renamed from: o  reason: collision with root package name */
    volatile Constructor<?> f37904o;

    /* renamed from: p  reason: collision with root package name */
    volatile boolean f37905p;

    /* renamed from: r  reason: collision with root package name */
    volatile boolean f37906r;

    /* renamed from: s  reason: collision with root package name */
    volatile boolean f37907s;

    /* renamed from: t  reason: collision with root package name */
    volatile boolean f37908t;

    /* renamed from: u  reason: collision with root package name */
    volatile boolean f37909u;

    /* renamed from: v  reason: collision with root package name */
    volatile boolean f37910v;

    /* renamed from: w  reason: collision with root package name */
    volatile File f37911w;

    /* renamed from: x  reason: collision with root package name */
    volatile boolean f37912x;

    /* renamed from: y  reason: collision with root package name */
    volatile boolean f37913y;

    public POP3Store(Session session, URLName uRLName) {
        this(session, uRLName, "pop3", false);
    }

    private boolean b(b bVar, String str, String str2) throws MessagingException {
        boolean z3;
        String str3;
        Locale locale;
        String property = this.session.getProperty("mail." + this.f37890a + ".auth.mechanisms");
        if (property == null) {
            property = bVar.u();
            z3 = true;
        } else {
            z3 = false;
        }
        String property2 = this.session.getProperty("mail." + this.f37890a + ".sasl.authorizationid");
        if (property2 == null) {
            str3 = str;
        } else {
            str3 = property2;
        }
        if (this.f37903n.isLoggable(Level.FINE)) {
            this.f37903n.fine("Attempt to authenticate using mechanisms: " + property);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(property);
        while (stringTokenizer.hasMoreTokens()) {
            String upperCase = stringTokenizer.nextToken().toUpperCase(Locale.ENGLISH);
            if (!bVar.Z(upperCase)) {
                this.f37903n.log(Level.FINE, "no authenticator for mechanism {0}", upperCase);
            } else if (!bVar.Y(upperCase)) {
                this.f37903n.log(Level.FINE, "mechanism {0} not supported by server", upperCase);
            } else {
                if (z3) {
                    String str4 = "mail." + this.f37890a + ".auth." + upperCase.toLowerCase(locale) + ".disable";
                    if (PropUtil.getBooleanProperty(this.session.getProperties(), str4, !bVar.z(upperCase))) {
                        if (this.f37903n.isLoggable(Level.FINE)) {
                            this.f37903n.fine("mechanism " + upperCase + " disabled by property: " + str4);
                        }
                    }
                }
                this.f37903n.log(Level.FINE, "Using mechanism {0}", upperCase);
                String k4 = bVar.k(upperCase, this.f37895f, str3, str, str2);
                if (k4 == null) {
                    return true;
                }
                throw new AuthenticationFailedException(k4);
            }
        }
        throw new AuthenticationFailedException("No authentication mechanisms supported by both server and client");
    }

    private static IOException c(b bVar, IOException iOException) {
        try {
            bVar.L();
        } catch (Throwable th) {
            if (h(th)) {
                iOException.addSuppressed(th);
            } else {
                th.addSuppressed(iOException);
                if (!(th instanceof Error)) {
                    if (th instanceof RuntimeException) {
                        throw th;
                    }
                    throw new RuntimeException("unexpected exception", th);
                }
                throw ((Error) th);
            }
        }
        return iOException;
    }

    private void checkConnected() throws MessagingException {
        if (super.isConnected()) {
            return;
        }
        throw new MessagingException("Not connected");
    }

    private final synchronized boolean f(String str) {
        boolean booleanProperty;
        String str2 = "mail." + this.f37890a + "." + str;
        booleanProperty = PropUtil.getBooleanProperty(this.session.getProperties(), str2, false);
        if (this.f37903n.isLoggable(Level.CONFIG)) {
            this.f37903n.config(str2 + ": " + booleanProperty);
        }
        return booleanProperty;
    }

    private static boolean h(Throwable th) {
        if (!(th instanceof Exception) && !(th instanceof LinkageError)) {
            return false;
        }
        return true;
    }

    public Map<String, String> capabilities() throws MessagingException {
        Map<String, String> map;
        synchronized (this) {
            map = this.f37902m;
        }
        if (map != null) {
            return Collections.unmodifiableMap(map);
        }
        return Collections.emptyMap();
    }

    @Override // javax.mail.Service, java.lang.AutoCloseable
    public synchronized void close() throws MessagingException {
        d(false);
    }

    synchronized void d(boolean z3) throws MessagingException {
        try {
            b bVar = this.f37893d;
            if (bVar != null) {
                if (z3) {
                    bVar.q();
                } else {
                    bVar.L();
                }
            }
            this.f37893d = null;
        } catch (IOException unused) {
            this.f37893d = null;
        }
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void e(POP3Folder pOP3Folder) {
        if (this.f37894e == pOP3Folder) {
            this.f37893d = null;
            this.f37894e = null;
        }
    }

    @Override // javax.mail.Service
    protected void finalize() throws Throwable {
        boolean z3;
        try {
            if (this.f37893d != null) {
                if (!this.f37913y) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                d(z3);
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized b g(POP3Folder pOP3Folder) throws IOException {
        Map<String, String> map;
        b bVar = this.f37893d;
        if (bVar != null && this.f37894e == null) {
            this.f37894e = pOP3Folder;
            return bVar;
        }
        String str = this.f37895f;
        int i4 = this.f37896g;
        MailLogger mailLogger = this.f37903n;
        Properties properties = this.session.getProperties();
        b bVar2 = new b(str, i4, mailLogger, properties, "mail." + this.f37890a, this.f37892c);
        if (this.f37899j || this.f37900k) {
            if (bVar2.x("STLS")) {
                if (bVar2.X()) {
                    bVar2.S(bVar2.o());
                } else if (this.f37900k) {
                    this.f37903n.fine("STLS required but failed");
                    throw c(bVar2, new EOFException("STLS required but failed"));
                }
            } else if (this.f37900k) {
                this.f37903n.fine("STLS required but not supported");
                throw c(bVar2, new EOFException("STLS required but not supported"));
            }
        }
        this.f37902m = bVar2.t();
        this.f37901l = bVar2.B();
        boolean z3 = true;
        if (!this.f37906r && (map = this.f37902m) != null && !map.containsKey("TOP")) {
            this.f37906r = true;
            this.f37903n.fine("server doesn't support TOP, disabling it");
        }
        Map<String, String> map2 = this.f37902m;
        if (map2 != null && !map2.containsKey("UIDL")) {
            z3 = false;
        }
        this.f37908t = z3;
        try {
            if (b(bVar2, this.f37897h, this.f37898i)) {
                if (this.f37893d == null && pOP3Folder != null) {
                    this.f37893d = bVar2;
                    this.f37894e = pOP3Folder;
                }
                if (this.f37894e == null) {
                    this.f37894e = pOP3Folder;
                }
                return bVar2;
            }
            throw c(bVar2, new EOFException("login failed"));
        } catch (EOFException e4) {
            throw c(bVar2, e4);
        } catch (Exception e5) {
            throw c(bVar2, new EOFException(e5.getMessage()));
        }
    }

    @Override // javax.mail.Store
    public Folder getDefaultFolder() throws MessagingException {
        checkConnected();
        return new DefaultFolder(this);
    }

    @Override // javax.mail.Store
    public Folder getFolder(String str) throws MessagingException {
        checkConnected();
        return new POP3Folder(this, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Session getSession() {
        return this.session;
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (!super.isConnected()) {
            return false;
        }
        try {
            try {
                b bVar = this.f37893d;
                if (bVar == null) {
                    this.f37893d = g(null);
                } else if (!bVar.K()) {
                    throw new IOException("NOOP failed");
                }
                return true;
            } catch (MessagingException unused) {
                return false;
            }
        } catch (IOException unused2) {
            super.close();
            return false;
        }
    }

    public synchronized boolean isSSL() {
        return this.f37901l;
    }

    @Override // javax.mail.Service
    protected synchronized boolean protocolConnect(String str, int i4, String str2, String str3) throws MessagingException {
        if (str != null && str3 != null && str2 != null) {
            if (i4 == -1) {
                try {
                    Properties properties = this.session.getProperties();
                    i4 = PropUtil.getIntProperty(properties, "mail." + this.f37890a + ".port", -1);
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (i4 == -1) {
                i4 = this.f37891b;
            }
            this.f37895f = str;
            this.f37896g = i4;
            this.f37897h = str2;
            this.f37898i = str3;
            try {
                try {
                    this.f37893d = g(null);
                    return true;
                } catch (SocketConnectException e4) {
                    throw new MailConnectException(e4);
                } catch (IOException e5) {
                    throw new MessagingException("Connect failed", e5);
                }
            } catch (EOFException e6) {
                throw new AuthenticationFailedException(e6.getMessage());
            }
        }
        return false;
    }

    public POP3Store(Session session, URLName uRLName, String str, boolean z3) {
        super(session, uRLName);
        Class<?> cls;
        this.f37890a = "pop3";
        this.f37891b = 110;
        this.f37892c = false;
        this.f37893d = null;
        this.f37894e = null;
        this.f37895f = null;
        this.f37896g = -1;
        this.f37897h = null;
        this.f37898i = null;
        this.f37899j = false;
        this.f37900k = false;
        this.f37901l = false;
        this.f37904o = null;
        this.f37905p = false;
        this.f37906r = false;
        this.f37907s = false;
        this.f37908t = true;
        this.f37909u = false;
        this.f37910v = false;
        this.f37911w = null;
        this.f37912x = false;
        this.f37913y = false;
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.f37890a = str;
        this.f37903n = new MailLogger(getClass(), "DEBUG POP3", session.getDebug(), session.getDebugOut());
        if (!z3) {
            Properties properties = session.getProperties();
            z3 = PropUtil.getBooleanProperty(properties, "mail." + str + ".ssl.enable", false);
        }
        if (z3) {
            this.f37891b = 995;
        } else {
            this.f37891b = 110;
        }
        this.f37892c = z3;
        this.f37905p = f("rsetbeforequit");
        this.f37906r = f("disabletop");
        this.f37907s = f("forgettopheaders");
        this.f37909u = f("cachewriteto");
        this.f37910v = f("filecache.enable");
        String property = session.getProperty("mail." + str + ".filecache.dir");
        if (property != null && this.f37903n.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger = this.f37903n;
            mailLogger.config("mail." + str + ".filecache.dir: " + property);
        }
        if (property != null) {
            this.f37911w = new File(property);
        }
        this.f37912x = f("keepmessagecontent");
        this.f37899j = f("starttls.enable");
        this.f37900k = f("starttls.required");
        this.f37913y = f("finalizecleanclose");
        String property2 = session.getProperty("mail." + str + ".message.class");
        if (property2 != null) {
            this.f37903n.log(Level.CONFIG, "message class: {0}", property2);
            try {
                try {
                    cls = Class.forName(property2, false, getClass().getClassLoader());
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName(property2);
                }
                this.f37904o = cls.getConstructor(Folder.class, Integer.TYPE);
            } catch (Exception e4) {
                this.f37903n.log(Level.CONFIG, "failed to load message class", (Throwable) e4);
            }
        }
    }

    @Override // javax.mail.Store
    public Folder getFolder(URLName uRLName) throws MessagingException {
        checkConnected();
        return new POP3Folder(this, uRLName.getFile());
    }
}
