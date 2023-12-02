package com.sun.mail.smtp;

import com.android.dx.io.Opcodes;
import com.arlosoft.macrodroid.utils.FileUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.common.base.Ascii;
import com.sun.mail.auth.Ntlm;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.LineInputStream;
import com.sun.mail.util.MailConnectException;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import com.sun.mail.util.SocketConnectException;
import com.sun.mail.util.SocketFetcher;
import com.sun.mail.util.TraceInputStream;
import com.sun.mail.util.TraceOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.logging.Level;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Service;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.URLName;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.ParseException;
import javax.net.ssl.SSLSocket;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.apache.http.client.params.AuthPolicy;

/* loaded from: classes6.dex */
public class SMTPTransport extends Transport {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String UNKNOWN = "UNKNOWN";
    private Address[] addresses;
    private boolean allowutf8;
    private Map<String, Authenticator> authenticators;
    private String authorizationID;
    private int chunkSize;
    private SMTPOutputStream dataStream;
    private boolean debugpassword;
    private boolean debugusername;
    private String defaultAuthenticationMechanisms;
    private int defaultPort;
    private boolean enableSASL;
    private MessagingException exception;
    private Hashtable<String, String> extMap;
    private String host;
    private Address[] invalidAddr;
    private boolean isSSL;
    private int lastReturnCode;
    private String lastServerResponse;
    private LineInputStream lineInputStream;
    private String localHostName;
    private MailLogger logger;
    private MimeMessage message;
    private String name;
    private boolean noauthdebug;
    private boolean noopStrict;
    private boolean notificationDone;
    private String ntlmDomain;
    private boolean quitOnSessionReject;
    private boolean quitWait;
    private boolean reportSuccess;
    private boolean requireStartTLS;
    private SaslAuthenticator saslAuthenticator;
    private String[] saslMechanisms;
    private String saslRealm;
    private boolean sendPartiallyFailed;
    private BufferedInputStream serverInput;
    private OutputStream serverOutput;
    private Socket serverSocket;
    private TraceInputStream traceInput;
    private MailLogger traceLogger;
    private TraceOutputStream traceOutput;
    private boolean useCanonicalHostName;
    private boolean useRset;
    private boolean useStartTLS;
    private Address[] validSentAddr;
    private Address[] validUnsentAddr;
    private static final String[] ignoreList = {"Bcc", "Content-Length"};
    private static final byte[] CRLF = {Ascii.CR, 10};
    private static final String[] UNKNOWN_SA = new String[0];
    private static char[] hexchar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public abstract class Authenticator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean enabled;
        private final String mech;
        protected int resp;

        Authenticator(SMTPTransport sMTPTransport, String str) {
            this(str, true);
        }

        boolean authenticate(String str, String str2, String str3, String str4) throws MessagingException {
            String str5;
            String str6 = "succeeded";
            try {
                try {
                    String initialResponse = getInitialResponse(str, str2, str3, str4);
                    if (SMTPTransport.this.noauthdebug && SMTPTransport.this.isTracing()) {
                        MailLogger mailLogger = SMTPTransport.this.logger;
                        mailLogger.fine("AUTH " + this.mech + " command trace suppressed");
                        SMTPTransport.this.suspendTracing();
                    }
                    if (initialResponse != null) {
                        SMTPTransport sMTPTransport = SMTPTransport.this;
                        StringBuilder sb = new StringBuilder();
                        sb.append("AUTH ");
                        sb.append(this.mech);
                        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        if (initialResponse.length() == 0) {
                            str5 = "=";
                        } else {
                            str5 = initialResponse;
                        }
                        sb.append(str5);
                        this.resp = sMTPTransport.simpleCommand(sb.toString());
                    } else {
                        SMTPTransport sMTPTransport2 = SMTPTransport.this;
                        this.resp = sMTPTransport2.simpleCommand("AUTH " + this.mech);
                    }
                    if (this.resp == 530) {
                        SMTPTransport.this.startTLS();
                        if (initialResponse != null) {
                            SMTPTransport sMTPTransport3 = SMTPTransport.this;
                            this.resp = sMTPTransport3.simpleCommand("AUTH " + this.mech + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + initialResponse);
                        } else {
                            SMTPTransport sMTPTransport4 = SMTPTransport.this;
                            this.resp = sMTPTransport4.simpleCommand("AUTH " + this.mech);
                        }
                    }
                    if (this.resp == 334) {
                        doAuth(str, str2, str3, str4);
                    }
                    if (SMTPTransport.this.noauthdebug && SMTPTransport.this.isTracing()) {
                        MailLogger mailLogger2 = SMTPTransport.this.logger;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("AUTH ");
                        sb2.append(this.mech);
                        sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        if (this.resp != 235) {
                            str6 = "failed";
                        }
                        sb2.append(str6);
                        mailLogger2.fine(sb2.toString());
                    }
                    SMTPTransport.this.resumeTracing();
                    if (this.resp != 235) {
                        SMTPTransport.this.closeConnection();
                        throw new AuthenticationFailedException(SMTPTransport.this.getLastServerResponse());
                    }
                    return true;
                }
            } catch (IOException e4) {
                MailLogger mailLogger3 = SMTPTransport.this.logger;
                Level level = Level.FINE;
                mailLogger3.log(level, "AUTH " + this.mech + " failed", (Throwable) e4);
                if (SMTPTransport.this.noauthdebug && SMTPTransport.this.isTracing()) {
                    MailLogger mailLogger4 = SMTPTransport.this.logger;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("AUTH ");
                    sb3.append(this.mech);
                    sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    if (this.resp != 235) {
                        str6 = "failed";
                    }
                    sb3.append(str6);
                    mailLogger4.fine(sb3.toString());
                }
                SMTPTransport.this.resumeTracing();
                if (this.resp != 235) {
                    SMTPTransport.this.closeConnection();
                    throw new AuthenticationFailedException(SMTPTransport.this.getLastServerResponse());
                }
                return true;
            }
        }

        abstract void doAuth(String str, String str2, String str3, String str4) throws MessagingException, IOException;

        boolean enabled() {
            return this.enabled;
        }

        String getInitialResponse(String str, String str2, String str3, String str4) throws MessagingException, IOException {
            return null;
        }

        String getMechanism() {
            return this.mech;
        }

