package com.google.protobuf;

import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class MapEntryLite<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Metadata<K, V> f33465a;

    /* renamed from: b  reason: collision with root package name */
    private final K f33466b;

    /* renamed from: c  reason: collision with root package name */
    private final V f33467c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.MapEntryLite$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33468a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f33468a = iArr;
            try {
                iArr[WireFormat.FieldType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33468a[WireFormat.FieldType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33468a[WireFormat.FieldType.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Metadata<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final WireFormat.FieldType f33469a;

        /* renamed from: b  reason: collision with root package name */
        public final K f33470b;

        /* renamed from: c  reason: collision with root package name */
        public final WireFormat.FieldType f33471c;

        /* renamed from: d  reason: collision with root package name */
        public final V f33472d;

        public Metadata(WireFormat.FieldType fieldType, K k4, WireFormat.FieldType fieldType2, V v3) {
            this.f33469a = fieldType;
            this.f33470b = k4;
            this.f33471c = fieldType2;
            this.f33472d = v3;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k4, WireFormat.FieldType fieldType2, V v3) {
        this.f33465a = new Metadata<>(fieldType, k4, fieldType2, v3);
        this.f33466b = k4;
        this.f33467c = v3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(Metadata<K, V> metadata, K k4, V v3) {
        return FieldSet.e(metadata.f33469a, 1, k4) + FieldSet.e(metadata.f33471c, 2, v3);
    }

    static <K, V> Map.Entry<K, V> c(CodedInputStream codedInputStream, Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Object obj = metadata.f33470b;
        Object obj2 = metadata.f33472d;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.a(1, metadata.f33469a.getWireType())) {
                obj = d(codedInputStream, extensionRegistryLite, metadata.f33469a, obj);
            } else if (readTag == WireFormat.a(2, metadata.f33471c.getWireType())) {
                obj2 = d(codedInputStream, extensionRegistryLite, metadata.f33471c, obj2);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    static <T> T d(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t3) throws IOException {
        int i4 = AnonymousClass1.f33468a[fieldType.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return (T) FieldSet.C(codedInputStream, fieldType, true);
                }
                throw new RuntimeException("Groups are not allowed in maps.");
            }
            return (T) Integer.valueOf(codedInputStream.readEnum());
        }
        MessageLite.Builder builder = ((MessageLite) t3).toBuilder();
        codedInputStream.readMessage(builder, extensionRegistryLite);
        return (T) builder.buildPartial();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void e(CodedOutputStream codedOutputStream, Metadata<K, V> metadata, K k4, V v3) throws IOException {
        FieldSet.G(codedOutputStream, metadata.f33469a, 1, k4);
        FieldSet.G(codedOutputStream, metadata.f33471c, 2, v3);
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K k4, WireFormat.FieldType fieldType2, V v3) {
        return new MapEntryLite<>(fieldType, k4, fieldType2, v3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata<K, V> b() {
        return this.f33465a;
    }

    public int computeMessageSize(int i4, K k4, V v3) {
        return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.i(a(this.f33465a, k4, v3));
    }

    public K getKey() {
        return this.f33466b;
    }

    public V getValue() {
        return this.f33467c;
    }

    public Map.Entry<K, V> parseEntry(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return c(byteString.newCodedInput(), this.f33465a, extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void parseInto(MapFieldLite<K, V> mapFieldLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
        Metadata<K, V> metadata = this.f33465a;
        Object obj = metadata.f33470b;
        Object obj2 = metadata.f33472d;
        while (true) {
            int readTag = codedInputStream.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == WireFormat.a(1, this.f33465a.f33469a.getWireType())) {
                obj = d(codedInputStream, extensionRegistryLite, this.f33465a.f33469a, obj);
            } else if (readTag == WireFormat.a(2, this.f33465a.f33471c.getWireType())) {
                obj2 = d(codedInputStream, extensionRegistryLite, this.f33465a.f33471c, obj2);
            } else if (!codedInputStream.skipField(readTag)) {
                break;
            }
        }
        codedInputStream.checkLastTagWas(0);
        codedInputStream.popLimit(pushLimit);
        mapFieldLite.put(obj, obj2);
    }

    public void serializeTo(CodedOutputStream codedOutputStream, int i4, K k4, V v3) throws IOException {
        codedOutputStream.writeTag(i4, 2);
        codedOutputStream.writeUInt32NoTag(a(this.f33465a, k4, v3));
        e(codedOutputStream, this.f33465a, k4, v3);
    }
}
