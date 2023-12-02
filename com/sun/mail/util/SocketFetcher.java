package com.sun.mail.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.AccessController;
import java.security.GeneralSecurityException;
import java.security.PrivilegedAction;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.SocketFactory;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes6.dex */
public class SocketFetcher {
    private static MailLogger logger = new MailLogger(SocketFetcher.class, "socket", "DEBUG SocketFetcher", PropUtil.getBooleanSystemProperty("mail.socket.debug", false), System.out);

    private SocketFetcher() {
    }

    private static void checkServerIdentity(String str, SSLSocket sSLSocket) throws IOException {
        try {
            Certificate[] peerCertificates = sSLSocket.getSession().getPeerCertificates();
            if (peerCertificates != null && peerCertificates.length > 0) {
                Certificate certificate = peerCertificates[0];
                if (certificate instanceof X509Certificate) {
                    if (matchCert(str, (X509Certificate) certificate)) {
                        return;
                    }
                }
            }
            sSLSocket.close();
            throw new IOException("Can't verify identity of server: " + str);
        } catch (SSLPeerUnverifiedException e4) {
            sSLSocket.close();
            IOException iOException = new IOException("Can't verify identity of server: " + str);
            iOException.initCause(e4);
            throw iOException;
        }
    }

    private static IOException cleanupAndThrow(Socket socket, IOException iOException) {
        try {
            socket.close();
        } catch (Throwable th) {
            if (isRecoverable(th)) {
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

    private static void configureSSLSocket(Socket socket, String str, Properties properties, String str2, SocketFactory socketFactory) throws IOException {
        if (!(socket instanceof SSLSocket)) {
            return;
        }
        SSLSocket sSLSocket = (SSLSocket) socket;
        String property = properties.getProperty(str2 + ".ssl.protocols", null);
        if (property != null) {
            sSLSocket.setEnabledProtocols(stringArray(property));
        } else {
            String[] enabledProtocols = sSLSocket.getEnabledProtocols();
            if (logger.isLoggable(Level.FINER)) {
                MailLogger mailLogger = logger;
                mailLogger.finer("SSL enabled protocols before " + Arrays.asList(enabledProtocols));
            }
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < enabledProtocols.length; i4++) {
                String str3 = enabledProtocols[i4];
                if (str3 != null && !str3.startsWith(SSLSocketFactory.SSL)) {
                    arrayList.add(enabledProtocols[i4]);
                }
            }
            sSLSocket.setEnabledProtocols((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        String property2 = properties.getProperty(str2 + ".ssl.ciphersuites", null);
        if (property2 != null) {
            sSLSocket.setEnabledCipherSuites(stringArray(property2));
        }
        if (logger.isLoggable(Level.FINER)) {
            MailLogger mailLogger2 = logger;
            mailLogger2.finer("SSL enabled protocols after " + Arrays.asList(sSLSocket.getEnabledProtocols()));
            MailLogger mailLogger3 = logger;
            mailLogger3.finer("SSL enabled ciphers after " + Arrays.asList(sSLSocket.getEnabledCipherSuites()));
        }
        sSLSocket.startHandshake();
        if (PropUtil.getBooleanProperty(properties, str2 + ".ssl.checkserveridentity", false)) {
            checkServerIdentity(str, sSLSocket);
        }
        if ((socketFactory instanceof MailSSLSocketFactory) && !((MailSSLSocketFactory) socketFactory).isServerTrusted(str, sSLSocket)) {
            throw cleanupAndThrow(sSLSocket, new IOException("Server is not trusted: " + str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0314 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02c1 A[Catch: IOException -> 0x0355, TryCatch #0 {IOException -> 0x0355, blocks: (B:64:0x02b8, B:66:0x02c1, B:68:0x02d6), top: B:103:0x02b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x033c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.Socket createSocket(java.net.InetAddress r20, int r21, java.lang.String r22, int r23, int r24, int r25, java.util.Properties r26, java.lang.String r27, javax.net.SocketFactory r28, boolean r29) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 881
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.createSocket(java.net.InetAddress, int, java.lang.String, int, int, int, java.util.Properties, java.lang.String, javax.net.SocketFactory, boolean):java.net.Socket");
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: com.sun.mail.util.SocketFetcher.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x023c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.Socket getSocket(java.lang.String r22, int r23, java.util.Properties r24, java.lang.String r25, boolean r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 612
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.getSocket(java.lang.String, int, java.util.Properties, java.lang.String, boolean):java.net.Socket");
    }

    private static SocketFactory getSocketFactory(String str) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> cls = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ClassLoader contextClassLoader = getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                cls = Class.forName(str, false, contextClassLoader);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (cls == null) {
            cls = Class.forName(str);
        }
        return (SocketFactory) cls.getMethod("getDefault", new Class[0]).invoke(new Object(), new Object[0]);
    }

    private static boolean isRecoverable(Throwable th) {
        if (!(th instanceof Exception) && !(th instanceof LinkageError)) {
            return false;
        }
        return true;
    }

    private static boolean matchCert(String str, X509Certificate x509Certificate) {
        MailLogger mailLogger = logger;
        Level level = Level.FINER;
        if (mailLogger.isLoggable(level)) {
            MailLogger mailLogger2 = logger;
            mailLogger2.finer("matchCert server " + str + ", cert " + x509Certificate);
        }
        try {
            Class<?> cls = Class.forName("sun.security.util.HostnameChecker");
            Object invoke = cls.getMethod("getInstance", Byte.TYPE).invoke(new Object(), (byte) 2);
            if (logger.isLoggable(level)) {
                logger.finer("using sun.security.util.HostnameChecker");
            }
            try {
                cls.getMethod("match", String.class, X509Certificate.class).invoke(invoke, str, x509Certificate);
                return true;
            } catch (InvocationTargetException e4) {
                logger.log(Level.FINER, "HostnameChecker FAIL", (Throwable) e4);
                return false;
            }
        } catch (Exception e5) {
            logger.log(Level.FINER, "NO sun.security.util.HostnameChecker", (Throwable) e5);
            try {
                Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
                if (subjectAlternativeNames != null) {
                    boolean z3 = false;
                    for (List<?> list : subjectAlternativeNames) {
                        if (((Integer) list.get(0)).intValue() == 2) {
                            String str2 = (String) list.get(1);
                            if (logger.isLoggable(Level.FINER)) {
                                MailLogger mailLogger3 = logger;
                                mailLogger3.finer("found name: " + str2);
                            }
                            if (matchServer(str, str2)) {
                                return true;
                            }
                            z3 = true;
                        }
                    }
                    if (z3) {
                        return false;
                    }
                }
            } catch (CertificateParsingException unused) {
            }
            Matcher matcher = Pattern.compile("CN=([^,]*)").matcher(x509Certificate.getSubjectX500Principal().getName());
            if (!matcher.find() || !matchServer(str, matcher.group(1).trim())) {
                return false;
            }
            return true;
        }
    }

    private static boolean matchServer(String str, String str2) {
        int length;
        if (logger.isLoggable(Level.FINER)) {
            MailLogger mailLogger = logger;
            mailLogger.finer("match server " + str + " with " + str2);
        }
        if (str2.startsWith("*.")) {
            String substring = str2.substring(2);
            if (substring.length() == 0 || (length = str.length() - substring.length()) < 1 || str.charAt(length - 1) != '.' || !str.regionMatches(true, length, substring, 0, substring.length())) {
                return false;
            }
            return true;
        }
        return str.equalsIgnoreCase(str2);
    }

    private static void proxyConnect(Socket socket, String str, int i4, String str2, String str3, String str4, int i5, int i6) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            MailLogger mailLogger = logger;
            mailLogger.fine("connecting through proxy " + str + ":" + i4 + " to " + str4 + ":" + i5);
        }
        if (i6 >= 0) {
            socket.connect(new InetSocketAddress(str, i4), i6);
        } else {
            socket.connect(new InetSocketAddress(str, i4));
        }
        PrintStream printStream = new PrintStream(socket.getOutputStream(), false, StandardCharsets.UTF_8.name());
        StringBuilder sb = new StringBuilder();
        sb.append("CONNECT ");
        sb.append(str4);
        sb.append(":");
        sb.append(i5);
        sb.append(" HTTP/1.1\r\n");
        sb.append("Host: ");
        sb.append(str4);
        sb.append(":");
        sb.append(i5);
        sb.append("\r\n");
        if (str2 != null && str3 != null) {
            String str5 = new String(BASE64EncoderStream.encode((str2 + ':' + str3).getBytes(StandardCharsets.UTF_8)), StandardCharsets.US_ASCII);
            sb.append("Proxy-Authorization: Basic ");
            sb.append(str5);
            sb.append("\r\n");
        }
        sb.append("Proxy-Connection: keep-alive\r\n\r\n");
        printStream.print(sb.toString());
        printStream.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        boolean z3 = true;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.length() != 0) {
                logger.finest(readLine);
                if (z3) {
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                    stringTokenizer.nextToken();
                    if (stringTokenizer.nextToken().equals("200")) {
                        z3 = false;
                    } else {
                        try {
                            socket.close();
                        } catch (IOException unused) {
                        }
                        ConnectException connectException = new ConnectException("connection through proxy " + str + ":" + i4 + " to " + str4 + ":" + i5 + " failed: " + readLine);
                        logger.log(Level.FINE, "connect failed", (Throwable) connectException);
                        throw connectException;
                    }
                }
            } else {
                return;
            }
        }
    }

    @Deprecated
    public static Socket startTLS(Socket socket) throws IOException {
        return startTLS(socket, new Properties(), "socket");
    }

    private static String[] stringArray(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Deprecated
    public static Socket startTLS(Socket socket, Properties properties, String str) throws IOException {
        return startTLS(socket, socket.getInetAddress().getHostName(), properties, str);
    }

    public static Socket startTLS(Socket socket, String str, Properties properties, String str2) throws IOException {
        SocketFactory socketFactory;
        int port = socket.getPort();
        if (logger.isLoggable(Level.FINER)) {
            logger.finer("startTLS host " + str + ", port " + port);
        }
        String str3 = "unknown socket factory";
        try {
            Object obj = properties.get(str2 + ".ssl.socketFactory");
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = null;
            sSLSocketFactory = null;
            if (obj instanceof SocketFactory) {
                socketFactory = (SocketFactory) obj;
                str3 = "SSL socket factory instance " + socketFactory;
            } else {
                socketFactory = null;
            }
            if (socketFactory == null) {
                String property = properties.getProperty(str2 + ".ssl.socketFactory.class");
                str3 = "SSL socket factory class " + property;
                socketFactory = getSocketFactory(property);
            }
            if (socketFactory != null && (socketFactory instanceof javax.net.ssl.SSLSocketFactory)) {
                sSLSocketFactory = socketFactory;
            }
            if (sSLSocketFactory == null) {
                Object obj2 = properties.get(str2 + ".socketFactory");
                if (obj2 instanceof SocketFactory) {
                    socketFactory = (SocketFactory) obj2;
                    str3 = "socket factory instance " + socketFactory;
                }
                if (socketFactory == null) {
                    String property2 = properties.getProperty(str2 + ".socketFactory.class");
                    str3 = "socket factory class " + property2;
                    socketFactory = getSocketFactory(property2);
                }
                if (socketFactory != null && (socketFactory instanceof javax.net.ssl.SSLSocketFactory)) {
                    sSLSocketFactory = socketFactory;
                }
            }
            MailSSLSocketFactory mailSSLSocketFactory = sSLSocketFactory;
            if (sSLSocketFactory == null) {
                String property3 = properties.getProperty(str2 + ".ssl.trust");
                if (property3 != null) {
                    try {
                        MailSSLSocketFactory mailSSLSocketFactory2 = new MailSSLSocketFactory();
                        if (property3.equals("*")) {
                            mailSSLSocketFactory2.setTrustAllHosts(true);
                        } else {
                            mailSSLSocketFactory2.setTrustedHosts(property3.split("\\s+"));
                        }
                        mailSSLSocketFactory = mailSSLSocketFactory2;
                    } catch (GeneralSecurityException e4) {
                        IOException iOException = new IOException("Can't create MailSSLSocketFactory");
                        iOException.initCause(e4);
                        throw iOException;
                    }
                } else {
                    mailSSLSocketFactory = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
                }
            }
            Socket createSocket = mailSSLSocketFactory.createSocket(socket, str, port, true);
            configureSSLSocket(createSocket, str, properties, str2, mailSSLSocketFactory);
            return createSocket;
        } catch (Exception e5) {
            e = e5;
            if (e instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e).getTargetException();
                if (targetException instanceof Exception) {
                    e = (Exception) targetException;
                }
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            IOException iOException2 = new IOException("Exception in startTLS using " + str3 + ": host, port: " + str + ", " + port + "; Exception: " + e);
            iOException2.initCause(e);
            throw iOException2;
        }
    }

    public static Socket getSocket(String str, int i4, Properties properties, String str2) throws IOException {
        return getSocket(str, i4, properties, str2, false);
    }
}
