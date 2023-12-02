package com.arlosoft.macrodroid.taskerplugin;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: TaskerVariableHelper.kt */
/* loaded from: classes3.dex */
public enum ArrayHandlingOption {
    FIRST_ELEMENT(0),
    COMMA_SEPARATED(1),
    NEW_LINE_SEPARATED(2);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int id;

    /* compiled from: TaskerVariableHelper.kt */
    @SourceDebugExtension({"SMAP\nTaskerVariableHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskerVariableHelper.kt\ncom/arlosoft/macrodroid/taskerplugin/ArrayHandlingOption$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,235:1\n1282#2,2:236\n*S KotlinDebug\n*F\n+ 1 TaskerVariableHelper.kt\ncom/arlosoft/macrodroid/taskerplugin/ArrayHandlingOption$Companion\n*L\n34#1:236,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ArrayHandlingOption fromId(int i4) {
            ArrayHandlingOption arrayHandlingOption;
            boolean z3;
            ArrayHandlingOption[] values = ArrayHandlingOption.values();
            int length = values.length;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    arrayHandlingOption = values[i5];
                    if (arrayHandlingOption.getId() == i4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        break;
                    }
                    i5++;
                } else {
                    arrayHandlingOption = null;
                    break;
                }
            }
            if (arrayHandlingOption == null) {
                return ArrayHandlingOption.FIRST_ELEMENT;
            }
            return arrayHandlingOption;
        }
    }

    ArrayHandlingOption(int i4) {
        this.id = i4;
    }

    @JvmStatic
    @NotNull
    public static final ArrayHandlingOption fromId(int i4) {
        return Companion.fromId(i4);
    }

    public final int getId() {
        return this.id;
    }
}
