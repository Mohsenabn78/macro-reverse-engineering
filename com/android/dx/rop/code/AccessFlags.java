package com.android.dx.rop.code;

import com.android.dx.util.Hex;

/* loaded from: classes2.dex */
public final class AccessFlags {
    public static final int ACC_ABSTRACT = 1024;
    public static final int ACC_ANNOTATION = 8192;
    public static final int ACC_BRIDGE = 64;
    public static final int ACC_CONSTRUCTOR = 65536;
    public static final int ACC_DECLARED_SYNCHRONIZED = 131072;
    public static final int ACC_ENUM = 16384;
    public static final int ACC_FINAL = 16;
    public static final int ACC_INTERFACE = 512;
    public static final int ACC_NATIVE = 256;
    public static final int ACC_PRIVATE = 2;
    public static final int ACC_PROTECTED = 4;
    public static final int ACC_PUBLIC = 1;
    public static final int ACC_STATIC = 8;
    public static final int ACC_STRICT = 2048;
    public static final int ACC_SUPER = 32;
    public static final int ACC_SYNCHRONIZED = 32;
    public static final int ACC_SYNTHETIC = 4096;
    public static final int ACC_TRANSIENT = 128;
    public static final int ACC_VARARGS = 128;
    public static final int ACC_VOLATILE = 64;
    public static final int CLASS_FLAGS = 30257;
    private static final int CONV_CLASS = 1;
    private static final int CONV_FIELD = 2;
    private static final int CONV_METHOD = 3;
    public static final int FIELD_FLAGS = 20703;
    public static final int INNER_CLASS_FLAGS = 30239;
    public static final int METHOD_FLAGS = 204287;

    private AccessFlags() {
    }

    public static String classString(int i4) {
        return humanHelper(i4, CLASS_FLAGS, 1);
    }

    public static String fieldString(int i4) {
        return humanHelper(i4, FIELD_FLAGS, 2);
    }

    private static String humanHelper(int i4, int i5, int i6) {
        StringBuffer stringBuffer = new StringBuffer(80);
        int i7 = (~i5) & i4;
        int i8 = i4 & i5;
        if ((i8 & 1) != 0) {
            stringBuffer.append("|public");
        }
        if ((i8 & 2) != 0) {
            stringBuffer.append("|private");
        }
        if ((i8 & 4) != 0) {
            stringBuffer.append("|protected");
        }
        if ((i8 & 8) != 0) {
            stringBuffer.append("|static");
        }
        if ((i8 & 16) != 0) {
            stringBuffer.append("|final");
        }
        if ((i8 & 32) != 0) {
            if (i6 == 1) {
                stringBuffer.append("|super");
            } else {
                stringBuffer.append("|synchronized");
            }
        }
        if ((i8 & 64) != 0) {
            if (i6 == 3) {
                stringBuffer.append("|bridge");
            } else {
                stringBuffer.append("|volatile");
            }
        }
        if ((i8 & 128) != 0) {
            if (i6 == 3) {
                stringBuffer.append("|varargs");
            } else {
                stringBuffer.append("|transient");
            }
        }
        if ((i8 & 256) != 0) {
            stringBuffer.append("|native");
        }
        if ((i8 & 512) != 0) {
            stringBuffer.append("|interface");
        }
        if ((i8 & 1024) != 0) {
            stringBuffer.append("|abstract");
        }
        if ((i8 & 2048) != 0) {
            stringBuffer.append("|strictfp");
        }
        if ((i8 & 4096) != 0) {
            stringBuffer.append("|synthetic");
        }
        if ((i8 & 8192) != 0) {
            stringBuffer.append("|annotation");
        }
        if ((i8 & 16384) != 0) {
            stringBuffer.append("|enum");
        }
        if ((65536 & i8) != 0) {
            stringBuffer.append("|constructor");
        }
        if ((i8 & 131072) != 0) {
            stringBuffer.append("|declared_synchronized");
        }
        if (i7 != 0 || stringBuffer.length() == 0) {
            stringBuffer.append('|');
            stringBuffer.append(Hex.u2(i7));
        }
        return stringBuffer.substring(1);
    }

    public static String innerClassString(int i4) {
        return humanHelper(i4, INNER_CLASS_FLAGS, 1);
    }

    public static boolean isAbstract(int i4) {
        if ((i4 & 1024) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isAnnotation(int i4) {
        if ((i4 & 8192) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isConstructor(int i4) {
        if ((i4 & 65536) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isDeclaredSynchronized(int i4) {
        if ((i4 & 131072) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isEnum(int i4) {
        if ((i4 & 16384) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isInterface(int i4) {
        if ((i4 & 512) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isNative(int i4) {
        if ((i4 & 256) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isPrivate(int i4) {
        if ((i4 & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isProtected(int i4) {
        if ((i4 & 4) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isPublic(int i4) {
        if ((i4 & 1) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isStatic(int i4) {
        if ((i4 & 8) != 0) {
            return true;
        }
        return false;
    }

    public static boolean isSynchronized(int i4) {
        if ((i4 & 32) != 0) {
            return true;
        }
        return false;
    }

    public static String methodString(int i4) {
        return humanHelper(i4, METHOD_FLAGS, 3);
    }
}
