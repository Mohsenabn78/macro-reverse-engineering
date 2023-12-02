package com.miguelbcr.ui.rx_paparazzo2;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.Fragment;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.Response;
import com.miguelbcr.ui.rx_paparazzo2.entities.size.Size;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import com.miguelbcr.ui.rx_paparazzo2.internal.di.ApplicationComponent;
import com.miguelbcr.ui.rx_paparazzo2.internal.di.ApplicationModule;
import com.yalantis.ucrop.UCrop;
import io.reactivex.Observable;
import java.util.List;
import rx_activity_result2.RxActivityResult;

/* loaded from: classes6.dex */
public final class RxPaparazzo {
    public static final int RESULT_DENIED_PERMISSION = 2;
    public static final int RESULT_DENIED_PERMISSION_NEVER_ASK = 3;

    /* renamed from: a  reason: collision with root package name */
    private static String f36161a;

    /* renamed from: b  reason: collision with root package name */
    private static String f36162b;

    /* loaded from: classes6.dex */
    public static class MultipleSelectionBuilder<T> extends a<T, MultipleSelectionBuilder<T>> {
        MultipleSelectionBuilder(T t3) {
            super(t3);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a crop() {
            return super.crop();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a limitPickerToOpenableFilesOnly() {
            return super.limitPickerToOpenableFilesOnly();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a sendToMediaScanner() {
            return super.sendToMediaScanner();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a setMaximumFileSizeInBytes(long j4) {
            return super.setMaximumFileSizeInBytes(j4);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a setMimeType(String str) {
            return super.setMimeType(str);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a setMultipleMimeType(String[] strArr) {
            return super.setMultipleMimeType(strArr);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a size(Size size) {
            return super.size(size);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a useDocumentPicker() {
            return super.useDocumentPicker();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a useInternalStorage() {
            return super.useInternalStorage();
        }

        public Observable<Response<T, List<FileData>>> usingFiles() {
            return a().files().pickFiles();
        }

        public Observable<Response<T, List<FileData>>> usingGallery() {
            b().setPickMimeType(ImageUtils.MIME_TYPE_IMAGE_WILDCARD);
            return usingFiles();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a crop(UCrop.Options options) {
            return super.crop(options);
        }
    }

    /* loaded from: classes6.dex */
    public static class RegisterBuilder {

        /* renamed from: a  reason: collision with root package name */
        private final RegisterBuilder f36163a = this;

        RegisterBuilder() {
        }

        public RegisterBuilder withFileProviderAuthority(String str) {
            String unused = RxPaparazzo.f36161a = str;
            return this.f36163a;
        }

        public RegisterBuilder withFileProviderPath(String str) {
            String unused = RxPaparazzo.f36162b = str;
            return this.f36163a;
        }
    }

    /* loaded from: classes6.dex */
    public static class SingleSelectionBuilder<T> extends a<T, SingleSelectionBuilder<T>> {
        SingleSelectionBuilder(T t3) {
            super(t3);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a crop() {
            return super.crop();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a limitPickerToOpenableFilesOnly() {
            return super.limitPickerToOpenableFilesOnly();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a sendToMediaScanner() {
            return super.sendToMediaScanner();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a setMaximumFileSizeInBytes(long j4) {
            return super.setMaximumFileSizeInBytes(j4);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a setMimeType(String str) {
            return super.setMimeType(str);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a setMultipleMimeType(String[] strArr) {
            return super.setMultipleMimeType(strArr);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a size(Size size) {
            return super.size(size);
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a useDocumentPicker() {
            return super.useDocumentPicker();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a useInternalStorage() {
            return super.useInternalStorage();
        }

        public Observable<Response<T, FileData>> usingCamera() {
            b().setFailCropIfNotImage(true);
            return a().camera().takePhoto();
        }

        public Observable<Response<T, FileData>> usingFiles() {
            return a().files().pickFile();
        }

        public Observable<Response<T, FileData>> usingGallery() {
            Config b4 = b();
            b4.setPickMimeType(ImageUtils.MIME_TYPE_IMAGE_WILDCARD);
            b4.setFailCropIfNotImage(true);
            return usingFiles();
        }

        @Override // com.miguelbcr.ui.rx_paparazzo2.RxPaparazzo.a
        public /* bridge */ /* synthetic */ a crop(UCrop.Options options) {
            return super.crop(options);
        }
    }

    private RxPaparazzo() {
    }

    public static <T extends Activity> MultipleSelectionBuilder<T> multiple(T t3) {
        return new MultipleSelectionBuilder<>(t3);
    }

    public static RegisterBuilder register(Application application) {
        RxActivityResult.register(application);
        return new RegisterBuilder();
    }

    public static <T extends Activity> SingleSelectionBuilder<T> single(T t3) {
        return new SingleSelectionBuilder<>(t3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static abstract class a<T, B extends a<T, B>> {

        /* renamed from: a  reason: collision with root package name */
        private final ApplicationComponent f36164a;

        /* renamed from: b  reason: collision with root package name */
        private final B f36165b = this;

        /* renamed from: c  reason: collision with root package name */
        private final Config f36166c;

        a(T t3) {
            Config config = new Config();
            this.f36166c = config;
            config.setFileProviderAuthority(RxPaparazzo.f36161a);
            config.setFileProviderPath(RxPaparazzo.f36162b);
            this.f36164a = ApplicationComponent.create(new ApplicationModule(config, t3));
        }

        ApplicationComponent a() {
            return this.f36164a;
        }

        Config b() {
            return this.f36166c;
        }

        public B crop() {
            this.f36166c.setCrop();
            return this.f36165b;
        }

        public B limitPickerToOpenableFilesOnly() {
            this.f36166c.setPickOpenableOnly(true);
            return this.f36165b;
        }

        public B sendToMediaScanner() {
            this.f36166c.setSendToMediaScanner(true);
            return this.f36165b;
        }

        public B setMaximumFileSizeInBytes(long j4) {
            this.f36166c.setMaximumFileSize(j4);
            return this.f36165b;
        }

        public B setMimeType(String str) {
            this.f36166c.setPickMimeType(str);
            return this.f36165b;
        }

        public B setMultipleMimeType(String... strArr) {
            this.f36166c.setPickMultipleMimeTypes(strArr);
            return this.f36165b;
        }

        public B size(Size size) {
            this.f36166c.setSize(size);
            return this.f36165b;
        }

        public B useDocumentPicker() {
            this.f36166c.setUseDocumentPicker(true);
            return this.f36165b;
        }

        public B useInternalStorage() {
            this.f36166c.setUseInternalStorage(true);
            return this.f36165b;
        }

        public <O extends UCrop.Options> B crop(O o4) {
            this.f36166c.setCrop(o4);
            return this.f36165b;
        }
    }

    public static <T extends Fragment> MultipleSelectionBuilder<T> multiple(T t3) {
        return new MultipleSelectionBuilder<>(t3);
    }

    public static <T extends Fragment> SingleSelectionBuilder<T> single(T t3) {
        return new SingleSelectionBuilder<>(t3);
    }
}
