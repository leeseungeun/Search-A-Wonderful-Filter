package com.SWF.search.analyze;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.SWF.utils.TxtFilter;

import cc.mallet.classify.Classifier;
import cc.mallet.classify.ClassifierTrainer;
import cc.mallet.classify.NaiveBayesTrainer;
import cc.mallet.classify.Trial;
import cc.mallet.pipe.CharSequence2TokenSequence;
import cc.mallet.pipe.FeatureSequence2FeatureVector;
import cc.mallet.pipe.Input2CharSequence;
import cc.mallet.pipe.Pipe;
import cc.mallet.pipe.SerialPipes;
import cc.mallet.pipe.Target2Label;
import cc.mallet.pipe.TokenSequence2FeatureSequence;
import cc.mallet.pipe.iterator.FileIterator;
import cc.mallet.types.InstanceList;
import cc.mallet.util.Randoms;

public class GetClassifier {

	public Map<String, Object> getLearnedMachine(String dataFolderPath){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();

		final int TRAININIG = 0;
		final int TESTING = 1;
		
		ArrayList<Pipe> pipeList = new ArrayList<Pipe>();
		pipeList.add(new Input2CharSequence("UTF-8"));
		Pattern tokenPattern = Pattern.compile("[\\p{L}\\p{N}_]+");
		pipeList.add(new CharSequence2TokenSequence(tokenPattern));
		pipeList.add(new TokenSequence2FeatureSequence());
		pipeList.add(new FeatureSequence2FeatureVector());
		pipeList.add(new Target2Label());
		SerialPipes pipeline = new SerialPipes(pipeList);

		FileIterator folderIterator = new FileIterator(
				new File[] {new File(dataFolderPath)},
				new TxtFilter(),
				FileIterator.LAST_DIRECTORY);


		InstanceList instances = new InstanceList(pipeline);

		instances.addThruPipe(folderIterator);

		InstanceList[] instanceList=instances.split(new Randoms(),
                new double[] {0.9, 0.1, 0.0});
		
		ClassifierTrainer classifierTrainer = new NaiveBayesTrainer();
		Classifier classifier = classifierTrainer.train(instanceList[TRAININIG]);
		Trial trial = new Trial(classifier, instanceList[TESTING]);
		
		resultMap.put("classifier", classifier);
		resultMap.put("modelAccuracy", trial.getAccuracy());

		return resultMap;
	}
}
