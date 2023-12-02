package com.miguelbcr.ui.rx_paparazzo2.workers;

import android.net.Uri;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.Ignore;
import com.miguelbcr.ui.rx_paparazzo2.entities.Response;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import com.miguelbcr.ui.rx_paparazzo2.interactors.CropImage;
import com.miguelbcr.ui.rx_paparazzo2.interactors.GetPath;
import com.miguelbcr.ui.rx_paparazzo2.interactors.GrantPermissions;
import com.miguelbcr.ui.rx_paparazzo2.interactors.PermissionUtil;
import com.miguelbcr.ui.rx_paparazzo2.interactors.PickFile;
import com.miguelbcr.ui.rx_paparazzo2.interactors.PickFiles;
import com.miguelbcr.ui.rx_paparazzo2.interactors.SaveFile;
import com.miguelbcr.ui.rx_paparazzo2.interactors.StartIntent;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;

/* loaded from: classes6.dex */
public final class Files extends com.miguelbcr.ui.rx_paparazzo2.workers.a {

    /* renamed from: b  reason: collision with root package name */
    private final GrantPermissions f36269b;

    /* renamed from: c  reason: collision with root package name */
    private final StartIntent f36270c;

    /* renamed from: d  reason: collision with root package name */
    private final GetPath f36271d;

    /* renamed from: e  reason: collision with root package name */
    private final CropImage f36272e;

    /* renamed from: f  reason: collision with root package name */
    private final SaveFile f36273f;

    /* renamed from: g  reason: collision with root package name */
    private final TargetUi f36274g;

    /* renamed from: h  reason: collision with root package name */
    private final Config f36275h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements Function<Ignore, ObservableSource<List<Uri>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PickFiles f36276a;

        a(PickFiles pickFiles) {
            this.f36276a = pickFiles;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<List<Uri>> apply(Ignore ignore) throws Exception {
            return this.f36276a.react();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public class b<T> implements Function<FileData, Response<T, FileData>> {
        b() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Response<T, FileData> apply(FileData fileData) throws Exception {
            return new Response<>(Files.this.f36274g.ui(), fileData, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c implements Function<FileData, ObservableSource<FileData>> {
        c() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(FileData fileData) throws Exception {
            return Files.this.g(fileData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class d implements Function<Uri, ObservableSource<FileData>> {
        d() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(Uri uri) throws Exception {
            return Files.this.f36271d.with(uri).react();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class e implements Function<Ignore, ObservableSource<Uri>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PickFile f36281a;

        e(PickFile pickFile) {
            this.f36281a = pickFile;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<Uri> apply(Ignore ignore) throws Exception {
            return this.f36281a.react();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class f implements Function<FileData, ObservableSource<FileData>> {
        f() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(FileData fileData) throws Exception {
            return Files.this.f36273f.with(fileData).react();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes6.dex */
    public class g<T> implements Function<List<FileData>, Response<T, List<FileData>>> {
        g() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Response<T, List<FileData>> apply(List<FileData> list) throws Exception {
            return new Response<>(Files.this.f36274g.ui(), list, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class h implements Function<FileData, ObservableSource<FileData>> {
        h() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(FileData fileData) throws Exception {
            return Files.this.g(fileData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class i implements Function<Uri, ObservableSource<FileData>> {
        i() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public ObservableSource<FileData> apply(Uri uri) throws Exception {
            return Files.this.f36271d.with(uri).react();
        }
    }

    public Files(GrantPermissions grantPermissions, StartIntent startIntent, GetPath getPath, CropImage cropImage, SaveFile saveFile, TargetUi targetUi, Config config) {
        super(targetUi);
        this.f36269b = grantPermissions;
        this.f36270c = startIntent;
        this.f36271d = getPath;
        this.f36272e = cropImage;
        this.f36273f = saveFile;
        this.f36274g = targetUi;
        this.f36275h = config;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Observable<FileData> g(FileData fileData) {
        return this.f36272e.with(fileData).react().flatMap(new f());
    }

    private String[] h() {
        return PermissionUtil.getReadAndWriteStoragePermissions(this.f36275h.isUseInternalStorage());
    }

    public <T> Observable<Response<T, FileData>> pickFile() {
        return pickFile(new PickFile(this.f36274g, this.f36275h, this.f36270c));
    }

    public <T> Observable<Response<T, List<FileData>>> pickFiles() {
        return pickFiles(new PickFiles(this.f36274g, this.f36275h, this.f36270c));
    }

    public <T> Observable<Response<T, FileData>> pickFile(PickFile pickFile) {
        return this.f36269b.with(h()).react().flatMap(new e(pickFile)).flatMap(new d()).flatMap(new c()).map(new b()).compose(b());
    }

    public <T> Observable<Response<T, List<FileData>>> pickFiles(PickFiles pickFiles) {
        return this.f36269b.with(h()).react().flatMap(new a(pickFiles)).flatMapIterable(new j()).concatMap(new i()).concatMap(new h()).toList().toObservable().map(new g()).compose(b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class j implements Function<List<Uri>, Iterable<Uri>> {
        j() {
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a */
        public Iterable<Uri> apply(List<Uri> list) throws Exception {
            return list;
        }
    }
}
