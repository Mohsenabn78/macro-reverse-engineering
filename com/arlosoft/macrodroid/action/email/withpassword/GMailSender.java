package com.arlosoft.macrodroid.action.email.withpassword;

import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/* loaded from: classes2.dex */
public class GMailSender extends Authenticator {

    /* renamed from: a  reason: collision with root package name */
    private final String f3449a = "smtp.gmail.com";

    /* renamed from: b  reason: collision with root package name */
    private final String f3450b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3451c;

    /* renamed from: d  reason: collision with root package name */
    private final Session f3452d;

    /* loaded from: classes2.dex */
    class a extends Authenticator {
        a() {
        }

        @Override // javax.mail.Authenticator
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(GMailSender.this.f3450b, GMailSender.this.f3451c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends FileDataSource {
        b(File file) {
            super(file);
        }

        @Override // javax.activation.FileDataSource, javax.activation.DataSource
        public String getContentType() {
            return "application/octet-stream";
        }
    }

    static {
        Security.addProvider(new com.arlosoft.macrodroid.action.email.withpassword.b());
    }

    public GMailSender(String str, String str2) {
        this.f3450b = str;
        this.f3451c = str2;
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.host", "smtp.gmail.com");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.socketFactory.fallback", "false");
        properties.setProperty("mail.smtp.quitwait", "false");
        this.f3452d = Session.getInstance(properties, new a());
    }

    public synchronized void sendMail(String str, String str2, String str3, String str4) throws Exception {
        try {
            MimeMessage mimeMessage = new MimeMessage(this.f3452d);
            DataHandler dataHandler = new DataHandler(new ByteArrayDataSource(str2.getBytes(), "text/plain"));
            mimeMessage.setSender(new InternetAddress(str3));
            mimeMessage.setSubject(str);
            mimeMessage.setDataHandler(dataHandler);
            if (str4.indexOf(44) > 0) {
                mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(str4));
            } else {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(str4));
            }
            Transport.send(mimeMessage);
        } catch (Throwable th) {
            SystemLog.logError("Could not send email: " + th);
            throw th;
        }
    }

    /* loaded from: classes2.dex */
    public class ByteArrayDataSource implements DataSource {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f3453a;

        /* renamed from: b  reason: collision with root package name */
        private String f3454b;

        public ByteArrayDataSource(byte[] bArr, String str) {
            this.f3453a = bArr;
            this.f3454b = str;
        }

        @Override // javax.activation.DataSource
        public String getContentType() {
            String str = this.f3454b;
            if (str == null) {
                return "application/octet-stream";
            }
            return str;
        }

        @Override // javax.activation.DataSource
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(this.f3453a);
        }

        @Override // javax.activation.DataSource
        public String getName() {
            return "ByteArrayDataSource";
        }

        @Override // javax.activation.DataSource
        public OutputStream getOutputStream() throws IOException {
            throw new IOException("Not Supported");
        }

        public void setType(String str) {
            this.f3454b = str;
        }

        public ByteArrayDataSource(byte[] bArr) {
            this.f3453a = bArr;
        }
    }

    public synchronized void sendMail(String str, String str2, String str3, String str4, File file) throws Exception {
        sendMail(str, str2, str3, str4, file, file.getName());
    }

    public synchronized void sendMail(String str, String str2, String str3, String str4, File file, String str5) throws Exception {
        MimeMessage mimeMessage = new MimeMessage(this.f3452d);
        mimeMessage.setSender(new InternetAddress(str3));
        mimeMessage.setSubject(str);
        mimeMessage.setSentDate(new Date());
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setDataHandler(new DataHandler(new b(file)));
        mimeBodyPart.setFileName(MimeUtility.encodeText(str5));
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(mimeBodyPart);
        mimeMessage.setContent(mimeMultipart);
        if (str4.indexOf(44) > 0) {
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(str4));
        } else {
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(str4));
        }
        Transport.send(mimeMessage);
    }
}
