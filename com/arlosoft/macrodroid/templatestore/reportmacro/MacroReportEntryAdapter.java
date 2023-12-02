package com.arlosoft.macrodroid.templatestore.reportmacro;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.databinding.ListItemReportCommentBinding;
import com.arlosoft.macrodroid.databinding.ListItemReportReasonBinding;
import com.arlosoft.macrodroid.databinding.ListItemReportSummaryBinding;
import com.arlosoft.macrodroid.templatestore.reportmacro.ReportEntry;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReportMacroActivity.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class MacroReportEntryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int VIEW_TYPE_COMMENT = 2;
    public static final int VIEW_TYPE_REASON_COUNT = 1;
    public static final int VIEW_TYPE_SUMMARY = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List<ReportEntry> f13654a;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ReportMacroActivity.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class CommentViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemReportCommentBinding f13655a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CommentViewHolder(@NotNull ListItemReportCommentBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f13655a = binding;
        }

        public final void bind(@NotNull ReportEntry.Comment comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            this.f13655a.commentText.setText(comment.getCommentText());
        }
    }

    /* compiled from: ReportMacroActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ReportMacroActivity.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ReasonCodeViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemReportReasonBinding f13656a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReasonCodeViewHolder(@NotNull ListItemReportReasonBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f13656a = binding;
        }

        public final void bind(@NotNull ReportEntry.ReasonCodeWithCount reasonCodeWithCount) {
            int i4;
            Intrinsics.checkNotNullParameter(reasonCodeWithCount, "reasonCodeWithCount");
            ListItemReportReasonBinding listItemReportReasonBinding = this.f13656a;
            TextView textView = listItemReportReasonBinding.reasonText;
            Resources resources = listItemReportReasonBinding.getRoot().getResources();
            int reasonCode = reasonCodeWithCount.getReasonCode();
            if (reasonCode != 0) {
                if (reasonCode != 1) {
                    if (reasonCode != 2) {
                        if (reasonCode != 3) {
                            i4 = R.string.report_macro_reason_exact_copy;
                        } else {
                            i4 = R.string.report_macro_reason_bad_language_offensive;
                        }
                    } else {
                        i4 = R.string.report_macro_reason_non_functional;
                    }
                } else {
                    i4 = R.string.report_macro_reason_trivial_macro;
                }
            } else {
                i4 = R.string.report_macro_reason_spam;
            }
            textView.setText(resources.getString(i4));
            this.f13656a.reasonCount.setText(String.valueOf(reasonCodeWithCount.getCount()));
        }
    }

    /* compiled from: ReportMacroActivity.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class SummaryViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListItemReportSummaryBinding f13657a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SummaryViewHolder(@NotNull ListItemReportSummaryBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.f13657a = binding;
        }

        public final void bind(@NotNull ReportEntry.Summary summary) {
            String format;
            Intrinsics.checkNotNullParameter(summary, "summary");
            this.f13657a.starCount.setText(String.valueOf(summary.getStarCount()));
            this.f13657a.reportCount.setText(String.valueOf(summary.getFlagCount()));
            TextView textView = this.f13657a.starPerReportRatio;
            if (summary.getFlagCount() == 0) {
                format = "NA";
            } else {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(summary.getStarCount() / summary.getFlagCount())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            textView.setText(format);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MacroReportEntryAdapter(@NotNull List<? extends ReportEntry> entries) {
        Intrinsics.checkNotNullParameter(entries, "entries");
        this.f13654a = entries;
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f13654a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i4) {
        return i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i4) {
        ReportEntry reportEntry = this.f13654a.get(i4);
        if (reportEntry instanceof ReportEntry.Summary) {
            return 0;
        }
        if (reportEntry instanceof ReportEntry.ReasonCodeWithCount) {
            return 1;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int i4) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof SummaryViewHolder) {
            ReportEntry reportEntry = this.f13654a.get(i4);
            Intrinsics.checkNotNull(reportEntry, "null cannot be cast to non-null type com.arlosoft.macrodroid.templatestore.reportmacro.ReportEntry.Summary");
            ((SummaryViewHolder) holder).bind((ReportEntry.Summary) reportEntry);
        } else if (holder instanceof ReasonCodeViewHolder) {
            ReportEntry reportEntry2 = this.f13654a.get(i4);
            Intrinsics.checkNotNull(reportEntry2, "null cannot be cast to non-null type com.arlosoft.macrodroid.templatestore.reportmacro.ReportEntry.ReasonCodeWithCount");
            ((ReasonCodeViewHolder) holder).bind((ReportEntry.ReasonCodeWithCount) reportEntry2);
        } else if (holder instanceof CommentViewHolder) {
            ReportEntry reportEntry3 = this.f13654a.get(i4);
            Intrinsics.checkNotNull(reportEntry3, "null cannot be cast to non-null type com.arlosoft.macrodroid.templatestore.reportmacro.ReportEntry.Comment");
            ((CommentViewHolder) holder).bind((ReportEntry.Comment) reportEntry3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int i4) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (i4 != 0) {
            if (i4 != 1) {
                ListItemReportCommentBinding inflate = ListItemReportCommentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "inflate(LayoutInflater.f….context), parent, false)");
                return new CommentViewHolder(inflate);
            }
            ListItemReportReasonBinding inflate2 = ListItemReportReasonBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(LayoutInflater.f….context), parent, false)");
            return new ReasonCodeViewHolder(inflate2);
        }
        ListItemReportSummaryBinding inflate3 = ListItemReportSummaryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(LayoutInflater.f….context), parent, false)");
        return new SummaryViewHolder(inflate3);
    }
}
