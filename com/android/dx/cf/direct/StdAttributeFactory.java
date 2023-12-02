package com.android.dx.cf.direct;

import com.android.dx.cf.attrib.AttAnnotationDefault;
import com.android.dx.cf.attrib.AttCode;
import com.android.dx.cf.attrib.AttConstantValue;
import com.android.dx.cf.attrib.AttDeprecated;
import com.android.dx.cf.attrib.AttEnclosingMethod;
import com.android.dx.cf.attrib.AttExceptions;
import com.android.dx.cf.attrib.AttInnerClasses;
import com.android.dx.cf.attrib.AttLineNumberTable;
import com.android.dx.cf.attrib.AttLocalVariableTable;
import com.android.dx.cf.attrib.AttLocalVariableTypeTable;
import com.android.dx.cf.attrib.AttRuntimeInvisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeInvisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleAnnotations;
import com.android.dx.cf.attrib.AttRuntimeVisibleParameterAnnotations;
import com.android.dx.cf.attrib.AttSignature;
import com.android.dx.cf.attrib.AttSourceFile;
import com.android.dx.cf.attrib.AttSynthetic;
import com.android.dx.cf.attrib.InnerClassList;
import com.android.dx.cf.code.ByteCatchList;
import com.android.dx.cf.code.BytecodeArray;
import com.android.dx.cf.code.LineNumberList;
import com.android.dx.cf.code.LocalVariableList;
import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.rop.annotation.AnnotationVisibility;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.io.IOException;

/* loaded from: classes2.dex */
public class StdAttributeFactory extends AttributeFactory {
    public static final StdAttributeFactory THE_ONE = new StdAttributeFactory();

