package com.SWF.search.analyze;

import java.util.List;

import com.SWF.search.dto.SearchDTO;

public class PrepareTrainSetMan {

	public static void main(String[] args) throws Exception {

		String [] ad = {
				"http://blog.naver.com/labelle0073/221027179313"
			,	"http://blog.naver.com/200303117/221028853008"
			,	"http://blog.naver.com/embalming/221028921555"
			/*	"http://blog.naver.com/ppopporr33/221009170443"
			,	"http://blog.naver.com/yyl8271/220809346554"
			,	"http://blog.naver.com/jamjma98/220718433042"
			,	"http://blog.naver.com/theboni/220034382975"
			,	"http://blog.naver.com/meeyoung6257/220671899536"
			,	"http://blog.naver.com/kakunglove/220771638415"
			,	"http://blog.naver.com/hwng777/220931126052"
			,	"http://blog.naver.com/lasmujeres/221011903019"
			,	"http://blog.naver.com/hhe_young/220868642670"
			,	"http://blog.naver.com/hhe_young/220869469741"
			,	"http://blog.naver.com/hhe_young/220872570375"
			,	"http://blog.naver.com/hhe_young/220873083075"
			,	"http://blog.naver.com/hhe_young/220880366423"
			,	"http://blog.naver.com/hhe_young/220882333302"
			,	"http://blog.naver.com/hhe_young/220883173333"
			,	"http://blog.naver.com/caesar0314/221028585668"
			,	"http://blog.naver.com/eunhye7013/221028501737"
			,	"http://blog.naver.com/hhe_young/220884905552"
			,	"http://blog.naver.com/hhe_young/220885387269"
			,	"http://blog.naver.com/hhe_young/220886157339"
			,	"http://blog.naver.com/hhe_young/220886157339"
			,	"http://blog.naver.com/hhe_young/220888078777"
			,	"http://blog.naver.com/hhe_young/220888729910"
			,	"http://blog.naver.com/hhe_young/220892124325"
			,	"http://blog.naver.com/hhe_young/220894078169"
			,	"http://blog.naver.com/midorius/220919418328"
			,	"http://blog.naver.com/ioymonsj/220984810184"
			,	"http://blog.naver.com/wonah77/220860294247"
			,	"http://blog.naver.com/1004babystar/220567193405"
			,	"http://blog.naver.com/dlskfk8907/220784766413"
			,	"http://blog.naver.com/rose13min/220974263120"
			,	"http://blog.naver.com/juble93/220736514468"
			,	"http://blog.naver.com/sanaella/220958951458"
			,	"http://blog.naver.com/zinzza925/220959299284"
			,	"http://blog.naver.com/kkssrin/220822394755"
			,	"http://blog.naver.com/hannapride/220247106935"
			,	"http://blog.naver.com/glamping_1004/220688079973"
			,	"http://blog.naver.com/saddmi89/220812741532"
			,	"http://blog.naver.com/jungbokum/220912857660"
			,	"http://blog.naver.com/miyea5/220585133044"
			,	"http://ronesmee.blog.me/221015519457"
			,	"http://blog.naver.com/minajjang11/221015718651"
			,	"http://blog.naver.com/limhj42/221013456452"
			,	"http://knntoday.blog.me/221011446437"
			,	"http://blog.naver.com/limhj42/221015037080"
			,	"http://blog.naver.com/limhj42/221021306822"
			,	"http://blog.naver.com/limhj42/221022992746"
			,	"http://blog.naver.com/limhj42/221005395734"
			,	"http://blog.naver.com/limhj42/220999561146"
			,	"http://blog.naver.com/jungbokum/220913553714"
			,	"http://blog.naver.com/jungbokum/220916736630"
			,	"http://blog.naver.com/jungbokum/220916736630"
			,	"http://blog.naver.com/rose13min/221018498702"
			,	"http://blog.naver.com/rose13min/221023766681"
			,	"http://blog.naver.com/rose13min/221028500209"
			,	"http://blog.naver.com/rose13min/221003679132"
			,	"http://blog.naver.com/rose13min/220995545949"
			,	"http://blog.naver.com/meeyoung6257/221016256346"
			,	"http://blog.naver.com/meeyoung6257/220963104263"
			,	"http://blog.naver.com/woppp123/221028432268"
			,	"http://blog.naver.com/rita0316/221028419816"
			,	"http://blog.naver.com/ljc7152/221028382043"
			,	"http://una216.blog.me/221028325293"
			,	"http://hero720221.blog.me/221028295802"
			,	"http://blog.naver.com/miyabi1229/221028249176"
			,	"http://blog.naver.com/eoqkrwkdid/221028079828"
			,	"http://blog.naver.com/j890402/221027926105"
			,	"http://blog.naver.com/unbias/221027513368"
			,	"http://blog.naver.com/jeeuen730/221027360580"
			,	"http://blog.naver.com/junytwww/221027200960"
			,	"http://blog.naver.com/zelty/221027123146"
			,	"http://blog.naver.com/mjda20/221025756449"
			,	"http://blog.naver.com/asdwasdw0828/221026520107"
			,	"http://blog.naver.com/kilwha/221026016994"
			,	"http://blog.naver.com/sale4638/221024789465"
			,	"http://blog.naver.com/smt0790/221022968720"
			,	"http://blog.naver.com/wjdgus3904/221022910470"
			,	"http://blog.naver.com/jjkkll36/221022861089"
			,	"http://blog.naver.com/jw53090/221022295697"
			,	"http://blog.naver.com/yolo8020/221020100497"
			,	"http://blog.naver.com/hjc050809/221020111112"
			,	"http://blog.naver.com/chrasis/221019535630"
			,	"http://blog.naver.com/in0781/221018866559"
			,	"http://blog.naver.com/ggungdi23/221018852055"
			,	"http://blog.naver.com/kike4476/221018763201"
			,	"http://blog.naver.com/ekdmsdl40/221018597027"
			,	"http://blog.naver.com/newcula/221018484561"
			,	"http://blog.naver.com/zelty/221018394870"
			,	"http://blog.naver.com/rodrod1112/221018367411"
			,	"http://blog.naver.com/foxiong/221018277975"
			,	"http://blog.naver.com/goslane1/221017956359"
			,	"http://blog.naver.com/s-jun06/221017931005"
			,	"http://blog.naver.com/musoi99/221017924098"
			,	"http://blog.naver.com/dlskarb0420/221017331855"
			,	"http://blog.naver.com/pjs060/221017068973"
			,	"http://blog.naver.com/ydl9053/221017078215"
			,	"http://blog.naver.com/smileeyyy/221016949531"
			,	"http://blog.naver.com/yeyeye3030/221016847475"
			,	"http://hero720221.blog.me/221016748797"
			,	"http://didwldnjs0528.blog.me/221016698670"
			,	"http://blog.naver.com/sua101900/221016673925"
			,	"http://blog.naver.com/blueking87/221016581176"
			,	"http://blog.naver.com/k-min0926/221016463516"
			,	"http://blog.naver.com/mj_jong/221016337145"
			,	"http://blog.naver.com/lionyj8723/221016033815"
			,	"http://blog.naver.com/mj_jong/221016237451"
			,	"http://blog.naver.com/eui0903/221015387848"
			,	"http://blog.naver.com/ameriri/221015442547"
			,	"http://blog.naver.com/manybe/221015753678"
			,	"http://blog.naver.com/auddnjs2003/221014652517"
			,	"http://blog.naver.com/foxiong/221014160920"
			,	"http://blog.naver.com/yy3150yy/221014528202"
			,	"http://blog.naver.com/queentr/221014233564"
			,	"http://hero720221.blog.me/221013859327"
			,	"http://blog.naver.com/haebal2/221013057611"
			,	"http://blog.naver.com/7773333/221012392849"
			,	"http://blog.naver.com/musoi99/221012312052"
			,	"http://blog.naver.com/gts2848/221012170901"
			,	"http://blog.naver.com/soran0000/221011874424"
			,	"http://nekoflowercake.blog.me/221011835494"
			,	"http://blog.naver.com/hjuy0331/221011546523"
			,	"http://blog.naver.com/pink-junjun/221011420516"
			,	"http://blog.naver.com/klj236/221011414386"
			,	"http://blog.naver.com/ums0302/221028699286"
			,	"http://blog.naver.com/imjandi/221028660612"
			,	"http://blog.naver.com/testu486/221028652097"
			,	"http://blog.naver.com/dmschd2578/221028620005"
			,	"http://blog.naver.com/thdus0322/221028420538"
			,	"http://blog.naver.com/sey0701/221028618600"
			,	"http://blog.naver.com/jgleea1/221028605547"
			,	"http://blog.naver.com/kittys3/221028603563"
			,	"http://blog.naver.com/mfcg123456/221028558187"
			,	"http://blog.naver.com/grace_baek/221028549940"
			,	"http://blog.naver.com/ssiph/221028484895"
			,	"http://blog.naver.com/moorai79/221028457701"
			,	"http://blog.naver.com/iam_fineboy/221028425904"
			,	"http://blog.naver.com/sugar224/221028404697"
			,	"http://blog.naver.com/violet1418/221028361437"
			,	"http://blog.naver.com/bonnygarri/221028355033"
			,	"http://blog.naver.com/khjj9789/221028276935"
			,	"http://blog.naver.com/sey0701/221028252093"
			,	"http://blog.naver.com/magiccider4/221028220956"
			,	"http://jinha2570.blog.me/221027850948"
			,	"http://titanprj.blog.me/221028080403"
			,	"http://blog.naver.com/yepark0939/221028025330"
			,	"http://kdssl.blog.me/221028336383"
			,	"http://blog.naver.com/bora668/221028649005"
			,	"http://blog.naver.com/tpgusl0511/221028874953"
			,	"http://blog.naver.com/lovelyhju84/221027523966"
			,	"http://blog.naver.com/fkslghdud/221027937275"
			,	"http://blog.naver.com/wls0254/221028227264"
			,	"http://blog.naver.com/tyami/221027720312"
			,	"http://blog.naver.com/comiyo/221027732364"
			,	"http://blog.naver.com/kgoun93/221027718818"
			,	"http://blog.naver.com/moony1031/221027383686"
			,	"http://blog.naver.com/dlwlals0475/221027638365"
			,	"http://blog.naver.com/since_131229/221027317474"
			,	"http://blog.naver.com/tpgusl0511/221027269822"
			,	"http://blog.naver.com/ojchry0/221027238131"
			,	"http://blog.naver.com/jungmi9552/221027655480"
			,	"http://blog.naver.com/mayamikey/221027238450"
			,	"http://blog.naver.com/iplusulove1/221027206746"
			,	"http://blog.naver.com/since_131229/221027173004"
			,	"http://blog.naver.com/rubycellaape/221026968440"
			,	"http://blog.naver.com/sum2_/221026443091"
			,	"http://blog.naver.com/sr3d/221025872511"
			,	"http://blog.naver.com/rkdxk53/221025836378"
			,	"http://blog.naver.com/lips1975/221025707849"
			,	"http://yhj1348.blog.me/221025605899"
			,	"http://blog.naver.com/joohyun1124/221024001945"
			,	"http://blog.naver.com/slowly__/221024068765"
			,	"http://blog.naver.com/dmsdud501/221023913729"
			,	"http://blog.naver.com/iluvkattun/221025212724"
			,	"http://blog.naver.com/opophw/221025171612"
			,	"http://blog.naver.com/ch0466/221025119128"
			,	"http://suj3530.blog.me/221024308836"
			,	"http://blog.naver.com/zeropop0/221024459430"
			,	"http://blog.naver.com/smilekimm/221023956777"
			,	"http://blog.naver.com/gpffps02/221028955483"
			,	"http://blog.naver.com/klj236/221028900286"
			,	"http://blog.naver.com/6900196/221020321547"
			,	"http://blog.naver.com/gmdtnr85/221020802057"
			,	"http://blog.naver.com/ljo9943/221019918415"
			,	"http://blog.naver.com/iamhodu/221015515704"*/
		};
		
		String [] nonad={
				"http://blog.naver.com/sujinizzz/220906641437"
			,	"http://blog.naver.com/kachisan/221004757153"
			,	"http://blog.naver.com/jihyun21020/220932923899"
			,	"http://blog.naver.com/pin1973/220988720222"
			,	"http://njw321.blog.me/220352306677"
			,	"http://aeri209.blog.me/220977675015"
			,	"http://blog.naver.com/gjr1215/220171696880"
			,	"http://blog.naver.com/sibs14pd/220398235854"
			,	"http://frees3104.blog.me/220996083023"
			,	"http://blog.naver.com/uhakplan2005/221011236984"
			,	"http://blog.naver.com/volkynet/220802288403"
			,	"http://blog.naver.com/workersj/220889290264"
			,	"http://blog.naver.com/urinee/220588323152"
			,	"http://blog.naver.com/dhappy7/220376933556"
			,	"http://blog.naver.com/sosodeaf/120077955"
			,	"http://blog.naver.com/autopeed0050/221012140861"
			,	"http://blog.naver.com/ironsy-/221024822721"
			,	"http://stellaohn.blog.me/221026829805"
			,	"http://blog.naver.com/sagak815/220971090139"
			,	"http://blog.naver.com/soonyonghan/220695549530"
			,	"http://blog.naver.com/sil724/100107170696"
			,	"http://blog.naver.com/asuka1204/220998646207"
			,	"http://blog.naver.com/min02090/220889435253"
			,	"http://blog.naver.com/uopt1080/220704094575"
			,	"http://cozy95.blog.me/221013429656"
			,	"http://blog.naver.com/miyea5/220608641055"
			,	"http://blog.naver.com/cocoachu22/220800315203"
			,	"http://blog.naver.com/atw4733/221016411805"
			,	"http://blog.naver.com/hooshia/221016110388"
			,	"http://blog.naver.com/mokamommy/221015372294"
			,	"http://blog.naver.com/hogam2007/221028665672"
			,	"http://yoyomakit.blog.me/221028504458"
			,	"http://blog.naver.com/egotism1229/40162890083"
			,	"http://blog.naver.com/jjongni7/220978041280"
			,	"http://blog.naver.com/ofagirl/220738664733"
			,	"http://baeyujinavi.blog.me/220934019295"
			,	"http://blog.naver.com/angelquick/221028740897"
			,	"http://blog.naver.com/lskimch/221028781857"
			,	"http://blog.naver.com/sunjinhye/221027493766"
			,	"http://blog.naver.com/soulbae4/220916025824"
			,	"http://blog.naver.com/kamijoy/221016714436"
			,	"http://blog.naver.com/ph2613/220978450299"
			,	"http://blog.naver.com/sjbaik32/220982669712"
			,	"http://blog.naver.com/sjbaik32/220985647767"
			,	"http://blog.naver.com/sjbaik32/221000188863"
			,	"http://blog.naver.com/sjbaik32/221008915606"
			,	"http://blog.naver.com/sjbaik32/221008919761"
			,	"http://blog.naver.com/sjbaik32/221010208043"
			,	"http://blog.naver.com/sjbaik32/221010215587"
			,	"http://blog.naver.com/sjbaik32/221018736389"
			,	"http://blog.naver.com/sjbaik32/221018739595"
			,	"http://blog.naver.com/sjbaik32/221020374024"
			,	"http://blog.naver.com/sjbaik32/221022087773"
			,	"http://blog.naver.com/sjbaik32/221023905234"
		};
		
		List<SearchDTO> adUrls = new GetUrlList().getUrlListMan(ad);
		List<SearchDTO> nonadUrls = new GetUrlList().getUrlListMan(nonad);

		for(int i=0;i<adUrls.size();i++){

			SearchDTO sDto = adUrls.get(i);

			String url = sDto.getUrl();

			String dom = new GetDOM().dom2String(url);




			String fileName = url.substring(url.lastIndexOf('?')+1);
			String location = "E:\\SWFServer\\train\\ad\\"+fileName+".txt";

			new PrepareDataSet().saveDataWithDom(dom, location);
		}
		
		/*for(int i=0;i<nonadUrls.size();i++){

			SearchDTO sDto = nonadUrls.get(i);

			String url = sDto.getUrl();

			String dom = new GetDOM().dom2String(url);
			
			String fileName = url.substring(url.lastIndexOf('?')+1);
			String location = "E:\\SWFServer\\train\\nonad\\"+fileName+".txt";

			new PrepareDataSet().saveDataWithDom(dom, location);

		}*/

	}
}
