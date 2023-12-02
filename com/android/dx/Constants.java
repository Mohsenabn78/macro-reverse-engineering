package com.android.dx;

import com.android.dx.rop.cst.CstBoolean;
import com.android.dx.rop.cst.CstByte;
import com.android.dx.rop.cst.CstChar;
import com.android.dx.rop.cst.CstDouble;
import com.android.dx.rop.cst.CstFloat;
import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.cst.CstKnownNull;
import com.android.dx.rop.cst.CstLong;
import com.android.dx.rop.cst.CstShort;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import com.android.dx.rop.cst.TypedConstant;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Constants {
    private Constants() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TypedConstant getConstant(Object obj) {
        if (obj == null) {
            return CstKnownNull.THE_ONE;
        }
        if (obj instanceof Boolean) {
            return CstBoolean.make(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Byte) {
            return CstByte.make(((Byte) obj).byteValue());
        }
        if (obj instanceof Character) {
            return CstChar.make(((Character) obj).charValue());
        }
        if (obj instanceof Double) {
            return CstDouble.make(Double.doubleToLongBits(((Double) obj).doubleValue()));
        }
        if (obj instanceof Float) {
            return CstFloat.make(Float.floatToIntBits(((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return CstInteger.make(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return CstLong.make(((Long) obj).longValue());
        }
        if (obj instanceof Short) {
            return CstShort.make(((Short) obj).shortValue());
        }
        if (obj instanceof String) {
            return new CstString((String) obj);
        }
        if (obj instanceof Class) {
            return new CstType(TypeId.get((Class) obj).ropType);
        }
        if (obj instanceof TypeId) {
            return new CstType(((TypeId) obj).ropType);
        }
        throw new UnsupportedOperationException("Not a constant: " + obj);
    }
}
