package com.android.dx.dex.code;

import com.android.dx.rop.code.Insn;
import com.android.dx.rop.code.RegisterSpec;
import com.android.dx.rop.code.Rop;
import com.android.dx.rop.code.Rops;
import com.android.dx.rop.code.ThrowingCstInsn;
import com.android.dx.rop.cst.Constant;
import com.android.dx.rop.cst.CstFieldRef;
import com.android.dx.rop.cst.CstString;
import com.android.dx.rop.cst.CstType;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class RopToDop {
    private static final HashMap<Rop, Dop> MAP;

    static {
        HashMap<Rop, Dop> hashMap = new HashMap<>(400);
        MAP = hashMap;
        hashMap.put(Rops.NOP, Dops.NOP);
        Rop rop = Rops.MOVE_INT;
        Dop dop = Dops.MOVE;
        hashMap.put(rop, dop);
        Rop rop2 = Rops.MOVE_LONG;
        Dop dop2 = Dops.MOVE_WIDE;
        hashMap.put(rop2, dop2);
        hashMap.put(Rops.MOVE_FLOAT, dop);
        hashMap.put(Rops.MOVE_DOUBLE, dop2);
        Rop rop3 = Rops.MOVE_OBJECT;
        Dop dop3 = Dops.MOVE_OBJECT;
        hashMap.put(rop3, dop3);
        hashMap.put(Rops.MOVE_PARAM_INT, dop);
        hashMap.put(Rops.MOVE_PARAM_LONG, dop2);
        hashMap.put(Rops.MOVE_PARAM_FLOAT, dop);
        hashMap.put(Rops.MOVE_PARAM_DOUBLE, dop2);
        hashMap.put(Rops.MOVE_PARAM_OBJECT, dop3);
        Rop rop4 = Rops.CONST_INT;
        Dop dop4 = Dops.CONST_4;
        hashMap.put(rop4, dop4);
        Rop rop5 = Rops.CONST_LONG;
        Dop dop5 = Dops.CONST_WIDE_16;
        hashMap.put(rop5, dop5);
        hashMap.put(Rops.CONST_FLOAT, dop4);
        hashMap.put(Rops.CONST_DOUBLE, dop5);
        hashMap.put(Rops.CONST_OBJECT_NOTHROW, dop4);
        hashMap.put(Rops.GOTO, Dops.GOTO);
        Rop rop6 = Rops.IF_EQZ_INT;
        Dop dop6 = Dops.IF_EQZ;
        hashMap.put(rop6, dop6);
        Rop rop7 = Rops.IF_NEZ_INT;
        Dop dop7 = Dops.IF_NEZ;
        hashMap.put(rop7, dop7);
        hashMap.put(Rops.IF_LTZ_INT, Dops.IF_LTZ);
        hashMap.put(Rops.IF_GEZ_INT, Dops.IF_GEZ);
        hashMap.put(Rops.IF_LEZ_INT, Dops.IF_LEZ);
        hashMap.put(Rops.IF_GTZ_INT, Dops.IF_GTZ);
        hashMap.put(Rops.IF_EQZ_OBJECT, dop6);
        hashMap.put(Rops.IF_NEZ_OBJECT, dop7);
        Rop rop8 = Rops.IF_EQ_INT;
        Dop dop8 = Dops.IF_EQ;
        hashMap.put(rop8, dop8);
        Rop rop9 = Rops.IF_NE_INT;
        Dop dop9 = Dops.IF_NE;
        hashMap.put(rop9, dop9);
        hashMap.put(Rops.IF_LT_INT, Dops.IF_LT);
        hashMap.put(Rops.IF_GE_INT, Dops.IF_GE);
        hashMap.put(Rops.IF_LE_INT, Dops.IF_LE);
        hashMap.put(Rops.IF_GT_INT, Dops.IF_GT);
        hashMap.put(Rops.IF_EQ_OBJECT, dop8);
        hashMap.put(Rops.IF_NE_OBJECT, dop9);
        hashMap.put(Rops.SWITCH, Dops.SPARSE_SWITCH);
        hashMap.put(Rops.ADD_INT, Dops.ADD_INT_2ADDR);
        hashMap.put(Rops.ADD_LONG, Dops.ADD_LONG_2ADDR);
        hashMap.put(Rops.ADD_FLOAT, Dops.ADD_FLOAT_2ADDR);
        hashMap.put(Rops.ADD_DOUBLE, Dops.ADD_DOUBLE_2ADDR);
        hashMap.put(Rops.SUB_INT, Dops.SUB_INT_2ADDR);
        hashMap.put(Rops.SUB_LONG, Dops.SUB_LONG_2ADDR);
        hashMap.put(Rops.SUB_FLOAT, Dops.SUB_FLOAT_2ADDR);
        hashMap.put(Rops.SUB_DOUBLE, Dops.SUB_DOUBLE_2ADDR);
        hashMap.put(Rops.MUL_INT, Dops.MUL_INT_2ADDR);
        hashMap.put(Rops.MUL_LONG, Dops.MUL_LONG_2ADDR);
        hashMap.put(Rops.MUL_FLOAT, Dops.MUL_FLOAT_2ADDR);
        hashMap.put(Rops.MUL_DOUBLE, Dops.MUL_DOUBLE_2ADDR);
        hashMap.put(Rops.DIV_INT, Dops.DIV_INT_2ADDR);
        hashMap.put(Rops.DIV_LONG, Dops.DIV_LONG_2ADDR);
        hashMap.put(Rops.DIV_FLOAT, Dops.DIV_FLOAT_2ADDR);
        hashMap.put(Rops.DIV_DOUBLE, Dops.DIV_DOUBLE_2ADDR);
        hashMap.put(Rops.REM_INT, Dops.REM_INT_2ADDR);
        hashMap.put(Rops.REM_LONG, Dops.REM_LONG_2ADDR);
        hashMap.put(Rops.REM_FLOAT, Dops.REM_FLOAT_2ADDR);
        hashMap.put(Rops.REM_DOUBLE, Dops.REM_DOUBLE_2ADDR);
        hashMap.put(Rops.NEG_INT, Dops.NEG_INT);
        hashMap.put(Rops.NEG_LONG, Dops.NEG_LONG);
        hashMap.put(Rops.NEG_FLOAT, Dops.NEG_FLOAT);
        hashMap.put(Rops.NEG_DOUBLE, Dops.NEG_DOUBLE);
        hashMap.put(Rops.AND_INT, Dops.AND_INT_2ADDR);
        hashMap.put(Rops.AND_LONG, Dops.AND_LONG_2ADDR);
        hashMap.put(Rops.OR_INT, Dops.OR_INT_2ADDR);
        hashMap.put(Rops.OR_LONG, Dops.OR_LONG_2ADDR);
        hashMap.put(Rops.XOR_INT, Dops.XOR_INT_2ADDR);
        hashMap.put(Rops.XOR_LONG, Dops.XOR_LONG_2ADDR);
        hashMap.put(Rops.SHL_INT, Dops.SHL_INT_2ADDR);
        hashMap.put(Rops.SHL_LONG, Dops.SHL_LONG_2ADDR);
        hashMap.put(Rops.SHR_INT, Dops.SHR_INT_2ADDR);
        hashMap.put(Rops.SHR_LONG, Dops.SHR_LONG_2ADDR);
        hashMap.put(Rops.USHR_INT, Dops.USHR_INT_2ADDR);
        hashMap.put(Rops.USHR_LONG, Dops.USHR_LONG_2ADDR);
        hashMap.put(Rops.NOT_INT, Dops.NOT_INT);
        hashMap.put(Rops.NOT_LONG, Dops.NOT_LONG);
        hashMap.put(Rops.ADD_CONST_INT, Dops.ADD_INT_LIT8);
        hashMap.put(Rops.SUB_CONST_INT, Dops.RSUB_INT_LIT8);
        hashMap.put(Rops.MUL_CONST_INT, Dops.MUL_INT_LIT8);
        hashMap.put(Rops.DIV_CONST_INT, Dops.DIV_INT_LIT8);
        hashMap.put(Rops.REM_CONST_INT, Dops.REM_INT_LIT8);
        hashMap.put(Rops.AND_CONST_INT, Dops.AND_INT_LIT8);
        hashMap.put(Rops.OR_CONST_INT, Dops.OR_INT_LIT8);
        hashMap.put(Rops.XOR_CONST_INT, Dops.XOR_INT_LIT8);
        hashMap.put(Rops.SHL_CONST_INT, Dops.SHL_INT_LIT8);
        hashMap.put(Rops.SHR_CONST_INT, Dops.SHR_INT_LIT8);
        hashMap.put(Rops.USHR_CONST_INT, Dops.USHR_INT_LIT8);
        hashMap.put(Rops.CMPL_LONG, Dops.CMP_LONG);
        hashMap.put(Rops.CMPL_FLOAT, Dops.CMPL_FLOAT);
        hashMap.put(Rops.CMPL_DOUBLE, Dops.CMPL_DOUBLE);
        hashMap.put(Rops.CMPG_FLOAT, Dops.CMPG_FLOAT);
        hashMap.put(Rops.CMPG_DOUBLE, Dops.CMPG_DOUBLE);
        hashMap.put(Rops.CONV_L2I, Dops.LONG_TO_INT);
        hashMap.put(Rops.CONV_F2I, Dops.FLOAT_TO_INT);
        hashMap.put(Rops.CONV_D2I, Dops.DOUBLE_TO_INT);
        hashMap.put(Rops.CONV_I2L, Dops.INT_TO_LONG);
        hashMap.put(Rops.CONV_F2L, Dops.FLOAT_TO_LONG);
        hashMap.put(Rops.CONV_D2L, Dops.DOUBLE_TO_LONG);
        hashMap.put(Rops.CONV_I2F, Dops.INT_TO_FLOAT);
        hashMap.put(Rops.CONV_L2F, Dops.LONG_TO_FLOAT);
        hashMap.put(Rops.CONV_D2F, Dops.DOUBLE_TO_FLOAT);
        hashMap.put(Rops.CONV_I2D, Dops.INT_TO_DOUBLE);
        hashMap.put(Rops.CONV_L2D, Dops.LONG_TO_DOUBLE);
        hashMap.put(Rops.CONV_F2D, Dops.FLOAT_TO_DOUBLE);
        hashMap.put(Rops.TO_BYTE, Dops.INT_TO_BYTE);
        hashMap.put(Rops.TO_CHAR, Dops.INT_TO_CHAR);
        hashMap.put(Rops.TO_SHORT, Dops.INT_TO_SHORT);
        hashMap.put(Rops.RETURN_VOID, Dops.RETURN_VOID);
        Rop rop10 = Rops.RETURN_INT;
        Dop dop10 = Dops.RETURN;
        hashMap.put(rop10, dop10);
        Rop rop11 = Rops.RETURN_LONG;
        Dop dop11 = Dops.RETURN_WIDE;
        hashMap.put(rop11, dop11);
        hashMap.put(Rops.RETURN_FLOAT, dop10);
        hashMap.put(Rops.RETURN_DOUBLE, dop11);
        hashMap.put(Rops.RETURN_OBJECT, Dops.RETURN_OBJECT);
        hashMap.put(Rops.ARRAY_LENGTH, Dops.ARRAY_LENGTH);
        hashMap.put(Rops.THROW, Dops.THROW);
        hashMap.put(Rops.MONITOR_ENTER, Dops.MONITOR_ENTER);
        hashMap.put(Rops.MONITOR_EXIT, Dops.MONITOR_EXIT);
        Rop rop12 = Rops.AGET_INT;
        Dop dop12 = Dops.AGET;
        hashMap.put(rop12, dop12);
        Rop rop13 = Rops.AGET_LONG;
        Dop dop13 = Dops.AGET_WIDE;
        hashMap.put(rop13, dop13);
        hashMap.put(Rops.AGET_FLOAT, dop12);
        hashMap.put(Rops.AGET_DOUBLE, dop13);
        hashMap.put(Rops.AGET_OBJECT, Dops.AGET_OBJECT);
        hashMap.put(Rops.AGET_BOOLEAN, Dops.AGET_BOOLEAN);
        hashMap.put(Rops.AGET_BYTE, Dops.AGET_BYTE);
        hashMap.put(Rops.AGET_CHAR, Dops.AGET_CHAR);
        hashMap.put(Rops.AGET_SHORT, Dops.AGET_SHORT);
        Rop rop14 = Rops.APUT_INT;
        Dop dop14 = Dops.APUT;
        hashMap.put(rop14, dop14);
        Rop rop15 = Rops.APUT_LONG;
        Dop dop15 = Dops.APUT_WIDE;
        hashMap.put(rop15, dop15);
        hashMap.put(Rops.APUT_FLOAT, dop14);
        hashMap.put(Rops.APUT_DOUBLE, dop15);
        hashMap.put(Rops.APUT_OBJECT, Dops.APUT_OBJECT);
        hashMap.put(Rops.APUT_BOOLEAN, Dops.APUT_BOOLEAN);
        hashMap.put(Rops.APUT_BYTE, Dops.APUT_BYTE);
        hashMap.put(Rops.APUT_CHAR, Dops.APUT_CHAR);
        hashMap.put(Rops.APUT_SHORT, Dops.APUT_SHORT);
        hashMap.put(Rops.NEW_INSTANCE, Dops.NEW_INSTANCE);
        hashMap.put(Rops.CHECK_CAST, Dops.CHECK_CAST);
        hashMap.put(Rops.INSTANCE_OF, Dops.INSTANCE_OF);
        Rop rop16 = Rops.GET_FIELD_LONG;
        Dop dop16 = Dops.IGET_WIDE;
        hashMap.put(rop16, dop16);
        hashMap.put(Rops.GET_FIELD_FLOAT, Dops.IGET);
        hashMap.put(Rops.GET_FIELD_DOUBLE, dop16);
        hashMap.put(Rops.GET_FIELD_OBJECT, Dops.IGET_OBJECT);
        Rop rop17 = Rops.GET_STATIC_LONG;
        Dop dop17 = Dops.SGET_WIDE;
        hashMap.put(rop17, dop17);
        hashMap.put(Rops.GET_STATIC_FLOAT, Dops.SGET);
        hashMap.put(Rops.GET_STATIC_DOUBLE, dop17);
        hashMap.put(Rops.GET_STATIC_OBJECT, Dops.SGET_OBJECT);
        Rop rop18 = Rops.PUT_FIELD_LONG;
        Dop dop18 = Dops.IPUT_WIDE;
        hashMap.put(rop18, dop18);
        hashMap.put(Rops.PUT_FIELD_FLOAT, Dops.IPUT);
        hashMap.put(Rops.PUT_FIELD_DOUBLE, dop18);
        hashMap.put(Rops.PUT_FIELD_OBJECT, Dops.IPUT_OBJECT);
        Rop rop19 = Rops.PUT_STATIC_LONG;
        Dop dop19 = Dops.SPUT_WIDE;
        hashMap.put(rop19, dop19);
        hashMap.put(Rops.PUT_STATIC_FLOAT, Dops.SPUT);
        hashMap.put(Rops.PUT_STATIC_DOUBLE, dop19);
        hashMap.put(Rops.PUT_STATIC_OBJECT, Dops.SPUT_OBJECT);
    }

    private RopToDop() {
    }

    public static Dop dopFor(Insn insn) {
        Rop opcode = insn.getOpcode();
        Dop dop = MAP.get(opcode);
        if (dop != null) {
            return dop;
        }
        int opcode2 = opcode.getOpcode();
        if (opcode2 != 4) {
            if (opcode2 != 5) {
                if (opcode2 != 41) {
                    if (opcode2 != 42) {
                        if (opcode2 != 55) {
                            if (opcode2 != 57) {
                                switch (opcode2) {
                                    case 45:
                                        int basicType = ((CstFieldRef) ((ThrowingCstInsn) insn).getConstant()).getBasicType();
                                        if (basicType != 1) {
                                            if (basicType != 2) {
                                                if (basicType != 3) {
                                                    if (basicType != 6) {
                                                        if (basicType == 8) {
                                                            return Dops.IGET_SHORT;
                                                        }
                                                    } else {
                                                        return Dops.IGET;
                                                    }
                                                } else {
                                                    return Dops.IGET_CHAR;
                                                }
                                            } else {
                                                return Dops.IGET_BYTE;
                                            }
                                        } else {
                                            return Dops.IGET_BOOLEAN;
                                        }
                                        break;
                                    case 46:
                                        int basicType2 = ((CstFieldRef) ((ThrowingCstInsn) insn).getConstant()).getBasicType();
                                        if (basicType2 != 1) {
                                            if (basicType2 != 2) {
                                                if (basicType2 != 3) {
                                                    if (basicType2 != 6) {
                                                        if (basicType2 == 8) {
                                                            return Dops.SGET_SHORT;
                                                        }
                                                    } else {
                                                        return Dops.SGET;
                                                    }
                                                } else {
                                                    return Dops.SGET_CHAR;
                                                }
                                            } else {
                                                return Dops.SGET_BYTE;
                                            }
                                        } else {
                                            return Dops.SGET_BOOLEAN;
                                        }
                                        break;
                                    case 47:
                                        int basicType3 = ((CstFieldRef) ((ThrowingCstInsn) insn).getConstant()).getBasicType();
                                        if (basicType3 != 1) {
                                            if (basicType3 != 2) {
                                                if (basicType3 != 3) {
                                                    if (basicType3 != 6) {
                                                        if (basicType3 == 8) {
                                                            return Dops.IPUT_SHORT;
                                                        }
                                                    } else {
                                                        return Dops.IPUT;
                                                    }
                                                } else {
                                                    return Dops.IPUT_CHAR;
                                                }
                                            } else {
                                                return Dops.IPUT_BYTE;
                                            }
                                        } else {
                                            return Dops.IPUT_BOOLEAN;
                                        }
                                        break;
                                    case 48:
                                        int basicType4 = ((CstFieldRef) ((ThrowingCstInsn) insn).getConstant()).getBasicType();
                                        if (basicType4 != 1) {
                                            if (basicType4 != 2) {
                                                if (basicType4 != 3) {
                                                    if (basicType4 != 6) {
                                                        if (basicType4 == 8) {
                                                            return Dops.SPUT_SHORT;
                                                        }
                                                    } else {
                                                        return Dops.SPUT;
                                                    }
                                                } else {
                                                    return Dops.SPUT_CHAR;
                                                }
                                            } else {
                                                return Dops.SPUT_BYTE;
                                            }
                                        } else {
                                            return Dops.SPUT_BOOLEAN;
                                        }
                                        break;
                                    case 49:
                                        return Dops.INVOKE_STATIC;
                                    case 50:
                                        return Dops.INVOKE_VIRTUAL;
                                    case 51:
                                        return Dops.INVOKE_SUPER;
                                    case 52:
                                        return Dops.INVOKE_DIRECT;
                                    case 53:
                                        return Dops.INVOKE_INTERFACE;
                                }
                            } else {
                                return Dops.FILL_ARRAY_DATA;
                            }
                        } else {
                            RegisterSpec result = insn.getResult();
                            if (result == null) {
                                return Dops.NOP;
                            }
                            switch (result.getBasicType()) {
                                case 1:
                                case 2:
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                    return Dops.MOVE_RESULT;
                                case 4:
                                case 7:
                                    return Dops.MOVE_RESULT_WIDE;
                                case 9:
                                    return Dops.MOVE_RESULT_OBJECT;
                                default:
                                    throw new RuntimeException("Unexpected basic type");
                            }
                        }
                    } else {
                        return Dops.FILLED_NEW_ARRAY;
                    }
                } else {
                    return Dops.NEW_ARRAY;
                }
            } else {
                Constant constant = ((ThrowingCstInsn) insn).getConstant();
                if (constant instanceof CstType) {
                    return Dops.CONST_CLASS;
                }
                if (constant instanceof CstString) {
                    return Dops.CONST_STRING;
                }
            }
            throw new RuntimeException("unknown rop: " + opcode);
        }
        return Dops.MOVE_EXCEPTION;
    }
}
