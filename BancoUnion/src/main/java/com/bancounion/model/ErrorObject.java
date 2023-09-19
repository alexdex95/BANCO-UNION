package com.bancounion.model;

import java.time.LocalDateTime;

public class ErrorObject {

	private int status;
	private String message;
	private LocalDateTime timestamp;

	public int getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public ErrorObject() {
	}

	public ErrorObject(ErrorObjectBuilder builder) {
		this.status = builder.status;
		this.message = builder.message;
		this.timestamp = builder.timestamp;
	}

	public static class ErrorObjectBuilder {

		private int status;
		private String message;
		private LocalDateTime timestamp;

		public ErrorObjectBuilder status(int status) {
			this.status = status;
			return this;
		}

		public ErrorObjectBuilder message(String message) {
			this.message = message;
			return this;
		}

		public ErrorObjectBuilder timestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public ErrorObject builder() {
			return new ErrorObject(this);
		}
	}
}
