package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {

    /* renamed from: a  reason: collision with root package name */
    private final long f29900a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29901b;

    /* renamed from: c  reason: collision with root package name */
    private final String f29902c;

    /* renamed from: d  reason: collision with root package name */
    private final long f29903d;

    /* renamed from: e  reason: collision with root package name */
    private final int f29904e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f29905a;

        /* renamed from: b  reason: collision with root package name */
        private String f29906b;

        /* renamed from: c  reason: collision with root package name */
        private String f29907c;

        /* renamed from: d  reason: collision with root package name */
        private Long f29908d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f29909e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame build() {
            String str = "";
            if (this.f29905a == null) {
                str = " pc";
            }
            if (this.f29906b == null) {
                str = str + " symbol";
            }
            if (this.f29908d == null) {
                str = str + " offset";
            }
            if (this.f29909e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.f29905a.longValue(), this.f29906b, this.f29907c, this.f29908d.longValue(), this.f29909e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setFile(String str) {
            this.f29907c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setImportance(int i4) {
            this.f29909e = Integer.valueOf(i4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setOffset(long j4) {
            this.f29908d = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setPc(long j4) {
            this.f29905a = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder setSymbol(String str) {
            if (str != null) {
                this.f29906b = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
        if (this.f29900a == frame.getPc() && this.f29901b.equals(frame.getSymbol()) && ((str = this.f29902c) != null ? str.equals(frame.getFile()) : frame.getFile() == null) && this.f29903d == frame.getOffset() && this.f29904e == frame.getImportance()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    @Nullable
    public String getFile() {
        return this.f29902c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public int getImportance() {
        return this.f29904e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public long getOffset() {
        return this.f29903d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public long getPc() {
        return this.f29900a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    @NonNull
    public String getSymbol() {
        return this.f29901b;
    }

    public int hashCode() {
        int hashCode;
        long j4 = this.f29900a;
        int hashCode2 = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f29901b.hashCode()) * 1000003;
        String str = this.f29902c;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j5 = this.f29903d;
        return this.f29904e ^ ((((hashCode2 ^ hashCode) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.f29900a + ", symbol=" + this.f29901b + ", file=" + this.f29902c + ", offset=" + this.f29903d + ", importance=" + this.f29904e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j4, String str, @Nullable String str2, long j5, int i4) {
        this.f29900a = j4;
        this.f29901b = str;
        this.f29902c = str2;
        this.f29903d = j5;
        this.f29904e = i4;
    }
}
