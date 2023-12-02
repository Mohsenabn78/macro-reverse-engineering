package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import javax.mail.Flags;

/* loaded from: classes6.dex */
public class FLAGS extends Flags implements Item {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f37839a = {'F', 'L', 'A', 'G', 'S'};
    private static final long serialVersionUID = 439049847053756670L;
    public int msgno;

    public FLAGS(IMAPResponse iMAPResponse) throws ParsingException {
        this.msgno = iMAPResponse.getNumber();
        iMAPResponse.skipSpaces();
        String[] readSimpleList = iMAPResponse.readSimpleList();
        if (readSimpleList != null) {
            for (String str : readSimpleList) {
                if (str.length() >= 2 && str.charAt(0) == '\\') {
                    char upperCase = Character.toUpperCase(str.charAt(1));
                    if (upperCase != '*') {
                        if (upperCase != 'A') {
                            if (upperCase != 'D') {
                                if (upperCase != 'F') {
                                    if (upperCase != 'R') {
                                        if (upperCase != 'S') {
                                            add(str);
                                        } else {
                                            add(Flags.Flag.SEEN);
                                        }
                                    } else {
                                        add(Flags.Flag.RECENT);
                                    }
                                } else {
                                    add(Flags.Flag.FLAGGED);
                                }
                            } else if (str.length() >= 3) {
                                char charAt = str.charAt(2);
                                if (charAt != 'e' && charAt != 'E') {
                                    if (charAt == 'r' || charAt == 'R') {
                                        add(Flags.Flag.DRAFT);
                                    }
                                } else {
                                    add(Flags.Flag.DELETED);
                                }
                            } else {
                                add(str);
                            }
                        } else {
                            add(Flags.Flag.ANSWERED);
                        }
                    } else {
                        add(Flags.Flag.USER);
                    }
                } else {
                    add(str);
                }
            }
        }
    }
}
