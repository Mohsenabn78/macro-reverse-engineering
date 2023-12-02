package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution extends CrashlyticsReport.Session.Event.Application.Execution {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> f29860a;

    /* renamed from: b  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Exception f29861b;

    /* renamed from: c  reason: collision with root package name */
    private final CrashlyticsReport.ApplicationExitInfo f29862c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution.Signal f29863d;

    /* renamed from: e  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> f29864e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Builder {

        /* renamed from: a  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> f29865a;

        /* renamed from: b  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Exception f29866b;

        /* renamed from: c  reason: collision with root package name */
        private CrashlyticsReport.ApplicationExitInfo f29867c;

        /* renamed from: d  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution.Signal f29868d;

        /* renamed from: e  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> f29869e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution build() {
            String str = "";
            if (this.f29868d == null) {
                str = " signal";
            }
            if (this.f29869e == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution(this.f29865a, this.f29866b, this.f29867c, this.f29868d, this.f29869e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setAppExitInfo(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
            this.f29867c = applicationExitInfo;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setBinaries(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList) {
            if (immutableList != null) {
                this.f29869e = immutableList;
                return this;
            }
            throw new NullPointerException("Null binaries");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setException(CrashlyticsReport.Session.Event.Application.Execution.Exception exception) {
            this.f29866b = exception;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setSignal(CrashlyticsReport.Session.Event.Application.Execution.Signal signal) {
            if (signal != null) {
                this.f29868d = signal;
                return this;
            }
            throw new NullPointerException("Null signal");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Builder
        public CrashlyticsReport.Session.Event.Application.Execution.Builder setThreads(ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList) {
            this.f29865a = immutableList;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution execution = (CrashlyticsReport.Session.Event.Application.Execution) obj;
        ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList = this.f29860a;
        if (immutableList != null ? immutableList.equals(execution.getThreads()) : execution.getThreads() == null) {
            CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f29861b;
            if (exception != null ? exception.equals(execution.getException()) : execution.getException() == null) {
                CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f29862c;
                if (applicationExitInfo != null ? applicationExitInfo.equals(execution.getAppExitInfo()) : execution.getAppExitInfo() == null) {
                    if (this.f29863d.equals(execution.getSignal()) && this.f29864e.equals(execution.getBinaries())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @Nullable
    public CrashlyticsReport.ApplicationExitInfo getAppExitInfo() {
        return this.f29862c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @NonNull
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> getBinaries() {
        return this.f29864e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @Nullable
    public CrashlyticsReport.Session.Event.Application.Execution.Exception getException() {
        return this.f29861b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution.Signal getSignal() {
        return this.f29863d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution
    @Nullable
    public ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> getThreads() {
        return this.f29860a;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList = this.f29860a;
        int i4 = 0;
        if (immutableList == null) {
            hashCode = 0;
        } else {
            hashCode = immutableList.hashCode();
        }
        int i5 = (hashCode ^ 1000003) * 1000003;
        CrashlyticsReport.Session.Event.Application.Execution.Exception exception = this.f29861b;
        if (exception == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = exception.hashCode();
        }
        int i6 = (i5 ^ hashCode2) * 1000003;
        CrashlyticsReport.ApplicationExitInfo applicationExitInfo = this.f29862c;
        if (applicationExitInfo != null) {
            i4 = applicationExitInfo.hashCode();
        }
        return ((((i6 ^ i4) * 1000003) ^ this.f29863d.hashCode()) * 1000003) ^ this.f29864e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.f29860a + ", exception=" + this.f29861b + ", appExitInfo=" + this.f29862c + ", signal=" + this.f29863d + ", binaries=" + this.f29864e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution(@Nullable ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.Thread> immutableList, @Nullable CrashlyticsReport.Session.Event.Application.Execution.Exception exception, @Nullable CrashlyticsReport.ApplicationExitInfo applicationExitInfo, CrashlyticsReport.Session.Event.Application.Execution.Signal signal, ImmutableList<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> immutableList2) {
        this.f29860a = immutableList;
        this.f29861b = exception;
        this.f29862c = applicationExitInfo;
        this.f29863d = signal;
        this.f29864e = immutableList2;
    }
}
