package com.sun.mail.util;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes6.dex */
public class BASE64DecoderStream extends FilterInputStream {
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', Advice.OffsetMapping.ForOrigin.Renderer.ForMethodName.SYMBOL, 'n', 'o', 'p', 'q', Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL, Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL, 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', SignatureVisitor.EXTENDS, '/'};
    private static final byte[] pem_convert_array = new byte[256];
    private byte[] buffer;
    private int bufsize;
    private boolean ignoreErrors;
    private int index;
    private byte[] input_buffer;
    private int input_len;
    private int input_pos;

    static {
        int i4 = 0;
        for (int i5 = 0; i5 < 255; i5++) {
            pem_convert_array[i5] = -1;
        }
        while (true) {
            char[] cArr = pem_array;
            if (i4 < cArr.length) {
                pem_convert_array[cArr[i4]] = (byte) i4;
                i4++;
            } else {
                return;
            }
        }
    }

    public BASE64DecoderStream(InputStream inputStream) {
        super(inputStream);
        this.buffer = new byte[3];
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = false;
        this.ignoreErrors = PropUtil.getBooleanSystemProperty("mail.mime.base64.ignoreerrors", false);
    }

    private int decode(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = i4;
        while (i5 >= 3) {
            boolean z3 = false;
            int i7 = 0;
            int i8 = 0;
            while (i7 < 4) {
                int i9 = getByte();
                if (i9 == -1 || i9 == -2) {
                    if (i9 == -1) {
                        if (i7 == 0) {
                            return i6 - i4;
                        }
                        if (!this.ignoreErrors) {
                            throw new DecodingException("BASE64Decoder: Error in encoded stream: needed 4 valid base64 characters but only got " + i7 + " before EOF" + recentChars());
                        }
                        z3 = true;
                    } else if (i7 < 2 && !this.ignoreErrors) {
                        throw new DecodingException("BASE64Decoder: Error in encoded stream: needed at least 2 valid base64 characters, but only got " + i7 + " before padding character (=)" + recentChars());
                    } else if (i7 == 0) {
                        return i6 - i4;
                    }
                    int i10 = i7 - 1;
                    if (i10 == 0) {
                        i10 = 1;
                    }
                    int i11 = i8 << 6;
                    for (int i12 = i7 + 1; i12 < 4; i12++) {
                        if (!z3) {
                            int i13 = getByte();
                            if (i13 == -1) {
                                if (!this.ignoreErrors) {
                                    throw new DecodingException("BASE64Decoder: Error in encoded stream: hit EOF while looking for padding characters (=)" + recentChars());
                                }
                            } else if (i13 != -2 && !this.ignoreErrors) {
                                throw new DecodingException("BASE64Decoder: Error in encoded stream: found valid base64 character after a padding character (=)" + recentChars());
                            }
                        }
                        i11 <<= 6;
                    }
                    int i14 = i11 >> 8;
                    if (i10 == 2) {
                        bArr[i6 + 1] = (byte) (i14 & 255);
                    }
                    bArr[i6] = (byte) ((i14 >> 8) & 255);
                    return (i6 + i10) - i4;
                }
                i7++;
                i8 = (i8 << 6) | i9;
            }
            bArr[i6 + 2] = (byte) (i8 & 255);
            int i15 = i8 >> 8;
            bArr[i6 + 1] = (byte) (i15 & 255);
            bArr[i6] = (byte) ((i15 >> 8) & 255);
            i5 -= 3;
            i6 += 3;
        }
        return i6 - i4;
    }

    private int getByte() throws IOException {
        byte b4;
        do {
            if (this.input_pos >= this.input_len) {
                try {
                    int read = ((FilterInputStream) this).in.read(this.input_buffer);
                    this.input_len = read;
                    if (read <= 0) {
                        return -1;
                    }
                    this.input_pos = 0;
                } catch (EOFException unused) {
                    return -1;
                }
            }
            byte[] bArr = this.input_buffer;
            int i4 = this.input_pos;
            this.input_pos = i4 + 1;
            int i5 = bArr[i4] & 255;
            if (i5 == 61) {
                return -2;
            }
            b4 = pem_convert_array[i5];
        } while (b4 == -1);
        return b4;
    }

    private String recentChars() {
        String str;
        int i4 = this.input_pos;
        if (i4 > 10) {
            i4 = 10;
        }
        if (i4 <= 0) {
            return "";
        }
        String str2 = ", the " + i4 + " most recent characters were: \"";
        for (int i5 = this.input_pos - i4; i5 < this.input_pos; i5++) {
            char c4 = (char) (this.input_buffer[i5] & 255);
            if (c4 != '\t') {
                if (c4 != '\n') {
                    if (c4 != '\r') {
                        if (c4 >= ' ' && c4 < 127) {
                            str = str2 + c4;
                        } else {
                            str = str2 + "\\" + ((int) c4);
                        }
                    } else {
                        str = str2 + "\\r";
                    }
                } else {
                    str = str2 + "\\n";
                }
            } else {
                str = str2 + "\\t";
            }
            str2 = str;
        }
        return str2 + "\"";
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((((FilterInputStream) this).in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            byte[] bArr = this.buffer;
            int decode = decode(bArr, 0, bArr.length);
            this.bufsize = decode;
            if (decode <= 0) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr2 = this.buffer;
        int i4 = this.index;
        this.index = i4 + 1;
        return bArr2[i4] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j4) throws IOException {
        long j5 = 0;
        while (true) {
            long j6 = j4 - 1;
            if (j4 <= 0 || read() < 0) {
                break;
            }
            j5++;
            j4 = j6;
        }
        return j5;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int i6;
        int i7;
        if (i5 == 0) {
            return 0;
        }
        int i8 = i4;
        while (true) {
            i6 = this.index;
            i7 = this.bufsize;
            if (i6 >= i7 || i5 <= 0) {
                break;
            }
            byte[] bArr2 = this.buffer;
            this.index = i6 + 1;
            bArr[i8] = bArr2[i6];
            i5--;
            i8++;
        }
        if (i6 >= i7) {
            this.index = 0;
            this.bufsize = 0;
        }
        int i9 = (i5 / 3) * 3;
        if (i9 > 0) {
            int decode = decode(bArr, i8, i9);
            i8 += decode;
            i5 -= decode;
            if (decode != i9) {
                if (i8 == i4) {
                    return -1;
                }
                return i8 - i4;
            }
        }
        while (i5 > 0) {
            int read = read();
            if (read == -1) {
                break;
            }
            bArr[i8] = (byte) read;
            i5--;
            i8++;
        }
        if (i8 == i4) {
            return -1;
        }
        return i8 - i4;
    }

    public BASE64DecoderStream(InputStream inputStream, boolean z3) {
        super(inputStream);
        this.buffer = new byte[3];
        this.bufsize = 0;
        this.index = 0;
        this.input_buffer = new byte[8190];
        this.input_pos = 0;
        this.input_len = 0;
        this.ignoreErrors = z3;
    }

    public static byte[] decode(byte[] bArr) {
        int i4;
        int length = (bArr.length / 4) * 3;
        if (length == 0) {
            return bArr;
        }
        if (bArr[bArr.length - 1] == 61) {
            length--;
            if (bArr[bArr.length - 2] == 61) {
                length--;
            }
        }
        byte[] bArr2 = new byte[length];
        int length2 = bArr.length;
        int i5 = 0;
        int i6 = 0;
        while (length2 > 0) {
            byte[] bArr3 = pem_convert_array;
            int i7 = i5 + 1;
            int i8 = i7 + 1;
            int i9 = ((bArr3[bArr[i5] & 255] << 6) | bArr3[bArr[i7] & 255]) << 6;
            byte b4 = bArr[i8];
            if (b4 != 61) {
                i8++;
                i9 |= bArr3[b4 & 255];
                i4 = 3;
            } else {
                i4 = 2;
            }
            int i10 = i9 << 6;
            byte b5 = bArr[i8];
            if (b5 != 61) {
                i8++;
                i10 |= bArr3[b5 & 255];
            } else {
                i4--;
            }
            if (i4 > 2) {
                bArr2[i6 + 2] = (byte) (i10 & 255);
            }
            int i11 = i10 >> 8;
            if (i4 > 1) {
                bArr2[i6 + 1] = (byte) (i11 & 255);
            }
            bArr2[i6] = (byte) ((i11 >> 8) & 255);
            i6 += i4;
            length2 -= 4;
            i5 = i8;
        }
        return bArr2;
    }
}
