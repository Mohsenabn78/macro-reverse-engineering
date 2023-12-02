package com.miguelbcr.ui.rx_paparazzo2.internal.di;

import com.miguelbcr.ui.rx_paparazzo2.interactors.GetPath;
import com.miguelbcr.ui.rx_paparazzo2.workers.Camera;
import com.miguelbcr.ui.rx_paparazzo2.workers.Files;

/* loaded from: classes6.dex */
public abstract class ApplicationComponent {
    public static ApplicationComponent create(ApplicationModule applicationModule) {
        return new a(applicationModule.getUi(), applicationModule.getConfig());
    }

    public abstract Camera camera();

    public abstract Files files();

    public abstract GetPath getPath();
}
