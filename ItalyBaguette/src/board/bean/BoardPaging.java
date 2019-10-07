package board.bean;

import lombok.Data;

@Data
public class BoardPaging {
	private int currentPage;//�뜝�럩寃긷뜝�럩�궨�뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕
	private int pageBlock;//[�뜝�럩逾졾뜝�럩�쓧][1][2][3][�뜝�럥堉꾢뜝�럩踰�]
	private int pageSize;//1�뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�뜝�럥堉� 5�뤆�룇裕뉔�억옙
	private int totalA;//占쎈／占쎈퉻�뜝�룞�삕占쎈빢
	private StringBuffer pagingHTML;
	
	public void makePagingHTML(){
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA+pageSize-1)/pageSize;//占쎈／占쎈튇占쎌쓡�뜝�럩逾좂춯�쉻�삕�뜝�럥�빢
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage > totalP) 
			endPage = totalP;
		
		if(startPage>pageBlock)
			pagingHTML.append("[<a id='paging' href='QNAList.do?pg="+(startPage-1)+"'>이전</a>]");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i==currentPage)
				pagingHTML.append("[<a id='currentPaging' href='QNAList.do?pg="+i+"'>"+i+"</a>]");
			else
				pagingHTML.append("[<a id='paging' href='QNAList.do?pg="+i+"'>"+i+"</a>]");
		}
		
		if(endPage < totalP)
			pagingHTML.append("[<a id='paging' href='QNAList.do?pg="+(endPage+1)+"'>다음</a>]");
	}
	
	public void makeSearchPagingHTML(String keyword,String option){
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA+pageSize-1)/pageSize;//占쎈／占쎈튇占쎌쓡�뜝�럩逾좂춯�쉻�삕�뜝�럥�빢
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage > totalP) 
			endPage = totalP;
		
		if(startPage>pageBlock)
			pagingHTML.append("[<a id='paging' href='boardSearch.do?pg="+(startPage-1)+"&search="+keyword+"&searchOption="+option+"'>다음</a>]");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i==currentPage)
				pagingHTML.append("[<a id='currentPaging' href='boardSearch.do?pg="+i+"&search="+keyword+"&searchOption="+option+"'>"+i+"</a>]");
			else
				pagingHTML.append("[<a id='paging' href='boardSearch.do?pg="+i+"&search="+keyword+"&searchOption="+option+"'>"+i+"</a>]");
		}
		
		if(endPage < totalP)
			pagingHTML.append("[<a id='paging' href='boardSearch.do?pg="+(endPage+1)+"&search="+keyword+"&searchOption="+option+"'>다음</a>]");
	}
	
	
}


























