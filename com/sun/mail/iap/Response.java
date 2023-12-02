package com.sun.mail.iap;

import com.sun.mail.util.ASCIIUtility;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/* loaded from: classes6.dex */
public class Response {
    public static final int BAD = 12;
    public static final int BYE = 16;
    public static final int CONTINUATION = 1;
    public static final int NO = 8;
    public static final int OK = 4;
    public static final int SYNTHETIC = 32;
    public static final int TAGGED = 2;
    public static final int TAG_MASK = 3;
    public static final int TYPE_MASK = 28;
    public static final int UNTAGGED = 3;

    /* renamed from: i  reason: collision with root package name */
    private static String f37617i = " (){%*\"\\]";

    /* renamed from: j  reason: collision with root package name */
    private static String f37618j = " (){%*\"\\";

    /* renamed from: a  reason: collision with root package name */
    protected int f37619a;

    /* renamed from: b  reason: collision with root package name */
    protected int f37620b;

    /* renamed from: c  reason: collision with root package name */
    protected int f37621c;

    /* renamed from: d  reason: collision with root package name */
    protected byte[] f37622d;

    /* renamed from: e  reason: collision with root package name */
    protected int f37623e;

    /* renamed from: f  reason: collision with root package name */
    protected String f37624f;

    /* renamed from: g  reason: collision with root package name */
    protected Exception f37625g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f37626h;

    public Response(String str) {
        this(str, true);
    }

    private void a() {
        this.f37619a = 0;
        if (this.f37621c == 0) {
            return;
        }
        byte b4 = this.f37622d[0];
        if (b4 == 43) {
            this.f37623e |= 1;
            this.f37619a = 0 + 1;
            return;
        }
        String str = "";
        if (b4 == 42) {
            this.f37623e |= 3;
            this.f37619a = 0 + 1;
        } else {
            this.f37623e |= 2;
            String readAtom = readAtom();
            this.f37624f = readAtom;
            if (readAtom == null) {
                this.f37624f = "";
            }
        }
        int i4 = this.f37619a;
        String readAtom2 = readAtom();
        if (readAtom2 != null) {
            str = readAtom2;
        }
        if (str.equalsIgnoreCase("OK")) {
            this.f37623e |= 4;
        } else if (str.equalsIgnoreCase("NO")) {
            this.f37623e |= 8;
        } else if (str.equalsIgnoreCase("BAD")) {
            this.f37623e |= 12;
        } else if (str.equalsIgnoreCase("BYE")) {
            this.f37623e |= 16;
        } else {
            this.f37619a = i4;
        }
        this.f37620b = this.f37619a;
    }

