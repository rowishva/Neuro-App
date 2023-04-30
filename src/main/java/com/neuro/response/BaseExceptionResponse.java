package com.neuro.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;
	private String errorCode;
	private String errorMessage;
	private List<String> errorDetails;

}
