package com.android.dx.rop.code;

import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;

/* loaded from: classes2.dex */
public final class Exceptions {
    public static final StdTypeList LIST_Error;
    public static final StdTypeList LIST_Error_ArithmeticException;
    public static final StdTypeList LIST_Error_ClassCastException;
    public static final StdTypeList LIST_Error_NegativeArraySizeException;
    public static final StdTypeList LIST_Error_NullPointerException;
    public static final StdTypeList LIST_Error_Null_ArrayIndexOutOfBounds;
    public static final StdTypeList LIST_Error_Null_ArrayIndex_ArrayStore;
    public static final StdTypeList LIST_Error_Null_IllegalMonitorStateException;
    public static final Type TYPE_ArithmeticException;
    public static final Type TYPE_ArrayIndexOutOfBoundsException;
    public static final Type TYPE_ArrayStoreException;
    public static final Type TYPE_ClassCastException;
    public static final Type TYPE_Error;
    public static final Type TYPE_IllegalMonitorStateException;
    public static final Type TYPE_NegativeArraySizeException;
    public static final Type TYPE_NullPointerException;

    static {
        Type intern = Type.intern("Ljava/lang/ArithmeticException;");
        TYPE_ArithmeticException = intern;
        Type intern2 = Type.intern("Ljava/lang/ArrayIndexOutOfBoundsException;");
        TYPE_ArrayIndexOutOfBoundsException = intern2;
        Type intern3 = Type.intern("Ljava/lang/ArrayStoreException;");
        TYPE_ArrayStoreException = intern3;
        Type intern4 = Type.intern("Ljava/lang/ClassCastException;");
        TYPE_ClassCastException = intern4;
        Type intern5 = Type.intern("Ljava/lang/Error;");
        TYPE_Error = intern5;
        Type intern6 = Type.intern("Ljava/lang/IllegalMonitorStateException;");
        TYPE_IllegalMonitorStateException = intern6;
        Type intern7 = Type.intern("Ljava/lang/NegativeArraySizeException;");
        TYPE_NegativeArraySizeException = intern7;
        Type intern8 = Type.intern("Ljava/lang/NullPointerException;");
        TYPE_NullPointerException = intern8;
        LIST_Error = StdTypeList.make(intern5);
        LIST_Error_ArithmeticException = StdTypeList.make(intern5, intern);
        LIST_Error_ClassCastException = StdTypeList.make(intern5, intern4);
        LIST_Error_NegativeArraySizeException = StdTypeList.make(intern5, intern7);
        LIST_Error_NullPointerException = StdTypeList.make(intern5, intern8);
        LIST_Error_Null_ArrayIndexOutOfBounds = StdTypeList.make(intern5, intern8, intern2);
        LIST_Error_Null_ArrayIndex_ArrayStore = StdTypeList.make(intern5, intern8, intern2, intern3);
        LIST_Error_Null_IllegalMonitorStateException = StdTypeList.make(intern5, intern8, intern6);
    }

    private Exceptions() {
    }
}
