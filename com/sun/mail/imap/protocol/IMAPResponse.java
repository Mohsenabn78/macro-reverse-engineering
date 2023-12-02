package com.sun.mail.imap.protocol;

import com.sun.mail.iap.Protocol;
import com.sun.mail.iap.ProtocolException;
import com.sun.mail.iap.Response;
import com.sun.mail.util.ASCIIUtility;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class IMAPResponse extends Response {

    /* renamed from: k  reason: collision with root package name */
    private String f37856k;

    /* renamed from: l  reason: collision with root package name */
    private int f37857l;

    public IMAPResponse(Protocol protocol) throws IOException, ProtocolException {
        super(protocol);
        f();
    }

    private void f() throws IOException, ProtocolException {
        if (isUnTagged() && !isOK() && !isNO() && !isBAD() && !isBYE()) {
            String readAtom = readAtom();
            this.f37856k = readAtom;
            try {
                this.f37857l = Integer.parseInt(readAtom);
                this.f37856k = readAtom();
            } catch (NumberFormatException unused) {
            }
        }
    }

    public String getKey() {
        return this.f37856k;
    }

    public int getNumber() {
        return this.f37857l;
    }

    public boolean keyEquals(String str) {
        String str2 = this.f37856k;
        if (str2 != null && str2.equalsIgnoreCase(str)) {
            return true;
        }
        return false;
    }

    public String[] readSimpleList() {
        byte[] bArr;
        int i4;
        skipSpaces();
        byte[] bArr2 = this.f37622d;
        int i5 = this.f37619a;
        if (bArr2[i5] != 40) {
            return null;
        }
        this.f37619a = i5 + 1;
        ArrayList arrayList = new ArrayList();
        int i6 = this.f37619a;
        while (true) {
            bArr = this.f37622d;
            i4 = this.f37619a;
            byte b4 = bArr[i4];
            if (b4 == 41) {
                break;
            }
            if (b4 == 32) {
                arrayList.add(ASCIIUtility.toString(bArr, i6, i4));
                i6 = this.f37619a + 1;
            }
            this.f37619a++;
        }
        if (i4 > i6) {
            arrayList.add(ASCIIUtility.toString(bArr, i6, i4));
        }
        this.f37619a++;
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    public IMAPResponse(IMAPResponse iMAPResponse) {
        super(iMAPResponse);
        this.f37856k = iMAPResponse.f37856k;
        this.f37857l = iMAPResponse.f37857l;
    }

    public IMAPResponse(String str) throws IOException, ProtocolException {
        this(str, true);
    }

    public IMAPResponse(String str, boolean z3) throws IOException, ProtocolException {
        super(str, z3);
        f();
    }
}
