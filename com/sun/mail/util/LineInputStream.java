package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;

/* loaded from: classes6.dex */
public class LineInputStream extends FilterInputStream {
    private boolean allowutf8;
    private CharsetDecoder decoder;
    private byte[] lineBuffer;
    private static boolean defaultutf8 = PropUtil.getBooleanSystemProperty("mail.mime.allowutf8", false);
    private static int MAX_INCR = 1048576;

    public LineInputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    public String readLine() throws IOException {
        int read;
        byte[] bArr = this.lineBuffer;
        if (bArr == null) {
            bArr = new byte[128];
            this.lineBuffer = bArr;
        }
        int length = bArr.length;
        int i4 = 0;
        while (true) {
            read = ((FilterInputStream) this).in.read();
            if (read == -1 || read == 10) {
                break;
            }
            boolean z3 = true;
            if (read == 13) {
                if (((FilterInputStream) this).in.markSupported()) {
                    ((FilterInputStream) this).in.mark(2);
                }
                int read2 = ((FilterInputStream) this).in.read();
                if (read2 == 13) {
                    read2 = ((FilterInputStream) this).in.read();
                } else {
                    z3 = false;
                }
                if (read2 != 10) {
                    if (((FilterInputStream) this).in.markSupported()) {
                        ((FilterInputStream) this).in.reset();
                    } else {
                        if (!(((FilterInputStream) this).in instanceof PushbackInputStream)) {
                            ((FilterInputStream) this).in = new PushbackInputStream(((FilterInputStream) this).in, 2);
                        }
                        if (read2 != -1) {
                            ((PushbackInputStream) ((FilterInputStream) this).in).unread(read2);
                        }
                        if (z3) {
                            ((PushbackInputStream) ((FilterInputStream) this).in).unread(13);
                        }
                    }
                }
            } else {
                length--;
                if (length < 0) {
                    int length2 = bArr.length;
                    int i5 = MAX_INCR;
                    if (length2 < i5) {
                        bArr = new byte[bArr.length * 2];
                    } else {
                        bArr = new byte[bArr.length + i5];
                    }
                    length = (bArr.length - i4) - 1;
                    System.arraycopy(this.lineBuffer, 0, bArr, 0, i4);
                    this.lineBuffer = bArr;
                }
                bArr[i4] = (byte) read;
                i4++;
            }
        }
        if (read == -1 && i4 == 0) {
            return null;
        }
        if (this.allowutf8) {
            return new String(bArr, 0, i4, StandardCharsets.UTF_8);
        }
        if (defaultutf8) {
            try {
                return this.decoder.decode(ByteBuffer.wrap(bArr, 0, i4)).toString();
            } catch (CharacterCodingException unused) {
            }
        }
        return new String(bArr, 0, 0, i4);
    }

    public LineInputStream(InputStream inputStream, boolean z3) {
        super(inputStream);
        this.lineBuffer = null;
        this.allowutf8 = z3;
        if (z3 || !defaultutf8) {
            return;
        }
        CharsetDecoder newDecoder = StandardCharsets.UTF_8.newDecoder();
        this.decoder = newDecoder;
        newDecoder.onMalformedInput(CodingErrorAction.REPORT);
        this.decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
    }
}
