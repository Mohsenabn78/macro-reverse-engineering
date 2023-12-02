package com.android.dx.cf.cst;

import com.android.dx.cf.iface.ParseException;
import com.android.dx.cf.iface.ParseObserver;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstInterfaceMethodRef;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.cst.CstNat;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.StdConstantPool;
import com.android.dx.rop.type.Type;
import com.android.dx.util.ByteArray;
import com.android.dx.util.Hex;
import java.util.BitSet;

/* loaded from: classes2.dex */
public final class ConstantPoolParser {
    private final ByteArray bytes;
    private int endOffset;
    private ParseObserver observer;
    private final int[] offsets;
    private final StdConstantPool pool;

    public ConstantPoolParser(ByteArray byteArray) {
        int unsignedShort = byteArray.getUnsignedShort(8);
        this.bytes = byteArray;
        this.pool = new StdConstantPool(unsignedShort);
        this.offsets = new int[unsignedShort];
        this.endOffset = -1;
    }

    private void determineOffsets() {
        int i4;
        int i5 = 10;
        int i6 = 1;
        while (true) {
            int[] iArr = this.offsets;
            if (i6 < iArr.length) {
                iArr[i6] = i5;
                int unsignedByte = this.bytes.getUnsignedByte(i5);
                switch (unsignedByte) {
                    case 1:
                        i5 += this.bytes.getUnsignedShort(i5 + 1) + 3;
                        break;
                    case 2:
                    case 13:
                    case 14:
                    case 17:
                    default:
                        throw new ParseException("unknown tag byte: " + Hex.u1(unsignedByte));
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                        i5 += 5;
                        break;
                    case 5:
                    case 6:
                        i5 += 9;
                        i4 = 2;
                        continue;
                        i6 += i4;
                    case 7:
                    case 8:
                        try {
                            i5 += 3;
                            break;
                        } catch (ParseException e4) {
                            e4.addContext("...while preparsing cst " + Hex.u2(i6) + " at offset " + Hex.u4(i5));
                            throw e4;
                        }
                    case 15:
                        throw new ParseException("MethodHandle not supported");
                    case 16:
                        throw new ParseException("MethodType not supported");
                    case 18:
                        throw new ParseException("InvokeDynamic not supported");
                }
                i4 = 1;
                i6 += i4;
            } else {
                this.endOffset = i5;
                return;
            }
        }
    }

