package com.android.dx.rop.code;

import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstMethodRef;
import com.android.dx.rop.type.Prototype;
import com.android.dx.rop.type.StdTypeList;
import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.rop.type.TypeList;

/* loaded from: classes2.dex */
public final class Rops {
    public static final Rop ADD_CONST_DOUBLE;
    public static final Rop ADD_CONST_FLOAT;
    public static final Rop ADD_CONST_INT;
    public static final Rop ADD_CONST_LONG;
    public static final Rop ADD_DOUBLE;
    public static final Rop ADD_FLOAT;
    public static final Rop ADD_INT;
    public static final Rop ADD_LONG;
    public static final Rop AGET_BOOLEAN;
    public static final Rop AGET_BYTE;
    public static final Rop AGET_CHAR;
    public static final Rop AGET_DOUBLE;
    public static final Rop AGET_FLOAT;
    public static final Rop AGET_INT;
    public static final Rop AGET_LONG;
    public static final Rop AGET_OBJECT;
    public static final Rop AGET_SHORT;
    public static final Rop AND_CONST_INT;
    public static final Rop AND_CONST_LONG;
    public static final Rop AND_INT;
    public static final Rop AND_LONG;
    public static final Rop APUT_BOOLEAN;
    public static final Rop APUT_BYTE;
    public static final Rop APUT_CHAR;
    public static final Rop APUT_DOUBLE;
    public static final Rop APUT_FLOAT;
    public static final Rop APUT_INT;
    public static final Rop APUT_LONG;
    public static final Rop APUT_OBJECT;
    public static final Rop APUT_SHORT;
    public static final Rop ARRAY_LENGTH;
    public static final Rop CHECK_CAST;
    public static final Rop CMPG_DOUBLE;
    public static final Rop CMPG_FLOAT;
    public static final Rop CMPL_DOUBLE;
    public static final Rop CMPL_FLOAT;
    public static final Rop CMPL_LONG;
    public static final Rop CONST_DOUBLE;
    public static final Rop CONST_FLOAT;
    public static final Rop CONST_INT;
    public static final Rop CONST_LONG;
    public static final Rop CONST_OBJECT;
    public static final Rop CONST_OBJECT_NOTHROW;
    public static final Rop CONV_D2F;
    public static final Rop CONV_D2I;
    public static final Rop CONV_D2L;
    public static final Rop CONV_F2D;
    public static final Rop CONV_F2I;
    public static final Rop CONV_F2L;
    public static final Rop CONV_I2D;
    public static final Rop CONV_I2F;
    public static final Rop CONV_I2L;
    public static final Rop CONV_L2D;
    public static final Rop CONV_L2F;
    public static final Rop CONV_L2I;
    public static final Rop DIV_CONST_DOUBLE;
    public static final Rop DIV_CONST_FLOAT;
    public static final Rop DIV_CONST_INT;
    public static final Rop DIV_CONST_LONG;
    public static final Rop DIV_DOUBLE;
    public static final Rop DIV_FLOAT;
    public static final Rop DIV_INT;
    public static final Rop DIV_LONG;
    public static final Rop FILL_ARRAY_DATA;
    public static final Rop GET_FIELD_BOOLEAN;
    public static final Rop GET_FIELD_BYTE;
    public static final Rop GET_FIELD_CHAR;
    public static final Rop GET_FIELD_DOUBLE;
    public static final Rop GET_FIELD_FLOAT;
    public static final Rop GET_FIELD_INT;
    public static final Rop GET_FIELD_LONG;
    public static final Rop GET_FIELD_OBJECT;
    public static final Rop GET_FIELD_SHORT;
    public static final Rop GET_STATIC_BOOLEAN;
    public static final Rop GET_STATIC_BYTE;
    public static final Rop GET_STATIC_CHAR;
    public static final Rop GET_STATIC_DOUBLE;
    public static final Rop GET_STATIC_FLOAT;
    public static final Rop GET_STATIC_INT;
    public static final Rop GET_STATIC_LONG;
    public static final Rop GET_STATIC_OBJECT;
    public static final Rop GET_STATIC_SHORT;
    public static final Rop GOTO;
    public static final Rop IF_EQZ_INT;
    public static final Rop IF_EQZ_OBJECT;
    public static final Rop IF_EQ_INT;
    public static final Rop IF_EQ_OBJECT;
    public static final Rop IF_GEZ_INT;
    public static final Rop IF_GE_INT;
    public static final Rop IF_GTZ_INT;
    public static final Rop IF_GT_INT;
    public static final Rop IF_LEZ_INT;
    public static final Rop IF_LE_INT;
    public static final Rop IF_LTZ_INT;
    public static final Rop IF_LT_INT;
    public static final Rop IF_NEZ_INT;
    public static final Rop IF_NEZ_OBJECT;
    public static final Rop IF_NE_INT;
    public static final Rop IF_NE_OBJECT;
    public static final Rop INSTANCE_OF;
    public static final Rop MARK_LOCAL_DOUBLE;
    public static final Rop MARK_LOCAL_FLOAT;
    public static final Rop MARK_LOCAL_INT;
    public static final Rop MARK_LOCAL_LONG;
    public static final Rop MARK_LOCAL_OBJECT;
    public static final Rop MONITOR_ENTER;
    public static final Rop MONITOR_EXIT;
    public static final Rop MOVE_DOUBLE;
    public static final Rop MOVE_FLOAT;
    public static final Rop MOVE_INT;
    public static final Rop MOVE_LONG;
    public static final Rop MOVE_OBJECT;
    public static final Rop MOVE_PARAM_DOUBLE;
    public static final Rop MOVE_PARAM_FLOAT;
    public static final Rop MOVE_PARAM_INT;
    public static final Rop MOVE_PARAM_LONG;
    public static final Rop MOVE_PARAM_OBJECT;
    public static final Rop MOVE_RETURN_ADDRESS;
    public static final Rop MUL_CONST_DOUBLE;
    public static final Rop MUL_CONST_FLOAT;
    public static final Rop MUL_CONST_INT;
    public static final Rop MUL_CONST_LONG;
    public static final Rop MUL_DOUBLE;
    public static final Rop MUL_FLOAT;
    public static final Rop MUL_INT;
    public static final Rop MUL_LONG;
    public static final Rop NEG_DOUBLE;
    public static final Rop NEG_FLOAT;
    public static final Rop NEG_INT;
    public static final Rop NEG_LONG;
    public static final Rop NEW_ARRAY_BOOLEAN;
    public static final Rop NEW_ARRAY_BYTE;
    public static final Rop NEW_ARRAY_CHAR;
    public static final Rop NEW_ARRAY_DOUBLE;
    public static final Rop NEW_ARRAY_FLOAT;
    public static final Rop NEW_ARRAY_INT;
    public static final Rop NEW_ARRAY_LONG;
    public static final Rop NEW_ARRAY_SHORT;
    public static final Rop NEW_INSTANCE;
    public static final Rop NOP;
    public static final Rop NOT_INT;
    public static final Rop NOT_LONG;
    public static final Rop OR_CONST_INT;
    public static final Rop OR_CONST_LONG;
    public static final Rop OR_INT;
    public static final Rop OR_LONG;
    public static final Rop PUT_FIELD_BOOLEAN;
    public static final Rop PUT_FIELD_BYTE;
    public static final Rop PUT_FIELD_CHAR;
    public static final Rop PUT_FIELD_DOUBLE;
    public static final Rop PUT_FIELD_FLOAT;
    public static final Rop PUT_FIELD_INT;
    public static final Rop PUT_FIELD_LONG;
    public static final Rop PUT_FIELD_OBJECT;
    public static final Rop PUT_FIELD_SHORT;
    public static final Rop PUT_STATIC_BOOLEAN;
    public static final Rop PUT_STATIC_BYTE;
    public static final Rop PUT_STATIC_CHAR;
    public static final Rop PUT_STATIC_DOUBLE;
    public static final Rop PUT_STATIC_FLOAT;
    public static final Rop PUT_STATIC_INT;
    public static final Rop PUT_STATIC_LONG;
    public static final Rop PUT_STATIC_OBJECT;
    public static final Rop PUT_STATIC_SHORT;
    public static final Rop REM_CONST_DOUBLE;
    public static final Rop REM_CONST_FLOAT;
    public static final Rop REM_CONST_INT;
    public static final Rop REM_CONST_LONG;
    public static final Rop REM_DOUBLE;
    public static final Rop REM_FLOAT;
    public static final Rop REM_INT;
    public static final Rop REM_LONG;
    public static final Rop RETURN_DOUBLE;
    public static final Rop RETURN_FLOAT;
    public static final Rop RETURN_INT;
    public static final Rop RETURN_LONG;
    public static final Rop RETURN_OBJECT;
    public static final Rop RETURN_VOID;
    public static final Rop SHL_CONST_INT;
    public static final Rop SHL_CONST_LONG;
    public static final Rop SHL_INT;
    public static final Rop SHL_LONG;
    public static final Rop SHR_CONST_INT;
    public static final Rop SHR_CONST_LONG;
    public static final Rop SHR_INT;
    public static final Rop SHR_LONG;
    public static final Rop SUB_CONST_DOUBLE;
    public static final Rop SUB_CONST_FLOAT;
    public static final Rop SUB_CONST_INT;
    public static final Rop SUB_CONST_LONG;
    public static final Rop SUB_DOUBLE;
    public static final Rop SUB_FLOAT;
    public static final Rop SUB_INT;
    public static final Rop SUB_LONG;
    public static final Rop SWITCH;
    public static final Rop THROW;
    public static final Rop TO_BYTE;
    public static final Rop TO_CHAR;
    public static final Rop TO_SHORT;
    public static final Rop USHR_CONST_INT;
    public static final Rop USHR_CONST_LONG;
    public static final Rop USHR_INT;
    public static final Rop USHR_LONG;
    public static final Rop XOR_CONST_INT;
    public static final Rop XOR_CONST_LONG;
    public static final Rop XOR_INT;
    public static final Rop XOR_LONG;

