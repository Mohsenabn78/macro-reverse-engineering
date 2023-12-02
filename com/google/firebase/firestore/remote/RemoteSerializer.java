package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.core.CompositeFilter;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.FieldTransform;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.model.mutation.SetMutation;
import com.google.firebase.firestore.model.mutation.TransformOperation;
import com.google.firebase.firestore.model.mutation.VerifyMutation;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.BatchGetDocumentsResponse;
import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentChange;
import com.google.firestore.v1.DocumentDelete;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.DocumentRemove;
import com.google.firestore.v1.DocumentTransform;
import com.google.firestore.v1.ListenResponse;
import com.google.firestore.v1.Precondition;
import com.google.firestore.v1.StructuredAggregationQuery;
import com.google.firestore.v1.StructuredQuery;
import com.google.firestore.v1.Target;
import com.google.firestore.v1.TargetChange;
import com.google.firestore.v1.Write;
import com.google.firestore.v1.WriteResult;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Timestamp;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public final class RemoteSerializer {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseId f31133a;

    /* renamed from: b  reason: collision with root package name */
    private final String f31134b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.remote.RemoteSerializer$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31135a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f31136b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f31137c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f31138d;

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ int[] f31139e;

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ int[] f31140f;

        /* renamed from: g  reason: collision with root package name */
        static final /* synthetic */ int[] f31141g;

        /* renamed from: h  reason: collision with root package name */
        static final /* synthetic */ int[] f31142h;

        /* renamed from: i  reason: collision with root package name */
        static final /* synthetic */ int[] f31143i;

        /* renamed from: j  reason: collision with root package name */
        static final /* synthetic */ int[] f31144j;

        /* renamed from: k  reason: collision with root package name */
        static final /* synthetic */ int[] f31145k;

        /* renamed from: l  reason: collision with root package name */
        static final /* synthetic */ int[] f31146l;

        /* renamed from: m  reason: collision with root package name */
        static final /* synthetic */ int[] f31147m;

        static {
            int[] iArr = new int[ListenResponse.ResponseTypeCase.values().length];
            f31147m = iArr;
            try {
                iArr[ListenResponse.ResponseTypeCase.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31147m[ListenResponse.ResponseTypeCase.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31147m[ListenResponse.ResponseTypeCase.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31147m[ListenResponse.ResponseTypeCase.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31147m[ListenResponse.ResponseTypeCase.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31147m[ListenResponse.ResponseTypeCase.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[TargetChange.TargetChangeType.values().length];
            f31146l = iArr2;
            try {
                iArr2[TargetChange.TargetChangeType.NO_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31146l[TargetChange.TargetChangeType.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31146l[TargetChange.TargetChangeType.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31146l[TargetChange.TargetChangeType.CURRENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f31146l[TargetChange.TargetChangeType.RESET.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f31146l[TargetChange.TargetChangeType.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[StructuredQuery.Direction.values().length];
            f31145k = iArr3;
            try {
                iArr3[StructuredQuery.Direction.ASCENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f31145k[StructuredQuery.Direction.DESCENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr4 = new int[StructuredQuery.FieldFilter.Operator.values().length];
            f31144j = iArr4;
            try {
                iArr4[StructuredQuery.FieldFilter.Operator.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f31144j[StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f31144j[StructuredQuery.FieldFilter.Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f31144j[StructuredQuery.FieldFilter.Operator.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f31144j[StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f31144j[StructuredQuery.FieldFilter.Operator.GREATER_THAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f31144j[StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f31144j[StructuredQuery.FieldFilter.Operator.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f31144j[StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f31144j[StructuredQuery.FieldFilter.Operator.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr5 = new int[FieldFilter.Operator.values().length];
            f31143i = iArr5;
            try {
                iArr5[FieldFilter.Operator.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f31143i[FieldFilter.Operator.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f31143i[FieldFilter.Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f31143i[FieldFilter.Operator.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f31143i[FieldFilter.Operator.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f31143i[FieldFilter.Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f31143i[FieldFilter.Operator.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f31143i[FieldFilter.Operator.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f31143i[FieldFilter.Operator.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f31143i[FieldFilter.Operator.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused34) {
            }
            int[] iArr6 = new int[StructuredQuery.UnaryFilter.Operator.values().length];
            f31142h = iArr6;
            try {
                iArr6[StructuredQuery.UnaryFilter.Operator.IS_NAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f31142h[StructuredQuery.UnaryFilter.Operator.IS_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f31142h[StructuredQuery.UnaryFilter.Operator.IS_NOT_NAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f31142h[StructuredQuery.UnaryFilter.Operator.IS_NOT_NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused38) {
            }
            int[] iArr7 = new int[StructuredQuery.Filter.FilterTypeCase.values().length];
            f31141g = iArr7;
            try {
                iArr7[StructuredQuery.Filter.FilterTypeCase.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f31141g[StructuredQuery.Filter.FilterTypeCase.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f31141g[StructuredQuery.Filter.FilterTypeCase.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused41) {
            }
            int[] iArr8 = new int[StructuredQuery.CompositeFilter.Operator.values().length];
            f31140f = iArr8;
            try {
                iArr8[StructuredQuery.CompositeFilter.Operator.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f31140f[StructuredQuery.CompositeFilter.Operator.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused43) {
            }
            int[] iArr9 = new int[CompositeFilter.Operator.values().length];
            f31139e = iArr9;
            try {
                iArr9[CompositeFilter.Operator.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f31139e[CompositeFilter.Operator.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused45) {
            }
            int[] iArr10 = new int[QueryPurpose.values().length];
            f31138d = iArr10;
            try {
                iArr10[QueryPurpose.LISTEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f31138d[QueryPurpose.EXISTENCE_FILTER_MISMATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f31138d[QueryPurpose.EXISTENCE_FILTER_MISMATCH_BLOOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f31138d[QueryPurpose.LIMBO_RESOLUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused49) {
            }
            int[] iArr11 = new int[DocumentTransform.FieldTransform.TransformTypeCase.values().length];
            f31137c = iArr11;
            try {
                iArr11[DocumentTransform.FieldTransform.TransformTypeCase.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f31137c[DocumentTransform.FieldTransform.TransformTypeCase.APPEND_MISSING_ELEMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f31137c[DocumentTransform.FieldTransform.TransformTypeCase.REMOVE_ALL_FROM_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f31137c[DocumentTransform.FieldTransform.TransformTypeCase.INCREMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused53) {
            }
            int[] iArr12 = new int[Precondition.ConditionTypeCase.values().length];
            f31136b = iArr12;
            try {
                iArr12[Precondition.ConditionTypeCase.UPDATE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f31136b[Precondition.ConditionTypeCase.EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f31136b[Precondition.ConditionTypeCase.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused56) {
            }
            int[] iArr13 = new int[Write.OperationCase.values().length];
            f31135a = iArr13;
            try {
                iArr13[Write.OperationCase.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f31135a[Write.OperationCase.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f31135a[Write.OperationCase.VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused59) {
            }
        }
    }

    public RemoteSerializer(DatabaseId databaseId) {
        this.f31133a = databaseId;
        this.f31134b = E(databaseId).canonicalString();
    }

    private String A(ResourcePath resourcePath) {
        return B(this.f31133a, resourcePath);
    }

    private String B(DatabaseId databaseId, ResourcePath resourcePath) {
        return E(databaseId).append("documents").append(resourcePath).canonicalString();
    }

    private static ResourcePath E(DatabaseId databaseId) {
        return ResourcePath.fromSegments(Arrays.asList("projects", databaseId.getProjectId(), "databases", databaseId.getDatabaseId()));
    }

    private static ResourcePath F(ResourcePath resourcePath) {
        boolean z3;
        if (resourcePath.length() > 4 && resourcePath.getSegment(4).equals("documents")) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Tried to deserialize invalid key %s", resourcePath);
        return resourcePath.popFirst(5);
    }

    private Status G(com.google.rpc.Status status) {
        return Status.fromCodeValue(status.getCode()).withDescription(status.getMessage());
    }

    private static boolean H(ResourcePath resourcePath) {
        if (resourcePath.length() < 4 || !resourcePath.getSegment(0).equals("projects") || !resourcePath.getSegment(2).equals("databases")) {
            return false;
        }
        return true;
    }

    private FieldMask c(DocumentMask documentMask) {
        int fieldPathsCount = documentMask.getFieldPathsCount();
        HashSet hashSet = new HashSet(fieldPathsCount);
        for (int i4 = 0; i4 < fieldPathsCount; i4++) {
            hashSet.add(FieldPath.fromServerFormat(documentMask.getFieldPaths(i4)));
        }
        return FieldMask.fromSet(hashSet);
    }

    private FieldFilter.Operator e(StructuredQuery.FieldFilter.Operator operator) {
        switch (AnonymousClass1.f31144j[operator.ordinal()]) {
            case 1:
                return FieldFilter.Operator.LESS_THAN;
            case 2:
                return FieldFilter.Operator.LESS_THAN_OR_EQUAL;
            case 3:
                return FieldFilter.Operator.EQUAL;
            case 4:
                return FieldFilter.Operator.NOT_EQUAL;
            case 5:
                return FieldFilter.Operator.GREATER_THAN_OR_EQUAL;
            case 6:
                return FieldFilter.Operator.GREATER_THAN;
            case 7:
                return FieldFilter.Operator.ARRAY_CONTAINS;
            case 8:
                return FieldFilter.Operator.IN;
            case 9:
                return FieldFilter.Operator.ARRAY_CONTAINS_ANY;
            case 10:
                return FieldFilter.Operator.NOT_IN;
            default:
                throw Assert.fail("Unhandled FieldFilter.operator %d", operator);
        }
    }

    private FieldTransform f(DocumentTransform.FieldTransform fieldTransform) {
        boolean z3;
        int i4 = AnonymousClass1.f31137c[fieldTransform.getTransformTypeCase().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        return new FieldTransform(FieldPath.fromServerFormat(fieldTransform.getFieldPath()), new NumericIncrementTransformOperation(fieldTransform.getIncrement()));
                    }
                    throw Assert.fail("Unknown FieldTransform proto: %s", fieldTransform);
                }
                return new FieldTransform(FieldPath.fromServerFormat(fieldTransform.getFieldPath()), new ArrayTransformOperation.Remove(fieldTransform.getRemoveAllFromArray().getValuesList()));
            }
            return new FieldTransform(FieldPath.fromServerFormat(fieldTransform.getFieldPath()), new ArrayTransformOperation.Union(fieldTransform.getAppendMissingElements().getValuesList()));
        }
        if (fieldTransform.getSetToServerValue() == DocumentTransform.FieldTransform.ServerValue.REQUEST_TIME) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Unknown transform setToServerValue: %s", fieldTransform.getSetToServerValue());
        return new FieldTransform(FieldPath.fromServerFormat(fieldTransform.getFieldPath()), ServerTimestampOperation.getInstance());
    }

    private List<Filter> h(StructuredQuery.Filter filter) {
        Filter g4 = g(filter);
        if (g4 instanceof CompositeFilter) {
            CompositeFilter compositeFilter = (CompositeFilter) g4;
            if (compositeFilter.isFlatConjunction()) {
                return compositeFilter.getFilters();
            }
        }
        return Collections.singletonList(g4);
    }

    private MutableDocument i(BatchGetDocumentsResponse batchGetDocumentsResponse) {
        Assert.hardAssert(batchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.FOUND), "Tried to deserialize a found document from a missing document.", new Object[0]);
        DocumentKey decodeKey = decodeKey(batchGetDocumentsResponse.getFound().getName());
        ObjectValue fromMap = ObjectValue.fromMap(batchGetDocumentsResponse.getFound().getFieldsMap());
        SnapshotVersion decodeVersion = decodeVersion(batchGetDocumentsResponse.getFound().getUpdateTime());
        Assert.hardAssert(!decodeVersion.equals(SnapshotVersion.NONE), "Got a document response with no snapshot version", new Object[0]);
        return MutableDocument.newFoundDocument(decodeKey, decodeVersion, fromMap);
    }

    private MutableDocument j(BatchGetDocumentsResponse batchGetDocumentsResponse) {
        Assert.hardAssert(batchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.MISSING), "Tried to deserialize a missing document from a found document.", new Object[0]);
        DocumentKey decodeKey = decodeKey(batchGetDocumentsResponse.getMissing());
        SnapshotVersion decodeVersion = decodeVersion(batchGetDocumentsResponse.getReadTime());
        Assert.hardAssert(!decodeVersion.equals(SnapshotVersion.NONE), "Got a no document response with no snapshot version", new Object[0]);
        return MutableDocument.newNoDocument(decodeKey, decodeVersion);
    }

    private OrderBy k(StructuredQuery.Order order) {
        OrderBy.Direction direction;
        FieldPath fromServerFormat = FieldPath.fromServerFormat(order.getField().getFieldPath());
        int i4 = AnonymousClass1.f31145k[order.getDirection().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                direction = OrderBy.Direction.DESCENDING;
            } else {
                throw Assert.fail("Unrecognized direction %d", order.getDirection());
            }
        } else {
            direction = OrderBy.Direction.ASCENDING;
        }
        return OrderBy.getInstance(direction, fromServerFormat);
    }

    private com.google.firebase.firestore.model.mutation.Precondition l(Precondition precondition) {
        int i4 = AnonymousClass1.f31136b[precondition.getConditionTypeCase().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return com.google.firebase.firestore.model.mutation.Precondition.NONE;
                }
                throw Assert.fail("Unknown precondition", new Object[0]);
            }
            return com.google.firebase.firestore.model.mutation.Precondition.exists(precondition.getExists());
        }
        return com.google.firebase.firestore.model.mutation.Precondition.updateTime(decodeVersion(precondition.getUpdateTime()));
    }

    private ResourcePath m(String str) {
        ResourcePath n4 = n(str);
        if (n4.length() == 4) {
            return ResourcePath.EMPTY;
        }
        return F(n4);
    }

    private ResourcePath n(String str) {
        ResourcePath fromString = ResourcePath.fromString(str);
        Assert.hardAssert(H(fromString), "Tried to deserialize invalid key %s", fromString);
        return fromString;
    }

    private Filter o(StructuredQuery.UnaryFilter unaryFilter) {
        FieldPath fromServerFormat = FieldPath.fromServerFormat(unaryFilter.getField().getFieldPath());
        int i4 = AnonymousClass1.f31142h[unaryFilter.getOp().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        return FieldFilter.create(fromServerFormat, FieldFilter.Operator.NOT_EQUAL, Values.NULL_VALUE);
                    }
                    throw Assert.fail("Unrecognized UnaryFilter.operator %d", unaryFilter.getOp());
                }
                return FieldFilter.create(fromServerFormat, FieldFilter.Operator.NOT_EQUAL, Values.NAN_VALUE);
            }
            return FieldFilter.create(fromServerFormat, FieldFilter.Operator.EQUAL, Values.NULL_VALUE);
        }
        return FieldFilter.create(fromServerFormat, FieldFilter.Operator.EQUAL, Values.NAN_VALUE);
    }

    private DocumentMask r(FieldMask fieldMask) {
        DocumentMask.Builder newBuilder = DocumentMask.newBuilder();
        for (FieldPath fieldPath : fieldMask.getMask()) {
            newBuilder.addFieldPaths(fieldPath.canonicalString());
        }
        return newBuilder.build();
    }

    private StructuredQuery.FieldFilter.Operator s(FieldFilter.Operator operator) {
        switch (AnonymousClass1.f31143i[operator.ordinal()]) {
            case 1:
                return StructuredQuery.FieldFilter.Operator.LESS_THAN;
            case 2:
                return StructuredQuery.FieldFilter.Operator.LESS_THAN_OR_EQUAL;
            case 3:
                return StructuredQuery.FieldFilter.Operator.EQUAL;
            case 4:
                return StructuredQuery.FieldFilter.Operator.NOT_EQUAL;
            case 5:
                return StructuredQuery.FieldFilter.Operator.GREATER_THAN;
            case 6:
                return StructuredQuery.FieldFilter.Operator.GREATER_THAN_OR_EQUAL;
            case 7:
                return StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS;
            case 8:
                return StructuredQuery.FieldFilter.Operator.IN;
            case 9:
                return StructuredQuery.FieldFilter.Operator.ARRAY_CONTAINS_ANY;
            case 10:
                return StructuredQuery.FieldFilter.Operator.NOT_IN;
            default:
                throw Assert.fail("Unknown operator %d", operator);
        }
    }

    private StructuredQuery.FieldReference t(FieldPath fieldPath) {
        return StructuredQuery.FieldReference.newBuilder().setFieldPath(fieldPath.canonicalString()).build();
    }

    private DocumentTransform.FieldTransform u(FieldTransform fieldTransform) {
        TransformOperation operation = fieldTransform.getOperation();
        if (operation instanceof ServerTimestampOperation) {
            return DocumentTransform.FieldTransform.newBuilder().setFieldPath(fieldTransform.getFieldPath().canonicalString()).setSetToServerValue(DocumentTransform.FieldTransform.ServerValue.REQUEST_TIME).build();
        }
        if (operation instanceof ArrayTransformOperation.Union) {
            return DocumentTransform.FieldTransform.newBuilder().setFieldPath(fieldTransform.getFieldPath().canonicalString()).setAppendMissingElements(ArrayValue.newBuilder().addAllValues(((ArrayTransformOperation.Union) operation).getElements())).build();
        }
        if (operation instanceof ArrayTransformOperation.Remove) {
            return DocumentTransform.FieldTransform.newBuilder().setFieldPath(fieldTransform.getFieldPath().canonicalString()).setRemoveAllFromArray(ArrayValue.newBuilder().addAllValues(((ArrayTransformOperation.Remove) operation).getElements())).build();
        }
        if (operation instanceof NumericIncrementTransformOperation) {
            return DocumentTransform.FieldTransform.newBuilder().setFieldPath(fieldTransform.getFieldPath().canonicalString()).setIncrement(((NumericIncrementTransformOperation) operation).getOperand()).build();
        }
        throw Assert.fail("Unknown transform: %s", operation);
    }

    private StructuredQuery.Filter w(List<Filter> list) {
        return v(new CompositeFilter(list, CompositeFilter.Operator.AND));
    }

    @Nullable
    private String x(QueryPurpose queryPurpose) {
        int i4 = AnonymousClass1.f31138d[queryPurpose.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        return "limbo-document";
                    }
                    throw Assert.fail("Unrecognized query purpose: %s", queryPurpose);
                }
                return "existence-filter-mismatch-bloom";
            }
            return "existence-filter-mismatch";
        }
        return null;
    }

    private StructuredQuery.Order y(OrderBy orderBy) {
        StructuredQuery.Order.Builder newBuilder = StructuredQuery.Order.newBuilder();
        if (orderBy.getDirection().equals(OrderBy.Direction.ASCENDING)) {
            newBuilder.setDirection(StructuredQuery.Direction.ASCENDING);
        } else {
            newBuilder.setDirection(StructuredQuery.Direction.DESCENDING);
        }
        newBuilder.setField(t(orderBy.getField()));
        return newBuilder.build();
    }

    private Precondition z(com.google.firebase.firestore.model.mutation.Precondition precondition) {
        Assert.hardAssert(!precondition.isNone(), "Can't serialize an empty precondition", new Object[0]);
        Precondition.Builder newBuilder = Precondition.newBuilder();
        if (precondition.getUpdateTime() != null) {
            return newBuilder.setUpdateTime(encodeVersion(precondition.getUpdateTime())).build();
        }
        if (precondition.getExists() != null) {
            return newBuilder.setExists(precondition.getExists().booleanValue()).build();
        }
        throw Assert.fail("Unknown Precondition", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StructuredAggregationQuery C(Target.QueryTarget queryTarget, List<AggregateField> list, HashMap<String, String> hashMap) {
        StructuredAggregationQuery.Builder newBuilder = StructuredAggregationQuery.newBuilder();
        newBuilder.setStructuredQuery(queryTarget.getStructuredQuery());
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int i4 = 1;
        for (AggregateField aggregateField : list) {
            if (!hashSet.contains(aggregateField.getAlias())) {
                hashSet.add(aggregateField.getAlias());
                StringBuilder sb = new StringBuilder();
                sb.append("aggregate_");
                int i5 = i4 + 1;
                sb.append(i4);
                String sb2 = sb.toString();
                hashMap.put(sb2, aggregateField.getAlias());
                StructuredAggregationQuery.Aggregation.Builder newBuilder2 = StructuredAggregationQuery.Aggregation.newBuilder();
                StructuredQuery.FieldReference build = StructuredQuery.FieldReference.newBuilder().setFieldPath(aggregateField.getFieldPath()).build();
                if (aggregateField instanceof AggregateField.CountAggregateField) {
                    newBuilder2.setCount(StructuredAggregationQuery.Aggregation.Count.getDefaultInstance());
                } else if (aggregateField instanceof AggregateField.SumAggregateField) {
                    newBuilder2.setSum(StructuredAggregationQuery.Aggregation.Sum.newBuilder().setField(build).build());
                } else if (aggregateField instanceof AggregateField.AverageAggregateField) {
                    newBuilder2.setAvg(StructuredAggregationQuery.Aggregation.Avg.newBuilder().setField(build).build());
                } else {
                    throw new RuntimeException("Unsupported aggregation");
                }
                newBuilder2.setAlias(sb2);
                arrayList.add(newBuilder2.build());
                i4 = i5;
            }
        }
        newBuilder.addAllAggregations(arrayList);
        return (StructuredAggregationQuery) newBuilder.build();
    }

    @VisibleForTesting
    StructuredQuery.Filter D(FieldFilter fieldFilter) {
        StructuredQuery.UnaryFilter.Operator operator;
        StructuredQuery.UnaryFilter.Operator operator2;
        FieldFilter.Operator operator3 = fieldFilter.getOperator();
        FieldFilter.Operator operator4 = FieldFilter.Operator.EQUAL;
        if (operator3 == operator4 || fieldFilter.getOperator() == FieldFilter.Operator.NOT_EQUAL) {
            StructuredQuery.UnaryFilter.Builder newBuilder = StructuredQuery.UnaryFilter.newBuilder();
            newBuilder.setField(t(fieldFilter.getField()));
            if (Values.isNanValue(fieldFilter.getValue())) {
                if (fieldFilter.getOperator() == operator4) {
                    operator2 = StructuredQuery.UnaryFilter.Operator.IS_NAN;
                } else {
                    operator2 = StructuredQuery.UnaryFilter.Operator.IS_NOT_NAN;
                }
                newBuilder.setOp(operator2);
                return StructuredQuery.Filter.newBuilder().setUnaryFilter(newBuilder).build();
            } else if (Values.isNullValue(fieldFilter.getValue())) {
                if (fieldFilter.getOperator() == operator4) {
                    operator = StructuredQuery.UnaryFilter.Operator.IS_NULL;
                } else {
                    operator = StructuredQuery.UnaryFilter.Operator.IS_NOT_NULL;
                }
                newBuilder.setOp(operator);
                return StructuredQuery.Filter.newBuilder().setUnaryFilter(newBuilder).build();
            }
        }
        StructuredQuery.FieldFilter.Builder newBuilder2 = StructuredQuery.FieldFilter.newBuilder();
        newBuilder2.setField(t(fieldFilter.getField()));
        newBuilder2.setOp(s(fieldFilter.getOperator()));
        newBuilder2.setValue(fieldFilter.getValue());
        return StructuredQuery.Filter.newBuilder().setFieldFilter(newBuilder2).build();
    }

    @VisibleForTesting
    CompositeFilter a(StructuredQuery.CompositeFilter compositeFilter) {
        ArrayList arrayList = new ArrayList();
        for (StructuredQuery.Filter filter : compositeFilter.getFiltersList()) {
            arrayList.add(g(filter));
        }
        return new CompositeFilter(arrayList, b(compositeFilter.getOp()));
    }

    CompositeFilter.Operator b(StructuredQuery.CompositeFilter.Operator operator) {
        int i4 = AnonymousClass1.f31140f[operator.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return CompositeFilter.Operator.OR;
            }
            throw Assert.fail("Only AND and OR composite filter types are supported.", new Object[0]);
        }
        return CompositeFilter.Operator.AND;
    }

    @VisibleForTesting
    FieldFilter d(StructuredQuery.FieldFilter fieldFilter) {
        return FieldFilter.create(FieldPath.fromServerFormat(fieldFilter.getField().getFieldPath()), e(fieldFilter.getOp()), fieldFilter.getValue());
    }

    public String databaseName() {
        return this.f31134b;
    }

    public com.google.firebase.firestore.core.Target decodeDocumentsTarget(Target.DocumentsTarget documentsTarget) {
        boolean z3;
        int documentsCount = documentsTarget.getDocumentsCount();
        if (documentsCount == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "DocumentsTarget contained other than 1 document %d", Integer.valueOf(documentsCount));
        return Query.atPath(m(documentsTarget.getDocuments(0))).toTarget();
    }

    public DocumentKey decodeKey(String str) {
        ResourcePath n4 = n(str);
        Assert.hardAssert(n4.getSegment(1).equals(this.f31133a.getProjectId()), "Tried to deserialize key from different project.", new Object[0]);
        Assert.hardAssert(n4.getSegment(3).equals(this.f31133a.getDatabaseId()), "Tried to deserialize key from different database.", new Object[0]);
        return DocumentKey.fromPath(F(n4));
    }

    public MutableDocument decodeMaybeDocument(BatchGetDocumentsResponse batchGetDocumentsResponse) {
        if (batchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.FOUND)) {
            return i(batchGetDocumentsResponse);
        }
        if (batchGetDocumentsResponse.getResultCase().equals(BatchGetDocumentsResponse.ResultCase.MISSING)) {
            return j(batchGetDocumentsResponse);
        }
        throw new IllegalArgumentException("Unknown result case: " + batchGetDocumentsResponse.getResultCase());
    }

    public Mutation decodeMutation(Write write) {
        com.google.firebase.firestore.model.mutation.Precondition precondition;
        if (write.hasCurrentDocument()) {
            precondition = l(write.getCurrentDocument());
        } else {
            precondition = com.google.firebase.firestore.model.mutation.Precondition.NONE;
        }
        com.google.firebase.firestore.model.mutation.Precondition precondition2 = precondition;
        ArrayList arrayList = new ArrayList();
        for (DocumentTransform.FieldTransform fieldTransform : write.getUpdateTransformsList()) {
            arrayList.add(f(fieldTransform));
        }
        int i4 = AnonymousClass1.f31135a[write.getOperationCase().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return new VerifyMutation(decodeKey(write.getVerify()), precondition2);
                }
                throw Assert.fail("Unknown mutation operation: %d", write.getOperationCase());
            }
            return new DeleteMutation(decodeKey(write.getDelete()), precondition2);
        } else if (write.hasUpdateMask()) {
            return new PatchMutation(decodeKey(write.getUpdate().getName()), ObjectValue.fromMap(write.getUpdate().getFieldsMap()), c(write.getUpdateMask()), precondition2, arrayList);
        } else {
            return new SetMutation(decodeKey(write.getUpdate().getName()), ObjectValue.fromMap(write.getUpdate().getFieldsMap()), precondition2, arrayList);
        }
    }

    public MutationResult decodeMutationResult(WriteResult writeResult, SnapshotVersion snapshotVersion) {
        SnapshotVersion decodeVersion = decodeVersion(writeResult.getUpdateTime());
        if (!SnapshotVersion.NONE.equals(decodeVersion)) {
            snapshotVersion = decodeVersion;
        }
        int transformResultsCount = writeResult.getTransformResultsCount();
        ArrayList arrayList = new ArrayList(transformResultsCount);
        for (int i4 = 0; i4 < transformResultsCount; i4++) {
            arrayList.add(writeResult.getTransformResults(i4));
        }
        return new MutationResult(snapshotVersion, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.firebase.firestore.core.Target decodeQueryTarget(java.lang.String r14, com.google.firestore.v1.StructuredQuery r15) {
        /*
            r13 = this;
            com.google.firebase.firestore.model.ResourcePath r14 = r13.m(r14)
            int r0 = r15.getFromCount()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 <= 0) goto L34
            if (r0 != r2) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            java.lang.String r4 = "StructuredQuery.from with more than one collection is not supported."
            java.lang.Object[] r5 = new java.lang.Object[r1]
            com.google.firebase.firestore.util.Assert.hardAssert(r0, r4, r5)
            com.google.firestore.v1.StructuredQuery$CollectionSelector r0 = r15.getFrom(r1)
            boolean r4 = r0.getAllDescendants()
            if (r4 == 0) goto L2a
            java.lang.String r0 = r0.getCollectionId()
            r5 = r14
            r6 = r0
            goto L36
        L2a:
            java.lang.String r0 = r0.getCollectionId()
            com.google.firebase.firestore.model.BasePath r14 = r14.append(r0)
            com.google.firebase.firestore.model.ResourcePath r14 = (com.google.firebase.firestore.model.ResourcePath) r14
        L34:
            r5 = r14
            r6 = r3
        L36:
            boolean r14 = r15.hasWhere()
            if (r14 == 0) goto L45
            com.google.firestore.v1.StructuredQuery$Filter r14 = r15.getWhere()
            java.util.List r14 = r13.h(r14)
            goto L49
        L45:
            java.util.List r14 = java.util.Collections.emptyList()
        L49:
            r7 = r14
            int r14 = r15.getOrderByCount()
            if (r14 <= 0) goto L67
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r14)
        L55:
            if (r1 >= r14) goto L65
            com.google.firestore.v1.StructuredQuery$Order r4 = r15.getOrderBy(r1)
            com.google.firebase.firestore.core.OrderBy r4 = r13.k(r4)
            r0.add(r4)
            int r1 = r1 + 1
            goto L55
        L65:
            r8 = r0
            goto L6c
        L67:
            java.util.List r14 = java.util.Collections.emptyList()
            r8 = r14
        L6c:
            boolean r14 = r15.hasLimit()
            if (r14 == 0) goto L7c
            com.google.protobuf.Int32Value r14 = r15.getLimit()
            int r14 = r14.getValue()
            long r0 = (long) r14
            goto L7e
        L7c:
            r0 = -1
        L7e:
            r9 = r0
            boolean r14 = r15.hasStartAt()
            if (r14 == 0) goto L9c
            com.google.firebase.firestore.core.Bound r14 = new com.google.firebase.firestore.core.Bound
            com.google.firestore.v1.Cursor r0 = r15.getStartAt()
            java.util.List r0 = r0.getValuesList()
            com.google.firestore.v1.Cursor r1 = r15.getStartAt()
            boolean r1 = r1.getBefore()
            r14.<init>(r0, r1)
            r11 = r14
            goto L9d
        L9c:
            r11 = r3
        L9d:
            boolean r14 = r15.hasEndAt()
            if (r14 == 0) goto Lb9
            com.google.firebase.firestore.core.Bound r3 = new com.google.firebase.firestore.core.Bound
            com.google.firestore.v1.Cursor r14 = r15.getEndAt()
            java.util.List r14 = r14.getValuesList()
            com.google.firestore.v1.Cursor r15 = r15.getEndAt()
            boolean r15 = r15.getBefore()
            r15 = r15 ^ r2
            r3.<init>(r14, r15)
        Lb9:
            r12 = r3
            com.google.firebase.firestore.core.Target r14 = new com.google.firebase.firestore.core.Target
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.remote.RemoteSerializer.decodeQueryTarget(java.lang.String, com.google.firestore.v1.StructuredQuery):com.google.firebase.firestore.core.Target");
    }

    public Timestamp decodeTimestamp(com.google.protobuf.Timestamp timestamp) {
        return new Timestamp(timestamp.getSeconds(), timestamp.getNanos());
    }

    public SnapshotVersion decodeVersion(com.google.protobuf.Timestamp timestamp) {
        if (timestamp.getSeconds() == 0 && timestamp.getNanos() == 0) {
            return SnapshotVersion.NONE;
        }
        return new SnapshotVersion(decodeTimestamp(timestamp));
    }

    public SnapshotVersion decodeVersionFromListenResponse(ListenResponse listenResponse) {
        if (listenResponse.getResponseTypeCase() != ListenResponse.ResponseTypeCase.TARGET_CHANGE) {
            return SnapshotVersion.NONE;
        }
        if (listenResponse.getTargetChange().getTargetIdsCount() != 0) {
            return SnapshotVersion.NONE;
        }
        return decodeVersion(listenResponse.getTargetChange().getReadTime());
    }

    public WatchChange decodeWatchChange(ListenResponse listenResponse) {
        WatchChange.WatchTargetChangeType watchTargetChangeType;
        WatchChange watchTargetChange;
        int i4 = AnonymousClass1.f31147m[listenResponse.getResponseTypeCase().ordinal()];
        Status status = null;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 == 5) {
                            com.google.firestore.v1.ExistenceFilter filter = listenResponse.getFilter();
                            return new WatchChange.ExistenceFilterWatchChange(filter.getTargetId(), new ExistenceFilter(filter.getCount(), filter.getUnchangedNames()));
                        }
                        throw new IllegalArgumentException("Unknown change type set");
                    }
                    DocumentRemove documentRemove = listenResponse.getDocumentRemove();
                    watchTargetChange = new WatchChange.DocumentChange(Collections.emptyList(), documentRemove.getRemovedTargetIdsList(), decodeKey(documentRemove.getDocument()), null);
                } else {
                    DocumentDelete documentDelete = listenResponse.getDocumentDelete();
                    List<Integer> removedTargetIdsList = documentDelete.getRemovedTargetIdsList();
                    MutableDocument newNoDocument = MutableDocument.newNoDocument(decodeKey(documentDelete.getDocument()), decodeVersion(documentDelete.getReadTime()));
                    return new WatchChange.DocumentChange(Collections.emptyList(), removedTargetIdsList, newNoDocument.getKey(), newNoDocument);
                }
            } else {
                DocumentChange documentChange = listenResponse.getDocumentChange();
                List<Integer> targetIdsList = documentChange.getTargetIdsList();
                List<Integer> removedTargetIdsList2 = documentChange.getRemovedTargetIdsList();
                DocumentKey decodeKey = decodeKey(documentChange.getDocument().getName());
                SnapshotVersion decodeVersion = decodeVersion(documentChange.getDocument().getUpdateTime());
                Assert.hardAssert(!decodeVersion.equals(SnapshotVersion.NONE), "Got a document change without an update time", new Object[0]);
                MutableDocument newFoundDocument = MutableDocument.newFoundDocument(decodeKey, decodeVersion, ObjectValue.fromMap(documentChange.getDocument().getFieldsMap()));
                watchTargetChange = new WatchChange.DocumentChange(targetIdsList, removedTargetIdsList2, newFoundDocument.getKey(), newFoundDocument);
            }
        } else {
            com.google.firestore.v1.TargetChange targetChange = listenResponse.getTargetChange();
            int i5 = AnonymousClass1.f31146l[targetChange.getTargetChangeType().ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            if (i5 == 5) {
                                watchTargetChangeType = WatchChange.WatchTargetChangeType.Reset;
                            } else {
                                throw new IllegalArgumentException("Unknown target change type");
                            }
                        } else {
                            watchTargetChangeType = WatchChange.WatchTargetChangeType.Current;
                        }
                    } else {
                        watchTargetChangeType = WatchChange.WatchTargetChangeType.Removed;
                        status = G(targetChange.getCause());
                    }
                } else {
                    watchTargetChangeType = WatchChange.WatchTargetChangeType.Added;
                }
            } else {
                watchTargetChangeType = WatchChange.WatchTargetChangeType.NoChange;
            }
            watchTargetChange = new WatchChange.WatchTargetChange(watchTargetChangeType, targetChange.getTargetIdsList(), targetChange.getResumeToken(), status);
        }
        return watchTargetChange;
    }

    public Document encodeDocument(DocumentKey documentKey, ObjectValue objectValue) {
        Document.Builder newBuilder = Document.newBuilder();
        newBuilder.setName(encodeKey(documentKey));
        newBuilder.putAllFields(objectValue.getFieldsMap());
        return newBuilder.build();
    }

    public Target.DocumentsTarget encodeDocumentsTarget(com.google.firebase.firestore.core.Target target) {
        Target.DocumentsTarget.Builder newBuilder = Target.DocumentsTarget.newBuilder();
        newBuilder.addDocuments(A(target.getPath()));
        return newBuilder.build();
    }

    public String encodeKey(DocumentKey documentKey) {
        return B(this.f31133a, documentKey.getPath());
    }

    @Nullable
    public Map<String, String> encodeListenRequestLabels(TargetData targetData) {
        String x3 = x(targetData.getPurpose());
        if (x3 == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("goog-listen-tags", x3);
        return hashMap;
    }

    public Write encodeMutation(Mutation mutation) {
        Write.Builder newBuilder = Write.newBuilder();
        if (mutation instanceof SetMutation) {
            newBuilder.setUpdate(encodeDocument(mutation.getKey(), ((SetMutation) mutation).getValue()));
        } else if (mutation instanceof PatchMutation) {
            newBuilder.setUpdate(encodeDocument(mutation.getKey(), ((PatchMutation) mutation).getValue()));
            newBuilder.setUpdateMask(r(mutation.getFieldMask()));
        } else if (mutation instanceof DeleteMutation) {
            newBuilder.setDelete(encodeKey(mutation.getKey()));
        } else if (mutation instanceof VerifyMutation) {
            newBuilder.setVerify(encodeKey(mutation.getKey()));
        } else {
            throw Assert.fail("unknown mutation type %s", mutation.getClass());
        }
        for (FieldTransform fieldTransform : mutation.getFieldTransforms()) {
            newBuilder.addUpdateTransforms(u(fieldTransform));
        }
        if (!mutation.getPrecondition().isNone()) {
            newBuilder.setCurrentDocument(z(mutation.getPrecondition()));
        }
        return newBuilder.build();
    }

    public Target.QueryTarget encodeQueryTarget(com.google.firebase.firestore.core.Target target) {
        boolean z3;
        boolean z4;
        Target.QueryTarget.Builder newBuilder = Target.QueryTarget.newBuilder();
        StructuredQuery.Builder newBuilder2 = StructuredQuery.newBuilder();
        ResourcePath path = target.getPath();
        if (target.getCollectionGroup() != null) {
            if (path.length() % 2 == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assert.hardAssert(z4, "Collection Group queries should be within a document path or root.", new Object[0]);
            newBuilder.setParent(A(path));
            StructuredQuery.CollectionSelector.Builder newBuilder3 = StructuredQuery.CollectionSelector.newBuilder();
            newBuilder3.setCollectionId(target.getCollectionGroup());
            newBuilder3.setAllDescendants(true);
            newBuilder2.addFrom(newBuilder3);
        } else {
            if (path.length() % 2 != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, "Document queries with filters are not supported.", new Object[0]);
            newBuilder.setParent(A(path.popLast()));
            StructuredQuery.CollectionSelector.Builder newBuilder4 = StructuredQuery.CollectionSelector.newBuilder();
            newBuilder4.setCollectionId(path.getLastSegment());
            newBuilder2.addFrom(newBuilder4);
        }
        if (target.getFilters().size() > 0) {
            newBuilder2.setWhere(w(target.getFilters()));
        }
        for (OrderBy orderBy : target.getOrderBy()) {
            newBuilder2.addOrderBy(y(orderBy));
        }
        if (target.hasLimit()) {
            newBuilder2.setLimit(Int32Value.newBuilder().setValue((int) target.getLimit()));
        }
        if (target.getStartAt() != null) {
            Cursor.Builder newBuilder5 = Cursor.newBuilder();
            newBuilder5.addAllValues(target.getStartAt().getPosition());
            newBuilder5.setBefore(target.getStartAt().isInclusive());
            newBuilder2.setStartAt(newBuilder5);
        }
        if (target.getEndAt() != null) {
            Cursor.Builder newBuilder6 = Cursor.newBuilder();
            newBuilder6.addAllValues(target.getEndAt().getPosition());
            newBuilder6.setBefore(!target.getEndAt().isInclusive());
            newBuilder2.setEndAt(newBuilder6);
        }
        newBuilder.setStructuredQuery(newBuilder2);
        return newBuilder.build();
    }

    public Target encodeTarget(TargetData targetData) {
        Target.Builder newBuilder = Target.newBuilder();
        com.google.firebase.firestore.core.Target target = targetData.getTarget();
        if (target.isDocumentQuery()) {
            newBuilder.setDocuments(encodeDocumentsTarget(target));
        } else {
            newBuilder.setQuery(encodeQueryTarget(target));
        }
        newBuilder.setTargetId(targetData.getTargetId());
        if (targetData.getResumeToken().isEmpty() && targetData.getSnapshotVersion().compareTo(SnapshotVersion.NONE) > 0) {
            newBuilder.setReadTime(encodeTimestamp(targetData.getSnapshotVersion().getTimestamp()));
        } else {
            newBuilder.setResumeToken(targetData.getResumeToken());
        }
        if (targetData.getExpectedCount() != null && (!targetData.getResumeToken().isEmpty() || targetData.getSnapshotVersion().compareTo(SnapshotVersion.NONE) > 0)) {
            newBuilder.setExpectedCount(Int32Value.newBuilder().setValue(targetData.getExpectedCount().intValue()));
        }
        return newBuilder.build();
    }

    public com.google.protobuf.Timestamp encodeTimestamp(Timestamp timestamp) {
        Timestamp.Builder newBuilder = com.google.protobuf.Timestamp.newBuilder();
        newBuilder.setSeconds(timestamp.getSeconds());
        newBuilder.setNanos(timestamp.getNanoseconds());
        return newBuilder.build();
    }

    public com.google.protobuf.Timestamp encodeVersion(SnapshotVersion snapshotVersion) {
        return encodeTimestamp(snapshotVersion.getTimestamp());
    }

    @VisibleForTesting
    Filter g(StructuredQuery.Filter filter) {
        int i4 = AnonymousClass1.f31141g[filter.getFilterTypeCase().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return o(filter.getUnaryFilter());
                }
                throw Assert.fail("Unrecognized Filter.filterType %d", filter.getFilterTypeCase());
            }
            return d(filter.getFieldFilter());
        }
        return a(filter.getCompositeFilter());
    }

    public boolean isLocalResourceName(ResourcePath resourcePath) {
        if (H(resourcePath) && resourcePath.getSegment(1).equals(this.f31133a.getProjectId()) && resourcePath.getSegment(3).equals(this.f31133a.getDatabaseId())) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    StructuredQuery.Filter p(CompositeFilter compositeFilter) {
        ArrayList arrayList = new ArrayList(compositeFilter.getFilters().size());
        for (Filter filter : compositeFilter.getFilters()) {
            arrayList.add(v(filter));
        }
        if (arrayList.size() == 1) {
            return (StructuredQuery.Filter) arrayList.get(0);
        }
        StructuredQuery.CompositeFilter.Builder newBuilder = StructuredQuery.CompositeFilter.newBuilder();
        newBuilder.setOp(q(compositeFilter.getOperator()));
        newBuilder.addAllFilters(arrayList);
        return StructuredQuery.Filter.newBuilder().setCompositeFilter(newBuilder).build();
    }

    StructuredQuery.CompositeFilter.Operator q(CompositeFilter.Operator operator) {
        int i4 = AnonymousClass1.f31139e[operator.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return StructuredQuery.CompositeFilter.Operator.OR;
            }
            throw Assert.fail("Unrecognized composite filter type.", new Object[0]);
        }
        return StructuredQuery.CompositeFilter.Operator.AND;
    }

    @VisibleForTesting
    StructuredQuery.Filter v(Filter filter) {
        if (filter instanceof FieldFilter) {
            return D((FieldFilter) filter);
        }
        if (filter instanceof CompositeFilter) {
            return p((CompositeFilter) filter);
        }
        throw Assert.fail("Unrecognized filter type %s", filter.toString());
    }

    public com.google.firebase.firestore.core.Target decodeQueryTarget(Target.QueryTarget queryTarget) {
        return decodeQueryTarget(queryTarget.getParent(), queryTarget.getStructuredQuery());
    }
}