    private Object b(boolean z3, boolean z4) {
        byte[] bArr;
        int i4;
        int i5;
        int i6;
        byte[] bArr2;
        byte b4;
        skipSpaces();
        byte[] bArr3 = this.f37622d;
        int i7 = this.f37619a;
        byte b5 = bArr3[i7];
        if (b5 == 34) {
            int i8 = i7 + 1;
            this.f37619a = i8;
            int i9 = i8;
            while (true) {
                i5 = this.f37619a;
                i6 = this.f37621c;
                if (i5 >= i6 || (b4 = (bArr2 = this.f37622d)[i5]) == 34) {
                    break;
                }
                if (b4 == 92) {
                    this.f37619a = i5 + 1;
                }
                int i10 = this.f37619a;
                if (i10 != i9) {
                    bArr2[i9] = bArr2[i10];
                }
                i9++;
                this.f37619a = i10 + 1;
            }
            if (i5 >= i6) {
                return null;
            }
            this.f37619a = i5 + 1;
            if (z4) {
                return e(this.f37622d, i8, i9);
            }
            return new ByteArray(this.f37622d, i8, i9 - i8);
        } else if (b5 == 123) {
            int i11 = i7 + 1;
            this.f37619a = i11;
            while (true) {
                bArr = this.f37622d;
                i4 = this.f37619a;
                if (bArr[i4] == 125) {
                    try {
                        break;
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
                this.f37619a = i4 + 1;
            }
            int parseInt = ASCIIUtility.parseInt(bArr, i11, i4);
            int i12 = this.f37619a + 3;
            int i13 = i12 + parseInt;
            this.f37619a = i13;
            if (z4) {
                return e(this.f37622d, i12, i13);
            }
            return new ByteArray(this.f37622d, i12, parseInt);
        } else if (z3) {
            String c4 = c(f37618j);
            if (z4) {
                return c4;
            }
            return new ByteArray(this.f37622d, i7, this.f37619a);
        } else if (b5 != 78 && b5 != 110) {
            return null;
        } else {
            this.f37619a = i7 + 3;
            return null;
        }
    }

    public static Response byeResponse(Exception exc) {
        Response response = new Response(("* BYE Jakarta Mail Exception: " + exc.toString()).replace('\r', ' ').replace('\n', ' '));
        response.f37623e = response.f37623e | 32;
        response.f37625g = exc;
        return response;
    }

    private String c(String str) {
        int i4;
        skipSpaces();
        int i5 = this.f37619a;
        if (i5 >= this.f37621c) {
            return null;
        }
        while (true) {
            int i6 = this.f37619a;
            if (i6 >= this.f37621c || (i4 = this.f37622d[i6] & 255) < 32 || str.indexOf((char) i4) >= 0 || i4 == 127) {
                break;
            }
            this.f37619a++;
        }
        return e(this.f37622d, i5, this.f37619a);
    }

    private String[] d(boolean z3) {
        String readString;
        skipSpaces();
        byte[] bArr = this.f37622d;
        int i4 = this.f37619a;
        if (bArr[i4] != 40) {
            return null;
        }
        this.f37619a = i4 + 1;
        ArrayList arrayList = new ArrayList();
        while (!isNextNonSpace(')')) {
            if (z3) {
                readString = readAtomString();
            } else {
                readString = readString();
            }
            if (readString == null) {
                break;
            }
            arrayList.add(readString);
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private String e(byte[] bArr, int i4, int i5) {
        if (this.f37626h) {
            return new String(bArr, i4, i5 - i4, StandardCharsets.UTF_8);
        }
        return ASCIIUtility.toString(bArr, i4, i5);
    }

    public Exception getException() {
        return this.f37625g;
    }

    public String getRest() {
        skipSpaces();
        return e(this.f37622d, this.f37619a, this.f37621c);
    }

    public String getTag() {
        return this.f37624f;
    }

    public int getType() {
        return this.f37623e;
    }

    public boolean isBAD() {
        if ((this.f37623e & 28) == 12) {
            return true;
        }
        return false;
    }

    public boolean isBYE() {
        if ((this.f37623e & 28) == 16) {
            return true;
        }
        return false;
    }

    public boolean isContinuation() {
        if ((this.f37623e & 3) == 1) {
            return true;
        }
        return false;
    }

    public boolean isNO() {
        if ((this.f37623e & 28) == 8) {
            return true;
        }
        return false;
    }

    public boolean isNextNonSpace(char c4) {
        skipSpaces();
        int i4 = this.f37619a;
        if (i4 < this.f37621c && this.f37622d[i4] == ((byte) c4)) {
            this.f37619a = i4 + 1;
            return true;
        }
        return false;
    }

    public boolean isOK() {
        if ((this.f37623e & 28) == 4) {
            return true;
        }
        return false;
    }

    public boolean isSynthetic() {
        if ((this.f37623e & 32) == 32) {
            return true;
        }
        return false;
    }

    public boolean isTagged() {
        if ((this.f37623e & 3) == 2) {
            return true;
        }
        return false;
    }

    public boolean isUnTagged() {
        if ((this.f37623e & 3) == 3) {
            return true;
        }
        return false;
    }

    public byte peekByte() {
        int i4 = this.f37619a;
        if (i4 < this.f37621c) {
            return this.f37622d[i4];
        }
        return (byte) 0;
    }

    public String readAtom() {
        return c(f37617i);
    }

    public String readAtomString() {
        return (String) b(true, true);
    }

    public String[] readAtomStringList() {
        return d(true);
    }

    public byte readByte() {
        int i4 = this.f37619a;
        if (i4 < this.f37621c) {
            byte[] bArr = this.f37622d;
            this.f37619a = i4 + 1;
            return bArr[i4];
        }
        return (byte) 0;
    }

    public ByteArray readByteArray() {
        if (isContinuation()) {
            skipSpaces();
            byte[] bArr = this.f37622d;
            int i4 = this.f37619a;
            return new ByteArray(bArr, i4, this.f37621c - i4);
        }
        return (ByteArray) b(false, false);
    }

    public ByteArrayInputStream readBytes() {
        ByteArray readByteArray = readByteArray();
        if (readByteArray != null) {
            return readByteArray.toByteArrayInputStream();
        }
        return null;
    }

    public long readLong() {
        skipSpaces();
        int i4 = this.f37619a;
        while (true) {
            int i5 = this.f37619a;
            if (i5 >= this.f37621c || !Character.isDigit((char) this.f37622d[i5])) {
                break;
            }
            this.f37619a++;
        }
        int i6 = this.f37619a;
        if (i6 > i4) {
            try {
                return ASCIIUtility.parseLong(this.f37622d, i4, i6);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return -1L;
    }

    public int readNumber() {
        skipSpaces();
        int i4 = this.f37619a;
        while (true) {
            int i5 = this.f37619a;
            if (i5 >= this.f37621c || !Character.isDigit((char) this.f37622d[i5])) {
                break;
            }
            this.f37619a++;
        }
        int i6 = this.f37619a;
        if (i6 > i4) {
            try {
                return ASCIIUtility.parseInt(this.f37622d, i4, i6);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return -1;
    }

    public String readString(char c4) {
        int i4;
        skipSpaces();
        int i5 = this.f37619a;
        if (i5 >= this.f37621c) {
            return null;
        }
        while (true) {
            i4 = this.f37619a;
            if (i4 >= this.f37621c || this.f37622d[i4] == c4) {
                break;
            }
            this.f37619a = i4 + 1;
        }
        return e(this.f37622d, i5, i4);
    }

    public String[] readStringList() {
        return d(false);
    }

    public void reset() {
        this.f37619a = this.f37620b;
    }

    public void skip(int i4) {
        this.f37619a += i4;
    }

    public void skipSpaces() {
        while (true) {
            int i4 = this.f37619a;
            if (i4 < this.f37621c && this.f37622d[i4] == 32) {
                this.f37619a = i4 + 1;
            } else {
                return;
            }
        }
    }

    public void skipToken() {
        while (true) {
            int i4 = this.f37619a;
            if (i4 < this.f37621c && this.f37622d[i4] != 32) {
                this.f37619a = i4 + 1;
            } else {
                return;
            }
        }
    }

    public boolean supportsUtf8() {
        return this.f37626h;
    }

    public String toString() {
        return e(this.f37622d, 0, this.f37621c);
    }

    public Response(String str, boolean z3) {
        this.f37622d = null;
        this.f37623e = 0;
        this.f37624f = null;
        if (z3) {
            this.f37622d = str.getBytes(StandardCharsets.UTF_8);
        } else {
            this.f37622d = str.getBytes(StandardCharsets.US_ASCII);
        }
        this.f37621c = this.f37622d.length;
        this.f37626h = z3;
        a();
    }

    public String readString() {
        return (String) b(false, true);
    }

    public Response(Protocol protocol) throws IOException, ProtocolException {
        this.f37622d = null;
        this.f37623e = 0;
        this.f37624f = null;
        ByteArray readResponse = protocol.e().readResponse(protocol.h());
        this.f37622d = readResponse.getBytes();
        this.f37621c = readResponse.getCount() - 2;
        this.f37626h = protocol.supportsUtf8();
        a();
    }

    public Response(Response response) {
        this.f37622d = null;
        this.f37623e = 0;
        this.f37624f = null;
        this.f37619a = response.f37619a;
        this.f37620b = response.f37620b;
        this.f37621c = response.f37621c;
        this.f37622d = response.f37622d;
        this.f37623e = response.f37623e;
        this.f37624f = response.f37624f;
        this.f37625g = response.f37625g;
        this.f37626h = response.f37626h;
    }
}
