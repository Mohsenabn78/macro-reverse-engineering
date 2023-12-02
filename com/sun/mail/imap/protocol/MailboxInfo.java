package com.sun.mail.imap.protocol;

import com.google.api.client.googleapis.notifications.ResourceStates;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import java.util.ArrayList;
import java.util.List;
import javax.mail.Flags;

/* loaded from: classes6.dex */
public class MailboxInfo {
    public Flags availableFlags;
    public int first;
    public long highestmodseq;
    public int mode;
    public Flags permanentFlags;
    public int recent;
    public List<IMAPResponse> responses;
    public int total;
    public boolean uidNotSticky;
    public long uidnext;
    public long uidvalidity;

    public MailboxInfo(Response[] responseArr) throws ParsingException {
        this.availableFlags = null;
        this.permanentFlags = null;
        this.total = -1;
        this.recent = -1;
        this.first = -1;
        this.uidvalidity = -1L;
        this.uidnext = -1L;
        this.uidNotSticky = false;
        this.highestmodseq = -1L;
        for (int i4 = 0; i4 < responseArr.length; i4++) {
            Response response = responseArr[i4];
            if (response != null && (response instanceof IMAPResponse)) {
                IMAPResponse iMAPResponse = (IMAPResponse) response;
                if (iMAPResponse.keyEquals(ResourceStates.EXISTS)) {
                    this.total = iMAPResponse.getNumber();
                    responseArr[i4] = null;
                } else if (iMAPResponse.keyEquals("RECENT")) {
                    this.recent = iMAPResponse.getNumber();
                    responseArr[i4] = null;
                } else if (iMAPResponse.keyEquals("FLAGS")) {
                    this.availableFlags = new FLAGS(iMAPResponse);
                    responseArr[i4] = null;
                } else if (iMAPResponse.keyEquals("VANISHED")) {
                    if (this.responses == null) {
                        this.responses = new ArrayList();
                    }
                    this.responses.add(iMAPResponse);
                    responseArr[i4] = null;
                } else if (iMAPResponse.keyEquals("FETCH")) {
                    if (this.responses == null) {
                        this.responses = new ArrayList();
                    }
                    this.responses.add(iMAPResponse);
                    responseArr[i4] = null;
                } else {
                    boolean z3 = true;
                    if (iMAPResponse.isUnTagged() && iMAPResponse.isOK()) {
                        iMAPResponse.skipSpaces();
                        if (iMAPResponse.readByte() != 91) {
                            iMAPResponse.reset();
                        } else {
                            String readAtom = iMAPResponse.readAtom();
                            if (readAtom.equalsIgnoreCase("UNSEEN")) {
                                this.first = iMAPResponse.readNumber();
                            } else if (readAtom.equalsIgnoreCase("UIDVALIDITY")) {
                                this.uidvalidity = iMAPResponse.readLong();
                            } else if (readAtom.equalsIgnoreCase("PERMANENTFLAGS")) {
                                this.permanentFlags = new FLAGS(iMAPResponse);
                            } else if (readAtom.equalsIgnoreCase("UIDNEXT")) {
                                this.uidnext = iMAPResponse.readLong();
                            } else if (readAtom.equalsIgnoreCase("HIGHESTMODSEQ")) {
                                this.highestmodseq = iMAPResponse.readLong();
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                responseArr[i4] = null;
                            } else {
                                iMAPResponse.reset();
                            }
                        }
                    } else if (iMAPResponse.isUnTagged() && iMAPResponse.isNO()) {
                        iMAPResponse.skipSpaces();
                        if (iMAPResponse.readByte() != 91) {
                            iMAPResponse.reset();
                        } else {
                            if (iMAPResponse.readAtom().equalsIgnoreCase("UIDNOTSTICKY")) {
                                this.uidNotSticky = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                responseArr[i4] = null;
                            } else {
                                iMAPResponse.reset();
                            }
                        }
                    }
                }
            }
        }
        if (this.permanentFlags == null) {
            Flags flags = this.availableFlags;
            if (flags != null) {
                this.permanentFlags = new Flags(flags);
            } else {
                this.permanentFlags = new Flags();
            }
        }
    }
}
