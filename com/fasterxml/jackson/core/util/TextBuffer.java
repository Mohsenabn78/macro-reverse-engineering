package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.BufferRecycler;
import java.math.BigDecimal;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class TextBuffer {

    /* renamed from: l  reason: collision with root package name */
    static final char[] f17895l = new char[0];

    /* renamed from: a  reason: collision with root package name */
    private final BufferRecycler f17896a;

    /* renamed from: b  reason: collision with root package name */
    private char[] f17897b;

    /* renamed from: c  reason: collision with root package name */
    private int f17898c;

    /* renamed from: d  reason: collision with root package name */
    private int f17899d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<char[]> f17900e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17901f = false;

    /* renamed from: g  reason: collision with root package name */
    private int f17902g;

    /* renamed from: h  reason: collision with root package name */
    private char[] f17903h;

    /* renamed from: i  reason: collision with root package name */
    private int f17904i;

    /* renamed from: j  reason: collision with root package name */
    private String f17905j;

    /* renamed from: k  reason: collision with root package name */
    private char[] f17906k;

    public TextBuffer(BufferRecycler bufferRecycler) {
        this.f17896a = bufferRecycler;
    }

    private char[] a(int i4) {
        return new char[i4];
    }

    private char[] b() {
        int i4;
        String str = this.f17905j;
        if (str != null) {
            return str.toCharArray();
        }
        if (this.f17898c >= 0) {
            int i5 = this.f17899d;
            if (i5 < 1) {
                return f17895l;
            }
            char[] a4 = a(i5);
            System.arraycopy(this.f17897b, this.f17898c, a4, 0, this.f17899d);
            return a4;
        }
        int size = size();
        if (size < 1) {
            return f17895l;
        }
        char[] a5 = a(size);
        ArrayList<char[]> arrayList = this.f17900e;
        if (arrayList != null) {
            int size2 = arrayList.size();
            i4 = 0;
            for (int i6 = 0; i6 < size2; i6++) {
                char[] cArr = this.f17900e.get(i6);
                int length = cArr.length;
                System.arraycopy(cArr, 0, a5, i4, length);
                i4 += length;
            }
        } else {
            i4 = 0;
        }
        System.arraycopy(this.f17903h, 0, a5, i4, this.f17904i);
        return a5;
    }

    private void c() {
        this.f17901f = false;
        this.f17900e.clear();
        this.f17902g = 0;
        this.f17904i = 0;
    }

    private void d(int i4) {
        if (this.f17900e == null) {
            this.f17900e = new ArrayList<>();
        }
        char[] cArr = this.f17903h;
        this.f17901f = true;
        this.f17900e.add(cArr);
        this.f17902g += cArr.length;
        int length = cArr.length;
        int i5 = length >> 1;
        if (i5 >= i4) {
            i4 = i5;
        }
        char[] a4 = a(Math.min(262144, length + i4));
        this.f17904i = 0;
        this.f17903h = a4;
    }

    private char[] e(int i4) {
        BufferRecycler bufferRecycler = this.f17896a;
        if (bufferRecycler != null) {
            return bufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.TEXT_BUFFER, i4);
        }
        return new char[Math.max(i4, 1000)];
    }

    private void f(int i4) {
        int i5 = this.f17899d;
        this.f17899d = 0;
        char[] cArr = this.f17897b;
        this.f17897b = null;
        int i6 = this.f17898c;
        this.f17898c = -1;
        int i7 = i4 + i5;
        char[] cArr2 = this.f17903h;
        if (cArr2 == null || i7 > cArr2.length) {
            this.f17903h = e(i7);
        }
        if (i5 > 0) {
            System.arraycopy(cArr, i6, this.f17903h, 0, i5);
        }
        this.f17902g = 0;
        this.f17904i = i5;
    }

    public void append(char c4) {
        if (this.f17898c >= 0) {
            f(16);
        }
        this.f17905j = null;
        this.f17906k = null;
        char[] cArr = this.f17903h;
        if (this.f17904i >= cArr.length) {
            d(1);
            cArr = this.f17903h;
        }
        int i4 = this.f17904i;
        this.f17904i = i4 + 1;
        cArr[i4] = c4;
    }

    public char[] contentsAsArray() {
        char[] cArr = this.f17906k;
        if (cArr == null) {
            char[] b4 = b();
            this.f17906k = b4;
            return b4;
        }
        return cArr;
    }

    public BigDecimal contentsAsDecimal() throws NumberFormatException {
        if (this.f17906k != null) {
            return new BigDecimal(this.f17906k);
        }
        if (this.f17898c >= 0) {
            return new BigDecimal(this.f17897b, this.f17898c, this.f17899d);
        }
        if (this.f17902g == 0) {
            return new BigDecimal(this.f17903h, 0, this.f17904i);
        }
        return new BigDecimal(contentsAsArray());
    }

    public double contentsAsDouble() throws NumberFormatException {
        return NumberInput.parseDouble(contentsAsString());
    }

    public String contentsAsString() {
        if (this.f17905j == null) {
            char[] cArr = this.f17906k;
            if (cArr != null) {
                this.f17905j = new String(cArr);
            } else {
                int i4 = this.f17898c;
                String str = "";
                if (i4 >= 0) {
                    int i5 = this.f17899d;
                    if (i5 < 1) {
                        this.f17905j = "";
                        return "";
                    }
                    this.f17905j = new String(this.f17897b, i4, i5);
                } else {
                    int i6 = this.f17902g;
                    int i7 = this.f17904i;
                    if (i6 == 0) {
                        if (i7 != 0) {
                            str = new String(this.f17903h, 0, i7);
                        }
                        this.f17905j = str;
                    } else {
                        StringBuilder sb = new StringBuilder(i6 + i7);
                        ArrayList<char[]> arrayList = this.f17900e;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i8 = 0; i8 < size; i8++) {
                                char[] cArr2 = this.f17900e.get(i8);
                                sb.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb.append(this.f17903h, 0, this.f17904i);
                        this.f17905j = sb.toString();
                    }
                }
            }
        }
        return this.f17905j;
    }

    public char[] emptyAndGetCurrentSegment() {
        this.f17898c = -1;
        this.f17904i = 0;
        this.f17899d = 0;
        this.f17897b = null;
        this.f17905j = null;
        this.f17906k = null;
        if (this.f17901f) {
            c();
        }
        char[] cArr = this.f17903h;
        if (cArr == null) {
            char[] e4 = e(0);
            this.f17903h = e4;
            return e4;
        }
        return cArr;
    }

    public void ensureNotShared() {
        if (this.f17898c >= 0) {
            f(16);
        }
    }

    public char[] expandCurrentSegment() {
        int min;
        char[] cArr = this.f17903h;
        int length = cArr.length;
        if (length == 262144) {
            min = 262145;
        } else {
            min = Math.min(262144, (length >> 1) + length);
        }
        char[] a4 = a(min);
        this.f17903h = a4;
        System.arraycopy(cArr, 0, a4, 0, length);
        return this.f17903h;
    }

    public char[] finishCurrentSegment() {
        if (this.f17900e == null) {
            this.f17900e = new ArrayList<>();
        }
        this.f17901f = true;
        this.f17900e.add(this.f17903h);
        int length = this.f17903h.length;
        this.f17902g += length;
        char[] a4 = a(Math.min(length + (length >> 1), 262144));
        this.f17904i = 0;
        this.f17903h = a4;
        return a4;
    }

    public char[] getCurrentSegment() {
        if (this.f17898c >= 0) {
            f(1);
        } else {
            char[] cArr = this.f17903h;
            if (cArr == null) {
                this.f17903h = e(0);
            } else if (this.f17904i >= cArr.length) {
                d(1);
            }
        }
        return this.f17903h;
    }

    public int getCurrentSegmentSize() {
        return this.f17904i;
    }

    public char[] getTextBuffer() {
        if (this.f17898c >= 0) {
            return this.f17897b;
        }
        char[] cArr = this.f17906k;
        if (cArr != null) {
            return cArr;
        }
        String str = this.f17905j;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.f17906k = charArray;
            return charArray;
        } else if (!this.f17901f) {
            return this.f17903h;
        } else {
            return contentsAsArray();
        }
    }

    public int getTextOffset() {
        int i4 = this.f17898c;
        if (i4 < 0) {
            return 0;
        }
        return i4;
    }

    public boolean hasTextAsCharacters() {
        if (this.f17898c >= 0 || this.f17906k != null || this.f17905j == null) {
            return true;
        }
        return false;
    }

    public void releaseBuffers() {
        if (this.f17896a == null) {
            resetWithEmpty();
        } else if (this.f17903h != null) {
            resetWithEmpty();
            char[] cArr = this.f17903h;
            this.f17903h = null;
            this.f17896a.releaseCharBuffer(BufferRecycler.CharBufferType.TEXT_BUFFER, cArr);
        }
    }

    public void resetWithCopy(char[] cArr, int i4, int i5) {
        this.f17897b = null;
        this.f17898c = -1;
        this.f17899d = 0;
        this.f17905j = null;
        this.f17906k = null;
        if (this.f17901f) {
            c();
        } else if (this.f17903h == null) {
            this.f17903h = e(i5);
        }
        this.f17902g = 0;
        this.f17904i = 0;
        append(cArr, i4, i5);
    }

    public void resetWithEmpty() {
        this.f17898c = -1;
        this.f17904i = 0;
        this.f17899d = 0;
        this.f17897b = null;
        this.f17905j = null;
        this.f17906k = null;
        if (this.f17901f) {
            c();
        }
    }

    public void resetWithShared(char[] cArr, int i4, int i5) {
        this.f17905j = null;
        this.f17906k = null;
        this.f17897b = cArr;
        this.f17898c = i4;
        this.f17899d = i5;
        if (this.f17901f) {
            c();
        }
    }

    public void resetWithString(String str) {
        this.f17897b = null;
        this.f17898c = -1;
        this.f17899d = 0;
        this.f17905j = str;
        this.f17906k = null;
        if (this.f17901f) {
            c();
        }
        this.f17904i = 0;
    }

    public void setCurrentLength(int i4) {
        this.f17904i = i4;
    }

    public int size() {
        if (this.f17898c >= 0) {
            return this.f17899d;
        }
        char[] cArr = this.f17906k;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.f17905j;
        if (str != null) {
            return str.length();
        }
        return this.f17902g + this.f17904i;
    }

    public String toString() {
        return contentsAsString();
    }

    public void append(char[] cArr, int i4, int i5) {
        if (this.f17898c >= 0) {
            f(i5);
        }
        this.f17905j = null;
        this.f17906k = null;
        char[] cArr2 = this.f17903h;
        int length = cArr2.length;
        int i6 = this.f17904i;
        int i7 = length - i6;
        if (i7 >= i5) {
            System.arraycopy(cArr, i4, cArr2, i6, i5);
            this.f17904i += i5;
            return;
        }
        if (i7 > 0) {
            System.arraycopy(cArr, i4, cArr2, i6, i7);
            i4 += i7;
            i5 -= i7;
        }
        do {
            d(i5);
            int min = Math.min(this.f17903h.length, i5);
            System.arraycopy(cArr, i4, this.f17903h, 0, min);
            this.f17904i += min;
            i4 += min;
            i5 -= min;
        } while (i5 > 0);
    }

    public void append(String str, int i4, int i5) {
        if (this.f17898c >= 0) {
            f(i5);
        }
        this.f17905j = null;
        this.f17906k = null;
        char[] cArr = this.f17903h;
        int length = cArr.length;
        int i6 = this.f17904i;
        int i7 = length - i6;
        if (i7 >= i5) {
            str.getChars(i4, i4 + i5, cArr, i6);
            this.f17904i += i5;
            return;
        }
        if (i7 > 0) {
            int i8 = i4 + i7;
            str.getChars(i4, i8, cArr, i6);
            i5 -= i7;
            i4 = i8;
        }
        while (true) {
            d(i5);
            int min = Math.min(this.f17903h.length, i5);
            int i9 = i4 + min;
            str.getChars(i4, i9, this.f17903h, 0);
            this.f17904i += min;
            i5 -= min;
            if (i5 <= 0) {
                return;
            }
            i4 = i9;
        }
    }
}
