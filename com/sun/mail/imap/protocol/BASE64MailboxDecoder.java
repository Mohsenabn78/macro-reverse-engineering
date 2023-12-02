package com.sun.mail.imap.protocol;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import kotlin.text.Typography;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okio.Utf8;

/* loaded from: classes6.dex */
public class BASE64MailboxDecoder {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f37817a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'n', 'o', 'p', 'q', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, ','};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f37818b = new byte[256];

    static {
        int i4 = 0;
        for (int i5 = 0; i5 < 255; i5++) {
            f37818b[i5] = -1;
        }
        while (true) {
            char[] cArr = f37817a;
            if (i4 < cArr.length) {
                f37818b[cArr[i4]] = (byte) i4;
                i4++;
            } else {
                return;
            }
        }
    }

    protected static int a(char[] cArr, int i4, CharacterIterator characterIterator) {
        boolean z3 = true;
        int i5 = -1;
        while (true) {
            byte next = (byte) characterIterator.next();
            if (next != -1) {
                if (next == 45) {
                    if (z3) {
                        int i6 = i4 + 1;
                        cArr[i4] = Typography.amp;
                        return i6;
                    }
                    return i4;
                }
                byte next2 = (byte) characterIterator.next();
                if (next2 != -1 && next2 != 45) {
                    byte[] bArr = f37818b;
                    byte b4 = bArr[next & 255];
                    byte b5 = bArr[next2 & 255];
                    byte b6 = (byte) (((b4 << 2) & 252) | ((b5 >>> 4) & 3));
                    if (i5 != -1) {
                        cArr[i4] = (char) ((i5 << 8) | (b6 & 255));
                        i4++;
                        i5 = -1;
                    } else {
                        i5 = b6 & 255;
                    }
                    byte next3 = (byte) characterIterator.next();
                    if (next3 != 61) {
                        if (next3 != -1 && next3 != 45) {
                            byte b7 = bArr[next3 & 255];
                            byte b8 = (byte) (((b5 << 4) & 240) | ((b7 >>> 2) & 15));
                            if (i5 != -1) {
                                cArr[i4] = (char) ((b8 & 255) | (i5 << 8));
                                i4++;
                                i5 = -1;
                            } else {
                                i5 = b8 & 255;
                            }
                            byte next4 = (byte) characterIterator.next();
                            if (next4 == 61) {
                                continue;
                            } else if (next4 != -1 && next4 != 45) {
                                byte b9 = (byte) ((bArr[next4 & 255] & Utf8.REPLACEMENT_BYTE) | ((b7 << 6) & 192));
                                if (i5 != -1) {
                                    cArr[i4] = (char) ((b9 & 255) | (i5 << 8));
                                    i4++;
                                    i5 = -1;
                                } else {
                                    i5 = b9 & 255;
                                }
                            } else {
                                return i4;
                            }
                        } else {
                            return i4;
                        }
                    }
                    z3 = false;
                } else {
                    return i4;
                }
            } else {
                return i4;
            }
        }
    }

    public static String decode(String str) {
        if (str != null && str.length() != 0) {
            char[] cArr = new char[str.length()];
            StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
            boolean z3 = false;
            int i4 = 0;
            for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
                if (first == '&') {
                    z3 = true;
                    i4 = a(cArr, i4, stringCharacterIterator);
                } else {
                    cArr[i4] = first;
                    i4++;
                }
            }
            if (z3) {
                return new String(cArr, 0, i4);
            }
            return str;
        }
        return str;
    }
}