    private Attribute annotationDefault(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            throwSeverelyTruncated();
        }
        return new AttAnnotationDefault(new AnnotationParser(directClassFile, i4, i5, parseObserver).parseValueAttribute(), i5);
    }

    private Attribute code(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        ByteCatchList byteCatchList;
        String human;
        if (i5 < 12) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        ConstantPool constantPool = directClassFile.getConstantPool();
        int unsignedShort = bytes.getUnsignedShort(i4);
        int i6 = i4 + 2;
        int unsignedShort2 = bytes.getUnsignedShort(i6);
        int i7 = i4 + 4;
        int i8 = bytes.getInt(i7);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "max_stack: " + Hex.u2(unsignedShort));
            parseObserver.parsed(bytes, i6, 2, "max_locals: " + Hex.u2(unsignedShort2));
            parseObserver.parsed(bytes, i7, 4, "code_length: " + Hex.u4(i8));
        }
        int i9 = i4 + 8;
        int i10 = i5 - 8;
        if (i10 < i8 + 4) {
            return throwTruncated();
        }
        int i11 = i9 + i8;
        int i12 = i10 - i8;
        BytecodeArray bytecodeArray = new BytecodeArray(bytes.slice(i9, i11), constantPool);
        if (parseObserver != null) {
            bytecodeArray.forEach(new CodeObserver(bytecodeArray.getBytes(), parseObserver));
        }
        int unsignedShort3 = bytes.getUnsignedShort(i11);
        if (unsignedShort3 == 0) {
            byteCatchList = ByteCatchList.EMPTY;
        } else {
            byteCatchList = new ByteCatchList(unsignedShort3);
        }
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i11, 2, "exception_table_length: " + Hex.u2(unsignedShort3));
        }
        int i13 = i11 + 2;
        int i14 = i12 - 2;
        if (i14 < (unsignedShort3 * 8) + 2) {
            return throwTruncated();
        }
        for (int i15 = 0; i15 < unsignedShort3; i15++) {
            if (parseObserver != null) {
                parseObserver.changeIndent(1);
            }
            int unsignedShort4 = bytes.getUnsignedShort(i13);
            int unsignedShort5 = bytes.getUnsignedShort(i13 + 2);
            int unsignedShort6 = bytes.getUnsignedShort(i13 + 4);
            CstType cstType = (CstType) constantPool.get0Ok(bytes.getUnsignedShort(i13 + 6));
            byteCatchList.set(i15, unsignedShort4, unsignedShort5, unsignedShort6, cstType);
            if (parseObserver != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(Hex.u2(unsignedShort4));
                sb.append("..");
                sb.append(Hex.u2(unsignedShort5));
                sb.append(" -> ");
                sb.append(Hex.u2(unsignedShort6));
                sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                if (cstType == null) {
                    human = "<any>";
                } else {
                    human = cstType.toHuman();
                }
                sb.append(human);
                parseObserver.parsed(bytes, i13, 8, sb.toString());
            }
            i13 += 8;
            i14 -= 8;
            if (parseObserver != null) {
                parseObserver.changeIndent(-1);
            }
        }
        byteCatchList.setImmutable();
        AttributeListParser attributeListParser = new AttributeListParser(directClassFile, 3, i13, this);
        attributeListParser.setObserver(parseObserver);
        StdAttributeList list = attributeListParser.getList();
        list.setImmutable();
        int endOffset = attributeListParser.getEndOffset() - i13;
        if (endOffset != i14) {
            return throwBadLength(endOffset + (i13 - i4));
        }
        return new AttCode(unsignedShort, unsignedShort2, bytecodeArray, byteCatchList, list);
    }

    private Attribute constantValue(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 != 2) {
            return throwBadLength(2);
        }
        ByteArray bytes = directClassFile.getBytes();
        TypedConstant typedConstant = (TypedConstant) directClassFile.getConstantPool().get(bytes.getUnsignedShort(i4));
        AttConstantValue attConstantValue = new AttConstantValue(typedConstant);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "value: " + typedConstant);
        }
        return attConstantValue;
    }

    private Attribute deprecated(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 != 0) {
            return throwBadLength(0);
        }
        return new AttDeprecated();
    }

    private Attribute enclosingMethod(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 != 4) {
            throwBadLength(4);
        }
        ByteArray bytes = directClassFile.getBytes();
        ConstantPool constantPool = directClassFile.getConstantPool();
        CstType cstType = (CstType) constantPool.get(bytes.getUnsignedShort(i4));
        int i6 = i4 + 2;
        CstNat cstNat = (CstNat) constantPool.get0Ok(bytes.getUnsignedShort(i6));
        AttEnclosingMethod attEnclosingMethod = new AttEnclosingMethod(cstType, cstNat);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "class: " + cstType);
            parseObserver.parsed(bytes, i6, 2, "method: " + DirectClassFile.stringOrNone(cstNat));
        }
        return attEnclosingMethod;
    }

    private Attribute exceptions(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i4);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "number_of_exceptions: " + Hex.u2(unsignedShort));
        }
        int i6 = i4 + 2;
        int i7 = unsignedShort * 2;
        if (i5 - 2 != i7) {
            throwBadLength(i7 + 2);
        }
        return new AttExceptions(directClassFile.makeTypeList(i6, unsignedShort));
    }

    private Attribute innerClasses(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        ConstantPool constantPool = directClassFile.getConstantPool();
        int unsignedShort = bytes.getUnsignedShort(i4);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "number_of_classes: " + Hex.u2(unsignedShort));
        }
        int i6 = i4 + 2;
        int i7 = unsignedShort * 8;
        if (i5 - 2 != i7) {
            throwBadLength(i7 + 2);
        }
        InnerClassList innerClassList = new InnerClassList(unsignedShort);
        for (int i8 = 0; i8 < unsignedShort; i8++) {
            int unsignedShort2 = bytes.getUnsignedShort(i6);
            int i9 = i6 + 2;
            int unsignedShort3 = bytes.getUnsignedShort(i9);
            int i10 = i6 + 4;
            int unsignedShort4 = bytes.getUnsignedShort(i10);
            int i11 = i6 + 6;
            int unsignedShort5 = bytes.getUnsignedShort(i11);
            CstType cstType = (CstType) constantPool.get(unsignedShort2);
            CstType cstType2 = (CstType) constantPool.get0Ok(unsignedShort3);
            CstString cstString = (CstString) constantPool.get0Ok(unsignedShort4);
            innerClassList.set(i8, cstType, cstType2, cstString, unsignedShort5);
            if (parseObserver != null) {
                parseObserver.parsed(bytes, i6, 2, "inner_class: " + DirectClassFile.stringOrNone(cstType));
                parseObserver.parsed(bytes, i9, 2, "  outer_class: " + DirectClassFile.stringOrNone(cstType2));
                parseObserver.parsed(bytes, i10, 2, "  name: " + DirectClassFile.stringOrNone(cstString));
                parseObserver.parsed(bytes, i11, 2, "  access_flags: " + AccessFlags.innerClassString(unsignedShort5));
            }
            i6 += 8;
        }
        innerClassList.setImmutable();
        return new AttInnerClasses(innerClassList);
    }

    private Attribute lineNumberTable(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i4);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "line_number_table_length: " + Hex.u2(unsignedShort));
        }
        int i6 = i4 + 2;
        int i7 = unsignedShort * 4;
        if (i5 - 2 != i7) {
            throwBadLength(i7 + 2);
        }
        LineNumberList lineNumberList = new LineNumberList(unsignedShort);
        for (int i8 = 0; i8 < unsignedShort; i8++) {
            int unsignedShort2 = bytes.getUnsignedShort(i6);
            int unsignedShort3 = bytes.getUnsignedShort(i6 + 2);
            lineNumberList.set(i8, unsignedShort2, unsignedShort3);
            if (parseObserver != null) {
                parseObserver.parsed(bytes, i6, 4, Hex.u2(unsignedShort2) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + unsignedShort3);
            }
            i6 += 4;
        }
        lineNumberList.setImmutable();
        return new AttLineNumberTable(lineNumberList);
    }

    private Attribute localVariableTable(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i4);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "local_variable_table_length: " + Hex.u2(unsignedShort));
        }
        return new AttLocalVariableTable(parseLocalVariables(bytes.slice(i4 + 2, i4 + i5), directClassFile.getConstantPool(), parseObserver, unsignedShort, false));
    }

    private Attribute localVariableTypeTable(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            return throwSeverelyTruncated();
        }
        ByteArray bytes = directClassFile.getBytes();
        int unsignedShort = bytes.getUnsignedShort(i4);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "local_variable_type_table_length: " + Hex.u2(unsignedShort));
        }
        return new AttLocalVariableTypeTable(parseLocalVariables(bytes.slice(i4 + 2, i4 + i5), directClassFile.getConstantPool(), parseObserver, unsignedShort, true));
    }

    private LocalVariableList parseLocalVariables(ByteArray byteArray, ConstantPool constantPool, ParseObserver parseObserver, int i4, boolean z3) {
        CstString cstString;
        CstString cstString2;
        int i5 = i4 * 10;
        if (byteArray.size() != i5) {
            throwBadLength(i5 + 2);
        }
        ByteArray.MyDataInputStream makeDataInputStream = byteArray.makeDataInputStream();
        LocalVariableList localVariableList = new LocalVariableList(i4);
        for (int i6 = 0; i6 < i4; i6++) {
            try {
                int readUnsignedShort = makeDataInputStream.readUnsignedShort();
                int readUnsignedShort2 = makeDataInputStream.readUnsignedShort();
                int readUnsignedShort3 = makeDataInputStream.readUnsignedShort();
                int readUnsignedShort4 = makeDataInputStream.readUnsignedShort();
                int readUnsignedShort5 = makeDataInputStream.readUnsignedShort();
                CstString cstString3 = (CstString) constantPool.get(readUnsignedShort3);
                CstString cstString4 = (CstString) constantPool.get(readUnsignedShort4);
                if (z3) {
                    cstString2 = null;
                    cstString = cstString4;
                } else {
                    cstString = null;
                    cstString2 = cstString4;
                }
                localVariableList.set(i6, readUnsignedShort, readUnsignedShort2, cstString3, cstString2, cstString, readUnsignedShort5);
                if (parseObserver != null) {
                    parseObserver.parsed(byteArray, i6 * 10, 10, Hex.u2(readUnsignedShort) + ".." + Hex.u2(readUnsignedShort + readUnsignedShort2) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + Hex.u2(readUnsignedShort5) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + cstString3.toHuman() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + cstString4.toHuman());
                }
            } catch (IOException e4) {
                throw new RuntimeException("shouldn't happen", e4);
            }
        }
        localVariableList.setImmutable();
        return localVariableList;
    }

    private Attribute runtimeInvisibleAnnotations(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            throwSeverelyTruncated();
        }
        return new AttRuntimeInvisibleAnnotations(new AnnotationParser(directClassFile, i4, i5, parseObserver).parseAnnotationAttribute(AnnotationVisibility.BUILD), i5);
    }

    private Attribute runtimeInvisibleParameterAnnotations(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            throwSeverelyTruncated();
        }
        return new AttRuntimeInvisibleParameterAnnotations(new AnnotationParser(directClassFile, i4, i5, parseObserver).parseParameterAttribute(AnnotationVisibility.BUILD), i5);
    }

    private Attribute runtimeVisibleAnnotations(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            throwSeverelyTruncated();
        }
        return new AttRuntimeVisibleAnnotations(new AnnotationParser(directClassFile, i4, i5, parseObserver).parseAnnotationAttribute(AnnotationVisibility.RUNTIME), i5);
    }

    private Attribute runtimeVisibleParameterAnnotations(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 < 2) {
            throwSeverelyTruncated();
        }
        return new AttRuntimeVisibleParameterAnnotations(new AnnotationParser(directClassFile, i4, i5, parseObserver).parseParameterAttribute(AnnotationVisibility.RUNTIME), i5);
    }

    private Attribute signature(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 != 2) {
            throwBadLength(2);
        }
        ByteArray bytes = directClassFile.getBytes();
        CstString cstString = (CstString) directClassFile.getConstantPool().get(bytes.getUnsignedShort(i4));
        AttSignature attSignature = new AttSignature(cstString);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "signature: " + cstString);
        }
        return attSignature;
    }

    private Attribute sourceFile(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 != 2) {
            throwBadLength(2);
        }
        ByteArray bytes = directClassFile.getBytes();
        CstString cstString = (CstString) directClassFile.getConstantPool().get(bytes.getUnsignedShort(i4));
        AttSourceFile attSourceFile = new AttSourceFile(cstString);
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i4, 2, "source: " + cstString);
        }
        return attSourceFile;
    }

    private Attribute synthetic(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        if (i5 != 0) {
            return throwBadLength(0);
        }
        return new AttSynthetic();
    }

    private static Attribute throwBadLength(int i4) {
        throw new ParseException("bad attribute length; expected length " + Hex.u4(i4));
    }

    private static Attribute throwSeverelyTruncated() {
        throw new ParseException("severely truncated attribute");
    }

    private static Attribute throwTruncated() {
        throw new ParseException("truncated attribute");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.dx.cf.direct.AttributeFactory
    public Attribute parse0(DirectClassFile directClassFile, int i4, String str, int i5, int i6, ParseObserver parseObserver) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        if (str == AttLineNumberTable.ATTRIBUTE_NAME) {
                            return lineNumberTable(directClassFile, i5, i6, parseObserver);
                        }
                        if (str == AttLocalVariableTable.ATTRIBUTE_NAME) {
                            return localVariableTable(directClassFile, i5, i6, parseObserver);
                        }
                        if (str == AttLocalVariableTypeTable.ATTRIBUTE_NAME) {
                            return localVariableTypeTable(directClassFile, i5, i6, parseObserver);
                        }
                    }
                } else if (str == AttAnnotationDefault.ATTRIBUTE_NAME) {
                    return annotationDefault(directClassFile, i5, i6, parseObserver);
                } else {
                    if (str == AttCode.ATTRIBUTE_NAME) {
                        return code(directClassFile, i5, i6, parseObserver);
                    }
                    if (str == AttDeprecated.ATTRIBUTE_NAME) {
                        return deprecated(directClassFile, i5, i6, parseObserver);
                    }
                    if (str == AttExceptions.ATTRIBUTE_NAME) {
                        return exceptions(directClassFile, i5, i6, parseObserver);
                    }
                    if (str == AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME) {
                        return runtimeInvisibleAnnotations(directClassFile, i5, i6, parseObserver);
                    }
                    if (str == AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME) {
                        return runtimeVisibleAnnotations(directClassFile, i5, i6, parseObserver);
                    }
                    if (str == AttRuntimeInvisibleParameterAnnotations.ATTRIBUTE_NAME) {
                        return runtimeInvisibleParameterAnnotations(directClassFile, i5, i6, parseObserver);
                    }
                    if (str == AttRuntimeVisibleParameterAnnotations.ATTRIBUTE_NAME) {
                        return runtimeVisibleParameterAnnotations(directClassFile, i5, i6, parseObserver);
                    }
                    if (str == AttSignature.ATTRIBUTE_NAME) {
                        return signature(directClassFile, i5, i6, parseObserver);
                    }
                    if (str == AttSynthetic.ATTRIBUTE_NAME) {
                        return synthetic(directClassFile, i5, i6, parseObserver);
                    }
                }
            } else if (str == AttConstantValue.ATTRIBUTE_NAME) {
                return constantValue(directClassFile, i5, i6, parseObserver);
            } else {
                if (str == AttDeprecated.ATTRIBUTE_NAME) {
                    return deprecated(directClassFile, i5, i6, parseObserver);
                }
                if (str == AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeInvisibleAnnotations(directClassFile, i5, i6, parseObserver);
                }
                if (str == AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME) {
                    return runtimeVisibleAnnotations(directClassFile, i5, i6, parseObserver);
                }
                if (str == AttSignature.ATTRIBUTE_NAME) {
                    return signature(directClassFile, i5, i6, parseObserver);
                }
                if (str == AttSynthetic.ATTRIBUTE_NAME) {
                    return synthetic(directClassFile, i5, i6, parseObserver);
                }
            }
        } else if (str == AttDeprecated.ATTRIBUTE_NAME) {
            return deprecated(directClassFile, i5, i6, parseObserver);
        } else {
            if (str == AttEnclosingMethod.ATTRIBUTE_NAME) {
                return enclosingMethod(directClassFile, i5, i6, parseObserver);
            }
            if (str == AttInnerClasses.ATTRIBUTE_NAME) {
                return innerClasses(directClassFile, i5, i6, parseObserver);
            }
            if (str == AttRuntimeInvisibleAnnotations.ATTRIBUTE_NAME) {
                return runtimeInvisibleAnnotations(directClassFile, i5, i6, parseObserver);
            }
            if (str == AttRuntimeVisibleAnnotations.ATTRIBUTE_NAME) {
                return runtimeVisibleAnnotations(directClassFile, i5, i6, parseObserver);
            }
            if (str == AttSynthetic.ATTRIBUTE_NAME) {
                return synthetic(directClassFile, i5, i6, parseObserver);
            }
            if (str == AttSignature.ATTRIBUTE_NAME) {
                return signature(directClassFile, i5, i6, parseObserver);
            }
            if (str == AttSourceFile.ATTRIBUTE_NAME) {
                return sourceFile(directClassFile, i5, i6, parseObserver);
            }
        }
        return super.parse0(directClassFile, i4, str, i5, i6, parseObserver);
    }
}
