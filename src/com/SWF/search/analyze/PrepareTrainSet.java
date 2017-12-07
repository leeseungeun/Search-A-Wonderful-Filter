package com.SWF.search.analyze;

import java.util.List;

import com.SWF.search.dto.SearchDTO;

public class PrepareTrainSet {

	public static void main(String[] args) throws Exception {

		List<SearchDTO> urls = new GetUrlList().getUrlList(400,"");

		String bannerWhite	="http://blogimgs.naver.net/nblog/mylog/post/gr_white.gif";
		String bannerGreen	="http://blogimgs.naver.net/nblog/mylog/post/gr_green.gif";
		String bannerGray	="http://blogimgs.naver.net/nblog/mylog/post/gr_gray.gif";
		String bannerBlack	="http://blogimgs.naver.net/nblog/mylog/post/gr_black.gif";

		String widget 		="http://blogimgs.naver.net/nblog/widget/greenreviewWidget.png";

		String weble = "https://weble.net";
		String seoulouba = "https://seoulouba.co.kr";
		String withblog="https://withblog.net";
		String reviewplace="http://reviewplace.co.kr";
		String modu="http://modublog.cdn2.cafe24.com/widget/modublog.jpg";
		String dia="https://stat.dia-blog.co.kr/widget/";

		for(int i=0;i<urls.size();i++){

			SearchDTO sDto = urls.get(i);

			String url = sDto.getUrl();

			String dom = new GetDOM().dom2String(url);

			List<String> imgs = new ParseDOM().getParsedElement(dom, "img", "src");


			for(int j=0;j<imgs.size();j++){

				String img = imgs.get(j);

				if(img.contains(widget)
						||img.contains(bannerWhite)
						||img.contains(bannerGreen)
						||img.contains(bannerGray)
						||img.contains(bannerBlack)
						||img.contains(dia)){


					String fileName = url.substring(url.lastIndexOf('?')+1);
					String location = "E:\\SWFServer\\train\\nonad\\"+fileName+".txt";

					new PrepareDataSet().saveDataWithDom(dom, location);

				} else if(img.contains(weble)
						||img.contains(seoulouba)
						||img.contains(withblog)
						||img.contains(reviewplace)
						||img.contains(modu)){

					String fileName = url.substring(url.lastIndexOf('?')+1);
					String location = "E:\\SWFServer\\train\\ad\\"+fileName+".txt";

					new PrepareDataSet().saveDataWithDom(dom, location);

				}

			}

		}

	}
}
