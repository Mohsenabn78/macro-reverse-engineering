package com.sun.mail.imap;

import javax.mail.Message;
import javax.mail.search.SearchTerm;

/* loaded from: classes6.dex */
public final class ModifiedSinceTerm extends SearchTerm {
    private static final long serialVersionUID = 5151457469634727992L;
    private long modseq;

    public ModifiedSinceTerm(long j4) {
        this.modseq = j4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ModifiedSinceTerm) || this.modseq != ((ModifiedSinceTerm) obj).modseq) {
            return false;
        }
        return true;
    }

    public long getModSeq() {
        return this.modseq;
    }

    public int hashCode() {
        return (int) this.modseq;
    }

    @Override // javax.mail.search.SearchTerm
    public boolean match(Message message) {
        try {
            if (!(message instanceof IMAPMessage)) {
                return false;
            }
            if (((IMAPMessage) message).getModSeq() < this.modseq) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