    private void parse() {
        Constant orNull;
        String str;
        determineOffsets();
        ParseObserver parseObserver = this.observer;
        if (parseObserver != null) {
            parseObserver.parsed(this.bytes, 8, 2, "constant_pool_count: " + Hex.u2(this.offsets.length));
            this.observer.parsed(this.bytes, 10, 0, "\nconstant_pool:");
            this.observer.changeIndent(1);
        }
        BitSet bitSet = new BitSet(this.offsets.length);
        int i4 = 1;
        while (true) {
            int[] iArr = this.offsets;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] != 0 && this.pool.getOrNull(i4) == null) {
                parse0(i4, bitSet);
            }
            i4++;
        }
        if (this.observer != null) {
            for (int i5 = 1; i5 < this.offsets.length; i5++) {
                if (this.pool.getOrNull(i5) != null) {
                    int i6 = this.offsets[i5];
                    int i7 = this.endOffset;
                    int i8 = i5 + 1;
                    while (true) {
                        int[] iArr2 = this.offsets;
                        if (i8 >= iArr2.length) {
                            break;
                        }
                        int i9 = iArr2[i8];
                        if (i9 != 0) {
                            i7 = i9;
                            break;
                        }
                        i8++;
                    }
                    if (bitSet.get(i5)) {
                        str = Hex.u2(i5) + ": utf8{\"" + orNull.toHuman() + "\"}";
                    } else {
                        str = Hex.u2(i5) + ": " + orNull.toString();
                    }
                    this.observer.parsed(this.bytes, i6, i7 - i6, str);
                }
            }
            this.observer.changeIndent(-1);
            this.observer.parsed(this.bytes, this.endOffset, 0, "end constant_pool");
        }
    }

    private Constant parse0(int i4, BitSet bitSet) {
        Constant parseUtf8;
        Constant orNull = this.pool.getOrNull(i4);
        if (orNull != null) {
            return orNull;
        }
        int i5 = this.offsets[i4];
        try {
            int unsignedByte = this.bytes.getUnsignedByte(i5);
            switch (unsignedByte) {
                case 1:
                    parseUtf8 = parseUtf8(i5);
                    bitSet.set(i4);
                    break;
                case 2:
                case 13:
                case 14:
                case 17:
                default:
                    throw new ParseException("unknown tag byte: " + Hex.u1(unsignedByte));
                case 3:
                    parseUtf8 = CstInteger.make(this.bytes.getInt(i5 + 1));
                    break;
                case 4:
                    parseUtf8 = CstFloat.make(this.bytes.getInt(i5 + 1));
                    break;
                case 5:
                    parseUtf8 = CstLong.make(this.bytes.getLong(i5 + 1));
                    break;
                case 6:
                    parseUtf8 = CstDouble.make(this.bytes.getLong(i5 + 1));
                    break;
                case 7:
                    parseUtf8 = new CstType(Type.internClassName(((CstString) parse0(this.bytes.getUnsignedShort(i5 + 1), bitSet)).getString()));
                    break;
                case 8:
                    parseUtf8 = parse0(this.bytes.getUnsignedShort(i5 + 1), bitSet);
                    break;
                case 9:
                    parseUtf8 = new CstFieldRef((CstType) parse0(this.bytes.getUnsignedShort(i5 + 1), bitSet), (CstNat) parse0(this.bytes.getUnsignedShort(i5 + 3), bitSet));
                    break;
                case 10:
                    parseUtf8 = new CstMethodRef((CstType) parse0(this.bytes.getUnsignedShort(i5 + 1), bitSet), (CstNat) parse0(this.bytes.getUnsignedShort(i5 + 3), bitSet));
                    break;
                case 11:
                    parseUtf8 = new CstInterfaceMethodRef((CstType) parse0(this.bytes.getUnsignedShort(i5 + 1), bitSet), (CstNat) parse0(this.bytes.getUnsignedShort(i5 + 3), bitSet));
                    break;
                case 12:
                    parseUtf8 = new CstNat((CstString) parse0(this.bytes.getUnsignedShort(i5 + 1), bitSet), (CstString) parse0(this.bytes.getUnsignedShort(i5 + 3), bitSet));
                    break;
                case 15:
                    throw new ParseException("MethodHandle not supported");
                case 16:
                    throw new ParseException("MethodType not supported");
                case 18:
                    throw new ParseException("InvokeDynamic not supported");
            }
            this.pool.set(i4, parseUtf8);
            return parseUtf8;
        } catch (ParseException e4) {
            e4.addContext("...while parsing cst " + Hex.u2(i4) + " at offset " + Hex.u4(i5));
            throw e4;
        } catch (RuntimeException e5) {
            ParseException parseException = new ParseException(e5);
            parseException.addContext("...while parsing cst " + Hex.u2(i4) + " at offset " + Hex.u4(i5));
            throw parseException;
        }
    }

    private void parseIfNecessary() {
        if (this.endOffset < 0) {
            parse();
        }
    }

    private CstString parseUtf8(int i4) {
        int unsignedShort = this.bytes.getUnsignedShort(i4 + 1);
        int i5 = i4 + 3;
        try {
            return new CstString(this.bytes.slice(i5, unsignedShort + i5));
        } catch (IllegalArgumentException e4) {
            throw new ParseException(e4);
        }
    }

    public int getEndOffset() {
        parseIfNecessary();
        return this.endOffset;
    }

    public StdConstantPool getPool() {
        parseIfNecessary();
        return this.pool;
    }

    public void setObserver(ParseObserver parseObserver) {
        this.observer = parseObserver;
    }
}
