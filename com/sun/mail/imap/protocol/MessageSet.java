package com.sun.mail.imap.protocol;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class MessageSet {
    public int end;
    public int start;

    public MessageSet() {
    }

    public MessageSet(int i4, int i5) {
        this.start = i4;
        this.end = i5;
    }

    public static MessageSet[] createMessageSets(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < iArr.length) {
            MessageSet messageSet = new MessageSet();
            messageSet.start = iArr[i4];
            do {
                i4++;
                if (i4 < iArr.length) {
                }
                int i5 = i4 - 1;
                messageSet.end = iArr[i5];
                arrayList.add(messageSet);
                i4 = i5 + 1;
            } while (iArr[i4] == iArr[i4 - 1] + 1);
            int i52 = i4 - 1;
            messageSet.end = iArr[i52];
            arrayList.add(messageSet);
            i4 = i52 + 1;
        }
        return (MessageSet[]) arrayList.toArray(new MessageSet[arrayList.size()]);
    }

    public static String toString(MessageSet[] messageSetArr) {
        if (messageSetArr != null && messageSetArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            int length = messageSetArr.length;
            int i4 = 0;
            while (true) {
                MessageSet messageSet = messageSetArr[i4];
                int i5 = messageSet.start;
                int i6 = messageSet.end;
                if (i6 > i5) {
                    sb.append(i5);
                    sb.append(':');
                    sb.append(i6);
                } else {
                    sb.append(i5);
                }
                i4++;
                if (i4 >= length) {
                    return sb.toString();
                }
                sb.append(',');
            }
        } else {
            return null;
        }
    }

    public int size() {
        return (this.end - this.start) + 1;
    }

    public static int size(MessageSet[] messageSetArr) {
        if (messageSetArr == null) {
            return 0;
        }
        int i4 = 0;
        for (MessageSet messageSet : messageSetArr) {
            i4 += messageSet.size();
        }
        return i4;
    }
}
