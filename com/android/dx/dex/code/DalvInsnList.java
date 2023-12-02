package com.android.dx.dex.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstBaseMethodRef;
import com.android.dx.util.AnnotatedOutput;
import com.android.dx.util.FixedSizeList;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class DalvInsnList extends FixedSizeList {
    private final int regCount;

    public DalvInsnList(int i4, int i5) {
        super(i4);
        this.regCount = i5;
    }

    public static DalvInsnList makeImmutable(ArrayList<DalvInsn> arrayList, int i4) {
        int size = arrayList.size();
        DalvInsnList dalvInsnList = new DalvInsnList(size, i4);
        for (int i5 = 0; i5 < size; i5++) {
            dalvInsnList.set(i5, arrayList.get(i5));
        }
        dalvInsnList.setImmutable();
        return dalvInsnList;
    }

    public int codeSize() {
        int size = size();
        if (size == 0) {
            return 0;
        }
        return get(size - 1).getNextAddress();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[Catch: IOException -> 0x0030, TryCatch #0 {IOException -> 0x0030, blocks: (B:4:0x000d, B:11:0x0026, B:12:0x0029, B:9:0x001e, B:13:0x002c), top: B:18:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0029 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void debugPrint(java.io.Writer r5, java.lang.String r6, boolean r7) {
        /*
            r4 = this;
            com.android.dx.util.IndentingWriter r0 = new com.android.dx.util.IndentingWriter
            r1 = 0
            r0.<init>(r5, r1, r6)
            int r5 = r4.size()
            r6 = 0
        Lb:
            if (r6 >= r5) goto L2c
            java.lang.Object r2 = r4.get0(r6)     // Catch: java.io.IOException -> L30
            com.android.dx.dex.code.DalvInsn r2 = (com.android.dx.dex.code.DalvInsn) r2     // Catch: java.io.IOException -> L30
            int r3 = r2.codeSize()     // Catch: java.io.IOException -> L30
            if (r3 != 0) goto L1e
            if (r7 == 0) goto L1c
            goto L1e
        L1c:
            r2 = 0
            goto L24
        L1e:
            java.lang.String r3 = ""
            java.lang.String r2 = r2.listingString(r3, r1, r7)     // Catch: java.io.IOException -> L30
        L24:
            if (r2 == 0) goto L29
            r0.write(r2)     // Catch: java.io.IOException -> L30
        L29:
            int r6 = r6 + 1
            goto Lb
        L2c:
            r0.flush()     // Catch: java.io.IOException -> L30
            return
        L30:
            r5 = move-exception
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.dex.code.DalvInsnList.debugPrint(java.io.Writer, java.lang.String, boolean):void");
    }

    public DalvInsn get(int i4) {
        return (DalvInsn) get0(i4);
    }

    public int getOutsSize() {
        boolean z3;
        int size = size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            DalvInsn dalvInsn = (DalvInsn) get0(i5);
            if (dalvInsn instanceof CstInsn) {
                Constant constant = ((CstInsn) dalvInsn).getConstant();
                if (constant instanceof CstBaseMethodRef) {
                    if (dalvInsn.getOpcode().getFamily() == 113) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    int parameterWordCount = ((CstBaseMethodRef) constant).getParameterWordCount(z3);
                    if (parameterWordCount > i4) {
                        i4 = parameterWordCount;
                    }
                }
            }
        }
        return i4;
    }

    public int getRegistersSize() {
        return this.regCount;
    }

    public void set(int i4, DalvInsn dalvInsn) {
        set0(i4, dalvInsn);
    }

    public void writeTo(AnnotatedOutput annotatedOutput) {
        String listingString;
        int cursor = annotatedOutput.getCursor();
        int size = size();
        if (annotatedOutput.annotates()) {
            boolean isVerbose = annotatedOutput.isVerbose();
            for (int i4 = 0; i4 < size; i4++) {
                DalvInsn dalvInsn = (DalvInsn) get0(i4);
                int codeSize = dalvInsn.codeSize() * 2;
                if (codeSize == 0 && !isVerbose) {
                    listingString = null;
                } else {
                    listingString = dalvInsn.listingString("  ", annotatedOutput.getAnnotationWidth(), true);
                }
                if (listingString != null) {
                    annotatedOutput.annotate(codeSize, listingString);
                } else if (codeSize != 0) {
                    annotatedOutput.annotate(codeSize, "");
                }
            }
        }
        for (int i5 = 0; i5 < size; i5++) {
            DalvInsn dalvInsn2 = (DalvInsn) get0(i5);
            try {
                dalvInsn2.writeTo(annotatedOutput);
            } catch (RuntimeException e4) {
                throw ExceptionWithContext.withContext(e4, "...while writing " + dalvInsn2);
            }
        }
        int cursor2 = (annotatedOutput.getCursor() - cursor) / 2;
        if (cursor2 == codeSize()) {
            return;
        }
        throw new RuntimeException("write length mismatch; expected " + codeSize() + " but actually wrote " + cursor2);
    }

    public void debugPrint(OutputStream outputStream, String str, boolean z3) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        debugPrint(outputStreamWriter, str, z3);
        try {
            outputStreamWriter.flush();
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }
}
