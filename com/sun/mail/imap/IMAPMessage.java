package com.sun.mail.imap;

import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.sun.mail.iap.ConnectionException;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.Utility;
import com.sun.mail.imap.protocol.BODY;
import com.sun.mail.imap.protocol.BODYSTRUCTURE;
import com.sun.mail.imap.protocol.ENVELOPE;
import com.sun.mail.imap.protocol.FetchItem;
import com.sun.mail.imap.protocol.FetchResponse;
import com.sun.mail.imap.protocol.IMAPProtocol;
import com.sun.mail.imap.protocol.INTERNALDATE;
import com.sun.mail.imap.protocol.Item;
import com.sun.mail.imap.protocol.MODSEQ;
import com.sun.mail.imap.protocol.RFC822DATA;
import com.sun.mail.imap.protocol.RFC822SIZE;
import com.sun.mail.imap.protocol.UID;
import com.sun.mail.util.ReadableMime;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.FolderClosedException;
import javax.mail.Header;
import javax.mail.IllegalWriteException;
import javax.mail.Message;
import javax.mail.MessageRemovedException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.UIDFolder;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.mail.internet.ParameterList;

/* loaded from: classes6.dex */
public class IMAPMessage extends MimeMessage implements ReadableMime {

    /* renamed from: a  reason: collision with root package name */
    protected BODYSTRUCTURE f37723a;

    /* renamed from: b  reason: collision with root package name */
    protected ENVELOPE f37724b;

    /* renamed from: c  reason: collision with root package name */
    protected Map<String, Object> f37725c;

    /* renamed from: d  reason: collision with root package name */
    private Date f37726d;

    /* renamed from: e  reason: collision with root package name */
    private long f37727e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f37728f;

    /* renamed from: g  reason: collision with root package name */
    private volatile long f37729g;

    /* renamed from: h  reason: collision with root package name */
    private volatile long f37730h;

    /* renamed from: i  reason: collision with root package name */
    protected String f37731i;

    /* renamed from: j  reason: collision with root package name */
    private String f37732j;

    /* renamed from: k  reason: collision with root package name */
    private String f37733k;

    /* renamed from: l  reason: collision with root package name */
    private String f37734l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f37735m;

    /* renamed from: n  reason: collision with root package name */
    private volatile boolean f37736n;

    /* renamed from: o  reason: collision with root package name */
    private Hashtable<String, String> f37737o;

    /* loaded from: classes6.dex */
    public static class FetchProfileCondition implements Utility.Condition {

        /* renamed from: a  reason: collision with root package name */
        private boolean f37738a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f37739b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f37740c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f37741d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f37742e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f37743f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f37744g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f37745h;

        /* renamed from: i  reason: collision with root package name */
        private String[] f37746i;

        /* renamed from: j  reason: collision with root package name */
        private Set<FetchItem> f37747j = new HashSet();

