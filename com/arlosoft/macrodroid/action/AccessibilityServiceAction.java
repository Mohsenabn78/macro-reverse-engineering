package com.arlosoft.macrodroid.action;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.util.SparseBooleanArray;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.AccessibilityServiceActionInfo;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AccessibilityServiceAction.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nAccessibilityServiceAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccessibilityServiceAction.kt\ncom/arlosoft/macrodroid/action/AccessibilityServiceAction\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,198:1\n1549#2:199\n1620#2,3:200\n1549#2:205\n1620#2,3:206\n1045#2:211\n37#3,2:203\n12544#4,2:209\n12544#4,2:212\n*S KotlinDebug\n*F\n+ 1 AccessibilityServiceAction.kt\ncom/arlosoft/macrodroid/action/AccessibilityServiceAction\n*L\n132#1:199\n132#1:200,3\n134#1:205\n134#1:206,3\n179#1:211\n132#1:203,2\n135#1:209,2\n144#1:212,2\n*E\n"})
/* loaded from: classes2.dex */
public final class AccessibilityServiceAction extends Action {
    @NotNull
    private final ArrayList<String> idList;
    @NotNull
    private final ArrayList<String> nameList;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AccessibilityServiceAction> CREATOR = new Parcelable.Creator<AccessibilityServiceAction>() { // from class: com.arlosoft.macrodroid.action.AccessibilityServiceAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AccessibilityServiceAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccessibilityServiceAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AccessibilityServiceAction[] newArray(int i4) {
            return new AccessibilityServiceAction[i4];
        }
    };

    /* compiled from: AccessibilityServiceAction.kt */
    /* loaded from: classes2.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean contains$default;
            boolean contains$default2;
            boolean contains$default3;
            kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                String string = Settings.Secure.getString(AccessibilityServiceAction.this.getContext().getContentResolver(), "enabled_accessibility_services");
                Iterator it = AccessibilityServiceAction.this.idList.iterator();
                boolean z3 = false;
                boolean z4 = false;
                while (it.hasNext()) {
                    String serviceId = (String) it.next();
                    if (AccessibilityServiceAction.this.option == 0) {
                        if (string == null) {
                            string = String.valueOf(serviceId);
                        } else {
                            Intrinsics.checkNotNullExpressionValue(serviceId, "serviceId");
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) serviceId, false, 2, (Object) null);
                            if (!contains$default) {
                                string = string + ":" + serviceId;
                            }
                        }
                        z4 = true;
                    } else {
                        if (AccessibilityServiceAction.this.option == 1) {
                            if (string != null) {
                                Intrinsics.checkNotNullExpressionValue(serviceId, "serviceId");
                                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) serviceId, false, 2, (Object) null);
                                if (contains$default3) {
                                    string = AccessibilityServiceAction.this.P(string, serviceId);
                                }
                            }
                        } else {
                            if (string != null) {
                                Intrinsics.checkNotNullExpressionValue(serviceId, "serviceId");
                                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) serviceId, false, 2, (Object) null);
                                if (contains$default2) {
                                    string = AccessibilityServiceAction.this.P(string, serviceId);
                                }
                            }
                            if (string == null) {
                                string = String.valueOf(serviceId);
                            } else {
                                string = string + ":" + serviceId;
                            }
                        }
                        z4 = true;
                    }
                }
                if (z4) {
                    try {
                        z3 = Settings.Secure.putString(AccessibilityServiceAction.this.getContext().getContentResolver(), "enabled_accessibility_services", string);
                    } catch (Exception unused) {
                        if (RootToolsHelper.isAccessGiven()) {
                            Util.runAsRoot(new String[]{"settings put secure enabled_accessibility_services " + string});
                            z3 = true;
                        }
                    }
                    if (!z3) {
                        Long macroGuid = AccessibilityServiceAction.this.getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                        SystemLog.logError("Could not set accessibility services, you need to grant permission via adb with the command: adb shell pm grant com.arlosoft.macrodroid android.permission.WRITE_SECURE_SETTINGS", macroGuid.longValue());
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ AccessibilityServiceAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final List<AccessibilityServiceData> O() {
        List<AccessibilityServiceData> sortedWith;
        Object systemService = getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) systemService).getInstalledAccessibilityServiceList();
        ArrayList arrayList = new ArrayList();
        for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
            String obj = accessibilityServiceInfo.getResolveInfo().loadLabel(getContext().getPackageManager()).toString();
            String id = accessibilityServiceInfo.getId();
            Intrinsics.checkNotNullExpressionValue(id, "service.id");
            arrayList.add(new AccessibilityServiceData(id, obj));
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.action.AccessibilityServiceAction$getAccessibilityServices$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int compareValues;
                compareValues = kotlin.comparisons.f.compareValues(((AccessibilityServiceData) t3).getName(), ((AccessibilityServiceData) t4).getName());
                return compareValues;
            }
        });
        return sortedWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String P(String str, String str2) {
        int indexOf$default;
        int indexOf$default2;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, RemoteSettings.FORWARD_SLASH_STRING, 0, false, 6, (Object) null);
        String substring = str2.substring(0, Math.max(0, indexOf$default));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) str2, RemoteSettings.FORWARD_SLASH_STRING, 0, false, 6, (Object) null);
        String substring2 = str2.substring(Math.max(0, indexOf$default2 + 1));
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        String str3 = substring + RemoteSettings.FORWARD_SLASH_STRING + substring + substring2;
        replace$default = kotlin.text.m.replace$default(str, ":" + str3, "", false, 4, (Object) null);
        replace$default2 = kotlin.text.m.replace$default(replace$default, str3, "", false, 4, (Object) null);
        replace$default3 = kotlin.text.m.replace$default(replace$default2, ":" + str2, "", false, 4, (Object) null);
        replace$default4 = kotlin.text.m.replace$default(replace$default3, str2, "", false, 4, (Object) null);
        return replace$default4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(boolean[] checkedStates, Ref.BooleanRef anyChecked, DialogInterface dialog, int i4, boolean z3) {
        Intrinsics.checkNotNullParameter(checkedStates, "$checkedStates");
        Intrinsics.checkNotNullParameter(anyChecked, "$anyChecked");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        checkedStates[i4] = z3;
        int length = checkedStates.length;
        boolean z4 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (checkedStates[i5]) {
                z4 = true;
                break;
            } else {
                i5++;
            }
        }
        anyChecked.element = z4;
        ((AlertDialog) dialog).getButton(-1).setEnabled(anyChecked.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(AccessibilityServiceAction this$0, String[] serviceNames, List allServices, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(serviceNames, "$serviceNames");
        Intrinsics.checkNotNullParameter(allServices, "$allServices");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type androidx.appcompat.app.AlertDialog");
        AlertDialog alertDialog = (AlertDialog) dialogInterface;
        alertDialog.getListView().getCheckedItemPositions();
        SparseBooleanArray checkedItemPositions = alertDialog.getListView().getCheckedItemPositions();
        this$0.nameList.clear();
        this$0.idList.clear();
        int size = checkedItemPositions.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (checkedItemPositions.valueAt(i5)) {
                this$0.nameList.add(serviceNames[checkedItemPositions.keyAt(i5)]);
                this$0.idList.add(((AccessibilityServiceData) allServices.get(checkedItemPositions.keyAt(i5))).getId());
            }
        }
        this$0.itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = Companion.a()[this.option];
        ArrayList<String> arrayList = this.nameList;
        return str + ": " + arrayList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return AccessibilityServiceActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return Companion.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        final boolean[] booleanArray;
        final List<AccessibilityServiceData> O = O();
        List<AccessibilityServiceData> list = O;
        collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (AccessibilityServiceData accessibilityServiceData : list) {
            arrayList.add(accessibilityServiceData.getName());
        }
        boolean z3 = false;
        final String[] strArr = (String[]) arrayList.toArray(new String[0]);
        collectionSizeOrDefault2 = kotlin.collections.f.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        for (AccessibilityServiceData accessibilityServiceData2 : list) {
            arrayList2.add(Boolean.valueOf(this.idList.contains(accessibilityServiceData2.getId())));
        }
        booleanArray = CollectionsKt___CollectionsKt.toBooleanArray(arrayList2);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        int length = booleanArray.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            } else if (booleanArray[i4]) {
                z3 = true;
                break;
            } else {
                i4++;
            }
        }
        booleanRef.element = z3;
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(getActivity(), R.style.Theme_App_Dialog_Action).setTitle(getConfiguredName()).setMultiChoiceItems(strArr, booleanArray, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.arlosoft.macrodroid.action.a
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i5, boolean z4) {
                AccessibilityServiceAction.Q(booleanArray, booleanRef, dialogInterface, i5, z4);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                AccessibilityServiceAction.R(AccessibilityServiceAction.this, strArr, O, dialogInterface, i5);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "Builder(activity, R.styl…lete()\n                })");
        AlertDialog create = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
        create.getButton(-1).setEnabled(booleanRef.element);
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        out.writeStringList(this.idList);
        out.writeStringList(this.nameList);
    }

    public AccessibilityServiceAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public AccessibilityServiceAction() {
        this.idList = new ArrayList<>();
        this.nameList = new ArrayList<>();
    }

    private AccessibilityServiceAction(Parcel parcel) {
        super(parcel);
        ArrayList<String> arrayList = new ArrayList<>();
        this.idList = arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.nameList = arrayList2;
        this.option = parcel.readInt();
        parcel.readStringList(arrayList);
        parcel.readStringList(arrayList2);
    }

    /* compiled from: AccessibilityServiceAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] a() {
            return new String[]{SelectableItem.r(R.string.enable), SelectableItem.r(R.string.disable), SelectableItem.r(R.string.toggle)};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
