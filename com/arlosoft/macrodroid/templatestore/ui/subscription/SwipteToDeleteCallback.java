package com.arlosoft.macrodroid.templatestore.ui.subscription;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.extensions.IntExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SwipteToDeleteCallback.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public class SwipteToDeleteCallback extends ItemTouchHelper.SimpleCallback {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f13860a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13861b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Function1<Integer, Unit> f13862c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SwipteToDeleteCallback(@NotNull Drawable deleteIcon, int i4, @NotNull Function1<? super Integer, Unit> itemDeletedHandler) {
        super(0, i4);
        Intrinsics.checkNotNullParameter(deleteIcon, "deleteIcon");
        Intrinsics.checkNotNullParameter(itemDeletedHandler, "itemDeletedHandler");
        this.f13860a = deleteIcon;
        this.f13861b = i4;
        this.f13862c = itemDeletedHandler;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(@NotNull Canvas c4, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, float f4, float f5, int i4, boolean z3) {
        int right;
        int i5;
        Intrinsics.checkNotNullParameter(c4, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        super.onChildDraw(c4, recyclerView, viewHolder, f4, f5, i4, z3);
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
        int px = IntExtensionsKt.getPx(8);
        int top = view.getTop() + ((view.getHeight() - this.f13860a.getIntrinsicHeight()) / 2);
        int intrinsicHeight = this.f13860a.getIntrinsicHeight() + top;
        if (this.f13861b == 8) {
            right = view.getLeft() + px;
            i5 = view.getLeft() + px + this.f13860a.getIntrinsicWidth();
        } else {
            int right2 = view.getRight() - px;
            right = (view.getRight() - px) - this.f13860a.getIntrinsicWidth();
            i5 = right2;
        }
        this.f13860a.setBounds(right, top, i5, intrinsicHeight);
        this.f13860a.draw(c4);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder viewHolder, @NotNull RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(@NotNull RecyclerView.ViewHolder viewHolder, int i4) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (i4 == 4 || i4 == 8) {
            this.f13862c.invoke(Integer.valueOf(viewHolder.getBindingAdapterPosition()));
        }
    }
}
