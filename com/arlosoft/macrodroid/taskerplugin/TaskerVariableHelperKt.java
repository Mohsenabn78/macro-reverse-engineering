package com.arlosoft.macrodroid.taskerplugin;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskerVariableHelper.kt */
/* loaded from: classes3.dex */
public final class TaskerVariableHelperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(String str) {
        if (str.length() > 0 && Character.isDigit(str.charAt(str.length() - 1))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(String str) {
        if (str.length() > 1 && !Character.isDigit(str.charAt(str.length() - 2)) && str.charAt(str.length() - 1) == '1') {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(String str) {
        int length = str.length();
        while (true) {
            length--;
            if (!Character.isDigit(str.charAt(length))) {
                break;
            }
        }
        if (length >= 0) {
            String substring = str.substring(0, length + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        return "";
    }
}
