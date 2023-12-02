package com.android.dx.cf.direct;

import com.android.dx.cf.iface.AttributeList;
import com.android.dx.cf.iface.Member;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.rop.cst.ConstantPool;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class MemberListParser {
    private final AttributeFactory attributeFactory;
    private final DirectClassFile cf;
    private final CstType definer;
    private int endOffset;
    private ParseObserver observer;
    private final int offset;

    public MemberListParser(DirectClassFile directClassFile, CstType cstType, int i4, AttributeFactory attributeFactory) {
        if (directClassFile != null) {
            if (i4 >= 0) {
                if (attributeFactory != null) {
                    this.cf = directClassFile;
                    this.definer = cstType;
                    this.offset = i4;
                    this.attributeFactory = attributeFactory;
                    this.endOffset = -1;
                    return;
                }
                throw new NullPointerException("attributeFactory == null");
            }
            throw new IllegalArgumentException("offset < 0");
        }
        throw new NullPointerException("cf == null");
    }

    private void parse() {
        int i4;
        ConstantPool constantPool;
        int attributeContext = getAttributeContext();
        int count = getCount();
        int i5 = this.offset + 2;
        ByteArray bytes = this.cf.getBytes();
        ConstantPool constantPool2 = this.cf.getConstantPool();
        ParseObserver parseObserver = this.observer;
        if (parseObserver != null) {
            int i6 = this.offset;
            parseObserver.parsed(bytes, i6, 2, humanName() + "s_count: " + Hex.u2(count));
        }
        int i7 = 0;
        while (i7 < count) {
            try {
                int unsignedShort = bytes.getUnsignedShort(i5);
                int i8 = i5 + 2;
                int unsignedShort2 = bytes.getUnsignedShort(i8);
                int i9 = i5 + 4;
                int unsignedShort3 = bytes.getUnsignedShort(i9);
                CstString cstString = (CstString) constantPool2.get(unsignedShort2);
                CstString cstString2 = (CstString) constantPool2.get(unsignedShort3);
                ParseObserver parseObserver2 = this.observer;
                int i10 = count;
                if (parseObserver2 != null) {
                    constantPool = constantPool2;
                    parseObserver2.startParsingMember(bytes, i5, cstString.getString(), cstString2.getString());
                    ParseObserver parseObserver3 = this.observer;
                    parseObserver3.parsed(bytes, i5, 0, "\n" + humanName() + "s[" + i7 + "]:\n");
                    this.observer.changeIndent(1);
                    ParseObserver parseObserver4 = this.observer;
                    StringBuilder sb = new StringBuilder();
                    sb.append("access_flags: ");
                    sb.append(humanAccessFlags(unsignedShort));
                    parseObserver4.parsed(bytes, i5, 2, sb.toString());
                    ParseObserver parseObserver5 = this.observer;
                    parseObserver5.parsed(bytes, i8, 2, "name: " + cstString.toHuman());
                    ParseObserver parseObserver6 = this.observer;
                    parseObserver6.parsed(bytes, i9, 2, "descriptor: " + cstString2.toHuman());
                } else {
                    constantPool = constantPool2;
                }
                AttributeListParser attributeListParser = new AttributeListParser(this.cf, attributeContext, i5 + 6, this.attributeFactory);
                attributeListParser.setObserver(this.observer);
                i5 = attributeListParser.getEndOffset();
                StdAttributeList list = attributeListParser.getList();
                list.setImmutable();
                Member member = set(i7, unsignedShort, new CstNat(cstString, cstString2), list);
                ParseObserver parseObserver7 = this.observer;
                if (parseObserver7 != null) {
                    parseObserver7.changeIndent(-1);
                    ParseObserver parseObserver8 = this.observer;
                    parseObserver8.parsed(bytes, i5, 0, "end " + humanName() + "s[" + i7 + "]\n");
                    i4 = i7;
                    try {
                        this.observer.endParsingMember(bytes, i5, cstString.getString(), cstString2.getString(), member);
                    } catch (ParseException e4) {
                        e = e4;
                        e.addContext("...while parsing " + humanName() + "s[" + i4 + "]");
                        throw e;
                    } catch (RuntimeException e5) {
                        e = e5;
                        ParseException parseException = new ParseException(e);
                        parseException.addContext("...while parsing " + humanName() + "s[" + i4 + "]");
                        throw parseException;
                    }
                } else {
                    i4 = i7;
                }
                i7 = i4 + 1;
                count = i10;
                constantPool2 = constantPool;
            } catch (ParseException e6) {
                e = e6;
                i4 = i7;
            } catch (RuntimeException e7) {
                e = e7;
                i4 = i7;
            }
        }
        this.endOffset = i5;
    }

    protected abstract int getAttributeContext();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getCount() {
        return this.cf.getBytes().getUnsignedShort(this.offset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final CstType getDefiner() {
        return this.definer;
    }

    public int getEndOffset() {
        parseIfNecessary();
        return this.endOffset;
    }

    protected abstract String humanAccessFlags(int i4);

    protected abstract String humanName();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void parseIfNecessary() {
        if (this.endOffset < 0) {
            parse();
        }
    }

    protected abstract Member set(int i4, int i5, CstNat cstNat, AttributeList attributeList);

    public final void setObserver(ParseObserver parseObserver) {
        this.observer = parseObserver;
    }
}
