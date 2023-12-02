package com.android.dx.cf.direct;

import com.android.dx.cf.attrib.RawAttribute;
import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstString;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;

/* loaded from: classes2.dex */
public class AttributeFactory {
    public static final int CTX_CLASS = 0;
    public static final int CTX_CODE = 3;
    public static final int CTX_COUNT = 4;
    public static final int CTX_FIELD = 1;
    public static final int CTX_METHOD = 2;

    public final Attribute parse(DirectClassFile directClassFile, int i4, int i5, ParseObserver parseObserver) {
        String str;
        if (directClassFile != null) {
            if (i4 >= 0 && i4 < 4) {
                CstString cstString = null;
                try {
                    ByteArray bytes = directClassFile.getBytes();
                    ConstantPool constantPool = directClassFile.getConstantPool();
                    int unsignedShort = bytes.getUnsignedShort(i5);
                    int i6 = i5 + 2;
                    int i7 = bytes.getInt(i6);
                    CstString cstString2 = (CstString) constantPool.get(unsignedShort);
                    if (parseObserver != null) {
                        try {
                            parseObserver.parsed(bytes, i5, 2, "name: " + cstString2.toHuman());
                            parseObserver.parsed(bytes, i6, 4, "length: " + Hex.u4(i7));
                        } catch (ParseException e4) {
                            e = e4;
                            cstString = cstString2;
                            StringBuilder sb = new StringBuilder();
                            sb.append("...while parsing ");
                            if (cstString != null) {
                                str = cstString.toHuman() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
                            } else {
                                str = "";
                            }
                            sb.append(str);
                            sb.append("attribute at offset ");
                            sb.append(Hex.u4(i5));
                            e.addContext(sb.toString());
                            throw e;
                        }
                    }
                    return parse0(directClassFile, i4, cstString2.getString(), i5 + 6, i7, parseObserver);
                } catch (ParseException e5) {
                    e = e5;
                }
            } else {
                throw new IllegalArgumentException("bad context");
            }
        } else {
            throw new NullPointerException("cf == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Attribute parse0(DirectClassFile directClassFile, int i4, String str, int i5, int i6, ParseObserver parseObserver) {
        ByteArray bytes = directClassFile.getBytes();
        RawAttribute rawAttribute = new RawAttribute(str, bytes, i5, i6, directClassFile.getConstantPool());
        if (parseObserver != null) {
            parseObserver.parsed(bytes, i5, i6, "attribute data");
        }
        return rawAttribute;
    }
}
