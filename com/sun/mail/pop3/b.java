package com.sun.mail.pop3;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.sun.mail.auth.Ntlm;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.net.ssl.SSLSocket;
import net.bytebuddy.asm.Advice;
import org.apache.http.client.params.AuthPolicy;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Protocol.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: r  reason: collision with root package name */
    private static char[] f37918r = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    /* renamed from: a  reason: collision with root package name */
    private Socket f37919a;

    /* renamed from: b  reason: collision with root package name */
    private String f37920b;

    /* renamed from: c  reason: collision with root package name */
    private Properties f37921c;

    /* renamed from: d  reason: collision with root package name */
    private String f37922d;

    /* renamed from: e  reason: collision with root package name */
    private BufferedReader f37923e;

    /* renamed from: f  reason: collision with root package name */
    private PrintWriter f37924f;

    /* renamed from: g  reason: collision with root package name */
    private TraceInputStream f37925g;

    /* renamed from: h  reason: collision with root package name */
    private TraceOutputStream f37926h;

    /* renamed from: i  reason: collision with root package name */
    private MailLogger f37927i;

    /* renamed from: j  reason: collision with root package name */
    private MailLogger f37928j;

    /* renamed from: k  reason: collision with root package name */
    private String f37929k;

    /* renamed from: m  reason: collision with root package name */
    private boolean f37931m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f37932n;

    /* renamed from: p  reason: collision with root package name */
    private String f37934p;

    /* renamed from: q  reason: collision with root package name */
    private String f37935q;

    /* renamed from: l  reason: collision with root package name */
    private Map<String, String> f37930l = null;

    /* renamed from: o  reason: collision with root package name */
    private Map<String, a> f37933o = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Protocol.java */
    /* loaded from: classes6.dex */
    public abstract class a {

        /* renamed from: a  reason: collision with root package name */
        protected com.sun.mail.pop3.c f37936a;

        /* renamed from: b  reason: collision with root package name */
        private final String f37937b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f37938c;

        a(b bVar, String str) {
            this(str, true);
        }

        boolean a(String str, String str2, String str3, String str4) throws IOException {
            String str5 = "succeeded";
            String str6 = "authentication failed";
            try {
                try {
                    String d4 = d(str, str2, str3, str4);
                    if (b.this.f37932n && b.this.C()) {
                        MailLogger mailLogger = b.this.f37927i;
                        mailLogger.fine("AUTH " + this.f37937b + " command trace suppressed");
                        b.this.a0();
                    }
                    f("AUTH " + this.f37937b, d4);
                    if (this.f37936a.f37946b) {
                        b(str, str2, str3, str4);
                    }
                    if (b.this.f37932n && b.this.C()) {
                        MailLogger mailLogger2 = b.this.f37927i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("AUTH ");
                        sb.append(this.f37937b);
                        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        if (!this.f37936a.f37945a) {
                            str5 = "failed";
                        }
                        sb.append(str5);
                        mailLogger2.fine(sb.toString());
                    }
                    b.this.O();
                    if (!this.f37936a.f37945a) {
                        b.this.q();
                        String str7 = this.f37936a.f37947c;
                        if (str7 != null) {
                            str6 = str7;
                        }
                        throw new EOFException(str6);
                    }
                    return true;
                } catch (IOException e4) {
                    MailLogger mailLogger3 = b.this.f37927i;
                    Level level = Level.FINE;
                    mailLogger3.log(level, "AUTH " + this.f37937b + " failed", (Throwable) e4);
                    if (b.this.f37932n && b.this.C()) {
                        MailLogger mailLogger4 = b.this.f37927i;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AUTH ");
                        sb2.append(this.f37937b);
                        sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        if (!this.f37936a.f37945a) {
                            str5 = "failed";
                        }
                        sb2.append(str5);
                        mailLogger4.fine(sb2.toString());
                    }
                    b.this.O();
                    if (!this.f37936a.f37945a) {
                        b.this.q();
                        String str8 = this.f37936a.f37947c;
                        if (str8 != null) {
                            str6 = str8;
                        }
                        throw new EOFException(str6);
                    }
                    return true;
                } catch (Throwable th) {
                    MailLogger mailLogger5 = b.this.f37927i;
                    Level level2 = Level.FINE;
                    mailLogger5.log(level2, "AUTH " + this.f37937b + " failed", (Throwable) th);
                    if (b.this.f37932n && b.this.C()) {
                        MailLogger mailLogger6 = b.this.f37927i;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("AUTH ");
                        sb3.append(this.f37937b);
                        sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        if (!this.f37936a.f37945a) {
                            str5 = "failed";
                        }
                        sb3.append(str5);
                        mailLogger6.fine(sb3.toString());
                    }
                    b.this.O();
                    if (!this.f37936a.f37945a) {
                        b.this.q();
                        if (!(th instanceof Error)) {
                            if (th instanceof Exception) {
                                String str9 = this.f37936a.f37947c;
                                if (str9 != null) {
                                    str6 = str9;
                                }
                                EOFException eOFException = new EOFException(str6);
                                eOFException.initCause(th);
                                throw eOFException;
                            }
                            String str10 = this.f37936a.f37947c;
                            if (str10 != null) {
                                str6 = str10;
                            }
                            throw new EOFException(str6);
                        }
                        throw th;
                    }
                    return true;
                }
            } catch (Throwable th2) {
                if (b.this.f37932n && b.this.C()) {
                    MailLogger mailLogger7 = b.this.f37927i;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("AUTH ");
                    sb4.append(this.f37937b);
                    sb4.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    if (!this.f37936a.f37945a) {
                        str5 = "failed";
                    }
                    sb4.append(str5);
                    mailLogger7.fine(sb4.toString());
                }
                b.this.O();
                if (!this.f37936a.f37945a) {
                    b.this.q();
                    String str11 = this.f37936a.f37947c;
                    if (str11 != null) {
                        str6 = str11;
                    }
                    throw new EOFException(str6);
                }
                throw th2;
            }
        }

        abstract void b(String str, String str2, String str3, String str4) throws IOException;

        boolean c() {
            return this.f37938c;
        }

        String d(String str, String str2, String str3, String str4) throws IOException {
            return null;
        }

        String e() {
            return this.f37937b;
        }

        protected void f(String str, String str2) throws IOException {
            if (b.this.f37927i.isLoggable(Level.FINE)) {
                MailLogger mailLogger = b.this.f37927i;
                mailLogger.fine(str + " using one line authentication format");
            }
            if (str2 != null) {
                b bVar = b.this;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (str2.length() == 0) {
                    str2 = "=";
                }
                sb.append(str2);
                this.f37936a = bVar.T(sb.toString());
                return;
            }
            this.f37936a = b.this.T(str);
        }

        a(String str, boolean z3) {
            this.f37937b = str.toUpperCase(Locale.ENGLISH);
            this.f37938c = z3;
        }
    }

    /* compiled from: Protocol.java */
    /* renamed from: com.sun.mail.pop3.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C0217b extends a {
        C0217b() {
            super(b.this, "LOGIN");
        }

        @Override // com.sun.mail.pop3.b.a
        boolean a(String str, String str2, String str3, String str4) throws IOException {
            String G = b.this.G(str3, str4);
            if (G == null) {
                return true;
            }
            throw new EOFException(G);
        }

        @Override // com.sun.mail.pop3.b.a
        void b(String str, String str2, String str3, String str4) throws IOException {
            throw new EOFException("LOGIN asked for more");
        }
    }

    /* compiled from: Protocol.java */
    /* loaded from: classes6.dex */
    private class c extends a {

        /* renamed from: e  reason: collision with root package name */
        private Ntlm f37941e;

        c() {
            super(b.this, AuthPolicy.NTLM);
        }

        @Override // com.sun.mail.pop3.b.a
        void b(String str, String str2, String str3, String str4) throws IOException {
            this.f37936a = b.this.T(this.f37941e.generateType3Msg(this.f37936a.f37947c.substring(4).trim()));
        }

        @Override // com.sun.mail.pop3.b.a
        String d(String str, String str2, String str3, String str4) throws IOException {
            Properties properties = b.this.f37921c;
            this.f37941e = new Ntlm(properties.getProperty(b.this.f37922d + ".auth.ntlm.domain"), b.this.w(), str3, str4, b.this.f37927i);
            Properties properties2 = b.this.f37921c;
            int intProperty = PropUtil.getIntProperty(properties2, b.this.f37922d + ".auth.ntlm.flags", 0);
            Properties properties3 = b.this.f37921c;
            return this.f37941e.generateType1Msg(intProperty, PropUtil.getBooleanProperty(properties3, b.this.f37922d + ".auth.ntlm.v2", true));
        }
    }

    /* compiled from: Protocol.java */
    /* loaded from: classes6.dex */
    private class d extends a {
        d() {
            super("XOAUTH2", false);
        }

        @Override // com.sun.mail.pop3.b.a
        void b(String str, String str2, String str3, String str4) throws IOException {
            String str5;
            String str6 = this.f37936a.f37947c;
            if (str6 != null) {
                str5 = new String(BASE64DecoderStream.decode(str6.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
            } else {
                str5 = "";
            }
            throw new EOFException("OAUTH2 authentication failed: " + str5);
        }

        @Override // com.sun.mail.pop3.b.a
        String d(String str, String str2, String str3, String str4) throws IOException {
            return ASCIIUtility.toString(BASE64EncoderStream.encode(("user=" + str3 + "\u0001auth=Bearer " + str4 + "\u0001\u0001").getBytes(StandardCharsets.UTF_8)));
        }

        @Override // com.sun.mail.pop3.b.a
        protected void f(String str, String str2) throws IOException {
            b bVar = b.this;
            Properties properties = bVar.f37921c;
            if (Boolean.valueOf(bVar.s(properties, b.this.f37922d + ".auth.xoauth2.two.line.authentication.format")).booleanValue()) {
                if (b.this.f37927i.isLoggable(Level.FINE)) {
                    MailLogger mailLogger = b.this.f37927i;
                    mailLogger.fine(str + " using two line authentication format");
                }
                b bVar2 = b.this;
                if (str2.length() == 0) {
                    str2 = "=";
                }
                this.f37936a = bVar2.d0(str, str2);
                return;
            }
            super.f(str, str2);
        }
    }

    /* compiled from: Protocol.java */
    /* loaded from: classes6.dex */
    private class e extends a {
        e() {
            super(b.this, "PLAIN");
        }

        @Override // com.sun.mail.pop3.b.a
        void b(String str, String str2, String str3, String str4) throws IOException {
            throw new EOFException("PLAIN asked for more");
        }

        @Override // com.sun.mail.pop3.b.a
        String d(String str, String str2, String str3, String str4) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
            if (str2 != null) {
                bASE64EncoderStream.write(str2.getBytes(StandardCharsets.UTF_8));
            }
            bASE64EncoderStream.write(0);
            bASE64EncoderStream.write(str3.getBytes(StandardCharsets.UTF_8));
            bASE64EncoderStream.write(0);
            bASE64EncoderStream.write(str4.getBytes(StandardCharsets.UTF_8));
            bASE64EncoderStream.flush();
            return ASCIIUtility.toString(byteArrayOutputStream.toByteArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011d A[LOOP:0: B:32:0x011b->B:33:0x011d, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(java.lang.String r10, int r11, com.sun.mail.util.MailLogger r12, java.util.Properties r13, java.lang.String r14, boolean r15) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.b.<init>(java.lang.String, int, com.sun.mail.util.MailLogger, java.util.Properties, java.lang.String, boolean):void");
    }

    private static boolean A(Throwable th) {
        if (!(th instanceof Exception) && !(th instanceof LinkageError)) {
            return false;
        }
        return true;
    }

    private void D(String str) throws IOException {
        if (this.f37919a != null) {
            if (str != null) {
                this.f37924f.print(str + "\r\n");
                this.f37924f.flush();
                return;
            }
            return;
        }
        throw new IOException("Folder is closed");
    }

    private com.sun.mail.pop3.c H(String str, int i4) throws IOException {
        J(str);
        D(str);
        com.sun.mail.pop3.c N = N();
        if (!N.f37945a) {
            I();
            return N;
        }
        N.f37948d = M(i4);
        I();
        return N;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0021, code lost:
        r2 = r3.f37923e.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.io.InputStream M(int r4) throws java.io.IOException {
        /*
            r3 = this;
            com.sun.mail.util.SharedByteArrayOutputStream r0 = new com.sun.mail.util.SharedByteArrayOutputStream
            r0.<init>(r4)
            r4 = 10
            r1 = 10
        L9:
            java.io.BufferedReader r2 = r3.f37923e     // Catch: java.io.InterruptedIOException -> L3c
            int r2 = r2.read()     // Catch: java.io.InterruptedIOException -> L3c
            if (r2 < 0) goto L2d
            if (r1 != r4) goto L28
            r1 = 46
            if (r2 != r1) goto L28
            java.io.BufferedReader r1 = r3.f37923e     // Catch: java.io.InterruptedIOException -> L3c
            int r1 = r1.read()     // Catch: java.io.InterruptedIOException -> L3c
            r2 = 13
            if (r1 != r2) goto L29
            java.io.BufferedReader r4 = r3.f37923e     // Catch: java.io.InterruptedIOException -> L3c
            int r2 = r4.read()     // Catch: java.io.InterruptedIOException -> L3c
            goto L2d
        L28:
            r1 = r2
        L29:
            r0.write(r1)     // Catch: java.io.InterruptedIOException -> L3c
            goto L9
        L2d:
            if (r2 < 0) goto L34
            java.io.InputStream r4 = r0.toStream()
            return r4
        L34:
            java.io.EOFException r4 = new java.io.EOFException
            java.lang.String r0 = "EOF on socket"
            r4.<init>(r0)
            throw r4
        L3c:
            r4 = move-exception
            java.net.Socket r0 = r3.f37919a     // Catch: java.io.IOException -> L42
            r0.close()     // Catch: java.io.IOException -> L42
        L42:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.b.M(int):java.io.InputStream");
    }

    private com.sun.mail.pop3.c N() throws IOException {
        try {
            String readLine = this.f37923e.readLine();
            if (readLine != null) {
                com.sun.mail.pop3.c cVar = new com.sun.mail.pop3.c();
                if (readLine.startsWith("+OK")) {
                    cVar.f37945a = true;
                } else if (readLine.startsWith("+ ")) {
                    cVar.f37945a = true;
                    cVar.f37946b = true;
                } else if (readLine.startsWith("-ERR")) {
                    cVar.f37945a = false;
                } else {
                    throw new IOException("Unexpected response: " + readLine);
                }
                int indexOf = readLine.indexOf(32);
                if (indexOf >= 0) {
                    cVar.f37947c = readLine.substring(indexOf + 1);
                }
                return cVar;
            }
            this.f37928j.finest("<EOF>");
            throw new EOFException("EOF on socket");
        } catch (InterruptedIOException e4) {
            try {
                this.f37919a.close();
            } catch (IOException unused) {
            }
            throw new EOFException(e4.getMessage());
        } catch (SocketException e5) {
            try {
                this.f37919a.close();
            } catch (IOException unused2) {
            }
            throw new EOFException(e5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (this.f37928j.isLoggable(Level.FINEST)) {
            this.f37925g.setTrace(true);
            this.f37926h.setTrace(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sun.mail.pop3.c T(String str) throws IOException {
        V(str);
        D(str);
        com.sun.mail.pop3.c N = N();
        U();
        return N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        if (this.f37928j.isLoggable(Level.FINEST)) {
            this.f37925g.setTrace(false);
            this.f37926h.setTrace(false);
        }
    }

    private static String b0(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i4 = 0;
        for (byte b4 : bArr) {
            int i5 = b4 & 255;
            int i6 = i4 + 1;
            char[] cArr2 = f37918r;
            cArr[i4] = cArr2[i5 >> 4];
            i4 = i6 + 1;
            cArr[i6] = cArr2[i5 & 15];
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.sun.mail.pop3.c d0(String str, String str2) throws IOException {
        String str3 = str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2;
        n(str3);
        T(str);
        l(str3);
        com.sun.mail.pop3.c T = T(str2);
        m();
        return T;
    }

    private static IOException p(Socket socket, IOException iOException) {
        try {
            socket.close();
        } catch (Throwable th) {
            if (A(th)) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean s(Properties properties, String str) {
        boolean booleanProperty;
        booleanProperty = PropUtil.getBooleanProperty(properties, str, false);
        if (this.f37927i.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger = this.f37927i;
            mailLogger.config(str + ": " + booleanProperty);
        }
        return booleanProperty;
    }

    private String v(String str) {
        try {
            return b0(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest((this.f37929k + str).getBytes("iso-8859-1")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized String w() {
        Socket socket;
        try {
            String str = this.f37935q;
            if (str == null || str.length() == 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                String canonicalHostName = localHost.getCanonicalHostName();
                this.f37935q = canonicalHostName;
                if (canonicalHostName == null) {
                    this.f37935q = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException unused) {
        }
        String str2 = this.f37935q;
        if ((str2 == null || str2.length() <= 0) && (socket = this.f37919a) != null && socket.isBound()) {
            InetAddress localAddress = this.f37919a.getLocalAddress();
            String canonicalHostName2 = localAddress.getCanonicalHostName();
            this.f37935q = canonicalHostName2;
            if (canonicalHostName2 == null) {
                this.f37935q = "[" + localAddress.getHostAddress() + "]";
            }
        }
        return this.f37935q;
    }

    private void y() throws IOException {
        boolean booleanProperty = PropUtil.getBooleanProperty(this.f37921c, "mail.debug.quote", false);
        TraceInputStream traceInputStream = new TraceInputStream(this.f37919a.getInputStream(), this.f37928j);
        this.f37925g = traceInputStream;
        traceInputStream.setQuote(booleanProperty);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.f37919a.getOutputStream(), this.f37928j);
        this.f37926h = traceOutputStream;
        traceOutputStream.setQuote(booleanProperty);
        this.f37923e = new BufferedReader(new InputStreamReader(this.f37925g, "iso-8859-1"));
        this.f37924f = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.f37926h, "iso-8859-1")));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean B() {
        return this.f37919a instanceof SSLSocket;
    }

    protected boolean C() {
        return this.f37928j.isLoggable(Level.FINEST);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized int E(int i4) throws IOException {
        int i5;
        com.sun.mail.pop3.c T = T("LIST " + i4);
        if (T.f37945a && T.f37947c != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(T.f37947c);
                stringTokenizer.nextToken();
                i5 = Integer.parseInt(stringTokenizer.nextToken());
            } catch (RuntimeException unused) {
            }
        }
        i5 = -1;
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized InputStream F() throws IOException {
        return H("LIST", 128).f37948d;
    }

    synchronized String G(String str, String str2) throws IOException {
        boolean z3;
        String str3;
        com.sun.mail.pop3.c T;
        String str4;
        if (this.f37931m && (this.f37919a instanceof SSLSocket)) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (this.f37932n && C()) {
            this.f37927i.fine("authentication command trace suppressed");
            a0();
        }
        if (this.f37929k != null) {
            str3 = v(str2);
        } else {
            str3 = null;
        }
        if (this.f37929k != null && str3 != null) {
            T = T("APOP " + str + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str3);
        } else if (z3) {
            String str5 = "USER " + str;
            n(str5);
            D(str5);
            String str6 = "PASS " + str2;
            l(str6);
            D(str6);
            com.sun.mail.pop3.c N = N();
            if (!N.f37945a) {
                String str7 = N.f37947c;
                if (str7 == null) {
                    str7 = "USER command failed";
                }
                N();
                m();
                O();
                return str7;
            }
            T = N();
            m();
        } else {
            com.sun.mail.pop3.c T2 = T("USER " + str);
            if (!T2.f37945a) {
                String str8 = T2.f37947c;
                if (str8 == null) {
                    str8 = "USER command failed";
                }
                O();
                return str8;
            }
            T = T("PASS " + str2);
        }
        if (this.f37932n && C()) {
            MailLogger mailLogger = this.f37927i;
            Level level = Level.FINE;
            if (T.f37945a) {
                str4 = "succeeded";
            } else {
                str4 = "failed";
            }
            mailLogger.log(level, "authentication command {0}", str4);
        }
        if (!T.f37945a) {
            String str9 = T.f37947c;
            if (str9 == null) {
                str9 = "login failed";
            }
            O();
            return str9;
        }
        O();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean K() throws IOException {
        return T("NOOP").f37945a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean L() throws IOException {
        boolean z3;
        z3 = T("QUIT").f37945a;
        q();
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0012 A[Catch: all -> 0x000a, TryCatch #2 {all -> 0x000a, blocks: (B:5:0x0004, B:13:0x0012, B:15:0x0048, B:17:0x004c, B:21:0x0063, B:23:0x006d, B:27:0x0088, B:29:0x0090, B:30:0x0098, B:52:0x0115, B:55:0x011b, B:57:0x0125, B:58:0x0141, B:31:0x009d, B:33:0x00bc, B:38:0x00c4, B:40:0x00c8, B:42:0x00df, B:46:0x00e8, B:48:0x00f2, B:51:0x010c), top: B:70:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009d A[Catch: all -> 0x000a, TryCatch #2 {all -> 0x000a, blocks: (B:5:0x0004, B:13:0x0012, B:15:0x0048, B:17:0x004c, B:21:0x0063, B:23:0x006d, B:27:0x0088, B:29:0x0090, B:30:0x0098, B:52:0x0115, B:55:0x011b, B:57:0x0125, B:58:0x0141, B:31:0x009d, B:33:0x00bc, B:38:0x00c4, B:40:0x00c8, B:42:0x00df, B:46:0x00e8, B:48:0x00f2, B:51:0x010c), top: B:70:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.io.InputStream P(int r6, int r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.b.P(int, int):java.io.InputStream");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        r2 = r5.f37923e.read();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean Q(int r6, java.io.OutputStream r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8f
            r0.<init>()     // Catch: java.lang.Throwable -> L8f
            java.lang.String r1 = "RETR "
            r0.append(r1)     // Catch: java.lang.Throwable -> L8f
            r0.append(r6)     // Catch: java.lang.Throwable -> L8f
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L8f
            r5.J(r6)     // Catch: java.lang.Throwable -> L8f
            r5.D(r6)     // Catch: java.lang.Throwable -> L8f
            com.sun.mail.pop3.c r6 = r5.N()     // Catch: java.lang.Throwable -> L8f
            boolean r6 = r6.f37945a     // Catch: java.lang.Throwable -> L8f
            if (r6 != 0) goto L26
            r5.I()     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r5)
            r6 = 0
            return r6
        L26:
            r6 = 10
            r0 = 0
            r1 = 10
        L2b:
            java.io.BufferedReader r2 = r5.f37923e     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            int r2 = r2.read()     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            if (r2 < 0) goto L67
            if (r1 != r6) goto L4a
            r1 = 46
            if (r2 != r1) goto L4a
            java.io.BufferedReader r1 = r5.f37923e     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            int r1 = r1.read()     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            r2 = 13
            if (r1 != r2) goto L4b
            java.io.BufferedReader r6 = r5.f37923e     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            int r2 = r6.read()     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            goto L67
        L4a:
            r1 = r2
        L4b:
            if (r0 != 0) goto L2b
            r7.write(r1)     // Catch: java.lang.RuntimeException -> L51 java.io.IOException -> L5c java.lang.Throwable -> L8f
            goto L2b
        L51:
            r0 = move-exception
            com.sun.mail.util.MailLogger r2 = r5.f37927i     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            java.util.logging.Level r3 = java.util.logging.Level.FINE     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            java.lang.String r4 = "exception while streaming"
            r2.log(r3, r4, r0)     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            goto L2b
        L5c:
            r0 = move-exception
            com.sun.mail.util.MailLogger r2 = r5.f37927i     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            java.util.logging.Level r3 = java.util.logging.Level.FINE     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            java.lang.String r4 = "exception while streaming"
            r2.log(r3, r4, r0)     // Catch: java.io.InterruptedIOException -> L88 java.lang.Throwable -> L8f
            goto L2b
        L67:
            if (r2 < 0) goto L80
            if (r0 == 0) goto L7a
            boolean r6 = r0 instanceof java.io.IOException     // Catch: java.lang.Throwable -> L8f
            if (r6 != 0) goto L77
            boolean r6 = r0 instanceof java.lang.RuntimeException     // Catch: java.lang.Throwable -> L8f
            if (r6 != 0) goto L74
            goto L7a
        L74:
            java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0     // Catch: java.lang.Throwable -> L8f
            throw r0     // Catch: java.lang.Throwable -> L8f
        L77:
            java.io.IOException r0 = (java.io.IOException) r0     // Catch: java.lang.Throwable -> L8f
            throw r0     // Catch: java.lang.Throwable -> L8f
        L7a:
            r5.I()     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r5)
            r6 = 1
            return r6
        L80:
            java.io.EOFException r6 = new java.io.EOFException     // Catch: java.lang.Throwable -> L8f
            java.lang.String r7 = "EOF on socket"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L8f
            throw r6     // Catch: java.lang.Throwable -> L8f
        L88:
            r6 = move-exception
            java.net.Socket r7 = r5.f37919a     // Catch: java.io.IOException -> L8e java.lang.Throwable -> L8f
            r7.close()     // Catch: java.io.IOException -> L8e java.lang.Throwable -> L8f
        L8e:
            throw r6     // Catch: java.lang.Throwable -> L8f
        L8f:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.pop3.b.Q(int, java.io.OutputStream):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean R() throws IOException {
        return T("RSET").f37945a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void S(InputStream inputStream) {
        String str;
        BufferedReader bufferedReader = null;
        if (inputStream == null) {
            this.f37930l = null;
        } else {
            this.f37930l = new HashMap(10);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "us-ascii"));
            } catch (UnsupportedEncodingException unused) {
            }
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        int indexOf = readLine.indexOf(32);
                        if (indexOf > 0) {
                            str = readLine.substring(0, indexOf);
                        } else {
                            str = readLine;
                        }
                        this.f37930l.put(str.toUpperCase(Locale.ENGLISH), readLine);
                    }
                } catch (IOException unused2) {
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
                try {
                    break;
                } catch (IOException unused4) {
                    return;
                }
            }
            inputStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.sun.mail.pop3.d W() throws IOException {
        com.sun.mail.pop3.d dVar;
        com.sun.mail.pop3.c T = T("STAT");
        dVar = new com.sun.mail.pop3.d();
        if (T.f37945a) {
            if (T.f37947c != null) {
                try {
                    StringTokenizer stringTokenizer = new StringTokenizer(T.f37947c);
                    dVar.f37949a = Integer.parseInt(stringTokenizer.nextToken());
                    dVar.f37950b = Integer.parseInt(stringTokenizer.nextToken());
                } catch (RuntimeException unused) {
                }
            }
        } else {
            throw new IOException("STAT command failed: " + T.f37947c);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean X() throws IOException {
        if (this.f37919a instanceof SSLSocket) {
            return true;
        }
        com.sun.mail.pop3.c T = T("STLS");
        if (T.f37945a) {
            try {
                this.f37919a = SocketFetcher.startTLS(this.f37919a, this.f37920b, this.f37921c, this.f37922d);
                y();
            } catch (IOException e4) {
                this.f37919a.close();
                this.f37919a = null;
                this.f37923e = null;
                this.f37924f = null;
                IOException iOException = new IOException("Could not convert socket to TLS");
                iOException.initCause(e4);
                throw iOException;
            }
        }
        return T.f37945a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean Y(String str) {
        if (str.equals("LOGIN")) {
            return true;
        }
        Map<String, String> map = this.f37930l;
        if (map == null) {
            return false;
        }
        String str2 = map.get("SASL");
        if (str2 == null) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Z(String str) {
        return this.f37933o.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized InputStream c0(int i4, int i5) throws IOException {
        return H("TOP " + i4 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i5, 0).f37948d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String e0(int i4) throws IOException {
        com.sun.mail.pop3.c T = T("UIDL " + i4);
        if (!T.f37945a) {
            return null;
        }
        int indexOf = T.f37947c.indexOf(32);
        if (indexOf <= 0) {
            return null;
        }
        return T.f37947c.substring(indexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean f0(String[] strArr) throws IOException {
        int parseInt;
        com.sun.mail.pop3.c H = H("UIDL", strArr.length * 15);
        if (!H.f37945a) {
            return false;
        }
        LineInputStream lineInputStream = new LineInputStream(H.f37948d);
        while (true) {
            String readLine = lineInputStream.readLine();
            if (readLine != null) {
                int indexOf = readLine.indexOf(32);
                if (indexOf >= 1 && indexOf < readLine.length() && (parseInt = Integer.parseInt(readLine.substring(0, indexOf))) > 0 && parseInt <= strArr.length) {
                    strArr[parseInt - 1] = readLine.substring(indexOf + 1);
                }
            } else {
                try {
                    break;
                } catch (IOException unused) {
                }
            }
        }
        H.f37948d.close();
        return true;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.f37919a != null) {
                L();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String k(String str, String str2, String str3, String str4, String str5) {
        a aVar = this.f37933o.get(str.toUpperCase(Locale.ENGLISH));
        if (aVar == null) {
            return "No such authentication mechanism: " + str;
        }
        try {
            if (!aVar.a(str2, str3, str4, str5)) {
                return "login failed";
            }
            return null;
        } catch (IOException e4) {
            return e4.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized InputStream o() throws IOException {
        com.sun.mail.pop3.c H = H("CAPA", 128);
        if (!H.f37945a) {
            return null;
        }
        return H.f37948d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        try {
            Socket socket = this.f37919a;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.f37919a = null;
            this.f37923e = null;
            this.f37924f = null;
            throw th;
        }
        this.f37919a = null;
        this.f37923e = null;
        this.f37924f = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean r(int i4) throws IOException {
        return T("DELE " + i4).f37945a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Map<String, String> t() {
        return this.f37930l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String u() {
        return this.f37934p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean x(String str) {
        boolean z3;
        Map<String, String> map = this.f37930l;
        if (map != null) {
            if (map.containsKey(str.toUpperCase(Locale.ENGLISH))) {
                z3 = true;
            }
        }
        z3 = false;
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z(String str) {
        a aVar = this.f37933o.get(str.toUpperCase(Locale.ENGLISH));
        if (aVar != null && aVar.c()) {
            return true;
        }
        return false;
    }

    private void I() {
    }

    private void U() {
    }

    private void m() {
    }

    private void J(String str) {
    }

    private void V(String str) {
    }

    private void l(String str) {
    }

    private void n(String str) {
    }
}
