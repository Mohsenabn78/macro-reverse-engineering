package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@CheckReturnValue
/* loaded from: classes6.dex */
public final class CodedOutputStreamWriter implements Writer {

    /* renamed from: a  reason: collision with root package name */
    private final CodedOutputStream f33298a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.CodedOutputStreamWriter$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33299a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f33299a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33299a[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33299a[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33299a[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33299a[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33299a[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33299a[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33299a[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f33299a[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f33299a[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f33299a[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f33299a[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.b(codedOutputStream, "output");
        this.f33298a = codedOutputStream2;
        codedOutputStream2.f33274a = this;
    }

    public static CodedOutputStreamWriter f(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f33274a;
        if (codedOutputStreamWriter != null) {
            return codedOutputStreamWriter;
        }
        return new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void g(int i4, boolean z3, V v3, MapEntryLite.Metadata<Boolean, V> metadata) throws IOException {
        this.f33298a.writeTag(i4, 2);
        this.f33298a.writeUInt32NoTag(MapEntryLite.a(metadata, Boolean.valueOf(z3), v3));
        MapEntryLite.e(this.f33298a, metadata, Boolean.valueOf(z3), v3);
    }

    private <V> void h(int i4, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        int i5 = 0;
        for (Integer num : map.keySet()) {
            iArr[i5] = num.intValue();
            i5++;
        }
        Arrays.sort(iArr);
        for (int i6 = 0; i6 < size; i6++) {
            int i7 = iArr[i6];
            V v3 = map.get(Integer.valueOf(i7));
            this.f33298a.writeTag(i4, 2);
            this.f33298a.writeUInt32NoTag(MapEntryLite.a(metadata, Integer.valueOf(i7), v3));
            MapEntryLite.e(this.f33298a, metadata, Integer.valueOf(i7), v3);
        }
    }

    private <V> void i(int i4, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        int i5 = 0;
        for (Long l4 : map.keySet()) {
            jArr[i5] = l4.longValue();
            i5++;
        }
        Arrays.sort(jArr);
        for (int i6 = 0; i6 < size; i6++) {
            long j4 = jArr[i6];
            V v3 = map.get(Long.valueOf(j4));
            this.f33298a.writeTag(i4, 2);
            this.f33298a.writeUInt32NoTag(MapEntryLite.a(metadata, Long.valueOf(j4), v3));
            MapEntryLite.e(this.f33298a, metadata, Long.valueOf(j4), v3);
        }
    }

    private <K, V> void j(int i4, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        switch (AnonymousClass1.f33299a[metadata.f33469a.ordinal()]) {
            case 1:
                V v3 = map.get(Boolean.FALSE);
                if (v3 != null) {
                    g(i4, false, v3, metadata);
                }
                V v4 = map.get(Boolean.TRUE);
                if (v4 != null) {
                    g(i4, true, v4, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                h(i4, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                i(i4, metadata, map);
                return;
            case 12:
                k(i4, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.f33469a);
        }
    }

    private <V> void k(int i4, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        int i5 = 0;
        for (String str : map.keySet()) {
            strArr[i5] = str;
            i5++;
        }
        Arrays.sort(strArr);
        for (int i6 = 0; i6 < size; i6++) {
            String str2 = strArr[i6];
            V v3 = map.get(str2);
            this.f33298a.writeTag(i4, 2);
            this.f33298a.writeUInt32NoTag(MapEntryLite.a(metadata, str2, v3));
            MapEntryLite.e(this.f33298a, metadata, str2, v3);
        }
    }

    private void l(int i4, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f33298a.writeString(i4, (String) obj);
        } else {
            this.f33298a.writeBytes(i4, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void a(int i4, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException {
        if (this.f33298a.n()) {
            j(i4, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f33298a.writeTag(i4, 2);
            this.f33298a.writeUInt32NoTag(MapEntryLite.a(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.e(this.f33298a, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void b(int i4, List<?> list, Schema schema) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            e(i4, list.get(i5), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void c(int i4, Object obj, Schema schema) throws IOException {
        this.f33298a.r(i4, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void d(int i4, List<?> list, Schema schema) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            c(i4, list.get(i5), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void e(int i4, Object obj, Schema schema) throws IOException {
        this.f33298a.t(i4, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int i4, boolean z3) throws IOException {
        this.f33298a.writeBool(i4, z3);
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int i4, List<Boolean> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeBoolSizeNoTag(list.get(i7).booleanValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeBoolNoTag(list.get(i5).booleanValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeBool(i4, list.get(i5).booleanValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int i4, ByteString byteString) throws IOException {
        this.f33298a.writeBytes(i4, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int i4, List<ByteString> list) throws IOException {
        for (int i5 = 0; i5 < list.size(); i5++) {
            this.f33298a.writeBytes(i4, list.get(i5));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int i4, double d4) throws IOException {
        this.f33298a.writeDouble(i4, d4);
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int i4, List<Double> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i7).doubleValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeDoubleNoTag(list.get(i5).doubleValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeDouble(i4, list.get(i5).doubleValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int i4) throws IOException {
        this.f33298a.writeTag(i4, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int i4, int i5) throws IOException {
        this.f33298a.writeEnum(i4, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeEnumSizeNoTag(list.get(i7).intValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeEnumNoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeEnum(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int i4, int i5) throws IOException {
        this.f33298a.writeFixed32(i4, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i7).intValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeFixed32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeFixed32(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int i4, long j4) throws IOException {
        this.f33298a.writeFixed64(i4, j4);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i7).longValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeFixed64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeFixed64(i4, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int i4, float f4) throws IOException {
        this.f33298a.writeFloat(i4, f4);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int i4, List<Float> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeFloatSizeNoTag(list.get(i7).floatValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeFloatNoTag(list.get(i5).floatValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeFloat(i4, list.get(i5).floatValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int i4, int i5) throws IOException {
        this.f33298a.writeInt32(i4, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeInt32SizeNoTag(list.get(i7).intValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeInt32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeInt32(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int i4, long j4) throws IOException {
        this.f33298a.writeInt64(i4, j4);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeInt64SizeNoTag(list.get(i7).longValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeInt64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeInt64(i4, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i4, Object obj) throws IOException {
        this.f33298a.writeMessage(i4, (MessageLite) obj);
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int i4, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f33298a.writeRawMessageSetExtension(i4, (ByteString) obj);
        } else {
            this.f33298a.writeMessageSetExtension(i4, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int i4, int i5) throws IOException {
        this.f33298a.writeSFixed32(i4, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i7).intValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeSFixed32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeSFixed32(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int i4, long j4) throws IOException {
        this.f33298a.writeSFixed64(i4, j4);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i7).longValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeSFixed64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeSFixed64(i4, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int i4, int i5) throws IOException {
        this.f33298a.writeSInt32(i4, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i7).intValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeSInt32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeSInt32(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int i4, long j4) throws IOException {
        this.f33298a.writeSInt64(i4, j4);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i7).longValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeSInt64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeSInt64(i4, list.get(i5).longValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int i4) throws IOException {
        this.f33298a.writeTag(i4, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int i4, String str) throws IOException {
        this.f33298a.writeString(i4, str);
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int i4, List<String> list) throws IOException {
        int i5 = 0;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i5 < list.size()) {
                l(i4, lazyStringList.getRaw(i5));
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeString(i4, list.get(i5));
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int i4, int i5) throws IOException {
        this.f33298a.writeUInt32(i4, i5);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int i4, List<Integer> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i7).intValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeUInt32NoTag(list.get(i5).intValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeUInt32(i4, list.get(i5).intValue());
            i5++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int i4, long j4) throws IOException {
        this.f33298a.writeUInt64(i4, j4);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int i4, List<Long> list, boolean z3) throws IOException {
        int i5 = 0;
        if (z3) {
            this.f33298a.writeTag(i4, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i7).longValue());
            }
            this.f33298a.writeUInt32NoTag(i6);
            while (i5 < list.size()) {
                this.f33298a.writeUInt64NoTag(list.get(i5).longValue());
                i5++;
            }
            return;
        }
        while (i5 < list.size()) {
            this.f33298a.writeUInt64(i4, list.get(i5).longValue());
            i5++;
        }
    }
}
