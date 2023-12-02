package com.android.dx.cf.code;

import com.android.dx.rop.type.Prototype;

/* loaded from: classes2.dex */
public class ValueAwareMachine extends BaseMachine {
    public ValueAwareMachine(Prototype prototype) {
        super(prototype);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    @Override // com.android.dx.cf.code.Machine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run(com.android.dx.cf.code.Frame r3, int r4, int r5) {
        /*
            r2 = this;
            if (r5 == 0) goto Lf7
            r0 = 20
            if (r5 == r0) goto Led
            r0 = 21
            r1 = 0
            if (r5 == r0) goto Le5
            r0 = 171(0xab, float:2.4E-43)
            if (r5 == r0) goto Lf7
            r0 = 172(0xac, float:2.41E-43)
            if (r5 == r0) goto Lf7
            switch(r5) {
                case 0: goto Lf7;
                case 18: goto Led;
                case 46: goto Ldd;
                case 54: goto Le5;
                case 79: goto Lf7;
                case 100: goto Ldd;
                case 104: goto Ldd;
                case 108: goto Ldd;
                case 112: goto Ldd;
                case 116: goto Ldd;
                case 120: goto Ldd;
                case 122: goto Ldd;
                case 124: goto Ldd;
                case 126: goto Ldd;
                case 128: goto Ldd;
                case 130: goto Ldd;
                default: goto L16;
            }
        L16:
            switch(r5) {
                case 87: goto Lf7;
                case 88: goto Lf7;
                case 89: goto Lc6;
                case 90: goto Lc6;
                case 91: goto Lc6;
                case 92: goto Lc6;
                case 93: goto Lc6;
                case 94: goto Lc6;
                case 95: goto Lc6;
                case 96: goto Ldd;
                default: goto L19;
            }
        L19:
            switch(r5) {
                case 132: goto Ldd;
                case 133: goto Ldd;
                case 134: goto Ldd;
                case 135: goto Ldd;
                case 136: goto Ldd;
                case 137: goto Ldd;
                case 138: goto Ldd;
                case 139: goto Ldd;
                case 140: goto Ldd;
                case 141: goto Ldd;
                case 142: goto Ldd;
                case 143: goto Ldd;
                case 144: goto Ldd;
                case 145: goto Ldd;
                case 146: goto Ldd;
                case 147: goto Ldd;
                case 148: goto Ldd;
                case 149: goto Ldd;
                case 150: goto Ldd;
                case 151: goto Ldd;
                case 152: goto Ldd;
                case 153: goto Lf7;
                case 154: goto Lf7;
                case 155: goto Lf7;
                case 156: goto Lf7;
                case 157: goto Lf7;
                case 158: goto Lf7;
                case 159: goto Lf7;
                case 160: goto Lf7;
                case 161: goto Lf7;
                case 162: goto Lf7;
                case 163: goto Lf7;
                case 164: goto Lf7;
                case 165: goto Lf7;
                case 166: goto Lf7;
                case 167: goto Lf7;
                case 168: goto Lb9;
                case 169: goto Lf7;
                default: goto L1c;
            }
        L1c:
            switch(r5) {
                case 177: goto Lf7;
                case 178: goto La3;
                case 179: goto Lf7;
                case 180: goto La3;
                case 181: goto Lf7;
                case 182: goto La3;
                case 183: goto L7c;
                case 184: goto La3;
                case 185: goto La3;
                default: goto L1f;
            }
        L1f:
            switch(r5) {
                case 187: goto L69;
                case 188: goto L5a;
                case 189: goto L47;
                case 190: goto Ldd;
                case 191: goto Lf7;
                case 192: goto L5a;
                case 193: goto L40;
                case 194: goto Lf7;
                case 195: goto Lf7;
                default: goto L22;
            }
        L22:
            switch(r5) {
                case 197: goto L5a;
                case 198: goto Lf7;
                case 199: goto Lf7;
                default: goto L25;
            }
        L25:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "shouldn't happen: "
            r4.append(r0)
            java.lang.String r5 = com.android.dx.util.Hex.u1(r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L40:
            com.android.dx.rop.type.Type r4 = com.android.dx.rop.type.Type.INT
            r2.setResult(r4)
            goto Lfa
        L47:
            com.android.dx.rop.cst.Constant r4 = r2.getAuxCst()
            com.android.dx.rop.cst.CstType r4 = (com.android.dx.rop.cst.CstType) r4
            com.android.dx.rop.type.Type r4 = r4.getClassType()
            com.android.dx.rop.type.Type r4 = r4.getArrayType()
            r2.setResult(r4)
            goto Lfa
        L5a:
            com.android.dx.rop.cst.Constant r4 = r2.getAuxCst()
            com.android.dx.rop.cst.CstType r4 = (com.android.dx.rop.cst.CstType) r4
            com.android.dx.rop.type.Type r4 = r4.getClassType()
            r2.setResult(r4)
            goto Lfa
        L69:
            com.android.dx.rop.cst.Constant r5 = r2.getAuxCst()
            com.android.dx.rop.cst.CstType r5 = (com.android.dx.rop.cst.CstType) r5
            com.android.dx.rop.type.Type r5 = r5.getClassType()
            com.android.dx.rop.type.Type r4 = r5.asUninitialized(r4)
            r2.setResult(r4)
            goto Lfa
        L7c:
            com.android.dx.rop.type.TypeBearer r4 = r2.arg(r1)
            com.android.dx.rop.type.Type r4 = r4.getType()
            boolean r5 = r4.isUninitialized()
            if (r5 == 0) goto L8d
            r3.makeInitialized(r4)
        L8d:
            com.android.dx.rop.cst.Constant r4 = r2.getAuxCst()
            com.android.dx.rop.type.TypeBearer r4 = (com.android.dx.rop.type.TypeBearer) r4
            com.android.dx.rop.type.Type r4 = r4.getType()
            com.android.dx.rop.type.Type r5 = com.android.dx.rop.type.Type.VOID
            if (r4 != r5) goto L9f
            r2.clearResult()
            goto Lfa
        L9f:
            r2.setResult(r4)
            goto Lfa
        La3:
            com.android.dx.rop.cst.Constant r4 = r2.getAuxCst()
            com.android.dx.rop.type.TypeBearer r4 = (com.android.dx.rop.type.TypeBearer) r4
            com.android.dx.rop.type.Type r4 = r4.getType()
            com.android.dx.rop.type.Type r5 = com.android.dx.rop.type.Type.VOID
            if (r4 != r5) goto Lb5
            r2.clearResult()
            goto Lfa
        Lb5:
            r2.setResult(r4)
            goto Lfa
        Lb9:
            com.android.dx.cf.code.ReturnAddress r4 = new com.android.dx.cf.code.ReturnAddress
            int r5 = r2.getAuxTarget()
            r4.<init>(r5)
            r2.setResult(r4)
            goto Lfa
        Lc6:
            r2.clearResult()
            int r4 = r2.getAuxInt()
        Lcd:
            if (r4 == 0) goto Lfa
            r5 = r4 & 15
            int r5 = r5 + (-1)
            com.android.dx.rop.type.TypeBearer r5 = r2.arg(r5)
            r2.addResult(r5)
            int r4 = r4 >> 4
            goto Lcd
        Ldd:
            com.android.dx.rop.type.Type r4 = r2.getAuxType()
            r2.setResult(r4)
            goto Lfa
        Le5:
            com.android.dx.rop.type.TypeBearer r4 = r2.arg(r1)
            r2.setResult(r4)
            goto Lfa
        Led:
            com.android.dx.rop.cst.Constant r4 = r2.getAuxCst()
            com.android.dx.rop.type.TypeBearer r4 = (com.android.dx.rop.type.TypeBearer) r4
            r2.setResult(r4)
            goto Lfa
        Lf7:
            r2.clearResult()
        Lfa:
            r2.storeResults(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.cf.code.ValueAwareMachine.run(com.android.dx.cf.code.Frame, int, int):void");
    }
}
