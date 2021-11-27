// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: InvoiceGenerator.proto

package com.example.invoice.grpc;

public interface InvoiceGeneratorServiceRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.example.invoice.InvoiceGeneratorServiceRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string firstName = 1;</code>
   * @return The firstName.
   */
  java.lang.String getFirstName();
  /**
   * <code>string firstName = 1;</code>
   * @return The bytes for firstName.
   */
  com.google.protobuf.ByteString
      getFirstNameBytes();

  /**
   * <code>string lastName = 2;</code>
   * @return The lastName.
   */
  java.lang.String getLastName();
  /**
   * <code>string lastName = 2;</code>
   * @return The bytes for lastName.
   */
  com.google.protobuf.ByteString
      getLastNameBytes();

  /**
   * <code>string email = 3;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 3;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>sint64 amount = 4;</code>
   * @return The amount.
   */
  long getAmount();

  /**
   * <code>.com.example.invoice.InvoiceGeneratorServiceRequest.Type purchaseType = 5;</code>
   * @return The enum numeric value on the wire for purchaseType.
   */
  int getPurchaseTypeValue();
  /**
   * <code>.com.example.invoice.InvoiceGeneratorServiceRequest.Type purchaseType = 5;</code>
   * @return The purchaseType.
   */
  com.example.invoice.grpc.InvoiceGeneratorServiceRequest.Type getPurchaseType();
}
