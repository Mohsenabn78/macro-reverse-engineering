package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.util.ASCIIUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class FetchResponse extends IMAPResponse {

    /* renamed from: p  reason: collision with root package name */
    private static final char[] f37842p = {'.', 'H', 'E', 'A', 'D', 'E', 'R'};

    /* renamed from: q  reason: collision with root package name */
    private static final char[] f37843q = {'.', 'T', 'E', 'X', 'T'};

    /* renamed from: m  reason: collision with root package name */
    private Item[] f37844m;

    /* renamed from: n  reason: collision with root package name */
    private Map<String, Object> f37845n;

    /* renamed from: o  reason: collision with root package name */
    private final FetchItem[] f37846o;

    public FetchResponse(Protocol protocol) throws IOException, ProtocolException {
        super(protocol);
        this.f37846o = null;
        a();
    }

    private void a() throws ParsingException {
        if (isNextNonSpace('(')) {
            ArrayList arrayList = new ArrayList();
            skipSpaces();
            while (this.f37619a < this.f37621c) {
                Item k4 = k();
                if (k4 != null) {
                    arrayList.add(k4);
                } else if (!j()) {
                    throw new ParsingException("error in FETCH parsing, unrecognized item at index " + this.f37619a + ", starts with \"" + i() + "\"");
                }
                if (isNextNonSpace(')')) {
                    this.f37844m = (Item[]) arrayList.toArray(new Item[arrayList.size()]);
                    return;
                }
            }
            throw new ParsingException("error in FETCH parsing, ran off end of buffer, size " + this.f37621c);
        }
        throw new ParsingException("error in FETCH parsing, missing '(' at index " + this.f37619a);
    }

    private boolean g(String str) {
        int length = str.length();
        int i4 = this.f37619a;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i4 + 1;
            int i7 = i5 + 1;
            if (Character.toUpperCase((char) this.f37622d[i4]) != str.charAt(i5)) {
                return false;
            }
            i5 = i7;
            i4 = i6;
        }
        this.f37619a += length;
        return true;
    }

    public static <T extends Item> List<T> getItems(Response[] responseArr, int i4, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        if (responseArr == null) {
            return arrayList;
        }
        for (int i5 = 0; i5 < responseArr.length; i5++) {
            Response response = responseArr[i5];
            if (response != null && (response instanceof FetchResponse) && ((FetchResponse) response).getNumber() == i4) {
                FetchResponse fetchResponse = (FetchResponse) responseArr[i5];
                int i6 = 0;
                while (true) {
                    Item[] itemArr = fetchResponse.f37844m;
                    if (i6 < itemArr.length) {
                        if (cls.isInstance(itemArr[i6])) {
                            arrayList.add(cls.cast(fetchResponse.f37844m[i6]));
                        }
                        i6++;
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean h(char[] cArr) {
        int length = cArr.length;
        int i4 = this.f37619a;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i4 + 1;
            int i7 = i5 + 1;
            if (Character.toUpperCase((char) this.f37622d[i4]) != cArr[i5]) {
                return false;
            }
            i5 = i7;
            i4 = i6;
        }
        this.f37619a += length;
        return true;
    }

    private String i() {
        int i4 = this.f37619a;
        int i5 = i4 + 20;
        int i6 = this.f37621c;
        if (i5 > i6) {
            return ASCIIUtility.toString(this.f37622d, i4, i6);
        }
        StringBuilder sb = new StringBuilder();
        byte[] bArr = this.f37622d;
        int i7 = this.f37619a;
        sb.append(ASCIIUtility.toString(bArr, i7, i7 + 20));
        sb.append("...");
        return sb.toString();
    }

    private boolean j() throws ParsingException {
        if (this.f37846o == null) {
            return false;
        }
        int i4 = 0;
        while (true) {
            FetchItem[] fetchItemArr = this.f37846o;
            if (i4 >= fetchItemArr.length) {
                return false;
            }
            if (g(fetchItemArr[i4].getName())) {
                if (this.f37845n == null) {
                    this.f37845n = new HashMap();
                }
                this.f37845n.put(this.f37846o[i4].getName(), this.f37846o[i4].parseItem(this));
                return true;
            }
            i4++;
        }
    }

    private Item k() throws ParsingException {
        boolean z3;
        byte b4 = this.f37622d[this.f37619a];
        if (b4 != 66) {
            if (b4 != 73) {
                if (b4 != 77) {
                    if (b4 != 82) {
                        if (b4 != 85) {
                            if (b4 != 98) {
                                if (b4 != 105) {
                                    if (b4 != 109) {
                                        if (b4 != 114) {
                                            if (b4 != 117) {
                                                if (b4 != 69) {
                                                    if (b4 != 70) {
                                                        if (b4 != 101) {
                                                            if (b4 != 102) {
                                                                return null;
                                                            }
                                                        }
                                                    }
                                                    if (h(FLAGS.f37839a)) {
                                                        return new FLAGS(this);
                                                    }
                                                    return null;
                                                }
                                                if (h(ENVELOPE.f37836a)) {
                                                    return new ENVELOPE(this);
                                                }
                                                return null;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (h(UID.f37872a)) {
                            return new UID(this);
                        }
                        return null;
                    }
                    if (h(RFC822SIZE.f37867a)) {
                        return new RFC822SIZE(this);
                    }
                    if (h(RFC822DATA.f37863d)) {
                        if (h(f37842p)) {
                            z3 = true;
                        } else {
                            h(f37843q);
                            z3 = false;
                        }
                        return new RFC822DATA(this, z3);
                    }
                    return null;
                }
                if (h(MODSEQ.f37862a)) {
                    return new MODSEQ(this);
                }
                return null;
            }
            if (h(INTERNALDATE.f37858b)) {
                return new INTERNALDATE(this);
            }
            return null;
        }
        if (h(BODYSTRUCTURE.f37830b)) {
            return new BODYSTRUCTURE(this);
        }
        if (h(BODY.f37824f)) {
            if (this.f37622d[this.f37619a] == 91) {
                return new BODY(this);
            }
            return new BODYSTRUCTURE(this);
        }
        return null;
    }

    public Map<String, Object> getExtensionItems() {
        return this.f37845n;
    }

    public Item getItem(int i4) {
        return this.f37844m[i4];
    }

    public int getItemCount() {
        return this.f37844m.length;
    }

    public <T extends Item> T getItem(Class<T> cls) {
        int i4 = 0;
        while (true) {
            Item[] itemArr = this.f37844m;
            if (i4 >= itemArr.length) {
                return null;
            }
            if (cls.isInstance(itemArr[i4])) {
                return cls.cast(this.f37844m[i4]);
            }
            i4++;
        }
    }

    public FetchResponse(IMAPResponse iMAPResponse) throws IOException, ProtocolException {
        this(iMAPResponse, null);
    }

    public FetchResponse(IMAPResponse iMAPResponse, FetchItem[] fetchItemArr) throws IOException, ProtocolException {
        super(iMAPResponse);
        this.f37846o = fetchItemArr;
        a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003a, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T extends com.sun.mail.imap.protocol.Item> T getItem(com.sun.mail.iap.Response[] r7, int r8, java.lang.Class<T> r9) {
        /*
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            r1 = 0
            r2 = 0
        L6:
            int r3 = r7.length
            if (r2 >= r3) goto L3d
            r3 = r7[r2]
            if (r3 == 0) goto L3a
            boolean r4 = r3 instanceof com.sun.mail.imap.protocol.FetchResponse
            if (r4 == 0) goto L3a
            com.sun.mail.imap.protocol.FetchResponse r3 = (com.sun.mail.imap.protocol.FetchResponse) r3
            int r3 = r3.getNumber()
            if (r3 == r8) goto L1a
            goto L3a
        L1a:
            r3 = r7[r2]
            com.sun.mail.imap.protocol.FetchResponse r3 = (com.sun.mail.imap.protocol.FetchResponse) r3
            r4 = 0
        L1f:
            com.sun.mail.imap.protocol.Item[] r5 = r3.f37844m
            int r6 = r5.length
            if (r4 >= r6) goto L3a
            r5 = r5[r4]
            boolean r5 = r9.isInstance(r5)
            if (r5 == 0) goto L37
            com.sun.mail.imap.protocol.Item[] r7 = r3.f37844m
            r7 = r7[r4]
            java.lang.Object r7 = r9.cast(r7)
            com.sun.mail.imap.protocol.Item r7 = (com.sun.mail.imap.protocol.Item) r7
            return r7
        L37:
            int r4 = r4 + 1
            goto L1f
        L3a:
            int r2 = r2 + 1
            goto L6
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.imap.protocol.FetchResponse.getItem(com.sun.mail.iap.Response[], int, java.lang.Class):com.sun.mail.imap.protocol.Item");
    }
}
