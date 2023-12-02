package com.sun.mail.imap.protocol;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import okio.Utf8;

/* loaded from: classes6.dex */
public class BASE64MailboxEncoder {

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f37819e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'n', 'o', 'p', 'q', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, ','};

    /* renamed from: a  reason: collision with root package name */
    protected byte[] f37820a = new byte[4];

    /* renamed from: b  reason: collision with root package name */
    protected int f37821b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f37822c = false;

    /* renamed from: d  reason: collision with root package name */
    protected Writer f37823d;

    public BASE64MailboxEncoder(Writer writer) {
        this.f37823d = writer;
    }

    public static String encode(String str) {
        char[] charArray = str.toCharArray();
        CharArrayWriter charArrayWriter = new CharArrayWriter(charArray.length);
        BASE64MailboxEncoder bASE64MailboxEncoder = null;
        boolean z3 = false;
        for (char c4 : charArray) {
            if (c4 >= ' ' && c4 <= '~') {
                if (bASE64MailboxEncoder != null) {
                    bASE64MailboxEncoder.flush();
                }
                if (c4 == '&') {
                    charArrayWriter.write(38);
                    charArrayWriter.write(45);
                    z3 = true;
                } else {
                    charArrayWriter.write(c4);
                }
            } else {
                if (bASE64MailboxEncoder == null) {
                    bASE64MailboxEncoder = new BASE64MailboxEncoder(charArrayWriter);
                    z3 = true;
                }
                bASE64MailboxEncoder.write(c4);
            }
        }
        if (bASE64MailboxEncoder != null) {
            bASE64MailboxEncoder.flush();
        }
        if (z3) {
            return charArrayWriter.toString();
        }
        return str;
    }

    protected void a() throws IOException {
        int i4 = this.f37821b;
        if (i4 == 1) {
            byte b4 = this.f37820a[0];
            Writer writer = this.f37823d;
            char[] cArr = f37819e;
            writer.write(cArr[(b4 >>> 2) & 63]);
            this.f37823d.write(cArr[((b4 << 4) & 48) + 0]);
        } else if (i4 == 2) {
            byte[] bArr = this.f37820a;
            byte b5 = bArr[0];
            byte b6 = bArr[1];
            Writer writer2 = this.f37823d;
            char[] cArr2 = f37819e;
            writer2.write(cArr2[(b5 >>> 2) & 63]);
            this.f37823d.write(cArr2[((b5 << 4) & 48) + ((b6 >>> 4) & 15)]);
            this.f37823d.write(cArr2[((b6 << 2) & 60) + 0]);
        } else {
            byte[] bArr2 = this.f37820a;
            byte b7 = bArr2[0];
            byte b8 = bArr2[1];
            byte b9 = bArr2[2];
            Writer writer3 = this.f37823d;
            char[] cArr3 = f37819e;
            writer3.write(cArr3[(b7 >>> 2) & 63]);
            this.f37823d.write(cArr3[((b7 << 4) & 48) + ((b8 >>> 4) & 15)]);
            this.f37823d.write(cArr3[((b8 << 2) & 60) + ((b9 >>> 6) & 3)]);
            this.f37823d.write(cArr3[b9 & Utf8.REPLACEMENT_BYTE]);
            if (this.f37821b == 4) {
                byte[] bArr3 = this.f37820a;
                bArr3[0] = bArr3[3];
            }
        }
    }

    public void flush() {
        try {
            if (this.f37821b > 0) {
                a();
                this.f37821b = 0;
            }
            if (this.f37822c) {
                this.f37823d.write(45);
                this.f37822c = false;
            }
        } catch (IOException unused) {
        }
    }

    public void write(int i4) {
        try {
            if (!this.f37822c) {
                this.f37822c = true;
                this.f37823d.write(38);
            }
            byte[] bArr = this.f37820a;
            int i5 = this.f37821b;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (i4 >> 8);
            int i7 = i6 + 1;
            this.f37821b = i7;
            bArr[i6] = (byte) (i4 & 255);
            if (i7 >= 3) {
                a();
                this.f37821b -= 3;
            }
        } catch (IOException unused) {
        }
    }
}
