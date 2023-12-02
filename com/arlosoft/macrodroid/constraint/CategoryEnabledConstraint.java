package com.arlosoft.macrodroid.constraint;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.categories.HasCategoryName;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.info.CategoryEnabledConstraintInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import me.drakeet.support.toast.ToastCompat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CategoryEnabledConstraint.kt */
@StabilityInferred(parameters = 0)
@TargetApi(21)
@SourceDebugExtension({"SMAP\nCategoryEnabledConstraint.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CategoryEnabledConstraint.kt\ncom/arlosoft/macrodroid/constraint/CategoryEnabledConstraint\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,184:1\n37#2,2:185\n*S KotlinDebug\n*F\n+ 1 CategoryEnabledConstraint.kt\ncom/arlosoft/macrodroid/constraint/CategoryEnabledConstraint\n*L\n148#1:185,2\n*E\n"})
/* loaded from: classes3.dex */
public final class CategoryEnabledConstraint extends Constraint implements HasCategoryName {
    private static final int OPTION_DISABLED = 1;
    private static final int OPTION_ENABLED = 0;
    @Nullable
    private transient List<String> categoryList;
    @Nullable
    private String categoryName;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CategoryEnabledConstraint> CREATOR = new Parcelable.Creator<CategoryEnabledConstraint>() { // from class: com.arlosoft.macrodroid.constraint.CategoryEnabledConstraint$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CategoryEnabledConstraint createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CategoryEnabledConstraint(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CategoryEnabledConstraint[] newArray(int i4) {
            return new CategoryEnabledConstraint[i4];
        }
    };

    public /* synthetic */ CategoryEnabledConstraint(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void Q() {
        int indexOf;
        T();
        List<String> list = this.categoryList;
        Intrinsics.checkNotNull(list);
        if (list.isEmpty()) {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.no_macros_found, 0).show();
            return;
        }
        String string = getContext().getString(R.string.constraint_category_enabled);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…straint_category_enabled)");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        List<String> list2 = this.categoryList;
        Intrinsics.checkNotNull(list2);
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends String>) ((List<? extends Object>) list2), this.categoryName);
        if (indexOf < 0) {
            indexOf = 0;
        }
        builder.setTitle(string);
        List<String> list3 = this.categoryList;
        Intrinsics.checkNotNull(list3);
        builder.setSingleChoiceItems((CharSequence[]) list3.toArray(new String[0]), indexOf, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.f0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CategoryEnabledConstraint.R(CategoryEnabledConstraint.this, dialogInterface, i4);
            }
        });
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.constraint.g0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                CategoryEnabledConstraint.S(CategoryEnabledConstraint.this, dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(CategoryEnabledConstraint this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<String> list = this$0.categoryList;
        Intrinsics.checkNotNull(list);
        this$0.categoryName = list.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(CategoryEnabledConstraint this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.itemComplete();
    }

    private final void T() {
        List<String> mutableList;
        String r4;
        List<Macro> allCompletedMacros = MacroStore.getInstance().getAllCompletedMacros();
        HashSet hashSet = new HashSet();
        for (Macro macro : allCompletedMacros) {
            String category = macro.getCategory();
            if (category != null) {
                hashSet.add(category);
            } else {
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ConfigureAppNotificationsAction: Macro has a null category"));
            }
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) hashSet);
        this.categoryList = mutableList;
        Intrinsics.checkNotNull(mutableList);
        kotlin.collections.h.sort(mutableList);
        List<String> list = this.categoryList;
        Intrinsics.checkNotNull(list);
        list.remove(SelectableItem.r(R.string.uncategorized));
        List<String> list2 = this.categoryList;
        Intrinsics.checkNotNull(list2);
        String r5 = SelectableItem.r(R.string.uncategorized);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.uncategorized)");
        list2.add(0, r5);
        if (this.categoryName == null) {
            List<String> list3 = this.categoryList;
            Intrinsics.checkNotNull(list3);
            if (list3.size() > 0) {
                List<String> list4 = this.categoryList;
                Intrinsics.checkNotNull(list4);
                r4 = list4.get(0);
            } else {
                r4 = SelectableItem.r(R.string.uncategorized);
            }
            this.categoryName = r4;
        }
    }

    private final String[] getOptions() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String r4 = SelectableItem.r(R.string.enabled);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.enabled)");
        String format = String.format(r4, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String r5 = SelectableItem.r(R.string.disabled);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.disabled)");
        String format2 = String.format(r5, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return new String[]{format, format2};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.constraint.Constraint
    public boolean checkOK(@Nullable TriggerContextInfo triggerContextInfo) {
        boolean z3;
        if (this.option == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (Settings.getDisabledCategories(MacroDroidApplication.Companion.getInstance()).contains(this.categoryName) != (!z3)) {
            return false;
        }
        return true;
    }

    @Override // com.arlosoft.macrodroid.categories.HasCategoryName
    @Nullable
    public String getCategory() {
        return this.categoryName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = getOptions()[this.option];
        String str2 = this.categoryName;
        return str + ": " + str2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return CategoryEnabledConstraintInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        return getExtendedDetail();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return getOptions();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.constraint.Constraint, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Q();
    }

    @Override // com.arlosoft.macrodroid.categories.HasCategoryName
    public void setCategory(@NotNull String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.categoryName = category;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        out.writeString(this.categoryName);
    }

    public CategoryEnabledConstraint(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public CategoryEnabledConstraint() {
    }

    private CategoryEnabledConstraint(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
        this.categoryName = parcel.readString();
    }

    /* compiled from: CategoryEnabledConstraint.kt */
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
}