    static {
        Type type = Type.VOID;
        StdTypeList stdTypeList = StdTypeList.EMPTY;
        NOP = new Rop(1, type, stdTypeList, "nop");
        Type type2 = Type.INT;
        StdTypeList stdTypeList2 = StdTypeList.INT;
        MOVE_INT = new Rop(2, type2, stdTypeList2, "move-int");
        Type type3 = Type.LONG;
        StdTypeList stdTypeList3 = StdTypeList.LONG;
        MOVE_LONG = new Rop(2, type3, stdTypeList3, "move-long");
        Type type4 = Type.FLOAT;
        StdTypeList stdTypeList4 = StdTypeList.FLOAT;
        MOVE_FLOAT = new Rop(2, type4, stdTypeList4, "move-float");
        Type type5 = Type.DOUBLE;
        StdTypeList stdTypeList5 = StdTypeList.DOUBLE;
        MOVE_DOUBLE = new Rop(2, type5, stdTypeList5, "move-double");
        Type type6 = Type.OBJECT;
        StdTypeList stdTypeList6 = StdTypeList.OBJECT;
        MOVE_OBJECT = new Rop(2, type6, stdTypeList6, "move-object");
        MOVE_RETURN_ADDRESS = new Rop(2, Type.RETURN_ADDRESS, StdTypeList.RETURN_ADDRESS, "move-return-address");
        MOVE_PARAM_INT = new Rop(3, type2, stdTypeList, "move-param-int");
        MOVE_PARAM_LONG = new Rop(3, type3, stdTypeList, "move-param-long");
        MOVE_PARAM_FLOAT = new Rop(3, type4, stdTypeList, "move-param-float");
        MOVE_PARAM_DOUBLE = new Rop(3, type5, stdTypeList, "move-param-double");
        MOVE_PARAM_OBJECT = new Rop(3, type6, stdTypeList, "move-param-object");
        CONST_INT = new Rop(5, type2, stdTypeList, "const-int");
        CONST_LONG = new Rop(5, type3, stdTypeList, "const-long");
        CONST_FLOAT = new Rop(5, type4, stdTypeList, "const-float");
        CONST_DOUBLE = new Rop(5, type5, stdTypeList, "const-double");
        StdTypeList stdTypeList7 = Exceptions.LIST_Error;
        CONST_OBJECT = new Rop(5, type6, stdTypeList, stdTypeList7, "const-object");
        CONST_OBJECT_NOTHROW = new Rop(5, type6, stdTypeList, "const-object-nothrow");
        GOTO = new Rop(6, type, stdTypeList, 3, "goto");
        IF_EQZ_INT = new Rop(7, type, stdTypeList2, 4, "if-eqz-int");
        IF_NEZ_INT = new Rop(8, type, stdTypeList2, 4, "if-nez-int");
        IF_LTZ_INT = new Rop(9, type, stdTypeList2, 4, "if-ltz-int");
        IF_GEZ_INT = new Rop(10, type, stdTypeList2, 4, "if-gez-int");
        IF_LEZ_INT = new Rop(11, type, stdTypeList2, 4, "if-lez-int");
        IF_GTZ_INT = new Rop(12, type, stdTypeList2, 4, "if-gtz-int");
        IF_EQZ_OBJECT = new Rop(7, type, stdTypeList6, 4, "if-eqz-object");
        IF_NEZ_OBJECT = new Rop(8, type, stdTypeList6, 4, "if-nez-object");
        StdTypeList stdTypeList8 = StdTypeList.INT_INT;
        IF_EQ_INT = new Rop(7, type, stdTypeList8, 4, "if-eq-int");
        IF_NE_INT = new Rop(8, type, stdTypeList8, 4, "if-ne-int");
        IF_LT_INT = new Rop(9, type, stdTypeList8, 4, "if-lt-int");
        IF_GE_INT = new Rop(10, type, stdTypeList8, 4, "if-ge-int");
        IF_LE_INT = new Rop(11, type, stdTypeList8, 4, "if-le-int");
        IF_GT_INT = new Rop(12, type, stdTypeList8, 4, "if-gt-int");
        StdTypeList stdTypeList9 = StdTypeList.OBJECT_OBJECT;
        IF_EQ_OBJECT = new Rop(7, type, stdTypeList9, 4, "if-eq-object");
        IF_NE_OBJECT = new Rop(8, type, stdTypeList9, 4, "if-ne-object");
        SWITCH = new Rop(13, type, stdTypeList2, 5, "switch");
        ADD_INT = new Rop(14, type2, stdTypeList8, "add-int");
        StdTypeList stdTypeList10 = StdTypeList.LONG_LONG;
        ADD_LONG = new Rop(14, type3, stdTypeList10, "add-long");
        StdTypeList stdTypeList11 = StdTypeList.FLOAT_FLOAT;
        ADD_FLOAT = new Rop(14, type4, stdTypeList11, "add-float");
        StdTypeList stdTypeList12 = StdTypeList.DOUBLE_DOUBLE;
        ADD_DOUBLE = new Rop(14, type5, stdTypeList12, 1, "add-double");
        SUB_INT = new Rop(15, type2, stdTypeList8, "sub-int");
        SUB_LONG = new Rop(15, type3, stdTypeList10, "sub-long");
        SUB_FLOAT = new Rop(15, type4, stdTypeList11, "sub-float");
        SUB_DOUBLE = new Rop(15, type5, stdTypeList12, 1, "sub-double");
        MUL_INT = new Rop(16, type2, stdTypeList8, "mul-int");
        MUL_LONG = new Rop(16, type3, stdTypeList10, "mul-long");
        MUL_FLOAT = new Rop(16, type4, stdTypeList11, "mul-float");
        MUL_DOUBLE = new Rop(16, type5, stdTypeList12, 1, "mul-double");
        StdTypeList stdTypeList13 = Exceptions.LIST_Error_ArithmeticException;
        DIV_INT = new Rop(17, type2, stdTypeList8, stdTypeList13, "div-int");
        DIV_LONG = new Rop(17, type3, stdTypeList10, stdTypeList13, "div-long");
        DIV_FLOAT = new Rop(17, type4, stdTypeList11, "div-float");
        DIV_DOUBLE = new Rop(17, type5, stdTypeList12, "div-double");
        REM_INT = new Rop(18, type2, stdTypeList8, stdTypeList13, "rem-int");
        REM_LONG = new Rop(18, type3, stdTypeList10, stdTypeList13, "rem-long");
        REM_FLOAT = new Rop(18, type4, stdTypeList11, "rem-float");
        REM_DOUBLE = new Rop(18, type5, stdTypeList12, "rem-double");
        NEG_INT = new Rop(19, type2, stdTypeList2, "neg-int");
        NEG_LONG = new Rop(19, type3, stdTypeList3, "neg-long");
        NEG_FLOAT = new Rop(19, type4, stdTypeList4, "neg-float");
        NEG_DOUBLE = new Rop(19, type5, stdTypeList5, "neg-double");
        AND_INT = new Rop(20, type2, stdTypeList8, "and-int");
        AND_LONG = new Rop(20, type3, stdTypeList10, "and-long");
        OR_INT = new Rop(21, type2, stdTypeList8, "or-int");
        OR_LONG = new Rop(21, type3, stdTypeList10, "or-long");
        XOR_INT = new Rop(22, type2, stdTypeList8, "xor-int");
        XOR_LONG = new Rop(22, type3, stdTypeList10, "xor-long");
        SHL_INT = new Rop(23, type2, stdTypeList8, "shl-int");
        StdTypeList stdTypeList14 = StdTypeList.LONG_INT;
        SHL_LONG = new Rop(23, type3, stdTypeList14, "shl-long");
        SHR_INT = new Rop(24, type2, stdTypeList8, "shr-int");
        SHR_LONG = new Rop(24, type3, stdTypeList14, "shr-long");
        USHR_INT = new Rop(25, type2, stdTypeList8, "ushr-int");
        USHR_LONG = new Rop(25, type3, stdTypeList14, "ushr-long");
        NOT_INT = new Rop(26, type2, stdTypeList2, "not-int");
        NOT_LONG = new Rop(26, type3, stdTypeList3, "not-long");
        ADD_CONST_INT = new Rop(14, type2, stdTypeList2, "add-const-int");
        ADD_CONST_LONG = new Rop(14, type3, stdTypeList3, "add-const-long");
        ADD_CONST_FLOAT = new Rop(14, type4, stdTypeList4, "add-const-float");
        ADD_CONST_DOUBLE = new Rop(14, type5, stdTypeList5, "add-const-double");
        SUB_CONST_INT = new Rop(15, type2, stdTypeList2, "sub-const-int");
        SUB_CONST_LONG = new Rop(15, type3, stdTypeList3, "sub-const-long");
        SUB_CONST_FLOAT = new Rop(15, type4, stdTypeList4, "sub-const-float");
        SUB_CONST_DOUBLE = new Rop(15, type5, stdTypeList5, "sub-const-double");
        MUL_CONST_INT = new Rop(16, type2, stdTypeList2, "mul-const-int");
        MUL_CONST_LONG = new Rop(16, type3, stdTypeList3, "mul-const-long");
        MUL_CONST_FLOAT = new Rop(16, type4, stdTypeList4, "mul-const-float");
        MUL_CONST_DOUBLE = new Rop(16, type5, stdTypeList5, "mul-const-double");
        DIV_CONST_INT = new Rop(17, type2, stdTypeList2, stdTypeList13, "div-const-int");
        DIV_CONST_LONG = new Rop(17, type3, stdTypeList3, stdTypeList13, "div-const-long");
        DIV_CONST_FLOAT = new Rop(17, type4, stdTypeList4, "div-const-float");
        DIV_CONST_DOUBLE = new Rop(17, type5, stdTypeList5, "div-const-double");
        REM_CONST_INT = new Rop(18, type2, stdTypeList2, stdTypeList13, "rem-const-int");
        REM_CONST_LONG = new Rop(18, type3, stdTypeList3, stdTypeList13, "rem-const-long");
        REM_CONST_FLOAT = new Rop(18, type4, stdTypeList4, "rem-const-float");
        REM_CONST_DOUBLE = new Rop(18, type5, stdTypeList5, "rem-const-double");
        AND_CONST_INT = new Rop(20, type2, stdTypeList2, "and-const-int");
        AND_CONST_LONG = new Rop(20, type3, stdTypeList3, "and-const-long");
        OR_CONST_INT = new Rop(21, type2, stdTypeList2, "or-const-int");
        OR_CONST_LONG = new Rop(21, type3, stdTypeList3, "or-const-long");
        XOR_CONST_INT = new Rop(22, type2, stdTypeList2, "xor-const-int");
        XOR_CONST_LONG = new Rop(22, type3, stdTypeList3, "xor-const-long");
        SHL_CONST_INT = new Rop(23, type2, stdTypeList2, "shl-const-int");
        SHL_CONST_LONG = new Rop(23, type3, stdTypeList2, "shl-const-long");
        SHR_CONST_INT = new Rop(24, type2, stdTypeList2, "shr-const-int");
        SHR_CONST_LONG = new Rop(24, type3, stdTypeList2, "shr-const-long");
        USHR_CONST_INT = new Rop(25, type2, stdTypeList2, "ushr-const-int");
        USHR_CONST_LONG = new Rop(25, type3, stdTypeList2, "ushr-const-long");
        CMPL_LONG = new Rop(27, type2, stdTypeList10, "cmpl-long");
        CMPL_FLOAT = new Rop(27, type2, stdTypeList11, "cmpl-float");
        CMPL_DOUBLE = new Rop(27, type2, stdTypeList12, "cmpl-double");
        CMPG_FLOAT = new Rop(28, type2, stdTypeList11, "cmpg-float");
        CMPG_DOUBLE = new Rop(28, type2, stdTypeList12, "cmpg-double");
        CONV_L2I = new Rop(29, type2, stdTypeList3, "conv-l2i");
        CONV_F2I = new Rop(29, type2, stdTypeList4, "conv-f2i");
        CONV_D2I = new Rop(29, type2, stdTypeList5, "conv-d2i");
        CONV_I2L = new Rop(29, type3, stdTypeList2, "conv-i2l");
        CONV_F2L = new Rop(29, type3, stdTypeList4, "conv-f2l");
        CONV_D2L = new Rop(29, type3, stdTypeList5, "conv-d2l");
        CONV_I2F = new Rop(29, type4, stdTypeList2, "conv-i2f");
        CONV_L2F = new Rop(29, type4, stdTypeList3, "conv-l2f");
        CONV_D2F = new Rop(29, type4, stdTypeList5, "conv-d2f");
        CONV_I2D = new Rop(29, type5, stdTypeList2, "conv-i2d");
        CONV_L2D = new Rop(29, type5, stdTypeList3, "conv-l2d");
        CONV_F2D = new Rop(29, type5, stdTypeList4, "conv-f2d");
        TO_BYTE = new Rop(30, type2, stdTypeList2, "to-byte");
        TO_CHAR = new Rop(31, type2, stdTypeList2, "to-char");
        TO_SHORT = new Rop(32, type2, stdTypeList2, "to-short");
        RETURN_VOID = new Rop(33, type, stdTypeList, 2, "return-void");
        RETURN_INT = new Rop(33, type, stdTypeList2, 2, "return-int");
        RETURN_LONG = new Rop(33, type, stdTypeList3, 2, "return-long");
        RETURN_FLOAT = new Rop(33, type, stdTypeList4, 2, "return-float");
        RETURN_DOUBLE = new Rop(33, type, stdTypeList5, 2, "return-double");
        RETURN_OBJECT = new Rop(33, type, stdTypeList6, 2, "return-object");
        StdTypeList stdTypeList15 = Exceptions.LIST_Error_NullPointerException;
        ARRAY_LENGTH = new Rop(34, type2, stdTypeList6, stdTypeList15, "array-length");
        StdTypeList stdTypeList16 = StdTypeList.THROWABLE;
        THROW = new Rop(35, type, stdTypeList16, stdTypeList16, "throw");
        MONITOR_ENTER = new Rop(36, type, stdTypeList6, stdTypeList15, "monitor-enter");
        MONITOR_EXIT = new Rop(37, type, stdTypeList6, Exceptions.LIST_Error_Null_IllegalMonitorStateException, "monitor-exit");
        StdTypeList stdTypeList17 = StdTypeList.INTARR_INT;
        StdTypeList stdTypeList18 = Exceptions.LIST_Error_Null_ArrayIndexOutOfBounds;
        AGET_INT = new Rop(38, type2, stdTypeList17, stdTypeList18, "aget-int");
        AGET_LONG = new Rop(38, type3, StdTypeList.LONGARR_INT, stdTypeList18, "aget-long");
        AGET_FLOAT = new Rop(38, type4, StdTypeList.FLOATARR_INT, stdTypeList18, "aget-float");
        AGET_DOUBLE = new Rop(38, type5, StdTypeList.DOUBLEARR_INT, stdTypeList18, "aget-double");
        AGET_OBJECT = new Rop(38, type6, StdTypeList.OBJECTARR_INT, stdTypeList18, "aget-object");
        AGET_BOOLEAN = new Rop(38, type2, StdTypeList.BOOLEANARR_INT, stdTypeList18, "aget-boolean");
        AGET_BYTE = new Rop(38, type2, StdTypeList.BYTEARR_INT, stdTypeList18, "aget-byte");
        AGET_CHAR = new Rop(38, type2, StdTypeList.CHARARR_INT, stdTypeList18, "aget-char");
        AGET_SHORT = new Rop(38, type2, StdTypeList.SHORTARR_INT, stdTypeList18, "aget-short");
        APUT_INT = new Rop(39, type, StdTypeList.INT_INTARR_INT, stdTypeList18, "aput-int");
        APUT_LONG = new Rop(39, type, StdTypeList.LONG_LONGARR_INT, stdTypeList18, "aput-long");
        APUT_FLOAT = new Rop(39, type, StdTypeList.FLOAT_FLOATARR_INT, stdTypeList18, "aput-float");
        APUT_DOUBLE = new Rop(39, type, StdTypeList.DOUBLE_DOUBLEARR_INT, stdTypeList18, "aput-double");
        StdTypeList stdTypeList19 = StdTypeList.OBJECT_OBJECTARR_INT;
        StdTypeList stdTypeList20 = Exceptions.LIST_Error_Null_ArrayIndex_ArrayStore;
        APUT_OBJECT = new Rop(39, type, stdTypeList19, stdTypeList20, "aput-object");
        APUT_BOOLEAN = new Rop(39, type, StdTypeList.INT_BOOLEANARR_INT, stdTypeList20, "aput-boolean");
        APUT_BYTE = new Rop(39, type, StdTypeList.INT_BYTEARR_INT, stdTypeList20, "aput-byte");
        APUT_CHAR = new Rop(39, type, StdTypeList.INT_CHARARR_INT, stdTypeList20, "aput-char");
        APUT_SHORT = new Rop(39, type, StdTypeList.INT_SHORTARR_INT, stdTypeList20, "aput-short");
        NEW_INSTANCE = new Rop(40, type6, stdTypeList, stdTypeList7, "new-instance");
        Type type7 = Type.INT_ARRAY;
        StdTypeList stdTypeList21 = Exceptions.LIST_Error_NegativeArraySizeException;
        NEW_ARRAY_INT = new Rop(41, type7, stdTypeList2, stdTypeList21, "new-array-int");
        NEW_ARRAY_LONG = new Rop(41, Type.LONG_ARRAY, stdTypeList2, stdTypeList21, "new-array-long");
        NEW_ARRAY_FLOAT = new Rop(41, Type.FLOAT_ARRAY, stdTypeList2, stdTypeList21, "new-array-float");
        NEW_ARRAY_DOUBLE = new Rop(41, Type.DOUBLE_ARRAY, stdTypeList2, stdTypeList21, "new-array-double");
        NEW_ARRAY_BOOLEAN = new Rop(41, Type.BOOLEAN_ARRAY, stdTypeList2, stdTypeList21, "new-array-boolean");
        NEW_ARRAY_BYTE = new Rop(41, Type.BYTE_ARRAY, stdTypeList2, stdTypeList21, "new-array-byte");
        NEW_ARRAY_CHAR = new Rop(41, Type.CHAR_ARRAY, stdTypeList2, stdTypeList21, "new-array-char");
        NEW_ARRAY_SHORT = new Rop(41, Type.SHORT_ARRAY, stdTypeList2, stdTypeList21, "new-array-short");
        CHECK_CAST = new Rop(43, type, stdTypeList6, Exceptions.LIST_Error_ClassCastException, "check-cast");
        INSTANCE_OF = new Rop(44, type2, stdTypeList6, stdTypeList7, "instance-of");
        GET_FIELD_INT = new Rop(45, type2, stdTypeList6, stdTypeList15, "get-field-int");
        GET_FIELD_LONG = new Rop(45, type3, stdTypeList6, stdTypeList15, "get-field-long");
        GET_FIELD_FLOAT = new Rop(45, type4, stdTypeList6, stdTypeList15, "get-field-float");
        GET_FIELD_DOUBLE = new Rop(45, type5, stdTypeList6, stdTypeList15, "get-field-double");
        GET_FIELD_OBJECT = new Rop(45, type6, stdTypeList6, stdTypeList15, "get-field-object");
        GET_FIELD_BOOLEAN = new Rop(45, type2, stdTypeList6, stdTypeList15, "get-field-boolean");
        GET_FIELD_BYTE = new Rop(45, type2, stdTypeList6, stdTypeList15, "get-field-byte");
        GET_FIELD_CHAR = new Rop(45, type2, stdTypeList6, stdTypeList15, "get-field-char");
        GET_FIELD_SHORT = new Rop(45, type2, stdTypeList6, stdTypeList15, "get-field-short");
        GET_STATIC_INT = new Rop(46, type2, stdTypeList, stdTypeList7, "get-static-int");
        GET_STATIC_LONG = new Rop(46, type3, stdTypeList, stdTypeList7, "get-static-long");
        GET_STATIC_FLOAT = new Rop(46, type4, stdTypeList, stdTypeList7, "get-static-float");
        GET_STATIC_DOUBLE = new Rop(46, type5, stdTypeList, stdTypeList7, "get-static-double");
        GET_STATIC_OBJECT = new Rop(46, type6, stdTypeList, stdTypeList7, "get-static-object");
        GET_STATIC_BOOLEAN = new Rop(46, type2, stdTypeList, stdTypeList7, "get-field-boolean");
        GET_STATIC_BYTE = new Rop(46, type2, stdTypeList, stdTypeList7, "get-field-byte");
        GET_STATIC_CHAR = new Rop(46, type2, stdTypeList, stdTypeList7, "get-field-char");
        GET_STATIC_SHORT = new Rop(46, type2, stdTypeList, stdTypeList7, "get-field-short");
        StdTypeList stdTypeList22 = StdTypeList.INT_OBJECT;
        PUT_FIELD_INT = new Rop(47, type, stdTypeList22, stdTypeList15, "put-field-int");
        PUT_FIELD_LONG = new Rop(47, type, StdTypeList.LONG_OBJECT, stdTypeList15, "put-field-long");
        PUT_FIELD_FLOAT = new Rop(47, type, StdTypeList.FLOAT_OBJECT, stdTypeList15, "put-field-float");
        PUT_FIELD_DOUBLE = new Rop(47, type, StdTypeList.DOUBLE_OBJECT, stdTypeList15, "put-field-double");
        PUT_FIELD_OBJECT = new Rop(47, type, stdTypeList9, stdTypeList15, "put-field-object");
        PUT_FIELD_BOOLEAN = new Rop(47, type, stdTypeList22, stdTypeList15, "put-field-boolean");
        PUT_FIELD_BYTE = new Rop(47, type, stdTypeList22, stdTypeList15, "put-field-byte");
        PUT_FIELD_CHAR = new Rop(47, type, stdTypeList22, stdTypeList15, "put-field-char");
        PUT_FIELD_SHORT = new Rop(47, type, stdTypeList22, stdTypeList15, "put-field-short");
        PUT_STATIC_INT = new Rop(48, type, stdTypeList2, stdTypeList7, "put-static-int");
        PUT_STATIC_LONG = new Rop(48, type, stdTypeList3, stdTypeList7, "put-static-long");
        PUT_STATIC_FLOAT = new Rop(48, type, stdTypeList4, stdTypeList7, "put-static-float");
        PUT_STATIC_DOUBLE = new Rop(48, type, stdTypeList5, stdTypeList7, "put-static-double");
        PUT_STATIC_OBJECT = new Rop(48, type, stdTypeList6, stdTypeList7, "put-static-object");
        PUT_STATIC_BOOLEAN = new Rop(48, type, stdTypeList2, stdTypeList7, "put-static-boolean");
        PUT_STATIC_BYTE = new Rop(48, type, stdTypeList2, stdTypeList7, "put-static-byte");
        PUT_STATIC_CHAR = new Rop(48, type, stdTypeList2, stdTypeList7, "put-static-char");
        PUT_STATIC_SHORT = new Rop(48, type, stdTypeList2, stdTypeList7, "put-static-short");
        MARK_LOCAL_INT = new Rop(54, type, stdTypeList2, "mark-local-int");
        MARK_LOCAL_LONG = new Rop(54, type, stdTypeList3, "mark-local-long");
        MARK_LOCAL_FLOAT = new Rop(54, type, stdTypeList4, "mark-local-float");
        MARK_LOCAL_DOUBLE = new Rop(54, type, stdTypeList5, "mark-local-double");
        MARK_LOCAL_OBJECT = new Rop(54, type, stdTypeList6, "mark-local-object");
        FILL_ARRAY_DATA = new Rop(57, type, stdTypeList, "fill-array-data");
    }

