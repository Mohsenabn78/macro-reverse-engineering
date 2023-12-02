package com.arlosoft.macrodroid.logcat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ItemLogcatMessageBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogcatMessageAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LogcatMessageAdapter extends RecyclerView.Adapter<ViewHolder> implements Filterable {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<LogcatMessage> f12639a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final LogcatMessageClickListener f12640b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private List<LogcatMessage> f12641c;

    /* compiled from: LogcatMessageAdapter.kt */
    /* loaded from: classes3.dex */
    public interface LogcatMessageClickListener {
        void onLogcatMessageClicked(@NotNull LogcatMessage logcatMessage);
    }

    /* compiled from: LogcatMessageAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ItemLogcatMessageBinding f12642a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final LogcatMessageClickListener f12643b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LogcatMessageAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ LogcatMessage $logcatMessage;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(LogcatMessage logcatMessage, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$logcatMessage = logcatMessage;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$logcatMessage, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f12643b.onLogcatMessageClicked(this.$logcatMessage);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ItemLogcatMessageBinding binding, @NotNull LogcatMessageClickListener clickListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(clickListener, "clickListener");
            this.f12642a = binding;
            this.f12643b = clickListener;
        }

        public final void bind(@NotNull LogcatMessage logcatMessage) {
            Intrinsics.checkNotNullParameter(logcatMessage, "logcatMessage");
            this.f12642a.componentName.setText(logcatMessage.getComponent());
            this.f12642a.message.setText(logcatMessage.getMessage());
            LinearLayout linearLayout = this.f12642a.container;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.container");
            ViewExtensionsKt.onClick$default(linearLayout, null, new a(logcatMessage, null), 1, null);
        }
    }

    public LogcatMessageAdapter(@NotNull List<LogcatMessage> logcatList, @NotNull LogcatMessageClickListener clickListener) {
        Intrinsics.checkNotNullParameter(logcatList, "logcatList");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        this.f12639a = logcatList;
        this.f12640b = clickListener;
        this.f12641c = logcatList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<LogcatMessage> a(@NotNull String constraint) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(constraint, "constraint");
        ArrayList arrayList = new ArrayList();
        for (LogcatMessage logcatMessage : this.f12639a) {
            String lowerCase = logcatMessage.getMessage().toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) constraint, false, 2, (Object) null);
            if (contains$default) {
                arrayList.add(logcatMessage);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(@NotNull List<LogcatMessage> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f12641c = list;
    }

    @Override // android.widget.Filterable
    @NotNull
    public Filter getFilter() {
        return new Filter() { // from class: com.arlosoft.macrodroid.logcat.LogcatMessageAdapter$getFilter$1
            @Override // android.widget.Filter
            @Nullable
            protected Filter.FilterResults performFiltering(@NotNull CharSequence constraint) {
                List<LogcatMessage> a4;
                Intrinsics.checkNotNullParameter(constraint, "constraint");
                if (constraint.length() == 0) {
                    a4 = LogcatMessageAdapter.this.f12639a;
                } else {
                    LogcatMessageAdapter logcatMessageAdapter = LogcatMessageAdapter.this;
                    String lowerCase = constraint.toString().toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    a4 = logcatMessageAdapter.a(lowerCase);
                }
                Filter.FilterResults filterResults = new Filter.FilterResults();
                filterResults.values = a4;
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(@NotNull CharSequence constraint, @NotNull Filter.FilterResults results) {
                Intrinsics.checkNotNullParameter(constraint, "constraint");
                Intrinsics.checkNotNullParameter(results, "results");
                LogcatMessageAdapter logcatMessageAdapter = LogcatMessageAdapter.this;
                Object obj = results.values;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<com.arlosoft.macrodroid.logcat.LogcatMessage>");
                logcatMessageAdapter.b((List) obj);
                LogcatMessageAdapter.this.notifyDataSetChanged();
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12641c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f12641c.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemLogcatMessageBinding inflate = ItemLogcatMessageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate, this.f12640b);
    }
}
