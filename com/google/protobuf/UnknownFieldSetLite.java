package com.google.protobuf;

import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes6.dex */
public final class UnknownFieldSetLite {

    /* renamed from: f  reason: collision with root package name */
    private static final UnknownFieldSetLite f33587f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* renamed from: a  reason: collision with root package name */
    private int f33588a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f33589b;

    /* renamed from: c  reason: collision with root package name */
    private Object[] f33590c;

    /* renamed from: d  reason: collision with root package name */
    private int f33591d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33592e;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void b(int i4) {
        int[] iArr = this.f33589b;
        if (i4 > iArr.length) {
            int i5 = this.f33588a;
            int i6 = i5 + (i5 / 2);
            if (i6 >= i4) {
                i4 = i6;
            }
            if (i4 < 8) {
                i4 = 8;
            }
            this.f33589b = Arrays.copyOf(iArr, i4);
            this.f33590c = Arrays.copyOf(this.f33590c, i4);
        }
    }

    private static int c(int[] iArr, int i4) {
        int i5 = 17;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        return i5;
    }

    private static int d(Object[] objArr, int i4) {
        int i5 = 17;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 = (i5 * 31) + objArr[i6].hashCode();
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite f(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i4 = unknownFieldSetLite.f33588a + unknownFieldSetLite2.f33588a;
        int[] copyOf = Arrays.copyOf(unknownFieldSetLite.f33589b, i4);
        System.arraycopy(unknownFieldSetLite2.f33589b, 0, copyOf, unknownFieldSetLite.f33588a, unknownFieldSetLite2.f33588a);
        Object[] copyOf2 = Arrays.copyOf(unknownFieldSetLite.f33590c, i4);
        System.arraycopy(unknownFieldSetLite2.f33590c, 0, copyOf2, unknownFieldSetLite.f33588a, unknownFieldSetLite2.f33588a);
        return new UnknownFieldSetLite(i4, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnknownFieldSetLite g() {
        return new UnknownFieldSetLite();
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return f33587f;
    }

    private static boolean h(Object[] objArr, Object[] objArr2, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (!objArr[i5].equals(objArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    private static boolean k(int[] iArr, int[] iArr2, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (iArr[i5] != iArr2[i5]) {
                return false;
            }
        }
        return true;
    }

    private static void m(int i4, Object obj, Writer writer) throws IOException {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i4);
        int tagWireType = WireFormat.getTagWireType(i4);
        if (tagWireType != 0) {
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    if (tagWireType != 3) {
                        if (tagWireType == 5) {
                            writer.writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
                            return;
                        }
                        throw new RuntimeException(InvalidProtocolBufferException.f());
                    } else if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
                        writer.writeStartGroup(tagFieldNumber);
                        ((UnknownFieldSetLite) obj).writeTo(writer);
                        writer.writeEndGroup(tagFieldNumber);
                        return;
                    } else {
                        writer.writeEndGroup(tagFieldNumber);
                        ((UnknownFieldSetLite) obj).writeTo(writer);
                        writer.writeStartGroup(tagFieldNumber);
                        return;
                    }
                }
                writer.writeBytes(tagFieldNumber, (ByteString) obj);
                return;
            }
            writer.writeFixed64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        writer.writeInt64(tagFieldNumber, ((Long) obj).longValue());
    }

    void a() {
        if (this.f33592e) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public UnknownFieldSetLite e(UnknownFieldSetLite unknownFieldSetLite) {
        if (unknownFieldSetLite.equals(getDefaultInstance())) {
            return this;
        }
        a();
        int i4 = this.f33588a + unknownFieldSetLite.f33588a;
        b(i4);
        System.arraycopy(unknownFieldSetLite.f33589b, 0, this.f33589b, this.f33588a, unknownFieldSetLite.f33588a);
        System.arraycopy(unknownFieldSetLite.f33590c, 0, this.f33590c, this.f33588a, unknownFieldSetLite.f33588a);
        this.f33588a = i4;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i4 = this.f33588a;
        if (i4 == unknownFieldSetLite.f33588a && k(this.f33589b, unknownFieldSetLite.f33589b, i4) && h(this.f33590c, unknownFieldSetLite.f33590c, this.f33588a)) {
            return true;
        }
        return false;
    }

    public int getSerializedSize() {
        int computeUInt64Size;
        int i4 = this.f33591d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f33588a; i6++) {
            int i7 = this.f33589b[i6];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i7);
            int tagWireType = WireFormat.getTagWireType(i7);
            if (tagWireType != 0) {
                if (tagWireType != 1) {
                    if (tagWireType != 2) {
                        if (tagWireType != 3) {
                            if (tagWireType == 5) {
                                computeUInt64Size = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.f33590c[i6]).intValue());
                            } else {
                                throw new IllegalStateException(InvalidProtocolBufferException.f());
                            }
                        } else {
                            computeUInt64Size = (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((UnknownFieldSetLite) this.f33590c[i6]).getSerializedSize();
                        }
                    } else {
                        computeUInt64Size = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.f33590c[i6]);
                    }
                } else {
                    computeUInt64Size = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.f33590c[i6]).longValue());
                }
            } else {
                computeUInt64Size = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.f33590c[i6]).longValue());
            }
            i5 += computeUInt64Size;
        }
        this.f33591d = i5;
        return i5;
    }

    public int getSerializedSizeAsMessageSet() {
        int i4 = this.f33591d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f33588a; i6++) {
            i5 += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.f33589b[i6]), (ByteString) this.f33590c[i6]);
        }
        this.f33591d = i5;
        return i5;
    }

    public int hashCode() {
        int i4 = this.f33588a;
        return ((((527 + i4) * 31) + c(this.f33589b, i4)) * 31) + d(this.f33590c, this.f33588a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < this.f33588a; i5++) {
            MessageLiteToString.d(sb, i4, String.valueOf(WireFormat.getTagFieldNumber(this.f33589b[i5])), this.f33590c[i5]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(int i4, Object obj) {
        a();
        b(this.f33588a + 1);
        int[] iArr = this.f33589b;
        int i5 = this.f33588a;
        iArr[i5] = i4;
        this.f33590c[i5] = obj;
        this.f33588a = i5 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            for (int i4 = this.f33588a - 1; i4 >= 0; i4--) {
                writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.f33589b[i4]), this.f33590c[i4]);
            }
            return;
        }
        for (int i5 = 0; i5 < this.f33588a; i5++) {
            writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.f33589b[i5]), this.f33590c[i5]);
        }
    }

    public void makeImmutable() {
        this.f33592e = false;
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i4 = 0; i4 < this.f33588a; i4++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.f33589b[i4]), (ByteString) this.f33590c[i4]);
        }
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (int i4 = 0; i4 < this.f33588a; i4++) {
            int i5 = this.f33589b[i4];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i5);
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.f33590c[i4]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.f33590c[i4]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.f33590c[i4]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.f33590c[i4]).writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else if (tagWireType == 5) {
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.f33590c[i4]).intValue());
            } else {
                throw InvalidProtocolBufferException.f();
            }
        }
    }

    private UnknownFieldSetLite(int i4, int[] iArr, Object[] objArr, boolean z3) {
        this.f33591d = -1;
        this.f33588a = i4;
        this.f33589b = iArr;
        this.f33590c = objArr;
        this.f33592e = z3;
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.f33588a == 0) {
            return;
        }
        if (writer.fieldOrder() == Writer.FieldOrder.ASCENDING) {
            for (int i4 = 0; i4 < this.f33588a; i4++) {
                m(this.f33589b[i4], this.f33590c[i4], writer);
            }
            return;
        }
        for (int i5 = this.f33588a - 1; i5 >= 0; i5--) {
            m(this.f33589b[i5], this.f33590c[i5], writer);
        }
    }
}
