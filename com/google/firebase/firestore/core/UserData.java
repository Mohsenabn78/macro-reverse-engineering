package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.model.mutation.SetMutation;
import com.google.firebase.firestore.model.mutation.TransformOperation;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes5.dex */
public class UserData {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.core.UserData$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30441a;

        static {
            int[] iArr = new int[Source.values().length];
            f30441a = iArr;
            try {
                iArr[Source.Set.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30441a[Source.MergeSet.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30441a[Source.Update.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30441a[Source.Argument.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30441a[Source.ArrayArgument.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class ParseContext {

        /* renamed from: a  reason: collision with root package name */
        private final ParseAccumulator f30445a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final FieldPath f30446b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f30447c;

        /* synthetic */ ParseContext(ParseAccumulator parseAccumulator, FieldPath fieldPath, boolean z3, AnonymousClass1 anonymousClass1) {
            this(parseAccumulator, fieldPath, z3);
        }

        private void a() {
            if (this.f30446b == null) {
                return;
            }
            for (int i4 = 0; i4 < this.f30446b.length(); i4++) {
                b(this.f30446b.getSegment(i4));
            }
        }

        private void b(String str) {
            if (!str.isEmpty()) {
                if (isWrite() && str.startsWith("__") && str.endsWith("__")) {
                    throw createError("Document fields cannot begin and end with \"__\"");
                }
                return;
            }
            throw createError("Document fields must not be empty");
        }

        public void addToFieldMask(FieldPath fieldPath) {
            this.f30445a.b(fieldPath);
        }

        public void addToFieldTransforms(FieldPath fieldPath, TransformOperation transformOperation) {
            this.f30445a.c(fieldPath, transformOperation);
        }

        public ParseContext childContext(String str) {
            FieldPath fieldPath = this.f30446b;
            ParseContext parseContext = new ParseContext(this.f30445a, fieldPath == null ? null : fieldPath.append(str), false);
            parseContext.b(str);
            return parseContext;
        }

        public RuntimeException createError(String str) {
            String str2;
            FieldPath fieldPath = this.f30446b;
            if (fieldPath != null && !fieldPath.isEmpty()) {
                str2 = " (found in field " + this.f30446b.toString() + ")";
            } else {
                str2 = "";
            }
            return new IllegalArgumentException("Invalid data. " + str + str2);
        }

        public Source getDataSource() {
            return this.f30445a.f30442a;
        }

        @Nullable
        public FieldPath getPath() {
            return this.f30446b;
        }

        public boolean isArrayElement() {
            return this.f30447c;
        }

        public boolean isWrite() {
            int i4 = AnonymousClass1.f30441a[this.f30445a.f30442a.ordinal()];
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                return true;
            }
            if (i4 == 4 || i4 == 5) {
                return false;
            }
            throw Assert.fail("Unexpected case for UserDataSource: %s", this.f30445a.f30442a.name());
        }

        private ParseContext(ParseAccumulator parseAccumulator, @Nullable FieldPath fieldPath, boolean z3) {
            this.f30445a = parseAccumulator;
            this.f30446b = fieldPath;
            this.f30447c = z3;
        }

        public ParseContext childContext(FieldPath fieldPath) {
            FieldPath fieldPath2 = this.f30446b;
            ParseContext parseContext = new ParseContext(this.f30445a, fieldPath2 == null ? null : fieldPath2.append(fieldPath), false);
            parseContext.a();
            return parseContext;
        }

        public ParseContext childContext(int i4) {
            return new ParseContext(this.f30445a, null, true);
        }
    }

    /* loaded from: classes5.dex */
    public static class ParsedSetData {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectValue f30448a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final FieldMask f30449b;

        /* renamed from: c  reason: collision with root package name */
        private final List<FieldTransform> f30450c;

        ParsedSetData(ObjectValue objectValue, @Nullable FieldMask fieldMask, List<FieldTransform> list) {
            this.f30448a = objectValue;
            this.f30449b = fieldMask;
            this.f30450c = list;
        }

        public ObjectValue getData() {
            return this.f30448a;
        }

        @Nullable
        public FieldMask getFieldMask() {
            return this.f30449b;
        }

        public List<FieldTransform> getFieldTransforms() {
            return this.f30450c;
        }

        public Mutation toMutation(DocumentKey documentKey, Precondition precondition) {
            FieldMask fieldMask = this.f30449b;
            if (fieldMask != null) {
                return new PatchMutation(documentKey, this.f30448a, fieldMask, precondition, this.f30450c);
            }
            return new SetMutation(documentKey, this.f30448a, precondition, this.f30450c);
        }
    }

    /* loaded from: classes5.dex */
    public static class ParsedUpdateData {

        /* renamed from: a  reason: collision with root package name */
        private final ObjectValue f30451a;

        /* renamed from: b  reason: collision with root package name */
        private final FieldMask f30452b;

        /* renamed from: c  reason: collision with root package name */
        private final List<FieldTransform> f30453c;

        ParsedUpdateData(ObjectValue objectValue, FieldMask fieldMask, List<FieldTransform> list) {
            this.f30451a = objectValue;
            this.f30452b = fieldMask;
            this.f30453c = list;
        }

        public ObjectValue getData() {
            return this.f30451a;
        }

        public FieldMask getFieldMask() {
            return this.f30452b;
        }

        public List<FieldTransform> getFieldTransforms() {
            return this.f30453c;
        }

        public Mutation toMutation(DocumentKey documentKey, Precondition precondition) {
            return new PatchMutation(documentKey, this.f30451a, this.f30452b, precondition, this.f30453c);
        }
    }

    /* loaded from: classes5.dex */
    public enum Source {
        Set,
        MergeSet,
        Update,
        Argument,
        ArrayArgument
    }

    private UserData() {
    }

    /* loaded from: classes5.dex */
    public static class ParseAccumulator {

        /* renamed from: a  reason: collision with root package name */
        private final Source f30442a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<FieldPath> f30443b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final ArrayList<FieldTransform> f30444c = new ArrayList<>();

        public ParseAccumulator(Source source) {
            this.f30442a = source;
        }

        void b(FieldPath fieldPath) {
            this.f30443b.add(fieldPath);
        }

        void c(FieldPath fieldPath, TransformOperation transformOperation) {
            this.f30444c.add(new FieldTransform(fieldPath, transformOperation));
        }

        public boolean contains(FieldPath fieldPath) {
            for (FieldPath fieldPath2 : this.f30443b) {
                if (fieldPath.isPrefixOf(fieldPath2)) {
                    return true;
                }
            }
            Iterator<FieldTransform> it = this.f30444c.iterator();
            while (it.hasNext()) {
                if (fieldPath.isPrefixOf(it.next().getFieldPath())) {
                    return true;
                }
            }
            return false;
        }

        public Source getDataSource() {
            return this.f30442a;
        }

        public List<FieldTransform> getFieldTransforms() {
            return this.f30444c;
        }

        public ParseContext rootContext() {
            return new ParseContext(this, FieldPath.EMPTY_PATH, false, null);
        }

        public ParsedSetData toMergeData(ObjectValue objectValue) {
            return new ParsedSetData(objectValue, FieldMask.fromSet(this.f30443b), Collections.unmodifiableList(this.f30444c));
        }

        public ParsedSetData toSetData(ObjectValue objectValue) {
            return new ParsedSetData(objectValue, null, Collections.unmodifiableList(this.f30444c));
        }

        public ParsedUpdateData toUpdateData(ObjectValue objectValue) {
            return new ParsedUpdateData(objectValue, FieldMask.fromSet(this.f30443b), Collections.unmodifiableList(this.f30444c));
        }

        public ParsedSetData toMergeData(ObjectValue objectValue, FieldMask fieldMask) {
            ArrayList arrayList = new ArrayList();
            Iterator<FieldTransform> it = this.f30444c.iterator();
            while (it.hasNext()) {
                FieldTransform next = it.next();
                if (fieldMask.covers(next.getFieldPath())) {
                    arrayList.add(next);
                }
            }
            return new ParsedSetData(objectValue, fieldMask, Collections.unmodifiableList(arrayList));
        }
    }
}
