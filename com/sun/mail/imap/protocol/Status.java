package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes6.dex */
public class Status {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f37871a = {"MESSAGES", "RECENT", "UNSEEN", "UIDNEXT", "UIDVALIDITY"};
    public long highestmodseq;
    public Map<String, Long> items;
    public String mbox;
    public int recent;
    public int total;
    public long uidnext;
    public long uidvalidity;
    public int unseen;

    public Status(Response response) throws ParsingException {
        this.mbox = null;
        this.total = -1;
        this.recent = -1;
        this.uidnext = -1L;
        this.uidvalidity = -1L;
        this.unseen = -1;
        this.highestmodseq = -1L;
        this.mbox = response.readAtomString();
        if (!response.supportsUtf8()) {
            this.mbox = BASE64MailboxDecoder.decode(this.mbox);
        }
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        while (response.peekByte() != 40 && response.peekByte() != 0) {
            char readByte = (char) response.readByte();
            sb.append(readByte);
            if (readByte != ' ') {
                z3 = false;
            }
        }
        if (!z3) {
            this.mbox = (this.mbox + ((Object) sb)).trim();
        }
        if (response.readByte() == 40) {
            do {
                String readAtom = response.readAtom();
                if (readAtom != null) {
                    if (readAtom.equalsIgnoreCase("MESSAGES")) {
                        this.total = response.readNumber();
                    } else if (readAtom.equalsIgnoreCase("RECENT")) {
                        this.recent = response.readNumber();
                    } else if (readAtom.equalsIgnoreCase("UIDNEXT")) {
                        this.uidnext = response.readLong();
                    } else if (readAtom.equalsIgnoreCase("UIDVALIDITY")) {
                        this.uidvalidity = response.readLong();
                    } else if (readAtom.equalsIgnoreCase("UNSEEN")) {
                        this.unseen = response.readNumber();
                    } else if (readAtom.equalsIgnoreCase("HIGHESTMODSEQ")) {
                        this.highestmodseq = response.readLong();
                    } else {
                        if (this.items == null) {
                            this.items = new HashMap();
                        }
                        this.items.put(readAtom.toUpperCase(Locale.ENGLISH), Long.valueOf(response.readLong()));
                    }
                } else {
                    throw new ParsingException("parse error in STATUS");
                }
            } while (!response.isNextNonSpace(')'));
            return;
        }
        throw new ParsingException("parse error in STATUS");
    }

    public static void add(Status status, Status status2) {
        int i4 = status2.total;
        if (i4 != -1) {
            status.total = i4;
        }
        int i5 = status2.recent;
        if (i5 != -1) {
            status.recent = i5;
        }
        long j4 = status2.uidnext;
        if (j4 != -1) {
            status.uidnext = j4;
        }
        long j5 = status2.uidvalidity;
        if (j5 != -1) {
            status.uidvalidity = j5;
        }
        int i6 = status2.unseen;
        if (i6 != -1) {
            status.unseen = i6;
        }
        long j6 = status2.highestmodseq;
        if (j6 != -1) {
            status.highestmodseq = j6;
        }
        Map<String, Long> map = status.items;
        if (map == null) {
            status.items = status2.items;
            return;
        }
        Map<String, Long> map2 = status2.items;
        if (map2 != null) {
            map.putAll(map2);
        }
    }

    public long getItem(String str) {
        int i4;
        Long l4;
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        Map<String, Long> map = this.items;
        if (map != null && (l4 = map.get(upperCase)) != null) {
            return l4.longValue();
        }
        if (upperCase.equals("MESSAGES")) {
            i4 = this.total;
        } else if (upperCase.equals("RECENT")) {
            i4 = this.recent;
        } else if (upperCase.equals("UIDNEXT")) {
            return this.uidnext;
        } else {
            if (upperCase.equals("UIDVALIDITY")) {
                return this.uidvalidity;
            }
            if (upperCase.equals("UNSEEN")) {
                i4 = this.unseen;
            } else if (upperCase.equals("HIGHESTMODSEQ")) {
                return this.highestmodseq;
            } else {
                return -1L;
            }
        }
        return i4;
    }
}
