package com.android.dx.rop.cst;

import androidx.core.app.FrameMetricsAggregator;
import com.android.dx.rop.type.Type;
import com.android.dx.util.Hex;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;

/* loaded from: classes2.dex */
public final class CstInteger extends CstLiteral32 {
    private static final CstInteger[] cache = new CstInteger[FrameMetricsAggregator.EVERY_DURATION];
    public static final CstInteger VALUE_M1 = make(-1);
    public static final CstInteger VALUE_0 = make(0);
    public static final CstInteger VALUE_1 = make(1);
    public static final CstInteger VALUE_2 = make(2);
    public static final CstInteger VALUE_3 = make(3);
    public static final CstInteger VALUE_4 = make(4);
    public static final CstInteger VALUE_5 = make(5);

    private CstInteger(int i4) {
        super(i4);
    }

    public static CstInteger make(int i4) {
        CstInteger[] cstIntegerArr = cache;
        int length = (Integer.MAX_VALUE & i4) % cstIntegerArr.length;
        CstInteger cstInteger = cstIntegerArr[length];
        if (cstInteger != null && cstInteger.getValue() == i4) {
            return cstInteger;
        }
        CstInteger cstInteger2 = new CstInteger(i4);
        cstIntegerArr[length] = cstInteger2;
        return cstInteger2;
    }

    @Override // com.android.dx.rop.type.TypeBearer
    public Type getType() {
        return Type.INT;
    }

    public int getValue() {
        return getIntBits();
    }

    @Override // com.android.dx.util.ToHuman
    public String toHuman() {
        return Integer.toString(getIntBits());
    }

    public String toString() {
        int intBits = getIntBits();
        return "int{0x" + Hex.u4(intBits) + " / " + intBits + '}';
    }

    @Override // com.android.dx.rop.cst.Constant
    public String typeName() {
        return HelperCommandsKt.HELPER_SETTING_VALUE_TYPE_INT;
    }
}
