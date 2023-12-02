package com.arlosoft.macrodroid.homescreen.tiles.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.databinding.HomeTileBasicLayoutMacroBinding;
import com.arlosoft.macrodroid.databinding.TileHomeScreenBasicBinding;
import com.arlosoft.macrodroid.homescreen.tiles.base.HomeScreenTile;
import com.arlosoft.macrodroid.widget.SquareMaterialCardView;
import com.google.android.material.card.MaterialCardView;
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HomeScreenTilesAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class HomeScreenTilesAdapter extends RecyclerView.Adapter<HomeTileViewHolder> implements DraggableItemAdapter<HomeTileViewHolder> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<HomeScreenTile> f12556a;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HomeScreenTilesAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class BasicViewHolder extends HomeTileViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final HomeTileBasicLayoutMacroBinding f12557b;

        /* renamed from: c  reason: collision with root package name */
        private HomeScreenTile f12558c;

        /* compiled from: HomeScreenTilesAdapter.kt */
        /* loaded from: classes3.dex */
        static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;

            a(Continuation<? super a> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    HomeScreenTile homeScreenTile = BasicViewHolder.this.f12558c;
                    if (homeScreenTile == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tile");
                        homeScreenTile = null;
                    }
                    SquareMaterialCardView squareMaterialCardView = BasicViewHolder.this.f12557b.tileContainer;
                    Intrinsics.checkNotNullExpressionValue(squareMaterialCardView, "binding.tileContainer");
                    ImageView imageView = BasicViewHolder.this.f12557b.icon;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.icon");
                    homeScreenTile.onClick(squareMaterialCardView, imageView);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public BasicViewHolder(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.databinding.HomeTileBasicLayoutMacroBinding r4) {
            /*
                r3 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                com.arlosoft.macrodroid.widget.SquareMaterialCardView r0 = r4.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r3.<init>(r0)
                r3.f12557b = r4
                androidx.constraintlayout.widget.ConstraintLayout r4 = r4.clickContainer
                java.lang.String r0 = "binding.clickContainer"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                com.arlosoft.macrodroid.homescreen.tiles.adapter.HomeScreenTilesAdapter$BasicViewHolder$a r0 = new com.arlosoft.macrodroid.homescreen.tiles.adapter.HomeScreenTilesAdapter$BasicViewHolder$a
                r1 = 0
                r0.<init>(r1)
                r2 = 1
                com.arlosoft.macrodroid.extensions.ViewExtensionsKt.onClick$default(r4, r1, r0, r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.homescreen.tiles.adapter.HomeScreenTilesAdapter.BasicViewHolder.<init>(com.arlosoft.macrodroid.databinding.HomeTileBasicLayoutMacroBinding):void");
        }

        @Override // com.arlosoft.macrodroid.homescreen.tiles.adapter.HomeScreenTilesAdapter.HomeTileViewHolder
        public void bind(@NotNull HomeScreenTile tile) {
            Intrinsics.checkNotNullParameter(tile, "tile");
            this.f12558c = tile;
            this.f12557b.tileContainer.setCardBackgroundColor(tile.getBackgroundColor());
            this.f12557b.title.setText(tile.getTitle());
            this.f12557b.icon.setImageResource(tile.getIconRes());
        }
    }

    /* compiled from: HomeScreenTilesAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: HomeScreenTilesAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class CustomViewHolder extends HomeTileViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final TileHomeScreenBasicBinding f12559b;

        /* renamed from: c  reason: collision with root package name */
        private HomeScreenTile f12560c;

        /* compiled from: HomeScreenTilesAdapter.kt */
        /* loaded from: classes3.dex */
        static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            int label;

            a(Continuation<? super a> continuation) {
                super(3, continuation);
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    HomeScreenTile homeScreenTile = CustomViewHolder.this.f12560c;
                    if (homeScreenTile == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tile");
                        homeScreenTile = null;
                    }
                    MaterialCardView materialCardView = CustomViewHolder.this.f12559b.tileContainer;
                    Intrinsics.checkNotNullExpressionValue(materialCardView, "binding.tileContainer");
                    ImageView imageView = CustomViewHolder.this.f12559b.icon;
                    Intrinsics.checkNotNullExpressionValue(imageView, "binding.icon");
                    homeScreenTile.onClick(materialCardView, imageView);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public CustomViewHolder(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.databinding.TileHomeScreenBasicBinding r4) {
            /*
                r3 = this;
                java.lang.String r0 = "binding"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                com.google.android.material.card.MaterialCardView r0 = r4.getRoot()
                java.lang.String r1 = "binding.root"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                r3.<init>(r0)
                r3.f12559b = r4
                android.widget.LinearLayout r4 = r4.clickableContainer
                java.lang.String r0 = "binding.clickableContainer"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                com.arlosoft.macrodroid.homescreen.tiles.adapter.HomeScreenTilesAdapter$CustomViewHolder$a r0 = new com.arlosoft.macrodroid.homescreen.tiles.adapter.HomeScreenTilesAdapter$CustomViewHolder$a
                r1 = 0
                r0.<init>(r1)
                r2 = 1
                com.arlosoft.macrodroid.extensions.ViewExtensionsKt.onClick$default(r4, r1, r0, r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.homescreen.tiles.adapter.HomeScreenTilesAdapter.CustomViewHolder.<init>(com.arlosoft.macrodroid.databinding.TileHomeScreenBasicBinding):void");
        }

        @Override // com.arlosoft.macrodroid.homescreen.tiles.adapter.HomeScreenTilesAdapter.HomeTileViewHolder
        public void bind(@NotNull HomeScreenTile tile) {
            Intrinsics.checkNotNullParameter(tile, "tile");
            this.f12560c = tile;
            this.f12559b.title.setText(tile.getTitle());
            this.f12559b.icon.setImageResource(tile.getIconRes());
            this.f12559b.tileContainer.setCardBackgroundColor(tile.getBackgroundColor());
            FrameLayout frameLayout = this.f12559b.customContent;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.customContent");
            tile.setCustomViewContents(frameLayout);
        }
    }

    /* compiled from: HomeScreenTilesAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static abstract class HomeTileViewHolder extends AbstractDraggableItemViewHolder {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HomeTileViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public abstract void bind(@NotNull HomeScreenTile homeScreenTile);
    }

    public HomeScreenTilesAdapter(@NotNull List<HomeScreenTile> tiles) {
        Intrinsics.checkNotNullParameter(tiles, "tiles");
        this.f12556a = tiles;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f12556a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f12556a.get(i4).getId();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        return !this.f12556a.get(i4).getSupportsBasicLayout();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanDrop(int i4, int i5) {
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public boolean onCheckCanStartDrag(@NotNull HomeTileViewHolder holder, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return true;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    @Nullable
    public ItemDraggableRange onGetItemDraggableRange(@NotNull HomeTileViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return null;
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragFinished(int i4, int i5, boolean z3) {
        notifyDataSetChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onItemDragStarted(int i4) {
        notifyDataSetChanged();
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
    public void onMoveItem(int i4, int i5) {
        this.f12556a.add(i5, this.f12556a.remove(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull HomeTileViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f12556a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public HomeTileViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i4 == 0) {
            HomeTileBasicLayoutMacroBinding inflate = HomeTileBasicLayoutMacroBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
            return new BasicViewHolder(inflate);
        }
        TileHomeScreenBasicBinding inflate2 = TileHomeScreenBasicBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(LayoutInflater.f….context), parent, false)");
        return new CustomViewHolder(inflate2);
    }
}
