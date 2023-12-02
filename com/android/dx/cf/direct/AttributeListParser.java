package com.android.dx.cf.direct;

import com.android.dx.cf.iface.Attribute;
import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.cf.iface.StdAttributeList;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AttributeListParser {
    private final AttributeFactory attributeFactory;
    private final DirectClassFile cf;
    private final int context;
    private int endOffset;
    private final StdAttributeList list;
    private ParseObserver observer;
    private final int offset;

    public AttributeListParser(DirectClassFile directClassFile, int i4, int i5, AttributeFactory attributeFactory) {
        if (directClassFile != null) {
            if (attributeFactory != null) {
                int unsignedShort = directClassFile.getBytes().getUnsignedShort(i5);
                this.cf = directClassFile;
                this.context = i4;
                this.offset = i5;
                this.attributeFactory = attributeFactory;
                this.list = new StdAttributeList(unsignedShort);
                this.endOffset = -1;
                return;
            }
            throw new NullPointerException("attributeFactory == null");
        }
        throw new NullPointerException("cf == null");
    }

    private void parse() {
        int size = this.list.size();
        int i4 = this.offset + 2;
        ByteArray bytes = this.cf.getBytes();
        ParseObserver parseObserver = this.observer;
        if (parseObserver != null) {
            int i5 = this.offset;
            parseObserver.parsed(bytes, i5, 2, "attributes_count: " + Hex.u2(size));
        }
        for (int i6 = 0; i6 < size; i6++) {
            try {
                ParseObserver parseObserver2 = this.observer;
                if (parseObserver2 != null) {
                    parseObserver2.parsed(bytes, i4, 0, "\nattributes[" + i6 + "]:\n");
                    this.observer.changeIndent(1);
                }
                Attribute parse = this.attributeFactory.parse(this.cf, this.context, i4, this.observer);
                i4 += parse.byteLength();
                this.list.set(i6, parse);
                ParseObserver parseObserver3 = this.observer;
                if (parseObserver3 != null) {
                    parseObserver3.changeIndent(-1);
                    ParseObserver parseObserver4 = this.observer;
                    parseObserver4.parsed(bytes, i4, 0, "end attributes[" + i6 + "]\n");
                }
            } catch (ParseException e4) {
                e4.addContext("...while parsing attributes[" + i6 + "]");
                throw e4;
            } catch (RuntimeException e5) {
                ParseException parseException = new ParseException(e5);
                parseException.addContext("...while parsing attributes[" + i6 + "]");
                throw parseException;
            }
        }
        this.endOffset = i4;
    }

    private void parseIfNecessary() {
        if (this.endOffset < 0) {
            parse();
        }
    }

    public int getEndOffset() {
        parseIfNecessary();
        return this.endOffset;
    }

    public StdAttributeList getList() {
        parseIfNecessary();
        return this.list;
    }

    public void setObserver(ParseObserver parseObserver) {
        this.observer = parseObserver;
    }
}
