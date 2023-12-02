package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.categories.HasMacroNames;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.info.MacroFinishedTriggerInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroFinishedTrigger.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nMacroFinishedTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroFinishedTrigger.kt\ncom/arlosoft/macrodroid/triggers/MacroFinishedTrigger\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,152:1\n350#2,7:153\n1549#2:160\n1620#2,3:161\n37#3,2:164\n*S KotlinDebug\n*F\n+ 1 MacroFinishedTrigger.kt\ncom/arlosoft/macrodroid/triggers/MacroFinishedTrigger\n*L\n74#1:153,7\n76#1:160\n76#1:161,3\n78#1:164,2\n*E\n"})
/* loaded from: classes3.dex */
public final class MacroFinishedTrigger extends Trigger implements HasMacroNames {
    private static final long GUID_THIS_MACRO = -1;
    private long macroId;
    @NotNull
    private String macroName;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MacroFinishedTrigger> CREATOR = new Parcelable.Creator<MacroFinishedTrigger>() { // from class: com.arlosoft.macrodroid.triggers.MacroFinishedTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroFinishedTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MacroFinishedTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroFinishedTrigger[] newArray(int i4) {
            return new MacroFinishedTrigger[i4];
        }
    };

    public /* synthetic */ MacroFinishedTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(MacroFinishedTrigger this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(MacroFinishedTrigger this$0, List list, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        int checkedItemPosition = ((AlertDialog) dialogInterface).getListView().getCheckedItemPosition();
        if (checkedItemPosition == 0) {
            this$0.macroId = -1L;
            String r4 = SelectableItem.r(R.string.constraint_last_run_time_this_macro);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.const…last_run_time_this_macro)");
            this$0.macroName = r4;
        } else {
            int i5 = checkedItemPosition - 1;
            this$0.macroId = ((Macro) list.get(i5)).getGUID();
            String name = ((Macro) list.get(i5)).getName();
            Intrinsics.checkNotNullExpressionValue(name, "macroList[position - 1].name");
            this$0.macroName = name;
        }
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(MacroFinishedTrigger this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void configureOnImport() {
        Macro macroByName;
        if (MacroStore.getInstance().getMacroByGUID(this.macroId) == null && (macroByName = MacroStore.getInstance().getMacroByName(this.macroName)) != null) {
            this.macroId = macroByName.getGUID();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str;
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(this.macroId);
        if (macroByGUID != null) {
            str = macroByGUID.getName();
        } else {
            str = null;
        }
        if (str == null) {
            return this.macroName;
        }
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return MacroFinishedTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    @NotNull
    public List<String> getMacroNames() {
        List<String> listOf;
        listOf = kotlin.collections.e.listOf(this.macroName);
        return listOf;
    }

    public final long getSelectedMacroGuid() {
        long j4 = this.macroId;
        if (j4 != -1) {
            return j4;
        }
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "{\n            macroGuid\n        }");
        return macroGuid.longValue();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return true;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        int collectionSizeOrDefault;
        List mutableList;
        boolean z3;
        final List<Macro> macroList = MacroStore.getInstance().getAllCompletedMacrosSorted(true);
        Iterator<Macro> it = macroList.iterator();
        while (it.hasNext()) {
            if (it.next().getGUID() == getMacro().getGUID()) {
                it.remove();
            }
        }
        Intrinsics.checkNotNullExpressionValue(macroList, "macroList");
        Iterator<Macro> it2 = macroList.iterator();
        int i4 = 0;
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().getGUID() == this.macroId) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    break;
                }
                i4++;
            } else {
                i4 = -1;
                break;
            }
        }
        int i5 = i4 + 1;
        List<Macro> list = macroList;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (Macro macro : list) {
            arrayList.add(macro.getName());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        mutableList.add(0, SelectableItem.r(R.string.constraint_last_run_time_this_macro));
        String[] strArr = (String[]) mutableList.toArray(new String[0]);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(strArr, i5, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.b5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroFinishedTrigger.P(MacroFinishedTrigger.this, dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.c5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroFinishedTrigger.Q(MacroFinishedTrigger.this, macroList, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.triggers.d5
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                MacroFinishedTrigger.R(MacroFinishedTrigger.this, dialogInterface);
            }
        });
        if (strArr.length > 50) {
            ListView listView = create.getListView();
            listView.setFastScrollEnabled(true);
            listView.setPadding(0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.fast_scroll_padding), 0);
            listView.setScrollBarStyle(33554432);
        }
    }

    @Override // com.arlosoft.macrodroid.categories.HasMacroNames
    public void setMacroNames(@NotNull List<String> macroNames) {
        Intrinsics.checkNotNullParameter(macroNames, "macroNames");
        if (macroNames.size() == 1) {
            this.macroName = macroNames.get(0);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        out.writeLong(this.macroId);
        out.writeString(this.macroName);
    }

    public MacroFinishedTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public MacroFinishedTrigger() {
        this.macroId = -1L;
        this.macroName = "";
    }

    private MacroFinishedTrigger(Parcel parcel) {
        super(parcel);
        this.macroId = -1L;
        this.macroName = "";
        this.option = parcel.readInt();
        this.macroId = parcel.readLong();
        String readString = parcel.readString();
        this.macroName = readString != null ? readString : "";
    }

    /* compiled from: MacroFinishedTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
    }
}
