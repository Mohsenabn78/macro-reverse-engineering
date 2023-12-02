package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;

/* loaded from: classes5.dex */
public class NumericIncrementTransformOperation implements TransformOperation {

    /* renamed from: a  reason: collision with root package name */
    private Value f30998a;

    public NumericIncrementTransformOperation(Value value) {
        Assert.hardAssert(Values.isNumber(value), "NumericIncrementTransformOperation expects a NumberValue operand", new Object[0]);
        this.f30998a = value;
    }

    private double a() {
        if (Values.isDouble(this.f30998a)) {
            return this.f30998a.getDoubleValue();
        }
        if (Values.isInteger(this.f30998a)) {
            return this.f30998a.getIntegerValue();
        }
        throw Assert.fail("Expected 'operand' to be of Number type, but was " + this.f30998a.getClass().getCanonicalName(), new Object[0]);
    }

    private long b() {
        if (Values.isDouble(this.f30998a)) {
            return (long) this.f30998a.getDoubleValue();
        }
        if (Values.isInteger(this.f30998a)) {
            return this.f30998a.getIntegerValue();
        }
        throw Assert.fail("Expected 'operand' to be of Number type, but was " + this.f30998a.getClass().getCanonicalName(), new Object[0]);
    }

    private long c(long j4, long j5) {
        long j6 = j4 + j5;
        if (((j4 ^ j6) & (j5 ^ j6)) >= 0) {
            return j6;
        }
        if (j6 >= 0) {
            return Long.MIN_VALUE;
        }
        return Long.MAX_VALUE;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public Value applyToLocalView(@Nullable Value value, Timestamp timestamp) {
        Value computeBaseValue = computeBaseValue(value);
        if (Values.isInteger(computeBaseValue) && Values.isInteger(this.f30998a)) {
            return Value.newBuilder().setIntegerValue(c(computeBaseValue.getIntegerValue(), b())).build();
        }
        if (Values.isInteger(computeBaseValue)) {
            return Value.newBuilder().setDoubleValue(computeBaseValue.getIntegerValue() + a()).build();
        }
        Assert.hardAssert(Values.isDouble(computeBaseValue), "Expected NumberValue to be of type DoubleValue, but was ", value.getClass().getCanonicalName());
        return Value.newBuilder().setDoubleValue(computeBaseValue.getDoubleValue() + a()).build();
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public Value computeBaseValue(@Nullable Value value) {
        if (!Values.isNumber(value)) {
            return Value.newBuilder().setIntegerValue(0L).build();
        }
        return value;
    }

    public Value getOperand() {
        return this.f30998a;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public Value applyToRemoteDocument(@Nullable Value value, Value value2) {
        return value2;
    }
}
