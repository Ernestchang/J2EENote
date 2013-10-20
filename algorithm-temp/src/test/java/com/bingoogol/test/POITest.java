package com.bingoogol.test;

import java.io.FileInputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.junit.Test;

public class POITest {

	@Test
	public void testRead() throws Exception {
		FileInputStream fis = new FileInputStream("e:/test/1.doc");

		HWPFDocument hwpfd = new HWPFDocument(fis);

		WordExtractor wordExtractor = new WordExtractor(hwpfd);

		String[] paragraph = wordExtractor.getParagraphText();

		for (int i = 0; i < paragraph.length; i++) {

			System.out.println(paragraph[i]);

		}

	}
}
