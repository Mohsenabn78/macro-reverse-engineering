package com.android.dex;

import com.android.dex.ClassData;
import com.android.dex.Code;
import com.android.dex.util.ByteInput;
import com.android.dex.util.ByteOutput;
import com.android.dex.util.FileUtils;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UTFDataFormatException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.UShort;

/* loaded from: classes2.dex */
public final class Dex {
    private static final int CHECKSUM_OFFSET = 8;
    private static final int CHECKSUM_SIZE = 4;
    static final short[] EMPTY_SHORT_ARRAY = new short[0];
    private static final int SIGNATURE_OFFSET = 12;
    private static final int SIGNATURE_SIZE = 20;
    private ByteBuffer data;
    private final FieldIdTable fieldIds;
    private final MethodIdTable methodIds;
    private int nextSectionStart;
    private final ProtoIdTable protoIds;
    private final StringTable strings;
    private final TableOfContents tableOfContents;
    private final TypeIndexToDescriptorIndexTable typeIds;
    private final TypeIndexToDescriptorTable typeNames;

    /* loaded from: classes2.dex */
    private final class ClassDefIterable implements Iterable<ClassDef> {
        private ClassDefIterable() {
        }

        @Override // java.lang.Iterable
        public Iterator<ClassDef> iterator() {
            if (!Dex.this.tableOfContents.classDefs.exists()) {
                return Collections.emptySet().iterator();
            }
            return new ClassDefIterator();
        }
    }

    /* loaded from: classes2.dex */
    private final class ClassDefIterator implements Iterator<ClassDef> {
        private int count;
        private final Section in;

        private ClassDefIterator() {
            this.in = Dex.this.open(Dex.this.tableOfContents.classDefs.off);
            this.count = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.count < Dex.this.tableOfContents.classDefs.size) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ClassDef next() {
            if (hasNext()) {
                this.count++;
                return this.in.readClassDef();
            }
            throw new NoSuchElementException();
        }
    }

    /* loaded from: classes2.dex */
    private final class FieldIdTable extends AbstractList<FieldId> implements RandomAccess {
        private FieldIdTable() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.fieldIds.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public FieldId get(int i4) {
            Dex.checkBounds(i4, Dex.this.tableOfContents.fieldIds.size);
            Dex dex = Dex.this;
            return dex.open(dex.tableOfContents.fieldIds.off + (i4 * 8)).readFieldId();
        }
    }

    /* loaded from: classes2.dex */
    private final class MethodIdTable extends AbstractList<MethodId> implements RandomAccess {
        private MethodIdTable() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.methodIds.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public MethodId get(int i4) {
            Dex.checkBounds(i4, Dex.this.tableOfContents.methodIds.size);
            Dex dex = Dex.this;
            return dex.open(dex.tableOfContents.methodIds.off + (i4 * 8)).readMethodId();
        }
    }

    /* loaded from: classes2.dex */
    private final class ProtoIdTable extends AbstractList<ProtoId> implements RandomAccess {
        private ProtoIdTable() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.protoIds.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public ProtoId get(int i4) {
            Dex.checkBounds(i4, Dex.this.tableOfContents.protoIds.size);
            Dex dex = Dex.this;
            return dex.open(dex.tableOfContents.protoIds.off + (i4 * 12)).readProtoId();
        }
    }

    /* loaded from: classes2.dex */
    public final class Section implements ByteInput, ByteOutput {
        private final ByteBuffer data;
        private final int initialPosition;
        private final String name;

        private int findCatchHandlerIndex(Code.CatchHandler[] catchHandlerArr, int i4) {
            for (int i5 = 0; i5 < catchHandlerArr.length; i5++) {
                if (catchHandlerArr[i5].getOffset() == i4) {
                    return i5;
                }
            }
            throw new IllegalArgumentException();
        }

        private byte[] getBytesFrom(int i4) {
            byte[] bArr = new byte[this.data.position() - i4];
            this.data.position(i4);
            this.data.get(bArr);
            return bArr;
        }

