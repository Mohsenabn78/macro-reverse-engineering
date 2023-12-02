package com.arlosoft.macrodroid.templatestore.reportmacro;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReportMacroViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class ReportEntry {
    public static final int $stable = 0;

    /* compiled from: ReportMacroViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Comment extends ReportEntry {
        public static final int $stable = 0;
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final String f13658a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Comment(@NotNull String commentText) {
            super(null);
            Intrinsics.checkNotNullParameter(commentText, "commentText");
            this.f13658a = commentText;
        }

        public static /* synthetic */ Comment copy$default(Comment comment, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = comment.f13658a;
            }
            return comment.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.f13658a;
        }

        @NotNull
        public final Comment copy(@NotNull String commentText) {
            Intrinsics.checkNotNullParameter(commentText, "commentText");
            return new Comment(commentText);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Comment) && Intrinsics.areEqual(this.f13658a, ((Comment) obj).f13658a)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCommentText() {
            return this.f13658a;
        }

        public int hashCode() {
            return this.f13658a.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.f13658a;
            return "Comment(commentText=" + str + ")";
        }
    }

    /* compiled from: ReportMacroViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ReasonCodeWithCount extends ReportEntry {
        public static final int $stable = 0;

        /* renamed from: a  reason: collision with root package name */
        private final int f13659a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13660b;

        public ReasonCodeWithCount(int i4, int i5) {
            super(null);
            this.f13659a = i4;
            this.f13660b = i5;
        }

        public static /* synthetic */ ReasonCodeWithCount copy$default(ReasonCodeWithCount reasonCodeWithCount, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i4 = reasonCodeWithCount.f13659a;
            }
            if ((i6 & 2) != 0) {
                i5 = reasonCodeWithCount.f13660b;
            }
            return reasonCodeWithCount.copy(i4, i5);
        }

        public final int component1() {
            return this.f13659a;
        }

        public final int component2() {
            return this.f13660b;
        }

        @NotNull
        public final ReasonCodeWithCount copy(int i4, int i5) {
            return new ReasonCodeWithCount(i4, i5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReasonCodeWithCount)) {
                return false;
            }
            ReasonCodeWithCount reasonCodeWithCount = (ReasonCodeWithCount) obj;
            if (this.f13659a == reasonCodeWithCount.f13659a && this.f13660b == reasonCodeWithCount.f13660b) {
                return true;
            }
            return false;
        }

        public final int getCount() {
            return this.f13660b;
        }

        public final int getReasonCode() {
            return this.f13659a;
        }

        public int hashCode() {
            return (this.f13659a * 31) + this.f13660b;
        }

        @NotNull
        public String toString() {
            int i4 = this.f13659a;
            int i5 = this.f13660b;
            return "ReasonCodeWithCount(reasonCode=" + i4 + ", count=" + i5 + ")";
        }
    }

    /* compiled from: ReportMacroViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Summary extends ReportEntry {
        public static final int $stable = 0;

        /* renamed from: a  reason: collision with root package name */
        private final int f13661a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13662b;

        public Summary(int i4, int i5) {
            super(null);
            this.f13661a = i4;
            this.f13662b = i5;
        }

        public static /* synthetic */ Summary copy$default(Summary summary, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i4 = summary.f13661a;
            }
            if ((i6 & 2) != 0) {
                i5 = summary.f13662b;
            }
            return summary.copy(i4, i5);
        }

        public final int component1() {
            return this.f13661a;
        }

        public final int component2() {
            return this.f13662b;
        }

        @NotNull
        public final Summary copy(int i4, int i5) {
            return new Summary(i4, i5);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Summary)) {
                return false;
            }
            Summary summary = (Summary) obj;
            if (this.f13661a == summary.f13661a && this.f13662b == summary.f13662b) {
                return true;
            }
            return false;
        }

        public final int getFlagCount() {
            return this.f13662b;
        }

        public final int getStarCount() {
            return this.f13661a;
        }

        public int hashCode() {
            return (this.f13661a * 31) + this.f13662b;
        }

        @NotNull
        public String toString() {
            int i4 = this.f13661a;
            int i5 = this.f13662b;
            return "Summary(starCount=" + i4 + ", flagCount=" + i5 + ")";
        }
    }

    private ReportEntry() {
    }

    public /* synthetic */ ReportEntry(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
