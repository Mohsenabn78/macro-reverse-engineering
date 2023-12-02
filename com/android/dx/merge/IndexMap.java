package com.android.dx.merge;

import com.android.dex.Annotation;
import com.android.dex.ClassDef;
import com.android.dex.Dex;
import com.android.dex.DexException;
import com.android.dex.EncodedValue;
import com.android.dex.EncodedValueCodec;
import com.android.dex.EncodedValueReader;
import com.android.dex.FieldId;
import com.android.dex.Leb128;
import com.android.dex.MethodId;
import com.android.dex.ProtoId;
import com.android.dex.TableOfContents;
import com.android.dex.TypeList;
import com.android.dex.util.ByteOutput;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import java.util.HashMap;
import kotlin.UShort;

/* loaded from: classes2.dex */
public final class IndexMap {
    private final HashMap<Integer, Integer> annotationDirectoryOffsets;
    private final HashMap<Integer, Integer> annotationOffsets;
    private final HashMap<Integer, Integer> annotationSetOffsets;
    private final HashMap<Integer, Integer> annotationSetRefListOffsets;
    public final short[] fieldIds;
    public final short[] methodIds;
    public final short[] protoIds;
    private final HashMap<Integer, Integer> staticValuesOffsets;
    public final int[] stringIds;
    private final Dex target;
    public final short[] typeIds;
    private final HashMap<Integer, Integer> typeListOffsets;

    /* loaded from: classes2.dex */
    private final class EncodedValueTransformer {
        private final ByteOutput out;

