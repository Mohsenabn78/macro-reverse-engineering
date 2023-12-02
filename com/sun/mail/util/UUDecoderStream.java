package com.sun.mail.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8;

/* loaded from: classes6.dex */
public class UUDecoderStream extends FilterInputStream {
    private byte[] buffer;
    private int bufsize;
    private boolean gotEnd;
    private boolean gotPrefix;
    private boolean ignoreErrors;
    private boolean ignoreMissingBeginEnd;
    private int index;
    private LineInputStream lin;
    private int mode;
    private String name;
    private String readAhead;

    public UUDecoderStream(InputStream inputStream) {
        super(inputStream);
        this.buffer = new byte[45];
        this.bufsize = 0;
        this.index = 0;
        this.gotPrefix = false;
        this.gotEnd = false;
        this.lin = new LineInputStream(inputStream);
        this.ignoreErrors = PropUtil.getBooleanSystemProperty("mail.mime.uudecode.ignoreerrors", false);
        this.ignoreMissingBeginEnd = PropUtil.getBooleanSystemProperty("mail.mime.uudecode.ignoremissingbeginend", false);
    }

    private boolean decode() throws IOException {
        if (this.gotEnd) {
            return false;
        }
        this.bufsize = 0;
        while (true) {
            String str = this.readAhead;
            if (str != null) {
                this.readAhead = null;
            } else {
                str = this.lin.readLine();
            }
            if (str == null) {
                if (this.ignoreMissingBeginEnd) {
                    this.gotEnd = true;
                    return false;
                }
                throw new DecodingException("UUDecoder: Missing end at EOF");
            } else if (str.equals("end")) {
                this.gotEnd = true;
                return false;
            } else if (str.length() != 0) {
                char charAt = str.charAt(0);
                if (charAt < ' ') {
                    if (!this.ignoreErrors) {
                        throw new DecodingException("UUDecoder: Buffer format error");
                    }
                } else {
                    int i4 = (charAt - ' ') & 63;
                    if (i4 == 0) {
                        String readLine = this.lin.readLine();
                        if ((readLine != null && readLine.equals("end")) || this.ignoreMissingBeginEnd) {
                            this.gotEnd = true;
                            return false;
                        }
                        throw new DecodingException("UUDecoder: Missing End after count 0 line");
                    } else if (str.length() < (((i4 * 8) + 5) / 6) + 1) {
                        if (!this.ignoreErrors) {
                            throw new DecodingException("UUDecoder: Short buffer error");
                        }
                    } else {
                        int i5 = 1;
                        while (this.bufsize < i4) {
                            int i6 = i5 + 1;
                            int i7 = i6 + 1;
                            byte charAt2 = (byte) ((str.charAt(i6) - ' ') & 63);
                            byte[] bArr = this.buffer;
                            int i8 = this.bufsize;
                            int i9 = i8 + 1;
                            this.bufsize = i9;
                            bArr[i8] = (byte) (((((byte) ((str.charAt(i5) - ' ') & 63)) << 2) & 252) | ((charAt2 >>> 4) & 3));
                            if (i9 < i4) {
                                i5 = i7 + 1;
                                byte charAt3 = (byte) ((str.charAt(i7) - ' ') & 63);
                                byte[] bArr2 = this.buffer;
                                int i10 = this.bufsize;
                                this.bufsize = i10 + 1;
                                bArr2[i10] = (byte) (((charAt2 << 4) & 240) | ((charAt3 >>> 2) & 15));
                                charAt2 = charAt3;
                            } else {
                                i5 = i7;
                            }
                            if (this.bufsize < i4) {
                                int i11 = i5 + 1;
                                byte[] bArr3 = this.buffer;
                                int i12 = this.bufsize;
                                this.bufsize = i12 + 1;
                                bArr3[i12] = (byte) ((((byte) ((str.charAt(i5) - ' ') & 63)) & Utf8.REPLACEMENT_BYTE) | ((charAt2 << 6) & 192));
                                i5 = i11;
                            }
                        }
                        return true;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b2, code lost:
        r8.readAhead = r0;
        r8.gotPrefix = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b6, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void readPrefix() throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.gotPrefix
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 438(0x1b6, float:6.14E-43)
            r8.mode = r0
            java.lang.String r0 = "encoder.buf"
            r8.name = r0
        Ld:
            com.sun.mail.util.LineInputStream r0 = r8.lin
            java.lang.String r0 = r0.readLine()
            r7 = 1
            if (r0 != 0) goto L28
            boolean r0 = r8.ignoreMissingBeginEnd
            if (r0 == 0) goto L20
            r8.gotPrefix = r7
            r8.gotEnd = r7
            goto Lb6
        L20:
            com.sun.mail.util.DecodingException r0 = new com.sun.mail.util.DecodingException
            java.lang.String r1 = "UUDecoder: Missing begin"
            r0.<init>(r1)
            throw r0
        L28:
            r2 = 0
            r3 = 0
            java.lang.String r4 = "begin"
            r5 = 0
            r6 = 5
            r1 = r0
            boolean r1 = r1.regionMatches(r2, r3, r4, r5, r6)
            r2 = 6
            if (r1 == 0) goto L90
            r1 = 9
            java.lang.String r1 = r0.substring(r2, r1)     // Catch: java.lang.NumberFormatException -> L43
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L43
            r8.mode = r1     // Catch: java.lang.NumberFormatException -> L43
            goto L48
        L43:
            r1 = move-exception
            boolean r2 = r8.ignoreErrors
            if (r2 == 0) goto L75
        L48:
            int r1 = r0.length()
            r2 = 10
            if (r1 <= r2) goto L57
            java.lang.String r0 = r0.substring(r2)
            r8.name = r0
            goto L5b
        L57:
            boolean r1 = r8.ignoreErrors
            if (r1 == 0) goto L5e
        L5b:
            r8.gotPrefix = r7
            goto Lb6
        L5e:
            com.sun.mail.util.DecodingException r1 = new com.sun.mail.util.DecodingException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "UUDecoder: Missing name: "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L75:
            com.sun.mail.util.DecodingException r0 = new com.sun.mail.util.DecodingException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "UUDecoder: Error in mode: "
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L90:
            boolean r1 = r8.ignoreMissingBeginEnd
            if (r1 == 0) goto Ld
            int r1 = r0.length()
            if (r1 == 0) goto Ld
            r1 = 0
            char r1 = r0.charAt(r1)
            int r1 = r1 + (-32)
            r1 = r1 & 63
            int r1 = r1 * 8
            int r1 = r1 + 5
            int r1 = r1 / r2
            if (r1 == 0) goto Lb2
            int r2 = r0.length()
            int r1 = r1 + 1
            if (r2 < r1) goto Ld
        Lb2:
            r8.readAhead = r0
            r8.gotPrefix = r7
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.UUDecoderStream.readPrefix():void");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return ((((FilterInputStream) this).in.available() * 3) / 4) + (this.bufsize - this.index);
    }

    public int getMode() throws IOException {
        readPrefix();
        return this.mode;
    }

    public String getName() throws IOException {
        readPrefix();
        return this.name;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.index >= this.bufsize) {
            readPrefix();
            if (!decode()) {
                return -1;
            }
            this.index = 0;
        }
        byte[] bArr = this.buffer;
        int i4 = this.index;
        this.index = i4 + 1;
        return bArr[i4] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i4, int i5) throws IOException {
        int i6 = 0;
        while (i6 < i5) {
            int read = read();
            if (read == -1) {
                if (i6 == 0) {
                    return -1;
                }
                return i6;
            }
            bArr[i4 + i6] = (byte) read;
            i6++;
        }
        return i6;
    }

    public UUDecoderStream(InputStream inputStream, boolean z3, boolean z4) {
        super(inputStream);
        this.buffer = new byte[45];
        this.bufsize = 0;
        this.index = 0;
        this.gotPrefix = false;
        this.gotEnd = false;
        this.lin = new LineInputStream(inputStream);
        this.ignoreErrors = z3;
        this.ignoreMissingBeginEnd = z4;
    }
}
