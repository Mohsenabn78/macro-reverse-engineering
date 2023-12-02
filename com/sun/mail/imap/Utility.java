package com.sun.mail.imap;

import com.sun.mail.imap.protocol.MessageSet;
import com.sun.mail.imap.protocol.UIDSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import javax.mail.Message;

/* loaded from: classes6.dex */
public final class Utility {

    /* loaded from: classes6.dex */
    public interface Condition {
        boolean test(IMAPMessage iMAPMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Comparator<Message> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Message message, Message message2) {
            return message.getMessageNumber() - message2.getMessageNumber();
        }
    }

    private Utility() {
    }

    public static UIDSet[] getResyncUIDSet(ResyncData resyncData) {
        return resyncData.a();
    }

    public static MessageSet[] toMessageSet(Message[] messageArr, Condition condition) {
        ArrayList arrayList = new ArrayList(1);
        int i4 = 0;
        while (i4 < messageArr.length) {
            IMAPMessage iMAPMessage = (IMAPMessage) messageArr[i4];
            if (!iMAPMessage.isExpunged()) {
                int w3 = iMAPMessage.w();
                if (condition == null || condition.test(iMAPMessage)) {
                    MessageSet messageSet = new MessageSet();
                    messageSet.start = w3;
                    while (true) {
                        i4++;
                        if (i4 >= messageArr.length) {
                            break;
                        }
                        IMAPMessage iMAPMessage2 = (IMAPMessage) messageArr[i4];
                        if (!iMAPMessage2.isExpunged()) {
                            int w4 = iMAPMessage2.w();
                            if (condition == null || condition.test(iMAPMessage2)) {
                                if (w4 == w3 + 1) {
                                    w3 = w4;
                                } else {
                                    i4--;
                                    break;
                                }
                            }
                        }
                    }
                    messageSet.end = w3;
                    arrayList.add(messageSet);
                }
            }
            i4++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (MessageSet[]) arrayList.toArray(new MessageSet[arrayList.size()]);
    }

    public static MessageSet[] toMessageSetSorted(Message[] messageArr, Condition condition) {
        Message[] messageArr2 = (Message[]) messageArr.clone();
        Arrays.sort(messageArr2, new a());
        return toMessageSet(messageArr2, condition);
    }

    public static UIDSet[] toUIDSet(Message[] messageArr) {
        ArrayList arrayList = new ArrayList(1);
        int i4 = 0;
        while (i4 < messageArr.length) {
            IMAPMessage iMAPMessage = (IMAPMessage) messageArr[i4];
            if (!iMAPMessage.isExpunged()) {
                long x3 = iMAPMessage.x();
                UIDSet uIDSet = new UIDSet();
                uIDSet.start = x3;
                while (true) {
                    i4++;
                    if (i4 >= messageArr.length) {
                        break;
                    }
                    IMAPMessage iMAPMessage2 = (IMAPMessage) messageArr[i4];
                    if (!iMAPMessage2.isExpunged()) {
                        long x4 = iMAPMessage2.x();
                        if (x4 == 1 + x3) {
                            x3 = x4;
                        } else {
                            i4--;
                            break;
                        }
                    }
                }
                uIDSet.end = x3;
                arrayList.add(uIDSet);
            }
            i4++;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return (UIDSet[]) arrayList.toArray(new UIDSet[arrayList.size()]);
    }
}
