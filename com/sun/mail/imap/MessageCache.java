package com.sun.mail.imap;

import com.sun.mail.util.MailLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import javax.mail.Message;

/* loaded from: classes6.dex */
public class MessageCache {

    /* renamed from: a  reason: collision with root package name */
    private IMAPMessage[] f37798a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f37799b;

    /* renamed from: c  reason: collision with root package name */
    private int f37800c;

    /* renamed from: d  reason: collision with root package name */
    private IMAPFolder f37801d;

    /* renamed from: e  reason: collision with root package name */
    private MailLogger f37802e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageCache(IMAPFolder iMAPFolder, IMAPStore iMAPStore, int i4) {
        this.f37801d = iMAPFolder;
        MailLogger subLogger = iMAPFolder.D.getSubLogger("messagecache", "DEBUG IMAP MC", iMAPStore.k());
        this.f37802e = subLogger;
        if (subLogger.isLoggable(Level.CONFIG)) {
            MailLogger mailLogger = this.f37802e;
            mailLogger.config("create cache of size " + i4);
        }
        a(i4, 1);
    }

    private void a(int i4, int i5) {
        IMAPMessage[] iMAPMessageArr = this.f37798a;
        if (iMAPMessageArr == null) {
            this.f37798a = new IMAPMessage[i4 + 64];
        } else if (iMAPMessageArr.length < i4) {
            if (this.f37802e.isLoggable(Level.FINE)) {
                this.f37802e.fine("expand capacity to " + i4);
            }
            int i6 = i4 + 64;
            IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[i6];
            IMAPMessage[] iMAPMessageArr3 = this.f37798a;
            System.arraycopy(iMAPMessageArr3, 0, iMAPMessageArr2, 0, iMAPMessageArr3.length);
            this.f37798a = iMAPMessageArr2;
            int[] iArr = this.f37799b;
            if (iArr != null) {
                int[] iArr2 = new int[i6];
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                int i7 = this.f37800c;
                while (i7 < i6) {
                    iArr2[i7] = i5;
                    i7++;
                    i5++;
                }
                this.f37799b = iArr2;
                if (this.f37802e.isLoggable(Level.FINE)) {
                    this.f37802e.fine("message " + i4 + " has sequence number " + this.f37799b[i4 - 1]);
                }
            }
        } else if (i4 < this.f37800c) {
            if (this.f37802e.isLoggable(Level.FINE)) {
                this.f37802e.fine("shrink capacity to " + i4);
            }
            for (int i8 = i4 + 1; i8 <= this.f37800c; i8++) {
                int i9 = i8 - 1;
                this.f37798a[i9] = null;
                int[] iArr3 = this.f37799b;
                if (iArr3 != null) {
                    iArr3[i9] = -1;
                }
            }
        }
        this.f37800c = i4;
    }

    private int b(int i4) {
        if (this.f37799b == null) {
            return i4;
        }
        if (i4 < 1) {
            if (this.f37802e.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.f37802e;
                mailLogger.fine("bad seqnum " + i4);
            }
            return -1;
        }
        for (int i5 = i4; i5 <= this.f37800c; i5++) {
            int i6 = this.f37799b[i5 - 1];
            if (i6 == i4) {
                return i5;
            }
            if (i6 > i4) {
                break;
            }
        }
        return -1;
    }

    private void c(int i4, int i5) {
        this.f37800c = i4 - 1;
        MailLogger mailLogger = this.f37802e;
        Level level = Level.FINE;
        if (mailLogger.isLoggable(level)) {
            this.f37802e.fine("size now " + this.f37800c);
        }
        int i6 = this.f37800c;
        if (i6 == 0) {
            this.f37798a = null;
            this.f37799b = null;
        } else if (i6 > 64 && i6 < this.f37798a.length / 2) {
            this.f37802e.fine("reallocate array");
            int i7 = this.f37800c;
            IMAPMessage[] iMAPMessageArr = new IMAPMessage[i7 + 64];
            System.arraycopy(this.f37798a, 0, iMAPMessageArr, 0, i7);
            this.f37798a = iMAPMessageArr;
            int[] iArr = this.f37799b;
            if (iArr != null) {
                int i8 = this.f37800c;
                int[] iArr2 = new int[i8 + 64];
                System.arraycopy(iArr, 0, iArr2, 0, i8);
                this.f37799b = iArr2;
            }
        } else {
            if (this.f37802e.isLoggable(level)) {
                this.f37802e.fine("clean " + i4 + " to " + i5);
            }
            while (i4 < i5) {
                int i9 = i4 - 1;
                this.f37798a[i9] = null;
                int[] iArr3 = this.f37799b;
                if (iArr3 != null) {
                    iArr3[i9] = 0;
                }
                i4++;
            }
        }
    }

    public void addMessages(int i4, int i5) {
        if (this.f37802e.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.f37802e;
            mailLogger.fine("add " + i4 + " messages");
        }
        a(this.f37800c + i4, i5);
    }

