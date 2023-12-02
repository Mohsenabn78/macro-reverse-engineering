package com.android.dx.util;

import com.android.dex.Leb128;
import com.android.dex.util.ByteOutput;
import com.android.dex.util.ExceptionWithContext;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class ByteArrayAnnotatedOutput implements AnnotatedOutput, ByteOutput {
    private static final int DEFAULT_SIZE = 1000;
    private int annotationWidth;
    private ArrayList<Annotation> annotations;
    private int cursor;
    private byte[] data;
    private int hexCols;
    private final boolean stretchy;
    private boolean verbose;

    public ByteArrayAnnotatedOutput(byte[] bArr) {
        this(bArr, false);
    }

    private void ensureCapacity(int i4) {
        byte[] bArr = this.data;
        if (bArr.length < i4) {
            byte[] bArr2 = new byte[(i4 * 2) + 1000];
            System.arraycopy(bArr, 0, bArr2, 0, this.cursor);
            this.data = bArr2;
        }
    }

    private static void throwBounds() {
        throw new IndexOutOfBoundsException("attempt to write past the end");
    }

    @Override // com.android.dx.util.Output
    public void alignTo(int i4) {
        int i5 = i4 - 1;
        if (i4 >= 0 && (i4 & i5) == 0) {
            int i6 = (this.cursor + i5) & (~i5);
            if (this.stretchy) {
                ensureCapacity(i6);
            } else if (i6 > this.data.length) {
                throwBounds();
                return;
            }
            this.cursor = i6;
            return;
        }
        throw new IllegalArgumentException("bogus alignment");
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public void annotate(String str) {
        if (this.annotations == null) {
            return;
        }
        endAnnotation();
        this.annotations.add(new Annotation(this.cursor, str));
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public boolean annotates() {
        if (this.annotations != null) {
            return true;
        }
        return false;
    }

    @Override // com.android.dx.util.Output
    public void assertCursor(int i4) {
        if (this.cursor == i4) {
            return;
        }
        throw new ExceptionWithContext("expected cursor " + i4 + "; actual value: " + this.cursor);
    }

    public void enableAnnotations(int i4, boolean z3) {
        if (this.annotations == null && this.cursor == 0) {
            if (i4 >= 40) {
                int i5 = (((i4 - 7) / 15) + 1) & (-2);
                if (i5 < 6) {
                    i5 = 6;
                } else if (i5 > 10) {
                    i5 = 10;
                }
                this.annotations = new ArrayList<>(1000);
                this.annotationWidth = i4;
                this.hexCols = i5;
                this.verbose = z3;
                return;
            }
            throw new IllegalArgumentException("annotationWidth < 40");
        }
        throw new RuntimeException("cannot enable annotations");
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public void endAnnotation() {
        int size;
        ArrayList<Annotation> arrayList = this.annotations;
        if (arrayList != null && (size = arrayList.size()) != 0) {
            this.annotations.get(size - 1).setEndIfUnset(this.cursor);
        }
    }

    public void finishAnnotating() {
        endAnnotation();
        ArrayList<Annotation> arrayList = this.annotations;
        if (arrayList != null) {
            for (int size = arrayList.size(); size > 0; size--) {
                int i4 = size - 1;
                Annotation annotation = this.annotations.get(i4);
                if (annotation.getStart() > this.cursor) {
                    this.annotations.remove(i4);
                } else {
                    int end = annotation.getEnd();
                    int i5 = this.cursor;
                    if (end > i5) {
                        annotation.setEnd(i5);
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public int getAnnotationWidth() {
        int i4 = this.hexCols;
        return this.annotationWidth - (((i4 * 2) + 8) + (i4 / 2));
    }

    public byte[] getArray() {
        return this.data;
    }

    @Override // com.android.dx.util.Output
    public int getCursor() {
        return this.cursor;
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public boolean isVerbose() {
        return this.verbose;
    }

    public byte[] toByteArray() {
        int i4 = this.cursor;
        byte[] bArr = new byte[i4];
        System.arraycopy(this.data, 0, bArr, 0, i4);
        return bArr;
    }

    @Override // com.android.dx.util.Output
    public void write(ByteArray byteArray) {
        int size = byteArray.size();
        int i4 = this.cursor;
        int i5 = size + i4;
        if (this.stretchy) {
            ensureCapacity(i5);
        } else if (i5 > this.data.length) {
            throwBounds();
            return;
        }
        byteArray.getBytes(this.data, i4);
        this.cursor = i5;
    }

    public void writeAnnotationsTo(Writer writer) throws IOException {
        int i4;
        String text;
        int i5;
        int i6;
        int annotationWidth = getAnnotationWidth();
        TwoColumnOutput twoColumnOutput = new TwoColumnOutput(writer, (this.annotationWidth - annotationWidth) - 1, annotationWidth, "|");
        Writer left = twoColumnOutput.getLeft();
        Writer right = twoColumnOutput.getRight();
        int size = this.annotations.size();
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i4 = this.cursor;
            if (i8 >= i4 || i7 >= size) {
                break;
            }
            Annotation annotation = this.annotations.get(i7);
            int start = annotation.getStart();
            if (i8 < start) {
                text = "";
                i6 = start;
                i5 = i8;
            } else {
                int end = annotation.getEnd();
                text = annotation.getText();
                i7++;
                i5 = start;
                i6 = end;
            }
            left.write(Hex.dump(this.data, i5, i6 - i5, i5, this.hexCols, 6));
            right.write(text);
            twoColumnOutput.flush();
            i8 = i6;
        }
        if (i8 < i4) {
            left.write(Hex.dump(this.data, i8, i4 - i8, i8, this.hexCols, 6));
        }
        while (i7 < size) {
            right.write(this.annotations.get(i7).getText());
            i7++;
        }
        twoColumnOutput.flush();
    }

    @Override // com.android.dx.util.Output, com.android.dex.util.ByteOutput
    public void writeByte(int i4) {
        int i5 = this.cursor;
        int i6 = i5 + 1;
        if (this.stretchy) {
            ensureCapacity(i6);
        } else if (i6 > this.data.length) {
            throwBounds();
            return;
        }
        this.data[i5] = (byte) i4;
        this.cursor = i6;
    }

    @Override // com.android.dx.util.Output
    public void writeInt(int i4) {
        int i5 = this.cursor;
        int i6 = i5 + 4;
        if (this.stretchy) {
            ensureCapacity(i6);
        } else if (i6 > this.data.length) {
            throwBounds();
            return;
        }
        byte[] bArr = this.data;
        bArr[i5] = (byte) i4;
        bArr[i5 + 1] = (byte) (i4 >> 8);
        bArr[i5 + 2] = (byte) (i4 >> 16);
        bArr[i5 + 3] = (byte) (i4 >> 24);
        this.cursor = i6;
    }

    @Override // com.android.dx.util.Output
    public void writeLong(long j4) {
        int i4 = this.cursor;
        int i5 = i4 + 8;
        if (this.stretchy) {
            ensureCapacity(i5);
        } else if (i5 > this.data.length) {
            throwBounds();
            return;
        }
        int i6 = (int) j4;
        byte[] bArr = this.data;
        bArr[i4] = (byte) i6;
        bArr[i4 + 1] = (byte) (i6 >> 8);
        bArr[i4 + 2] = (byte) (i6 >> 16);
        bArr[i4 + 3] = (byte) (i6 >> 24);
        int i7 = (int) (j4 >> 32);
        bArr[i4 + 4] = (byte) i7;
        bArr[i4 + 5] = (byte) (i7 >> 8);
        bArr[i4 + 6] = (byte) (i7 >> 16);
        bArr[i4 + 7] = (byte) (i7 >> 24);
        this.cursor = i5;
    }

    @Override // com.android.dx.util.Output
    public void writeShort(int i4) {
        int i5 = this.cursor;
        int i6 = i5 + 2;
        if (this.stretchy) {
            ensureCapacity(i6);
        } else if (i6 > this.data.length) {
            throwBounds();
            return;
        }
        byte[] bArr = this.data;
        bArr[i5] = (byte) i4;
        bArr[i5 + 1] = (byte) (i4 >> 8);
        this.cursor = i6;
    }

    @Override // com.android.dx.util.Output
    public int writeSleb128(int i4) {
        if (this.stretchy) {
            ensureCapacity(this.cursor + 5);
        }
        int i5 = this.cursor;
        Leb128.writeSignedLeb128(this, i4);
        return this.cursor - i5;
    }

    @Override // com.android.dx.util.Output
    public int writeUleb128(int i4) {
        if (this.stretchy) {
            ensureCapacity(this.cursor + 5);
        }
        int i5 = this.cursor;
        Leb128.writeUnsignedLeb128(this, i4);
        return this.cursor - i5;
    }

    @Override // com.android.dx.util.Output
    public void writeZeroes(int i4) {
        if (i4 >= 0) {
            int i5 = this.cursor + i4;
            if (this.stretchy) {
                ensureCapacity(i5);
            } else if (i5 > this.data.length) {
                throwBounds();
                return;
            }
            this.cursor = i5;
            return;
        }
        throw new IllegalArgumentException("count < 0");
    }

    public ByteArrayAnnotatedOutput() {
        this(1000);
    }

    public ByteArrayAnnotatedOutput(int i4) {
        this(new byte[i4], true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class Annotation {
        private int end;
        private final int start;
        private final String text;

        public Annotation(int i4, int i5, String str) {
            this.start = i4;
            this.end = i5;
            this.text = str;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }

        public String getText() {
            return this.text;
        }

        public void setEnd(int i4) {
            this.end = i4;
        }

        public void setEndIfUnset(int i4) {
            if (this.end == Integer.MAX_VALUE) {
                this.end = i4;
            }
        }

        public Annotation(int i4, String str) {
            this(i4, Integer.MAX_VALUE, str);
        }
    }

    private ByteArrayAnnotatedOutput(byte[] bArr, boolean z3) {
        if (bArr != null) {
            this.stretchy = z3;
            this.data = bArr;
            this.cursor = 0;
            this.verbose = false;
            this.annotations = null;
            this.annotationWidth = 0;
            this.hexCols = 0;
            return;
        }
        throw new NullPointerException("data == null");
    }

    @Override // com.android.dx.util.AnnotatedOutput
    public void annotate(int i4, String str) {
        if (this.annotations == null) {
            return;
        }
        endAnnotation();
        int size = this.annotations.size();
        int end = size == 0 ? 0 : this.annotations.get(size - 1).getEnd();
        int i5 = this.cursor;
        if (end <= i5) {
            end = i5;
        }
        this.annotations.add(new Annotation(end, i4 + end, str));
    }

    @Override // com.android.dx.util.Output
    public void write(byte[] bArr, int i4, int i5) {
        int i6 = this.cursor;
        int i7 = i6 + i5;
        int i8 = i4 + i5;
        if ((i4 | i5 | i7) >= 0 && i8 <= bArr.length) {
            if (this.stretchy) {
                ensureCapacity(i7);
            } else if (i7 > this.data.length) {
                throwBounds();
                return;
            }
            System.arraycopy(bArr, i4, this.data, i6, i5);
            this.cursor = i7;
            return;
        }
        throw new IndexOutOfBoundsException("bytes.length " + bArr.length + "; " + i4 + "..!" + i7);
    }

    @Override // com.android.dx.util.Output
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }
}
