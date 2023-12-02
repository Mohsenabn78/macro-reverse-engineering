package com.miguelbcr.ui.rx_paparazzo2.internal.di;

import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;

/* loaded from: classes6.dex */
public class ApplicationModule {

    /* renamed from: a  reason: collision with root package name */
    private final Config f36254a;

    /* renamed from: b  reason: collision with root package name */
    private final TargetUi f36255b;

    public ApplicationModule(Config config, Object obj) {
        this.f36254a = config;
        this.f36255b = new TargetUi(obj);
    }

    public Config getConfig() {
        return this.f36254a;
    }

    public TargetUi getUi() {
        return this.f36255b;
    }
}
