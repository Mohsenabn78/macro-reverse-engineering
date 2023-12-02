package com.sun.mail.util.logging;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;
import javax.activation.DataHandler;
import javax.activation.FileTypeMap;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessageContext;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Service;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;

/* loaded from: classes6.dex */
public class MailHandler extends Handler {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MIN_HEADER_SIZE = 1024;
    private volatile Filter[] attachmentFilters;
    private Formatter[] attachmentFormatters;
    private Formatter[] attachmentNames;
    private Authenticator auth;
    private int capacity;
    private Comparator<? super LogRecord> comparator;
    private FileTypeMap contentTypes;
    private LogRecord[] data;
    private String encoding;
    private volatile Filter filter;
    private Formatter formatter;
    private boolean isWriting;
    private Properties mailProps;
    private int[] matched;
    private Filter pushFilter;
    private Level pushLevel;
    private volatile boolean sealed;
    private Session session;
    private int size;
    private Formatter subjectFormatter;
    private static final Filter[] EMPTY_FILTERS = new Filter[0];
    private static final Formatter[] EMPTY_FORMATTERS = new Formatter[0];
    private static final int offValue = Level.OFF.intValue();
    private static final PrivilegedAction<Object> MAILHANDLER_LOADER = new GetAndSetContext(MailHandler.class);
    private static final ThreadLocal<Integer> MUTEX = new ThreadLocal<>();
    private static final Integer MUTEX_PUBLISH = -2;
    private static final Integer MUTEX_REPORT = -4;
    private static final Integer MUTEX_LINKAGE = -8;
    private volatile Level logLevel = Level.ALL;
    private volatile ErrorManager errorManager = defaultErrorManager();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class DefaultAuthenticator extends Authenticator {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String pass;

        private DefaultAuthenticator(String str) {
            this.pass = str;
        }

        static Authenticator of(String str) {
            return new DefaultAuthenticator(str);
        }

        @Override // javax.mail.Authenticator
        protected final PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(getDefaultUserName(), this.pass);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class GetAndSetContext implements PrivilegedAction<Object> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final Object NOT_MODIFIED = GetAndSetContext.class;
        private final Object source;

        GetAndSetContext(Object obj) {
            this.source = obj;
        }

        @Override // java.security.PrivilegedAction
        public final Object run() {
            ClassLoader classLoader;
            Thread currentThread = Thread.currentThread();
            ClassLoader contextClassLoader = currentThread.getContextClassLoader();
            Object obj = this.source;
            if (obj == null) {
                classLoader = null;
            } else if (obj instanceof ClassLoader) {
                classLoader = (ClassLoader) obj;
            } else if (obj instanceof Class) {
                classLoader = ((Class) obj).getClassLoader();
            } else if (obj instanceof Thread) {
                classLoader = ((Thread) obj).getContextClassLoader();
            } else {
                classLoader = obj.getClass().getClassLoader();
            }
            if (contextClassLoader != classLoader) {
                currentThread.setContextClassLoader(classLoader);
                return contextClassLoader;
            }
            return NOT_MODIFIED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class TailNameFormatter extends Formatter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final String name;

        private TailNameFormatter(String str) {
            this.name = str;
        }

        static Formatter of(String str) {
            return new TailNameFormatter(str);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof TailNameFormatter) {
                return this.name.equals(((TailNameFormatter) obj).name);
            }
            return false;
        }

        @Override // java.util.logging.Formatter
        public final String format(LogRecord logRecord) {
            return "";
        }

        @Override // java.util.logging.Formatter
        public final String getTail(Handler handler) {
            return this.name;
        }

        public final int hashCode() {
            return TailNameFormatter.class.hashCode() + this.name.hashCode();
        }

        public final String toString() {
            return this.name;
        }
    }

    public MailHandler() {
        init(null);
        this.sealed = true;
        checkAccess();
    }

