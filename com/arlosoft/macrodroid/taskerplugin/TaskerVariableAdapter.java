package com.arlosoft.macrodroid.taskerplugin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.StyleRes;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.databinding.ListItemTaskerVariableBinding;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableAdapter;
import com.arlosoft.macrodroid.utils.MDTextUtils;
import com.arlosoft.macrodroid.utils.VariablesHelper;
import com.arlosoft.macrodroid.variables.VariableOrOption;
import com.arlosoft.macrodroid.variables.VariableWithTypeSpinnerAdapter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.e;
import kotlin.collections.f;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TaskerVariableAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class TaskerVariableAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String[] f13626a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f13627b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Activity f13628c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final SelectableItem f13629d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13630e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final List<VarDescriptor> f13631f;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: TaskerVariableAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: TaskerVariableAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class VarDescriptor {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f13632a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final String f13633b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final String f13634c;

        public VarDescriptor(@NotNull String identifier, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.f13632a = identifier;
            this.f13633b = str;
            this.f13634c = str2;
        }

        public static /* synthetic */ VarDescriptor copy$default(VarDescriptor varDescriptor, String str, String str2, String str3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = varDescriptor.f13632a;
            }
            if ((i4 & 2) != 0) {
                str2 = varDescriptor.f13633b;
            }
            if ((i4 & 4) != 0) {
                str3 = varDescriptor.f13634c;
            }
            return varDescriptor.copy(str, str2, str3);
        }

        @NotNull
        public final String component1() {
            return this.f13632a;
        }

        @Nullable
        public final String component2() {
            return this.f13633b;
        }

        @Nullable
        public final String component3() {
            return this.f13634c;
        }

        @NotNull
        public final VarDescriptor copy(@NotNull String identifier, @Nullable String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new VarDescriptor(identifier, str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VarDescriptor)) {
                return false;
            }
            VarDescriptor varDescriptor = (VarDescriptor) obj;
            if (Intrinsics.areEqual(this.f13632a, varDescriptor.f13632a) && Intrinsics.areEqual(this.f13633b, varDescriptor.f13633b) && Intrinsics.areEqual(this.f13634c, varDescriptor.f13634c)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getDescription() {
            return this.f13634c;
        }

        @NotNull
        public final String getIdentifier() {
            return this.f13632a;
        }

        @Nullable
        public final String getName() {
            return this.f13633b;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.f13632a.hashCode() * 31;
            String str = this.f13633b;
            int i4 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i5 = (hashCode2 + hashCode) * 31;
            String str2 = this.f13634c;
            if (str2 != null) {
                i4 = str2.hashCode();
            }
            return i5 + i4;
        }

        @NotNull
        public String toString() {
            String str = this.f13632a;
            String str2 = this.f13633b;
            String str3 = this.f13634c;
            return "VarDescriptor(identifier=" + str + ", name=" + str2 + ", description=" + str3 + ")";
        }

        public /* synthetic */ VarDescriptor(String str, String str2, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i4 & 2) != 0 ? null : str2, (i4 & 4) != 0 ? null : str3);
        }
    }

    /* compiled from: TaskerVariableAdapter.kt */
    @StabilityInferred(parameters = 0)
    @SourceDebugExtension({"SMAP\nTaskerVariableAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskerVariableAdapter.kt\ncom/arlosoft/macrodroid/taskerplugin/TaskerVariableAdapter$ViewHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,156:1\n262#2,2:157\n262#2,2:159\n1549#3:161\n1620#3,3:162\n*S KotlinDebug\n*F\n+ 1 TaskerVariableAdapter.kt\ncom/arlosoft/macrodroid/taskerplugin/TaskerVariableAdapter$ViewHolder\n*L\n46#1:157,2\n48#1:159,2\n106#1:161\n106#1:162,3\n*E\n"})
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemTaskerVariableBinding f13635a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final SelectableItem f13636b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, String> f13637c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final Activity f13638d;

        /* renamed from: e  reason: collision with root package name */
        private final int f13639e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ListItemTaskerVariableBinding binding, @NotNull SelectableItem selectableItem, @NotNull Map<String, String> variableMap, @NotNull Activity activity, @StyleRes int i4) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
            Intrinsics.checkNotNullParameter(variableMap, "variableMap");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.f13635a = binding;
            this.f13636b = selectableItem;
            this.f13637c = variableMap;
            this.f13638d = activity;
            this.f13639e = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(final ViewHolder this$0, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            VariablesHelper.createNewVariable(this$0.f13638d, this$0.f13635a.varSpinner, this$0.f13636b, this$0.f13639e, 2, true, false, new VariablesHelper.VariableCreatedListener() { // from class: n0.c
                @Override // com.arlosoft.macrodroid.utils.VariablesHelper.VariableCreatedListener
                public final void variableCreated(MacroDroidVariable macroDroidVariable) {
                    TaskerVariableAdapter.ViewHolder.d(TaskerVariableAdapter.ViewHolder.this, macroDroidVariable);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ViewHolder this$0, MacroDroidVariable macroDroidVariable) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            List<MacroDroidVariable> variablesOfType = this$0.f13636b.getVariablesOfType(2);
            ArrayList arrayList = new ArrayList();
            String string = this$0.f13638d.getString(R.string.none);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.none)");
            arrayList.add(0, new VariableOrOption.Option(string, 0));
            int i4 = 0;
            int i5 = 0;
            for (MacroDroidVariable variable : variablesOfType) {
                if (Intrinsics.areEqual(macroDroidVariable.getName(), variable.getName())) {
                    i4 = i5 + 1;
                }
                Intrinsics.checkNotNullExpressionValue(variable, "variable");
                arrayList.add(new VariableOrOption.Variable(variable, ""));
                i5++;
            }
            VariableWithTypeSpinnerAdapter variableWithTypeSpinnerAdapter = new VariableWithTypeSpinnerAdapter(this$0.f13638d, arrayList, null);
            variableWithTypeSpinnerAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            this$0.f13635a.varSpinner.setAdapter((SpinnerAdapter) variableWithTypeSpinnerAdapter);
            this$0.f13635a.varSpinner.setSelection(i4, false);
        }

        private final void e(View view, VarDescriptor varDescriptor) {
            int collectionSizeOrDefault;
            ArrayAdapter variableWithTypeSpinnerAdapter;
            VariableOrOption option;
            float f4;
            List listOf;
            ArrayList<MacroDroidVariable> allOutputStringVariables = this.f13636b.getAllOutputStringVariables();
            ArrayList<MacroDroidVariable> allDictionaryAndArrayVariables = this.f13636b.getAllDictionaryAndArrayVariables();
            ArrayList<MacroDroidVariable> arrayList = new ArrayList();
            arrayList.add(0, null);
            final String identifier = varDescriptor.getIdentifier();
            String str = this.f13637c.get(identifier);
            Iterator<MacroDroidVariable> it = allDictionaryAndArrayVariables.iterator();
            int i4 = 0;
            int i5 = 0;
            while (it.hasNext()) {
                i4++;
                MacroDroidVariable next = it.next();
                if (Intrinsics.areEqual(str, next.getName())) {
                    i5 = i4;
                }
                arrayList.add(next);
            }
            Iterator<MacroDroidVariable> it2 = allOutputStringVariables.iterator();
            int i6 = 0;
            while (it2.hasNext()) {
                i6++;
                MacroDroidVariable next2 = it2.next();
                if (Intrinsics.areEqual(str, next2.getName())) {
                    i5 = allDictionaryAndArrayVariables.size() + i6;
                }
                arrayList.add(next2);
            }
            if (arrayList.isEmpty()) {
                Context context = view.getContext();
                listOf = e.listOf(view.getContext().getString(R.string.no_string_variables_defined));
                variableWithTypeSpinnerAdapter = new ArrayAdapter(context, (int) R.layout.simple_spinner_item, listOf);
            } else {
                Activity activity = this.f13638d;
                collectionSizeOrDefault = f.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (MacroDroidVariable macroDroidVariable : arrayList) {
                    if (macroDroidVariable != null) {
                        option = new VariableOrOption.Variable(macroDroidVariable, null, 2, null);
                    } else {
                        String string = this.f13638d.getString(R.string.none);
                        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.string.none)");
                        option = new VariableOrOption.Option(string, 0);
                    }
                    arrayList2.add(option);
                }
                variableWithTypeSpinnerAdapter = new VariableWithTypeSpinnerAdapter(activity, arrayList2, null);
            }
            variableWithTypeSpinnerAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
            this.f13635a.varSpinner.setAdapter((SpinnerAdapter) variableWithTypeSpinnerAdapter);
            this.f13635a.varSpinner.setSelection(i5, false);
            this.f13635a.varSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.arlosoft.macrodroid.taskerplugin.TaskerVariableAdapter$ViewHolder$configureSpinner$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(@Nullable AdapterView<?> adapterView, @Nullable View view2, int i7, long j4) {
                    ListItemTaskerVariableBinding listItemTaskerVariableBinding;
                    float f5;
                    Map map;
                    ListItemTaskerVariableBinding listItemTaskerVariableBinding2;
                    Map map2;
                    listItemTaskerVariableBinding = TaskerVariableAdapter.ViewHolder.this.f13635a;
                    Spinner spinner = listItemTaskerVariableBinding.varSpinner;
                    if (i7 == 0) {
                        f5 = 0.25f;
                    } else {
                        f5 = 1.0f;
                    }
                    spinner.setAlpha(f5);
                    if (i7 == 0) {
                        map2 = TaskerVariableAdapter.ViewHolder.this.f13637c;
                        map2.remove(identifier);
                        return;
                    }
                    map = TaskerVariableAdapter.ViewHolder.this.f13637c;
                    String str2 = identifier;
                    listItemTaskerVariableBinding2 = TaskerVariableAdapter.ViewHolder.this.f13635a;
                    Object selectedItem = listItemTaskerVariableBinding2.varSpinner.getSelectedItem();
                    Intrinsics.checkNotNull(selectedItem, "null cannot be cast to non-null type com.arlosoft.macrodroid.variables.VariableOrOption.Variable");
                    map.put(str2, ((VariableOrOption.Variable) selectedItem).getVariable().getName());
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(@Nullable AdapterView<?> adapterView) {
                }
            });
            Spinner spinner = this.f13635a.varSpinner;
            if (spinner.getSelectedItemPosition() == 0) {
                f4 = 0.25f;
            } else {
                f4 = 1.0f;
            }
            spinner.setAlpha(f4);
        }

        public final void bind(@NotNull VarDescriptor varDescriptor) {
            boolean z3;
            Intrinsics.checkNotNullParameter(varDescriptor, "varDescriptor");
            this.f13635a.varName.setText(varDescriptor.getName());
            if (varDescriptor.getDescription() != null) {
                if (varDescriptor.getDescription().length() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    this.f13635a.varDescription.setText(MDTextUtils.fromHtml(varDescriptor.getDescription()));
                    TextView textView = this.f13635a.varDescription;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.varDescription");
                    textView.setVisibility(0);
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    e(itemView, varDescriptor);
                    this.f13635a.addVarButton.setOnClickListener(new View.OnClickListener() { // from class: n0.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            TaskerVariableAdapter.ViewHolder.c(TaskerVariableAdapter.ViewHolder.this, view);
                        }
                    });
                }
            }
            TextView textView2 = this.f13635a.varDescription;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.varDescription");
            textView2.setVisibility(8);
            View itemView2 = this.itemView;
            Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
            e(itemView2, varDescriptor);
            this.f13635a.addVarButton.setOnClickListener(new View.OnClickListener() { // from class: n0.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskerVariableAdapter.ViewHolder.c(TaskerVariableAdapter.ViewHolder.this, view);
                }
            });
        }
    }

    public TaskerVariableAdapter(@NotNull String[] relevantVariables, @NotNull Map<String, String> variableMap, @NotNull Activity activity, @NotNull SelectableItem selectableItem, @StyleRes int i4) {
        List<VarDescriptor> sortedWith;
        boolean contains$default;
        List split$default;
        Object obj;
        Intrinsics.checkNotNullParameter(relevantVariables, "relevantVariables");
        Intrinsics.checkNotNullParameter(variableMap, "variableMap");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(selectableItem, "selectableItem");
        this.f13626a = relevantVariables;
        this.f13627b = variableMap;
        this.f13628c = activity;
        this.f13629d = selectableItem;
        this.f13630e = i4;
        ArrayList arrayList = new ArrayList();
        for (String str : relevantVariables) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "\n", false, 2, (Object) null);
            if (contains$default) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null);
                String str2 = (String) split$default.get(0);
                if (split$default.size() > 1) {
                    obj = split$default.get(1);
                } else {
                    obj = split$default.get(0);
                }
                arrayList.add(new VarDescriptor(str2, (String) obj, split$default.size() > 2 ? (String) split$default.get(2) : null));
            } else {
                arrayList.add(new VarDescriptor(str, str, null, 4, null));
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.taskerplugin.TaskerVariableAdapter$special$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int compareValues;
                compareValues = kotlin.comparisons.f.compareValues(((TaskerVariableAdapter.VarDescriptor) t3).getName(), ((TaskerVariableAdapter.VarDescriptor) t4).getName());
                return compareValues;
            }
        });
        this.f13631f = sortedWith;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13626a.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f13631f.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemTaskerVariableBinding inflate = ListItemTaskerVariableBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate, this.f13629d, this.f13627b, this.f13628c, this.f13630e);
    }
}
