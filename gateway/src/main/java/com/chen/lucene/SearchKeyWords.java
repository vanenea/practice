package com.chen.lucene;

import java.io.IOException;
import java.nio.file.FileSystems;

import org.apache.log4j.Logger;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.chen.service.IUserService;

public class SearchKeyWords {
	
	private static Logger logger = Logger.getLogger(SearchKeyWords.class);
	private static final String INDEX_PATH = "D:\\lucene-db";
	
	@Autowired
	private IUserService userService;
	/**
	 * 创建索引
	 */
	public void createIndex() {
		IndexWriter indexWriter = null;
		try {
			Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(INDEX_PATH));
			Analyzer analyzer = new IKAnalyzer(true);
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
			indexWriter = new IndexWriter(directory, indexWriterConfig);
			indexWriter.deleteAll();
			Document d = new Document();
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}finally {
			if(indexWriter!=null) {
				try {
					indexWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error(e.getMessage());
				}
			}
		}
	}
}
