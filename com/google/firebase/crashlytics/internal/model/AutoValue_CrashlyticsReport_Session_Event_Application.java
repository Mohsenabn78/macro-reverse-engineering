package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes5.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.Session.Event.Application {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReport.Session.Event.Application.Execution f29850a;

    /* renamed from: b  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.CustomAttribute> f29851b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableList<CrashlyticsReport.CustomAttribute> f29852c;

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f29853d;

    /* renamed from: e  reason: collision with root package name */
    private final int f29854e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Builder {

        /* renamed from: a  reason: collision with root package name */
        private CrashlyticsReport.Session.Event.Application.Execution f29855a;

        /* renamed from: b  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.CustomAttribute> f29856b;

        /* renamed from: c  reason: collision with root package name */
        private ImmutableList<CrashlyticsReport.CustomAttribute> f29857c;

        /* renamed from: d  reason: collision with root package name */
        private Boolean f29858d;

        /* renamed from: e  reason: collision with root package name */
        private Integer f29859e;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application build() {
            String str = "";
            if (this.f29855a == null) {
                str = " execution";
            }
            if (this.f29859e == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(this.f29855a, this.f29856b, this.f29857c, this.f29858d, this.f29859e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder setBackground(@Nullable Boolean bool) {
            this.f29858d = bool;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder setCustomAttributes(ImmutableList<CrashlyticsReport.CustomAttribute> immutableList) {
            this.f29856b = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder setExecution(CrashlyticsReport.Session.Event.Application.Execution execution) {
            if (execution != null) {
                this.f29855a = execution;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder setInternalKeys(ImmutableList<CrashlyticsReport.CustomAttribute> immutableList) {
            this.f29857c = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Builder
        public CrashlyticsReport.Session.Event.Application.Builder setUiOrientation(int i4) {
            this.f29859e = Integer.valueOf(i4);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder() {
        }

        private Builder(CrashlyticsReport.Session.Event.Application application) {
            this.f29855a = application.getExecution();
            this.f29856b = application.getCustomAttributes();
            this.f29857c = application.getInternalKeys();
            this.f29858d = application.getBackground();
            this.f29859e = Integer.valueOf(application.getUiOrientation());
        }
    }

    public boolean equals(Object obj) {
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
        if (this.f29850a.equals(application.getExecution()) && ((immutableList = this.f29851b) != null ? immutableList.equals(application.getCustomAttributes()) : application.getCustomAttributes() == null) && ((immutableList2 = this.f29852c) != null ? immutableList2.equals(application.getInternalKeys()) : application.getInternalKeys() == null) && ((bool = this.f29853d) != null ? bool.equals(application.getBackground()) : application.getBackground() == null) && this.f29854e == application.getUiOrientation()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    @Nullable
    public Boolean getBackground() {
        return this.f29853d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    @Nullable
    public ImmutableList<CrashlyticsReport.CustomAttribute> getCustomAttributes() {
        return this.f29851b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    @NonNull
    public CrashlyticsReport.Session.Event.Application.Execution getExecution() {
        return this.f29850a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    @Nullable
    public ImmutableList<CrashlyticsReport.CustomAttribute> getInternalKeys() {
        return this.f29852c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public int getUiOrientation() {
        return this.f29854e;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = (this.f29850a.hashCode() ^ 1000003) * 1000003;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList = this.f29851b;
        int i4 = 0;
        if (immutableList == null) {
            hashCode = 0;
        } else {
            hashCode = immutableList.hashCode();
        }
        int i5 = (hashCode3 ^ hashCode) * 1000003;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2 = this.f29852c;
        if (immutableList2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = immutableList2.hashCode();
        }
        int i6 = (i5 ^ hashCode2) * 1000003;
        Boolean bool = this.f29853d;
        if (bool != null) {
            i4 = bool.hashCode();
        }
        return ((i6 ^ i4) * 1000003) ^ this.f29854e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public CrashlyticsReport.Session.Event.Application.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return "Application{execution=" + this.f29850a + ", customAttributes=" + this.f29851b + ", internalKeys=" + this.f29852c + ", background=" + this.f29853d + ", uiOrientation=" + this.f29854e + "}";
    }

    private AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution execution, @Nullable ImmutableList<CrashlyticsReport.CustomAttribute> immutableList, @Nullable ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2, @Nullable Boolean bool, int i4) {
        this.f29850a = execution;
        this.f29851b = immutableList;
        this.f29852c = immutableList2;
        this.f29853d = bool;
        this.f29854e = i4;
    }
}
