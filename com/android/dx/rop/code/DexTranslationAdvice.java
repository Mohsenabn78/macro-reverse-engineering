package com.android.dx.rop.code;

import com.android.dx.rop.cst.CstInteger;
import com.android.dx.rop.type.Type;

/* loaded from: classes2.dex */
public final class DexTranslationAdvice implements TranslationAdvice {
    private static final int MIN_INVOKE_IN_ORDER = 6;
    private final boolean disableSourcesInOrder;
    public static final DexTranslationAdvice THE_ONE = new DexTranslationAdvice();
    public static final DexTranslationAdvice NO_SOURCES_IN_ORDER = new DexTranslationAdvice(true);

    private DexTranslationAdvice() {
        this.disableSourcesInOrder = false;
    }

    private int totalRopWidth(RegisterSpecList registerSpecList) {
        int size = registerSpecList.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            i4 += registerSpecList.get(i5).getCategory();
        }
        return i4;
    }

    @Override // com.android.dx.rop.code.TranslationAdvice
    public int getMaxOptimalRegisterCount() {
        return 16;
    }

    @Override // com.android.dx.rop.code.TranslationAdvice
    public boolean hasConstantOperation(Rop rop, RegisterSpec registerSpec, RegisterSpec registerSpec2) {
        if (registerSpec.getType() != Type.INT) {
            return false;
        }
        if (!(registerSpec2.getTypeBearer() instanceof CstInteger)) {
            if (!(registerSpec.getTypeBearer() instanceof CstInteger) || rop.getOpcode() != 15) {
                return false;
            }
            return ((CstInteger) registerSpec.getTypeBearer()).fitsIn16Bits();
        }
        CstInteger cstInteger = (CstInteger) registerSpec2.getTypeBearer();
        switch (rop.getOpcode()) {
            case 14:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
                return cstInteger.fitsIn16Bits();
            case 15:
                return CstInteger.make(-cstInteger.getValue()).fitsIn16Bits();
            case 19:
            default:
                return false;
            case 23:
            case 24:
            case 25:
                return cstInteger.fitsIn8Bits();
        }
    }

    @Override // com.android.dx.rop.code.TranslationAdvice
    public boolean requiresSourcesInOrder(Rop rop, RegisterSpecList registerSpecList) {
        if (!this.disableSourcesInOrder && rop.isCallLike() && totalRopWidth(registerSpecList) >= 6) {
            return true;
        }
        return false;
    }

    private DexTranslationAdvice(boolean z3) {
        this.disableSourcesInOrder = z3;
    }
}
