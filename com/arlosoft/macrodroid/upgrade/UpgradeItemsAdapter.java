package com.arlosoft.macrodroid.upgrade;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.ItemUpgradeBinding;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: UpgradeItemsAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UpgradeItemsAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<UpgradeBlurbItem> f15893a;

    /* compiled from: UpgradeItemsAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ItemUpgradeBinding f15894a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ItemUpgradeBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f15894a = binding;
        }

        public final void bind(@NotNull UpgradeBlurbItem blurbItem) {
            Intrinsics.checkNotNullParameter(blurbItem, "blurbItem");
            ItemUpgradeBinding itemUpgradeBinding = this.f15894a;
            itemUpgradeBinding.title.setText(itemUpgradeBinding.getRoot().getResources().getString(blurbItem.getTitle()));
            ItemUpgradeBinding itemUpgradeBinding2 = this.f15894a;
            itemUpgradeBinding2.description.setText(itemUpgradeBinding2.getRoot().getResources().getString(blurbItem.getDescription()));
            this.f15894a.image.setImageResource(blurbItem.getImage());
        }
    }

    public UpgradeItemsAdapter(@NotNull List<UpgradeBlurbItem> blurbList) {
        Intrinsics.checkNotNullParameter(blurbList, "blurbList");
        this.f15893a = blurbList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f15893a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f15893a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemUpgradeBinding inflate = ItemUpgradeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate);
    }
}
