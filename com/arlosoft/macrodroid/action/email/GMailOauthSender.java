package com.arlosoft.macrodroid.action.email;

import android.content.Context;
import com.arlosoft.macrodroid.utils.GmailHelper;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/* loaded from: classes2.dex */
public class GMailOauthSender {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends FileDataSource {
        a(File file) {
            super(file);
        }

        @Override // javax.activation.FileDataSource, javax.activation.DataSource
        public String getContentType() {
            return "application/octet-stream";
        }
    }

    private static Message a(MimeMessage mimeMessage) throws MessagingException, IOException {
        Message message = new Message();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            mimeMessage.writeTo(byteArrayOutputStream);
            message.setRaw(Base64.encodeBase64URLSafeString(byteArrayOutputStream.toByteArray()));
        } catch (Throwable unused) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Date: " + simpleDateFormat.format(new Date()) + "\r\n");
            stringBuffer.append("From: " + mimeMessage.getFrom()[0] + "\r\n");
            stringBuffer.append("To: " + mimeMessage.getAllRecipients()[0] + "\r\n");
            stringBuffer.append("Subject: " + mimeMessage.getSubject() + "\r\n");
            stringBuffer.append("MIME-Version: 1.0\r\n");
            stringBuffer.append("Content-Type: text/plain; charset=us-ascii\r\n");
            stringBuffer.append("Content-Transfer-Encoding: 7bit\r\n");
            stringBuffer.append("\r\n\r\n" + mimeMessage.getContent());
            message.setRaw(Base64.encodeBase64URLSafeString(stringBuffer.toString().getBytes()));
        }
        return message;
    }

    public synchronized void sendMail(Context context, String str, String str2, String str3, String str4, String str5) throws Exception {
        GmailHelper gmailHelper = GmailHelper.getInstance(context.getApplicationContext());
        GoogleAccountCredential credentials = gmailHelper.getCredentials();
        if (credentials.getSelectedAccountName() != null) {
            Session defaultInstance = Session.getDefaultInstance(new Properties(), null);
            String str6 = credentials.getSelectedAccount().name;
            MimeMessage mimeMessage = new MimeMessage(defaultInstance);
            mimeMessage.setFrom(new InternetAddress(str6));
            for (String str7 : str5.split("[,;]")) {
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(str7));
            }
            mimeMessage.setSubject(str);
            mimeMessage.setText(str2);
            new Gmail.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), credentials).setApplicationName("MacroDroid").build().users().messages().send(str6, a(mimeMessage)).execute();
        } else {
            gmailHelper.showAccountNotConfiguredNotification();
            throw new AuthenticationFailedException();
        }
    }

    public synchronized void sendMail(Context context, String str, String str2, String str3, String str4, String str5, File file) throws Exception {
        sendMail(context, str, str2, str3, str4, str5, file, file.getName());
    }

    public synchronized void sendMail(Context context, String str, String str2, String str3, String str4, String str5, File file, String str6) throws Exception {
        GmailHelper gmailHelper = GmailHelper.getInstance(context.getApplicationContext());
        GoogleAccountCredential credentials = gmailHelper.getCredentials();
        if (credentials.getSelectedAccountName() != null) {
            Session defaultInstance = Session.getDefaultInstance(new Properties(), null);
            String str7 = credentials.getSelectedAccount().name;
            MimeMessage mimeMessage = new MimeMessage(defaultInstance);
            mimeMessage.setFrom(new InternetAddress(str7));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(str5));
            mimeMessage.setSubject(str);
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(str2, "text/plain");
            mimeBodyPart.setHeader("Content-Type", "text/plain; charset=\"UTF-8\"");
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(mimeBodyPart);
            MimeBodyPart mimeBodyPart2 = new MimeBodyPart();
            mimeBodyPart2.setDataHandler(new DataHandler(new a(file)));
            mimeBodyPart2.setFileName(MimeUtility.encodeText(str6));
            mimeMultipart.addBodyPart(mimeBodyPart2);
            mimeMessage.setContent(mimeMultipart);
            Gmail build = new Gmail.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), credentials).setApplicationName("MacroDroid").build();
            build.users().messages().send(str7, a(mimeMessage)).execute();
        } else {
            gmailHelper.showAccountNotConfiguredNotification();
            throw new AuthenticationFailedException();
        }
    }
}
