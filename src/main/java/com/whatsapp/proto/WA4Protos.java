package com.whatsapp.proto;

public final class WA4Protos {
	private WA4Protos() {}
	public static void registerAllExtensions(
			com.google.protobuf.ExtensionRegistryLite registry) {
	}

	public static void registerAllExtensions(
			com.google.protobuf.ExtensionRegistry registry) {
		registerAllExtensions(
				(com.google.protobuf.ExtensionRegistryLite) registry);
	}
	public interface HandshakeMessageOrBuilder extends
			// @@protoc_insertion_point(interface_extends:whatsapp.HandshakeMessage)
			com.google.protobuf.MessageOrBuilder {

		/**
		 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
		 * @return Whether the clientHello field is set.
		 */
		boolean hasClientHello();
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
		 * @return The clientHello.
		 */
		com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello getClientHello();
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
		 */
		com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHelloOrBuilder getClientHelloOrBuilder();

		/**
		 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
		 * @return Whether the serverHello field is set.
		 */
		boolean hasServerHello();
		/**
		 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
		 * @return The serverHello.
		 */
		com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello getServerHello();
		/**
		 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
		 */
		com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHelloOrBuilder getServerHelloOrBuilder();

		/**
		 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
		 * @return Whether the clientFinish field is set.
		 */
		boolean hasClientFinish();
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
		 * @return The clientFinish.
		 */
		com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish getClientFinish();
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
		 */
		com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinishOrBuilder getClientFinishOrBuilder();
	}
	/**
	 * Protobuf type {@code whatsapp.HandshakeMessage}
	 */
	public static final class HandshakeMessage extends
			com.google.protobuf.GeneratedMessageV3 implements
			// @@protoc_insertion_point(message_implements:whatsapp.HandshakeMessage)
			HandshakeMessageOrBuilder {
		private static final long serialVersionUID = 0L;
		// Use HandshakeMessage.newBuilder() to construct.
		private HandshakeMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
			super(builder);
		}
		private HandshakeMessage() {
		}

		@java.lang.Override
		@SuppressWarnings({"unused"})
		protected java.lang.Object newInstance(
				UnusedPrivateParameter unused) {
			return new HandshakeMessage();
		}

		@java.lang.Override
		public final com.google.protobuf.UnknownFieldSet
		getUnknownFields() {
			return this.unknownFields;
		}
		private HandshakeMessage(
				com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			this();
			if (extensionRegistry == null) {
				throw new java.lang.NullPointerException();
			}
			int mutable_bitField0_ = 0;
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
						case 18: {
							com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.Builder subBuilder = null;
							if (((bitField0_ & 0x00000001) != 0)) {
								subBuilder = clientHello_.toBuilder();
							}
							clientHello_ = input.readMessage(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.parser(), extensionRegistry);
							if (subBuilder != null) {
								subBuilder.mergeFrom(clientHello_);
								clientHello_ = subBuilder.buildPartial();
							}
							bitField0_ |= 0x00000001;
							break;
						}
						case 26: {
							com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.Builder subBuilder = null;
							if (((bitField0_ & 0x00000002) != 0)) {
								subBuilder = serverHello_.toBuilder();
							}
							serverHello_ = input.readMessage(com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.parser(), extensionRegistry);
							if (subBuilder != null) {
								subBuilder.mergeFrom(serverHello_);
								serverHello_ = subBuilder.buildPartial();
							}
							bitField0_ |= 0x00000002;
							break;
						}
						case 34: {
							com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.Builder subBuilder = null;
							if (((bitField0_ & 0x00000004) != 0)) {
								subBuilder = clientFinish_.toBuilder();
							}
							clientFinish_ = input.readMessage(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.parser(), extensionRegistry);
							if (subBuilder != null) {
								subBuilder.mergeFrom(clientFinish_);
								clientFinish_ = subBuilder.buildPartial();
							}
							bitField0_ |= 0x00000004;
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
			return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_descriptor;
		}

		@java.lang.Override
		protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
		internalGetFieldAccessorTable() {
			return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_fieldAccessorTable
					.ensureFieldAccessorsInitialized(
							com.whatsapp.proto.WA4Protos.HandshakeMessage.class, com.whatsapp.proto.WA4Protos.HandshakeMessage.Builder.class);
		}

		public interface ClientHelloOrBuilder extends
				// @@protoc_insertion_point(interface_extends:whatsapp.HandshakeMessage.ClientHello)
				com.google.protobuf.MessageOrBuilder {

			/**
			 * <code>bytes ephemeral = 1;</code>
			 * @return Whether the ephemeral field is set.
			 */
			boolean hasEphemeral();
			/**
			 * <code>bytes ephemeral = 1;</code>
			 * @return The ephemeral.
			 */
			com.google.protobuf.ByteString getEphemeral();

			/**
			 * <code>bytes static = 2;</code>
			 * @return Whether the static field is set.
			 */
			boolean hasStatic();
			/**
			 * <code>bytes static = 2;</code>
			 * @return The static.
			 */
			com.google.protobuf.ByteString getStatic();

			/**
			 * <code>bytes payload = 3;</code>
			 * @return Whether the payload field is set.
			 */
			boolean hasPayload();
			/**
			 * <code>bytes payload = 3;</code>
			 * @return The payload.
			 */
			com.google.protobuf.ByteString getPayload();
		}
		/**
		 * Protobuf type {@code whatsapp.HandshakeMessage.ClientHello}
		 */
		public static final class ClientHello extends
				com.google.protobuf.GeneratedMessageV3 implements
				// @@protoc_insertion_point(message_implements:whatsapp.HandshakeMessage.ClientHello)
				ClientHelloOrBuilder {
			private static final long serialVersionUID = 0L;
			// Use ClientHello.newBuilder() to construct.
			private ClientHello(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
				super(builder);
			}
			private ClientHello() {
				ephemeral_ = com.google.protobuf.ByteString.EMPTY;
				static_ = com.google.protobuf.ByteString.EMPTY;
				payload_ = com.google.protobuf.ByteString.EMPTY;
			}

			@java.lang.Override
			@SuppressWarnings({"unused"})
			protected java.lang.Object newInstance(
					UnusedPrivateParameter unused) {
				return new ClientHello();
			}

			@java.lang.Override
			public final com.google.protobuf.UnknownFieldSet
			getUnknownFields() {
				return this.unknownFields;
			}
			private ClientHello(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				this();
				if (extensionRegistry == null) {
					throw new java.lang.NullPointerException();
				}
				int mutable_bitField0_ = 0;
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
								bitField0_ |= 0x00000001;
								ephemeral_ = input.readBytes();
								break;
							}
							case 18: {
								bitField0_ |= 0x00000002;
								static_ = input.readBytes();
								break;
							}
							case 26: {
								bitField0_ |= 0x00000004;
								payload_ = input.readBytes();
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
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientHello_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientHello_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.class, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.Builder.class);
			}

			private int bitField0_;
			public static final int EPHEMERAL_FIELD_NUMBER = 1;
			private com.google.protobuf.ByteString ephemeral_;
			/**
			 * <code>bytes ephemeral = 1;</code>
			 * @return Whether the ephemeral field is set.
			 */
			@java.lang.Override
			public boolean hasEphemeral() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>bytes ephemeral = 1;</code>
			 * @return The ephemeral.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getEphemeral() {
				return ephemeral_;
			}

			public static final int STATIC_FIELD_NUMBER = 2;
			private com.google.protobuf.ByteString static_;
			/**
			 * <code>bytes static = 2;</code>
			 * @return Whether the static field is set.
			 */
			@java.lang.Override
			public boolean hasStatic() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>bytes static = 2;</code>
			 * @return The static.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getStatic() {
				return static_;
			}

			public static final int PAYLOAD_FIELD_NUMBER = 3;
			private com.google.protobuf.ByteString payload_;
			/**
			 * <code>bytes payload = 3;</code>
			 * @return Whether the payload field is set.
			 */
			@java.lang.Override
			public boolean hasPayload() {
				return ((bitField0_ & 0x00000004) != 0);
			}
			/**
			 * <code>bytes payload = 3;</code>
			 * @return The payload.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getPayload() {
				return payload_;
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
				if (((bitField0_ & 0x00000001) != 0)) {
					output.writeBytes(1, ephemeral_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					output.writeBytes(2, static_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					output.writeBytes(3, payload_);
				}
				unknownFields.writeTo(output);
			}

			@java.lang.Override
			public int getSerializedSize() {
				int size = memoizedSize;
				if (size != -1) return size;

				size = 0;
				if (((bitField0_ & 0x00000001) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(1, ephemeral_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(2, static_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(3, payload_);
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
				if (!(obj instanceof com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello)) {
					return super.equals(obj);
				}
				com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello other = (com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello) obj;

				if (hasEphemeral() != other.hasEphemeral()) return false;
				if (hasEphemeral()) {
					if (!getEphemeral()
							.equals(other.getEphemeral())) return false;
				}
				if (hasStatic() != other.hasStatic()) return false;
				if (hasStatic()) {
					if (!getStatic()
							.equals(other.getStatic())) return false;
				}
				if (hasPayload() != other.hasPayload()) return false;
				if (hasPayload()) {
					if (!getPayload()
							.equals(other.getPayload())) return false;
				}
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
				if (hasEphemeral()) {
					hash = (37 * hash) + EPHEMERAL_FIELD_NUMBER;
					hash = (53 * hash) + getEphemeral().hashCode();
				}
				if (hasStatic()) {
					hash = (37 * hash) + STATIC_FIELD_NUMBER;
					hash = (53 * hash) + getStatic().hashCode();
				}
				if (hasPayload()) {
					hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
					hash = (53 * hash) + getPayload().hashCode();
				}
				hash = (29 * hash) + unknownFields.hashCode();
				memoizedHashCode = hash;
				return hash;
			}

			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(
					java.nio.ByteBuffer data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(
					java.nio.ByteBuffer data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(
					com.google.protobuf.ByteString data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(
					com.google.protobuf.ByteString data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(byte[] data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(
					byte[] data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseDelimitedFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseDelimitedFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(
					com.google.protobuf.CodedInputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parseFrom(
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
			public static Builder newBuilder(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello prototype) {
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
			 * Protobuf type {@code whatsapp.HandshakeMessage.ClientHello}
			 */
			public static final class Builder extends
					com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
					// @@protoc_insertion_point(builder_implements:whatsapp.HandshakeMessage.ClientHello)
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHelloOrBuilder {
				public static final com.google.protobuf.Descriptors.Descriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientHello_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientHello_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.class, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.Builder.class);
				}

				// Construct using com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.newBuilder()
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
					ephemeral_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000001);
					static_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000002);
					payload_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000004);
					return this;
				}

				@java.lang.Override
				public com.google.protobuf.Descriptors.Descriptor
				getDescriptorForType() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientHello_descriptor;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello getDefaultInstanceForType() {
					return com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.getDefaultInstance();
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello build() {
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello result = buildPartial();
					if (!result.isInitialized()) {
						throw newUninitializedMessageException(result);
					}
					return result;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello buildPartial() {
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello result = new com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello(this);
					int from_bitField0_ = bitField0_;
					int to_bitField0_ = 0;
					if (((from_bitField0_ & 0x00000001) != 0)) {
						to_bitField0_ |= 0x00000001;
					}
					result.ephemeral_ = ephemeral_;
					if (((from_bitField0_ & 0x00000002) != 0)) {
						to_bitField0_ |= 0x00000002;
					}
					result.static_ = static_;
					if (((from_bitField0_ & 0x00000004) != 0)) {
						to_bitField0_ |= 0x00000004;
					}
					result.payload_ = payload_;
					result.bitField0_ = to_bitField0_;
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
					if (other instanceof com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello) {
						return mergeFrom((com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello)other);
					} else {
						super.mergeFrom(other);
						return this;
					}
				}

				public Builder mergeFrom(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello other) {
					if (other == com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.getDefaultInstance()) return this;
					if (other.hasEphemeral()) {
						setEphemeral(other.getEphemeral());
					}
					if (other.hasStatic()) {
						setStatic(other.getStatic());
					}
					if (other.hasPayload()) {
						setPayload(other.getPayload());
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
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello parsedMessage = null;
					try {
						parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
					} catch (com.google.protobuf.InvalidProtocolBufferException e) {
						parsedMessage = (com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello) e.getUnfinishedMessage();
						throw e.unwrapIOException();
					} finally {
						if (parsedMessage != null) {
							mergeFrom(parsedMessage);
						}
					}
					return this;
				}
				private int bitField0_;

				private com.google.protobuf.ByteString ephemeral_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes ephemeral = 1;</code>
				 * @return Whether the ephemeral field is set.
				 */
				@java.lang.Override
				public boolean hasEphemeral() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>bytes ephemeral = 1;</code>
				 * @return The ephemeral.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getEphemeral() {
					return ephemeral_;
				}
				/**
				 * <code>bytes ephemeral = 1;</code>
				 * @param value The ephemeral to set.
				 * @return This builder for chaining.
				 */
				public Builder setEphemeral(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000001;
					ephemeral_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes ephemeral = 1;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearEphemeral() {
					bitField0_ = (bitField0_ & ~0x00000001);
					ephemeral_ = getDefaultInstance().getEphemeral();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString static_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes static = 2;</code>
				 * @return Whether the static field is set.
				 */
				@java.lang.Override
				public boolean hasStatic() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>bytes static = 2;</code>
				 * @return The static.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getStatic() {
					return static_;
				}
				/**
				 * <code>bytes static = 2;</code>
				 * @param value The static to set.
				 * @return This builder for chaining.
				 */
				public Builder setStatic(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000002;
					static_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes static = 2;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearStatic() {
					bitField0_ = (bitField0_ & ~0x00000002);
					static_ = getDefaultInstance().getStatic();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString payload_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes payload = 3;</code>
				 * @return Whether the payload field is set.
				 */
				@java.lang.Override
				public boolean hasPayload() {
					return ((bitField0_ & 0x00000004) != 0);
				}
				/**
				 * <code>bytes payload = 3;</code>
				 * @return The payload.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getPayload() {
					return payload_;
				}
				/**
				 * <code>bytes payload = 3;</code>
				 * @param value The payload to set.
				 * @return This builder for chaining.
				 */
				public Builder setPayload(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000004;
					payload_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes payload = 3;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearPayload() {
					bitField0_ = (bitField0_ & ~0x00000004);
					payload_ = getDefaultInstance().getPayload();
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


				// @@protoc_insertion_point(builder_scope:whatsapp.HandshakeMessage.ClientHello)
			}

			// @@protoc_insertion_point(class_scope:whatsapp.HandshakeMessage.ClientHello)
			private static final com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello DEFAULT_INSTANCE;
			static {
				DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello();
			}

			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello getDefaultInstance() {
				return DEFAULT_INSTANCE;
			}

			private static final com.google.protobuf.Parser<ClientHello>
					PARSER = new com.google.protobuf.AbstractParser<ClientHello>() {
				@java.lang.Override
				public ClientHello parsePartialFrom(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return new ClientHello(input, extensionRegistry);
				}
			};

			public static com.google.protobuf.Parser<ClientHello> parser() {
				return PARSER;
			}

			@java.lang.Override
			public com.google.protobuf.Parser<ClientHello> getParserForType() {
				return PARSER;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello getDefaultInstanceForType() {
				return DEFAULT_INSTANCE;
			}

		}

		public interface ServerHelloOrBuilder extends
				// @@protoc_insertion_point(interface_extends:whatsapp.HandshakeMessage.ServerHello)
				com.google.protobuf.MessageOrBuilder {

			/**
			 * <code>bytes ephemeral = 1;</code>
			 * @return Whether the ephemeral field is set.
			 */
			boolean hasEphemeral();
			/**
			 * <code>bytes ephemeral = 1;</code>
			 * @return The ephemeral.
			 */
			com.google.protobuf.ByteString getEphemeral();

			/**
			 * <code>bytes static = 2;</code>
			 * @return Whether the static field is set.
			 */
			boolean hasStatic();
			/**
			 * <code>bytes static = 2;</code>
			 * @return The static.
			 */
			com.google.protobuf.ByteString getStatic();

			/**
			 * <code>bytes payload = 3;</code>
			 * @return Whether the payload field is set.
			 */
			boolean hasPayload();
			/**
			 * <code>bytes payload = 3;</code>
			 * @return The payload.
			 */
			com.google.protobuf.ByteString getPayload();
		}
		/**
		 * Protobuf type {@code whatsapp.HandshakeMessage.ServerHello}
		 */
		public static final class ServerHello extends
				com.google.protobuf.GeneratedMessageV3 implements
				// @@protoc_insertion_point(message_implements:whatsapp.HandshakeMessage.ServerHello)
				ServerHelloOrBuilder {
			private static final long serialVersionUID = 0L;
			// Use ServerHello.newBuilder() to construct.
			private ServerHello(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
				super(builder);
			}
			private ServerHello() {
				ephemeral_ = com.google.protobuf.ByteString.EMPTY;
				static_ = com.google.protobuf.ByteString.EMPTY;
				payload_ = com.google.protobuf.ByteString.EMPTY;
			}

			@java.lang.Override
			@SuppressWarnings({"unused"})
			protected java.lang.Object newInstance(
					UnusedPrivateParameter unused) {
				return new ServerHello();
			}

			@java.lang.Override
			public final com.google.protobuf.UnknownFieldSet
			getUnknownFields() {
				return this.unknownFields;
			}
			private ServerHello(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				this();
				if (extensionRegistry == null) {
					throw new java.lang.NullPointerException();
				}
				int mutable_bitField0_ = 0;
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
								bitField0_ |= 0x00000001;
								ephemeral_ = input.readBytes();
								break;
							}
							case 18: {
								bitField0_ |= 0x00000002;
								static_ = input.readBytes();
								break;
							}
							case 26: {
								bitField0_ |= 0x00000004;
								payload_ = input.readBytes();
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
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ServerHello_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ServerHello_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.class, com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.Builder.class);
			}

			private int bitField0_;
			public static final int EPHEMERAL_FIELD_NUMBER = 1;
			private com.google.protobuf.ByteString ephemeral_;
			/**
			 * <code>bytes ephemeral = 1;</code>
			 * @return Whether the ephemeral field is set.
			 */
			@java.lang.Override
			public boolean hasEphemeral() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>bytes ephemeral = 1;</code>
			 * @return The ephemeral.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getEphemeral() {
				return ephemeral_;
			}

			public static final int STATIC_FIELD_NUMBER = 2;
			private com.google.protobuf.ByteString static_;
			/**
			 * <code>bytes static = 2;</code>
			 * @return Whether the static field is set.
			 */
			@java.lang.Override
			public boolean hasStatic() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>bytes static = 2;</code>
			 * @return The static.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getStatic() {
				return static_;
			}

			public static final int PAYLOAD_FIELD_NUMBER = 3;
			private com.google.protobuf.ByteString payload_;
			/**
			 * <code>bytes payload = 3;</code>
			 * @return Whether the payload field is set.
			 */
			@java.lang.Override
			public boolean hasPayload() {
				return ((bitField0_ & 0x00000004) != 0);
			}
			/**
			 * <code>bytes payload = 3;</code>
			 * @return The payload.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getPayload() {
				return payload_;
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
				if (((bitField0_ & 0x00000001) != 0)) {
					output.writeBytes(1, ephemeral_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					output.writeBytes(2, static_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					output.writeBytes(3, payload_);
				}
				unknownFields.writeTo(output);
			}

			@java.lang.Override
			public int getSerializedSize() {
				int size = memoizedSize;
				if (size != -1) return size;

				size = 0;
				if (((bitField0_ & 0x00000001) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(1, ephemeral_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(2, static_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(3, payload_);
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
				if (!(obj instanceof com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello)) {
					return super.equals(obj);
				}
				com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello other = (com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello) obj;

				if (hasEphemeral() != other.hasEphemeral()) return false;
				if (hasEphemeral()) {
					if (!getEphemeral()
							.equals(other.getEphemeral())) return false;
				}
				if (hasStatic() != other.hasStatic()) return false;
				if (hasStatic()) {
					if (!getStatic()
							.equals(other.getStatic())) return false;
				}
				if (hasPayload() != other.hasPayload()) return false;
				if (hasPayload()) {
					if (!getPayload()
							.equals(other.getPayload())) return false;
				}
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
				if (hasEphemeral()) {
					hash = (37 * hash) + EPHEMERAL_FIELD_NUMBER;
					hash = (53 * hash) + getEphemeral().hashCode();
				}
				if (hasStatic()) {
					hash = (37 * hash) + STATIC_FIELD_NUMBER;
					hash = (53 * hash) + getStatic().hashCode();
				}
				if (hasPayload()) {
					hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
					hash = (53 * hash) + getPayload().hashCode();
				}
				hash = (29 * hash) + unknownFields.hashCode();
				memoizedHashCode = hash;
				return hash;
			}

			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(
					java.nio.ByteBuffer data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(
					java.nio.ByteBuffer data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(
					com.google.protobuf.ByteString data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(
					com.google.protobuf.ByteString data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(byte[] data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(
					byte[] data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseDelimitedFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseDelimitedFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(
					com.google.protobuf.CodedInputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parseFrom(
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
			public static Builder newBuilder(com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello prototype) {
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
			 * Protobuf type {@code whatsapp.HandshakeMessage.ServerHello}
			 */
			public static final class Builder extends
					com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
					// @@protoc_insertion_point(builder_implements:whatsapp.HandshakeMessage.ServerHello)
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHelloOrBuilder {
				public static final com.google.protobuf.Descriptors.Descriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ServerHello_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ServerHello_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.class, com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.Builder.class);
				}

				// Construct using com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.newBuilder()
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
					ephemeral_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000001);
					static_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000002);
					payload_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000004);
					return this;
				}

				@java.lang.Override
				public com.google.protobuf.Descriptors.Descriptor
				getDescriptorForType() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ServerHello_descriptor;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello getDefaultInstanceForType() {
					return com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.getDefaultInstance();
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello build() {
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello result = buildPartial();
					if (!result.isInitialized()) {
						throw newUninitializedMessageException(result);
					}
					return result;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello buildPartial() {
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello result = new com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello(this);
					int from_bitField0_ = bitField0_;
					int to_bitField0_ = 0;
					if (((from_bitField0_ & 0x00000001) != 0)) {
						to_bitField0_ |= 0x00000001;
					}
					result.ephemeral_ = ephemeral_;
					if (((from_bitField0_ & 0x00000002) != 0)) {
						to_bitField0_ |= 0x00000002;
					}
					result.static_ = static_;
					if (((from_bitField0_ & 0x00000004) != 0)) {
						to_bitField0_ |= 0x00000004;
					}
					result.payload_ = payload_;
					result.bitField0_ = to_bitField0_;
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
					if (other instanceof com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello) {
						return mergeFrom((com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello)other);
					} else {
						super.mergeFrom(other);
						return this;
					}
				}

				public Builder mergeFrom(com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello other) {
					if (other == com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.getDefaultInstance()) return this;
					if (other.hasEphemeral()) {
						setEphemeral(other.getEphemeral());
					}
					if (other.hasStatic()) {
						setStatic(other.getStatic());
					}
					if (other.hasPayload()) {
						setPayload(other.getPayload());
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
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello parsedMessage = null;
					try {
						parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
					} catch (com.google.protobuf.InvalidProtocolBufferException e) {
						parsedMessage = (com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello) e.getUnfinishedMessage();
						throw e.unwrapIOException();
					} finally {
						if (parsedMessage != null) {
							mergeFrom(parsedMessage);
						}
					}
					return this;
				}
				private int bitField0_;

				private com.google.protobuf.ByteString ephemeral_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes ephemeral = 1;</code>
				 * @return Whether the ephemeral field is set.
				 */
				@java.lang.Override
				public boolean hasEphemeral() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>bytes ephemeral = 1;</code>
				 * @return The ephemeral.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getEphemeral() {
					return ephemeral_;
				}
				/**
				 * <code>bytes ephemeral = 1;</code>
				 * @param value The ephemeral to set.
				 * @return This builder for chaining.
				 */
				public Builder setEphemeral(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000001;
					ephemeral_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes ephemeral = 1;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearEphemeral() {
					bitField0_ = (bitField0_ & ~0x00000001);
					ephemeral_ = getDefaultInstance().getEphemeral();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString static_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes static = 2;</code>
				 * @return Whether the static field is set.
				 */
				@java.lang.Override
				public boolean hasStatic() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>bytes static = 2;</code>
				 * @return The static.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getStatic() {
					return static_;
				}
				/**
				 * <code>bytes static = 2;</code>
				 * @param value The static to set.
				 * @return This builder for chaining.
				 */
				public Builder setStatic(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000002;
					static_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes static = 2;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearStatic() {
					bitField0_ = (bitField0_ & ~0x00000002);
					static_ = getDefaultInstance().getStatic();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString payload_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes payload = 3;</code>
				 * @return Whether the payload field is set.
				 */
				@java.lang.Override
				public boolean hasPayload() {
					return ((bitField0_ & 0x00000004) != 0);
				}
				/**
				 * <code>bytes payload = 3;</code>
				 * @return The payload.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getPayload() {
					return payload_;
				}
				/**
				 * <code>bytes payload = 3;</code>
				 * @param value The payload to set.
				 * @return This builder for chaining.
				 */
				public Builder setPayload(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000004;
					payload_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes payload = 3;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearPayload() {
					bitField0_ = (bitField0_ & ~0x00000004);
					payload_ = getDefaultInstance().getPayload();
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


				// @@protoc_insertion_point(builder_scope:whatsapp.HandshakeMessage.ServerHello)
			}

			// @@protoc_insertion_point(class_scope:whatsapp.HandshakeMessage.ServerHello)
			private static final com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello DEFAULT_INSTANCE;
			static {
				DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello();
			}

			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello getDefaultInstance() {
				return DEFAULT_INSTANCE;
			}

			private static final com.google.protobuf.Parser<ServerHello>
					PARSER = new com.google.protobuf.AbstractParser<ServerHello>() {
				@java.lang.Override
				public ServerHello parsePartialFrom(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return new ServerHello(input, extensionRegistry);
				}
			};

			public static com.google.protobuf.Parser<ServerHello> parser() {
				return PARSER;
			}

			@java.lang.Override
			public com.google.protobuf.Parser<ServerHello> getParserForType() {
				return PARSER;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello getDefaultInstanceForType() {
				return DEFAULT_INSTANCE;
			}

		}

		public interface ClientFinishOrBuilder extends
				// @@protoc_insertion_point(interface_extends:whatsapp.HandshakeMessage.ClientFinish)
				com.google.protobuf.MessageOrBuilder {

			/**
			 * <code>bytes static = 1;</code>
			 * @return Whether the static field is set.
			 */
			boolean hasStatic();
			/**
			 * <code>bytes static = 1;</code>
			 * @return The static.
			 */
			com.google.protobuf.ByteString getStatic();

			/**
			 * <code>bytes payload = 2;</code>
			 * @return Whether the payload field is set.
			 */
			boolean hasPayload();
			/**
			 * <code>bytes payload = 2;</code>
			 * @return The payload.
			 */
			com.google.protobuf.ByteString getPayload();
		}
		/**
		 * Protobuf type {@code whatsapp.HandshakeMessage.ClientFinish}
		 */
		public static final class ClientFinish extends
				com.google.protobuf.GeneratedMessageV3 implements
				// @@protoc_insertion_point(message_implements:whatsapp.HandshakeMessage.ClientFinish)
				ClientFinishOrBuilder {
			private static final long serialVersionUID = 0L;
			// Use ClientFinish.newBuilder() to construct.
			private ClientFinish(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
				super(builder);
			}
			private ClientFinish() {
				static_ = com.google.protobuf.ByteString.EMPTY;
				payload_ = com.google.protobuf.ByteString.EMPTY;
			}

			@java.lang.Override
			@SuppressWarnings({"unused"})
			protected java.lang.Object newInstance(
					UnusedPrivateParameter unused) {
				return new ClientFinish();
			}

			@java.lang.Override
			public final com.google.protobuf.UnknownFieldSet
			getUnknownFields() {
				return this.unknownFields;
			}
			private ClientFinish(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				this();
				if (extensionRegistry == null) {
					throw new java.lang.NullPointerException();
				}
				int mutable_bitField0_ = 0;
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
								bitField0_ |= 0x00000001;
								static_ = input.readBytes();
								break;
							}
							case 18: {
								bitField0_ |= 0x00000002;
								payload_ = input.readBytes();
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
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientFinish_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientFinish_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.class, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.Builder.class);
			}

			private int bitField0_;
			public static final int STATIC_FIELD_NUMBER = 1;
			private com.google.protobuf.ByteString static_;
			/**
			 * <code>bytes static = 1;</code>
			 * @return Whether the static field is set.
			 */
			@java.lang.Override
			public boolean hasStatic() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>bytes static = 1;</code>
			 * @return The static.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getStatic() {
				return static_;
			}

			public static final int PAYLOAD_FIELD_NUMBER = 2;
			private com.google.protobuf.ByteString payload_;
			/**
			 * <code>bytes payload = 2;</code>
			 * @return Whether the payload field is set.
			 */
			@java.lang.Override
			public boolean hasPayload() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>bytes payload = 2;</code>
			 * @return The payload.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getPayload() {
				return payload_;
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
				if (((bitField0_ & 0x00000001) != 0)) {
					output.writeBytes(1, static_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					output.writeBytes(2, payload_);
				}
				unknownFields.writeTo(output);
			}

			@java.lang.Override
			public int getSerializedSize() {
				int size = memoizedSize;
				if (size != -1) return size;

				size = 0;
				if (((bitField0_ & 0x00000001) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(1, static_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(2, payload_);
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
				if (!(obj instanceof com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish)) {
					return super.equals(obj);
				}
				com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish other = (com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish) obj;

				if (hasStatic() != other.hasStatic()) return false;
				if (hasStatic()) {
					if (!getStatic()
							.equals(other.getStatic())) return false;
				}
				if (hasPayload() != other.hasPayload()) return false;
				if (hasPayload()) {
					if (!getPayload()
							.equals(other.getPayload())) return false;
				}
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
				if (hasStatic()) {
					hash = (37 * hash) + STATIC_FIELD_NUMBER;
					hash = (53 * hash) + getStatic().hashCode();
				}
				if (hasPayload()) {
					hash = (37 * hash) + PAYLOAD_FIELD_NUMBER;
					hash = (53 * hash) + getPayload().hashCode();
				}
				hash = (29 * hash) + unknownFields.hashCode();
				memoizedHashCode = hash;
				return hash;
			}

			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(
					java.nio.ByteBuffer data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(
					java.nio.ByteBuffer data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(
					com.google.protobuf.ByteString data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(
					com.google.protobuf.ByteString data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(byte[] data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(
					byte[] data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseDelimitedFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseDelimitedFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(
					com.google.protobuf.CodedInputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parseFrom(
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
			public static Builder newBuilder(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish prototype) {
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
			 * Protobuf type {@code whatsapp.HandshakeMessage.ClientFinish}
			 */
			public static final class Builder extends
					com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
					// @@protoc_insertion_point(builder_implements:whatsapp.HandshakeMessage.ClientFinish)
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinishOrBuilder {
				public static final com.google.protobuf.Descriptors.Descriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientFinish_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientFinish_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.class, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.Builder.class);
				}

				// Construct using com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.newBuilder()
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
					static_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000001);
					payload_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000002);
					return this;
				}

				@java.lang.Override
				public com.google.protobuf.Descriptors.Descriptor
				getDescriptorForType() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_ClientFinish_descriptor;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish getDefaultInstanceForType() {
					return com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.getDefaultInstance();
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish build() {
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish result = buildPartial();
					if (!result.isInitialized()) {
						throw newUninitializedMessageException(result);
					}
					return result;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish buildPartial() {
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish result = new com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish(this);
					int from_bitField0_ = bitField0_;
					int to_bitField0_ = 0;
					if (((from_bitField0_ & 0x00000001) != 0)) {
						to_bitField0_ |= 0x00000001;
					}
					result.static_ = static_;
					if (((from_bitField0_ & 0x00000002) != 0)) {
						to_bitField0_ |= 0x00000002;
					}
					result.payload_ = payload_;
					result.bitField0_ = to_bitField0_;
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
					if (other instanceof com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish) {
						return mergeFrom((com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish)other);
					} else {
						super.mergeFrom(other);
						return this;
					}
				}

				public Builder mergeFrom(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish other) {
					if (other == com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.getDefaultInstance()) return this;
					if (other.hasStatic()) {
						setStatic(other.getStatic());
					}
					if (other.hasPayload()) {
						setPayload(other.getPayload());
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
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish parsedMessage = null;
					try {
						parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
					} catch (com.google.protobuf.InvalidProtocolBufferException e) {
						parsedMessage = (com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish) e.getUnfinishedMessage();
						throw e.unwrapIOException();
					} finally {
						if (parsedMessage != null) {
							mergeFrom(parsedMessage);
						}
					}
					return this;
				}
				private int bitField0_;

				private com.google.protobuf.ByteString static_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes static = 1;</code>
				 * @return Whether the static field is set.
				 */
				@java.lang.Override
				public boolean hasStatic() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>bytes static = 1;</code>
				 * @return The static.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getStatic() {
					return static_;
				}
				/**
				 * <code>bytes static = 1;</code>
				 * @param value The static to set.
				 * @return This builder for chaining.
				 */
				public Builder setStatic(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000001;
					static_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes static = 1;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearStatic() {
					bitField0_ = (bitField0_ & ~0x00000001);
					static_ = getDefaultInstance().getStatic();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString payload_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes payload = 2;</code>
				 * @return Whether the payload field is set.
				 */
				@java.lang.Override
				public boolean hasPayload() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>bytes payload = 2;</code>
				 * @return The payload.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getPayload() {
					return payload_;
				}
				/**
				 * <code>bytes payload = 2;</code>
				 * @param value The payload to set.
				 * @return This builder for chaining.
				 */
				public Builder setPayload(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000002;
					payload_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes payload = 2;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearPayload() {
					bitField0_ = (bitField0_ & ~0x00000002);
					payload_ = getDefaultInstance().getPayload();
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


				// @@protoc_insertion_point(builder_scope:whatsapp.HandshakeMessage.ClientFinish)
			}

			// @@protoc_insertion_point(class_scope:whatsapp.HandshakeMessage.ClientFinish)
			private static final com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish DEFAULT_INSTANCE;
			static {
				DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish();
			}

			public static com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish getDefaultInstance() {
				return DEFAULT_INSTANCE;
			}

			private static final com.google.protobuf.Parser<ClientFinish>
					PARSER = new com.google.protobuf.AbstractParser<ClientFinish>() {
				@java.lang.Override
				public ClientFinish parsePartialFrom(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return new ClientFinish(input, extensionRegistry);
				}
			};

			public static com.google.protobuf.Parser<ClientFinish> parser() {
				return PARSER;
			}

			@java.lang.Override
			public com.google.protobuf.Parser<ClientFinish> getParserForType() {
				return PARSER;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish getDefaultInstanceForType() {
				return DEFAULT_INSTANCE;
			}

		}

		private int bitField0_;
		public static final int CLIENT_HELLO_FIELD_NUMBER = 2;
		private com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello clientHello_;
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
		 * @return Whether the clientHello field is set.
		 */
		@java.lang.Override
		public boolean hasClientHello() {
			return ((bitField0_ & 0x00000001) != 0);
		}
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
		 * @return The clientHello.
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello getClientHello() {
			return clientHello_ == null ? com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.getDefaultInstance() : clientHello_;
		}
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHelloOrBuilder getClientHelloOrBuilder() {
			return clientHello_ == null ? com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.getDefaultInstance() : clientHello_;
		}

		public static final int SERVER_HELLO_FIELD_NUMBER = 3;
		private com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello serverHello_;
		/**
		 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
		 * @return Whether the serverHello field is set.
		 */
		@java.lang.Override
		public boolean hasServerHello() {
			return ((bitField0_ & 0x00000002) != 0);
		}
		/**
		 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
		 * @return The serverHello.
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello getServerHello() {
			return serverHello_ == null ? com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.getDefaultInstance() : serverHello_;
		}
		/**
		 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHelloOrBuilder getServerHelloOrBuilder() {
			return serverHello_ == null ? com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.getDefaultInstance() : serverHello_;
		}

		public static final int CLIENT_FINISH_FIELD_NUMBER = 4;
		private com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish clientFinish_;
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
		 * @return Whether the clientFinish field is set.
		 */
		@java.lang.Override
		public boolean hasClientFinish() {
			return ((bitField0_ & 0x00000004) != 0);
		}
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
		 * @return The clientFinish.
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish getClientFinish() {
			return clientFinish_ == null ? com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.getDefaultInstance() : clientFinish_;
		}
		/**
		 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinishOrBuilder getClientFinishOrBuilder() {
			return clientFinish_ == null ? com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.getDefaultInstance() : clientFinish_;
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
			if (((bitField0_ & 0x00000001) != 0)) {
				output.writeMessage(2, getClientHello());
			}
			if (((bitField0_ & 0x00000002) != 0)) {
				output.writeMessage(3, getServerHello());
			}
			if (((bitField0_ & 0x00000004) != 0)) {
				output.writeMessage(4, getClientFinish());
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSize;
			if (size != -1) return size;

			size = 0;
			if (((bitField0_ & 0x00000001) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeMessageSize(2, getClientHello());
			}
			if (((bitField0_ & 0x00000002) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeMessageSize(3, getServerHello());
			}
			if (((bitField0_ & 0x00000004) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeMessageSize(4, getClientFinish());
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
			if (!(obj instanceof com.whatsapp.proto.WA4Protos.HandshakeMessage)) {
				return super.equals(obj);
			}
			com.whatsapp.proto.WA4Protos.HandshakeMessage other = (com.whatsapp.proto.WA4Protos.HandshakeMessage) obj;

			if (hasClientHello() != other.hasClientHello()) return false;
			if (hasClientHello()) {
				if (!getClientHello()
						.equals(other.getClientHello())) return false;
			}
			if (hasServerHello() != other.hasServerHello()) return false;
			if (hasServerHello()) {
				if (!getServerHello()
						.equals(other.getServerHello())) return false;
			}
			if (hasClientFinish() != other.hasClientFinish()) return false;
			if (hasClientFinish()) {
				if (!getClientFinish()
						.equals(other.getClientFinish())) return false;
			}
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
			if (hasClientHello()) {
				hash = (37 * hash) + CLIENT_HELLO_FIELD_NUMBER;
				hash = (53 * hash) + getClientHello().hashCode();
			}
			if (hasServerHello()) {
				hash = (37 * hash) + SERVER_HELLO_FIELD_NUMBER;
				hash = (53 * hash) + getServerHello().hashCode();
			}
			if (hasClientFinish()) {
				hash = (37 * hash) + CLIENT_FINISH_FIELD_NUMBER;
				hash = (53 * hash) + getClientFinish().hashCode();
			}
			hash = (29 * hash) + unknownFields.hashCode();
			memoizedHashCode = hash;
			return hash;
		}

		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(
				java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(
				java.nio.ByteBuffer data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(
				com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(
				com.google.protobuf.ByteString data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(
				byte[] data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(java.io.InputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseWithIOException(PARSER, input);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(
				java.io.InputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseWithIOException(PARSER, input, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseDelimitedFrom(java.io.InputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseDelimitedWithIOException(PARSER, input);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseDelimitedFrom(
				java.io.InputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(
				com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseWithIOException(PARSER, input);
		}
		public static com.whatsapp.proto.WA4Protos.HandshakeMessage parseFrom(
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
		public static Builder newBuilder(com.whatsapp.proto.WA4Protos.HandshakeMessage prototype) {
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
		 * Protobuf type {@code whatsapp.HandshakeMessage}
		 */
		public static final class Builder extends
				com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
				// @@protoc_insertion_point(builder_implements:whatsapp.HandshakeMessage)
				com.whatsapp.proto.WA4Protos.HandshakeMessageOrBuilder {
			public static final com.google.protobuf.Descriptors.Descriptor
			getDescriptor() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.HandshakeMessage.class, com.whatsapp.proto.WA4Protos.HandshakeMessage.Builder.class);
			}

			// Construct using com.whatsapp.proto.WA4Protos.HandshakeMessage.newBuilder()
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
					getClientHelloFieldBuilder();
					getServerHelloFieldBuilder();
					getClientFinishFieldBuilder();
				}
			}
			@java.lang.Override
			public Builder clear() {
				super.clear();
				if (clientHelloBuilder_ == null) {
					clientHello_ = null;
				} else {
					clientHelloBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000001);
				if (serverHelloBuilder_ == null) {
					serverHello_ = null;
				} else {
					serverHelloBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000002);
				if (clientFinishBuilder_ == null) {
					clientFinish_ = null;
				} else {
					clientFinishBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000004);
				return this;
			}

			@java.lang.Override
			public com.google.protobuf.Descriptors.Descriptor
			getDescriptorForType() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_HandshakeMessage_descriptor;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.HandshakeMessage getDefaultInstanceForType() {
				return com.whatsapp.proto.WA4Protos.HandshakeMessage.getDefaultInstance();
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.HandshakeMessage build() {
				com.whatsapp.proto.WA4Protos.HandshakeMessage result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.HandshakeMessage buildPartial() {
				com.whatsapp.proto.WA4Protos.HandshakeMessage result = new com.whatsapp.proto.WA4Protos.HandshakeMessage(this);
				int from_bitField0_ = bitField0_;
				int to_bitField0_ = 0;
				if (((from_bitField0_ & 0x00000001) != 0)) {
					if (clientHelloBuilder_ == null) {
						result.clientHello_ = clientHello_;
					} else {
						result.clientHello_ = clientHelloBuilder_.build();
					}
					to_bitField0_ |= 0x00000001;
				}
				if (((from_bitField0_ & 0x00000002) != 0)) {
					if (serverHelloBuilder_ == null) {
						result.serverHello_ = serverHello_;
					} else {
						result.serverHello_ = serverHelloBuilder_.build();
					}
					to_bitField0_ |= 0x00000002;
				}
				if (((from_bitField0_ & 0x00000004) != 0)) {
					if (clientFinishBuilder_ == null) {
						result.clientFinish_ = clientFinish_;
					} else {
						result.clientFinish_ = clientFinishBuilder_.build();
					}
					to_bitField0_ |= 0x00000004;
				}
				result.bitField0_ = to_bitField0_;
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
				if (other instanceof com.whatsapp.proto.WA4Protos.HandshakeMessage) {
					return mergeFrom((com.whatsapp.proto.WA4Protos.HandshakeMessage)other);
				} else {
					super.mergeFrom(other);
					return this;
				}
			}

			public Builder mergeFrom(com.whatsapp.proto.WA4Protos.HandshakeMessage other) {
				if (other == com.whatsapp.proto.WA4Protos.HandshakeMessage.getDefaultInstance()) return this;
				if (other.hasClientHello()) {
					mergeClientHello(other.getClientHello());
				}
				if (other.hasServerHello()) {
					mergeServerHello(other.getServerHello());
				}
				if (other.hasClientFinish()) {
					mergeClientFinish(other.getClientFinish());
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
				com.whatsapp.proto.WA4Protos.HandshakeMessage parsedMessage = null;
				try {
					parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
				} catch (com.google.protobuf.InvalidProtocolBufferException e) {
					parsedMessage = (com.whatsapp.proto.WA4Protos.HandshakeMessage) e.getUnfinishedMessage();
					throw e.unwrapIOException();
				} finally {
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
				}
				return this;
			}
			private int bitField0_;

			private com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello clientHello_;
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.Builder, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHelloOrBuilder> clientHelloBuilder_;
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
			 * @return Whether the clientHello field is set.
			 */
			public boolean hasClientHello() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
			 * @return The clientHello.
			 */
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello getClientHello() {
				if (clientHelloBuilder_ == null) {
					return clientHello_ == null ? com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.getDefaultInstance() : clientHello_;
				} else {
					return clientHelloBuilder_.getMessage();
				}
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
			 */
			public Builder setClientHello(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello value) {
				if (clientHelloBuilder_ == null) {
					if (value == null) {
						throw new NullPointerException();
					}
					clientHello_ = value;
					onChanged();
				} else {
					clientHelloBuilder_.setMessage(value);
				}
				bitField0_ |= 0x00000001;
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
			 */
			public Builder setClientHello(
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.Builder builderForValue) {
				if (clientHelloBuilder_ == null) {
					clientHello_ = builderForValue.build();
					onChanged();
				} else {
					clientHelloBuilder_.setMessage(builderForValue.build());
				}
				bitField0_ |= 0x00000001;
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
			 */
			public Builder mergeClientHello(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello value) {
				if (clientHelloBuilder_ == null) {
					if (((bitField0_ & 0x00000001) != 0) &&
							clientHello_ != null &&
							clientHello_ != com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.getDefaultInstance()) {
						clientHello_ =
								com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.newBuilder(clientHello_).mergeFrom(value).buildPartial();
					} else {
						clientHello_ = value;
					}
					onChanged();
				} else {
					clientHelloBuilder_.mergeFrom(value);
				}
				bitField0_ |= 0x00000001;
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
			 */
			public Builder clearClientHello() {
				if (clientHelloBuilder_ == null) {
					clientHello_ = null;
					onChanged();
				} else {
					clientHelloBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000001);
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
			 */
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.Builder getClientHelloBuilder() {
				bitField0_ |= 0x00000001;
				onChanged();
				return getClientHelloFieldBuilder().getBuilder();
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
			 */
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHelloOrBuilder getClientHelloOrBuilder() {
				if (clientHelloBuilder_ != null) {
					return clientHelloBuilder_.getMessageOrBuilder();
				} else {
					return clientHello_ == null ?
							com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.getDefaultInstance() : clientHello_;
				}
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientHello client_hello = 2;</code>
			 */
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.Builder, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHelloOrBuilder>
			getClientHelloFieldBuilder() {
				if (clientHelloBuilder_ == null) {
					clientHelloBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
							com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHello.Builder, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientHelloOrBuilder>(
							getClientHello(),
							getParentForChildren(),
							isClean());
					clientHello_ = null;
				}
				return clientHelloBuilder_;
			}

			private com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello serverHello_;
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello, com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.Builder, com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHelloOrBuilder> serverHelloBuilder_;
			/**
			 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
			 * @return Whether the serverHello field is set.
			 */
			public boolean hasServerHello() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
			 * @return The serverHello.
			 */
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello getServerHello() {
				if (serverHelloBuilder_ == null) {
					return serverHello_ == null ? com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.getDefaultInstance() : serverHello_;
				} else {
					return serverHelloBuilder_.getMessage();
				}
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
			 */
			public Builder setServerHello(com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello value) {
				if (serverHelloBuilder_ == null) {
					if (value == null) {
						throw new NullPointerException();
					}
					serverHello_ = value;
					onChanged();
				} else {
					serverHelloBuilder_.setMessage(value);
				}
				bitField0_ |= 0x00000002;
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
			 */
			public Builder setServerHello(
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.Builder builderForValue) {
				if (serverHelloBuilder_ == null) {
					serverHello_ = builderForValue.build();
					onChanged();
				} else {
					serverHelloBuilder_.setMessage(builderForValue.build());
				}
				bitField0_ |= 0x00000002;
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
			 */
			public Builder mergeServerHello(com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello value) {
				if (serverHelloBuilder_ == null) {
					if (((bitField0_ & 0x00000002) != 0) &&
							serverHello_ != null &&
							serverHello_ != com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.getDefaultInstance()) {
						serverHello_ =
								com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.newBuilder(serverHello_).mergeFrom(value).buildPartial();
					} else {
						serverHello_ = value;
					}
					onChanged();
				} else {
					serverHelloBuilder_.mergeFrom(value);
				}
				bitField0_ |= 0x00000002;
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
			 */
			public Builder clearServerHello() {
				if (serverHelloBuilder_ == null) {
					serverHello_ = null;
					onChanged();
				} else {
					serverHelloBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000002);
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
			 */
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.Builder getServerHelloBuilder() {
				bitField0_ |= 0x00000002;
				onChanged();
				return getServerHelloFieldBuilder().getBuilder();
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
			 */
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHelloOrBuilder getServerHelloOrBuilder() {
				if (serverHelloBuilder_ != null) {
					return serverHelloBuilder_.getMessageOrBuilder();
				} else {
					return serverHello_ == null ?
							com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.getDefaultInstance() : serverHello_;
				}
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ServerHello server_hello = 3;</code>
			 */
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello, com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.Builder, com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHelloOrBuilder>
			getServerHelloFieldBuilder() {
				if (serverHelloBuilder_ == null) {
					serverHelloBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
							com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello, com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHello.Builder, com.whatsapp.proto.WA4Protos.HandshakeMessage.ServerHelloOrBuilder>(
							getServerHello(),
							getParentForChildren(),
							isClean());
					serverHello_ = null;
				}
				return serverHelloBuilder_;
			}

			private com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish clientFinish_;
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.Builder, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinishOrBuilder> clientFinishBuilder_;
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
			 * @return Whether the clientFinish field is set.
			 */
			public boolean hasClientFinish() {
				return ((bitField0_ & 0x00000004) != 0);
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
			 * @return The clientFinish.
			 */
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish getClientFinish() {
				if (clientFinishBuilder_ == null) {
					return clientFinish_ == null ? com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.getDefaultInstance() : clientFinish_;
				} else {
					return clientFinishBuilder_.getMessage();
				}
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
			 */
			public Builder setClientFinish(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish value) {
				if (clientFinishBuilder_ == null) {
					if (value == null) {
						throw new NullPointerException();
					}
					clientFinish_ = value;
					onChanged();
				} else {
					clientFinishBuilder_.setMessage(value);
				}
				bitField0_ |= 0x00000004;
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
			 */
			public Builder setClientFinish(
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.Builder builderForValue) {
				if (clientFinishBuilder_ == null) {
					clientFinish_ = builderForValue.build();
					onChanged();
				} else {
					clientFinishBuilder_.setMessage(builderForValue.build());
				}
				bitField0_ |= 0x00000004;
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
			 */
			public Builder mergeClientFinish(com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish value) {
				if (clientFinishBuilder_ == null) {
					if (((bitField0_ & 0x00000004) != 0) &&
							clientFinish_ != null &&
							clientFinish_ != com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.getDefaultInstance()) {
						clientFinish_ =
								com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.newBuilder(clientFinish_).mergeFrom(value).buildPartial();
					} else {
						clientFinish_ = value;
					}
					onChanged();
				} else {
					clientFinishBuilder_.mergeFrom(value);
				}
				bitField0_ |= 0x00000004;
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
			 */
			public Builder clearClientFinish() {
				if (clientFinishBuilder_ == null) {
					clientFinish_ = null;
					onChanged();
				} else {
					clientFinishBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000004);
				return this;
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
			 */
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.Builder getClientFinishBuilder() {
				bitField0_ |= 0x00000004;
				onChanged();
				return getClientFinishFieldBuilder().getBuilder();
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
			 */
			public com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinishOrBuilder getClientFinishOrBuilder() {
				if (clientFinishBuilder_ != null) {
					return clientFinishBuilder_.getMessageOrBuilder();
				} else {
					return clientFinish_ == null ?
							com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.getDefaultInstance() : clientFinish_;
				}
			}
			/**
			 * <code>.whatsapp.HandshakeMessage.ClientFinish client_finish = 4;</code>
			 */
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.Builder, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinishOrBuilder>
			getClientFinishFieldBuilder() {
				if (clientFinishBuilder_ == null) {
					clientFinishBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
							com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinish.Builder, com.whatsapp.proto.WA4Protos.HandshakeMessage.ClientFinishOrBuilder>(
							getClientFinish(),
							getParentForChildren(),
							isClean());
					clientFinish_ = null;
				}
				return clientFinishBuilder_;
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


			// @@protoc_insertion_point(builder_scope:whatsapp.HandshakeMessage)
		}

		// @@protoc_insertion_point(class_scope:whatsapp.HandshakeMessage)
		private static final com.whatsapp.proto.WA4Protos.HandshakeMessage DEFAULT_INSTANCE;
		static {
			DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.HandshakeMessage();
		}

		public static com.whatsapp.proto.WA4Protos.HandshakeMessage getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		private static final com.google.protobuf.Parser<HandshakeMessage>
				PARSER = new com.google.protobuf.AbstractParser<HandshakeMessage>() {
			@java.lang.Override
			public HandshakeMessage parsePartialFrom(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return new HandshakeMessage(input, extensionRegistry);
			}
		};

		public static com.google.protobuf.Parser<HandshakeMessage> parser() {
			return PARSER;
		}

		@java.lang.Override
		public com.google.protobuf.Parser<HandshakeMessage> getParserForType() {
			return PARSER;
		}

		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.HandshakeMessage getDefaultInstanceForType() {
			return DEFAULT_INSTANCE;
		}

	}

	public interface NoiseCertificateOrBuilder extends
			// @@protoc_insertion_point(interface_extends:whatsapp.NoiseCertificate)
			com.google.protobuf.MessageOrBuilder {

		/**
		 * <code>bytes details = 1;</code>
		 * @return Whether the details field is set.
		 */
		boolean hasDetails();
		/**
		 * <code>bytes details = 1;</code>
		 * @return The details.
		 */
		com.google.protobuf.ByteString getDetails();

		/**
		 * <code>bytes signature = 2;</code>
		 * @return Whether the signature field is set.
		 */
		boolean hasSignature();
		/**
		 * <code>bytes signature = 2;</code>
		 * @return The signature.
		 */
		com.google.protobuf.ByteString getSignature();
	}
	/**
	 * Protobuf type {@code whatsapp.NoiseCertificate}
	 */
	public static final class NoiseCertificate extends
			com.google.protobuf.GeneratedMessageV3 implements
			// @@protoc_insertion_point(message_implements:whatsapp.NoiseCertificate)
			NoiseCertificateOrBuilder {
		private static final long serialVersionUID = 0L;
		// Use NoiseCertificate.newBuilder() to construct.
		private NoiseCertificate(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
			super(builder);
		}
		private NoiseCertificate() {
			details_ = com.google.protobuf.ByteString.EMPTY;
			signature_ = com.google.protobuf.ByteString.EMPTY;
		}

		@java.lang.Override
		@SuppressWarnings({"unused"})
		protected java.lang.Object newInstance(
				UnusedPrivateParameter unused) {
			return new NoiseCertificate();
		}

		@java.lang.Override
		public final com.google.protobuf.UnknownFieldSet
		getUnknownFields() {
			return this.unknownFields;
		}
		private NoiseCertificate(
				com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			this();
			if (extensionRegistry == null) {
				throw new java.lang.NullPointerException();
			}
			int mutable_bitField0_ = 0;
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
							bitField0_ |= 0x00000001;
							details_ = input.readBytes();
							break;
						}
						case 18: {
							bitField0_ |= 0x00000002;
							signature_ = input.readBytes();
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
			return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_descriptor;
		}

		@java.lang.Override
		protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
		internalGetFieldAccessorTable() {
			return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_fieldAccessorTable
					.ensureFieldAccessorsInitialized(
							com.whatsapp.proto.WA4Protos.NoiseCertificate.class, com.whatsapp.proto.WA4Protos.NoiseCertificate.Builder.class);
		}

		public interface DetailsOrBuilder extends
				// @@protoc_insertion_point(interface_extends:whatsapp.NoiseCertificate.Details)
				com.google.protobuf.MessageOrBuilder {

			/**
			 * <code>uint32 serial = 1;</code>
			 * @return Whether the serial field is set.
			 */
			boolean hasSerial();
			/**
			 * <code>uint32 serial = 1;</code>
			 * @return The serial.
			 */
			int getSerial();

			/**
			 * <code>string issuer = 2;</code>
			 * @return Whether the issuer field is set.
			 */
			boolean hasIssuer();
			/**
			 * <code>string issuer = 2;</code>
			 * @return The issuer.
			 */
			java.lang.String getIssuer();
			/**
			 * <code>string issuer = 2;</code>
			 * @return The bytes for issuer.
			 */
			com.google.protobuf.ByteString
			getIssuerBytes();

			/**
			 * <code>uint64 expires = 3;</code>
			 * @return Whether the expires field is set.
			 */
			boolean hasExpires();
			/**
			 * <code>uint64 expires = 3;</code>
			 * @return The expires.
			 */
			long getExpires();

			/**
			 * <code>string subject = 4;</code>
			 * @return Whether the subject field is set.
			 */
			boolean hasSubject();
			/**
			 * <code>string subject = 4;</code>
			 * @return The subject.
			 */
			java.lang.String getSubject();
			/**
			 * <code>string subject = 4;</code>
			 * @return The bytes for subject.
			 */
			com.google.protobuf.ByteString
			getSubjectBytes();

			/**
			 * <code>bytes key = 5;</code>
			 * @return Whether the key field is set.
			 */
			boolean hasKey();
			/**
			 * <code>bytes key = 5;</code>
			 * @return The key.
			 */
			com.google.protobuf.ByteString getKey();
		}
		/**
		 * Protobuf type {@code whatsapp.NoiseCertificate.Details}
		 */
		public static final class Details extends
				com.google.protobuf.GeneratedMessageV3 implements
				// @@protoc_insertion_point(message_implements:whatsapp.NoiseCertificate.Details)
				DetailsOrBuilder {
			private static final long serialVersionUID = 0L;
			// Use Details.newBuilder() to construct.
			private Details(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
				super(builder);
			}
			private Details() {
				issuer_ = "";
				subject_ = "";
				key_ = com.google.protobuf.ByteString.EMPTY;
			}

			@java.lang.Override
			@SuppressWarnings({"unused"})
			protected java.lang.Object newInstance(
					UnusedPrivateParameter unused) {
				return new Details();
			}

			@java.lang.Override
			public final com.google.protobuf.UnknownFieldSet
			getUnknownFields() {
				return this.unknownFields;
			}
			private Details(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				this();
				if (extensionRegistry == null) {
					throw new java.lang.NullPointerException();
				}
				int mutable_bitField0_ = 0;
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
							case 8: {
								bitField0_ |= 0x00000001;
								serial_ = input.readUInt32();
								break;
							}
							case 18: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000002;
								issuer_ = s;
								break;
							}
							case 24: {
								bitField0_ |= 0x00000004;
								expires_ = input.readUInt64();
								break;
							}
							case 34: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000008;
								subject_ = s;
								break;
							}
							case 42: {
								bitField0_ |= 0x00000010;
								key_ = input.readBytes();
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
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_Details_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_Details_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.NoiseCertificate.Details.class, com.whatsapp.proto.WA4Protos.NoiseCertificate.Details.Builder.class);
			}

			private int bitField0_;
			public static final int SERIAL_FIELD_NUMBER = 1;
			private int serial_;
			/**
			 * <code>uint32 serial = 1;</code>
			 * @return Whether the serial field is set.
			 */
			@java.lang.Override
			public boolean hasSerial() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>uint32 serial = 1;</code>
			 * @return The serial.
			 */
			@java.lang.Override
			public int getSerial() {
				return serial_;
			}

			public static final int ISSUER_FIELD_NUMBER = 2;
			private volatile java.lang.Object issuer_;
			/**
			 * <code>string issuer = 2;</code>
			 * @return Whether the issuer field is set.
			 */
			@java.lang.Override
			public boolean hasIssuer() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>string issuer = 2;</code>
			 * @return The issuer.
			 */
			@java.lang.Override
			public java.lang.String getIssuer() {
				java.lang.Object ref = issuer_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					issuer_ = s;
					return s;
				}
			}
			/**
			 * <code>string issuer = 2;</code>
			 * @return The bytes for issuer.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getIssuerBytes() {
				java.lang.Object ref = issuer_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					issuer_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int EXPIRES_FIELD_NUMBER = 3;
			private long expires_;
			/**
			 * <code>uint64 expires = 3;</code>
			 * @return Whether the expires field is set.
			 */
			@java.lang.Override
			public boolean hasExpires() {
				return ((bitField0_ & 0x00000004) != 0);
			}
			/**
			 * <code>uint64 expires = 3;</code>
			 * @return The expires.
			 */
			@java.lang.Override
			public long getExpires() {
				return expires_;
			}

			public static final int SUBJECT_FIELD_NUMBER = 4;
			private volatile java.lang.Object subject_;
			/**
			 * <code>string subject = 4;</code>
			 * @return Whether the subject field is set.
			 */
			@java.lang.Override
			public boolean hasSubject() {
				return ((bitField0_ & 0x00000008) != 0);
			}
			/**
			 * <code>string subject = 4;</code>
			 * @return The subject.
			 */
			@java.lang.Override
			public java.lang.String getSubject() {
				java.lang.Object ref = subject_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					subject_ = s;
					return s;
				}
			}
			/**
			 * <code>string subject = 4;</code>
			 * @return The bytes for subject.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getSubjectBytes() {
				java.lang.Object ref = subject_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					subject_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int KEY_FIELD_NUMBER = 5;
			private com.google.protobuf.ByteString key_;
			/**
			 * <code>bytes key = 5;</code>
			 * @return Whether the key field is set.
			 */
			@java.lang.Override
			public boolean hasKey() {
				return ((bitField0_ & 0x00000010) != 0);
			}
			/**
			 * <code>bytes key = 5;</code>
			 * @return The key.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getKey() {
				return key_;
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
				if (((bitField0_ & 0x00000001) != 0)) {
					output.writeUInt32(1, serial_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 2, issuer_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					output.writeUInt64(3, expires_);
				}
				if (((bitField0_ & 0x00000008) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 4, subject_);
				}
				if (((bitField0_ & 0x00000010) != 0)) {
					output.writeBytes(5, key_);
				}
				unknownFields.writeTo(output);
			}

			@java.lang.Override
			public int getSerializedSize() {
				int size = memoizedSize;
				if (size != -1) return size;

				size = 0;
				if (((bitField0_ & 0x00000001) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeUInt32Size(1, serial_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, issuer_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeUInt64Size(3, expires_);
				}
				if (((bitField0_ & 0x00000008) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, subject_);
				}
				if (((bitField0_ & 0x00000010) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(5, key_);
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
				if (!(obj instanceof com.whatsapp.proto.WA4Protos.NoiseCertificate.Details)) {
					return super.equals(obj);
				}
				com.whatsapp.proto.WA4Protos.NoiseCertificate.Details other = (com.whatsapp.proto.WA4Protos.NoiseCertificate.Details) obj;

				if (hasSerial() != other.hasSerial()) return false;
				if (hasSerial()) {
					if (getSerial()
							!= other.getSerial()) return false;
				}
				if (hasIssuer() != other.hasIssuer()) return false;
				if (hasIssuer()) {
					if (!getIssuer()
							.equals(other.getIssuer())) return false;
				}
				if (hasExpires() != other.hasExpires()) return false;
				if (hasExpires()) {
					if (getExpires()
							!= other.getExpires()) return false;
				}
				if (hasSubject() != other.hasSubject()) return false;
				if (hasSubject()) {
					if (!getSubject()
							.equals(other.getSubject())) return false;
				}
				if (hasKey() != other.hasKey()) return false;
				if (hasKey()) {
					if (!getKey()
							.equals(other.getKey())) return false;
				}
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
				if (hasSerial()) {
					hash = (37 * hash) + SERIAL_FIELD_NUMBER;
					hash = (53 * hash) + getSerial();
				}
				if (hasIssuer()) {
					hash = (37 * hash) + ISSUER_FIELD_NUMBER;
					hash = (53 * hash) + getIssuer().hashCode();
				}
				if (hasExpires()) {
					hash = (37 * hash) + EXPIRES_FIELD_NUMBER;
					hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
							getExpires());
				}
				if (hasSubject()) {
					hash = (37 * hash) + SUBJECT_FIELD_NUMBER;
					hash = (53 * hash) + getSubject().hashCode();
				}
				if (hasKey()) {
					hash = (37 * hash) + KEY_FIELD_NUMBER;
					hash = (53 * hash) + getKey().hashCode();
				}
				hash = (29 * hash) + unknownFields.hashCode();
				memoizedHashCode = hash;
				return hash;
			}

			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(
					java.nio.ByteBuffer data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(
					java.nio.ByteBuffer data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(
					com.google.protobuf.ByteString data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(
					com.google.protobuf.ByteString data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(byte[] data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(
					byte[] data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseDelimitedFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseDelimitedFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(
					com.google.protobuf.CodedInputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parseFrom(
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
			public static Builder newBuilder(com.whatsapp.proto.WA4Protos.NoiseCertificate.Details prototype) {
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
			 * Protobuf type {@code whatsapp.NoiseCertificate.Details}
			 */
			public static final class Builder extends
					com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
					// @@protoc_insertion_point(builder_implements:whatsapp.NoiseCertificate.Details)
					com.whatsapp.proto.WA4Protos.NoiseCertificate.DetailsOrBuilder {
				public static final com.google.protobuf.Descriptors.Descriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_Details_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_Details_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.NoiseCertificate.Details.class, com.whatsapp.proto.WA4Protos.NoiseCertificate.Details.Builder.class);
				}

				// Construct using com.whatsapp.proto.WA4Protos.NoiseCertificate.Details.newBuilder()
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
					serial_ = 0;
					bitField0_ = (bitField0_ & ~0x00000001);
					issuer_ = "";
					bitField0_ = (bitField0_ & ~0x00000002);
					expires_ = 0L;
					bitField0_ = (bitField0_ & ~0x00000004);
					subject_ = "";
					bitField0_ = (bitField0_ & ~0x00000008);
					key_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000010);
					return this;
				}

				@java.lang.Override
				public com.google.protobuf.Descriptors.Descriptor
				getDescriptorForType() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_Details_descriptor;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.NoiseCertificate.Details getDefaultInstanceForType() {
					return com.whatsapp.proto.WA4Protos.NoiseCertificate.Details.getDefaultInstance();
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.NoiseCertificate.Details build() {
					com.whatsapp.proto.WA4Protos.NoiseCertificate.Details result = buildPartial();
					if (!result.isInitialized()) {
						throw newUninitializedMessageException(result);
					}
					return result;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.NoiseCertificate.Details buildPartial() {
					com.whatsapp.proto.WA4Protos.NoiseCertificate.Details result = new com.whatsapp.proto.WA4Protos.NoiseCertificate.Details(this);
					int from_bitField0_ = bitField0_;
					int to_bitField0_ = 0;
					if (((from_bitField0_ & 0x00000001) != 0)) {
						result.serial_ = serial_;
						to_bitField0_ |= 0x00000001;
					}
					if (((from_bitField0_ & 0x00000002) != 0)) {
						to_bitField0_ |= 0x00000002;
					}
					result.issuer_ = issuer_;
					if (((from_bitField0_ & 0x00000004) != 0)) {
						result.expires_ = expires_;
						to_bitField0_ |= 0x00000004;
					}
					if (((from_bitField0_ & 0x00000008) != 0)) {
						to_bitField0_ |= 0x00000008;
					}
					result.subject_ = subject_;
					if (((from_bitField0_ & 0x00000010) != 0)) {
						to_bitField0_ |= 0x00000010;
					}
					result.key_ = key_;
					result.bitField0_ = to_bitField0_;
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
					if (other instanceof com.whatsapp.proto.WA4Protos.NoiseCertificate.Details) {
						return mergeFrom((com.whatsapp.proto.WA4Protos.NoiseCertificate.Details)other);
					} else {
						super.mergeFrom(other);
						return this;
					}
				}

				public Builder mergeFrom(com.whatsapp.proto.WA4Protos.NoiseCertificate.Details other) {
					if (other == com.whatsapp.proto.WA4Protos.NoiseCertificate.Details.getDefaultInstance()) return this;
					if (other.hasSerial()) {
						setSerial(other.getSerial());
					}
					if (other.hasIssuer()) {
						bitField0_ |= 0x00000002;
						issuer_ = other.issuer_;
						onChanged();
					}
					if (other.hasExpires()) {
						setExpires(other.getExpires());
					}
					if (other.hasSubject()) {
						bitField0_ |= 0x00000008;
						subject_ = other.subject_;
						onChanged();
					}
					if (other.hasKey()) {
						setKey(other.getKey());
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
					com.whatsapp.proto.WA4Protos.NoiseCertificate.Details parsedMessage = null;
					try {
						parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
					} catch (com.google.protobuf.InvalidProtocolBufferException e) {
						parsedMessage = (com.whatsapp.proto.WA4Protos.NoiseCertificate.Details) e.getUnfinishedMessage();
						throw e.unwrapIOException();
					} finally {
						if (parsedMessage != null) {
							mergeFrom(parsedMessage);
						}
					}
					return this;
				}
				private int bitField0_;

				private int serial_ ;
				/**
				 * <code>uint32 serial = 1;</code>
				 * @return Whether the serial field is set.
				 */
				@java.lang.Override
				public boolean hasSerial() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>uint32 serial = 1;</code>
				 * @return The serial.
				 */
				@java.lang.Override
				public int getSerial() {
					return serial_;
				}
				/**
				 * <code>uint32 serial = 1;</code>
				 * @param value The serial to set.
				 * @return This builder for chaining.
				 */
				public Builder setSerial(int value) {
					bitField0_ |= 0x00000001;
					serial_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>uint32 serial = 1;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearSerial() {
					bitField0_ = (bitField0_ & ~0x00000001);
					serial_ = 0;
					onChanged();
					return this;
				}

				private java.lang.Object issuer_ = "";
				/**
				 * <code>string issuer = 2;</code>
				 * @return Whether the issuer field is set.
				 */
				public boolean hasIssuer() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>string issuer = 2;</code>
				 * @return The issuer.
				 */
				public java.lang.String getIssuer() {
					java.lang.Object ref = issuer_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						issuer_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string issuer = 2;</code>
				 * @return The bytes for issuer.
				 */
				public com.google.protobuf.ByteString
				getIssuerBytes() {
					java.lang.Object ref = issuer_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						issuer_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string issuer = 2;</code>
				 * @param value The issuer to set.
				 * @return This builder for chaining.
				 */
				public Builder setIssuer(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000002;
					issuer_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string issuer = 2;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearIssuer() {
					bitField0_ = (bitField0_ & ~0x00000002);
					issuer_ = getDefaultInstance().getIssuer();
					onChanged();
					return this;
				}
				/**
				 * <code>string issuer = 2;</code>
				 * @param value The bytes for issuer to set.
				 * @return This builder for chaining.
				 */
				public Builder setIssuerBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000002;
					issuer_ = value;
					onChanged();
					return this;
				}

				private long expires_ ;
				/**
				 * <code>uint64 expires = 3;</code>
				 * @return Whether the expires field is set.
				 */
				@java.lang.Override
				public boolean hasExpires() {
					return ((bitField0_ & 0x00000004) != 0);
				}
				/**
				 * <code>uint64 expires = 3;</code>
				 * @return The expires.
				 */
				@java.lang.Override
				public long getExpires() {
					return expires_;
				}
				/**
				 * <code>uint64 expires = 3;</code>
				 * @param value The expires to set.
				 * @return This builder for chaining.
				 */
				public Builder setExpires(long value) {
					bitField0_ |= 0x00000004;
					expires_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>uint64 expires = 3;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearExpires() {
					bitField0_ = (bitField0_ & ~0x00000004);
					expires_ = 0L;
					onChanged();
					return this;
				}

				private java.lang.Object subject_ = "";
				/**
				 * <code>string subject = 4;</code>
				 * @return Whether the subject field is set.
				 */
				public boolean hasSubject() {
					return ((bitField0_ & 0x00000008) != 0);
				}
				/**
				 * <code>string subject = 4;</code>
				 * @return The subject.
				 */
				public java.lang.String getSubject() {
					java.lang.Object ref = subject_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						subject_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string subject = 4;</code>
				 * @return The bytes for subject.
				 */
				public com.google.protobuf.ByteString
				getSubjectBytes() {
					java.lang.Object ref = subject_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						subject_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string subject = 4;</code>
				 * @param value The subject to set.
				 * @return This builder for chaining.
				 */
				public Builder setSubject(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000008;
					subject_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string subject = 4;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearSubject() {
					bitField0_ = (bitField0_ & ~0x00000008);
					subject_ = getDefaultInstance().getSubject();
					onChanged();
					return this;
				}
				/**
				 * <code>string subject = 4;</code>
				 * @param value The bytes for subject to set.
				 * @return This builder for chaining.
				 */
				public Builder setSubjectBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000008;
					subject_ = value;
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString key_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes key = 5;</code>
				 * @return Whether the key field is set.
				 */
				@java.lang.Override
				public boolean hasKey() {
					return ((bitField0_ & 0x00000010) != 0);
				}
				/**
				 * <code>bytes key = 5;</code>
				 * @return The key.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getKey() {
					return key_;
				}
				/**
				 * <code>bytes key = 5;</code>
				 * @param value The key to set.
				 * @return This builder for chaining.
				 */
				public Builder setKey(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000010;
					key_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes key = 5;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearKey() {
					bitField0_ = (bitField0_ & ~0x00000010);
					key_ = getDefaultInstance().getKey();
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


				// @@protoc_insertion_point(builder_scope:whatsapp.NoiseCertificate.Details)
			}

			// @@protoc_insertion_point(class_scope:whatsapp.NoiseCertificate.Details)
			private static final com.whatsapp.proto.WA4Protos.NoiseCertificate.Details DEFAULT_INSTANCE;
			static {
				DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.NoiseCertificate.Details();
			}

			public static com.whatsapp.proto.WA4Protos.NoiseCertificate.Details getDefaultInstance() {
				return DEFAULT_INSTANCE;
			}

			private static final com.google.protobuf.Parser<Details>
					PARSER = new com.google.protobuf.AbstractParser<Details>() {
				@java.lang.Override
				public Details parsePartialFrom(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return new Details(input, extensionRegistry);
				}
			};

			public static com.google.protobuf.Parser<Details> parser() {
				return PARSER;
			}

			@java.lang.Override
			public com.google.protobuf.Parser<Details> getParserForType() {
				return PARSER;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.NoiseCertificate.Details getDefaultInstanceForType() {
				return DEFAULT_INSTANCE;
			}

		}

		private int bitField0_;
		public static final int DETAILS_FIELD_NUMBER = 1;
		private com.google.protobuf.ByteString details_;
		/**
		 * <code>bytes details = 1;</code>
		 * @return Whether the details field is set.
		 */
		@java.lang.Override
		public boolean hasDetails() {
			return ((bitField0_ & 0x00000001) != 0);
		}
		/**
		 * <code>bytes details = 1;</code>
		 * @return The details.
		 */
		@java.lang.Override
		public com.google.protobuf.ByteString getDetails() {
			return details_;
		}

		public static final int SIGNATURE_FIELD_NUMBER = 2;
		private com.google.protobuf.ByteString signature_;
		/**
		 * <code>bytes signature = 2;</code>
		 * @return Whether the signature field is set.
		 */
		@java.lang.Override
		public boolean hasSignature() {
			return ((bitField0_ & 0x00000002) != 0);
		}
		/**
		 * <code>bytes signature = 2;</code>
		 * @return The signature.
		 */
		@java.lang.Override
		public com.google.protobuf.ByteString getSignature() {
			return signature_;
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
			if (((bitField0_ & 0x00000001) != 0)) {
				output.writeBytes(1, details_);
			}
			if (((bitField0_ & 0x00000002) != 0)) {
				output.writeBytes(2, signature_);
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSize;
			if (size != -1) return size;

			size = 0;
			if (((bitField0_ & 0x00000001) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeBytesSize(1, details_);
			}
			if (((bitField0_ & 0x00000002) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeBytesSize(2, signature_);
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
			if (!(obj instanceof com.whatsapp.proto.WA4Protos.NoiseCertificate)) {
				return super.equals(obj);
			}
			com.whatsapp.proto.WA4Protos.NoiseCertificate other = (com.whatsapp.proto.WA4Protos.NoiseCertificate) obj;

			if (hasDetails() != other.hasDetails()) return false;
			if (hasDetails()) {
				if (!getDetails()
						.equals(other.getDetails())) return false;
			}
			if (hasSignature() != other.hasSignature()) return false;
			if (hasSignature()) {
				if (!getSignature()
						.equals(other.getSignature())) return false;
			}
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
			if (hasDetails()) {
				hash = (37 * hash) + DETAILS_FIELD_NUMBER;
				hash = (53 * hash) + getDetails().hashCode();
			}
			if (hasSignature()) {
				hash = (37 * hash) + SIGNATURE_FIELD_NUMBER;
				hash = (53 * hash) + getSignature().hashCode();
			}
			hash = (29 * hash) + unknownFields.hashCode();
			memoizedHashCode = hash;
			return hash;
		}

		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(
				java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(
				java.nio.ByteBuffer data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(
				com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(
				com.google.protobuf.ByteString data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(
				byte[] data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(java.io.InputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseWithIOException(PARSER, input);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(
				java.io.InputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseWithIOException(PARSER, input, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseDelimitedFrom(java.io.InputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseDelimitedWithIOException(PARSER, input);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseDelimitedFrom(
				java.io.InputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(
				com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseWithIOException(PARSER, input);
		}
		public static com.whatsapp.proto.WA4Protos.NoiseCertificate parseFrom(
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
		public static Builder newBuilder(com.whatsapp.proto.WA4Protos.NoiseCertificate prototype) {
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
		 * Protobuf type {@code whatsapp.NoiseCertificate}
		 */
		public static final class Builder extends
				com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
				// @@protoc_insertion_point(builder_implements:whatsapp.NoiseCertificate)
				com.whatsapp.proto.WA4Protos.NoiseCertificateOrBuilder {
			public static final com.google.protobuf.Descriptors.Descriptor
			getDescriptor() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.NoiseCertificate.class, com.whatsapp.proto.WA4Protos.NoiseCertificate.Builder.class);
			}

			// Construct using com.whatsapp.proto.WA4Protos.NoiseCertificate.newBuilder()
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
				details_ = com.google.protobuf.ByteString.EMPTY;
				bitField0_ = (bitField0_ & ~0x00000001);
				signature_ = com.google.protobuf.ByteString.EMPTY;
				bitField0_ = (bitField0_ & ~0x00000002);
				return this;
			}

			@java.lang.Override
			public com.google.protobuf.Descriptors.Descriptor
			getDescriptorForType() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_NoiseCertificate_descriptor;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.NoiseCertificate getDefaultInstanceForType() {
				return com.whatsapp.proto.WA4Protos.NoiseCertificate.getDefaultInstance();
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.NoiseCertificate build() {
				com.whatsapp.proto.WA4Protos.NoiseCertificate result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.NoiseCertificate buildPartial() {
				com.whatsapp.proto.WA4Protos.NoiseCertificate result = new com.whatsapp.proto.WA4Protos.NoiseCertificate(this);
				int from_bitField0_ = bitField0_;
				int to_bitField0_ = 0;
				if (((from_bitField0_ & 0x00000001) != 0)) {
					to_bitField0_ |= 0x00000001;
				}
				result.details_ = details_;
				if (((from_bitField0_ & 0x00000002) != 0)) {
					to_bitField0_ |= 0x00000002;
				}
				result.signature_ = signature_;
				result.bitField0_ = to_bitField0_;
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
				if (other instanceof com.whatsapp.proto.WA4Protos.NoiseCertificate) {
					return mergeFrom((com.whatsapp.proto.WA4Protos.NoiseCertificate)other);
				} else {
					super.mergeFrom(other);
					return this;
				}
			}

			public Builder mergeFrom(com.whatsapp.proto.WA4Protos.NoiseCertificate other) {
				if (other == com.whatsapp.proto.WA4Protos.NoiseCertificate.getDefaultInstance()) return this;
				if (other.hasDetails()) {
					setDetails(other.getDetails());
				}
				if (other.hasSignature()) {
					setSignature(other.getSignature());
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
				com.whatsapp.proto.WA4Protos.NoiseCertificate parsedMessage = null;
				try {
					parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
				} catch (com.google.protobuf.InvalidProtocolBufferException e) {
					parsedMessage = (com.whatsapp.proto.WA4Protos.NoiseCertificate) e.getUnfinishedMessage();
					throw e.unwrapIOException();
				} finally {
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
				}
				return this;
			}
			private int bitField0_;

			private com.google.protobuf.ByteString details_ = com.google.protobuf.ByteString.EMPTY;
			/**
			 * <code>bytes details = 1;</code>
			 * @return Whether the details field is set.
			 */
			@java.lang.Override
			public boolean hasDetails() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>bytes details = 1;</code>
			 * @return The details.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getDetails() {
				return details_;
			}
			/**
			 * <code>bytes details = 1;</code>
			 * @param value The details to set.
			 * @return This builder for chaining.
			 */
			public Builder setDetails(com.google.protobuf.ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000001;
				details_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>bytes details = 1;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearDetails() {
				bitField0_ = (bitField0_ & ~0x00000001);
				details_ = getDefaultInstance().getDetails();
				onChanged();
				return this;
			}

			private com.google.protobuf.ByteString signature_ = com.google.protobuf.ByteString.EMPTY;
			/**
			 * <code>bytes signature = 2;</code>
			 * @return Whether the signature field is set.
			 */
			@java.lang.Override
			public boolean hasSignature() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>bytes signature = 2;</code>
			 * @return The signature.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getSignature() {
				return signature_;
			}
			/**
			 * <code>bytes signature = 2;</code>
			 * @param value The signature to set.
			 * @return This builder for chaining.
			 */
			public Builder setSignature(com.google.protobuf.ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000002;
				signature_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>bytes signature = 2;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearSignature() {
				bitField0_ = (bitField0_ & ~0x00000002);
				signature_ = getDefaultInstance().getSignature();
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


			// @@protoc_insertion_point(builder_scope:whatsapp.NoiseCertificate)
		}

		// @@protoc_insertion_point(class_scope:whatsapp.NoiseCertificate)
		private static final com.whatsapp.proto.WA4Protos.NoiseCertificate DEFAULT_INSTANCE;
		static {
			DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.NoiseCertificate();
		}

		public static com.whatsapp.proto.WA4Protos.NoiseCertificate getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		private static final com.google.protobuf.Parser<NoiseCertificate>
				PARSER = new com.google.protobuf.AbstractParser<NoiseCertificate>() {
			@java.lang.Override
			public NoiseCertificate parsePartialFrom(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return new NoiseCertificate(input, extensionRegistry);
			}
		};

		public static com.google.protobuf.Parser<NoiseCertificate> parser() {
			return PARSER;
		}

		@java.lang.Override
		public com.google.protobuf.Parser<NoiseCertificate> getParserForType() {
			return PARSER;
		}

		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.NoiseCertificate getDefaultInstanceForType() {
			return DEFAULT_INSTANCE;
		}

	}

	public interface ClientPayloadOrBuilder extends
			// @@protoc_insertion_point(interface_extends:whatsapp.ClientPayload)
			com.google.protobuf.MessageOrBuilder {

		/**
		 * <code>uint64 username = 1;</code>
		 * @return Whether the username field is set.
		 */
		boolean hasUsername();
		/**
		 * <code>uint64 username = 1;</code>
		 * @return The username.
		 */
		long getUsername();

		/**
		 * <code>bool passive = 3;</code>
		 * @return Whether the passive field is set.
		 */
		boolean hasPassive();
		/**
		 * <code>bool passive = 3;</code>
		 * @return The passive.
		 */
		boolean getPassive();

		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @return A list containing the clientFeatures.
		 */
		java.util.List<com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature> getClientFeaturesList();
		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @return The count of clientFeatures.
		 */
		int getClientFeaturesCount();
		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @param index The index of the element to return.
		 * @return The clientFeatures at the given index.
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature getClientFeatures(int index);
		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @return A list containing the enum numeric values on the wire for clientFeatures.
		 */
		java.util.List<java.lang.Integer>
		getClientFeaturesValueList();
		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @param index The index of the value to return.
		 * @return The enum numeric value on the wire of clientFeatures at the given index.
		 */
		int getClientFeaturesValue(int index);

		/**
		 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
		 * @return Whether the userAgent field is set.
		 */
		boolean hasUserAgent();
		/**
		 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
		 * @return The userAgent.
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent getUserAgent();
		/**
		 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.UserAgentOrBuilder getUserAgentOrBuilder();

		/**
		 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
		 * @return Whether the webInfo field is set.
		 */
		boolean hasWebInfo();
		/**
		 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
		 * @return The webInfo.
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo getWebInfo();
		/**
		 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.WebInfoOrBuilder getWebInfoOrBuilder();

		/**
		 * <code>string push_name = 7;</code>
		 * @return Whether the pushName field is set.
		 */
		boolean hasPushName();
		/**
		 * <code>string push_name = 7;</code>
		 * @return The pushName.
		 */
		java.lang.String getPushName();
		/**
		 * <code>string push_name = 7;</code>
		 * @return The bytes for pushName.
		 */
		com.google.protobuf.ByteString
		getPushNameBytes();

		/**
		 * <code>sfixed32 session_id = 9;</code>
		 * @return Whether the sessionId field is set.
		 */
		boolean hasSessionId();
		/**
		 * <code>sfixed32 session_id = 9;</code>
		 * @return The sessionId.
		 */
		int getSessionId();

		/**
		 * <code>bool short_connect = 10;</code>
		 * @return Whether the shortConnect field is set.
		 */
		boolean hasShortConnect();
		/**
		 * <code>bool short_connect = 10;</code>
		 * @return The shortConnect.
		 */
		boolean getShortConnect();

		/**
		 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
		 * @return Whether the iosAppExtension field is set.
		 */
		boolean hasIosAppExtension();
		/**
		 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
		 * @return The enum numeric value on the wire for iosAppExtension.
		 */
		int getIosAppExtensionValue();
		/**
		 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
		 * @return The iosAppExtension.
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension getIosAppExtension();

		/**
		 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
		 * @return Whether the connectType field is set.
		 */
		boolean hasConnectType();
		/**
		 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
		 * @return The enum numeric value on the wire for connectType.
		 */
		int getConnectTypeValue();
		/**
		 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
		 * @return The connectType.
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType getConnectType();

		/**
		 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
		 * @return Whether the connectReason field is set.
		 */
		boolean hasConnectReason();
		/**
		 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
		 * @return The enum numeric value on the wire for connectReason.
		 */
		int getConnectReasonValue();
		/**
		 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
		 * @return The connectReason.
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason getConnectReason();

		/**
		 * <code>repeated sfixed32 shards = 14;</code>
		 * @return A list containing the shards.
		 */
		java.util.List<java.lang.Integer> getShardsList();
		/**
		 * <code>repeated sfixed32 shards = 14;</code>
		 * @return The count of shards.
		 */
		int getShardsCount();
		/**
		 * <code>repeated sfixed32 shards = 14;</code>
		 * @param index The index of the element to return.
		 * @return The shards at the given index.
		 */
		int getShards(int index);

		/**
		 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
		 * @return Whether the dnsSource field is set.
		 */
		boolean hasDnsSource();
		/**
		 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
		 * @return The dnsSource.
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource getDnsSource();
		/**
		 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.DNSSourceOrBuilder getDnsSourceOrBuilder();

		/**
		 * <code>uint32 connect_attempt_count = 16;</code>
		 * @return Whether the connectAttemptCount field is set.
		 */
		boolean hasConnectAttemptCount();
		/**
		 * <code>uint32 connect_attempt_count = 16;</code>
		 * @return The connectAttemptCount.
		 */
		int getConnectAttemptCount();

		/**
		 * <code>uint32 agent = 17;</code>
		 * @return Whether the agent field is set.
		 */
		boolean hasAgent();
		/**
		 * <code>uint32 agent = 17;</code>
		 * @return The agent.
		 */
		int getAgent();

		/**
		 * <code>uint32 device = 18;</code>
		 * @return Whether the device field is set.
		 */
		boolean hasDevice();
		/**
		 * <code>uint32 device = 18;</code>
		 * @return The device.
		 */
		int getDevice();

		/**
		 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
		 * @return Whether the regData field is set.
		 */
		boolean hasRegData();
		/**
		 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
		 * @return The regData.
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData getRegData();
		/**
		 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
		 */
		com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegDataOrBuilder getRegDataOrBuilder();
	}
	/**
	 * Protobuf type {@code whatsapp.ClientPayload}
	 */
	public static final class ClientPayload extends
			com.google.protobuf.GeneratedMessageV3 implements
			// @@protoc_insertion_point(message_implements:whatsapp.ClientPayload)
			ClientPayloadOrBuilder {
		private static final long serialVersionUID = 0L;
		// Use ClientPayload.newBuilder() to construct.
		private ClientPayload(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
			super(builder);
		}
		private ClientPayload() {
			clientFeatures_ = java.util.Collections.emptyList();
			pushName_ = "";
			iosAppExtension_ = 0;
			connectType_ = 0;
			connectReason_ = 0;
			shards_ = emptyIntList();
		}

		@java.lang.Override
		@SuppressWarnings({"unused"})
		protected java.lang.Object newInstance(
				UnusedPrivateParameter unused) {
			return new ClientPayload();
		}

		@java.lang.Override
		public final com.google.protobuf.UnknownFieldSet
		getUnknownFields() {
			return this.unknownFields;
		}
		private ClientPayload(
				com.google.protobuf.CodedInputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			this();
			if (extensionRegistry == null) {
				throw new java.lang.NullPointerException();
			}
			int mutable_bitField0_ = 0;
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
						case 8: {
							bitField0_ |= 0x00000001;
							username_ = input.readUInt64();
							break;
						}
						case 24: {
							bitField0_ |= 0x00000002;
							passive_ = input.readBool();
							break;
						}
						case 32: {
							int rawValue = input.readEnum();
							if (!((mutable_bitField0_ & 0x00000004) != 0)) {
								clientFeatures_ = new java.util.ArrayList<java.lang.Integer>();
								mutable_bitField0_ |= 0x00000004;
							}
							clientFeatures_.add(rawValue);
							break;
						}
						case 34: {
							int length = input.readRawVarint32();
							int oldLimit = input.pushLimit(length);
							while(input.getBytesUntilLimit() > 0) {
								int rawValue = input.readEnum();
								if (!((mutable_bitField0_ & 0x00000004) != 0)) {
									clientFeatures_ = new java.util.ArrayList<java.lang.Integer>();
									mutable_bitField0_ |= 0x00000004;
								}
								clientFeatures_.add(rawValue);
							}
							input.popLimit(oldLimit);
							break;
						}
						case 42: {
							com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Builder subBuilder = null;
							if (((bitField0_ & 0x00000004) != 0)) {
								subBuilder = userAgent_.toBuilder();
							}
							userAgent_ = input.readMessage(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.parser(), extensionRegistry);
							if (subBuilder != null) {
								subBuilder.mergeFrom(userAgent_);
								userAgent_ = subBuilder.buildPartial();
							}
							bitField0_ |= 0x00000004;
							break;
						}
						case 50: {
							com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.Builder subBuilder = null;
							if (((bitField0_ & 0x00000008) != 0)) {
								subBuilder = webInfo_.toBuilder();
							}
							webInfo_ = input.readMessage(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.parser(), extensionRegistry);
							if (subBuilder != null) {
								subBuilder.mergeFrom(webInfo_);
								webInfo_ = subBuilder.buildPartial();
							}
							bitField0_ |= 0x00000008;
							break;
						}
						case 58: {
							java.lang.String s = input.readStringRequireUtf8();
							bitField0_ |= 0x00000010;
							pushName_ = s;
							break;
						}
						case 77: {
							bitField0_ |= 0x00000020;
							sessionId_ = input.readSFixed32();
							break;
						}
						case 80: {
							bitField0_ |= 0x00000040;
							shortConnect_ = input.readBool();
							break;
						}
						case 96: {
							int rawValue = input.readEnum();
							bitField0_ |= 0x00000100;
							connectType_ = rawValue;
							break;
						}
						case 104: {
							int rawValue = input.readEnum();
							bitField0_ |= 0x00000200;
							connectReason_ = rawValue;
							break;
						}
						case 117: {
							if (!((mutable_bitField0_ & 0x00000800) != 0)) {
								shards_ = newIntList();
								mutable_bitField0_ |= 0x00000800;
							}
							shards_.addInt(input.readSFixed32());
							break;
						}
						case 114: {
							int length = input.readRawVarint32();
							int limit = input.pushLimit(length);
							if (!((mutable_bitField0_ & 0x00000800) != 0) && input.getBytesUntilLimit() > 0) {
								shards_ = newIntList();
								mutable_bitField0_ |= 0x00000800;
							}
							while (input.getBytesUntilLimit() > 0) {
								shards_.addInt(input.readSFixed32());
							}
							input.popLimit(limit);
							break;
						}
						case 122: {
							com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.Builder subBuilder = null;
							if (((bitField0_ & 0x00000400) != 0)) {
								subBuilder = dnsSource_.toBuilder();
							}
							dnsSource_ = input.readMessage(com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.parser(), extensionRegistry);
							if (subBuilder != null) {
								subBuilder.mergeFrom(dnsSource_);
								dnsSource_ = subBuilder.buildPartial();
							}
							bitField0_ |= 0x00000400;
							break;
						}
						case 128: {
							bitField0_ |= 0x00000800;
							connectAttemptCount_ = input.readUInt32();
							break;
						}
						case 136: {
							bitField0_ |= 0x00001000;
							agent_ = input.readUInt32();
							break;
						}
						case 144: {
							bitField0_ |= 0x00002000;
							device_ = input.readUInt32();
							break;
						}
						case 154: {
							com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.Builder subBuilder = null;
							if (((bitField0_ & 0x00004000) != 0)) {
								subBuilder = regData_.toBuilder();
							}
							regData_ = input.readMessage(com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.parser(), extensionRegistry);
							if (subBuilder != null) {
								subBuilder.mergeFrom(regData_);
								regData_ = subBuilder.buildPartial();
							}
							bitField0_ |= 0x00004000;
							break;
						}
						case 240: {
							int rawValue = input.readEnum();
							bitField0_ |= 0x00000080;
							iosAppExtension_ = rawValue;
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
				if (((mutable_bitField0_ & 0x00000004) != 0)) {
					clientFeatures_ = java.util.Collections.unmodifiableList(clientFeatures_);
				}
				if (((mutable_bitField0_ & 0x00000800) != 0)) {
					shards_.makeImmutable(); // C
				}
				this.unknownFields = unknownFields.build();
				makeExtensionsImmutable();
			}
		}
		public static final com.google.protobuf.Descriptors.Descriptor
		getDescriptor() {
			return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_descriptor;
		}

		@java.lang.Override
		protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
		internalGetFieldAccessorTable() {
			return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_fieldAccessorTable
					.ensureFieldAccessorsInitialized(
							com.whatsapp.proto.WA4Protos.ClientPayload.class, com.whatsapp.proto.WA4Protos.ClientPayload.Builder.class);
		}

		/**
		 * Protobuf enum {@code whatsapp.ClientPayload.ClientFeature}
		 */
		public enum ClientFeature
				implements com.google.protobuf.ProtocolMessageEnum {
			/**
			 * <code>NONE = 0;</code>
			 */
			NONE(0),
			UNRECOGNIZED(-1),
			;

			/**
			 * <code>NONE = 0;</code>
			 */
			public static final int NONE_VALUE = 0;


			public final int getNumber() {
				if (this == UNRECOGNIZED) {
					throw new java.lang.IllegalArgumentException(
							"Can't get the number of an unknown enum value.");
				}
				return value;
			}

			/**
			 * @param value The numeric wire value of the corresponding enum entry.
			 * @return The enum associated with the given numeric wire value.
			 * @deprecated Use {@link #forNumber(int)} instead.
			 */
			@java.lang.Deprecated
			public static ClientFeature valueOf(int value) {
				return forNumber(value);
			}

			/**
			 * @param value The numeric wire value of the corresponding enum entry.
			 * @return The enum associated with the given numeric wire value.
			 */
			public static ClientFeature forNumber(int value) {
				switch (value) {
					case 0: return NONE;
					default: return null;
				}
			}

			public static com.google.protobuf.Internal.EnumLiteMap<ClientFeature>
			internalGetValueMap() {
				return internalValueMap;
			}
			private static final com.google.protobuf.Internal.EnumLiteMap<
					ClientFeature> internalValueMap =
					new com.google.protobuf.Internal.EnumLiteMap<ClientFeature>() {
						public ClientFeature findValueByNumber(int number) {
							return ClientFeature.forNumber(number);
						}
					};

			public final com.google.protobuf.Descriptors.EnumValueDescriptor
			getValueDescriptor() {
				if (this == UNRECOGNIZED) {
					throw new java.lang.IllegalStateException(
							"Can't get the descriptor of an unrecognized enum value.");
				}
				return getDescriptor().getValues().get(ordinal());
			}
			public final com.google.protobuf.Descriptors.EnumDescriptor
			getDescriptorForType() {
				return getDescriptor();
			}
			public static final com.google.protobuf.Descriptors.EnumDescriptor
			getDescriptor() {
				return com.whatsapp.proto.WA4Protos.ClientPayload.getDescriptor().getEnumTypes().get(0);
			}

			private static final ClientFeature[] VALUES = values();

			public static ClientFeature valueOf(
					com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
				if (desc.getType() != getDescriptor()) {
					throw new java.lang.IllegalArgumentException(
							"EnumValueDescriptor is not for this type.");
				}
				if (desc.getIndex() == -1) {
					return UNRECOGNIZED;
				}
				return VALUES[desc.getIndex()];
			}

			private final int value;

			private ClientFeature(int value) {
				this.value = value;
			}

			// @@protoc_insertion_point(enum_scope:whatsapp.ClientPayload.ClientFeature)
		}

		/**
		 * Protobuf enum {@code whatsapp.ClientPayload.IOSAppExtension}
		 */
		public enum IOSAppExtension
				implements com.google.protobuf.ProtocolMessageEnum {
			/**
			 * <code>SHARE_EXTENSION = 0;</code>
			 */
			SHARE_EXTENSION(0),
			/**
			 * <code>SERVICE_EXTENSION = 1;</code>
			 */
			SERVICE_EXTENSION(1),
			/**
			 * <code>INTENTS_EXTENSION = 2;</code>
			 */
			INTENTS_EXTENSION(2),
			UNRECOGNIZED(-1),
			;

			/**
			 * <code>SHARE_EXTENSION = 0;</code>
			 */
			public static final int SHARE_EXTENSION_VALUE = 0;
			/**
			 * <code>SERVICE_EXTENSION = 1;</code>
			 */
			public static final int SERVICE_EXTENSION_VALUE = 1;
			/**
			 * <code>INTENTS_EXTENSION = 2;</code>
			 */
			public static final int INTENTS_EXTENSION_VALUE = 2;


			public final int getNumber() {
				if (this == UNRECOGNIZED) {
					throw new java.lang.IllegalArgumentException(
							"Can't get the number of an unknown enum value.");
				}
				return value;
			}

			/**
			 * @param value The numeric wire value of the corresponding enum entry.
			 * @return The enum associated with the given numeric wire value.
			 * @deprecated Use {@link #forNumber(int)} instead.
			 */
			@java.lang.Deprecated
			public static IOSAppExtension valueOf(int value) {
				return forNumber(value);
			}

			/**
			 * @param value The numeric wire value of the corresponding enum entry.
			 * @return The enum associated with the given numeric wire value.
			 */
			public static IOSAppExtension forNumber(int value) {
				switch (value) {
					case 0: return SHARE_EXTENSION;
					case 1: return SERVICE_EXTENSION;
					case 2: return INTENTS_EXTENSION;
					default: return null;
				}
			}

			public static com.google.protobuf.Internal.EnumLiteMap<IOSAppExtension>
			internalGetValueMap() {
				return internalValueMap;
			}
			private static final com.google.protobuf.Internal.EnumLiteMap<
					IOSAppExtension> internalValueMap =
					new com.google.protobuf.Internal.EnumLiteMap<IOSAppExtension>() {
						public IOSAppExtension findValueByNumber(int number) {
							return IOSAppExtension.forNumber(number);
						}
					};

			public final com.google.protobuf.Descriptors.EnumValueDescriptor
			getValueDescriptor() {
				if (this == UNRECOGNIZED) {
					throw new java.lang.IllegalStateException(
							"Can't get the descriptor of an unrecognized enum value.");
				}
				return getDescriptor().getValues().get(ordinal());
			}
			public final com.google.protobuf.Descriptors.EnumDescriptor
			getDescriptorForType() {
				return getDescriptor();
			}
			public static final com.google.protobuf.Descriptors.EnumDescriptor
			getDescriptor() {
				return com.whatsapp.proto.WA4Protos.ClientPayload.getDescriptor().getEnumTypes().get(1);
			}

			private static final IOSAppExtension[] VALUES = values();

			public static IOSAppExtension valueOf(
					com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
				if (desc.getType() != getDescriptor()) {
					throw new java.lang.IllegalArgumentException(
							"EnumValueDescriptor is not for this type.");
				}
				if (desc.getIndex() == -1) {
					return UNRECOGNIZED;
				}
				return VALUES[desc.getIndex()];
			}

			private final int value;

			private IOSAppExtension(int value) {
				this.value = value;
			}

			// @@protoc_insertion_point(enum_scope:whatsapp.ClientPayload.IOSAppExtension)
		}

		/**
		 * Protobuf enum {@code whatsapp.ClientPayload.ConnectReason}
		 */
		public enum ConnectReason
				implements com.google.protobuf.ProtocolMessageEnum {
			/**
			 * <code>PUSH = 0;</code>
			 */
			PUSH(0),
			/**
			 * <code>USER_ACTIVATED = 1;</code>
			 */
			USER_ACTIVATED(1),
			/**
			 * <code>SCHEDULED = 2;</code>
			 */
			SCHEDULED(2),
			/**
			 * <code>ERROR_RECONNECT = 3;</code>
			 */
			ERROR_RECONNECT(3),
			/**
			 * <code>NETWORK_SWITCH = 4;</code>
			 */
			NETWORK_SWITCH(4),
			/**
			 * <code>PING_RECONNECT = 5;</code>
			 */
			PING_RECONNECT(5),
			UNRECOGNIZED(-1),
			;

			/**
			 * <code>PUSH = 0;</code>
			 */
			public static final int PUSH_VALUE = 0;
			/**
			 * <code>USER_ACTIVATED = 1;</code>
			 */
			public static final int USER_ACTIVATED_VALUE = 1;
			/**
			 * <code>SCHEDULED = 2;</code>
			 */
			public static final int SCHEDULED_VALUE = 2;
			/**
			 * <code>ERROR_RECONNECT = 3;</code>
			 */
			public static final int ERROR_RECONNECT_VALUE = 3;
			/**
			 * <code>NETWORK_SWITCH = 4;</code>
			 */
			public static final int NETWORK_SWITCH_VALUE = 4;
			/**
			 * <code>PING_RECONNECT = 5;</code>
			 */
			public static final int PING_RECONNECT_VALUE = 5;


			public final int getNumber() {
				if (this == UNRECOGNIZED) {
					throw new java.lang.IllegalArgumentException(
							"Can't get the number of an unknown enum value.");
				}
				return value;
			}

			/**
			 * @param value The numeric wire value of the corresponding enum entry.
			 * @return The enum associated with the given numeric wire value.
			 * @deprecated Use {@link #forNumber(int)} instead.
			 */
			@java.lang.Deprecated
			public static ConnectReason valueOf(int value) {
				return forNumber(value);
			}

			/**
			 * @param value The numeric wire value of the corresponding enum entry.
			 * @return The enum associated with the given numeric wire value.
			 */
			public static ConnectReason forNumber(int value) {
				switch (value) {
					case 0: return PUSH;
					case 1: return USER_ACTIVATED;
					case 2: return SCHEDULED;
					case 3: return ERROR_RECONNECT;
					case 4: return NETWORK_SWITCH;
					case 5: return PING_RECONNECT;
					default: return null;
				}
			}

			public static com.google.protobuf.Internal.EnumLiteMap<ConnectReason>
			internalGetValueMap() {
				return internalValueMap;
			}
			private static final com.google.protobuf.Internal.EnumLiteMap<
					ConnectReason> internalValueMap =
					new com.google.protobuf.Internal.EnumLiteMap<ConnectReason>() {
						public ConnectReason findValueByNumber(int number) {
							return ConnectReason.forNumber(number);
						}
					};

			public final com.google.protobuf.Descriptors.EnumValueDescriptor
			getValueDescriptor() {
				if (this == UNRECOGNIZED) {
					throw new java.lang.IllegalStateException(
							"Can't get the descriptor of an unrecognized enum value.");
				}
				return getDescriptor().getValues().get(ordinal());
			}
			public final com.google.protobuf.Descriptors.EnumDescriptor
			getDescriptorForType() {
				return getDescriptor();
			}
			public static final com.google.protobuf.Descriptors.EnumDescriptor
			getDescriptor() {
				return com.whatsapp.proto.WA4Protos.ClientPayload.getDescriptor().getEnumTypes().get(2);
			}

			private static final ConnectReason[] VALUES = values();

			public static ConnectReason valueOf(
					com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
				if (desc.getType() != getDescriptor()) {
					throw new java.lang.IllegalArgumentException(
							"EnumValueDescriptor is not for this type.");
				}
				if (desc.getIndex() == -1) {
					return UNRECOGNIZED;
				}
				return VALUES[desc.getIndex()];
			}

			private final int value;

			private ConnectReason(int value) {
				this.value = value;
			}

			// @@protoc_insertion_point(enum_scope:whatsapp.ClientPayload.ConnectReason)
		}

		/**
		 * Protobuf enum {@code whatsapp.ClientPayload.ConnectType}
		 */
		public enum ConnectType
				implements com.google.protobuf.ProtocolMessageEnum {
			/**
			 * <code>CELLULAR_UNKNOWN = 0;</code>
			 */
			CELLULAR_UNKNOWN(0),
			/**
			 * <code>WIFI_UNKNOWN = 1;</code>
			 */
			WIFI_UNKNOWN(1),
			/**
			 * <code>CELLULAR_EDGE = 100;</code>
			 */
			CELLULAR_EDGE(100),
			/**
			 * <code>CELLULAR_IDEN = 101;</code>
			 */
			CELLULAR_IDEN(101),
			/**
			 * <code>CELLULAR_UMTS = 102;</code>
			 */
			CELLULAR_UMTS(102),
			/**
			 * <code>CELLULAR_EVDO = 103;</code>
			 */
			CELLULAR_EVDO(103),
			/**
			 * <code>CELLULAR_GPRS = 104;</code>
			 */
			CELLULAR_GPRS(104),
			/**
			 * <code>CELLULAR_HSDPA = 105;</code>
			 */
			CELLULAR_HSDPA(105),
			/**
			 * <code>CELLULAR_HSUPA = 106;</code>
			 */
			CELLULAR_HSUPA(106),
			/**
			 * <code>CELLULAR_HSPA = 107;</code>
			 */
			CELLULAR_HSPA(107),
			/**
			 * <code>CELLULAR_CDMA = 108;</code>
			 */
			CELLULAR_CDMA(108),
			/**
			 * <code>CELLULAR_1XRTT = 109;</code>
			 */
			CELLULAR_1XRTT(109),
			/**
			 * <code>CELLULAR_EHRPD = 110;</code>
			 */
			CELLULAR_EHRPD(110),
			/**
			 * <code>CELLULAR_LTE = 111;</code>
			 */
			CELLULAR_LTE(111),
			/**
			 * <code>CELLULAR_HSPAP = 112;</code>
			 */
			CELLULAR_HSPAP(112),
			UNRECOGNIZED(-1),
			;

			/**
			 * <code>CELLULAR_UNKNOWN = 0;</code>
			 */
			public static final int CELLULAR_UNKNOWN_VALUE = 0;
			/**
			 * <code>WIFI_UNKNOWN = 1;</code>
			 */
			public static final int WIFI_UNKNOWN_VALUE = 1;
			/**
			 * <code>CELLULAR_EDGE = 100;</code>
			 */
			public static final int CELLULAR_EDGE_VALUE = 100;
			/**
			 * <code>CELLULAR_IDEN = 101;</code>
			 */
			public static final int CELLULAR_IDEN_VALUE = 101;
			/**
			 * <code>CELLULAR_UMTS = 102;</code>
			 */
			public static final int CELLULAR_UMTS_VALUE = 102;
			/**
			 * <code>CELLULAR_EVDO = 103;</code>
			 */
			public static final int CELLULAR_EVDO_VALUE = 103;
			/**
			 * <code>CELLULAR_GPRS = 104;</code>
			 */
			public static final int CELLULAR_GPRS_VALUE = 104;
			/**
			 * <code>CELLULAR_HSDPA = 105;</code>
			 */
			public static final int CELLULAR_HSDPA_VALUE = 105;
			/**
			 * <code>CELLULAR_HSUPA = 106;</code>
			 */
			public static final int CELLULAR_HSUPA_VALUE = 106;
			/**
			 * <code>CELLULAR_HSPA = 107;</code>
			 */
			public static final int CELLULAR_HSPA_VALUE = 107;
			/**
			 * <code>CELLULAR_CDMA = 108;</code>
			 */
			public static final int CELLULAR_CDMA_VALUE = 108;
			/**
			 * <code>CELLULAR_1XRTT = 109;</code>
			 */
			public static final int CELLULAR_1XRTT_VALUE = 109;
			/**
			 * <code>CELLULAR_EHRPD = 110;</code>
			 */
			public static final int CELLULAR_EHRPD_VALUE = 110;
			/**
			 * <code>CELLULAR_LTE = 111;</code>
			 */
			public static final int CELLULAR_LTE_VALUE = 111;
			/**
			 * <code>CELLULAR_HSPAP = 112;</code>
			 */
			public static final int CELLULAR_HSPAP_VALUE = 112;


			public final int getNumber() {
				if (this == UNRECOGNIZED) {
					throw new java.lang.IllegalArgumentException(
							"Can't get the number of an unknown enum value.");
				}
				return value;
			}

			/**
			 * @param value The numeric wire value of the corresponding enum entry.
			 * @return The enum associated with the given numeric wire value.
			 * @deprecated Use {@link #forNumber(int)} instead.
			 */
			@java.lang.Deprecated
			public static ConnectType valueOf(int value) {
				return forNumber(value);
			}

			/**
			 * @param value The numeric wire value of the corresponding enum entry.
			 * @return The enum associated with the given numeric wire value.
			 */
			public static ConnectType forNumber(int value) {
				switch (value) {
					case 0: return CELLULAR_UNKNOWN;
					case 1: return WIFI_UNKNOWN;
					case 100: return CELLULAR_EDGE;
					case 101: return CELLULAR_IDEN;
					case 102: return CELLULAR_UMTS;
					case 103: return CELLULAR_EVDO;
					case 104: return CELLULAR_GPRS;
					case 105: return CELLULAR_HSDPA;
					case 106: return CELLULAR_HSUPA;
					case 107: return CELLULAR_HSPA;
					case 108: return CELLULAR_CDMA;
					case 109: return CELLULAR_1XRTT;
					case 110: return CELLULAR_EHRPD;
					case 111: return CELLULAR_LTE;
					case 112: return CELLULAR_HSPAP;
					default: return null;
				}
			}

			public static com.google.protobuf.Internal.EnumLiteMap<ConnectType>
			internalGetValueMap() {
				return internalValueMap;
			}
			private static final com.google.protobuf.Internal.EnumLiteMap<
					ConnectType> internalValueMap =
					new com.google.protobuf.Internal.EnumLiteMap<ConnectType>() {
						public ConnectType findValueByNumber(int number) {
							return ConnectType.forNumber(number);
						}
					};

			public final com.google.protobuf.Descriptors.EnumValueDescriptor
			getValueDescriptor() {
				if (this == UNRECOGNIZED) {
					throw new java.lang.IllegalStateException(
							"Can't get the descriptor of an unrecognized enum value.");
				}
				return getDescriptor().getValues().get(ordinal());
			}
			public final com.google.protobuf.Descriptors.EnumDescriptor
			getDescriptorForType() {
				return getDescriptor();
			}
			public static final com.google.protobuf.Descriptors.EnumDescriptor
			getDescriptor() {
				return com.whatsapp.proto.WA4Protos.ClientPayload.getDescriptor().getEnumTypes().get(3);
			}

			private static final ConnectType[] VALUES = values();

			public static ConnectType valueOf(
					com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
				if (desc.getType() != getDescriptor()) {
					throw new java.lang.IllegalArgumentException(
							"EnumValueDescriptor is not for this type.");
				}
				if (desc.getIndex() == -1) {
					return UNRECOGNIZED;
				}
				return VALUES[desc.getIndex()];
			}

			private final int value;

			private ConnectType(int value) {
				this.value = value;
			}

			// @@protoc_insertion_point(enum_scope:whatsapp.ClientPayload.ConnectType)
		}

		public interface UserAgentOrBuilder extends
				// @@protoc_insertion_point(interface_extends:whatsapp.ClientPayload.UserAgent)
				com.google.protobuf.MessageOrBuilder {

			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
			 * @return Whether the platform field is set.
			 */
			boolean hasPlatform();
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
			 * @return The enum numeric value on the wire for platform.
			 */
			int getPlatformValue();
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
			 * @return The platform.
			 */
			com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform getPlatform();

			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
			 * @return Whether the appVersion field is set.
			 */
			boolean hasAppVersion();
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
			 * @return The appVersion.
			 */
			com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion getAppVersion();
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
			 */
			com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersionOrBuilder getAppVersionOrBuilder();

			/**
			 * <code>string mcc = 3;</code>
			 * @return Whether the mcc field is set.
			 */
			boolean hasMcc();
			/**
			 * <code>string mcc = 3;</code>
			 * @return The mcc.
			 */
			java.lang.String getMcc();
			/**
			 * <code>string mcc = 3;</code>
			 * @return The bytes for mcc.
			 */
			com.google.protobuf.ByteString
			getMccBytes();

			/**
			 * <code>string mnc = 4;</code>
			 * @return Whether the mnc field is set.
			 */
			boolean hasMnc();
			/**
			 * <code>string mnc = 4;</code>
			 * @return The mnc.
			 */
			java.lang.String getMnc();
			/**
			 * <code>string mnc = 4;</code>
			 * @return The bytes for mnc.
			 */
			com.google.protobuf.ByteString
			getMncBytes();

			/**
			 * <code>string os_version = 5;</code>
			 * @return Whether the osVersion field is set.
			 */
			boolean hasOsVersion();
			/**
			 * <code>string os_version = 5;</code>
			 * @return The osVersion.
			 */
			java.lang.String getOsVersion();
			/**
			 * <code>string os_version = 5;</code>
			 * @return The bytes for osVersion.
			 */
			com.google.protobuf.ByteString
			getOsVersionBytes();

			/**
			 * <code>string manufacturer = 6;</code>
			 * @return Whether the manufacturer field is set.
			 */
			boolean hasManufacturer();
			/**
			 * <code>string manufacturer = 6;</code>
			 * @return The manufacturer.
			 */
			java.lang.String getManufacturer();
			/**
			 * <code>string manufacturer = 6;</code>
			 * @return The bytes for manufacturer.
			 */
			com.google.protobuf.ByteString
			getManufacturerBytes();

			/**
			 * <code>string device = 7;</code>
			 * @return Whether the device field is set.
			 */
			boolean hasDevice();
			/**
			 * <code>string device = 7;</code>
			 * @return The device.
			 */
			java.lang.String getDevice();
			/**
			 * <code>string device = 7;</code>
			 * @return The bytes for device.
			 */
			com.google.protobuf.ByteString
			getDeviceBytes();

			/**
			 * <code>string os_build_number = 8;</code>
			 * @return Whether the osBuildNumber field is set.
			 */
			boolean hasOsBuildNumber();
			/**
			 * <code>string os_build_number = 8;</code>
			 * @return The osBuildNumber.
			 */
			java.lang.String getOsBuildNumber();
			/**
			 * <code>string os_build_number = 8;</code>
			 * @return The bytes for osBuildNumber.
			 */
			com.google.protobuf.ByteString
			getOsBuildNumberBytes();

			/**
			 * <code>string phone_id = 9;</code>
			 * @return Whether the phoneId field is set.
			 */
			boolean hasPhoneId();
			/**
			 * <code>string phone_id = 9;</code>
			 * @return The phoneId.
			 */
			java.lang.String getPhoneId();
			/**
			 * <code>string phone_id = 9;</code>
			 * @return The bytes for phoneId.
			 */
			com.google.protobuf.ByteString
			getPhoneIdBytes();

			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
			 * @return Whether the releaseChannel field is set.
			 */
			boolean hasReleaseChannel();
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
			 * @return The enum numeric value on the wire for releaseChannel.
			 */
			int getReleaseChannelValue();
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
			 * @return The releaseChannel.
			 */
			com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel getReleaseChannel();

			/**
			 * <code>string locale_language_iso_639_1 = 11;</code>
			 * @return Whether the localeLanguageIso6391 field is set.
			 */
			boolean hasLocaleLanguageIso6391();
			/**
			 * <code>string locale_language_iso_639_1 = 11;</code>
			 * @return The localeLanguageIso6391.
			 */
			java.lang.String getLocaleLanguageIso6391();
			/**
			 * <code>string locale_language_iso_639_1 = 11;</code>
			 * @return The bytes for localeLanguageIso6391.
			 */
			com.google.protobuf.ByteString
			getLocaleLanguageIso6391Bytes();

			/**
			 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
			 * @return Whether the localCountryIso31661Alpha2 field is set.
			 */
			boolean hasLocalCountryIso31661Alpha2();
			/**
			 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
			 * @return The localCountryIso31661Alpha2.
			 */
			java.lang.String getLocalCountryIso31661Alpha2();
			/**
			 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
			 * @return The bytes for localCountryIso31661Alpha2.
			 */
			com.google.protobuf.ByteString
			getLocalCountryIso31661Alpha2Bytes();

			/**
			 * <code>string device_board = 13;</code>
			 * @return Whether the deviceBoard field is set.
			 */
			boolean hasDeviceBoard();
			/**
			 * <code>string device_board = 13;</code>
			 * @return The deviceBoard.
			 */
			java.lang.String getDeviceBoard();
			/**
			 * <code>string device_board = 13;</code>
			 * @return The bytes for deviceBoard.
			 */
			com.google.protobuf.ByteString
			getDeviceBoardBytes();
		}
		/**
		 * Protobuf type {@code whatsapp.ClientPayload.UserAgent}
		 */
		public static final class UserAgent extends
				com.google.protobuf.GeneratedMessageV3 implements
				// @@protoc_insertion_point(message_implements:whatsapp.ClientPayload.UserAgent)
				UserAgentOrBuilder {
			private static final long serialVersionUID = 0L;
			// Use UserAgent.newBuilder() to construct.
			private UserAgent(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
				super(builder);
			}
			private UserAgent() {
				platform_ = 0;
				mcc_ = "";
				mnc_ = "";
				osVersion_ = "";
				manufacturer_ = "";
				device_ = "";
				osBuildNumber_ = "";
				phoneId_ = "";
				releaseChannel_ = 0;
				localeLanguageIso6391_ = "";
				localCountryIso31661Alpha2_ = "";
				deviceBoard_ = "";
			}

			@java.lang.Override
			@SuppressWarnings({"unused"})
			protected java.lang.Object newInstance(
					UnusedPrivateParameter unused) {
				return new UserAgent();
			}

			@java.lang.Override
			public final com.google.protobuf.UnknownFieldSet
			getUnknownFields() {
				return this.unknownFields;
			}
			private UserAgent(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				this();
				if (extensionRegistry == null) {
					throw new java.lang.NullPointerException();
				}
				int mutable_bitField0_ = 0;
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
							case 8: {
								int rawValue = input.readEnum();
								bitField0_ |= 0x00000001;
								platform_ = rawValue;
								break;
							}
							case 18: {
								com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.Builder subBuilder = null;
								if (((bitField0_ & 0x00000002) != 0)) {
									subBuilder = appVersion_.toBuilder();
								}
								appVersion_ = input.readMessage(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.parser(), extensionRegistry);
								if (subBuilder != null) {
									subBuilder.mergeFrom(appVersion_);
									appVersion_ = subBuilder.buildPartial();
								}
								bitField0_ |= 0x00000002;
								break;
							}
							case 26: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000004;
								mcc_ = s;
								break;
							}
							case 34: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000008;
								mnc_ = s;
								break;
							}
							case 42: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000010;
								osVersion_ = s;
								break;
							}
							case 50: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000020;
								manufacturer_ = s;
								break;
							}
							case 58: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000040;
								device_ = s;
								break;
							}
							case 66: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000080;
								osBuildNumber_ = s;
								break;
							}
							case 74: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000100;
								phoneId_ = s;
								break;
							}
							case 80: {
								int rawValue = input.readEnum();
								bitField0_ |= 0x00000200;
								releaseChannel_ = rawValue;
								break;
							}
							case 90: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000400;
								localeLanguageIso6391_ = s;
								break;
							}
							case 98: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000800;
								localCountryIso31661Alpha2_ = s;
								break;
							}
							case 106: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00001000;
								deviceBoard_ = s;
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
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.class, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Builder.class);
			}

			/**
			 * Protobuf enum {@code whatsapp.ClientPayload.UserAgent.Platform}
			 */
			public enum Platform
					implements com.google.protobuf.ProtocolMessageEnum {
				/**
				 * <code>ANDROID = 0;</code>
				 */
				ANDROID(0),
				/**
				 * <code>IOS = 1;</code>
				 */
				IOS(1),
				/**
				 * <code>WINDOWS_PHONE = 2;</code>
				 */
				WINDOWS_PHONE(2),
				/**
				 * <code>BLACKBERRY = 3;</code>
				 */
				BLACKBERRY(3),
				/**
				 * <code>BLACKBERRYX = 4;</code>
				 */
				BLACKBERRYX(4),
				/**
				 * <code>S40 = 5;</code>
				 */
				S40(5),
				/**
				 * <code>S60 = 6;</code>
				 */
				S60(6),
				/**
				 * <code>PYTHON_CLIENT = 7;</code>
				 */
				PYTHON_CLIENT(7),
				/**
				 * <code>TIZEN = 8;</code>
				 */
				TIZEN(8),
				/**
				 * <code>ENTERPRISE = 9;</code>
				 */
				ENTERPRISE(9),
				/**
				 * <code>SMB_ANDROID = 10;</code>
				 */
				SMB_ANDROID(10),
				/**
				 * <code>KAIOS = 11;</code>
				 */
				KAIOS(11),
				/**
				 * <code>SMB_IOS = 12;</code>
				 */
				SMB_IOS(12),
				/**
				 * <code>WINDOWS = 13;</code>
				 */
				WINDOWS(13),
				/**
				 * <code>WEB = 14;</code>
				 */
				WEB(14),
				UNRECOGNIZED(-1),
				;

				/**
				 * <code>ANDROID = 0;</code>
				 */
				public static final int ANDROID_VALUE = 0;
				/**
				 * <code>IOS = 1;</code>
				 */
				public static final int IOS_VALUE = 1;
				/**
				 * <code>WINDOWS_PHONE = 2;</code>
				 */
				public static final int WINDOWS_PHONE_VALUE = 2;
				/**
				 * <code>BLACKBERRY = 3;</code>
				 */
				public static final int BLACKBERRY_VALUE = 3;
				/**
				 * <code>BLACKBERRYX = 4;</code>
				 */
				public static final int BLACKBERRYX_VALUE = 4;
				/**
				 * <code>S40 = 5;</code>
				 */
				public static final int S40_VALUE = 5;
				/**
				 * <code>S60 = 6;</code>
				 */
				public static final int S60_VALUE = 6;
				/**
				 * <code>PYTHON_CLIENT = 7;</code>
				 */
				public static final int PYTHON_CLIENT_VALUE = 7;
				/**
				 * <code>TIZEN = 8;</code>
				 */
				public static final int TIZEN_VALUE = 8;
				/**
				 * <code>ENTERPRISE = 9;</code>
				 */
				public static final int ENTERPRISE_VALUE = 9;
				/**
				 * <code>SMB_ANDROID = 10;</code>
				 */
				public static final int SMB_ANDROID_VALUE = 10;
				/**
				 * <code>KAIOS = 11;</code>
				 */
				public static final int KAIOS_VALUE = 11;
				/**
				 * <code>SMB_IOS = 12;</code>
				 */
				public static final int SMB_IOS_VALUE = 12;
				/**
				 * <code>WINDOWS = 13;</code>
				 */
				public static final int WINDOWS_VALUE = 13;
				/**
				 * <code>WEB = 14;</code>
				 */
				public static final int WEB_VALUE = 14;


				public final int getNumber() {
					if (this == UNRECOGNIZED) {
						throw new java.lang.IllegalArgumentException(
								"Can't get the number of an unknown enum value.");
					}
					return value;
				}

				/**
				 * @param value The numeric wire value of the corresponding enum entry.
				 * @return The enum associated with the given numeric wire value.
				 * @deprecated Use {@link #forNumber(int)} instead.
				 */
				@java.lang.Deprecated
				public static Platform valueOf(int value) {
					return forNumber(value);
				}

				/**
				 * @param value The numeric wire value of the corresponding enum entry.
				 * @return The enum associated with the given numeric wire value.
				 */
				public static Platform forNumber(int value) {
					switch (value) {
						case 0: return ANDROID;
						case 1: return IOS;
						case 2: return WINDOWS_PHONE;
						case 3: return BLACKBERRY;
						case 4: return BLACKBERRYX;
						case 5: return S40;
						case 6: return S60;
						case 7: return PYTHON_CLIENT;
						case 8: return TIZEN;
						case 9: return ENTERPRISE;
						case 10: return SMB_ANDROID;
						case 11: return KAIOS;
						case 12: return SMB_IOS;
						case 13: return WINDOWS;
						case 14: return WEB;
						default: return null;
					}
				}

				public static com.google.protobuf.Internal.EnumLiteMap<Platform>
				internalGetValueMap() {
					return internalValueMap;
				}
				private static final com.google.protobuf.Internal.EnumLiteMap<
						Platform> internalValueMap =
						new com.google.protobuf.Internal.EnumLiteMap<Platform>() {
							public Platform findValueByNumber(int number) {
								return Platform.forNumber(number);
							}
						};

				public final com.google.protobuf.Descriptors.EnumValueDescriptor
				getValueDescriptor() {
					if (this == UNRECOGNIZED) {
						throw new java.lang.IllegalStateException(
								"Can't get the descriptor of an unrecognized enum value.");
					}
					return getDescriptor().getValues().get(ordinal());
				}
				public final com.google.protobuf.Descriptors.EnumDescriptor
				getDescriptorForType() {
					return getDescriptor();
				}
				public static final com.google.protobuf.Descriptors.EnumDescriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.getDescriptor().getEnumTypes().get(0);
				}

				private static final Platform[] VALUES = values();

				public static Platform valueOf(
						com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
					if (desc.getType() != getDescriptor()) {
						throw new java.lang.IllegalArgumentException(
								"EnumValueDescriptor is not for this type.");
					}
					if (desc.getIndex() == -1) {
						return UNRECOGNIZED;
					}
					return VALUES[desc.getIndex()];
				}

				private final int value;

				private Platform(int value) {
					this.value = value;
				}

				// @@protoc_insertion_point(enum_scope:whatsapp.ClientPayload.UserAgent.Platform)
			}

			/**
			 * Protobuf enum {@code whatsapp.ClientPayload.UserAgent.ReleaseChannel}
			 */
			public enum ReleaseChannel
					implements com.google.protobuf.ProtocolMessageEnum {
				/**
				 * <code>RELEASE = 0;</code>
				 */
				RELEASE(0),
				/**
				 * <code>BETA = 1;</code>
				 */
				BETA(1),
				/**
				 * <code>ALPHA = 2;</code>
				 */
				ALPHA(2),
				/**
				 * <code>DEBUG = 3;</code>
				 */
				DEBUG(3),
				UNRECOGNIZED(-1),
				;

				/**
				 * <code>RELEASE = 0;</code>
				 */
				public static final int RELEASE_VALUE = 0;
				/**
				 * <code>BETA = 1;</code>
				 */
				public static final int BETA_VALUE = 1;
				/**
				 * <code>ALPHA = 2;</code>
				 */
				public static final int ALPHA_VALUE = 2;
				/**
				 * <code>DEBUG = 3;</code>
				 */
				public static final int DEBUG_VALUE = 3;


				public final int getNumber() {
					if (this == UNRECOGNIZED) {
						throw new java.lang.IllegalArgumentException(
								"Can't get the number of an unknown enum value.");
					}
					return value;
				}

				/**
				 * @param value The numeric wire value of the corresponding enum entry.
				 * @return The enum associated with the given numeric wire value.
				 * @deprecated Use {@link #forNumber(int)} instead.
				 */
				@java.lang.Deprecated
				public static ReleaseChannel valueOf(int value) {
					return forNumber(value);
				}

				/**
				 * @param value The numeric wire value of the corresponding enum entry.
				 * @return The enum associated with the given numeric wire value.
				 */
				public static ReleaseChannel forNumber(int value) {
					switch (value) {
						case 0: return RELEASE;
						case 1: return BETA;
						case 2: return ALPHA;
						case 3: return DEBUG;
						default: return null;
					}
				}

				public static com.google.protobuf.Internal.EnumLiteMap<ReleaseChannel>
				internalGetValueMap() {
					return internalValueMap;
				}
				private static final com.google.protobuf.Internal.EnumLiteMap<
						ReleaseChannel> internalValueMap =
						new com.google.protobuf.Internal.EnumLiteMap<ReleaseChannel>() {
							public ReleaseChannel findValueByNumber(int number) {
								return ReleaseChannel.forNumber(number);
							}
						};

				public final com.google.protobuf.Descriptors.EnumValueDescriptor
				getValueDescriptor() {
					if (this == UNRECOGNIZED) {
						throw new java.lang.IllegalStateException(
								"Can't get the descriptor of an unrecognized enum value.");
					}
					return getDescriptor().getValues().get(ordinal());
				}
				public final com.google.protobuf.Descriptors.EnumDescriptor
				getDescriptorForType() {
					return getDescriptor();
				}
				public static final com.google.protobuf.Descriptors.EnumDescriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.getDescriptor().getEnumTypes().get(1);
				}

				private static final ReleaseChannel[] VALUES = values();

				public static ReleaseChannel valueOf(
						com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
					if (desc.getType() != getDescriptor()) {
						throw new java.lang.IllegalArgumentException(
								"EnumValueDescriptor is not for this type.");
					}
					if (desc.getIndex() == -1) {
						return UNRECOGNIZED;
					}
					return VALUES[desc.getIndex()];
				}

				private final int value;

				private ReleaseChannel(int value) {
					this.value = value;
				}

				// @@protoc_insertion_point(enum_scope:whatsapp.ClientPayload.UserAgent.ReleaseChannel)
			}

			public interface AppVersionOrBuilder extends
					// @@protoc_insertion_point(interface_extends:whatsapp.ClientPayload.UserAgent.AppVersion)
					com.google.protobuf.MessageOrBuilder {

				/**
				 * <code>uint32 primary = 1;</code>
				 * @return Whether the primary field is set.
				 */
				boolean hasPrimary();
				/**
				 * <code>uint32 primary = 1;</code>
				 * @return The primary.
				 */
				int getPrimary();

				/**
				 * <code>uint32 secondary = 2;</code>
				 * @return Whether the secondary field is set.
				 */
				boolean hasSecondary();
				/**
				 * <code>uint32 secondary = 2;</code>
				 * @return The secondary.
				 */
				int getSecondary();

				/**
				 * <code>uint32 tertiary = 3;</code>
				 * @return Whether the tertiary field is set.
				 */
				boolean hasTertiary();
				/**
				 * <code>uint32 tertiary = 3;</code>
				 * @return The tertiary.
				 */
				int getTertiary();

				/**
				 * <code>uint32 quaternary = 4;</code>
				 * @return Whether the quaternary field is set.
				 */
				boolean hasQuaternary();
				/**
				 * <code>uint32 quaternary = 4;</code>
				 * @return The quaternary.
				 */
				int getQuaternary();
			}
			/**
			 * Protobuf type {@code whatsapp.ClientPayload.UserAgent.AppVersion}
			 */
			public static final class AppVersion extends
					com.google.protobuf.GeneratedMessageV3 implements
					// @@protoc_insertion_point(message_implements:whatsapp.ClientPayload.UserAgent.AppVersion)
					AppVersionOrBuilder {
				private static final long serialVersionUID = 0L;
				// Use AppVersion.newBuilder() to construct.
				private AppVersion(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
					super(builder);
				}
				private AppVersion() {
				}

				@java.lang.Override
				@SuppressWarnings({"unused"})
				protected java.lang.Object newInstance(
						UnusedPrivateParameter unused) {
					return new AppVersion();
				}

				@java.lang.Override
				public final com.google.protobuf.UnknownFieldSet
				getUnknownFields() {
					return this.unknownFields;
				}
				private AppVersion(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					this();
					if (extensionRegistry == null) {
						throw new java.lang.NullPointerException();
					}
					int mutable_bitField0_ = 0;
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
								case 8: {
									bitField0_ |= 0x00000001;
									primary_ = input.readUInt32();
									break;
								}
								case 16: {
									bitField0_ |= 0x00000002;
									secondary_ = input.readUInt32();
									break;
								}
								case 24: {
									bitField0_ |= 0x00000004;
									tertiary_ = input.readUInt32();
									break;
								}
								case 32: {
									bitField0_ |= 0x00000008;
									quaternary_ = input.readUInt32();
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
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.class, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.Builder.class);
				}

				private int bitField0_;
				public static final int PRIMARY_FIELD_NUMBER = 1;
				private int primary_;
				/**
				 * <code>uint32 primary = 1;</code>
				 * @return Whether the primary field is set.
				 */
				@java.lang.Override
				public boolean hasPrimary() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>uint32 primary = 1;</code>
				 * @return The primary.
				 */
				@java.lang.Override
				public int getPrimary() {
					return primary_;
				}

				public static final int SECONDARY_FIELD_NUMBER = 2;
				private int secondary_;
				/**
				 * <code>uint32 secondary = 2;</code>
				 * @return Whether the secondary field is set.
				 */
				@java.lang.Override
				public boolean hasSecondary() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>uint32 secondary = 2;</code>
				 * @return The secondary.
				 */
				@java.lang.Override
				public int getSecondary() {
					return secondary_;
				}

				public static final int TERTIARY_FIELD_NUMBER = 3;
				private int tertiary_;
				/**
				 * <code>uint32 tertiary = 3;</code>
				 * @return Whether the tertiary field is set.
				 */
				@java.lang.Override
				public boolean hasTertiary() {
					return ((bitField0_ & 0x00000004) != 0);
				}
				/**
				 * <code>uint32 tertiary = 3;</code>
				 * @return The tertiary.
				 */
				@java.lang.Override
				public int getTertiary() {
					return tertiary_;
				}

				public static final int QUATERNARY_FIELD_NUMBER = 4;
				private int quaternary_;
				/**
				 * <code>uint32 quaternary = 4;</code>
				 * @return Whether the quaternary field is set.
				 */
				@java.lang.Override
				public boolean hasQuaternary() {
					return ((bitField0_ & 0x00000008) != 0);
				}
				/**
				 * <code>uint32 quaternary = 4;</code>
				 * @return The quaternary.
				 */
				@java.lang.Override
				public int getQuaternary() {
					return quaternary_;
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
					if (((bitField0_ & 0x00000001) != 0)) {
						output.writeUInt32(1, primary_);
					}
					if (((bitField0_ & 0x00000002) != 0)) {
						output.writeUInt32(2, secondary_);
					}
					if (((bitField0_ & 0x00000004) != 0)) {
						output.writeUInt32(3, tertiary_);
					}
					if (((bitField0_ & 0x00000008) != 0)) {
						output.writeUInt32(4, quaternary_);
					}
					unknownFields.writeTo(output);
				}

				@java.lang.Override
				public int getSerializedSize() {
					int size = memoizedSize;
					if (size != -1) return size;

					size = 0;
					if (((bitField0_ & 0x00000001) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeUInt32Size(1, primary_);
					}
					if (((bitField0_ & 0x00000002) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeUInt32Size(2, secondary_);
					}
					if (((bitField0_ & 0x00000004) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeUInt32Size(3, tertiary_);
					}
					if (((bitField0_ & 0x00000008) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeUInt32Size(4, quaternary_);
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
					if (!(obj instanceof com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion)) {
						return super.equals(obj);
					}
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion other = (com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion) obj;

					if (hasPrimary() != other.hasPrimary()) return false;
					if (hasPrimary()) {
						if (getPrimary()
								!= other.getPrimary()) return false;
					}
					if (hasSecondary() != other.hasSecondary()) return false;
					if (hasSecondary()) {
						if (getSecondary()
								!= other.getSecondary()) return false;
					}
					if (hasTertiary() != other.hasTertiary()) return false;
					if (hasTertiary()) {
						if (getTertiary()
								!= other.getTertiary()) return false;
					}
					if (hasQuaternary() != other.hasQuaternary()) return false;
					if (hasQuaternary()) {
						if (getQuaternary()
								!= other.getQuaternary()) return false;
					}
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
					if (hasPrimary()) {
						hash = (37 * hash) + PRIMARY_FIELD_NUMBER;
						hash = (53 * hash) + getPrimary();
					}
					if (hasSecondary()) {
						hash = (37 * hash) + SECONDARY_FIELD_NUMBER;
						hash = (53 * hash) + getSecondary();
					}
					if (hasTertiary()) {
						hash = (37 * hash) + TERTIARY_FIELD_NUMBER;
						hash = (53 * hash) + getTertiary();
					}
					if (hasQuaternary()) {
						hash = (37 * hash) + QUATERNARY_FIELD_NUMBER;
						hash = (53 * hash) + getQuaternary();
					}
					hash = (29 * hash) + unknownFields.hashCode();
					memoizedHashCode = hash;
					return hash;
				}

				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(
						java.nio.ByteBuffer data)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(
						java.nio.ByteBuffer data,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(
						com.google.protobuf.ByteString data)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(
						com.google.protobuf.ByteString data,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(byte[] data)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(
						byte[] data,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(java.io.InputStream input)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseWithIOException(PARSER, input);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(
						java.io.InputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseWithIOException(PARSER, input, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseDelimitedFrom(java.io.InputStream input)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseDelimitedWithIOException(PARSER, input);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseDelimitedFrom(
						java.io.InputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(
						com.google.protobuf.CodedInputStream input)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseWithIOException(PARSER, input);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parseFrom(
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
				public static Builder newBuilder(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion prototype) {
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
				 * Protobuf type {@code whatsapp.ClientPayload.UserAgent.AppVersion}
				 */
				public static final class Builder extends
						com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
						// @@protoc_insertion_point(builder_implements:whatsapp.ClientPayload.UserAgent.AppVersion)
						com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersionOrBuilder {
					public static final com.google.protobuf.Descriptors.Descriptor
					getDescriptor() {
						return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_descriptor;
					}

					@java.lang.Override
					protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
					internalGetFieldAccessorTable() {
						return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_fieldAccessorTable
								.ensureFieldAccessorsInitialized(
										com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.class, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.Builder.class);
					}

					// Construct using com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.newBuilder()
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
						primary_ = 0;
						bitField0_ = (bitField0_ & ~0x00000001);
						secondary_ = 0;
						bitField0_ = (bitField0_ & ~0x00000002);
						tertiary_ = 0;
						bitField0_ = (bitField0_ & ~0x00000004);
						quaternary_ = 0;
						bitField0_ = (bitField0_ & ~0x00000008);
						return this;
					}

					@java.lang.Override
					public com.google.protobuf.Descriptors.Descriptor
					getDescriptorForType() {
						return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_descriptor;
					}

					@java.lang.Override
					public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion getDefaultInstanceForType() {
						return com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.getDefaultInstance();
					}

					@java.lang.Override
					public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion build() {
						com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion result = buildPartial();
						if (!result.isInitialized()) {
							throw newUninitializedMessageException(result);
						}
						return result;
					}

					@java.lang.Override
					public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion buildPartial() {
						com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion result = new com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion(this);
						int from_bitField0_ = bitField0_;
						int to_bitField0_ = 0;
						if (((from_bitField0_ & 0x00000001) != 0)) {
							result.primary_ = primary_;
							to_bitField0_ |= 0x00000001;
						}
						if (((from_bitField0_ & 0x00000002) != 0)) {
							result.secondary_ = secondary_;
							to_bitField0_ |= 0x00000002;
						}
						if (((from_bitField0_ & 0x00000004) != 0)) {
							result.tertiary_ = tertiary_;
							to_bitField0_ |= 0x00000004;
						}
						if (((from_bitField0_ & 0x00000008) != 0)) {
							result.quaternary_ = quaternary_;
							to_bitField0_ |= 0x00000008;
						}
						result.bitField0_ = to_bitField0_;
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
						if (other instanceof com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion) {
							return mergeFrom((com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion)other);
						} else {
							super.mergeFrom(other);
							return this;
						}
					}

					public Builder mergeFrom(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion other) {
						if (other == com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.getDefaultInstance()) return this;
						if (other.hasPrimary()) {
							setPrimary(other.getPrimary());
						}
						if (other.hasSecondary()) {
							setSecondary(other.getSecondary());
						}
						if (other.hasTertiary()) {
							setTertiary(other.getTertiary());
						}
						if (other.hasQuaternary()) {
							setQuaternary(other.getQuaternary());
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
						com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion parsedMessage = null;
						try {
							parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
						} catch (com.google.protobuf.InvalidProtocolBufferException e) {
							parsedMessage = (com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion) e.getUnfinishedMessage();
							throw e.unwrapIOException();
						} finally {
							if (parsedMessage != null) {
								mergeFrom(parsedMessage);
							}
						}
						return this;
					}
					private int bitField0_;

					private int primary_ ;
					/**
					 * <code>uint32 primary = 1;</code>
					 * @return Whether the primary field is set.
					 */
					@java.lang.Override
					public boolean hasPrimary() {
						return ((bitField0_ & 0x00000001) != 0);
					}
					/**
					 * <code>uint32 primary = 1;</code>
					 * @return The primary.
					 */
					@java.lang.Override
					public int getPrimary() {
						return primary_;
					}
					/**
					 * <code>uint32 primary = 1;</code>
					 * @param value The primary to set.
					 * @return This builder for chaining.
					 */
					public Builder setPrimary(int value) {
						bitField0_ |= 0x00000001;
						primary_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>uint32 primary = 1;</code>
					 * @return This builder for chaining.
					 */
					public Builder clearPrimary() {
						bitField0_ = (bitField0_ & ~0x00000001);
						primary_ = 0;
						onChanged();
						return this;
					}

					private int secondary_ ;
					/**
					 * <code>uint32 secondary = 2;</code>
					 * @return Whether the secondary field is set.
					 */
					@java.lang.Override
					public boolean hasSecondary() {
						return ((bitField0_ & 0x00000002) != 0);
					}
					/**
					 * <code>uint32 secondary = 2;</code>
					 * @return The secondary.
					 */
					@java.lang.Override
					public int getSecondary() {
						return secondary_;
					}
					/**
					 * <code>uint32 secondary = 2;</code>
					 * @param value The secondary to set.
					 * @return This builder for chaining.
					 */
					public Builder setSecondary(int value) {
						bitField0_ |= 0x00000002;
						secondary_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>uint32 secondary = 2;</code>
					 * @return This builder for chaining.
					 */
					public Builder clearSecondary() {
						bitField0_ = (bitField0_ & ~0x00000002);
						secondary_ = 0;
						onChanged();
						return this;
					}

					private int tertiary_ ;
					/**
					 * <code>uint32 tertiary = 3;</code>
					 * @return Whether the tertiary field is set.
					 */
					@java.lang.Override
					public boolean hasTertiary() {
						return ((bitField0_ & 0x00000004) != 0);
					}
					/**
					 * <code>uint32 tertiary = 3;</code>
					 * @return The tertiary.
					 */
					@java.lang.Override
					public int getTertiary() {
						return tertiary_;
					}
					/**
					 * <code>uint32 tertiary = 3;</code>
					 * @param value The tertiary to set.
					 * @return This builder for chaining.
					 */
					public Builder setTertiary(int value) {
						bitField0_ |= 0x00000004;
						tertiary_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>uint32 tertiary = 3;</code>
					 * @return This builder for chaining.
					 */
					public Builder clearTertiary() {
						bitField0_ = (bitField0_ & ~0x00000004);
						tertiary_ = 0;
						onChanged();
						return this;
					}

					private int quaternary_ ;
					/**
					 * <code>uint32 quaternary = 4;</code>
					 * @return Whether the quaternary field is set.
					 */
					@java.lang.Override
					public boolean hasQuaternary() {
						return ((bitField0_ & 0x00000008) != 0);
					}
					/**
					 * <code>uint32 quaternary = 4;</code>
					 * @return The quaternary.
					 */
					@java.lang.Override
					public int getQuaternary() {
						return quaternary_;
					}
					/**
					 * <code>uint32 quaternary = 4;</code>
					 * @param value The quaternary to set.
					 * @return This builder for chaining.
					 */
					public Builder setQuaternary(int value) {
						bitField0_ |= 0x00000008;
						quaternary_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>uint32 quaternary = 4;</code>
					 * @return This builder for chaining.
					 */
					public Builder clearQuaternary() {
						bitField0_ = (bitField0_ & ~0x00000008);
						quaternary_ = 0;
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


					// @@protoc_insertion_point(builder_scope:whatsapp.ClientPayload.UserAgent.AppVersion)
				}

				// @@protoc_insertion_point(class_scope:whatsapp.ClientPayload.UserAgent.AppVersion)
				private static final com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion DEFAULT_INSTANCE;
				static {
					DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion();
				}

				public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion getDefaultInstance() {
					return DEFAULT_INSTANCE;
				}

				private static final com.google.protobuf.Parser<AppVersion>
						PARSER = new com.google.protobuf.AbstractParser<AppVersion>() {
					@java.lang.Override
					public AppVersion parsePartialFrom(
							com.google.protobuf.CodedInputStream input,
							com.google.protobuf.ExtensionRegistryLite extensionRegistry)
							throws com.google.protobuf.InvalidProtocolBufferException {
						return new AppVersion(input, extensionRegistry);
					}
				};

				public static com.google.protobuf.Parser<AppVersion> parser() {
					return PARSER;
				}

				@java.lang.Override
				public com.google.protobuf.Parser<AppVersion> getParserForType() {
					return PARSER;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion getDefaultInstanceForType() {
					return DEFAULT_INSTANCE;
				}

			}

			private int bitField0_;
			public static final int PLATFORM_FIELD_NUMBER = 1;
			private int platform_;
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
			 * @return Whether the platform field is set.
			 */
			@java.lang.Override public boolean hasPlatform() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
			 * @return The enum numeric value on the wire for platform.
			 */
			@java.lang.Override public int getPlatformValue() {
				return platform_;
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
			 * @return The platform.
			 */
			@java.lang.Override public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform getPlatform() {
				@SuppressWarnings("deprecation")
				com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform result = com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform.valueOf(platform_);
				return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform.UNRECOGNIZED : result;
			}

			public static final int APP_VERSION_FIELD_NUMBER = 2;
			private com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion appVersion_;
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
			 * @return Whether the appVersion field is set.
			 */
			@java.lang.Override
			public boolean hasAppVersion() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
			 * @return The appVersion.
			 */
			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion getAppVersion() {
				return appVersion_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.getDefaultInstance() : appVersion_;
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
			 */
			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersionOrBuilder getAppVersionOrBuilder() {
				return appVersion_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.getDefaultInstance() : appVersion_;
			}

			public static final int MCC_FIELD_NUMBER = 3;
			private volatile java.lang.Object mcc_;
			/**
			 * <code>string mcc = 3;</code>
			 * @return Whether the mcc field is set.
			 */
			@java.lang.Override
			public boolean hasMcc() {
				return ((bitField0_ & 0x00000004) != 0);
			}
			/**
			 * <code>string mcc = 3;</code>
			 * @return The mcc.
			 */
			@java.lang.Override
			public java.lang.String getMcc() {
				java.lang.Object ref = mcc_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					mcc_ = s;
					return s;
				}
			}
			/**
			 * <code>string mcc = 3;</code>
			 * @return The bytes for mcc.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getMccBytes() {
				java.lang.Object ref = mcc_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					mcc_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int MNC_FIELD_NUMBER = 4;
			private volatile java.lang.Object mnc_;
			/**
			 * <code>string mnc = 4;</code>
			 * @return Whether the mnc field is set.
			 */
			@java.lang.Override
			public boolean hasMnc() {
				return ((bitField0_ & 0x00000008) != 0);
			}
			/**
			 * <code>string mnc = 4;</code>
			 * @return The mnc.
			 */
			@java.lang.Override
			public java.lang.String getMnc() {
				java.lang.Object ref = mnc_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					mnc_ = s;
					return s;
				}
			}
			/**
			 * <code>string mnc = 4;</code>
			 * @return The bytes for mnc.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getMncBytes() {
				java.lang.Object ref = mnc_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					mnc_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int OS_VERSION_FIELD_NUMBER = 5;
			private volatile java.lang.Object osVersion_;
			/**
			 * <code>string os_version = 5;</code>
			 * @return Whether the osVersion field is set.
			 */
			@java.lang.Override
			public boolean hasOsVersion() {
				return ((bitField0_ & 0x00000010) != 0);
			}
			/**
			 * <code>string os_version = 5;</code>
			 * @return The osVersion.
			 */
			@java.lang.Override
			public java.lang.String getOsVersion() {
				java.lang.Object ref = osVersion_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					osVersion_ = s;
					return s;
				}
			}
			/**
			 * <code>string os_version = 5;</code>
			 * @return The bytes for osVersion.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getOsVersionBytes() {
				java.lang.Object ref = osVersion_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					osVersion_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int MANUFACTURER_FIELD_NUMBER = 6;
			private volatile java.lang.Object manufacturer_;
			/**
			 * <code>string manufacturer = 6;</code>
			 * @return Whether the manufacturer field is set.
			 */
			@java.lang.Override
			public boolean hasManufacturer() {
				return ((bitField0_ & 0x00000020) != 0);
			}
			/**
			 * <code>string manufacturer = 6;</code>
			 * @return The manufacturer.
			 */
			@java.lang.Override
			public java.lang.String getManufacturer() {
				java.lang.Object ref = manufacturer_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					manufacturer_ = s;
					return s;
				}
			}
			/**
			 * <code>string manufacturer = 6;</code>
			 * @return The bytes for manufacturer.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getManufacturerBytes() {
				java.lang.Object ref = manufacturer_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					manufacturer_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int DEVICE_FIELD_NUMBER = 7;
			private volatile java.lang.Object device_;
			/**
			 * <code>string device = 7;</code>
			 * @return Whether the device field is set.
			 */
			@java.lang.Override
			public boolean hasDevice() {
				return ((bitField0_ & 0x00000040) != 0);
			}
			/**
			 * <code>string device = 7;</code>
			 * @return The device.
			 */
			@java.lang.Override
			public java.lang.String getDevice() {
				java.lang.Object ref = device_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					device_ = s;
					return s;
				}
			}
			/**
			 * <code>string device = 7;</code>
			 * @return The bytes for device.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getDeviceBytes() {
				java.lang.Object ref = device_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					device_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int OS_BUILD_NUMBER_FIELD_NUMBER = 8;
			private volatile java.lang.Object osBuildNumber_;
			/**
			 * <code>string os_build_number = 8;</code>
			 * @return Whether the osBuildNumber field is set.
			 */
			@java.lang.Override
			public boolean hasOsBuildNumber() {
				return ((bitField0_ & 0x00000080) != 0);
			}
			/**
			 * <code>string os_build_number = 8;</code>
			 * @return The osBuildNumber.
			 */
			@java.lang.Override
			public java.lang.String getOsBuildNumber() {
				java.lang.Object ref = osBuildNumber_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					osBuildNumber_ = s;
					return s;
				}
			}
			/**
			 * <code>string os_build_number = 8;</code>
			 * @return The bytes for osBuildNumber.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getOsBuildNumberBytes() {
				java.lang.Object ref = osBuildNumber_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					osBuildNumber_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int PHONE_ID_FIELD_NUMBER = 9;
			private volatile java.lang.Object phoneId_;
			/**
			 * <code>string phone_id = 9;</code>
			 * @return Whether the phoneId field is set.
			 */
			@java.lang.Override
			public boolean hasPhoneId() {
				return ((bitField0_ & 0x00000100) != 0);
			}
			/**
			 * <code>string phone_id = 9;</code>
			 * @return The phoneId.
			 */
			@java.lang.Override
			public java.lang.String getPhoneId() {
				java.lang.Object ref = phoneId_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					phoneId_ = s;
					return s;
				}
			}
			/**
			 * <code>string phone_id = 9;</code>
			 * @return The bytes for phoneId.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getPhoneIdBytes() {
				java.lang.Object ref = phoneId_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					phoneId_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int RELEASE_CHANNEL_FIELD_NUMBER = 10;
			private int releaseChannel_;
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
			 * @return Whether the releaseChannel field is set.
			 */
			@java.lang.Override public boolean hasReleaseChannel() {
				return ((bitField0_ & 0x00000200) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
			 * @return The enum numeric value on the wire for releaseChannel.
			 */
			@java.lang.Override public int getReleaseChannelValue() {
				return releaseChannel_;
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
			 * @return The releaseChannel.
			 */
			@java.lang.Override public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel getReleaseChannel() {
				@SuppressWarnings("deprecation")
				com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel result = com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel.valueOf(releaseChannel_);
				return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel.UNRECOGNIZED : result;
			}

			public static final int LOCALE_LANGUAGE_ISO_639_1_FIELD_NUMBER = 11;
			private volatile java.lang.Object localeLanguageIso6391_;
			/**
			 * <code>string locale_language_iso_639_1 = 11;</code>
			 * @return Whether the localeLanguageIso6391 field is set.
			 */
			@java.lang.Override
			public boolean hasLocaleLanguageIso6391() {
				return ((bitField0_ & 0x00000400) != 0);
			}
			/**
			 * <code>string locale_language_iso_639_1 = 11;</code>
			 * @return The localeLanguageIso6391.
			 */
			@java.lang.Override
			public java.lang.String getLocaleLanguageIso6391() {
				java.lang.Object ref = localeLanguageIso6391_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					localeLanguageIso6391_ = s;
					return s;
				}
			}
			/**
			 * <code>string locale_language_iso_639_1 = 11;</code>
			 * @return The bytes for localeLanguageIso6391.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getLocaleLanguageIso6391Bytes() {
				java.lang.Object ref = localeLanguageIso6391_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					localeLanguageIso6391_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int LOCAL_COUNTRY_ISO_3166_1_ALPHA_2_FIELD_NUMBER = 12;
			private volatile java.lang.Object localCountryIso31661Alpha2_;
			/**
			 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
			 * @return Whether the localCountryIso31661Alpha2 field is set.
			 */
			@java.lang.Override
			public boolean hasLocalCountryIso31661Alpha2() {
				return ((bitField0_ & 0x00000800) != 0);
			}
			/**
			 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
			 * @return The localCountryIso31661Alpha2.
			 */
			@java.lang.Override
			public java.lang.String getLocalCountryIso31661Alpha2() {
				java.lang.Object ref = localCountryIso31661Alpha2_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					localCountryIso31661Alpha2_ = s;
					return s;
				}
			}
			/**
			 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
			 * @return The bytes for localCountryIso31661Alpha2.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getLocalCountryIso31661Alpha2Bytes() {
				java.lang.Object ref = localCountryIso31661Alpha2_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					localCountryIso31661Alpha2_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int DEVICE_BOARD_FIELD_NUMBER = 13;
			private volatile java.lang.Object deviceBoard_;
			/**
			 * <code>string device_board = 13;</code>
			 * @return Whether the deviceBoard field is set.
			 */
			@java.lang.Override
			public boolean hasDeviceBoard() {
				return ((bitField0_ & 0x00001000) != 0);
			}
			/**
			 * <code>string device_board = 13;</code>
			 * @return The deviceBoard.
			 */
			@java.lang.Override
			public java.lang.String getDeviceBoard() {
				java.lang.Object ref = deviceBoard_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					deviceBoard_ = s;
					return s;
				}
			}
			/**
			 * <code>string device_board = 13;</code>
			 * @return The bytes for deviceBoard.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getDeviceBoardBytes() {
				java.lang.Object ref = deviceBoard_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					deviceBoard_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
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
				if (((bitField0_ & 0x00000001) != 0)) {
					output.writeEnum(1, platform_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					output.writeMessage(2, getAppVersion());
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 3, mcc_);
				}
				if (((bitField0_ & 0x00000008) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 4, mnc_);
				}
				if (((bitField0_ & 0x00000010) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 5, osVersion_);
				}
				if (((bitField0_ & 0x00000020) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 6, manufacturer_);
				}
				if (((bitField0_ & 0x00000040) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 7, device_);
				}
				if (((bitField0_ & 0x00000080) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 8, osBuildNumber_);
				}
				if (((bitField0_ & 0x00000100) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 9, phoneId_);
				}
				if (((bitField0_ & 0x00000200) != 0)) {
					output.writeEnum(10, releaseChannel_);
				}
				if (((bitField0_ & 0x00000400) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 11, localeLanguageIso6391_);
				}
				if (((bitField0_ & 0x00000800) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 12, localCountryIso31661Alpha2_);
				}
				if (((bitField0_ & 0x00001000) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 13, deviceBoard_);
				}
				unknownFields.writeTo(output);
			}

			@java.lang.Override
			public int getSerializedSize() {
				int size = memoizedSize;
				if (size != -1) return size;

				size = 0;
				if (((bitField0_ & 0x00000001) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeEnumSize(1, platform_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeMessageSize(2, getAppVersion());
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, mcc_);
				}
				if (((bitField0_ & 0x00000008) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, mnc_);
				}
				if (((bitField0_ & 0x00000010) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, osVersion_);
				}
				if (((bitField0_ & 0x00000020) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(6, manufacturer_);
				}
				if (((bitField0_ & 0x00000040) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, device_);
				}
				if (((bitField0_ & 0x00000080) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(8, osBuildNumber_);
				}
				if (((bitField0_ & 0x00000100) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(9, phoneId_);
				}
				if (((bitField0_ & 0x00000200) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeEnumSize(10, releaseChannel_);
				}
				if (((bitField0_ & 0x00000400) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(11, localeLanguageIso6391_);
				}
				if (((bitField0_ & 0x00000800) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(12, localCountryIso31661Alpha2_);
				}
				if (((bitField0_ & 0x00001000) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(13, deviceBoard_);
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
				if (!(obj instanceof com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent)) {
					return super.equals(obj);
				}
				com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent other = (com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent) obj;

				if (hasPlatform() != other.hasPlatform()) return false;
				if (hasPlatform()) {
					if (platform_ != other.platform_) return false;
				}
				if (hasAppVersion() != other.hasAppVersion()) return false;
				if (hasAppVersion()) {
					if (!getAppVersion()
							.equals(other.getAppVersion())) return false;
				}
				if (hasMcc() != other.hasMcc()) return false;
				if (hasMcc()) {
					if (!getMcc()
							.equals(other.getMcc())) return false;
				}
				if (hasMnc() != other.hasMnc()) return false;
				if (hasMnc()) {
					if (!getMnc()
							.equals(other.getMnc())) return false;
				}
				if (hasOsVersion() != other.hasOsVersion()) return false;
				if (hasOsVersion()) {
					if (!getOsVersion()
							.equals(other.getOsVersion())) return false;
				}
				if (hasManufacturer() != other.hasManufacturer()) return false;
				if (hasManufacturer()) {
					if (!getManufacturer()
							.equals(other.getManufacturer())) return false;
				}
				if (hasDevice() != other.hasDevice()) return false;
				if (hasDevice()) {
					if (!getDevice()
							.equals(other.getDevice())) return false;
				}
				if (hasOsBuildNumber() != other.hasOsBuildNumber()) return false;
				if (hasOsBuildNumber()) {
					if (!getOsBuildNumber()
							.equals(other.getOsBuildNumber())) return false;
				}
				if (hasPhoneId() != other.hasPhoneId()) return false;
				if (hasPhoneId()) {
					if (!getPhoneId()
							.equals(other.getPhoneId())) return false;
				}
				if (hasReleaseChannel() != other.hasReleaseChannel()) return false;
				if (hasReleaseChannel()) {
					if (releaseChannel_ != other.releaseChannel_) return false;
				}
				if (hasLocaleLanguageIso6391() != other.hasLocaleLanguageIso6391()) return false;
				if (hasLocaleLanguageIso6391()) {
					if (!getLocaleLanguageIso6391()
							.equals(other.getLocaleLanguageIso6391())) return false;
				}
				if (hasLocalCountryIso31661Alpha2() != other.hasLocalCountryIso31661Alpha2()) return false;
				if (hasLocalCountryIso31661Alpha2()) {
					if (!getLocalCountryIso31661Alpha2()
							.equals(other.getLocalCountryIso31661Alpha2())) return false;
				}
				if (hasDeviceBoard() != other.hasDeviceBoard()) return false;
				if (hasDeviceBoard()) {
					if (!getDeviceBoard()
							.equals(other.getDeviceBoard())) return false;
				}
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
				if (hasPlatform()) {
					hash = (37 * hash) + PLATFORM_FIELD_NUMBER;
					hash = (53 * hash) + platform_;
				}
				if (hasAppVersion()) {
					hash = (37 * hash) + APP_VERSION_FIELD_NUMBER;
					hash = (53 * hash) + getAppVersion().hashCode();
				}
				if (hasMcc()) {
					hash = (37 * hash) + MCC_FIELD_NUMBER;
					hash = (53 * hash) + getMcc().hashCode();
				}
				if (hasMnc()) {
					hash = (37 * hash) + MNC_FIELD_NUMBER;
					hash = (53 * hash) + getMnc().hashCode();
				}
				if (hasOsVersion()) {
					hash = (37 * hash) + OS_VERSION_FIELD_NUMBER;
					hash = (53 * hash) + getOsVersion().hashCode();
				}
				if (hasManufacturer()) {
					hash = (37 * hash) + MANUFACTURER_FIELD_NUMBER;
					hash = (53 * hash) + getManufacturer().hashCode();
				}
				if (hasDevice()) {
					hash = (37 * hash) + DEVICE_FIELD_NUMBER;
					hash = (53 * hash) + getDevice().hashCode();
				}
				if (hasOsBuildNumber()) {
					hash = (37 * hash) + OS_BUILD_NUMBER_FIELD_NUMBER;
					hash = (53 * hash) + getOsBuildNumber().hashCode();
				}
				if (hasPhoneId()) {
					hash = (37 * hash) + PHONE_ID_FIELD_NUMBER;
					hash = (53 * hash) + getPhoneId().hashCode();
				}
				if (hasReleaseChannel()) {
					hash = (37 * hash) + RELEASE_CHANNEL_FIELD_NUMBER;
					hash = (53 * hash) + releaseChannel_;
				}
				if (hasLocaleLanguageIso6391()) {
					hash = (37 * hash) + LOCALE_LANGUAGE_ISO_639_1_FIELD_NUMBER;
					hash = (53 * hash) + getLocaleLanguageIso6391().hashCode();
				}
				if (hasLocalCountryIso31661Alpha2()) {
					hash = (37 * hash) + LOCAL_COUNTRY_ISO_3166_1_ALPHA_2_FIELD_NUMBER;
					hash = (53 * hash) + getLocalCountryIso31661Alpha2().hashCode();
				}
				if (hasDeviceBoard()) {
					hash = (37 * hash) + DEVICE_BOARD_FIELD_NUMBER;
					hash = (53 * hash) + getDeviceBoard().hashCode();
				}
				hash = (29 * hash) + unknownFields.hashCode();
				memoizedHashCode = hash;
				return hash;
			}

			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(
					java.nio.ByteBuffer data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(
					java.nio.ByteBuffer data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(
					com.google.protobuf.ByteString data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(
					com.google.protobuf.ByteString data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(byte[] data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(
					byte[] data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseDelimitedFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseDelimitedFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(
					com.google.protobuf.CodedInputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parseFrom(
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
			public static Builder newBuilder(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent prototype) {
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
			 * Protobuf type {@code whatsapp.ClientPayload.UserAgent}
			 */
			public static final class Builder extends
					com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
					// @@protoc_insertion_point(builder_implements:whatsapp.ClientPayload.UserAgent)
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgentOrBuilder {
				public static final com.google.protobuf.Descriptors.Descriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.class, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Builder.class);
				}

				// Construct using com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.newBuilder()
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
						getAppVersionFieldBuilder();
					}
				}
				@java.lang.Override
				public Builder clear() {
					super.clear();
					platform_ = 0;
					bitField0_ = (bitField0_ & ~0x00000001);
					if (appVersionBuilder_ == null) {
						appVersion_ = null;
					} else {
						appVersionBuilder_.clear();
					}
					bitField0_ = (bitField0_ & ~0x00000002);
					mcc_ = "";
					bitField0_ = (bitField0_ & ~0x00000004);
					mnc_ = "";
					bitField0_ = (bitField0_ & ~0x00000008);
					osVersion_ = "";
					bitField0_ = (bitField0_ & ~0x00000010);
					manufacturer_ = "";
					bitField0_ = (bitField0_ & ~0x00000020);
					device_ = "";
					bitField0_ = (bitField0_ & ~0x00000040);
					osBuildNumber_ = "";
					bitField0_ = (bitField0_ & ~0x00000080);
					phoneId_ = "";
					bitField0_ = (bitField0_ & ~0x00000100);
					releaseChannel_ = 0;
					bitField0_ = (bitField0_ & ~0x00000200);
					localeLanguageIso6391_ = "";
					bitField0_ = (bitField0_ & ~0x00000400);
					localCountryIso31661Alpha2_ = "";
					bitField0_ = (bitField0_ & ~0x00000800);
					deviceBoard_ = "";
					bitField0_ = (bitField0_ & ~0x00001000);
					return this;
				}

				@java.lang.Override
				public com.google.protobuf.Descriptors.Descriptor
				getDescriptorForType() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_UserAgent_descriptor;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent getDefaultInstanceForType() {
					return com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.getDefaultInstance();
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent build() {
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent result = buildPartial();
					if (!result.isInitialized()) {
						throw newUninitializedMessageException(result);
					}
					return result;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent buildPartial() {
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent result = new com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent(this);
					int from_bitField0_ = bitField0_;
					int to_bitField0_ = 0;
					if (((from_bitField0_ & 0x00000001) != 0)) {
						to_bitField0_ |= 0x00000001;
					}
					result.platform_ = platform_;
					if (((from_bitField0_ & 0x00000002) != 0)) {
						if (appVersionBuilder_ == null) {
							result.appVersion_ = appVersion_;
						} else {
							result.appVersion_ = appVersionBuilder_.build();
						}
						to_bitField0_ |= 0x00000002;
					}
					if (((from_bitField0_ & 0x00000004) != 0)) {
						to_bitField0_ |= 0x00000004;
					}
					result.mcc_ = mcc_;
					if (((from_bitField0_ & 0x00000008) != 0)) {
						to_bitField0_ |= 0x00000008;
					}
					result.mnc_ = mnc_;
					if (((from_bitField0_ & 0x00000010) != 0)) {
						to_bitField0_ |= 0x00000010;
					}
					result.osVersion_ = osVersion_;
					if (((from_bitField0_ & 0x00000020) != 0)) {
						to_bitField0_ |= 0x00000020;
					}
					result.manufacturer_ = manufacturer_;
					if (((from_bitField0_ & 0x00000040) != 0)) {
						to_bitField0_ |= 0x00000040;
					}
					result.device_ = device_;
					if (((from_bitField0_ & 0x00000080) != 0)) {
						to_bitField0_ |= 0x00000080;
					}
					result.osBuildNumber_ = osBuildNumber_;
					if (((from_bitField0_ & 0x00000100) != 0)) {
						to_bitField0_ |= 0x00000100;
					}
					result.phoneId_ = phoneId_;
					if (((from_bitField0_ & 0x00000200) != 0)) {
						to_bitField0_ |= 0x00000200;
					}
					result.releaseChannel_ = releaseChannel_;
					if (((from_bitField0_ & 0x00000400) != 0)) {
						to_bitField0_ |= 0x00000400;
					}
					result.localeLanguageIso6391_ = localeLanguageIso6391_;
					if (((from_bitField0_ & 0x00000800) != 0)) {
						to_bitField0_ |= 0x00000800;
					}
					result.localCountryIso31661Alpha2_ = localCountryIso31661Alpha2_;
					if (((from_bitField0_ & 0x00001000) != 0)) {
						to_bitField0_ |= 0x00001000;
					}
					result.deviceBoard_ = deviceBoard_;
					result.bitField0_ = to_bitField0_;
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
					if (other instanceof com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent) {
						return mergeFrom((com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent)other);
					} else {
						super.mergeFrom(other);
						return this;
					}
				}

				public Builder mergeFrom(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent other) {
					if (other == com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.getDefaultInstance()) return this;
					if (other.hasPlatform()) {
						setPlatform(other.getPlatform());
					}
					if (other.hasAppVersion()) {
						mergeAppVersion(other.getAppVersion());
					}
					if (other.hasMcc()) {
						bitField0_ |= 0x00000004;
						mcc_ = other.mcc_;
						onChanged();
					}
					if (other.hasMnc()) {
						bitField0_ |= 0x00000008;
						mnc_ = other.mnc_;
						onChanged();
					}
					if (other.hasOsVersion()) {
						bitField0_ |= 0x00000010;
						osVersion_ = other.osVersion_;
						onChanged();
					}
					if (other.hasManufacturer()) {
						bitField0_ |= 0x00000020;
						manufacturer_ = other.manufacturer_;
						onChanged();
					}
					if (other.hasDevice()) {
						bitField0_ |= 0x00000040;
						device_ = other.device_;
						onChanged();
					}
					if (other.hasOsBuildNumber()) {
						bitField0_ |= 0x00000080;
						osBuildNumber_ = other.osBuildNumber_;
						onChanged();
					}
					if (other.hasPhoneId()) {
						bitField0_ |= 0x00000100;
						phoneId_ = other.phoneId_;
						onChanged();
					}
					if (other.hasReleaseChannel()) {
						setReleaseChannel(other.getReleaseChannel());
					}
					if (other.hasLocaleLanguageIso6391()) {
						bitField0_ |= 0x00000400;
						localeLanguageIso6391_ = other.localeLanguageIso6391_;
						onChanged();
					}
					if (other.hasLocalCountryIso31661Alpha2()) {
						bitField0_ |= 0x00000800;
						localCountryIso31661Alpha2_ = other.localCountryIso31661Alpha2_;
						onChanged();
					}
					if (other.hasDeviceBoard()) {
						bitField0_ |= 0x00001000;
						deviceBoard_ = other.deviceBoard_;
						onChanged();
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
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent parsedMessage = null;
					try {
						parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
					} catch (com.google.protobuf.InvalidProtocolBufferException e) {
						parsedMessage = (com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent) e.getUnfinishedMessage();
						throw e.unwrapIOException();
					} finally {
						if (parsedMessage != null) {
							mergeFrom(parsedMessage);
						}
					}
					return this;
				}
				private int bitField0_;

				private int platform_ = 0;
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
				 * @return Whether the platform field is set.
				 */
				@java.lang.Override public boolean hasPlatform() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
				 * @return The enum numeric value on the wire for platform.
				 */
				@java.lang.Override public int getPlatformValue() {
					return platform_;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
				 * @param value The enum numeric value on the wire for platform to set.
				 * @return This builder for chaining.
				 */
				public Builder setPlatformValue(int value) {
					bitField0_ |= 0x00000001;
					platform_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
				 * @return The platform.
				 */
				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform getPlatform() {
					@SuppressWarnings("deprecation")
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform result = com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform.valueOf(platform_);
					return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform.UNRECOGNIZED : result;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
				 * @param value The platform to set.
				 * @return This builder for chaining.
				 */
				public Builder setPlatform(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Platform value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000001;
					platform_ = value.getNumber();
					onChanged();
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.Platform platform = 1;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearPlatform() {
					bitField0_ = (bitField0_ & ~0x00000001);
					platform_ = 0;
					onChanged();
					return this;
				}

				private com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion appVersion_;
				private com.google.protobuf.SingleFieldBuilderV3<
						com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersionOrBuilder> appVersionBuilder_;
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
				 * @return Whether the appVersion field is set.
				 */
				public boolean hasAppVersion() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
				 * @return The appVersion.
				 */
				public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion getAppVersion() {
					if (appVersionBuilder_ == null) {
						return appVersion_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.getDefaultInstance() : appVersion_;
					} else {
						return appVersionBuilder_.getMessage();
					}
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
				 */
				public Builder setAppVersion(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion value) {
					if (appVersionBuilder_ == null) {
						if (value == null) {
							throw new NullPointerException();
						}
						appVersion_ = value;
						onChanged();
					} else {
						appVersionBuilder_.setMessage(value);
					}
					bitField0_ |= 0x00000002;
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
				 */
				public Builder setAppVersion(
						com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.Builder builderForValue) {
					if (appVersionBuilder_ == null) {
						appVersion_ = builderForValue.build();
						onChanged();
					} else {
						appVersionBuilder_.setMessage(builderForValue.build());
					}
					bitField0_ |= 0x00000002;
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
				 */
				public Builder mergeAppVersion(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion value) {
					if (appVersionBuilder_ == null) {
						if (((bitField0_ & 0x00000002) != 0) &&
								appVersion_ != null &&
								appVersion_ != com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.getDefaultInstance()) {
							appVersion_ =
									com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.newBuilder(appVersion_).mergeFrom(value).buildPartial();
						} else {
							appVersion_ = value;
						}
						onChanged();
					} else {
						appVersionBuilder_.mergeFrom(value);
					}
					bitField0_ |= 0x00000002;
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
				 */
				public Builder clearAppVersion() {
					if (appVersionBuilder_ == null) {
						appVersion_ = null;
						onChanged();
					} else {
						appVersionBuilder_.clear();
					}
					bitField0_ = (bitField0_ & ~0x00000002);
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
				 */
				public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.Builder getAppVersionBuilder() {
					bitField0_ |= 0x00000002;
					onChanged();
					return getAppVersionFieldBuilder().getBuilder();
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
				 */
				public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersionOrBuilder getAppVersionOrBuilder() {
					if (appVersionBuilder_ != null) {
						return appVersionBuilder_.getMessageOrBuilder();
					} else {
						return appVersion_ == null ?
								com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.getDefaultInstance() : appVersion_;
					}
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.AppVersion app_version = 2;</code>
				 */
				private com.google.protobuf.SingleFieldBuilderV3<
						com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersionOrBuilder>
				getAppVersionFieldBuilder() {
					if (appVersionBuilder_ == null) {
						appVersionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
								com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersion.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.AppVersionOrBuilder>(
								getAppVersion(),
								getParentForChildren(),
								isClean());
						appVersion_ = null;
					}
					return appVersionBuilder_;
				}

				private java.lang.Object mcc_ = "";
				/**
				 * <code>string mcc = 3;</code>
				 * @return Whether the mcc field is set.
				 */
				public boolean hasMcc() {
					return ((bitField0_ & 0x00000004) != 0);
				}
				/**
				 * <code>string mcc = 3;</code>
				 * @return The mcc.
				 */
				public java.lang.String getMcc() {
					java.lang.Object ref = mcc_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						mcc_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string mcc = 3;</code>
				 * @return The bytes for mcc.
				 */
				public com.google.protobuf.ByteString
				getMccBytes() {
					java.lang.Object ref = mcc_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						mcc_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string mcc = 3;</code>
				 * @param value The mcc to set.
				 * @return This builder for chaining.
				 */
				public Builder setMcc(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000004;
					mcc_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string mcc = 3;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearMcc() {
					bitField0_ = (bitField0_ & ~0x00000004);
					mcc_ = getDefaultInstance().getMcc();
					onChanged();
					return this;
				}
				/**
				 * <code>string mcc = 3;</code>
				 * @param value The bytes for mcc to set.
				 * @return This builder for chaining.
				 */
				public Builder setMccBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000004;
					mcc_ = value;
					onChanged();
					return this;
				}

				private java.lang.Object mnc_ = "";
				/**
				 * <code>string mnc = 4;</code>
				 * @return Whether the mnc field is set.
				 */
				public boolean hasMnc() {
					return ((bitField0_ & 0x00000008) != 0);
				}
				/**
				 * <code>string mnc = 4;</code>
				 * @return The mnc.
				 */
				public java.lang.String getMnc() {
					java.lang.Object ref = mnc_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						mnc_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string mnc = 4;</code>
				 * @return The bytes for mnc.
				 */
				public com.google.protobuf.ByteString
				getMncBytes() {
					java.lang.Object ref = mnc_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						mnc_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string mnc = 4;</code>
				 * @param value The mnc to set.
				 * @return This builder for chaining.
				 */
				public Builder setMnc(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000008;
					mnc_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string mnc = 4;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearMnc() {
					bitField0_ = (bitField0_ & ~0x00000008);
					mnc_ = getDefaultInstance().getMnc();
					onChanged();
					return this;
				}
				/**
				 * <code>string mnc = 4;</code>
				 * @param value The bytes for mnc to set.
				 * @return This builder for chaining.
				 */
				public Builder setMncBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000008;
					mnc_ = value;
					onChanged();
					return this;
				}

				private java.lang.Object osVersion_ = "";
				/**
				 * <code>string os_version = 5;</code>
				 * @return Whether the osVersion field is set.
				 */
				public boolean hasOsVersion() {
					return ((bitField0_ & 0x00000010) != 0);
				}
				/**
				 * <code>string os_version = 5;</code>
				 * @return The osVersion.
				 */
				public java.lang.String getOsVersion() {
					java.lang.Object ref = osVersion_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						osVersion_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string os_version = 5;</code>
				 * @return The bytes for osVersion.
				 */
				public com.google.protobuf.ByteString
				getOsVersionBytes() {
					java.lang.Object ref = osVersion_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						osVersion_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string os_version = 5;</code>
				 * @param value The osVersion to set.
				 * @return This builder for chaining.
				 */
				public Builder setOsVersion(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000010;
					osVersion_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string os_version = 5;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearOsVersion() {
					bitField0_ = (bitField0_ & ~0x00000010);
					osVersion_ = getDefaultInstance().getOsVersion();
					onChanged();
					return this;
				}
				/**
				 * <code>string os_version = 5;</code>
				 * @param value The bytes for osVersion to set.
				 * @return This builder for chaining.
				 */
				public Builder setOsVersionBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000010;
					osVersion_ = value;
					onChanged();
					return this;
				}

				private java.lang.Object manufacturer_ = "";
				/**
				 * <code>string manufacturer = 6;</code>
				 * @return Whether the manufacturer field is set.
				 */
				public boolean hasManufacturer() {
					return ((bitField0_ & 0x00000020) != 0);
				}
				/**
				 * <code>string manufacturer = 6;</code>
				 * @return The manufacturer.
				 */
				public java.lang.String getManufacturer() {
					java.lang.Object ref = manufacturer_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						manufacturer_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string manufacturer = 6;</code>
				 * @return The bytes for manufacturer.
				 */
				public com.google.protobuf.ByteString
				getManufacturerBytes() {
					java.lang.Object ref = manufacturer_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						manufacturer_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string manufacturer = 6;</code>
				 * @param value The manufacturer to set.
				 * @return This builder for chaining.
				 */
				public Builder setManufacturer(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000020;
					manufacturer_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string manufacturer = 6;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearManufacturer() {
					bitField0_ = (bitField0_ & ~0x00000020);
					manufacturer_ = getDefaultInstance().getManufacturer();
					onChanged();
					return this;
				}
				/**
				 * <code>string manufacturer = 6;</code>
				 * @param value The bytes for manufacturer to set.
				 * @return This builder for chaining.
				 */
				public Builder setManufacturerBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000020;
					manufacturer_ = value;
					onChanged();
					return this;
				}

				private java.lang.Object device_ = "";
				/**
				 * <code>string device = 7;</code>
				 * @return Whether the device field is set.
				 */
				public boolean hasDevice() {
					return ((bitField0_ & 0x00000040) != 0);
				}
				/**
				 * <code>string device = 7;</code>
				 * @return The device.
				 */
				public java.lang.String getDevice() {
					java.lang.Object ref = device_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						device_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string device = 7;</code>
				 * @return The bytes for device.
				 */
				public com.google.protobuf.ByteString
				getDeviceBytes() {
					java.lang.Object ref = device_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						device_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string device = 7;</code>
				 * @param value The device to set.
				 * @return This builder for chaining.
				 */
				public Builder setDevice(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000040;
					device_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string device = 7;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearDevice() {
					bitField0_ = (bitField0_ & ~0x00000040);
					device_ = getDefaultInstance().getDevice();
					onChanged();
					return this;
				}
				/**
				 * <code>string device = 7;</code>
				 * @param value The bytes for device to set.
				 * @return This builder for chaining.
				 */
				public Builder setDeviceBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000040;
					device_ = value;
					onChanged();
					return this;
				}

				private java.lang.Object osBuildNumber_ = "";
				/**
				 * <code>string os_build_number = 8;</code>
				 * @return Whether the osBuildNumber field is set.
				 */
				public boolean hasOsBuildNumber() {
					return ((bitField0_ & 0x00000080) != 0);
				}
				/**
				 * <code>string os_build_number = 8;</code>
				 * @return The osBuildNumber.
				 */
				public java.lang.String getOsBuildNumber() {
					java.lang.Object ref = osBuildNumber_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						osBuildNumber_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string os_build_number = 8;</code>
				 * @return The bytes for osBuildNumber.
				 */
				public com.google.protobuf.ByteString
				getOsBuildNumberBytes() {
					java.lang.Object ref = osBuildNumber_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						osBuildNumber_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string os_build_number = 8;</code>
				 * @param value The osBuildNumber to set.
				 * @return This builder for chaining.
				 */
				public Builder setOsBuildNumber(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000080;
					osBuildNumber_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string os_build_number = 8;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearOsBuildNumber() {
					bitField0_ = (bitField0_ & ~0x00000080);
					osBuildNumber_ = getDefaultInstance().getOsBuildNumber();
					onChanged();
					return this;
				}
				/**
				 * <code>string os_build_number = 8;</code>
				 * @param value The bytes for osBuildNumber to set.
				 * @return This builder for chaining.
				 */
				public Builder setOsBuildNumberBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000080;
					osBuildNumber_ = value;
					onChanged();
					return this;
				}

				private java.lang.Object phoneId_ = "";
				/**
				 * <code>string phone_id = 9;</code>
				 * @return Whether the phoneId field is set.
				 */
				public boolean hasPhoneId() {
					return ((bitField0_ & 0x00000100) != 0);
				}
				/**
				 * <code>string phone_id = 9;</code>
				 * @return The phoneId.
				 */
				public java.lang.String getPhoneId() {
					java.lang.Object ref = phoneId_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						phoneId_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string phone_id = 9;</code>
				 * @return The bytes for phoneId.
				 */
				public com.google.protobuf.ByteString
				getPhoneIdBytes() {
					java.lang.Object ref = phoneId_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						phoneId_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string phone_id = 9;</code>
				 * @param value The phoneId to set.
				 * @return This builder for chaining.
				 */
				public Builder setPhoneId(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000100;
					phoneId_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string phone_id = 9;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearPhoneId() {
					bitField0_ = (bitField0_ & ~0x00000100);
					phoneId_ = getDefaultInstance().getPhoneId();
					onChanged();
					return this;
				}
				/**
				 * <code>string phone_id = 9;</code>
				 * @param value The bytes for phoneId to set.
				 * @return This builder for chaining.
				 */
				public Builder setPhoneIdBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000100;
					phoneId_ = value;
					onChanged();
					return this;
				}

				private int releaseChannel_ = 0;
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
				 * @return Whether the releaseChannel field is set.
				 */
				@java.lang.Override public boolean hasReleaseChannel() {
					return ((bitField0_ & 0x00000200) != 0);
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
				 * @return The enum numeric value on the wire for releaseChannel.
				 */
				@java.lang.Override public int getReleaseChannelValue() {
					return releaseChannel_;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
				 * @param value The enum numeric value on the wire for releaseChannel to set.
				 * @return This builder for chaining.
				 */
				public Builder setReleaseChannelValue(int value) {
					bitField0_ |= 0x00000200;
					releaseChannel_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
				 * @return The releaseChannel.
				 */
				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel getReleaseChannel() {
					@SuppressWarnings("deprecation")
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel result = com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel.valueOf(releaseChannel_);
					return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel.UNRECOGNIZED : result;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
				 * @param value The releaseChannel to set.
				 * @return This builder for chaining.
				 */
				public Builder setReleaseChannel(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.ReleaseChannel value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000200;
					releaseChannel_ = value.getNumber();
					onChanged();
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.UserAgent.ReleaseChannel release_channel = 10;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearReleaseChannel() {
					bitField0_ = (bitField0_ & ~0x00000200);
					releaseChannel_ = 0;
					onChanged();
					return this;
				}

				private java.lang.Object localeLanguageIso6391_ = "";
				/**
				 * <code>string locale_language_iso_639_1 = 11;</code>
				 * @return Whether the localeLanguageIso6391 field is set.
				 */
				public boolean hasLocaleLanguageIso6391() {
					return ((bitField0_ & 0x00000400) != 0);
				}
				/**
				 * <code>string locale_language_iso_639_1 = 11;</code>
				 * @return The localeLanguageIso6391.
				 */
				public java.lang.String getLocaleLanguageIso6391() {
					java.lang.Object ref = localeLanguageIso6391_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						localeLanguageIso6391_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string locale_language_iso_639_1 = 11;</code>
				 * @return The bytes for localeLanguageIso6391.
				 */
				public com.google.protobuf.ByteString
				getLocaleLanguageIso6391Bytes() {
					java.lang.Object ref = localeLanguageIso6391_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						localeLanguageIso6391_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string locale_language_iso_639_1 = 11;</code>
				 * @param value The localeLanguageIso6391 to set.
				 * @return This builder for chaining.
				 */
				public Builder setLocaleLanguageIso6391(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000400;
					localeLanguageIso6391_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string locale_language_iso_639_1 = 11;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearLocaleLanguageIso6391() {
					bitField0_ = (bitField0_ & ~0x00000400);
					localeLanguageIso6391_ = getDefaultInstance().getLocaleLanguageIso6391();
					onChanged();
					return this;
				}
				/**
				 * <code>string locale_language_iso_639_1 = 11;</code>
				 * @param value The bytes for localeLanguageIso6391 to set.
				 * @return This builder for chaining.
				 */
				public Builder setLocaleLanguageIso6391Bytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000400;
					localeLanguageIso6391_ = value;
					onChanged();
					return this;
				}

				private java.lang.Object localCountryIso31661Alpha2_ = "";
				/**
				 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
				 * @return Whether the localCountryIso31661Alpha2 field is set.
				 */
				public boolean hasLocalCountryIso31661Alpha2() {
					return ((bitField0_ & 0x00000800) != 0);
				}
				/**
				 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
				 * @return The localCountryIso31661Alpha2.
				 */
				public java.lang.String getLocalCountryIso31661Alpha2() {
					java.lang.Object ref = localCountryIso31661Alpha2_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						localCountryIso31661Alpha2_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
				 * @return The bytes for localCountryIso31661Alpha2.
				 */
				public com.google.protobuf.ByteString
				getLocalCountryIso31661Alpha2Bytes() {
					java.lang.Object ref = localCountryIso31661Alpha2_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						localCountryIso31661Alpha2_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
				 * @param value The localCountryIso31661Alpha2 to set.
				 * @return This builder for chaining.
				 */
				public Builder setLocalCountryIso31661Alpha2(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000800;
					localCountryIso31661Alpha2_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearLocalCountryIso31661Alpha2() {
					bitField0_ = (bitField0_ & ~0x00000800);
					localCountryIso31661Alpha2_ = getDefaultInstance().getLocalCountryIso31661Alpha2();
					onChanged();
					return this;
				}
				/**
				 * <code>string local_country_iso_3166_1_alpha_2 = 12;</code>
				 * @param value The bytes for localCountryIso31661Alpha2 to set.
				 * @return This builder for chaining.
				 */
				public Builder setLocalCountryIso31661Alpha2Bytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000800;
					localCountryIso31661Alpha2_ = value;
					onChanged();
					return this;
				}

				private java.lang.Object deviceBoard_ = "";
				/**
				 * <code>string device_board = 13;</code>
				 * @return Whether the deviceBoard field is set.
				 */
				public boolean hasDeviceBoard() {
					return ((bitField0_ & 0x00001000) != 0);
				}
				/**
				 * <code>string device_board = 13;</code>
				 * @return The deviceBoard.
				 */
				public java.lang.String getDeviceBoard() {
					java.lang.Object ref = deviceBoard_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						deviceBoard_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string device_board = 13;</code>
				 * @return The bytes for deviceBoard.
				 */
				public com.google.protobuf.ByteString
				getDeviceBoardBytes() {
					java.lang.Object ref = deviceBoard_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						deviceBoard_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string device_board = 13;</code>
				 * @param value The deviceBoard to set.
				 * @return This builder for chaining.
				 */
				public Builder setDeviceBoard(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00001000;
					deviceBoard_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string device_board = 13;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearDeviceBoard() {
					bitField0_ = (bitField0_ & ~0x00001000);
					deviceBoard_ = getDefaultInstance().getDeviceBoard();
					onChanged();
					return this;
				}
				/**
				 * <code>string device_board = 13;</code>
				 * @param value The bytes for deviceBoard to set.
				 * @return This builder for chaining.
				 */
				public Builder setDeviceBoardBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00001000;
					deviceBoard_ = value;
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


				// @@protoc_insertion_point(builder_scope:whatsapp.ClientPayload.UserAgent)
			}

			// @@protoc_insertion_point(class_scope:whatsapp.ClientPayload.UserAgent)
			private static final com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent DEFAULT_INSTANCE;
			static {
				DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent();
			}

			public static com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent getDefaultInstance() {
				return DEFAULT_INSTANCE;
			}

			private static final com.google.protobuf.Parser<UserAgent>
					PARSER = new com.google.protobuf.AbstractParser<UserAgent>() {
				@java.lang.Override
				public UserAgent parsePartialFrom(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return new UserAgent(input, extensionRegistry);
				}
			};

			public static com.google.protobuf.Parser<UserAgent> parser() {
				return PARSER;
			}

			@java.lang.Override
			public com.google.protobuf.Parser<UserAgent> getParserForType() {
				return PARSER;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent getDefaultInstanceForType() {
				return DEFAULT_INSTANCE;
			}

		}

		public interface WebInfoOrBuilder extends
				// @@protoc_insertion_point(interface_extends:whatsapp.ClientPayload.WebInfo)
				com.google.protobuf.MessageOrBuilder {

			/**
			 * <code>string ref_token = 1;</code>
			 * @return Whether the refToken field is set.
			 */
			boolean hasRefToken();
			/**
			 * <code>string ref_token = 1;</code>
			 * @return The refToken.
			 */
			java.lang.String getRefToken();
			/**
			 * <code>string ref_token = 1;</code>
			 * @return The bytes for refToken.
			 */
			com.google.protobuf.ByteString
			getRefTokenBytes();

			/**
			 * <code>string version = 2;</code>
			 * @return Whether the version field is set.
			 */
			boolean hasVersion();
			/**
			 * <code>string version = 2;</code>
			 * @return The version.
			 */
			java.lang.String getVersion();
			/**
			 * <code>string version = 2;</code>
			 * @return The bytes for version.
			 */
			com.google.protobuf.ByteString
			getVersionBytes();

			/**
			 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
			 * @return Whether the webdPayload field is set.
			 */
			boolean hasWebdPayload();
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
			 * @return The webdPayload.
			 */
			com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload getWebdPayload();
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
			 */
			com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayloadOrBuilder getWebdPayloadOrBuilder();
		}
		/**
		 * Protobuf type {@code whatsapp.ClientPayload.WebInfo}
		 */
		public static final class WebInfo extends
				com.google.protobuf.GeneratedMessageV3 implements
				// @@protoc_insertion_point(message_implements:whatsapp.ClientPayload.WebInfo)
				WebInfoOrBuilder {
			private static final long serialVersionUID = 0L;
			// Use WebInfo.newBuilder() to construct.
			private WebInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
				super(builder);
			}
			private WebInfo() {
				refToken_ = "";
				version_ = "";
			}

			@java.lang.Override
			@SuppressWarnings({"unused"})
			protected java.lang.Object newInstance(
					UnusedPrivateParameter unused) {
				return new WebInfo();
			}

			@java.lang.Override
			public final com.google.protobuf.UnknownFieldSet
			getUnknownFields() {
				return this.unknownFields;
			}
			private WebInfo(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				this();
				if (extensionRegistry == null) {
					throw new java.lang.NullPointerException();
				}
				int mutable_bitField0_ = 0;
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
								bitField0_ |= 0x00000001;
								refToken_ = s;
								break;
							}
							case 18: {
								java.lang.String s = input.readStringRequireUtf8();
								bitField0_ |= 0x00000002;
								version_ = s;
								break;
							}
							case 26: {
								com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.Builder subBuilder = null;
								if (((bitField0_ & 0x00000004) != 0)) {
									subBuilder = webdPayload_.toBuilder();
								}
								webdPayload_ = input.readMessage(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.parser(), extensionRegistry);
								if (subBuilder != null) {
									subBuilder.mergeFrom(webdPayload_);
									webdPayload_ = subBuilder.buildPartial();
								}
								bitField0_ |= 0x00000004;
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
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.class, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.Builder.class);
			}

			/**
			 * Protobuf enum {@code whatsapp.ClientPayload.WebInfo.ReleaseChannel}
			 */
			public enum ReleaseChannel
					implements com.google.protobuf.ProtocolMessageEnum {
				/**
				 * <code>RELEASE = 0;</code>
				 */
				RELEASE(0),
				/**
				 * <code>BETA = 1;</code>
				 */
				BETA(1),
				/**
				 * <code>ALPHA = 2;</code>
				 */
				ALPHA(2),
				/**
				 * <code>DEBUG = 3;</code>
				 */
				DEBUG(3),
				UNRECOGNIZED(-1),
				;

				/**
				 * <code>RELEASE = 0;</code>
				 */
				public static final int RELEASE_VALUE = 0;
				/**
				 * <code>BETA = 1;</code>
				 */
				public static final int BETA_VALUE = 1;
				/**
				 * <code>ALPHA = 2;</code>
				 */
				public static final int ALPHA_VALUE = 2;
				/**
				 * <code>DEBUG = 3;</code>
				 */
				public static final int DEBUG_VALUE = 3;


				public final int getNumber() {
					if (this == UNRECOGNIZED) {
						throw new java.lang.IllegalArgumentException(
								"Can't get the number of an unknown enum value.");
					}
					return value;
				}

				/**
				 * @param value The numeric wire value of the corresponding enum entry.
				 * @return The enum associated with the given numeric wire value.
				 * @deprecated Use {@link #forNumber(int)} instead.
				 */
				@java.lang.Deprecated
				public static ReleaseChannel valueOf(int value) {
					return forNumber(value);
				}

				/**
				 * @param value The numeric wire value of the corresponding enum entry.
				 * @return The enum associated with the given numeric wire value.
				 */
				public static ReleaseChannel forNumber(int value) {
					switch (value) {
						case 0: return RELEASE;
						case 1: return BETA;
						case 2: return ALPHA;
						case 3: return DEBUG;
						default: return null;
					}
				}

				public static com.google.protobuf.Internal.EnumLiteMap<ReleaseChannel>
				internalGetValueMap() {
					return internalValueMap;
				}
				private static final com.google.protobuf.Internal.EnumLiteMap<
						ReleaseChannel> internalValueMap =
						new com.google.protobuf.Internal.EnumLiteMap<ReleaseChannel>() {
							public ReleaseChannel findValueByNumber(int number) {
								return ReleaseChannel.forNumber(number);
							}
						};

				public final com.google.protobuf.Descriptors.EnumValueDescriptor
				getValueDescriptor() {
					if (this == UNRECOGNIZED) {
						throw new java.lang.IllegalStateException(
								"Can't get the descriptor of an unrecognized enum value.");
					}
					return getDescriptor().getValues().get(ordinal());
				}
				public final com.google.protobuf.Descriptors.EnumDescriptor
				getDescriptorForType() {
					return getDescriptor();
				}
				public static final com.google.protobuf.Descriptors.EnumDescriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.getDescriptor().getEnumTypes().get(0);
				}

				private static final ReleaseChannel[] VALUES = values();

				public static ReleaseChannel valueOf(
						com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
					if (desc.getType() != getDescriptor()) {
						throw new java.lang.IllegalArgumentException(
								"EnumValueDescriptor is not for this type.");
					}
					if (desc.getIndex() == -1) {
						return UNRECOGNIZED;
					}
					return VALUES[desc.getIndex()];
				}

				private final int value;

				private ReleaseChannel(int value) {
					this.value = value;
				}

				// @@protoc_insertion_point(enum_scope:whatsapp.ClientPayload.WebInfo.ReleaseChannel)
			}

			public interface WebdPayloadOrBuilder extends
					// @@protoc_insertion_point(interface_extends:whatsapp.ClientPayload.WebInfo.WebdPayload)
					com.google.protobuf.MessageOrBuilder {

				/**
				 * <code>bool uses_participant_in_key = 1;</code>
				 * @return Whether the usesParticipantInKey field is set.
				 */
				boolean hasUsesParticipantInKey();
				/**
				 * <code>bool uses_participant_in_key = 1;</code>
				 * @return The usesParticipantInKey.
				 */
				boolean getUsesParticipantInKey();

				/**
				 * <code>bool supports_starred_messages = 2 [deprecated = true];</code>
				 * @return Whether the supportsStarredMessages field is set.
				 */
				@java.lang.Deprecated boolean hasSupportsStarredMessages();
				/**
				 * <code>bool supports_starred_messages = 2 [deprecated = true];</code>
				 * @return The supportsStarredMessages.
				 */
				@java.lang.Deprecated boolean getSupportsStarredMessages();

				/**
				 * <code>bool supports_document_messages = 3 [deprecated = true];</code>
				 * @return Whether the supportsDocumentMessages field is set.
				 */
				@java.lang.Deprecated boolean hasSupportsDocumentMessages();
				/**
				 * <code>bool supports_document_messages = 3 [deprecated = true];</code>
				 * @return The supportsDocumentMessages.
				 */
				@java.lang.Deprecated boolean getSupportsDocumentMessages();

				/**
				 * <code>bool supports_url_messages = 4 [deprecated = true];</code>
				 * @return Whether the supportsUrlMessages field is set.
				 */
				@java.lang.Deprecated boolean hasSupportsUrlMessages();
				/**
				 * <code>bool supports_url_messages = 4 [deprecated = true];</code>
				 * @return The supportsUrlMessages.
				 */
				@java.lang.Deprecated boolean getSupportsUrlMessages();

				/**
				 * <code>bool supports_media_retry = 5 [deprecated = true];</code>
				 * @return Whether the supportsMediaRetry field is set.
				 */
				@java.lang.Deprecated boolean hasSupportsMediaRetry();
				/**
				 * <code>bool supports_media_retry = 5 [deprecated = true];</code>
				 * @return The supportsMediaRetry.
				 */
				@java.lang.Deprecated boolean getSupportsMediaRetry();

				/**
				 * <code>bool supports_e2e_image = 6 [deprecated = true];</code>
				 * @return Whether the supportsE2eImage field is set.
				 */
				@java.lang.Deprecated boolean hasSupportsE2EImage();
				/**
				 * <code>bool supports_e2e_image = 6 [deprecated = true];</code>
				 * @return The supportsE2eImage.
				 */
				@java.lang.Deprecated boolean getSupportsE2EImage();

				/**
				 * <code>bool supports_e2e_video = 7 [deprecated = true];</code>
				 * @return Whether the supportsE2eVideo field is set.
				 */
				@java.lang.Deprecated boolean hasSupportsE2EVideo();
				/**
				 * <code>bool supports_e2e_video = 7 [deprecated = true];</code>
				 * @return The supportsE2eVideo.
				 */
				@java.lang.Deprecated boolean getSupportsE2EVideo();

				/**
				 * <code>bool supports_e2e_audio = 8 [deprecated = true];</code>
				 * @return Whether the supportsE2eAudio field is set.
				 */
				@java.lang.Deprecated boolean hasSupportsE2EAudio();
				/**
				 * <code>bool supports_e2e_audio = 8 [deprecated = true];</code>
				 * @return The supportsE2eAudio.
				 */
				@java.lang.Deprecated boolean getSupportsE2EAudio();

				/**
				 * <code>bool supports_e2e_document = 9 [deprecated = true];</code>
				 * @return Whether the supportsE2eDocument field is set.
				 */
				@java.lang.Deprecated boolean hasSupportsE2EDocument();
				/**
				 * <code>bool supports_e2e_document = 9 [deprecated = true];</code>
				 * @return The supportsE2eDocument.
				 */
				@java.lang.Deprecated boolean getSupportsE2EDocument();

				/**
				 * <code>string document_types = 10 [deprecated = true];</code>
				 * @return Whether the documentTypes field is set.
				 */
				@java.lang.Deprecated boolean hasDocumentTypes();
				/**
				 * <code>string document_types = 10 [deprecated = true];</code>
				 * @return The documentTypes.
				 */
				@java.lang.Deprecated java.lang.String getDocumentTypes();
				/**
				 * <code>string document_types = 10 [deprecated = true];</code>
				 * @return The bytes for documentTypes.
				 */
				@java.lang.Deprecated com.google.protobuf.ByteString
				getDocumentTypesBytes();

				/**
				 * <code>bytes features = 11;</code>
				 * @return Whether the features field is set.
				 */
				boolean hasFeatures();
				/**
				 * <code>bytes features = 11;</code>
				 * @return The features.
				 */
				com.google.protobuf.ByteString getFeatures();
			}
			/**
			 * Protobuf type {@code whatsapp.ClientPayload.WebInfo.WebdPayload}
			 */
			public static final class WebdPayload extends
					com.google.protobuf.GeneratedMessageV3 implements
					// @@protoc_insertion_point(message_implements:whatsapp.ClientPayload.WebInfo.WebdPayload)
					WebdPayloadOrBuilder {
				private static final long serialVersionUID = 0L;
				// Use WebdPayload.newBuilder() to construct.
				private WebdPayload(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
					super(builder);
				}
				private WebdPayload() {
					documentTypes_ = "";
					features_ = com.google.protobuf.ByteString.EMPTY;
				}

				@java.lang.Override
				@SuppressWarnings({"unused"})
				protected java.lang.Object newInstance(
						UnusedPrivateParameter unused) {
					return new WebdPayload();
				}

				@java.lang.Override
				public final com.google.protobuf.UnknownFieldSet
				getUnknownFields() {
					return this.unknownFields;
				}
				private WebdPayload(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					this();
					if (extensionRegistry == null) {
						throw new java.lang.NullPointerException();
					}
					int mutable_bitField0_ = 0;
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
								case 8: {
									bitField0_ |= 0x00000001;
									usesParticipantInKey_ = input.readBool();
									break;
								}
								case 16: {
									bitField0_ |= 0x00000002;
									supportsStarredMessages_ = input.readBool();
									break;
								}
								case 24: {
									bitField0_ |= 0x00000004;
									supportsDocumentMessages_ = input.readBool();
									break;
								}
								case 32: {
									bitField0_ |= 0x00000008;
									supportsUrlMessages_ = input.readBool();
									break;
								}
								case 40: {
									bitField0_ |= 0x00000010;
									supportsMediaRetry_ = input.readBool();
									break;
								}
								case 48: {
									bitField0_ |= 0x00000020;
									supportsE2EImage_ = input.readBool();
									break;
								}
								case 56: {
									bitField0_ |= 0x00000040;
									supportsE2EVideo_ = input.readBool();
									break;
								}
								case 64: {
									bitField0_ |= 0x00000080;
									supportsE2EAudio_ = input.readBool();
									break;
								}
								case 72: {
									bitField0_ |= 0x00000100;
									supportsE2EDocument_ = input.readBool();
									break;
								}
								case 82: {
									java.lang.String s = input.readStringRequireUtf8();
									bitField0_ |= 0x00000200;
									documentTypes_ = s;
									break;
								}
								case 90: {
									bitField0_ |= 0x00000400;
									features_ = input.readBytes();
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
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.class, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.Builder.class);
				}

				private int bitField0_;
				public static final int USES_PARTICIPANT_IN_KEY_FIELD_NUMBER = 1;
				private boolean usesParticipantInKey_;
				/**
				 * <code>bool uses_participant_in_key = 1;</code>
				 * @return Whether the usesParticipantInKey field is set.
				 */
				@java.lang.Override
				public boolean hasUsesParticipantInKey() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>bool uses_participant_in_key = 1;</code>
				 * @return The usesParticipantInKey.
				 */
				@java.lang.Override
				public boolean getUsesParticipantInKey() {
					return usesParticipantInKey_;
				}

				public static final int SUPPORTS_STARRED_MESSAGES_FIELD_NUMBER = 2;
				private boolean supportsStarredMessages_;
				/**
				 * <code>bool supports_starred_messages = 2 [deprecated = true];</code>
				 * @return Whether the supportsStarredMessages field is set.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean hasSupportsStarredMessages() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>bool supports_starred_messages = 2 [deprecated = true];</code>
				 * @return The supportsStarredMessages.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean getSupportsStarredMessages() {
					return supportsStarredMessages_;
				}

				public static final int SUPPORTS_DOCUMENT_MESSAGES_FIELD_NUMBER = 3;
				private boolean supportsDocumentMessages_;
				/**
				 * <code>bool supports_document_messages = 3 [deprecated = true];</code>
				 * @return Whether the supportsDocumentMessages field is set.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean hasSupportsDocumentMessages() {
					return ((bitField0_ & 0x00000004) != 0);
				}
				/**
				 * <code>bool supports_document_messages = 3 [deprecated = true];</code>
				 * @return The supportsDocumentMessages.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean getSupportsDocumentMessages() {
					return supportsDocumentMessages_;
				}

				public static final int SUPPORTS_URL_MESSAGES_FIELD_NUMBER = 4;
				private boolean supportsUrlMessages_;
				/**
				 * <code>bool supports_url_messages = 4 [deprecated = true];</code>
				 * @return Whether the supportsUrlMessages field is set.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean hasSupportsUrlMessages() {
					return ((bitField0_ & 0x00000008) != 0);
				}
				/**
				 * <code>bool supports_url_messages = 4 [deprecated = true];</code>
				 * @return The supportsUrlMessages.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean getSupportsUrlMessages() {
					return supportsUrlMessages_;
				}

				public static final int SUPPORTS_MEDIA_RETRY_FIELD_NUMBER = 5;
				private boolean supportsMediaRetry_;
				/**
				 * <code>bool supports_media_retry = 5 [deprecated = true];</code>
				 * @return Whether the supportsMediaRetry field is set.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean hasSupportsMediaRetry() {
					return ((bitField0_ & 0x00000010) != 0);
				}
				/**
				 * <code>bool supports_media_retry = 5 [deprecated = true];</code>
				 * @return The supportsMediaRetry.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean getSupportsMediaRetry() {
					return supportsMediaRetry_;
				}

				public static final int SUPPORTS_E2E_IMAGE_FIELD_NUMBER = 6;
				private boolean supportsE2EImage_;
				/**
				 * <code>bool supports_e2e_image = 6 [deprecated = true];</code>
				 * @return Whether the supportsE2eImage field is set.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean hasSupportsE2EImage() {
					return ((bitField0_ & 0x00000020) != 0);
				}
				/**
				 * <code>bool supports_e2e_image = 6 [deprecated = true];</code>
				 * @return The supportsE2eImage.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean getSupportsE2EImage() {
					return supportsE2EImage_;
				}

				public static final int SUPPORTS_E2E_VIDEO_FIELD_NUMBER = 7;
				private boolean supportsE2EVideo_;
				/**
				 * <code>bool supports_e2e_video = 7 [deprecated = true];</code>
				 * @return Whether the supportsE2eVideo field is set.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean hasSupportsE2EVideo() {
					return ((bitField0_ & 0x00000040) != 0);
				}
				/**
				 * <code>bool supports_e2e_video = 7 [deprecated = true];</code>
				 * @return The supportsE2eVideo.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean getSupportsE2EVideo() {
					return supportsE2EVideo_;
				}

				public static final int SUPPORTS_E2E_AUDIO_FIELD_NUMBER = 8;
				private boolean supportsE2EAudio_;
				/**
				 * <code>bool supports_e2e_audio = 8 [deprecated = true];</code>
				 * @return Whether the supportsE2eAudio field is set.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean hasSupportsE2EAudio() {
					return ((bitField0_ & 0x00000080) != 0);
				}
				/**
				 * <code>bool supports_e2e_audio = 8 [deprecated = true];</code>
				 * @return The supportsE2eAudio.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean getSupportsE2EAudio() {
					return supportsE2EAudio_;
				}

				public static final int SUPPORTS_E2E_DOCUMENT_FIELD_NUMBER = 9;
				private boolean supportsE2EDocument_;
				/**
				 * <code>bool supports_e2e_document = 9 [deprecated = true];</code>
				 * @return Whether the supportsE2eDocument field is set.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean hasSupportsE2EDocument() {
					return ((bitField0_ & 0x00000100) != 0);
				}
				/**
				 * <code>bool supports_e2e_document = 9 [deprecated = true];</code>
				 * @return The supportsE2eDocument.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean getSupportsE2EDocument() {
					return supportsE2EDocument_;
				}

				public static final int DOCUMENT_TYPES_FIELD_NUMBER = 10;
				private volatile java.lang.Object documentTypes_;
				/**
				 * <code>string document_types = 10 [deprecated = true];</code>
				 * @return Whether the documentTypes field is set.
				 */
				@java.lang.Override
				@java.lang.Deprecated public boolean hasDocumentTypes() {
					return ((bitField0_ & 0x00000200) != 0);
				}
				/**
				 * <code>string document_types = 10 [deprecated = true];</code>
				 * @return The documentTypes.
				 */
				@java.lang.Override
				@java.lang.Deprecated public java.lang.String getDocumentTypes() {
					java.lang.Object ref = documentTypes_;
					if (ref instanceof java.lang.String) {
						return (java.lang.String) ref;
					} else {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						documentTypes_ = s;
						return s;
					}
				}
				/**
				 * <code>string document_types = 10 [deprecated = true];</code>
				 * @return The bytes for documentTypes.
				 */
				@java.lang.Override
				@java.lang.Deprecated public com.google.protobuf.ByteString
				getDocumentTypesBytes() {
					java.lang.Object ref = documentTypes_;
					if (ref instanceof java.lang.String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						documentTypes_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}

				public static final int FEATURES_FIELD_NUMBER = 11;
				private com.google.protobuf.ByteString features_;
				/**
				 * <code>bytes features = 11;</code>
				 * @return Whether the features field is set.
				 */
				@java.lang.Override
				public boolean hasFeatures() {
					return ((bitField0_ & 0x00000400) != 0);
				}
				/**
				 * <code>bytes features = 11;</code>
				 * @return The features.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getFeatures() {
					return features_;
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
					if (((bitField0_ & 0x00000001) != 0)) {
						output.writeBool(1, usesParticipantInKey_);
					}
					if (((bitField0_ & 0x00000002) != 0)) {
						output.writeBool(2, supportsStarredMessages_);
					}
					if (((bitField0_ & 0x00000004) != 0)) {
						output.writeBool(3, supportsDocumentMessages_);
					}
					if (((bitField0_ & 0x00000008) != 0)) {
						output.writeBool(4, supportsUrlMessages_);
					}
					if (((bitField0_ & 0x00000010) != 0)) {
						output.writeBool(5, supportsMediaRetry_);
					}
					if (((bitField0_ & 0x00000020) != 0)) {
						output.writeBool(6, supportsE2EImage_);
					}
					if (((bitField0_ & 0x00000040) != 0)) {
						output.writeBool(7, supportsE2EVideo_);
					}
					if (((bitField0_ & 0x00000080) != 0)) {
						output.writeBool(8, supportsE2EAudio_);
					}
					if (((bitField0_ & 0x00000100) != 0)) {
						output.writeBool(9, supportsE2EDocument_);
					}
					if (((bitField0_ & 0x00000200) != 0)) {
						com.google.protobuf.GeneratedMessageV3.writeString(output, 10, documentTypes_);
					}
					if (((bitField0_ & 0x00000400) != 0)) {
						output.writeBytes(11, features_);
					}
					unknownFields.writeTo(output);
				}

				@java.lang.Override
				public int getSerializedSize() {
					int size = memoizedSize;
					if (size != -1) return size;

					size = 0;
					if (((bitField0_ & 0x00000001) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBoolSize(1, usesParticipantInKey_);
					}
					if (((bitField0_ & 0x00000002) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBoolSize(2, supportsStarredMessages_);
					}
					if (((bitField0_ & 0x00000004) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBoolSize(3, supportsDocumentMessages_);
					}
					if (((bitField0_ & 0x00000008) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBoolSize(4, supportsUrlMessages_);
					}
					if (((bitField0_ & 0x00000010) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBoolSize(5, supportsMediaRetry_);
					}
					if (((bitField0_ & 0x00000020) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBoolSize(6, supportsE2EImage_);
					}
					if (((bitField0_ & 0x00000040) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBoolSize(7, supportsE2EVideo_);
					}
					if (((bitField0_ & 0x00000080) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBoolSize(8, supportsE2EAudio_);
					}
					if (((bitField0_ & 0x00000100) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBoolSize(9, supportsE2EDocument_);
					}
					if (((bitField0_ & 0x00000200) != 0)) {
						size += com.google.protobuf.GeneratedMessageV3.computeStringSize(10, documentTypes_);
					}
					if (((bitField0_ & 0x00000400) != 0)) {
						size += com.google.protobuf.CodedOutputStream
								.computeBytesSize(11, features_);
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
					if (!(obj instanceof com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload)) {
						return super.equals(obj);
					}
					com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload other = (com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload) obj;

					if (hasUsesParticipantInKey() != other.hasUsesParticipantInKey()) return false;
					if (hasUsesParticipantInKey()) {
						if (getUsesParticipantInKey()
								!= other.getUsesParticipantInKey()) return false;
					}
					if (hasSupportsStarredMessages() != other.hasSupportsStarredMessages()) return false;
					if (hasSupportsStarredMessages()) {
						if (getSupportsStarredMessages()
								!= other.getSupportsStarredMessages()) return false;
					}
					if (hasSupportsDocumentMessages() != other.hasSupportsDocumentMessages()) return false;
					if (hasSupportsDocumentMessages()) {
						if (getSupportsDocumentMessages()
								!= other.getSupportsDocumentMessages()) return false;
					}
					if (hasSupportsUrlMessages() != other.hasSupportsUrlMessages()) return false;
					if (hasSupportsUrlMessages()) {
						if (getSupportsUrlMessages()
								!= other.getSupportsUrlMessages()) return false;
					}
					if (hasSupportsMediaRetry() != other.hasSupportsMediaRetry()) return false;
					if (hasSupportsMediaRetry()) {
						if (getSupportsMediaRetry()
								!= other.getSupportsMediaRetry()) return false;
					}
					if (hasSupportsE2EImage() != other.hasSupportsE2EImage()) return false;
					if (hasSupportsE2EImage()) {
						if (getSupportsE2EImage()
								!= other.getSupportsE2EImage()) return false;
					}
					if (hasSupportsE2EVideo() != other.hasSupportsE2EVideo()) return false;
					if (hasSupportsE2EVideo()) {
						if (getSupportsE2EVideo()
								!= other.getSupportsE2EVideo()) return false;
					}
					if (hasSupportsE2EAudio() != other.hasSupportsE2EAudio()) return false;
					if (hasSupportsE2EAudio()) {
						if (getSupportsE2EAudio()
								!= other.getSupportsE2EAudio()) return false;
					}
					if (hasSupportsE2EDocument() != other.hasSupportsE2EDocument()) return false;
					if (hasSupportsE2EDocument()) {
						if (getSupportsE2EDocument()
								!= other.getSupportsE2EDocument()) return false;
					}
					if (hasDocumentTypes() != other.hasDocumentTypes()) return false;
					if (hasDocumentTypes()) {
						if (!getDocumentTypes()
								.equals(other.getDocumentTypes())) return false;
					}
					if (hasFeatures() != other.hasFeatures()) return false;
					if (hasFeatures()) {
						if (!getFeatures()
								.equals(other.getFeatures())) return false;
					}
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
					if (hasUsesParticipantInKey()) {
						hash = (37 * hash) + USES_PARTICIPANT_IN_KEY_FIELD_NUMBER;
						hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
								getUsesParticipantInKey());
					}
					if (hasSupportsStarredMessages()) {
						hash = (37 * hash) + SUPPORTS_STARRED_MESSAGES_FIELD_NUMBER;
						hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
								getSupportsStarredMessages());
					}
					if (hasSupportsDocumentMessages()) {
						hash = (37 * hash) + SUPPORTS_DOCUMENT_MESSAGES_FIELD_NUMBER;
						hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
								getSupportsDocumentMessages());
					}
					if (hasSupportsUrlMessages()) {
						hash = (37 * hash) + SUPPORTS_URL_MESSAGES_FIELD_NUMBER;
						hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
								getSupportsUrlMessages());
					}
					if (hasSupportsMediaRetry()) {
						hash = (37 * hash) + SUPPORTS_MEDIA_RETRY_FIELD_NUMBER;
						hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
								getSupportsMediaRetry());
					}
					if (hasSupportsE2EImage()) {
						hash = (37 * hash) + SUPPORTS_E2E_IMAGE_FIELD_NUMBER;
						hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
								getSupportsE2EImage());
					}
					if (hasSupportsE2EVideo()) {
						hash = (37 * hash) + SUPPORTS_E2E_VIDEO_FIELD_NUMBER;
						hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
								getSupportsE2EVideo());
					}
					if (hasSupportsE2EAudio()) {
						hash = (37 * hash) + SUPPORTS_E2E_AUDIO_FIELD_NUMBER;
						hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
								getSupportsE2EAudio());
					}
					if (hasSupportsE2EDocument()) {
						hash = (37 * hash) + SUPPORTS_E2E_DOCUMENT_FIELD_NUMBER;
						hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
								getSupportsE2EDocument());
					}
					if (hasDocumentTypes()) {
						hash = (37 * hash) + DOCUMENT_TYPES_FIELD_NUMBER;
						hash = (53 * hash) + getDocumentTypes().hashCode();
					}
					if (hasFeatures()) {
						hash = (37 * hash) + FEATURES_FIELD_NUMBER;
						hash = (53 * hash) + getFeatures().hashCode();
					}
					hash = (29 * hash) + unknownFields.hashCode();
					memoizedHashCode = hash;
					return hash;
				}

				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(
						java.nio.ByteBuffer data)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(
						java.nio.ByteBuffer data,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(
						com.google.protobuf.ByteString data)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(
						com.google.protobuf.ByteString data,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(byte[] data)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(
						byte[] data,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return PARSER.parseFrom(data, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(java.io.InputStream input)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseWithIOException(PARSER, input);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(
						java.io.InputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseWithIOException(PARSER, input, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseDelimitedFrom(java.io.InputStream input)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseDelimitedWithIOException(PARSER, input);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseDelimitedFrom(
						java.io.InputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(
						com.google.protobuf.CodedInputStream input)
						throws java.io.IOException {
					return com.google.protobuf.GeneratedMessageV3
							.parseWithIOException(PARSER, input);
				}
				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parseFrom(
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
				public static Builder newBuilder(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload prototype) {
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
				 * Protobuf type {@code whatsapp.ClientPayload.WebInfo.WebdPayload}
				 */
				public static final class Builder extends
						com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
						// @@protoc_insertion_point(builder_implements:whatsapp.ClientPayload.WebInfo.WebdPayload)
						com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayloadOrBuilder {
					public static final com.google.protobuf.Descriptors.Descriptor
					getDescriptor() {
						return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_descriptor;
					}

					@java.lang.Override
					protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
					internalGetFieldAccessorTable() {
						return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_fieldAccessorTable
								.ensureFieldAccessorsInitialized(
										com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.class, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.Builder.class);
					}

					// Construct using com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.newBuilder()
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
						usesParticipantInKey_ = false;
						bitField0_ = (bitField0_ & ~0x00000001);
						supportsStarredMessages_ = false;
						bitField0_ = (bitField0_ & ~0x00000002);
						supportsDocumentMessages_ = false;
						bitField0_ = (bitField0_ & ~0x00000004);
						supportsUrlMessages_ = false;
						bitField0_ = (bitField0_ & ~0x00000008);
						supportsMediaRetry_ = false;
						bitField0_ = (bitField0_ & ~0x00000010);
						supportsE2EImage_ = false;
						bitField0_ = (bitField0_ & ~0x00000020);
						supportsE2EVideo_ = false;
						bitField0_ = (bitField0_ & ~0x00000040);
						supportsE2EAudio_ = false;
						bitField0_ = (bitField0_ & ~0x00000080);
						supportsE2EDocument_ = false;
						bitField0_ = (bitField0_ & ~0x00000100);
						documentTypes_ = "";
						bitField0_ = (bitField0_ & ~0x00000200);
						features_ = com.google.protobuf.ByteString.EMPTY;
						bitField0_ = (bitField0_ & ~0x00000400);
						return this;
					}

					@java.lang.Override
					public com.google.protobuf.Descriptors.Descriptor
					getDescriptorForType() {
						return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_descriptor;
					}

					@java.lang.Override
					public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload getDefaultInstanceForType() {
						return com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.getDefaultInstance();
					}

					@java.lang.Override
					public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload build() {
						com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload result = buildPartial();
						if (!result.isInitialized()) {
							throw newUninitializedMessageException(result);
						}
						return result;
					}

					@java.lang.Override
					public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload buildPartial() {
						com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload result = new com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload(this);
						int from_bitField0_ = bitField0_;
						int to_bitField0_ = 0;
						if (((from_bitField0_ & 0x00000001) != 0)) {
							result.usesParticipantInKey_ = usesParticipantInKey_;
							to_bitField0_ |= 0x00000001;
						}
						if (((from_bitField0_ & 0x00000002) != 0)) {
							result.supportsStarredMessages_ = supportsStarredMessages_;
							to_bitField0_ |= 0x00000002;
						}
						if (((from_bitField0_ & 0x00000004) != 0)) {
							result.supportsDocumentMessages_ = supportsDocumentMessages_;
							to_bitField0_ |= 0x00000004;
						}
						if (((from_bitField0_ & 0x00000008) != 0)) {
							result.supportsUrlMessages_ = supportsUrlMessages_;
							to_bitField0_ |= 0x00000008;
						}
						if (((from_bitField0_ & 0x00000010) != 0)) {
							result.supportsMediaRetry_ = supportsMediaRetry_;
							to_bitField0_ |= 0x00000010;
						}
						if (((from_bitField0_ & 0x00000020) != 0)) {
							result.supportsE2EImage_ = supportsE2EImage_;
							to_bitField0_ |= 0x00000020;
						}
						if (((from_bitField0_ & 0x00000040) != 0)) {
							result.supportsE2EVideo_ = supportsE2EVideo_;
							to_bitField0_ |= 0x00000040;
						}
						if (((from_bitField0_ & 0x00000080) != 0)) {
							result.supportsE2EAudio_ = supportsE2EAudio_;
							to_bitField0_ |= 0x00000080;
						}
						if (((from_bitField0_ & 0x00000100) != 0)) {
							result.supportsE2EDocument_ = supportsE2EDocument_;
							to_bitField0_ |= 0x00000100;
						}
						if (((from_bitField0_ & 0x00000200) != 0)) {
							to_bitField0_ |= 0x00000200;
						}
						result.documentTypes_ = documentTypes_;
						if (((from_bitField0_ & 0x00000400) != 0)) {
							to_bitField0_ |= 0x00000400;
						}
						result.features_ = features_;
						result.bitField0_ = to_bitField0_;
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
						if (other instanceof com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload) {
							return mergeFrom((com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload)other);
						} else {
							super.mergeFrom(other);
							return this;
						}
					}

					public Builder mergeFrom(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload other) {
						if (other == com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.getDefaultInstance()) return this;
						if (other.hasUsesParticipantInKey()) {
							setUsesParticipantInKey(other.getUsesParticipantInKey());
						}
						if (other.hasSupportsStarredMessages()) {
							setSupportsStarredMessages(other.getSupportsStarredMessages());
						}
						if (other.hasSupportsDocumentMessages()) {
							setSupportsDocumentMessages(other.getSupportsDocumentMessages());
						}
						if (other.hasSupportsUrlMessages()) {
							setSupportsUrlMessages(other.getSupportsUrlMessages());
						}
						if (other.hasSupportsMediaRetry()) {
							setSupportsMediaRetry(other.getSupportsMediaRetry());
						}
						if (other.hasSupportsE2EImage()) {
							setSupportsE2EImage(other.getSupportsE2EImage());
						}
						if (other.hasSupportsE2EVideo()) {
							setSupportsE2EVideo(other.getSupportsE2EVideo());
						}
						if (other.hasSupportsE2EAudio()) {
							setSupportsE2EAudio(other.getSupportsE2EAudio());
						}
						if (other.hasSupportsE2EDocument()) {
							setSupportsE2EDocument(other.getSupportsE2EDocument());
						}
						if (other.hasDocumentTypes()) {
							bitField0_ |= 0x00000200;
							documentTypes_ = other.documentTypes_;
							onChanged();
						}
						if (other.hasFeatures()) {
							setFeatures(other.getFeatures());
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
						com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload parsedMessage = null;
						try {
							parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
						} catch (com.google.protobuf.InvalidProtocolBufferException e) {
							parsedMessage = (com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload) e.getUnfinishedMessage();
							throw e.unwrapIOException();
						} finally {
							if (parsedMessage != null) {
								mergeFrom(parsedMessage);
							}
						}
						return this;
					}
					private int bitField0_;

					private boolean usesParticipantInKey_ ;
					/**
					 * <code>bool uses_participant_in_key = 1;</code>
					 * @return Whether the usesParticipantInKey field is set.
					 */
					@java.lang.Override
					public boolean hasUsesParticipantInKey() {
						return ((bitField0_ & 0x00000001) != 0);
					}
					/**
					 * <code>bool uses_participant_in_key = 1;</code>
					 * @return The usesParticipantInKey.
					 */
					@java.lang.Override
					public boolean getUsesParticipantInKey() {
						return usesParticipantInKey_;
					}
					/**
					 * <code>bool uses_participant_in_key = 1;</code>
					 * @param value The usesParticipantInKey to set.
					 * @return This builder for chaining.
					 */
					public Builder setUsesParticipantInKey(boolean value) {
						bitField0_ |= 0x00000001;
						usesParticipantInKey_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bool uses_participant_in_key = 1;</code>
					 * @return This builder for chaining.
					 */
					public Builder clearUsesParticipantInKey() {
						bitField0_ = (bitField0_ & ~0x00000001);
						usesParticipantInKey_ = false;
						onChanged();
						return this;
					}

					private boolean supportsStarredMessages_ ;
					/**
					 * <code>bool supports_starred_messages = 2 [deprecated = true];</code>
					 * @return Whether the supportsStarredMessages field is set.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean hasSupportsStarredMessages() {
						return ((bitField0_ & 0x00000002) != 0);
					}
					/**
					 * <code>bool supports_starred_messages = 2 [deprecated = true];</code>
					 * @return The supportsStarredMessages.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean getSupportsStarredMessages() {
						return supportsStarredMessages_;
					}
					/**
					 * <code>bool supports_starred_messages = 2 [deprecated = true];</code>
					 * @param value The supportsStarredMessages to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setSupportsStarredMessages(boolean value) {
						bitField0_ |= 0x00000002;
						supportsStarredMessages_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bool supports_starred_messages = 2 [deprecated = true];</code>
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder clearSupportsStarredMessages() {
						bitField0_ = (bitField0_ & ~0x00000002);
						supportsStarredMessages_ = false;
						onChanged();
						return this;
					}

					private boolean supportsDocumentMessages_ ;
					/**
					 * <code>bool supports_document_messages = 3 [deprecated = true];</code>
					 * @return Whether the supportsDocumentMessages field is set.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean hasSupportsDocumentMessages() {
						return ((bitField0_ & 0x00000004) != 0);
					}
					/**
					 * <code>bool supports_document_messages = 3 [deprecated = true];</code>
					 * @return The supportsDocumentMessages.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean getSupportsDocumentMessages() {
						return supportsDocumentMessages_;
					}
					/**
					 * <code>bool supports_document_messages = 3 [deprecated = true];</code>
					 * @param value The supportsDocumentMessages to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setSupportsDocumentMessages(boolean value) {
						bitField0_ |= 0x00000004;
						supportsDocumentMessages_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bool supports_document_messages = 3 [deprecated = true];</code>
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder clearSupportsDocumentMessages() {
						bitField0_ = (bitField0_ & ~0x00000004);
						supportsDocumentMessages_ = false;
						onChanged();
						return this;
					}

					private boolean supportsUrlMessages_ ;
					/**
					 * <code>bool supports_url_messages = 4 [deprecated = true];</code>
					 * @return Whether the supportsUrlMessages field is set.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean hasSupportsUrlMessages() {
						return ((bitField0_ & 0x00000008) != 0);
					}
					/**
					 * <code>bool supports_url_messages = 4 [deprecated = true];</code>
					 * @return The supportsUrlMessages.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean getSupportsUrlMessages() {
						return supportsUrlMessages_;
					}
					/**
					 * <code>bool supports_url_messages = 4 [deprecated = true];</code>
					 * @param value The supportsUrlMessages to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setSupportsUrlMessages(boolean value) {
						bitField0_ |= 0x00000008;
						supportsUrlMessages_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bool supports_url_messages = 4 [deprecated = true];</code>
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder clearSupportsUrlMessages() {
						bitField0_ = (bitField0_ & ~0x00000008);
						supportsUrlMessages_ = false;
						onChanged();
						return this;
					}

					private boolean supportsMediaRetry_ ;
					/**
					 * <code>bool supports_media_retry = 5 [deprecated = true];</code>
					 * @return Whether the supportsMediaRetry field is set.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean hasSupportsMediaRetry() {
						return ((bitField0_ & 0x00000010) != 0);
					}
					/**
					 * <code>bool supports_media_retry = 5 [deprecated = true];</code>
					 * @return The supportsMediaRetry.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean getSupportsMediaRetry() {
						return supportsMediaRetry_;
					}
					/**
					 * <code>bool supports_media_retry = 5 [deprecated = true];</code>
					 * @param value The supportsMediaRetry to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setSupportsMediaRetry(boolean value) {
						bitField0_ |= 0x00000010;
						supportsMediaRetry_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bool supports_media_retry = 5 [deprecated = true];</code>
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder clearSupportsMediaRetry() {
						bitField0_ = (bitField0_ & ~0x00000010);
						supportsMediaRetry_ = false;
						onChanged();
						return this;
					}

					private boolean supportsE2EImage_ ;
					/**
					 * <code>bool supports_e2e_image = 6 [deprecated = true];</code>
					 * @return Whether the supportsE2eImage field is set.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean hasSupportsE2EImage() {
						return ((bitField0_ & 0x00000020) != 0);
					}
					/**
					 * <code>bool supports_e2e_image = 6 [deprecated = true];</code>
					 * @return The supportsE2eImage.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean getSupportsE2EImage() {
						return supportsE2EImage_;
					}
					/**
					 * <code>bool supports_e2e_image = 6 [deprecated = true];</code>
					 * @param value The supportsE2eImage to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setSupportsE2EImage(boolean value) {
						bitField0_ |= 0x00000020;
						supportsE2EImage_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bool supports_e2e_image = 6 [deprecated = true];</code>
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder clearSupportsE2EImage() {
						bitField0_ = (bitField0_ & ~0x00000020);
						supportsE2EImage_ = false;
						onChanged();
						return this;
					}

					private boolean supportsE2EVideo_ ;
					/**
					 * <code>bool supports_e2e_video = 7 [deprecated = true];</code>
					 * @return Whether the supportsE2eVideo field is set.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean hasSupportsE2EVideo() {
						return ((bitField0_ & 0x00000040) != 0);
					}
					/**
					 * <code>bool supports_e2e_video = 7 [deprecated = true];</code>
					 * @return The supportsE2eVideo.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean getSupportsE2EVideo() {
						return supportsE2EVideo_;
					}
					/**
					 * <code>bool supports_e2e_video = 7 [deprecated = true];</code>
					 * @param value The supportsE2eVideo to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setSupportsE2EVideo(boolean value) {
						bitField0_ |= 0x00000040;
						supportsE2EVideo_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bool supports_e2e_video = 7 [deprecated = true];</code>
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder clearSupportsE2EVideo() {
						bitField0_ = (bitField0_ & ~0x00000040);
						supportsE2EVideo_ = false;
						onChanged();
						return this;
					}

					private boolean supportsE2EAudio_ ;
					/**
					 * <code>bool supports_e2e_audio = 8 [deprecated = true];</code>
					 * @return Whether the supportsE2eAudio field is set.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean hasSupportsE2EAudio() {
						return ((bitField0_ & 0x00000080) != 0);
					}
					/**
					 * <code>bool supports_e2e_audio = 8 [deprecated = true];</code>
					 * @return The supportsE2eAudio.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean getSupportsE2EAudio() {
						return supportsE2EAudio_;
					}
					/**
					 * <code>bool supports_e2e_audio = 8 [deprecated = true];</code>
					 * @param value The supportsE2eAudio to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setSupportsE2EAudio(boolean value) {
						bitField0_ |= 0x00000080;
						supportsE2EAudio_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bool supports_e2e_audio = 8 [deprecated = true];</code>
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder clearSupportsE2EAudio() {
						bitField0_ = (bitField0_ & ~0x00000080);
						supportsE2EAudio_ = false;
						onChanged();
						return this;
					}

					private boolean supportsE2EDocument_ ;
					/**
					 * <code>bool supports_e2e_document = 9 [deprecated = true];</code>
					 * @return Whether the supportsE2eDocument field is set.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean hasSupportsE2EDocument() {
						return ((bitField0_ & 0x00000100) != 0);
					}
					/**
					 * <code>bool supports_e2e_document = 9 [deprecated = true];</code>
					 * @return The supportsE2eDocument.
					 */
					@java.lang.Override
					@java.lang.Deprecated public boolean getSupportsE2EDocument() {
						return supportsE2EDocument_;
					}
					/**
					 * <code>bool supports_e2e_document = 9 [deprecated = true];</code>
					 * @param value The supportsE2eDocument to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setSupportsE2EDocument(boolean value) {
						bitField0_ |= 0x00000100;
						supportsE2EDocument_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bool supports_e2e_document = 9 [deprecated = true];</code>
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder clearSupportsE2EDocument() {
						bitField0_ = (bitField0_ & ~0x00000100);
						supportsE2EDocument_ = false;
						onChanged();
						return this;
					}

					private java.lang.Object documentTypes_ = "";
					/**
					 * <code>string document_types = 10 [deprecated = true];</code>
					 * @return Whether the documentTypes field is set.
					 */
					@java.lang.Deprecated public boolean hasDocumentTypes() {
						return ((bitField0_ & 0x00000200) != 0);
					}
					/**
					 * <code>string document_types = 10 [deprecated = true];</code>
					 * @return The documentTypes.
					 */
					@java.lang.Deprecated public java.lang.String getDocumentTypes() {
						java.lang.Object ref = documentTypes_;
						if (!(ref instanceof java.lang.String)) {
							com.google.protobuf.ByteString bs =
									(com.google.protobuf.ByteString) ref;
							java.lang.String s = bs.toStringUtf8();
							documentTypes_ = s;
							return s;
						} else {
							return (java.lang.String) ref;
						}
					}
					/**
					 * <code>string document_types = 10 [deprecated = true];</code>
					 * @return The bytes for documentTypes.
					 */
					@java.lang.Deprecated public com.google.protobuf.ByteString
					getDocumentTypesBytes() {
						java.lang.Object ref = documentTypes_;
						if (ref instanceof String) {
							com.google.protobuf.ByteString b =
									com.google.protobuf.ByteString.copyFromUtf8(
											(java.lang.String) ref);
							documentTypes_ = b;
							return b;
						} else {
							return (com.google.protobuf.ByteString) ref;
						}
					}
					/**
					 * <code>string document_types = 10 [deprecated = true];</code>
					 * @param value The documentTypes to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setDocumentTypes(
							java.lang.String value) {
						if (value == null) {
							throw new NullPointerException();
						}
						bitField0_ |= 0x00000200;
						documentTypes_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>string document_types = 10 [deprecated = true];</code>
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder clearDocumentTypes() {
						bitField0_ = (bitField0_ & ~0x00000200);
						documentTypes_ = getDefaultInstance().getDocumentTypes();
						onChanged();
						return this;
					}
					/**
					 * <code>string document_types = 10 [deprecated = true];</code>
					 * @param value The bytes for documentTypes to set.
					 * @return This builder for chaining.
					 */
					@java.lang.Deprecated public Builder setDocumentTypesBytes(
							com.google.protobuf.ByteString value) {
						if (value == null) {
							throw new NullPointerException();
						}
						checkByteStringIsUtf8(value);
						bitField0_ |= 0x00000200;
						documentTypes_ = value;
						onChanged();
						return this;
					}

					private com.google.protobuf.ByteString features_ = com.google.protobuf.ByteString.EMPTY;
					/**
					 * <code>bytes features = 11;</code>
					 * @return Whether the features field is set.
					 */
					@java.lang.Override
					public boolean hasFeatures() {
						return ((bitField0_ & 0x00000400) != 0);
					}
					/**
					 * <code>bytes features = 11;</code>
					 * @return The features.
					 */
					@java.lang.Override
					public com.google.protobuf.ByteString getFeatures() {
						return features_;
					}
					/**
					 * <code>bytes features = 11;</code>
					 * @param value The features to set.
					 * @return This builder for chaining.
					 */
					public Builder setFeatures(com.google.protobuf.ByteString value) {
						if (value == null) {
							throw new NullPointerException();
						}
						bitField0_ |= 0x00000400;
						features_ = value;
						onChanged();
						return this;
					}
					/**
					 * <code>bytes features = 11;</code>
					 * @return This builder for chaining.
					 */
					public Builder clearFeatures() {
						bitField0_ = (bitField0_ & ~0x00000400);
						features_ = getDefaultInstance().getFeatures();
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


					// @@protoc_insertion_point(builder_scope:whatsapp.ClientPayload.WebInfo.WebdPayload)
				}

				// @@protoc_insertion_point(class_scope:whatsapp.ClientPayload.WebInfo.WebdPayload)
				private static final com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload DEFAULT_INSTANCE;
				static {
					DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload();
				}

				public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload getDefaultInstance() {
					return DEFAULT_INSTANCE;
				}

				private static final com.google.protobuf.Parser<WebdPayload>
						PARSER = new com.google.protobuf.AbstractParser<WebdPayload>() {
					@java.lang.Override
					public WebdPayload parsePartialFrom(
							com.google.protobuf.CodedInputStream input,
							com.google.protobuf.ExtensionRegistryLite extensionRegistry)
							throws com.google.protobuf.InvalidProtocolBufferException {
						return new WebdPayload(input, extensionRegistry);
					}
				};

				public static com.google.protobuf.Parser<WebdPayload> parser() {
					return PARSER;
				}

				@java.lang.Override
				public com.google.protobuf.Parser<WebdPayload> getParserForType() {
					return PARSER;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload getDefaultInstanceForType() {
					return DEFAULT_INSTANCE;
				}

			}

			private int bitField0_;
			public static final int REF_TOKEN_FIELD_NUMBER = 1;
			private volatile java.lang.Object refToken_;
			/**
			 * <code>string ref_token = 1;</code>
			 * @return Whether the refToken field is set.
			 */
			@java.lang.Override
			public boolean hasRefToken() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>string ref_token = 1;</code>
			 * @return The refToken.
			 */
			@java.lang.Override
			public java.lang.String getRefToken() {
				java.lang.Object ref = refToken_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					refToken_ = s;
					return s;
				}
			}
			/**
			 * <code>string ref_token = 1;</code>
			 * @return The bytes for refToken.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getRefTokenBytes() {
				java.lang.Object ref = refToken_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					refToken_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int VERSION_FIELD_NUMBER = 2;
			private volatile java.lang.Object version_;
			/**
			 * <code>string version = 2;</code>
			 * @return Whether the version field is set.
			 */
			@java.lang.Override
			public boolean hasVersion() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>string version = 2;</code>
			 * @return The version.
			 */
			@java.lang.Override
			public java.lang.String getVersion() {
				java.lang.Object ref = version_;
				if (ref instanceof java.lang.String) {
					return (java.lang.String) ref;
				} else {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					version_ = s;
					return s;
				}
			}
			/**
			 * <code>string version = 2;</code>
			 * @return The bytes for version.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString
			getVersionBytes() {
				java.lang.Object ref = version_;
				if (ref instanceof java.lang.String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					version_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}

			public static final int WEBD_PAYLOAD_FIELD_NUMBER = 3;
			private com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload webdPayload_;
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
			 * @return Whether the webdPayload field is set.
			 */
			@java.lang.Override
			public boolean hasWebdPayload() {
				return ((bitField0_ & 0x00000004) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
			 * @return The webdPayload.
			 */
			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload getWebdPayload() {
				return webdPayload_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.getDefaultInstance() : webdPayload_;
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
			 */
			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayloadOrBuilder getWebdPayloadOrBuilder() {
				return webdPayload_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.getDefaultInstance() : webdPayload_;
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
				if (((bitField0_ & 0x00000001) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 1, refToken_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					com.google.protobuf.GeneratedMessageV3.writeString(output, 2, version_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					output.writeMessage(3, getWebdPayload());
				}
				unknownFields.writeTo(output);
			}

			@java.lang.Override
			public int getSerializedSize() {
				int size = memoizedSize;
				if (size != -1) return size;

				size = 0;
				if (((bitField0_ & 0x00000001) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, refToken_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, version_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeMessageSize(3, getWebdPayload());
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
				if (!(obj instanceof com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo)) {
					return super.equals(obj);
				}
				com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo other = (com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo) obj;

				if (hasRefToken() != other.hasRefToken()) return false;
				if (hasRefToken()) {
					if (!getRefToken()
							.equals(other.getRefToken())) return false;
				}
				if (hasVersion() != other.hasVersion()) return false;
				if (hasVersion()) {
					if (!getVersion()
							.equals(other.getVersion())) return false;
				}
				if (hasWebdPayload() != other.hasWebdPayload()) return false;
				if (hasWebdPayload()) {
					if (!getWebdPayload()
							.equals(other.getWebdPayload())) return false;
				}
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
				if (hasRefToken()) {
					hash = (37 * hash) + REF_TOKEN_FIELD_NUMBER;
					hash = (53 * hash) + getRefToken().hashCode();
				}
				if (hasVersion()) {
					hash = (37 * hash) + VERSION_FIELD_NUMBER;
					hash = (53 * hash) + getVersion().hashCode();
				}
				if (hasWebdPayload()) {
					hash = (37 * hash) + WEBD_PAYLOAD_FIELD_NUMBER;
					hash = (53 * hash) + getWebdPayload().hashCode();
				}
				hash = (29 * hash) + unknownFields.hashCode();
				memoizedHashCode = hash;
				return hash;
			}

			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(
					java.nio.ByteBuffer data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(
					java.nio.ByteBuffer data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(
					com.google.protobuf.ByteString data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(
					com.google.protobuf.ByteString data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(byte[] data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(
					byte[] data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseDelimitedFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseDelimitedFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(
					com.google.protobuf.CodedInputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parseFrom(
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
			public static Builder newBuilder(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo prototype) {
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
			 * Protobuf type {@code whatsapp.ClientPayload.WebInfo}
			 */
			public static final class Builder extends
					com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
					// @@protoc_insertion_point(builder_implements:whatsapp.ClientPayload.WebInfo)
					com.whatsapp.proto.WA4Protos.ClientPayload.WebInfoOrBuilder {
				public static final com.google.protobuf.Descriptors.Descriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.class, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.Builder.class);
				}

				// Construct using com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.newBuilder()
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
						getWebdPayloadFieldBuilder();
					}
				}
				@java.lang.Override
				public Builder clear() {
					super.clear();
					refToken_ = "";
					bitField0_ = (bitField0_ & ~0x00000001);
					version_ = "";
					bitField0_ = (bitField0_ & ~0x00000002);
					if (webdPayloadBuilder_ == null) {
						webdPayload_ = null;
					} else {
						webdPayloadBuilder_.clear();
					}
					bitField0_ = (bitField0_ & ~0x00000004);
					return this;
				}

				@java.lang.Override
				public com.google.protobuf.Descriptors.Descriptor
				getDescriptorForType() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_WebInfo_descriptor;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo getDefaultInstanceForType() {
					return com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.getDefaultInstance();
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo build() {
					com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo result = buildPartial();
					if (!result.isInitialized()) {
						throw newUninitializedMessageException(result);
					}
					return result;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo buildPartial() {
					com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo result = new com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo(this);
					int from_bitField0_ = bitField0_;
					int to_bitField0_ = 0;
					if (((from_bitField0_ & 0x00000001) != 0)) {
						to_bitField0_ |= 0x00000001;
					}
					result.refToken_ = refToken_;
					if (((from_bitField0_ & 0x00000002) != 0)) {
						to_bitField0_ |= 0x00000002;
					}
					result.version_ = version_;
					if (((from_bitField0_ & 0x00000004) != 0)) {
						if (webdPayloadBuilder_ == null) {
							result.webdPayload_ = webdPayload_;
						} else {
							result.webdPayload_ = webdPayloadBuilder_.build();
						}
						to_bitField0_ |= 0x00000004;
					}
					result.bitField0_ = to_bitField0_;
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
					if (other instanceof com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo) {
						return mergeFrom((com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo)other);
					} else {
						super.mergeFrom(other);
						return this;
					}
				}

				public Builder mergeFrom(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo other) {
					if (other == com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.getDefaultInstance()) return this;
					if (other.hasRefToken()) {
						bitField0_ |= 0x00000001;
						refToken_ = other.refToken_;
						onChanged();
					}
					if (other.hasVersion()) {
						bitField0_ |= 0x00000002;
						version_ = other.version_;
						onChanged();
					}
					if (other.hasWebdPayload()) {
						mergeWebdPayload(other.getWebdPayload());
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
					com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo parsedMessage = null;
					try {
						parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
					} catch (com.google.protobuf.InvalidProtocolBufferException e) {
						parsedMessage = (com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo) e.getUnfinishedMessage();
						throw e.unwrapIOException();
					} finally {
						if (parsedMessage != null) {
							mergeFrom(parsedMessage);
						}
					}
					return this;
				}
				private int bitField0_;

				private java.lang.Object refToken_ = "";
				/**
				 * <code>string ref_token = 1;</code>
				 * @return Whether the refToken field is set.
				 */
				public boolean hasRefToken() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>string ref_token = 1;</code>
				 * @return The refToken.
				 */
				public java.lang.String getRefToken() {
					java.lang.Object ref = refToken_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						refToken_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string ref_token = 1;</code>
				 * @return The bytes for refToken.
				 */
				public com.google.protobuf.ByteString
				getRefTokenBytes() {
					java.lang.Object ref = refToken_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						refToken_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string ref_token = 1;</code>
				 * @param value The refToken to set.
				 * @return This builder for chaining.
				 */
				public Builder setRefToken(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000001;
					refToken_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string ref_token = 1;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearRefToken() {
					bitField0_ = (bitField0_ & ~0x00000001);
					refToken_ = getDefaultInstance().getRefToken();
					onChanged();
					return this;
				}
				/**
				 * <code>string ref_token = 1;</code>
				 * @param value The bytes for refToken to set.
				 * @return This builder for chaining.
				 */
				public Builder setRefTokenBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000001;
					refToken_ = value;
					onChanged();
					return this;
				}

				private java.lang.Object version_ = "";
				/**
				 * <code>string version = 2;</code>
				 * @return Whether the version field is set.
				 */
				public boolean hasVersion() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>string version = 2;</code>
				 * @return The version.
				 */
				public java.lang.String getVersion() {
					java.lang.Object ref = version_;
					if (!(ref instanceof java.lang.String)) {
						com.google.protobuf.ByteString bs =
								(com.google.protobuf.ByteString) ref;
						java.lang.String s = bs.toStringUtf8();
						version_ = s;
						return s;
					} else {
						return (java.lang.String) ref;
					}
				}
				/**
				 * <code>string version = 2;</code>
				 * @return The bytes for version.
				 */
				public com.google.protobuf.ByteString
				getVersionBytes() {
					java.lang.Object ref = version_;
					if (ref instanceof String) {
						com.google.protobuf.ByteString b =
								com.google.protobuf.ByteString.copyFromUtf8(
										(java.lang.String) ref);
						version_ = b;
						return b;
					} else {
						return (com.google.protobuf.ByteString) ref;
					}
				}
				/**
				 * <code>string version = 2;</code>
				 * @param value The version to set.
				 * @return This builder for chaining.
				 */
				public Builder setVersion(
						java.lang.String value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000002;
					version_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>string version = 2;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearVersion() {
					bitField0_ = (bitField0_ & ~0x00000002);
					version_ = getDefaultInstance().getVersion();
					onChanged();
					return this;
				}
				/**
				 * <code>string version = 2;</code>
				 * @param value The bytes for version to set.
				 * @return This builder for chaining.
				 */
				public Builder setVersionBytes(
						com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					checkByteStringIsUtf8(value);
					bitField0_ |= 0x00000002;
					version_ = value;
					onChanged();
					return this;
				}

				private com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload webdPayload_;
				private com.google.protobuf.SingleFieldBuilderV3<
						com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayloadOrBuilder> webdPayloadBuilder_;
				/**
				 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
				 * @return Whether the webdPayload field is set.
				 */
				public boolean hasWebdPayload() {
					return ((bitField0_ & 0x00000004) != 0);
				}
				/**
				 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
				 * @return The webdPayload.
				 */
				public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload getWebdPayload() {
					if (webdPayloadBuilder_ == null) {
						return webdPayload_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.getDefaultInstance() : webdPayload_;
					} else {
						return webdPayloadBuilder_.getMessage();
					}
				}
				/**
				 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
				 */
				public Builder setWebdPayload(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload value) {
					if (webdPayloadBuilder_ == null) {
						if (value == null) {
							throw new NullPointerException();
						}
						webdPayload_ = value;
						onChanged();
					} else {
						webdPayloadBuilder_.setMessage(value);
					}
					bitField0_ |= 0x00000004;
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
				 */
				public Builder setWebdPayload(
						com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.Builder builderForValue) {
					if (webdPayloadBuilder_ == null) {
						webdPayload_ = builderForValue.build();
						onChanged();
					} else {
						webdPayloadBuilder_.setMessage(builderForValue.build());
					}
					bitField0_ |= 0x00000004;
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
				 */
				public Builder mergeWebdPayload(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload value) {
					if (webdPayloadBuilder_ == null) {
						if (((bitField0_ & 0x00000004) != 0) &&
								webdPayload_ != null &&
								webdPayload_ != com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.getDefaultInstance()) {
							webdPayload_ =
									com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.newBuilder(webdPayload_).mergeFrom(value).buildPartial();
						} else {
							webdPayload_ = value;
						}
						onChanged();
					} else {
						webdPayloadBuilder_.mergeFrom(value);
					}
					bitField0_ |= 0x00000004;
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
				 */
				public Builder clearWebdPayload() {
					if (webdPayloadBuilder_ == null) {
						webdPayload_ = null;
						onChanged();
					} else {
						webdPayloadBuilder_.clear();
					}
					bitField0_ = (bitField0_ & ~0x00000004);
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
				 */
				public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.Builder getWebdPayloadBuilder() {
					bitField0_ |= 0x00000004;
					onChanged();
					return getWebdPayloadFieldBuilder().getBuilder();
				}
				/**
				 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
				 */
				public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayloadOrBuilder getWebdPayloadOrBuilder() {
					if (webdPayloadBuilder_ != null) {
						return webdPayloadBuilder_.getMessageOrBuilder();
					} else {
						return webdPayload_ == null ?
								com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.getDefaultInstance() : webdPayload_;
					}
				}
				/**
				 * <code>.whatsapp.ClientPayload.WebInfo.WebdPayload webd_payload = 3;</code>
				 */
				private com.google.protobuf.SingleFieldBuilderV3<
						com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayloadOrBuilder>
				getWebdPayloadFieldBuilder() {
					if (webdPayloadBuilder_ == null) {
						webdPayloadBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
								com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayload.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.WebdPayloadOrBuilder>(
								getWebdPayload(),
								getParentForChildren(),
								isClean());
						webdPayload_ = null;
					}
					return webdPayloadBuilder_;
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


				// @@protoc_insertion_point(builder_scope:whatsapp.ClientPayload.WebInfo)
			}

			// @@protoc_insertion_point(class_scope:whatsapp.ClientPayload.WebInfo)
			private static final com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo DEFAULT_INSTANCE;
			static {
				DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo();
			}

			public static com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo getDefaultInstance() {
				return DEFAULT_INSTANCE;
			}

			private static final com.google.protobuf.Parser<WebInfo>
					PARSER = new com.google.protobuf.AbstractParser<WebInfo>() {
				@java.lang.Override
				public WebInfo parsePartialFrom(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return new WebInfo(input, extensionRegistry);
				}
			};

			public static com.google.protobuf.Parser<WebInfo> parser() {
				return PARSER;
			}

			@java.lang.Override
			public com.google.protobuf.Parser<WebInfo> getParserForType() {
				return PARSER;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo getDefaultInstanceForType() {
				return DEFAULT_INSTANCE;
			}

		}

		public interface DNSSourceOrBuilder extends
				// @@protoc_insertion_point(interface_extends:whatsapp.ClientPayload.DNSSource)
				com.google.protobuf.MessageOrBuilder {

			/**
			 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
			 * @return Whether the dnsMethod field is set.
			 */
			boolean hasDnsMethod();
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
			 * @return The enum numeric value on the wire for dnsMethod.
			 */
			int getDnsMethodValue();
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
			 * @return The dnsMethod.
			 */
			com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod getDnsMethod();

			/**
			 * <code>bool app_cached = 16;</code>
			 * @return Whether the appCached field is set.
			 */
			boolean hasAppCached();
			/**
			 * <code>bool app_cached = 16;</code>
			 * @return The appCached.
			 */
			boolean getAppCached();
		}
		/**
		 * Protobuf type {@code whatsapp.ClientPayload.DNSSource}
		 */
		public static final class DNSSource extends
				com.google.protobuf.GeneratedMessageV3 implements
				// @@protoc_insertion_point(message_implements:whatsapp.ClientPayload.DNSSource)
				DNSSourceOrBuilder {
			private static final long serialVersionUID = 0L;
			// Use DNSSource.newBuilder() to construct.
			private DNSSource(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
				super(builder);
			}
			private DNSSource() {
				dnsMethod_ = 0;
			}

			@java.lang.Override
			@SuppressWarnings({"unused"})
			protected java.lang.Object newInstance(
					UnusedPrivateParameter unused) {
				return new DNSSource();
			}

			@java.lang.Override
			public final com.google.protobuf.UnknownFieldSet
			getUnknownFields() {
				return this.unknownFields;
			}
			private DNSSource(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				this();
				if (extensionRegistry == null) {
					throw new java.lang.NullPointerException();
				}
				int mutable_bitField0_ = 0;
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
							case 120: {
								int rawValue = input.readEnum();
								bitField0_ |= 0x00000001;
								dnsMethod_ = rawValue;
								break;
							}
							case 128: {
								bitField0_ |= 0x00000002;
								appCached_ = input.readBool();
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
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_DNSSource_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_DNSSource_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.class, com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.Builder.class);
			}

			/**
			 * Protobuf enum {@code whatsapp.ClientPayload.DNSSource.DNSResolutionMethod}
			 */
			public enum DNSResolutionMethod
					implements com.google.protobuf.ProtocolMessageEnum {
				/**
				 * <code>SYSTEM = 0;</code>
				 */
				SYSTEM(0),
				/**
				 * <code>GOOGLE = 1;</code>
				 */
				GOOGLE(1),
				/**
				 * <code>HARDCODED = 2;</code>
				 */
				HARDCODED(2),
				/**
				 * <code>OVERRIDE = 3;</code>
				 */
				OVERRIDE(3),
				/**
				 * <code>FALLBACK = 4;</code>
				 */
				FALLBACK(4),
				UNRECOGNIZED(-1),
				;

				/**
				 * <code>SYSTEM = 0;</code>
				 */
				public static final int SYSTEM_VALUE = 0;
				/**
				 * <code>GOOGLE = 1;</code>
				 */
				public static final int GOOGLE_VALUE = 1;
				/**
				 * <code>HARDCODED = 2;</code>
				 */
				public static final int HARDCODED_VALUE = 2;
				/**
				 * <code>OVERRIDE = 3;</code>
				 */
				public static final int OVERRIDE_VALUE = 3;
				/**
				 * <code>FALLBACK = 4;</code>
				 */
				public static final int FALLBACK_VALUE = 4;


				public final int getNumber() {
					if (this == UNRECOGNIZED) {
						throw new java.lang.IllegalArgumentException(
								"Can't get the number of an unknown enum value.");
					}
					return value;
				}

				/**
				 * @param value The numeric wire value of the corresponding enum entry.
				 * @return The enum associated with the given numeric wire value.
				 * @deprecated Use {@link #forNumber(int)} instead.
				 */
				@java.lang.Deprecated
				public static DNSResolutionMethod valueOf(int value) {
					return forNumber(value);
				}

				/**
				 * @param value The numeric wire value of the corresponding enum entry.
				 * @return The enum associated with the given numeric wire value.
				 */
				public static DNSResolutionMethod forNumber(int value) {
					switch (value) {
						case 0: return SYSTEM;
						case 1: return GOOGLE;
						case 2: return HARDCODED;
						case 3: return OVERRIDE;
						case 4: return FALLBACK;
						default: return null;
					}
				}

				public static com.google.protobuf.Internal.EnumLiteMap<DNSResolutionMethod>
				internalGetValueMap() {
					return internalValueMap;
				}
				private static final com.google.protobuf.Internal.EnumLiteMap<
						DNSResolutionMethod> internalValueMap =
						new com.google.protobuf.Internal.EnumLiteMap<DNSResolutionMethod>() {
							public DNSResolutionMethod findValueByNumber(int number) {
								return DNSResolutionMethod.forNumber(number);
							}
						};

				public final com.google.protobuf.Descriptors.EnumValueDescriptor
				getValueDescriptor() {
					if (this == UNRECOGNIZED) {
						throw new java.lang.IllegalStateException(
								"Can't get the descriptor of an unrecognized enum value.");
					}
					return getDescriptor().getValues().get(ordinal());
				}
				public final com.google.protobuf.Descriptors.EnumDescriptor
				getDescriptorForType() {
					return getDescriptor();
				}
				public static final com.google.protobuf.Descriptors.EnumDescriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.getDescriptor().getEnumTypes().get(0);
				}

				private static final DNSResolutionMethod[] VALUES = values();

				public static DNSResolutionMethod valueOf(
						com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
					if (desc.getType() != getDescriptor()) {
						throw new java.lang.IllegalArgumentException(
								"EnumValueDescriptor is not for this type.");
					}
					if (desc.getIndex() == -1) {
						return UNRECOGNIZED;
					}
					return VALUES[desc.getIndex()];
				}

				private final int value;

				private DNSResolutionMethod(int value) {
					this.value = value;
				}

				// @@protoc_insertion_point(enum_scope:whatsapp.ClientPayload.DNSSource.DNSResolutionMethod)
			}

			private int bitField0_;
			public static final int DNS_METHOD_FIELD_NUMBER = 15;
			private int dnsMethod_;
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
			 * @return Whether the dnsMethod field is set.
			 */
			@java.lang.Override public boolean hasDnsMethod() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
			 * @return The enum numeric value on the wire for dnsMethod.
			 */
			@java.lang.Override public int getDnsMethodValue() {
				return dnsMethod_;
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
			 * @return The dnsMethod.
			 */
			@java.lang.Override public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod getDnsMethod() {
				@SuppressWarnings("deprecation")
				com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod result = com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod.valueOf(dnsMethod_);
				return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod.UNRECOGNIZED : result;
			}

			public static final int APP_CACHED_FIELD_NUMBER = 16;
			private boolean appCached_;
			/**
			 * <code>bool app_cached = 16;</code>
			 * @return Whether the appCached field is set.
			 */
			@java.lang.Override
			public boolean hasAppCached() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>bool app_cached = 16;</code>
			 * @return The appCached.
			 */
			@java.lang.Override
			public boolean getAppCached() {
				return appCached_;
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
				if (((bitField0_ & 0x00000001) != 0)) {
					output.writeEnum(15, dnsMethod_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					output.writeBool(16, appCached_);
				}
				unknownFields.writeTo(output);
			}

			@java.lang.Override
			public int getSerializedSize() {
				int size = memoizedSize;
				if (size != -1) return size;

				size = 0;
				if (((bitField0_ & 0x00000001) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeEnumSize(15, dnsMethod_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBoolSize(16, appCached_);
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
				if (!(obj instanceof com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource)) {
					return super.equals(obj);
				}
				com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource other = (com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource) obj;

				if (hasDnsMethod() != other.hasDnsMethod()) return false;
				if (hasDnsMethod()) {
					if (dnsMethod_ != other.dnsMethod_) return false;
				}
				if (hasAppCached() != other.hasAppCached()) return false;
				if (hasAppCached()) {
					if (getAppCached()
							!= other.getAppCached()) return false;
				}
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
				if (hasDnsMethod()) {
					hash = (37 * hash) + DNS_METHOD_FIELD_NUMBER;
					hash = (53 * hash) + dnsMethod_;
				}
				if (hasAppCached()) {
					hash = (37 * hash) + APP_CACHED_FIELD_NUMBER;
					hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
							getAppCached());
				}
				hash = (29 * hash) + unknownFields.hashCode();
				memoizedHashCode = hash;
				return hash;
			}

			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(
					java.nio.ByteBuffer data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(
					java.nio.ByteBuffer data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(
					com.google.protobuf.ByteString data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(
					com.google.protobuf.ByteString data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(byte[] data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(
					byte[] data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseDelimitedFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseDelimitedFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(
					com.google.protobuf.CodedInputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parseFrom(
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
			public static Builder newBuilder(com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource prototype) {
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
			 * Protobuf type {@code whatsapp.ClientPayload.DNSSource}
			 */
			public static final class Builder extends
					com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
					// @@protoc_insertion_point(builder_implements:whatsapp.ClientPayload.DNSSource)
					com.whatsapp.proto.WA4Protos.ClientPayload.DNSSourceOrBuilder {
				public static final com.google.protobuf.Descriptors.Descriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_DNSSource_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_DNSSource_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.class, com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.Builder.class);
				}

				// Construct using com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.newBuilder()
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
					dnsMethod_ = 0;
					bitField0_ = (bitField0_ & ~0x00000001);
					appCached_ = false;
					bitField0_ = (bitField0_ & ~0x00000002);
					return this;
				}

				@java.lang.Override
				public com.google.protobuf.Descriptors.Descriptor
				getDescriptorForType() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_DNSSource_descriptor;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource getDefaultInstanceForType() {
					return com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.getDefaultInstance();
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource build() {
					com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource result = buildPartial();
					if (!result.isInitialized()) {
						throw newUninitializedMessageException(result);
					}
					return result;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource buildPartial() {
					com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource result = new com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource(this);
					int from_bitField0_ = bitField0_;
					int to_bitField0_ = 0;
					if (((from_bitField0_ & 0x00000001) != 0)) {
						to_bitField0_ |= 0x00000001;
					}
					result.dnsMethod_ = dnsMethod_;
					if (((from_bitField0_ & 0x00000002) != 0)) {
						result.appCached_ = appCached_;
						to_bitField0_ |= 0x00000002;
					}
					result.bitField0_ = to_bitField0_;
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
					if (other instanceof com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource) {
						return mergeFrom((com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource)other);
					} else {
						super.mergeFrom(other);
						return this;
					}
				}

				public Builder mergeFrom(com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource other) {
					if (other == com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.getDefaultInstance()) return this;
					if (other.hasDnsMethod()) {
						setDnsMethod(other.getDnsMethod());
					}
					if (other.hasAppCached()) {
						setAppCached(other.getAppCached());
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
					com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource parsedMessage = null;
					try {
						parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
					} catch (com.google.protobuf.InvalidProtocolBufferException e) {
						parsedMessage = (com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource) e.getUnfinishedMessage();
						throw e.unwrapIOException();
					} finally {
						if (parsedMessage != null) {
							mergeFrom(parsedMessage);
						}
					}
					return this;
				}
				private int bitField0_;

				private int dnsMethod_ = 0;
				/**
				 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
				 * @return Whether the dnsMethod field is set.
				 */
				@java.lang.Override public boolean hasDnsMethod() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
				 * @return The enum numeric value on the wire for dnsMethod.
				 */
				@java.lang.Override public int getDnsMethodValue() {
					return dnsMethod_;
				}
				/**
				 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
				 * @param value The enum numeric value on the wire for dnsMethod to set.
				 * @return This builder for chaining.
				 */
				public Builder setDnsMethodValue(int value) {
					bitField0_ |= 0x00000001;
					dnsMethod_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
				 * @return The dnsMethod.
				 */
				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod getDnsMethod() {
					@SuppressWarnings("deprecation")
					com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod result = com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod.valueOf(dnsMethod_);
					return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod.UNRECOGNIZED : result;
				}
				/**
				 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
				 * @param value The dnsMethod to set.
				 * @return This builder for chaining.
				 */
				public Builder setDnsMethod(com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.DNSResolutionMethod value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000001;
					dnsMethod_ = value.getNumber();
					onChanged();
					return this;
				}
				/**
				 * <code>.whatsapp.ClientPayload.DNSSource.DNSResolutionMethod dns_method = 15;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearDnsMethod() {
					bitField0_ = (bitField0_ & ~0x00000001);
					dnsMethod_ = 0;
					onChanged();
					return this;
				}

				private boolean appCached_ ;
				/**
				 * <code>bool app_cached = 16;</code>
				 * @return Whether the appCached field is set.
				 */
				@java.lang.Override
				public boolean hasAppCached() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>bool app_cached = 16;</code>
				 * @return The appCached.
				 */
				@java.lang.Override
				public boolean getAppCached() {
					return appCached_;
				}
				/**
				 * <code>bool app_cached = 16;</code>
				 * @param value The appCached to set.
				 * @return This builder for chaining.
				 */
				public Builder setAppCached(boolean value) {
					bitField0_ |= 0x00000002;
					appCached_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bool app_cached = 16;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearAppCached() {
					bitField0_ = (bitField0_ & ~0x00000002);
					appCached_ = false;
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


				// @@protoc_insertion_point(builder_scope:whatsapp.ClientPayload.DNSSource)
			}

			// @@protoc_insertion_point(class_scope:whatsapp.ClientPayload.DNSSource)
			private static final com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource DEFAULT_INSTANCE;
			static {
				DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource();
			}

			public static com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource getDefaultInstance() {
				return DEFAULT_INSTANCE;
			}

			private static final com.google.protobuf.Parser<DNSSource>
					PARSER = new com.google.protobuf.AbstractParser<DNSSource>() {
				@java.lang.Override
				public DNSSource parsePartialFrom(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return new DNSSource(input, extensionRegistry);
				}
			};

			public static com.google.protobuf.Parser<DNSSource> parser() {
				return PARSER;
			}

			@java.lang.Override
			public com.google.protobuf.Parser<DNSSource> getParserForType() {
				return PARSER;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource getDefaultInstanceForType() {
				return DEFAULT_INSTANCE;
			}

		}

		public interface CompanionRegDataOrBuilder extends
				// @@protoc_insertion_point(interface_extends:whatsapp.ClientPayload.CompanionRegData)
				com.google.protobuf.MessageOrBuilder {

			/**
			 * <code>bytes e_regid = 1;</code>
			 * @return Whether the eRegid field is set.
			 */
			boolean hasERegid();
			/**
			 * <code>bytes e_regid = 1;</code>
			 * @return The eRegid.
			 */
			com.google.protobuf.ByteString getERegid();

			/**
			 * <code>bytes e_keytype = 2;</code>
			 * @return Whether the eKeytype field is set.
			 */
			boolean hasEKeytype();
			/**
			 * <code>bytes e_keytype = 2;</code>
			 * @return The eKeytype.
			 */
			com.google.protobuf.ByteString getEKeytype();

			/**
			 * <code>bytes e_ident = 3;</code>
			 * @return Whether the eIdent field is set.
			 */
			boolean hasEIdent();
			/**
			 * <code>bytes e_ident = 3;</code>
			 * @return The eIdent.
			 */
			com.google.protobuf.ByteString getEIdent();

			/**
			 * <code>bytes e_skey_id = 4;</code>
			 * @return Whether the eSkeyId field is set.
			 */
			boolean hasESkeyId();
			/**
			 * <code>bytes e_skey_id = 4;</code>
			 * @return The eSkeyId.
			 */
			com.google.protobuf.ByteString getESkeyId();

			/**
			 * <code>bytes e_skey_val = 5;</code>
			 * @return Whether the eSkeyVal field is set.
			 */
			boolean hasESkeyVal();
			/**
			 * <code>bytes e_skey_val = 5;</code>
			 * @return The eSkeyVal.
			 */
			com.google.protobuf.ByteString getESkeyVal();

			/**
			 * <code>bytes e_skey_sig = 6;</code>
			 * @return Whether the eSkeySig field is set.
			 */
			boolean hasESkeySig();
			/**
			 * <code>bytes e_skey_sig = 6;</code>
			 * @return The eSkeySig.
			 */
			com.google.protobuf.ByteString getESkeySig();

			/**
			 * <code>bytes build_hash = 7;</code>
			 * @return Whether the buildHash field is set.
			 */
			boolean hasBuildHash();
			/**
			 * <code>bytes build_hash = 7;</code>
			 * @return The buildHash.
			 */
			com.google.protobuf.ByteString getBuildHash();

			/**
			 * <code>bytes companion_props = 8;</code>
			 * @return Whether the companionProps field is set.
			 */
			boolean hasCompanionProps();
			/**
			 * <code>bytes companion_props = 8;</code>
			 * @return The companionProps.
			 */
			com.google.protobuf.ByteString getCompanionProps();
		}
		/**
		 * Protobuf type {@code whatsapp.ClientPayload.CompanionRegData}
		 */
		public static final class CompanionRegData extends
				com.google.protobuf.GeneratedMessageV3 implements
				// @@protoc_insertion_point(message_implements:whatsapp.ClientPayload.CompanionRegData)
				CompanionRegDataOrBuilder {
			private static final long serialVersionUID = 0L;
			// Use CompanionRegData.newBuilder() to construct.
			private CompanionRegData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
				super(builder);
			}
			private CompanionRegData() {
				eRegid_ = com.google.protobuf.ByteString.EMPTY;
				eKeytype_ = com.google.protobuf.ByteString.EMPTY;
				eIdent_ = com.google.protobuf.ByteString.EMPTY;
				eSkeyId_ = com.google.protobuf.ByteString.EMPTY;
				eSkeyVal_ = com.google.protobuf.ByteString.EMPTY;
				eSkeySig_ = com.google.protobuf.ByteString.EMPTY;
				buildHash_ = com.google.protobuf.ByteString.EMPTY;
				companionProps_ = com.google.protobuf.ByteString.EMPTY;
			}

			@java.lang.Override
			@SuppressWarnings({"unused"})
			protected java.lang.Object newInstance(
					UnusedPrivateParameter unused) {
				return new CompanionRegData();
			}

			@java.lang.Override
			public final com.google.protobuf.UnknownFieldSet
			getUnknownFields() {
				return this.unknownFields;
			}
			private CompanionRegData(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				this();
				if (extensionRegistry == null) {
					throw new java.lang.NullPointerException();
				}
				int mutable_bitField0_ = 0;
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
								bitField0_ |= 0x00000001;
								eRegid_ = input.readBytes();
								break;
							}
							case 18: {
								bitField0_ |= 0x00000002;
								eKeytype_ = input.readBytes();
								break;
							}
							case 26: {
								bitField0_ |= 0x00000004;
								eIdent_ = input.readBytes();
								break;
							}
							case 34: {
								bitField0_ |= 0x00000008;
								eSkeyId_ = input.readBytes();
								break;
							}
							case 42: {
								bitField0_ |= 0x00000010;
								eSkeyVal_ = input.readBytes();
								break;
							}
							case 50: {
								bitField0_ |= 0x00000020;
								eSkeySig_ = input.readBytes();
								break;
							}
							case 58: {
								bitField0_ |= 0x00000040;
								buildHash_ = input.readBytes();
								break;
							}
							case 66: {
								bitField0_ |= 0x00000080;
								companionProps_ = input.readBytes();
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
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_CompanionRegData_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_CompanionRegData_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.class, com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.Builder.class);
			}

			private int bitField0_;
			public static final int E_REGID_FIELD_NUMBER = 1;
			private com.google.protobuf.ByteString eRegid_;
			/**
			 * <code>bytes e_regid = 1;</code>
			 * @return Whether the eRegid field is set.
			 */
			@java.lang.Override
			public boolean hasERegid() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>bytes e_regid = 1;</code>
			 * @return The eRegid.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getERegid() {
				return eRegid_;
			}

			public static final int E_KEYTYPE_FIELD_NUMBER = 2;
			private com.google.protobuf.ByteString eKeytype_;
			/**
			 * <code>bytes e_keytype = 2;</code>
			 * @return Whether the eKeytype field is set.
			 */
			@java.lang.Override
			public boolean hasEKeytype() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>bytes e_keytype = 2;</code>
			 * @return The eKeytype.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getEKeytype() {
				return eKeytype_;
			}

			public static final int E_IDENT_FIELD_NUMBER = 3;
			private com.google.protobuf.ByteString eIdent_;
			/**
			 * <code>bytes e_ident = 3;</code>
			 * @return Whether the eIdent field is set.
			 */
			@java.lang.Override
			public boolean hasEIdent() {
				return ((bitField0_ & 0x00000004) != 0);
			}
			/**
			 * <code>bytes e_ident = 3;</code>
			 * @return The eIdent.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getEIdent() {
				return eIdent_;
			}

			public static final int E_SKEY_ID_FIELD_NUMBER = 4;
			private com.google.protobuf.ByteString eSkeyId_;
			/**
			 * <code>bytes e_skey_id = 4;</code>
			 * @return Whether the eSkeyId field is set.
			 */
			@java.lang.Override
			public boolean hasESkeyId() {
				return ((bitField0_ & 0x00000008) != 0);
			}
			/**
			 * <code>bytes e_skey_id = 4;</code>
			 * @return The eSkeyId.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getESkeyId() {
				return eSkeyId_;
			}

			public static final int E_SKEY_VAL_FIELD_NUMBER = 5;
			private com.google.protobuf.ByteString eSkeyVal_;
			/**
			 * <code>bytes e_skey_val = 5;</code>
			 * @return Whether the eSkeyVal field is set.
			 */
			@java.lang.Override
			public boolean hasESkeyVal() {
				return ((bitField0_ & 0x00000010) != 0);
			}
			/**
			 * <code>bytes e_skey_val = 5;</code>
			 * @return The eSkeyVal.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getESkeyVal() {
				return eSkeyVal_;
			}

			public static final int E_SKEY_SIG_FIELD_NUMBER = 6;
			private com.google.protobuf.ByteString eSkeySig_;
			/**
			 * <code>bytes e_skey_sig = 6;</code>
			 * @return Whether the eSkeySig field is set.
			 */
			@java.lang.Override
			public boolean hasESkeySig() {
				return ((bitField0_ & 0x00000020) != 0);
			}
			/**
			 * <code>bytes e_skey_sig = 6;</code>
			 * @return The eSkeySig.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getESkeySig() {
				return eSkeySig_;
			}

			public static final int BUILD_HASH_FIELD_NUMBER = 7;
			private com.google.protobuf.ByteString buildHash_;
			/**
			 * <code>bytes build_hash = 7;</code>
			 * @return Whether the buildHash field is set.
			 */
			@java.lang.Override
			public boolean hasBuildHash() {
				return ((bitField0_ & 0x00000040) != 0);
			}
			/**
			 * <code>bytes build_hash = 7;</code>
			 * @return The buildHash.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getBuildHash() {
				return buildHash_;
			}

			public static final int COMPANION_PROPS_FIELD_NUMBER = 8;
			private com.google.protobuf.ByteString companionProps_;
			/**
			 * <code>bytes companion_props = 8;</code>
			 * @return Whether the companionProps field is set.
			 */
			@java.lang.Override
			public boolean hasCompanionProps() {
				return ((bitField0_ & 0x00000080) != 0);
			}
			/**
			 * <code>bytes companion_props = 8;</code>
			 * @return The companionProps.
			 */
			@java.lang.Override
			public com.google.protobuf.ByteString getCompanionProps() {
				return companionProps_;
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
				if (((bitField0_ & 0x00000001) != 0)) {
					output.writeBytes(1, eRegid_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					output.writeBytes(2, eKeytype_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					output.writeBytes(3, eIdent_);
				}
				if (((bitField0_ & 0x00000008) != 0)) {
					output.writeBytes(4, eSkeyId_);
				}
				if (((bitField0_ & 0x00000010) != 0)) {
					output.writeBytes(5, eSkeyVal_);
				}
				if (((bitField0_ & 0x00000020) != 0)) {
					output.writeBytes(6, eSkeySig_);
				}
				if (((bitField0_ & 0x00000040) != 0)) {
					output.writeBytes(7, buildHash_);
				}
				if (((bitField0_ & 0x00000080) != 0)) {
					output.writeBytes(8, companionProps_);
				}
				unknownFields.writeTo(output);
			}

			@java.lang.Override
			public int getSerializedSize() {
				int size = memoizedSize;
				if (size != -1) return size;

				size = 0;
				if (((bitField0_ & 0x00000001) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(1, eRegid_);
				}
				if (((bitField0_ & 0x00000002) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(2, eKeytype_);
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(3, eIdent_);
				}
				if (((bitField0_ & 0x00000008) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(4, eSkeyId_);
				}
				if (((bitField0_ & 0x00000010) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(5, eSkeyVal_);
				}
				if (((bitField0_ & 0x00000020) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(6, eSkeySig_);
				}
				if (((bitField0_ & 0x00000040) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(7, buildHash_);
				}
				if (((bitField0_ & 0x00000080) != 0)) {
					size += com.google.protobuf.CodedOutputStream
							.computeBytesSize(8, companionProps_);
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
				if (!(obj instanceof com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData)) {
					return super.equals(obj);
				}
				com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData other = (com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData) obj;

				if (hasERegid() != other.hasERegid()) return false;
				if (hasERegid()) {
					if (!getERegid()
							.equals(other.getERegid())) return false;
				}
				if (hasEKeytype() != other.hasEKeytype()) return false;
				if (hasEKeytype()) {
					if (!getEKeytype()
							.equals(other.getEKeytype())) return false;
				}
				if (hasEIdent() != other.hasEIdent()) return false;
				if (hasEIdent()) {
					if (!getEIdent()
							.equals(other.getEIdent())) return false;
				}
				if (hasESkeyId() != other.hasESkeyId()) return false;
				if (hasESkeyId()) {
					if (!getESkeyId()
							.equals(other.getESkeyId())) return false;
				}
				if (hasESkeyVal() != other.hasESkeyVal()) return false;
				if (hasESkeyVal()) {
					if (!getESkeyVal()
							.equals(other.getESkeyVal())) return false;
				}
				if (hasESkeySig() != other.hasESkeySig()) return false;
				if (hasESkeySig()) {
					if (!getESkeySig()
							.equals(other.getESkeySig())) return false;
				}
				if (hasBuildHash() != other.hasBuildHash()) return false;
				if (hasBuildHash()) {
					if (!getBuildHash()
							.equals(other.getBuildHash())) return false;
				}
				if (hasCompanionProps() != other.hasCompanionProps()) return false;
				if (hasCompanionProps()) {
					if (!getCompanionProps()
							.equals(other.getCompanionProps())) return false;
				}
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
				if (hasERegid()) {
					hash = (37 * hash) + E_REGID_FIELD_NUMBER;
					hash = (53 * hash) + getERegid().hashCode();
				}
				if (hasEKeytype()) {
					hash = (37 * hash) + E_KEYTYPE_FIELD_NUMBER;
					hash = (53 * hash) + getEKeytype().hashCode();
				}
				if (hasEIdent()) {
					hash = (37 * hash) + E_IDENT_FIELD_NUMBER;
					hash = (53 * hash) + getEIdent().hashCode();
				}
				if (hasESkeyId()) {
					hash = (37 * hash) + E_SKEY_ID_FIELD_NUMBER;
					hash = (53 * hash) + getESkeyId().hashCode();
				}
				if (hasESkeyVal()) {
					hash = (37 * hash) + E_SKEY_VAL_FIELD_NUMBER;
					hash = (53 * hash) + getESkeyVal().hashCode();
				}
				if (hasESkeySig()) {
					hash = (37 * hash) + E_SKEY_SIG_FIELD_NUMBER;
					hash = (53 * hash) + getESkeySig().hashCode();
				}
				if (hasBuildHash()) {
					hash = (37 * hash) + BUILD_HASH_FIELD_NUMBER;
					hash = (53 * hash) + getBuildHash().hashCode();
				}
				if (hasCompanionProps()) {
					hash = (37 * hash) + COMPANION_PROPS_FIELD_NUMBER;
					hash = (53 * hash) + getCompanionProps().hashCode();
				}
				hash = (29 * hash) + unknownFields.hashCode();
				memoizedHashCode = hash;
				return hash;
			}

			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(
					java.nio.ByteBuffer data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(
					java.nio.ByteBuffer data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(
					com.google.protobuf.ByteString data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(
					com.google.protobuf.ByteString data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(byte[] data)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(
					byte[] data,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return PARSER.parseFrom(data, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseDelimitedFrom(java.io.InputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseDelimitedFrom(
					java.io.InputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(
					com.google.protobuf.CodedInputStream input)
					throws java.io.IOException {
				return com.google.protobuf.GeneratedMessageV3
						.parseWithIOException(PARSER, input);
			}
			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parseFrom(
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
			public static Builder newBuilder(com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData prototype) {
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
			 * Protobuf type {@code whatsapp.ClientPayload.CompanionRegData}
			 */
			public static final class Builder extends
					com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
					// @@protoc_insertion_point(builder_implements:whatsapp.ClientPayload.CompanionRegData)
					com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegDataOrBuilder {
				public static final com.google.protobuf.Descriptors.Descriptor
				getDescriptor() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_CompanionRegData_descriptor;
				}

				@java.lang.Override
				protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
				internalGetFieldAccessorTable() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_CompanionRegData_fieldAccessorTable
							.ensureFieldAccessorsInitialized(
									com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.class, com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.Builder.class);
				}

				// Construct using com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.newBuilder()
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
					eRegid_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000001);
					eKeytype_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000002);
					eIdent_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000004);
					eSkeyId_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000008);
					eSkeyVal_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000010);
					eSkeySig_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000020);
					buildHash_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000040);
					companionProps_ = com.google.protobuf.ByteString.EMPTY;
					bitField0_ = (bitField0_ & ~0x00000080);
					return this;
				}

				@java.lang.Override
				public com.google.protobuf.Descriptors.Descriptor
				getDescriptorForType() {
					return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_CompanionRegData_descriptor;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData getDefaultInstanceForType() {
					return com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.getDefaultInstance();
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData build() {
					com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData result = buildPartial();
					if (!result.isInitialized()) {
						throw newUninitializedMessageException(result);
					}
					return result;
				}

				@java.lang.Override
				public com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData buildPartial() {
					com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData result = new com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData(this);
					int from_bitField0_ = bitField0_;
					int to_bitField0_ = 0;
					if (((from_bitField0_ & 0x00000001) != 0)) {
						to_bitField0_ |= 0x00000001;
					}
					result.eRegid_ = eRegid_;
					if (((from_bitField0_ & 0x00000002) != 0)) {
						to_bitField0_ |= 0x00000002;
					}
					result.eKeytype_ = eKeytype_;
					if (((from_bitField0_ & 0x00000004) != 0)) {
						to_bitField0_ |= 0x00000004;
					}
					result.eIdent_ = eIdent_;
					if (((from_bitField0_ & 0x00000008) != 0)) {
						to_bitField0_ |= 0x00000008;
					}
					result.eSkeyId_ = eSkeyId_;
					if (((from_bitField0_ & 0x00000010) != 0)) {
						to_bitField0_ |= 0x00000010;
					}
					result.eSkeyVal_ = eSkeyVal_;
					if (((from_bitField0_ & 0x00000020) != 0)) {
						to_bitField0_ |= 0x00000020;
					}
					result.eSkeySig_ = eSkeySig_;
					if (((from_bitField0_ & 0x00000040) != 0)) {
						to_bitField0_ |= 0x00000040;
					}
					result.buildHash_ = buildHash_;
					if (((from_bitField0_ & 0x00000080) != 0)) {
						to_bitField0_ |= 0x00000080;
					}
					result.companionProps_ = companionProps_;
					result.bitField0_ = to_bitField0_;
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
					if (other instanceof com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData) {
						return mergeFrom((com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData)other);
					} else {
						super.mergeFrom(other);
						return this;
					}
				}

				public Builder mergeFrom(com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData other) {
					if (other == com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.getDefaultInstance()) return this;
					if (other.hasERegid()) {
						setERegid(other.getERegid());
					}
					if (other.hasEKeytype()) {
						setEKeytype(other.getEKeytype());
					}
					if (other.hasEIdent()) {
						setEIdent(other.getEIdent());
					}
					if (other.hasESkeyId()) {
						setESkeyId(other.getESkeyId());
					}
					if (other.hasESkeyVal()) {
						setESkeyVal(other.getESkeyVal());
					}
					if (other.hasESkeySig()) {
						setESkeySig(other.getESkeySig());
					}
					if (other.hasBuildHash()) {
						setBuildHash(other.getBuildHash());
					}
					if (other.hasCompanionProps()) {
						setCompanionProps(other.getCompanionProps());
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
					com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData parsedMessage = null;
					try {
						parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
					} catch (com.google.protobuf.InvalidProtocolBufferException e) {
						parsedMessage = (com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData) e.getUnfinishedMessage();
						throw e.unwrapIOException();
					} finally {
						if (parsedMessage != null) {
							mergeFrom(parsedMessage);
						}
					}
					return this;
				}
				private int bitField0_;

				private com.google.protobuf.ByteString eRegid_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes e_regid = 1;</code>
				 * @return Whether the eRegid field is set.
				 */
				@java.lang.Override
				public boolean hasERegid() {
					return ((bitField0_ & 0x00000001) != 0);
				}
				/**
				 * <code>bytes e_regid = 1;</code>
				 * @return The eRegid.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getERegid() {
					return eRegid_;
				}
				/**
				 * <code>bytes e_regid = 1;</code>
				 * @param value The eRegid to set.
				 * @return This builder for chaining.
				 */
				public Builder setERegid(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000001;
					eRegid_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes e_regid = 1;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearERegid() {
					bitField0_ = (bitField0_ & ~0x00000001);
					eRegid_ = getDefaultInstance().getERegid();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString eKeytype_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes e_keytype = 2;</code>
				 * @return Whether the eKeytype field is set.
				 */
				@java.lang.Override
				public boolean hasEKeytype() {
					return ((bitField0_ & 0x00000002) != 0);
				}
				/**
				 * <code>bytes e_keytype = 2;</code>
				 * @return The eKeytype.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getEKeytype() {
					return eKeytype_;
				}
				/**
				 * <code>bytes e_keytype = 2;</code>
				 * @param value The eKeytype to set.
				 * @return This builder for chaining.
				 */
				public Builder setEKeytype(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000002;
					eKeytype_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes e_keytype = 2;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearEKeytype() {
					bitField0_ = (bitField0_ & ~0x00000002);
					eKeytype_ = getDefaultInstance().getEKeytype();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString eIdent_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes e_ident = 3;</code>
				 * @return Whether the eIdent field is set.
				 */
				@java.lang.Override
				public boolean hasEIdent() {
					return ((bitField0_ & 0x00000004) != 0);
				}
				/**
				 * <code>bytes e_ident = 3;</code>
				 * @return The eIdent.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getEIdent() {
					return eIdent_;
				}
				/**
				 * <code>bytes e_ident = 3;</code>
				 * @param value The eIdent to set.
				 * @return This builder for chaining.
				 */
				public Builder setEIdent(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000004;
					eIdent_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes e_ident = 3;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearEIdent() {
					bitField0_ = (bitField0_ & ~0x00000004);
					eIdent_ = getDefaultInstance().getEIdent();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString eSkeyId_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes e_skey_id = 4;</code>
				 * @return Whether the eSkeyId field is set.
				 */
				@java.lang.Override
				public boolean hasESkeyId() {
					return ((bitField0_ & 0x00000008) != 0);
				}
				/**
				 * <code>bytes e_skey_id = 4;</code>
				 * @return The eSkeyId.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getESkeyId() {
					return eSkeyId_;
				}
				/**
				 * <code>bytes e_skey_id = 4;</code>
				 * @param value The eSkeyId to set.
				 * @return This builder for chaining.
				 */
				public Builder setESkeyId(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000008;
					eSkeyId_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes e_skey_id = 4;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearESkeyId() {
					bitField0_ = (bitField0_ & ~0x00000008);
					eSkeyId_ = getDefaultInstance().getESkeyId();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString eSkeyVal_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes e_skey_val = 5;</code>
				 * @return Whether the eSkeyVal field is set.
				 */
				@java.lang.Override
				public boolean hasESkeyVal() {
					return ((bitField0_ & 0x00000010) != 0);
				}
				/**
				 * <code>bytes e_skey_val = 5;</code>
				 * @return The eSkeyVal.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getESkeyVal() {
					return eSkeyVal_;
				}
				/**
				 * <code>bytes e_skey_val = 5;</code>
				 * @param value The eSkeyVal to set.
				 * @return This builder for chaining.
				 */
				public Builder setESkeyVal(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000010;
					eSkeyVal_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes e_skey_val = 5;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearESkeyVal() {
					bitField0_ = (bitField0_ & ~0x00000010);
					eSkeyVal_ = getDefaultInstance().getESkeyVal();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString eSkeySig_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes e_skey_sig = 6;</code>
				 * @return Whether the eSkeySig field is set.
				 */
				@java.lang.Override
				public boolean hasESkeySig() {
					return ((bitField0_ & 0x00000020) != 0);
				}
				/**
				 * <code>bytes e_skey_sig = 6;</code>
				 * @return The eSkeySig.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getESkeySig() {
					return eSkeySig_;
				}
				/**
				 * <code>bytes e_skey_sig = 6;</code>
				 * @param value The eSkeySig to set.
				 * @return This builder for chaining.
				 */
				public Builder setESkeySig(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000020;
					eSkeySig_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes e_skey_sig = 6;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearESkeySig() {
					bitField0_ = (bitField0_ & ~0x00000020);
					eSkeySig_ = getDefaultInstance().getESkeySig();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString buildHash_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes build_hash = 7;</code>
				 * @return Whether the buildHash field is set.
				 */
				@java.lang.Override
				public boolean hasBuildHash() {
					return ((bitField0_ & 0x00000040) != 0);
				}
				/**
				 * <code>bytes build_hash = 7;</code>
				 * @return The buildHash.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getBuildHash() {
					return buildHash_;
				}
				/**
				 * <code>bytes build_hash = 7;</code>
				 * @param value The buildHash to set.
				 * @return This builder for chaining.
				 */
				public Builder setBuildHash(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000040;
					buildHash_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes build_hash = 7;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearBuildHash() {
					bitField0_ = (bitField0_ & ~0x00000040);
					buildHash_ = getDefaultInstance().getBuildHash();
					onChanged();
					return this;
				}

				private com.google.protobuf.ByteString companionProps_ = com.google.protobuf.ByteString.EMPTY;
				/**
				 * <code>bytes companion_props = 8;</code>
				 * @return Whether the companionProps field is set.
				 */
				@java.lang.Override
				public boolean hasCompanionProps() {
					return ((bitField0_ & 0x00000080) != 0);
				}
				/**
				 * <code>bytes companion_props = 8;</code>
				 * @return The companionProps.
				 */
				@java.lang.Override
				public com.google.protobuf.ByteString getCompanionProps() {
					return companionProps_;
				}
				/**
				 * <code>bytes companion_props = 8;</code>
				 * @param value The companionProps to set.
				 * @return This builder for chaining.
				 */
				public Builder setCompanionProps(com.google.protobuf.ByteString value) {
					if (value == null) {
						throw new NullPointerException();
					}
					bitField0_ |= 0x00000080;
					companionProps_ = value;
					onChanged();
					return this;
				}
				/**
				 * <code>bytes companion_props = 8;</code>
				 * @return This builder for chaining.
				 */
				public Builder clearCompanionProps() {
					bitField0_ = (bitField0_ & ~0x00000080);
					companionProps_ = getDefaultInstance().getCompanionProps();
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


				// @@protoc_insertion_point(builder_scope:whatsapp.ClientPayload.CompanionRegData)
			}

			// @@protoc_insertion_point(class_scope:whatsapp.ClientPayload.CompanionRegData)
			private static final com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData DEFAULT_INSTANCE;
			static {
				DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData();
			}

			public static com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData getDefaultInstance() {
				return DEFAULT_INSTANCE;
			}

			private static final com.google.protobuf.Parser<CompanionRegData>
					PARSER = new com.google.protobuf.AbstractParser<CompanionRegData>() {
				@java.lang.Override
				public CompanionRegData parsePartialFrom(
						com.google.protobuf.CodedInputStream input,
						com.google.protobuf.ExtensionRegistryLite extensionRegistry)
						throws com.google.protobuf.InvalidProtocolBufferException {
					return new CompanionRegData(input, extensionRegistry);
				}
			};

			public static com.google.protobuf.Parser<CompanionRegData> parser() {
				return PARSER;
			}

			@java.lang.Override
			public com.google.protobuf.Parser<CompanionRegData> getParserForType() {
				return PARSER;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData getDefaultInstanceForType() {
				return DEFAULT_INSTANCE;
			}

		}

		private int bitField0_;
		public static final int USERNAME_FIELD_NUMBER = 1;
		private long username_;
		/**
		 * <code>uint64 username = 1;</code>
		 * @return Whether the username field is set.
		 */
		@java.lang.Override
		public boolean hasUsername() {
			return ((bitField0_ & 0x00000001) != 0);
		}
		/**
		 * <code>uint64 username = 1;</code>
		 * @return The username.
		 */
		@java.lang.Override
		public long getUsername() {
			return username_;
		}

		public static final int PASSIVE_FIELD_NUMBER = 3;
		private boolean passive_;
		/**
		 * <code>bool passive = 3;</code>
		 * @return Whether the passive field is set.
		 */
		@java.lang.Override
		public boolean hasPassive() {
			return ((bitField0_ & 0x00000002) != 0);
		}
		/**
		 * <code>bool passive = 3;</code>
		 * @return The passive.
		 */
		@java.lang.Override
		public boolean getPassive() {
			return passive_;
		}

		public static final int CLIENT_FEATURES_FIELD_NUMBER = 4;
		private java.util.List<java.lang.Integer> clientFeatures_;
		private static final com.google.protobuf.Internal.ListAdapter.Converter<
				java.lang.Integer, com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature> clientFeatures_converter_ =
				new com.google.protobuf.Internal.ListAdapter.Converter<
						java.lang.Integer, com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature>() {
					public com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature convert(java.lang.Integer from) {
						@SuppressWarnings("deprecation")
						com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature result = com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature.valueOf(from);
						return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature.UNRECOGNIZED : result;
					}
				};
		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @return A list containing the clientFeatures.
		 */
		@java.lang.Override
		public java.util.List<com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature> getClientFeaturesList() {
			return new com.google.protobuf.Internal.ListAdapter<
					java.lang.Integer, com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature>(clientFeatures_, clientFeatures_converter_);
		}
		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @return The count of clientFeatures.
		 */
		@java.lang.Override
		public int getClientFeaturesCount() {
			return clientFeatures_.size();
		}
		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @param index The index of the element to return.
		 * @return The clientFeatures at the given index.
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature getClientFeatures(int index) {
			return clientFeatures_converter_.convert(clientFeatures_.get(index));
		}
		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @return A list containing the enum numeric values on the wire for clientFeatures.
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer>
		getClientFeaturesValueList() {
			return clientFeatures_;
		}
		/**
		 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
		 * @param index The index of the value to return.
		 * @return The enum numeric value on the wire of clientFeatures at the given index.
		 */
		@java.lang.Override
		public int getClientFeaturesValue(int index) {
			return clientFeatures_.get(index);
		}
		private int clientFeaturesMemoizedSerializedSize;

		public static final int USER_AGENT_FIELD_NUMBER = 5;
		private com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent userAgent_;
		/**
		 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
		 * @return Whether the userAgent field is set.
		 */
		@java.lang.Override
		public boolean hasUserAgent() {
			return ((bitField0_ & 0x00000004) != 0);
		}
		/**
		 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
		 * @return The userAgent.
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent getUserAgent() {
			return userAgent_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.getDefaultInstance() : userAgent_;
		}
		/**
		 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgentOrBuilder getUserAgentOrBuilder() {
			return userAgent_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.getDefaultInstance() : userAgent_;
		}

		public static final int WEB_INFO_FIELD_NUMBER = 6;
		private com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo webInfo_;
		/**
		 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
		 * @return Whether the webInfo field is set.
		 */
		@java.lang.Override
		public boolean hasWebInfo() {
			return ((bitField0_ & 0x00000008) != 0);
		}
		/**
		 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
		 * @return The webInfo.
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo getWebInfo() {
			return webInfo_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.getDefaultInstance() : webInfo_;
		}
		/**
		 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfoOrBuilder getWebInfoOrBuilder() {
			return webInfo_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.getDefaultInstance() : webInfo_;
		}

		public static final int PUSH_NAME_FIELD_NUMBER = 7;
		private volatile java.lang.Object pushName_;
		/**
		 * <code>string push_name = 7;</code>
		 * @return Whether the pushName field is set.
		 */
		@java.lang.Override
		public boolean hasPushName() {
			return ((bitField0_ & 0x00000010) != 0);
		}
		/**
		 * <code>string push_name = 7;</code>
		 * @return The pushName.
		 */
		@java.lang.Override
		public java.lang.String getPushName() {
			java.lang.Object ref = pushName_;
			if (ref instanceof java.lang.String) {
				return (java.lang.String) ref;
			} else {
				com.google.protobuf.ByteString bs =
						(com.google.protobuf.ByteString) ref;
				java.lang.String s = bs.toStringUtf8();
				pushName_ = s;
				return s;
			}
		}
		/**
		 * <code>string push_name = 7;</code>
		 * @return The bytes for pushName.
		 */
		@java.lang.Override
		public com.google.protobuf.ByteString
		getPushNameBytes() {
			java.lang.Object ref = pushName_;
			if (ref instanceof java.lang.String) {
				com.google.protobuf.ByteString b =
						com.google.protobuf.ByteString.copyFromUtf8(
								(java.lang.String) ref);
				pushName_ = b;
				return b;
			} else {
				return (com.google.protobuf.ByteString) ref;
			}
		}

		public static final int SESSION_ID_FIELD_NUMBER = 9;
		private int sessionId_;
		/**
		 * <code>sfixed32 session_id = 9;</code>
		 * @return Whether the sessionId field is set.
		 */
		@java.lang.Override
		public boolean hasSessionId() {
			return ((bitField0_ & 0x00000020) != 0);
		}
		/**
		 * <code>sfixed32 session_id = 9;</code>
		 * @return The sessionId.
		 */
		@java.lang.Override
		public int getSessionId() {
			return sessionId_;
		}

		public static final int SHORT_CONNECT_FIELD_NUMBER = 10;
		private boolean shortConnect_;
		/**
		 * <code>bool short_connect = 10;</code>
		 * @return Whether the shortConnect field is set.
		 */
		@java.lang.Override
		public boolean hasShortConnect() {
			return ((bitField0_ & 0x00000040) != 0);
		}
		/**
		 * <code>bool short_connect = 10;</code>
		 * @return The shortConnect.
		 */
		@java.lang.Override
		public boolean getShortConnect() {
			return shortConnect_;
		}

		public static final int IOS_APP_EXTENSION_FIELD_NUMBER = 30;
		private int iosAppExtension_;
		/**
		 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
		 * @return Whether the iosAppExtension field is set.
		 */
		@java.lang.Override public boolean hasIosAppExtension() {
			return ((bitField0_ & 0x00000080) != 0);
		}
		/**
		 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
		 * @return The enum numeric value on the wire for iosAppExtension.
		 */
		@java.lang.Override public int getIosAppExtensionValue() {
			return iosAppExtension_;
		}
		/**
		 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
		 * @return The iosAppExtension.
		 */
		@java.lang.Override public com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension getIosAppExtension() {
			@SuppressWarnings("deprecation")
			com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension result = com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension.valueOf(iosAppExtension_);
			return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension.UNRECOGNIZED : result;
		}

		public static final int CONNECT_TYPE_FIELD_NUMBER = 12;
		private int connectType_;
		/**
		 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
		 * @return Whether the connectType field is set.
		 */
		@java.lang.Override public boolean hasConnectType() {
			return ((bitField0_ & 0x00000100) != 0);
		}
		/**
		 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
		 * @return The enum numeric value on the wire for connectType.
		 */
		@java.lang.Override public int getConnectTypeValue() {
			return connectType_;
		}
		/**
		 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
		 * @return The connectType.
		 */
		@java.lang.Override public com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType getConnectType() {
			@SuppressWarnings("deprecation")
			com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType result = com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType.valueOf(connectType_);
			return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType.UNRECOGNIZED : result;
		}

		public static final int CONNECT_REASON_FIELD_NUMBER = 13;
		private int connectReason_;
		/**
		 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
		 * @return Whether the connectReason field is set.
		 */
		@java.lang.Override public boolean hasConnectReason() {
			return ((bitField0_ & 0x00000200) != 0);
		}
		/**
		 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
		 * @return The enum numeric value on the wire for connectReason.
		 */
		@java.lang.Override public int getConnectReasonValue() {
			return connectReason_;
		}
		/**
		 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
		 * @return The connectReason.
		 */
		@java.lang.Override public com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason getConnectReason() {
			@SuppressWarnings("deprecation")
			com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason result = com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason.valueOf(connectReason_);
			return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason.UNRECOGNIZED : result;
		}

		public static final int SHARDS_FIELD_NUMBER = 14;
		private com.google.protobuf.Internal.IntList shards_;
		/**
		 * <code>repeated sfixed32 shards = 14;</code>
		 * @return A list containing the shards.
		 */
		@java.lang.Override
		public java.util.List<java.lang.Integer>
		getShardsList() {
			return shards_;
		}
		/**
		 * <code>repeated sfixed32 shards = 14;</code>
		 * @return The count of shards.
		 */
		public int getShardsCount() {
			return shards_.size();
		}
		/**
		 * <code>repeated sfixed32 shards = 14;</code>
		 * @param index The index of the element to return.
		 * @return The shards at the given index.
		 */
		public int getShards(int index) {
			return shards_.getInt(index);
		}
		private int shardsMemoizedSerializedSize = -1;

		public static final int DNS_SOURCE_FIELD_NUMBER = 15;
		private com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource dnsSource_;
		/**
		 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
		 * @return Whether the dnsSource field is set.
		 */
		@java.lang.Override
		public boolean hasDnsSource() {
			return ((bitField0_ & 0x00000400) != 0);
		}
		/**
		 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
		 * @return The dnsSource.
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource getDnsSource() {
			return dnsSource_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.getDefaultInstance() : dnsSource_;
		}
		/**
		 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSourceOrBuilder getDnsSourceOrBuilder() {
			return dnsSource_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.getDefaultInstance() : dnsSource_;
		}

		public static final int CONNECT_ATTEMPT_COUNT_FIELD_NUMBER = 16;
		private int connectAttemptCount_;
		/**
		 * <code>uint32 connect_attempt_count = 16;</code>
		 * @return Whether the connectAttemptCount field is set.
		 */
		@java.lang.Override
		public boolean hasConnectAttemptCount() {
			return ((bitField0_ & 0x00000800) != 0);
		}
		/**
		 * <code>uint32 connect_attempt_count = 16;</code>
		 * @return The connectAttemptCount.
		 */
		@java.lang.Override
		public int getConnectAttemptCount() {
			return connectAttemptCount_;
		}

		public static final int AGENT_FIELD_NUMBER = 17;
		private int agent_;
		/**
		 * <code>uint32 agent = 17;</code>
		 * @return Whether the agent field is set.
		 */
		@java.lang.Override
		public boolean hasAgent() {
			return ((bitField0_ & 0x00001000) != 0);
		}
		/**
		 * <code>uint32 agent = 17;</code>
		 * @return The agent.
		 */
		@java.lang.Override
		public int getAgent() {
			return agent_;
		}

		public static final int DEVICE_FIELD_NUMBER = 18;
		private int device_;
		/**
		 * <code>uint32 device = 18;</code>
		 * @return Whether the device field is set.
		 */
		@java.lang.Override
		public boolean hasDevice() {
			return ((bitField0_ & 0x00002000) != 0);
		}
		/**
		 * <code>uint32 device = 18;</code>
		 * @return The device.
		 */
		@java.lang.Override
		public int getDevice() {
			return device_;
		}

		public static final int REG_DATA_FIELD_NUMBER = 19;
		private com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData regData_;
		/**
		 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
		 * @return Whether the regData field is set.
		 */
		@java.lang.Override
		public boolean hasRegData() {
			return ((bitField0_ & 0x00004000) != 0);
		}
		/**
		 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
		 * @return The regData.
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData getRegData() {
			return regData_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.getDefaultInstance() : regData_;
		}
		/**
		 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
		 */
		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegDataOrBuilder getRegDataOrBuilder() {
			return regData_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.getDefaultInstance() : regData_;
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
			getSerializedSize();
			if (((bitField0_ & 0x00000001) != 0)) {
				output.writeUInt64(1, username_);
			}
			if (((bitField0_ & 0x00000002) != 0)) {
				output.writeBool(3, passive_);
			}
			if (getClientFeaturesList().size() > 0) {
				output.writeUInt32NoTag(34);
				output.writeUInt32NoTag(clientFeaturesMemoizedSerializedSize);
			}
			for (int i = 0; i < clientFeatures_.size(); i++) {
				output.writeEnumNoTag(clientFeatures_.get(i));
			}
			if (((bitField0_ & 0x00000004) != 0)) {
				output.writeMessage(5, getUserAgent());
			}
			if (((bitField0_ & 0x00000008) != 0)) {
				output.writeMessage(6, getWebInfo());
			}
			if (((bitField0_ & 0x00000010) != 0)) {
				com.google.protobuf.GeneratedMessageV3.writeString(output, 7, pushName_);
			}
			if (((bitField0_ & 0x00000020) != 0)) {
				output.writeSFixed32(9, sessionId_);
			}
			if (((bitField0_ & 0x00000040) != 0)) {
				output.writeBool(10, shortConnect_);
			}
			if (((bitField0_ & 0x00000100) != 0)) {
				output.writeEnum(12, connectType_);
			}
			if (((bitField0_ & 0x00000200) != 0)) {
				output.writeEnum(13, connectReason_);
			}
			if (getShardsList().size() > 0) {
				output.writeUInt32NoTag(114);
				output.writeUInt32NoTag(shardsMemoizedSerializedSize);
			}
			for (int i = 0; i < shards_.size(); i++) {
				output.writeSFixed32NoTag(shards_.getInt(i));
			}
			if (((bitField0_ & 0x00000400) != 0)) {
				output.writeMessage(15, getDnsSource());
			}
			if (((bitField0_ & 0x00000800) != 0)) {
				output.writeUInt32(16, connectAttemptCount_);
			}
			if (((bitField0_ & 0x00001000) != 0)) {
				output.writeUInt32(17, agent_);
			}
			if (((bitField0_ & 0x00002000) != 0)) {
				output.writeUInt32(18, device_);
			}
			if (((bitField0_ & 0x00004000) != 0)) {
				output.writeMessage(19, getRegData());
			}
			if (((bitField0_ & 0x00000080) != 0)) {
				output.writeEnum(30, iosAppExtension_);
			}
			unknownFields.writeTo(output);
		}

		@java.lang.Override
		public int getSerializedSize() {
			int size = memoizedSize;
			if (size != -1) return size;

			size = 0;
			if (((bitField0_ & 0x00000001) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeUInt64Size(1, username_);
			}
			if (((bitField0_ & 0x00000002) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeBoolSize(3, passive_);
			}
			{
				int dataSize = 0;
				for (int i = 0; i < clientFeatures_.size(); i++) {
					dataSize += com.google.protobuf.CodedOutputStream
							.computeEnumSizeNoTag(clientFeatures_.get(i));
				}
				size += dataSize;
				if (!getClientFeaturesList().isEmpty()) {  size += 1;
					size += com.google.protobuf.CodedOutputStream
							.computeUInt32SizeNoTag(dataSize);
				}clientFeaturesMemoizedSerializedSize = dataSize;
			}
			if (((bitField0_ & 0x00000004) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeMessageSize(5, getUserAgent());
			}
			if (((bitField0_ & 0x00000008) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeMessageSize(6, getWebInfo());
			}
			if (((bitField0_ & 0x00000010) != 0)) {
				size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, pushName_);
			}
			if (((bitField0_ & 0x00000020) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeSFixed32Size(9, sessionId_);
			}
			if (((bitField0_ & 0x00000040) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeBoolSize(10, shortConnect_);
			}
			if (((bitField0_ & 0x00000100) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeEnumSize(12, connectType_);
			}
			if (((bitField0_ & 0x00000200) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeEnumSize(13, connectReason_);
			}
			{
				int dataSize = 0;
				dataSize = 4 * getShardsList().size();
				size += dataSize;
				if (!getShardsList().isEmpty()) {
					size += 1;
					size += com.google.protobuf.CodedOutputStream
							.computeInt32SizeNoTag(dataSize);
				}
				shardsMemoizedSerializedSize = dataSize;
			}
			if (((bitField0_ & 0x00000400) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeMessageSize(15, getDnsSource());
			}
			if (((bitField0_ & 0x00000800) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeUInt32Size(16, connectAttemptCount_);
			}
			if (((bitField0_ & 0x00001000) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeUInt32Size(17, agent_);
			}
			if (((bitField0_ & 0x00002000) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeUInt32Size(18, device_);
			}
			if (((bitField0_ & 0x00004000) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeMessageSize(19, getRegData());
			}
			if (((bitField0_ & 0x00000080) != 0)) {
				size += com.google.protobuf.CodedOutputStream
						.computeEnumSize(30, iosAppExtension_);
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
			if (!(obj instanceof com.whatsapp.proto.WA4Protos.ClientPayload)) {
				return super.equals(obj);
			}
			com.whatsapp.proto.WA4Protos.ClientPayload other = (com.whatsapp.proto.WA4Protos.ClientPayload) obj;

			if (hasUsername() != other.hasUsername()) return false;
			if (hasUsername()) {
				if (getUsername()
						!= other.getUsername()) return false;
			}
			if (hasPassive() != other.hasPassive()) return false;
			if (hasPassive()) {
				if (getPassive()
						!= other.getPassive()) return false;
			}
			if (!clientFeatures_.equals(other.clientFeatures_)) return false;
			if (hasUserAgent() != other.hasUserAgent()) return false;
			if (hasUserAgent()) {
				if (!getUserAgent()
						.equals(other.getUserAgent())) return false;
			}
			if (hasWebInfo() != other.hasWebInfo()) return false;
			if (hasWebInfo()) {
				if (!getWebInfo()
						.equals(other.getWebInfo())) return false;
			}
			if (hasPushName() != other.hasPushName()) return false;
			if (hasPushName()) {
				if (!getPushName()
						.equals(other.getPushName())) return false;
			}
			if (hasSessionId() != other.hasSessionId()) return false;
			if (hasSessionId()) {
				if (getSessionId()
						!= other.getSessionId()) return false;
			}
			if (hasShortConnect() != other.hasShortConnect()) return false;
			if (hasShortConnect()) {
				if (getShortConnect()
						!= other.getShortConnect()) return false;
			}
			if (hasIosAppExtension() != other.hasIosAppExtension()) return false;
			if (hasIosAppExtension()) {
				if (iosAppExtension_ != other.iosAppExtension_) return false;
			}
			if (hasConnectType() != other.hasConnectType()) return false;
			if (hasConnectType()) {
				if (connectType_ != other.connectType_) return false;
			}
			if (hasConnectReason() != other.hasConnectReason()) return false;
			if (hasConnectReason()) {
				if (connectReason_ != other.connectReason_) return false;
			}
			if (!getShardsList()
					.equals(other.getShardsList())) return false;
			if (hasDnsSource() != other.hasDnsSource()) return false;
			if (hasDnsSource()) {
				if (!getDnsSource()
						.equals(other.getDnsSource())) return false;
			}
			if (hasConnectAttemptCount() != other.hasConnectAttemptCount()) return false;
			if (hasConnectAttemptCount()) {
				if (getConnectAttemptCount()
						!= other.getConnectAttemptCount()) return false;
			}
			if (hasAgent() != other.hasAgent()) return false;
			if (hasAgent()) {
				if (getAgent()
						!= other.getAgent()) return false;
			}
			if (hasDevice() != other.hasDevice()) return false;
			if (hasDevice()) {
				if (getDevice()
						!= other.getDevice()) return false;
			}
			if (hasRegData() != other.hasRegData()) return false;
			if (hasRegData()) {
				if (!getRegData()
						.equals(other.getRegData())) return false;
			}
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
			if (hasUsername()) {
				hash = (37 * hash) + USERNAME_FIELD_NUMBER;
				hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
						getUsername());
			}
			if (hasPassive()) {
				hash = (37 * hash) + PASSIVE_FIELD_NUMBER;
				hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
						getPassive());
			}
			if (getClientFeaturesCount() > 0) {
				hash = (37 * hash) + CLIENT_FEATURES_FIELD_NUMBER;
				hash = (53 * hash) + clientFeatures_.hashCode();
			}
			if (hasUserAgent()) {
				hash = (37 * hash) + USER_AGENT_FIELD_NUMBER;
				hash = (53 * hash) + getUserAgent().hashCode();
			}
			if (hasWebInfo()) {
				hash = (37 * hash) + WEB_INFO_FIELD_NUMBER;
				hash = (53 * hash) + getWebInfo().hashCode();
			}
			if (hasPushName()) {
				hash = (37 * hash) + PUSH_NAME_FIELD_NUMBER;
				hash = (53 * hash) + getPushName().hashCode();
			}
			if (hasSessionId()) {
				hash = (37 * hash) + SESSION_ID_FIELD_NUMBER;
				hash = (53 * hash) + getSessionId();
			}
			if (hasShortConnect()) {
				hash = (37 * hash) + SHORT_CONNECT_FIELD_NUMBER;
				hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
						getShortConnect());
			}
			if (hasIosAppExtension()) {
				hash = (37 * hash) + IOS_APP_EXTENSION_FIELD_NUMBER;
				hash = (53 * hash) + iosAppExtension_;
			}
			if (hasConnectType()) {
				hash = (37 * hash) + CONNECT_TYPE_FIELD_NUMBER;
				hash = (53 * hash) + connectType_;
			}
			if (hasConnectReason()) {
				hash = (37 * hash) + CONNECT_REASON_FIELD_NUMBER;
				hash = (53 * hash) + connectReason_;
			}
			if (getShardsCount() > 0) {
				hash = (37 * hash) + SHARDS_FIELD_NUMBER;
				hash = (53 * hash) + getShardsList().hashCode();
			}
			if (hasDnsSource()) {
				hash = (37 * hash) + DNS_SOURCE_FIELD_NUMBER;
				hash = (53 * hash) + getDnsSource().hashCode();
			}
			if (hasConnectAttemptCount()) {
				hash = (37 * hash) + CONNECT_ATTEMPT_COUNT_FIELD_NUMBER;
				hash = (53 * hash) + getConnectAttemptCount();
			}
			if (hasAgent()) {
				hash = (37 * hash) + AGENT_FIELD_NUMBER;
				hash = (53 * hash) + getAgent();
			}
			if (hasDevice()) {
				hash = (37 * hash) + DEVICE_FIELD_NUMBER;
				hash = (53 * hash) + getDevice();
			}
			if (hasRegData()) {
				hash = (37 * hash) + REG_DATA_FIELD_NUMBER;
				hash = (53 * hash) + getRegData().hashCode();
			}
			hash = (29 * hash) + unknownFields.hashCode();
			memoizedHashCode = hash;
			return hash;
		}

		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(
				java.nio.ByteBuffer data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(
				java.nio.ByteBuffer data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(
				com.google.protobuf.ByteString data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(
				com.google.protobuf.ByteString data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(byte[] data)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(
				byte[] data,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws com.google.protobuf.InvalidProtocolBufferException {
			return PARSER.parseFrom(data, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(java.io.InputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseWithIOException(PARSER, input);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(
				java.io.InputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseWithIOException(PARSER, input, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseDelimitedFrom(java.io.InputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseDelimitedWithIOException(PARSER, input);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseDelimitedFrom(
				java.io.InputStream input,
				com.google.protobuf.ExtensionRegistryLite extensionRegistry)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(
				com.google.protobuf.CodedInputStream input)
				throws java.io.IOException {
			return com.google.protobuf.GeneratedMessageV3
					.parseWithIOException(PARSER, input);
		}
		public static com.whatsapp.proto.WA4Protos.ClientPayload parseFrom(
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
		public static Builder newBuilder(com.whatsapp.proto.WA4Protos.ClientPayload prototype) {
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
		 * Protobuf type {@code whatsapp.ClientPayload}
		 */
		public static final class Builder extends
				com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
				// @@protoc_insertion_point(builder_implements:whatsapp.ClientPayload)
				com.whatsapp.proto.WA4Protos.ClientPayloadOrBuilder {
			public static final com.google.protobuf.Descriptors.Descriptor
			getDescriptor() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_descriptor;
			}

			@java.lang.Override
			protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internalGetFieldAccessorTable() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_fieldAccessorTable
						.ensureFieldAccessorsInitialized(
								com.whatsapp.proto.WA4Protos.ClientPayload.class, com.whatsapp.proto.WA4Protos.ClientPayload.Builder.class);
			}

			// Construct using com.whatsapp.proto.WA4Protos.ClientPayload.newBuilder()
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
					getUserAgentFieldBuilder();
					getWebInfoFieldBuilder();
					getDnsSourceFieldBuilder();
					getRegDataFieldBuilder();
				}
			}
			@java.lang.Override
			public Builder clear() {
				super.clear();
				username_ = 0L;
				bitField0_ = (bitField0_ & ~0x00000001);
				passive_ = false;
				bitField0_ = (bitField0_ & ~0x00000002);
				clientFeatures_ = java.util.Collections.emptyList();
				bitField0_ = (bitField0_ & ~0x00000004);
				if (userAgentBuilder_ == null) {
					userAgent_ = null;
				} else {
					userAgentBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000008);
				if (webInfoBuilder_ == null) {
					webInfo_ = null;
				} else {
					webInfoBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000010);
				pushName_ = "";
				bitField0_ = (bitField0_ & ~0x00000020);
				sessionId_ = 0;
				bitField0_ = (bitField0_ & ~0x00000040);
				shortConnect_ = false;
				bitField0_ = (bitField0_ & ~0x00000080);
				iosAppExtension_ = 0;
				bitField0_ = (bitField0_ & ~0x00000100);
				connectType_ = 0;
				bitField0_ = (bitField0_ & ~0x00000200);
				connectReason_ = 0;
				bitField0_ = (bitField0_ & ~0x00000400);
				shards_ = emptyIntList();
				bitField0_ = (bitField0_ & ~0x00000800);
				if (dnsSourceBuilder_ == null) {
					dnsSource_ = null;
				} else {
					dnsSourceBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00001000);
				connectAttemptCount_ = 0;
				bitField0_ = (bitField0_ & ~0x00002000);
				agent_ = 0;
				bitField0_ = (bitField0_ & ~0x00004000);
				device_ = 0;
				bitField0_ = (bitField0_ & ~0x00008000);
				if (regDataBuilder_ == null) {
					regData_ = null;
				} else {
					regDataBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00010000);
				return this;
			}

			@java.lang.Override
			public com.google.protobuf.Descriptors.Descriptor
			getDescriptorForType() {
				return com.whatsapp.proto.WA4Protos.internal_static_whatsapp_ClientPayload_descriptor;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload getDefaultInstanceForType() {
				return com.whatsapp.proto.WA4Protos.ClientPayload.getDefaultInstance();
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload build() {
				com.whatsapp.proto.WA4Protos.ClientPayload result = buildPartial();
				if (!result.isInitialized()) {
					throw newUninitializedMessageException(result);
				}
				return result;
			}

			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload buildPartial() {
				com.whatsapp.proto.WA4Protos.ClientPayload result = new com.whatsapp.proto.WA4Protos.ClientPayload(this);
				int from_bitField0_ = bitField0_;
				int to_bitField0_ = 0;
				if (((from_bitField0_ & 0x00000001) != 0)) {
					result.username_ = username_;
					to_bitField0_ |= 0x00000001;
				}
				if (((from_bitField0_ & 0x00000002) != 0)) {
					result.passive_ = passive_;
					to_bitField0_ |= 0x00000002;
				}
				if (((bitField0_ & 0x00000004) != 0)) {
					clientFeatures_ = java.util.Collections.unmodifiableList(clientFeatures_);
					bitField0_ = (bitField0_ & ~0x00000004);
				}
				result.clientFeatures_ = clientFeatures_;
				if (((from_bitField0_ & 0x00000008) != 0)) {
					if (userAgentBuilder_ == null) {
						result.userAgent_ = userAgent_;
					} else {
						result.userAgent_ = userAgentBuilder_.build();
					}
					to_bitField0_ |= 0x00000004;
				}
				if (((from_bitField0_ & 0x00000010) != 0)) {
					if (webInfoBuilder_ == null) {
						result.webInfo_ = webInfo_;
					} else {
						result.webInfo_ = webInfoBuilder_.build();
					}
					to_bitField0_ |= 0x00000008;
				}
				if (((from_bitField0_ & 0x00000020) != 0)) {
					to_bitField0_ |= 0x00000010;
				}
				result.pushName_ = pushName_;
				if (((from_bitField0_ & 0x00000040) != 0)) {
					result.sessionId_ = sessionId_;
					to_bitField0_ |= 0x00000020;
				}
				if (((from_bitField0_ & 0x00000080) != 0)) {
					result.shortConnect_ = shortConnect_;
					to_bitField0_ |= 0x00000040;
				}
				if (((from_bitField0_ & 0x00000100) != 0)) {
					to_bitField0_ |= 0x00000080;
				}
				result.iosAppExtension_ = iosAppExtension_;
				if (((from_bitField0_ & 0x00000200) != 0)) {
					to_bitField0_ |= 0x00000100;
				}
				result.connectType_ = connectType_;
				if (((from_bitField0_ & 0x00000400) != 0)) {
					to_bitField0_ |= 0x00000200;
				}
				result.connectReason_ = connectReason_;
				if (((bitField0_ & 0x00000800) != 0)) {
					shards_.makeImmutable();
					bitField0_ = (bitField0_ & ~0x00000800);
				}
				result.shards_ = shards_;
				if (((from_bitField0_ & 0x00001000) != 0)) {
					if (dnsSourceBuilder_ == null) {
						result.dnsSource_ = dnsSource_;
					} else {
						result.dnsSource_ = dnsSourceBuilder_.build();
					}
					to_bitField0_ |= 0x00000400;
				}
				if (((from_bitField0_ & 0x00002000) != 0)) {
					result.connectAttemptCount_ = connectAttemptCount_;
					to_bitField0_ |= 0x00000800;
				}
				if (((from_bitField0_ & 0x00004000) != 0)) {
					result.agent_ = agent_;
					to_bitField0_ |= 0x00001000;
				}
				if (((from_bitField0_ & 0x00008000) != 0)) {
					result.device_ = device_;
					to_bitField0_ |= 0x00002000;
				}
				if (((from_bitField0_ & 0x00010000) != 0)) {
					if (regDataBuilder_ == null) {
						result.regData_ = regData_;
					} else {
						result.regData_ = regDataBuilder_.build();
					}
					to_bitField0_ |= 0x00004000;
				}
				result.bitField0_ = to_bitField0_;
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
				if (other instanceof com.whatsapp.proto.WA4Protos.ClientPayload) {
					return mergeFrom((com.whatsapp.proto.WA4Protos.ClientPayload)other);
				} else {
					super.mergeFrom(other);
					return this;
				}
			}

			public Builder mergeFrom(com.whatsapp.proto.WA4Protos.ClientPayload other) {
				if (other == com.whatsapp.proto.WA4Protos.ClientPayload.getDefaultInstance()) return this;
				if (other.hasUsername()) {
					setUsername(other.getUsername());
				}
				if (other.hasPassive()) {
					setPassive(other.getPassive());
				}
				if (!other.clientFeatures_.isEmpty()) {
					if (clientFeatures_.isEmpty()) {
						clientFeatures_ = other.clientFeatures_;
						bitField0_ = (bitField0_ & ~0x00000004);
					} else {
						ensureClientFeaturesIsMutable();
						clientFeatures_.addAll(other.clientFeatures_);
					}
					onChanged();
				}
				if (other.hasUserAgent()) {
					mergeUserAgent(other.getUserAgent());
				}
				if (other.hasWebInfo()) {
					mergeWebInfo(other.getWebInfo());
				}
				if (other.hasPushName()) {
					bitField0_ |= 0x00000020;
					pushName_ = other.pushName_;
					onChanged();
				}
				if (other.hasSessionId()) {
					setSessionId(other.getSessionId());
				}
				if (other.hasShortConnect()) {
					setShortConnect(other.getShortConnect());
				}
				if (other.hasIosAppExtension()) {
					setIosAppExtension(other.getIosAppExtension());
				}
				if (other.hasConnectType()) {
					setConnectType(other.getConnectType());
				}
				if (other.hasConnectReason()) {
					setConnectReason(other.getConnectReason());
				}
				if (!other.shards_.isEmpty()) {
					if (shards_.isEmpty()) {
						shards_ = other.shards_;
						bitField0_ = (bitField0_ & ~0x00000800);
					} else {
						ensureShardsIsMutable();
						shards_.addAll(other.shards_);
					}
					onChanged();
				}
				if (other.hasDnsSource()) {
					mergeDnsSource(other.getDnsSource());
				}
				if (other.hasConnectAttemptCount()) {
					setConnectAttemptCount(other.getConnectAttemptCount());
				}
				if (other.hasAgent()) {
					setAgent(other.getAgent());
				}
				if (other.hasDevice()) {
					setDevice(other.getDevice());
				}
				if (other.hasRegData()) {
					mergeRegData(other.getRegData());
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
				com.whatsapp.proto.WA4Protos.ClientPayload parsedMessage = null;
				try {
					parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
				} catch (com.google.protobuf.InvalidProtocolBufferException e) {
					parsedMessage = (com.whatsapp.proto.WA4Protos.ClientPayload) e.getUnfinishedMessage();
					throw e.unwrapIOException();
				} finally {
					if (parsedMessage != null) {
						mergeFrom(parsedMessage);
					}
				}
				return this;
			}
			private int bitField0_;

			private long username_ ;
			/**
			 * <code>uint64 username = 1;</code>
			 * @return Whether the username field is set.
			 */
			@java.lang.Override
			public boolean hasUsername() {
				return ((bitField0_ & 0x00000001) != 0);
			}
			/**
			 * <code>uint64 username = 1;</code>
			 * @return The username.
			 */
			@java.lang.Override
			public long getUsername() {
				return username_;
			}
			/**
			 * <code>uint64 username = 1;</code>
			 * @param value The username to set.
			 * @return This builder for chaining.
			 */
			public Builder setUsername(long value) {
				bitField0_ |= 0x00000001;
				username_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>uint64 username = 1;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearUsername() {
				bitField0_ = (bitField0_ & ~0x00000001);
				username_ = 0L;
				onChanged();
				return this;
			}

			private boolean passive_ ;
			/**
			 * <code>bool passive = 3;</code>
			 * @return Whether the passive field is set.
			 */
			@java.lang.Override
			public boolean hasPassive() {
				return ((bitField0_ & 0x00000002) != 0);
			}
			/**
			 * <code>bool passive = 3;</code>
			 * @return The passive.
			 */
			@java.lang.Override
			public boolean getPassive() {
				return passive_;
			}
			/**
			 * <code>bool passive = 3;</code>
			 * @param value The passive to set.
			 * @return This builder for chaining.
			 */
			public Builder setPassive(boolean value) {
				bitField0_ |= 0x00000002;
				passive_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>bool passive = 3;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearPassive() {
				bitField0_ = (bitField0_ & ~0x00000002);
				passive_ = false;
				onChanged();
				return this;
			}

			private java.util.List<java.lang.Integer> clientFeatures_ =
					java.util.Collections.emptyList();
			private void ensureClientFeaturesIsMutable() {
				if (!((bitField0_ & 0x00000004) != 0)) {
					clientFeatures_ = new java.util.ArrayList<java.lang.Integer>(clientFeatures_);
					bitField0_ |= 0x00000004;
				}
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @return A list containing the clientFeatures.
			 */
			public java.util.List<com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature> getClientFeaturesList() {
				return new com.google.protobuf.Internal.ListAdapter<
						java.lang.Integer, com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature>(clientFeatures_, clientFeatures_converter_);
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @return The count of clientFeatures.
			 */
			public int getClientFeaturesCount() {
				return clientFeatures_.size();
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @param index The index of the element to return.
			 * @return The clientFeatures at the given index.
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature getClientFeatures(int index) {
				return clientFeatures_converter_.convert(clientFeatures_.get(index));
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @param index The index to set the value at.
			 * @param value The clientFeatures to set.
			 * @return This builder for chaining.
			 */
			public Builder setClientFeatures(
					int index, com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature value) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureClientFeaturesIsMutable();
				clientFeatures_.set(index, value.getNumber());
				onChanged();
				return this;
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @param value The clientFeatures to add.
			 * @return This builder for chaining.
			 */
			public Builder addClientFeatures(com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature value) {
				if (value == null) {
					throw new NullPointerException();
				}
				ensureClientFeaturesIsMutable();
				clientFeatures_.add(value.getNumber());
				onChanged();
				return this;
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @param values The clientFeatures to add.
			 * @return This builder for chaining.
			 */
			public Builder addAllClientFeatures(
					java.lang.Iterable<? extends com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature> values) {
				ensureClientFeaturesIsMutable();
				for (com.whatsapp.proto.WA4Protos.ClientPayload.ClientFeature value : values) {
					clientFeatures_.add(value.getNumber());
				}
				onChanged();
				return this;
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearClientFeatures() {
				clientFeatures_ = java.util.Collections.emptyList();
				bitField0_ = (bitField0_ & ~0x00000004);
				onChanged();
				return this;
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @return A list containing the enum numeric values on the wire for clientFeatures.
			 */
			public java.util.List<java.lang.Integer>
			getClientFeaturesValueList() {
				return java.util.Collections.unmodifiableList(clientFeatures_);
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @param index The index of the value to return.
			 * @return The enum numeric value on the wire of clientFeatures at the given index.
			 */
			public int getClientFeaturesValue(int index) {
				return clientFeatures_.get(index);
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @param index The index of the value to return.
			 * @return The enum numeric value on the wire of clientFeatures at the given index.
			 * @return This builder for chaining.
			 */
			public Builder setClientFeaturesValue(
					int index, int value) {
				ensureClientFeaturesIsMutable();
				clientFeatures_.set(index, value);
				onChanged();
				return this;
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @param value The enum numeric value on the wire for clientFeatures to add.
			 * @return This builder for chaining.
			 */
			public Builder addClientFeaturesValue(int value) {
				ensureClientFeaturesIsMutable();
				clientFeatures_.add(value);
				onChanged();
				return this;
			}
			/**
			 * <code>repeated .whatsapp.ClientPayload.ClientFeature client_features = 4;</code>
			 * @param values The enum numeric values on the wire for clientFeatures to add.
			 * @return This builder for chaining.
			 */
			public Builder addAllClientFeaturesValue(
					java.lang.Iterable<java.lang.Integer> values) {
				ensureClientFeaturesIsMutable();
				for (int value : values) {
					clientFeatures_.add(value);
				}
				onChanged();
				return this;
			}

			private com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent userAgent_;
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgentOrBuilder> userAgentBuilder_;
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
			 * @return Whether the userAgent field is set.
			 */
			public boolean hasUserAgent() {
				return ((bitField0_ & 0x00000008) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
			 * @return The userAgent.
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent getUserAgent() {
				if (userAgentBuilder_ == null) {
					return userAgent_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.getDefaultInstance() : userAgent_;
				} else {
					return userAgentBuilder_.getMessage();
				}
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
			 */
			public Builder setUserAgent(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent value) {
				if (userAgentBuilder_ == null) {
					if (value == null) {
						throw new NullPointerException();
					}
					userAgent_ = value;
					onChanged();
				} else {
					userAgentBuilder_.setMessage(value);
				}
				bitField0_ |= 0x00000008;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
			 */
			public Builder setUserAgent(
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Builder builderForValue) {
				if (userAgentBuilder_ == null) {
					userAgent_ = builderForValue.build();
					onChanged();
				} else {
					userAgentBuilder_.setMessage(builderForValue.build());
				}
				bitField0_ |= 0x00000008;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
			 */
			public Builder mergeUserAgent(com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent value) {
				if (userAgentBuilder_ == null) {
					if (((bitField0_ & 0x00000008) != 0) &&
							userAgent_ != null &&
							userAgent_ != com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.getDefaultInstance()) {
						userAgent_ =
								com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.newBuilder(userAgent_).mergeFrom(value).buildPartial();
					} else {
						userAgent_ = value;
					}
					onChanged();
				} else {
					userAgentBuilder_.mergeFrom(value);
				}
				bitField0_ |= 0x00000008;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
			 */
			public Builder clearUserAgent() {
				if (userAgentBuilder_ == null) {
					userAgent_ = null;
					onChanged();
				} else {
					userAgentBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000008);
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Builder getUserAgentBuilder() {
				bitField0_ |= 0x00000008;
				onChanged();
				return getUserAgentFieldBuilder().getBuilder();
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.UserAgentOrBuilder getUserAgentOrBuilder() {
				if (userAgentBuilder_ != null) {
					return userAgentBuilder_.getMessageOrBuilder();
				} else {
					return userAgent_ == null ?
							com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.getDefaultInstance() : userAgent_;
				}
			}
			/**
			 * <code>.whatsapp.ClientPayload.UserAgent user_agent = 5;</code>
			 */
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgentOrBuilder>
			getUserAgentFieldBuilder() {
				if (userAgentBuilder_ == null) {
					userAgentBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
							com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgent.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.UserAgentOrBuilder>(
							getUserAgent(),
							getParentForChildren(),
							isClean());
					userAgent_ = null;
				}
				return userAgentBuilder_;
			}

			private com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo webInfo_;
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfoOrBuilder> webInfoBuilder_;
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
			 * @return Whether the webInfo field is set.
			 */
			public boolean hasWebInfo() {
				return ((bitField0_ & 0x00000010) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
			 * @return The webInfo.
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo getWebInfo() {
				if (webInfoBuilder_ == null) {
					return webInfo_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.getDefaultInstance() : webInfo_;
				} else {
					return webInfoBuilder_.getMessage();
				}
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
			 */
			public Builder setWebInfo(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo value) {
				if (webInfoBuilder_ == null) {
					if (value == null) {
						throw new NullPointerException();
					}
					webInfo_ = value;
					onChanged();
				} else {
					webInfoBuilder_.setMessage(value);
				}
				bitField0_ |= 0x00000010;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
			 */
			public Builder setWebInfo(
					com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.Builder builderForValue) {
				if (webInfoBuilder_ == null) {
					webInfo_ = builderForValue.build();
					onChanged();
				} else {
					webInfoBuilder_.setMessage(builderForValue.build());
				}
				bitField0_ |= 0x00000010;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
			 */
			public Builder mergeWebInfo(com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo value) {
				if (webInfoBuilder_ == null) {
					if (((bitField0_ & 0x00000010) != 0) &&
							webInfo_ != null &&
							webInfo_ != com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.getDefaultInstance()) {
						webInfo_ =
								com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.newBuilder(webInfo_).mergeFrom(value).buildPartial();
					} else {
						webInfo_ = value;
					}
					onChanged();
				} else {
					webInfoBuilder_.mergeFrom(value);
				}
				bitField0_ |= 0x00000010;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
			 */
			public Builder clearWebInfo() {
				if (webInfoBuilder_ == null) {
					webInfo_ = null;
					onChanged();
				} else {
					webInfoBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00000010);
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.Builder getWebInfoBuilder() {
				bitField0_ |= 0x00000010;
				onChanged();
				return getWebInfoFieldBuilder().getBuilder();
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.WebInfoOrBuilder getWebInfoOrBuilder() {
				if (webInfoBuilder_ != null) {
					return webInfoBuilder_.getMessageOrBuilder();
				} else {
					return webInfo_ == null ?
							com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.getDefaultInstance() : webInfo_;
				}
			}
			/**
			 * <code>.whatsapp.ClientPayload.WebInfo web_info = 6;</code>
			 */
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfoOrBuilder>
			getWebInfoFieldBuilder() {
				if (webInfoBuilder_ == null) {
					webInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
							com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfo.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.WebInfoOrBuilder>(
							getWebInfo(),
							getParentForChildren(),
							isClean());
					webInfo_ = null;
				}
				return webInfoBuilder_;
			}

			private java.lang.Object pushName_ = "";
			/**
			 * <code>string push_name = 7;</code>
			 * @return Whether the pushName field is set.
			 */
			public boolean hasPushName() {
				return ((bitField0_ & 0x00000020) != 0);
			}
			/**
			 * <code>string push_name = 7;</code>
			 * @return The pushName.
			 */
			public java.lang.String getPushName() {
				java.lang.Object ref = pushName_;
				if (!(ref instanceof java.lang.String)) {
					com.google.protobuf.ByteString bs =
							(com.google.protobuf.ByteString) ref;
					java.lang.String s = bs.toStringUtf8();
					pushName_ = s;
					return s;
				} else {
					return (java.lang.String) ref;
				}
			}
			/**
			 * <code>string push_name = 7;</code>
			 * @return The bytes for pushName.
			 */
			public com.google.protobuf.ByteString
			getPushNameBytes() {
				java.lang.Object ref = pushName_;
				if (ref instanceof String) {
					com.google.protobuf.ByteString b =
							com.google.protobuf.ByteString.copyFromUtf8(
									(java.lang.String) ref);
					pushName_ = b;
					return b;
				} else {
					return (com.google.protobuf.ByteString) ref;
				}
			}
			/**
			 * <code>string push_name = 7;</code>
			 * @param value The pushName to set.
			 * @return This builder for chaining.
			 */
			public Builder setPushName(
					java.lang.String value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000020;
				pushName_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>string push_name = 7;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearPushName() {
				bitField0_ = (bitField0_ & ~0x00000020);
				pushName_ = getDefaultInstance().getPushName();
				onChanged();
				return this;
			}
			/**
			 * <code>string push_name = 7;</code>
			 * @param value The bytes for pushName to set.
			 * @return This builder for chaining.
			 */
			public Builder setPushNameBytes(
					com.google.protobuf.ByteString value) {
				if (value == null) {
					throw new NullPointerException();
				}
				checkByteStringIsUtf8(value);
				bitField0_ |= 0x00000020;
				pushName_ = value;
				onChanged();
				return this;
			}

			private int sessionId_ ;
			/**
			 * <code>sfixed32 session_id = 9;</code>
			 * @return Whether the sessionId field is set.
			 */
			@java.lang.Override
			public boolean hasSessionId() {
				return ((bitField0_ & 0x00000040) != 0);
			}
			/**
			 * <code>sfixed32 session_id = 9;</code>
			 * @return The sessionId.
			 */
			@java.lang.Override
			public int getSessionId() {
				return sessionId_;
			}
			/**
			 * <code>sfixed32 session_id = 9;</code>
			 * @param value The sessionId to set.
			 * @return This builder for chaining.
			 */
			public Builder setSessionId(int value) {
				bitField0_ |= 0x00000040;
				sessionId_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>sfixed32 session_id = 9;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearSessionId() {
				bitField0_ = (bitField0_ & ~0x00000040);
				sessionId_ = 0;
				onChanged();
				return this;
			}

			private boolean shortConnect_ ;
			/**
			 * <code>bool short_connect = 10;</code>
			 * @return Whether the shortConnect field is set.
			 */
			@java.lang.Override
			public boolean hasShortConnect() {
				return ((bitField0_ & 0x00000080) != 0);
			}
			/**
			 * <code>bool short_connect = 10;</code>
			 * @return The shortConnect.
			 */
			@java.lang.Override
			public boolean getShortConnect() {
				return shortConnect_;
			}
			/**
			 * <code>bool short_connect = 10;</code>
			 * @param value The shortConnect to set.
			 * @return This builder for chaining.
			 */
			public Builder setShortConnect(boolean value) {
				bitField0_ |= 0x00000080;
				shortConnect_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>bool short_connect = 10;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearShortConnect() {
				bitField0_ = (bitField0_ & ~0x00000080);
				shortConnect_ = false;
				onChanged();
				return this;
			}

			private int iosAppExtension_ = 0;
			/**
			 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
			 * @return Whether the iosAppExtension field is set.
			 */
			@java.lang.Override public boolean hasIosAppExtension() {
				return ((bitField0_ & 0x00000100) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
			 * @return The enum numeric value on the wire for iosAppExtension.
			 */
			@java.lang.Override public int getIosAppExtensionValue() {
				return iosAppExtension_;
			}
			/**
			 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
			 * @param value The enum numeric value on the wire for iosAppExtension to set.
			 * @return This builder for chaining.
			 */
			public Builder setIosAppExtensionValue(int value) {
				bitField0_ |= 0x00000100;
				iosAppExtension_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
			 * @return The iosAppExtension.
			 */
			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension getIosAppExtension() {
				@SuppressWarnings("deprecation")
				com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension result = com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension.valueOf(iosAppExtension_);
				return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension.UNRECOGNIZED : result;
			}
			/**
			 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
			 * @param value The iosAppExtension to set.
			 * @return This builder for chaining.
			 */
			public Builder setIosAppExtension(com.whatsapp.proto.WA4Protos.ClientPayload.IOSAppExtension value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000100;
				iosAppExtension_ = value.getNumber();
				onChanged();
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.IOSAppExtension ios_app_extension = 30;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearIosAppExtension() {
				bitField0_ = (bitField0_ & ~0x00000100);
				iosAppExtension_ = 0;
				onChanged();
				return this;
			}

			private int connectType_ = 0;
			/**
			 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
			 * @return Whether the connectType field is set.
			 */
			@java.lang.Override public boolean hasConnectType() {
				return ((bitField0_ & 0x00000200) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
			 * @return The enum numeric value on the wire for connectType.
			 */
			@java.lang.Override public int getConnectTypeValue() {
				return connectType_;
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
			 * @param value The enum numeric value on the wire for connectType to set.
			 * @return This builder for chaining.
			 */
			public Builder setConnectTypeValue(int value) {
				bitField0_ |= 0x00000200;
				connectType_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
			 * @return The connectType.
			 */
			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType getConnectType() {
				@SuppressWarnings("deprecation")
				com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType result = com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType.valueOf(connectType_);
				return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType.UNRECOGNIZED : result;
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
			 * @param value The connectType to set.
			 * @return This builder for chaining.
			 */
			public Builder setConnectType(com.whatsapp.proto.WA4Protos.ClientPayload.ConnectType value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000200;
				connectType_ = value.getNumber();
				onChanged();
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectType connect_type = 12;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearConnectType() {
				bitField0_ = (bitField0_ & ~0x00000200);
				connectType_ = 0;
				onChanged();
				return this;
			}

			private int connectReason_ = 0;
			/**
			 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
			 * @return Whether the connectReason field is set.
			 */
			@java.lang.Override public boolean hasConnectReason() {
				return ((bitField0_ & 0x00000400) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
			 * @return The enum numeric value on the wire for connectReason.
			 */
			@java.lang.Override public int getConnectReasonValue() {
				return connectReason_;
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
			 * @param value The enum numeric value on the wire for connectReason to set.
			 * @return This builder for chaining.
			 */
			public Builder setConnectReasonValue(int value) {
				bitField0_ |= 0x00000400;
				connectReason_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
			 * @return The connectReason.
			 */
			@java.lang.Override
			public com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason getConnectReason() {
				@SuppressWarnings("deprecation")
				com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason result = com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason.valueOf(connectReason_);
				return result == null ? com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason.UNRECOGNIZED : result;
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
			 * @param value The connectReason to set.
			 * @return This builder for chaining.
			 */
			public Builder setConnectReason(com.whatsapp.proto.WA4Protos.ClientPayload.ConnectReason value) {
				if (value == null) {
					throw new NullPointerException();
				}
				bitField0_ |= 0x00000400;
				connectReason_ = value.getNumber();
				onChanged();
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.ConnectReason connect_reason = 13;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearConnectReason() {
				bitField0_ = (bitField0_ & ~0x00000400);
				connectReason_ = 0;
				onChanged();
				return this;
			}

			private com.google.protobuf.Internal.IntList shards_ = emptyIntList();
			private void ensureShardsIsMutable() {
				if (!((bitField0_ & 0x00000800) != 0)) {
					shards_ = mutableCopy(shards_);
					bitField0_ |= 0x00000800;
				}
			}
			/**
			 * <code>repeated sfixed32 shards = 14;</code>
			 * @return A list containing the shards.
			 */
			public java.util.List<java.lang.Integer>
			getShardsList() {
				return ((bitField0_ & 0x00000800) != 0) ?
						java.util.Collections.unmodifiableList(shards_) : shards_;
			}
			/**
			 * <code>repeated sfixed32 shards = 14;</code>
			 * @return The count of shards.
			 */
			public int getShardsCount() {
				return shards_.size();
			}
			/**
			 * <code>repeated sfixed32 shards = 14;</code>
			 * @param index The index of the element to return.
			 * @return The shards at the given index.
			 */
			public int getShards(int index) {
				return shards_.getInt(index);
			}
			/**
			 * <code>repeated sfixed32 shards = 14;</code>
			 * @param index The index to set the value at.
			 * @param value The shards to set.
			 * @return This builder for chaining.
			 */
			public Builder setShards(
					int index, int value) {
				ensureShardsIsMutable();
				shards_.setInt(index, value);
				onChanged();
				return this;
			}
			/**
			 * <code>repeated sfixed32 shards = 14;</code>
			 * @param value The shards to add.
			 * @return This builder for chaining.
			 */
			public Builder addShards(int value) {
				ensureShardsIsMutable();
				shards_.addInt(value);
				onChanged();
				return this;
			}
			/**
			 * <code>repeated sfixed32 shards = 14;</code>
			 * @param values The shards to add.
			 * @return This builder for chaining.
			 */
			public Builder addAllShards(
					java.lang.Iterable<? extends java.lang.Integer> values) {
				ensureShardsIsMutable();
				com.google.protobuf.AbstractMessageLite.Builder.addAll(
						values, shards_);
				onChanged();
				return this;
			}
			/**
			 * <code>repeated sfixed32 shards = 14;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearShards() {
				shards_ = emptyIntList();
				bitField0_ = (bitField0_ & ~0x00000800);
				onChanged();
				return this;
			}

			private com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource dnsSource_;
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource, com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.DNSSourceOrBuilder> dnsSourceBuilder_;
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
			 * @return Whether the dnsSource field is set.
			 */
			public boolean hasDnsSource() {
				return ((bitField0_ & 0x00001000) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
			 * @return The dnsSource.
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource getDnsSource() {
				if (dnsSourceBuilder_ == null) {
					return dnsSource_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.getDefaultInstance() : dnsSource_;
				} else {
					return dnsSourceBuilder_.getMessage();
				}
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
			 */
			public Builder setDnsSource(com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource value) {
				if (dnsSourceBuilder_ == null) {
					if (value == null) {
						throw new NullPointerException();
					}
					dnsSource_ = value;
					onChanged();
				} else {
					dnsSourceBuilder_.setMessage(value);
				}
				bitField0_ |= 0x00001000;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
			 */
			public Builder setDnsSource(
					com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.Builder builderForValue) {
				if (dnsSourceBuilder_ == null) {
					dnsSource_ = builderForValue.build();
					onChanged();
				} else {
					dnsSourceBuilder_.setMessage(builderForValue.build());
				}
				bitField0_ |= 0x00001000;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
			 */
			public Builder mergeDnsSource(com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource value) {
				if (dnsSourceBuilder_ == null) {
					if (((bitField0_ & 0x00001000) != 0) &&
							dnsSource_ != null &&
							dnsSource_ != com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.getDefaultInstance()) {
						dnsSource_ =
								com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.newBuilder(dnsSource_).mergeFrom(value).buildPartial();
					} else {
						dnsSource_ = value;
					}
					onChanged();
				} else {
					dnsSourceBuilder_.mergeFrom(value);
				}
				bitField0_ |= 0x00001000;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
			 */
			public Builder clearDnsSource() {
				if (dnsSourceBuilder_ == null) {
					dnsSource_ = null;
					onChanged();
				} else {
					dnsSourceBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00001000);
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.Builder getDnsSourceBuilder() {
				bitField0_ |= 0x00001000;
				onChanged();
				return getDnsSourceFieldBuilder().getBuilder();
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.DNSSourceOrBuilder getDnsSourceOrBuilder() {
				if (dnsSourceBuilder_ != null) {
					return dnsSourceBuilder_.getMessageOrBuilder();
				} else {
					return dnsSource_ == null ?
							com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.getDefaultInstance() : dnsSource_;
				}
			}
			/**
			 * <code>.whatsapp.ClientPayload.DNSSource dns_source = 15;</code>
			 */
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource, com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.DNSSourceOrBuilder>
			getDnsSourceFieldBuilder() {
				if (dnsSourceBuilder_ == null) {
					dnsSourceBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
							com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource, com.whatsapp.proto.WA4Protos.ClientPayload.DNSSource.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.DNSSourceOrBuilder>(
							getDnsSource(),
							getParentForChildren(),
							isClean());
					dnsSource_ = null;
				}
				return dnsSourceBuilder_;
			}

			private int connectAttemptCount_ ;
			/**
			 * <code>uint32 connect_attempt_count = 16;</code>
			 * @return Whether the connectAttemptCount field is set.
			 */
			@java.lang.Override
			public boolean hasConnectAttemptCount() {
				return ((bitField0_ & 0x00002000) != 0);
			}
			/**
			 * <code>uint32 connect_attempt_count = 16;</code>
			 * @return The connectAttemptCount.
			 */
			@java.lang.Override
			public int getConnectAttemptCount() {
				return connectAttemptCount_;
			}
			/**
			 * <code>uint32 connect_attempt_count = 16;</code>
			 * @param value The connectAttemptCount to set.
			 * @return This builder for chaining.
			 */
			public Builder setConnectAttemptCount(int value) {
				bitField0_ |= 0x00002000;
				connectAttemptCount_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>uint32 connect_attempt_count = 16;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearConnectAttemptCount() {
				bitField0_ = (bitField0_ & ~0x00002000);
				connectAttemptCount_ = 0;
				onChanged();
				return this;
			}

			private int agent_ ;
			/**
			 * <code>uint32 agent = 17;</code>
			 * @return Whether the agent field is set.
			 */
			@java.lang.Override
			public boolean hasAgent() {
				return ((bitField0_ & 0x00004000) != 0);
			}
			/**
			 * <code>uint32 agent = 17;</code>
			 * @return The agent.
			 */
			@java.lang.Override
			public int getAgent() {
				return agent_;
			}
			/**
			 * <code>uint32 agent = 17;</code>
			 * @param value The agent to set.
			 * @return This builder for chaining.
			 */
			public Builder setAgent(int value) {
				bitField0_ |= 0x00004000;
				agent_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>uint32 agent = 17;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearAgent() {
				bitField0_ = (bitField0_ & ~0x00004000);
				agent_ = 0;
				onChanged();
				return this;
			}

			private int device_ ;
			/**
			 * <code>uint32 device = 18;</code>
			 * @return Whether the device field is set.
			 */
			@java.lang.Override
			public boolean hasDevice() {
				return ((bitField0_ & 0x00008000) != 0);
			}
			/**
			 * <code>uint32 device = 18;</code>
			 * @return The device.
			 */
			@java.lang.Override
			public int getDevice() {
				return device_;
			}
			/**
			 * <code>uint32 device = 18;</code>
			 * @param value The device to set.
			 * @return This builder for chaining.
			 */
			public Builder setDevice(int value) {
				bitField0_ |= 0x00008000;
				device_ = value;
				onChanged();
				return this;
			}
			/**
			 * <code>uint32 device = 18;</code>
			 * @return This builder for chaining.
			 */
			public Builder clearDevice() {
				bitField0_ = (bitField0_ & ~0x00008000);
				device_ = 0;
				onChanged();
				return this;
			}

			private com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData regData_;
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData, com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegDataOrBuilder> regDataBuilder_;
			/**
			 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
			 * @return Whether the regData field is set.
			 */
			public boolean hasRegData() {
				return ((bitField0_ & 0x00010000) != 0);
			}
			/**
			 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
			 * @return The regData.
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData getRegData() {
				if (regDataBuilder_ == null) {
					return regData_ == null ? com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.getDefaultInstance() : regData_;
				} else {
					return regDataBuilder_.getMessage();
				}
			}
			/**
			 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
			 */
			public Builder setRegData(com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData value) {
				if (regDataBuilder_ == null) {
					if (value == null) {
						throw new NullPointerException();
					}
					regData_ = value;
					onChanged();
				} else {
					regDataBuilder_.setMessage(value);
				}
				bitField0_ |= 0x00010000;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
			 */
			public Builder setRegData(
					com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.Builder builderForValue) {
				if (regDataBuilder_ == null) {
					regData_ = builderForValue.build();
					onChanged();
				} else {
					regDataBuilder_.setMessage(builderForValue.build());
				}
				bitField0_ |= 0x00010000;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
			 */
			public Builder mergeRegData(com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData value) {
				if (regDataBuilder_ == null) {
					if (((bitField0_ & 0x00010000) != 0) &&
							regData_ != null &&
							regData_ != com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.getDefaultInstance()) {
						regData_ =
								com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.newBuilder(regData_).mergeFrom(value).buildPartial();
					} else {
						regData_ = value;
					}
					onChanged();
				} else {
					regDataBuilder_.mergeFrom(value);
				}
				bitField0_ |= 0x00010000;
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
			 */
			public Builder clearRegData() {
				if (regDataBuilder_ == null) {
					regData_ = null;
					onChanged();
				} else {
					regDataBuilder_.clear();
				}
				bitField0_ = (bitField0_ & ~0x00010000);
				return this;
			}
			/**
			 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.Builder getRegDataBuilder() {
				bitField0_ |= 0x00010000;
				onChanged();
				return getRegDataFieldBuilder().getBuilder();
			}
			/**
			 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
			 */
			public com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegDataOrBuilder getRegDataOrBuilder() {
				if (regDataBuilder_ != null) {
					return regDataBuilder_.getMessageOrBuilder();
				} else {
					return regData_ == null ?
							com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.getDefaultInstance() : regData_;
				}
			}
			/**
			 * <code>.whatsapp.ClientPayload.CompanionRegData reg_data = 19;</code>
			 */
			private com.google.protobuf.SingleFieldBuilderV3<
					com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData, com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegDataOrBuilder>
			getRegDataFieldBuilder() {
				if (regDataBuilder_ == null) {
					regDataBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
							com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData, com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegData.Builder, com.whatsapp.proto.WA4Protos.ClientPayload.CompanionRegDataOrBuilder>(
							getRegData(),
							getParentForChildren(),
							isClean());
					regData_ = null;
				}
				return regDataBuilder_;
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


			// @@protoc_insertion_point(builder_scope:whatsapp.ClientPayload)
		}

		// @@protoc_insertion_point(class_scope:whatsapp.ClientPayload)
		private static final com.whatsapp.proto.WA4Protos.ClientPayload DEFAULT_INSTANCE;
		static {
			DEFAULT_INSTANCE = new com.whatsapp.proto.WA4Protos.ClientPayload();
		}

		public static com.whatsapp.proto.WA4Protos.ClientPayload getDefaultInstance() {
			return DEFAULT_INSTANCE;
		}

		private static final com.google.protobuf.Parser<ClientPayload>
				PARSER = new com.google.protobuf.AbstractParser<ClientPayload>() {
			@java.lang.Override
			public ClientPayload parsePartialFrom(
					com.google.protobuf.CodedInputStream input,
					com.google.protobuf.ExtensionRegistryLite extensionRegistry)
					throws com.google.protobuf.InvalidProtocolBufferException {
				return new ClientPayload(input, extensionRegistry);
			}
		};

		public static com.google.protobuf.Parser<ClientPayload> parser() {
			return PARSER;
		}

		@java.lang.Override
		public com.google.protobuf.Parser<ClientPayload> getParserForType() {
			return PARSER;
		}

		@java.lang.Override
		public com.whatsapp.proto.WA4Protos.ClientPayload getDefaultInstanceForType() {
			return DEFAULT_INSTANCE;
		}

	}

	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_HandshakeMessage_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_HandshakeMessage_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_HandshakeMessage_ClientHello_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_HandshakeMessage_ClientHello_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_HandshakeMessage_ServerHello_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_HandshakeMessage_ServerHello_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_HandshakeMessage_ClientFinish_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_HandshakeMessage_ClientFinish_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_NoiseCertificate_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_NoiseCertificate_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_NoiseCertificate_Details_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_NoiseCertificate_Details_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_ClientPayload_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_ClientPayload_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_ClientPayload_UserAgent_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_ClientPayload_UserAgent_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_ClientPayload_WebInfo_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_ClientPayload_WebInfo_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_ClientPayload_DNSSource_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_ClientPayload_DNSSource_fieldAccessorTable;
	private static final com.google.protobuf.Descriptors.Descriptor
			internal_static_whatsapp_ClientPayload_CompanionRegData_descriptor;
	private static final
	com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
			internal_static_whatsapp_ClientPayload_CompanionRegData_fieldAccessorTable;

	public static com.google.protobuf.Descriptors.FileDescriptor
	getDescriptor() {
		return descriptor;
	}
	private static  com.google.protobuf.Descriptors.FileDescriptor
			descriptor;
	static {
		java.lang.String[] descriptorData = {
				"\n\010my.proto\022\010whatsapp\"\321\004\n\020HandshakeMessag" +
						"e\022A\n\014client_hello\030\002 \001(\0132&.whatsapp.Hands" +
						"hakeMessage.ClientHelloH\000\210\001\001\022A\n\014server_h" +
						"ello\030\003 \001(\0132&.whatsapp.HandshakeMessage.S" +
						"erverHelloH\001\210\001\001\022C\n\rclient_finish\030\004 \001(\0132\'" +
						".whatsapp.HandshakeMessage.ClientFinishH" +
						"\002\210\001\001\032u\n\013ClientHello\022\026\n\tephemeral\030\001 \001(\014H\000" +
						"\210\001\001\022\023\n\006static\030\002 \001(\014H\001\210\001\001\022\024\n\007payload\030\003 \001(" +
						"\014H\002\210\001\001B\014\n\n_ephemeralB\t\n\007_staticB\n\n\010_payl" +
						"oad\032u\n\013ServerHello\022\026\n\tephemeral\030\001 \001(\014H\000\210" +
						"\001\001\022\023\n\006static\030\002 \001(\014H\001\210\001\001\022\024\n\007payload\030\003 \001(\014" +
						"H\002\210\001\001B\014\n\n_ephemeralB\t\n\007_staticB\n\n\010_paylo" +
						"ad\032P\n\014ClientFinish\022\023\n\006static\030\001 \001(\014H\000\210\001\001\022" +
						"\024\n\007payload\030\002 \001(\014H\001\210\001\001B\t\n\007_staticB\n\n\010_pay" +
						"loadB\017\n\r_client_helloB\017\n\r_server_helloB\020" +
						"\n\016_client_finish\"\204\002\n\020NoiseCertificate\022\024\n" +
						"\007details\030\001 \001(\014H\000\210\001\001\022\026\n\tsignature\030\002 \001(\014H\001" +
						"\210\001\001\032\247\001\n\007Details\022\023\n\006serial\030\001 \001(\rH\000\210\001\001\022\023\n\006" +
						"issuer\030\002 \001(\tH\001\210\001\001\022\024\n\007expires\030\003 \001(\004H\002\210\001\001\022" +
						"\024\n\007subject\030\004 \001(\tH\003\210\001\001\022\020\n\003key\030\005 \001(\014H\004\210\001\001B" +
						"\t\n\007_serialB\t\n\007_issuerB\n\n\010_expiresB\n\n\010_su" +
						"bjectB\006\n\004_keyB\n\n\010_detailsB\014\n\n_signature\"" +
						"\344 \n\rClientPayload\022\025\n\010username\030\001 \001(\004H\000\210\001\001" +
						"\022\024\n\007passive\030\003 \001(\010H\001\210\001\001\022>\n\017client_feature" +
						"s\030\004 \003(\0162%.whatsapp.ClientPayload.ClientF" +
						"eature\022:\n\nuser_agent\030\005 \001(\0132!.whatsapp.Cl" +
						"ientPayload.UserAgentH\002\210\001\001\0226\n\010web_info\030\006" +
						" \001(\0132\037.whatsapp.ClientPayload.WebInfoH\003\210" +
						"\001\001\022\026\n\tpush_name\030\007 \001(\tH\004\210\001\001\022\027\n\nsession_id" +
						"\030\t \001(\017H\005\210\001\001\022\032\n\rshort_connect\030\n \001(\010H\006\210\001\001\022" +
						"G\n\021ios_app_extension\030\036 \001(\0162\'.whatsapp.Cl" +
						"ientPayload.IOSAppExtensionH\007\210\001\001\022>\n\014conn" +
						"ect_type\030\014 \001(\0162#.whatsapp.ClientPayload." +
						"ConnectTypeH\010\210\001\001\022B\n\016connect_reason\030\r \001(\016" +
						"2%.whatsapp.ClientPayload.ConnectReasonH" +
						"\t\210\001\001\022\016\n\006shards\030\016 \003(\017\022:\n\ndns_source\030\017 \001(\013" +
						"2!.whatsapp.ClientPayload.DNSSourceH\n\210\001\001" +
						"\022\"\n\025connect_attempt_count\030\020 \001(\rH\013\210\001\001\022\022\n\005" +
						"agent\030\021 \001(\rH\014\210\001\001\022\023\n\006device\030\022 \001(\rH\r\210\001\001\022?\n" +
						"\010reg_data\030\023 \001(\0132(.whatsapp.ClientPayload" +
						".CompanionRegDataH\016\210\001\001\032\223\t\n\tUserAgent\022A\n\010" +
						"platform\030\001 \001(\0162*.whatsapp.ClientPayload." +
						"UserAgent.PlatformH\000\210\001\001\022F\n\013app_version\030\002" +
						" \001(\0132,.whatsapp.ClientPayload.UserAgent." +
						"AppVersionH\001\210\001\001\022\020\n\003mcc\030\003 \001(\tH\002\210\001\001\022\020\n\003mnc" +
						"\030\004 \001(\tH\003\210\001\001\022\027\n\nos_version\030\005 \001(\tH\004\210\001\001\022\031\n\014" +
						"manufacturer\030\006 \001(\tH\005\210\001\001\022\023\n\006device\030\007 \001(\tH" +
						"\006\210\001\001\022\034\n\017os_build_number\030\010 \001(\tH\007\210\001\001\022\025\n\010ph" +
						"one_id\030\t \001(\tH\010\210\001\001\022N\n\017release_channel\030\n \001" +
						"(\01620.whatsapp.ClientPayload.UserAgent.Re" +
						"leaseChannelH\t\210\001\001\022&\n\031locale_language_iso" +
						"_639_1\030\013 \001(\tH\n\210\001\001\022-\n local_country_iso_3" +
						"166_1_alpha_2\030\014 \001(\tH\013\210\001\001\022\031\n\014device_board" +
						"\030\r \001(\tH\014\210\001\001\032\240\001\n\nAppVersion\022\024\n\007primary\030\001 " +
						"\001(\rH\000\210\001\001\022\026\n\tsecondary\030\002 \001(\rH\001\210\001\001\022\025\n\010tert" +
						"iary\030\003 \001(\rH\002\210\001\001\022\027\n\nquaternary\030\004 \001(\rH\003\210\001\001" +
						"B\n\n\010_primaryB\014\n\n_secondaryB\013\n\t_tertiaryB" +
						"\r\n\013_quaternary\"\323\001\n\010Platform\022\013\n\007ANDROID\020\000" +
						"\022\007\n\003IOS\020\001\022\021\n\rWINDOWS_PHONE\020\002\022\016\n\nBLACKBER" +
						"RY\020\003\022\017\n\013BLACKBERRYX\020\004\022\007\n\003S40\020\005\022\007\n\003S60\020\006\022" +
						"\021\n\rPYTHON_CLIENT\020\007\022\t\n\005TIZEN\020\010\022\016\n\nENTERPR" +
						"ISE\020\t\022\017\n\013SMB_ANDROID\020\n\022\t\n\005KAIOS\020\013\022\013\n\007SMB" +
						"_IOS\020\014\022\013\n\007WINDOWS\020\r\022\007\n\003WEB\020\016\"=\n\016ReleaseC" +
						"hannel\022\013\n\007RELEASE\020\000\022\010\n\004BETA\020\001\022\t\n\005ALPHA\020\002" +
						"\022\t\n\005DEBUG\020\003B\013\n\t_platformB\016\n\014_app_version" +
						"B\006\n\004_mccB\006\n\004_mncB\r\n\013_os_versionB\017\n\r_manu" +
						"facturerB\t\n\007_deviceB\022\n\020_os_build_numberB" +
						"\013\n\t_phone_idB\022\n\020_release_channelB\034\n\032_loc" +
						"ale_language_iso_639_1B#\n!_local_country" +
						"_iso_3166_1_alpha_2B\017\n\r_device_board\032\241\007\n" +
						"\007WebInfo\022\026\n\tref_token\030\001 \001(\tH\000\210\001\001\022\024\n\007vers" +
						"ion\030\002 \001(\tH\001\210\001\001\022F\n\014webd_payload\030\003 \001(\0132+.w" +
						"hatsapp.ClientPayload.WebInfo.WebdPayloa" +
						"dH\002\210\001\001\032\265\005\n\013WebdPayload\022$\n\027uses_participa" +
						"nt_in_key\030\001 \001(\010H\000\210\001\001\022*\n\031supports_starred" +
						"_messages\030\002 \001(\010B\002\030\001H\001\210\001\001\022+\n\032supports_doc" +
						"ument_messages\030\003 \001(\010B\002\030\001H\002\210\001\001\022&\n\025support" +
						"s_url_messages\030\004 \001(\010B\002\030\001H\003\210\001\001\022%\n\024support" +
						"s_media_retry\030\005 \001(\010B\002\030\001H\004\210\001\001\022#\n\022supports" +
						"_e2e_image\030\006 \001(\010B\002\030\001H\005\210\001\001\022#\n\022supports_e2" +
						"e_video\030\007 \001(\010B\002\030\001H\006\210\001\001\022#\n\022supports_e2e_a" +
						"udio\030\010 \001(\010B\002\030\001H\007\210\001\001\022&\n\025supports_e2e_docu" +
						"ment\030\t \001(\010B\002\030\001H\010\210\001\001\022\037\n\016document_types\030\n " +
						"\001(\tB\002\030\001H\t\210\001\001\022\025\n\010features\030\013 \001(\014H\n\210\001\001B\032\n\030_" +
						"uses_participant_in_keyB\034\n\032_supports_sta" +
						"rred_messagesB\035\n\033_supports_document_mess" +
						"agesB\030\n\026_supports_url_messagesB\027\n\025_suppo" +
						"rts_media_retryB\025\n\023_supports_e2e_imageB\025" +
						"\n\023_supports_e2e_videoB\025\n\023_supports_e2e_a" +
						"udioB\030\n\026_supports_e2e_documentB\021\n\017_docum" +
						"ent_typesB\013\n\t_features\"=\n\016ReleaseChannel" +
						"\022\013\n\007RELEASE\020\000\022\010\n\004BETA\020\001\022\t\n\005ALPHA\020\002\022\t\n\005DE" +
						"BUG\020\003B\014\n\n_ref_tokenB\n\n\010_versionB\017\n\r_webd" +
						"_payload\032\354\001\n\tDNSSource\022N\n\ndns_method\030\017 \001" +
						"(\01625.whatsapp.ClientPayload.DNSSource.DN" +
						"SResolutionMethodH\000\210\001\001\022\027\n\napp_cached\030\020 \001" +
						"(\010H\001\210\001\001\"X\n\023DNSResolutionMethod\022\n\n\006SYSTEM" +
						"\020\000\022\n\n\006GOOGLE\020\001\022\r\n\tHARDCODED\020\002\022\014\n\010OVERRID" +
						"E\020\003\022\014\n\010FALLBACK\020\004B\r\n\013_dns_methodB\r\n\013_app" +
						"_cached\032\314\002\n\020CompanionRegData\022\024\n\007e_regid\030" +
						"\001 \001(\014H\000\210\001\001\022\026\n\te_keytype\030\002 \001(\014H\001\210\001\001\022\024\n\007e_" +
						"ident\030\003 \001(\014H\002\210\001\001\022\026\n\te_skey_id\030\004 \001(\014H\003\210\001\001" +
						"\022\027\n\ne_skey_val\030\005 \001(\014H\004\210\001\001\022\027\n\ne_skey_sig\030" +
						"\006 \001(\014H\005\210\001\001\022\027\n\nbuild_hash\030\007 \001(\014H\006\210\001\001\022\034\n\017c" +
						"ompanion_props\030\010 \001(\014H\007\210\001\001B\n\n\010_e_regidB\014\n" +
						"\n_e_keytypeB\n\n\010_e_identB\014\n\n_e_skey_idB\r\n" +
						"\013_e_skey_valB\r\n\013_e_skey_sigB\r\n\013_build_ha" +
						"shB\022\n\020_companion_props\"\031\n\rClientFeature\022" +
						"\010\n\004NONE\020\000\"T\n\017IOSAppExtension\022\023\n\017SHARE_EX" +
						"TENSION\020\000\022\025\n\021SERVICE_EXTENSION\020\001\022\025\n\021INTE" +
						"NTS_EXTENSION\020\002\"y\n\rConnectReason\022\010\n\004PUSH" +
						"\020\000\022\022\n\016USER_ACTIVATED\020\001\022\r\n\tSCHEDULED\020\002\022\023\n" +
						"\017ERROR_RECONNECT\020\003\022\022\n\016NETWORK_SWITCH\020\004\022\022" +
						"\n\016PING_RECONNECT\020\005\"\260\002\n\013ConnectType\022\024\n\020CE" +
						"LLULAR_UNKNOWN\020\000\022\020\n\014WIFI_UNKNOWN\020\001\022\021\n\rCE" +
						"LLULAR_EDGE\020d\022\021\n\rCELLULAR_IDEN\020e\022\021\n\rCELL" +
						"ULAR_UMTS\020f\022\021\n\rCELLULAR_EVDO\020g\022\021\n\rCELLUL" +
						"AR_GPRS\020h\022\022\n\016CELLULAR_HSDPA\020i\022\022\n\016CELLULA" +
						"R_HSUPA\020j\022\021\n\rCELLULAR_HSPA\020k\022\021\n\rCELLULAR" +
						"_CDMA\020l\022\022\n\016CELLULAR_1XRTT\020m\022\022\n\016CELLULAR_" +
						"EHRPD\020n\022\020\n\014CELLULAR_LTE\020o\022\022\n\016CELLULAR_HS" +
						"PAP\020pB\013\n\t_usernameB\n\n\010_passiveB\r\n\013_user_" +
						"agentB\013\n\t_web_infoB\014\n\n_push_nameB\r\n\013_ses" +
						"sion_idB\020\n\016_short_connectB\024\n\022_ios_app_ex" +
						"tensionB\017\n\r_connect_typeB\021\n\017_connect_rea" +
						"sonB\r\n\013_dns_sourceB\030\n\026_connect_attempt_c" +
						"ountB\010\n\006_agentB\t\n\007_deviceB\013\n\t_reg_dataB\024" +
						"\n\022com.whatsapp.protob\006proto3"
		};
		descriptor = com.google.protobuf.Descriptors.FileDescriptor
				.internalBuildGeneratedFileFrom(descriptorData,
						new com.google.protobuf.Descriptors.FileDescriptor[] {
						});
		internal_static_whatsapp_HandshakeMessage_descriptor =
				getDescriptor().getMessageTypes().get(0);
		internal_static_whatsapp_HandshakeMessage_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_HandshakeMessage_descriptor,
				new java.lang.String[] { "ClientHello", "ServerHello", "ClientFinish", "ClientHello", "ServerHello", "ClientFinish", });
		internal_static_whatsapp_HandshakeMessage_ClientHello_descriptor =
				internal_static_whatsapp_HandshakeMessage_descriptor.getNestedTypes().get(0);
		internal_static_whatsapp_HandshakeMessage_ClientHello_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_HandshakeMessage_ClientHello_descriptor,
				new java.lang.String[] { "Ephemeral", "Static", "Payload", "Ephemeral", "Static", "Payload", });
		internal_static_whatsapp_HandshakeMessage_ServerHello_descriptor =
				internal_static_whatsapp_HandshakeMessage_descriptor.getNestedTypes().get(1);
		internal_static_whatsapp_HandshakeMessage_ServerHello_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_HandshakeMessage_ServerHello_descriptor,
				new java.lang.String[] { "Ephemeral", "Static", "Payload", "Ephemeral", "Static", "Payload", });
		internal_static_whatsapp_HandshakeMessage_ClientFinish_descriptor =
				internal_static_whatsapp_HandshakeMessage_descriptor.getNestedTypes().get(2);
		internal_static_whatsapp_HandshakeMessage_ClientFinish_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_HandshakeMessage_ClientFinish_descriptor,
				new java.lang.String[] { "Static", "Payload", "Static", "Payload", });
		internal_static_whatsapp_NoiseCertificate_descriptor =
				getDescriptor().getMessageTypes().get(1);
		internal_static_whatsapp_NoiseCertificate_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_NoiseCertificate_descriptor,
				new java.lang.String[] { "Details", "Signature", "Details", "Signature", });
		internal_static_whatsapp_NoiseCertificate_Details_descriptor =
				internal_static_whatsapp_NoiseCertificate_descriptor.getNestedTypes().get(0);
		internal_static_whatsapp_NoiseCertificate_Details_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_NoiseCertificate_Details_descriptor,
				new java.lang.String[] { "Serial", "Issuer", "Expires", "Subject", "Key", "Serial", "Issuer", "Expires", "Subject", "Key", });
		internal_static_whatsapp_ClientPayload_descriptor =
				getDescriptor().getMessageTypes().get(2);
		internal_static_whatsapp_ClientPayload_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_ClientPayload_descriptor,
				new java.lang.String[] { "Username", "Passive", "ClientFeatures", "UserAgent", "WebInfo", "PushName", "SessionId", "ShortConnect", "IosAppExtension", "ConnectType", "ConnectReason", "Shards", "DnsSource", "ConnectAttemptCount", "Agent", "Device", "RegData", "Username", "Passive", "UserAgent", "WebInfo", "PushName", "SessionId", "ShortConnect", "IosAppExtension", "ConnectType", "ConnectReason", "DnsSource", "ConnectAttemptCount", "Agent", "Device", "RegData", });
		internal_static_whatsapp_ClientPayload_UserAgent_descriptor =
				internal_static_whatsapp_ClientPayload_descriptor.getNestedTypes().get(0);
		internal_static_whatsapp_ClientPayload_UserAgent_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_ClientPayload_UserAgent_descriptor,
				new java.lang.String[] { "Platform", "AppVersion", "Mcc", "Mnc", "OsVersion", "Manufacturer", "Device", "OsBuildNumber", "PhoneId", "ReleaseChannel", "LocaleLanguageIso6391", "LocalCountryIso31661Alpha2", "DeviceBoard", "Platform", "AppVersion", "Mcc", "Mnc", "OsVersion", "Manufacturer", "Device", "OsBuildNumber", "PhoneId", "ReleaseChannel", "LocaleLanguageIso6391", "LocalCountryIso31661Alpha2", "DeviceBoard", });
		internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_descriptor =
				internal_static_whatsapp_ClientPayload_UserAgent_descriptor.getNestedTypes().get(0);
		internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_ClientPayload_UserAgent_AppVersion_descriptor,
				new java.lang.String[] { "Primary", "Secondary", "Tertiary", "Quaternary", "Primary", "Secondary", "Tertiary", "Quaternary", });
		internal_static_whatsapp_ClientPayload_WebInfo_descriptor =
				internal_static_whatsapp_ClientPayload_descriptor.getNestedTypes().get(1);
		internal_static_whatsapp_ClientPayload_WebInfo_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_ClientPayload_WebInfo_descriptor,
				new java.lang.String[] { "RefToken", "Version", "WebdPayload", "RefToken", "Version", "WebdPayload", });
		internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_descriptor =
				internal_static_whatsapp_ClientPayload_WebInfo_descriptor.getNestedTypes().get(0);
		internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_ClientPayload_WebInfo_WebdPayload_descriptor,
				new java.lang.String[] { "UsesParticipantInKey", "SupportsStarredMessages", "SupportsDocumentMessages", "SupportsUrlMessages", "SupportsMediaRetry", "SupportsE2EImage", "SupportsE2EVideo", "SupportsE2EAudio", "SupportsE2EDocument", "DocumentTypes", "Features", "UsesParticipantInKey", "SupportsStarredMessages", "SupportsDocumentMessages", "SupportsUrlMessages", "SupportsMediaRetry", "SupportsE2EImage", "SupportsE2EVideo", "SupportsE2EAudio", "SupportsE2EDocument", "DocumentTypes", "Features", });
		internal_static_whatsapp_ClientPayload_DNSSource_descriptor =
				internal_static_whatsapp_ClientPayload_descriptor.getNestedTypes().get(2);
		internal_static_whatsapp_ClientPayload_DNSSource_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_ClientPayload_DNSSource_descriptor,
				new java.lang.String[] { "DnsMethod", "AppCached", "DnsMethod", "AppCached", });
		internal_static_whatsapp_ClientPayload_CompanionRegData_descriptor =
				internal_static_whatsapp_ClientPayload_descriptor.getNestedTypes().get(3);
		internal_static_whatsapp_ClientPayload_CompanionRegData_fieldAccessorTable = new
				com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
				internal_static_whatsapp_ClientPayload_CompanionRegData_descriptor,
				new java.lang.String[] { "ERegid", "EKeytype", "EIdent", "ESkeyId", "ESkeyVal", "ESkeySig", "BuildHash", "CompanionProps", "ERegid", "EKeytype", "EIdent", "ESkeyId", "ESkeyVal", "ESkeySig", "BuildHash", "CompanionProps", });
	}

	// @@protoc_insertion_point(outer_class_scope)
}