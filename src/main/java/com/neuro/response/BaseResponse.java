package com.neuro.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int status;
	private String message;
	private T content;
	private List<T> contentList;

}
