package cn.cdu.fang.web.utill;

public class Paging {
	public static int showNum = 5;
	protected final static String BASE = "home?currentPage="; 
	/**
	 * 
	 * <ul>
          <li class="disabled"><a href="#" title="点击去到第一页">&laquo; 第一页</a></li>
          <li><a href="#" title="上一页">&larr;</a></li>
          <li class="active"><a href="#">1</a></li>
          <li><a href="#">2</a></li>
          <li><a href="#">..</a></li>
          <li><a href="#">8</a></li>
          <li><a href="#">9</a></li>
          <li><a href="#" title="下一页">&rarr;</a></li>
          <li><a href="#" title="跳转到最后一页">最后一页 &raquo;</a></li>
        </ul>
	 * 
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param tottlePage
	 * @return
	 */
	public static String pagingScript(int currentPage,int pageSize,int tottlePage){
		StringBuilder sb = new StringBuilder();
		sb.append("<ul>");
		sb.append("<li "+(currentPage != 0 ? "" :"class=\"disabled\"")+"><a href=\""+BASE+"0\" title=\"点击去到第一页\">&laquo; 第一页</a></li>");
		if(0 <= currentPage && currentPage < tottlePage-1) sb.append(" <li><a href=\""+BASE+(currentPage + 1)+"\" title=\"下一页\">&rarr;</a></li>");
		
		if(tottlePage >= 0 && tottlePage <= showNum){
			//直接显示
			sb.append(add2sb(0,tottlePage,currentPage));
		}else{
			if(currentPage < showNum / 2){
				sb.append(add2sb(tottlePage / 2 - showNum / 2 , tottlePage / 2 - 1,currentPage));
				
				sb.append("<li><a href=\""+BASE+(currentPage+1)+"\">..</a></li>");
				
				sb.append(add2sb(tottlePage / 2, tottlePage-2,currentPage));
			}
			if(currentPage > showNum / 2 && currentPage < (tottlePage - showNum / 2)){
				sb.append(add2sb(currentPage - showNum / 2, currentPage-1,currentPage));
				
				sb.append("<li><a href=\""+BASE+(currentPage+1)+"\">..</a></li>");
				
				sb.append(add2sb(currentPage ,currentPage + showNum / 2,currentPage));
			}
			if(currentPage > (tottlePage - showNum / 2)){
				sb.append(add2sb(tottlePage / 2 - showNum / 2, tottlePage / 2,currentPage));
				
				sb.append("<li><a href=\""+BASE+(currentPage+1)+"\">..</a></li>");
				
				sb.append(add2sb(tottlePage / 2,tottlePage - 2,currentPage));
			}
			
			
		}
		
		if(currentPage > 0 && currentPage < tottlePage) sb.append(" <li><a href=\""+BASE+(currentPage-1)+"\" title=\"下一页\">&rarr;</a></li>");
		if(currentPage > 0 && currentPage < tottlePage) sb.append("<li "+(currentPage != (tottlePage-1) ? "" :"class=\"disabled\"")+"><a href=\""+BASE+(tottlePage-1)+"\" title=\"跳转到最后一页\">最后一页 &raquo;</a></li>");
		sb.append("<ul>");
		return sb.toString();
	}
	
	private static String add2sb(int begain,int end,int current){
		StringBuilder sb = new StringBuilder();
		for(int i=begain;i<end;i++){
			if(i == current) continue;
			sb.append("<li><a href=\""+BASE+i+"\">"+(i+1)+"</a></li>");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(pagingScript(0,5,1));
	}
}