        public EncodedValueTransformer(ByteOutput byteOutput) {
            this.out = byteOutput;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformAnnotation(EncodedValueReader encodedValueReader) {
            int readAnnotation = encodedValueReader.readAnnotation();
            Leb128.writeUnsignedLeb128(this.out, IndexMap.this.adjustType(encodedValueReader.getAnnotationType()));
            Leb128.writeUnsignedLeb128(this.out, readAnnotation);
            for (int i4 = 0; i4 < readAnnotation; i4++) {
                Leb128.writeUnsignedLeb128(this.out, IndexMap.this.adjustString(encodedValueReader.readAnnotationName()));
                transform(encodedValueReader);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void transformArray(EncodedValueReader encodedValueReader) {
            int readArray = encodedValueReader.readArray();
            Leb128.writeUnsignedLeb128(this.out, readArray);
            for (int i4 = 0; i4 < readArray; i4++) {
                transform(encodedValueReader);
            }
        }

        private void writeTypeAndArg(int i4, int i5) {
            this.out.writeByte(i4 | (i5 << 5));
        }

        public void transform(EncodedValueReader encodedValueReader) {
            int peek = encodedValueReader.peek();
            if (peek != 0) {
                if (peek != 6) {
                    if (peek != 2) {
                        if (peek != 3) {
                            if (peek != 4) {
                                if (peek != 16) {
                                    if (peek != 17) {
                                        switch (peek) {
                                            case 23:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 23, IndexMap.this.adjustString(encodedValueReader.readString()));
                                                return;
                                            case 24:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 24, IndexMap.this.adjustType(encodedValueReader.readType()));
                                                return;
                                            case 25:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 25, IndexMap.this.adjustField(encodedValueReader.readField()));
                                                return;
                                            case 26:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 26, IndexMap.this.adjustMethod(encodedValueReader.readMethod()));
                                                return;
                                            case 27:
                                                EncodedValueCodec.writeUnsignedIntegralValue(this.out, 27, IndexMap.this.adjustField(encodedValueReader.readEnum()));
                                                return;
                                            case 28:
                                                writeTypeAndArg(28, 0);
                                                transformArray(encodedValueReader);
                                                return;
                                            case 29:
                                                writeTypeAndArg(29, 0);
                                                transformAnnotation(encodedValueReader);
                                                return;
                                            case 30:
                                                encodedValueReader.readNull();
                                                writeTypeAndArg(30, 0);
                                                return;
                                            case 31:
                                                writeTypeAndArg(31, encodedValueReader.readBoolean() ? 1 : 0);
                                                return;
                                            default:
                                                throw new DexException("Unexpected type: " + Integer.toHexString(encodedValueReader.peek()));
                                        }
                                    }
                                    EncodedValueCodec.writeRightZeroExtendedValue(this.out, 17, Double.doubleToLongBits(encodedValueReader.readDouble()));
                                    return;
                                }
                                EncodedValueCodec.writeRightZeroExtendedValue(this.out, 16, Float.floatToIntBits(encodedValueReader.readFloat()) << 32);
                                return;
                            }
                            EncodedValueCodec.writeSignedIntegralValue(this.out, 4, encodedValueReader.readInt());
                            return;
                        }
                        EncodedValueCodec.writeUnsignedIntegralValue(this.out, 3, encodedValueReader.readChar());
                        return;
                    }
                    EncodedValueCodec.writeSignedIntegralValue(this.out, 2, encodedValueReader.readShort());
                    return;
                }
                EncodedValueCodec.writeSignedIntegralValue(this.out, 6, encodedValueReader.readLong());
                return;
            }
            EncodedValueCodec.writeSignedIntegralValue(this.out, 0, encodedValueReader.readByte());
        }
    }

    public IndexMap(Dex dex, TableOfContents tableOfContents) {
        this.target = dex;
        this.stringIds = new int[tableOfContents.stringIds.size];
        this.typeIds = new short[tableOfContents.typeIds.size];
        this.protoIds = new short[tableOfContents.protoIds.size];
        this.fieldIds = new short[tableOfContents.fieldIds.size];
        this.methodIds = new short[tableOfContents.methodIds.size];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        this.typeListOffsets = hashMap;
        this.annotationOffsets = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        this.annotationSetOffsets = hashMap2;
        this.annotationSetRefListOffsets = new HashMap<>();
        HashMap<Integer, Integer> hashMap3 = new HashMap<>();
        this.annotationDirectoryOffsets = hashMap3;
        HashMap<Integer, Integer> hashMap4 = new HashMap<>();
        this.staticValuesOffsets = hashMap4;
        hashMap.put(0, 0);
        hashMap2.put(0, 0);
        hashMap3.put(0, 0);
        hashMap4.put(0, 0);
    }

    public MethodId adjust(MethodId methodId) {
        return new MethodId(this.target, adjustType(methodId.getDeclaringClassIndex()), adjustProto(methodId.getProtoIndex()), adjustString(methodId.getNameIndex()));
    }

    public int adjustAnnotation(int i4) {
        return this.annotationOffsets.get(Integer.valueOf(i4)).intValue();
    }

    public int adjustAnnotationDirectory(int i4) {
        return this.annotationDirectoryOffsets.get(Integer.valueOf(i4)).intValue();
    }

    public int adjustAnnotationSet(int i4) {
        return this.annotationSetOffsets.get(Integer.valueOf(i4)).intValue();
    }

    public int adjustAnnotationSetRefList(int i4) {
        return this.annotationSetRefListOffsets.get(Integer.valueOf(i4)).intValue();
    }

    public EncodedValue adjustEncodedArray(EncodedValue encodedValue) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
        new EncodedValueTransformer(byteArrayAnnotatedOutput).transformArray(new EncodedValueReader(encodedValue, 28));
        return new EncodedValue(byteArrayAnnotatedOutput.toByteArray());
    }

    public EncodedValue adjustEncodedValue(EncodedValue encodedValue) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
        new EncodedValueTransformer(byteArrayAnnotatedOutput).transform(new EncodedValueReader(encodedValue));
        return new EncodedValue(byteArrayAnnotatedOutput.toByteArray());
    }

    public int adjustField(int i4) {
        return this.fieldIds[i4] & UShort.MAX_VALUE;
    }

    public int adjustMethod(int i4) {
        return this.methodIds[i4] & UShort.MAX_VALUE;
    }

    public int adjustProto(int i4) {
        return this.protoIds[i4] & UShort.MAX_VALUE;
    }

    public int adjustStaticValues(int i4) {
        return this.staticValuesOffsets.get(Integer.valueOf(i4)).intValue();
    }

    public int adjustString(int i4) {
        if (i4 == -1) {
            return -1;
        }
        return this.stringIds[i4];
    }

    public int adjustType(int i4) {
        if (i4 == -1) {
            return -1;
        }
        return 65535 & this.typeIds[i4];
    }

    public TypeList adjustTypeList(TypeList typeList) {
        if (typeList == TypeList.EMPTY) {
            return typeList;
        }
        short[] sArr = (short[]) typeList.getTypes().clone();
        for (int i4 = 0; i4 < sArr.length; i4++) {
            sArr[i4] = (short) adjustType(sArr[i4]);
        }
        return new TypeList(this.target, sArr);
    }

    public int adjustTypeListOffset(int i4) {
        return this.typeListOffsets.get(Integer.valueOf(i4)).intValue();
    }

    public void putAnnotationDirectoryOffset(int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.annotationDirectoryOffsets.put(Integer.valueOf(i4), Integer.valueOf(i5));
            return;
        }
        throw new IllegalArgumentException();
    }

    public void putAnnotationOffset(int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.annotationOffsets.put(Integer.valueOf(i4), Integer.valueOf(i5));
            return;
        }
        throw new IllegalArgumentException();
    }

    public void putAnnotationSetOffset(int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.annotationSetOffsets.put(Integer.valueOf(i4), Integer.valueOf(i5));
            return;
        }
        throw new IllegalArgumentException();
    }

    public void putAnnotationSetRefListOffset(int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.annotationSetRefListOffsets.put(Integer.valueOf(i4), Integer.valueOf(i5));
            return;
        }
        throw new IllegalArgumentException();
    }

    public void putStaticValuesOffset(int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.staticValuesOffsets.put(Integer.valueOf(i4), Integer.valueOf(i5));
            return;
        }
        throw new IllegalArgumentException();
    }

    public void putTypeListOffset(int i4, int i5) {
        if (i4 > 0 && i5 > 0) {
            this.typeListOffsets.put(Integer.valueOf(i4), Integer.valueOf(i5));
            return;
        }
        throw new IllegalArgumentException();
    }

    public FieldId adjust(FieldId fieldId) {
        return new FieldId(this.target, adjustType(fieldId.getDeclaringClassIndex()), adjustType(fieldId.getTypeIndex()), adjustString(fieldId.getNameIndex()));
    }

    public ProtoId adjust(ProtoId protoId) {
        return new ProtoId(this.target, adjustString(protoId.getShortyIndex()), adjustType(protoId.getReturnTypeIndex()), adjustTypeListOffset(protoId.getParametersOffset()));
    }

    public ClassDef adjust(ClassDef classDef) {
        return new ClassDef(this.target, classDef.getOffset(), adjustType(classDef.getTypeIndex()), classDef.getAccessFlags(), adjustType(classDef.getSupertypeIndex()), adjustTypeListOffset(classDef.getInterfacesOffset()), classDef.getSourceFileIndex(), classDef.getAnnotationsOffset(), classDef.getClassDataOffset(), classDef.getStaticValuesOffset());
    }

    public SortableType adjust(SortableType sortableType) {
        return new SortableType(sortableType.getDex(), sortableType.getIndexMap(), adjust(sortableType.getClassDef()));
    }

    public Annotation adjust(Annotation annotation) {
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(32);
        new EncodedValueTransformer(byteArrayAnnotatedOutput).transformAnnotation(annotation.getReader());
        return new Annotation(this.target, annotation.getVisibility(), new EncodedValue(byteArrayAnnotatedOutput.toByteArray()));
    }
}
