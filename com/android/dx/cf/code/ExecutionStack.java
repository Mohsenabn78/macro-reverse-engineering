package com.android.dx.cf.code;

import com.android.dex.util.ExceptionWithContext;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;
import com.android.dx.util.MutabilityControl;

/* loaded from: classes2.dex */
public final class ExecutionStack extends MutabilityControl {
    private final boolean[] local;
    private final TypeBearer[] stack;
    private int stackPtr;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ExecutionStack(int r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L5
            r1 = 1
            goto L6
        L5:
            r1 = 0
        L6:
            r2.<init>(r1)
            com.android.dx.rop.type.TypeBearer[] r1 = new com.android.dx.rop.type.TypeBearer[r3]
            r2.stack = r1
            boolean[] r3 = new boolean[r3]
            r2.local = r3
            r2.stackPtr = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.cf.code.ExecutionStack.<init>(int):void");
    }

    private static String stackElementString(TypeBearer typeBearer) {
        if (typeBearer == null) {
            return "<invalid>";
        }
        return typeBearer.toString();
    }

    private static TypeBearer throwSimException(String str) {
        throw new SimException("stack: " + str);
    }

    public void annotate(ExceptionWithContext exceptionWithContext) {
        String u22;
        int i4 = this.stackPtr - 1;
        for (int i5 = 0; i5 <= i4; i5++) {
            if (i5 == i4) {
                u22 = "top0";
            } else {
                u22 = Hex.u2(i4 - i5);
            }
            exceptionWithContext.addContext("stack[" + u22 + "]: " + stackElementString(this.stack[i5]));
        }
    }

    public void change(int i4, TypeBearer typeBearer) {
        throwIfImmutable();
        try {
            TypeBearer frameType = typeBearer.getFrameType();
            int i5 = (this.stackPtr - i4) - 1;
            TypeBearer typeBearer2 = this.stack[i5];
            if (typeBearer2 == null || typeBearer2.getType().getCategory() != frameType.getType().getCategory()) {
                throwSimException("incompatible substitution: " + stackElementString(typeBearer2) + " -> " + stackElementString(frameType));
            }
            this.stack[i5] = frameType;
        } catch (NullPointerException unused) {
            throw new NullPointerException("type == null");
        }
    }

    public void clear() {
        throwIfImmutable();
        for (int i4 = 0; i4 < this.stackPtr; i4++) {
            this.stack[i4] = null;
            this.local[i4] = false;
        }
        this.stackPtr = 0;
    }

    public ExecutionStack copy() {
        ExecutionStack executionStack = new ExecutionStack(this.stack.length);
        TypeBearer[] typeBearerArr = this.stack;
        System.arraycopy(typeBearerArr, 0, executionStack.stack, 0, typeBearerArr.length);
        boolean[] zArr = this.local;
        System.arraycopy(zArr, 0, executionStack.local, 0, zArr.length);
        executionStack.stackPtr = this.stackPtr;
        return executionStack;
    }

    public int getMaxStack() {
        return this.stack.length;
    }

    public void makeInitialized(Type type) {
        if (this.stackPtr == 0) {
            return;
        }
        throwIfImmutable();
        Type initializedType = type.getInitializedType();
        for (int i4 = 0; i4 < this.stackPtr; i4++) {
            TypeBearer[] typeBearerArr = this.stack;
            if (typeBearerArr[i4] == type) {
                typeBearerArr[i4] = initializedType;
            }
        }
    }

    public ExecutionStack merge(ExecutionStack executionStack) {
        try {
            return Merger.mergeStack(this, executionStack);
        } catch (SimException e4) {
            e4.addContext("underlay stack:");
            annotate(e4);
            e4.addContext("overlay stack:");
            executionStack.annotate(e4);
            throw e4;
        }
    }

    public TypeBearer peek(int i4) {
        if (i4 >= 0) {
            int i5 = this.stackPtr;
            if (i4 >= i5) {
                return throwSimException("underflow");
            }
            return this.stack[(i5 - i4) - 1];
        }
        throw new IllegalArgumentException("n < 0");
    }

    public boolean peekLocal(int i4) {
        if (i4 >= 0) {
            int i5 = this.stackPtr;
            if (i4 < i5) {
                return this.local[(i5 - i4) - 1];
            }
            throw new SimException("stack: underflow");
        }
        throw new IllegalArgumentException("n < 0");
    }

    public Type peekType(int i4) {
        return peek(i4).getType();
    }

    public TypeBearer pop() {
        throwIfImmutable();
        TypeBearer peek = peek(0);
        TypeBearer[] typeBearerArr = this.stack;
        int i4 = this.stackPtr;
        typeBearerArr[i4 - 1] = null;
        this.local[i4 - 1] = false;
        this.stackPtr = i4 - peek.getType().getCategory();
        return peek;
    }

    public void push(TypeBearer typeBearer) {
        throwIfImmutable();
        try {
            TypeBearer frameType = typeBearer.getFrameType();
            int category = frameType.getType().getCategory();
            int i4 = this.stackPtr;
            int i5 = i4 + category;
            TypeBearer[] typeBearerArr = this.stack;
            if (i5 > typeBearerArr.length) {
                throwSimException("overflow");
                return;
            }
            if (category == 2) {
                typeBearerArr[i4] = null;
                this.stackPtr = i4 + 1;
            }
            int i6 = this.stackPtr;
            typeBearerArr[i6] = frameType;
            this.stackPtr = i6 + 1;
        } catch (NullPointerException unused) {
            throw new NullPointerException("type == null");
        }
    }

    public void setLocal() {
        throwIfImmutable();
        this.local[this.stackPtr] = true;
    }

    public int size() {
        return this.stackPtr;
    }
}
