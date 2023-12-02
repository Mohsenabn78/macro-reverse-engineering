package com.arlosoft.macrodroid.constraint;

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
import com.arlosoft.macrodroid.constraint.info.MacroRunningConstraintInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MacroRunningConstraint.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nMacroRunningConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MacroRunningConstraint.kt\ncom/arlosoft/macrodroid/constraint/MacroRunningConstraint\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,196:1\n350#2,7:197\n1549#2:204\n1620#2,3:205\n37#3,2:208\n*S KotlinDebug\n*F\n+ 1 MacroRunningConstraint.kt\ncom/arlosoft/macrodroid/constraint/MacroRunningConstraint\n*L\n126#1:197,7\n128#1:204\n128#1:205,3\n130#1:208,2\n*E\n"})
/* loaded from: classes3.dex */
public final class MacroRunningConstraint extends Constraint implements HasMacroNames {
    private static final long GUID_THIS_MACRO = -1;
    private static final int OPTION_NOT_RUNNING = 1;
    private static final int OPTION_RUNNING = 0;
    private long macroId;
    @NotNull
    private String macroName;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<MacroRunningConstraint> CREATOR = new Parcelable.Creator<MacroRunningConstraint>() { // from class: com.arlosoft.macrodroid.constraint.MacroRunningConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroRunningConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MacroRunningConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MacroRunningConstraint[] newArray(int i4) {
            return new MacroRunningConstraint[i4];
        }
    };

    public /* synthetic */ MacroRunningConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void R() {
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
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.a3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroRunningConstraint.S(MacroRunningConstraint.this, dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.b3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                MacroRunningConstraint.T(MacroRunningConstraint.this, macroList, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.constraint.c3
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                MacroRunningConstraint.U(MacroRunningConstraint.this, dialogInterface);
            }
        });
        if (strArr.length > 50) {
            ListView listView = create.getListView();
            listView.setFastScrollEnabled(true);
            listView.setPadding(0, 0, getContext().getResources().getDimensionPixelSize(R.dimen.fast_scroll_padding), 0);
            listView.setScrollBarStyle(33554432);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(MacroRunningConstraint this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(MacroRunningConstraint this$0, List list, DialogInterface dialogInterface, int i4) {
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
    public static final void U(MacroRunningConstraint this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        if (this.macroId == -1) {
            if (this.option == 0) {
                Macro macro = getMacro();
                Intrinsics.checkNotNull(macro);
                return macro.isRunning();
            }
            Macro macro2 = getMacro();
            Intrinsics.checkNotNull(macro2);
            if (!macro2.isRunning()) {
                return true;
            }
            return false;
        }
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(this.macroId);
        if (macroByGUID != null) {
            if (this.option == 0) {
                return macroByGUID.isRunning();
            }
            if (!macroByGUID.isRunning()) {
                return true;
            }
            return false;
        }
        Macro macroByName = MacroStore.getInstance().getMacroByName(this.macroName);
        if (macroByName != null) {
            if (this.option == 0) {
                return macroByName.isRunning();
            }
            if (!macroByName.isRunning()) {
                return true;
            }
            return false;
        }
        long j4 = this.macroId;
        String str = this.macroName;
        SystemLog.logError("Macro Running constraint could not find macro with id: " + j4 + " and name: " + str);
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void configureOnImport() {
        Macro macroByName;
        if (MacroStore.getInstance().getMacroByGUID(this.macroId) == null && (macroByName = MacroStore.getInstance().getMacroByName(this.macroName)) != null) {
            this.macroId = macroByName.getGUID();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getConfiguredName() {
        return Companion.getOptions()[this.option];
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
        return MacroRunningConstraintInfo.Companion.getInstance();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return Companion.getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        R();
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

    public MacroRunningConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    private MacroRunningConstraint() {
        this.macroId = -1L;
        this.macroName = "";
    }

    private MacroRunningConstraint(Parcel parcel) {
        super(parcel);
        this.macroId = -1L;
        this.macroName = "";
        this.option = parcel.readInt();
        this.macroId = parcel.readLong();
        String readString = parcel.readString();
        this.macroName = readString != null ? readString : "";
    }

    /* compiled from: MacroRunningConstraint.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String[] getOptions() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String r4 = SelectableItem.r(R.string.constraint_macro_running_option_running);
            Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.const…o_running_option_running)");
            String format = String.format(r4, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String r5 = SelectableItem.r(R.string.constraint_macro_running_option_not_running);
            Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.const…nning_option_not_running)");
            String format2 = String.format(r5, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return new String[]{format, format2};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
