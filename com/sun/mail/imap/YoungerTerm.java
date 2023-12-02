package com.sun.mail.imap;

import java.util.Date;
import javax.mail.Message;
import javax.mail.search.SearchTerm;

/* loaded from: classes6.dex */
public final class YoungerTerm extends SearchTerm {
    private static final long serialVersionUID = 1592714210688163496L;
    private int interval;

    public YoungerTerm(int i4) {
        this.interval = i4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof YoungerTerm) || this.interval != ((YoungerTerm) obj).interval) {
            return false;
        }
        return true;
    }

    public int getInterval() {
        return this.interval;
    }

    public int hashCode() {
        return this.interval;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            Date receivedDate = message.getReceivedDate();
            if (receivedDate == null || receivedDate.getTime() < System.currentTimeMillis() - (this.interval * 1000)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
