package com.arlosoft.macrodroid.autobackup.ui;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.autobackup.model.BackupFile;
import com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalPresenter;
import com.arlosoft.macrodroid.databinding.ItemAutobackupFileBinding;
import com.arlosoft.macrodroid.extensions.ViewExtensionsKt;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BackupFileListAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class BackupFileListAdapter extends RecyclerView.Adapter<ViewHolder> {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<BackupFile> f9313a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final AutoBackupLocalPresenter f9314b;

    /* compiled from: BackupFileListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ItemAutobackupFileBinding f9315a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final AutoBackupLocalPresenter f9316b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BackupFileListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class a extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ BackupFile $backupFile;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(BackupFile backupFile, Continuation<? super a> continuation) {
                super(3, continuation);
                this.$backupFile = backupFile;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new a(this.$backupFile, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f9316b.onBackupSelected(this.$backupFile);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: BackupFileListAdapter.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
            final /* synthetic */ BackupFile $backupFile;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(BackupFile backupFile, Continuation<? super b> continuation) {
                super(3, continuation);
                this.$backupFile = backupFile;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            /* renamed from: a */
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable View view, @Nullable Continuation<? super Unit> continuation) {
                return new b(this.$backupFile, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    ViewHolder.this.f9316b.onBackupLongClicked(this.$backupFile);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull ItemAutobackupFileBinding binding, @NotNull AutoBackupLocalPresenter presenter) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(presenter, "presenter");
            this.f9315a = binding;
            this.f9316b = presenter;
        }

        public final void bind(@NotNull BackupFile backupFile) {
            Intrinsics.checkNotNullParameter(backupFile, "backupFile");
            this.f9315a.fileName.setText(backupFile.getFile().getName());
            this.f9315a.infoLabel.setText(DateUtils.getRelativeTimeSpanString(backupFile.getFile().lastModified()));
            MaterialCardView materialCardView = this.f9315a.container;
            Intrinsics.checkNotNullExpressionValue(materialCardView, "binding.container");
            ViewExtensionsKt.onClick$default(materialCardView, null, new a(backupFile, null), 1, null);
            MaterialCardView materialCardView2 = this.f9315a.container;
            Intrinsics.checkNotNullExpressionValue(materialCardView2, "binding.container");
            ViewExtensionsKt.onLongClick$default(materialCardView2, null, false, new b(backupFile, null), 3, null);
        }
    }

    public BackupFileListAdapter(@NotNull List<BackupFile> fileList, @NotNull AutoBackupLocalPresenter presenter) {
        Intrinsics.checkNotNullParameter(fileList, "fileList");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.f9313a = fileList;
        this.f9314b = presenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f9313a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.bind(this.f9313a.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemAutobackupFileBinding inflate = ItemAutobackupFileBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
        return new ViewHolder(inflate, this.f9314b);
    }
}
