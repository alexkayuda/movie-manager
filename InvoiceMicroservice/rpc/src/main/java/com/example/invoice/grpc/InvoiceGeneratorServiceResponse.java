// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: InvoiceGenerator.proto

package com.example.invoice.grpc;

/**
 * Protobuf type {@code com.example.invoice.InvoiceGeneratorServiceResponse}
 */
public  final class InvoiceGeneratorServiceResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.invoice.InvoiceGeneratorServiceResponse)
    InvoiceGeneratorServiceResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use InvoiceGeneratorServiceResponse.newBuilder() to construct.
  private InvoiceGeneratorServiceResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private InvoiceGeneratorServiceResponse() {
    responseMessage_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new InvoiceGeneratorServiceResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private InvoiceGeneratorServiceResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            responseMessage_ = s;
            break;
          }
          case 16: {

            responseCode_ = input.readSInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.invoice.grpc.InvoiceGenerator.internal_static_com_example_invoice_InvoiceGeneratorServiceResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.invoice.grpc.InvoiceGenerator.internal_static_com_example_invoice_InvoiceGeneratorServiceResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.invoice.grpc.InvoiceGeneratorServiceResponse.class, com.example.invoice.grpc.InvoiceGeneratorServiceResponse.Builder.class);
  }

  public static final int RESPONSEMESSAGE_FIELD_NUMBER = 1;
  private volatile java.lang.Object responseMessage_;
  /**
   * <code>string responseMessage = 1;</code>
   * @return The responseMessage.
   */
  public java.lang.String getResponseMessage() {
    java.lang.Object ref = responseMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      responseMessage_ = s;
      return s;
    }
  }
  /**
   * <code>string responseMessage = 1;</code>
   * @return The bytes for responseMessage.
   */
  public com.google.protobuf.ByteString
      getResponseMessageBytes() {
    java.lang.Object ref = responseMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      responseMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RESPONSECODE_FIELD_NUMBER = 2;
  private long responseCode_;
  /**
   * <code>sint64 responseCode = 2;</code>
   * @return The responseCode.
   */
  public long getResponseCode() {
    return responseCode_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getResponseMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, responseMessage_);
    }
    if (responseCode_ != 0L) {
      output.writeSInt64(2, responseCode_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getResponseMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, responseMessage_);
    }
    if (responseCode_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeSInt64Size(2, responseCode_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.invoice.grpc.InvoiceGeneratorServiceResponse)) {
      return super.equals(obj);
    }
    com.example.invoice.grpc.InvoiceGeneratorServiceResponse other = (com.example.invoice.grpc.InvoiceGeneratorServiceResponse) obj;

    if (!getResponseMessage()
        .equals(other.getResponseMessage())) return false;
    if (getResponseCode()
        != other.getResponseCode()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + RESPONSEMESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getResponseMessage().hashCode();
    hash = (37 * hash) + RESPONSECODE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getResponseCode());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.invoice.grpc.InvoiceGeneratorServiceResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.example.invoice.InvoiceGeneratorServiceResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.invoice.InvoiceGeneratorServiceResponse)
      com.example.invoice.grpc.InvoiceGeneratorServiceResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.invoice.grpc.InvoiceGenerator.internal_static_com_example_invoice_InvoiceGeneratorServiceResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.invoice.grpc.InvoiceGenerator.internal_static_com_example_invoice_InvoiceGeneratorServiceResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.invoice.grpc.InvoiceGeneratorServiceResponse.class, com.example.invoice.grpc.InvoiceGeneratorServiceResponse.Builder.class);
    }

    // Construct using com.example.invoice.grpc.InvoiceGeneratorServiceResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      responseMessage_ = "";

      responseCode_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.invoice.grpc.InvoiceGenerator.internal_static_com_example_invoice_InvoiceGeneratorServiceResponse_descriptor;
    }

    @java.lang.Override
    public com.example.invoice.grpc.InvoiceGeneratorServiceResponse getDefaultInstanceForType() {
      return com.example.invoice.grpc.InvoiceGeneratorServiceResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.invoice.grpc.InvoiceGeneratorServiceResponse build() {
      com.example.invoice.grpc.InvoiceGeneratorServiceResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.invoice.grpc.InvoiceGeneratorServiceResponse buildPartial() {
      com.example.invoice.grpc.InvoiceGeneratorServiceResponse result = new com.example.invoice.grpc.InvoiceGeneratorServiceResponse(this);
      result.responseMessage_ = responseMessage_;
      result.responseCode_ = responseCode_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.invoice.grpc.InvoiceGeneratorServiceResponse) {
        return mergeFrom((com.example.invoice.grpc.InvoiceGeneratorServiceResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.invoice.grpc.InvoiceGeneratorServiceResponse other) {
      if (other == com.example.invoice.grpc.InvoiceGeneratorServiceResponse.getDefaultInstance()) return this;
      if (!other.getResponseMessage().isEmpty()) {
        responseMessage_ = other.responseMessage_;
        onChanged();
      }
      if (other.getResponseCode() != 0L) {
        setResponseCode(other.getResponseCode());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.invoice.grpc.InvoiceGeneratorServiceResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.invoice.grpc.InvoiceGeneratorServiceResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object responseMessage_ = "";
    /**
     * <code>string responseMessage = 1;</code>
     * @return The responseMessage.
     */
    public java.lang.String getResponseMessage() {
      java.lang.Object ref = responseMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        responseMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string responseMessage = 1;</code>
     * @return The bytes for responseMessage.
     */
    public com.google.protobuf.ByteString
        getResponseMessageBytes() {
      java.lang.Object ref = responseMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        responseMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string responseMessage = 1;</code>
     * @param value The responseMessage to set.
     * @return This builder for chaining.
     */
    public Builder setResponseMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      responseMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string responseMessage = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearResponseMessage() {
      
      responseMessage_ = getDefaultInstance().getResponseMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string responseMessage = 1;</code>
     * @param value The bytes for responseMessage to set.
     * @return This builder for chaining.
     */
    public Builder setResponseMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      responseMessage_ = value;
      onChanged();
      return this;
    }

    private long responseCode_ ;
    /**
     * <code>sint64 responseCode = 2;</code>
     * @return The responseCode.
     */
    public long getResponseCode() {
      return responseCode_;
    }
    /**
     * <code>sint64 responseCode = 2;</code>
     * @param value The responseCode to set.
     * @return This builder for chaining.
     */
    public Builder setResponseCode(long value) {
      
      responseCode_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>sint64 responseCode = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearResponseCode() {
      
      responseCode_ = 0L;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.example.invoice.InvoiceGeneratorServiceResponse)
  }

  // @@protoc_insertion_point(class_scope:com.example.invoice.InvoiceGeneratorServiceResponse)
  private static final com.example.invoice.grpc.InvoiceGeneratorServiceResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.invoice.grpc.InvoiceGeneratorServiceResponse();
  }

  public static com.example.invoice.grpc.InvoiceGeneratorServiceResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<InvoiceGeneratorServiceResponse>
      PARSER = new com.google.protobuf.AbstractParser<InvoiceGeneratorServiceResponse>() {
    @java.lang.Override
    public InvoiceGeneratorServiceResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new InvoiceGeneratorServiceResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<InvoiceGeneratorServiceResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<InvoiceGeneratorServiceResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.invoice.grpc.InvoiceGeneratorServiceResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

