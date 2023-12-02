package com.android.dx.util;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes2.dex */
public final class IndentingWriter extends FilterWriter {
    private boolean collectingIndent;
    private int column;
    private int indent;
    private final int maxIndent;
    private final String prefix;
    private final int width;

    public IndentingWriter(Writer writer, int i4, String str) {
        super(writer);
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("width < 0");
        }
        if (str != null) {
            this.width = i4 != 0 ? i4 : Integer.MAX_VALUE;
            this.maxIndent = i4 >> 1;
            this.prefix = str.length() == 0 ? null : str;
            bol();
            return;
        }
        throw new NullPointerException("prefix == null");
    }

    private void bol() {
        boolean z3;
        this.column = 0;
        if (this.maxIndent != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.collectingIndent = z3;
        this.indent = 0;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i4) throws IOException {
        int i5;
        synchronized (((FilterWriter) this).lock) {
            int i6 = 0;
            if (this.collectingIndent) {
                if (i4 == 32) {
                    int i7 = this.indent + 1;
                    this.indent = i7;
                    int i8 = this.maxIndent;
                    if (i7 >= i8) {
                        this.indent = i8;
                        this.collectingIndent = false;
                    }
                } else {
                    this.collectingIndent = false;
                }
            }
            if (this.column == this.width && i4 != 10) {
                ((FilterWriter) this).out.write(10);
                this.column = 0;
            }
            if (this.column == 0) {
                String str = this.prefix;
                if (str != null) {
                    ((FilterWriter) this).out.write(str);
                }
                if (!this.collectingIndent) {
                    while (true) {
                        i5 = this.indent;
                        if (i6 >= i5) {
                            break;
                        }
                        ((FilterWriter) this).out.write(32);
                        i6++;
                    }
                    this.column = i5;
                }
            }
            ((FilterWriter) this).out.write(i4);
            if (i4 == 10) {
                bol();
            } else {
                this.column++;
            }
        }
    }

    public IndentingWriter(Writer writer, int i4) {
        this(writer, i4, "");
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i4, int i5) throws IOException {
        synchronized (((FilterWriter) this).lock) {
            while (i5 > 0) {
                write(cArr[i4]);
                i4++;
                i5--;
            }
        }
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i4, int i5) throws IOException {
        synchronized (((FilterWriter) this).lock) {
            while (i5 > 0) {
                write(str.charAt(i4));
                i4++;
                i5--;
            }
        }
    }
}