        private Code.CatchHandler readCatchHandler(int i4) {
            int i5;
            int readSleb128 = readSleb128();
            int abs = Math.abs(readSleb128);
            int[] iArr = new int[abs];
            int[] iArr2 = new int[abs];
            for (int i6 = 0; i6 < abs; i6++) {
                iArr[i6] = readUleb128();
                iArr2[i6] = readUleb128();
            }
            if (readSleb128 <= 0) {
                i5 = readUleb128();
            } else {
                i5 = -1;
            }
            return new Code.CatchHandler(iArr, iArr2, i5, i4);
        }

        private Code.CatchHandler[] readCatchHandlers() {
            int position = this.data.position();
            int readUleb128 = readUleb128();
            Code.CatchHandler[] catchHandlerArr = new Code.CatchHandler[readUleb128];
            for (int i4 = 0; i4 < readUleb128; i4++) {
                catchHandlerArr[i4] = readCatchHandler(this.data.position() - position);
            }
            return catchHandlerArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ClassData readClassData() {
            return new ClassData(readFields(readUleb128()), readFields(readUleb128()), readMethods(readUleb128()), readMethods(readUleb128()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Code readCode() {
            Code.Try[] tryArr;
            Code.CatchHandler[] catchHandlerArr;
            int readUnsignedShort = readUnsignedShort();
            int readUnsignedShort2 = readUnsignedShort();
            int readUnsignedShort3 = readUnsignedShort();
            int readUnsignedShort4 = readUnsignedShort();
            int readInt = readInt();
            short[] readShortArray = readShortArray(readInt());
            if (readUnsignedShort4 > 0) {
                if (readShortArray.length % 2 == 1) {
                    readShort();
                }
                Section open = Dex.this.open(this.data.position());
                skip(readUnsignedShort4 * 8);
                catchHandlerArr = readCatchHandlers();
                tryArr = open.readTries(readUnsignedShort4, catchHandlerArr);
            } else {
                tryArr = new Code.Try[0];
                catchHandlerArr = new Code.CatchHandler[0];
            }
            return new Code(readUnsignedShort, readUnsignedShort2, readUnsignedShort3, readInt, readShortArray, tryArr, catchHandlerArr);
        }

        private ClassData.Field[] readFields(int i4) {
            ClassData.Field[] fieldArr = new ClassData.Field[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                i5 += readUleb128();
                fieldArr[i6] = new ClassData.Field(i5, readUleb128());
            }
            return fieldArr;
        }

        private ClassData.Method[] readMethods(int i4) {
            ClassData.Method[] methodArr = new ClassData.Method[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                i5 += readUleb128();
                methodArr[i6] = new ClassData.Method(i5, readUleb128(), readUleb128());
            }
            return methodArr;
        }

        private Code.Try[] readTries(int i4, Code.CatchHandler[] catchHandlerArr) {
            Code.Try[] tryArr = new Code.Try[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                tryArr[i5] = new Code.Try(readInt(), readUnsignedShort(), findCatchHandlerIndex(catchHandlerArr, readUnsignedShort()));
            }
            return tryArr;
        }

        public void alignToFourBytes() {
            ByteBuffer byteBuffer = this.data;
            byteBuffer.position((byteBuffer.position() + 3) & (-4));
        }

        public void alignToFourBytesWithZeroFill() {
            while ((this.data.position() & 3) != 0) {
                this.data.put((byte) 0);
            }
        }

        public void assertFourByteAligned() {
            if ((this.data.position() & 3) == 0) {
                return;
            }
            throw new IllegalStateException("Not four byte aligned!");
        }

        public int getPosition() {
            return this.data.position();
        }

        public Annotation readAnnotation() {
            byte readByte = readByte();
            int position = this.data.position();
            new EncodedValueReader(this, 29).skipValue();
            return new Annotation(Dex.this, readByte, new EncodedValue(getBytesFrom(position)));
        }

        @Override // com.android.dex.util.ByteInput
        public byte readByte() {
            return this.data.get();
        }

        public byte[] readByteArray(int i4) {
            byte[] bArr = new byte[i4];
            this.data.get(bArr);
            return bArr;
        }

        public ClassDef readClassDef() {
            return new ClassDef(Dex.this, getPosition(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt(), readInt());
        }

        public EncodedValue readEncodedArray() {
            int position = this.data.position();
            new EncodedValueReader(this, 28).skipValue();
            return new EncodedValue(getBytesFrom(position));
        }

        public FieldId readFieldId() {
            return new FieldId(Dex.this, readUnsignedShort(), readUnsignedShort(), readInt());
        }

        public int readInt() {
            return this.data.getInt();
        }

        public MethodId readMethodId() {
            return new MethodId(Dex.this, readUnsignedShort(), readUnsignedShort(), readInt());
        }

        public ProtoId readProtoId() {
            return new ProtoId(Dex.this, readInt(), readInt(), readInt());
        }

        public short readShort() {
            return this.data.getShort();
        }

        public short[] readShortArray(int i4) {
            if (i4 == 0) {
                return Dex.EMPTY_SHORT_ARRAY;
            }
            short[] sArr = new short[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                sArr[i5] = readShort();
            }
            return sArr;
        }

        public int readSleb128() {
            return Leb128.readSignedLeb128(this);
        }

        public String readString() {
            int readInt = readInt();
            int position = this.data.position();
            int limit = this.data.limit();
            this.data.position(readInt);
            ByteBuffer byteBuffer = this.data;
            byteBuffer.limit(byteBuffer.capacity());
            try {
                try {
                    int readUleb128 = readUleb128();
                    String decode = Mutf8.decode(this, new char[readUleb128]);
                    if (decode.length() == readUleb128) {
                        return decode;
                    }
                    throw new DexException("Declared length " + readUleb128 + " doesn't match decoded length of " + decode.length());
                } catch (UTFDataFormatException e4) {
                    throw new DexException(e4);
                }
            } finally {
                this.data.position(position);
                this.data.limit(limit);
            }
        }

        public TypeList readTypeList() {
            short[] readShortArray = readShortArray(readInt());
            alignToFourBytes();
            return new TypeList(Dex.this, readShortArray);
        }

        public int readUleb128() {
            return Leb128.readUnsignedLeb128(this);
        }

        public int readUleb128p1() {
            return Leb128.readUnsignedLeb128(this) - 1;
        }

        public int readUnsignedShort() {
            return readShort() & UShort.MAX_VALUE;
        }

        public int remaining() {
            return this.data.remaining();
        }

        public void skip(int i4) {
            if (i4 >= 0) {
                ByteBuffer byteBuffer = this.data;
                byteBuffer.position(byteBuffer.position() + i4);
                return;
            }
            throw new IllegalArgumentException();
        }

        public int used() {
            return this.data.position() - this.initialPosition;
        }

        public void write(byte[] bArr) {
            this.data.put(bArr);
        }

        @Override // com.android.dex.util.ByteOutput
        public void writeByte(int i4) {
            this.data.put((byte) i4);
        }

        public void writeInt(int i4) {
            this.data.putInt(i4);
        }

        public void writeShort(short s3) {
            this.data.putShort(s3);
        }

        public void writeSleb128(int i4) {
            try {
                Leb128.writeSignedLeb128(this, i4);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new DexException("Section limit " + this.data.limit() + " exceeded by " + this.name);
            }
        }

        public void writeStringData(String str) {
            try {
                writeUleb128(str.length());
                write(Mutf8.encode(str));
                writeByte(0);
            } catch (UTFDataFormatException unused) {
                throw new AssertionError();
            }
        }

        public void writeTypeList(TypeList typeList) {
            short[] types = typeList.getTypes();
            writeInt(types.length);
            for (short s3 : types) {
                writeShort(s3);
            }
            alignToFourBytesWithZeroFill();
        }

        public void writeUleb128(int i4) {
            try {
                Leb128.writeUnsignedLeb128(this, i4);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new DexException("Section limit " + this.data.limit() + " exceeded by " + this.name);
            }
        }

        public void writeUleb128p1(int i4) {
            writeUleb128(i4 + 1);
        }

        public void writeUnsignedShort(int i4) {
            short s3 = (short) i4;
            if (i4 == (65535 & s3)) {
                writeShort(s3);
                return;
            }
            throw new IllegalArgumentException("Expected an unsigned short: " + i4);
        }

        private Section(String str, ByteBuffer byteBuffer) {
            this.name = str;
            this.data = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        public void write(short[] sArr) {
            for (short s3 : sArr) {
                writeShort(s3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class StringTable extends AbstractList<String> implements RandomAccess {
        private StringTable() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.stringIds.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public String get(int i4) {
            Dex.checkBounds(i4, Dex.this.tableOfContents.stringIds.size);
            Dex dex = Dex.this;
            return dex.open(dex.tableOfContents.stringIds.off + (i4 * 4)).readString();
        }
    }

    /* loaded from: classes2.dex */
    private final class TypeIndexToDescriptorIndexTable extends AbstractList<Integer> implements RandomAccess {
        private TypeIndexToDescriptorIndexTable() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.typeIds.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int i4) {
            return Integer.valueOf(Dex.this.descriptorIndexFromTypeIndex(i4));
        }
    }

    /* loaded from: classes2.dex */
    private final class TypeIndexToDescriptorTable extends AbstractList<String> implements RandomAccess {
        private TypeIndexToDescriptorTable() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return Dex.this.tableOfContents.typeIds.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public String get(int i4) {
            return Dex.this.strings.get(Dex.this.descriptorIndexFromTypeIndex(i4));
        }
    }

    public Dex(byte[] bArr) throws IOException {
        this(ByteBuffer.wrap(bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkBounds(int i4, int i5) {
        if (i4 >= 0 && i4 < i5) {
            return;
        }
        throw new IndexOutOfBoundsException("index:" + i4 + ", length=" + i5);
    }

    public static Dex create(ByteBuffer byteBuffer) throws IOException {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        if (byteBuffer.get(0) == 100 && byteBuffer.get(1) == 101 && byteBuffer.get(2) == 121 && byteBuffer.get(3) == 10) {
            byteBuffer.position(8);
            int i4 = byteBuffer.getInt();
            int i5 = byteBuffer.getInt();
            byteBuffer.position(i4);
            byteBuffer.limit(i4 + i5);
            byteBuffer = byteBuffer.slice();
        }
        return new Dex(byteBuffer);
    }

    private void loadFrom(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                ByteBuffer wrap = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
                this.data = wrap;
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                this.tableOfContents.readFrom(this);
                return;
            }
        }
    }

    public int annotationDirectoryOffsetFromClassDefIndex(int i4) {
        checkBounds(i4, this.tableOfContents.classDefs.size);
        return this.data.getInt(this.tableOfContents.classDefs.off + (i4 * 32) + 4 + 4 + 4 + 4 + 4);
    }

    public Section appendSection(int i4, String str) {
        if ((i4 & 3) == 0) {
            int i5 = this.nextSectionStart + i4;
            ByteBuffer duplicate = this.data.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            duplicate.position(this.nextSectionStart);
            duplicate.limit(i5);
            Section section = new Section(str, duplicate);
            this.nextSectionStart = i5;
            return section;
        }
        throw new IllegalStateException("Not four byte aligned!");
    }

    public Iterable<ClassDef> classDefs() {
        return new ClassDefIterable();
    }

    public int computeChecksum() throws IOException {
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.data.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        return (int) adler32.getValue();
    }

    public byte[] computeSignature() throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
            byte[] bArr = new byte[8192];
            ByteBuffer duplicate = this.data.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(8192, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                messageDigest.update(bArr, 0, min);
            }
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public int declaringClassIndexFromMethodIndex(int i4) {
        checkBounds(i4, this.tableOfContents.methodIds.size);
        return this.data.getShort(this.tableOfContents.methodIds.off + (i4 * 8)) & UShort.MAX_VALUE;
    }

    public int descriptorIndexFromTypeIndex(int i4) {
        checkBounds(i4, this.tableOfContents.typeIds.size);
        return this.data.getInt(this.tableOfContents.typeIds.off + (i4 * 4));
    }

    public List<FieldId> fieldIds() {
        return this.fieldIds;
    }

    public int findClassDefIndexFromTypeIndex(int i4) {
        checkBounds(i4, this.tableOfContents.typeIds.size);
        if (!this.tableOfContents.classDefs.exists()) {
            return -1;
        }
        for (int i5 = 0; i5 < this.tableOfContents.classDefs.size; i5++) {
            if (typeIndexFromClassDefIndex(i5) == i4) {
                return i5;
            }
        }
        return -1;
    }

    public int findFieldIndex(FieldId fieldId) {
        return Collections.binarySearch(this.fieldIds, fieldId);
    }

    public int findMethodIndex(MethodId methodId) {
        return Collections.binarySearch(this.methodIds, methodId);
    }

    public int findStringIndex(String str) {
        return Collections.binarySearch(this.strings, str);
    }

    public int findTypeIndex(String str) {
        return Collections.binarySearch(this.typeNames, str);
    }

    public byte[] getBytes() {
        ByteBuffer duplicate = this.data.duplicate();
        byte[] bArr = new byte[duplicate.capacity()];
        duplicate.position(0);
        duplicate.get(bArr);
        return bArr;
    }

    public int getLength() {
        return this.data.capacity();
    }

    public int getNextSectionStart() {
        return this.nextSectionStart;
    }

    public TableOfContents getTableOfContents() {
        return this.tableOfContents;
    }

    public short[] interfaceTypeIndicesFromClassDefIndex(int i4) {
        checkBounds(i4, this.tableOfContents.classDefs.size);
        int i5 = this.data.getInt(this.tableOfContents.classDefs.off + (i4 * 32) + 4 + 4 + 4);
        if (i5 == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        int i6 = this.data.getInt(i5);
        if (i6 > 0) {
            int i7 = i5 + 4;
            short[] sArr = new short[i6];
            for (int i8 = 0; i8 < i6; i8++) {
                sArr[i8] = this.data.getShort(i7);
                i7 += 2;
            }
            return sArr;
        }
        throw new AssertionError("Unexpected interfaces list size: " + i6);
    }

    public List<MethodId> methodIds() {
        return this.methodIds;
    }

    public int nameIndexFromFieldIndex(int i4) {
        checkBounds(i4, this.tableOfContents.fieldIds.size);
        return this.data.getInt(this.tableOfContents.fieldIds.off + (i4 * 8) + 2 + 2);
    }

    public int nameIndexFromMethodIndex(int i4) {
        checkBounds(i4, this.tableOfContents.methodIds.size);
        return this.data.getInt(this.tableOfContents.methodIds.off + (i4 * 8) + 2 + 2);
    }

    public Section open(int i4) {
        if (i4 >= 0 && i4 < this.data.capacity()) {
            ByteBuffer duplicate = this.data.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            duplicate.position(i4);
            duplicate.limit(this.data.capacity());
            return new Section("section", duplicate);
        }
        throw new IllegalArgumentException("position=" + i4 + " length=" + this.data.capacity());
    }

    public short[] parameterTypeIndicesFromMethodIndex(int i4) {
        checkBounds(i4, this.tableOfContents.methodIds.size);
        int i5 = this.data.getShort(this.tableOfContents.methodIds.off + (i4 * 8) + 2) & UShort.MAX_VALUE;
        checkBounds(i5, this.tableOfContents.protoIds.size);
        int i6 = this.data.getInt(this.tableOfContents.protoIds.off + (i5 * 12) + 4 + 4);
        if (i6 == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        int i7 = this.data.getInt(i6);
        if (i7 > 0) {
            int i8 = i6 + 4;
            short[] sArr = new short[i7];
            for (int i9 = 0; i9 < i7; i9++) {
                sArr[i9] = this.data.getShort(i8);
                i8 += 2;
            }
            return sArr;
        }
        throw new AssertionError("Unexpected parameter type list size: " + i7);
    }

    public List<ProtoId> protoIds() {
        return this.protoIds;
    }

    public ClassData readClassData(ClassDef classDef) {
        int classDataOffset = classDef.getClassDataOffset();
        if (classDataOffset != 0) {
            return open(classDataOffset).readClassData();
        }
        throw new IllegalArgumentException("offset == 0");
    }

    public Code readCode(ClassData.Method method) {
        int codeOffset = method.getCodeOffset();
        if (codeOffset != 0) {
            return open(codeOffset).readCode();
        }
        throw new IllegalArgumentException("offset == 0");
    }

    public TypeList readTypeList(int i4) {
        if (i4 == 0) {
            return TypeList.EMPTY;
        }
        return open(i4).readTypeList();
    }

    public int returnTypeIndexFromMethodIndex(int i4) {
        checkBounds(i4, this.tableOfContents.methodIds.size);
        int i5 = this.data.getShort(this.tableOfContents.methodIds.off + (i4 * 8) + 2) & UShort.MAX_VALUE;
        checkBounds(i5, this.tableOfContents.protoIds.size);
        return this.data.getInt(this.tableOfContents.protoIds.off + (i5 * 12) + 4);
    }

    public List<String> strings() {
        return this.strings;
    }

    public List<Integer> typeIds() {
        return this.typeIds;
    }

    public int typeIndexFromClassDefIndex(int i4) {
        checkBounds(i4, this.tableOfContents.classDefs.size);
        return this.data.getInt(this.tableOfContents.classDefs.off + (i4 * 32));
    }

    public int typeIndexFromFieldIndex(int i4) {
        checkBounds(i4, this.tableOfContents.fieldIds.size);
        return this.data.getShort(this.tableOfContents.fieldIds.off + (i4 * 8) + 2) & UShort.MAX_VALUE;
    }

    public List<String> typeNames() {
        return this.typeNames;
    }

    public void writeHashes() throws IOException {
        open(12).write(computeSignature());
        open(8).writeInt(computeChecksum());
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.data.duplicate();
        duplicate.clear();
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            outputStream.write(bArr, 0, min);
        }
    }

    private Dex(ByteBuffer byteBuffer) throws IOException {
        TableOfContents tableOfContents = new TableOfContents();
        this.tableOfContents = tableOfContents;
        this.nextSectionStart = 0;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        this.data = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        tableOfContents.readFrom(this);
    }

    public void writeTo(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        writeTo(fileOutputStream);
        fileOutputStream.close();
    }

    public Dex(int i4) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.nextSectionStart = 0;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[i4]);
        this.data = wrap;
        wrap.order(ByteOrder.LITTLE_ENDIAN);
    }

    public Dex(InputStream inputStream) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.nextSectionStart = 0;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        loadFrom(inputStream);
    }

    public Dex(File file) throws IOException {
        this.tableOfContents = new TableOfContents();
        this.nextSectionStart = 0;
        this.strings = new StringTable();
        this.typeIds = new TypeIndexToDescriptorIndexTable();
        this.typeNames = new TypeIndexToDescriptorTable();
        this.protoIds = new ProtoIdTable();
        this.fieldIds = new FieldIdTable();
        this.methodIds = new MethodIdTable();
        if (FileUtils.hasArchiveSuffix(file.getName())) {
            ZipFile zipFile = new ZipFile(file);
            ZipEntry entry = zipFile.getEntry(DexFormat.DEX_IN_JAR_NAME);
            if (entry != null) {
                loadFrom(zipFile.getInputStream(entry));
                zipFile.close();
                return;
            }
            throw new DexException("Expected classes.dex in " + file);
        } else if (file.getName().endsWith(".dex")) {
            loadFrom(new FileInputStream(file));
        } else {
            throw new DexException("unknown output extension: " + file);
        }
    }
}
