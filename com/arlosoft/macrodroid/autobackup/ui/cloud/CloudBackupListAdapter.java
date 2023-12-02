package com.arlosoft.macrodroid.autobackup.ui.cloud;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.ItemAutobackupFileBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.google.android.material.card.MaterialCardView;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CloudBackupListAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CloudBackupListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private List<BackupInfo> f9382a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final AutoBackupCloudViewModel f9383b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f9384c;

    /* compiled from: CloudBackupListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ItemAutobackupFileBinding f9385a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final AutoBackupCloudViewModel f9386b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final String f9387c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CloudBackupListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ BackupInfo $backupInfo;
            final /* synthetic */ String $fileName;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BackupInfo backupInfo, String str, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$backupInfo = backupInfo;
                this.$fileName = str;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$backupInfo, this.$fileName, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f9386b.onCloudBackupFileClicked(this.$backupInfo, this.$fileName);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CloudBackupListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ BackupInfo $backupInfo;
            final /* synthetic */ String $fileName;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(BackupInfo backupInfo, String str, Continuation<? super b> continuation) {
                super(3, continuation);
                this.$backupInfo = backupInfo;
                this.$fileName = str;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new b(this.$backupInfo, this.$fileName, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f9386b.onCloudBackupFileLongClicked(this.$backupInfo, this.$fileName);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ItemAutobackupFileBinding binding, @NotNull AutoBackupCloudViewModel viewModel, @Nullable String str) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            this.f9385a = binding;
            this.f9386b = viewModel;
            this.f9387c = str;
        }

        private final String a(BackupInfo backupInfo) {
            int lastIndexOf$default;
            int indexOf$default;
            List split$default;
            String str;
            try {
                String name = backupInfo.getName();
                lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) backupInfo.getName(), "___", 0, false, 6, (Object) null);
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) backupInfo.getName(), ".zip", 0, false, 6, (Object) null);
                String substring = name.substring(lastIndexOf$default + 3, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                if (!substring.equals(this.f9387c)) {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) backupInfo.getName(), new String[]{"___"}, false, 0, 6, (Object) null);
                    str = split$default.get(1) + " (" + split$default.get(2) + ")";
                } else {
                    str = this.itemView.getContext().getString(R.string.cloud_backup_this_device);
                }
                Intrinsics.checkNotNullExpressionValue(str, "{\n\n                val f…          }\n            }");
                return str;
            } catch (Exception unused) {
                return "";
            }
        }

        private final String b(BackupInfo backupInfo) {
            int indexOf$default;
            try {
                String name = backupInfo.getName();
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) backupInfo.getName(), "___", 0, false, 6, (Object) null);
                String substring = name.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                long parseLong = Long.parseLong(substring);
                DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(this.itemView.getContext());
                DateFormat timeFormat = android.text.format.DateFormat.getTimeFormat(this.itemView.getContext());
                Date date = new Date(parseLong);
                String format = dateFormat.format(date);
                String format2 = timeFormat.format(date);
                return format + " - " + format2;
            } catch (Exception unused) {
                return TypeDescription.Generic.OfWildcardType.SYMBOL;
            }
        }

        public final void bind(@NotNull BackupInfo backupInfo) {
            Intrinsics.checkNotNullParameter(backupInfo, "backupInfo");
            String b4 = b(backupInfo);
            this.f9385a.fileName.setText(b(backupInfo));
            this.f9385a.infoLabel.setText(a(backupInfo));
            MaterialCardView materialCardView = this.f9385a.container;
            Intrinsics.checkNotNullExpressionValue(materialCardView, "binding.container");
            ViewExtensionsKt.onClick$default(materialCardView, null, new a(backupInfo, b4, null), 1, null);
            MaterialCardView materialCardView2 = this.f9385a.container;
            Intrinsics.checkNotNullExpressionValue(materialCardView2, "binding.container");
            ViewExtensionsKt.onLongClick$default(materialCardView2, null, false, new b(backupInfo, b4, null), 3, null);
        }
    }

    public CloudBackupListAdapter(@NotNull List<BackupInfo> backupList, @NotNull AutoBackupCloudViewModel viewModel) {
        Intrinsics.checkNotNullParameter(backupList, "backupList");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.f9382a = backupList;
        this.f9383b = viewModel;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9382a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return this.f9382a.get(i4).getTimeStamp();
    }

    public final void setDeviceId(@Nullable String str) {
        this.f9384c = str;
    }

    public final void setItems(@NotNull List<BackupInfo> backupList) {
        Intrinsics.checkNotNullParameter(backupList, "backupList");
        this.f9382a = backupList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f9382a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemAutobackupFileBinding inflate = ItemAutobackupFileBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate, this.f9383b, this.f9384c);
    }
}
