package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class ListInfo {
    public static final int CHANGED = 1;
    public static final int INDETERMINATE = 3;
    public static final int UNCHANGED = 2;
    public String[] attrs;
    public boolean canOpen;
    public int changeState;
    public boolean hasInferiors;
    public String name;
    public char separator;

    public ListInfo(IMAPResponse iMAPResponse) throws ParsingException {
        this.name = null;
        this.separator = '/';
        this.hasInferiors = true;
        this.canOpen = true;
        this.changeState = 3;
        String[] readSimpleList = iMAPResponse.readSimpleList();
        ArrayList arrayList = new ArrayList();
        if (readSimpleList != null) {
            for (int i4 = 0; i4 < readSimpleList.length; i4++) {
                if (readSimpleList[i4].equalsIgnoreCase("\\Marked")) {
                    this.changeState = 1;
                } else if (readSimpleList[i4].equalsIgnoreCase("\\Unmarked")) {
                    this.changeState = 2;
                } else if (readSimpleList[i4].equalsIgnoreCase("\\Noselect")) {
                    this.canOpen = false;
                } else if (readSimpleList[i4].equalsIgnoreCase("\\Noinferiors")) {
                    this.hasInferiors = false;
                }
                arrayList.add(readSimpleList[i4]);
            }
        }
        this.attrs = (String[]) arrayList.toArray(new String[arrayList.size()]);
        iMAPResponse.skipSpaces();
        if (iMAPResponse.readByte() == 34) {
            char readByte = (char) iMAPResponse.readByte();
            this.separator = readByte;
            if (readByte == '\\') {
                this.separator = (char) iMAPResponse.readByte();
            }
            iMAPResponse.skip(1);
        } else {
            iMAPResponse.skip(2);
        }
        iMAPResponse.skipSpaces();
        this.name = iMAPResponse.readAtomString();
        if (!iMAPResponse.supportsUtf8()) {
            this.name = BASE64MailboxDecoder.decode(this.name);
        }
    }
}
