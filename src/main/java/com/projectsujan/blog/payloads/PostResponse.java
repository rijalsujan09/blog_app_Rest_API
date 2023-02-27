package com.projectsujan.blog.payloads;

import java.util.List;

import com.fasterxml.jackson.databind.node.BooleanNode;

public class PostResponse {

	private List<PostDto> contentDtos;
	private int pageNumber;
	private int pageSize;
	private Long totalElemnets;
	private int totalPages;
	private Boolean lastPage;
	
	
	
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public List<PostDto> getContentDtos() {
		return contentDtos;
	}
	public void setContentDtos(List<PostDto> contentDtos) {
		this.contentDtos = contentDtos;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalElemnets() {
		return totalElemnets;
	}
	public void setTotalElemnets(Long totalElemnets) {
		this.totalElemnets = totalElemnets;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public Boolean getLastPage() {
		return lastPage;
	}
	public void setLastPage(Boolean lastPage) {
		this.lastPage = lastPage;
	}
	
	

}
