package com.android.dx.dex.file;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.dex.DexOptions;
import com.android.dx.dex.file.MixedItemSection;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.rop.cst.CstEnumRef;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArrayAnnotatedOutput;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Adler32;

/* loaded from: classes2.dex */
public final class DexFile {
    private final MixedItemSection byteData;
    private final MixedItemSection classData;
    private final ClassDefsSection classDefs;
    private DexOptions dexOptions;
    private int dumpWidth;
    private final FieldIdsSection fieldIds;
    private int fileSize;
    private final HeaderSection header;
    private final MixedItemSection map;
    private final MethodIdsSection methodIds;
    private final ProtoIdsSection protoIds;
    private final Section[] sections;
    private final MixedItemSection stringData;
    private final StringIdsSection stringIds;
    private final TypeIdsSection typeIds;
    private final MixedItemSection typeLists;
    private final MixedItemSection wordData;

    public DexFile(DexOptions dexOptions) {
        this.dexOptions = dexOptions;
        HeaderSection headerSection = new HeaderSection(this);
        this.header = headerSection;
        MixedItemSection.SortType sortType = MixedItemSection.SortType.NONE;
        MixedItemSection mixedItemSection = new MixedItemSection(null, this, 4, sortType);
        this.typeLists = mixedItemSection;
        MixedItemSection.SortType sortType2 = MixedItemSection.SortType.TYPE;
        MixedItemSection mixedItemSection2 = new MixedItemSection("word_data", this, 4, sortType2);
        this.wordData = mixedItemSection2;
        MixedItemSection mixedItemSection3 = new MixedItemSection("string_data", this, 1, MixedItemSection.SortType.INSTANCE);
        this.stringData = mixedItemSection3;
        MixedItemSection mixedItemSection4 = new MixedItemSection(null, this, 1, sortType);
        this.classData = mixedItemSection4;
        MixedItemSection mixedItemSection5 = new MixedItemSection("byte_data", this, 1, sortType2);
        this.byteData = mixedItemSection5;
        StringIdsSection stringIdsSection = new StringIdsSection(this);
        this.stringIds = stringIdsSection;
        TypeIdsSection typeIdsSection = new TypeIdsSection(this);
        this.typeIds = typeIdsSection;
        ProtoIdsSection protoIdsSection = new ProtoIdsSection(this);
        this.protoIds = protoIdsSection;
        FieldIdsSection fieldIdsSection = new FieldIdsSection(this);
        this.fieldIds = fieldIdsSection;
        MethodIdsSection methodIdsSection = new MethodIdsSection(this);
        this.methodIds = methodIdsSection;
        ClassDefsSection classDefsSection = new ClassDefsSection(this);
        this.classDefs = classDefsSection;
        MixedItemSection mixedItemSection6 = new MixedItemSection("map", this, 4, sortType);
        this.map = mixedItemSection6;
        this.sections = new Section[]{headerSection, stringIdsSection, typeIdsSection, protoIdsSection, fieldIdsSection, methodIdsSection, classDefsSection, mixedItemSection2, mixedItemSection, mixedItemSection3, mixedItemSection5, mixedItemSection4, mixedItemSection6};
        this.fileSize = -1;
        this.dumpWidth = 79;
    }

    private static void calcChecksum(byte[] bArr) {
        Adler32 adler32 = new Adler32();
        adler32.update(bArr, 12, bArr.length - 12);
        int value = (int) adler32.getValue();
        bArr[8] = (byte) value;
        bArr[9] = (byte) (value >> 8);
        bArr[10] = (byte) (value >> 16);
        bArr[11] = (byte) (value >> 24);
    }

