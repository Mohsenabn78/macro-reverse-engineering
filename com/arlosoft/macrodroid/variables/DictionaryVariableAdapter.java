package com.arlosoft.macrodroid.variables;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.databinding.ListItemVariableMultiEntryBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.anko.Sdk27PropertiesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DictionaryVariableAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class DictionaryVariableAdapter extends RecyclerView.Adapter<EntryViewHolder> implements Filterable {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private VariableValue.Dictionary f16162a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ElementSelectedListener f16163b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private List<VariableValue.DictionaryEntry> f16164c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private List<VariableValue.DictionaryEntry> f16165d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private String f16166e;

    /* compiled from: DictionaryVariableAdapter.kt */
    /* loaded from: classes3.dex */
    public interface ElementSelectedListener {
        void onElementSelected(@NotNull VariableValue.DictionaryEntry dictionaryEntry, boolean z3);
    }

    /* compiled from: DictionaryVariableAdapter.kt */
    /* loaded from: classes3.dex */
    public final class EntryViewHolder extends RecyclerView.ViewHolder {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemVariableMultiEntryBinding f16167a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final ElementSelectedListener f16168b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f16169c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ DictionaryVariableAdapter f16170d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DictionaryVariableAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ VariableValue.DictionaryEntry $dictionaryEntry;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(VariableValue.DictionaryEntry dictionaryEntry, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$dictionaryEntry = dictionaryEntry;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$dictionaryEntry, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    EntryViewHolder.this.f16168b.onElementSelected(this.$dictionaryEntry, true);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DictionaryVariableAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ VariableValue.DictionaryEntry $dictionaryEntry;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(VariableValue.DictionaryEntry dictionaryEntry, Continuation<? super b> continuation) {
                super(3, continuation);
                this.$dictionaryEntry = dictionaryEntry;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new b(this.$dictionaryEntry, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    EntryViewHolder.this.f16168b.onElementSelected(this.$dictionaryEntry, false);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntryViewHolder(@NotNull DictionaryVariableAdapter dictionaryVariableAdapter, @NotNull ListItemVariableMultiEntryBinding binding, ElementSelectedListener elementSelectedListener, boolean z3) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(elementSelectedListener, "elementSelectedListener");
            this.f16170d = dictionaryVariableAdapter;
            this.f16167a = binding;
            this.f16168b = elementSelectedListener;
            this.f16169c = z3;
        }

        public final void bind(@NotNull VariableValue.DictionaryEntry dictionaryEntry) {
            float f4;
            boolean z3;
            Intrinsics.checkNotNullParameter(dictionaryEntry, "dictionaryEntry");
            this.f16167a.key.setText(dictionaryEntry.getKey());
            ViewGroup.LayoutParams layoutParams = this.f16167a.key.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            if (this.f16169c) {
                f4 = 20.0f;
            } else {
                f4 = 50.0f;
            }
            layoutParams2.weight = f4;
            VariableValue variable = dictionaryEntry.getVariable();
            if (!(variable instanceof VariableValue.Empty)) {
                if (variable.getValueAsText().length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    this.f16167a.value.setText(variable.getValueAsText());
                    TextView textView = this.f16167a.value;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.value");
                    Sdk27PropertiesKt.setTextColor(textView, ContextCompat.getColor(this.f16167a.getRoot().getContext(), R.color.white));
                    TextView textView2 = this.f16167a.key;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.key");
                    ViewExtensionsKt.onClick$default(textView2, null, new a(dictionaryEntry, null), 1, null);
                    TextView textView3 = this.f16167a.value;
                    Intrinsics.checkNotNullExpressionValue(textView3, "binding.value");
                    ViewExtensionsKt.onClick$default(textView3, null, new b(dictionaryEntry, null), 1, null);
                    ListItemVariableMultiEntryBinding listItemVariableMultiEntryBinding = this.f16167a;
                    TextView textView4 = listItemVariableMultiEntryBinding.typeLabel;
                    MacroDroidVariable.Companion companion = MacroDroidVariable.Companion;
                    Context context = listItemVariableMultiEntryBinding.getRoot().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
                    textView4.setText(companion.getTypeAsString(context, variable.getVariableType()));
                }
            }
            ListItemVariableMultiEntryBinding listItemVariableMultiEntryBinding2 = this.f16167a;
            listItemVariableMultiEntryBinding2.value.setText(listItemVariableMultiEntryBinding2.getRoot().getContext().getText(R.string.empty));
            TextView textView5 = this.f16167a.value;
            Intrinsics.checkNotNullExpressionValue(textView5, "binding.value");
            Sdk27PropertiesKt.setTextColor(textView5, ContextCompat.getColor(this.f16167a.getRoot().getContext(), R.color.white_transparent));
            TextView textView22 = this.f16167a.key;
            Intrinsics.checkNotNullExpressionValue(textView22, "binding.key");
            ViewExtensionsKt.onClick$default(textView22, null, new a(dictionaryEntry, null), 1, null);
            TextView textView32 = this.f16167a.value;
            Intrinsics.checkNotNullExpressionValue(textView32, "binding.value");
            ViewExtensionsKt.onClick$default(textView32, null, new b(dictionaryEntry, null), 1, null);
            ListItemVariableMultiEntryBinding listItemVariableMultiEntryBinding3 = this.f16167a;
            TextView textView42 = listItemVariableMultiEntryBinding3.typeLabel;
            MacroDroidVariable.Companion companion2 = MacroDroidVariable.Companion;
            Context context2 = listItemVariableMultiEntryBinding3.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "binding.root.context");
            textView42.setText(companion2.getTypeAsString(context2, variable.getVariableType()));
        }
    }

    public DictionaryVariableAdapter(@NotNull VariableValue.Dictionary dictionary, @NotNull ElementSelectedListener elementSelectedListener) {
        List<VariableValue.DictionaryEntry> list;
        Intrinsics.checkNotNullParameter(dictionary, "dictionary");
        Intrinsics.checkNotNullParameter(elementSelectedListener, "elementSelectedListener");
        this.f16162a = dictionary;
        this.f16163b = elementSelectedListener;
        List<VariableValue.DictionaryEntry> entriesSorted = dictionary.getEntriesSorted();
        this.f16164c = entriesSorted;
        list = CollectionsKt___CollectionsKt.toList(entriesSorted);
        this.f16165d = list;
        this.f16166e = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<VariableValue.DictionaryEntry> a(String str) {
        boolean contains$default;
        boolean contains$default2;
        ArrayList arrayList = new ArrayList();
        for (VariableValue.DictionaryEntry dictionaryEntry : this.f16164c) {
            String lowerCase = dictionaryEntry.getKey().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            String lowerCase2 = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null);
            if (!contains$default) {
                String lowerCase3 = dictionaryEntry.getVariable().getValueAsText().toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
                String lowerCase4 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase()");
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) lowerCase4, false, 2, (Object) null);
                if (contains$default2) {
                }
            }
            arrayList.add(dictionaryEntry);
        }
        return arrayList;
    }

    @Override // android.widget.Filterable
    @NotNull
    public Filter getFilter() {
        return new Filter() { // from class: com.arlosoft.macrodroid.variables.DictionaryVariableAdapter$getFilter$1
            @Override // android.widget.Filter
            @NotNull
            protected Filter.FilterResults performFiltering(@NotNull CharSequence constraint) {
                boolean z3;
                Intrinsics.checkNotNullParameter(constraint, "constraint");
                DictionaryVariableAdapter.this.f16166e = constraint.toString();
                if (constraint.length() == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                List a4 = z3 ? DictionaryVariableAdapter.this.f16164c : DictionaryVariableAdapter.this.a(constraint.toString());
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = a4;
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(@NotNull CharSequence constraint, @NotNull Filter.FilterResults results) {
                Intrinsics.checkNotNullParameter(constraint, "constraint");
                Intrinsics.checkNotNullParameter(results, "results");
                DictionaryVariableAdapter dictionaryVariableAdapter = DictionaryVariableAdapter.this;
                Object obj = results.values;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<com.arlosoft.macrodroid.variables.VariableValue.DictionaryEntry>");
                dictionaryVariableAdapter.f16165d = (List) obj;
                DictionaryVariableAdapter.this.notifyDataSetChanged();
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f16165d.size();
    }

    public final void updateDictionary(@NotNull VariableValue.Dictionary dictionary) {
        Intrinsics.checkNotNullParameter(dictionary, "dictionary");
        this.f16162a = dictionary;
        this.f16164c = dictionary.getEntriesSorted();
        getFilter().filter(this.f16166e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull EntryViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f16165d.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public EntryViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ListItemVariableMultiEntryBinding inflate = ListItemVariableMultiEntryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new EntryViewHolder(this, inflate, this.f16163b, this.f16162a.isArray());
    }
}
