package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes6.dex */
interface Writer {

    /* loaded from: classes6.dex */
    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    <K, V> void a(int i4, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) throws IOException;

    void b(int i4, List<?> list, Schema schema) throws IOException;

    @Deprecated
    void c(int i4, Object obj, Schema schema) throws IOException;

    @Deprecated
    void d(int i4, List<?> list, Schema schema) throws IOException;

    void e(int i4, Object obj, Schema schema) throws IOException;

    FieldOrder fieldOrder();

    void writeBool(int i4, boolean z3) throws IOException;

    void writeBoolList(int i4, List<Boolean> list, boolean z3) throws IOException;

    void writeBytes(int i4, ByteString byteString) throws IOException;

    void writeBytesList(int i4, List<ByteString> list) throws IOException;

    void writeDouble(int i4, double d4) throws IOException;

    void writeDoubleList(int i4, List<Double> list, boolean z3) throws IOException;

    @Deprecated
    void writeEndGroup(int i4) throws IOException;

    void writeEnum(int i4, int i5) throws IOException;

    void writeEnumList(int i4, List<Integer> list, boolean z3) throws IOException;

    void writeFixed32(int i4, int i5) throws IOException;

    void writeFixed32List(int i4, List<Integer> list, boolean z3) throws IOException;

    void writeFixed64(int i4, long j4) throws IOException;

    void writeFixed64List(int i4, List<Long> list, boolean z3) throws IOException;

    void writeFloat(int i4, float f4) throws IOException;

    void writeFloatList(int i4, List<Float> list, boolean z3) throws IOException;

    void writeInt32(int i4, int i5) throws IOException;

    void writeInt32List(int i4, List<Integer> list, boolean z3) throws IOException;

    void writeInt64(int i4, long j4) throws IOException;

    void writeInt64List(int i4, List<Long> list, boolean z3) throws IOException;

    void writeMessage(int i4, Object obj) throws IOException;

    void writeMessageSetItem(int i4, Object obj) throws IOException;

    void writeSFixed32(int i4, int i5) throws IOException;

    void writeSFixed32List(int i4, List<Integer> list, boolean z3) throws IOException;

    void writeSFixed64(int i4, long j4) throws IOException;

    void writeSFixed64List(int i4, List<Long> list, boolean z3) throws IOException;

    void writeSInt32(int i4, int i5) throws IOException;

    void writeSInt32List(int i4, List<Integer> list, boolean z3) throws IOException;

    void writeSInt64(int i4, long j4) throws IOException;

    void writeSInt64List(int i4, List<Long> list, boolean z3) throws IOException;

    @Deprecated
    void writeStartGroup(int i4) throws IOException;

    void writeString(int i4, String str) throws IOException;

    void writeStringList(int i4, List<String> list) throws IOException;

    void writeUInt32(int i4, int i5) throws IOException;

    void writeUInt32List(int i4, List<Integer> list, boolean z3) throws IOException;

    void writeUInt64(int i4, long j4) throws IOException;

    void writeUInt64List(int i4, List<Long> list, boolean z3) throws IOException;
}