    private static void calcSignature(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
            messageDigest.update(bArr, 32, bArr.length - 32);
            try {
                int digest = messageDigest.digest(bArr, 12, 20);
                if (digest == 20) {
                    return;
                }
                throw new RuntimeException("unexpected digest write: " + digest + " bytes");
            } catch (DigestException e4) {
                throw new RuntimeException(e4);
            }
        } catch (NoSuchAlgorithmException e5) {
            throw new RuntimeException(e5);
        }
    }

    private ByteArrayAnnotatedOutput toDex0(boolean z3, boolean z4) {
        ExceptionWithContext exceptionWithContext;
        this.classDefs.prepare();
        this.classData.prepare();
        this.wordData.prepare();
        this.byteData.prepare();
        this.methodIds.prepare();
        this.fieldIds.prepare();
        this.protoIds.prepare();
        this.typeLists.prepare();
        this.typeIds.prepare();
        this.stringIds.prepare();
        this.stringData.prepare();
        this.header.prepare();
        int length = this.sections.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            Section section = this.sections[i5];
            int fileOffset = section.setFileOffset(i4);
            if (fileOffset >= i4) {
                try {
                    MixedItemSection mixedItemSection = this.map;
                    if (section == mixedItemSection) {
                        MapItem.addMap(this.sections, mixedItemSection);
                        this.map.prepare();
                    }
                    if (section instanceof MixedItemSection) {
                        ((MixedItemSection) section).placeItems();
                    }
                    i4 = section.writeSize() + fileOffset;
                } catch (RuntimeException e4) {
                    throw ExceptionWithContext.withContext(e4, "...while writing section " + i5);
                }
            } else {
                throw new RuntimeException("bogus placement for section " + i5);
            }
        }
        this.fileSize = i4;
        byte[] bArr = new byte[i4];
        ByteArrayAnnotatedOutput byteArrayAnnotatedOutput = new ByteArrayAnnotatedOutput(bArr);
        if (z3) {
            byteArrayAnnotatedOutput.enableAnnotations(this.dumpWidth, z4);
        }
        for (int i6 = 0; i6 < length; i6++) {
            try {
                Section section2 = this.sections[i6];
                int fileOffset2 = section2.getFileOffset() - byteArrayAnnotatedOutput.getCursor();
                if (fileOffset2 >= 0) {
                    byteArrayAnnotatedOutput.writeZeroes(section2.getFileOffset() - byteArrayAnnotatedOutput.getCursor());
                    section2.writeTo(byteArrayAnnotatedOutput);
                } else {
                    throw new ExceptionWithContext("excess write of " + (-fileOffset2));
                }
            } catch (RuntimeException e5) {
                if (e5 instanceof ExceptionWithContext) {
                    exceptionWithContext = (ExceptionWithContext) e5;
                } else {
                    exceptionWithContext = new ExceptionWithContext(e5);
                }
                exceptionWithContext.addContext("...while writing section " + i6);
                throw exceptionWithContext;
            }
        }
        if (byteArrayAnnotatedOutput.getCursor() == this.fileSize) {
            calcSignature(bArr);
            calcChecksum(bArr);
            if (z3) {
                this.wordData.writeIndexAnnotation(byteArrayAnnotatedOutput, ItemType.TYPE_CODE_ITEM, "\nmethod code index:\n\n");
                getStatistics().writeAnnotation(byteArrayAnnotatedOutput);
                byteArrayAnnotatedOutput.finishAnnotating();
            }
            return byteArrayAnnotatedOutput;
        }
        throw new RuntimeException("foreshortened write");
    }

    public void add(ClassDefItem classDefItem) {
        this.classDefs.add(classDefItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IndexedItem findItemOrNull(Constant constant) {
        if (constant instanceof CstString) {
            return this.stringIds.get(constant);
        }
        if (constant instanceof CstType) {
            return this.typeIds.get(constant);
        }
        if (constant instanceof CstBaseMethodRef) {
            return this.methodIds.get(constant);
        }
        if (constant instanceof CstFieldRef) {
            return this.fieldIds.get(constant);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MixedItemSection getByteData() {
        return this.byteData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MixedItemSection getClassData() {
        return this.classData;
    }

    public ClassDefsSection getClassDefs() {
        return this.classDefs;
    }

    public ClassDefItem getClassOrNull(String str) {
        try {
            return (ClassDefItem) this.classDefs.get(new CstType(Type.internClassName(str)));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public DexOptions getDexOptions() {
        return this.dexOptions;
    }

    public FieldIdsSection getFieldIds() {
        return this.fieldIds;
    }

    public int getFileSize() {
        int i4 = this.fileSize;
        if (i4 >= 0) {
            return i4;
        }
        throw new RuntimeException("file size not yet known");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Section getFirstDataSection() {
        return this.wordData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Section getLastDataSection() {
        return this.map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MixedItemSection getMap() {
        return this.map;
    }

    public MethodIdsSection getMethodIds() {
        return this.methodIds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoIdsSection getProtoIds() {
        return this.protoIds;
    }

    public Statistics getStatistics() {
        Statistics statistics = new Statistics();
        for (Section section : this.sections) {
            statistics.addAll(section);
        }
        return statistics;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MixedItemSection getStringData() {
        return this.stringData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringIdsSection getStringIds() {
        return this.stringIds;
    }

    public TypeIdsSection getTypeIds() {
        return this.typeIds;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MixedItemSection getTypeLists() {
        return this.typeLists;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MixedItemSection getWordData() {
        return this.wordData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void internIfAppropriate(Constant constant) {
        if (constant instanceof CstString) {
            this.stringIds.intern((CstString) constant);
        } else if (constant instanceof CstType) {
            this.typeIds.intern((CstType) constant);
        } else if (constant instanceof CstBaseMethodRef) {
            this.methodIds.intern((CstBaseMethodRef) constant);
        } else if (constant instanceof CstFieldRef) {
            this.fieldIds.intern((CstFieldRef) constant);
        } else if (constant instanceof CstEnumRef) {
            this.fieldIds.intern(((CstEnumRef) constant).getFieldRef());
        } else if (constant != null) {
        } else {
            throw new NullPointerException("cst == null");
        }
    }

    public boolean isEmpty() {
        return this.classDefs.items().isEmpty();
    }

    public void setDumpWidth(int i4) {
        if (i4 >= 40) {
            this.dumpWidth = i4;
            return;
        }
        throw new IllegalArgumentException("dumpWidth < 40");
    }

    public byte[] toDex(Writer writer, boolean z3) throws IOException {
        boolean z4;
        if (writer != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        ByteArrayAnnotatedOutput dex0 = toDex0(z4, z3);
        if (z4) {
            dex0.writeAnnotationsTo(writer);
        }
        return dex0.getArray();
    }

    public void writeTo(OutputStream outputStream, Writer writer, boolean z3) throws IOException {
        boolean z4;
        if (writer != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        ByteArrayAnnotatedOutput dex0 = toDex0(z4, z3);
        if (outputStream != null) {
            outputStream.write(dex0.getArray());
        }
        if (z4) {
            dex0.writeAnnotationsTo(writer);
        }
    }
}