    private Rops() {
    }

    public static Rop opAdd(TypeList typeList) {
        return pickBinaryOp(typeList, ADD_CONST_INT, ADD_CONST_LONG, ADD_CONST_FLOAT, ADD_CONST_DOUBLE, ADD_INT, ADD_LONG, ADD_FLOAT, ADD_DOUBLE);
    }

    public static Rop opAget(TypeBearer typeBearer) {
        switch (typeBearer.getBasicType()) {
            case 1:
                return AGET_BOOLEAN;
            case 2:
                return AGET_BYTE;
            case 3:
                return AGET_CHAR;
            case 4:
                return AGET_DOUBLE;
            case 5:
                return AGET_FLOAT;
            case 6:
                return AGET_INT;
            case 7:
                return AGET_LONG;
            case 8:
                return AGET_SHORT;
            case 9:
                return AGET_OBJECT;
            default:
                return throwBadType(typeBearer);
        }
    }

    public static Rop opAnd(TypeList typeList) {
        return pickBinaryOp(typeList, AND_CONST_INT, AND_CONST_LONG, null, null, AND_INT, AND_LONG, null, null);
    }

    public static Rop opAput(TypeBearer typeBearer) {
        switch (typeBearer.getBasicType()) {
            case 1:
                return APUT_BOOLEAN;
            case 2:
                return APUT_BYTE;
            case 3:
                return APUT_CHAR;
            case 4:
                return APUT_DOUBLE;
            case 5:
                return APUT_FLOAT;
            case 6:
                return APUT_INT;
            case 7:
                return APUT_LONG;
            case 8:
                return APUT_SHORT;
            case 9:
                return APUT_OBJECT;
            default:
                return throwBadType(typeBearer);
        }
    }

