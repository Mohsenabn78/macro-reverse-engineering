package com.android.dx.dex.cf;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.cf.direct.DirectClassFile;
import com.android.dx.cf.iface.Field;
import com.android.dx.cf.iface.FieldList;
import com.android.dx.dex.DexOptions;
import com.android.dx.dex.code.DalvCode;
import com.android.dx.dex.code.RopTranslator;
import com.android.dx.dex.file.ClassDefItem;
import com.android.dx.dex.file.DexFile;
import com.android.dx.dex.file.EncodedField;
import com.android.dx.dex.file.FieldIdsSection;
import com.android.dx.dex.file.MethodIdsSection;
import com.android.dx.rop.annotation.Annotations;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.code.LocalVariableInfo;
import com.android.dx.rop.code.RopMethod;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.rop.cst.CstBoolean;
import com.android.dx.rop.cst.CstByte;
import com.android.dx.rop.cst.CstChar;
import com.android.dx.rop.cst.CstEnumRef;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstInterfaceMethodRef;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstShort;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;
import com.android.dx.rop.type.Type;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class CfTranslator {
    private static final boolean DEBUG = false;

    private CfTranslator() {
    }

    private static TypedConstant coerceConstant(TypedConstant typedConstant, Type type) {
        if (typedConstant.getType().equals(type)) {
            return typedConstant;
        }
        int basicType = type.getBasicType();
        if (basicType != 1) {
            if (basicType != 2) {
                if (basicType != 3) {
                    if (basicType == 8) {
                        return CstShort.make(((CstInteger) typedConstant).getValue());
                    }
                    throw new UnsupportedOperationException("can't coerce " + typedConstant + " to " + type);
                }
                return CstChar.make(((CstInteger) typedConstant).getValue());
            }
            return CstByte.make(((CstInteger) typedConstant).getValue());
        }
        return CstBoolean.make(((CstInteger) typedConstant).getValue());
    }

    private static void processFields(DirectClassFile directClassFile, ClassDefItem classDefItem, DexFile dexFile) {
        CstType thisClass = directClassFile.getThisClass();
        FieldList fields = directClassFile.getFields();
        int size = fields.size();
        for (int i4 = 0; i4 < size; i4++) {
            Field field = fields.get(i4);
            try {
                CstFieldRef cstFieldRef = new CstFieldRef(thisClass, field.getNat());
                int accessFlags = field.getAccessFlags();
                if (AccessFlags.isStatic(accessFlags)) {
                    TypedConstant constantValue = field.getConstantValue();
                    EncodedField encodedField = new EncodedField(cstFieldRef, accessFlags);
                    if (constantValue != null) {
                        constantValue = coerceConstant(constantValue, cstFieldRef.getType());
                    }
                    classDefItem.addStaticField(encodedField, constantValue);
                } else {
                    classDefItem.addInstanceField(new EncodedField(cstFieldRef, accessFlags));
                }
                Annotations annotations = AttributeTranslator.getAnnotations(field.getAttributes());
                if (annotations.size() != 0) {
                    classDefItem.addFieldAnnotations(cstFieldRef, annotations, dexFile);
                }
                dexFile.getFieldIds().intern(cstFieldRef);
            } catch (RuntimeException e4) {
                throw ExceptionWithContext.withContext(e4, "...while processing " + field.getName().toHuman() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + field.getDescriptor().toHuman());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ab A[Catch: RuntimeException -> 0x0144, TryCatch #0 {RuntimeException -> 0x0144, blocks: (B:5:0x0019, B:7:0x003d, B:15:0x004f, B:19:0x0057, B:21:0x0090, B:23:0x0096, B:25:0x00a0, B:28:0x00a7, B:30:0x00ab, B:32:0x00b2, B:35:0x00c2, B:39:0x00e6, B:41:0x00ec, B:43:0x00f2, B:45:0x00f6, B:46:0x00fa, B:48:0x010b, B:53:0x0116, B:55:0x011d, B:57:0x0127, B:58:0x012a, B:60:0x0134, B:61:0x0137, B:54:0x011a), top: B:67:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec A[Catch: RuntimeException -> 0x0144, TryCatch #0 {RuntimeException -> 0x0144, blocks: (B:5:0x0019, B:7:0x003d, B:15:0x004f, B:19:0x0057, B:21:0x0090, B:23:0x0096, B:25:0x00a0, B:28:0x00a7, B:30:0x00ab, B:32:0x00b2, B:35:0x00c2, B:39:0x00e6, B:41:0x00ec, B:43:0x00f2, B:45:0x00f6, B:46:0x00fa, B:48:0x010b, B:53:0x0116, B:55:0x011d, B:57:0x0127, B:58:0x012a, B:60:0x0134, B:61:0x0137, B:54:0x011a), top: B:67:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f6 A[Catch: RuntimeException -> 0x0144, TryCatch #0 {RuntimeException -> 0x0144, blocks: (B:5:0x0019, B:7:0x003d, B:15:0x004f, B:19:0x0057, B:21:0x0090, B:23:0x0096, B:25:0x00a0, B:28:0x00a7, B:30:0x00ab, B:32:0x00b2, B:35:0x00c2, B:39:0x00e6, B:41:0x00ec, B:43:0x00f2, B:45:0x00f6, B:46:0x00fa, B:48:0x010b, B:53:0x0116, B:55:0x011d, B:57:0x0127, B:58:0x012a, B:60:0x0134, B:61:0x0137, B:54:0x011a), top: B:67:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010b A[Catch: RuntimeException -> 0x0144, TryCatch #0 {RuntimeException -> 0x0144, blocks: (B:5:0x0019, B:7:0x003d, B:15:0x004f, B:19:0x0057, B:21:0x0090, B:23:0x0096, B:25:0x00a0, B:28:0x00a7, B:30:0x00ab, B:32:0x00b2, B:35:0x00c2, B:39:0x00e6, B:41:0x00ec, B:43:0x00f2, B:45:0x00f6, B:46:0x00fa, B:48:0x010b, B:53:0x0116, B:55:0x011d, B:57:0x0127, B:58:0x012a, B:60:0x0134, B:61:0x0137, B:54:0x011a), top: B:67:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0127 A[Catch: RuntimeException -> 0x0144, TryCatch #0 {RuntimeException -> 0x0144, blocks: (B:5:0x0019, B:7:0x003d, B:15:0x004f, B:19:0x0057, B:21:0x0090, B:23:0x0096, B:25:0x00a0, B:28:0x00a7, B:30:0x00ab, B:32:0x00b2, B:35:0x00c2, B:39:0x00e6, B:41:0x00ec, B:43:0x00f2, B:45:0x00f6, B:46:0x00fa, B:48:0x010b, B:53:0x0116, B:55:0x011d, B:57:0x0127, B:58:0x012a, B:60:0x0134, B:61:0x0137, B:54:0x011a), top: B:67:0x0019 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0134 A[Catch: RuntimeException -> 0x0144, TryCatch #0 {RuntimeException -> 0x0144, blocks: (B:5:0x0019, B:7:0x003d, B:15:0x004f, B:19:0x0057, B:21:0x0090, B:23:0x0096, B:25:0x00a0, B:28:0x00a7, B:30:0x00ab, B:32:0x00b2, B:35:0x00c2, B:39:0x00e6, B:41:0x00ec, B:43:0x00f2, B:45:0x00f6, B:46:0x00fa, B:48:0x010b, B:53:0x0116, B:55:0x011d, B:57:0x0127, B:58:0x012a, B:60:0x0134, B:61:0x0137, B:54:0x011a), top: B:67:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void processMethods(com.android.dx.cf.direct.DirectClassFile r24, com.android.dx.dex.cf.CfOptions r25, com.android.dx.dex.DexOptions r26, com.android.dx.dex.file.ClassDefItem r27, com.android.dx.dex.file.DexFile r28) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.dex.cf.CfTranslator.processMethods(com.android.dx.cf.direct.DirectClassFile, com.android.dx.dex.cf.CfOptions, com.android.dx.dex.DexOptions, com.android.dx.dex.file.ClassDefItem, com.android.dx.dex.file.DexFile):void");
    }

    public static ClassDefItem translate(DirectClassFile directClassFile, byte[] bArr, CfOptions cfOptions, DexOptions dexOptions, DexFile dexFile) {
        try {
            return translate0(directClassFile, bArr, cfOptions, dexOptions, dexFile);
        } catch (RuntimeException e4) {
            throw ExceptionWithContext.withContext(e4, "...while processing " + directClassFile.getFilePath());
        }
    }

    private static ClassDefItem translate0(DirectClassFile directClassFile, byte[] bArr, CfOptions cfOptions, DexOptions dexOptions, DexFile dexFile) {
        CstString sourceFile;
        OptimizerOptions.loadOptimizeLists(cfOptions.optimizeListFile, cfOptions.dontOptimizeListFile);
        CstType thisClass = directClassFile.getThisClass();
        int accessFlags = directClassFile.getAccessFlags() & (-33);
        if (cfOptions.positionInfo == 1) {
            sourceFile = null;
        } else {
            sourceFile = directClassFile.getSourceFile();
        }
        ClassDefItem classDefItem = new ClassDefItem(thisClass, accessFlags, directClassFile.getSuperclass(), directClassFile.getInterfaces(), sourceFile);
        Annotations classAnnotations = AttributeTranslator.getClassAnnotations(directClassFile, cfOptions);
        if (classAnnotations.size() != 0) {
            classDefItem.setClassAnnotations(classAnnotations, dexFile);
        }
        FieldIdsSection fieldIds = dexFile.getFieldIds();
        MethodIdsSection methodIds = dexFile.getMethodIds();
        processFields(directClassFile, classDefItem, dexFile);
        processMethods(directClassFile, cfOptions, dexOptions, classDefItem, dexFile);
        ConstantPool constantPool = directClassFile.getConstantPool();
        int size = constantPool.size();
        for (int i4 = 0; i4 < size; i4++) {
            Constant orNull = constantPool.getOrNull(i4);
            if (orNull instanceof CstMethodRef) {
                methodIds.intern((CstBaseMethodRef) orNull);
            } else if (orNull instanceof CstInterfaceMethodRef) {
                methodIds.intern(((CstInterfaceMethodRef) orNull).toMethodRef());
            } else if (orNull instanceof CstFieldRef) {
                fieldIds.intern((CstFieldRef) orNull);
            } else if (orNull instanceof CstEnumRef) {
                fieldIds.intern(((CstEnumRef) orNull).getFieldRef());
            }
        }
        return classDefItem;
    }

    private static void updateDexStatistics(CfOptions cfOptions, DexOptions dexOptions, RopMethod ropMethod, RopMethod ropMethod2, LocalVariableInfo localVariableInfo, int i4, int i5) {
        DalvCode translate = RopTranslator.translate(ropMethod, cfOptions.positionInfo, localVariableInfo, i4, dexOptions);
        DalvCode translate2 = RopTranslator.translate(ropMethod2, cfOptions.positionInfo, localVariableInfo, i4, dexOptions);
        DalvCode.AssignIndicesCallback assignIndicesCallback = new DalvCode.AssignIndicesCallback() { // from class: com.android.dx.dex.cf.CfTranslator.1
            @Override // com.android.dx.dex.code.DalvCode.AssignIndicesCallback
            public int getIndex(Constant constant) {
                return 0;
            }
        };
        translate.assignIndices(assignIndicesCallback);
        translate2.assignIndices(assignIndicesCallback);
        CodeStatistics.updateDexStatistics(translate2, translate);
        CodeStatistics.updateOriginalByteCount(i5);
    }
}
