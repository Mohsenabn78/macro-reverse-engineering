package com.sun.mail.iap;

import androidx.exifinterface.media.ExifInterface;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.base.Ascii;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.SSLSocket;

/* loaded from: classes6.dex */
public class Protocol {

    /* renamed from: q  reason: collision with root package name */
    static final AtomicInteger f37598q = new AtomicInteger();

    /* renamed from: r  reason: collision with root package name */
    private static final byte[] f37599r = {Ascii.CR, 10};

    /* renamed from: a  reason: collision with root package name */
    protected String f37600a;

    /* renamed from: b  reason: collision with root package name */
    private Socket f37601b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f37602c;

    /* renamed from: d  reason: collision with root package name */
    protected MailLogger f37603d;

    /* renamed from: e  reason: collision with root package name */
    protected MailLogger f37604e;

    /* renamed from: f  reason: collision with root package name */
    protected Properties f37605f;

    /* renamed from: g  reason: collision with root package name */
    protected String f37606g;

    /* renamed from: h  reason: collision with root package name */
    private TraceInputStream f37607h;

    /* renamed from: i  reason: collision with root package name */
    private volatile ResponseInputStream f37608i;

    /* renamed from: j  reason: collision with root package name */
    private TraceOutputStream f37609j;

    /* renamed from: k  reason: collision with root package name */
    private volatile DataOutputStream f37610k;

    /* renamed from: l  reason: collision with root package name */
    private int f37611l;

    /* renamed from: m  reason: collision with root package name */
    private final String f37612m;

    /* renamed from: n  reason: collision with root package name */
    private String f37613n;

    /* renamed from: o  reason: collision with root package name */
    private final List<ResponseHandler> f37614o;

    /* renamed from: p  reason: collision with root package name */
    private volatile long f37615p;

    public Protocol(String str, int i4, Properties properties, String str2, boolean z3, MailLogger mailLogger) throws IOException, ProtocolException {
        this.f37611l = 0;
        this.f37614o = new CopyOnWriteArrayList();
        this.f37612m = c(properties, str2);
        try {
            this.f37600a = str;
            this.f37605f = properties;
            this.f37606g = str2;
            this.f37603d = mailLogger;
            this.f37604e = mailLogger.getSubLogger("protocol", null);
            this.f37601b = SocketFetcher.getSocket(str, i4, properties, str2, z3);
            this.f37602c = PropUtil.getBooleanProperty(properties, "mail.debug.quote", false);
            i();
            k(readResponse());
            this.f37615p = System.currentTimeMillis();
        } catch (Throwable th) {
            disconnect();
            throw th;
        }
    }

    private String c(Properties properties, String str) {
        String str2;
        if (PropUtil.getBooleanProperty(properties, str + ".reusetagprefix", false)) {
            return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        }
        int andIncrement = f37598q.getAndIncrement() % 18278;
        if (andIncrement < 26) {
            return new String(new char[]{(char) (andIncrement + 65)});
        }
        if (andIncrement < 702) {
            int i4 = andIncrement - 26;
            str2 = new String(new char[]{(char) ((i4 / 26) + 65), (char) ((i4 % 26) + 65)});
        } else {
            int i5 = andIncrement - 702;
            str2 = new String(new char[]{(char) ((i5 / 676) + 65), (char) (((i5 % 676) / 26) + 65), (char) ((i5 % 26) + 65)});
        }
        return str2;
    }

