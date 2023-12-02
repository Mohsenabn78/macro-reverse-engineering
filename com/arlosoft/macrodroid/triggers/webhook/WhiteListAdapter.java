package com.arlosoft.macrodroid.triggers.webhook;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.ViewWhitelistItemBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.arlosoft.macrodroid.triggers.webhook.WhiteListAdapter;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WhiteListAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class WhiteListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f15709a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Function1<String, Unit> f15710b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function1<String, Unit> f15711c;

    /* compiled from: WhiteListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ViewWhitelistItemBinding f15712a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final Function1<String, Unit> f15713b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final Function1<String, Unit> f15714c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: WhiteListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $item;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$item = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void c(ViewHolder viewHolder, String str, DialogInterface dialogInterface, int i4) {
                if (i4 != 0) {
                    if (i4 == 1) {
                        viewHolder.getDeleteItemCallback().invoke(str);
                        return;
                    }
                    return;
                }
                viewHolder.getEditItemCallback().invoke(str);
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: b */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$item, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    String[] strArr = {ViewHolder.this.f15712a.getRoot().getContext().getString(R.string.edit), ViewHolder.this.f15712a.getRoot().getContext().getString(R.string.delete)};
                    AlertDialog.Builder builder = new AlertDialog.Builder(ViewHolder.this.f15712a.getRoot().getContext(), R.style.Theme_App_Dialog_Trigger_NoTitle);
                    final ViewHolder viewHolder = ViewHolder.this;
                    final String str = this.$item;
                    builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.webhook.a
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i4) {
                            WhiteListAdapter.ViewHolder.a.c(WhiteListAdapter.ViewHolder.this, str, dialogInterface, i4);
                        }
                    });
                    builder.show();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public ViewHolder(@NotNull ViewWhitelistItemBinding binding, @NotNull Function1<? super String, Unit> deleteItemCallback, @NotNull Function1<? super String, Unit> editItemCallback) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(deleteItemCallback, "deleteItemCallback");
            Intrinsics.checkNotNullParameter(editItemCallback, "editItemCallback");
            this.f15712a = binding;
            this.f15713b = deleteItemCallback;
            this.f15714c = editItemCallback;
        }

        public final void bind(@NotNull String item) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.f15712a.ipAddress.setText(item);
            TextView textView = this.f15712a.ipAddress;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.ipAddress");
            ViewExtensionsKt.onClick$default(textView, null, new a(item, null), 1, null);
        }

        @NotNull
        public final Function1<String, Unit> getDeleteItemCallback() {
            return this.f15713b;
        }

        @NotNull
        public final Function1<String, Unit> getEditItemCallback() {
            return this.f15714c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WhiteListAdapter(@NotNull List<String> items, @NotNull Function1<? super String, Unit> deleteItemCallback, @NotNull Function1<? super String, Unit> editItemCallback) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(deleteItemCallback, "deleteItemCallback");
        Intrinsics.checkNotNullParameter(editItemCallback, "editItemCallback");
        this.f15709a = items;
        this.f15710b = deleteItemCallback;
        this.f15711c = editItemCallback;
    }

    @NotNull
    public final Function1<String, Unit> getDeleteItemCallback() {
        return this.f15710b;
    }

    @NotNull
    public final Function1<String, Unit> getEditItemCallback() {
        return this.f15711c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15709a.size();
    }

    @NotNull
    public final List<String> getItems() {
        return this.f15709a;
    }

    public final void setItems(@NotNull List<String> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.f15709a.clear();
        this.f15709a.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f15709a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewWhitelistItemBinding inflate = ViewWhitelistItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate, this.f15710b, this.f15711c);
    }
}
