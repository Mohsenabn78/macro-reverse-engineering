package com.miguelbcr.ui.rx_paparazzo2.internal.di;

import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import com.miguelbcr.ui.rx_paparazzo2.interactors.CropImage;
import com.miguelbcr.ui.rx_paparazzo2.interactors.DownloadFile;
import com.miguelbcr.ui.rx_paparazzo2.interactors.GetPath;
import com.miguelbcr.ui.rx_paparazzo2.interactors.GrantPermissions;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import com.miguelbcr.ui.rx_paparazzo2.interactors.SaveFile;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ScaledImageDimensions;
import com.miguelbcr.ui.rx_paparazzo2.interactors.StartIntent;
import com.miguelbcr.ui.rx_paparazzo2.interactors.TakePhoto;
import com.miguelbcr.ui.rx_paparazzo2.workers.Camera;
import com.miguelbcr.ui.rx_paparazzo2.workers.Files;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ApplicationComponentImpl.java */
/* loaded from: classes6.dex */
public class a extends ApplicationComponent {

    /* renamed from: a  reason: collision with root package name */
    private final GetPath f36256a;

    /* renamed from: b  reason: collision with root package name */
    private final Camera f36257b;

    /* renamed from: c  reason: collision with root package name */
    private final Files f36258c;

    public a(TargetUi targetUi, Config config) {
        StartIntent startIntent = new StartIntent(targetUi);
        ImageUtils imageUtils = new ImageUtils(targetUi, config);
        DownloadFile downloadFile = new DownloadFile(targetUi, config, imageUtils);
        TakePhoto takePhoto = new TakePhoto(config, startIntent, targetUi, imageUtils);
        ScaledImageDimensions scaledImageDimensions = new ScaledImageDimensions(targetUi, config);
        CropImage cropImage = new CropImage(targetUi, config, startIntent, imageUtils);
        SaveFile saveFile = new SaveFile(targetUi, config, scaledImageDimensions, imageUtils);
        GrantPermissions grantPermissions = new GrantPermissions(targetUi);
        GetPath getPath = new GetPath(config, targetUi, downloadFile);
        this.f36256a = getPath;
        this.f36257b = new Camera(takePhoto, cropImage, saveFile, grantPermissions, targetUi, config);
        this.f36258c = new Files(grantPermissions, startIntent, getPath, cropImage, saveFile, targetUi, config);
    }

    @Override // com.miguelbcr.ui.rx_paparazzo2.internal.di.ApplicationComponent
    public Camera camera() {
        return this.f36257b;
    }

    @Override // com.miguelbcr.ui.rx_paparazzo2.internal.di.ApplicationComponent
    public Files files() {
        return this.f36258c;
    }

    @Override // com.miguelbcr.ui.rx_paparazzo2.internal.di.ApplicationComponent
    public GetPath getPath() {
        return this.f36256a;
    }
}
