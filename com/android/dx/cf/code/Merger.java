package com.android.dx.cf.code;

import com.android.dx.rop.type.Type;
import com.android.dx.rop.type.TypeBearer;
import com.android.dx.util.Hex;

/* loaded from: classes2.dex */
public final class Merger {
    private Merger() {
    }

    public static boolean isPossiblyAssignableFrom(TypeBearer typeBearer, TypeBearer typeBearer2) {
        Type type = typeBearer.getType();
        Type type2 = typeBearer2.getType();
        if (type.equals(type2)) {
            return true;
        }
        int basicType = type.getBasicType();
        int basicType2 = type2.getBasicType();
        if (basicType == 10) {
            type = Type.OBJECT;
            basicType = 9;
        }
        if (basicType2 == 10) {
            type2 = Type.OBJECT;
            basicType2 = 9;
        }
        if (basicType == 9 && basicType2 == 9) {
            Type type3 = Type.KNOWN_NULL;
            if (type == type3) {
                return false;
            }
            if (type2 == type3 || type == Type.OBJECT) {
                return true;
            }
            if (type.isArray()) {
                if (!type2.isArray()) {
                    return false;
                }
                do {
                    type = type.getComponentType();
                    type2 = type2.getComponentType();
                    if (!type.isArray()) {
                        break;
                    }
                } while (type2.isArray());
                return isPossiblyAssignableFrom(type, type2);
            } else if (!type2.isArray() || type == Type.SERIALIZABLE || type == Type.CLONEABLE) {
                return true;
            } else {
                return false;
            }
        } else if (type.isIntlike() && type2.isIntlike()) {
            return true;
        } else {
            return false;
        }
    }

    public static OneLocalsArray mergeLocals(OneLocalsArray oneLocalsArray, OneLocalsArray oneLocalsArray2) {
        if (oneLocalsArray == oneLocalsArray2) {
            return oneLocalsArray;
        }
        int maxLocals = oneLocalsArray.getMaxLocals();
        if (oneLocalsArray2.getMaxLocals() == maxLocals) {
            OneLocalsArray oneLocalsArray3 = null;
            for (int i4 = 0; i4 < maxLocals; i4++) {
                TypeBearer orNull = oneLocalsArray.getOrNull(i4);
                TypeBearer mergeType = mergeType(orNull, oneLocalsArray2.getOrNull(i4));
                if (mergeType != orNull) {
                    if (oneLocalsArray3 == null) {
                        oneLocalsArray3 = oneLocalsArray.copy();
                    }
                    if (mergeType == null) {
                        oneLocalsArray3.invalidate(i4);
                    } else {
                        oneLocalsArray3.set(i4, mergeType);
                    }
                }
            }
            if (oneLocalsArray3 == null) {
                return oneLocalsArray;
            }
            oneLocalsArray3.setImmutable();
            return oneLocalsArray3;
        }
        throw new SimException("mismatched maxLocals values");
    }

    public static ExecutionStack mergeStack(ExecutionStack executionStack, ExecutionStack executionStack2) {
        if (executionStack == executionStack2) {
            return executionStack;
        }
        int size = executionStack.size();
        if (executionStack2.size() == size) {
            ExecutionStack executionStack3 = null;
            for (int i4 = 0; i4 < size; i4++) {
                TypeBearer peek = executionStack.peek(i4);
                TypeBearer peek2 = executionStack2.peek(i4);
                TypeBearer mergeType = mergeType(peek, peek2);
                if (mergeType != peek) {
                    if (executionStack3 == null) {
                        executionStack3 = executionStack.copy();
                    }
                    if (mergeType != null) {
                        try {
                            executionStack3.change(i4, mergeType);
                        } catch (SimException e4) {
                            e4.addContext("...while merging stack[" + Hex.u2(i4) + "]");
                            throw e4;
                        }
                    } else {
                        throw new SimException("incompatible: " + peek + ", " + peek2);
                    }
                    e4.addContext("...while merging stack[" + Hex.u2(i4) + "]");
                    throw e4;
                }
            }
            if (executionStack3 == null) {
                return executionStack;
            }
            executionStack3.setImmutable();
            return executionStack3;
        }
        throw new SimException("mismatched stack depths");
    }

    public static TypeBearer mergeType(TypeBearer typeBearer, TypeBearer typeBearer2) {
        if (typeBearer != null && !typeBearer.equals(typeBearer2)) {
            if (typeBearer2 == null) {
                return null;
            }
            Type type = typeBearer.getType();
            Type type2 = typeBearer2.getType();
            if (type == type2) {
                return type;
            }
            if (type.isReference() && type2.isReference()) {
                Type type3 = Type.KNOWN_NULL;
                if (type == type3) {
                    return type2;
                }
                if (type2 == type3) {
                    return type;
                }
                if (type.isArray() && type2.isArray()) {
                    TypeBearer mergeType = mergeType(type.getComponentType(), type2.getComponentType());
                    if (mergeType == null) {
                        return Type.OBJECT;
                    }
                    return ((Type) mergeType).getArrayType();
                }
                return Type.OBJECT;
            } else if (!type.isIntlike() || !type2.isIntlike()) {
                return null;
            } else {
                return Type.INT;
            }
        }
        return typeBearer;
    }
}