    private static SocketChannel d(Socket socket) {
        Field[] declaredFields;
        SocketChannel channel;
        for (Class<?> cls = socket.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField("socket");
                declaredField.setAccessible(true);
                channel = ((Socket) declaredField.get(socket)).getChannel();
            } catch (Exception unused) {
            }
            if (channel != null) {
                return channel;
            }
        }
        for (Class<?> cls2 = socket.getClass(); cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            try {
                for (Field field : cls2.getDeclaredFields()) {
                    if (Socket.class.isAssignableFrom(field.getType())) {
                        try {
                            field.setAccessible(true);
                            SocketChannel channel2 = ((Socket) field.get(socket)).getChannel();
                            if (channel2 != null) {
                                return channel2;
                            }
                        } catch (Exception unused2) {
                            continue;
                        }
                    }
                }
                continue;
            } catch (Exception unused3) {
            }
        }
        return null;
    }

    private void i() throws IOException {
        TraceInputStream traceInputStream = new TraceInputStream(this.f37601b.getInputStream(), this.f37604e);
        this.f37607h = traceInputStream;
        traceInputStream.setQuote(this.f37602c);
        this.f37608i = new ResponseInputStream(this.f37607h);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.f37601b.getOutputStream(), this.f37604e);
        this.f37609j = traceOutputStream;
        traceOutputStream.setQuote(this.f37602c);
        this.f37610k = new DataOutputStream(new BufferedOutputStream(this.f37609j));
    }

    public void addResponseHandler(ResponseHandler responseHandler) {
        this.f37614o.add(responseHandler);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005b A[Catch: all -> 0x0072, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000b, B:14:0x0026, B:15:0x002a, B:18:0x0032, B:20:0x003b, B:29:0x005b, B:30:0x005e, B:24:0x0047, B:27:0x0054, B:8:0x0012, B:10:0x001b), top: B:36:0x0001, inners: #1, #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0023 -> B:13:0x0024). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.sun.mail.iap.Response[] command(java.lang.String r8, com.sun.mail.iap.Argument r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.b(r8)     // Catch: java.lang.Throwable -> L72
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L72
            r0.<init>()     // Catch: java.lang.Throwable -> L72
            r1 = 0
            r2 = 1
            java.lang.String r8 = r7.writeCommand(r8, r9)     // Catch: java.lang.Exception -> L11 com.sun.mail.iap.LiteralException -> L1a java.lang.Throwable -> L72
            r9 = 0
            goto L24
        L11:
            r8 = move-exception
            com.sun.mail.iap.Response r8 = com.sun.mail.iap.Response.byeResponse(r8)     // Catch: java.lang.Throwable -> L72
            r0.add(r8)     // Catch: java.lang.Throwable -> L72
            goto L22
        L1a:
            r8 = move-exception
            com.sun.mail.iap.Response r8 = r8.getResponse()     // Catch: java.lang.Throwable -> L72
            r0.add(r8)     // Catch: java.lang.Throwable -> L72
        L22:
            r8 = r1
        L23:
            r9 = 1
        L24:
            if (r9 != 0) goto L59
            com.sun.mail.iap.Response r3 = r7.readResponse()     // Catch: com.sun.mail.iap.ProtocolException -> L46 java.io.IOException -> L51 java.lang.Throwable -> L72
            boolean r4 = r3.isBYE()     // Catch: java.lang.Throwable -> L72
            if (r4 == 0) goto L32
            r1 = r3
            goto L24
        L32:
            r0.add(r3)     // Catch: java.lang.Throwable -> L72
            boolean r4 = r3.isTagged()     // Catch: java.lang.Throwable -> L72
            if (r4 == 0) goto L24
            java.lang.String r3 = r3.getTag()     // Catch: java.lang.Throwable -> L72
            boolean r3 = r3.equals(r8)     // Catch: java.lang.Throwable -> L72
            if (r3 == 0) goto L24
            goto L23
        L46:
            r3 = move-exception
            com.sun.mail.util.MailLogger r4 = r7.f37603d     // Catch: java.lang.Throwable -> L72
            java.util.logging.Level r5 = java.util.logging.Level.FINE     // Catch: java.lang.Throwable -> L72
            java.lang.String r6 = "ignoring bad response"
            r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L72
            goto L24
        L51:
            r8 = move-exception
            if (r1 != 0) goto L59
            com.sun.mail.iap.Response r8 = com.sun.mail.iap.Response.byeResponse(r8)     // Catch: java.lang.Throwable -> L72
            r1 = r8
        L59:
            if (r1 == 0) goto L5e
            r0.add(r1)     // Catch: java.lang.Throwable -> L72
        L5e:
            int r8 = r0.size()     // Catch: java.lang.Throwable -> L72
            com.sun.mail.iap.Response[] r8 = new com.sun.mail.iap.Response[r8]     // Catch: java.lang.Throwable -> L72
            r0.toArray(r8)     // Catch: java.lang.Throwable -> L72
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L72
            r7.f37615p = r0     // Catch: java.lang.Throwable -> L72
            r7.a()     // Catch: java.lang.Throwable -> L72
            monitor-exit(r7)
            return r8
        L72:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.iap.Protocol.command(java.lang.String, com.sun.mail.iap.Argument):com.sun.mail.iap.Response[]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void disconnect() {
        Socket socket = this.f37601b;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
            this.f37601b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ResponseInputStream e() {
        return this.f37608i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized String f() {
        Socket socket;
        String str = this.f37613n;
        if (str == null || str.length() <= 0) {
            Properties properties = this.f37605f;
            this.f37613n = properties.getProperty(this.f37606g + ".localhost");
        }
        String str2 = this.f37613n;
        if (str2 == null || str2.length() <= 0) {
            Properties properties2 = this.f37605f;
            this.f37613n = properties2.getProperty(this.f37606g + ".localaddress");
        }
        try {
            String str3 = this.f37613n;
            if (str3 == null || str3.length() <= 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                String canonicalHostName = localHost.getCanonicalHostName();
                this.f37613n = canonicalHostName;
                if (canonicalHostName == null) {
                    this.f37613n = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException unused) {
        }
        String str4 = this.f37613n;
        if ((str4 == null || str4.length() <= 0) && (socket = this.f37601b) != null && socket.isBound()) {
            InetAddress localAddress = this.f37601b.getLocalAddress();
            String canonicalHostName2 = localAddress.getCanonicalHostName();
            this.f37613n = canonicalHostName2;
            if (canonicalHostName2 == null) {
                this.f37613n = "[" + localAddress.getHostAddress() + "]";
            }
        }
        return this.f37613n;
    }

    protected void finalize() throws Throwable {
        try {
            disconnect();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public OutputStream g() {
        return this.f37610k;
    }

    public SocketChannel getChannel() {
        SocketChannel channel = this.f37601b.getChannel();
        if (channel != null) {
            return channel;
        }
        Socket socket = this.f37601b;
        if (socket instanceof SSLSocket) {
            return d(socket);
        }
        return channel;
    }

    public InetAddress getInetAddress() {
        return this.f37601b.getInetAddress();
    }

    public SocketAddress getLocalSocketAddress() {
        return this.f37601b.getLocalSocketAddress();
    }

    public long getTimestamp() {
        return this.f37615p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteArray h() {
        return null;
    }

    public void handleResult(Response response) throws ProtocolException {
        if (response.isOK()) {
            return;
        }
        if (!response.isNO()) {
            if (!response.isBAD()) {
                if (!response.isBYE()) {
                    return;
                }
                disconnect();
                throw new ConnectionException(this, response);
            }
            throw new BadCommandException(response);
        }
        throw new CommandFailedException(response);
    }

    public boolean hasResponse() {
        try {
            if (this.f37608i.available() <= 0) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean isSSL() {
        return this.f37601b instanceof SSLSocket;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j() {
        return this.f37604e.isLoggable(Level.FINEST);
    }

    protected void k(Response response) throws ProtocolException {
        if (!response.isBYE()) {
            return;
        }
        throw new ConnectionException(this, response);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        if (this.f37604e.isLoggable(Level.FINEST)) {
            this.f37607h.setTrace(true);
            this.f37609j.setTrace(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean m() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        if (this.f37604e.isLoggable(Level.FINEST)) {
            this.f37607h.setTrace(false);
            this.f37609j.setTrace(false);
        }
    }

    public void notifyResponseHandlers(Response[] responseArr) {
        if (this.f37614o.isEmpty()) {
            return;
        }
        for (Response response : responseArr) {
            if (response != null) {
                for (ResponseHandler responseHandler : this.f37614o) {
                    if (responseHandler != null) {
                        responseHandler.handleResponse(response);
                    }
                }
            }
        }
    }

    public Response readResponse() throws IOException, ProtocolException {
        return new Response(this);
    }

    public void removeResponseHandler(ResponseHandler responseHandler) {
        this.f37614o.remove(responseHandler);
    }

    public void simpleCommand(String str, Argument argument) throws ProtocolException {
        Response[] command = command(str, argument);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
    }

    public synchronized void startCompression(String str) throws IOException, ProtocolException {
        simpleCommand(str, null);
        TraceInputStream traceInputStream = new TraceInputStream(new InflaterInputStream(this.f37601b.getInputStream(), new Inflater(true)), this.f37604e);
        this.f37607h = traceInputStream;
        traceInputStream.setQuote(this.f37602c);
        this.f37608i = new ResponseInputStream(this.f37607h);
        Properties properties = this.f37605f;
        int intProperty = PropUtil.getIntProperty(properties, this.f37606g + ".compress.level", -1);
        Properties properties2 = this.f37605f;
        int intProperty2 = PropUtil.getIntProperty(properties2, this.f37606g + ".compress.strategy", 0);
        MailLogger mailLogger = this.f37603d;
        Level level = Level.FINE;
        if (mailLogger.isLoggable(level)) {
            this.f37603d.log(level, "Creating Deflater with compression level {0} and strategy {1}", Integer.valueOf(intProperty), Integer.valueOf(intProperty2));
        }
        Deflater deflater = new Deflater(-1, true);
        try {
            deflater.setLevel(intProperty);
        } catch (IllegalArgumentException e4) {
            this.f37603d.log(Level.FINE, "Ignoring bad compression level", (Throwable) e4);
        }
        try {
            deflater.setStrategy(intProperty2);
        } catch (IllegalArgumentException e5) {
            this.f37603d.log(Level.FINE, "Ignoring bad compression strategy", (Throwable) e5);
        }
        TraceOutputStream traceOutputStream = new TraceOutputStream(new DeflaterOutputStream(this.f37601b.getOutputStream(), deflater, true), this.f37604e);
        this.f37609j = traceOutputStream;
        traceOutputStream.setQuote(this.f37602c);
        this.f37610k = new DataOutputStream(new BufferedOutputStream(this.f37609j));
    }

    public synchronized void startTLS(String str) throws IOException, ProtocolException {
        if (this.f37601b instanceof SSLSocket) {
            return;
        }
        simpleCommand(str, null);
        this.f37601b = SocketFetcher.startTLS(this.f37601b, this.f37600a, this.f37605f, this.f37606g);
        i();
    }

    public boolean supportsUtf8() {
        return false;
    }

    public String writeCommand(String str, Argument argument) throws IOException, ProtocolException {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f37612m);
        int i4 = this.f37611l;
        this.f37611l = i4 + 1;
        sb.append(Integer.toString(i4));
        String sb2 = sb.toString();
        DataOutputStream dataOutputStream = this.f37610k;
        dataOutputStream.writeBytes(sb2 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str);
        if (argument != null) {
            this.f37610k.write(32);
            argument.write(this);
        }
        this.f37610k.write(f37599r);
        this.f37610k.flush();
        return sb2;
    }

    public Protocol(InputStream inputStream, PrintStream printStream, Properties properties, boolean z3) throws IOException {
        this.f37611l = 0;
        this.f37614o = new CopyOnWriteArrayList();
        this.f37600a = "localhost";
        this.f37605f = properties;
        this.f37602c = false;
        this.f37612m = c(properties, "mail.imap");
        MailLogger mailLogger = new MailLogger(getClass(), "DEBUG", z3, System.out);
        this.f37603d = mailLogger;
        this.f37604e = mailLogger.getSubLogger("protocol", null);
        TraceInputStream traceInputStream = new TraceInputStream(inputStream, this.f37604e);
        this.f37607h = traceInputStream;
        traceInputStream.setQuote(this.f37602c);
        this.f37608i = new ResponseInputStream(this.f37607h);
        TraceOutputStream traceOutputStream = new TraceOutputStream(printStream, this.f37604e);
        this.f37609j = traceOutputStream;
        traceOutputStream.setQuote(this.f37602c);
        this.f37610k = new DataOutputStream(new BufferedOutputStream(this.f37609j));
        this.f37615p = System.currentTimeMillis();
    }

    private void a() {
    }

    private void b(String str) {
    }
}
