package com.SWF.search.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.SWF.search.analyze.GetClassifier;
import com.SWF.search.analyze.GetUrlList;
import com.SWF.search.analyze.PrepareDataSet;
import com.SWF.search.dto.ResultDTO;
import com.SWF.search.dto.SearchDTO;
import com.SWF.user.dao.UserDAO;
import com.SWF.utils.FileCopy;

import cc.mallet.classify.Classifier;
import cc.mallet.types.Label;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Inject
	UserDAO uDao;
	
	public ResultDTO getSearchReuslt(int page, String keyword,String email) throws Exception{
		
		String trainPath ="E:\\SWFServer\\train";
		String tmpPath = "E:\\SWFServer\\tmp\\";
		
		List<SearchDTO> list = new ArrayList<SearchDTO>();
		
		if(keyword==null||keyword.length()==0){
			
			list = new GetUrlList().getUrlListPerPage(page,"");
			
		} else {
			
			keyword += " ";
			list = new GetUrlList().getUrlListPerPage(page,keyword);
		}
		new PrepareDataSet().saveData(list, tmpPath);
		
		ResultDTO rDto = new ResultDTO();
		
		Map<String, Object> result = new GetClassifier().getLearnedMachine(trainPath);
		Classifier classifier = (Classifier)result.get("classifier");
		
		File path = new File(tmpPath);

		File [] files = path.listFiles();
		Arrays.sort(files);
		
		for (int i = 0; i < files.length; i++){
			if (files[i].isFile()){ 
				
				Label label = classifier.classify(files[i]).getLabeling().getBestLabel();
			
				list.get(i).setLabel(label);
				String url = list.get(i).getUrl();
				
				String filename = trainPath+"\\"+label+"\\"+url.substring(url.lastIndexOf('?')+1)+".txt";
				new FileCopy().fileCopy(files[i].getPath(), filename);
			}
		}
		double modelAccuracy = (double)result.get("modelAccuracy");
		modelAccuracy = Math.round(modelAccuracy * 100) / 100d;

		rDto.setModelAccuracy(modelAccuracy);
		rDto.setLabeledResult(list);
		
		uDao.updatePointMinus(email, 2);
		
		return rDto;
	}
	
}
