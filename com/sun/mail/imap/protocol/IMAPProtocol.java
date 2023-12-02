package com.sun.mail.imap.protocol;

import com.android.dex.DexFormat;
import com.google.common.base.Ascii;
import com.sun.mail.auth.Ntlm;
import com.sun.mail.iap.Argument;
import com.sun.mail.iap.BadCommandException;
import com.sun.mail.iap.ByteArray;
import com.sun.mail.iap.CommandFailedException;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.Literal;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.ACL;
import com.sun.mail.imap.AppendUID;
import com.sun.mail.imap.CopyUID;
import com.sun.mail.imap.ResyncData;
import com.sun.mail.imap.Rights;
import com.sun.mail.imap.SortTerm;
import com.sun.mail.imap.Utility;
import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.MailLogger;
import com.sun.mail.util.PropUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import javax.mail.Flags;
import javax.mail.Quota;
import javax.mail.internet.MimeUtility;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;

/* loaded from: classes6.dex */
public class IMAPProtocol extends Protocol {
    private static final byte[] I = {Ascii.CR, 10};
    private static final FetchItem[] J = new FetchItem[0];
    private static final byte[] K = {68, 79, 78, 69, Ascii.CR, 10};
    protected SearchSequence A;
    protected String[] B;
    protected Set<String> C;
    private String D;
    private SaslAuthenticator E;
    private String F;
    private ByteArray G;
    private volatile String H;

    /* renamed from: s  reason: collision with root package name */
    private boolean f37848s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f37849t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f37850u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f37851v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f37852w;

    /* renamed from: x  reason: collision with root package name */
    private Map<String, String> f37853x;

    /* renamed from: y  reason: collision with root package name */
    private List<String> f37854y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f37855z;

    public IMAPProtocol(String str, String str2, int i4, Properties properties, boolean z3, MailLogger mailLogger) throws IOException, ProtocolException {
        super(str2, i4, properties, "mail." + str, z3, mailLogger);
        this.f37848s = false;
        this.f37849t = false;
        this.f37851v = true;
        try {
            this.D = str;
            this.f37851v = !PropUtil.getBooleanProperty(properties, "mail.debug.auth", false);
            this.f37850u = PropUtil.getBooleanProperty(properties, this.f37606g + ".referralexception", false);
            if (this.f37853x == null) {
                capability();
            }
            if (hasCapability("IMAP4rev1")) {
                this.f37849t = true;
            }
            this.B = r10;
            String[] strArr = {"UTF-8", MimeUtility.mimeCharset(MimeUtility.getDefaultJavaCharset())};
            this.f37848s = true;
        } catch (Throwable th) {
            if (!this.f37848s) {
                disconnect();
            }
            throw th;
        }
    }

