package com.sun.mail.smtp;

import java.io.InputStream;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/* loaded from: classes6.dex */
public class SMTPMessage extends MimeMessage {
    public static final int NOTIFY_DELAY = 4;
    public static final int NOTIFY_FAILURE = 2;
    public static final int NOTIFY_NEVER = -1;
    public static final int NOTIFY_SUCCESS = 1;
    public static final int RETURN_FULL = 1;
    public static final int RETURN_HDRS = 2;
    private static final String[] returnOptionString = {null, "FULL", "HDRS"};
    private boolean allow8bitMIME;
    private String envelopeFrom;
    private String extension;
    private int notifyOptions;
    private int returnOption;
    private boolean sendPartial;
    private String submitter;

    public SMTPMessage(Session session) {
        super(session);
        this.notifyOptions = 0;
        this.returnOption = 0;
        this.sendPartial = false;
        this.allow8bitMIME = false;
        this.submitter = null;
        this.extension = null;
    }

    public boolean getAllow8bitMIME() {
        return this.allow8bitMIME;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDSNNotify() {
        int i4 = this.notifyOptions;
        if (i4 == 0) {
            return null;
        }
        if (i4 == -1) {
            return "NEVER";
        }
        StringBuilder sb = new StringBuilder();
        if ((this.notifyOptions & 1) != 0) {
            sb.append("SUCCESS");
        }
        if ((this.notifyOptions & 2) != 0) {
            if (sb.length() != 0) {
                sb.append(',');
            }
            sb.append("FAILURE");
        }
        if ((this.notifyOptions & 4) != 0) {
            if (sb.length() != 0) {
                sb.append(',');
            }
            sb.append("DELAY");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getDSNRet() {
        return returnOptionString[this.returnOption];
    }

    public String getEnvelopeFrom() {
        return this.envelopeFrom;
    }

    public String getMailExtension() {
        return this.extension;
    }

    public int getNotifyOptions() {
        return this.notifyOptions;
    }

    public int getReturnOption() {
        return this.returnOption;
    }

    public boolean getSendPartial() {
        return this.sendPartial;
    }

    public String getSubmitter() {
        return this.submitter;
    }

    public void setAllow8bitMIME(boolean z3) {
        this.allow8bitMIME = z3;
    }

    public void setEnvelopeFrom(String str) {
        this.envelopeFrom = str;
    }

    public void setMailExtension(String str) {
        this.extension = str;
    }

    public void setNotifyOptions(int i4) {
        if (i4 >= -1 && i4 < 8) {
            this.notifyOptions = i4;
            return;
        }
        throw new IllegalArgumentException("Bad return option");
    }

    public void setReturnOption(int i4) {
        if (i4 >= 0 && i4 <= 2) {
            this.returnOption = i4;
            return;
        }
        throw new IllegalArgumentException("Bad return option");
    }

    public void setSendPartial(boolean z3) {
        this.sendPartial = z3;
    }

    public void setSubmitter(String str) {
        this.submitter = str;
    }

    public SMTPMessage(Session session, InputStream inputStream) throws MessagingException {
        super(session, inputStream);
        this.notifyOptions = 0;
        this.returnOption = 0;
        this.sendPartial = false;
        this.allow8bitMIME = false;
        this.submitter = null;
        this.extension = null;
    }

    public SMTPMessage(MimeMessage mimeMessage) throws MessagingException {
        super(mimeMessage);
        this.notifyOptions = 0;
        this.returnOption = 0;
        this.sendPartial = false;
        this.allow8bitMIME = false;
        this.submitter = null;
        this.extension = null;
    }
}
