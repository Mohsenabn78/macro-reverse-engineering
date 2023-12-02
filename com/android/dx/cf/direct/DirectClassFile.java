package com.android.dx.cf.direct;

import com.android.dx.cf.attrib.AttSourceFile;
import com.android.dx.cf.cst.ConstantPoolParser;
import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.ClassFile;
import com.android.dx.cf.iface.FieldList;
import com.android.dx.cf.iface.MethodList;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.rop.code.AccessFlags;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.StdConstantPool;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeList;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import net.bytebuddy.dynamic.ClassFileLocator;

/* loaded from: classes2.dex */
public class DirectClassFile implements ClassFile {
    private static final int CLASS_FILE_MAGIC = -889275714;
    private static final int CLASS_FILE_MAX_MAJOR_VERSION = 51;
    private static final int CLASS_FILE_MAX_MINOR_VERSION = 0;
    private static final int CLASS_FILE_MIN_MAJOR_VERSION = 45;
    private int accessFlags;
    private AttributeFactory attributeFactory;
    private StdAttributeList attributes;
    private final ByteArray bytes;
    private FieldList fields;
    private final String filePath;
    private TypeList interfaces;
    private MethodList methods;
    private ParseObserver observer;
    private StdConstantPool pool;
    private final boolean strictParse;
    private CstType superClass;
    private CstType thisClass;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class DcfTypeList implements TypeList {
        private final ByteArray bytes;
        private final StdConstantPool pool;
        private final int size;

        public DcfTypeList(ByteArray byteArray, int i4, int i5, StdConstantPool stdConstantPool, ParseObserver parseObserver) {
            if (i5 >= 0) {
                ByteArray slice = byteArray.slice(i4, (i5 * 2) + i4);
                this.bytes = slice;
                this.size = i5;
                this.pool = stdConstantPool;
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = i6 * 2;
                    try {
                        CstType cstType = (CstType) stdConstantPool.get(slice.getUnsignedShort(i7));
                        if (parseObserver != null) {
                            parseObserver.parsed(slice, i7, 2, "  " + cstType);
                        }
                    } catch (ClassCastException e4) {
                        throw new RuntimeException("bogus class cpi", e4);
                    }
                }
                return;
            }
            throw new IllegalArgumentException("size < 0");
        }

        @Override // com.android.dx.rop.type.TypeList
        public Type getType(int i4) {
            return ((CstType) this.pool.get(this.bytes.getUnsignedShort(i4 * 2))).getClassType();
        }

        @Override // com.android.dx.rop.type.TypeList
        public int getWordCount() {
            return this.size;
        }

        @Override // com.android.dx.rop.type.TypeList
        public boolean isMutable() {
            return false;
        }

        @Override // com.android.dx.rop.type.TypeList
        public int size() {
            return this.size;
        }