    private int[] A(String str, SearchTerm searchTerm, String str2) throws ProtocolException, SearchException, IOException {
        String javaCharset;
        Response[] command;
        SearchSequence y3 = y();
        int[] iArr = null;
        if (str2 == null) {
            javaCharset = null;
        } else {
            javaCharset = MimeUtility.javaCharset(str2);
        }
        Argument generateSequence = y3.generateSequence(searchTerm, javaCharset);
        generateSequence.writeAtom(str);
        if (str2 == null) {
            command = command("SEARCH", generateSequence);
        } else {
            command = command("SEARCH CHARSET " + str2, generateSequence);
        }
        Response response = command[command.length - 1];
        if (response.isOK()) {
            ArrayList arrayList = new ArrayList();
            int length = command.length;
            for (int i4 = 0; i4 < length; i4++) {
                Response response2 = command[i4];
                if (response2 instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) response2;
                    if (iMAPResponse.keyEquals("SEARCH")) {
                        while (true) {
                            int readNumber = iMAPResponse.readNumber();
                            if (readNumber == -1) {
                                break;
                            }
                            arrayList.add(Integer.valueOf(readNumber));
                        }
                        command[i4] = null;
                    }
                }
            }
            int size = arrayList.size();
            iArr = new int[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
            }
        }
        notifyResponseHandlers(command);
        handleResult(response);
        return iArr;
    }

    private CopyUID B(String str, String str2, boolean z3) throws ProtocolException {
        if (hasCapability("MOVE")) {
            if (z3 && !hasCapability("UIDPLUS")) {
                throw new BadCommandException("UIDPLUS not supported");
            }
            Argument argument = new Argument();
            argument.writeAtom(str);
            I(argument, str2);
            Response[] command = command("MOVE", argument);
            notifyResponseHandlers(command);
            handleResult(command[command.length - 1]);
            if (z3) {
                return x(command);
            }
            return null;
        }
        throw new BadCommandException("MOVE not supported");
    }

    private Quota D(Response response) throws ParsingException {
        Quota quota = new Quota(response.readAtomString());
        response.skipSpaces();
        if (response.readByte() == 40) {
            ArrayList arrayList = new ArrayList();
            while (!response.isNextNonSpace(')')) {
                String readAtom = response.readAtom();
                if (readAtom != null) {
                    arrayList.add(new Quota.Resource(readAtom, response.readLong(), response.readLong()));
                }
            }
            quota.resources = (Quota.Resource[]) arrayList.toArray(new Quota.Resource[arrayList.size()]);
            return quota;
        }
        throw new ParsingException("parse error in QUOTA");
    }

    private static Argument E(ResyncData resyncData) {
        Argument argument = new Argument();
        argument.writeAtom("QRESYNC");
        Argument argument2 = new Argument();
        argument2.writeNumber(resyncData.getUIDValidity());
        argument2.writeNumber(resyncData.getModSeq());
        UIDSet[] resyncUIDSet = Utility.getResyncUIDSet(resyncData);
        if (resyncUIDSet != null) {
            argument2.writeString(UIDSet.toString(resyncUIDSet));
        }
        argument.writeArgument(argument2);
        return argument;
    }

    private int[] F(String str, SearchTerm searchTerm) throws ProtocolException, SearchException {
        if (supportsUtf8() || SearchSequence.isAscii(searchTerm)) {
            try {
                return A(str, searchTerm, null);
            } catch (IOException unused) {
            }
        }
        int i4 = 0;
        while (true) {
            String[] strArr = this.B;
            if (i4 < strArr.length) {
                String str2 = strArr[i4];
                if (str2 != null) {
                    try {
                        return A(str, searchTerm, str2);
                    } catch (CommandFailedException unused2) {
                        this.B[i4] = null;
                    } catch (ProtocolException e4) {
                        throw e4;
                    } catch (IOException unused3) {
                    } catch (SearchException e5) {
                        throw e5;
                    }
                }
                i4++;
            } else {
                throw new SearchException("Search failed");
            }
        }
    }

    private void H(String str, Flags flags, boolean z3) throws ProtocolException {
        Response[] command;
        if (z3) {
            command = command("STORE " + str + " +FLAGS " + q(flags), null);
        } else {
            command = command("STORE " + str + " -FLAGS " + q(flags), null);
        }
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
    }

    private void o(Response response) throws IMAPReferralException {
        int indexOf;
        String substring;
        String str;
        String rest = response.getRest();
        if (rest.startsWith("[") && (indexOf = rest.indexOf(32)) > 0 && rest.substring(1, indexOf).equalsIgnoreCase("REFERRAL")) {
            int indexOf2 = rest.indexOf(93);
            if (indexOf2 > 0) {
                substring = rest.substring(indexOf + 1, indexOf2);
                str = rest.substring(indexOf2 + 1).trim();
            } else {
                substring = rest.substring(indexOf + 1);
                str = "";
            }
            if (response.isBYE()) {
                disconnect();
            }
            throw new IMAPReferralException(str, substring);
        }
    }

    private CopyUID p(String str, String str2, boolean z3) throws ProtocolException {
        if (z3 && !hasCapability("UIDPLUS")) {
            throw new BadCommandException("UIDPLUS not supported");
        }
        Argument argument = new Argument();
        argument.writeAtom(str);
        I(argument, str2);
        Response[] command = command("COPY", argument);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        if (z3) {
            return x(command);
        }
        return null;
    }

    private Response[] s(String str, String str2, boolean z3) throws ProtocolException {
        if (z3) {
            return command("UID FETCH " + str + " (" + str2 + ")", null);
        }
        return command("FETCH " + str + " (" + str2 + ")", null);
    }

    private AppendUID w(Response response) {
        byte readByte;
        if (!response.isOK()) {
            return null;
        }
        do {
            readByte = response.readByte();
            if (readByte <= 0) {
                break;
            }
        } while (readByte != 91);
        if (readByte == 0 || !response.readAtom().equalsIgnoreCase("APPENDUID")) {
            return null;
        }
        return new AppendUID(response.readLong(), response.readLong());
    }

    protected void C(Response response) {
        while (true) {
            String readAtom = response.readAtom();
            if (readAtom != null) {
                if (readAtom.length() == 0) {
                    if (response.peekByte() != 93) {
                        response.skipToken();
                    } else {
                        return;
                    }
                } else {
                    this.f37853x.put(readAtom.toUpperCase(Locale.ENGLISH), readAtom);
                    if (readAtom.regionMatches(true, 0, "AUTH=", 0, 5)) {
                        this.f37854y.add(readAtom.substring(5));
                        if (this.f37603d.isLoggable(Level.FINE)) {
                            MailLogger mailLogger = this.f37603d;
                            mailLogger.fine("AUTH: " + readAtom.substring(5));
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    protected void G(Response response) {
        byte readByte;
        do {
            readByte = response.readByte();
            if (readByte <= 0) {
                break;
            }
        } while (readByte != 91);
        if (readByte == 0 || !response.readAtom().equalsIgnoreCase("CAPABILITY")) {
            return;
        }
        this.f37853x = new HashMap(10);
        this.f37854y = new ArrayList(5);
        C(response);
    }

    protected void I(Argument argument, String str) {
        if (this.f37855z) {
            argument.writeString(str, StandardCharsets.UTF_8);
        } else {
            argument.writeString(BASE64MailboxEncoder.encode(str));
        }
    }

    public void append(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        appenduid(str, flags, date, literal, false);
    }

    public AppendUID appenduid(String str, Flags flags, Date date, Literal literal) throws ProtocolException {
        return appenduid(str, flags, date, literal, true);
    }

    public synchronized void authlogin(String str, String str2) throws ProtocolException {
        Response byeResponse;
        boolean z3;
        String str3;
        ArrayList arrayList = new ArrayList();
        if (this.f37851v && j()) {
            this.f37603d.fine("AUTHENTICATE LOGIN command trace suppressed");
            n();
        }
        String str4 = null;
        try {
            z3 = false;
            byeResponse = null;
            str4 = writeCommand("AUTHENTICATE LOGIN", null);
        } catch (Exception e4) {
            byeResponse = Response.byeResponse(e4);
            z3 = true;
        }
        OutputStream g4 = g();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        boolean z4 = true;
        while (!z3) {
            try {
                byeResponse = readResponse();
            } catch (Exception e5) {
                byeResponse = Response.byeResponse(e5);
            }
            if (byeResponse.isContinuation()) {
                if (z4) {
                    str3 = str;
                    z4 = false;
                } else {
                    str3 = str2;
                }
                bASE64EncoderStream.write(str3.getBytes(StandardCharsets.UTF_8));
                bASE64EncoderStream.flush();
                byteArrayOutputStream.write(I);
                g4.write(byteArrayOutputStream.toByteArray());
                g4.flush();
                byteArrayOutputStream.reset();
            } else {
                if ((!byeResponse.isTagged() || !byeResponse.getTag().equals(str4)) && !byeResponse.isBYE()) {
                }
                z3 = true;
            }
            arrayList.add(byeResponse);
        }
        l();
        Response[] responseArr = (Response[]) arrayList.toArray(new Response[arrayList.size()]);
        handleCapabilityResponse(responseArr);
        notifyResponseHandlers(responseArr);
        if (this.f37851v && j()) {
            this.f37603d.fine("AUTHENTICATE LOGIN command result: " + byeResponse);
        }
        z(byeResponse);
        G(byeResponse);
        this.f37852w = true;
    }

    public synchronized void authntlm(String str, String str2, String str3) throws ProtocolException {
        Response byeResponse;
        boolean z3;
        boolean z4;
        String generateType3Msg;
        ArrayList arrayList = new ArrayList();
        int intProperty = PropUtil.getIntProperty(this.f37605f, "mail." + this.D + ".auth.ntlm.flags", 0);
        boolean booleanProperty = PropUtil.getBooleanProperty(this.f37605f, "mail." + this.D + ".auth.ntlm.v2", true);
        Ntlm ntlm = new Ntlm(this.f37605f.getProperty("mail." + this.D + ".auth.ntlm.domain", ""), f(), str2, str3, this.f37603d);
        if (this.f37851v && j()) {
            this.f37603d.fine("AUTHENTICATE NTLM command trace suppressed");
            n();
        }
        String str4 = null;
        try {
            z3 = false;
            str4 = writeCommand("AUTHENTICATE NTLM", null);
            byeResponse = null;
        } catch (Exception e4) {
            byeResponse = Response.byeResponse(e4);
            z3 = true;
        }
        OutputStream g4 = g();
        boolean z5 = true;
        while (!z3) {
            try {
                byeResponse = readResponse();
            } catch (Exception e5) {
                e = e5;
            }
            if (byeResponse.isContinuation()) {
                if (z5) {
                    generateType3Msg = ntlm.generateType1Msg(intProperty, booleanProperty);
                    z4 = false;
                } else {
                    z4 = z5;
                    generateType3Msg = ntlm.generateType3Msg(byeResponse.getRest());
                }
                try {
                    g4.write(generateType3Msg.getBytes(StandardCharsets.UTF_8));
                    g4.write(I);
                    g4.flush();
                    z5 = z4;
                } catch (Exception e6) {
                    e = e6;
                    z5 = z4;
                    byeResponse = Response.byeResponse(e);
                    z3 = true;
                    arrayList.add(byeResponse);
                }
            } else {
                if ((!byeResponse.isTagged() || !byeResponse.getTag().equals(str4)) && !byeResponse.isBYE()) {
                }
                z3 = true;
            }
            arrayList.add(byeResponse);
        }
        l();
        Response[] responseArr = (Response[]) arrayList.toArray(new Response[arrayList.size()]);
        handleCapabilityResponse(responseArr);
        notifyResponseHandlers(responseArr);
        if (this.f37851v && j()) {
            this.f37603d.fine("AUTHENTICATE NTLM command result: " + byeResponse);
        }
        z(byeResponse);
        G(byeResponse);
        this.f37852w = true;
    }

    public synchronized void authoauth2(String str, String str2) throws ProtocolException {
        Response byeResponse;
        boolean z3;
        ArrayList arrayList = new ArrayList();
        if (this.f37851v && j()) {
            this.f37603d.fine("AUTHENTICATE XOAUTH2 command trace suppressed");
            n();
        }
        String str3 = null;
        try {
            Argument argument = new Argument();
            argument.writeAtom("XOAUTH2");
            z3 = false;
            if (hasCapability("SASL-IR")) {
                byte[] encode = BASE64EncoderStream.encode(("user=" + str + "\u0001auth=Bearer " + str2 + "\u0001\u0001").getBytes(StandardCharsets.UTF_8));
                argument.writeAtom(ASCIIUtility.toString(encode, 0, encode.length));
            }
            String writeCommand = writeCommand("AUTHENTICATE", argument);
            byeResponse = null;
            str3 = writeCommand;
        } catch (Exception e4) {
            byeResponse = Response.byeResponse(e4);
            z3 = true;
        }
        OutputStream g4 = g();
        while (!z3) {
            try {
                byeResponse = readResponse();
            } catch (Exception e5) {
                byeResponse = Response.byeResponse(e5);
            }
            if (byeResponse.isContinuation()) {
                g4.write(BASE64EncoderStream.encode(("user=" + str + "\u0001auth=Bearer " + str2 + "\u0001\u0001").getBytes(StandardCharsets.UTF_8)));
                g4.write(I);
                g4.flush();
            } else {
                if ((!byeResponse.isTagged() || !byeResponse.getTag().equals(str3)) && !byeResponse.isBYE()) {
                }
                z3 = true;
            }
            arrayList.add(byeResponse);
        }
        l();
        Response[] responseArr = (Response[]) arrayList.toArray(new Response[arrayList.size()]);
        handleCapabilityResponse(responseArr);
        notifyResponseHandlers(responseArr);
        if (this.f37851v && j()) {
            this.f37603d.fine("AUTHENTICATE XOAUTH2 command result: " + byeResponse);
        }
        z(byeResponse);
        G(byeResponse);
        this.f37852w = true;
    }

    public synchronized void authplain(String str, String str2, String str3) throws ProtocolException {
        Response byeResponse;
        boolean z3;
        String str4;
        ArrayList arrayList = new ArrayList();
        if (this.f37851v && j()) {
            this.f37603d.fine("AUTHENTICATE PLAIN command trace suppressed");
            n();
        }
        String str5 = null;
        try {
            z3 = false;
            byeResponse = null;
            str5 = writeCommand("AUTHENTICATE PLAIN", null);
        } catch (Exception e4) {
            byeResponse = Response.byeResponse(e4);
            z3 = true;
        }
        OutputStream g4 = g();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        while (!z3) {
            try {
                byeResponse = readResponse();
            } catch (Exception e5) {
                byeResponse = Response.byeResponse(e5);
            }
            if (byeResponse.isContinuation()) {
                StringBuilder sb = new StringBuilder();
                if (str == null) {
                    str4 = "";
                } else {
                    str4 = str;
                }
                sb.append(str4);
                sb.append(DexFormat.MAGIC_SUFFIX);
                sb.append(str2);
                sb.append(DexFormat.MAGIC_SUFFIX);
                sb.append(str3);
                bASE64EncoderStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
                bASE64EncoderStream.flush();
                byteArrayOutputStream.write(I);
                g4.write(byteArrayOutputStream.toByteArray());
                g4.flush();
                byteArrayOutputStream.reset();
            } else {
                if ((!byeResponse.isTagged() || !byeResponse.getTag().equals(str5)) && !byeResponse.isBYE()) {
                }
                z3 = true;
            }
            arrayList.add(byeResponse);
        }
        l();
        Response[] responseArr = (Response[]) arrayList.toArray(new Response[arrayList.size()]);
        handleCapabilityResponse(responseArr);
        notifyResponseHandlers(responseArr);
        if (this.f37851v && j()) {
            this.f37603d.fine("AUTHENTICATE PLAIN command result: " + byeResponse);
        }
        z(byeResponse);
        G(byeResponse);
        this.f37852w = true;
    }

    public void capability() throws ProtocolException {
        Response[] command = command("CAPABILITY", null);
        Response response = command[command.length - 1];
        if (response.isOK()) {
            handleCapabilityResponse(command);
        }
        handleResult(response);
    }

    public void check() throws ProtocolException {
        simpleCommand("CHECK", null);
    }

    public void close() throws ProtocolException {
        simpleCommand("CLOSE", null);
    }

    public void compress() throws ProtocolException {
        try {
            super.startCompression("COMPRESS DEFLATE");
        } catch (ProtocolException e4) {
            this.f37603d.log(Level.FINE, "COMPRESS ProtocolException", (Throwable) e4);
            throw e4;
        } catch (Exception e5) {
            this.f37603d.log(Level.FINE, "COMPRESS Exception", (Throwable) e5);
            notifyResponseHandlers(new Response[]{Response.byeResponse(e5)});
            disconnect();
            throw new ProtocolException("COMPRESS failure", e5);
        }
    }

    public void copy(MessageSet[] messageSetArr, String str) throws ProtocolException {
        p(MessageSet.toString(messageSetArr), str, false);
    }

    public CopyUID copyuid(MessageSet[] messageSetArr, String str) throws ProtocolException {
        return p(MessageSet.toString(messageSetArr), str, true);
    }

    public void create(String str) throws ProtocolException {
        Argument argument = new Argument();
        I(argument, str);
        simpleCommand("CREATE", argument);
    }

    public void delete(String str) throws ProtocolException {
        Argument argument = new Argument();
        I(argument, str);
        simpleCommand("DELETE", argument);
    }

    public void deleteACL(String str, String str2) throws ProtocolException {
        if (hasCapability("ACL")) {
            Argument argument = new Argument();
            I(argument, str);
            argument.writeString(str2);
            Response[] command = command("DELETEACL", argument);
            Response response = command[command.length - 1];
            notifyResponseHandlers(command);
            handleResult(response);
            return;
        }
        throw new BadCommandException("ACL not supported");
    }

    @Override // com.sun.mail.iap.Protocol
    public void disconnect() {
        super.disconnect();
        this.f37852w = false;
    }

    public void enable(String str) throws ProtocolException {
        if (hasCapability("ENABLE")) {
            Argument argument = new Argument();
            argument.writeAtom(str);
            simpleCommand("ENABLE", argument);
            if (this.C == null) {
                this.C = new HashSet();
            }
            this.C.add(str.toUpperCase(Locale.ENGLISH));
            this.f37855z = isEnabled("UTF8=ACCEPT");
            return;
        }
        throw new BadCommandException("ENABLE not supported");
    }

    public MailboxInfo examine(String str) throws ProtocolException {
        return examine(str, null);
    }

    public void expunge() throws ProtocolException {
        simpleCommand("EXPUNGE", null);
    }

    public Response[] fetch(MessageSet[] messageSetArr, String str) throws ProtocolException {
        return s(MessageSet.toString(messageSetArr), str, false);
    }

    public BODY fetchBody(int i4, String str) throws ProtocolException {
        return u(i4, str, false);
    }

    public BODYSTRUCTURE fetchBodyStructure(int i4) throws ProtocolException {
        Response[] fetch = fetch(i4, "BODYSTRUCTURE");
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (BODYSTRUCTURE) FetchResponse.getItem(fetch, i4, BODYSTRUCTURE.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public Flags fetchFlags(int i4) throws ProtocolException {
        Response[] fetch = fetch(i4, "FLAGS");
        int length = fetch.length;
        int i5 = 0;
        Flags flags = null;
        while (true) {
            if (i5 < length) {
                Response response = fetch[i5];
                if (response != null && (response instanceof FetchResponse) && ((FetchResponse) response).getNumber() == i4 && (flags = (Flags) ((FetchResponse) fetch[i5]).getItem(FLAGS.class)) != null) {
                    fetch[i5] = null;
                    break;
                }
                i5++;
            } else {
                break;
            }
        }
        notifyResponseHandlers(fetch);
        handleResult(fetch[fetch.length - 1]);
        return flags;
    }

    public MODSEQ fetchMODSEQ(int i4) throws ProtocolException {
        Response[] fetch = fetch(i4, "MODSEQ");
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (MODSEQ) FetchResponse.getItem(fetch, i4, MODSEQ.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public RFC822DATA fetchRFC822(int i4, String str) throws ProtocolException {
        String str2;
        if (str == null) {
            str2 = "RFC822";
        } else {
            str2 = "RFC822." + str;
        }
        Response[] fetch = fetch(i4, str2);
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (RFC822DATA) FetchResponse.getItem(fetch, i4, RFC822DATA.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public void fetchSequenceNumber(long j4) throws ProtocolException {
        Response[] s3 = s(String.valueOf(j4), "UID", true);
        notifyResponseHandlers(s3);
        handleResult(s3[s3.length - 1]);
    }

    public long[] fetchSequenceNumbers(long j4, long j5) throws ProtocolException {
        UID uid;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(j4));
        sb.append(":");
        sb.append(j5 == -1 ? "*" : String.valueOf(j5));
        Response[] s3 = s(sb.toString(), "UID", true);
        ArrayList arrayList = new ArrayList();
        for (Response response : s3) {
            if (response != null && (response instanceof FetchResponse) && (uid = (UID) ((FetchResponse) response).getItem(UID.class)) != null) {
                arrayList.add(uid);
            }
        }
        notifyResponseHandlers(s3);
        handleResult(s3[s3.length - 1]);
        long[] jArr = new long[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            jArr[i4] = ((UID) arrayList.get(i4)).uid;
        }
        return jArr;
    }

    public UID fetchUID(int i4) throws ProtocolException {
        Response[] fetch = fetch(i4, "UID");
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            return (UID) FetchResponse.getItem(fetch, i4, UID.class);
        }
        if (response.isNO()) {
            return null;
        }
        handleResult(response);
        return null;
    }

    public ACL[] getACL(String str) throws ProtocolException {
        String readAtomString;
        if (hasCapability("ACL")) {
            Argument argument = new Argument();
            I(argument, str);
            Response[] command = command("GETACL", argument);
            Response response = command[command.length - 1];
            ArrayList arrayList = new ArrayList();
            if (response.isOK()) {
                int length = command.length;
                for (int i4 = 0; i4 < length; i4++) {
                    Response response2 = command[i4];
                    if (response2 instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) response2;
                        if (iMAPResponse.keyEquals("ACL")) {
                            iMAPResponse.readAtomString();
                            while (true) {
                                String readAtomString2 = iMAPResponse.readAtomString();
                                if (readAtomString2 == null || (readAtomString = iMAPResponse.readAtomString()) == null) {
                                    break;
                                }
                                arrayList.add(new ACL(readAtomString2, new Rights(readAtomString)));
                            }
                            command[i4] = null;
                        }
                    }
                }
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return (ACL[]) arrayList.toArray(new ACL[arrayList.size()]);
        }
        throw new BadCommandException("ACL not supported");
    }

    public Map<String, String> getCapabilities() {
        return this.f37853x;
    }

    public FetchItem[] getFetchItems() {
        return J;
    }

    public String getProxyAuthUser() {
        return this.F;
    }

    public Quota[] getQuota(String str) throws ProtocolException {
        if (hasCapability("QUOTA")) {
            Argument argument = new Argument();
            argument.writeString(str);
            Response[] command = command("GETQUOTA", argument);
            ArrayList arrayList = new ArrayList();
            Response response = command[command.length - 1];
            if (response.isOK()) {
                int length = command.length;
                for (int i4 = 0; i4 < length; i4++) {
                    Response response2 = command[i4];
                    if (response2 instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) response2;
                        if (iMAPResponse.keyEquals("QUOTA")) {
                            arrayList.add(D(iMAPResponse));
                            command[i4] = null;
                        }
                    }
                }
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return (Quota[]) arrayList.toArray(new Quota[arrayList.size()]);
        }
        throw new BadCommandException("QUOTA not supported");
    }

    public Quota[] getQuotaRoot(String str) throws ProtocolException {
        Quota.Resource[] resourceArr;
        if (hasCapability("QUOTA")) {
            Argument argument = new Argument();
            I(argument, str);
            Response[] command = command("GETQUOTAROOT", argument);
            Response response = command[command.length - 1];
            HashMap hashMap = new HashMap();
            if (response.isOK()) {
                int length = command.length;
                for (int i4 = 0; i4 < length; i4++) {
                    Response response2 = command[i4];
                    if (response2 instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) response2;
                        if (iMAPResponse.keyEquals("QUOTAROOT")) {
                            iMAPResponse.readAtomString();
                            while (true) {
                                String readAtomString = iMAPResponse.readAtomString();
                                if (readAtomString == null || readAtomString.length() <= 0) {
                                    break;
                                }
                                hashMap.put(readAtomString, new Quota(readAtomString));
                            }
                            command[i4] = null;
                        } else if (iMAPResponse.keyEquals("QUOTA")) {
                            Quota D = D(iMAPResponse);
                            Quota quota = (Quota) hashMap.get(D.quotaRoot);
                            if (quota != null && (resourceArr = quota.resources) != null) {
                                Quota.Resource[] resourceArr2 = new Quota.Resource[resourceArr.length + D.resources.length];
                                System.arraycopy(resourceArr, 0, resourceArr2, 0, resourceArr.length);
                                Quota.Resource[] resourceArr3 = D.resources;
                                System.arraycopy(resourceArr3, 0, resourceArr2, quota.resources.length, resourceArr3.length);
                                D.resources = resourceArr2;
                            }
                            hashMap.put(D.quotaRoot, D);
                            command[i4] = null;
                        }
                    }
                }
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return (Quota[]) hashMap.values().toArray(new Quota[hashMap.size()]);
        }
        throw new BadCommandException("GETQUOTAROOT not supported");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sun.mail.iap.Protocol
    public ByteArray h() {
        ByteArray byteArray = this.G;
        this.G = null;
        return byteArray;
    }

    public void handleCapabilityResponse(Response[] responseArr) {
        boolean z3 = true;
        for (Response response : responseArr) {
            if (response instanceof IMAPResponse) {
                IMAPResponse iMAPResponse = (IMAPResponse) response;
                if (iMAPResponse.keyEquals("CAPABILITY")) {
                    if (z3) {
                        this.f37853x = new HashMap(10);
                        this.f37854y = new ArrayList(5);
                        z3 = false;
                    }
                    C(iMAPResponse);
                }
            }
        }
    }

    public boolean hasCapability(String str) {
        if (str.endsWith("*")) {
            String upperCase = str.substring(0, str.length() - 1).toUpperCase(Locale.ENGLISH);
            for (String str2 : this.f37853x.keySet()) {
                if (str2.startsWith(upperCase)) {
                    return true;
                }
            }
            return false;
        }
        return this.f37853x.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    @Deprecated
    public void id(String str) throws ProtocolException {
        HashMap hashMap = new HashMap();
        hashMap.put("GUID", str);
        id(hashMap);
    }

    public void idleAbort() {
        OutputStream g4 = g();
        try {
            g4.write(K);
            g4.flush();
        } catch (Exception e4) {
            this.f37603d.log(Level.FINEST, "Exception aborting IDLE", (Throwable) e4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x002e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x002b -> B:14:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void idleStart() throws com.sun.mail.iap.ProtocolException {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "IDLE"
            boolean r0 = r5.hasCapability(r0)     // Catch: java.lang.Throwable -> L70
            if (r0 == 0) goto L68
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L70
            r0.<init>()     // Catch: java.lang.Throwable -> L70
            r1 = 1
            java.lang.String r2 = "IDLE"
            r3 = 0
            java.lang.String r2 = r5.writeCommand(r2, r3)     // Catch: java.lang.Exception -> L1a com.sun.mail.iap.LiteralException -> L23 java.lang.Throwable -> L70
            r5.H = r2     // Catch: java.lang.Exception -> L1a com.sun.mail.iap.LiteralException -> L23 java.lang.Throwable -> L70
            r2 = 0
            goto L2c
        L1a:
            r2 = move-exception
            com.sun.mail.iap.Response r2 = com.sun.mail.iap.Response.byeResponse(r2)     // Catch: java.lang.Throwable -> L70
            r0.add(r2)     // Catch: java.lang.Throwable -> L70
            goto L2b
        L23:
            r2 = move-exception
            com.sun.mail.iap.Response r2 = r2.getResponse()     // Catch: java.lang.Throwable -> L70
            r0.add(r2)     // Catch: java.lang.Throwable -> L70
        L2b:
            r2 = 1
        L2c:
            if (r2 != 0) goto L4a
            com.sun.mail.iap.Response r3 = r5.readResponse()     // Catch: com.sun.mail.iap.ProtocolException -> L33 java.io.IOException -> L35 java.lang.Throwable -> L70
            goto L3a
        L33:
            goto L2c
        L35:
            r3 = move-exception
            com.sun.mail.iap.Response r3 = com.sun.mail.iap.Response.byeResponse(r3)     // Catch: java.lang.Throwable -> L70
        L3a:
            r0.add(r3)     // Catch: java.lang.Throwable -> L70
            boolean r4 = r3.isContinuation()     // Catch: java.lang.Throwable -> L70
            if (r4 != 0) goto L2b
            boolean r3 = r3.isBYE()     // Catch: java.lang.Throwable -> L70
            if (r3 == 0) goto L2c
            goto L2b
        L4a:
            int r2 = r0.size()     // Catch: java.lang.Throwable -> L70
            com.sun.mail.iap.Response[] r2 = new com.sun.mail.iap.Response[r2]     // Catch: java.lang.Throwable -> L70
            java.lang.Object[] r0 = r0.toArray(r2)     // Catch: java.lang.Throwable -> L70
            com.sun.mail.iap.Response[] r0 = (com.sun.mail.iap.Response[]) r0     // Catch: java.lang.Throwable -> L70
            int r2 = r0.length     // Catch: java.lang.Throwable -> L70
            int r2 = r2 - r1
            r1 = r0[r2]     // Catch: java.lang.Throwable -> L70
            r5.notifyResponseHandlers(r0)     // Catch: java.lang.Throwable -> L70
            boolean r0 = r1.isContinuation()     // Catch: java.lang.Throwable -> L70
            if (r0 != 0) goto L66
            r5.handleResult(r1)     // Catch: java.lang.Throwable -> L70
        L66:
            monitor-exit(r5)
            return
        L68:
            com.sun.mail.iap.BadCommandException r0 = new com.sun.mail.iap.BadCommandException     // Catch: java.lang.Throwable -> L70
            java.lang.String r1 = "IDLE not supported"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L70
            throw r0     // Catch: java.lang.Throwable -> L70
        L70:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.IMAPProtocol.idleStart():void");
    }

    public boolean isAuthenticated() {
        return this.f37852w;
    }

    public boolean isEnabled(String str) {
        Set<String> set = this.C;
        if (set == null) {
            return false;
        }
        return set.contains(str.toUpperCase(Locale.ENGLISH));
    }

    public boolean isREV1() {
        return this.f37849t;
    }

    @Override // com.sun.mail.iap.Protocol
    protected void k(Response response) throws ProtocolException {
        if (!response.isBYE()) {
            if (response.isOK()) {
                Properties properties = this.f37605f;
                boolean booleanProperty = PropUtil.getBooleanProperty(properties, this.f37606g + ".referralexception", false);
                this.f37850u = booleanProperty;
                if (booleanProperty) {
                    o(response);
                }
                G(response);
                return;
            } else if (((IMAPResponse) response).keyEquals("PREAUTH")) {
                this.f37852w = true;
                G(response);
                return;
            } else {
                disconnect();
                throw new ConnectionException(this, response);
            }
        }
        o(response);
        throw new ConnectionException(this, response);
    }

    public ListInfo[] list(String str, String str2) throws ProtocolException {
        return r("LIST", str, str2);
    }

    public Rights[] listRights(String str, String str2) throws ProtocolException {
        if (hasCapability("ACL")) {
            Argument argument = new Argument();
            I(argument, str);
            argument.writeString(str2);
            Response[] command = command("LISTRIGHTS", argument);
            Response response = command[command.length - 1];
            ArrayList arrayList = new ArrayList();
            if (response.isOK()) {
                int length = command.length;
                for (int i4 = 0; i4 < length; i4++) {
                    Response response2 = command[i4];
                    if (response2 instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) response2;
                        if (iMAPResponse.keyEquals("LISTRIGHTS")) {
                            iMAPResponse.readAtomString();
                            iMAPResponse.readAtomString();
                            while (true) {
                                String readAtomString = iMAPResponse.readAtomString();
                                if (readAtomString == null) {
                                    break;
                                }
                                arrayList.add(new Rights(readAtomString));
                            }
                            command[i4] = null;
                        }
                    }
                }
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return (Rights[]) arrayList.toArray(new Rights[arrayList.size()]);
        }
        throw new BadCommandException("ACL not supported");
    }

    public void login(String str, String str2) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(str);
        argument.writeString(str2);
        try {
            if (this.f37851v && j()) {
                this.f37603d.fine("LOGIN command trace suppressed");
                n();
            }
            Response[] command = command("LOGIN", argument);
            l();
            handleCapabilityResponse(command);
            notifyResponseHandlers(command);
            if (this.f37851v && j()) {
                MailLogger mailLogger = this.f37603d;
                mailLogger.fine("LOGIN command result: " + command[command.length - 1]);
            }
            z(command[command.length - 1]);
            G(command[command.length - 1]);
            this.f37852w = true;
        } catch (Throwable th) {
            l();
            throw th;
        }
    }

    public void logout() throws ProtocolException {
        try {
            Response[] command = command("LOGOUT", null);
            this.f37852w = false;
            notifyResponseHandlers(command);
        } finally {
            disconnect();
        }
    }

    public ListInfo[] lsub(String str, String str2) throws ProtocolException {
        return r("LSUB", str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sun.mail.iap.Protocol
    public boolean m() {
        return hasCapability("LITERAL+");
    }

    public void move(MessageSet[] messageSetArr, String str) throws ProtocolException {
        B(MessageSet.toString(messageSetArr), str, false);
    }

    public CopyUID moveuid(MessageSet[] messageSetArr, String str) throws ProtocolException {
        return B(MessageSet.toString(messageSetArr), str, true);
    }

    public Rights myRights(String str) throws ProtocolException {
        if (hasCapability("ACL")) {
            Argument argument = new Argument();
            I(argument, str);
            Response[] command = command("MYRIGHTS", argument);
            Response response = command[command.length - 1];
            Rights rights = null;
            if (response.isOK()) {
                int length = command.length;
                Rights rights2 = null;
                for (int i4 = 0; i4 < length; i4++) {
                    Response response2 = command[i4];
                    if (response2 instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) response2;
                        if (iMAPResponse.keyEquals("MYRIGHTS")) {
                            iMAPResponse.readAtomString();
                            String readAtomString = iMAPResponse.readAtomString();
                            if (rights2 == null) {
                                rights2 = new Rights(readAtomString);
                            }
                            command[i4] = null;
                        }
                    }
                }
                rights = rights2;
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return rights;
        }
        throw new BadCommandException("ACL not supported");
    }

    public Namespaces namespace() throws ProtocolException {
        if (hasCapability("NAMESPACE")) {
            Namespaces namespaces = null;
            Response[] command = command("NAMESPACE", null);
            Response response = command[command.length - 1];
            if (response.isOK()) {
                int length = command.length;
                Namespaces namespaces2 = null;
                for (int i4 = 0; i4 < length; i4++) {
                    Response response2 = command[i4];
                    if (response2 instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) response2;
                        if (iMAPResponse.keyEquals("NAMESPACE")) {
                            if (namespaces2 == null) {
                                namespaces2 = new Namespaces(iMAPResponse);
                            }
                            command[i4] = null;
                        }
                    }
                }
                namespaces = namespaces2;
            }
            notifyResponseHandlers(command);
            handleResult(response);
            return namespaces;
        }
        throw new BadCommandException("NAMESPACE not supported");
    }

    public void noop() throws ProtocolException {
        this.f37603d.fine("IMAPProtocol noop");
        simpleCommand("NOOP", null);
    }

    public BODY peekBody(int i4, String str) throws ProtocolException {
        return u(i4, str, true);
    }

    public boolean processIdleResponse(Response response) throws ProtocolException {
        notifyResponseHandlers(new Response[]{response});
        boolean isBYE = response.isBYE();
        if (response.isTagged() && response.getTag().equals(this.H)) {
            isBYE = true;
        }
        if (isBYE) {
            this.H = null;
        }
        handleResult(response);
        return !isBYE;
    }

    public void proxyauth(String str) throws ProtocolException {
        Argument argument = new Argument();
        argument.writeString(str);
        simpleCommand("PROXYAUTH", argument);
        this.F = str;
    }

    protected String q(Flags flags) {
        Flags.Flag[] systemFlags;
        String str;
        StringBuilder sb = new StringBuilder("(");
        boolean z3 = true;
        for (Flags.Flag flag : flags.getSystemFlags()) {
            if (flag == Flags.Flag.ANSWERED) {
                str = "\\Answered";
            } else if (flag == Flags.Flag.DELETED) {
                str = "\\Deleted";
            } else if (flag == Flags.Flag.DRAFT) {
                str = "\\Draft";
            } else if (flag == Flags.Flag.FLAGGED) {
                str = "\\Flagged";
            } else if (flag == Flags.Flag.RECENT) {
                str = "\\Recent";
            } else if (flag == Flags.Flag.SEEN) {
                str = "\\Seen";
            }
            if (z3) {
                z3 = false;
            } else {
                sb.append(' ');
            }
            sb.append(str);
        }
        for (String str2 : flags.getUserFlags()) {
            if (z3) {
                z3 = false;
            } else {
                sb.append(' ');
            }
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    protected ListInfo[] r(String str, String str2, String str3) throws ProtocolException {
        Argument argument = new Argument();
        I(argument, str2);
        I(argument, str3);
        Response[] command = command(str, argument);
        Response response = command[command.length - 1];
        ListInfo[] listInfoArr = null;
        if (response.isOK()) {
            ArrayList arrayList = new ArrayList(1);
            int length = command.length;
            for (int i4 = 0; i4 < length; i4++) {
                Response response2 = command[i4];
                if (response2 instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) response2;
                    if (iMAPResponse.keyEquals(str)) {
                        arrayList.add(new ListInfo(iMAPResponse));
                        command[i4] = null;
                    }
                }
            }
            if (arrayList.size() > 0) {
                listInfoArr = (ListInfo[]) arrayList.toArray(new ListInfo[arrayList.size()]);
            }
        }
        notifyResponseHandlers(command);
        handleResult(response);
        return listInfoArr;
    }

    public synchronized Response readIdleResponse() {
        Response byeResponse;
        if (this.H == null) {
            return null;
        }
        try {
            byeResponse = readResponse();
        } catch (ProtocolException e4) {
            byeResponse = Response.byeResponse(e4);
        } catch (IOException e5) {
            byeResponse = Response.byeResponse(e5);
        }
        return byeResponse;
    }

    @Override // com.sun.mail.iap.Protocol
    public Response readResponse() throws IOException, ProtocolException {
        IMAPResponse iMAPResponse = new IMAPResponse(this);
        if (iMAPResponse.keyEquals("FETCH")) {
            return new FetchResponse(iMAPResponse, getFetchItems());
        }
        return iMAPResponse;
    }

    public void rename(String str, String str2) throws ProtocolException {
        Argument argument = new Argument();
        I(argument, str);
        I(argument, str2);
        simpleCommand("RENAME", argument);
    }

    public void sasllogin(String[] strArr, String str, String str2, String str3, String str4) throws ProtocolException {
        String str5;
        List list;
        Properties properties = this.f37605f;
        if (PropUtil.getBooleanProperty(properties, "mail." + this.D + ".sasl.usecanonicalhostname", false)) {
            str5 = getInetAddress().getCanonicalHostName();
        } else {
            str5 = this.f37600a;
        }
        if (this.E == null) {
            try {
                this.E = (SaslAuthenticator) Class.forName("com.sun.mail.imap.protocol.IMAPSaslAuthenticator").getConstructor(IMAPProtocol.class, String.class, Properties.class, MailLogger.class, String.class).newInstance(this, this.D, this.f37605f, this.f37603d, str5);
            } catch (Exception e4) {
                this.f37603d.log(Level.FINE, "Can't load SASL authenticator", (Throwable) e4);
                return;
            }
        }
        if (strArr != null && strArr.length > 0) {
            list = new ArrayList(strArr.length);
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (this.f37854y.contains(strArr[i4])) {
                    list.add(strArr[i4]);
                }
            }
        } else {
            list = this.f37854y;
        }
        String[] strArr2 = (String[]) list.toArray(new String[list.size()]);
        try {
            if (this.f37851v && j()) {
                this.f37603d.fine("SASL authentication command trace suppressed");
                n();
            }
            if (this.E.authenticate(strArr2, str, str2, str3, str4)) {
                if (this.f37851v && j()) {
                    this.f37603d.fine("SASL authentication succeeded");
                }
                this.f37852w = true;
            } else if (this.f37851v && j()) {
                this.f37603d.fine("SASL authentication failed");
            }
        } finally {
            l();
        }
    }

    public int[] search(MessageSet[] messageSetArr, SearchTerm searchTerm) throws ProtocolException, SearchException {
        return F(MessageSet.toString(messageSetArr), searchTerm);
    }

    public MailboxInfo select(String str) throws ProtocolException {
        return select(str, null);
    }

    public void setACL(String str, char c4, ACL acl) throws ProtocolException {
        if (hasCapability("ACL")) {
            Argument argument = new Argument();
            I(argument, str);
            argument.writeString(acl.getName());
            String rights = acl.getRights().toString();
            if (c4 == '+' || c4 == '-') {
                rights = c4 + rights;
            }
            argument.writeString(rights);
            Response[] command = command("SETACL", argument);
            Response response = command[command.length - 1];
            notifyResponseHandlers(command);
            handleResult(response);
            return;
        }
        throw new BadCommandException("ACL not supported");
    }

    public void setQuota(Quota quota) throws ProtocolException {
        if (hasCapability("QUOTA")) {
            Argument argument = new Argument();
            argument.writeString(quota.quotaRoot);
            Argument argument2 = new Argument();
            if (quota.resources != null) {
                int i4 = 0;
                while (true) {
                    Quota.Resource[] resourceArr = quota.resources;
                    if (i4 >= resourceArr.length) {
                        break;
                    }
                    argument2.writeAtom(resourceArr[i4].name);
                    argument2.writeNumber(quota.resources[i4].limit);
                    i4++;
                }
            }
            argument.writeArgument(argument2);
            Response[] command = command("SETQUOTA", argument);
            Response response = command[command.length - 1];
            notifyResponseHandlers(command);
            handleResult(response);
            return;
        }
        throw new BadCommandException("QUOTA not supported");
    }

    public int[] sort(SortTerm[] sortTermArr, SearchTerm searchTerm) throws ProtocolException, SearchException {
        if (hasCapability("SORT*")) {
            if (sortTermArr != null && sortTermArr.length != 0) {
                Argument argument = new Argument();
                Argument argument2 = new Argument();
                for (SortTerm sortTerm : sortTermArr) {
                    argument2.writeAtom(sortTerm.toString());
                }
                argument.writeArgument(argument2);
                argument.writeAtom("UTF-8");
                if (searchTerm != null) {
                    try {
                        argument.append(y().generateSequence(searchTerm, "UTF-8"));
                    } catch (IOException e4) {
                        throw new SearchException(e4.toString());
                    }
                } else {
                    argument.writeAtom("ALL");
                }
                Response[] command = command("SORT", argument);
                Response response = command[command.length - 1];
                int[] iArr = null;
                if (response.isOK()) {
                    ArrayList arrayList = new ArrayList();
                    int length = command.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        Response response2 = command[i4];
                        if (response2 instanceof IMAPResponse) {
                            IMAPResponse iMAPResponse = (IMAPResponse) response2;
                            if (iMAPResponse.keyEquals("SORT")) {
                                while (true) {
                                    int readNumber = iMAPResponse.readNumber();
                                    if (readNumber == -1) {
                                        break;
                                    }
                                    arrayList.add(Integer.valueOf(readNumber));
                                }
                                command[i4] = null;
                            }
                        }
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i5 = 0; i5 < size; i5++) {
                        iArr[i5] = ((Integer) arrayList.get(i5)).intValue();
                    }
                }
                notifyResponseHandlers(command);
                handleResult(response);
                return iArr;
            }
            throw new BadCommandException("Must have at least one sort term");
        }
        throw new BadCommandException("SORT not supported");
    }

    public void startTLS() throws ProtocolException {
        try {
            super.startTLS("STARTTLS");
        } catch (ProtocolException e4) {
            this.f37603d.log(Level.FINE, "STARTTLS ProtocolException", (Throwable) e4);
            throw e4;
        } catch (Exception e5) {
            this.f37603d.log(Level.FINE, "STARTTLS Exception", (Throwable) e5);
            notifyResponseHandlers(new Response[]{Response.byeResponse(e5)});
            disconnect();
            throw new ProtocolException("STARTTLS failure", e5);
        }
    }

    public Status status(String str, String[] strArr) throws ProtocolException {
        if (!isREV1() && !hasCapability("IMAP4SUNVERSION")) {
            throw new BadCommandException("STATUS not supported");
        }
        Argument argument = new Argument();
        I(argument, str);
        Argument argument2 = new Argument();
        if (strArr == null) {
            strArr = Status.f37871a;
        }
        for (String str2 : strArr) {
            argument2.writeAtom(str2);
        }
        argument.writeArgument(argument2);
        Response[] command = command("STATUS", argument);
        Response response = command[command.length - 1];
        Status status = null;
        if (response.isOK()) {
            int length = command.length;
            Status status2 = null;
            for (int i4 = 0; i4 < length; i4++) {
                Response response2 = command[i4];
                if (response2 instanceof IMAPResponse) {
                    IMAPResponse iMAPResponse = (IMAPResponse) response2;
                    if (iMAPResponse.keyEquals("STATUS")) {
                        if (status2 == null) {
                            status2 = new Status(iMAPResponse);
                        } else {
                            Status.add(status2, new Status(iMAPResponse));
                        }
                        command[i4] = null;
                    }
                }
            }
            status = status2;
        }
        notifyResponseHandlers(command);
        handleResult(response);
        return status;
    }

    public void storeFlags(MessageSet[] messageSetArr, Flags flags, boolean z3) throws ProtocolException {
        H(MessageSet.toString(messageSetArr), flags, z3);
    }

    public void subscribe(String str) throws ProtocolException {
        Argument argument = new Argument();
        I(argument, str);
        simpleCommand("SUBSCRIBE", argument);
    }

    @Override // com.sun.mail.iap.Protocol
    public boolean supportsUtf8() {
        return this.f37855z;
    }

    protected BODY t(int i4, String str, int i5, int i6, boolean z3, ByteArray byteArray) throws ProtocolException {
        String str2;
        this.G = byteArray;
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (z3) {
            str2 = "BODY.PEEK[";
        } else {
            str2 = "BODY[";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("]<");
        sb.append(String.valueOf(i5));
        sb.append(".");
        sb.append(String.valueOf(i6));
        sb.append(">");
        return v(i4, str, sb.toString());
    }

    protected BODY u(int i4, String str, boolean z3) throws ProtocolException {
        String str2;
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (z3) {
            str2 = "BODY.PEEK[";
        } else {
            str2 = "BODY[";
        }
        sb.append(str2);
        sb.append(str);
        sb.append("]");
        return v(i4, str, sb.toString());
    }

    public void uidexpunge(UIDSet[] uIDSetArr) throws ProtocolException {
        if (hasCapability("UIDPLUS")) {
            simpleCommand("UID EXPUNGE " + UIDSet.toString(uIDSetArr), null);
            return;
        }
        throw new BadCommandException("UID EXPUNGE not supported");
    }

    public int[] uidfetchChangedSince(long j4, long j5, long j6) throws ProtocolException {
        String valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(j4));
        sb.append(":");
        if (j5 == -1) {
            valueOf = "*";
        } else {
            valueOf = String.valueOf(j5);
        }
        sb.append(valueOf);
        Response[] command = command("UID FETCH " + sb.toString() + " (FLAGS) (CHANGEDSINCE " + String.valueOf(j6) + ")", null);
        ArrayList arrayList = new ArrayList();
        for (Response response : command) {
            if (response != null && (response instanceof FetchResponse)) {
                arrayList.add(Integer.valueOf(((FetchResponse) response).getNumber()));
            }
        }
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i4 = 0; i4 < size; i4++) {
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
        return iArr;
    }

    public void unauthenticate() throws ProtocolException {
        if (hasCapability("X-UNAUTHENTICATE")) {
            simpleCommand("UNAUTHENTICATE", null);
            this.f37852w = false;
            return;
        }
        throw new BadCommandException("UNAUTHENTICATE not supported");
    }

    public void unselect() throws ProtocolException {
        if (hasCapability("UNSELECT")) {
            simpleCommand("UNSELECT", null);
            return;
        }
        throw new BadCommandException("UNSELECT not supported");
    }

    public void unsubscribe(String str) throws ProtocolException {
        Argument argument = new Argument();
        I(argument, str);
        simpleCommand("UNSUBSCRIBE", argument);
    }

    protected BODY v(int i4, String str, String str2) throws ProtocolException {
        Response[] fetch = fetch(i4, str2);
        notifyResponseHandlers(fetch);
        Response response = fetch[fetch.length - 1];
        if (response.isOK()) {
            List<BODY> items = FetchResponse.getItems(fetch, i4, BODY.class);
            if (items.size() == 1) {
                return (BODY) items.get(0);
            }
            if (this.f37603d.isLoggable(Level.FINEST)) {
                MailLogger mailLogger = this.f37603d;
                mailLogger.finest("got " + items.size() + " BODY responses for section " + str);
            }
            for (BODY body : items) {
                if (this.f37603d.isLoggable(Level.FINEST)) {
                    MailLogger mailLogger2 = this.f37603d;
                    mailLogger2.finest("got BODY section " + body.getSection());
                }
                if (body.getSection().equalsIgnoreCase(str)) {
                    return body;
                }
            }
            return null;
        } else if (response.isNO()) {
            return null;
        } else {
            handleResult(response);
            return null;
        }
    }

    protected CopyUID x(Response[] responseArr) {
        byte readByte;
        for (int length = responseArr.length - 1; length >= 0; length--) {
            Response response = responseArr[length];
            if (response != null && response.isOK()) {
                do {
                    readByte = response.readByte();
                    if (readByte <= 0) {
                        break;
                    }
                } while (readByte != 91);
                if (readByte != 0 && response.readAtom().equalsIgnoreCase("COPYUID")) {
                    return new CopyUID(response.readLong(), UIDSet.parseUIDSets(response.readAtom()), UIDSet.parseUIDSets(response.readAtom()));
                }
            }
        }
        return null;
    }

    protected SearchSequence y() {
        if (this.A == null) {
            this.A = new SearchSequence(this);
        }
        return this.A;
    }

    protected void z(Response response) throws ProtocolException {
        if (hasCapability("LOGIN-REFERRALS") && (!response.isOK() || this.f37850u)) {
            o(response);
        }
        handleResult(response);
    }

    public AppendUID appenduid(String str, Flags flags, Date date, Literal literal, boolean z3) throws ProtocolException {
        Argument argument = new Argument();
        I(argument, str);
        if (flags != null) {
            Flags.Flag flag = Flags.Flag.RECENT;
            if (flags.contains(flag)) {
                Flags flags2 = new Flags(flags);
                flags2.remove(flag);
                flags = flags2;
            }
            argument.writeAtom(q(flags));
        }
        if (date != null) {
            argument.writeString(INTERNALDATE.format(date));
        }
        argument.writeBytes(literal);
        Response[] command = command("APPEND", argument);
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        if (z3) {
            return w(command[command.length - 1]);
        }
        return null;
    }

    public void copy(int i4, int i5, String str) throws ProtocolException {
        p(String.valueOf(i4) + ":" + String.valueOf(i5), str, false);
    }

    public CopyUID copyuid(int i4, int i5, String str) throws ProtocolException {
        return p(String.valueOf(i4) + ":" + String.valueOf(i5), str, true);
    }

    public MailboxInfo examine(String str, ResyncData resyncData) throws ProtocolException {
        Argument argument = new Argument();
        I(argument, str);
        if (resyncData != null) {
            if (resyncData == ResyncData.CONDSTORE) {
                if (hasCapability("CONDSTORE")) {
                    argument.writeArgument(new Argument().writeAtom("CONDSTORE"));
                } else {
                    throw new BadCommandException("CONDSTORE not supported");
                }
            } else if (hasCapability("QRESYNC")) {
                argument.writeArgument(E(resyncData));
            } else {
                throw new BadCommandException("QRESYNC not supported");
            }
        }
        Response[] command = command("EXAMINE", argument);
        MailboxInfo mailboxInfo = new MailboxInfo(command);
        mailboxInfo.mode = 1;
        notifyResponseHandlers(command);
        handleResult(command[command.length - 1]);
        return mailboxInfo;
    }

    public Response[] fetch(int i4, int i5, String str) throws ProtocolException {
        return s(String.valueOf(i4) + ":" + String.valueOf(i5), str, false);
    }

    public BODY fetchBody(int i4, String str, int i5, int i6) throws ProtocolException {
        return t(i4, str, i5, i6, false, null);
    }

    public void move(int i4, int i5, String str) throws ProtocolException {
        B(String.valueOf(i4) + ":" + String.valueOf(i5), str, false);
    }

    public CopyUID moveuid(int i4, int i5, String str) throws ProtocolException {
        return B(String.valueOf(i4) + ":" + String.valueOf(i5), str, true);
    }

    public BODY peekBody(int i4, String str, int i5, int i6) throws ProtocolException {
        return t(i4, str, i5, i6, true, null);
    }

    public int[] search(SearchTerm searchTerm) throws ProtocolException, SearchException {
        return F("ALL", searchTerm);
    }

    public MailboxInfo select(String str, ResyncData resyncData) throws ProtocolException {
        Argument argument = new Argument();
        I(argument, str);
        if (resyncData != null) {
            if (resyncData == ResyncData.CONDSTORE) {
                if (hasCapability("CONDSTORE")) {
                    argument.writeArgument(new Argument().writeAtom("CONDSTORE"));
                } else {
                    throw new BadCommandException("CONDSTORE not supported");
                }
            } else if (hasCapability("QRESYNC")) {
                argument.writeArgument(E(resyncData));
            } else {
                throw new BadCommandException("QRESYNC not supported");
            }
        }
        Response[] command = command("SELECT", argument);
        MailboxInfo mailboxInfo = new MailboxInfo(command);
        notifyResponseHandlers(command);
        Response response = command[command.length - 1];
        if (response.isOK()) {
            if (response.toString().indexOf("READ-ONLY") != -1) {
                mailboxInfo.mode = 1;
            } else {
                mailboxInfo.mode = 2;
            }
        }
        handleResult(response);
        return mailboxInfo;
    }

    public void storeFlags(int i4, int i5, Flags flags, boolean z3) throws ProtocolException {
        H(String.valueOf(i4) + ":" + String.valueOf(i5), flags, z3);
    }

    public Response[] fetch(int i4, String str) throws ProtocolException {
        return s(String.valueOf(i4), str, false);
    }

    public BODY fetchBody(int i4, String str, int i5, int i6, ByteArray byteArray) throws ProtocolException {
        return t(i4, str, i5, i6, false, byteArray);
    }

    public BODY peekBody(int i4, String str, int i5, int i6, ByteArray byteArray) throws ProtocolException {
        return t(i4, str, i5, i6, true, byteArray);
    }

    public void storeFlags(int i4, Flags flags, boolean z3) throws ProtocolException {
        H(String.valueOf(i4), flags, z3);
    }

    public Map<String, String> id(Map<String, String> map) throws ProtocolException {
        ID id;
        if (hasCapability("ID")) {
            Response[] command = command("ID", ID.a(map));
            Response response = command[command.length - 1];
            if (response.isOK()) {
                int length = command.length;
                id = null;
                for (int i4 = 0; i4 < length; i4++) {
                    Response response2 = command[i4];
                    if (response2 instanceof IMAPResponse) {
                        IMAPResponse iMAPResponse = (IMAPResponse) response2;
                        if (iMAPResponse.keyEquals("ID")) {
                            if (id == null) {
                                id = new ID(iMAPResponse);
                            }
                            command[i4] = null;
                        }
                    }
                }
            } else {
                id = null;
            }
            notifyResponseHandlers(command);
            handleResult(response);
            if (id == null) {
                return null;
            }
            return id.b();
        }
        throw new BadCommandException("ID not supported");
    }

    public void fetchSequenceNumbers(long[] jArr) throws ProtocolException {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < jArr.length; i4++) {
            if (i4 > 0) {
                sb.append(",");
            }
            sb.append(String.valueOf(jArr[i4]));
        }
        Response[] s3 = s(sb.toString(), "UID", true);
        notifyResponseHandlers(s3);
        handleResult(s3[s3.length - 1]);
    }

    public IMAPProtocol(InputStream inputStream, PrintStream printStream, Properties properties, boolean z3) throws IOException {
        super(inputStream, printStream, properties, z3);
        this.f37848s = false;
        this.f37849t = false;
        this.f37851v = true;
        this.D = "imap";
        this.f37851v = !PropUtil.getBooleanProperty(properties, "mail.debug.auth", false);
        if (this.f37853x == null) {
            this.f37853x = new HashMap();
        }
        this.B = r3;
        String[] strArr = {"UTF-8", MimeUtility.mimeCharset(MimeUtility.getDefaultJavaCharset())};
        this.f37848s = true;
    }
}