    public void expungeMessage(int i4) {
        int b4 = b(i4);
        if (b4 < 0) {
            if (this.f37802e.isLoggable(Level.FINE)) {
                this.f37802e.fine("expunge no seqnum " + i4);
                return;
            }
            return;
        }
        int i5 = b4 - 1;
        IMAPMessage iMAPMessage = this.f37798a[i5];
        if (iMAPMessage != null) {
            if (this.f37802e.isLoggable(Level.FINE)) {
                this.f37802e.fine("expunge existing " + b4);
            }
            iMAPMessage.setExpunged(true);
        }
        int[] iArr = this.f37799b;
        if (iArr == null) {
            this.f37802e.fine("create seqnums array");
            this.f37799b = new int[this.f37798a.length];
            for (int i6 = 1; i6 < b4; i6++) {
                this.f37799b[i6 - 1] = i6;
            }
            this.f37799b[i5] = 0;
            int i7 = b4 + 1;
            while (true) {
                int[] iArr2 = this.f37799b;
                if (i7 <= iArr2.length) {
                    int i8 = i7 - 1;
                    iArr2[i8] = i8;
                    i7++;
                } else {
                    return;
                }
            }
        } else {
            iArr[i5] = 0;
            int i9 = b4 + 1;
            while (true) {
                int[] iArr3 = this.f37799b;
                if (i9 <= iArr3.length) {
                    int i10 = i9 - 1;
                    int i11 = iArr3[i10];
                    if (i11 > 0) {
                        iArr3[i10] = i11 - 1;
                    }
                    i9++;
                } else {
                    return;
                }
            }
        }
    }

    public IMAPMessage getMessage(int i4) {
        if (i4 >= 1 && i4 <= this.f37800c) {
            int i5 = i4 - 1;
            IMAPMessage iMAPMessage = this.f37798a[i5];
            if (iMAPMessage == null) {
                if (this.f37802e.isLoggable(Level.FINE)) {
                    this.f37802e.fine("create message number " + i4);
                }
                iMAPMessage = this.f37801d.K(i4);
                this.f37798a[i5] = iMAPMessage;
                if (seqnumOf(i4) <= 0) {
                    this.f37802e.fine("it's expunged!");
                    iMAPMessage.setExpunged(true);
                }
            }
            return iMAPMessage;
        }
        throw new ArrayIndexOutOfBoundsException("message number (" + i4 + ") out of bounds (" + this.f37800c + ")");
    }

    public IMAPMessage getMessageBySeqnum(int i4) {
        int b4 = b(i4);
        if (b4 < 0) {
            if (this.f37802e.isLoggable(Level.FINE)) {
                MailLogger mailLogger = this.f37802e;
                mailLogger.fine("no message seqnum " + i4);
                return null;
            }
            return null;
        }
        return getMessage(b4);
    }

    public IMAPMessage[] removeExpungedMessages() {
        this.f37802e.fine("remove expunged messages");
        ArrayList arrayList = new ArrayList();
        int i4 = 1;
        int i5 = 1;
        while (i4 <= this.f37800c) {
            if (seqnumOf(i4) <= 0) {
                arrayList.add(getMessage(i4));
            } else {
                if (i5 != i4) {
                    IMAPMessage[] iMAPMessageArr = this.f37798a;
                    IMAPMessage iMAPMessage = iMAPMessageArr[i4 - 1];
                    iMAPMessageArr[i5 - 1] = iMAPMessage;
                    if (iMAPMessage != null) {
                        iMAPMessage.setMessageNumber(i5);
                    }
                }
                i5++;
            }
            i4++;
        }
        this.f37799b = null;
        c(i5, i4);
        int size = arrayList.size();
        IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[size];
        if (this.f37802e.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.f37802e;
            mailLogger.fine("return " + size);
        }
        arrayList.toArray(iMAPMessageArr2);
        return iMAPMessageArr2;
    }

    public int seqnumOf(int i4) {
        if (this.f37799b == null) {
            return i4;
        }
        if (this.f37802e.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.f37802e;
            mailLogger.fine("msgnum " + i4 + " is seqnum " + this.f37799b[i4 - 1]);
        }
        return this.f37799b[i4 - 1];
    }

    public int size() {
        return this.f37800c;
    }

    public IMAPMessage[] removeExpungedMessages(Message[] messageArr) {
        this.f37802e.fine("remove expunged messages");
        ArrayList arrayList = new ArrayList();
        int length = messageArr.length;
        int[] iArr = new int[length];
        boolean z3 = false;
        for (int i4 = 0; i4 < messageArr.length; i4++) {
            iArr[i4] = messageArr[i4].getMessageNumber();
        }
        Arrays.sort(iArr);
        int i5 = 0;
        int i6 = 1;
        int i7 = 1;
        while (i6 <= this.f37800c) {
            if (i5 < length && i6 == iArr[i5] && seqnumOf(i6) <= 0) {
                arrayList.add(getMessage(i6));
                while (i5 < length && iArr[i5] <= i6) {
                    i5++;
                }
            } else {
                if (i7 != i6) {
                    IMAPMessage[] iMAPMessageArr = this.f37798a;
                    int i8 = i7 - 1;
                    int i9 = i6 - 1;
                    IMAPMessage iMAPMessage = iMAPMessageArr[i9];
                    iMAPMessageArr[i8] = iMAPMessage;
                    if (iMAPMessage != null) {
                        iMAPMessage.setMessageNumber(i7);
                    }
                    int[] iArr2 = this.f37799b;
                    if (iArr2 != null) {
                        iArr2[i8] = iArr2[i9];
                    }
                }
                int[] iArr3 = this.f37799b;
                if (iArr3 != null && iArr3[i7 - 1] != i7) {
                    z3 = true;
                }
                i7++;
            }
            i6++;
        }
        if (!z3) {
            this.f37799b = null;
        }
        c(i7, i6);
        int size = arrayList.size();
        IMAPMessage[] iMAPMessageArr2 = new IMAPMessage[size];
        if (this.f37802e.isLoggable(Level.FINE)) {
            this.f37802e.fine("return " + size);
        }
        arrayList.toArray(iMAPMessageArr2);
        return iMAPMessageArr2;
    }
}