        Authenticator(String str, boolean z3) {
            this.mech = str.toUpperCase(Locale.ENGLISH);
            this.enabled = z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class BDATOutputStream extends SMTPOutputStream {
        public BDATOutputStream(OutputStream outputStream, int i4) {
            super(new ChunkedOutputStream(outputStream, i4));
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            ((FilterOutputStream) this).out.close();
        }
    }

    /* loaded from: classes6.dex */
    private class DigestMD5Authenticator extends Authenticator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private DigestMD5 md5support;

        DigestMD5Authenticator() {
            super(SMTPTransport.this, "DIGEST-MD5");
        }

        private synchronized DigestMD5 getMD5() {
            if (this.md5support == null) {
                this.md5support = new DigestMD5(SMTPTransport.this.logger);
            }
            return this.md5support;
        }

        @Override // com.sun.mail.smtp.SMTPTransport.Authenticator
        void doAuth(String str, String str2, String str3, String str4) throws MessagingException, IOException {
            DigestMD5 md5 = getMD5();
            int simpleCommand = SMTPTransport.this.simpleCommand(md5.authClient(str, str3, str4, SMTPTransport.this.getSASLRealm(), SMTPTransport.this.getLastServerResponse()));
            this.resp = simpleCommand;
            if (simpleCommand == 334) {
                if (!md5.authServer(SMTPTransport.this.getLastServerResponse())) {
                    this.resp = -1;
                } else {
                    this.resp = SMTPTransport.this.simpleCommand(new byte[0]);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    private class LoginAuthenticator extends Authenticator {
        LoginAuthenticator() {
            super(SMTPTransport.this, "LOGIN");
        }

        @Override // com.sun.mail.smtp.SMTPTransport.Authenticator
        void doAuth(String str, String str2, String str3, String str4) throws MessagingException, IOException {
            int simpleCommand = SMTPTransport.this.simpleCommand(BASE64EncoderStream.encode(str3.getBytes(StandardCharsets.UTF_8)));
            this.resp = simpleCommand;
            if (simpleCommand == 334) {
                this.resp = SMTPTransport.this.simpleCommand(BASE64EncoderStream.encode(str4.getBytes(StandardCharsets.UTF_8)));
            }
        }
    }

    /* loaded from: classes6.dex */
    private class NtlmAuthenticator extends Authenticator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Ntlm ntlm;

        NtlmAuthenticator() {
            super(SMTPTransport.this, AuthPolicy.NTLM);
        }

        @Override // com.sun.mail.smtp.SMTPTransport.Authenticator
        void doAuth(String str, String str2, String str3, String str4) throws MessagingException, IOException {
            this.resp = SMTPTransport.this.simpleCommand(this.ntlm.generateType3Msg(SMTPTransport.this.getLastServerResponse().substring(4).trim()));
        }

        @Override // com.sun.mail.smtp.SMTPTransport.Authenticator
        String getInitialResponse(String str, String str2, String str3, String str4) throws MessagingException, IOException {
            this.ntlm = new Ntlm(SMTPTransport.this.getNTLMDomain(), SMTPTransport.this.getLocalHost(), str3, str4, SMTPTransport.this.logger);
            Properties properties = ((Service) SMTPTransport.this).session.getProperties();
            int intProperty = PropUtil.getIntProperty(properties, "mail." + SMTPTransport.this.name + ".auth.ntlm.flags", 0);
            Properties properties2 = ((Service) SMTPTransport.this).session.getProperties();
            return this.ntlm.generateType1Msg(intProperty, PropUtil.getBooleanProperty(properties2, "mail." + SMTPTransport.this.name + ".auth.ntlm.v2", true));
        }
    }

    /* loaded from: classes6.dex */
    private class OAuth2Authenticator extends Authenticator {
        OAuth2Authenticator() {
            super("XOAUTH2", false);
        }

        @Override // com.sun.mail.smtp.SMTPTransport.Authenticator
        void doAuth(String str, String str2, String str3, String str4) throws MessagingException, IOException {
            throw new AuthenticationFailedException("OAUTH2 asked for more");
        }

        @Override // com.sun.mail.smtp.SMTPTransport.Authenticator
        String getInitialResponse(String str, String str2, String str3, String str4) throws MessagingException, IOException {
            return ASCIIUtility.toString(BASE64EncoderStream.encode(("user=" + str3 + "\u0001auth=Bearer " + str4 + "\u0001\u0001").getBytes(StandardCharsets.UTF_8)));
        }
    }

    /* loaded from: classes6.dex */
    private class PlainAuthenticator extends Authenticator {
        PlainAuthenticator() {
            super(SMTPTransport.this, "PLAIN");
        }

        @Override // com.sun.mail.smtp.SMTPTransport.Authenticator
        void doAuth(String str, String str2, String str3, String str4) throws MessagingException, IOException {
            throw new AuthenticationFailedException("PLAIN asked for more");
        }

        @Override // com.sun.mail.smtp.SMTPTransport.Authenticator
        String getInitialResponse(String str, String str2, String str3, String str4) throws MessagingException, IOException {
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

    public SMTPTransport(Session session, URLName uRLName) {
        this(session, uRLName, "smtp", false);
    }

    private void addressesFailed() {
        Address[] addressArr = this.validSentAddr;
        if (addressArr != null) {
            Address[] addressArr2 = this.validUnsentAddr;
            if (addressArr2 != null) {
                Address[] addressArr3 = new Address[addressArr.length + addressArr2.length];
                System.arraycopy(addressArr, 0, addressArr3, 0, addressArr.length);
                Address[] addressArr4 = this.validUnsentAddr;
                System.arraycopy(addressArr4, 0, addressArr3, this.validSentAddr.length, addressArr4.length);
                this.validSentAddr = null;
                this.validUnsentAddr = addressArr3;
                return;
            }
            this.validUnsentAddr = addressArr;
            this.validSentAddr = null;
        }
    }

    private boolean authenticate(String str, String str2) throws MessagingException {
        Locale locale;
        String property = this.session.getProperty("mail." + this.name + ".auth.mechanisms");
        if (property == null) {
            property = this.defaultAuthenticationMechanisms;
        }
        String authorizationId = getAuthorizationId();
        if (authorizationId == null) {
            authorizationId = str;
        }
        if (this.enableSASL) {
            this.logger.fine("Authenticate with SASL");
            try {
                if (sasllogin(getSASLMechanisms(), getSASLRealm(), authorizationId, str, str2)) {
                    return true;
                }
                this.logger.fine("SASL authentication failed");
                return false;
            } catch (UnsupportedOperationException e4) {
                this.logger.log(Level.FINE, "SASL support failed", (Throwable) e4);
            }
        }
        if (this.logger.isLoggable(Level.FINE)) {
            this.logger.fine("Attempt to authenticate using mechanisms: " + property);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(property);
        while (stringTokenizer.hasMoreTokens()) {
            String upperCase = stringTokenizer.nextToken().toUpperCase(Locale.ENGLISH);
            Authenticator authenticator = this.authenticators.get(upperCase);
            if (authenticator == null) {
                this.logger.log(Level.FINE, "no authenticator for mechanism {0}", upperCase);
            } else if (!supportsAuthentication(upperCase)) {
                this.logger.log(Level.FINE, "mechanism {0} not supported by server", upperCase);
            } else {
                if (property == this.defaultAuthenticationMechanisms) {
                    String str3 = "mail." + this.name + ".auth." + upperCase.toLowerCase(locale) + ".disable";
                    if (PropUtil.getBooleanProperty(this.session.getProperties(), str3, !authenticator.enabled())) {
                        if (this.logger.isLoggable(Level.FINE)) {
                            this.logger.fine("mechanism " + upperCase + " disabled by property: " + str3);
                        }
                    }
                }
                this.logger.log(Level.FINE, "Using mechanism {0}", upperCase);
                return authenticator.authenticate(this.host, authorizationId, str, str2);
            }
        }
        throw new AuthenticationFailedException("No authentication mechanisms supported by both server and client");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.OutputStream, java.net.Socket, java.io.BufferedInputStream, com.sun.mail.util.LineInputStream] */
    public void closeConnection() throws MessagingException {
        try {
            try {
                Socket socket = this.serverSocket;
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e4) {
                throw new MessagingException("Server Close Failed", e4);
            }
        } finally {
            this.serverSocket = null;
            this.serverOutput = null;
            this.serverInput = null;
            this.lineInputStream = null;
            if (super.isConnected()) {
                super.close();
            }
        }
    }

    private boolean convertTo8Bit(MimePart mimePart) {
        InputStream inputStream;
        boolean z3 = false;
        try {
            if (mimePart.isMimeType(FileUtils.MIME_TYPE_TEXT)) {
                String encoding = mimePart.getEncoding();
                if (encoding == null) {
                    return false;
                }
                if (!encoding.equalsIgnoreCase("quoted-printable") && !encoding.equalsIgnoreCase("base64")) {
                    return false;
                }
                try {
                    inputStream = mimePart.getInputStream();
                } catch (Throwable th) {
                    th = th;
                    inputStream = null;
                }
                try {
                    if (is8Bit(inputStream)) {
                        mimePart.setContent(mimePart.getContent(), mimePart.getContentType());
                        mimePart.setHeader("Content-Transfer-Encoding", "8bit");
                        z3 = true;
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        return z3;
                    }
                    return z3;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } else if (!mimePart.isMimeType("multipart/*")) {
                return false;
            } else {
                MimeMultipart mimeMultipart = (MimeMultipart) mimePart.getContent();
                int count = mimeMultipart.getCount();
                boolean z4 = false;
                for (int i4 = 0; i4 < count; i4++) {
                    try {
                        if (convertTo8Bit((MimePart) mimeMultipart.getBodyPart(i4))) {
                            z4 = true;
                        }
                    } catch (IOException | MessagingException unused2) {
                    }
                }
                return z4;
            }
        } catch (IOException | MessagingException unused3) {
            return false;
        }
    }

    private void expandGroups() {
        ArrayList arrayList = null;
        int i4 = 0;
        while (true) {
            Address[] addressArr = this.addresses;
            if (i4 >= addressArr.length) {
                break;
            }
            InternetAddress internetAddress = (InternetAddress) addressArr[i4];
            if (internetAddress.isGroup()) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i4; i5++) {
                        arrayList.add(this.addresses[i5]);
                    }
                }
                try {
                    InternetAddress[] group = internetAddress.getGroup(true);
                    if (group != null) {
                        for (InternetAddress internetAddress2 : group) {
                            arrayList.add(internetAddress2);
                        }
                    } else {
                        arrayList.add(internetAddress);
                    }
                } catch (ParseException unused) {
                    arrayList.add(internetAddress);
                }
            } else if (arrayList != null) {
                arrayList.add(internetAddress);
            }
            i4++;
        }
        if (arrayList != null) {
            InternetAddress[] internetAddressArr = new InternetAddress[arrayList.size()];
            arrayList.toArray(internetAddressArr);
            this.addresses = internetAddressArr;
        }
    }

    private void initStreams() throws IOException {
        boolean booleanProperty = PropUtil.getBooleanProperty(this.session.getProperties(), "mail.debug.quote", false);
        TraceInputStream traceInputStream = new TraceInputStream(this.serverSocket.getInputStream(), this.traceLogger);
        this.traceInput = traceInputStream;
        traceInputStream.setQuote(booleanProperty);
        TraceOutputStream traceOutputStream = new TraceOutputStream(this.serverSocket.getOutputStream(), this.traceLogger);
        this.traceOutput = traceOutputStream;
        traceOutputStream.setQuote(booleanProperty);
        this.serverOutput = new BufferedOutputStream(this.traceOutput);
        this.serverInput = new BufferedInputStream(this.traceInput);
        this.lineInputStream = new LineInputStream(this.serverInput);
    }

    private boolean is8Bit(InputStream inputStream) {
        boolean z3 = false;
        int i4 = 0;
        while (true) {
            try {
                int read = inputStream.read();
                if (read >= 0) {
                    int i5 = read & 255;
                    if (i5 != 13 && i5 != 10) {
                        if (i5 == 0 || (i4 = i4 + 1) > 998) {
                            return false;
                        }
                    } else {
                        i4 = 0;
                    }
                    if (i5 > 127) {
                        z3 = true;
                    }
                } else {
                    if (z3) {
                        this.logger.fine("found an 8bit part");
                    }
                    return z3;
                }
            } catch (IOException unused) {
                return false;
            }
        }
    }

    private boolean isNotLastLine(String str) {
        if (str != null && str.length() >= 4 && str.charAt(3) == '-') {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTracing() {
        return this.traceLogger.isLoggable(Level.FINEST);
    }

    private void issueSendCommand(String str, int i4) throws MessagingException {
        int length;
        int length2;
        sendCommand(str);
        int readServerResponse = readServerResponse();
        if (readServerResponse != i4) {
            Address[] addressArr = this.validSentAddr;
            if (addressArr == null) {
                length = 0;
            } else {
                length = addressArr.length;
            }
            Address[] addressArr2 = this.validUnsentAddr;
            if (addressArr2 == null) {
                length2 = 0;
            } else {
                length2 = addressArr2.length;
            }
            Address[] addressArr3 = new Address[length + length2];
            if (length > 0) {
                System.arraycopy(addressArr, 0, addressArr3, 0, length);
            }
            if (length2 > 0) {
                System.arraycopy(this.validUnsentAddr, 0, addressArr3, length, length2);
            }
            this.validSentAddr = null;
            this.validUnsentAddr = addressArr3;
            if (this.logger.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.logger;
                mailLogger.fine("got response code " + readServerResponse + ", with response: " + this.lastServerResponse);
            }
            String str2 = this.lastServerResponse;
            int i5 = this.lastReturnCode;
            if (this.serverSocket != null) {
                issueCommand("RSET", -1);
            }
            this.lastServerResponse = str2;
            this.lastReturnCode = i5;
            throw new SMTPSendFailedException(str, readServerResponse, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
        }
    }

    private String normalizeAddress(String str) {
        if (!str.startsWith("<") && !str.endsWith(">")) {
            return "<" + str + ">";
        }
        return str;
    }

    private void openServer(String str, int i4) throws MessagingException {
        int readServerResponse;
        MailLogger mailLogger = this.logger;
        Level level = Level.FINE;
        if (mailLogger.isLoggable(level)) {
            MailLogger mailLogger2 = this.logger;
            mailLogger2.fine("trying to connect to host \"" + str + "\", port " + i4 + ", isSSL " + this.isSSL);
        }
        try {
            Properties properties = this.session.getProperties();
            Socket socket = SocketFetcher.getSocket(str, i4, properties, "mail." + this.name, this.isSSL);
            this.serverSocket = socket;
            int port = socket.getPort();
            this.host = str;
            initStreams();
            if (readServerResponse() != 220) {
                String str2 = this.lastServerResponse;
                try {
                    if (this.quitOnSessionReject) {
                        sendCommand("QUIT");
                        if (this.quitWait && (readServerResponse = readServerResponse()) != 221 && readServerResponse != -1 && this.logger.isLoggable(level)) {
                            MailLogger mailLogger3 = this.logger;
                            mailLogger3.fine("QUIT failed with " + readServerResponse);
                        }
                    }
                    this.serverSocket.close();
                    this.serverSocket = null;
                    this.serverOutput = null;
                    this.serverInput = null;
                } catch (Exception e4) {
                    MailLogger mailLogger4 = this.logger;
                    Level level2 = Level.FINE;
                    if (mailLogger4.isLoggable(level2)) {
                        this.logger.log(level2, "QUIT failed", (Throwable) e4);
                    }
                    this.serverSocket.close();
                    this.serverSocket = null;
                    this.serverOutput = null;
                    this.serverInput = null;
                }
                this.lineInputStream = null;
                if (this.logger.isLoggable(Level.FINE)) {
                    MailLogger mailLogger5 = this.logger;
                    mailLogger5.fine("got bad greeting from host \"" + str + "\", port: " + port + ", response: " + str2);
                }
                throw new MessagingException("Got bad greeting from SMTP host: " + str + ", port: " + port + ", response: " + str2);
            } else if (this.logger.isLoggable(level)) {
                MailLogger mailLogger6 = this.logger;
                mailLogger6.fine("connected to host \"" + str + "\", port: " + port);
            }
        } catch (SocketConnectException e5) {
            throw new MailConnectException(e5);
        } catch (UnknownHostException e6) {
            throw new MessagingException("Unknown SMTP host: " + str, e6);
        } catch (IOException e7) {
            throw new MessagingException("Could not connect to SMTP host: " + str + ", port: " + i4, e7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeTracing() {
        if (this.traceLogger.isLoggable(Level.FINEST)) {
            this.traceInput.setTrace(true);
            this.traceOutput.setTrace(true);
        }
    }

    private boolean sasllogin(String[] strArr, String str, String str2, String str3, String str4) throws MessagingException {
        String str5;
        ArrayList arrayList;
        String str6;
        if (this.useCanonicalHostName) {
            str5 = this.serverSocket.getInetAddress().getCanonicalHostName();
        } else {
            str5 = this.host;
        }
        if (this.saslAuthenticator == null) {
            try {
                this.saslAuthenticator = (SaslAuthenticator) Class.forName("com.sun.mail.smtp.SMTPSaslAuthenticator").getConstructor(SMTPTransport.class, String.class, Properties.class, MailLogger.class, String.class).newInstance(this, this.name, this.session.getProperties(), this.logger, str5);
            } catch (Exception e4) {
                this.logger.log(Level.FINE, "Can't load SASL authenticator", (Throwable) e4);
                return false;
            }
        }
        if (strArr != null && strArr.length > 0) {
            arrayList = new ArrayList(strArr.length);
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (supportsAuthentication(strArr[i4])) {
                    arrayList.add(strArr[i4]);
                }
            }
        } else {
            arrayList = new ArrayList();
            Hashtable<String, String> hashtable = this.extMap;
            if (hashtable != null && (str6 = hashtable.get("AUTH")) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(str6);
                while (stringTokenizer.hasMoreTokens()) {
                    arrayList.add(stringTokenizer.nextToken());
                }
            }
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        try {
            if (this.noauthdebug && isTracing()) {
                this.logger.fine("SASL AUTH command trace suppressed");
                suspendTracing();
            }
            return this.saslAuthenticator.authenticate(strArr2, str, str2, str3, str4);
        } finally {
            resumeTracing();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void suspendTracing() {
        if (this.traceLogger.isLoggable(Level.FINEST)) {
            this.traceInput.setTrace(false);
            this.traceOutput.setTrace(false);
        }
    }

    private byte[] toBytes(String str) {
        if (this.allowutf8) {
            return str.getBytes(StandardCharsets.UTF_8);
        }
        return ASCIIUtility.getBytes(str);
    }

    private String tracePassword(String str) {
        if (!this.debugpassword) {
            if (str == null) {
                return "<null>";
            }
            return "<non-null>";
        }
        return str;
    }

    private String traceUser(String str) {
        if (!this.debugusername) {
            return "<user name suppressed>";
        }
        return str;
    }

    protected static String xtext(String str) {
        return xtext(str, false);
    }

    protected OutputStream bdat() throws MessagingException {
        BDATOutputStream bDATOutputStream = new BDATOutputStream(this.serverOutput, this.chunkSize);
        this.dataStream = bDATOutputStream;
        return bDATOutputStream;
    }

    protected void checkConnected() {
        if (super.isConnected()) {
            return;
        }
        throw new IllegalStateException("Not connected");
    }

    @Override // javax.mail.Service, java.lang.AutoCloseable
    public synchronized void close() throws MessagingException {
        int readServerResponse;
        if (!super.isConnected()) {
            return;
        }
        if (this.serverSocket != null) {
            sendCommand("QUIT");
            if (this.quitWait && (readServerResponse = readServerResponse()) != 221 && readServerResponse != -1 && this.logger.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.logger;
                mailLogger.fine("QUIT failed with " + readServerResponse);
            }
        }
        closeConnection();
    }

    public synchronized void connect(Socket socket) throws MessagingException {
        this.serverSocket = socket;
        super.connect();
    }

    protected OutputStream data() throws MessagingException {
        issueSendCommand("DATA", 354);
        SMTPOutputStream sMTPOutputStream = new SMTPOutputStream(this.serverOutput);
        this.dataStream = sMTPOutputStream;
        return sMTPOutputStream;
    }

    protected boolean ehlo(String str) throws MessagingException {
        String str2;
        if (str != null) {
            str2 = "EHLO " + str;
        } else {
            str2 = "EHLO";
        }
        sendCommand(str2);
        int readServerResponse = readServerResponse();
        if (readServerResponse == 250) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(this.lastServerResponse));
            this.extMap = new Hashtable<>();
            boolean z3 = true;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (z3) {
                        z3 = false;
                    } else if (readLine.length() >= 5) {
                        String substring = readLine.substring(4);
                        int indexOf = substring.indexOf(32);
                        String str3 = "";
                        if (indexOf > 0) {
                            str3 = substring.substring(indexOf + 1);
                            substring = substring.substring(0, indexOf);
                        }
                        if (this.logger.isLoggable(Level.FINE)) {
                            this.logger.fine("Found extension \"" + substring + "\", arg \"" + str3 + "\"");
                        }
                        this.extMap.put(substring.toUpperCase(Locale.ENGLISH), str3);
                    }
                } catch (IOException unused) {
                }
            }
        }
        if (readServerResponse == 250) {
            return true;
        }
        return false;
    }

    @Override // javax.mail.Service
    protected void finalize() throws Throwable {
        try {
            closeConnection();
        } catch (MessagingException unused) {
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
        super.finalize();
    }

    protected void finishBdat() throws IOException, MessagingException {
        this.dataStream.ensureAtBOL();
        this.dataStream.close();
    }

    protected void finishData() throws IOException, MessagingException {
        this.dataStream.ensureAtBOL();
        issueSendCommand(".", 250);
    }

    public synchronized String getAuthorizationId() {
        if (this.authorizationID == UNKNOWN) {
            Session session = this.session;
            this.authorizationID = session.getProperty("mail." + this.name + ".sasl.authorizationid");
        }
        return this.authorizationID;
    }

    public String getExtensionParameter(String str) {
        Hashtable<String, String> hashtable = this.extMap;
        if (hashtable == null) {
            return null;
        }
        return hashtable.get(str.toUpperCase(Locale.ENGLISH));
    }

    public synchronized int getLastReturnCode() {
        return this.lastReturnCode;
    }

    public synchronized String getLastServerResponse() {
        return this.lastServerResponse;
    }

    public synchronized String getLocalHost() {
        Socket socket;
        String str = this.localHostName;
        if (str == null || str.length() <= 0) {
            Session session = this.session;
            this.localHostName = session.getProperty("mail." + this.name + ".localhost");
        }
        String str2 = this.localHostName;
        if (str2 == null || str2.length() <= 0) {
            Session session2 = this.session;
            this.localHostName = session2.getProperty("mail." + this.name + ".localaddress");
        }
        try {
            String str3 = this.localHostName;
            if (str3 == null || str3.length() <= 0) {
                InetAddress localHost = InetAddress.getLocalHost();
                String canonicalHostName = localHost.getCanonicalHostName();
                this.localHostName = canonicalHostName;
                if (canonicalHostName == null) {
                    this.localHostName = "[" + localHost.getHostAddress() + "]";
                }
            }
        } catch (UnknownHostException unused) {
        }
        String str4 = this.localHostName;
        if ((str4 == null || str4.length() <= 0) && (socket = this.serverSocket) != null && socket.isBound()) {
            InetAddress localAddress = this.serverSocket.getLocalAddress();
            String canonicalHostName2 = localAddress.getCanonicalHostName();
            this.localHostName = canonicalHostName2;
            if (canonicalHostName2 == null) {
                this.localHostName = "[" + localAddress.getHostAddress() + "]";
            }
        }
        return this.localHostName;
    }

    public synchronized String getNTLMDomain() {
        if (this.ntlmDomain == UNKNOWN) {
            Session session = this.session;
            this.ntlmDomain = session.getProperty("mail." + this.name + ".auth.ntlm.domain");
        }
        return this.ntlmDomain;
    }

    public synchronized boolean getNoopStrict() {
        return this.noopStrict;
    }

    public synchronized boolean getReportSuccess() {
        return this.reportSuccess;
    }

    public synchronized boolean getRequireStartTLS() {
        return this.requireStartTLS;
    }

    public synchronized boolean getSASLEnabled() {
        return this.enableSASL;
    }

    public synchronized String[] getSASLMechanisms() {
        if (this.saslMechanisms == UNKNOWN_SA) {
            ArrayList arrayList = new ArrayList(5);
            Session session = this.session;
            String property = session.getProperty("mail." + this.name + ".sasl.mechanisms");
            if (property != null && property.length() > 0) {
                if (this.logger.isLoggable(Level.FINE)) {
                    MailLogger mailLogger = this.logger;
                    mailLogger.fine("SASL mechanisms allowed: " + property);
                }
                StringTokenizer stringTokenizer = new StringTokenizer(property, " ,");
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.length() > 0) {
                        arrayList.add(nextToken);
                    }
                }
            }
            String[] strArr = new String[arrayList.size()];
            this.saslMechanisms = strArr;
            arrayList.toArray(strArr);
        }
        String[] strArr2 = this.saslMechanisms;
        if (strArr2 == null) {
            return null;
        }
        return (String[]) strArr2.clone();
    }

    public synchronized String getSASLRealm() {
        if (this.saslRealm == UNKNOWN) {
            Session session = this.session;
            String property = session.getProperty("mail." + this.name + ".sasl.realm");
            this.saslRealm = property;
            if (property == null) {
                Session session2 = this.session;
                this.saslRealm = session2.getProperty("mail." + this.name + ".saslrealm");
            }
        }
        return this.saslRealm;
    }

    public synchronized boolean getStartTLS() {
        return this.useStartTLS;
    }

    public synchronized boolean getUseCanonicalHostName() {
        return this.useCanonicalHostName;
    }

    public synchronized boolean getUseRset() {
        return this.useRset;
    }

    protected void helo(String str) throws MessagingException {
        if (str != null) {
            issueCommand("HELO " + str, 250);
            return;
        }
        issueCommand("HELO", 250);
    }

    @Override // javax.mail.Service
    public synchronized boolean isConnected() {
        if (!super.isConnected()) {
            return false;
        }
        try {
            try {
                if (this.useRset) {
                    sendCommand("RSET");
                } else {
                    sendCommand("NOOP");
                }
                int readServerResponse = readServerResponse();
                if (readServerResponse >= 0 && (!this.noopStrict ? readServerResponse != 421 : readServerResponse == 250)) {
                    return true;
                }
                try {
                    closeConnection();
                } catch (MessagingException unused) {
                }
                return false;
            } catch (MessagingException unused2) {
                return false;
            }
        } catch (Exception unused3) {
            closeConnection();
            return false;
        }
    }

    public synchronized boolean isSSL() {
        return this.serverSocket instanceof SSLSocket;
    }

    public synchronized void issueCommand(String str, int i4) throws MessagingException {
        sendCommand(str);
        int readServerResponse = readServerResponse();
        if (i4 != -1 && readServerResponse != i4) {
            throw new MessagingException(this.lastServerResponse);
        }
    }

    protected void mailFrom() throws MessagingException {
        String str;
        InternetAddress localAddress;
        Address[] from;
        String str2;
        String str3;
        MimeMessage mimeMessage = this.message;
        String str4 = null;
        if (mimeMessage instanceof SMTPMessage) {
            str = ((SMTPMessage) mimeMessage).getEnvelopeFrom();
        } else {
            str = null;
        }
        if (str == null || str.length() <= 0) {
            str = this.session.getProperty("mail." + this.name + ".from");
        }
        boolean z3 = false;
        if (str == null || str.length() <= 0) {
            MimeMessage mimeMessage2 = this.message;
            if (mimeMessage2 != null && (from = mimeMessage2.getFrom()) != null && from.length > 0) {
                localAddress = from[0];
            } else {
                localAddress = InternetAddress.getLocalAddress(this.session);
            }
            if (localAddress != null) {
                str = localAddress.getAddress();
            } else {
                throw new MessagingException("can't determine local email address");
            }
        }
        String str5 = "MAIL FROM:" + normalizeAddress(str);
        if (this.allowutf8 && supportsExtension("SMTPUTF8")) {
            str5 = str5 + " SMTPUTF8";
        }
        if (supportsExtension("DSN")) {
            MimeMessage mimeMessage3 = this.message;
            if (mimeMessage3 instanceof SMTPMessage) {
                str3 = ((SMTPMessage) mimeMessage3).getDSNRet();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = this.session.getProperty("mail." + this.name + ".dsn.ret");
            }
            if (str3 != null) {
                str5 = str5 + " RET=" + str3;
            }
        }
        if (supportsExtension("AUTH")) {
            MimeMessage mimeMessage4 = this.message;
            if (mimeMessage4 instanceof SMTPMessage) {
                str2 = ((SMTPMessage) mimeMessage4).getSubmitter();
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = this.session.getProperty("mail." + this.name + ".submitter");
            }
            if (str2 != null) {
                try {
                    if (this.allowutf8 && supportsExtension("SMTPUTF8")) {
                        z3 = true;
                    }
                    str5 = str5 + " AUTH=" + xtext(str2, z3);
                } catch (IllegalArgumentException e4) {
                    MailLogger mailLogger = this.logger;
                    Level level = Level.FINE;
                    if (mailLogger.isLoggable(level)) {
                        this.logger.log(level, "ignoring invalid submitter: " + str2, (Throwable) e4);
                    }
                }
            }
        }
        MimeMessage mimeMessage5 = this.message;
        if (mimeMessage5 instanceof SMTPMessage) {
            str4 = ((SMTPMessage) mimeMessage5).getMailExtension();
        }
        if (str4 == null) {
            str4 = this.session.getProperty("mail." + this.name + ".mailextension");
        }
        if (str4 != null && str4.length() > 0) {
            str5 = str5 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str4;
        }
        try {
            issueSendCommand(str5, 250);
        } catch (SMTPSendFailedException e5) {
            int returnCode = e5.getReturnCode();
            if (returnCode == 501 || returnCode == 503 || returnCode == 553 || returnCode == 550 || returnCode == 551) {
                try {
                    e5.setNextException(new SMTPSenderFailedException(new InternetAddress(str), str5, returnCode, e5.getMessage()));
                } catch (AddressException unused) {
                }
            }
            throw e5;
        }
    }

    @Override // javax.mail.Transport
    protected void notifyTransportListeners(int i4, Address[] addressArr, Address[] addressArr2, Address[] addressArr3, Message message) {
        if (!this.notificationDone) {
            super.notifyTransportListeners(i4, addressArr, addressArr2, addressArr3, message);
            this.notificationDone = true;
        }
    }

    @Override // javax.mail.Service
    protected synchronized boolean protocolConnect(String str, int i4, String str2, String str3) throws MessagingException {
        Properties properties = this.session.getProperties();
        boolean z3 = false;
        boolean booleanProperty = PropUtil.getBooleanProperty(properties, "mail." + this.name + ".auth", false);
        if (booleanProperty && (str2 == null || str3 == null)) {
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("need username and password for authentication");
                MailLogger mailLogger = this.logger;
                mailLogger.fine("protocolConnect returning false, host=" + str + ", user=" + traceUser(str2) + ", password=" + tracePassword(str3));
            }
            return false;
        }
        boolean booleanProperty2 = PropUtil.getBooleanProperty(properties, "mail." + this.name + ".ehlo", true);
        MailLogger mailLogger2 = this.logger;
        Level level = Level.FINE;
        if (mailLogger2.isLoggable(level)) {
            MailLogger mailLogger3 = this.logger;
            mailLogger3.fine("useEhlo " + booleanProperty2 + ", useAuth " + booleanProperty);
        }
        if (i4 == -1) {
            i4 = PropUtil.getIntProperty(properties, "mail." + this.name + ".port", -1);
        }
        if (i4 == -1) {
            i4 = this.defaultPort;
        }
        str = (str == null || str.length() == 0) ? "localhost" : "localhost";
        if (this.serverSocket != null) {
            openServer();
        } else {
            openServer(str, i4);
        }
        if (booleanProperty2) {
            z3 = ehlo(getLocalHost());
        }
        if (!z3) {
            helo(getLocalHost());
        }
        if (this.useStartTLS || this.requireStartTLS) {
            if (this.serverSocket instanceof SSLSocket) {
                this.logger.fine("STARTTLS requested but already using SSL");
            } else if (supportsExtension("STARTTLS")) {
                startTLS();
                ehlo(getLocalHost());
            } else if (this.requireStartTLS) {
                this.logger.fine("STARTTLS required but not supported");
                throw new MessagingException("STARTTLS is required but host does not support STARTTLS");
            }
        }
        if (this.allowutf8 && !supportsExtension("SMTPUTF8")) {
            this.logger.log(Level.INFO, "mail.mime.allowutf8 set but server doesn't advertise SMTPUTF8 support");
        }
        if ((!booleanProperty && (str2 == null || str3 == null)) || (!supportsExtension("AUTH") && !supportsExtension("AUTH=LOGIN"))) {
            return true;
        }
        if (this.logger.isLoggable(level)) {
            MailLogger mailLogger4 = this.logger;
            mailLogger4.fine("protocolConnect login, host=" + str + ", user=" + traceUser(str2) + ", password=" + tracePassword(str3));
        }
        boolean authenticate = authenticate(str2, str3);
        if (!authenticate) {
            try {
                closeConnection();
            } catch (MessagingException unused) {
            }
        }
        return authenticate;
    }

    /* JADX WARN: Removed duplicated region for block: B:155:0x0195 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void rcptTo() throws javax.mail.MessagingException {
        /*
            Method dump skipped, instructions count: 802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.rcptTo():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int readServerResponse() throws javax.mail.MessagingException {
        /*
            r6 = this;
            java.lang.String r0 = "close failed"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 100
            r1.<init>(r2)
        L9:
            r2 = 0
            com.sun.mail.util.LineInputStream r3 = r6.lineInputStream     // Catch: java.io.IOException -> L79
            java.lang.String r3 = r3.readLine()     // Catch: java.io.IOException -> L79
            r4 = -1
            if (r3 != 0) goto L2d
            java.lang.String r0 = r1.toString()     // Catch: java.io.IOException -> L79
            int r1 = r0.length()     // Catch: java.io.IOException -> L79
            if (r1 != 0) goto L1f
            java.lang.String r0 = "[EOF]"
        L1f:
            r6.lastServerResponse = r0     // Catch: java.io.IOException -> L79
            r6.lastReturnCode = r4     // Catch: java.io.IOException -> L79
            com.sun.mail.util.MailLogger r1 = r6.logger     // Catch: java.io.IOException -> L79
            java.util.logging.Level r3 = java.util.logging.Level.FINE     // Catch: java.io.IOException -> L79
            java.lang.String r5 = "EOF: {0}"
            r1.log(r3, r5, r0)     // Catch: java.io.IOException -> L79
            return r4
        L2d:
            r1.append(r3)     // Catch: java.io.IOException -> L79
            java.lang.String r5 = "\n"
            r1.append(r5)     // Catch: java.io.IOException -> L79
            boolean r3 = r6.isNotLastLine(r3)     // Catch: java.io.IOException -> L79
            if (r3 != 0) goto L9
            java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> L79
            int r3 = r1.length()
            r5 = 3
            if (r3 < r5) goto L68
            java.lang.String r2 = r1.substring(r2, r5)     // Catch: java.lang.StringIndexOutOfBoundsException -> L4f java.lang.NumberFormatException -> L5c
            int r0 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.StringIndexOutOfBoundsException -> L4f java.lang.NumberFormatException -> L5c
            goto L69
        L4f:
            r6.close()     // Catch: javax.mail.MessagingException -> L53
            goto L68
        L53:
            r2 = move-exception
            com.sun.mail.util.MailLogger r3 = r6.logger
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r3.log(r5, r0, r2)
            goto L68
        L5c:
            r6.close()     // Catch: javax.mail.MessagingException -> L60
            goto L68
        L60:
            r2 = move-exception
            com.sun.mail.util.MailLogger r3 = r6.logger
            java.util.logging.Level r5 = java.util.logging.Level.FINE
            r3.log(r5, r0, r2)
        L68:
            r0 = -1
        L69:
            if (r0 != r4) goto L74
            com.sun.mail.util.MailLogger r2 = r6.logger
            java.util.logging.Level r3 = java.util.logging.Level.FINE
            java.lang.String r4 = "bad server response: {0}"
            r2.log(r3, r4, r1)
        L74:
            r6.lastServerResponse = r1
            r6.lastReturnCode = r0
            return r0
        L79:
            r0 = move-exception
            com.sun.mail.util.MailLogger r1 = r6.logger
            java.util.logging.Level r3 = java.util.logging.Level.FINE
            java.lang.String r4 = "exception reading response"
            r1.log(r3, r4, r0)
            java.lang.String r1 = ""
            r6.lastServerResponse = r1
            r6.lastReturnCode = r2
            javax.mail.MessagingException r1 = new javax.mail.MessagingException
            java.lang.String r2 = "Exception reading response"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.smtp.SMTPTransport.readServerResponse():int");
    }

    protected void sendCommand(String str) throws MessagingException {
        sendCommand(toBytes(str));
    }

    @Override // javax.mail.Transport
    public synchronized void sendMessage(Message message, Address[] addressArr) throws MessagingException, SendFailedException {
        String subject;
        boolean z3;
        if (message != null) {
            subject = message.getSubject();
        } else {
            subject = "";
        }
        sendMessageStart(subject);
        checkConnected();
        if (message instanceof MimeMessage) {
            if (addressArr != null && addressArr.length != 0) {
                for (int i4 = 0; i4 < addressArr.length; i4++) {
                    if (!(addressArr[i4] instanceof InternetAddress)) {
                        throw new MessagingException(addressArr[i4] + " is not an InternetAddress");
                    }
                }
                this.message = (MimeMessage) message;
                this.addresses = addressArr;
                this.validUnsentAddr = addressArr;
                expandGroups();
                if (message instanceof SMTPMessage) {
                    z3 = ((SMTPMessage) message).getAllow8bitMIME();
                } else {
                    z3 = false;
                }
                if (!z3) {
                    Properties properties = this.session.getProperties();
                    z3 = PropUtil.getBooleanProperty(properties, "mail." + this.name + ".allow8bitmime", false);
                }
                if (this.logger.isLoggable(Level.FINE)) {
                    MailLogger mailLogger = this.logger;
                    mailLogger.fine("use8bit " + z3);
                }
                if (z3 && supportsExtension("8BITMIME") && convertTo8Bit(this.message)) {
                    try {
                        this.message.saveChanges();
                    } catch (MessagingException unused) {
                    }
                }
                try {
                    mailFrom();
                    rcptTo();
                    if (this.chunkSize > 0 && supportsExtension("CHUNKING")) {
                        this.message.writeTo(bdat(), ignoreList);
                        finishBdat();
                    } else {
                        this.message.writeTo(data(), ignoreList);
                        finishData();
                    }
                    if (!this.sendPartiallyFailed) {
                        this.logger.fine("message successfully delivered to mail server");
                        notifyTransportListeners(1, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                        this.invalidAddr = null;
                        this.validUnsentAddr = null;
                        this.validSentAddr = null;
                        this.addresses = null;
                        this.message = null;
                        this.exception = null;
                        this.sendPartiallyFailed = false;
                        this.notificationDone = false;
                        sendMessageEnd();
                    } else {
                        this.logger.fine("Sending partially failed because of invalid destination addresses");
                        notifyTransportListeners(3, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                        throw new SMTPSendFailedException(".", this.lastReturnCode, this.lastServerResponse, this.exception, this.validSentAddr, this.validUnsentAddr, this.invalidAddr);
                    }
                } catch (IOException e4) {
                    this.logger.log(Level.FINE, "IOException while sending, closing", (Throwable) e4);
                    try {
                        closeConnection();
                    } catch (MessagingException unused2) {
                    }
                    addressesFailed();
                    notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    throw new MessagingException("IOException while sending message", e4);
                } catch (MessagingException e5) {
                    this.logger.log(Level.FINE, "MessagingException while sending", (Throwable) e5);
                    if (e5.getNextException() instanceof IOException) {
                        this.logger.fine("nested IOException, closing");
                        try {
                            closeConnection();
                        } catch (MessagingException unused3) {
                        }
                    }
                    addressesFailed();
                    notifyTransportListeners(2, this.validSentAddr, this.validUnsentAddr, this.invalidAddr, this.message);
                    throw e5;
                }
            } else {
                throw new SendFailedException("No recipient addresses");
            }
        } else {
            this.logger.fine("Can only send RFC822 msgs");
            throw new MessagingException("SMTP can only send RFC822 messages");
        }
    }

    public synchronized void setAuthorizationID(String str) {
        this.authorizationID = str;
    }

    public synchronized void setLocalHost(String str) {
        this.localHostName = str;
    }

    public synchronized void setNTLMDomain(String str) {
        this.ntlmDomain = str;
    }

    public synchronized void setNoopStrict(boolean z3) {
        this.noopStrict = z3;
    }

    public synchronized void setReportSuccess(boolean z3) {
        this.reportSuccess = z3;
    }

    public synchronized void setRequireStartTLS(boolean z3) {
        this.requireStartTLS = z3;
    }

    public synchronized void setSASLEnabled(boolean z3) {
        this.enableSASL = z3;
    }

    public synchronized void setSASLMechanisms(String[] strArr) {
        if (strArr != null) {
            strArr = (String[]) strArr.clone();
        }
        this.saslMechanisms = strArr;
    }

    public synchronized void setSASLRealm(String str) {
        this.saslRealm = str;
    }

    public synchronized void setStartTLS(boolean z3) {
        this.useStartTLS = z3;
    }

    public synchronized void setUseCanonicalHostName(boolean z3) {
        this.useCanonicalHostName = z3;
    }

    public synchronized void setUseRset(boolean z3) {
        this.useRset = z3;
    }

    public synchronized int simpleCommand(String str) throws MessagingException {
        sendCommand(str);
        return readServerResponse();
    }

    protected void startTLS() throws MessagingException {
        issueCommand("STARTTLS", Opcodes.REM_INT_LIT8);
        try {
            Socket socket = this.serverSocket;
            String str = this.host;
            Properties properties = this.session.getProperties();
            this.serverSocket = SocketFetcher.startTLS(socket, str, properties, "mail." + this.name);
            initStreams();
        } catch (IOException e4) {
            closeConnection();
            throw new MessagingException("Could not convert socket to TLS", e4);
        }
    }

    protected boolean supportsAuthentication(String str) {
        String str2;
        Hashtable<String, String> hashtable = this.extMap;
        if (hashtable == null || (str2 = hashtable.get("AUTH")) == null) {
            return false;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str2);
        while (stringTokenizer.hasMoreTokens()) {
            if (stringTokenizer.nextToken().equalsIgnoreCase(str)) {
                return true;
            }
        }
        if (!str.equalsIgnoreCase("LOGIN") || !supportsExtension("AUTH=LOGIN")) {
            return false;
        }
        this.logger.fine("use AUTH=LOGIN hack");
        return true;
    }

    public boolean supportsExtension(String str) {
        Hashtable<String, String> hashtable = this.extMap;
        if (hashtable != null && hashtable.get(str.toUpperCase(Locale.ENGLISH)) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SMTPTransport(Session session, URLName uRLName, String str, boolean z3) {
        super(session, uRLName);
        this.name = "smtp";
        this.defaultPort = 25;
        this.isSSL = false;
        this.sendPartiallyFailed = false;
        this.authenticators = new HashMap();
        this.quitWait = false;
        this.quitOnSessionReject = false;
        this.saslRealm = UNKNOWN;
        this.authorizationID = UNKNOWN;
        this.enableSASL = false;
        this.useCanonicalHostName = false;
        this.saslMechanisms = UNKNOWN_SA;
        this.ntlmDomain = UNKNOWN;
        this.noopStrict = true;
        this.noauthdebug = true;
        Properties properties = session.getProperties();
        MailLogger mailLogger = new MailLogger(getClass(), "DEBUG SMTP", session.getDebug(), session.getDebugOut());
        this.logger = mailLogger;
        this.traceLogger = mailLogger.getSubLogger("protocol", null);
        this.noauthdebug = !PropUtil.getBooleanProperty(properties, "mail.debug.auth", false);
        this.debugusername = PropUtil.getBooleanProperty(properties, "mail.debug.auth.username", true);
        this.debugpassword = PropUtil.getBooleanProperty(properties, "mail.debug.auth.password", false);
        str = uRLName != null ? uRLName.getProtocol() : str;
        this.name = str;
        z3 = z3 ? z3 : PropUtil.getBooleanProperty(properties, "mail." + str + ".ssl.enable", false);
        if (z3) {
            this.defaultPort = 465;
        } else {
            this.defaultPort = 25;
        }
        this.isSSL = z3;
        this.quitWait = PropUtil.getBooleanProperty(properties, "mail." + str + ".quitwait", true);
        this.quitOnSessionReject = PropUtil.getBooleanProperty(properties, "mail." + str + ".quitonsessionreject", false);
        this.reportSuccess = PropUtil.getBooleanProperty(properties, "mail." + str + ".reportsuccess", false);
        this.useStartTLS = PropUtil.getBooleanProperty(properties, "mail." + str + ".starttls.enable", false);
        this.requireStartTLS = PropUtil.getBooleanProperty(properties, "mail." + str + ".starttls.required", false);
        this.useRset = PropUtil.getBooleanProperty(properties, "mail." + str + ".userset", false);
        this.noopStrict = PropUtil.getBooleanProperty(properties, "mail." + str + ".noop.strict", true);
        boolean booleanProperty = PropUtil.getBooleanProperty(properties, "mail." + str + ".sasl.enable", false);
        this.enableSASL = booleanProperty;
        if (booleanProperty) {
            this.logger.config("enable SASL");
        }
        boolean booleanProperty2 = PropUtil.getBooleanProperty(properties, "mail." + str + ".sasl.usecanonicalhostname", false);
        this.useCanonicalHostName = booleanProperty2;
        if (booleanProperty2) {
            this.logger.config("use canonical host name");
        }
        boolean booleanProperty3 = PropUtil.getBooleanProperty(properties, "mail.mime.allowutf8", false);
        this.allowutf8 = booleanProperty3;
        if (booleanProperty3) {
            this.logger.config("allow UTF-8");
        }
        int intProperty = PropUtil.getIntProperty(properties, "mail." + str + ".chunksize", -1);
        this.chunkSize = intProperty;
        if (intProperty > 0 && this.logger.isLoggable(Level.CONFIG)) {
            this.logger.config("chunk size " + this.chunkSize);
        }
        Authenticator[] authenticatorArr = {new LoginAuthenticator(), new PlainAuthenticator(), new DigestMD5Authenticator(), new NtlmAuthenticator(), new OAuth2Authenticator()};
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 5; i4++) {
            this.authenticators.put(authenticatorArr[i4].getMechanism(), authenticatorArr[i4]);
            sb.append(authenticatorArr[i4].getMechanism());
            sb.append(' ');
        }
        this.defaultAuthenticationMechanisms = sb.toString();
    }

    private void sendCommand(byte[] bArr) throws MessagingException {
        try {
            this.serverOutput.write(bArr);
            this.serverOutput.write(CRLF);
            this.serverOutput.flush();
        } catch (IOException e4) {
            throw new MessagingException("Can't send command to SMTP host", e4);
        }
    }

    protected static String xtext(String str, boolean z3) {
        byte[] bytes;
        if (z3) {
            bytes = str.getBytes(StandardCharsets.UTF_8);
        } else {
            bytes = ASCIIUtility.getBytes(str);
        }
        StringBuilder sb = null;
        for (int i4 = 0; i4 < bytes.length; i4++) {
            char c4 = (char) (bytes[i4] & 255);
            if (!z3 && c4 >= 128) {
                throw new IllegalArgumentException("Non-ASCII character in SMTP submitter: " + str);
            }
            if (c4 < '!' || c4 > '~' || c4 == '+' || c4 == '=') {
                if (sb == null) {
                    sb = new StringBuilder(str.length() + 4);
                    sb.append(str.substring(0, i4));
                }
                sb.append(SignatureVisitor.EXTENDS);
                sb.append(hexchar[(c4 & 240) >> 4]);
                sb.append(hexchar[c4 & 15]);
            } else if (sb != null) {
                sb.append(c4);
            }
        }
        return sb != null ? sb.toString() : str;
    }

    /* loaded from: classes6.dex */
    private class ChunkedOutputStream extends OutputStream {
        private final byte[] buf;
        private int count = 0;
        private final OutputStream out;

        public ChunkedOutputStream(OutputStream outputStream, int i4) {
            this.out = outputStream;
            this.buf = new byte[i4];
        }

        private void bdat(byte[] bArr, int i4, int i5, boolean z3) throws IOException {
            if (i5 > 0 || z3) {
                try {
                    if (z3) {
                        SMTPTransport sMTPTransport = SMTPTransport.this;
                        sMTPTransport.sendCommand("BDAT " + i5 + " LAST");
                    } else {
                        SMTPTransport sMTPTransport2 = SMTPTransport.this;
                        sMTPTransport2.sendCommand("BDAT " + i5);
                    }
                    this.out.write(bArr, i4, i5);
                    this.out.flush();
                    if (SMTPTransport.this.readServerResponse() == 250) {
                        return;
                    }
                    throw new IOException(SMTPTransport.this.lastServerResponse);
                } catch (MessagingException e4) {
                    throw new IOException("BDAT write exception", e4);
                }
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            bdat(this.buf, 0, this.count, true);
            this.count = 0;
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            bdat(this.buf, 0, this.count, false);
            this.count = 0;
        }

        @Override // java.io.OutputStream
        public void write(int i4) throws IOException {
            byte[] bArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            this.count = i6;
            bArr[i5] = (byte) i4;
            if (i6 >= bArr.length) {
                flush();
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) throws IOException {
            while (i5 > 0) {
                int min = Math.min(this.buf.length - this.count, i5);
                byte[] bArr2 = this.buf;
                if (min == bArr2.length) {
                    bdat(bArr, i4, min, false);
                } else {
                    System.arraycopy(bArr, i4, bArr2, this.count, min);
                    this.count += min;
                }
                i4 += min;
                i5 -= min;
                if (this.count >= this.buf.length) {
                    flush();
                }
            }
        }
    }

    protected int simpleCommand(byte[] bArr) throws MessagingException {
        sendCommand(bArr);
        return readServerResponse();
    }

    private void sendMessageEnd() {
    }

    private void sendMessageStart(String str) {
    }

    private void openServer() throws MessagingException {
        IOException e4;
        int i4;
        int readServerResponse;
        this.host = UNKNOWN;
        try {
            i4 = this.serverSocket.getPort();
            try {
                this.host = this.serverSocket.getInetAddress().getHostName();
                MailLogger mailLogger = this.logger;
                Level level = Level.FINE;
                if (mailLogger.isLoggable(level)) {
                    MailLogger mailLogger2 = this.logger;
                    mailLogger2.fine("starting protocol to host \"" + this.host + "\", port " + i4);
                }
                initStreams();
                int readServerResponse2 = readServerResponse();
                if (readServerResponse2 != 220) {
                    try {
                        if (this.quitOnSessionReject) {
                            sendCommand("QUIT");
                            if (this.quitWait && (readServerResponse = readServerResponse()) != 221 && readServerResponse != -1 && this.logger.isLoggable(level)) {
                                MailLogger mailLogger3 = this.logger;
                                mailLogger3.fine("QUIT failed with " + readServerResponse);
                            }
                        }
                        this.serverSocket.close();
                        this.serverSocket = null;
                        this.serverOutput = null;
                        this.serverInput = null;
                    } catch (Exception e5) {
                        MailLogger mailLogger4 = this.logger;
                        Level level2 = Level.FINE;
                        if (mailLogger4.isLoggable(level2)) {
                            this.logger.log(level2, "QUIT failed", (Throwable) e5);
                        }
                        this.serverSocket.close();
                        this.serverSocket = null;
                        this.serverOutput = null;
                        this.serverInput = null;
                    }
                    this.lineInputStream = null;
                    if (this.logger.isLoggable(Level.FINE)) {
                        MailLogger mailLogger5 = this.logger;
                        mailLogger5.fine("got bad greeting from host \"" + this.host + "\", port: " + i4 + ", response: " + readServerResponse2);
                    }
                    throw new MessagingException("Got bad greeting from SMTP host: " + this.host + ", port: " + i4 + ", response: " + readServerResponse2);
                } else if (this.logger.isLoggable(level)) {
                    MailLogger mailLogger6 = this.logger;
                    mailLogger6.fine("protocol started to host \"" + this.host + "\", port: " + i4);
                }
            } catch (IOException e6) {
                e4 = e6;
                throw new MessagingException("Could not start protocol to SMTP host: " + this.host + ", port: " + i4, e4);
            }
        } catch (IOException e7) {
            e4 = e7;
            i4 = -1;
        }
    }
}
