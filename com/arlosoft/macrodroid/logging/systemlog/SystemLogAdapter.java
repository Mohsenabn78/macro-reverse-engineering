package com.arlosoft.macrodroid.logging.systemlog;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;
import com.arlosoft.macrodroid.database.room.SystemLogEntry;
import com.arlosoft.macrodroid.databinding.ViewSystemLogEntryBinding;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: SystemLogAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SystemLogAdapter extends PagingDataAdapter<SystemLogEntry, SystemLogViewHolder> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MacroMovementMethod f12703a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f12704b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12705c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12706d;

    /* renamed from: e  reason: collision with root package name */
    private int f12707e;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final DiffUtil.ItemCallback<SystemLogEntry> f12702f = new DiffUtil.ItemCallback<SystemLogEntry>() { // from class: com.arlosoft.macrodroid.logging.systemlog.SystemLogAdapter$Companion$diffCallback$1
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        @SuppressLint({"DiffUtilEquals"})
        public boolean areContentsTheSame(@NotNull SystemLogEntry oldItem, @NotNull SystemLogEntry newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(@NotNull SystemLogEntry oldItem, @NotNull SystemLogEntry newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return oldItem.getId() == newItem.getId();
        }
    };

    /* compiled from: SystemLogAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DiffUtil.ItemCallback<SystemLogEntry> getDiffCallback() {
            return SystemLogAdapter.f12702f;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemLogAdapter(@NotNull MacroMovementMethod macroMovementMethod, boolean z3, boolean z4, boolean z5) {
        super(f12702f, null, null, 6, null);
        Intrinsics.checkNotNullParameter(macroMovementMethod, "macroMovementMethod");
        this.f12703a = macroMovementMethod;
        this.f12704b = z3;
        this.f12705c = z4;
        this.f12706d = z5;
    }

    public final void setReversed(boolean z3) {
        this.f12705c = z3;
        notifyDataSetChanged();
    }

    public final void setShowMilliseconds(boolean z3) {
        this.f12706d = z3;
        notifyDataSetChanged();
    }

    public final void setTextSize(int i4) {
        this.f12707e = i4;
        notifyDataSetChanged();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
        if (r0 > 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ab, code lost:
        if (r0 < 0) goto L9;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.logging.systemlog.SystemLogViewHolder r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.Object r0 = r8.getItem(r10)
            r2 = r0
            com.arlosoft.macrodroid.database.room.SystemLogEntry r2 = (com.arlosoft.macrodroid.database.room.SystemLogEntry) r2
            if (r2 == 0) goto Lb9
            r4 = 0
            boolean r0 = r8.f12705c
            r1 = 1
            r3 = 0
            if (r0 != 0) goto L5c
            if (r10 != 0) goto L32
            org.threeten.bp.LocalDate r10 = org.threeten.bp.LocalDate.now()
            long r0 = r2.getTimeStamp()
            org.threeten.bp.LocalDate r0 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.toLocalDate(r0)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r0)
            if (r10 != 0) goto Lae
            long r0 = r2.getTimeStamp()
            org.threeten.bp.LocalDate r10 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.toLocalDate(r0)
            goto L7d
        L32:
            if (r10 <= r1) goto Lae
            int r10 = r10 - r1
            java.lang.Object r10 = r8.getItem(r10)
            com.arlosoft.macrodroid.database.room.SystemLogEntry r10 = (com.arlosoft.macrodroid.database.room.SystemLogEntry) r10
            if (r10 == 0) goto Lae
            long r0 = r10.getTimeStamp()
            org.threeten.bp.LocalDate r10 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.toLocalDate(r0)
            long r0 = r2.getTimeStamp()
            org.threeten.bp.LocalDate r0 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.toLocalDate(r0)
            int r1 = r10.compareTo(r0)
            if (r1 <= 0) goto L55
        L53:
            r3 = r0
            goto Lae
        L55:
            int r0 = r0.compareTo(r10)
            if (r0 <= 0) goto Lae
        L5b:
            goto L7d
        L5c:
            int r0 = r8.getItemCount()
            int r0 = r0 - r1
            if (r10 != r0) goto L7f
            org.threeten.bp.LocalDate r10 = org.threeten.bp.LocalDate.now()
            long r0 = r2.getTimeStamp()
            org.threeten.bp.LocalDate r0 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.toLocalDate(r0)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r0)
            if (r10 != 0) goto Lae
            long r0 = r2.getTimeStamp()
            org.threeten.bp.LocalDate r10 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.toLocalDate(r0)
        L7d:
            r3 = r10
            goto Lae
        L7f:
            int r0 = r8.getItemCount()
            int r0 = r0 + (-2)
            if (r10 >= r0) goto Lae
            int r10 = r10 + r1
            java.lang.Object r10 = r8.getItem(r10)
            com.arlosoft.macrodroid.database.room.SystemLogEntry r10 = (com.arlosoft.macrodroid.database.room.SystemLogEntry) r10
            if (r10 == 0) goto Lae
            long r0 = r10.getTimeStamp()
            org.threeten.bp.LocalDate r10 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.toLocalDate(r0)
            long r0 = r2.getTimeStamp()
            org.threeten.bp.LocalDate r0 = com.arlosoft.macrodroid.extensions.LongExtensionsKt.toLocalDate(r0)
            int r1 = r10.compareTo(r0)
            if (r1 >= 0) goto La7
            goto L53
        La7:
            int r0 = r0.compareTo(r10)
            if (r0 >= 0) goto Lae
            goto L5b
        Lae:
            int r10 = r8.f12707e
            float r5 = (float) r10
            boolean r6 = r8.f12704b
            boolean r7 = r8.f12706d
            r1 = r9
            r1.bind(r2, r3, r4, r5, r6, r7)
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.logging.systemlog.SystemLogAdapter.onBindViewHolder(com.arlosoft.macrodroid.logging.systemlog.SystemLogViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public SystemLogViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ViewSystemLogEntryBinding inflate = ViewSystemLogEntryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new SystemLogViewHolder(inflate, this.f12703a);
    }
}
