package imageboard.bean;

import lombok.Data;

@Data
public class ImageboardPaging {
	private int currentPage;//占쎌겱占쎌삺占쎈읂占쎌뵠筌욑옙
	private int pageBlock;//[占쎌뵠占쎌읈][1][2][3][占쎈뼄占쎌벉]
	private int pageSize;//1占쎈읂占쎌뵠筌욑옙占쎈뼣 5揶쏆뮇逾�
	private int totalA;//�룯�빓占쏙옙�땾
	private StringBuffer pagingHTML;
	
	public void makePagingHTML(){
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA+pageSize-1)/pageSize;//�룯�빜�읂占쎌뵠筌욑옙占쎈땾
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage > totalP) 
			endPage = totalP;
		
		if(startPage>pageBlock)
			pagingHTML.append("[<a id='paging' href='imageboardList.do?pg="+(startPage-1)+"'>이전</a>]");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i==currentPage)
				pagingHTML.append("[<a id='currentPaging' href='imageboardList.do?pg="+i+"'>"+i+"</a>]");
			else
				pagingHTML.append("[<a id='paging' href='imageboardList.do?pg="+i+"'>"+i+"</a>]");
		}
		
		if(endPage < totalP)
			pagingHTML.append("[<a id='paging' href='imageboardList.do?pg="+(endPage+1)+"'>다음</a>]");
	}
	
	public void makeSearchPagingHTML(String keyword){
		pagingHTML = new StringBuffer();
		
		int totalP = (totalA+pageSize-1)/pageSize;//�룯�빜�읂占쎌뵠筌욑옙占쎈땾
		
		int startPage = (currentPage-1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage > totalP) 
			endPage = totalP;
		
		if(startPage>pageBlock)
			pagingHTML.append("[<a id='paging' href='boardSearch.do?pg="+(startPage-1)+"&search="+keyword+"'>이전</a>]");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i==currentPage)
				pagingHTML.append("[<a id='currentPaging' href='boardSearch.do?pg="+i+"&search="+keyword+"'>"+i+"</a>]");
			else
				pagingHTML.append("[<a id='paging' href='boardSearch.do?pg="+i+"&search="+keyword+"'>"+i+"</a>]");
		}
		
		if(endPage < totalP)
			pagingHTML.append("[<a id='paging' href='boardSearch.do?pg="+(endPage+1)+"&search="+keyword+"'>다음</a>]");
	}
	
	
}


