        public FetchProfileCondition(FetchProfile fetchProfile, FetchItem[] fetchItemArr) {
            this.f37738a = false;
            this.f37739b = false;
            this.f37740c = false;
            this.f37741d = false;
            this.f37742e = false;
            this.f37743f = false;
            this.f37744g = false;
            this.f37745h = false;
            this.f37746i = null;
            if (fetchProfile.contains(FetchProfile.Item.ENVELOPE)) {
                this.f37738a = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.FLAGS)) {
                this.f37739b = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.CONTENT_INFO)) {
                this.f37740c = true;
            }
            if (fetchProfile.contains(FetchProfile.Item.SIZE)) {
                this.f37743f = true;
            }
            if (fetchProfile.contains(UIDFolder.FetchProfileItem.UID)) {
                this.f37741d = true;
            }
            if (fetchProfile.contains(IMAPFolder.FetchProfileItem.HEADERS)) {
                this.f37742e = true;
            }
            if (fetchProfile.contains(IMAPFolder.FetchProfileItem.SIZE)) {
                this.f37743f = true;
            }
            if (fetchProfile.contains(IMAPFolder.FetchProfileItem.MESSAGE)) {
                this.f37744g = true;
            }
            if (fetchProfile.contains(IMAPFolder.FetchProfileItem.INTERNALDATE)) {
                this.f37745h = true;
            }
            this.f37746i = fetchProfile.getHeaderNames();
            for (int i4 = 0; i4 < fetchItemArr.length; i4++) {
                if (fetchProfile.contains(fetchItemArr[i4].getFetchProfileItem())) {
                    this.f37747j.add(fetchItemArr[i4]);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:58:0x0090  */
        @Override // com.sun.mail.imap.Utility.Condition
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean test(com.sun.mail.imap.IMAPMessage r7) {
            /*
                r6 = this;
                boolean r0 = r6.f37738a
                r1 = 1
                if (r0 == 0) goto L12
                com.sun.mail.imap.protocol.ENVELOPE r0 = com.sun.mail.imap.IMAPMessage.h(r7)
                if (r0 != 0) goto L12
                boolean r0 = com.sun.mail.imap.IMAPMessage.i(r7)
                if (r0 != 0) goto L12
                return r1
            L12:
                boolean r0 = r6.f37739b
                if (r0 == 0) goto L1d
                javax.mail.Flags r0 = com.sun.mail.imap.IMAPMessage.j(r7)
                if (r0 != 0) goto L1d
                return r1
            L1d:
                boolean r0 = r6.f37740c
                if (r0 == 0) goto L2e
                com.sun.mail.imap.protocol.BODYSTRUCTURE r0 = com.sun.mail.imap.IMAPMessage.k(r7)
                if (r0 != 0) goto L2e
                boolean r0 = com.sun.mail.imap.IMAPMessage.i(r7)
                if (r0 != 0) goto L2e
                return r1
            L2e:
                boolean r0 = r6.f37741d
                r2 = -1
                if (r0 == 0) goto L3d
                long r4 = r7.x()
                int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r0 != 0) goto L3d
                return r1
            L3d:
                boolean r0 = r6.f37742e
                if (r0 == 0) goto L48
                boolean r0 = com.sun.mail.imap.IMAPMessage.l(r7)
                if (r0 != 0) goto L48
                return r1
            L48:
                boolean r0 = r6.f37743f
                if (r0 == 0) goto L5b
                long r4 = com.sun.mail.imap.IMAPMessage.m(r7)
                int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                if (r0 != 0) goto L5b
                boolean r0 = com.sun.mail.imap.IMAPMessage.i(r7)
                if (r0 != 0) goto L5b
                return r1
            L5b:
                boolean r0 = r6.f37744g
                if (r0 == 0) goto L66
                boolean r0 = com.sun.mail.imap.IMAPMessage.i(r7)
                if (r0 != 0) goto L66
                return r1
            L66:
                boolean r0 = r6.f37745h
                if (r0 == 0) goto L71
                java.util.Date r0 = com.sun.mail.imap.IMAPMessage.n(r7)
                if (r0 != 0) goto L71
                return r1
            L71:
                r0 = 0
                r2 = 0
            L73:
                java.lang.String[] r3 = r6.f37746i
                int r4 = r3.length
                if (r2 >= r4) goto L84
                r3 = r3[r2]
                boolean r3 = com.sun.mail.imap.IMAPMessage.o(r7, r3)
                if (r3 != 0) goto L81
                return r1
            L81:
                int r2 = r2 + 1
                goto L73
            L84:
                java.util.Set<com.sun.mail.imap.protocol.FetchItem> r2 = r6.f37747j
                java.util.Iterator r2 = r2.iterator()
            L8a:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto La5
                java.lang.Object r3 = r2.next()
                com.sun.mail.imap.protocol.FetchItem r3 = (com.sun.mail.imap.protocol.FetchItem) r3
                java.util.Map<java.lang.String, java.lang.Object> r4 = r7.f37725c
                if (r4 == 0) goto La4
                java.lang.String r3 = r3.getName()
                java.lang.Object r3 = r4.get(r3)
                if (r3 != 0) goto L8a
            La4:
                return r1
            La5:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.IMAPMessage.FetchProfileCondition.test(com.sun.mail.imap.IMAPMessage):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMessage(IMAPFolder iMAPFolder, int i4) {
        super(iMAPFolder, i4);
        this.f37727e = -1L;
        this.f37729g = -1L;
        this.f37730h = -1L;
        this.f37735m = false;
        this.f37736n = false;
        this.f37737o = new Hashtable<>(1);
        this.flags = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B(String str) {
        if (this.f37735m) {
            return true;
        }
        return this.f37737o.containsKey(str.toUpperCase(Locale.ENGLISH));
    }

    private synchronized void D() throws MessagingException {
        if (this.f37723a != null) {
            return;
        }
        synchronized (u()) {
            try {
                IMAPProtocol v3 = v();
                q();
                BODYSTRUCTURE fetchBodyStructure = v3.fetchBodyStructure(w());
                this.f37723a = fetchBodyStructure;
                if (fetchBodyStructure == null) {
                    s();
                    throw new MessagingException("Unable to load BODYSTRUCTURE");
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                s();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    private synchronized void E() throws MessagingException {
        if (this.f37724b != null) {
            return;
        }
        synchronized (u()) {
            try {
                IMAPProtocol v3 = v();
                q();
                int w3 = w();
                Response[] fetch = v3.fetch(w3, "ENVELOPE INTERNALDATE RFC822.SIZE");
                for (int i4 = 0; i4 < fetch.length; i4++) {
                    Response response = fetch[i4];
                    if (response != null && (response instanceof FetchResponse) && ((FetchResponse) response).getNumber() == w3) {
                        FetchResponse fetchResponse = (FetchResponse) fetch[i4];
                        int itemCount = fetchResponse.getItemCount();
                        for (int i5 = 0; i5 < itemCount; i5++) {
                            Item item = fetchResponse.getItem(i5);
                            if (item instanceof ENVELOPE) {
                                this.f37724b = (ENVELOPE) item;
                            } else if (item instanceof INTERNALDATE) {
                                this.f37726d = ((INTERNALDATE) item).getDate();
                            } else if (item instanceof RFC822SIZE) {
                                this.f37727e = ((RFC822SIZE) item).size;
                            }
                        }
                    }
                }
                v3.notifyResponseHandlers(fetch);
                v3.handleResult(fetch[fetch.length - 1]);
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                s();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        if (this.f37724b != null) {
            return;
        }
        throw new MessagingException("Failed to load IMAP envelope");
    }

    private synchronized void F() throws MessagingException {
        if (this.flags != null) {
            return;
        }
        synchronized (u()) {
            try {
                IMAPProtocol v3 = v();
                q();
                Flags fetchFlags = v3.fetchFlags(w());
                this.flags = fetchFlags;
                if (fetchFlags == null) {
                    this.flags = new Flags();
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                s();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    private synchronized void G() throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        if (this.f37735m) {
            return;
        }
        synchronized (u()) {
            try {
                IMAPProtocol v3 = v();
                q();
                byteArrayInputStream = null;
                if (v3.isREV1()) {
                    BODY peekBody = v3.peekBody(w(), L("HEADER"));
                    if (peekBody != null) {
                        byteArrayInputStream = peekBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA fetchRFC822 = v3.fetchRFC822(w(), "HEADER");
                    if (fetchRFC822 != null) {
                        byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                    }
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                s();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        if (byteArrayInputStream != null) {
            this.headers = new InternetHeaders(byteArrayInputStream);
            this.f37735m = true;
            return;
        }
        throw new MessagingException("Cannot load header");
    }

    private void H(String str) {
        this.f37737o.put(str.toUpperCase(Locale.ENGLISH), str);
    }

    private void I(boolean z3) {
        this.f37735m = z3;
    }

    private String L(String str) {
        if (this.f37731i == null) {
            return str;
        }
        return this.f37731i + "." + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BODYSTRUCTURE a() {
        return this.f37723a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ENVELOPE b() {
        return this.f37724b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Flags c() {
        return this.flags;
    }

    private InternetAddress[] g(InternetAddress[] internetAddressArr) {
        if (internetAddressArr == null) {
            return null;
        }
        return (InternetAddress[]) internetAddressArr.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        return this.f37735m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean A() {
        return ((IMAPStore) this.folder.getStore()).t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C() throws FolderClosedException {
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).f37653j;
        if (iMAPProtocol != null) {
            return iMAPProtocol.isREV1();
        }
        throw new FolderClosedException(this.folder);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(long j4) {
        this.f37730h = j4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(long j4) {
        this.f37729g = j4;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addFrom(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void addHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void addHeaderLine(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void addRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        return this.f37730h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session e() {
        return this.session;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Flags flags) {
        this.flags = flags;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration<String> getAllHeaderLines() throws MessagingException {
        q();
        G();
        return super.getAllHeaderLines();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration<Header> getAllHeaders() throws MessagingException {
        q();
        G();
        return super.getAllHeaders();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentID() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getContentID();
        }
        D();
        return this.f37723a.id;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String[] getContentLanguage() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getContentLanguage();
        }
        D();
        String[] strArr = this.f37723a.language;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getContentMD5() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getContentMD5();
        }
        D();
        return this.f37723a.md5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.internet.MimeMessage
    public InputStream getContentStream() throws MessagingException {
        BODY fetchBody;
        if (this.f37736n) {
            return super.getContentStream();
        }
        boolean peek = getPeek();
        synchronized (u()) {
            try {
                IMAPProtocol v3 = v();
                q();
                if (v3.isREV1()) {
                    int i4 = -1;
                    if (t() != -1) {
                        String L = L("TEXT");
                        if (this.f37723a != null && !A()) {
                            i4 = this.f37723a.size;
                        }
                        return new IMAPInputStream(this, L, i4, peek);
                    }
                }
                ByteArrayInputStream byteArrayInputStream = null;
                if (v3.isREV1()) {
                    if (peek) {
                        fetchBody = v3.peekBody(w(), L("TEXT"));
                    } else {
                        fetchBody = v3.fetchBody(w(), L("TEXT"));
                    }
                    if (fetchBody != null) {
                        byteArrayInputStream = fetchBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA fetchRFC822 = v3.fetchRFC822(w(), "TEXT");
                    if (fetchRFC822 != null) {
                        byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                    }
                }
                if (byteArrayInputStream == null) {
                    s();
                    return new ByteArrayInputStream(new byte[0]);
                }
                return byteArrayInputStream;
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                s();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public synchronized String getContentType() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getContentType();
        }
        if (this.f37732j == null) {
            D();
            BODYSTRUCTURE bodystructure = this.f37723a;
            this.f37732j = new ContentType(bodystructure.type, bodystructure.subtype, bodystructure.cParams).toString();
        }
        return this.f37732j;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public synchronized DataHandler getDataHandler() throws MessagingException {
        String str;
        q();
        if (this.dh == null && !this.f37736n) {
            D();
            if (this.f37732j == null) {
                BODYSTRUCTURE bodystructure = this.f37723a;
                this.f37732j = new ContentType(bodystructure.type, bodystructure.subtype, bodystructure.cParams).toString();
            }
            if (this.f37723a.isMulti()) {
                this.dh = new DataHandler(new IMAPMultipartDataSource(this, this.f37723a.bodies, this.f37731i, this));
            } else if (this.f37723a.isNested() && C() && this.f37723a.envelope != null) {
                BODYSTRUCTURE bodystructure2 = this.f37723a;
                BODYSTRUCTURE bodystructure3 = bodystructure2.bodies[0];
                ENVELOPE envelope = bodystructure2.envelope;
                if (this.f37731i == null) {
                    str = "1";
                } else {
                    str = this.f37731i + ".1";
                }
                this.dh = new DataHandler(new IMAPNestedMessage(this, bodystructure3, envelope, str), this.f37732j);
            }
        }
        return super.getDataHandler();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDescription() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getDescription();
        }
        String str = this.f37734l;
        if (str != null) {
            return str;
        }
        D();
        String str2 = this.f37723a.description;
        if (str2 == null) {
            return null;
        }
        try {
            this.f37734l = MimeUtility.decodeText(str2);
        } catch (UnsupportedEncodingException unused) {
            this.f37734l = this.f37723a.description;
        }
        return this.f37734l;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getDisposition() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getDisposition();
        }
        D();
        return this.f37723a.disposition;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getEncoding() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getEncoding();
        }
        D();
        return this.f37723a.encoding;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String getFileName() throws MessagingException {
        String str;
        ParameterList parameterList;
        q();
        if (this.f37736n) {
            return super.getFileName();
        }
        D();
        ParameterList parameterList2 = this.f37723a.dParams;
        if (parameterList2 != null) {
            str = parameterList2.get("filename");
        } else {
            str = null;
        }
        if (str == null && (parameterList = this.f37723a.cParams) != null) {
            return parameterList.get("name");
        }
        return str;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized Flags getFlags() throws MessagingException {
        q();
        F();
        return super.getFlags();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getFrom() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getFrom();
        }
        E();
        ENVELOPE envelope = this.f37724b;
        InternetAddress[] internetAddressArr = envelope.from;
        if (internetAddressArr == null || internetAddressArr.length == 0) {
            internetAddressArr = envelope.sender;
        }
        return g(internetAddressArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public String[] getHeader(String str) throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        q();
        if (B(str)) {
            return this.headers.getHeader(str);
        }
        synchronized (u()) {
            try {
                try {
                    IMAPProtocol v3 = v();
                    q();
                    if (v3.isREV1()) {
                        BODY peekBody = v3.peekBody(w(), L("HEADER.FIELDS (" + str + ")"));
                        if (peekBody != null) {
                            byteArrayInputStream = peekBody.getByteArrayInputStream();
                        }
                        byteArrayInputStream = null;
                    } else {
                        RFC822DATA fetchRFC822 = v3.fetchRFC822(w(), "HEADER.LINES (" + str + ")");
                        if (fetchRFC822 != null) {
                            byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                        }
                        byteArrayInputStream = null;
                    }
                } catch (ProtocolException e4) {
                    s();
                    throw new MessagingException(e4.getMessage(), e4);
                }
            } catch (ConnectionException e5) {
                throw new FolderClosedException(this.folder, e5.getMessage());
            }
        }
        if (byteArrayInputStream == null) {
            return null;
        }
        if (this.headers == null) {
            this.headers = new InternetHeaders();
        }
        this.headers.load(byteArrayInputStream);
        H(str);
        return this.headers.getHeader(str);
    }

    public String getInReplyTo() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getHeader("In-Reply-To", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        }
        E();
        return this.f37724b.inReplyTo;
    }

    public synchronized Object getItem(FetchItem fetchItem) throws MessagingException {
        Object obj;
        Map<String, Object> map = this.f37725c;
        if (map == null) {
            obj = null;
        } else {
            obj = map.get(fetchItem.getName());
        }
        if (obj == null) {
            obj = r(fetchItem);
        }
        return obj;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getLineCount() throws MessagingException {
        q();
        D();
        return this.f37723a.lines;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration<String> getMatchingHeaderLines(String[] strArr) throws MessagingException {
        q();
        G();
        return super.getMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration<Header> getMatchingHeaders(String[] strArr) throws MessagingException {
        q();
        G();
        return super.getMatchingHeaders(strArr);
    }

    @Override // javax.mail.internet.MimeMessage
    public String getMessageID() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getMessageID();
        }
        E();
        return this.f37724b.messageId;
    }

    @Override // com.sun.mail.util.ReadableMime
    public InputStream getMimeStream() throws MessagingException {
        BODY fetchBody;
        boolean peek = getPeek();
        synchronized (u()) {
            try {
                IMAPProtocol v3 = v();
                q();
                if (v3.isREV1() && t() != -1) {
                    return new IMAPInputStream(this, this.f37731i, -1, peek);
                }
                ByteArrayInputStream byteArrayInputStream = null;
                if (v3.isREV1()) {
                    if (peek) {
                        fetchBody = v3.peekBody(w(), this.f37731i);
                    } else {
                        fetchBody = v3.fetchBody(w(), this.f37731i);
                    }
                    if (fetchBody != null) {
                        byteArrayInputStream = fetchBody.getByteArrayInputStream();
                    }
                } else {
                    RFC822DATA fetchRFC822 = v3.fetchRFC822(w(), null);
                    if (fetchRFC822 != null) {
                        byteArrayInputStream = fetchRFC822.getByteArrayInputStream();
                    }
                }
                if (byteArrayInputStream == null) {
                    s();
                    return new ByteArrayInputStream(new byte[0]);
                }
                return byteArrayInputStream;
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                s();
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    public synchronized long getModSeq() throws MessagingException {
        if (this.f37730h != -1) {
            return this.f37730h;
        }
        synchronized (u()) {
            try {
                IMAPProtocol v3 = v();
                q();
                MODSEQ fetchMODSEQ = v3.fetchMODSEQ(w());
                if (fetchMODSEQ != null) {
                    this.f37730h = fetchMODSEQ.modseq;
                }
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
        return this.f37730h;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public Enumeration<String> getNonMatchingHeaderLines(String[] strArr) throws MessagingException {
        q();
        G();
        return super.getNonMatchingHeaderLines(strArr);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public Enumeration<Header> getNonMatchingHeaders(String[] strArr) throws MessagingException {
        q();
        G();
        return super.getNonMatchingHeaders(strArr);
    }

    public synchronized boolean getPeek() {
        Boolean bool = this.f37728f;
        if (bool == null) {
            return ((IMAPStore) this.folder.getStore()).n();
        }
        return bool.booleanValue();
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getReceivedDate() throws MessagingException {
        q();
        if (this.f37726d == null) {
            E();
        }
        if (this.f37726d == null) {
            return null;
        }
        return new Date(this.f37726d.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getRecipients(Message.RecipientType recipientType) throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getRecipients(recipientType);
        }
        E();
        if (recipientType == Message.RecipientType.TO) {
            return g(this.f37724b.to);
        }
        if (recipientType == Message.RecipientType.CC) {
            return g(this.f37724b.cc);
        }
        if (recipientType == Message.RecipientType.BCC) {
            return g(this.f37724b.bcc);
        }
        return super.getRecipients(recipientType);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Address[] getReplyTo() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getReplyTo();
        }
        E();
        InternetAddress[] internetAddressArr = this.f37724b.replyTo;
        if (internetAddressArr != null && internetAddressArr.length != 0) {
            return g(internetAddressArr);
        }
        return getFrom();
    }

    @Override // javax.mail.internet.MimeMessage
    public Address getSender() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getSender();
        }
        E();
        InternetAddress[] internetAddressArr = this.f37724b.sender;
        if (internetAddressArr != null && internetAddressArr.length > 0) {
            return internetAddressArr[0];
        }
        return null;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public Date getSentDate() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getSentDate();
        }
        E();
        if (this.f37724b.date == null) {
            return null;
        }
        return new Date(this.f37724b.date.getTime());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public int getSize() throws MessagingException {
        q();
        if (this.f37727e == -1) {
            E();
        }
        long j4 = this.f37727e;
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j4;
    }

    public long getSizeLong() throws MessagingException {
        q();
        if (this.f37727e == -1) {
            E();
        }
        return this.f37727e;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public String getSubject() throws MessagingException {
        q();
        if (this.f37736n) {
            return super.getSubject();
        }
        String str = this.f37733k;
        if (str != null) {
            return str;
        }
        E();
        String str2 = this.f37724b.subject;
        if (str2 == null) {
            return null;
        }
        try {
            this.f37733k = MimeUtility.decodeText(MimeUtility.unfold(str2));
        } catch (UnsupportedEncodingException unused) {
            this.f37733k = this.f37724b.subject;
        }
        return this.f37733k;
    }

    public synchronized void invalidateHeaders() {
        this.f37735m = false;
        this.f37737o.clear();
        this.headers = null;
        this.f37724b = null;
        this.f37723a = null;
        this.f37726d = null;
        this.f37727e = -1L;
        this.f37732j = null;
        this.f37733k = null;
        this.f37734l = null;
        this.flags = null;
        this.content = null;
        this.contentStream = null;
        this.f37736n = false;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized boolean isSet(Flags.Flag flag) throws MessagingException {
        q();
        F();
        return super.isSet(flag);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() throws MessageRemovedException {
        if (!this.expunged) {
            return;
        }
        throw new MessageRemovedException();
    }

    protected Object r(FetchItem fetchItem) throws MessagingException {
        Object obj;
        Object obj2;
        synchronized (u()) {
            try {
                try {
                    IMAPProtocol v3 = v();
                    q();
                    int w3 = w();
                    Response[] fetch = v3.fetch(w3, fetchItem.getName());
                    obj = null;
                    for (int i4 = 0; i4 < fetch.length; i4++) {
                        Response response = fetch[i4];
                        if (response != null && (response instanceof FetchResponse) && ((FetchResponse) response).getNumber() == w3) {
                            y(((FetchResponse) fetch[i4]).getExtensionItems());
                            Map<String, Object> map = this.f37725c;
                            if (map != null && (obj2 = map.get(fetchItem.getName())) != null) {
                                obj = obj2;
                            }
                        }
                    }
                    v3.notifyResponseHandlers(fetch);
                    v3.handleResult(fetch[fetch.length - 1]);
                } catch (ConnectionException e4) {
                    throw new FolderClosedException(this.folder, e4.getMessage());
                } catch (ProtocolException e5) {
                    s();
                    throw new MessagingException(e5.getMessage(), e5);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void removeHeader(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() throws MessageRemovedException, FolderClosedException {
        synchronized (u()) {
            try {
                v().noop();
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException unused) {
            }
        }
        if (!this.expunged) {
            return;
        }
        throw new MessageRemovedException();
    }

    @Override // javax.mail.internet.MimeMessage
    public void setContentID(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentLanguage(String[] strArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public void setContentMD5(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDataHandler(DataHandler dataHandler) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setDescription(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setDisposition(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Message
    public void setExpunged(boolean z3) {
        super.setExpunged(z3);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setFileName(String str) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public synchronized void setFlags(Flags flags, boolean z3) throws MessagingException {
        synchronized (u()) {
            try {
                IMAPProtocol v3 = v();
                q();
                v3.storeFlags(w(), flags, z3);
            } catch (ConnectionException e4) {
                throw new FolderClosedException(this.folder, e4.getMessage());
            } catch (ProtocolException e5) {
                throw new MessagingException(e5.getMessage(), e5);
            }
        }
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setFrom(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void setHeader(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javax.mail.Message
    public void setMessageNumber(int i4) {
        super.setMessageNumber(i4);
    }

    public synchronized void setPeek(boolean z3) {
        this.f37728f = Boolean.valueOf(z3);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setRecipients(Message.RecipientType recipientType, Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setReplyTo(Address[] addressArr) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSender(Address address) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Message
    public void setSentDate(Date date) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    @Override // javax.mail.internet.MimeMessage
    public void setSubject(String str, String str2) throws MessagingException {
        throw new IllegalWriteException("IMAPMessage is read-only");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int t() {
        return ((IMAPStore) this.folder.getStore()).i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object u() {
        return ((IMAPFolder) this.folder).f37655l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPProtocol v() throws ProtocolException, FolderClosedException {
        ((IMAPFolder) this.folder).R();
        IMAPProtocol iMAPProtocol = ((IMAPFolder) this.folder).f37653j;
        if (iMAPProtocol != null) {
            return iMAPProtocol;
        }
        throw new FolderClosedException(this.folder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int w() {
        return ((IMAPFolder) this.folder).f37654k.seqnumOf(getMessageNumber());
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.Part
    public void writeTo(OutputStream outputStream) throws IOException, MessagingException {
        if (this.f37736n) {
            super.writeTo(outputStream);
            return;
        }
        InputStream mimeStream = getMimeStream();
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = mimeStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } finally {
            mimeStream.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long x() {
        return this.f37729g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(Map<String, Object> map) {
        if (map != null && !map.isEmpty()) {
            if (this.f37725c == null) {
                this.f37725c = new HashMap();
            }
            this.f37725c.putAll(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean z(Item item, String[] strArr, boolean z3) throws MessagingException {
        ByteArrayInputStream byteArrayInputStream;
        boolean isHeader;
        if (item instanceof Flags) {
            this.flags = (Flags) item;
        } else if (item instanceof ENVELOPE) {
            this.f37724b = (ENVELOPE) item;
        } else if (item instanceof INTERNALDATE) {
            this.f37726d = ((INTERNALDATE) item).getDate();
        } else if (item instanceof RFC822SIZE) {
            this.f37727e = ((RFC822SIZE) item).size;
        } else if (item instanceof MODSEQ) {
            this.f37730h = ((MODSEQ) item).modseq;
        } else if (item instanceof BODYSTRUCTURE) {
            this.f37723a = (BODYSTRUCTURE) item;
        } else if (item instanceof UID) {
            UID uid = (UID) item;
            this.f37729g = uid.uid;
            Folder folder = this.folder;
            if (((IMAPFolder) folder).f37656m == null) {
                ((IMAPFolder) folder).f37656m = new Hashtable<>();
            }
            ((IMAPFolder) this.folder).f37656m.put(Long.valueOf(uid.uid), this);
        } else {
            boolean z4 = item instanceof RFC822DATA;
            if (!z4 && !(item instanceof BODY)) {
                return false;
            }
            if (z4) {
                RFC822DATA rfc822data = (RFC822DATA) item;
                byteArrayInputStream = rfc822data.getByteArrayInputStream();
                isHeader = rfc822data.isHeader();
            } else {
                BODY body = (BODY) item;
                byteArrayInputStream = body.getByteArrayInputStream();
                isHeader = body.isHeader();
            }
            if (!isHeader) {
                try {
                    this.f37727e = byteArrayInputStream.available();
                } catch (IOException unused) {
                }
                parse(byteArrayInputStream);
                this.f37736n = true;
                I(true);
            } else {
                InternetHeaders internetHeaders = new InternetHeaders();
                if (byteArrayInputStream != null) {
                    internetHeaders.load(byteArrayInputStream);
                }
                if (this.headers != null && !z3) {
                    Enumeration<Header> allHeaders = internetHeaders.getAllHeaders();
                    while (allHeaders.hasMoreElements()) {
                        Header nextElement = allHeaders.nextElement();
                        if (!B(nextElement.getName())) {
                            this.headers.addHeader(nextElement.getName(), nextElement.getValue());
                        }
                    }
                } else {
                    this.headers = internetHeaders;
                }
                if (z3) {
                    I(true);
                } else {
                    for (String str : strArr) {
                        H(str);
                    }
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IMAPMessage(Session session) {
        super(session);
        this.f37727e = -1L;
        this.f37729g = -1L;
        this.f37730h = -1L;
        this.f37735m = false;
        this.f37736n = false;
        this.f37737o = new Hashtable<>(1);
    }

    @Override // javax.mail.internet.MimeMessage, javax.mail.internet.MimePart
    public String getHeader(String str, String str2) throws MessagingException {
        q();
        if (getHeader(str) == null) {
            return null;
        }
        return this.headers.getHeader(str, str2);
    }
}