        @Override // com.android.dx.rop.type.TypeList
        public TypeList withAddedType(Type type) {
            throw new UnsupportedOperationException("unsupported");
        }
    }

    public DirectClassFile(ByteArray byteArray, String str, boolean z3) {
        if (byteArray == null) {
            throw new NullPointerException("bytes == null");
        }
        if (str != null) {
            this.filePath = str;
            this.bytes = byteArray;
            this.strictParse = z3;
            this.accessFlags = -1;
            return;
        }
        throw new NullPointerException("filePath == null");
    }

    private boolean isGoodMagic(int i4) {
        if (i4 == CLASS_FILE_MAGIC) {
            return true;
        }
        return false;
    }

    private boolean isGoodVersion(int i4, int i5) {
        if (i4 >= 0) {
            if (i5 == 51) {
                if (i4 <= 0) {
                    return true;
                }
                return false;
            } else if (i5 < 51 && i5 >= 45) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private void parse() {
        try {
            parse0();
        } catch (ParseException e4) {
            e4.addContext("...while parsing " + this.filePath);
            throw e4;
        } catch (RuntimeException e5) {
            ParseException parseException = new ParseException(e5);
            parseException.addContext("...while parsing " + this.filePath);
            throw parseException;
        }
    }

    private void parse0() {
        if (this.bytes.size() >= 10) {
            ParseObserver parseObserver = this.observer;
            if (parseObserver != null) {
                parseObserver.parsed(this.bytes, 0, 0, "begin classfile");
                ParseObserver parseObserver2 = this.observer;
                ByteArray byteArray = this.bytes;
                parseObserver2.parsed(byteArray, 0, 4, "magic: " + Hex.u4(getMagic0()));
                ParseObserver parseObserver3 = this.observer;
                ByteArray byteArray2 = this.bytes;
                parseObserver3.parsed(byteArray2, 4, 2, "minor_version: " + Hex.u2(getMinorVersion0()));
                ParseObserver parseObserver4 = this.observer;
                ByteArray byteArray3 = this.bytes;
                parseObserver4.parsed(byteArray3, 6, 2, "major_version: " + Hex.u2(getMajorVersion0()));
            }
            if (this.strictParse) {
                if (isGoodMagic(getMagic0())) {
                    if (!isGoodVersion(getMinorVersion0(), getMajorVersion0())) {
                        throw new ParseException("unsupported class file version " + getMajorVersion0() + "." + getMinorVersion0());
                    }
                } else {
                    throw new ParseException("bad class file magic (" + Hex.u4(getMagic0()) + ")");
                }
            }
            ConstantPoolParser constantPoolParser = new ConstantPoolParser(this.bytes);
            constantPoolParser.setObserver(this.observer);
            StdConstantPool pool = constantPoolParser.getPool();
            this.pool = pool;
            pool.setImmutable();
            int endOffset = constantPoolParser.getEndOffset();
            int unsignedShort = this.bytes.getUnsignedShort(endOffset);
            int i4 = endOffset + 2;
            this.thisClass = (CstType) this.pool.get(this.bytes.getUnsignedShort(i4));
            int i5 = endOffset + 4;
            this.superClass = (CstType) this.pool.get0Ok(this.bytes.getUnsignedShort(i5));
            int i6 = endOffset + 6;
            int unsignedShort2 = this.bytes.getUnsignedShort(i6);
            ParseObserver parseObserver5 = this.observer;
            if (parseObserver5 != null) {
                ByteArray byteArray4 = this.bytes;
                parseObserver5.parsed(byteArray4, endOffset, 2, "access_flags: " + AccessFlags.classString(unsignedShort));
                ParseObserver parseObserver6 = this.observer;
                ByteArray byteArray5 = this.bytes;
                parseObserver6.parsed(byteArray5, i4, 2, "this_class: " + this.thisClass);
                ParseObserver parseObserver7 = this.observer;
                ByteArray byteArray6 = this.bytes;
                parseObserver7.parsed(byteArray6, i5, 2, "super_class: " + stringOrNone(this.superClass));
                ParseObserver parseObserver8 = this.observer;
                ByteArray byteArray7 = this.bytes;
                parseObserver8.parsed(byteArray7, i6, 2, "interfaces_count: " + Hex.u2(unsignedShort2));
                if (unsignedShort2 != 0) {
                    this.observer.parsed(this.bytes, endOffset + 8, 0, "interfaces:");
                }
            }
            int i7 = endOffset + 8;
            this.interfaces = makeTypeList(i7, unsignedShort2);
            int i8 = i7 + (unsignedShort2 * 2);
            if (this.strictParse) {
                String className = this.thisClass.getClassType().getClassName();
                if (!this.filePath.endsWith(ClassFileLocator.CLASS_FILE_EXTENSION) || !this.filePath.startsWith(className) || this.filePath.length() != className.length() + 6) {
                    throw new ParseException("class name (" + className + ") does not match path (" + this.filePath + ")");
                }
            }
            this.accessFlags = unsignedShort;
            FieldListParser fieldListParser = new FieldListParser(this, this.thisClass, i8, this.attributeFactory);
            fieldListParser.setObserver(this.observer);
            this.fields = fieldListParser.getList();
            MethodListParser methodListParser = new MethodListParser(this, this.thisClass, fieldListParser.getEndOffset(), this.attributeFactory);
            methodListParser.setObserver(this.observer);
            this.methods = methodListParser.getList();
            AttributeListParser attributeListParser = new AttributeListParser(this, 0, methodListParser.getEndOffset(), this.attributeFactory);
            attributeListParser.setObserver(this.observer);
            StdAttributeList list = attributeListParser.getList();
            this.attributes = list;
            list.setImmutable();
            int endOffset2 = attributeListParser.getEndOffset();
            if (endOffset2 == this.bytes.size()) {
                ParseObserver parseObserver9 = this.observer;
                if (parseObserver9 != null) {
                    parseObserver9.parsed(this.bytes, endOffset2, 0, "end classfile");
                    return;
                }
                return;
            }
            throw new ParseException("extra bytes at end of class file, at offset " + Hex.u4(endOffset2));
        }
        throw new ParseException("severely truncated class file");
    }

    private void parseToEndIfNecessary() {
        if (this.attributes == null) {
            parse();
        }
    }

    private void parseToInterfacesIfNecessary() {
        if (this.accessFlags == -1) {
            parse();
        }
    }

    public static String stringOrNone(Object obj) {
        if (obj == null) {
            return "(none)";
        }
        return obj.toString();
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public int getAccessFlags() {
        parseToInterfacesIfNecessary();
        return this.accessFlags;
    }

    @Override // com.android.dx.cf.iface.ClassFile, com.android.dx.cf.iface.HasAttribute
    public AttributeList getAttributes() {
        parseToEndIfNecessary();
        return this.attributes;
    }

    public ByteArray getBytes() {
        return this.bytes;
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public ConstantPool getConstantPool() {
        parseToInterfacesIfNecessary();
        return this.pool;
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public FieldList getFields() {
        parseToEndIfNecessary();
        return this.fields;
    }

    public String getFilePath() {
        return this.filePath;
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public TypeList getInterfaces() {
        parseToInterfacesIfNecessary();
        return this.interfaces;
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public int getMagic() {
        parseToInterfacesIfNecessary();
        return getMagic0();
    }

    public int getMagic0() {
        return this.bytes.getInt(0);
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public int getMajorVersion() {
        parseToInterfacesIfNecessary();
        return getMajorVersion0();
    }

    public int getMajorVersion0() {
        return this.bytes.getUnsignedShort(6);
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public MethodList getMethods() {
        parseToEndIfNecessary();
        return this.methods;
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public int getMinorVersion() {
        parseToInterfacesIfNecessary();
        return getMinorVersion0();
    }

    public int getMinorVersion0() {
        return this.bytes.getUnsignedShort(4);
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public CstString getSourceFile() {
        Attribute findFirst = getAttributes().findFirst(AttSourceFile.ATTRIBUTE_NAME);
        if (findFirst instanceof AttSourceFile) {
            return ((AttSourceFile) findFirst).getSourceFile();
        }
        return null;
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public CstType getSuperclass() {
        parseToInterfacesIfNecessary();
        return this.superClass;
    }

    @Override // com.android.dx.cf.iface.ClassFile
    public CstType getThisClass() {
        parseToInterfacesIfNecessary();
        return this.thisClass;
    }

    public TypeList makeTypeList(int i4, int i5) {
        if (i5 == 0) {
            return StdTypeList.EMPTY;
        }
        StdConstantPool stdConstantPool = this.pool;
        if (stdConstantPool != null) {
            return new DcfTypeList(this.bytes, i4, i5, stdConstantPool, this.observer);
        }
        throw new IllegalStateException("pool not yet initialized");
    }

    public void setAttributeFactory(AttributeFactory attributeFactory) {
        if (attributeFactory != null) {
            this.attributeFactory = attributeFactory;
            return;
        }
        throw new NullPointerException("attributeFactory == null");
    }

    public void setObserver(ParseObserver parseObserver) {
        this.observer = parseObserver;
    }

    public DirectClassFile(byte[] bArr, String str, boolean z3) {
        this(new ByteArray(bArr), str, z3);
    }
}