    private boolean alignAttachmentFilters() {
        int length = this.attachmentFormatters.length;
        int length2 = this.attachmentFilters.length;
        boolean z3 = false;
        if (length2 != length) {
            this.attachmentFilters = (Filter[]) Arrays.copyOf(this.attachmentFilters, length, Filter[].class);
            clearMatches(length2);
            if (length2 != 0) {
                z3 = true;
            }
            Filter filter = this.filter;
            if (filter != null) {
                while (length2 < length) {
                    this.attachmentFilters[length2] = filter;
                    length2++;
                }
            }
        }
        if (length == 0) {
            this.attachmentFilters = emptyFilterArray();
        }
        return z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021 A[LOOP:0: B:10:0x0021->B:14:0x0037, LOOP_START, PHI: r3 
      PHI: (r3v1 int) = (r3v0 int), (r3v2 int) binds: [B:8:0x0018, B:14:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean alignAttachmentNames() {
        /*
            r5 = this;
            java.util.logging.Formatter[] r0 = r5.attachmentFormatters
            int r0 = r0.length
            java.util.logging.Formatter[] r1 = r5.attachmentNames
            int r2 = r1.length
            r3 = 0
            if (r2 == r0) goto L17
            java.lang.Class<java.util.logging.Formatter[]> r4 = java.util.logging.Formatter[].class
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r0, r4)
            java.util.logging.Formatter[] r1 = (java.util.logging.Formatter[]) r1
            r5.attachmentNames = r1
            if (r2 == 0) goto L17
            r1 = 1
            goto L18
        L17:
            r1 = 0
        L18:
            if (r0 != 0) goto L21
            java.util.logging.Formatter[] r0 = emptyFormatterArray()
            r5.attachmentNames = r0
            goto L3a
        L21:
            if (r3 >= r0) goto L3a
            java.util.logging.Formatter[] r2 = r5.attachmentNames
            r4 = r2[r3]
            if (r4 != 0) goto L37
            java.util.logging.Formatter[] r4 = r5.attachmentFormatters
            r4 = r4[r3]
            java.lang.String r4 = r5.toString(r4)
            java.util.logging.Formatter r4 = com.sun.mail.util.logging.MailHandler.TailNameFormatter.of(r4)
            r2[r3] = r4
        L37:
            int r3 = r3 + 1
            goto L21
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.alignAttachmentNames():boolean");
    }

    private boolean allowRestrictedHeaders() {
        return LogManagerProperties.hasLogManager();
    }

    private void appendContentLang(MimePart mimePart, Locale locale) {
        int length;
        String concat;
        try {
            String languageTag = LogManagerProperties.toLanguageTag(locale);
            if (languageTag.length() != 0) {
                String header = mimePart.getHeader(HttpHeaders.CONTENT_LANGUAGE, null);
                if (isEmpty(header)) {
                    mimePart.setHeader(HttpHeaders.CONTENT_LANGUAGE, languageTag);
                } else if (!header.equalsIgnoreCase(languageTag)) {
                    String concat2 = ",".concat(languageTag);
                    int i4 = 0;
                    do {
                        i4 = header.indexOf(concat2, i4);
                        if (i4 <= -1 || (i4 = i4 + concat2.length()) == header.length()) {
                            break;
                        }
                    } while (header.charAt(i4) != ',');
                    if (i4 < 0) {
                        int lastIndexOf = header.lastIndexOf("\r\n\t");
                        if (lastIndexOf < 0) {
                            length = header.length() + 20;
                        } else {
                            length = (header.length() - lastIndexOf) + 8;
                        }
                        if (length + concat2.length() > 76) {
                            concat = header.concat("\r\n\t".concat(concat2));
                        } else {
                            concat = header.concat(concat2);
                        }
                        mimePart.setHeader(HttpHeaders.CONTENT_LANGUAGE, concat);
                    }
                }
            }
        } catch (MessagingException e4) {
            reportError(e4.getMessage(), e4, 5);
        }
    }

    private void appendFileName(Part part, String str) {
        if (str != null) {
            if (str.length() > 0) {
                appendFileName0(part, str);
                return;
            }
            return;
        }
        reportNullError(5);
    }

    private void appendFileName0(Part part, String str) {
        try {
            String replaceAll = str.replaceAll("[\\x00-\\x1F\\x7F]+", "");
            String fileName = part.getFileName();
            if (fileName != null) {
                replaceAll = fileName.concat(replaceAll);
            }
            part.setFileName(replaceAll);
        } catch (MessagingException e4) {
            reportError(e4.getMessage(), e4, 5);
        }
    }

    private void appendSubject(Message message, String str) {
        if (str != null) {
            if (str.length() > 0) {
                appendSubject0(message, str);
                return;
            }
            return;
        }
        reportNullError(5);
    }

    private void appendSubject0(Message message, String str) {
        try {
            String replaceAll = str.replaceAll("[\\x00-\\x1F\\x7F]+", "");
            String encodingName = getEncodingName();
            String subject = message.getSubject();
            MimeMessage mimeMessage = (MimeMessage) message;
            if (subject != null) {
                replaceAll = subject.concat(replaceAll);
            }
            mimeMessage.setSubject(replaceAll, MimeUtility.mimeCharset(encodingName));
        } catch (MessagingException e4) {
            reportError(e4.getMessage(), e4, 5);
        }
    }

    private static String atIndexMsg(int i4) {
        return "At index: " + i4 + '.';
    }

    private static MessagingException attach(MessagingException messagingException, Exception exc) {
        if (exc != null && !messagingException.setNextException(exc)) {
            if (exc instanceof MessagingException) {
                MessagingException messagingException2 = (MessagingException) exc;
                if (messagingException2.setNextException(messagingException)) {
                    return messagingException2;
                }
            }
            if (exc != messagingException) {
                messagingException.addSuppressed(exc);
            }
        }
        return messagingException;
    }

    private static RuntimeException attachmentMismatch(String str) {
        return new IndexOutOfBoundsException(str);
    }

    private void checkAccess() {
        if (this.sealed) {
            LogManagerProperties.checkLogManagerAccess();
        }
    }

    private void clearMatches(int i4) {
        for (int i5 = 0; i5 < this.size; i5++) {
            int[] iArr = this.matched;
            if (iArr[i5] >= i4) {
                iArr[i5] = MUTEX_PUBLISH.intValue();
            }
        }
    }

    private String contentWithEncoding(String str, String str2) {
        try {
            ContentType contentType = new ContentType(str);
            contentType.setParameter("charset", MimeUtility.mimeCharset(str2));
            String contentType2 = contentType.toString();
            if (!isEmpty(contentType2)) {
                return contentType2;
            }
            return str;
        } catch (MessagingException e4) {
            reportError(str, e4, 5);
            return str;
        }
    }

    private MimeBodyPart createBodyPart() throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDisposition(Part.INLINE);
        mimeBodyPart.setDescription(descriptionFrom(getFormatter(), getFilter(), this.subjectFormatter));
        setAcceptLang(mimeBodyPart);
        return mimeBodyPart;
    }

    private static Formatter createSimpleFormatter() {
        return (Formatter) Formatter.class.cast(new SimpleFormatter());
    }

    private ErrorManager defaultErrorManager() {
        ErrorManager errorManager;
        try {
            errorManager = super.getErrorManager();
        } catch (LinkageError | RuntimeException unused) {
            errorManager = null;
        }
        if (errorManager == null) {
            return new ErrorManager();
        }
        return errorManager;
    }

    private String descriptionFrom(Comparator<?> comparator, Level level, Filter filter) {
        StringBuilder sb = new StringBuilder();
        sb.append("Sorted using ");
        sb.append(comparator == null ? "no comparator" : comparator.getClass().getName());
        sb.append(", pushed when ");
        sb.append(level.getName());
        sb.append(", and ");
        sb.append(filter == null ? "no push filter" : filter.getClass().getName());
        sb.append('.');
        return sb.toString();
    }

    private static Filter[] emptyFilterArray() {
        return EMPTY_FILTERS;
    }

    private static Formatter[] emptyFormatterArray() {
        return EMPTY_FORMATTERS;
    }

    private void envelopeFor(Message message, boolean z3) {
        setAcceptLang(message);
        setFrom(message);
        Message.RecipientType recipientType = Message.RecipientType.TO;
        if (!setRecipient(message, "mail.to", recipientType)) {
            setDefaultRecipient(message, recipientType);
        }
        setRecipient(message, "mail.cc", Message.RecipientType.CC);
        setRecipient(message, "mail.bcc", Message.RecipientType.BCC);
        setReplyTo(message);
        setSender(message);
        setMailer(message);
        setAutoSubmitted(message);
        if (z3) {
            setPriority(message);
        }
        try {
            message.setSentDate(new Date());
        } catch (MessagingException e4) {
            reportError(e4.getMessage(), e4, 5);
        }
    }

    private String format(Formatter formatter, LogRecord logRecord) {
        try {
            return formatter.format(logRecord);
        } catch (RuntimeException e4) {
            reportError(e4.getMessage(), e4, 5);
            return "";
        }
    }

    private Object getAndSetContextClassLoader(Object obj) {
        PrivilegedAction getAndSetContext;
        if (obj != GetAndSetContext.NOT_MODIFIED) {
            try {
                if (obj instanceof PrivilegedAction) {
                    getAndSetContext = (PrivilegedAction) obj;
                } else {
                    getAndSetContext = new GetAndSetContext(obj);
                }
                return AccessController.doPrivileged(getAndSetContext);
            } catch (SecurityException unused) {
            }
        }
        return GetAndSetContext.NOT_MODIFIED;
    }

    private String getClassId(Formatter formatter) {
        if (formatter instanceof TailNameFormatter) {
            return String.class.getName();
        }
        return formatter.getClass().getName();
    }

    private String getContentType(String str) {
        String contentType = this.contentTypes.getContentType(str);
        if ("application/octet-stream".equalsIgnoreCase(contentType)) {
            return null;
        }
        return contentType;
    }

    private String getEncodingName() {
        String encoding = getEncoding();
        if (encoding == null) {
            return MimeUtility.getDefaultJavaCharset();
        }
        return encoding;
    }

    private String getLocalHost(Service service) {
        try {
            return LogManagerProperties.getLocalHost(service);
        } catch (Exception e4) {
            reportError(service.toString(), e4, 4);
            return null;
        } catch (LinkageError | NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    private int getMatchedPart() {
        Integer num = MUTEX.get();
        if (num == null || num.intValue() >= readOnlyAttachmentFilters().length) {
            num = MUTEX_PUBLISH;
        }
        return num.intValue();
    }

    private Session getSession(Message message) {
        message.getClass();
        return new MessageContext(message).getSession();
    }

    private void grow() {
        LogRecord[] logRecordArr = this.data;
        int length = logRecordArr.length;
        int i4 = (length >> 1) + length + 1;
        int i5 = this.capacity;
        if (i4 > i5 || i4 < length) {
            i4 = i5;
        }
        this.data = (LogRecord[]) Arrays.copyOf(logRecordArr, i4, LogRecord[].class);
        this.matched = Arrays.copyOf(this.matched, i4);
    }

    private static boolean hasValue(String str) {
        if (!isEmpty(str) && !"null".equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    private String head(Formatter formatter) {
        try {
            return formatter.getHead(this);
        } catch (RuntimeException e4) {
            reportError(e4.getMessage(), e4, 5);
            return "";
        }
    }

    private synchronized void init(Properties properties) {
        String name = getClass().getName();
        this.mailProps = new Properties();
        Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
        this.contentTypes = FileTypeMap.getDefaultFileTypeMap();
        getAndSetContextClassLoader(andSetContextClassLoader);
        initErrorManager(name);
        initLevel(name);
        initFilter(name);
        initCapacity(name);
        initAuthenticator(name);
        initEncoding(name);
        initFormatter(name);
        initComparator(name);
        initPushLevel(name);
        initPushFilter(name);
        initSubject(name);
        initAttachmentFormaters(name);
        initAttachmentFilters(name);
        initAttachmentNames(name);
        if (properties == null && LogManagerProperties.fromLogManager(name.concat(".verify")) != null) {
            verifySettings(initSession());
        }
        intern();
    }

    private void initAttachmentFilters(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".attachment.filters"));
        if (!isEmpty(fromLogManager)) {
            String[] split = fromLogManager.split(",");
            int length = split.length;
            Filter[] filterArr = new Filter[length];
            for (int i4 = 0; i4 < length; i4++) {
                String trim = split[i4].trim();
                split[i4] = trim;
                if (!"null".equalsIgnoreCase(trim)) {
                    try {
                        filterArr[i4] = LogManagerProperties.newFilter(split[i4]);
                    } catch (SecurityException e4) {
                        throw e4;
                    } catch (Exception e5) {
                        reportError(e5.getMessage(), e5, 4);
                    }
                }
            }
            this.attachmentFilters = filterArr;
            if (alignAttachmentFilters()) {
                reportError("Attachment filters.", attachmentMismatch("Length mismatch."), 4);
                return;
            }
            return;
        }
        this.attachmentFilters = emptyFilterArray();
        alignAttachmentFilters();
    }

    private void initAttachmentFormaters(String str) {
        Formatter[] formatterArr;
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".attachment.formatters"));
        if (!isEmpty(fromLogManager)) {
            String[] split = fromLogManager.split(",");
            if (split.length == 0) {
                formatterArr = emptyFormatterArray();
            } else {
                formatterArr = new Formatter[split.length];
            }
            for (int i4 = 0; i4 < formatterArr.length; i4++) {
                String trim = split[i4].trim();
                split[i4] = trim;
                if (!"null".equalsIgnoreCase(trim)) {
                    try {
                        Formatter newFormatter = LogManagerProperties.newFormatter(split[i4]);
                        formatterArr[i4] = newFormatter;
                        if (newFormatter instanceof TailNameFormatter) {
                            reportError("Attachment formatter.", new ClassNotFoundException(formatterArr[i4].toString()), 4);
                            formatterArr[i4] = createSimpleFormatter();
                        }
                    } catch (SecurityException e4) {
                        throw e4;
                    } catch (Exception e5) {
                        reportError(e5.getMessage(), e5, 4);
                        formatterArr[i4] = createSimpleFormatter();
                    }
                } else {
                    reportError("Attachment formatter.", new NullPointerException(atIndexMsg(i4)), 4);
                    formatterArr[i4] = createSimpleFormatter();
                }
            }
            this.attachmentFormatters = formatterArr;
            return;
        }
        this.attachmentFormatters = emptyFormatterArray();
    }

    private void initAttachmentNames(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".attachment.names"));
        if (!isEmpty(fromLogManager)) {
            String[] split = fromLogManager.split(",");
            int length = split.length;
            Formatter[] formatterArr = new Formatter[length];
            for (int i4 = 0; i4 < length; i4++) {
                String trim = split[i4].trim();
                split[i4] = trim;
                if (!"null".equalsIgnoreCase(trim)) {
                    try {
                        try {
                            formatterArr[i4] = LogManagerProperties.newFormatter(split[i4]);
                        } catch (ClassCastException | ClassNotFoundException unused) {
                            formatterArr[i4] = TailNameFormatter.of(split[i4]);
                        }
                    } catch (SecurityException e4) {
                        throw e4;
                    } catch (Exception e5) {
                        reportError(e5.getMessage(), e5, 4);
                    }
                } else {
                    reportError("Attachment names.", new NullPointerException(atIndexMsg(i4)), 4);
                }
            }
            this.attachmentNames = formatterArr;
            if (alignAttachmentNames()) {
                reportError("Attachment names.", attachmentMismatch("Length mismatch."), 4);
                return;
            }
            return;
        }
        this.attachmentNames = emptyFormatterArray();
        alignAttachmentNames();
    }

    private void initAuthenticator(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".authenticator"));
        if (fromLogManager != null && !"null".equalsIgnoreCase(fromLogManager)) {
            if (fromLogManager.length() != 0) {
                try {
                    this.auth = (Authenticator) LogManagerProperties.newObjectFrom(fromLogManager, Authenticator.class);
                    return;
                } catch (ClassCastException | ClassNotFoundException unused) {
                    this.auth = DefaultAuthenticator.of(fromLogManager);
                    return;
                } catch (SecurityException e4) {
                    throw e4;
                } catch (Exception e5) {
                    reportError(e5.getMessage(), e5, 4);
                    return;
                }
            }
            this.auth = DefaultAuthenticator.of(fromLogManager);
        }
    }

    private void initCapacity(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".capacity"));
            if (fromLogManager != null) {
                setCapacity0(Integer.parseInt(fromLogManager));
            } else {
                setCapacity0(1000);
            }
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            reportError(e5.getMessage(), e5, 4);
        }
        if (this.capacity <= 0) {
            this.capacity = 1000;
        }
        LogRecord[] logRecordArr = new LogRecord[1];
        this.data = logRecordArr;
        this.matched = new int[logRecordArr.length];
    }

    private void initComparator(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".comparator"));
            String fromLogManager2 = LogManagerProperties.fromLogManager(str.concat(".comparator.reverse"));
            if (hasValue(fromLogManager)) {
                this.comparator = LogManagerProperties.newComparator(fromLogManager);
                if (Boolean.parseBoolean(fromLogManager2)) {
                    this.comparator = LogManagerProperties.reverseOrder(this.comparator);
                }
            } else if (!isEmpty(fromLogManager2)) {
                throw new IllegalArgumentException("No comparator to reverse.");
            }
        } catch (SecurityException e4) {
            throw e4;
        } catch (Exception e5) {
            reportError(e5.getMessage(), e5, 4);
        }
    }

    private void initEncoding(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".encoding"));
            if (fromLogManager != null) {
                setEncoding0(fromLogManager);
            }
        } catch (UnsupportedEncodingException e4) {
            e = e4;
            reportError(e.getMessage(), e, 4);
        } catch (SecurityException e5) {
            throw e5;
        } catch (RuntimeException e6) {
            e = e6;
            reportError(e.getMessage(), e, 4);
        }
    }

    private void initErrorManager(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".errorManager"));
            if (fromLogManager != null) {
                setErrorManager0(LogManagerProperties.newErrorManager(fromLogManager));
            }
        } catch (SecurityException e4) {
            throw e4;
        } catch (Exception e5) {
            reportError(e5.getMessage(), e5, 4);
        }
    }

    private void initFilter(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".filter"));
            if (hasValue(fromLogManager)) {
                this.filter = LogManagerProperties.newFilter(fromLogManager);
            }
        } catch (SecurityException e4) {
            throw e4;
        } catch (Exception e5) {
            reportError(e5.getMessage(), e5, 4);
        }
    }

    private void initFormatter(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".formatter"));
            if (hasValue(fromLogManager)) {
                Formatter newFormatter = LogManagerProperties.newFormatter(fromLogManager);
                if (!(newFormatter instanceof TailNameFormatter)) {
                    this.formatter = newFormatter;
                } else {
                    this.formatter = createSimpleFormatter();
                }
            } else {
                this.formatter = createSimpleFormatter();
            }
        } catch (SecurityException e4) {
            throw e4;
        } catch (Exception e5) {
            reportError(e5.getMessage(), e5, 4);
            this.formatter = createSimpleFormatter();
        }
    }

    private void initLevel(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".level"));
            if (fromLogManager != null) {
                this.logLevel = Level.parse(fromLogManager);
            } else {
                this.logLevel = Level.WARNING;
            }
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            reportError(e5.getMessage(), e5, 4);
            this.logLevel = Level.WARNING;
        }
    }

    private void initPushFilter(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".pushFilter"));
            if (hasValue(fromLogManager)) {
                this.pushFilter = LogManagerProperties.newFilter(fromLogManager);
            }
        } catch (SecurityException e4) {
            throw e4;
        } catch (Exception e5) {
            reportError(e5.getMessage(), e5, 4);
        }
    }

    private void initPushLevel(String str) {
        try {
            String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".pushLevel"));
            if (fromLogManager != null) {
                this.pushLevel = Level.parse(fromLogManager);
            }
        } catch (RuntimeException e4) {
            reportError(e4.getMessage(), e4, 4);
        }
        if (this.pushLevel == null) {
            this.pushLevel = Level.OFF;
        }
    }

    private Session initSession() {
        Session session = Session.getInstance(new LogManagerProperties(this.mailProps, getClass().getName()), this.auth);
        this.session = session;
        return session;
    }

    private void initSubject(String str) {
        String fromLogManager = LogManagerProperties.fromLogManager(str.concat(".subject"));
        if (fromLogManager == null) {
            fromLogManager = "com.sun.mail.util.logging.CollectorFormatter";
        }
        if (hasValue(fromLogManager)) {
            try {
                this.subjectFormatter = LogManagerProperties.newFormatter(fromLogManager);
                return;
            } catch (ClassCastException | ClassNotFoundException unused) {
                this.subjectFormatter = TailNameFormatter.of(fromLogManager);
                return;
            } catch (SecurityException e4) {
                throw e4;
            } catch (Exception e5) {
                this.subjectFormatter = TailNameFormatter.of(fromLogManager);
                reportError(e5.getMessage(), e5, 4);
                return;
            }
        }
        this.subjectFormatter = TailNameFormatter.of(fromLogManager);
    }

    private void intern() {
        try {
            HashMap hashMap = new HashMap();
            try {
                intern(hashMap, this.errorManager);
            } catch (SecurityException e4) {
                reportError(e4.getMessage(), e4, 4);
            }
            try {
                Filter filter = this.filter;
                Object intern = intern(hashMap, filter);
                if (intern != filter && (intern instanceof Filter)) {
                    this.filter = (Filter) intern;
                }
                Formatter formatter = this.formatter;
                Object intern2 = intern(hashMap, formatter);
                if (intern2 != formatter && (intern2 instanceof Formatter)) {
                    this.formatter = (Formatter) intern2;
                }
            } catch (SecurityException e5) {
                reportError(e5.getMessage(), e5, 4);
            }
            Formatter formatter2 = this.subjectFormatter;
            Object intern3 = intern(hashMap, formatter2);
            if (intern3 != formatter2 && (intern3 instanceof Formatter)) {
                this.subjectFormatter = (Formatter) intern3;
            }
            Filter filter2 = this.pushFilter;
            Object intern4 = intern(hashMap, filter2);
            if (intern4 != filter2 && (intern4 instanceof Filter)) {
                this.pushFilter = (Filter) intern4;
            }
            int i4 = 0;
            while (true) {
                Formatter[] formatterArr = this.attachmentFormatters;
                if (i4 >= formatterArr.length) {
                    return;
                }
                Formatter formatter3 = formatterArr[i4];
                Object intern5 = intern(hashMap, formatter3);
                if (intern5 != formatter3 && (intern5 instanceof Formatter)) {
                    this.attachmentFormatters[i4] = (Formatter) intern5;
                }
                Filter filter3 = this.attachmentFilters[i4];
                Object intern6 = intern(hashMap, filter3);
                if (intern6 != filter3 && (intern6 instanceof Filter)) {
                    this.attachmentFilters[i4] = (Filter) intern6;
                }
                Formatter formatter4 = this.attachmentNames[i4];
                Object intern7 = intern(hashMap, formatter4);
                if (intern7 != formatter4 && (intern7 instanceof Formatter)) {
                    this.attachmentNames[i4] = (Formatter) intern7;
                }
                i4++;
            }
        } catch (Exception e6) {
            reportError(e6.getMessage(), e6, 4);
        } catch (LinkageError e7) {
            reportError(e7.getMessage(), new InvocationTargetException(e7), 4);
        }
    }

    private boolean isAttachmentLoggable(LogRecord logRecord) {
        Filter[] readOnlyAttachmentFilters = readOnlyAttachmentFilters();
        for (int i4 = 0; i4 < readOnlyAttachmentFilters.length; i4++) {
            Filter filter = readOnlyAttachmentFilters[i4];
            if (filter == null || filter.isLoggable(logRecord)) {
                setMatchedPart(i4);
                return true;
            }
        }
        return false;
    }

    private static boolean isEmpty(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }

    private boolean isPushable(LogRecord logRecord) {
        int intValue = getPushLevel().intValue();
        if (intValue != offValue && logRecord.getLevel().intValue() >= intValue) {
            Filter pushFilter = getPushFilter();
            if (pushFilter == null) {
                return true;
            }
            int matchedPart = getMatchedPart();
            if ((matchedPart == -1 && getFilter() == pushFilter) || (matchedPart >= 0 && this.attachmentFilters[matchedPart] == pushFilter)) {
                return true;
            }
            return pushFilter.isLoggable(logRecord);
        }
        return false;
    }

    private Locale localeFor(LogRecord logRecord) {
        ResourceBundle resourceBundle = logRecord.getResourceBundle();
        if (resourceBundle != null) {
            Locale locale = resourceBundle.getLocale();
            if (locale == null || isEmpty(locale.getLanguage())) {
                return Locale.getDefault();
            }
            return locale;
        }
        return null;
    }

    private void publish0(LogRecord logRecord) {
        Message message;
        boolean z3;
        synchronized (this) {
            int i4 = this.size;
            if (i4 == this.data.length && i4 < this.capacity) {
                grow();
            }
            int i5 = this.size;
            message = null;
            if (i5 < this.data.length) {
                this.matched[i5] = getMatchedPart();
                LogRecord[] logRecordArr = this.data;
                int i6 = this.size;
                logRecordArr[i6] = logRecord;
                this.size = i6 + 1;
                z3 = isPushable(logRecord);
                if (z3 || this.size >= this.capacity) {
                    message = writeLogRecords(1);
                }
            } else {
                z3 = false;
            }
        }
        if (message != null) {
            send(message, z3, 1);
        }
    }

    private Filter[] readOnlyAttachmentFilters() {
        return this.attachmentFilters;
    }

    private void releaseMutex() {
        MUTEX.remove();
    }

    private void reportFilterError(LogRecord logRecord) {
        Formatter createSimpleFormatter = createSimpleFormatter();
        reportError("Log record " + logRecord.getSequenceNumber() + " was filtered from all message parts.  " + head(createSimpleFormatter) + format(createSimpleFormatter, logRecord) + tail(createSimpleFormatter, ""), new IllegalArgumentException(getFilter() + ", " + Arrays.asList(readOnlyAttachmentFilters())), 5);
    }

    private void reportLinkageError(Throwable th, int i4) {
        if (th != null) {
            ThreadLocal<Integer> threadLocal = MUTEX;
            Integer num = threadLocal.get();
            if (num == null || num.intValue() > MUTEX_LINKAGE.intValue()) {
                threadLocal.set(MUTEX_LINKAGE);
                try {
                    Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
                    if (num != null) {
                        threadLocal.set(num);
                        return;
                    } else {
                        threadLocal.remove();
                        return;
                    }
                } catch (LinkageError | RuntimeException unused) {
                    if (num != null) {
                        MUTEX.set(num);
                        return;
                    } else {
                        MUTEX.remove();
                        return;
                    }
                } catch (Throwable th2) {
                    if (num != null) {
                        MUTEX.set(num);
                    } else {
                        MUTEX.remove();
                    }
                    throw th2;
                }
            }
            return;
        }
        throw new NullPointerException(String.valueOf(i4));
    }

    private void reportNonDiscriminating(Object obj, Object obj2) {
        reportError("Non discriminating equals implementation.", new IllegalArgumentException(obj.getClass().getName() + " should not be equal to " + obj2.getClass().getName()), 4);
    }

    private void reportNonSymmetric(Object obj, Object obj2) {
        reportError("Non symmetric equals implementation.", new IllegalArgumentException(obj.getClass().getName() + " is not equal to " + obj2.getClass().getName()), 4);
    }

    private void reportNullError(int i4) {
        reportError("null", new NullPointerException(), i4);
    }

    private void reportUnPublishedError(LogRecord logRecord) {
        String str;
        ThreadLocal<Integer> threadLocal = MUTEX;
        Integer num = threadLocal.get();
        if (num == null || num.intValue() > MUTEX_REPORT.intValue()) {
            threadLocal.set(MUTEX_REPORT);
            if (logRecord != null) {
                try {
                    Formatter createSimpleFormatter = createSimpleFormatter();
                    str = "Log record " + logRecord.getSequenceNumber() + " was not published. " + head(createSimpleFormatter) + format(createSimpleFormatter, logRecord) + tail(createSimpleFormatter, "");
                } catch (Throwable th) {
                    if (num != null) {
                        MUTEX.set(num);
                    } else {
                        MUTEX.remove();
                    }
                    throw th;
                }
            } else {
                str = null;
            }
            reportError(str, new IllegalStateException("Recursive publish detected by thread " + Thread.currentThread()), 1);
            if (num != null) {
                threadLocal.set(num);
            } else {
                threadLocal.remove();
            }
        }
    }

    private void reportUnexpectedSend(MimeMessage mimeMessage, String str, Exception exc) {
        Exception messagingException = new MessagingException("An empty message was sent.", exc);
        setErrorContent(mimeMessage, str, messagingException);
        reportError(mimeMessage, messagingException, 4);
    }

    private void reset() {
        int i4 = this.size;
        LogRecord[] logRecordArr = this.data;
        if (i4 < logRecordArr.length) {
            Arrays.fill(logRecordArr, 0, i4, (Object) null);
        } else {
            Arrays.fill(logRecordArr, (Object) null);
        }
        this.size = 0;
    }

    private void saveChangesNoContent(Message message, String str) {
        if (message != null) {
            try {
                try {
                    message.saveChanges();
                } catch (RuntimeException | MessagingException e4) {
                    reportError(str, e4, 5);
                }
            } catch (NullPointerException e5) {
                try {
                    if (message.getHeader("Content-Transfer-Encoding") == null) {
                        message.setHeader("Content-Transfer-Encoding", "base64");
                        message.saveChanges();
                        return;
                    }
                    throw e5;
                } catch (RuntimeException | MessagingException e6) {
                    if (e6 != e5) {
                        e6.addSuppressed(e5);
                    }
                    throw e6;
                }
            }
        }
    }

    private void send(Message message, boolean z3, int i4) {
        try {
            envelopeFor(message, z3);
            Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
            Transport.send(message);
            getAndSetContextClassLoader(andSetContextClassLoader);
        } catch (RuntimeException e4) {
            reportError(message, e4, i4);
        } catch (Exception e5) {
            reportError(message, e5, i4);
        }
    }

    private void setAcceptLang(Part part) {
        try {
            String languageTag = LogManagerProperties.toLanguageTag(Locale.getDefault());
            if (languageTag.length() != 0) {
                part.setHeader(HttpHeaders.ACCEPT_LANGUAGE, languageTag);
            }
        } catch (MessagingException e4) {
            reportError(e4.getMessage(), e4, 5);
        }
    }

    private void setAuthenticator0(Authenticator authenticator) {
        Session updateSession;
        checkAccess();
        synchronized (this) {
            if (!this.isWriting) {
                this.auth = authenticator;
                updateSession = updateSession();
            } else {
                throw new IllegalStateException();
            }
        }
        verifySettings(updateSession);
    }

    private void setAutoSubmitted(Message message) {
        if (allowRestrictedHeaders()) {
            try {
                message.setHeader("auto-submitted", "auto-generated");
            } catch (MessagingException e4) {
                reportError(e4.getMessage(), e4, 5);
            }
        }
    }

    private synchronized void setCapacity0(int i4) {
        checkAccess();
        if (i4 > 0) {
            if (!this.isWriting) {
                if (this.capacity < 0) {
                    this.capacity = -i4;
                } else {
                    this.capacity = i4;
                }
            } else {
                throw new IllegalStateException();
            }
        } else {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
    }

    private void setContent(MimePart mimePart, CharSequence charSequence, String str) throws MessagingException {
        String encodingName = getEncodingName();
        if (str != null && !"text/plain".equalsIgnoreCase(str)) {
            try {
                mimePart.setDataHandler(new DataHandler(new ByteArrayDataSource(charSequence.toString(), contentWithEncoding(str, encodingName))));
                return;
            } catch (IOException e4) {
                reportError(e4.getMessage(), e4, 5);
                mimePart.setText(charSequence.toString(), encodingName);
                return;
            }
        }
        mimePart.setText(charSequence.toString(), MimeUtility.mimeCharset(encodingName));
    }

    private void setDefaultFrom(Message message) {
        try {
            message.setFrom();
        } catch (MessagingException e4) {
            reportError(e4.getMessage(), e4, 5);
        }
    }

    private void setDefaultRecipient(Message message, Message.RecipientType recipientType) {
        try {
            InternetAddress localAddress = InternetAddress.getLocalAddress(getSession(message));
            if (localAddress != null) {
                message.setRecipient(recipientType, localAddress);
                return;
            }
            MimeMessage mimeMessage = new MimeMessage(getSession(message));
            mimeMessage.setFrom();
            Address[] from = mimeMessage.getFrom();
            if (from.length > 0) {
                message.setRecipients(recipientType, from);
                return;
            }
            throw new MessagingException("No local address.");
        } catch (RuntimeException | MessagingException e4) {
            reportError("Unable to compute a default recipient.", e4, 5);
        }
    }

    private void setEncoding0(String str) throws UnsupportedEncodingException {
        if (str != null) {
            try {
                if (!Charset.isSupported(str)) {
                    throw new UnsupportedEncodingException(str);
                }
            } catch (IllegalCharsetNameException unused) {
                throw new UnsupportedEncodingException(str);
            }
        }
        synchronized (this) {
            this.encoding = str;
        }
    }

    private void setErrorContent(MimeMessage mimeMessage, String str, Throwable th) {
        MimeBodyPart createBodyPart;
        String descriptionFrom;
        String classId;
        String name;
        try {
            synchronized (this) {
                createBodyPart = createBodyPart();
                descriptionFrom = descriptionFrom(this.comparator, this.pushLevel, this.pushFilter);
                classId = getClassId(this.subjectFormatter);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Formatted using ");
            if (th == null) {
                name = Throwable.class.getName();
            } else {
                name = th.getClass().getName();
            }
            sb.append(name);
            sb.append(", filtered with ");
            sb.append(str);
            sb.append(", and named by ");
            sb.append(classId);
            sb.append('.');
            createBodyPart.setDescription(sb.toString());
            setContent(createBodyPart, toMsgString(th), "text/plain");
            Multipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(createBodyPart);
            mimeMessage.setContent(mimeMultipart);
            mimeMessage.setDescription(descriptionFrom);
            setAcceptLang(mimeMessage);
            mimeMessage.saveChanges();
        } catch (RuntimeException | MessagingException e4) {
            reportError("Unable to create body.", e4, 4);
        }
    }

    private void setErrorManager0(ErrorManager errorManager) {
        errorManager.getClass();
        try {
            synchronized (this) {
                this.errorManager = errorManager;
                super.setErrorManager(errorManager);
            }
        } catch (LinkageError | RuntimeException unused) {
        }
    }

    private void setFrom(Message message) {
        String property = getSession(message).getProperty("mail.from");
        if (property != null) {
            try {
                InternetAddress[] parse = InternetAddress.parse(property, false);
                if (parse.length > 0) {
                    if (parse.length == 1) {
                        message.setFrom(parse[0]);
                    } else {
                        message.addFrom(parse);
                    }
                }
                return;
            } catch (MessagingException e4) {
                reportError(e4.getMessage(), e4, 5);
                setDefaultFrom(message);
                return;
            }
        }
        setDefaultFrom(message);
    }

    private void setIncompleteCopy(Message message) {
        try {
            message.setHeader("Incomplete-Copy", "");
        } catch (MessagingException e4) {
            reportError(e4.getMessage(), e4, 5);
        }
    }

    private void setMailProperties0(Properties properties) {
        Session updateSession;
        checkAccess();
        Properties properties2 = (Properties) properties.clone();
        synchronized (this) {
            if (!this.isWriting) {
                this.mailProps = properties2;
                updateSession = updateSession();
            } else {
                throw new IllegalStateException();
            }
        }
        verifySettings(updateSession);
    }

    private void setMailer(Message message) {
        String replaceAll;
        String fold;
        try {
            Class<?> cls = getClass();
            if (cls == MailHandler.class) {
                fold = MailHandler.class.getName();
            } else {
                try {
                    replaceAll = MimeUtility.encodeText(cls.getName());
                } catch (UnsupportedEncodingException e4) {
                    reportError(e4.getMessage(), e4, 5);
                    replaceAll = cls.getName().replaceAll("[^\\x00-\\x7F]", "\u001a");
                }
                fold = MimeUtility.fold(10, MailHandler.class.getName() + " using the " + replaceAll + " extension.");
            }
            message.setHeader("X-Mailer", fold);
        } catch (MessagingException e5) {
            reportError(e5.getMessage(), e5, 5);
        }
    }

    private void setMatchedPart(int i4) {
        Integer num = MUTEX_PUBLISH;
        ThreadLocal<Integer> threadLocal = MUTEX;
        if (num.equals(threadLocal.get())) {
            threadLocal.set(Integer.valueOf(i4));
        }
    }

    private void setPriority(Message message) {
        try {
            message.setHeader("Importance", "High");
            message.setHeader("Priority", "urgent");
            message.setHeader("X-Priority", ExifInterface.GPS_MEASUREMENT_2D);
        } catch (MessagingException e4) {
            reportError(e4.getMessage(), e4, 5);
        }
    }

    private boolean setRecipient(Message message, String str, Message.RecipientType recipientType) {
        boolean z3;
        String property = getSession(message).getProperty(str);
        if (property != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!isEmpty(property)) {
            try {
                InternetAddress[] parse = InternetAddress.parse(property, false);
                if (parse.length > 0) {
                    message.setRecipients(recipientType, parse);
                }
            } catch (MessagingException e4) {
                reportError(e4.getMessage(), e4, 5);
            }
        }
        return z3;
    }

    private void setReplyTo(Message message) {
        String property = getSession(message).getProperty("mail.reply.to");
        if (!isEmpty(property)) {
            try {
                InternetAddress[] parse = InternetAddress.parse(property, false);
                if (parse.length > 0) {
                    message.setReplyTo(parse);
                }
            } catch (MessagingException e4) {
                reportError(e4.getMessage(), e4, 5);
            }
        }
    }

    private void setSender(Message message) {
        String property = getSession(message).getProperty("mail.sender");
        if (!isEmpty(property)) {
            try {
                InternetAddress[] parse = InternetAddress.parse(property, false);
                if (parse.length > 0) {
                    ((MimeMessage) message).setSender(parse[0]);
                    if (parse.length > 1) {
                        reportError("Ignoring other senders.", tooManyAddresses(parse, 1), 5);
                    }
                }
            } catch (MessagingException e4) {
                reportError(e4.getMessage(), e4, 5);
            }
        }
    }

    private void sort() {
        Comparator<? super LogRecord> comparator = this.comparator;
        if (comparator != null) {
            try {
                int i4 = this.size;
                if (i4 != 1) {
                    Arrays.sort(this.data, 0, i4, comparator);
                    return;
                }
                LogRecord logRecord = this.data[0];
                if (comparator.compare(logRecord, logRecord) != 0) {
                    throw new IllegalArgumentException(this.comparator.getClass().getName());
                }
            } catch (RuntimeException e4) {
                reportError(e4.getMessage(), e4, 5);
            }
        }
    }

    private String tail(Formatter formatter, String str) {
        try {
            return formatter.getTail(this);
        } catch (RuntimeException e4) {
            reportError(e4.getMessage(), e4, 5);
            return str;
        }
    }

    private String toMsgString(Throwable th) {
        if (th == null) {
            return "null";
        }
        String encodingName = getEncodingName();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, encodingName);
            try {
                PrintWriter printWriter = new PrintWriter(outputStreamWriter);
                printWriter.println(th.getMessage());
                th.printStackTrace(printWriter);
                printWriter.flush();
                printWriter.close();
                outputStreamWriter.close();
                return byteArrayOutputStream.toString(encodingName);
            } catch (Throwable th2) {
                try {
                    outputStreamWriter.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (RuntimeException e4) {
            return th.toString() + ' ' + e4.toString();
        } catch (Exception e5) {
            return th.toString() + ' ' + e5.toString();
        }
    }

    private String toRawString(Message message) throws MessagingException, IOException {
        if (message != null) {
            Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(message.getSize() + 1024, 1024));
                message.writeTo(byteArrayOutputStream);
                return byteArrayOutputStream.toString("UTF-8");
            } finally {
                getAndSetContextClassLoader(andSetContextClassLoader);
            }
        }
        return null;
    }

    private String toString(Formatter formatter) {
        String obj = formatter.toString();
        if (!isEmpty(obj)) {
            return obj;
        }
        return getClassId(formatter);
    }

    private AddressException tooManyAddresses(Address[] addressArr, int i4) {
        return new AddressException(Arrays.asList(addressArr).subList(i4, addressArr.length).toString());
    }

    private boolean tryMutex() {
        ThreadLocal<Integer> threadLocal = MUTEX;
        if (threadLocal.get() == null) {
            threadLocal.set(MUTEX_PUBLISH);
            return true;
        }
        return false;
    }

    private Session updateSession() {
        if (this.mailProps.getProperty("verify") != null) {
            return initSession();
        }
        this.session = null;
        return null;
    }

    private static void verifyAddresses(Address[] addressArr) throws AddressException {
        if (addressArr != null) {
            for (Address address : addressArr) {
                if (address instanceof InternetAddress) {
                    ((InternetAddress) address).validate();
                }
            }
        }
    }

    private static InetAddress verifyHost(String str) throws IOException {
        InetAddress byName;
        if (isEmpty(str)) {
            byName = InetAddress.getLocalHost();
        } else {
            byName = InetAddress.getByName(str);
        }
        if (byName.getCanonicalHostName().length() != 0) {
            return byName;
        }
        throw new UnknownHostException();
    }

    private static void verifyProperties(Session session, String str) {
        session.getProperty("mail.from");
        session.getProperty("mail." + str + ".from");
        session.getProperty("mail.dsn.ret");
        session.getProperty("mail." + str + ".dsn.ret");
        session.getProperty("mail.dsn.notify");
        session.getProperty("mail." + str + ".dsn.notify");
        session.getProperty("mail." + str + ".port");
        session.getProperty("mail.user");
        session.getProperty("mail." + str + ".user");
        session.getProperty("mail." + str + ".localport");
    }

    private void verifySettings(Session session) {
        if (session != null) {
            try {
                Object put = session.getProperties().put("verify", "");
                if (put instanceof String) {
                    String str = (String) put;
                    if (hasValue(str)) {
                        verifySettings0(session, str);
                    }
                } else if (put != null) {
                    verifySettings0(session, put.getClass().toString());
                }
            } catch (LinkageError e4) {
                reportLinkageError(e4, 4);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(17:(10:51|(1:53)(1:131)|54|(1:56)(1:130)|57|(4:119|120|(2:122|(1:124))(1:127)|125)|59|(14:87|88|(1:92)|93|94|95|96|97|2a0|104|(1:106)|107|108|109)|61|(6:63|(1:65)|66|(1:(2:83|84))(3:70|(3:73|(1:75)(3:76|77|78)|71)|79)|80|81)(2:85|86))|136|137|(1:139)|141|142|143|144|145|(1:147)(1:153)|148|(1:150)|151|59|(0)|61|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:45|46|(17:(10:51|(1:53)(1:131)|54|(1:56)(1:130)|57|(4:119|120|(2:122|(1:124))(1:127)|125)|59|(14:87|88|(1:92)|93|94|95|96|97|2a0|104|(1:106)|107|108|109)|61|(6:63|(1:65)|66|(1:(2:83|84))(3:70|(3:73|(1:75)(3:76|77|78)|71)|79)|80|81)(2:85|86))|136|137|(1:139)|141|142|143|144|145|(1:147)(1:153)|148|(1:150)|151|59|(0)|61|(0)(0))|132|133|134|135) */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0204, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0205, code lost:
        r14 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x021e, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0220, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0225, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0226, code lost:
        r2 = r0;
        r13 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0237 A[Catch: Exception -> 0x0393, RuntimeException -> 0x039c, TryCatch #10 {Exception -> 0x0393, blocks: (B:32:0x00d8, B:34:0x00de, B:36:0x00e1, B:41:0x00ec, B:43:0x00ef, B:51:0x0115, B:53:0x011e, B:56:0x0128, B:58:0x0153, B:60:0x015f, B:62:0x017f, B:64:0x01b3, B:66:0x01bb, B:68:0x01c9, B:70:0x01d2, B:71:0x01d7, B:125:0x0265, B:127:0x026d, B:129:0x0275, B:131:0x027d, B:132:0x0281, B:138:0x0293, B:149:0x02f7, B:158:0x0304, B:155:0x02ff, B:156:0x0302, B:159:0x030f, B:161:0x0312, B:163:0x0321, B:164:0x0327, B:166:0x0331, B:168:0x0334, B:169:0x0338, B:171:0x033b, B:173:0x0343, B:174:0x0346, B:175:0x0366, B:177:0x0369, B:178:0x0371, B:179:0x037d, B:180:0x037e, B:181:0x0385, B:137:0x0288, B:76:0x01df, B:63:0x019a, B:59:0x015a, B:77:0x01ec, B:83:0x01ff, B:87:0x0206, B:89:0x020e, B:123:0x025d, B:90:0x0212, B:107:0x0231, B:109:0x0237, B:112:0x0240, B:114:0x0246, B:116:0x0249, B:117:0x024f, B:119:0x0255, B:121:0x0258, B:100:0x0228, B:104:0x022e, B:44:0x00fb, B:45:0x0105, B:39:0x00e6, B:48:0x0108, B:50:0x0112, B:188:0x038f, B:189:0x0392), top: B:211:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x025d A[Catch: Exception -> 0x0393, RuntimeException -> 0x039c, TryCatch #10 {Exception -> 0x0393, blocks: (B:32:0x00d8, B:34:0x00de, B:36:0x00e1, B:41:0x00ec, B:43:0x00ef, B:51:0x0115, B:53:0x011e, B:56:0x0128, B:58:0x0153, B:60:0x015f, B:62:0x017f, B:64:0x01b3, B:66:0x01bb, B:68:0x01c9, B:70:0x01d2, B:71:0x01d7, B:125:0x0265, B:127:0x026d, B:129:0x0275, B:131:0x027d, B:132:0x0281, B:138:0x0293, B:149:0x02f7, B:158:0x0304, B:155:0x02ff, B:156:0x0302, B:159:0x030f, B:161:0x0312, B:163:0x0321, B:164:0x0327, B:166:0x0331, B:168:0x0334, B:169:0x0338, B:171:0x033b, B:173:0x0343, B:174:0x0346, B:175:0x0366, B:177:0x0369, B:178:0x0371, B:179:0x037d, B:180:0x037e, B:181:0x0385, B:137:0x0288, B:76:0x01df, B:63:0x019a, B:59:0x015a, B:77:0x01ec, B:83:0x01ff, B:87:0x0206, B:89:0x020e, B:123:0x025d, B:90:0x0212, B:107:0x0231, B:109:0x0237, B:112:0x0240, B:114:0x0246, B:116:0x0249, B:117:0x024f, B:119:0x0255, B:121:0x0258, B:100:0x0228, B:104:0x022e, B:44:0x00fb, B:45:0x0105, B:39:0x00e6, B:48:0x0108, B:50:0x0112, B:188:0x038f, B:189:0x0392), top: B:211:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0312 A[Catch: Exception -> 0x0393, RuntimeException -> 0x039c, TryCatch #10 {Exception -> 0x0393, blocks: (B:32:0x00d8, B:34:0x00de, B:36:0x00e1, B:41:0x00ec, B:43:0x00ef, B:51:0x0115, B:53:0x011e, B:56:0x0128, B:58:0x0153, B:60:0x015f, B:62:0x017f, B:64:0x01b3, B:66:0x01bb, B:68:0x01c9, B:70:0x01d2, B:71:0x01d7, B:125:0x0265, B:127:0x026d, B:129:0x0275, B:131:0x027d, B:132:0x0281, B:138:0x0293, B:149:0x02f7, B:158:0x0304, B:155:0x02ff, B:156:0x0302, B:159:0x030f, B:161:0x0312, B:163:0x0321, B:164:0x0327, B:166:0x0331, B:168:0x0334, B:169:0x0338, B:171:0x033b, B:173:0x0343, B:174:0x0346, B:175:0x0366, B:177:0x0369, B:178:0x0371, B:179:0x037d, B:180:0x037e, B:181:0x0385, B:137:0x0288, B:76:0x01df, B:63:0x019a, B:59:0x015a, B:77:0x01ec, B:83:0x01ff, B:87:0x0206, B:89:0x020e, B:123:0x025d, B:90:0x0212, B:107:0x0231, B:109:0x0237, B:112:0x0240, B:114:0x0246, B:116:0x0249, B:117:0x024f, B:119:0x0255, B:121:0x0258, B:100:0x0228, B:104:0x022e, B:44:0x00fb, B:45:0x0105, B:39:0x00e6, B:48:0x0108, B:50:0x0112, B:188:0x038f, B:189:0x0392), top: B:211:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x037e A[Catch: Exception -> 0x0393, RuntimeException -> 0x039c, TryCatch #10 {Exception -> 0x0393, blocks: (B:32:0x00d8, B:34:0x00de, B:36:0x00e1, B:41:0x00ec, B:43:0x00ef, B:51:0x0115, B:53:0x011e, B:56:0x0128, B:58:0x0153, B:60:0x015f, B:62:0x017f, B:64:0x01b3, B:66:0x01bb, B:68:0x01c9, B:70:0x01d2, B:71:0x01d7, B:125:0x0265, B:127:0x026d, B:129:0x0275, B:131:0x027d, B:132:0x0281, B:138:0x0293, B:149:0x02f7, B:158:0x0304, B:155:0x02ff, B:156:0x0302, B:159:0x030f, B:161:0x0312, B:163:0x0321, B:164:0x0327, B:166:0x0331, B:168:0x0334, B:169:0x0338, B:171:0x033b, B:173:0x0343, B:174:0x0346, B:175:0x0366, B:177:0x0369, B:178:0x0371, B:179:0x037d, B:180:0x037e, B:181:0x0385, B:137:0x0288, B:76:0x01df, B:63:0x019a, B:59:0x015a, B:77:0x01ec, B:83:0x01ff, B:87:0x0206, B:89:0x020e, B:123:0x025d, B:90:0x0212, B:107:0x0231, B:109:0x0237, B:112:0x0240, B:114:0x0246, B:116:0x0249, B:117:0x024f, B:119:0x0255, B:121:0x0258, B:100:0x0228, B:104:0x022e, B:44:0x00fb, B:45:0x0105, B:39:0x00e6, B:48:0x0108, B:50:0x0112, B:188:0x038f, B:189:0x0392), top: B:211:0x00d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x026d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void verifySettings0(javax.mail.Session r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 936
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.verifySettings0(javax.mail.Session, java.lang.String):void");
    }

    private Message writeLogRecords(int i4) {
        try {
            synchronized (this) {
                if (this.size > 0 && !this.isWriting) {
                    this.isWriting = true;
                    Message writeLogRecords0 = writeLogRecords0();
                    this.isWriting = false;
                    if (this.size > 0) {
                        reset();
                    }
                    return writeLogRecords0;
                }
                return null;
            }
        } catch (RuntimeException e4) {
            reportError(e4.getMessage(), e4, i4);
            return null;
        } catch (Exception e5) {
            reportError(e5.getMessage(), e5, i4);
            return null;
        }
    }

    private Message writeLogRecords0() throws Exception {
        MimePart createBodyPart;
        StringBuilder sb;
        Filter filter;
        boolean z3;
        sort();
        if (this.session == null) {
            initSession();
        }
        MimeMessage mimeMessage = new MimeMessage(this.session);
        int length = this.attachmentFormatters.length;
        BodyPart[] bodyPartArr = new MimeBodyPart[length];
        CharSequence[] charSequenceArr = new StringBuilder[length];
        if (length == 0) {
            mimeMessage.setDescription(descriptionFrom(getFormatter(), getFilter(), this.subjectFormatter));
            createBodyPart = mimeMessage;
        } else {
            mimeMessage.setDescription(descriptionFrom(this.comparator, this.pushLevel, this.pushFilter));
            createBodyPart = createBodyPart();
        }
        appendSubject(mimeMessage, head(this.subjectFormatter));
        Formatter formatter = getFormatter();
        Filter filter2 = getFilter();
        LogRecord logRecord = null;
        StringBuilder sb2 = null;
        Object obj = null;
        int i4 = 0;
        while (i4 < this.size) {
            int i5 = this.matched[i4];
            LogRecord[] logRecordArr = this.data;
            LogRecord logRecord2 = logRecordArr[i4];
            logRecordArr[i4] = logRecord;
            Locale localeFor = localeFor(logRecord2);
            appendSubject(mimeMessage, format(this.subjectFormatter, logRecord2));
            if (filter2 != null && i5 != -1 && length != 0 && (i5 >= -1 || !filter2.isLoggable(logRecord2))) {
                z3 = false;
                filter = null;
            } else {
                if (sb2 == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(head(formatter));
                    sb2 = sb3;
                }
                sb2.append(format(formatter, logRecord2));
                if (localeFor != null && !localeFor.equals(obj)) {
                    appendContentLang(createBodyPart, localeFor);
                }
                filter = filter2;
                z3 = true;
            }
            Filter filter3 = filter2;
            Filter filter4 = filter;
            int i6 = 0;
            while (i6 < length) {
                StringBuilder sb4 = sb2;
                Filter filter5 = this.attachmentFilters[i6];
                if (filter5 == null || filter4 == filter5 || i5 == i6 || (i5 < i6 && filter5.isLoggable(logRecord2))) {
                    if (filter4 == null && filter5 != null) {
                        filter4 = filter5;
                    }
                    if (bodyPartArr[i6] == null) {
                        bodyPartArr[i6] = createBodyPart(i6);
                        StringBuilder sb5 = new StringBuilder();
                        charSequenceArr[i6] = sb5;
                        sb5.append(head(this.attachmentFormatters[i6]));
                        appendFileName(bodyPartArr[i6], head(this.attachmentNames[i6]));
                    }
                    appendFileName(bodyPartArr[i6], format(this.attachmentNames[i6], logRecord2));
                    charSequenceArr[i6].append(format(this.attachmentFormatters[i6], logRecord2));
                    if (localeFor != null && !localeFor.equals(obj)) {
                        appendContentLang(bodyPartArr[i6], localeFor);
                    }
                    z3 = true;
                }
                i6++;
                sb2 = sb4;
            }
            StringBuilder sb6 = sb2;
            if (z3) {
                if (createBodyPart != mimeMessage && localeFor != null && !localeFor.equals(obj)) {
                    appendContentLang(mimeMessage, localeFor);
                }
            } else {
                reportFilterError(logRecord2);
            }
            i4++;
            obj = localeFor;
            filter2 = filter3;
            sb2 = sb6;
            logRecord = null;
        }
        this.size = 0;
        for (int i7 = length - 1; i7 >= 0; i7--) {
            MimeBodyPart mimeBodyPart = bodyPartArr[i7];
            if (mimeBodyPart != null) {
                appendFileName(mimeBodyPart, tail(this.attachmentNames[i7], NotificationCompat.CATEGORY_ERROR));
                charSequenceArr[i7].append(tail(this.attachmentFormatters[i7], ""));
                if (charSequenceArr[i7].length() > 0) {
                    String fileName = bodyPartArr[i7].getFileName();
                    if (isEmpty(fileName)) {
                        fileName = toString(this.attachmentFormatters[i7]);
                        bodyPartArr[i7].setFileName(fileName);
                    }
                    setContent(bodyPartArr[i7], charSequenceArr[i7], getContentType(fileName));
                    sb = null;
                } else {
                    setIncompleteCopy(mimeMessage);
                    sb = null;
                    bodyPartArr[i7] = null;
                }
                charSequenceArr[i7] = sb;
            }
        }
        if (sb2 != null) {
            sb2.append(tail(formatter, ""));
        } else {
            sb2 = new StringBuilder(0);
        }
        appendSubject(mimeMessage, tail(this.subjectFormatter, ""));
        String contentTypeOf = contentTypeOf(sb2);
        String contentTypeOf2 = contentTypeOf(formatter);
        if (contentTypeOf2 != null) {
            contentTypeOf = contentTypeOf2;
        }
        setContent(createBodyPart, sb2, contentTypeOf);
        if (createBodyPart != mimeMessage) {
            Multipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart((BodyPart) createBodyPart);
            for (int i8 = 0; i8 < length; i8++) {
                BodyPart bodyPart = bodyPartArr[i8];
                if (bodyPart != null) {
                    mimeMultipart.addBodyPart(bodyPart);
                }
            }
            mimeMessage.setContent(mimeMultipart);
        }
        return mimeMessage;
    }

    @Override // java.util.logging.Handler
    public void close() {
        Message writeLogRecords;
        try {
            checkAccess();
            synchronized (this) {
                writeLogRecords = writeLogRecords(3);
                this.logLevel = Level.OFF;
                int i4 = this.capacity;
                if (i4 > 0) {
                    this.capacity = -i4;
                }
                if (this.size == 0 && this.data.length != 1) {
                    LogRecord[] logRecordArr = new LogRecord[1];
                    this.data = logRecordArr;
                    this.matched = new int[logRecordArr.length];
                }
            }
            if (writeLogRecords != null) {
                send(writeLogRecords, false, 3);
            }
        } catch (LinkageError e4) {
            reportLinkageError(e4, 3);
        }
    }

    final String contentTypeOf(CharSequence charSequence) {
        if (isEmpty(charSequence)) {
            return null;
        }
        if (charSequence.length() > 25) {
            charSequence = charSequence.subSequence(0, 25);
        }
        try {
            return URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(charSequence.toString().getBytes(getEncodingName())));
        } catch (IOException e4) {
            reportError(e4.getMessage(), e4, 5);
            return null;
        }
    }

    @Override // java.util.logging.Handler
    public void flush() {
        push(false, 2);
    }

    public final Filter[] getAttachmentFilters() {
        return (Filter[]) readOnlyAttachmentFilters().clone();
    }

    public final Formatter[] getAttachmentFormatters() {
        Formatter[] formatterArr;
        synchronized (this) {
            formatterArr = this.attachmentFormatters;
        }
        return (Formatter[]) formatterArr.clone();
    }

    public final Formatter[] getAttachmentNames() {
        Formatter[] formatterArr;
        synchronized (this) {
            formatterArr = this.attachmentNames;
        }
        return (Formatter[]) formatterArr.clone();
    }

    public final synchronized Authenticator getAuthenticator() {
        checkAccess();
        return this.auth;
    }

    public final synchronized int getCapacity() {
        return Math.abs(this.capacity);
    }

    public final synchronized Comparator<? super LogRecord> getComparator() {
        return this.comparator;
    }

    @Override // java.util.logging.Handler
    public synchronized String getEncoding() {
        return this.encoding;
    }

    @Override // java.util.logging.Handler
    public ErrorManager getErrorManager() {
        checkAccess();
        return this.errorManager;
    }

    @Override // java.util.logging.Handler
    public Filter getFilter() {
        return this.filter;
    }

    @Override // java.util.logging.Handler
    public synchronized Formatter getFormatter() {
        return this.formatter;
    }

    @Override // java.util.logging.Handler
    public Level getLevel() {
        return this.logLevel;
    }

    public final Properties getMailProperties() {
        Properties properties;
        checkAccess();
        synchronized (this) {
            properties = this.mailProps;
        }
        return (Properties) properties.clone();
    }

    public final synchronized Filter getPushFilter() {
        return this.pushFilter;
    }

    public final synchronized Level getPushLevel() {
        return this.pushLevel;
    }

    public final synchronized Formatter getSubject() {
        return this.subjectFormatter;
    }

    @Override // java.util.logging.Handler
    public boolean isLoggable(LogRecord logRecord) {
        int intValue;
        if (logRecord == null || logRecord.getLevel().intValue() < (intValue = getLevel().intValue()) || intValue == offValue) {
            return false;
        }
        Filter filter = getFilter();
        if (filter != null && !filter.isLoggable(logRecord)) {
            return isAttachmentLoggable(logRecord);
        }
        setMatchedPart(-1);
        return true;
    }

    final boolean isMissingContent(Message message, Throwable th) {
        Object andSetContextClassLoader = getAndSetContextClassLoader(MAILHANDLER_LOADER);
        try {
            try {
                message.writeTo(new ByteArrayOutputStream(1024));
            } catch (RuntimeException e4) {
                throw e4;
            } catch (Exception e5) {
                String message2 = e5.getMessage();
                if (!isEmpty(message2)) {
                    int i4 = 0;
                    while (th != null) {
                        if (e5.getClass() == th.getClass() && message2.equals(th.getMessage())) {
                            getAndSetContextClassLoader(andSetContextClassLoader);
                            return true;
                        }
                        Throwable cause = th.getCause();
                        if (cause == null && (th instanceof MessagingException)) {
                            th = ((MessagingException) th).getNextException();
                        } else {
                            th = cause;
                        }
                        i4++;
                        if (i4 == 65536) {
                            break;
                        }
                    }
                }
            }
            getAndSetContextClassLoader(andSetContextClassLoader);
            return false;
        } catch (Throwable th2) {
            getAndSetContextClassLoader(andSetContextClassLoader);
            throw th2;
        }
    }

    public void preDestroy() {
        push(false, 3);
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        if (tryMutex()) {
            try {
                try {
                    if (isLoggable(logRecord)) {
                        if (logRecord != null) {
                            logRecord.getSourceMethodName();
                            publish0(logRecord);
                        } else {
                            reportNullError(1);
                        }
                    }
                } catch (LinkageError e4) {
                    reportLinkageError(e4, 1);
                }
                return;
            } finally {
                releaseMutex();
            }
        }
        reportUnPublishedError(logRecord);
    }

    public void push() {
        push(true, 2);
    }

    @Override // java.util.logging.Handler
    protected void reportError(String str, Exception exc, int i4) {
        try {
            if (str != null) {
                this.errorManager.error(Level.SEVERE.getName().concat(": ").concat(str), exc, i4);
            } else {
                this.errorManager.error(null, exc, i4);
            }
        } catch (LinkageError | RuntimeException e4) {
            reportLinkageError(e4, i4);
        }
    }

    public final void setAttachmentFilters(Filter... filterArr) {
        Filter[] filterArr2;
        checkAccess();
        if (filterArr.length == 0) {
            filterArr2 = emptyFilterArray();
        } else {
            filterArr2 = (Filter[]) Arrays.copyOf(filterArr, filterArr.length, Filter[].class);
        }
        synchronized (this) {
            Formatter[] formatterArr = this.attachmentFormatters;
            if (formatterArr.length == filterArr2.length) {
                if (!this.isWriting) {
                    if (this.size != 0) {
                        int i4 = 0;
                        while (true) {
                            if (i4 >= filterArr2.length) {
                                break;
                            } else if (filterArr2[i4] != this.attachmentFilters[i4]) {
                                clearMatches(i4);
                                break;
                            } else {
                                i4++;
                            }
                        }
                    }
                    this.attachmentFilters = filterArr2;
                } else {
                    throw new IllegalStateException();
                }
            } else {
                throw attachmentMismatch(formatterArr.length, filterArr2.length);
            }
        }
    }

    public final void setAttachmentFormatters(Formatter... formatterArr) {
        Formatter[] formatterArr2;
        checkAccess();
        if (formatterArr.length == 0) {
            formatterArr2 = emptyFormatterArray();
        } else {
            formatterArr2 = (Formatter[]) Arrays.copyOf(formatterArr, formatterArr.length, Formatter[].class);
            for (int i4 = 0; i4 < formatterArr2.length; i4++) {
                if (formatterArr2[i4] == null) {
                    throw new NullPointerException(atIndexMsg(i4));
                }
            }
        }
        synchronized (this) {
            if (!this.isWriting) {
                this.attachmentFormatters = formatterArr2;
                alignAttachmentFilters();
                alignAttachmentNames();
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final void setAttachmentNames(String... strArr) {
        Formatter[] formatterArr;
        checkAccess();
        if (strArr.length == 0) {
            formatterArr = emptyFormatterArray();
        } else {
            formatterArr = new Formatter[strArr.length];
        }
        for (int i4 = 0; i4 < strArr.length; i4++) {
            String str = strArr[i4];
            if (str != null) {
                if (str.length() > 0) {
                    formatterArr[i4] = TailNameFormatter.of(str);
                } else {
                    throw new IllegalArgumentException(atIndexMsg(i4));
                }
            } else {
                throw new NullPointerException(atIndexMsg(i4));
            }
        }
        synchronized (this) {
            Formatter[] formatterArr2 = this.attachmentFormatters;
            if (formatterArr2.length == strArr.length) {
                if (!this.isWriting) {
                    this.attachmentNames = formatterArr;
                } else {
                    throw new IllegalStateException();
                }
            } else {
                throw attachmentMismatch(formatterArr2.length, strArr.length);
            }
        }
    }

    public final void setAuthenticator(Authenticator authenticator) {
        setAuthenticator0(authenticator);
    }

    public final synchronized void setComparator(Comparator<? super LogRecord> comparator) {
        checkAccess();
        if (!this.isWriting) {
            this.comparator = comparator;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override // java.util.logging.Handler
    public void setEncoding(String str) throws UnsupportedEncodingException {
        checkAccess();
        setEncoding0(str);
    }

    @Override // java.util.logging.Handler
    public void setErrorManager(ErrorManager errorManager) {
        checkAccess();
        setErrorManager0(errorManager);
    }

    @Override // java.util.logging.Handler
    public void setFilter(Filter filter) {
        checkAccess();
        synchronized (this) {
            if (filter != this.filter) {
                clearMatches(-1);
            }
            this.filter = filter;
        }
    }

    @Override // java.util.logging.Handler
    public synchronized void setFormatter(Formatter formatter) throws SecurityException {
        checkAccess();
        if (formatter != null) {
            this.formatter = formatter;
        } else {
            throw new NullPointerException();
        }
    }

    @Override // java.util.logging.Handler
    public void setLevel(Level level) {
        level.getClass();
        checkAccess();
        synchronized (this) {
            if (this.capacity > 0) {
                this.logLevel = level;
            }
        }
    }

    public final void setMailProperties(Properties properties) {
        setMailProperties0(properties);
    }

    public final synchronized void setPushFilter(Filter filter) {
        checkAccess();
        if (!this.isWriting) {
            this.pushFilter = filter;
        } else {
            throw new IllegalStateException();
        }
    }

    public final synchronized void setPushLevel(Level level) {
        checkAccess();
        if (level != null) {
            if (!this.isWriting) {
                this.pushLevel = level;
            } else {
                throw new IllegalStateException();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public final void setSubject(String str) {
        if (str != null) {
            setSubject(TailNameFormatter.of(str));
        } else {
            checkAccess();
            throw null;
        }
    }

    private static RuntimeException attachmentMismatch(int i4, int i5) {
        return attachmentMismatch("Attachments mismatched, expected " + i4 + " but given " + i5 + '.');
    }

    private void push(boolean z3, int i4) {
        try {
            if (tryMutex()) {
                try {
                    Message writeLogRecords = writeLogRecords(i4);
                    if (writeLogRecords != null) {
                        send(writeLogRecords, z3, i4);
                    }
                } catch (LinkageError e4) {
                    reportLinkageError(e4, i4);
                }
                return;
            }
            reportUnPublishedError(null);
        } finally {
            releaseMutex();
        }
    }

    public final void setAuthenticator(char... cArr) {
        if (cArr == null) {
            setAuthenticator0(null);
        } else {
            setAuthenticator0(DefaultAuthenticator.of(new String(cArr)));
        }
    }

    private String descriptionFrom(Formatter formatter, Filter filter, Formatter formatter2) {
        StringBuilder sb = new StringBuilder();
        sb.append("Formatted using ");
        sb.append(getClassId(formatter));
        sb.append(", filtered with ");
        sb.append(filter == null ? "no filter" : filter.getClass().getName());
        sb.append(", and named by ");
        sb.append(getClassId(formatter2));
        sb.append('.');
        return sb.toString();
    }

    public final void setSubject(Formatter formatter) {
        checkAccess();
        formatter.getClass();
        synchronized (this) {
            if (!this.isWriting) {
                this.subjectFormatter = formatter;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private void reportError(Message message, Exception exc, int i4) {
        try {
            try {
                this.errorManager.error(toRawString(message), exc, i4);
            } catch (RuntimeException e4) {
                reportError(toMsgString(e4), exc, i4);
            } catch (Exception e5) {
                reportError(toMsgString(e5), exc, i4);
            }
        } catch (LinkageError e6) {
            reportLinkageError(e6, i4);
        }
    }

    public MailHandler(int i4) {
        init(null);
        this.sealed = true;
        setCapacity0(i4);
    }

    private MimeBodyPart createBodyPart(int i4) throws MessagingException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDisposition(Part.ATTACHMENT);
        mimeBodyPart.setDescription(descriptionFrom(this.attachmentFormatters[i4], this.attachmentFilters[i4], this.attachmentNames[i4]));
        setAcceptLang(mimeBodyPart);
        return mimeBodyPart;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
        r7 = r7.getSuperclass();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.lang.String contentTypeOf(java.util.logging.Formatter r7) {
        /*
            r6 = this;
            if (r7 == 0) goto L67
            java.lang.Class r0 = r7.getClass()
            java.lang.String r0 = r0.getName()
            java.lang.String r0 = r6.getContentType(r0)
            if (r0 == 0) goto L11
            return r0
        L11:
            java.lang.Class r7 = r7.getClass()
        L15:
            java.lang.Class<java.util.logging.Formatter> r0 = java.util.logging.Formatter.class
            if (r7 == r0) goto L67
            java.lang.String r0 = r7.getSimpleName()     // Catch: java.lang.InternalError -> L1e
            goto L22
        L1e:
            java.lang.String r0 = r7.getName()
        L22:
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r1)
            r1 = 36
            int r1 = r0.indexOf(r1)
            r2 = 1
            int r1 = r1 + r2
        L30:
            java.lang.String r3 = "ml"
            int r1 = r0.indexOf(r3, r1)
            r3 = -1
            if (r1 <= r3) goto L62
            if (r1 <= 0) goto L5f
            int r3 = r1 + (-1)
            char r4 = r0.charAt(r3)
            r5 = 120(0x78, float:1.68E-43)
            if (r4 != r5) goto L48
            java.lang.String r7 = "application/xml"
            return r7
        L48:
            if (r1 <= r2) goto L5f
            int r4 = r1 + (-2)
            char r4 = r0.charAt(r4)
            r5 = 104(0x68, float:1.46E-43)
            if (r4 != r5) goto L5f
            char r3 = r0.charAt(r3)
            r4 = 116(0x74, float:1.63E-43)
            if (r3 != r4) goto L5f
            java.lang.String r7 = "text/html"
            return r7
        L5f:
            int r1 = r1 + 2
            goto L30
        L62:
            java.lang.Class r7 = r7.getSuperclass()
            goto L15
        L67:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.logging.MailHandler.contentTypeOf(java.util.logging.Formatter):java.lang.String");
    }

    public MailHandler(Properties properties) {
        properties.getClass();
        init(properties);
        this.sealed = true;
        setMailProperties0(properties);
    }

    public void postConstruct() {
    }

    public final void setAttachmentNames(Formatter... formatterArr) {
        Formatter[] formatterArr2;
        checkAccess();
        if (formatterArr.length == 0) {
            formatterArr2 = emptyFormatterArray();
        } else {
            formatterArr2 = (Formatter[]) Arrays.copyOf(formatterArr, formatterArr.length, Formatter[].class);
        }
        for (int i4 = 0; i4 < formatterArr2.length; i4++) {
            if (formatterArr2[i4] == null) {
                throw new NullPointerException(atIndexMsg(i4));
            }
        }
        synchronized (this) {
            Formatter[] formatterArr3 = this.attachmentFormatters;
            if (formatterArr3.length == formatterArr2.length) {
                if (!this.isWriting) {
                    this.attachmentNames = formatterArr2;
                } else {
                    throw new IllegalStateException();
                }
            } else {
                throw attachmentMismatch(formatterArr3.length, formatterArr2.length);
            }
        }
    }

    private Object intern(Map<Object, Object> map, Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Object newInstance = obj.getClass().getName().equals(TailNameFormatter.class.getName()) ? obj : obj.getClass().getConstructor(new Class[0]).newInstance(new Object[0]);
        if (newInstance.getClass() == obj.getClass()) {
            Object obj2 = map.get(newInstance);
            if (obj2 == null) {
                boolean equals = newInstance.equals(obj);
                boolean equals2 = obj.equals(newInstance);
                if (!equals || !equals2) {
                    if (equals != equals2) {
                        reportNonSymmetric(obj, newInstance);
                        return obj;
                    }
                    return obj;
                }
                Object put = map.put(obj, obj);
                if (put != null) {
                    reportNonDiscriminating(newInstance, put);
                    Object remove = map.remove(newInstance);
                    if (remove != obj) {
                        reportNonDiscriminating(newInstance, remove);
                        map.clear();
                        return obj;
                    }
                    return obj;
                }
                return obj;
            } else if (obj.getClass() == obj2.getClass()) {
                return obj2;
            } else {
                reportNonDiscriminating(obj, obj2);
                return obj;
            }
        }
        return obj;
    }
}
