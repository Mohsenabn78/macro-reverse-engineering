package com.android.dx.dex.file;

import com.android.dex.EncodedValueCodec;
import com.android.dx.rop.annotation.Annotation;
import com.android.dx.rop.annotation.NameValuePair;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstAnnotation;
import com.android.dx.rop.cst.CstArray;
import com.android.dx.rop.cst.CstBoolean;
import com.android.dx.rop.cst.CstByte;
import com.android.dx.rop.cst.CstChar;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstEnumRef;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLiteralBits;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstShort;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.Hex;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class ValueEncoder {
    private static final int VALUE_ANNOTATION = 29;
    private static final int VALUE_ARRAY = 28;
    private static final int VALUE_BOOLEAN = 31;
    private static final int VALUE_BYTE = 0;
    private static final int VALUE_CHAR = 3;
    private static final int VALUE_DOUBLE = 17;
    private static final int VALUE_ENUM = 27;
    private static final int VALUE_FIELD = 25;
    private static final int VALUE_FLOAT = 16;
    private static final int VALUE_INT = 4;
    private static final int VALUE_LONG = 6;
    private static final int VALUE_METHOD = 26;
    private static final int VALUE_NULL = 30;
    private static final int VALUE_SHORT = 2;
    private static final int VALUE_STRING = 23;
    private static final int VALUE_TYPE = 24;
    private final DexFile file;
    private final AnnotatedOutput out;

    public ValueEncoder(DexFile dexFile, AnnotatedOutput annotatedOutput) {
        if (dexFile != null) {
            if (annotatedOutput != null) {
                this.file = dexFile;
                this.out = annotatedOutput;
                return;
            }
            throw new NullPointerException("out == null");
        }
        throw new NullPointerException("file == null");
    }

    public static void addContents(DexFile dexFile, Annotation annotation) {
        TypeIdsSection typeIds = dexFile.getTypeIds();
        StringIdsSection stringIds = dexFile.getStringIds();
        typeIds.intern(annotation.getType());
        for (NameValuePair nameValuePair : annotation.getNameValuePairs()) {
            stringIds.intern(nameValuePair.getName());
            addContents(dexFile, nameValuePair.getValue());
        }
    }

    public static String constantToHuman(Constant constant) {
        if (constantToValueType(constant) == 30) {
            return "null";
        }
        return constant.typeName() + ' ' + constant.toHuman();
    }

    private static int constantToValueType(Constant constant) {
        if (constant instanceof CstByte) {
            return 0;
        }
        if (constant instanceof CstShort) {
            return 2;
        }
        if (constant instanceof CstChar) {
            return 3;
        }
        if (constant instanceof CstInteger) {
            return 4;
        }
        if (constant instanceof CstLong) {
            return 6;
        }
        if (constant instanceof CstFloat) {
            return 16;
        }
        if (constant instanceof CstDouble) {
            return 17;
        }
        if (constant instanceof CstString) {
            return 23;
        }
        if (constant instanceof CstType) {
            return 24;
        }
        if (constant instanceof CstFieldRef) {
            return 25;
        }
        if (constant instanceof CstMethodRef) {
            return 26;
        }
        if (constant instanceof CstEnumRef) {
            return 27;
        }
        if (constant instanceof CstArray) {
            return 28;
        }
        if (constant instanceof CstAnnotation) {
            return 29;
        }
        if (constant instanceof CstKnownNull) {
            return 30;
        }
        if (constant instanceof CstBoolean) {
            return 31;
        }
        throw new RuntimeException("Shouldn't happen");
    }

    public void writeAnnotation(Annotation annotation, boolean z3) {
        boolean z4;
        if (z3 && this.out.annotates()) {
            z4 = true;
        } else {
            z4 = false;
        }
        StringIdsSection stringIds = this.file.getStringIds();
        TypeIdsSection typeIds = this.file.getTypeIds();
        CstType type = annotation.getType();
        int indexOf = typeIds.indexOf(type);
        if (z4) {
            AnnotatedOutput annotatedOutput = this.out;
            annotatedOutput.annotate("  type_idx: " + Hex.u4(indexOf) + " // " + type.toHuman());
        }
        this.out.writeUleb128(typeIds.indexOf(annotation.getType()));
        Collection<NameValuePair> nameValuePairs = annotation.getNameValuePairs();
        int size = nameValuePairs.size();
        if (z4) {
            AnnotatedOutput annotatedOutput2 = this.out;
            annotatedOutput2.annotate("  size: " + Hex.u4(size));
        }
        this.out.writeUleb128(size);
        int i4 = 0;
        for (NameValuePair nameValuePair : nameValuePairs) {
            CstString name = nameValuePair.getName();
            int indexOf2 = stringIds.indexOf(name);
            Constant value = nameValuePair.getValue();
            if (z4) {
                AnnotatedOutput annotatedOutput3 = this.out;
                annotatedOutput3.annotate(0, "  elements[" + i4 + "]:");
                i4++;
                AnnotatedOutput annotatedOutput4 = this.out;
                annotatedOutput4.annotate("    name_idx: " + Hex.u4(indexOf2) + " // " + name.toHuman());
            }
            this.out.writeUleb128(indexOf2);
            if (z4) {
                AnnotatedOutput annotatedOutput5 = this.out;
                annotatedOutput5.annotate("    value: " + constantToHuman(value));
            }
            writeConstant(value);
        }
        if (z4) {
            this.out.endAnnotation();
        }
    }

    public void writeArray(CstArray cstArray, boolean z3) {
        boolean z4;
        if (z3 && this.out.annotates()) {
            z4 = true;
        } else {
            z4 = false;
        }
        CstArray.List list = cstArray.getList();
        int size = list.size();
        if (z4) {
            AnnotatedOutput annotatedOutput = this.out;
            annotatedOutput.annotate("  size: " + Hex.u4(size));
        }
        this.out.writeUleb128(size);
        for (int i4 = 0; i4 < size; i4++) {
            Constant constant = list.get(i4);
            if (z4) {
                AnnotatedOutput annotatedOutput2 = this.out;
                annotatedOutput2.annotate("  [" + Integer.toHexString(i4) + "] " + constantToHuman(constant));
            }
            writeConstant(constant);
        }
        if (z4) {
            this.out.endAnnotation();
        }
    }

    public void writeConstant(Constant constant) {
        int constantToValueType = constantToValueType(constant);
        if (constantToValueType != 0 && constantToValueType != 6 && constantToValueType != 2) {
            if (constantToValueType != 3) {
                if (constantToValueType != 4) {
                    if (constantToValueType != 16) {
                        if (constantToValueType != 17) {
                            switch (constantToValueType) {
                                case 23:
                                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, this.file.getStringIds().indexOf((CstString) constant));
                                    return;
                                case 24:
                                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, this.file.getTypeIds().indexOf((CstType) constant));
                                    return;
                                case 25:
                                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, this.file.getFieldIds().indexOf((CstFieldRef) constant));
                                    return;
                                case 26:
                                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, this.file.getMethodIds().indexOf((CstMethodRef) constant));
                                    return;
                                case 27:
                                    EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, this.file.getFieldIds().indexOf(((CstEnumRef) constant).getFieldRef()));
                                    return;
                                case 28:
                                    this.out.writeByte(constantToValueType);
                                    writeArray((CstArray) constant, false);
                                    return;
                                case 29:
                                    this.out.writeByte(constantToValueType);
                                    writeAnnotation(((CstAnnotation) constant).getAnnotation(), false);
                                    return;
                                case 30:
                                    this.out.writeByte(constantToValueType);
                                    return;
                                case 31:
                                    this.out.writeByte((((CstBoolean) constant).getIntBits() << 5) | constantToValueType);
                                    return;
                                default:
                                    throw new RuntimeException("Shouldn't happen");
                            }
                        }
                        EncodedValueCodec.writeRightZeroExtendedValue(this.out, constantToValueType, ((CstDouble) constant).getLongBits());
                        return;
                    }
                    EncodedValueCodec.writeRightZeroExtendedValue(this.out, constantToValueType, ((CstFloat) constant).getLongBits() << 32);
                    return;
                }
            } else {
                EncodedValueCodec.writeUnsignedIntegralValue(this.out, constantToValueType, ((CstLiteralBits) constant).getLongBits());
                return;
            }
        }
        EncodedValueCodec.writeSignedIntegralValue(this.out, constantToValueType, ((CstLiteralBits) constant).getLongBits());
    }

    public static void addContents(DexFile dexFile, Constant constant) {
        if (constant instanceof CstAnnotation) {
            addContents(dexFile, ((CstAnnotation) constant).getAnnotation());
        } else if (constant instanceof CstArray) {
            CstArray.List list = ((CstArray) constant).getList();
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                addContents(dexFile, list.get(i4));
            }
        } else {
            dexFile.internIfAppropriate(constant);
        }
    }
}
