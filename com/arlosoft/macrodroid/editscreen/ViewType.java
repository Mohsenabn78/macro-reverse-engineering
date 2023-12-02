package com.arlosoft.macrodroid.editscreen;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: AllSelectableItemsListAdapter.kt */
/* loaded from: classes3.dex */
public enum ViewType {
    TRIGGER_HEADER(0),
    TRIGGER_EMPTY(1),
    ACTION_HEADER(10),
    ACTION_EMPTY(11),
    CONSTRAINT_HEADER(20),
    CONSTRAINT_EMPTY(21),
    SELECTABLE_ITEM_TRIGGER(30),
    SELECTABLE_ITEM_ACTION(31),
    SELECTABLE_ITEM_CONSTRAINT(32),
    SELECTABLE_ITEM_TRIGGER_LAST(40),
    SELECTABLE_ITEM_ACTION_LAST(41),
    SELECTABLE_ITEM_CONSTRAINT_LAST(42),
    LOCAL_VARIABLE_HEADER(50),
    LOCAL_VARIABLE_EMPTY(51),
    LOCAL_VARIABLE_ITEM(52),
    LOCAL_VARIABLE_ITEM_LAST(53);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int id;

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @SourceDebugExtension({"SMAP\nAllSelectableItemsListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllSelectableItemsListAdapter.kt\ncom/arlosoft/macrodroid/editscreen/ViewType$Companion\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,618:1\n1282#2,2:619\n*S KotlinDebug\n*F\n+ 1 AllSelectableItemsListAdapter.kt\ncom/arlosoft/macrodroid/editscreen/ViewType$Companion\n*L\n61#1:619,2\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ViewType fromId(int i4) {
            ViewType viewType;
            boolean z3;
            ViewType[] values = ViewType.values();
            int length = values.length;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    viewType = values[i5];
                    if (viewType.getId() == i4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        break;
                    }
                    i5++;
                } else {
                    viewType = null;
                    break;
                }
            }
            if (viewType != null) {
                return viewType;
            }
            throw new IllegalArgumentException("Unknown ViewType id: " + i4);
        }
    }

    ViewType(int i4) {
        this.id = i4;
    }

    public final int getId() {
        return this.id;
    }
}
