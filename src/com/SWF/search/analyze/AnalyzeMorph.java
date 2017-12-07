package com.SWF.search.analyze;

import java.util.List;

import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.nlp.komoran.modeler.builder.ModelBuilder;
import kr.co.shineware.util.common.model.Pair;

public class AnalyzeMorph {

	public String analyze(String target) throws Exception{

		ModelBuilder builder = new ModelBuilder();
		
		builder.buildPath("E:/dev_searchFilter/workspace/SWF/src/corpus_build");
		builder.save("models");

		Komoran komoran = new Komoran("models");
		komoran.setUserDic("E:/dev_searchFilter/workspace/SWF/src/user_data/dic.user");
		String in = target;

		StringBuilder sb = new StringBuilder();

		List<List<Pair<String, String>>> analyzeResultList = komoran.analyze(in);
		for (List<Pair<String, String>> wordResultList : analyzeResultList) {
			for(int i=0;i<wordResultList.size();i++){

				Pair<String, String> pair = wordResultList.get(i);
				String HyeongTaeSo = pair.getSecond();

				if(HyeongTaeSo.contains("NNG")
						||HyeongTaeSo.contains("NNP")
						||HyeongTaeSo.contains("NNB")
						||HyeongTaeSo.contains("NR")
						||HyeongTaeSo.contains("NP")
						||HyeongTaeSo.contains("VV")
						||HyeongTaeSo.contains("VA")
						||HyeongTaeSo.contains("VX")
						||HyeongTaeSo.contains("VCP")
						||HyeongTaeSo.contains("VCN")
						||HyeongTaeSo.contains("MAG")
						||HyeongTaeSo.contains("MAJ")){

					sb.append(pair.getFirst());
					sb.append("/");
					sb.append(HyeongTaeSo);
					sb.append(" ");
				}
			}
		}
		String result = sb.toString();
		if(result.lastIndexOf(" ")>0){
			result = result.substring(0, result.lastIndexOf(" "));
		}
		return result;
	}

}
