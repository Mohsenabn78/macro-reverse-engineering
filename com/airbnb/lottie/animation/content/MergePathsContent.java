package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* loaded from: classes2.dex */
public class MergePathsContent implements b, com.airbnb.lottie.animation.content.a {

    /* renamed from: d  reason: collision with root package name */
    private final String f1468d;

    /* renamed from: f  reason: collision with root package name */
    private final MergePaths f1470f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f1465a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f1466b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f1467c = new Path();

    /* renamed from: e  reason: collision with root package name */
    private final List<b> f1469e = new ArrayList();

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1471a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            f1471a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1471a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1471a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1471a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1471a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public MergePathsContent(MergePaths mergePaths) {
        this.f1468d = mergePaths.getName();
        this.f1470f = mergePaths;
    }

    private void a() {
        for (int i4 = 0; i4 < this.f1469e.size(); i4++) {
            this.f1467c.addPath(this.f1469e.get(i4).getPath());
        }
    }

    @TargetApi(19)
    private void b(Path.Op op) {
        this.f1466b.reset();
        this.f1465a.reset();
        for (int size = this.f1469e.size() - 1; size >= 1; size--) {
            b bVar = this.f1469e.get(size);
            if (bVar instanceof ContentGroup) {
                ContentGroup contentGroup = (ContentGroup) bVar;
                List<b> c4 = contentGroup.c();
                for (int size2 = c4.size() - 1; size2 >= 0; size2--) {
                    Path path = c4.get(size2).getPath();
                    path.transform(contentGroup.d());
                    this.f1466b.addPath(path);
                }
            } else {
                this.f1466b.addPath(bVar.getPath());
            }
        }
        b bVar2 = this.f1469e.get(0);
        if (bVar2 instanceof ContentGroup) {
            ContentGroup contentGroup2 = (ContentGroup) bVar2;
            List<b> c5 = contentGroup2.c();
            for (int i4 = 0; i4 < c5.size(); i4++) {
                Path path2 = c5.get(i4).getPath();
                path2.transform(contentGroup2.d());
                this.f1465a.addPath(path2);
            }
        } else {
            this.f1465a.set(bVar2.getPath());
        }
        this.f1467c.op(this.f1465a, this.f1466b, op);
    }

    @Override // com.airbnb.lottie.animation.content.a
    public void absorbContent(ListIterator<Content> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            Content previous = listIterator.previous();
            if (previous instanceof b) {
                this.f1469e.add((b) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.f1468d;
    }

    @Override // com.airbnb.lottie.animation.content.b
    public Path getPath() {
        this.f1467c.reset();
        if (this.f1470f.isHidden()) {
            return this.f1467c;
        }
        int i4 = a.f1471a[this.f1470f.getMode().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 == 5) {
                            b(Path.Op.XOR);
                        }
                    } else {
                        b(Path.Op.INTERSECT);
                    }
                } else {
                    b(Path.Op.REVERSE_DIFFERENCE);
                }
            } else {
                b(Path.Op.UNION);
            }
        } else {
            a();
        }
        return this.f1467c;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public void setContents(List<Content> list, List<Content> list2) {
        for (int i4 = 0; i4 < this.f1469e.size(); i4++) {
            this.f1469e.get(i4).setContents(list, list2);
        }
    }
}