    public static Rop opCmpg(TypeBearer typeBearer) {
        int basicType = typeBearer.getBasicType();
        if (basicType != 4) {
            if (basicType != 5) {
                return throwBadType(typeBearer);
            }
            return CMPG_FLOAT;
        }
        return CMPG_DOUBLE;
    }

    public static Rop opCmpl(TypeBearer typeBearer) {
        int basicType = typeBearer.getBasicType();
        if (basicType != 4) {
            if (basicType != 5) {
                if (basicType != 7) {
                    return throwBadType(typeBearer);
                }
                return CMPL_LONG;
            }
            return CMPL_FLOAT;
        }
        return CMPL_DOUBLE;
    }

    public static Rop opConst(TypeBearer typeBearer) {
        if (typeBearer.getType() == Type.KNOWN_NULL) {
            return CONST_OBJECT_NOTHROW;
        }
        int basicFrameType = typeBearer.getBasicFrameType();
        if (basicFrameType != 4) {
            if (basicFrameType != 5) {
                if (basicFrameType != 6) {
                    if (basicFrameType != 7) {
                        if (basicFrameType != 9) {
                            return throwBadType(typeBearer);
                        }
                        return CONST_OBJECT;
                    }
                    return CONST_LONG;
                }
                return CONST_INT;
            }
            return CONST_FLOAT;
        }
        return CONST_DOUBLE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r1 != 7) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.android.dx.rop.code.Rop opConv(com.android.dx.rop.type.TypeBearer r6, com.android.dx.rop.type.TypeBearer r7) {
        /*
            int r0 = r6.getBasicFrameType()
            int r1 = r7.getBasicFrameType()
            r2 = 7
            r3 = 6
            r4 = 5
            r5 = 4
            if (r1 == r5) goto L44
            if (r1 == r4) goto L34
            if (r1 == r3) goto L15
            if (r1 == r2) goto L1b
            goto L4a
        L15:
            if (r0 == r5) goto L31
            if (r0 == r4) goto L2e
            if (r0 == r2) goto L2b
        L1b:
            if (r0 == r5) goto L28
            if (r0 == r4) goto L25
            if (r0 == r3) goto L22
            goto L34
        L22:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_L2I
            return r6
        L25:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_L2F
            return r6
        L28:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_L2D
            return r6
        L2b:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_I2L
            return r6
        L2e:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_I2F
            return r6
        L31:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_I2D
            return r6
        L34:
            if (r0 == r5) goto L41
            if (r0 == r3) goto L3e
            if (r0 == r2) goto L3b
            goto L44
        L3b:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_F2L
            return r6
        L3e:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_F2I
            return r6
        L41:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_F2D
            return r6
        L44:
            if (r0 == r4) goto L61
            if (r0 == r3) goto L5e
            if (r0 == r2) goto L5b
        L4a:
            com.android.dx.rop.type.Type r6 = r6.getType()
            com.android.dx.rop.type.Type r7 = r7.getType()
            com.android.dx.rop.type.StdTypeList r6 = com.android.dx.rop.type.StdTypeList.make(r6, r7)
            com.android.dx.rop.code.Rop r6 = throwBadTypes(r6)
            return r6
        L5b:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_D2L
            return r6
        L5e:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_D2I
            return r6
        L61:
            com.android.dx.rop.code.Rop r6 = com.android.dx.rop.code.Rops.CONV_D2F
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dx.rop.code.Rops.opConv(com.android.dx.rop.type.TypeBearer, com.android.dx.rop.type.TypeBearer):com.android.dx.rop.code.Rop");
    }

    public static Rop opDiv(TypeList typeList) {
        return pickBinaryOp(typeList, DIV_CONST_INT, DIV_CONST_LONG, DIV_CONST_FLOAT, DIV_CONST_DOUBLE, DIV_INT, DIV_LONG, DIV_FLOAT, DIV_DOUBLE);
    }

    public static Rop opFilledNewArray(TypeBearer typeBearer, int i4) {
        Type componentType = typeBearer.getType().getComponentType();
        if (componentType.isCategory2()) {
            return throwBadType(typeBearer);
        }
        if (i4 >= 0) {
            StdTypeList stdTypeList = new StdTypeList(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                stdTypeList.set(i5, componentType);
            }
            return new Rop(42, stdTypeList, Exceptions.LIST_Error);
        }
        throw new IllegalArgumentException("count < 0");
    }

    public static Rop opGetField(TypeBearer typeBearer) {
        switch (typeBearer.getBasicType()) {
            case 1:
                return GET_FIELD_BOOLEAN;
            case 2:
                return GET_FIELD_BYTE;
            case 3:
                return GET_FIELD_CHAR;
            case 4:
                return GET_FIELD_DOUBLE;
            case 5:
                return GET_FIELD_FLOAT;
            case 6:
                return GET_FIELD_INT;
            case 7:
                return GET_FIELD_LONG;
            case 8:
                return GET_FIELD_SHORT;
            case 9:
                return GET_FIELD_OBJECT;
            default:
                return throwBadType(typeBearer);
        }
    }

    public static Rop opGetStatic(TypeBearer typeBearer) {
        switch (typeBearer.getBasicType()) {
            case 1:
                return GET_STATIC_BOOLEAN;
            case 2:
                return GET_STATIC_BYTE;
            case 3:
                return GET_STATIC_CHAR;
            case 4:
                return GET_STATIC_DOUBLE;
            case 5:
                return GET_STATIC_FLOAT;
            case 6:
                return GET_STATIC_INT;
            case 7:
                return GET_STATIC_LONG;
            case 8:
                return GET_STATIC_SHORT;
            case 9:
                return GET_STATIC_OBJECT;
            default:
                return throwBadType(typeBearer);
        }
    }

    public static Rop opIfEq(TypeList typeList) {
        return pickIf(typeList, IF_EQZ_INT, IF_EQZ_OBJECT, IF_EQ_INT, IF_EQ_OBJECT);
    }

    public static Rop opIfGe(TypeList typeList) {
        return pickIf(typeList, IF_GEZ_INT, null, IF_GE_INT, null);
    }

    public static Rop opIfGt(TypeList typeList) {
        return pickIf(typeList, IF_GTZ_INT, null, IF_GT_INT, null);
    }

    public static Rop opIfLe(TypeList typeList) {
        return pickIf(typeList, IF_LEZ_INT, null, IF_LE_INT, null);
    }

    public static Rop opIfLt(TypeList typeList) {
        return pickIf(typeList, IF_LTZ_INT, null, IF_LT_INT, null);
    }

    public static Rop opIfNe(TypeList typeList) {
        return pickIf(typeList, IF_NEZ_INT, IF_NEZ_OBJECT, IF_NE_INT, IF_NE_OBJECT);
    }

    public static Rop opInvokeDirect(Prototype prototype) {
        return new Rop(52, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
    }

    public static Rop opInvokeInterface(Prototype prototype) {
        return new Rop(53, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
    }

    public static Rop opInvokeStatic(Prototype prototype) {
        return new Rop(49, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
    }

    public static Rop opInvokeSuper(Prototype prototype) {
        return new Rop(51, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
    }

    public static Rop opInvokeVirtual(Prototype prototype) {
        return new Rop(50, prototype.getParameterFrameTypes(), StdTypeList.THROWABLE);
    }

    public static Rop opMarkLocal(TypeBearer typeBearer) {
        int basicFrameType = typeBearer.getBasicFrameType();
        if (basicFrameType != 4) {
            if (basicFrameType != 5) {
                if (basicFrameType != 6) {
                    if (basicFrameType != 7) {
                        if (basicFrameType != 9) {
                            return throwBadType(typeBearer);
                        }
                        return MARK_LOCAL_OBJECT;
                    }
                    return MARK_LOCAL_LONG;
                }
                return MARK_LOCAL_INT;
            }
            return MARK_LOCAL_FLOAT;
        }
        return MARK_LOCAL_DOUBLE;
    }

    public static Rop opMove(TypeBearer typeBearer) {
        switch (typeBearer.getBasicFrameType()) {
            case 4:
                return MOVE_DOUBLE;
            case 5:
                return MOVE_FLOAT;
            case 6:
                return MOVE_INT;
            case 7:
                return MOVE_LONG;
            case 8:
            default:
                return throwBadType(typeBearer);
            case 9:
                return MOVE_OBJECT;
            case 10:
                return MOVE_RETURN_ADDRESS;
        }
    }

    public static Rop opMoveException(TypeBearer typeBearer) {
        return new Rop(4, typeBearer.getType(), StdTypeList.EMPTY, null);
    }

    public static Rop opMoveParam(TypeBearer typeBearer) {
        int basicFrameType = typeBearer.getBasicFrameType();
        if (basicFrameType != 4) {
            if (basicFrameType != 5) {
                if (basicFrameType != 6) {
                    if (basicFrameType != 7) {
                        if (basicFrameType != 9) {
                            return throwBadType(typeBearer);
                        }
                        return MOVE_PARAM_OBJECT;
                    }
                    return MOVE_PARAM_LONG;
                }
                return MOVE_PARAM_INT;
            }
            return MOVE_PARAM_FLOAT;
        }
        return MOVE_PARAM_DOUBLE;
    }

    public static Rop opMoveResult(TypeBearer typeBearer) {
        return new Rop(55, typeBearer.getType(), StdTypeList.EMPTY, null);
    }

    public static Rop opMoveResultPseudo(TypeBearer typeBearer) {
        return new Rop(56, typeBearer.getType(), StdTypeList.EMPTY, null);
    }

    public static Rop opMul(TypeList typeList) {
        return pickBinaryOp(typeList, MUL_CONST_INT, MUL_CONST_LONG, MUL_CONST_FLOAT, MUL_CONST_DOUBLE, MUL_INT, MUL_LONG, MUL_FLOAT, MUL_DOUBLE);
    }

    public static Rop opNeg(TypeBearer typeBearer) {
        int basicFrameType = typeBearer.getBasicFrameType();
        if (basicFrameType != 4) {
            if (basicFrameType != 5) {
                if (basicFrameType != 6) {
                    if (basicFrameType != 7) {
                        return throwBadType(typeBearer);
                    }
                    return NEG_LONG;
                }
                return NEG_INT;
            }
            return NEG_FLOAT;
        }
        return NEG_DOUBLE;
    }

    public static Rop opNewArray(TypeBearer typeBearer) {
        Type type = typeBearer.getType();
        switch (type.getComponentType().getBasicType()) {
            case 1:
                return NEW_ARRAY_BOOLEAN;
            case 2:
                return NEW_ARRAY_BYTE;
            case 3:
                return NEW_ARRAY_CHAR;
            case 4:
                return NEW_ARRAY_DOUBLE;
            case 5:
                return NEW_ARRAY_FLOAT;
            case 6:
                return NEW_ARRAY_INT;
            case 7:
                return NEW_ARRAY_LONG;
            case 8:
                return NEW_ARRAY_SHORT;
            case 9:
                return new Rop(41, type, StdTypeList.INT, Exceptions.LIST_Error_NegativeArraySizeException, "new-array-object");
            default:
                return throwBadType(type);
        }
    }

    public static Rop opNot(TypeBearer typeBearer) {
        int basicFrameType = typeBearer.getBasicFrameType();
        if (basicFrameType != 6) {
            if (basicFrameType != 7) {
                return throwBadType(typeBearer);
            }
            return NOT_LONG;
        }
        return NOT_INT;
    }

    public static Rop opOr(TypeList typeList) {
        return pickBinaryOp(typeList, OR_CONST_INT, OR_CONST_LONG, null, null, OR_INT, OR_LONG, null, null);
    }

    public static Rop opPutField(TypeBearer typeBearer) {
        switch (typeBearer.getBasicType()) {
            case 1:
                return PUT_FIELD_BOOLEAN;
            case 2:
                return PUT_FIELD_BYTE;
            case 3:
                return PUT_FIELD_CHAR;
            case 4:
                return PUT_FIELD_DOUBLE;
            case 5:
                return PUT_FIELD_FLOAT;
            case 6:
                return PUT_FIELD_INT;
            case 7:
                return PUT_FIELD_LONG;
            case 8:
                return PUT_FIELD_SHORT;
            case 9:
                return PUT_FIELD_OBJECT;
            default:
                return throwBadType(typeBearer);
        }
    }

    public static Rop opPutStatic(TypeBearer typeBearer) {
        switch (typeBearer.getBasicType()) {
            case 1:
                return PUT_STATIC_BOOLEAN;
            case 2:
                return PUT_STATIC_BYTE;
            case 3:
                return PUT_STATIC_CHAR;
            case 4:
                return PUT_STATIC_DOUBLE;
            case 5:
                return PUT_STATIC_FLOAT;
            case 6:
                return PUT_STATIC_INT;
            case 7:
                return PUT_STATIC_LONG;
            case 8:
                return PUT_STATIC_SHORT;
            case 9:
                return PUT_STATIC_OBJECT;
            default:
                return throwBadType(typeBearer);
        }
    }

    public static Rop opRem(TypeList typeList) {
        return pickBinaryOp(typeList, REM_CONST_INT, REM_CONST_LONG, REM_CONST_FLOAT, REM_CONST_DOUBLE, REM_INT, REM_LONG, REM_FLOAT, REM_DOUBLE);
    }

    public static Rop opReturn(TypeBearer typeBearer) {
        int basicFrameType = typeBearer.getBasicFrameType();
        if (basicFrameType != 0) {
            if (basicFrameType != 9) {
                if (basicFrameType != 4) {
                    if (basicFrameType != 5) {
                        if (basicFrameType != 6) {
                            if (basicFrameType != 7) {
                                return throwBadType(typeBearer);
                            }
                            return RETURN_LONG;
                        }
                        return RETURN_INT;
                    }
                    return RETURN_FLOAT;
                }
                return RETURN_DOUBLE;
            }
            return RETURN_OBJECT;
        }
        return RETURN_VOID;
    }

    public static Rop opShl(TypeList typeList) {
        return pickBinaryOp(typeList, SHL_CONST_INT, SHL_CONST_LONG, null, null, SHL_INT, SHL_LONG, null, null);
    }

    public static Rop opShr(TypeList typeList) {
        return pickBinaryOp(typeList, SHR_CONST_INT, SHR_CONST_LONG, null, null, SHR_INT, SHR_LONG, null, null);
    }

    public static Rop opSub(TypeList typeList) {
        return pickBinaryOp(typeList, SUB_CONST_INT, SUB_CONST_LONG, SUB_CONST_FLOAT, SUB_CONST_DOUBLE, SUB_INT, SUB_LONG, SUB_FLOAT, SUB_DOUBLE);
    }

    public static Rop opUshr(TypeList typeList) {
        return pickBinaryOp(typeList, USHR_CONST_INT, USHR_CONST_LONG, null, null, USHR_INT, USHR_LONG, null, null);
    }

    public static Rop opXor(TypeList typeList) {
        return pickBinaryOp(typeList, XOR_CONST_INT, XOR_CONST_LONG, null, null, XOR_INT, XOR_LONG, null, null);
    }

    private static Rop pickBinaryOp(TypeList typeList, Rop rop, Rop rop2, Rop rop3, Rop rop4, Rop rop5, Rop rop6, Rop rop7, Rop rop8) {
        int basicFrameType = typeList.getType(0).getBasicFrameType();
        int size = typeList.size();
        Rop rop9 = null;
        if (size != 1) {
            if (size == 2) {
                if (basicFrameType != 4) {
                    if (basicFrameType != 5) {
                        if (basicFrameType != 6) {
                            if (basicFrameType == 7) {
                                return rop6;
                            }
                        } else {
                            return rop5;
                        }
                    } else {
                        rop9 = rop7;
                    }
                } else {
                    rop9 = rop8;
                }
            }
        } else if (basicFrameType != 4) {
            if (basicFrameType != 5) {
                if (basicFrameType != 6) {
                    if (basicFrameType == 7) {
                        return rop2;
                    }
                } else {
                    return rop;
                }
            } else {
                rop9 = rop3;
            }
        } else {
            rop9 = rop4;
        }
        if (rop9 == null) {
            return throwBadTypes(typeList);
        }
        return rop9;
    }

    private static Rop pickIf(TypeList typeList, Rop rop, Rop rop2, Rop rop3, Rop rop4) {
        int basicFrameType;
        int size = typeList.size();
        if (size != 1) {
            if (size == 2 && (basicFrameType = typeList.getType(0).getBasicFrameType()) == typeList.getType(1).getBasicFrameType()) {
                if (basicFrameType != 6) {
                    if (basicFrameType == 9 && rop4 != null) {
                        return rop4;
                    }
                } else {
                    return rop3;
                }
            }
        } else {
            int basicFrameType2 = typeList.getType(0).getBasicFrameType();
            if (basicFrameType2 != 6) {
                if (basicFrameType2 == 9 && rop2 != null) {
                    return rop2;
                }
            } else {
                return rop;
            }
        }
        return throwBadTypes(typeList);
    }

    public static Rop ropFor(int i4, TypeBearer typeBearer, TypeList typeList, Constant constant) {
        Type componentType;
        Type componentType2;
        switch (i4) {
            case 1:
                return NOP;
            case 2:
                return opMove(typeBearer);
            case 3:
                return opMoveParam(typeBearer);
            case 4:
                return opMoveException(typeBearer);
            case 5:
                return opConst(typeBearer);
            case 6:
                return GOTO;
            case 7:
                return opIfEq(typeList);
            case 8:
                return opIfNe(typeList);
            case 9:
                return opIfLt(typeList);
            case 10:
                return opIfGe(typeList);
            case 11:
                return opIfLe(typeList);
            case 12:
                return opIfGt(typeList);
            case 13:
                return SWITCH;
            case 14:
                return opAdd(typeList);
            case 15:
                return opSub(typeList);
            case 16:
                return opMul(typeList);
            case 17:
                return opDiv(typeList);
            case 18:
                return opRem(typeList);
            case 19:
                return opNeg(typeBearer);
            case 20:
                return opAnd(typeList);
            case 21:
                return opOr(typeList);
            case 22:
                return opXor(typeList);
            case 23:
                return opShl(typeList);
            case 24:
                return opShr(typeList);
            case 25:
                return opUshr(typeList);
            case 26:
                return opNot(typeBearer);
            case 27:
                return opCmpl(typeList.getType(0));
            case 28:
                return opCmpg(typeList.getType(0));
            case 29:
                return opConv(typeBearer, typeList.getType(0));
            case 30:
                return TO_BYTE;
            case 31:
                return TO_CHAR;
            case 32:
                return TO_SHORT;
            case 33:
                if (typeList.size() == 0) {
                    return RETURN_VOID;
                }
                return opReturn(typeList.getType(0));
            case 34:
                return ARRAY_LENGTH;
            case 35:
                return THROW;
            case 36:
                return MONITOR_ENTER;
            case 37:
                return MONITOR_EXIT;
            case 38:
                Type type = typeList.getType(0);
                if (type == Type.KNOWN_NULL) {
                    componentType = typeBearer.getType();
                } else {
                    componentType = type.getComponentType();
                }
                return opAget(componentType);
            case 39:
                Type type2 = typeList.getType(1);
                if (type2 == Type.KNOWN_NULL) {
                    componentType2 = typeList.getType(0);
                } else {
                    componentType2 = type2.getComponentType();
                }
                return opAput(componentType2);
            case 40:
                return NEW_INSTANCE;
            case 41:
                return opNewArray(typeBearer.getType());
            case 42:
            default:
                throw new RuntimeException("unknown opcode " + RegOps.opName(i4));
            case 43:
                return CHECK_CAST;
            case 44:
                return INSTANCE_OF;
            case 45:
                return opGetField(typeBearer);
            case 46:
                return opGetStatic(typeBearer);
            case 47:
                return opPutField(typeList.getType(0));
            case 48:
                return opPutStatic(typeList.getType(0));
            case 49:
                return opInvokeStatic(((CstMethodRef) constant).getPrototype());
            case 50:
                CstMethodRef cstMethodRef = (CstMethodRef) constant;
                return opInvokeVirtual(cstMethodRef.getPrototype().withFirstParameter(cstMethodRef.getDefiningClass().getClassType()));
            case 51:
                CstMethodRef cstMethodRef2 = (CstMethodRef) constant;
                return opInvokeSuper(cstMethodRef2.getPrototype().withFirstParameter(cstMethodRef2.getDefiningClass().getClassType()));
            case 52:
                CstMethodRef cstMethodRef3 = (CstMethodRef) constant;
                return opInvokeDirect(cstMethodRef3.getPrototype().withFirstParameter(cstMethodRef3.getDefiningClass().getClassType()));
            case 53:
                CstMethodRef cstMethodRef4 = (CstMethodRef) constant;
                return opInvokeInterface(cstMethodRef4.getPrototype().withFirstParameter(cstMethodRef4.getDefiningClass().getClassType()));
        }
    }

    private static Rop throwBadType(TypeBearer typeBearer) {
        throw new IllegalArgumentException("bad type: " + typeBearer);
    }

    private static Rop throwBadTypes(TypeList typeList) {
        throw new IllegalArgumentException("bad types: " + typeList);
    }
}
